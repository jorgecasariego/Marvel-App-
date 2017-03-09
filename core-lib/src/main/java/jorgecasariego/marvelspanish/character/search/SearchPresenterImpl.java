package jorgecasariego.marvelspanish.character.search;


import java.sql.SQLException;

import javax.inject.Inject;

import jorgecasariego.marvelspanish.database.DatabaseHelper;
import jorgecasariego.marvelspanish.database.mapper.Mapper;
import jorgecasariego.marvelspanish.util.Constants;
import jorgecasariego.marvelspanish.util.SchedulerProvider;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.subscriptions.Subscriptions;

/**
 * Created by jorgecasariego on 6/3/17.
 */

class SearchPresenterImpl implements SearchPresenter {

    @Inject
    SearchInteractor interactor;
    @Inject
    DatabaseHelper databaseHelper;

    private SearchView view;
    private Subscription subscription = Subscriptions.empty();
    private SchedulerProvider scheduler;

    @Inject
    public SearchPresenterImpl(SchedulerProvider scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void bind(SearchView view) {
        this.view = view;
    }


    @Override
    public void doSearch(boolean isConnected, String query, long timestamp) {
        if (null != view) {
            view.showProgress();
        }

        /**
             There are four MAP operator applied to API response inside SearchPresenterImpl:

             - The 1st map, check if the response code from API is Okay, and if not an exception will
                    throw later. Make sure that you use ‘Exceptions.propagate’ method, otherwise you
                    have to handle the exception right there using try/catch statement!!

             - The 2nd map, check if is there any result for the character being searched, and if not
                    an exception will throw later…

             - The 3rd map, really map response model into database model using Mapper class.

             - and finally, the last map, insert response into database for further cache.
         */
        subscription = interactor.loadCharacter(query, Constants.PRIVATE_KEY, Constants.PUBLIC_KEY, timestamp)
                // check if result code is OK
                .map(charactersResponse -> {
                    if (Constants.CODE_OK == charactersResponse.getCode())
                        return charactersResponse;
                    else
                        throw Exceptions.propagate(new ApiResponseCodeException(charactersResponse.getCode(), charactersResponse.getStatus()));
                })
                // check if is there any result
                .map(charactersResponse -> {
                    if (charactersResponse.getData().getCount() > 0)
                        return charactersResponse;
                    else
                        throw Exceptions.propagate(new NoSuchCharacterException());
                })
                // map CharacterResponse to CharacterModel
                .map(Mapper::mapCharacterResponseToCharacter)
                // cache data on database
                .map(character -> {
                    try {
                        databaseHelper.addCharacter(character);
                    } catch (SQLException e) {
                        throw Exceptions.propagate(e);
                    }

                    return character;
                })
                .observeOn(scheduler.mainThread())
                .subscribe(character -> {
                            if (null != view) {
                                view.hideProgress();
                                view.showCharacter(character);

                                if (!isConnected)
                                    view.showOfflineMessage(false);
                            }
                        },
                        // handle exceptions
                        throwable -> {
                            if (null != view) {
                                view.hideProgress();

                                if (isConnected) {
                                    if (throwable instanceof ApiResponseCodeException)
                                        view.showServiceError((ApiResponseCodeException) throwable);
                                    else if (throwable instanceof NoSuchCharacterException)
                                        view.showQueryNoResult();
                                    else
                                        view.showRetryMessage(throwable);

                                } else {
                                    view.showOfflineMessage(true);
                                }
                            }
                        });
    }

    @Override
    public boolean isQueryValid(String query) {
        return null != query && !query.isEmpty();
    }

    @Override
    public void loadCharactersCachedData() {
        if (null != view)
            try {
                view.setCharactersCachedData(databaseHelper.selectAllCharacters());
            } catch (SQLException e) {
                view.showError(e);
            }
    }

    @Override
    public void unbind() {
        if (subscription != null && !subscription.isUnsubscribed())
            subscription.unsubscribe();

        interactor.unbind();

        view = null;
    }
}

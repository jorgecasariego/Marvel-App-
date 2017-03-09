package jorgecasariego.marvelspanish.character.search;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jorgecasariego on 6/3/17.
 */
@Module
public class SearchModule {

    @Provides
    @Search
    public SearchInteractor provideInteractor(SearchInteractorImpl interactor){
        return interactor;
    }

    @Provides
    @Search
    public SearchPresenter providePresenter(SearchPresenterImpl presenter){
        return presenter;
    }
}

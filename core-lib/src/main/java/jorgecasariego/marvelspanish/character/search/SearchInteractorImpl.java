package jorgecasariego.marvelspanish.character.search;

import javax.inject.Inject;

import jorgecasariego.marvelspanish.domain.client.MarvelApi;
import jorgecasariego.marvelspanish.domain.model.CharactersResponse;
import jorgecasariego.marvelspanish.util.HashGenerator;
import jorgecasariego.marvelspanish.util.SchedulerProvider;
import rx.Observable;
import rx.Subscription;
import rx.subjects.ReplaySubject;

/**
 * Created by jorgecasariego on 6/3/17.
 */
@Search
public class SearchInteractorImpl implements SearchInteractor {

    private MarvelApi api;
    private SchedulerProvider scheduler;

    private ReplaySubject<CharactersResponse> characterSubject;
    private Subscription characterSubscription;

    @Inject
    SearchInteractorImpl(MarvelApi api, SchedulerProvider scheduler){
        this.api = api;
        this.scheduler = scheduler;

    }

    @Override
    public Observable<CharactersResponse> loadCharacter(String query,
                                                        String privateKey,
                                                        String publicKey,
                                                        long timestamp) {
        if (characterSubscription == null || characterSubscription.isUnsubscribed()) {
            characterSubject = ReplaySubject.create();

            // generate hash using timestamp and API keys
            String hash = HashGenerator.generate(timestamp, privateKey, publicKey);

            /**
             *    all mapping things happen inside background thread, cause we specified it using
             *    subscribeOn inside SearchInteractorImpl class, and this is how it would never
             *    interrupt the MainThread to cause any lag or even ANRs.
             */
            characterSubscription = api.getCharacters(query, publicKey, hash, timestamp)
                    .subscribeOn(scheduler.backgroundThread())
                    .subscribe(characterSubject);
        }

        return characterSubject.asObservable();
    }

    @Override
    public void unbind() {
        if(characterSubscription != null && !characterSubscription.isUnsubscribed()){
            characterSubscription.unsubscribe();
        }
    }
}

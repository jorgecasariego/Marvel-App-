package jorgecasariego.marvelspanish.character.cache;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jorgecasariego on 6/3/17.
 */
@Module
public class CacheModule {

    @Provides
    @Cache
    public CachePresenter providePresenter(CachePresenterImpl presenter){
        return presenter;
    }
}

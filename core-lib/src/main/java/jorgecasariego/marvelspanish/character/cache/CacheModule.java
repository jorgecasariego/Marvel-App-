package jorgecasariego.marvelspanish.character.cache;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jorgecasariego on 6/3/17.
 *
 * This module is being used by CacheSubComponent
 *
 * Becasuse we are still inside core module and we have no idea about how it is gonna be used by View.
 *
 */
@Module
public class CacheModule {

    @Provides
    @Cache
    public CachePresenter providePresenter(CachePresenterImpl presenter){
        return presenter;
    }
}

package jorgecasariego.marvelspanish.character.cache;

import dagger.Subcomponent;

/**
 * Created by jorgecasariego on 7/3/17.
 *
 * CacheSubComponent is an ApplicationComponent's Subcomponent
 */
@Cache
@Subcomponent(modules = {
        CacheModule.class
})
public interface CacheSubComponent {

    void inject(CacheFragment fragment);
}

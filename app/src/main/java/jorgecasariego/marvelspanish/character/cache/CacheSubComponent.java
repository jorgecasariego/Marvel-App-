package jorgecasariego.marvelspanish.character.cache;

import dagger.Subcomponent;

/**
 * Created by jorgecasariego on 7/3/17.
 */
@Cache
@Subcomponent(modules = {
        CacheModule.class
})
public interface CacheSubComponent {

    void inject(CacheFragment fragment);
}

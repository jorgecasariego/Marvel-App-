package jorgecasariego.marvelspanish;

import javax.inject.Singleton;

import dagger.Component;
import jorgecasariego.marvelspanish.activity.CharacterActivity;
import jorgecasariego.marvelspanish.activity.MainActivity;
import jorgecasariego.marvelspanish.activity.SplashActivity;
import jorgecasariego.marvelspanish.character.cache.CacheModule;
import jorgecasariego.marvelspanish.character.cache.CacheSubComponent;
import jorgecasariego.marvelspanish.character.search.SearchModule;
import jorgecasariego.marvelspanish.character.search.SearchSubComponent;
import jorgecasariego.marvelspanish.database.DatabaseModule;
import jorgecasariego.marvelspanish.domain.ApiModule;
import jorgecasariego.marvelspanish.domain.ClientModule;

/**
 * Created by jorgecasariego on 7/3/17.
 */
@Singleton
@Component(modules = {
        AndroidModule.class,
        ApplicationModule.class,
        ApiModule.class,
        DatabaseModule.class,
        ClientModule.class
})
public interface ApplicationComponent {

    void inject(SplashActivity activity);

    void inject(MainActivity activity);

    void inject(CharacterActivity characterActivity);

    SearchSubComponent plus(SearchModule module);

    CacheSubComponent plus(CacheModule module);
}

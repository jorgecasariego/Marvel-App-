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
 *
 * From our ApplicationComponent we'll be able to create two subComponents: SearchSubComponent
 * and CacheSubComponent.
 *
 * As they are subcomponents of ApplicationComponent, both will have acces to isntances produced by
 * AndroidModule, ApplicationModule, ApiModule, DatabaseModule and ClientModule
 *
 * Here we can see that SearchSubComponent needs another module (which is passed as a parameter
 * of plus() method). Doing this we're extending ApplicationComponent graph by an additional
 * object produced by new Module
 *
 * Besides that ApplicationComponent uses AndroidModule and ApplicationModule to provide all
 * the Application injections.
 *
 *  - Inject methods helps with injection
 *  - First of all I have to mention that inject and plus is the name!! you can rename it to
 *    whatever you like and Dagger take care of input and output of the method to know what’s
 *    their use! but please don’t monkey around with the name cause your team member must read
 *    this code later
 *
 *  - using plus methods you can ask Dagger to add a SubComponent to the ApplicationComponent
 *    and do the inject method inside that SubComponent.
 *
 *  - plus methods take a Module and return a SubComponent using that module.
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

package jorgecasariego.marvelspanish;

import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jorgecasariego on 7/3/17.
 *
 * This module provide Application Context and Application Resources which always comes handy
 * for injection while developing for android to access for instance to Services or different Resources.
 *
 * This module would be created in MarvelApplication class which extends Application:
 *
 * public ApplicationComponent createComponent() {
 *      return DaggerApplicationComponent.builder()
 *          .androidModule(new AndroidModule(this))
 *          .build();
 * }
 *
 */
@Module
public class AndroidModule {
    private MarvelApplication application;

    public AndroidModule(MarvelApplication application){
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    Resources provideResources() {
        return application.getResources();
    }
}

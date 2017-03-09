package jorgecasariego.marvelspanish;

import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jorgecasariego on 7/3/17.
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

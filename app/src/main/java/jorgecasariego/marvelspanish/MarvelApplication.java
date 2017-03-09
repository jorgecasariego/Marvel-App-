package jorgecasariego.marvelspanish;

import android.app.Application;
import android.content.Context;

import jorgecasariego.marvelspanish.character.cache.CacheModule;
import jorgecasariego.marvelspanish.character.cache.CacheSubComponent;
import jorgecasariego.marvelspanish.character.search.SearchModule;
import jorgecasariego.marvelspanish.character.search.SearchSubComponent;

/**
 * Created by jorgecasariego on 7/3/17.
 */

public abstract class MarvelApplication extends Application {

    private static ApplicationComponent component;
    private CacheSubComponent cacheSubComponent;
    private SearchSubComponent searchSubComponent;

    public static  ApplicationComponent getComponent() {
        return component;
    }

    public static MarvelApplication get(Context context){
        return (MarvelApplication) context.getApplicationContext();
    }

    public CacheSubComponent getCacheSubComponent() {
        if (null == cacheSubComponent)
            createCacheSubComponent();

        return cacheSubComponent;
    }

    public CacheSubComponent createCacheSubComponent() {
        cacheSubComponent = component.plus(new CacheModule());
        return cacheSubComponent;
    }

    public void releaseCacheSubComponent() {
        cacheSubComponent = null;
    }

    public SearchSubComponent getSearchSubComponent() {
        if (null == searchSubComponent)
            createSearchSubComponent();

        return searchSubComponent;
    }

    public SearchSubComponent createSearchSubComponent() {
        searchSubComponent = component.plus(new SearchModule());
        return searchSubComponent;
    }

    public void releaseSearchSubComponent() {
        searchSubComponent = null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initApplication();

        component = createComponent();
    }

    public ApplicationComponent createComponent() {
        return DaggerApplicationComponent.builder()
                .androidModule(new AndroidModule(this))
                .build();
    }

    public abstract void initApplication();
}

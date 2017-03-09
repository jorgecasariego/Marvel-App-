package jorgecasariego.marvelspanish;

import android.content.Context;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.mirhoseini.utils.Utils;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jorgecasariego.marvelspanish.util.AppConstants;
import jorgecasariego.marvelspanish.util.AppSchedulerProvider;
import jorgecasariego.marvelspanish.util.Constants;
import jorgecasariego.marvelspanish.util.SchedulerProvider;
import jorgecasariego.marvelspanish.util.StateManager;
import jorgecasariego.marvelspanish.util.StateManagerImpl;
import okhttp3.HttpUrl;

/**
 * Created by jorgecasariego on 7/3/17.
 *
 * Almost all application requirements are being provided in this module:
 *  - isDebug: use BuildConfig.DEBUG boolean variable to check if the running instance of
 *             application is in debug mode and use it for logging network API calls in logcat.
 *
 *  - networkTimeoutInSeconds, cacheSize, cacheMaxAge, cacheMaxStale, cacheDir:
 *              provide network parameters which being used when creating the OkHttp client for Retrofit.
 *
 *  - endpoint: provide the API’s endpoint for retrofit.
 *
 *  - appScheduler: provide RxAndroid schedulers
 *
 *  - isConnect: provide network state for handling offline situations.
 */
@Module
public class ApplicationModule {

    @Provides
    @Singleton
    @Named("isDebug")
    boolean provideIsDebug() {
        return BuildConfig.DEBUG;
    }

    @Provides
    @Singleton
    @Named("networkTimeoutInSeconds")
    int provideNetworkTimeoutInSeconds() {
        return AppConstants.NETWORK_CONNECTION_TIMEOUT;
    }

    @Provides
    @Singleton
    HttpUrl provideEndpoint() {
        return HttpUrl.parse(Constants.BASE_URL);
    }

    @Provides
    @Singleton
    SchedulerProvider provideAppScheduler() {
        return new AppSchedulerProvider();
    }

    @Provides
    @Singleton
    @Named("cacheSize")
    long provideCacheSize() {
        return AppConstants.CACHE_SIZE;
    }

    @Provides
    @Singleton
    @Named("cacheMaxAge")
    int provideCacheMaxAgeMinutes() {
        return AppConstants.CACHE_MAX_AGE;
    }

    @Provides
    @Singleton
    @Named("cacheMaxStale")
    int provideCacheMaxStaleDays() {
        return AppConstants.CACHE_MAX_STALE;
    }

    @Provides
    @Singleton
    @Named("retryCount")
    public int provideApiRetryCount() {
        return AppConstants.API_RETRY_COUNT;
    }

    @Provides
    @Singleton
    @Named("cacheDir")
    File provideCacheDir(Context context) {
        return context.getCacheDir();
    }

    @Provides
    @Named("isConnect")
    boolean provideIsConnect(Context context) {
        return Utils.isConnected(context);
    }

    @Provides
    FirebaseAnalytics provideFirebaseAnalytics(Context context) {
        return FirebaseAnalytics.getInstance(context);
    }

    @Provides
    @Singleton
    public StateManager provideStateManager(StateManagerImpl stateManager) {
        return stateManager;
    }
}

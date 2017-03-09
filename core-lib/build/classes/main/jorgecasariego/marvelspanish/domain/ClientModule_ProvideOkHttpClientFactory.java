package jorgecasariego.marvelspanish.domain;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClientModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
  private final ClientModule module;

  private final Provider<HttpLoggingInterceptor> loggingInterceptorProvider;

  private final Provider<Integer> networkTimeoutInSecondsProvider;

  private final Provider<Boolean> isDebugProvider;

  private final Provider<Cache> cacheProvider;

  private final Provider<Interceptor> cacheInterceptorProvider;

  private final Provider<Interceptor> offlineCacheInterceptorProvider;

  private final Provider<Interceptor> retryInterceptorProvider;

  public ClientModule_ProvideOkHttpClientFactory(
      ClientModule module,
      Provider<HttpLoggingInterceptor> loggingInterceptorProvider,
      Provider<Integer> networkTimeoutInSecondsProvider,
      Provider<Boolean> isDebugProvider,
      Provider<Cache> cacheProvider,
      Provider<Interceptor> cacheInterceptorProvider,
      Provider<Interceptor> offlineCacheInterceptorProvider,
      Provider<Interceptor> retryInterceptorProvider) {
    assert module != null;
    this.module = module;
    assert loggingInterceptorProvider != null;
    this.loggingInterceptorProvider = loggingInterceptorProvider;
    assert networkTimeoutInSecondsProvider != null;
    this.networkTimeoutInSecondsProvider = networkTimeoutInSecondsProvider;
    assert isDebugProvider != null;
    this.isDebugProvider = isDebugProvider;
    assert cacheProvider != null;
    this.cacheProvider = cacheProvider;
    assert cacheInterceptorProvider != null;
    this.cacheInterceptorProvider = cacheInterceptorProvider;
    assert offlineCacheInterceptorProvider != null;
    this.offlineCacheInterceptorProvider = offlineCacheInterceptorProvider;
    assert retryInterceptorProvider != null;
    this.retryInterceptorProvider = retryInterceptorProvider;
  }

  @Override
  public OkHttpClient get() {
    return Preconditions.checkNotNull(
        module.provideOkHttpClient(
            loggingInterceptorProvider.get(),
            networkTimeoutInSecondsProvider.get(),
            isDebugProvider.get(),
            cacheProvider.get(),
            cacheInterceptorProvider.get(),
            offlineCacheInterceptorProvider.get(),
            retryInterceptorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<OkHttpClient> create(
      ClientModule module,
      Provider<HttpLoggingInterceptor> loggingInterceptorProvider,
      Provider<Integer> networkTimeoutInSecondsProvider,
      Provider<Boolean> isDebugProvider,
      Provider<Cache> cacheProvider,
      Provider<Interceptor> cacheInterceptorProvider,
      Provider<Interceptor> offlineCacheInterceptorProvider,
      Provider<Interceptor> retryInterceptorProvider) {
    return new ClientModule_ProvideOkHttpClientFactory(
        module,
        loggingInterceptorProvider,
        networkTimeoutInSecondsProvider,
        isDebugProvider,
        cacheProvider,
        cacheInterceptorProvider,
        offlineCacheInterceptorProvider,
        retryInterceptorProvider);
  }
}

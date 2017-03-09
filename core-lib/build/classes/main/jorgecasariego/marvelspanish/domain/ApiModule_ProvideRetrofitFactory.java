package jorgecasariego.marvelspanish.domain;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final ApiModule module;

  private final Provider<HttpUrl> baseUrlProvider;

  private final Provider<Converter.Factory> converterFactoryProvider;

  private final Provider<CallAdapter.Factory> callAdapterFactoryProvider;

  private final Provider<OkHttpClient> okHttpClientProvider;

  public ApiModule_ProvideRetrofitFactory(
      ApiModule module,
      Provider<HttpUrl> baseUrlProvider,
      Provider<Converter.Factory> converterFactoryProvider,
      Provider<CallAdapter.Factory> callAdapterFactoryProvider,
      Provider<OkHttpClient> okHttpClientProvider) {
    assert module != null;
    this.module = module;
    assert baseUrlProvider != null;
    this.baseUrlProvider = baseUrlProvider;
    assert converterFactoryProvider != null;
    this.converterFactoryProvider = converterFactoryProvider;
    assert callAdapterFactoryProvider != null;
    this.callAdapterFactoryProvider = callAdapterFactoryProvider;
    assert okHttpClientProvider != null;
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public Retrofit get() {
    return Preconditions.checkNotNull(
        module.provideRetrofit(
            baseUrlProvider.get(),
            converterFactoryProvider.get(),
            callAdapterFactoryProvider.get(),
            okHttpClientProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Retrofit> create(
      ApiModule module,
      Provider<HttpUrl> baseUrlProvider,
      Provider<Converter.Factory> converterFactoryProvider,
      Provider<CallAdapter.Factory> callAdapterFactoryProvider,
      Provider<OkHttpClient> okHttpClientProvider) {
    return new ApiModule_ProvideRetrofitFactory(
        module,
        baseUrlProvider,
        converterFactoryProvider,
        callAdapterFactoryProvider,
        okHttpClientProvider);
  }
}

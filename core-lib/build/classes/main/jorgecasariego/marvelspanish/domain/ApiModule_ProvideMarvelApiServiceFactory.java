package jorgecasariego.marvelspanish.domain;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import jorgecasariego.marvelspanish.domain.client.MarvelApi;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvideMarvelApiServiceFactory implements Factory<MarvelApi> {
  private final ApiModule module;

  private final Provider<Retrofit> retrofitProvider;

  public ApiModule_ProvideMarvelApiServiceFactory(
      ApiModule module, Provider<Retrofit> retrofitProvider) {
    assert module != null;
    this.module = module;
    assert retrofitProvider != null;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public MarvelApi get() {
    return Preconditions.checkNotNull(
        module.provideMarvelApiService(retrofitProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MarvelApi> create(ApiModule module, Provider<Retrofit> retrofitProvider) {
    return new ApiModule_ProvideMarvelApiServiceFactory(module, retrofitProvider);
  }
}

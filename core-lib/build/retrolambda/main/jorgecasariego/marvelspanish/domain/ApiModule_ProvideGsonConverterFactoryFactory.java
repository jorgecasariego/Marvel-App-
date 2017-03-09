package jorgecasariego.marvelspanish.domain;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Converter;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvideGsonConverterFactoryFactory
    implements Factory<Converter.Factory> {
  private final ApiModule module;

  private final Provider<Gson> gsonProvider;

  public ApiModule_ProvideGsonConverterFactoryFactory(
      ApiModule module, Provider<Gson> gsonProvider) {
    assert module != null;
    this.module = module;
    assert gsonProvider != null;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public Converter.Factory get() {
    return Preconditions.checkNotNull(
        module.provideGsonConverterFactory(gsonProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Converter.Factory> create(ApiModule module, Provider<Gson> gsonProvider) {
    return new ApiModule_ProvideGsonConverterFactoryFactory(module, gsonProvider);
  }
}

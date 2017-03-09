package jorgecasariego.marvelspanish.domain;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import retrofit2.CallAdapter;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvideRxJavaCallAdapterFactoryFactory
    implements Factory<CallAdapter.Factory> {
  private final ApiModule module;

  public ApiModule_ProvideRxJavaCallAdapterFactoryFactory(ApiModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public CallAdapter.Factory get() {
    return Preconditions.checkNotNull(
        module.provideRxJavaCallAdapterFactory(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<CallAdapter.Factory> create(ApiModule module) {
    return new ApiModule_ProvideRxJavaCallAdapterFactoryFactory(module);
  }
}

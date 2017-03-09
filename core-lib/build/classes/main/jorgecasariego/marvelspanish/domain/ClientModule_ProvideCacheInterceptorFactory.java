package jorgecasariego.marvelspanish.domain;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Interceptor;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClientModule_ProvideCacheInterceptorFactory implements Factory<Interceptor> {
  private final ClientModule module;

  private final Provider<Integer> maxAgeMinProvider;

  public ClientModule_ProvideCacheInterceptorFactory(
      ClientModule module, Provider<Integer> maxAgeMinProvider) {
    assert module != null;
    this.module = module;
    assert maxAgeMinProvider != null;
    this.maxAgeMinProvider = maxAgeMinProvider;
  }

  @Override
  public Interceptor get() {
    return Preconditions.checkNotNull(
        module.provideCacheInterceptor(maxAgeMinProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Interceptor> create(
      ClientModule module, Provider<Integer> maxAgeMinProvider) {
    return new ClientModule_ProvideCacheInterceptorFactory(module, maxAgeMinProvider);
  }
}

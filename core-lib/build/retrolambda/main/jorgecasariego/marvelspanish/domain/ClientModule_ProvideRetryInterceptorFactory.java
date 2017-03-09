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
public final class ClientModule_ProvideRetryInterceptorFactory implements Factory<Interceptor> {
  private final ClientModule module;

  private final Provider<Integer> retryCountProvider;

  public ClientModule_ProvideRetryInterceptorFactory(
      ClientModule module, Provider<Integer> retryCountProvider) {
    assert module != null;
    this.module = module;
    assert retryCountProvider != null;
    this.retryCountProvider = retryCountProvider;
  }

  @Override
  public Interceptor get() {
    return Preconditions.checkNotNull(
        module.provideRetryInterceptor(retryCountProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Interceptor> create(
      ClientModule module, Provider<Integer> retryCountProvider) {
    return new ClientModule_ProvideRetryInterceptorFactory(module, retryCountProvider);
  }
}

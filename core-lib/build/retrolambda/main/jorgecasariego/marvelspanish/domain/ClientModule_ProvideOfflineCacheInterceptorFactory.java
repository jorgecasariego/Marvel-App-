package jorgecasariego.marvelspanish.domain;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import jorgecasariego.marvelspanish.util.StateManager;
import okhttp3.Interceptor;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClientModule_ProvideOfflineCacheInterceptorFactory
    implements Factory<Interceptor> {
  private final ClientModule module;

  private final Provider<StateManager> stateManagerProvider;

  private final Provider<Integer> maxStaleDayProvider;

  public ClientModule_ProvideOfflineCacheInterceptorFactory(
      ClientModule module,
      Provider<StateManager> stateManagerProvider,
      Provider<Integer> maxStaleDayProvider) {
    assert module != null;
    this.module = module;
    assert stateManagerProvider != null;
    this.stateManagerProvider = stateManagerProvider;
    assert maxStaleDayProvider != null;
    this.maxStaleDayProvider = maxStaleDayProvider;
  }

  @Override
  public Interceptor get() {
    return Preconditions.checkNotNull(
        module.provideOfflineCacheInterceptor(
            stateManagerProvider.get(), maxStaleDayProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Interceptor> create(
      ClientModule module,
      Provider<StateManager> stateManagerProvider,
      Provider<Integer> maxStaleDayProvider) {
    return new ClientModule_ProvideOfflineCacheInterceptorFactory(
        module, stateManagerProvider, maxStaleDayProvider);
  }
}

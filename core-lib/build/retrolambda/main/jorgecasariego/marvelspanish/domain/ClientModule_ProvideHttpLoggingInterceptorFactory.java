package jorgecasariego.marvelspanish.domain;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.logging.HttpLoggingInterceptor;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClientModule_ProvideHttpLoggingInterceptorFactory
    implements Factory<HttpLoggingInterceptor> {
  private final ClientModule module;

  public ClientModule_ProvideHttpLoggingInterceptorFactory(ClientModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public HttpLoggingInterceptor get() {
    return Preconditions.checkNotNull(
        module.provideHttpLoggingInterceptor(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<HttpLoggingInterceptor> create(ClientModule module) {
    return new ClientModule_ProvideHttpLoggingInterceptorFactory(module);
  }
}

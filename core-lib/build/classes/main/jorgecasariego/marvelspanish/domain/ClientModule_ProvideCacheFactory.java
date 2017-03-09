package jorgecasariego.marvelspanish.domain;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.io.File;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Cache;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClientModule_ProvideCacheFactory implements Factory<Cache> {
  private final ClientModule module;

  private final Provider<File> cacheDirProvider;

  private final Provider<Long> cacheSizeProvider;

  public ClientModule_ProvideCacheFactory(
      ClientModule module, Provider<File> cacheDirProvider, Provider<Long> cacheSizeProvider) {
    assert module != null;
    this.module = module;
    assert cacheDirProvider != null;
    this.cacheDirProvider = cacheDirProvider;
    assert cacheSizeProvider != null;
    this.cacheSizeProvider = cacheSizeProvider;
  }

  @Override
  public Cache get() {
    return Preconditions.checkNotNull(
        module.provideCache(cacheDirProvider.get(), cacheSizeProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Cache> create(
      ClientModule module, Provider<File> cacheDirProvider, Provider<Long> cacheSizeProvider) {
    return new ClientModule_ProvideCacheFactory(module, cacheDirProvider, cacheSizeProvider);
  }
}

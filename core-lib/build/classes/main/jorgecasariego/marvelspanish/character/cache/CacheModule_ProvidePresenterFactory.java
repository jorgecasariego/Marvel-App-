package jorgecasariego.marvelspanish.character.cache;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CacheModule_ProvidePresenterFactory implements Factory<CachePresenter> {
  private final CacheModule module;

  private final Provider<CachePresenterImpl> presenterProvider;

  public CacheModule_ProvidePresenterFactory(
      CacheModule module, Provider<CachePresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public CachePresenter get() {
    return Preconditions.checkNotNull(
        module.providePresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<CachePresenter> create(
      CacheModule module, Provider<CachePresenterImpl> presenterProvider) {
    return new CacheModule_ProvidePresenterFactory(module, presenterProvider);
  }
}

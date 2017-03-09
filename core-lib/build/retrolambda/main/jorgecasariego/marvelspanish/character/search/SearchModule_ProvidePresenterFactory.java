package jorgecasariego.marvelspanish.character.search;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SearchModule_ProvidePresenterFactory implements Factory<SearchPresenter> {
  private final SearchModule module;

  private final Provider<SearchPresenterImpl> presenterProvider;

  public SearchModule_ProvidePresenterFactory(
      SearchModule module, Provider<SearchPresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public SearchPresenter get() {
    return Preconditions.checkNotNull(
        module.providePresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SearchPresenter> create(
      SearchModule module, Provider<SearchPresenterImpl> presenterProvider) {
    return new SearchModule_ProvidePresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link SearchModule#providePresenter(SearchPresenterImpl)}. */
  public static SearchPresenter proxyProvidePresenter(SearchModule instance, Object presenter) {
    return instance.providePresenter((SearchPresenterImpl) presenter);
  }
}

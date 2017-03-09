package jorgecasariego.marvelspanish.character.search;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SearchModule_ProvideInteractorFactory implements Factory<SearchInteractor> {
  private final SearchModule module;

  private final Provider<SearchInteractorImpl> interactorProvider;

  public SearchModule_ProvideInteractorFactory(
      SearchModule module, Provider<SearchInteractorImpl> interactorProvider) {
    assert module != null;
    this.module = module;
    assert interactorProvider != null;
    this.interactorProvider = interactorProvider;
  }

  @Override
  public SearchInteractor get() {
    return Preconditions.checkNotNull(
        module.provideInteractor(interactorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SearchInteractor> create(
      SearchModule module, Provider<SearchInteractorImpl> interactorProvider) {
    return new SearchModule_ProvideInteractorFactory(module, interactorProvider);
  }
}

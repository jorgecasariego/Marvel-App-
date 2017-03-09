package jorgecasariego.marvelspanish.character.search;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import jorgecasariego.marvelspanish.database.DatabaseHelper;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SearchPresenterImpl_MembersInjector
    implements MembersInjector<SearchPresenterImpl> {
  private final Provider<SearchInteractor> interactorProvider;

  private final Provider<DatabaseHelper> databaseHelperProvider;

  public SearchPresenterImpl_MembersInjector(
      Provider<SearchInteractor> interactorProvider,
      Provider<DatabaseHelper> databaseHelperProvider) {
    assert interactorProvider != null;
    this.interactorProvider = interactorProvider;
    assert databaseHelperProvider != null;
    this.databaseHelperProvider = databaseHelperProvider;
  }

  public static MembersInjector<SearchPresenterImpl> create(
      Provider<SearchInteractor> interactorProvider,
      Provider<DatabaseHelper> databaseHelperProvider) {
    return new SearchPresenterImpl_MembersInjector(interactorProvider, databaseHelperProvider);
  }

  @Override
  public void injectMembers(SearchPresenterImpl instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.interactor = interactorProvider.get();
    instance.databaseHelper = databaseHelperProvider.get();
  }

  public static void injectInteractor(
      SearchPresenterImpl instance, Provider<SearchInteractor> interactorProvider) {
    instance.interactor = interactorProvider.get();
  }

  public static void injectDatabaseHelper(
      SearchPresenterImpl instance, Provider<DatabaseHelper> databaseHelperProvider) {
    instance.databaseHelper = databaseHelperProvider.get();
  }
}

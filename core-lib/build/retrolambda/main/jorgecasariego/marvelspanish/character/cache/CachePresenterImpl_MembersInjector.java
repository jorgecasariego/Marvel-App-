package jorgecasariego.marvelspanish.character.cache;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import jorgecasariego.marvelspanish.database.DatabaseHelper;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CachePresenterImpl_MembersInjector
    implements MembersInjector<CachePresenterImpl> {
  private final Provider<DatabaseHelper> databaseHelperProvider;

  public CachePresenterImpl_MembersInjector(Provider<DatabaseHelper> databaseHelperProvider) {
    assert databaseHelperProvider != null;
    this.databaseHelperProvider = databaseHelperProvider;
  }

  public static MembersInjector<CachePresenterImpl> create(
      Provider<DatabaseHelper> databaseHelperProvider) {
    return new CachePresenterImpl_MembersInjector(databaseHelperProvider);
  }

  @Override
  public void injectMembers(CachePresenterImpl instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.databaseHelper = databaseHelperProvider.get();
  }

  public static void injectDatabaseHelper(
      CachePresenterImpl instance, Provider<DatabaseHelper> databaseHelperProvider) {
    instance.databaseHelper = databaseHelperProvider.get();
  }
}

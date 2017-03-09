package jorgecasariego.marvelspanish.character.cache;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CachePresenterImpl_Factory implements Factory<CachePresenterImpl> {
  private final MembersInjector<CachePresenterImpl> cachePresenterImplMembersInjector;

  public CachePresenterImpl_Factory(
      MembersInjector<CachePresenterImpl> cachePresenterImplMembersInjector) {
    assert cachePresenterImplMembersInjector != null;
    this.cachePresenterImplMembersInjector = cachePresenterImplMembersInjector;
  }

  @Override
  public CachePresenterImpl get() {
    return MembersInjectors.injectMembers(
        cachePresenterImplMembersInjector, new CachePresenterImpl());
  }

  public static Factory<CachePresenterImpl> create(
      MembersInjector<CachePresenterImpl> cachePresenterImplMembersInjector) {
    return new CachePresenterImpl_Factory(cachePresenterImplMembersInjector);
  }
}

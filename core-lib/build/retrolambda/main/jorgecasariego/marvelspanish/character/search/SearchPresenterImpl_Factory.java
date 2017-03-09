package jorgecasariego.marvelspanish.character.search;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;
import jorgecasariego.marvelspanish.util.SchedulerProvider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SearchPresenterImpl_Factory implements Factory<SearchPresenterImpl> {
  private final MembersInjector<SearchPresenterImpl> searchPresenterImplMembersInjector;

  private final Provider<SchedulerProvider> schedulerProvider;

  public SearchPresenterImpl_Factory(
      MembersInjector<SearchPresenterImpl> searchPresenterImplMembersInjector,
      Provider<SchedulerProvider> schedulerProvider) {
    assert searchPresenterImplMembersInjector != null;
    this.searchPresenterImplMembersInjector = searchPresenterImplMembersInjector;
    assert schedulerProvider != null;
    this.schedulerProvider = schedulerProvider;
  }

  @Override
  public SearchPresenterImpl get() {
    return MembersInjectors.injectMembers(
        searchPresenterImplMembersInjector, new SearchPresenterImpl(schedulerProvider.get()));
  }

  public static Factory<SearchPresenterImpl> create(
      MembersInjector<SearchPresenterImpl> searchPresenterImplMembersInjector,
      Provider<SchedulerProvider> schedulerProvider) {
    return new SearchPresenterImpl_Factory(searchPresenterImplMembersInjector, schedulerProvider);
  }
}

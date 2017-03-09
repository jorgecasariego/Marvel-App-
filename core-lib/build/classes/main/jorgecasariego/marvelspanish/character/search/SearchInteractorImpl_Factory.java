package jorgecasariego.marvelspanish.character.search;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import jorgecasariego.marvelspanish.domain.client.MarvelApi;
import jorgecasariego.marvelspanish.util.SchedulerProvider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SearchInteractorImpl_Factory implements Factory<SearchInteractorImpl> {
  private final Provider<MarvelApi> apiProvider;

  private final Provider<SchedulerProvider> schedulerProvider;

  public SearchInteractorImpl_Factory(
      Provider<MarvelApi> apiProvider, Provider<SchedulerProvider> schedulerProvider) {
    assert apiProvider != null;
    this.apiProvider = apiProvider;
    assert schedulerProvider != null;
    this.schedulerProvider = schedulerProvider;
  }

  @Override
  public SearchInteractorImpl get() {
    return new SearchInteractorImpl(apiProvider.get(), schedulerProvider.get());
  }

  public static Factory<SearchInteractorImpl> create(
      Provider<MarvelApi> apiProvider, Provider<SchedulerProvider> schedulerProvider) {
    return new SearchInteractorImpl_Factory(apiProvider, schedulerProvider);
  }

  /** Proxies {@link SearchInteractorImpl#SearchInteractorImpl(MarvelApi, SchedulerProvider)}. */
  public static SearchInteractorImpl newSearchInteractorImpl(
      MarvelApi api, SchedulerProvider scheduler) {
    return new SearchInteractorImpl(api, scheduler);
  }
}

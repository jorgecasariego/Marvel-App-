package jorgecasariego.marvelspanish.character.search;

import jorgecasariego.marvelspanish.base.BasePresenter;

/**
 * Created by jorgecasariego on 6/3/17.
 */

interface SearchPresenter extends BasePresenter<SearchView> {

    void doSearch(boolean isConnected, String query, long timestamp);

    boolean isQueryValid(String query);

    void loadCharactersCachedData();
}

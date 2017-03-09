package jorgecasariego.marvelspanish.character.cache;

import jorgecasariego.marvelspanish.base.BasePresenter;

/**
 * Created by jorgecasariego on 6/3/17.
 */

interface CachePresenter extends BasePresenter<CacheView>{

    void loadLast5CharactersCachedData();
}

package jorgecasariego.marvelspanish.character.cache;

import java.util.List;

import jorgecasariego.marvelspanish.base.BaseView;
import jorgecasariego.marvelspanish.database.model.CharacterModel;

/**
 * Created by jorgecasariego on 6/3/17.
 */

interface CacheView extends BaseView {

    void setLast5CharactersCachedData(List<CharacterModel> characterModels);

    void showError(Throwable throwable);
}

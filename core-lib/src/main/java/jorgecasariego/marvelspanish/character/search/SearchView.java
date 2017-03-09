package jorgecasariego.marvelspanish.character.search;

import java.util.List;

import jorgecasariego.marvelspanish.base.BaseView;
import jorgecasariego.marvelspanish.database.model.CharacterModel;

/**
 * Created by jorgecasariego on 6/3/17.
 */

interface SearchView extends BaseView {

    void showQueryError(Throwable throwable);

    void showCharacter(CharacterModel character);

    void showRetryMessage(Throwable throwable);

    void showQueryNoResult();

    void setCharactersCachedData(List<CharacterModel> characters);

    void showError(Throwable throwable);

    void showProgress();

    void hideProgress();

    void showServiceError(ApiResponseCodeException throwable);
}

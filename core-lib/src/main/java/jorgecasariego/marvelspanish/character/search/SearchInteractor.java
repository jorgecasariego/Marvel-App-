package jorgecasariego.marvelspanish.character.search;

import jorgecasariego.marvelspanish.base.BaseInteractor;
import jorgecasariego.marvelspanish.domain.model.CharactersResponse;
import rx.Observable;

/**
 * Created by jorgecasariego on 6/3/17.
 */

interface SearchInteractor extends BaseInteractor {

    Observable<CharactersResponse> loadCharacter(String query, String privateKey, String publicKey, long timestamp);

}

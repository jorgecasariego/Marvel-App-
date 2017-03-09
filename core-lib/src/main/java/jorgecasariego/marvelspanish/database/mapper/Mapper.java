package jorgecasariego.marvelspanish.database.mapper;

import jorgecasariego.marvelspanish.database.model.CharacterModel;
import jorgecasariego.marvelspanish.domain.model.CharactersResponse;
import jorgecasariego.marvelspanish.util.Constants;

/**
 * Created by jorgecasariego on 7/3/17.
 */

public class Mapper {

    public static CharacterModel mapCharacterResponseToCharacter(CharactersResponse charactersResponse){
        CharacterModel character = new CharacterModel();

        character.setName(charactersResponse.getData().getResults()[0].getName());
        character.setDescription(charactersResponse.getData().getResults()[0].getDescription());
        character.setThumbnail(String.format("%s/%s.%s",
                charactersResponse.getData().getResults()[0].getThumbnail().getPath(),
                Constants.STANDARD_XLARGE,
                charactersResponse.getData().getResults()[0].getThumbnail().getExtension()));
        character.setImage(String.format("%s/%s.%s",
                charactersResponse.getData().getResults()[0].getThumbnail().getPath(),
                Constants.PORTRAIT_XLARGE,
                charactersResponse.getData().getResults()[0].getThumbnail().getExtension()));

        return character;
    }
}

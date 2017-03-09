package jorgecasariego.marvelspanish.database;

import java.sql.SQLException;
import java.util.List;

import jorgecasariego.marvelspanish.database.model.CharacterModel;

/**
 * Created by jorgecasariego on 7/3/17.
 */

public interface DatabaseHelper {
    int addCharacter(CharacterModel character) throws SQLException;

    List<CharacterModel> selectLast5Characters() throws SQLException;

    List<CharacterModel> selectAllCharacters() throws SQLException;

}

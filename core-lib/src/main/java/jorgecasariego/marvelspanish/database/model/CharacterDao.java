package jorgecasariego.marvelspanish.database.model;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by jorgecasariego on 7/3/17.
 */

public class CharacterDao extends BaseDaoImpl<CharacterModel, Integer> {
    protected CharacterDao(Class<CharacterModel> dataClass) throws SQLException {
        super(dataClass);
    }

    protected CharacterDao(ConnectionSource connectionSource, Class<CharacterModel> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    protected CharacterDao(ConnectionSource connectionSource, DatabaseTableConfig<CharacterModel> tableConfig) throws SQLException {
        super(connectionSource, tableConfig);
    }

    public List<CharacterModel> getCharacters() throws SQLException {
        return queryForAll();
    }
}

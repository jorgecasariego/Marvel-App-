package jorgecasariego.marvelspanish.character.cache;

import java.sql.SQLException;

import javax.inject.Inject;

import jorgecasariego.marvelspanish.database.DatabaseHelper;

/**
 * Created by jorgecasariego on 6/3/17.
 */

public class CachePresenterImpl implements CachePresenter {

    @Inject
    DatabaseHelper databaseHelper;

    private  CacheView view;

    @Inject
    public CachePresenterImpl(){

    }

    @Override
    public void loadLast5CharactersCachedData() {
        if(null != view){
            try{
                view.setLast5CharactersCachedData(databaseHelper.selectLast5Characters());
            } catch (SQLException e){
                view.showError(e);
            }
        }
    }

    @Override
    public void bind(CacheView view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        view = null;
    }
}

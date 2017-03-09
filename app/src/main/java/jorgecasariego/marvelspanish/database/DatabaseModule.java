package jorgecasariego.marvelspanish.database;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jorgecasariego on 7/3/17.
 */
@Module
public class DatabaseModule {

    @Provides
    @Singleton
    DatabaseHelper provideDatabaseHelperService(DatabaseHelperImpl databaseHelper) {
        return databaseHelper;
    }
}

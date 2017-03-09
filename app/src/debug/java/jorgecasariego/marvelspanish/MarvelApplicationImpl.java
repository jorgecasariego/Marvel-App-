package jorgecasariego.marvelspanish;

import timber.log.Timber;

/**
 * Created by jorgecasariego on 8/3/17.
 */

public class MarvelApplicationImpl extends MarvelApplication {
    @Override
    public void initApplication() {

        //initialize Timber in debug version to log
        Timber.plant(new Timber.DebugTree() {
            @Override
            protected String createStackElementTag(StackTraceElement element) {
                // adding line number to logs
                return super.createStackElementTag(element) + ":" + element.getLineNumber();
            }
        });
    }
}

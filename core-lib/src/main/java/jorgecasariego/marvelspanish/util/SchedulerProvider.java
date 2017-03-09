package jorgecasariego.marvelspanish.util;

import rx.Scheduler;

/**
 * Created by jorgecasariego on 7/3/17.
 */

public interface SchedulerProvider {
    Scheduler mainThread();

    Scheduler backgroundThread();
}

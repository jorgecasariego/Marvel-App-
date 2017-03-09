package jorgecasariego.marvelspanish.util;

import javax.inject.Inject;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jorgecasariego on 7/3/17.
 *
 * Schedulers in RxJava are threads in java.
 *
 * To make ththe connection between core and app modules possible, app module implements
 * SchedulerProvider interface from core within AppSchedulerProvider class which has both methods
 * (mainThread/backgroundThread) implemented
 */

public class AppSchedulerProvider implements SchedulerProvider {

    @Inject
    public AppSchedulerProvider() {
    }

    @Override
    public Scheduler mainThread() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler backgroundThread() {
        return Schedulers.io();
    }
}

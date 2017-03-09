package jorgecasariego.marvelspanish.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import javax.inject.Inject;

import butterknife.ButterKnife;
import jorgecasariego.marvelspanish.ApplicationComponent;
import jorgecasariego.marvelspanish.MarvelApplication;
import jorgecasariego.marvelspanish.R;
import jorgecasariego.marvelspanish.base.BaseActivity;
import jorgecasariego.marvelspanish.util.AppConstants;
import timber.log.Timber;

public class SplashActivity extends BaseActivity {

    // injecting dependencies via Dagger
    @Inject
    Context context;

    // Thread to process splash screen events
    private Thread splashThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);

        // The thread to wait for splash screen events
        splashThread = new Thread() {
            @Override
            public void run() {

                try {
                    synchronized (this) {
                        // Wait given period of time or exit on touch
                        wait(AppConstants.SPLASH_TIMEOUT_SEC);
                    }
                } catch (InterruptedException ex) {
                    Timber.e(ex, "Splash thread interrupted!");
                }

                finish();

                // Open MainActivity
                Intent mainActivityIntent = new Intent();
                mainActivityIntent.setClass(context, MainActivity.class);
                startActivity(mainActivityIntent);
            }
        };

        splashThread.start();
    }

    @Override
    protected void injectDependencies(MarvelApplication application, ApplicationComponent component) {
        component.inject(this);
    }

    // Listening to whole activity touch events
    @Override
    public boolean onTouchEvent(MotionEvent evt) {
        if (evt.getAction() == MotionEvent.ACTION_DOWN) {
            synchronized (splashThread) {
                splashThread.notifyAll();
            }
        }

        return true;
    }

    @Override
    protected void releaseSubComponents(MarvelApplication application) {

    }

}

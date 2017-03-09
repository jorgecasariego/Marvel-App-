package jorgecasariego.marvelspanish.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import jorgecasariego.marvelspanish.ApplicationComponent;
import jorgecasariego.marvelspanish.MarvelApplication;

/**
 * Created by jorgecasariego on 7/3/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        injectDependencies(MarvelApplication.get(this), MarvelApplication.getComponent());

        // can be used for general purpose in all Activities of Application
    }

    protected abstract void injectDependencies(MarvelApplication application, ApplicationComponent component);

    @Override
    public void finish() {
        super.finish();

        releaseSubComponents(MarvelApplication.get(this));
    }

    protected abstract void releaseSubComponents(MarvelApplication application);

}

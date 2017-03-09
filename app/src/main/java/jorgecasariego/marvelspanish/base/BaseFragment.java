package jorgecasariego.marvelspanish.base;

import android.content.Context;
import android.support.v4.app.Fragment;

import jorgecasariego.marvelspanish.MarvelApplication;

/**
 * Created by jorgecasariego on 7/3/17.
 */

public abstract class BaseFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        injectDependencies(MarvelApplication.get(getContext()));

        // can be used for general purpose in all Fragments of Application
    }

    protected abstract void injectDependencies(MarvelApplication application);
}

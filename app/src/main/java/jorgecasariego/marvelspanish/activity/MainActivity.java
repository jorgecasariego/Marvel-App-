package jorgecasariego.marvelspanish.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import jorgecasariego.marvelspanish.ApplicationComponent;
import jorgecasariego.marvelspanish.MarvelApplication;
import jorgecasariego.marvelspanish.R;
import jorgecasariego.marvelspanish.base.BaseActivity;
import jorgecasariego.marvelspanish.character.cache.CacheFragment;
import jorgecasariego.marvelspanish.character.search.SearchFragment;
import jorgecasariego.marvelspanish.database.model.CharacterModel;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

/**
 * In MarvelApplication class we create application component once and use it in Activities and
 * Fragments by extending BaseActivity and BaseFragment classes. Both of them are abstract and
 * the injectDependencies method must be implemented inside the Activity or Fragment.
 *
 */
public class MainActivity extends BaseActivity {

    public static final String TAG_SEARCH_FRAGMENT = "search_fragment";
    public static final String TAG_CACHE_FRAGMENT = "cache_fragment";

    // injecting dependencies via Dagger
    @Inject
    Context context;

    // injecting views via ButterKnife
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    CompositeSubscription subscriptions;
    private SearchFragment searchFragment;
    private CacheFragment cacheFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // inject views using ButterKnife
        ButterKnife.bind(this);

        setupToolbar();

        if (null == savedInstanceState) {
            searchFragment = SearchFragment.newInstance();
            cacheFragment = CacheFragment.newInstance();
            attachFragments();
        } else {
            searchFragment = (SearchFragment) getSupportFragmentManager().findFragmentByTag(TAG_SEARCH_FRAGMENT);
            cacheFragment = (CacheFragment) getSupportFragmentManager().findFragmentByTag(TAG_CACHE_FRAGMENT);
        }

        Timber.d("Main Activity Created");
    }

    @Override
    protected void injectDependencies(MarvelApplication application, ApplicationComponent component) {
        component.inject(this);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.logo);
        getSupportActionBar().setTitle(R.string.main_title);
    }

    private void attachFragments() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.search_fragment, searchFragment, TAG_SEARCH_FRAGMENT);
        fragmentTransaction.replace(R.id.cache_fragment, cacheFragment, TAG_CACHE_FRAGMENT);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (null == subscriptions || subscriptions.isUnsubscribed())
            subscriptions = new CompositeSubscription();

        subscriptions.addAll(
                searchFragment.characterObservable()
                        .subscribe(this::showCharacter),
                searchFragment.messageObservable()
                        .subscribe(this::showMessage),
                searchFragment.offlineObservable()
                        .subscribe(this::showOfflineMessage),
                cacheFragment.characterObservable()
                        .subscribe(this::showCharacter),
                cacheFragment.messageObservable()
                        .subscribe(this::showMessage),
                cacheFragment.offlineObservable()
                        .subscribe(this::showOfflineMessage)
        );
    }

    public void showMessage(String message) {
        Timber.d("Showing Message: %s", message);

        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public void showOfflineMessage(boolean isCritical) {
        Timber.d("Showing Offline Message");

        Snackbar.make(toolbar, R.string.offline_message, Snackbar.LENGTH_LONG)
                .setAction(R.string.go_online, v -> startActivity(new Intent(
                        Settings.ACTION_WIFI_SETTINGS)))
                .setActionTextColor(Color.GREEN)
                .show();
    }

    public void showCharacter(CharacterModel character) {
        startActivity(CharacterActivity.newIntent(this, character));
    }

    @Override
    protected void onPause() {
        super.onPause();

        subscriptions.unsubscribe();
    }

    @Override
    protected void releaseSubComponents(MarvelApplication application) {
        application.releaseCacheSubComponent();
        application.releaseSearchSubComponent();
    }
}

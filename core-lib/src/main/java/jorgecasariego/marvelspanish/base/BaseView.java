package jorgecasariego.marvelspanish.base;

/**
 * Created by jorgecasariego on 6/3/17.
 */

public interface BaseView<T> {

    void showMessage(String message);

    void showOfflineMessage(boolean isCritical);
}

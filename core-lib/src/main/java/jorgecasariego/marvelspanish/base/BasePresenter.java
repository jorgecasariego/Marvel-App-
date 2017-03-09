package jorgecasariego.marvelspanish.base;

/**
 * Created by jorgecasariego on 6/3/17.
 */

public interface BasePresenter<T> {

    void bind(T view);

    void unbind();
}

package jorgecasariego.marvelspanish.character.search;

import dagger.Subcomponent;

/**
 * Created by jorgecasariego on 7/3/17.
 */
@Search
@Subcomponent(modules = {
        SearchModule.class
})
public interface SearchSubComponent {

    void inject(SearchFragment fragment);

}


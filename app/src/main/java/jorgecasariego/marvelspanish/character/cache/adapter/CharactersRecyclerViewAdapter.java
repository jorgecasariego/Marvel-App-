package jorgecasariego.marvelspanish.character.cache.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jakewharton.rxbinding.view.RxView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jorgecasariego.marvelspanish.R;
import jorgecasariego.marvelspanish.database.model.CharacterModel;
import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by jorgecasariego on 7/3/17.
 */

public class CharactersRecyclerViewAdapter extends RecyclerView.Adapter<CharacterViewHolder> {

    private ArrayList<CharacterModel> characters = new ArrayList<>();

    private PublishSubject<CharacterModel> notify = PublishSubject.create();

    @Inject
    public CharactersRecyclerViewAdapter(){

    }

    public void setCharacters(List<CharacterModel> characters) {
        this.characters = new ArrayList<>(characters);
    }

    @Override
    public CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_character, parent, false);

        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CharacterViewHolder holder, int position) {
        final CharacterModel character = characters.get(position);

        holder.setCharacter(character);

        RxView.clicks(holder.view)
                .map(aVoid -> holder.getCharacter())
                .subscribe(notify::onNext);
    }

    public Observable<CharacterModel> asObservable(){
        return notify.asObservable();
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }
}

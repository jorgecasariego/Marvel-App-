package jorgecasariego.marvelspanish.character.cache.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;

import jorgecasariego.marvelspanish.database.model.CharacterModel;

/**
 * Created by jorgecasariego on 7/3/17.
 */

public class CharacterViewHolder extends RecyclerView.ViewHolder{

    public final View view;
    private CharacterModel character;
    private ViewDataBinding binding;

    public CharacterViewHolder(View view) {
        super(view);
        this.view = view;

        binding = DataBindingUtil.bind(view);
    }

    public CharacterModel getCharacter() {
        return character;
    }

    public void setCharacter(CharacterModel character) {
        this.character = character;

        binding.setVariable(BR.character, character);
        binding.executePendingBindings();
    }
}

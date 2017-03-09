package jorgecasariego.marvelspanish.util;

import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.graphics.Palette;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import jorgecasariego.marvelspanish.R;

/**
 * Created by jorgecasariego on 7/3/17.
 */

public class CustomBindingAdapter {
    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        if (null == url) {
            imageView.setImageResource(R.drawable.default_image);
        } else {
            Picasso.with(imageView.getContext())
                    .load(url)
                    .error(R.drawable.default_image)
                    .into(imageView, new PaletteCallback(imageView) {
                        @Override
                        public void onPalette(Palette palette) {
                            if (null != palette) {
                                ViewGroup parent = (ViewGroup) imageView.getParent().getParent();
                                parent.setBackgroundColor(palette.getDarkVibrantColor(Color.GRAY));
                            }
                        }
                    });
        }
    }

    public static abstract class PaletteCallback implements com.squareup.picasso.Callback {
        private final ImageView target;

        public PaletteCallback(final ImageView t) {
            target = t;
        }

        @Override
        public void onSuccess() {
            onPalette(Palette.from(((BitmapDrawable) target.getDrawable()).getBitmap()).generate());
        }

        @Override
        public void onError() {
            onPalette(null);
        }

        public abstract void onPalette(final Palette palette);
    }
}

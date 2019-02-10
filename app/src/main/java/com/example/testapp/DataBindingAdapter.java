package com.example.testapp;

import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.databinding.BindingAdapter;

import static com.example.testapp.URLs.IMAGE_BASE;

public class DataBindingAdapter {

    @BindingAdapter(value = {"movie", "tvSeries"})
    public static void addTitle(TextView title, String movieTitle, String tvSeriesTitle) {
        if(movieTitle != null) {
            title.setText(movieTitle);
            return;
        }
        title.setText(tvSeriesTitle);
    }

    @BindingAdapter("url")
    public static void loadImage(ImageView view, String url) {
        Picasso.get().load(IMAGE_BASE + url).into(view);
    }

}

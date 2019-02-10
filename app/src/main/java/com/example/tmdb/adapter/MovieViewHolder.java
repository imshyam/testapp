package com.example.tmdb.adapter;

import com.example.tmdb.BR;
import com.example.tmdb.model.MovieItem;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

class MovieViewHolder extends RecyclerView.ViewHolder {

    private final ViewDataBinding dataBinding;

    public MovieViewHolder(@NonNull ViewDataBinding dataBinding) {
        super(dataBinding.getRoot());
        this.dataBinding = dataBinding;
    }

    public void bindItem(MovieItem movie, boolean isFavoriteList) {
        dataBinding.setVariable(BR.movie, movie);
        dataBinding.executePendingBindings();
    }
}

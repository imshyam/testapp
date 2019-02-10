package com.example.testapp.adapter;

import com.example.testapp.BR;
import com.example.testapp.model.MovieItem;

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

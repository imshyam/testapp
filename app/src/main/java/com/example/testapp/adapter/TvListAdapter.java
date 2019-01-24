package com.example.testapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testapp.R;
import com.example.testapp.dao.FavoriteDao;
import com.example.testapp.model.MovieItem;
import com.example.testapp.model.TvSeriesItem;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TvListAdapter extends RecyclerView.Adapter<TvViewHolder> {
    List<TvSeriesItem> tvSeriesItems;
    FavoriteDao favoriteDao;

    public TvListAdapter(List<TvSeriesItem> tvSeriesItems, FavoriteDao favoriteDao) {
        this.tvSeriesItems = tvSeriesItems;
        this.favoriteDao = favoriteDao;
    }
    @NonNull
    @Override
    public TvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item,
                parent, false);
        return new  TvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvViewHolder holder, int position) {
        TvSeriesItem tvSeriesItem = tvSeriesItems.get(position);
        holder.bindItem(tvSeriesItem);
    }

    @Override
    public int getItemCount() {
        return tvSeriesItems.size();
    }
}

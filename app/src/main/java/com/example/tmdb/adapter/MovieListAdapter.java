package com.example.tmdb.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tmdb.R;
import com.example.tmdb.dao.FavoriteDao;
import com.example.tmdb.databinding.MovieListItemBinding;
import com.example.tmdb.executor.AppExecutor;
import com.example.tmdb.model.FavoriteItem;
import com.example.tmdb.model.HistoryItemTypeEnum;
import com.example.tmdb.model.MovieItem;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieListAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    List<MovieItem> movieItems;
    FavoriteDao favoriteDao;
    boolean isFavoriteList;

    public MovieListAdapter(List<MovieItem> movieItems, FavoriteDao favoriteDao, boolean isFavoriteList) {
        this.movieItems = movieItems;
        this.favoriteDao = favoriteDao;
        this.isFavoriteList = isFavoriteList;
    }
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MovieListItemBinding itemBinding = MovieListItemBinding.inflate(layoutInflater, parent, false);
        return new  MovieViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MovieItem movie = movieItems.get(position);
        holder.bindItem(movie, isFavoriteList);
        AppExecutor executor = AppExecutor.getInstance();
        if (isFavoriteList) {
            holder.itemView.findViewById(R.id.add_to_my_list).setOnClickListener((view) -> {
                executor.diskIO().execute(() -> favoriteDao.deleteItem(movie.getId()));
                removeMovieAt(position);
            });
        } else {
            holder.itemView.findViewById(R.id.add_to_my_list).setOnClickListener((view) -> {
                HistoryItemTypeEnum itemTypeEnum = movie.getOriginal_name() == null ?
                        HistoryItemTypeEnum.MOVIE_ITEM : HistoryItemTypeEnum.TV_SERIES_ITEM;
                executor.diskIO().execute(() -> favoriteDao.insertAll(new FavoriteItem(movie.getId(), itemTypeEnum)));
            });
        }
    }

    private void removeMovieAt(int position) {
        movieItems.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, movieItems.size());
    }

    @Override
    public int getItemCount() {
        return movieItems.size();
    }

    public void updateItems(List<MovieItem> movieItems) {
        this.movieItems.addAll(movieItems);
        notifyDataSetChanged();
    }
}

package com.example.testapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testapp.OnFragmentInteractionListener;
import com.example.testapp.R;
import com.example.testapp.adapter.MovieListAdapter;
import com.example.testapp.dao.MovieDatabase;
import com.example.testapp.dao.MoviesDao;
import com.example.testapp.executer.AppExecutor;
import com.example.testapp.model.MovieItem;
import com.example.testapp.viewmodel.TvMoviesViewModel;
import com.example.testapp.viewmodel.ViewModelFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MovieFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MovieFragment extends Fragment {
    private View rootView;
    private RecyclerView recyclerView;

    private OnFragmentInteractionListener mListener;

    public MovieFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MovieFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MovieFragment newInstance(String param1, String param2) {
        MovieFragment fragment = new MovieFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_movies, container, false);
        recyclerView = rootView.findViewById(R.id.movie_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        MoviesDao moviesDao = MovieDatabase.getInstance(getActivity()).moviesDao();
        Executor executor = AppExecutor.getInstance().diskIO();

        ViewModelFactory viewModelFactory = new ViewModelFactory(moviesDao, executor);
        TvMoviesViewModel viewModel = ViewModelProviders.of(this, viewModelFactory).get(TvMoviesViewModel.class);

        viewModel.getMovies().observe(this, allItems -> {
            List<MovieItem> movieItems = new ArrayList<>();
            for (MovieItem item: allItems) {
                if (item.getOriginal_title() != null) {
                    movieItems.add(item);
                }
            }
            if(movieItems.size() > 0 && rootView != null) {
                MovieListAdapter adapter = new MovieListAdapter(movieItems);
                recyclerView.setAdapter(adapter);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}

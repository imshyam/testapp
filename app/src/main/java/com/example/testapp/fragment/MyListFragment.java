package com.example.testapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testapp.OnFragmentInteractionListener;
import com.example.testapp.R;
import com.example.testapp.dao.FavoriteDao;
import com.example.testapp.dao.MovieDatabase;
import com.example.testapp.dao.MoviesDao;
import com.example.testapp.executer.AppExecutor;
import com.example.testapp.model.FavoriteItem;
import com.example.testapp.model.MovieItem;
import com.example.testapp.viewmodel.TvMoviesViewModel;
import com.example.testapp.viewmodel.ViewModelFactory;

import java.util.concurrent.Executor;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MyListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    TextView tv;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MyListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyListFragment newInstance(String param1, String param2) {
        MyListFragment fragment = new MyListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_my_list, container, false);
        tv = rootView.findViewById(R.id.fav);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        MoviesDao moviesDao = MovieDatabase.getInstance(getActivity()).moviesDao();
        FavoriteDao favoriteDao = MovieDatabase.getInstance(getActivity()).favoriteDao();
        Executor executor = AppExecutor.getInstance().diskIO();

        ViewModelFactory viewModelFactory = new ViewModelFactory(moviesDao, favoriteDao, executor);
        TvMoviesViewModel viewModel = ViewModelProviders.of(this, viewModelFactory).get(TvMoviesViewModel.class);

        viewModel.getFavorites().observe(this, favoriteItems -> {
            String s = "";
            for (MovieItem fav:  favoriteItems) {
                s += fav.getId() + fav.getOriginal_name() +  " : " + fav.getOriginal_title() + " \n";
            }
            tv.setText(s);
        });


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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

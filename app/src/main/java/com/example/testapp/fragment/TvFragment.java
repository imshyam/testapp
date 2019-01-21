package com.example.testapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testapp.OnFragmentInteractionListener;
import com.example.testapp.R;
import com.example.testapp.adapter.MovieListAdapter;
import com.example.testapp.adapter.TvListAdapter;
import com.example.testapp.model.MovieItem;
import com.example.testapp.model.TvSeriesItem;
import com.example.testapp.viewmodel.MoviesViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TvFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TvFragment extends Fragment {


    private View rootView;
    private RecyclerView recyclerView;

    private OnFragmentInteractionListener mListener;

    public TvFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TvFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TvFragment newInstance() {
        TvFragment fragment = new TvFragment();
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
        rootView = inflater.inflate(R.layout.fragment_tv, container, false);
        recyclerView = rootView.findViewById(R.id.tv_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        MoviesViewModel viewModel = ViewModelProviders.of(getActivity()).get(MoviesViewModel.class);

        viewModel.getTvSeries().observe(this, responseJson -> {
            List<TvSeriesItem> tvSeriesItems = responseJson.getResults();
            if(tvSeriesItems.size() > 0 && rootView != null) {
                TvListAdapter adapter = new TvListAdapter(tvSeriesItems);
                recyclerView.setAdapter(adapter);
            }
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
package com.melayer.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {

    private View faceView;

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        faceView = inflater.inflate(R.layout.fragment_my, container, false);


        return faceView;
    }
}

package com.melayer.interfragmentcommunication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MaxFragment extends Fragment {

    public static final String KEY_IMAGE = "loadTimeImage";

    public static MaxFragment getInstance(int image){
        MaxFragment frag = new MaxFragment();
        Bundle bundle =  new Bundle();
        bundle.putInt(MaxFragment.KEY_IMAGE, image);
        frag.setArguments(bundle);

        return frag;
    }
    public MaxFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View faceView = inflater.inflate(R.layout.fragment_max, container, false);

        ((ImageView) faceView.findViewById(R.id.imageView))
                .setImageResource(getArguments().getInt(KEY_IMAGE));

        return faceView;
    }

}

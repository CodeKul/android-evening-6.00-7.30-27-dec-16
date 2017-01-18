package com.melayer.interfragmentcommunication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MinFragment extends Fragment {


    public static MinFragment getInstance(){
        MinFragment minFragment = new MinFragment();

        return minFragment;
    }

    public MinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View faceView = inflater.inflate(R.layout.fragment_min, container, false);
        faceView.findViewById(R.id.btnPoker).setOnClickListener(this::poker);
        faceView.findViewById(R.id.btnRoullete).setOnClickListener(this::roullete);

        return faceView;
    }

    private void roullete(View view) {
        ((MainActivity)(getActivity())).loadFragment(R.id.frameMax,MaxFragment.getInstance(R.drawable.ic_roulette));
    }

    private void poker(View view) {
        ((MainActivity)(getActivity())).loadFragment(R.id.frameMax,MaxFragment.getInstance(R.drawable.ic_poker));
    }

}

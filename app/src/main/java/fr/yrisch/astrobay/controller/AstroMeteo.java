package fr.yrisch.astrobay.controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.yrisch.astrobay.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AstroMeteo extends Fragment {


    public AstroMeteo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_astro_meteo,container,false);
    }

}

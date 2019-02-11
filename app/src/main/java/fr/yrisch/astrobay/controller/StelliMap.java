package fr.yrisch.astrobay.controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import fr.yrisch.astrobay.R;
import fr.yrisch.astrobay.ui.NGC;
import fr.yrisch.astrobay.ui.NGCAdaptater;

/**
 * A simple {@link Fragment} subclass.
 */
public class StelliMap extends Fragment {

    public StelliMap() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ListView mListView = null;
        mListView =(ListView) mListView.findViewById(R.id.scrollNGC);
        List<NGC> NGCs = generateNGCs();
        NGCAdaptater adaptater = new NGCAdaptater(StelliMap.this, NGCs);
        return inflater.inflate(R.layout.fragment_stelli_map,container,false);

    }

}

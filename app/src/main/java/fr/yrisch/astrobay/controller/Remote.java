package fr.yrisch.astrobay.controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.yrisch.astrobay.R;
import io.github.controlwear.virtual.joystick.android.JoystickView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Remote extends Fragment {

    private View rview;


    public Remote() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rview = inflater.inflate(R.layout.fragment_remote,container,false);
        JoystickView joystick = (JoystickView) rview.findViewById(R.id.Btn);
        final TextView ang = rview.findViewById(R.id.ang);
        final TextView str = rview.findViewById(R.id.str);
        joystick.setOnMoveListener(new JoystickView.OnMoveListener() {
            @Override
            public void onMove(int angle, int strength) {
                ang.setText(String.valueOf(angle));
                str.setText(String.valueOf(strength));
            }
        });
        return rview;
    }


}

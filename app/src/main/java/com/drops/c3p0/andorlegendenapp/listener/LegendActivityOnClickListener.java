package com.drops.c3p0.andorlegendenapp.listener;

import android.view.View;

import com.drops.c3p0.andorlegendenapp.activity.LegendActivity;

/**
 *   Dieser Listener wird mit allen Buttons der LegendActivity verknüpft.
 * Es wird gelauscht, bis ein Button berührt wird. Dann wird der jeweilige
 * Programmcode ausgefürht.
 * Der einsatz der Klasse dient zur besseren Übersicht.
 * Created by C3P0 on 14.12.2017.
 */

public class LegendActivityOnClickListener implements View.OnClickListener{

    @Override
    public void onClick(View view) {
        //Explicit CAST
        LegendActivity legendActivity = (LegendActivity) view.getContext();


    }
}

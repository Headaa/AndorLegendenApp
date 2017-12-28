package com.drops.c3p0.andorlegendenapp.listener;

import android.content.Intent;
import android.view.View;

import com.drops.c3p0.andorlegendenapp.R;
import com.drops.c3p0.andorlegendenapp.activity.ListViewActivityLegends;
import com.drops.c3p0.andorlegendenapp.activity.MainActivity;

/**
 * Dieser Listener wird mit allen Button der MainActivity verknüpft.
 * Es wird gelauscht, bis ein Button berührt wird. Dann wird der jeweilige
 * Programmcode ausgefürht.
 * Der Einsatz der Klasse dient zur besseren Übersicht.
 * <p>
 * <p>
 * Created by C3P0 on 14.12.2017.
 */

public class MainActivityOnClickListener implements View.OnClickListener {


    @Override
    public void onClick(View view)
    {
        //EXPLICIT CAST!!!!
        MainActivity mainActivity = (MainActivity) view.getContext();




        switch (view.getId())
        {
            case R.id.imgButtonLegends:
                Intent intentLegends = new Intent(mainActivity, ListViewActivityLegends.class);
                mainActivity.startActivity(intentLegends);
                break;
            case R.id.imgButtonMusic:

                break;
        }
    }
}

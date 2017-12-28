package com.drops.c3p0.andorlegendenapp.controller;

import android.content.Context;

import com.drops.c3p0.andorlegendenapp.R;
import com.drops.c3p0.andorlegendenapp.activity.MainActivity;
import com.drops.c3p0.andorlegendenapp.beans.Legend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by C3P0 on 18.12.2017.
 */

public class DbLegends  {
    // Legendenliste

    private static DbLegends instance = null;
    private List<Legend> legendList;

    //Sortierstatus: 0 = unsortiert, 1 = Nach Titel Sortiert, 2 ...TODO
    private int legendSort;
    private int numberOfLegends;
    private boolean legendsSorted;
    //Konstruktor

    private DbLegends(Context context) {
        legendSort = 0;
        legendsSorted = false;
        Legend addLegend = null;

        int currentNr = 0;
        legendList = new ArrayList<Legend>();
       // while (getResources().getBoolean (
       //                 this.getResources().getIdentifier("legend" + Integer.toString(currentNr) + "Title", "string", this.getPackageName())
       //         ))//TODO

        numberOfLegends = Integer.parseInt( context.getResources().getString(R.string.numberOfLegends));
        //
            for( currentNr =0;currentNr < numberOfLegends;currentNr++)
        {

            addLegend = new Legend(context,currentNr);
            legendList.add(addLegend);
        }
    }

    // Genereiere die einzige Instanz der Legendendatenbank Klasse

    public static synchronized DbLegends getInstance(Context context)
    {
        if (instance == null)
        {
            instance = new DbLegends(context);
        }
        return instance;
    }



    Boolean sortLegends(int sort) {
        switch (sort) {


            //Sortien nach Titelname
            case 1:
                //TODO Sortieralgorithmus implementieren
                break;
        }


        return false;

    }

    public List<Legend> getLegendList() {
        return legendList;
    }

    public void setLegendList(List<Legend> legendList) {
        this.legendList = legendList;
    }

    public String[] getLegendTitleList() {
        String[] strToReturn = new String[this.legendList.size()];
        for (int i=0; i<this.legendList.size();i++)
        {
            strToReturn[i] = legendList.get(i).getLegendTitle();
        }
        //String[] strToReturn = {"1","2"};//TODO DELETE?

        int legendNr = 0;

            return strToReturn;
    }
}

package com.drops.c3p0.andorlegendenapp.beans;

import android.content.Context;

import com.drops.c3p0.andorlegendenapp.activity.MainActivity;
import com.drops.c3p0.andorlegendenapp.controller.DbLegends;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by C3P0 on 18.12.2017.
 */

public class Legend {

    //Name und Inhalt der Legende
    private String legendtitle;
    private String shortDescription;
    private String prolog;
    private LinkedList<String> legendCards = null;
    private int numberOfCards;

    //Werte zum ablegen und ordnen
    private int legendId;

    //Konstruktor - Erzeugt die notwendigen Daten Redundant?? TODO
    public Legend() {
        this.legendtitle = "NoTitle";
        this.shortDescription = " ";
        this.prolog = " ";
    }

    ;

    //Konstruktor - Erzeugt die notwendigen Daten für eiene Legende aus den Text-Strings
    public Legend(Context context, int id) {
        MainActivity mainActivity = (MainActivity) context;

      legendCards = new LinkedList<String>();

        this.legendId = id;
        this.numberOfCards = Integer.parseInt((String) mainActivity.getResources().getText(mainActivity.getResources().getIdentifier("legend" + this.legendId + "CardNumbers","string", mainActivity.getPackageName())));

        //    int test =  mainActivity.getResources().getText(mainActivity.getResources().getIdentifier("legend" + Integer.toString(id) + "Prolog", "string", mainActivity.getPackageName()));
        int test = mainActivity.getResources().getIdentifier("legend" + Integer.toString(id) + "Prolog", "string", mainActivity.getPackageName());
        this.legendtitle = (String) mainActivity.getResources().getText(mainActivity.getResources().getIdentifier("legend" + Integer.toString(id) + "Title", "string", mainActivity.getPackageName()));
        this.prolog =      (String) mainActivity.getResources().getText(mainActivity.getResources().getIdentifier("legend" + Integer.toString(id) + "Prolog", "string", mainActivity.getPackageName()));
        // Schleife zum Einlesen der Legendentexte

        for (int currentCard = 0; currentCard < this.numberOfCards ; currentCard++) {
            this.legendCards.add((String) mainActivity.getResources().getText(mainActivity.getResources().getIdentifier("legend" + Integer.toString(id) + "Card" + Integer.toString(currentCard), "string", mainActivity.getPackageName())).toString());
        }
    }

    //@Override

    // Getter und Setter Methoden
    public String getLegendTitle() {
        return legendtitle;
    }

    public int getLegendId() {
        return legendId;
    }

    public String getProlog() {
        return prolog;
    }

    public List<String> getLegendCards() {
        return legendCards;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }
}

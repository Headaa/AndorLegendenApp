package com.drops.c3p0.andorlegendenapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.drops.c3p0.andorlegendenapp.R;
import com.drops.c3p0.andorlegendenapp.R;
import com.drops.c3p0.andorlegendenapp.beans.Legend;
import com.drops.c3p0.andorlegendenapp.controller.DbLegends;

/**
 * Created by C3P0 on 13.12.2017.
 */

public class LegendActivity extends ListViewActivityLegends {

    //Deklarationen
    //Datentypen
    private int currentCard = 0;
    private int numberOfCards = 0;

    //Hilfsvariablen
    boolean zeroLegendFlag;

    //Widgets
    //Bildwechsler
    private ImageSwitcher imgSwitcherLegend = null; // TODO NOCH nötig?

    //Buttons
    private Button buttonLegendBack = null;
    private Button buttonLegendForward = null;

    //Textfelder
    private TextView textViewLegendTitle = null;
    private TextView textViewLegendQuest = null;
    //Scrollbar
    private ScrollView scrollViewLegend = null;
    static  boolean zeroFlag = true;

    //Text to Speech


    //Helferfunktionen
    //
    //
    //
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_legend);
        //Variablen Definitionen
        numberOfCards = DbLegends.getInstance(this).getLegendList().get(ListViewActivityLegends.getCurrentLegend()).getNumberOfCards();

        //Widgets Definitionen

        buttonLegendBack = (Button) findViewById(R.id.buttonLegendBack);
        buttonLegendForward = (Button) findViewById(R.id.buttonLegendForward);

        textViewLegendQuest = (TextView) findViewById(R.id.textViewLegendQuest);
        scrollViewLegend = (ScrollView) findViewById(R.id.SCROLLER_ID);
        textViewLegendTitle = (TextView) findViewById(R.id.textViewLegendTitle);

        // Setzen des Titels der aktuellen Legende
        textViewLegendTitle.setText(DbLegends.getInstance(this).getLegendList().get(ListViewActivityLegends.getCurrentLegend()).getLegendTitle());

        //Setzen des Prolog der Legende
        textViewLegendQuest.setText(DbLegends.getInstance(this).getLegendList().get(ListViewActivityLegends.getCurrentLegend()).getProlog());

        //   Toast.makeText(getApplicationContext(),          numberOfCards, Toast.LENGTH_SHORT).show();
        //Definition der Hilfsvariablen
        zeroLegendFlag = true;

        buttonLegendForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //EXPLIZIT CAST
                MainActivity mainActivity = (MainActivity) view.getContext();



                // Aktualisiert den aktuellen Questfortschritt
                if (currentCard == numberOfCards) {
                    Intent intent = new Intent(LegendActivity.this, ListViewActivityLegends.class);
                    startActivity(intent);
                } else {
                    if (zeroFlag == true) {
                       // currentCard++;
                        textViewLegendQuest.setText(Html.fromHtml(DbLegends.getInstance(mainActivity).getLegendList().get(ListViewActivityLegends.getCurrentLegend()).getLegendCards().get(currentCard)));
                        zeroFlag = false;
                    } else {

                        currentCard++;
                        textViewLegendQuest.setText(Html.fromHtml(DbLegends.getInstance(mainActivity).getLegendList().get(ListViewActivityLegends.getCurrentLegend()).getLegendCards().get(currentCard)));

                    }
                }
                //   Toast.makeText(getApplicationContext(),//TODO entfernen
                // Toast.makeText(getApplicationContext(),//TODO entfernen
                ;
            }
        });

    // OnClick Listener für den zurück Button in der LegendActivity.

        buttonLegendBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) view.getContext();

                if (currentCard == 0) {
                    Intent intent = new Intent(LegendActivity.this, ListViewActivityLegends.class);
                    startActivity(intent);
                } else {

                    --currentCard;
                    textViewLegendQuest.setText(Html.fromHtml(DbLegends.getInstance(mainActivity).getLegendList().get(ListViewActivityLegends.getCurrentLegend()).getLegendCards().get(currentCard)));

                }
            }
        });

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        zeroFlag = false;

        //  mediaPlayer.stop();
        //  mediaPlayer.release();

    }
}

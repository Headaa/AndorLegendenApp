package com.drops.c3p0.andorlegendenapp.activity;

/**
 * Created by C3P0 on 12.12.2017.
 * package com.drops.c3p0.legendenvonandor;
 * <p>
 * /**
 * Created by C3P0 on 12.12.2017.
 */


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.drops.c3p0.andorlegendenapp.R;
import com.drops.c3p0.andorlegendenapp.R;
import com.drops.c3p0.andorlegendenapp.controller.DbLegends;

public class ListViewActivityLegends extends com.drops.c3p0.andorlegendenapp.activity.MainActivity {

    //Variablendekeration
    // Widgets
    private ListView listViewLegends = null;

    //Datentypen
    private DbLegends dbLegends = null;
    private String[] legendsStringList = null;
    private static int currentLegend = 0;

    //Methoden

    public static int getCurrentLegend() {
        return currentLegend;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.legends_layout);

        //Legenden Laden
        //dbLegends = new DbLegends();

        listViewLegends = (ListView) findViewById(R.id.listView_legends);


        legendsStringList = DbLegends.getInstance(this).getLegendTitleList();

        ArrayAdapter<String> adapter = new <String>ArrayAdapter(this,
                android.R.layout.simple_list_item_1, legendsStringList);

        listViewLegends.setAdapter(adapter);

        listViewLegends.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                currentLegend = position;
                String output = (String)"22";


                Toast.makeText(getApplicationContext(),//TODO entfernen
                        Integer.toString(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ListViewActivityLegends.this, LegendActivity.class);
                startActivity(intent);

            }
        });

    }
}


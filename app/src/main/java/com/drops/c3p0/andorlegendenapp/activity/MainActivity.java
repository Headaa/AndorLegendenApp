package com.drops.c3p0.andorlegendenapp.activity;
// Für die App Entwicklung nötie Importe

import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;

import com.drops.c3p0.andorlegendenapp.R;
import com.drops.c3p0.andorlegendenapp.listener.MainActivityOnClickListener;
import com.drops.c3p0.andorlegendenapp.listener.MainActivityOnTouchListener;

import static java.util.Locale.GERMANY;

// Zum testen nötige Importe


public class MainActivity extends AppCompatActivity {

    // Variablendeklerationen UI
    //Image Buttons
    private ImageButton imgButtonLegends = null;
    private ImageButton imgButtonMusic = null;

    //Widgets Deklaration
    // Buttons
    Button buttonDummyOne = null;
    Button buttonStartMusic = null;
    Button buttonStopMusic = null;

    //private Button button_stop_music = null;
    private Button buttonBack = null;

    // ListAdapter
    ListAdapter listAdapter = null;

    //Listener
    private MainActivityOnClickListener mainActivityOnClickListener = null;
    private MainActivityOnTouchListener mainActivityOnTouchListener = null;


    //Media

    //Player
    MediaPlayer mediaPlayer = null;

    //TTS
    TextToSpeech ttobj = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        //mediaPlayer = MediaPlayer.create(this,R.raw.fantasie);
      //  mediaPlayer.start(); //TODO

        //TTS Init
        ttobj =  new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                ttobj.setLanguage(GERMANY);
            }
        });




        // Definition und Belegung der Variablen
        // ImageButtons
        imgButtonLegends = (ImageButton) findViewById(R.id.imgButtonLegends);
        imgButtonMusic = (ImageButton) findViewById(R.id.imgButtonMusic);

        //Buttons
        buttonBack = (Button) findViewById(R.id.button_back);
        buttonDummyOne = (Button) findViewById(R.id.buttonDummyOne);
        buttonStartMusic = (Button) findViewById(R.id.buttonStartMusic);
        buttonStopMusic = (Button) findViewById(R.id.buttonStopMusic);

        // Gernerieren des MainActivitiyOn-Click--Listener
        mainActivityOnClickListener = new MainActivityOnClickListener();

        //Setzen des OnClick Listeners
        imgButtonLegends.setOnClickListener(mainActivityOnClickListener);
        imgButtonMusic.setOnClickListener(mainActivityOnClickListener);

        // Gernerieren des MainActivitiyOn--Touch--Listener
        mainActivityOnTouchListener = new MainActivityOnTouchListener();

        //Setzen des OnTouch Listeners
        buttonDummyOne.setOnTouchListener(mainActivityOnTouchListener);
        imgButtonMusic.setOnTouchListener(mainActivityOnTouchListener);
        buttonStartMusic.setOnTouchListener(mainActivityOnTouchListener);
        buttonStopMusic.setOnTouchListener(mainActivityOnTouchListener);







    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        //onClickListner Definition Button Back
/*
    button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 // setContentView(R.layout.main_layout);
            }
        });
*/
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
      //  mediaPlayer.stop();
      //  mediaPlayer.release();

    }
}

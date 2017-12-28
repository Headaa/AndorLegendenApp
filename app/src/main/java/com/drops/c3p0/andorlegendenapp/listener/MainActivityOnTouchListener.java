package com.drops.c3p0.andorlegendenapp.listener;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

import com.drops.c3p0.andorlegendenapp.R;
import com.drops.c3p0.andorlegendenapp.activity.ListViewActivityLegends;
import com.drops.c3p0.andorlegendenapp.activity.MainActivity;

/**
 * Created by C3P0 on 15.12.2017.
 */

public class MainActivityOnTouchListener implements View.OnTouchListener {


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        MainActivity mainActivity = (MainActivity) view.getContext();

        //Widgets Delcare
        Button buttonDummyOne = null;
        ImageButton imgButtonMusic = null;

        //Widgets Define
        buttonDummyOne = (Button) mainActivity.findViewById(R.id.buttonDummyOne);
        imgButtonMusic = (ImageButton) mainActivity.findViewById(R.id.imgButtonMusic);

        //Animations
        // XML File Animations
        Animation animationAlpha = AnimationUtils.loadAnimation(mainActivity, R.anim.fade_in);
        Animation animationSpinRotate = AnimationUtils.loadAnimation(mainActivity, R.anim.spin_rotate);
        // Fade Animation
        AlphaAnimation anim;
        anim = new AlphaAnimation(1.0f, 0.6f);
        anim.setDuration(1000);
        anim.setRepeatCount(1);
        anim.setRepeatMode(AlphaAnimation.REVERSE);

        //Media Player Implementation


        view.performClick();    // TODO was bringt das?
        switch (view.getId()) {
            case R.id.buttonDummyOne:
                //buttonDummyOne.setText("2123");
                buttonDummyOne.startAnimation(anim);

                break;

            case R.id.imgButtonMusic:
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {


                    imgButtonMusic.startAnimation(anim);

                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {

                    Intent intentMusic = new Intent(mainActivity, ListViewActivityLegends.class);
                    mainActivity.startActivity(intentMusic);

                } else if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {

                }

                break;
            case R.id.buttonStartMusic:

                break;

            case  R.id.buttonStopMusic:

                break;

        }
        return false;
    }
}

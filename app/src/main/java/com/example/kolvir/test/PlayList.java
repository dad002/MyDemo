package com.example.kolvir.test;

/**
 * Created by kulik on 16.02.2018.
 */
import android.app.Service;
import android.content.Context;
import android.media.MediaPlayer;

import java.util.Random;


public class PlayList {

    MediaPlayer mPlayer;
    boolean MUTE_INDEX = true;
    boolean IS_PLAIYNG = false;

    public void createPlayList(Context context) {
        Random r = new Random();
        int MUSIC_NUMBER = r.nextInt(2);
        switch (MUSIC_NUMBER){
            case (0):
                {
                    mPlayer = MediaPlayer.create(context, R.raw.music_main_0);
                    mPlayer.start();
                    MUTE_INDEX = false;
                    IS_PLAIYNG = true;
                break;
            }
            case (1):
                {
                    mPlayer = MediaPlayer.create(context, R.raw.music_main_1);
                    mPlayer.start();
                    MUTE_INDEX = false;
                    IS_PLAIYNG = true;
                break;
            }
            case (2):{
                    mPlayer = MediaPlayer.create(context, R.raw.music_main_2);
                    mPlayer.start();
                    MUTE_INDEX = false;
                    IS_PLAIYNG = true;
                break;
            }
        }

    }
    public boolean isPlaying(){
        boolean x = mPlayer.isPlaying();
        return x;
    }
    public void stop(){
        mPlayer.pause();
    }
    public void stopPlay(){
        if(!MUTE_INDEX){
            mPlayer.stop();
            MUTE_INDEX = true;
            IS_PLAIYNG = false;
        }
        else {
            mPlayer.start();
            MUTE_INDEX = false;
            IS_PLAIYNG = true;
        }
    }
}

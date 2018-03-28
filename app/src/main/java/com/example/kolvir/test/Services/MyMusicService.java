package com.example.kolvir.test.Services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import com.example.kolvir.test.R;


public class MyMusicService extends Service{

    private static final String TAG = null;
    MediaPlayer player;

    public IBinder onBind(Intent arg0){

        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.music_main_0);
        player.setLooping(true);
    }

    public int onStartCommand(Intent intent, int flags, int startId){
        player.start();
        return Service.START_STICKY;
    }

    public void onStart(Intent intent, int startId){

    }

    public IBinder onUnBind(Intent arg0){
        return null;
    }

    public void onStop(){

    }
    public void onPause(){

    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}

package com.example.kolvir.test.Services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.example.kolvir.test.R;


public class MyMusicService extends Service{

    static MediaPlayer player;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "My Service Created",Toast.LENGTH_LONG).show();

        player = MediaPlayer.create(this, R.raw.music_main_0);
        player.setLooping(true);
        Log.i("RVINFO", "ServiceOnCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"Service started", Toast.LENGTH_LONG).show();
        player.start();
        Log.i("RVINFO","ServiceOnStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    public static void onPause(){
        player.pause();
    }

    public static void onStart(){
        Log.i("RVINFO", "ServiceOnStart");
        player.start();
    }

    public static boolean isPlaying(){
        return player.isPlaying();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"Service stopped", Toast.LENGTH_LONG).show();
        player.stop();
        super.onDestroy();
    }
}

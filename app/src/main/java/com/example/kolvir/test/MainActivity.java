package com.example.kolvir.test;


import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.kolvir.test.FirstChapter.first_part_novel;
import com.example.kolvir.test.Gallery.Gallery;
import com.example.kolvir.test.Services.MusicService;

import java.util.ArrayList;

//TODO 1. Анимация плохо работает с галреей + она глючит при обратном выходе из приложения
//TODO 2. Разобраться с сервисами и делать паузу а не стоп при переходе в многозадачкость и когда сворачиваем


public class MainActivity extends AppCompatActivity {
    String TAG = "RVINFO";
    Animation animButton;
    ImageView imagePlay;
    ImageView imageContinue;
    ImageView imageGallery;
    ImageView imageAboutUs;
    ImageView imageSound;


    private ArrayList<Song> songList;
    private MusicService musicSrv;
    private Intent playIntent;
    private boolean musicBound=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animButton = AnimationUtils.loadAnimation(this,R.anim.menu_button);

        imagePlay = findViewById(R.id.BPlay);
        imageContinue = findViewById(R.id.BContinue);
        imageGallery = findViewById(R.id.BGallery);
        imageAboutUs = findViewById(R.id.BOptions);
        imageSound = findViewById(R.id.BSound);

        setOnTouch(imagePlay);
        setOnTouch(imageContinue);
        setOnTouch(imageGallery);
        setOnTouch(imageAboutUs);
        setOnTouch(imageSound);

    }
    private ServiceConnection musicConnection = new ServiceConnection(){

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MusicService.MusicBinder binder = (MusicService.MusicBinder)service;
            //get service
            musicSrv = binder.getService();
            //pass list
            musicSrv.setList(songList);
            musicBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            musicBound = false;
        }
    };
    @Override
    protected void onStart() {
        super.onStart();
        if(playIntent==null){
            playIntent = new Intent(this, MusicService.class);
            bindService(playIntent, musicConnection, Context.BIND_AUTO_CREATE);
            startService(playIntent);
        }
    }
    public void getSongList() {
        //retrieve song info
        ContentResolver musicResolver = getContentResolver();
        Uri musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor musicCursor = musicResolver.query(musicUri, null, null, null, null);

        if(musicCursor!=null && musicCursor.moveToFirst()){
            //get column
            int idColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media._ID);
            //add songs to list
            do {
                long thisId = musicCursor.getLong(idColumn);
                songList.add(new Song(thisId));
            }
            while (musicCursor.moveToNext());
        }
    }
    public void songPicked(View view){
        musicSrv.setSong(Integer.parseInt(view.getTag().toString()));
        musicSrv.playSong();
    }

    public void onClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.BPlay:
                    intent = new Intent(this,first_part_novel.class);
                    view.clearAnimation();
                    startActivity(intent);
                break;
            case R.id.BContinue:
                    view.clearAnimation();
                    //TODO позволяет сделать выбор комнаты с которой надо будет начать
                break;
            case R.id.BGallery:
                Log.i(TAG,"GOGOGO");
                    intent = new Intent(this,Gallery.class);
                    view.clearAnimation();
                    startActivity(intent);
                break;
            case R.id.BOptions:
                    view.clearAnimation();
                break;
            case R.id.BSound:
                    view.clearAnimation();
                    stopService(playIntent);
                    musicSrv=null;
                break;
        }
    }

    private void setOnTouch(View v){
        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.startAnimation(animButton);
                }
                return false;
            }
        });
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {

        }
        if (keyCode == KeyEvent.KEYCODE_BACK){

        }
        return super.onKeyLongPress(keyCode, event);
    }
}
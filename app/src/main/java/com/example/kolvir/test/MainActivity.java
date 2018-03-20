package com.example.kolvir.test;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.kolvir.test.FirstChapter.first_part_novel;
import com.example.kolvir.test.Gallery.Gallery;
import com.example.kolvir.test.Services.MyMusicService;

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

        startService(new Intent(this, MyMusicService.class));
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
                    stopService(new Intent(this, MyMusicService.class));
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
    public void onBackPressed() {
        super.onBackPressed();
        stopService(new Intent(this, MyMusicService.class));
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        stopService(new Intent(this,MyMusicService.class));
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            stopService(new Intent(this,MyMusicService.class));
        }
        return super.onKeyLongPress(keyCode, event);
    }
}
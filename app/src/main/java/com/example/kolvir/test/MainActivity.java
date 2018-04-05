package com.example.kolvir.test;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.kolvir.test.FirstChapter.first_part_novel;
import com.example.kolvir.test.Gallery.Gallery;
import com.example.kolvir.test.Services.MyMusicService;

//TODO 1. Анимация плохо работает с галреей
//TODO 2. Разобраться с сервисами и делать паузу а не стоп при переходе в многозадачкость и когда сворачиваем


public class MainActivity extends AppCompatActivity {
    String TAG = "RVINFO";
    Animation animButton;
    ImageView imagePlay;
    ImageView imageContinue;
    ImageView imageGallery;
    ImageView imageAboutUs;
    ImageView imageSound;
    Boolean isMusicNotNecessary;
    Boolean isRealPause;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animButton = AnimationUtils.loadAnimation(this, R.anim.button_anim);
        startService(new Intent(this, MyMusicService.class));

        imagePlay = findViewById(R.id.BPlay);
        imageContinue = findViewById(R.id.BContinue);
        imageGallery = findViewById(R.id.BGallery);
        imageAboutUs = findViewById(R.id.BAboutUs);
        imageSound = findViewById(R.id.BSound);

        setOnTouch(imagePlay);
        setOnTouch(imageContinue);
        setOnTouch(imageGallery);
        setOnTouch(imageAboutUs);
        setOnTouch(imageSound);

        isMusicNotNecessary = true;
        isRealPause = false;

        Log.i(TAG, "onCreate");

    }

    public void onClick(View view) {
        Intent intent;

        switch (view.getId()) {
            case R.id.BPlay:
                intent = new Intent(this, first_part_novel.class);
                view.clearAnimation();
                startActivity(intent);
                overridePendingTransition(R.anim.botton_in, R.anim.top_out);
                break;
            case R.id.BContinue:
                view.clearAnimation();
                //TODO позволяет сделать выбор комнаты с которой надо будет начать
                break;
            case R.id.BGallery:
                Log.i(TAG, "GOGOGO");
                intent = new Intent(this, Gallery.class);
                view.clearAnimation();
                startActivity(intent);
                isMusicNotNecessary = false;
                break;
            case R.id.BAboutUs:
                intent = new Intent(this, AboutUsActivity.class);
                view.clearAnimation();
                startActivity(intent);
                isMusicNotNecessary = false;
                break;
            case R.id.BSound:
                if (MyMusicService.isPlaying()) {
                    MyMusicService.onPause();
                    isRealPause = true;
                } else {
                    MyMusicService.onStart();
                    isRealPause = false;
                }
                break;
        }
    }

    private void setOnTouch(View v) {
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
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(this, MyMusicService.class));

        Log.i(TAG, "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isMusicNotNecessary) MyMusicService.onPause();

        Log.i(TAG, "onStop");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        if (isMusicNotNecessary && !isRealPause) MyMusicService.onStart();
        isMusicNotNecessary = true;

        Log.i(TAG, "onRestart");
    }
}
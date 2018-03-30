package com.example.kolvir.test;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

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
    int tmp = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animButton = AnimationUtils.loadAnimation(this,R.anim.button_anim);

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
                    overridePendingTransition(R.anim.botton_in,R.anim.top_out);
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
                if (MyMusicService.isPlaying()){
                    MyMusicService.onPause();
                    tmp = 0;
                }
                else {
                    tmp = 1;
                    MyMusicService.onStart();
                }
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
        stopService(new Intent(this, MyMusicService.class));
        super.onBackPressed();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU){
            Toast.makeText(this,"stop",Toast.LENGTH_SHORT).show();
            stopService(new Intent(this, MyMusicService.class));
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            Toast.makeText(this,"yes",Toast.LENGTH_SHORT).show();
            stopService(new Intent(this, MyMusicService.class));
        }
        return super.onKeyLongPress(keyCode, event);
    }
}
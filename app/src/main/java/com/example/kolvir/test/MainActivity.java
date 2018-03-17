package com.example.kolvir.test;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.kolvir.test.FirstChapter.first_part_novel;
import com.example.kolvir.test.Gallery.Gallery;
import com.example.kolvir.test.Services.MyMusicService;

public class MainActivity extends AppCompatActivity {
    String TAG = "RVINFO";
    Animation animButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animButton = AnimationUtils.loadAnimation(this,R.anim.menu_button);
        //startService(new Intent(this, MyMusicService.class));
        //playList.createPlayList(this);
    }

    public void onClick(View view){
        Intent intent;
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.startAnimation(animButton);
                }
                return false;
            }
        });
        switch (view.getId()){
            case R.id.BPlay:
                    intent = new Intent(this,first_part_novel.class);
                    startActivity(intent);
                break;
            case R.id.BContinue:
                    //TODO позволяет сделать выбор комнаты с которой надо будет начать
                break;
            case R.id.BGallery:
                Log.i(TAG,"GOGOGO");
                    intent = new Intent(this,Gallery.class);
                    startActivity(intent);
                break;
            case R.id.BOptions:
                break;
            case R.id.BSound:

                stopService(new Intent(this, MyMusicService.class));
                break;
        }
    }
}
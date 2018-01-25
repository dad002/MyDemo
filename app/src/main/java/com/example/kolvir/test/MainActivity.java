package com.example.kolvir.test;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kolvir.test.FirstChapter.first_part_novel;
import com.example.kolvir.test.Gallery.Gallery;

public class MainActivity extends AppCompatActivity {

    private boolean MUTE_INDEX = false;

    private boolean IS_PLAYING = false;
    MediaPlayer mPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayer = MediaPlayer.create(this, R.raw.music);
        mPlayer.start();
        IS_PLAYING = true;
    }

    public void onClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.BPlay:
                    intent = new Intent(this,first_part_novel.class);
                    startActivity(intent);
                break;
            case R.id.BContinue:
                    //TODO позволяет сделать выбор комнаты с которой надо будет начать
                break;
            case R.id.BGallery:
                    intent = new Intent(this,Gallery.class);
                    startActivity(intent);
                break;
            case R.id.BOptions:
                    //TODO активити с опциями
                break;
            case R.id.BSound:
                   stopPlay();
                break;
        }
    }

    private void stopPlay() {
        if (!MUTE_INDEX) {
            mPlayer.pause();
            MUTE_INDEX = true;
        }
        else{
            mPlayer.start();
            MUTE_INDEX = false;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPlayer.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPlayer.isPlaying()){
            stopPlay();
        }
    }
}
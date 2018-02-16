package com.example.kolvir.test;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kolvir.test.FirstChapter.first_part_novel;
import com.example.kolvir.test.Gallery.Gallery;

public class MainActivity extends AppCompatActivity {
    PlayList playList = new PlayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playList.createPlayList(this);
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
                    playList.stopPlay();
                    System.out.print(playList.IS_PLAIYNG);
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        playList.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (playList.isPlaying()){
            playList.stopPlay();
        }
    }


}
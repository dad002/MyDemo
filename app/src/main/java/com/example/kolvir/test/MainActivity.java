package com.example.kolvir.test;

        import android.content.Context;
        import android.content.Intent;
        import android.content.res.AssetFileDescriptor;
        import android.content.res.AssetManager;
        import android.media.AudioManager;
        import android.media.MediaPlayer;
        import android.media.SoundPool;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import com.example.kolvir.test.FirstChapter.first_part_novel;
        import com.example.kolvir.test.Gallery.Gallery;

        import java.io.IOException;
        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mPlayer;
    private boolean mute_index = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayer = MediaPlayer.create(this, R.raw.music);
        mPlayer.start();
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                stopPlay();
            }
        });
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
        if (!mute_index) {
            mPlayer.pause();
            mute_index = true;
        }
        else{
            mPlayer.start();
            mute_index = false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPlayer.isPlaying()){
            stopPlay();
        }
    }
}
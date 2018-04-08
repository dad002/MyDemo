package com.example.kolvir.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
//TODO еблан
public class SplashActivity extends AppCompatActivity {
    private ImageView iv;
    private Thread timer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        iv = (ImageView) findViewById(R.id.splash_tree);
        Animation tree_anim = AnimationUtils.loadAnimation(this, R.anim.splash_anim);
        iv.startAnimation(tree_anim);

        startNewActivity();
    }

    @Override
    protected void onStop() {
        Log.i("SPLASH","onStopSplash");
        super.onStop();

        if (timer != null) {
            Thread dummy = timer;
            timer = null;
            dummy.interrupt();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("SPLASH","onRestartSplash");
        startNewActivity();
    }

    private void startNewActivity(){
        final Intent intent = new Intent(this, MainActivity.class);

        timer = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.start();
        Log.i("RVINFO", "onCreate_splash");
    }
}
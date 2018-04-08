package com.example.kolvir.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kulik on 05.04.2018.
 */

public class AboutUsActivity extends AppCompatActivity {
    TextView tvArtemy;
    TextView tvMikhail;
    TextView tvThird;
    TextView tvRights;
    ImageView ivLogo;
    boolean isVisible = true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about_us);
        tvArtemy = (TextView) findViewById(R.id.textView4);
        tvMikhail = (TextView) findViewById(R.id.textView5);
        tvThird = (TextView) findViewById(R.id.textView6);
        tvRights = (TextView) findViewById(R.id.textView3);
        ivLogo = (ImageView) findViewById(R.id.imageView2);
        Animation text_anim = AnimationUtils.loadAnimation(this, R.anim.about_us_anim);
        tvArtemy.startAnimation(text_anim);
        tvMikhail.startAnimation(text_anim);
        tvThird.startAnimation(text_anim);
        tvRights.startAnimation(text_anim);
        ivLogo.startAnimation(text_anim);
    }
}

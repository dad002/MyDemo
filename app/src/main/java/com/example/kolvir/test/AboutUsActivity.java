package com.example.kolvir.test;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

public class AboutUsActivity extends AppCompatActivity {
    TextView tvArtemy;
    TextView tvMikhail;
    TextView tvThird;
    TextView tvRights;
    ImageView ivLogo;
    ImageView back;
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
        back = findViewById(R.id.img1);
        Glide.with(this).load(R.mipmap.gallery_back).asBitmap().into(new SimpleTarget<Bitmap>(1920, 1080) {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                Drawable drawable = new BitmapDrawable(getResources(), resource);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    back.setImageDrawable(drawable);
                }
            }
        });
        Animation text_anim = AnimationUtils.loadAnimation(this, R.anim.about_us_anim);
        tvArtemy.startAnimation(text_anim);
        tvMikhail.startAnimation(text_anim);
        tvThird.startAnimation(text_anim);
        tvRights.startAnimation(text_anim);
        ivLogo.startAnimation(text_anim);
    }
}

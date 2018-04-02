package com.example.kolvir.test.Gallery;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.kolvir.test.R;
import com.example.kolvir.test.Services.MyMusicService;

public class Gallery extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager llm;
    RVAdapter adapter;
    String TAGRV = "RVINFO";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Log.i(TAGRV,"InGallery");
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);

        Glide.with(this).load(R.mipmap.gallery_back).asBitmap().into(new SimpleTarget<Bitmap>(1920, 1080) {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                Drawable drawable = new BitmapDrawable(getResources(), resource);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    recyclerView.setBackground(drawable);
                }
            }
        });

        adapter = new RVAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.addAll(Chapters.getChapters());

        llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(llm);

    }
}

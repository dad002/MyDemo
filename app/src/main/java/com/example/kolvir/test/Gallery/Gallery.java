package com.example.kolvir.test.Gallery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.kolvir.test.R;
//ааааааааааааааааа бля
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

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);

        adapter = new RVAdapter();
        recyclerView.setAdapter(adapter);
        adapter.addAll(Chapters.getChapters());

        llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(llm);

    }
}

package com.example.kolvir.test.Gallery;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.AbsListView;

import com.example.kolvir.test.MainActivity;
import com.example.kolvir.test.R;

/**
 * Created by kolvir on 11.01.2018.
 */

public class Gallery extends MainActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
    }
}

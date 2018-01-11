package com.example.kolvir.test.FirstChapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.kolvir.test.R;

public class first_part_novel extends AppCompatActivity{

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_part_novel);

        text = (TextView) findViewById(R.id.MainText);
    }

    public void onTouch(View view){
        text.setText(R.string.cool); // for test
        //TODO тута нужно делать подгрузку текста и выводить его + надо следить за сменой image
    }

}

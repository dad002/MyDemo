package com.example.kolvir.test.FirstChapter;


import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kolvir.test.Exel;
import com.example.kolvir.test.R;

public class first_part_novel extends AppCompatActivity{

    ImageView im;
    TextView mainText;
    TextView nameText;
    Exel ex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_part_novel);

        AssetManager am = this.getAssets();

        try {
            ex = new Exel(am,0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mainText =  findViewById(R.id.MainText);
        nameText =  findViewById(R.id.names);
        im =  findViewById(R.id.fPartImage);
    }

    public void onTouch(View view) throws Exception {
        //TODO потом разберись что за хрень с 0.0 и возможно раскидай по разным функциям эту работу
        String tmp = ex.Print();

        String[] strings = tmp.split("%");

        switch (strings[0]){
            case "0.0":
                    nameText.setText(strings[1]);
                    mainText.setText(strings[2]);
                break;
            case "1.0":
                    im.setImageResource(R.mipmap.forsecond);
                    nameText.setText(strings[1]);
                    mainText.setText(strings[2]);
                break;
            case "2.0":
                    //TODO скорее всего это будет подключение музыкальных вставок(коротеньких)
                break;
            case "3.0":
                    Intent intent = new Intent(this,room_first.class);
                    startActivity(intent);
                break;
        }

    }
}

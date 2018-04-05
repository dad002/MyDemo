package com.example.kolvir.test.FirstChapter;


import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kolvir.test.AuxiliaryForHistory.DelayedPrinter;
import com.example.kolvir.test.AuxiliaryForHistory.Exel;
import com.example.kolvir.test.R;

public class first_part_novel extends AppCompatActivity {

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
            ex = new Exel(am, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mainText = findViewById(R.id.MainText);
        nameText = findViewById(R.id.names);
        im = findViewById(R.id.fPartImage);
    }

    public void onTouch(View view) throws Exception {
        if (DelayedPrinter.getIsRunning()) {

            String[] strings = getTextFromExcel(0).split("%");
            DelayedPrinter.setIsRunning(false);
            switch (strings[0]) {
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
            }
        } else {

            String[] strings = getTextFromExcel(1).split("%");
            DelayedPrinter.Word word = new DelayedPrinter.Word(strings[2]);

            switch (strings[0]) {
                case "0.0":
                    nameText.setText(strings[1]);
                    mainText.setText("");
                    DelayedPrinter.printText(word, mainText);
                    break;
                case "1.0":
                    im.setImageResource(R.mipmap.forsecond);
                    nameText.setText(strings[1]);
                    mainText.setText("");
                    DelayedPrinter.printText(word, mainText);
                    break;
                case "2.0":
                    //TODO скорее всего это будет подключение музыкальных вставок(коротеньких)
                    break;
                case "3.0":
                    Intent intent = new Intent(this, room_first.class);
                    startActivity(intent);
                    break;
            }
        }
    }

    public String getTextFromExcel(int status) {
        String tmp;
        if (status == 1) {
            tmp = ex.Print(0);
        } else {
            tmp = ex.Print(1);
        }
        return tmp;
    }
}

package com.example.kolvir.test;

import android.content.res.AssetManager;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;

public class Exel {

    String res;

    public Exel(AssetManager am) throws Exception {

        int row;
        int cell;

        HSSFWorkbook wb = null;
        try{
            wb = new HSSFWorkbook(am.open("exel.xls"));
        } catch (IOException e){
            e.printStackTrace();
        }
        row = 0;
        cell = 0;
    }

    public String CreateNames(){

        return res;
    }

    public String Print(){
        return res;
    }
}

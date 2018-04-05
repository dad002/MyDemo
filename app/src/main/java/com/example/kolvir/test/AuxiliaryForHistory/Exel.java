package com.example.kolvir.test.AuxiliaryForHistory;

import android.content.res.AssetManager;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;

public class Exel {

    private int row;
    private int cell;
    private int sheet;
    private HSSFWorkbook wb = null;

    public Exel(AssetManager am, int chapterName) throws Exception {
        sheet = chapterName;

        try {
            wb = new HSSFWorkbook(am.open("exel.xls"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        row = 1;
        cell = 1;
    }

    public String Print(int rowStatus) {
        if (rowStatus == 1) row -= 1;

        if (row < 0) row = 0;

        String acIndex = CreateResIndex();

        String res = acIndex + "%" + CreateNames() + "%" + CreateMessage();

        if (!acIndex.equals("3.0")) {
            row += 1;
        }
        return res;
    }

    private String CreateNames() {
        String res = wb.getSheetAt(sheet).getRow(row).getCell(cell + 1).toString();

        if (res == null) {
            return " ";
        } else {
            return res;
        }
    }

    private String CreateMessage() {
        String res = wb.getSheetAt(sheet).getRow(row).getCell(cell + 2).toString();

        if (res == null) {
            return " ";
        } else {
            return res;
        }
    }

    private String CreateResIndex() {
        return wb.getSheetAt(sheet).getRow(row).getCell(cell).toString();
    }
}

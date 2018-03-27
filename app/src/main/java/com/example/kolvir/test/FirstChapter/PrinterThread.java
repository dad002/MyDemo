package com.example.kolvir.test.FirstChapter;

/**
 * Created by kolvir on 27.03.2018.
 */

public class PrinterThread extends Thread{

    private volatile boolean mFinish = false;

    public void setmFinish(){
        mFinish = true;
    }

    @Override
    public void run() {

    }
}

package com.example.kolvir.test.Services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.ContactsContract;

/**
 * Created by kulik on 30.03.2018.
 */

public class ScreenReceiver extends BroadcastReceiver {


    public static boolean wasScreenOn = true;
    public boolean screenOff;

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF)){
            screenOff =true;
            wasScreenOn = false;
        }
        else {
            screenOff = false;
            wasScreenOn = true;
        }
        Intent i = new Intent(context, UpdateService.class);
        i.putExtra("screen_state", screenOff);
        context.startService(i);

    }
}

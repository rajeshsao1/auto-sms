package com.autosms.myapplicationcallevent.backgroundtask;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.autosms.myapplicationcallevent.SplashScreenActivity;

public class StartAppOnBoot extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
            Intent i = new Intent(context, SplashScreenActivity.class);
            i.addFlags(268435456);
            context.startActivity(i);
        }
    }
}

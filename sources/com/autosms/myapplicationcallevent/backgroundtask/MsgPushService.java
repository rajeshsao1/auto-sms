package com.autosms.myapplicationcallevent.backgroundtask;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;

public class MsgPushService extends Service {
    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(), "Service Started", 1).show();
        doRestart(getApplicationContext());
        return 1;
    }

    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroy", 1).show();
    }

    public IBinder onBind(Intent arg0) {
        return null;
    }

    public static void doRestart(Context c) {
        if (c != null) {
            try {
                PackageManager pm = c.getPackageManager();
                if (pm != null) {
                    Intent mStartActivity = pm.getLaunchIntentForPackage(c.getPackageName());
                    if (mStartActivity != null) {
                        mStartActivity.addFlags(67108864);
                        ((AlarmManager) c.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + 100, PendingIntent.getActivity(c, 223344, mStartActivity, 268435456));
                    } else {
                        Log.e("TAG_SERVICE", "Was not able to restart application, mStartActivity null");
                    }
                } else {
                    Log.e("TAG_SERVICE", "Was not able to restart application, PM null");
                }
            } catch (Exception e) {
                Log.e("TAG_SERVICE", "Was not able to restart application");
            }
        } else {
            Log.e("TAG_SERVICE", "Was not able to restart application, Context null");
        }
    }
}

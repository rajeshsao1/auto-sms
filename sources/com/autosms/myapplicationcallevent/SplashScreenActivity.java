package com.autosms.myapplicationcallevent;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.pixplicity.easyprefs.library.Prefs;

public class SplashScreenActivity extends AppCompatActivity {
    Handler handler;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_splash_screen);
        Handler handler2 = new Handler();
        this.handler = handler2;
        handler2.postDelayed(new Runnable() {
            public void run() {
                if (Prefs.getBoolean("isLogin", Boolean.parseBoolean(""))) {
                    SplashScreenActivity.this.startActivity(new Intent(SplashScreenActivity.this.getApplicationContext(), MainActivity.class));
                    SplashScreenActivity.this.finish();
                    return;
                }
                Intent i = new Intent(SplashScreenActivity.this.getApplicationContext(), LoginActivity.class);
                i.addFlags(268435456);
                SplashScreenActivity.this.startActivity(i);
            }
        }, 3000);
    }
}

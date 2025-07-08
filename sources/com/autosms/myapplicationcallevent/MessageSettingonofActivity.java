package com.autosms.myapplicationcallevent;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.pixplicity.easyprefs.library.Prefs;

public class MessageSettingonofActivity extends AppCompatActivity {
    Button btnon;
    String msgSetting;
    Toolbar toolbar;

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        finish();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_message_settingonof);
        this.btnon = (Button) findViewById(R.id.btnon);
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.tool2);
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String string = Prefs.getString("msgSettingOnOff", "");
        this.msgSetting = string;
        if (string.equalsIgnoreCase("true")) {
            this.btnon.setText("Message Setting is On");
        } else {
            this.btnon.setText("Message Setting is Off");
        }
        this.btnon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (MessageSettingonofActivity.this.btnon.getText().toString().equalsIgnoreCase("Message Setting is On")) {
                    Prefs.putString("msgSettingOnOff", "false");
                    Toast.makeText(MessageSettingonofActivity.this, "Message Setting is Off !!", 0).show();
                    MessageSettingonofActivity.this.btnon.setText("Message Setting is Off");
                } else if (MessageSettingonofActivity.this.btnon.getText().toString().equalsIgnoreCase("Message Setting is Off")) {
                    Prefs.putString("msgSettingOnOff", "true");
                    Toast.makeText(MessageSettingonofActivity.this, "Message Setting is On !!", 0).show();
                    MessageSettingonofActivity.this.btnon.setText("Message Setting is On");
                }
            }
        });
    }
}

package com.autosms.myapplicationcallevent;

import android.content.Intent;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.pixplicity.easyprefs.library.Prefs;

public class MisscallmsgActivity extends AppCompatActivity {
    Button btnEdit;
    Button btnSave;
    EditText edtMsg;
    Toolbar toolbar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_misscallmsg);
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.tool1);
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.btnSave = (Button) findViewById(R.id.btnSave);
        this.btnEdit = (Button) findViewById(R.id.btnEdit);
        EditText editText = (EditText) findViewById(R.id.edtMsg);
        this.edtMsg = editText;
        editText.setEnabled(false);
        Prefs.putString("msgtype", "");
        this.edtMsg.setText(Prefs.getString("msg_MissCall", ""));
        this.btnEdit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MisscallmsgActivity.this.edtMsg.setEnabled(true);
            }
        });
        this.btnEdit.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                MisscallmsgActivity.this.edtMsg.setEnabled(true);
                if (event.getAction() == 0) {
                    v.getBackground().setColorFilter(new LightingColorFilter(-1, -5636096));
                }
                if (event.getAction() == 1) {
                    v.getBackground().setColorFilter(new LightingColorFilter(-1, 0));
                }
                return false;
            }
        });
        this.btnSave.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                MisscallmsgActivity.this.edtMsg.setEnabled(true);
                if (event.getAction() == 0) {
                    v.getBackground().setColorFilter(new LightingColorFilter(-1, -5636096));
                }
                if (event.getAction() == 1) {
                    v.getBackground().setColorFilter(new LightingColorFilter(-1, 0));
                }
                return false;
            }
        });
        this.btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!MisscallmsgActivity.this.edtMsg.getText().toString().equalsIgnoreCase("")) {
                    Prefs.putString("msg_MissCall", MisscallmsgActivity.this.edtMsg.getText().toString());
                    Prefs.putString("msgtype", "misscall");
                    MisscallmsgActivity.this.edtMsg.setEnabled(false);
                    MisscallmsgActivity.this.edtMsg.setText("");
                    MisscallmsgActivity.this.edtMsg.setText(Prefs.getString("msg_MissCall", ""));
                    Toast.makeText(MisscallmsgActivity.this, "Message saved Successfully !!", 0).show();
                    MisscallmsgActivity.this.startActivity(new Intent(MisscallmsgActivity.this.getApplicationContext(), MainActivity.class));
                    return;
                }
                Toast.makeText(MisscallmsgActivity.this, "Please type message..", 0).show();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        finish();
        return true;
    }
}

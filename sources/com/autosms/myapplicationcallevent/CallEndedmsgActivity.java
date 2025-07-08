package com.autosms.myapplicationcallevent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.pixplicity.easyprefs.library.Prefs;

public class CallEndedmsgActivity extends AppCompatActivity {
    Button btnEdit;
    Button btnSave;
    EditText edtMsg;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_callended);
        this.btnSave = (Button) findViewById(R.id.btnSave);
        this.btnEdit = (Button) findViewById(R.id.btnEdit);
        EditText editText = (EditText) findViewById(R.id.edtMsg);
        this.edtMsg = editText;
        editText.setEnabled(false);
        Prefs.putString("msgtype1", "");
        this.edtMsg.setText(Prefs.getString("msg_CallEnded", ""));
        this.btnEdit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CallEndedmsgActivity.this.edtMsg.setEnabled(true);
            }
        });
        this.btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Prefs.putString("msg_CallEnded", CallEndedmsgActivity.this.edtMsg.getText().toString());
                Prefs.putString("msgtype1", "callended");
                CallEndedmsgActivity.this.edtMsg.setEnabled(false);
                CallEndedmsgActivity.this.edtMsg.setText("");
                CallEndedmsgActivity.this.edtMsg.setText(Prefs.getString("msg_CallEnded", ""));
                Toast.makeText(CallEndedmsgActivity.this, "Message for Call saved Successfully ..", 0).show();
            }
        });
    }
}

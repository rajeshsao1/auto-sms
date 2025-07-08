package com.autosms.myapplicationcallevent;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.autosms.myapplicationcallevent.Helper.MyController;
import com.google.gson.Gson;
import com.pixplicity.easyprefs.library.Prefs;
import java.util.ArrayList;

public class BlockContactActivity extends AppCompatActivity {
    int SELECT_PHONE_NUMBER;
    Button b1;
    EditText edt1;
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
        setContentView((int) R.layout.activity_block_contact);
        this.edt1 = (EditText) findViewById(R.id.edtMob);
        this.b1 = (Button) findViewById(R.id.btn);
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.t3);
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        MyController.arrayList = new ArrayList<>();
        this.b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String str = "+91" + BlockContactActivity.this.edt1.getText().toString();
                if (!str.equalsIgnoreCase("")) {
                    MyController.arrayList.add(str);
                    Prefs.putString("array", new Gson().toJson((Object) MyController.arrayList));
                    Toast.makeText(BlockContactActivity.this, "Contact blocked.", 0).show();
                    BlockContactActivity.this.edt1.setText("");
                    return;
                }
                Toast.makeText(BlockContactActivity.this, "enter mobile no.", 0).show();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == this.SELECT_PHONE_NUMBER && resultCode == -1) {
            Cursor cursor = getContentResolver().query(data.getData(), new String[]{"data1"}, (String) null, (String[]) null, (String) null);
            if (cursor != null && cursor.moveToFirst()) {
                cursor.getString(cursor.getColumnIndex("data1"));
            }
            cursor.close();
        }
    }

    public void selectContact() {
        Intent i = new Intent("android.intent.action.PICK");
        i.setType("vnd.android.cursor.dir/phone_v2");
        startActivityForResult(i, this.SELECT_PHONE_NUMBER);
    }
}

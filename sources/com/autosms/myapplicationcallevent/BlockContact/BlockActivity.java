package com.autosms.myapplicationcallevent.BlockContact;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autosms.myapplicationcallevent.R;
import java.util.ArrayList;

public class BlockActivity extends AppCompatActivity {
    Button actionButton;
    ArrayList<NoteModel> arrayList;
    DatabaseHelper database_helper;
    RecyclerView recyclerView;
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
        setContentView((int) R.layout.activity_block);
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.t3);
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.actionButton = (Button) findViewById(R.id.add);
        this.database_helper = new DatabaseHelper(this);
        displayNotes();
        this.actionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BlockActivity.this.showDialog();
            }
        });
    }

    public void displayNotes() {
        this.arrayList = new ArrayList<>(this.database_helper.getNotes());
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.recyclerView.setAdapter(new NotesAdapter(getApplicationContext(), this, this.arrayList));
    }

    public void showDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        dialog.setContentView(R.layout.dialog);
        params.copyFrom(dialog.getWindow().getAttributes());
        params.height = -1;
        params.width = -1;
        params.gravity = 17;
        dialog.getWindow().setAttributes(params);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.show();
        dialog.setCancelable(true);
        final EditText title = (EditText) dialog.findViewById(R.id.title);
        ((Button) dialog.findViewById(R.id.submit)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (title.getText().toString().isEmpty()) {
                    title.setError("Please Enter contact no.");
                    return;
                }
                BlockActivity.this.database_helper.addNotes(title.getText().toString());
                dialog.cancel();
                BlockActivity.this.displayNotes();
            }
        });
    }
}

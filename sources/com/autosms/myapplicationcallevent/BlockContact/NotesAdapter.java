package com.autosms.myapplicationcallevent.BlockContact;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.autosms.myapplicationcallevent.R;
import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<viewHolder> {
    Activity activity;
    ArrayList<NoteModel> arrayList;
    Context context;
    DatabaseHelper database_helper;

    public NotesAdapter(Context context2, Activity activity2, ArrayList<NoteModel> arrayList2) {
        this.context = context2;
        this.activity = activity2;
        this.arrayList = arrayList2;
    }

    public viewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new viewHolder(LayoutInflater.from(this.context).inflate(R.layout.notes_list, viewGroup, false));
    }

    public void onBindViewHolder(viewHolder holder, final int position) {
        holder.title.setText(this.arrayList.get(position).getTitle());
        this.database_helper = new DatabaseHelper(this.context);
        holder.delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NotesAdapter.this.database_helper.delete(NotesAdapter.this.arrayList.get(position).getID());
                NotesAdapter.this.arrayList.remove(position);
                NotesAdapter.this.notifyDataSetChanged();
            }
        });
        holder.edit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NotesAdapter.this.showDialog(position);
            }
        });
    }

    public int getItemCount() {
        return this.arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView delete;
        TextView description;
        ImageView edit;
        TextView title;

        public viewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.title);
            this.delete = (ImageView) itemView.findViewById(R.id.delete);
            this.edit = (ImageView) itemView.findViewById(R.id.edit);
        }
    }

    public void showDialog(final int pos) {
        final Dialog dialog = new Dialog(this.activity);
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
        final EditText title = (EditText) dialog.findViewById(R.id.title);
        title.setText(this.arrayList.get(pos).getTitle());
        ((Button) dialog.findViewById(R.id.submit)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (title.getText().toString().isEmpty()) {
                    title.setError("Please Enter Title");
                    return;
                }
                NotesAdapter.this.database_helper.updateNote(title.getText().toString(), NotesAdapter.this.arrayList.get(pos).getID());
                NotesAdapter.this.arrayList.get(pos).setTitle(title.getText().toString());
                dialog.cancel();
                NotesAdapter.this.notifyDataSetChanged();
            }
        });
    }
}

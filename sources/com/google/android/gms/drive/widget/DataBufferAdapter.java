package com.google.android.gms.drive.widget;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.drive.internal.zzz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBufferAdapter<T> extends BaseAdapter {
    private final Context mContext;
    private final LayoutInflater mInflater;
    private final int zzavs;
    private int zzavt;
    private final int zzavu;
    private final List<DataBuffer<T>> zzavv;
    private boolean zzavw;

    public DataBufferAdapter(Context context, int i) {
        this(context, i, 0, new ArrayList());
    }

    public DataBufferAdapter(Context context, int i, int i2) {
        this(context, i, i2, new ArrayList());
    }

    public DataBufferAdapter(Context context, int i, int i2, List<DataBuffer<T>> list) {
        this.zzavw = true;
        this.mContext = context;
        this.zzavt = i;
        this.zzavs = i;
        this.zzavu = i2;
        this.zzavv = list;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public DataBufferAdapter(Context context, int i, int i2, DataBuffer<T>... dataBufferArr) {
        this(context, i, i2, Arrays.asList(dataBufferArr));
    }

    public DataBufferAdapter(Context context, int i, List<DataBuffer<T>> list) {
        this(context, i, 0, list);
    }

    public DataBufferAdapter(Context context, int i, DataBuffer<T>... dataBufferArr) {
        this(context, i, 0, Arrays.asList(dataBufferArr));
    }

    private View zza(int i, View view, ViewGroup viewGroup, int i2) {
        if (view == null) {
            view = this.mInflater.inflate(i2, viewGroup, false);
        }
        try {
            int i3 = this.zzavu;
            TextView textView = i3 == 0 ? (TextView) view : (TextView) view.findViewById(i3);
            Object item = getItem(i);
            textView.setText(item instanceof CharSequence ? (CharSequence) item : item.toString());
            return view;
        } catch (ClassCastException e) {
            zzz.zza("DataBufferAdapter", e, "You must supply a resource ID for a TextView");
            throw new IllegalStateException("DataBufferAdapter requires the resource ID to be a TextView", e);
        }
    }

    public void append(DataBuffer<T> dataBuffer) {
        this.zzavv.add(dataBuffer);
        if (this.zzavw) {
            notifyDataSetChanged();
        }
    }

    public void clear() {
        for (DataBuffer<T> release : this.zzavv) {
            release.release();
        }
        this.zzavv.clear();
        if (this.zzavw) {
            notifyDataSetChanged();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getCount() {
        int i = 0;
        for (DataBuffer<T> count : this.zzavv) {
            i += count.getCount();
        }
        return i;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return zza(i, view, viewGroup, this.zzavt);
    }

    public T getItem(int i) throws CursorIndexOutOfBoundsException {
        int i2 = i;
        for (DataBuffer next : this.zzavv) {
            int count = next.getCount();
            if (count <= i2) {
                i2 -= count;
            } else {
                try {
                    return next.get(i2);
                } catch (CursorIndexOutOfBoundsException e) {
                    throw new CursorIndexOutOfBoundsException(i, getCount());
                }
            }
        }
        throw new CursorIndexOutOfBoundsException(i, getCount());
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return zza(i, view, viewGroup, this.zzavs);
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.zzavw = true;
    }

    public void setDropDownViewResource(int i) {
        this.zzavt = i;
    }

    public void setNotifyOnChange(boolean z) {
        this.zzavw = z;
    }
}

package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T> implements DataBuffer<T> {
    protected final DataHolder zzahi;

    protected AbstractDataBuffer(DataHolder dataHolder) {
        this.zzahi = dataHolder;
        if (dataHolder != null) {
            dataHolder.zzu(this);
        }
    }

    @Deprecated
    public final void close() {
        release();
    }

    public abstract T get(int i);

    public int getCount() {
        DataHolder dataHolder = this.zzahi;
        if (dataHolder == null) {
            return 0;
        }
        return dataHolder.getCount();
    }

    @Deprecated
    public boolean isClosed() {
        DataHolder dataHolder = this.zzahi;
        return dataHolder == null || dataHolder.isClosed();
    }

    public Iterator<T> iterator() {
        return new zzb(this);
    }

    public void release() {
        DataHolder dataHolder = this.zzahi;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    public Iterator<T> singleRefIterator() {
        return new zzg(this);
    }

    public Bundle zzpZ() {
        return this.zzahi.zzpZ();
    }
}

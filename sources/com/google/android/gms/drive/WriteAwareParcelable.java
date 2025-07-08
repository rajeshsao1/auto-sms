package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;

public abstract class WriteAwareParcelable implements Parcelable {
    private volatile transient boolean zzapw = false;

    public void writeToParcel(Parcel parcel, int i) {
        zzx.zzab(!zzsT());
        this.zzapw = true;
        zzJ(parcel, i);
    }

    /* access modifiers changed from: protected */
    public abstract void zzJ(Parcel parcel, int i);

    public final boolean zzsT() {
        return this.zzapw;
    }
}

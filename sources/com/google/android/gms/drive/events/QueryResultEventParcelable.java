package com.google.android.gms.drive.events;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.WriteAwareParcelable;

public class QueryResultEventParcelable extends WriteAwareParcelable implements DriveEvent {
    public static final zzl CREATOR = new zzl();
    final int mVersionCode;
    final DataHolder zzahi;
    final boolean zzapQ;
    final int zzapR;

    QueryResultEventParcelable(int i, DataHolder dataHolder, boolean z, int i2) {
        this.mVersionCode = i;
        this.zzahi = dataHolder;
        this.zzapQ = z;
        this.zzapR = i2;
    }

    public int describeContents() {
        return 0;
    }

    public int getType() {
        return 3;
    }

    public void zzJ(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }

    public DataHolder zzsX() {
        return this.zzahi;
    }

    public boolean zzsY() {
        return this.zzapQ;
    }

    public int zzsZ() {
        return this.zzapR;
    }
}

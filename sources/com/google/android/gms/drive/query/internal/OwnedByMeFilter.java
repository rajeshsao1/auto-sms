package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

public class OwnedByMeFilter extends AbstractFilter {
    public static final zzo CREATOR = new zzo();
    final int mVersionCode;

    public OwnedByMeFilter() {
        this(1);
    }

    OwnedByMeFilter(int i) {
        this.mVersionCode = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }

    public <F> F zza(zzf<F> zzf) {
        return zzf.zztP();
    }
}

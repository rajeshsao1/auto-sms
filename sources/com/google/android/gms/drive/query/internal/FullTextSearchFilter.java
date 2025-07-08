package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

public class FullTextSearchFilter extends AbstractFilter {
    public static final zzh CREATOR = new zzh();
    final String mValue;
    final int mVersionCode;

    FullTextSearchFilter(int i, String str) {
        this.mVersionCode = i;
        this.mValue = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public <F> F zza(zzf<F> zzf) {
        return zzf.zzdj(this.mValue);
    }
}

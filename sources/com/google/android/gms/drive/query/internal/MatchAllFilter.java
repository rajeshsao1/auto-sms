package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

public class MatchAllFilter extends AbstractFilter {
    public static final zzl CREATOR = new zzl();
    final int mVersionCode;

    public MatchAllFilter() {
        this(1);
    }

    MatchAllFilter(int i) {
        this.mVersionCode = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }

    public <F> F zza(zzf<F> zzf) {
        return zzf.zztQ();
    }
}

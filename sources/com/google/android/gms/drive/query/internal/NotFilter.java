package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.query.Filter;

public class NotFilter extends AbstractFilter {
    public static final Parcelable.Creator<NotFilter> CREATOR = new zzm();
    final int mVersionCode;
    final FilterHolder zzauw;

    NotFilter(int i, FilterHolder filterHolder) {
        this.mVersionCode = i;
        this.zzauw = filterHolder;
    }

    public NotFilter(Filter filter) {
        this(1, new FilterHolder(filter));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }

    public <T> T zza(zzf<T> zzf) {
        return zzf.zzB(this.zzauw.getFilter().zza(zzf));
    }
}

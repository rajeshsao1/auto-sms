package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class Scope implements SafeParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new zzb();
    final int mVersionCode;
    private final String zzagB;

    Scope(int i, String str) {
        zzx.zzh(str, "scopeUri must not be null or empty");
        this.mVersionCode = i;
        this.zzagB = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.zzagB.equals(((Scope) obj).zzagB);
    }

    public int hashCode() {
        return this.zzagB.hashCode();
    }

    public String toString() {
        return this.zzagB;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public String zzpb() {
        return this.zzagB;
    }
}

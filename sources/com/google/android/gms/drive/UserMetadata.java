package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UserMetadata implements SafeParcelable {
    public static final Parcelable.Creator<UserMetadata> CREATOR = new zzl();
    final int mVersionCode;
    final String zzWQ;
    final String zzaps;
    final String zzapt;
    final boolean zzapu;
    final String zzapv;

    UserMetadata(int i, String str, String str2, String str3, boolean z, String str4) {
        this.mVersionCode = i;
        this.zzaps = str;
        this.zzWQ = str2;
        this.zzapt = str3;
        this.zzapu = z;
        this.zzapv = str4;
    }

    public UserMetadata(String str, String str2, String str3, boolean z, String str4) {
        this(1, str, str2, str3, z, str4);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("Permission ID: '%s', Display Name: '%s', Picture URL: '%s', Authenticated User: %b, Email: '%s'", new Object[]{this.zzaps, this.zzWQ, this.zzapt, Boolean.valueOf(this.zzapu), this.zzapv});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }
}

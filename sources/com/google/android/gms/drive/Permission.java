package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class Permission implements SafeParcelable {
    public static final Parcelable.Creator<Permission> CREATOR = new zzj();
    final int mVersionCode;
    private String zzapk;
    private int zzapl;
    private String zzapm;
    private String zzapn;
    private int zzapo;
    private boolean zzapp;

    Permission(int i, String str, int i2, String str2, String str3, int i3, boolean z) {
        this.mVersionCode = i;
        this.zzapk = str;
        this.zzapl = i2;
        this.zzapm = str2;
        this.zzapn = str3;
        this.zzapo = i3;
        this.zzapp = z;
    }

    public static boolean zzcA(int i) {
        return i == 0 || i == 1 || i == 2 || i == 3;
    }

    public static boolean zzcz(int i) {
        switch (i) {
            case 256:
            case 257:
            case 258:
                return true;
            default:
                return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Permission permission = (Permission) obj;
        return zzw.equal(this.zzapk, permission.zzapk) && this.zzapl == permission.zzapl && this.zzapo == permission.zzapo && this.zzapp == permission.zzapp;
    }

    public int getRole() {
        if (!zzcA(this.zzapo)) {
            return -1;
        }
        return this.zzapo;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzapk, Integer.valueOf(this.zzapl), Integer.valueOf(this.zzapo), Boolean.valueOf(this.zzapp));
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    public String zzsO() {
        if (!zzcz(this.zzapl)) {
            return null;
        }
        return this.zzapk;
    }

    public int zzsP() {
        if (!zzcz(this.zzapl)) {
            return -1;
        }
        return this.zzapl;
    }

    public String zzsQ() {
        return this.zzapm;
    }

    public String zzsR() {
        return this.zzapn;
    }

    public boolean zzsS() {
        return this.zzapp;
    }
}

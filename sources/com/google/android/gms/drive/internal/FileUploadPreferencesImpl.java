package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.FileUploadPreferences;

public final class FileUploadPreferencesImpl implements SafeParcelable, FileUploadPreferences {
    public static final Parcelable.Creator<FileUploadPreferencesImpl> CREATOR = new zzag();
    final int mVersionCode;
    int zzarG;
    int zzarH;
    boolean zzarI;

    FileUploadPreferencesImpl(int i, int i2, int i3, boolean z) {
        this.mVersionCode = i;
        this.zzarG = i2;
        this.zzarH = i3;
        this.zzarI = z;
    }

    public static boolean zzdj(int i) {
        return i == 1 || i == 2;
    }

    public static boolean zzdk(int i) {
        return i == 256 || i == 257;
    }

    public int describeContents() {
        return 0;
    }

    public int getBatteryUsagePreference() {
        if (!zzdk(this.zzarH)) {
            return 0;
        }
        return this.zzarH;
    }

    public int getNetworkTypePreference() {
        if (!zzdj(this.zzarG)) {
            return 0;
        }
        return this.zzarG;
    }

    public boolean isRoamingAllowed() {
        return this.zzarI;
    }

    public void setBatteryUsagePreference(int i) {
        if (zzdk(i)) {
            this.zzarH = i;
            return;
        }
        throw new IllegalArgumentException("Invalid battery usage preference value.");
    }

    public void setNetworkTypePreference(int i) {
        if (zzdj(i)) {
            this.zzarG = i;
            return;
        }
        throw new IllegalArgumentException("Invalid data connection preference value.");
    }

    public void setRoamingAllowed(boolean z) {
        this.zzarI = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzag.zza(this, parcel, i);
    }
}

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDeviceUsagePreferenceResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnDeviceUsagePreferenceResponse> CREATOR = new zzax();
    final int mVersionCode;
    final FileUploadPreferencesImpl zzasg;

    OnDeviceUsagePreferenceResponse(int i, FileUploadPreferencesImpl fileUploadPreferencesImpl) {
        this.mVersionCode = i;
        this.zzasg = fileUploadPreferencesImpl;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzax.zza(this, parcel, i);
    }

    public FileUploadPreferencesImpl zztp() {
        return this.zzasg;
    }
}

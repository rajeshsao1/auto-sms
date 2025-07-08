package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SetFileUploadPreferencesRequest implements SafeParcelable {
    public static final Parcelable.Creator<SetFileUploadPreferencesRequest> CREATOR = new zzbr();
    final int mVersionCode;
    final FileUploadPreferencesImpl zzasg;

    SetFileUploadPreferencesRequest(int i, FileUploadPreferencesImpl fileUploadPreferencesImpl) {
        this.mVersionCode = i;
        this.zzasg = fileUploadPreferencesImpl;
    }

    public SetFileUploadPreferencesRequest(FileUploadPreferencesImpl fileUploadPreferencesImpl) {
        this(1, fileUploadPreferencesImpl);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbr.zza(this, parcel, i);
    }
}

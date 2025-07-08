package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzq;

public class DriveServiceResponse implements SafeParcelable {
    public static final Parcelable.Creator<DriveServiceResponse> CREATOR = new zzad();
    final int mVersionCode;
    final IBinder zzarB;

    DriveServiceResponse(int i, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzarB = iBinder;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzad.zza(this, parcel, i);
    }

    public zzq zztj() {
        return zzq.zza.zzaQ(this.zzarB);
    }
}

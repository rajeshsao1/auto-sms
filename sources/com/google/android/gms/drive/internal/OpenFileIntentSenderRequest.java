package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

public class OpenFileIntentSenderRequest implements SafeParcelable {
    public static final Parcelable.Creator<OpenFileIntentSenderRequest> CREATOR = new zzbm();
    final int mVersionCode;
    final String zzapg;
    final String[] zzaph;
    final DriveId zzapj;
    final FilterHolder zzasz;

    OpenFileIntentSenderRequest(int i, String str, String[] strArr, DriveId driveId, FilterHolder filterHolder) {
        this.mVersionCode = i;
        this.zzapg = str;
        this.zzaph = strArr;
        this.zzapj = driveId;
        this.zzasz = filterHolder;
    }

    public OpenFileIntentSenderRequest(String str, String[] strArr, DriveId driveId, FilterHolder filterHolder) {
        this(1, str, strArr, driveId, filterHolder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbm.zza(this, parcel, i);
    }
}

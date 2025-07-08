package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzp;

public class ResolveAccountResponse implements SafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new zzz();
    final int mVersionCode;
    private boolean zzahx;
    IBinder zzakA;
    private ConnectionResult zzams;
    private boolean zzamt;

    ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.mVersionCode = i;
        this.zzakA = iBinder;
        this.zzams = connectionResult;
        this.zzahx = z;
        this.zzamt = z2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.zzams.equals(resolveAccountResponse.zzams) && zzqX().equals(resolveAccountResponse.zzqX());
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzz.zza(this, parcel, i);
    }

    public zzp zzqX() {
        return zzp.zza.zzaP(this.zzakA);
    }

    public ConnectionResult zzqY() {
        return this.zzams;
    }

    public boolean zzqZ() {
        return this.zzahx;
    }

    public boolean zzra() {
        return this.zzamt;
    }
}

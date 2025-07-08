package com.google.android.gms.signin.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SignInResponse implements SafeParcelable {
    public static final Parcelable.Creator<SignInResponse> CREATOR = new zzj();
    final int mVersionCode;
    private final ConnectionResult zzams;
    private final ResolveAccountResponse zzbhk;

    public SignInResponse(int i) {
        this(new ConnectionResult(i, (PendingIntent) null), (ResolveAccountResponse) null);
    }

    SignInResponse(int i, ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this.mVersionCode = i;
        this.zzams = connectionResult;
        this.zzbhk = resolveAccountResponse;
    }

    public SignInResponse(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, resolveAccountResponse);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    public ResolveAccountResponse zzFP() {
        return this.zzbhk;
    }

    public ConnectionResult zzqY() {
        return this.zzams;
    }
}

package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;

public class zzc implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public final Api<?> zzagT;
    private final int zzagU;
    private zzl zzagV;

    public zzc(Api<?> api, int i) {
        this.zzagT = api;
        this.zzagU = i;
    }

    private void zzpi() {
        zzx.zzb(this.zzagV, (Object) "Callbacks must be attached to a GoogleApiClient instance before connecting the client.");
    }

    public void onConnected(Bundle bundle) {
        zzpi();
        this.zzagV.onConnected(bundle);
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        zzpi();
        this.zzagV.zza(connectionResult, this.zzagT, this.zzagU);
    }

    public void onConnectionSuspended(int i) {
        zzpi();
        this.zzagV.onConnectionSuspended(i);
    }

    public void zza(zzl zzl) {
        this.zzagV = zzl;
    }
}

package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzqu;

public class zzd implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private final zzqu.zza zzbdJ;
    private boolean zzbdK = true;
    private zzf zzbdy = null;

    public zzd(zzqu.zza zza) {
        this.zzbdJ = zza;
    }

    public void onConnected(Bundle bundle) {
        zzqu.zza zza;
        this.zzbdy.zzau(false);
        if (this.zzbdK && (zza = this.zzbdJ) != null) {
            zza.zzES();
        }
        this.zzbdK = false;
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzbdy.zzau(true);
        if (this.zzbdK && this.zzbdJ != null) {
            if (connectionResult.hasResolution()) {
                this.zzbdJ.zzc(connectionResult.getResolution());
            } else {
                this.zzbdJ.zzET();
            }
        }
        this.zzbdK = false;
    }

    public void onConnectionSuspended(int i) {
        this.zzbdy.zzau(true);
    }

    public void zza(zzf zzf) {
        this.zzbdy = zzf;
    }

    public void zzat(boolean z) {
        this.zzbdK = z;
    }
}

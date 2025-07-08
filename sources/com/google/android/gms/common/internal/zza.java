package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.zze;

public class zza extends zzp.zza {
    private Context mContext;
    private Account zzTI;
    int zzakz;

    public static Account zza(zzp zzp) {
        if (zzp != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzp.getAccount();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zza)) {
            return false;
        }
        return this.zzTI.equals(((zza) obj).zzTI);
    }

    public Account getAccount() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.zzakz) {
            return this.zzTI;
        }
        if (zze.zzf(this.mContext, callingUid)) {
            this.zzakz = callingUid;
            return this.zzTI;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }
}

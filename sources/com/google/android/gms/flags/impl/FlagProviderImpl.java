package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.flags.impl.zza;
import com.google.android.gms.internal.zzpk;

public class FlagProviderImpl extends zzpk.zza {
    private boolean zzqA = false;
    private SharedPreferences zzvx;

    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return zza.C0032zza.zza(this.zzvx, str, Boolean.valueOf(z)).booleanValue();
    }

    public int getIntFlagValue(String str, int i, int i2) {
        return zza.zzb.zza(this.zzvx, str, Integer.valueOf(i)).intValue();
    }

    public long getLongFlagValue(String str, long j, int i) {
        return zza.zzc.zza(this.zzvx, str, Long.valueOf(j)).longValue();
    }

    public String getStringFlagValue(String str, String str2, int i) {
        return zza.zzd.zza(this.zzvx, str, str2);
    }

    public void init(zzd zzd) {
        Context context = (Context) zze.zzp(zzd);
        if (!this.zzqA) {
            try {
                this.zzvx = zzb.zzw(context.createPackageContext("com.google.android.gms", 0));
                this.zzqA = true;
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
    }
}

package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zza;

public class zzf extends zza<Integer> {
    public zzf(String str, int i) {
        super(str, i);
    }

    /* access modifiers changed from: protected */
    public void zza(Bundle bundle, Integer num) {
        bundle.putInt(getName(), num.intValue());
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzg */
    public Integer zzc(DataHolder dataHolder, int i, int i2) {
        return Integer.valueOf(dataHolder.zzc(getName(), i, i2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzq */
    public Integer zzn(Bundle bundle) {
        return Integer.valueOf(bundle.getInt(getName()));
    }
}

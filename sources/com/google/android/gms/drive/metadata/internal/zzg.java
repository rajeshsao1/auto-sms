package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zza;

public class zzg extends zza<Long> {
    public zzg(String str, int i) {
        super(str, i);
    }

    /* access modifiers changed from: protected */
    public void zza(Bundle bundle, Long l) {
        bundle.putLong(getName(), l.longValue());
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzh */
    public Long zzc(DataHolder dataHolder, int i, int i2) {
        return Long.valueOf(dataHolder.zzb(getName(), i, i2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzr */
    public Long zzn(Bundle bundle) {
        return Long.valueOf(bundle.getLong(getName()));
    }
}

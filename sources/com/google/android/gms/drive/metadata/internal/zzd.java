package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import java.util.Date;

public class zzd extends com.google.android.gms.drive.metadata.zzd<Date> {
    public zzd(String str, int i) {
        super(str, i);
    }

    /* access modifiers changed from: protected */
    public void zza(Bundle bundle, Date date) {
        bundle.putLong(getName(), date.getTime());
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzf */
    public Date zzc(DataHolder dataHolder, int i, int i2) {
        return new Date(dataHolder.zzb(getName(), i, i2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzp */
    public Date zzn(Bundle bundle) {
        return new Date(bundle.getLong(getName()));
    }
}

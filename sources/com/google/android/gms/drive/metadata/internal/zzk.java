package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.zza;
import java.util.Collection;

public abstract class zzk<T extends Parcelable> extends zza<T> {
    public zzk(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    /* access modifiers changed from: protected */
    public void zza(Bundle bundle, T t) {
        bundle.putParcelable(getName(), t);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzt */
    public T zzn(Bundle bundle) {
        return bundle.getParcelable(getName());
    }
}

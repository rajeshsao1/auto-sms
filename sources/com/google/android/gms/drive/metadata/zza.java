package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class zza<T> implements MetadataField<T> {
    private final String zzasF;
    private final Set<String> zzasG;
    private final Set<String> zzasH;
    private final int zzasI;

    protected zza(String str, int i) {
        this.zzasF = (String) zzx.zzb(str, (Object) "fieldName");
        this.zzasG = Collections.singleton(str);
        this.zzasH = Collections.emptySet();
        this.zzasI = i;
    }

    protected zza(String str, Collection<String> collection, Collection<String> collection2, int i) {
        this.zzasF = (String) zzx.zzb(str, (Object) "fieldName");
        this.zzasG = Collections.unmodifiableSet(new HashSet(collection));
        this.zzasH = Collections.unmodifiableSet(new HashSet(collection2));
        this.zzasI = i;
    }

    public final String getName() {
        return this.zzasF;
    }

    public String toString() {
        return this.zzasF;
    }

    public final T zza(DataHolder dataHolder, int i, int i2) {
        if (zzb(dataHolder, i, i2)) {
            return zzc(dataHolder, i, i2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract void zza(Bundle bundle, T t);

    public final void zza(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2) {
        zzx.zzb(dataHolder, (Object) "dataHolder");
        zzx.zzb(metadataBundle, (Object) "bundle");
        if (zzb(dataHolder, i, i2)) {
            metadataBundle.zzc(this, zzc(dataHolder, i, i2));
        }
    }

    public final void zza(T t, Bundle bundle) {
        zzx.zzb(bundle, (Object) "bundle");
        if (t == null) {
            bundle.putString(getName(), (String) null);
        } else {
            zza(bundle, t);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x000c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean zzb(com.google.android.gms.common.data.DataHolder r4, int r5, int r6) {
        /*
            r3 = this;
            java.util.Set<java.lang.String> r0 = r3.zzasG
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0020
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            boolean r2 = r4.zzcz(r1)
            if (r2 == 0) goto L_0x001e
            boolean r1 = r4.zzi(r1, r5, r6)
            if (r1 == 0) goto L_0x0006
        L_0x001e:
            r4 = 0
            return r4
        L_0x0020:
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.drive.metadata.zza.zzb(com.google.android.gms.common.data.DataHolder, int, int):boolean");
    }

    /* access modifiers changed from: protected */
    public abstract T zzc(DataHolder dataHolder, int i, int i2);

    public final T zzm(Bundle bundle) {
        zzx.zzb(bundle, (Object) "bundle");
        if (bundle.get(getName()) != null) {
            return zzn(bundle);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract T zzn(Bundle bundle);

    public final Collection<String> zzty() {
        return this.zzasG;
    }
}

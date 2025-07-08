package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zznm;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class MetadataBundle implements SafeParcelable {
    public static final Parcelable.Creator<MetadataBundle> CREATOR = new zzh();
    final int mVersionCode;
    final Bundle zzasQ;

    MetadataBundle(int i, Bundle bundle) {
        this.mVersionCode = i;
        Bundle bundle2 = (Bundle) zzx.zzz(bundle);
        this.zzasQ = bundle2;
        bundle2.setClassLoader(getClass().getClassLoader());
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : bundle2.keySet()) {
            if (zze.zzdc(str) == null) {
                arrayList.add(str);
                zzz.zzz("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
            }
        }
        for (String remove : arrayList) {
            this.zzasQ.remove(remove);
        }
    }

    private MetadataBundle(Bundle bundle) {
        this(1, bundle);
    }

    public static <T> MetadataBundle zzb(MetadataField<T> metadataField, T t) {
        MetadataBundle zztE = zztE();
        zztE.zzc(metadataField, t);
        return zztE;
    }

    public static MetadataBundle zztE() {
        return new MetadataBundle(new Bundle());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataBundle)) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> keySet = this.zzasQ.keySet();
        if (!keySet.equals(metadataBundle.zzasQ.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!zzw.equal(this.zzasQ.get(str), metadataBundle.zzasQ.get(str))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (String str : this.zzasQ.keySet()) {
            i = (i * 31) + this.zzasQ.get(str).hashCode();
        }
        return i;
    }

    public void setContext(Context context) {
        BitmapTeleporter bitmapTeleporter = (BitmapTeleporter) zza(zznm.zzatz);
        if (bitmapTeleporter != null) {
            bitmapTeleporter.zzc(context.getCacheDir());
        }
    }

    public String toString() {
        return "MetadataBundle [values=" + this.zzasQ + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public <T> T zza(MetadataField<T> metadataField) {
        return metadataField.zzm(this.zzasQ);
    }

    public <T> void zzc(MetadataField<T> metadataField, T t) {
        if (zze.zzdc(metadataField.getName()) != null) {
            metadataField.zza(t, this.zzasQ);
            return;
        }
        throw new IllegalArgumentException("Unregistered field: " + metadataField.getName());
    }

    public boolean zzc(MetadataField<?> metadataField) {
        return this.zzasQ.containsKey(metadataField.getName());
    }

    public MetadataBundle zztF() {
        return new MetadataBundle(new Bundle(this.zzasQ));
    }

    public Set<MetadataField<?>> zztG() {
        HashSet hashSet = new HashSet();
        for (String zzdc : this.zzasQ.keySet()) {
            hashSet.add(zze.zzdc(zzdc));
        }
        return hashSet;
    }
}

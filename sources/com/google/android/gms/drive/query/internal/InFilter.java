package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.zzb;
import java.util.Collection;
import java.util.Collections;

public class InFilter<T> extends AbstractFilter {
    public static final zzj CREATOR = new zzj();
    final int mVersionCode;
    final MetadataBundle zzauh;
    private final zzb<T> zzauu;

    InFilter(int i, MetadataBundle metadataBundle) {
        this.mVersionCode = i;
        this.zzauh = metadataBundle;
        this.zzauu = (zzb) zze.zza(metadataBundle);
    }

    public InFilter(SearchableCollectionMetadataField<T> searchableCollectionMetadataField, T t) {
        this(1, MetadataBundle.zzb(searchableCollectionMetadataField, Collections.singleton(t)));
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return ((Collection) this.zzauh.zza(this.zzauu)).iterator().next();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    public <F> F zza(zzf<F> zzf) {
        return zzf.zzb(this.zzauu, getValue());
    }
}

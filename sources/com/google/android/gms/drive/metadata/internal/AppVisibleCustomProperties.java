package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties implements SafeParcelable, Iterable<CustomProperty> {
    public static final Parcelable.Creator<AppVisibleCustomProperties> CREATOR = new zza();
    public static final AppVisibleCustomProperties zzasK = new zza().zztA();
    final int mVersionCode;
    final List<CustomProperty> zzasL;

    public static class zza {
        private final Map<CustomPropertyKey, CustomProperty> zzasM = new HashMap();

        public zza zza(CustomPropertyKey customPropertyKey, String str) {
            zzx.zzb(customPropertyKey, (Object) "key");
            this.zzasM.put(customPropertyKey, new CustomProperty(customPropertyKey, str));
            return this;
        }

        public zza zza(CustomProperty customProperty) {
            zzx.zzb(customProperty, (Object) "property");
            this.zzasM.put(customProperty.zztB(), customProperty);
            return this;
        }

        public AppVisibleCustomProperties zztA() {
            return new AppVisibleCustomProperties((Collection) this.zzasM.values());
        }
    }

    AppVisibleCustomProperties(int i, Collection<CustomProperty> collection) {
        this.mVersionCode = i;
        zzx.zzz(collection);
        this.zzasL = new ArrayList(collection);
    }

    private AppVisibleCustomProperties(Collection<CustomProperty> collection) {
        this(1, collection);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return zztz().equals(((AppVisibleCustomProperties) obj).zztz());
    }

    public int hashCode() {
        return zzw.hashCode(this.zzasL);
    }

    public Iterator<CustomProperty> iterator() {
        return this.zzasL.iterator();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public Map<CustomPropertyKey, String> zztz() {
        HashMap hashMap = new HashMap(this.zzasL.size());
        for (CustomProperty next : this.zzasL) {
            hashMap.put(next.zztB(), next.getValue());
        }
        return Collections.unmodifiableMap(hashMap);
    }
}

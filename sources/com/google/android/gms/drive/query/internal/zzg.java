package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import com.google.android.gms.drive.query.Filter;
import java.util.List;

public class zzg implements zzf<Boolean> {
    private Boolean zzaut = false;

    private zzg() {
    }

    public static boolean zza(Filter filter) {
        if (filter == null) {
            return false;
        }
        return ((Boolean) filter.zza(new zzg())).booleanValue();
    }

    /* renamed from: zzc */
    public <T> Boolean zzb(zzb<T> zzb, T t) {
        return this.zzaut;
    }

    /* renamed from: zzc */
    public <T> Boolean zzb(Operator operator, MetadataField<T> metadataField, T t) {
        return this.zzaut;
    }

    /* renamed from: zzc */
    public Boolean zzb(Operator operator, List<Boolean> list) {
        return this.zzaut;
    }

    /* renamed from: zzd */
    public Boolean zzB(Boolean bool) {
        return this.zzaut;
    }

    /* renamed from: zzdk */
    public Boolean zzdj(String str) {
        if (!str.isEmpty()) {
            this.zzaut = true;
        }
        return this.zzaut;
    }

    /* renamed from: zzf */
    public Boolean zze(MetadataField<?> metadataField) {
        return this.zzaut;
    }

    /* renamed from: zzf */
    public <T> Boolean zze(MetadataField<T> metadataField, T t) {
        return this.zzaut;
    }

    /* renamed from: zztR */
    public Boolean zztQ() {
        return this.zzaut;
    }

    /* renamed from: zztS */
    public Boolean zztP() {
        return this.zzaut;
    }
}

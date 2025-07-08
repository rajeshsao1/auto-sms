package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.zzf;
import java.util.List;

public class zzc implements zzf<String> {
    /* renamed from: zza */
    public <T> String zzb(zzb<T> zzb, T t) {
        return String.format("contains(%s,%s)", new Object[]{zzb.getName(), t});
    }

    /* renamed from: zza */
    public <T> String zzb(Operator operator, MetadataField<T> metadataField, T t) {
        return String.format("cmp(%s,%s,%s)", new Object[]{operator.getTag(), metadataField.getName(), t});
    }

    /* renamed from: zza */
    public String zzb(Operator operator, List<String> list) {
        StringBuilder sb = new StringBuilder(operator.getTag() + "(");
        String str = "";
        for (String append : list) {
            sb.append(str);
            sb.append(append);
            str = ",";
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: zzd */
    public String zze(MetadataField<?> metadataField) {
        return String.format("fieldOnly(%s)", new Object[]{metadataField.getName()});
    }

    /* renamed from: zzd */
    public <T> String zze(MetadataField<T> metadataField, T t) {
        return String.format("has(%s,%s)", new Object[]{metadataField.getName(), t});
    }

    /* renamed from: zzdh */
    public String zzB(String str) {
        return String.format("not(%s)", new Object[]{str});
    }

    /* renamed from: zzdi */
    public String zzdj(String str) {
        return String.format("fullTextSearch(%s)", new Object[]{str});
    }

    /* renamed from: zztN */
    public String zztQ() {
        return "all()";
    }

    /* renamed from: zztO */
    public String zztP() {
        return "ownedByMe()";
    }
}

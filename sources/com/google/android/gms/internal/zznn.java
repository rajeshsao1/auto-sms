package com.google.android.gms.internal;

import android.os.Bundle;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.CustomProperty;
import com.google.android.gms.drive.metadata.internal.zze;
import com.google.android.gms.drive.metadata.internal.zzk;
import java.util.Arrays;

public class zznn extends zzk<AppVisibleCustomProperties> {
    public static final zze.zza zzatL = new zze.zza() {
        public void zzb(DataHolder dataHolder) {
            zznn.zzd(dataHolder);
        }

        public String zztD() {
            return "customPropertiesExtraHolder";
        }
    };

    public zznn(int i) {
        super("customProperties", Arrays.asList(new String[]{"hasCustomProperties", "sqlId"}), Arrays.asList(new String[]{"customPropertiesExtra", "customPropertiesExtraHolder"}), i);
    }

    private static void zzc(DataHolder dataHolder) {
        String str;
        synchronized (dataHolder) {
            DataHolder dataHolder2 = (DataHolder) dataHolder.zzpZ().getParcelable("customPropertiesExtraHolder");
            if (dataHolder2 != null) {
                try {
                    LongSparseArray<AppVisibleCustomProperties.zza> zzf = zzf(dataHolder2);
                    SparseArray sparseArray = new SparseArray();
                    for (int i = 0; i < dataHolder.getCount(); i++) {
                        AppVisibleCustomProperties.zza zza = zzf.get(dataHolder.zzb("sqlId", i, dataHolder.zzbH(i)));
                        if (zza != null) {
                            sparseArray.append(i, zza.zztA());
                        }
                    }
                    dataHolder.zzpZ().putSparseParcelableArray("customPropertiesExtra", sparseArray);
                } finally {
                    dataHolder2.close();
                    str = "customPropertiesExtraHolder";
                    dataHolder.zzpZ().remove(str);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static void zzd(DataHolder dataHolder) {
        Bundle zzpZ = dataHolder.zzpZ();
        if (zzpZ != null) {
            synchronized (dataHolder) {
                DataHolder dataHolder2 = (DataHolder) zzpZ.getParcelable("customPropertiesExtraHolder");
                if (dataHolder2 != null) {
                    dataHolder2.close();
                    zzpZ.remove("customPropertiesExtraHolder");
                }
            }
        }
    }

    private static LongSparseArray<AppVisibleCustomProperties.zza> zzf(DataHolder dataHolder) {
        Bundle zzpZ = dataHolder.zzpZ();
        String string = zzpZ.getString("entryIdColumn");
        String string2 = zzpZ.getString("keyColumn");
        String string3 = zzpZ.getString("visibilityColumn");
        String string4 = zzpZ.getString("valueColumn");
        LongSparseArray<AppVisibleCustomProperties.zza> longSparseArray = new LongSparseArray<>();
        for (int i = 0; i < dataHolder.getCount(); i++) {
            int zzbH = dataHolder.zzbH(i);
            long zzb = dataHolder.zzb(string, i, zzbH);
            String zzd = dataHolder.zzd(string2, i, zzbH);
            int zzc = dataHolder.zzc(string3, i, zzbH);
            CustomProperty customProperty = new CustomProperty(new CustomPropertyKey(zzd, zzc), dataHolder.zzd(string4, i, zzbH));
            AppVisibleCustomProperties.zza zza = longSparseArray.get(zzb);
            if (zza == null) {
                zza = new AppVisibleCustomProperties.zza();
                longSparseArray.put(zzb, zza);
            }
            zza.zza(customProperty);
        }
        return longSparseArray;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzl */
    public AppVisibleCustomProperties zzc(DataHolder dataHolder, int i, int i2) {
        Bundle zzpZ = dataHolder.zzpZ();
        SparseArray sparseParcelableArray = zzpZ.getSparseParcelableArray("customPropertiesExtra");
        if (sparseParcelableArray == null) {
            if (zzpZ.getParcelable("customPropertiesExtraHolder") != null) {
                zzc(dataHolder);
                sparseParcelableArray = zzpZ.getSparseParcelableArray("customPropertiesExtra");
            }
            if (sparseParcelableArray == null) {
                return AppVisibleCustomProperties.zzasK;
            }
        }
        return (AppVisibleCustomProperties) sparseParcelableArray.get(i, AppVisibleCustomProperties.zzasK);
    }
}

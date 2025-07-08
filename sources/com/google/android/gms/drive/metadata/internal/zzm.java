package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.zze;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class zzm extends zzj<DriveId> implements SearchableCollectionMetadataField<DriveId> {
    public static final zze.zza zzasT = new zze.zza() {
        public void zzb(DataHolder dataHolder) {
            zzm.zzd(dataHolder);
        }

        public String zztD() {
            return "parentsExtraHolder";
        }
    };

    public zzm(int i) {
        super("parents", Collections.emptySet(), Arrays.asList(new String[]{"parentsExtra", "dbInstanceId", "parentsExtraHolder"}), i);
    }

    private void zzc(DataHolder dataHolder) {
        String str;
        synchronized (dataHolder) {
            DataHolder dataHolder2 = (DataHolder) dataHolder.zzpZ().getParcelable("parentsExtraHolder");
            if (dataHolder2 != null) {
                try {
                    int count = dataHolder.getCount();
                    ArrayList arrayList = new ArrayList(count);
                    HashMap hashMap = new HashMap(count);
                    for (int i = 0; i < count; i++) {
                        int zzbH = dataHolder.zzbH(i);
                        ParentDriveIdSet parentDriveIdSet = new ParentDriveIdSet();
                        arrayList.add(parentDriveIdSet);
                        hashMap.put(Long.valueOf(dataHolder.zzb("sqlId", i, zzbH)), parentDriveIdSet);
                    }
                    Bundle zzpZ = dataHolder2.zzpZ();
                    String string = zzpZ.getString("childSqlIdColumn");
                    String string2 = zzpZ.getString("parentSqlIdColumn");
                    String string3 = zzpZ.getString("parentResIdColumn");
                    int count2 = dataHolder2.getCount();
                    for (int i2 = 0; i2 < count2; i2++) {
                        int zzbH2 = dataHolder2.zzbH(i2);
                        ((ParentDriveIdSet) hashMap.get(Long.valueOf(dataHolder2.zzb(string, i2, zzbH2)))).zza(new PartialDriveId(dataHolder2.zzd(string3, i2, zzbH2), dataHolder2.zzb(string2, i2, zzbH2), 1));
                    }
                    dataHolder.zzpZ().putParcelableArrayList("parentsExtra", arrayList);
                } finally {
                    dataHolder2.close();
                    str = "parentsExtraHolder";
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
                DataHolder dataHolder2 = (DataHolder) zzpZ.getParcelable("parentsExtraHolder");
                if (dataHolder2 != null) {
                    dataHolder2.close();
                    zzpZ.remove("parentsExtraHolder");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzd */
    public Collection<DriveId> zzc(DataHolder dataHolder, int i, int i2) {
        Bundle zzpZ = dataHolder.zzpZ();
        ArrayList parcelableArrayList = zzpZ.getParcelableArrayList("parentsExtra");
        if (parcelableArrayList == null) {
            if (zzpZ.getParcelable("parentsExtraHolder") != null) {
                zzc(dataHolder);
                parcelableArrayList = zzpZ.getParcelableArrayList("parentsExtra");
            }
            if (parcelableArrayList == null) {
                return null;
            }
        }
        return ((ParentDriveIdSet) parcelableArrayList.get(i)).zzD(zzpZ.getLong("dbInstanceId"));
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzs */
    public Collection<DriveId> zzn(Bundle bundle) {
        Collection zzs = super.zzn(bundle);
        if (zzs == null) {
            return null;
        }
        return new HashSet(zzs);
    }
}

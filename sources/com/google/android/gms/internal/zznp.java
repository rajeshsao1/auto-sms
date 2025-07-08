package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.zzk;
import java.util.Arrays;

public class zznp extends zzk<DriveId> {
    public static final zznp zzatS = new zznp();

    private zznp() {
        super("driveId", Arrays.asList(new String[]{"sqlId", "resourceId", "mimeType"}), Arrays.asList(new String[]{"dbInstanceId"}), 4100000);
    }

    /* access modifiers changed from: protected */
    public boolean zzb(DataHolder dataHolder, int i, int i2) {
        for (String zzcz : zzty()) {
            if (!dataHolder.zzcz(zzcz)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzm */
    public DriveId zzc(DataHolder dataHolder, int i, int i2) {
        long j = dataHolder.zzpZ().getLong("dbInstanceId");
        boolean equals = DriveFolder.MIME_TYPE.equals(dataHolder.zzd(zznm.zzatr.getName(), i, i2));
        String zzd = dataHolder.zzd("resourceId", i, i2);
        return new DriveId("generated-android-null".equals(zzd) ? null : zzd, Long.valueOf(dataHolder.zzb("sqlId", i, i2)).longValue(), j, equals ? 1 : 0);
    }
}

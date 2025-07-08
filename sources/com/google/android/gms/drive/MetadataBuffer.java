package com.google.android.gms.drive;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.zzp;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.zze;
import com.google.android.gms.internal.zznm;

public final class MetadataBuffer extends AbstractDataBuffer<Metadata> {
    private zza zzapb;

    private static class zza extends Metadata {
        private final DataHolder zzahi;
        private final int zzajf;
        /* access modifiers changed from: private */
        public final int zzapc;

        public zza(DataHolder dataHolder, int i) {
            this.zzahi = dataHolder;
            this.zzapc = i;
            this.zzajf = dataHolder.zzbH(i);
        }

        public boolean isDataValid() {
            return !this.zzahi.isClosed();
        }

        public <T> T zza(MetadataField<T> metadataField) {
            return metadataField.zza(this.zzahi, this.zzapc, this.zzajf);
        }

        /* renamed from: zzsK */
        public Metadata freeze() {
            MetadataBundle zztE = MetadataBundle.zztE();
            for (MetadataField<BitmapTeleporter> next : zze.zztC()) {
                if (next != zznm.zzatz) {
                    next.zza(this.zzahi, zztE, this.zzapc, this.zzajf);
                }
            }
            return new zzp(zztE);
        }
    }

    public MetadataBuffer(DataHolder dataHolder) {
        super(dataHolder);
        dataHolder.zzpZ().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    public Metadata get(int i) {
        zza zza2 = this.zzapb;
        if (zza2 != null && zza2.zzapc == i) {
            return zza2;
        }
        zza zza3 = new zza(this.zzahi, i);
        this.zzapb = zza3;
        return zza3;
    }

    @Deprecated
    public String getNextPageToken() {
        return null;
    }

    public void release() {
        if (this.zzahi != null) {
            zze.zza(this.zzahi);
        }
        super.release();
    }
}

package com.google.android.gms.drive.events.internal;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.events.zzh;
import com.google.android.gms.drive.events.zzj;

public class zza implements zzh {
    private final zzj zzapV;
    private final long zzapW;
    private final long zzapX;

    public zza(TransferProgressData transferProgressData) {
        this.zzapV = new zzb(transferProgressData);
        this.zzapW = transferProgressData.getBytesTransferred();
        this.zzapX = transferProgressData.getTotalBytes();
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zza zza = (zza) obj;
        return zzw.equal(this.zzapV, zza.zzapV) && this.zzapW == zza.zzapW && this.zzapX == zza.zzapX;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzapX), Long.valueOf(this.zzapW), Long.valueOf(this.zzapX));
    }

    public String toString() {
        return String.format("FileTransferProgress[FileTransferState: %s, BytesTransferred: %d, TotalBytes: %d]", new Object[]{this.zzapV.toString(), Long.valueOf(this.zzapW), Long.valueOf(this.zzapX)});
    }
}

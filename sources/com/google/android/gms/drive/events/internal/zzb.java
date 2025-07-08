package com.google.android.gms.drive.events.internal;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.zzj;

public class zzb implements zzj {
    private final int zzBc;
    private final DriveId zzaoz;
    private final int zzapT;

    public zzb(TransferProgressData transferProgressData) {
        this.zzaoz = transferProgressData.getDriveId();
        this.zzapT = transferProgressData.zztb();
        this.zzBc = transferProgressData.getStatus();
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzb zzb = (zzb) obj;
        return zzw.equal(this.zzaoz, zzb.zzaoz) && this.zzapT == zzb.zzapT && this.zzBc == zzb.zzBc;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaoz, Integer.valueOf(this.zzapT), Integer.valueOf(this.zzBc));
    }

    public String toString() {
        return String.format("FileTransferState[TransferType: %d, DriveId: %s, status: %d]", new Object[]{Integer.valueOf(this.zzapT), this.zzaoz, Integer.valueOf(this.zzBc)});
    }
}

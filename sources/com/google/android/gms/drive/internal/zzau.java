package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso;
import java.io.IOException;

public final class zzau extends zzso<zzau> {
    public long zzarW;
    public long zzarZ;

    public zzau() {
        zztm();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzau)) {
            return false;
        }
        zzau zzau = (zzau) obj;
        if (this.zzarZ == zzau.zzarZ && this.zzarW == zzau.zzarW) {
            return (this.zzbuj == null || this.zzbuj.isEmpty()) ? zzau.zzbuj == null || zzau.zzbuj.isEmpty() : this.zzbuj.equals(zzau.zzbuj);
        }
        return false;
    }

    public int hashCode() {
        long j = this.zzarZ;
        long j2 = this.zzarW;
        return ((((((527 + getClass().getName().hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode());
    }

    public void writeTo(zzsn zzsn) throws IOException {
        zzsn.zzc(1, this.zzarZ);
        zzsn.zzc(2, this.zzarW);
        super.writeTo(zzsn);
    }

    /* renamed from: zzn */
    public zzau mergeFrom(zzsm zzsm) throws IOException {
        while (true) {
            int zzIX = zzsm.zzIX();
            if (zzIX == 0) {
                return this;
            }
            if (zzIX == 8) {
                this.zzarZ = zzsm.zzJe();
            } else if (zzIX == 16) {
                this.zzarW = zzsm.zzJe();
            } else if (!zza(zzsm, zzIX)) {
                return this;
            }
        }
    }

    public zzau zztm() {
        this.zzarZ = -1;
        this.zzarW = -1;
        this.zzbuj = null;
        this.zzbuu = -1;
        return this;
    }

    /* access modifiers changed from: protected */
    public int zzz() {
        return super.zzz() + zzsn.zze(1, this.zzarZ) + zzsn.zze(2, this.zzarW);
    }
}

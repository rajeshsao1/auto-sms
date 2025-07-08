package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso;
import java.io.IOException;

public final class zzas extends zzso<zzas> {
    public int versionCode;
    public long zzarV;
    public long zzarW;
    public long zzarX;

    public zzas() {
        zztk();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzas)) {
            return false;
        }
        zzas zzas = (zzas) obj;
        if (this.versionCode == zzas.versionCode && this.zzarV == zzas.zzarV && this.zzarW == zzas.zzarW && this.zzarX == zzas.zzarX) {
            return (this.zzbuj == null || this.zzbuj.isEmpty()) ? zzas.zzbuj == null || zzas.zzbuj.isEmpty() : this.zzbuj.equals(zzas.zzbuj);
        }
        return false;
    }

    public int hashCode() {
        long j = this.zzarV;
        long j2 = this.zzarW;
        long j3 = this.zzarX;
        return ((((((((((527 + getClass().getName().hashCode()) * 31) + this.versionCode) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode());
    }

    public void writeTo(zzsn zzsn) throws IOException {
        zzsn.zzA(1, this.versionCode);
        zzsn.zzc(2, this.zzarV);
        zzsn.zzc(3, this.zzarW);
        zzsn.zzc(4, this.zzarX);
        super.writeTo(zzsn);
    }

    /* renamed from: zzl */
    public zzas mergeFrom(zzsm zzsm) throws IOException {
        while (true) {
            int zzIX = zzsm.zzIX();
            if (zzIX == 0) {
                return this;
            }
            if (zzIX == 8) {
                this.versionCode = zzsm.zzJb();
            } else if (zzIX == 16) {
                this.zzarV = zzsm.zzJe();
            } else if (zzIX == 24) {
                this.zzarW = zzsm.zzJe();
            } else if (zzIX == 32) {
                this.zzarX = zzsm.zzJe();
            } else if (!zza(zzsm, zzIX)) {
                return this;
            }
        }
    }

    public zzas zztk() {
        this.versionCode = 1;
        this.zzarV = -1;
        this.zzarW = -1;
        this.zzarX = -1;
        this.zzbuj = null;
        this.zzbuu = -1;
        return this;
    }

    /* access modifiers changed from: protected */
    public int zzz() {
        return super.zzz() + zzsn.zzC(1, this.versionCode) + zzsn.zze(2, this.zzarV) + zzsn.zze(3, this.zzarW) + zzsn.zze(4, this.zzarX);
    }
}

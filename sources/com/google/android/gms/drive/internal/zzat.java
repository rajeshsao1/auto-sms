package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso;
import com.google.android.gms.internal.zzst;
import com.google.android.gms.internal.zzsu;
import java.io.IOException;

public final class zzat extends zzso<zzat> {
    public int versionCode;
    public long zzarW;
    public String zzarY;
    public long zzarZ;
    public int zzasa;

    public zzat() {
        zztl();
    }

    public static zzat zzm(byte[] bArr) throws zzst {
        return (zzat) zzsu.mergeFrom(new zzat(), bArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzat)) {
            return false;
        }
        zzat zzat = (zzat) obj;
        if (this.versionCode != zzat.versionCode) {
            return false;
        }
        String str = this.zzarY;
        if (str == null) {
            if (zzat.zzarY != null) {
                return false;
            }
        } else if (!str.equals(zzat.zzarY)) {
            return false;
        }
        if (this.zzarZ == zzat.zzarZ && this.zzarW == zzat.zzarW && this.zzasa == zzat.zzasa) {
            return (this.zzbuj == null || this.zzbuj.isEmpty()) ? zzat.zzbuj == null || zzat.zzbuj.isEmpty() : this.zzbuj.equals(zzat.zzbuj);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((527 + getClass().getName().hashCode()) * 31) + this.versionCode) * 31;
        String str = this.zzarY;
        int i = 0;
        int hashCode2 = str == null ? 0 : str.hashCode();
        long j = this.zzarZ;
        long j2 = this.zzarW;
        int i2 = (((((((hashCode + hashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.zzasa) * 31;
        if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
            i = this.zzbuj.hashCode();
        }
        return i2 + i;
    }

    public void writeTo(zzsn zzsn) throws IOException {
        zzsn.zzA(1, this.versionCode);
        zzsn.zzn(2, this.zzarY);
        zzsn.zzc(3, this.zzarZ);
        zzsn.zzc(4, this.zzarW);
        int i = this.zzasa;
        if (i != -1) {
            zzsn.zzA(5, i);
        }
        super.writeTo(zzsn);
    }

    /* renamed from: zzm */
    public zzat mergeFrom(zzsm zzsm) throws IOException {
        while (true) {
            int zzIX = zzsm.zzIX();
            if (zzIX == 0) {
                return this;
            }
            if (zzIX == 8) {
                this.versionCode = zzsm.zzJb();
            } else if (zzIX == 18) {
                this.zzarY = zzsm.readString();
            } else if (zzIX == 24) {
                this.zzarZ = zzsm.zzJe();
            } else if (zzIX == 32) {
                this.zzarW = zzsm.zzJe();
            } else if (zzIX == 40) {
                this.zzasa = zzsm.zzJb();
            } else if (!zza(zzsm, zzIX)) {
                return this;
            }
        }
    }

    public zzat zztl() {
        this.versionCode = 1;
        this.zzarY = "";
        this.zzarZ = -1;
        this.zzarW = -1;
        this.zzasa = -1;
        this.zzbuj = null;
        this.zzbuu = -1;
        return this;
    }

    /* access modifiers changed from: protected */
    public int zzz() {
        int zzz = super.zzz() + zzsn.zzC(1, this.versionCode) + zzsn.zzo(2, this.zzarY) + zzsn.zze(3, this.zzarZ) + zzsn.zze(4, this.zzarW);
        int i = this.zzasa;
        return i != -1 ? zzz + zzsn.zzC(5, i) : zzz;
    }
}

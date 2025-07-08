package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

final class zzsw {
    final int tag;
    final byte[] zzbuv;

    zzsw(int i, byte[] bArr) {
        this.tag = i;
        this.zzbuv = bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzsw)) {
            return false;
        }
        zzsw zzsw = (zzsw) obj;
        return this.tag == zzsw.tag && Arrays.equals(this.zzbuv, zzsw.zzbuv);
    }

    public int hashCode() {
        return ((527 + this.tag) * 31) + Arrays.hashCode(this.zzbuv);
    }

    /* access modifiers changed from: package-private */
    public void writeTo(zzsn zzsn) throws IOException {
        zzsn.zzmB(this.tag);
        zzsn.zzH(this.zzbuv);
    }

    /* access modifiers changed from: package-private */
    public int zzz() {
        return zzsn.zzmC(this.tag) + 0 + this.zzbuv.length;
    }
}

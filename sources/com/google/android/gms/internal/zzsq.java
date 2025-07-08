package com.google.android.gms.internal;

public final class zzsq implements Cloneable {
    private static final zzsr zzbum = new zzsr();
    private int mSize;
    private boolean zzbun;
    private int[] zzbuo;
    private zzsr[] zzbup;

    zzsq() {
        this(10);
    }

    zzsq(int i) {
        this.zzbun = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzbuo = new int[idealIntArraySize];
        this.zzbup = new zzsr[idealIntArraySize];
        this.mSize = 0;
    }

    private void gc() {
        int i = this.mSize;
        int[] iArr = this.zzbuo;
        zzsr[] zzsrArr = this.zzbup;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            zzsr zzsr = zzsrArr[i3];
            if (zzsr != zzbum) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    zzsrArr[i2] = zzsr;
                    zzsrArr[i3] = null;
                }
                i2++;
            }
        }
        this.zzbun = false;
        this.mSize = i2;
    }

    private int idealByteArraySize(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }

    private int idealIntArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    private boolean zza(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean zza(zzsr[] zzsrArr, zzsr[] zzsrArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!zzsrArr[i2].equals(zzsrArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int zzmH(int i) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.zzbuo[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i2 = i4 - 1;
            }
        }
        return i3 ^ -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzsq)) {
            return false;
        }
        zzsq zzsq = (zzsq) obj;
        return size() == zzsq.size() && zza(this.zzbuo, zzsq.zzbuo, this.mSize) && zza(this.zzbup, zzsq.zzbup, this.mSize);
    }

    public int hashCode() {
        if (this.zzbun) {
            gc();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzbuo[i2]) * 31) + this.zzbup[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /* access modifiers changed from: package-private */
    public int size() {
        if (this.zzbun) {
            gc();
        }
        return this.mSize;
    }

    /* renamed from: zzJq */
    public final zzsq clone() {
        int size = size();
        zzsq zzsq = new zzsq(size);
        System.arraycopy(this.zzbuo, 0, zzsq.zzbuo, 0, size);
        for (int i = 0; i < size; i++) {
            zzsr[] zzsrArr = this.zzbup;
            if (zzsrArr[i] != null) {
                zzsq.zzbup[i] = zzsrArr[i].clone();
            }
        }
        zzsq.mSize = size;
        return zzsq;
    }

    /* access modifiers changed from: package-private */
    public void zza(int i, zzsr zzsr) {
        int zzmH = zzmH(i);
        if (zzmH >= 0) {
            this.zzbup[zzmH] = zzsr;
            return;
        }
        int i2 = zzmH ^ -1;
        int i3 = this.mSize;
        if (i2 < i3) {
            zzsr[] zzsrArr = this.zzbup;
            if (zzsrArr[i2] == zzbum) {
                this.zzbuo[i2] = i;
                zzsrArr[i2] = zzsr;
                return;
            }
        }
        if (this.zzbun && i3 >= this.zzbuo.length) {
            gc();
            i2 = zzmH(i) ^ -1;
        }
        int i4 = this.mSize;
        if (i4 >= this.zzbuo.length) {
            int idealIntArraySize = idealIntArraySize(i4 + 1);
            int[] iArr = new int[idealIntArraySize];
            zzsr[] zzsrArr2 = new zzsr[idealIntArraySize];
            int[] iArr2 = this.zzbuo;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            zzsr[] zzsrArr3 = this.zzbup;
            System.arraycopy(zzsrArr3, 0, zzsrArr2, 0, zzsrArr3.length);
            this.zzbuo = iArr;
            this.zzbup = zzsrArr2;
        }
        int i5 = this.mSize;
        if (i5 - i2 != 0) {
            int[] iArr3 = this.zzbuo;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            zzsr[] zzsrArr4 = this.zzbup;
            System.arraycopy(zzsrArr4, i2, zzsrArr4, i6, this.mSize - i2);
        }
        this.zzbuo[i2] = i;
        this.zzbup[i2] = zzsr;
        this.mSize++;
    }

    /* access modifiers changed from: package-private */
    public zzsr zzmF(int i) {
        int zzmH = zzmH(i);
        if (zzmH < 0) {
            return null;
        }
        zzsr[] zzsrArr = this.zzbup;
        if (zzsrArr[zzmH] == zzbum) {
            return null;
        }
        return zzsrArr[zzmH];
    }

    /* access modifiers changed from: package-private */
    public zzsr zzmG(int i) {
        if (this.zzbun) {
            gc();
        }
        return this.zzbup[i];
    }
}

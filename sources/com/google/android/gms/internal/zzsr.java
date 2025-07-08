package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class zzsr implements Cloneable {
    private zzsp<?, ?> zzbuq;
    private Object zzbur;
    private List<zzsw> zzbus = new ArrayList();

    zzsr() {
    }

    private byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzz()];
        writeTo(zzsn.zzE(bArr));
        return bArr;
    }

    public boolean equals(Object obj) {
        List<zzsw> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzsr)) {
            return false;
        }
        zzsr zzsr = (zzsr) obj;
        if (this.zzbur == null || zzsr.zzbur == null) {
            List<zzsw> list2 = this.zzbus;
            if (list2 != null && (list = zzsr.zzbus) != null) {
                return list2.equals(list);
            }
            try {
                return Arrays.equals(toByteArray(), zzsr.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else {
            zzsp<?, ?> zzsp = this.zzbuq;
            if (zzsp != zzsr.zzbuq) {
                return false;
            }
            if (!zzsp.zzbuk.isArray()) {
                return this.zzbur.equals(zzsr.zzbur);
            }
            Object obj2 = this.zzbur;
            return obj2 instanceof byte[] ? Arrays.equals((byte[]) obj2, (byte[]) zzsr.zzbur) : obj2 instanceof int[] ? Arrays.equals((int[]) obj2, (int[]) zzsr.zzbur) : obj2 instanceof long[] ? Arrays.equals((long[]) obj2, (long[]) zzsr.zzbur) : obj2 instanceof float[] ? Arrays.equals((float[]) obj2, (float[]) zzsr.zzbur) : obj2 instanceof double[] ? Arrays.equals((double[]) obj2, (double[]) zzsr.zzbur) : obj2 instanceof boolean[] ? Arrays.equals((boolean[]) obj2, (boolean[]) zzsr.zzbur) : Arrays.deepEquals((Object[]) obj2, (Object[]) zzsr.zzbur);
        }
    }

    public int hashCode() {
        try {
            return 527 + Arrays.hashCode(toByteArray());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public void writeTo(zzsn zzsn) throws IOException {
        Object obj = this.zzbur;
        if (obj != null) {
            this.zzbuq.zza(obj, zzsn);
            return;
        }
        for (zzsw writeTo : this.zzbus) {
            writeTo.writeTo(zzsn);
        }
    }

    /* renamed from: zzJr */
    public final zzsr clone() {
        Object clone;
        zzsr zzsr = new zzsr();
        try {
            zzsr.zzbuq = this.zzbuq;
            List<zzsw> list = this.zzbus;
            if (list == null) {
                zzsr.zzbus = null;
            } else {
                zzsr.zzbus.addAll(list);
            }
            Object obj = this.zzbur;
            if (obj != null) {
                if (obj instanceof zzsu) {
                    clone = ((zzsu) obj).clone();
                } else if (obj instanceof byte[]) {
                    clone = ((byte[]) obj).clone();
                } else {
                    int i = 0;
                    if (obj instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) obj;
                        byte[][] bArr2 = new byte[bArr.length][];
                        zzsr.zzbur = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (obj instanceof boolean[]) {
                        clone = ((boolean[]) obj).clone();
                    } else if (obj instanceof int[]) {
                        clone = ((int[]) obj).clone();
                    } else if (obj instanceof long[]) {
                        clone = ((long[]) obj).clone();
                    } else if (obj instanceof float[]) {
                        clone = ((float[]) obj).clone();
                    } else if (obj instanceof double[]) {
                        clone = ((double[]) obj).clone();
                    } else if (obj instanceof zzsu[]) {
                        zzsu[] zzsuArr = (zzsu[]) obj;
                        zzsu[] zzsuArr2 = new zzsu[zzsuArr.length];
                        zzsr.zzbur = zzsuArr2;
                        while (i < zzsuArr.length) {
                            zzsuArr2[i] = zzsuArr[i].clone();
                            i++;
                        }
                    }
                }
                zzsr.zzbur = clone;
            }
            return zzsr;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(zzsw zzsw) {
        this.zzbus.add(zzsw);
    }

    /* access modifiers changed from: package-private */
    public <T> T zzb(zzsp<?, T> zzsp) {
        if (this.zzbur == null) {
            this.zzbuq = zzsp;
            this.zzbur = zzsp.zzJ(this.zzbus);
            this.zzbus = null;
        } else if (this.zzbuq != zzsp) {
            throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
        }
        return this.zzbur;
    }

    /* access modifiers changed from: package-private */
    public int zzz() {
        Object obj = this.zzbur;
        if (obj != null) {
            return this.zzbuq.zzY(obj);
        }
        int i = 0;
        for (zzsw zzz : this.zzbus) {
            i += zzz.zzz();
        }
        return i;
    }
}

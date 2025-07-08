package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public interface zzsz {

    public static final class zza extends zzso<zza> {
        public String[] zzbuI;
        public String[] zzbuJ;
        public int[] zzbuK;
        public long[] zzbuL;

        public zza() {
            zzJC();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (zzss.equals((Object[]) this.zzbuI, (Object[]) zza.zzbuI) && zzss.equals((Object[]) this.zzbuJ, (Object[]) zza.zzbuJ) && zzss.equals(this.zzbuK, zza.zzbuK) && zzss.equals(this.zzbuL, zza.zzbuL)) {
                return (this.zzbuj == null || this.zzbuj.isEmpty()) ? zza.zzbuj == null || zza.zzbuj.isEmpty() : this.zzbuj.equals(zza.zzbuj);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((527 + getClass().getName().hashCode()) * 31) + zzss.hashCode((Object[]) this.zzbuI)) * 31) + zzss.hashCode((Object[]) this.zzbuJ)) * 31) + zzss.hashCode(this.zzbuK)) * 31) + zzss.hashCode(this.zzbuL)) * 31) + ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode());
        }

        public void writeTo(zzsn zzsn) throws IOException {
            String[] strArr = this.zzbuI;
            int i = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                while (true) {
                    String[] strArr2 = this.zzbuI;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i2];
                    if (str != null) {
                        zzsn.zzn(1, str);
                    }
                    i2++;
                }
            }
            String[] strArr3 = this.zzbuJ;
            if (strArr3 != null && strArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    String[] strArr4 = this.zzbuJ;
                    if (i3 >= strArr4.length) {
                        break;
                    }
                    String str2 = strArr4[i3];
                    if (str2 != null) {
                        zzsn.zzn(2, str2);
                    }
                    i3++;
                }
            }
            int[] iArr = this.zzbuK;
            if (iArr != null && iArr.length > 0) {
                int i4 = 0;
                while (true) {
                    int[] iArr2 = this.zzbuK;
                    if (i4 >= iArr2.length) {
                        break;
                    }
                    zzsn.zzA(3, iArr2[i4]);
                    i4++;
                }
            }
            long[] jArr = this.zzbuL;
            if (jArr != null && jArr.length > 0) {
                while (true) {
                    long[] jArr2 = this.zzbuL;
                    if (i >= jArr2.length) {
                        break;
                    }
                    zzsn.zzb(4, jArr2[i]);
                    i++;
                }
            }
            super.writeTo(zzsn);
        }

        public zza zzJC() {
            this.zzbuI = zzsx.zzbuB;
            this.zzbuJ = zzsx.zzbuB;
            this.zzbuK = zzsx.zzbuw;
            this.zzbuL = zzsx.zzbux;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzS */
        public zza mergeFrom(zzsm zzsm) throws IOException {
            int i;
            while (true) {
                int zzIX = zzsm.zzIX();
                if (zzIX == 0) {
                    return this;
                }
                if (zzIX == 10) {
                    int zzc = zzsx.zzc(zzsm, 10);
                    String[] strArr = this.zzbuI;
                    int length = strArr == null ? 0 : strArr.length;
                    int i2 = zzc + length;
                    String[] strArr2 = new String[i2];
                    if (length != 0) {
                        System.arraycopy(strArr, 0, strArr2, 0, length);
                    }
                    while (length < i2 - 1) {
                        strArr2[length] = zzsm.readString();
                        zzsm.zzIX();
                        length++;
                    }
                    strArr2[length] = zzsm.readString();
                    this.zzbuI = strArr2;
                } else if (zzIX == 18) {
                    int zzc2 = zzsx.zzc(zzsm, 18);
                    String[] strArr3 = this.zzbuJ;
                    int length2 = strArr3 == null ? 0 : strArr3.length;
                    int i3 = zzc2 + length2;
                    String[] strArr4 = new String[i3];
                    if (length2 != 0) {
                        System.arraycopy(strArr3, 0, strArr4, 0, length2);
                    }
                    while (length2 < i3 - 1) {
                        strArr4[length2] = zzsm.readString();
                        zzsm.zzIX();
                        length2++;
                    }
                    strArr4[length2] = zzsm.readString();
                    this.zzbuJ = strArr4;
                } else if (zzIX != 24) {
                    if (zzIX == 26) {
                        i = zzsm.zzmq(zzsm.zzJf());
                        int position = zzsm.getPosition();
                        int i4 = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzJb();
                            i4++;
                        }
                        zzsm.zzms(position);
                        int[] iArr = this.zzbuK;
                        int length3 = iArr == null ? 0 : iArr.length;
                        int i5 = i4 + length3;
                        int[] iArr2 = new int[i5];
                        if (length3 != 0) {
                            System.arraycopy(iArr, 0, iArr2, 0, length3);
                        }
                        while (length3 < i5) {
                            iArr2[length3] = zzsm.zzJb();
                            length3++;
                        }
                        this.zzbuK = iArr2;
                    } else if (zzIX == 32) {
                        int zzc3 = zzsx.zzc(zzsm, 32);
                        long[] jArr = this.zzbuL;
                        int length4 = jArr == null ? 0 : jArr.length;
                        int i6 = zzc3 + length4;
                        long[] jArr2 = new long[i6];
                        if (length4 != 0) {
                            System.arraycopy(jArr, 0, jArr2, 0, length4);
                        }
                        while (length4 < i6 - 1) {
                            jArr2[length4] = zzsm.zzJa();
                            zzsm.zzIX();
                            length4++;
                        }
                        jArr2[length4] = zzsm.zzJa();
                        this.zzbuL = jArr2;
                    } else if (zzIX == 34) {
                        i = zzsm.zzmq(zzsm.zzJf());
                        int position2 = zzsm.getPosition();
                        int i7 = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzJa();
                            i7++;
                        }
                        zzsm.zzms(position2);
                        long[] jArr3 = this.zzbuL;
                        int length5 = jArr3 == null ? 0 : jArr3.length;
                        int i8 = i7 + length5;
                        long[] jArr4 = new long[i8];
                        if (length5 != 0) {
                            System.arraycopy(jArr3, 0, jArr4, 0, length5);
                        }
                        while (length5 < i8) {
                            jArr4[length5] = zzsm.zzJa();
                            length5++;
                        }
                        this.zzbuL = jArr4;
                    } else if (!zza(zzsm, zzIX)) {
                        return this;
                    }
                    zzsm.zzmr(i);
                } else {
                    int zzc4 = zzsx.zzc(zzsm, 24);
                    int[] iArr3 = this.zzbuK;
                    int length6 = iArr3 == null ? 0 : iArr3.length;
                    int i9 = zzc4 + length6;
                    int[] iArr4 = new int[i9];
                    if (length6 != 0) {
                        System.arraycopy(iArr3, 0, iArr4, 0, length6);
                    }
                    while (length6 < i9 - 1) {
                        iArr4[length6] = zzsm.zzJb();
                        zzsm.zzIX();
                        length6++;
                    }
                    iArr4[length6] = zzsm.zzJb();
                    this.zzbuK = iArr4;
                }
            }
        }

        /* access modifiers changed from: protected */
        public int zzz() {
            int[] iArr;
            int zzz = super.zzz();
            String[] strArr = this.zzbuI;
            int i = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    String[] strArr2 = this.zzbuI;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i2];
                    if (str != null) {
                        i4++;
                        i3 += zzsn.zzgO(str);
                    }
                    i2++;
                }
                zzz = zzz + i3 + (i4 * 1);
            }
            String[] strArr3 = this.zzbuJ;
            if (strArr3 != null && strArr3.length > 0) {
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    String[] strArr4 = this.zzbuJ;
                    if (i5 >= strArr4.length) {
                        break;
                    }
                    String str2 = strArr4[i5];
                    if (str2 != null) {
                        i7++;
                        i6 += zzsn.zzgO(str2);
                    }
                    i5++;
                }
                zzz = zzz + i6 + (i7 * 1);
            }
            int[] iArr2 = this.zzbuK;
            if (iArr2 != null && iArr2.length > 0) {
                int i8 = 0;
                int i9 = 0;
                while (true) {
                    iArr = this.zzbuK;
                    if (i8 >= iArr.length) {
                        break;
                    }
                    i9 += zzsn.zzmx(iArr[i8]);
                    i8++;
                }
                zzz = zzz + i9 + (iArr.length * 1);
            }
            long[] jArr = this.zzbuL;
            if (jArr == null || jArr.length <= 0) {
                return zzz;
            }
            int i10 = 0;
            while (true) {
                long[] jArr2 = this.zzbuL;
                if (i >= jArr2.length) {
                    return zzz + i10 + (jArr2.length * 1);
                }
                i10 += zzsn.zzas(jArr2[i]);
                i++;
            }
        }
    }

    public static final class zzb extends zzso<zzb> {
        public String version;
        public int zzbuM;
        public String zzbuN;

        public zzb() {
            zzJD();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            if (this.zzbuM != zzb.zzbuM) {
                return false;
            }
            String str = this.zzbuN;
            if (str == null) {
                if (zzb.zzbuN != null) {
                    return false;
                }
            } else if (!str.equals(zzb.zzbuN)) {
                return false;
            }
            String str2 = this.version;
            if (str2 == null) {
                if (zzb.version != null) {
                    return false;
                }
            } else if (!str2.equals(zzb.version)) {
                return false;
            }
            return (this.zzbuj == null || this.zzbuj.isEmpty()) ? zzb.zzbuj == null || zzb.zzbuj.isEmpty() : this.zzbuj.equals(zzb.zzbuj);
        }

        public int hashCode() {
            int hashCode = (((527 + getClass().getName().hashCode()) * 31) + this.zzbuM) * 31;
            String str = this.zzbuN;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.version;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                i = this.zzbuj.hashCode();
            }
            return hashCode3 + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            int i = this.zzbuM;
            if (i != 0) {
                zzsn.zzA(1, i);
            }
            if (!this.zzbuN.equals("")) {
                zzsn.zzn(2, this.zzbuN);
            }
            if (!this.version.equals("")) {
                zzsn.zzn(3, this.version);
            }
            super.writeTo(zzsn);
        }

        public zzb zzJD() {
            this.zzbuM = 0;
            this.zzbuN = "";
            this.version = "";
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzT */
        public zzb mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                if (zzIX != 0) {
                    if (zzIX == 8) {
                        int zzJb = zzsm.zzJb();
                        switch (zzJb) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                                this.zzbuM = zzJb;
                                break;
                        }
                    } else if (zzIX == 18) {
                        this.zzbuN = zzsm.readString();
                    } else if (zzIX == 26) {
                        this.version = zzsm.readString();
                    } else if (!zza(zzsm, zzIX)) {
                        return this;
                    }
                } else {
                    return this;
                }
            }
        }

        /* access modifiers changed from: protected */
        public int zzz() {
            int zzz = super.zzz();
            int i = this.zzbuM;
            if (i != 0) {
                zzz += zzsn.zzC(1, i);
            }
            if (!this.zzbuN.equals("")) {
                zzz += zzsn.zzo(2, this.zzbuN);
            }
            return !this.version.equals("") ? zzz + zzsn.zzo(3, this.version) : zzz;
        }
    }

    public static final class zzc extends zzso<zzc> {
        public byte[] zzbuO;
        public byte[][] zzbuP;
        public boolean zzbuQ;

        public zzc() {
            zzJE();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) obj;
            if (Arrays.equals(this.zzbuO, zzc.zzbuO) && zzss.zza(this.zzbuP, zzc.zzbuP) && this.zzbuQ == zzc.zzbuQ) {
                return (this.zzbuj == null || this.zzbuj.isEmpty()) ? zzc.zzbuj == null || zzc.zzbuj.isEmpty() : this.zzbuj.equals(zzc.zzbuj);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((527 + getClass().getName().hashCode()) * 31) + Arrays.hashCode(this.zzbuO)) * 31) + zzss.zza(this.zzbuP)) * 31) + (this.zzbuQ ? 1231 : 1237)) * 31) + ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode());
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (!Arrays.equals(this.zzbuO, zzsx.zzbuD)) {
                zzsn.zza(1, this.zzbuO);
            }
            byte[][] bArr = this.zzbuP;
            if (bArr != null && bArr.length > 0) {
                int i = 0;
                while (true) {
                    byte[][] bArr2 = this.zzbuP;
                    if (i >= bArr2.length) {
                        break;
                    }
                    byte[] bArr3 = bArr2[i];
                    if (bArr3 != null) {
                        zzsn.zza(2, bArr3);
                    }
                    i++;
                }
            }
            boolean z = this.zzbuQ;
            if (z) {
                zzsn.zze(3, z);
            }
            super.writeTo(zzsn);
        }

        public zzc zzJE() {
            this.zzbuO = zzsx.zzbuD;
            this.zzbuP = zzsx.zzbuC;
            this.zzbuQ = false;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzU */
        public zzc mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                if (zzIX == 0) {
                    return this;
                }
                if (zzIX == 10) {
                    this.zzbuO = zzsm.readBytes();
                } else if (zzIX == 18) {
                    int zzc = zzsx.zzc(zzsm, 18);
                    byte[][] bArr = this.zzbuP;
                    int length = bArr == null ? 0 : bArr.length;
                    int i = zzc + length;
                    byte[][] bArr2 = new byte[i][];
                    if (length != 0) {
                        System.arraycopy(bArr, 0, bArr2, 0, length);
                    }
                    while (length < i - 1) {
                        bArr2[length] = zzsm.readBytes();
                        zzsm.zzIX();
                        length++;
                    }
                    bArr2[length] = zzsm.readBytes();
                    this.zzbuP = bArr2;
                } else if (zzIX == 24) {
                    this.zzbuQ = zzsm.zzJc();
                } else if (!zza(zzsm, zzIX)) {
                    return this;
                }
            }
        }

        /* access modifiers changed from: protected */
        public int zzz() {
            int zzz = super.zzz();
            if (!Arrays.equals(this.zzbuO, zzsx.zzbuD)) {
                zzz += zzsn.zzb(1, this.zzbuO);
            }
            byte[][] bArr = this.zzbuP;
            if (bArr != null && bArr.length > 0) {
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    byte[][] bArr2 = this.zzbuP;
                    if (i >= bArr2.length) {
                        break;
                    }
                    byte[] bArr3 = bArr2[i];
                    if (bArr3 != null) {
                        i3++;
                        i2 += zzsn.zzG(bArr3);
                    }
                    i++;
                }
                zzz = zzz + i2 + (i3 * 1);
            }
            boolean z = this.zzbuQ;
            return z ? zzz + zzsn.zzf(3, z) : zzz;
        }
    }

    public static final class zzd extends zzso<zzd> {
        public String tag;
        public long zzbuR;
        public long zzbuS;
        public long zzbuT;
        public int zzbuU;
        public boolean zzbuV;
        public zze[] zzbuW;
        public zzb zzbuX;
        public byte[] zzbuY;
        public byte[] zzbuZ;
        public byte[] zzbva;
        public zza zzbvb;
        public String zzbvc;
        public long zzbvd;
        public zzc zzbve;
        public byte[] zzbvf;
        public int zzbvg;
        public int[] zzbvh;
        public long zzbvi;
        public int zzob;

        public zzd() {
            zzJF();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd zzd = (zzd) obj;
            if (this.zzbuR != zzd.zzbuR || this.zzbuS != zzd.zzbuS || this.zzbuT != zzd.zzbuT) {
                return false;
            }
            String str = this.tag;
            if (str == null) {
                if (zzd.tag != null) {
                    return false;
                }
            } else if (!str.equals(zzd.tag)) {
                return false;
            }
            if (this.zzbuU != zzd.zzbuU || this.zzob != zzd.zzob || this.zzbuV != zzd.zzbuV || !zzss.equals((Object[]) this.zzbuW, (Object[]) zzd.zzbuW)) {
                return false;
            }
            zzb zzb = this.zzbuX;
            if (zzb == null) {
                if (zzd.zzbuX != null) {
                    return false;
                }
            } else if (!zzb.equals(zzd.zzbuX)) {
                return false;
            }
            if (!Arrays.equals(this.zzbuY, zzd.zzbuY) || !Arrays.equals(this.zzbuZ, zzd.zzbuZ) || !Arrays.equals(this.zzbva, zzd.zzbva)) {
                return false;
            }
            zza zza = this.zzbvb;
            if (zza == null) {
                if (zzd.zzbvb != null) {
                    return false;
                }
            } else if (!zza.equals(zzd.zzbvb)) {
                return false;
            }
            String str2 = this.zzbvc;
            if (str2 == null) {
                if (zzd.zzbvc != null) {
                    return false;
                }
            } else if (!str2.equals(zzd.zzbvc)) {
                return false;
            }
            if (this.zzbvd != zzd.zzbvd) {
                return false;
            }
            zzc zzc = this.zzbve;
            if (zzc == null) {
                if (zzd.zzbve != null) {
                    return false;
                }
            } else if (!zzc.equals(zzd.zzbve)) {
                return false;
            }
            if (Arrays.equals(this.zzbvf, zzd.zzbvf) && this.zzbvg == zzd.zzbvg && zzss.equals(this.zzbvh, zzd.zzbvh) && this.zzbvi == zzd.zzbvi) {
                return (this.zzbuj == null || this.zzbuj.isEmpty()) ? zzd.zzbuj == null || zzd.zzbuj.isEmpty() : this.zzbuj.equals(zzd.zzbuj);
            }
            return false;
        }

        public int hashCode() {
            long j = this.zzbuR;
            long j2 = this.zzbuS;
            long j3 = this.zzbuT;
            int hashCode = (((((((527 + getClass().getName().hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            String str = this.tag;
            int i = 0;
            int hashCode2 = (((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.zzbuU) * 31) + this.zzob) * 31) + (this.zzbuV ? 1231 : 1237)) * 31) + zzss.hashCode((Object[]) this.zzbuW)) * 31;
            zzb zzb = this.zzbuX;
            int hashCode3 = (((((((hashCode2 + (zzb == null ? 0 : zzb.hashCode())) * 31) + Arrays.hashCode(this.zzbuY)) * 31) + Arrays.hashCode(this.zzbuZ)) * 31) + Arrays.hashCode(this.zzbva)) * 31;
            zza zza = this.zzbvb;
            int hashCode4 = (hashCode3 + (zza == null ? 0 : zza.hashCode())) * 31;
            String str2 = this.zzbvc;
            int hashCode5 = str2 == null ? 0 : str2.hashCode();
            long j4 = this.zzbvd;
            int i2 = (((hashCode4 + hashCode5) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            zzc zzc = this.zzbve;
            int hashCode6 = zzc == null ? 0 : zzc.hashCode();
            long j5 = this.zzbvi;
            int hashCode7 = (((((((((i2 + hashCode6) * 31) + Arrays.hashCode(this.zzbvf)) * 31) + this.zzbvg) * 31) + zzss.hashCode(this.zzbvh)) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31;
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                i = this.zzbuj.hashCode();
            }
            return hashCode7 + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            long j = this.zzbuR;
            if (j != 0) {
                zzsn.zzb(1, j);
            }
            if (!this.tag.equals("")) {
                zzsn.zzn(2, this.tag);
            }
            zze[] zzeArr = this.zzbuW;
            int i = 0;
            if (zzeArr != null && zzeArr.length > 0) {
                int i2 = 0;
                while (true) {
                    zze[] zzeArr2 = this.zzbuW;
                    if (i2 >= zzeArr2.length) {
                        break;
                    }
                    zze zze = zzeArr2[i2];
                    if (zze != null) {
                        zzsn.zza(3, (zzsu) zze);
                    }
                    i2++;
                }
            }
            if (!Arrays.equals(this.zzbuY, zzsx.zzbuD)) {
                zzsn.zza(6, this.zzbuY);
            }
            zza zza = this.zzbvb;
            if (zza != null) {
                zzsn.zza(7, (zzsu) zza);
            }
            if (!Arrays.equals(this.zzbuZ, zzsx.zzbuD)) {
                zzsn.zza(8, this.zzbuZ);
            }
            zzb zzb = this.zzbuX;
            if (zzb != null) {
                zzsn.zza(9, (zzsu) zzb);
            }
            boolean z = this.zzbuV;
            if (z) {
                zzsn.zze(10, z);
            }
            int i3 = this.zzbuU;
            if (i3 != 0) {
                zzsn.zzA(11, i3);
            }
            int i4 = this.zzob;
            if (i4 != 0) {
                zzsn.zzA(12, i4);
            }
            if (!Arrays.equals(this.zzbva, zzsx.zzbuD)) {
                zzsn.zza(13, this.zzbva);
            }
            if (!this.zzbvc.equals("")) {
                zzsn.zzn(14, this.zzbvc);
            }
            long j2 = this.zzbvd;
            if (j2 != 180000) {
                zzsn.zzc(15, j2);
            }
            zzc zzc = this.zzbve;
            if (zzc != null) {
                zzsn.zza(16, (zzsu) zzc);
            }
            long j3 = this.zzbuS;
            if (j3 != 0) {
                zzsn.zzb(17, j3);
            }
            if (!Arrays.equals(this.zzbvf, zzsx.zzbuD)) {
                zzsn.zza(18, this.zzbvf);
            }
            int i5 = this.zzbvg;
            if (i5 != 0) {
                zzsn.zzA(19, i5);
            }
            int[] iArr = this.zzbvh;
            if (iArr != null && iArr.length > 0) {
                while (true) {
                    int[] iArr2 = this.zzbvh;
                    if (i >= iArr2.length) {
                        break;
                    }
                    zzsn.zzA(20, iArr2[i]);
                    i++;
                }
            }
            long j4 = this.zzbuT;
            if (j4 != 0) {
                zzsn.zzb(21, j4);
            }
            long j5 = this.zzbvi;
            if (j5 != 0) {
                zzsn.zzb(22, j5);
            }
            super.writeTo(zzsn);
        }

        public zzd zzJF() {
            this.zzbuR = 0;
            this.zzbuS = 0;
            this.zzbuT = 0;
            this.tag = "";
            this.zzbuU = 0;
            this.zzob = 0;
            this.zzbuV = false;
            this.zzbuW = zze.zzJG();
            this.zzbuX = null;
            this.zzbuY = zzsx.zzbuD;
            this.zzbuZ = zzsx.zzbuD;
            this.zzbva = zzsx.zzbuD;
            this.zzbvb = null;
            this.zzbvc = "";
            this.zzbvd = 180000;
            this.zzbve = null;
            this.zzbvf = zzsx.zzbuD;
            this.zzbvg = 0;
            this.zzbvh = zzsx.zzbuw;
            this.zzbvi = 0;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzV */
        public zzd mergeFrom(zzsm zzsm) throws IOException {
            zzsu zzsu;
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        return this;
                    case 8:
                        this.zzbuR = zzsm.zzJa();
                        continue;
                    case 18:
                        this.tag = zzsm.readString();
                        continue;
                    case 26:
                        int zzc = zzsx.zzc(zzsm, 26);
                        zze[] zzeArr = this.zzbuW;
                        int length = zzeArr == null ? 0 : zzeArr.length;
                        int i = zzc + length;
                        zze[] zzeArr2 = new zze[i];
                        if (length != 0) {
                            System.arraycopy(zzeArr, 0, zzeArr2, 0, length);
                        }
                        while (length < i - 1) {
                            zzeArr2[length] = new zze();
                            zzsm.zza(zzeArr2[length]);
                            zzsm.zzIX();
                            length++;
                        }
                        zzeArr2[length] = new zze();
                        zzsm.zza(zzeArr2[length]);
                        this.zzbuW = zzeArr2;
                        continue;
                    case 50:
                        this.zzbuY = zzsm.readBytes();
                        continue;
                    case 58:
                        if (this.zzbvb == null) {
                            this.zzbvb = new zza();
                        }
                        zzsu = this.zzbvb;
                        break;
                    case 66:
                        this.zzbuZ = zzsm.readBytes();
                        continue;
                    case 74:
                        if (this.zzbuX == null) {
                            this.zzbuX = new zzb();
                        }
                        zzsu = this.zzbuX;
                        break;
                    case 80:
                        this.zzbuV = zzsm.zzJc();
                        continue;
                    case 88:
                        this.zzbuU = zzsm.zzJb();
                        continue;
                    case 96:
                        this.zzob = zzsm.zzJb();
                        continue;
                    case 106:
                        this.zzbva = zzsm.readBytes();
                        continue;
                    case 114:
                        this.zzbvc = zzsm.readString();
                        continue;
                    case 120:
                        this.zzbvd = zzsm.zzJe();
                        continue;
                    case 130:
                        if (this.zzbve == null) {
                            this.zzbve = new zzc();
                        }
                        zzsu = this.zzbve;
                        break;
                    case 136:
                        this.zzbuS = zzsm.zzJa();
                        continue;
                    case 146:
                        this.zzbvf = zzsm.readBytes();
                        continue;
                    case 152:
                        int zzJb = zzsm.zzJb();
                        if (zzJb == 0 || zzJb == 1 || zzJb == 2) {
                            this.zzbvg = zzJb;
                            break;
                        } else {
                            continue;
                        }
                    case 160:
                        int zzc2 = zzsx.zzc(zzsm, 160);
                        int[] iArr = this.zzbvh;
                        int length2 = iArr == null ? 0 : iArr.length;
                        int i2 = zzc2 + length2;
                        int[] iArr2 = new int[i2];
                        if (length2 != 0) {
                            System.arraycopy(iArr, 0, iArr2, 0, length2);
                        }
                        while (length2 < i2 - 1) {
                            iArr2[length2] = zzsm.zzJb();
                            zzsm.zzIX();
                            length2++;
                        }
                        iArr2[length2] = zzsm.zzJb();
                        this.zzbvh = iArr2;
                        continue;
                    case 162:
                        int zzmq = zzsm.zzmq(zzsm.zzJf());
                        int position = zzsm.getPosition();
                        int i3 = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzJb();
                            i3++;
                        }
                        zzsm.zzms(position);
                        int[] iArr3 = this.zzbvh;
                        int length3 = iArr3 == null ? 0 : iArr3.length;
                        int i4 = i3 + length3;
                        int[] iArr4 = new int[i4];
                        if (length3 != 0) {
                            System.arraycopy(iArr3, 0, iArr4, 0, length3);
                        }
                        while (length3 < i4) {
                            iArr4[length3] = zzsm.zzJb();
                            length3++;
                        }
                        this.zzbvh = iArr4;
                        zzsm.zzmr(zzmq);
                        continue;
                    case 168:
                        this.zzbuT = zzsm.zzJa();
                        continue;
                    case 176:
                        this.zzbvi = zzsm.zzJa();
                        continue;
                    default:
                        if (!zza(zzsm, zzIX)) {
                            return this;
                        }
                        continue;
                }
                zzsm.zza(zzsu);
            }
        }

        /* access modifiers changed from: protected */
        public int zzz() {
            int[] iArr;
            int zzz = super.zzz();
            long j = this.zzbuR;
            if (j != 0) {
                zzz += zzsn.zzd(1, j);
            }
            if (!this.tag.equals("")) {
                zzz += zzsn.zzo(2, this.tag);
            }
            zze[] zzeArr = this.zzbuW;
            int i = 0;
            if (zzeArr != null && zzeArr.length > 0) {
                int i2 = 0;
                while (true) {
                    zze[] zzeArr2 = this.zzbuW;
                    if (i2 >= zzeArr2.length) {
                        break;
                    }
                    zze zze = zzeArr2[i2];
                    if (zze != null) {
                        zzz += zzsn.zzc(3, (zzsu) zze);
                    }
                    i2++;
                }
            }
            if (!Arrays.equals(this.zzbuY, zzsx.zzbuD)) {
                zzz += zzsn.zzb(6, this.zzbuY);
            }
            zza zza = this.zzbvb;
            if (zza != null) {
                zzz += zzsn.zzc(7, (zzsu) zza);
            }
            if (!Arrays.equals(this.zzbuZ, zzsx.zzbuD)) {
                zzz += zzsn.zzb(8, this.zzbuZ);
            }
            zzb zzb = this.zzbuX;
            if (zzb != null) {
                zzz += zzsn.zzc(9, (zzsu) zzb);
            }
            boolean z = this.zzbuV;
            if (z) {
                zzz += zzsn.zzf(10, z);
            }
            int i3 = this.zzbuU;
            if (i3 != 0) {
                zzz += zzsn.zzC(11, i3);
            }
            int i4 = this.zzob;
            if (i4 != 0) {
                zzz += zzsn.zzC(12, i4);
            }
            if (!Arrays.equals(this.zzbva, zzsx.zzbuD)) {
                zzz += zzsn.zzb(13, this.zzbva);
            }
            if (!this.zzbvc.equals("")) {
                zzz += zzsn.zzo(14, this.zzbvc);
            }
            long j2 = this.zzbvd;
            if (j2 != 180000) {
                zzz += zzsn.zze(15, j2);
            }
            zzc zzc = this.zzbve;
            if (zzc != null) {
                zzz += zzsn.zzc(16, (zzsu) zzc);
            }
            long j3 = this.zzbuS;
            if (j3 != 0) {
                zzz += zzsn.zzd(17, j3);
            }
            if (!Arrays.equals(this.zzbvf, zzsx.zzbuD)) {
                zzz += zzsn.zzb(18, this.zzbvf);
            }
            int i5 = this.zzbvg;
            if (i5 != 0) {
                zzz += zzsn.zzC(19, i5);
            }
            int[] iArr2 = this.zzbvh;
            if (iArr2 != null && iArr2.length > 0) {
                int i6 = 0;
                while (true) {
                    iArr = this.zzbvh;
                    if (i >= iArr.length) {
                        break;
                    }
                    i6 += zzsn.zzmx(iArr[i]);
                    i++;
                }
                zzz = zzz + i6 + (iArr.length * 2);
            }
            long j4 = this.zzbuT;
            if (j4 != 0) {
                zzz += zzsn.zzd(21, j4);
            }
            long j5 = this.zzbvi;
            return j5 != 0 ? zzz + zzsn.zzd(22, j5) : zzz;
        }
    }

    public static final class zze extends zzso<zze> {
        private static volatile zze[] zzbvj;
        public String key;
        public String value;

        public zze() {
            zzJH();
        }

        public static zze[] zzJG() {
            if (zzbvj == null) {
                synchronized (zzss.zzbut) {
                    if (zzbvj == null) {
                        zzbvj = new zze[0];
                    }
                }
            }
            return zzbvj;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zze = (zze) obj;
            String str = this.key;
            if (str == null) {
                if (zze.key != null) {
                    return false;
                }
            } else if (!str.equals(zze.key)) {
                return false;
            }
            String str2 = this.value;
            if (str2 == null) {
                if (zze.value != null) {
                    return false;
                }
            } else if (!str2.equals(zze.value)) {
                return false;
            }
            return (this.zzbuj == null || this.zzbuj.isEmpty()) ? zze.zzbuj == null || zze.zzbuj.isEmpty() : this.zzbuj.equals(zze.zzbuj);
        }

        public int hashCode() {
            int hashCode = (527 + getClass().getName().hashCode()) * 31;
            String str = this.key;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.value;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                i = this.zzbuj.hashCode();
            }
            return hashCode3 + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (!this.key.equals("")) {
                zzsn.zzn(1, this.key);
            }
            if (!this.value.equals("")) {
                zzsn.zzn(2, this.value);
            }
            super.writeTo(zzsn);
        }

        public zze zzJH() {
            this.key = "";
            this.value = "";
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzW */
        public zze mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                if (zzIX == 0) {
                    return this;
                }
                if (zzIX == 10) {
                    this.key = zzsm.readString();
                } else if (zzIX == 18) {
                    this.value = zzsm.readString();
                } else if (!zza(zzsm, zzIX)) {
                    return this;
                }
            }
        }

        /* access modifiers changed from: protected */
        public int zzz() {
            int zzz = super.zzz();
            if (!this.key.equals("")) {
                zzz += zzsn.zzo(1, this.key);
            }
            return !this.value.equals("") ? zzz + zzsn.zzo(2, this.value) : zzz;
        }
    }
}

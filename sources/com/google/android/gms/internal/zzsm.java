package com.google.android.gms.internal;

import androidx.appcompat.widget.ActivityChooserView;
import java.io.IOException;

public final class zzsm {
    private final byte[] buffer;
    private int zzbtZ;
    private int zzbua;
    private int zzbub;
    private int zzbuc;
    private int zzbud;
    private int zzbue = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int zzbuf;
    private int zzbug = 64;
    private int zzbuh = 67108864;

    private zzsm(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzbtZ = i;
        this.zzbua = i2 + i;
        this.zzbuc = i;
    }

    public static zzsm zzD(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    private void zzJj() {
        int i = this.zzbua + this.zzbub;
        this.zzbua = i;
        int i2 = this.zzbue;
        if (i > i2) {
            int i3 = i - i2;
            this.zzbub = i3;
            this.zzbua = i - i3;
            return;
        }
        this.zzbub = 0;
    }

    public static zzsm zza(byte[] bArr, int i, int i2) {
        return new zzsm(bArr, i, i2);
    }

    public static long zzan(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int zzmp(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public int getPosition() {
        return this.zzbuc - this.zzbtZ;
    }

    public byte[] readBytes() throws IOException {
        int zzJf = zzJf();
        int i = this.zzbua;
        int i2 = this.zzbuc;
        if (zzJf > i - i2 || zzJf <= 0) {
            return zzJf == 0 ? zzsx.zzbuD : zzmt(zzJf);
        }
        byte[] bArr = new byte[zzJf];
        System.arraycopy(this.buffer, i2, bArr, 0, zzJf);
        this.zzbuc += zzJf;
        return bArr;
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(zzJi());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(zzJh());
    }

    public String readString() throws IOException {
        int zzJf = zzJf();
        if (zzJf > this.zzbua - this.zzbuc || zzJf <= 0) {
            return new String(zzmt(zzJf), "UTF-8");
        }
        String str = new String(this.buffer, this.zzbuc, zzJf, "UTF-8");
        this.zzbuc += zzJf;
        return str;
    }

    public int zzIX() throws IOException {
        if (zzJl()) {
            this.zzbud = 0;
            return 0;
        }
        int zzJf = zzJf();
        this.zzbud = zzJf;
        if (zzJf != 0) {
            return zzJf;
        }
        throw zzst.zzJv();
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public void zzIY() throws java.io.IOException {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r1.zzIX()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.zzmo(r0)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsm.zzIY():void");
    }

    public long zzIZ() throws IOException {
        return zzJg();
    }

    public long zzJa() throws IOException {
        return zzJg();
    }

    public int zzJb() throws IOException {
        return zzJf();
    }

    public boolean zzJc() throws IOException {
        return zzJf() != 0;
    }

    public int zzJd() throws IOException {
        return zzmp(zzJf());
    }

    public long zzJe() throws IOException {
        return zzan(zzJg());
    }

    public int zzJf() throws IOException {
        int i;
        byte zzJm = zzJm();
        if (zzJm >= 0) {
            return zzJm;
        }
        byte b = zzJm & Byte.MAX_VALUE;
        byte zzJm2 = zzJm();
        if (zzJm2 >= 0) {
            i = zzJm2 << 7;
        } else {
            b |= (zzJm2 & Byte.MAX_VALUE) << 7;
            byte zzJm3 = zzJm();
            if (zzJm3 >= 0) {
                i = zzJm3 << 14;
            } else {
                b |= (zzJm3 & Byte.MAX_VALUE) << 14;
                byte zzJm4 = zzJm();
                if (zzJm4 >= 0) {
                    i = zzJm4 << 21;
                } else {
                    byte b2 = b | ((zzJm4 & Byte.MAX_VALUE) << 21);
                    byte zzJm5 = zzJm();
                    byte b3 = b2 | (zzJm5 << 28);
                    if (zzJm5 >= 0) {
                        return b3;
                    }
                    for (int i2 = 0; i2 < 5; i2++) {
                        if (zzJm() >= 0) {
                            return b3;
                        }
                    }
                    throw zzst.zzJu();
                }
            }
        }
        return b | i;
    }

    public long zzJg() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzJm = zzJm();
            j |= ((long) (zzJm & Byte.MAX_VALUE)) << i;
            if ((zzJm & 128) == 0) {
                return j;
            }
        }
        throw zzst.zzJu();
    }

    public int zzJh() throws IOException {
        return (zzJm() & 255) | ((zzJm() & 255) << 8) | ((zzJm() & 255) << 16) | ((zzJm() & 255) << 24);
    }

    public long zzJi() throws IOException {
        byte zzJm = zzJm();
        byte zzJm2 = zzJm();
        return ((((long) zzJm2) & 255) << 8) | (((long) zzJm) & 255) | ((((long) zzJm()) & 255) << 16) | ((((long) zzJm()) & 255) << 24) | ((((long) zzJm()) & 255) << 32) | ((((long) zzJm()) & 255) << 40) | ((((long) zzJm()) & 255) << 48) | ((((long) zzJm()) & 255) << 56);
    }

    public int zzJk() {
        int i = this.zzbue;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - this.zzbuc;
    }

    public boolean zzJl() {
        return this.zzbuc == this.zzbua;
    }

    public byte zzJm() throws IOException {
        int i = this.zzbuc;
        if (i != this.zzbua) {
            byte[] bArr = this.buffer;
            this.zzbuc = i + 1;
            return bArr[i];
        }
        throw zzst.zzJs();
    }

    public void zza(zzsu zzsu) throws IOException {
        int zzJf = zzJf();
        if (this.zzbuf < this.zzbug) {
            int zzmq = zzmq(zzJf);
            this.zzbuf++;
            zzsu.mergeFrom(this);
            zzmn(0);
            this.zzbuf--;
            zzmr(zzmq);
            return;
        }
        throw zzst.zzJy();
    }

    public void zza(zzsu zzsu, int i) throws IOException {
        int i2 = this.zzbuf;
        if (i2 < this.zzbug) {
            this.zzbuf = i2 + 1;
            zzsu.mergeFrom(this);
            zzmn(zzsx.zzF(i, 4));
            this.zzbuf--;
            return;
        }
        throw zzst.zzJy();
    }

    public void zzmn(int i) throws zzst {
        if (this.zzbud != i) {
            throw zzst.zzJw();
        }
    }

    public boolean zzmo(int i) throws IOException {
        int zzmI = zzsx.zzmI(i);
        if (zzmI == 0) {
            zzJb();
            return true;
        } else if (zzmI == 1) {
            zzJi();
            return true;
        } else if (zzmI == 2) {
            zzmu(zzJf());
            return true;
        } else if (zzmI == 3) {
            zzIY();
            zzmn(zzsx.zzF(zzsx.zzmJ(i), 4));
            return true;
        } else if (zzmI == 4) {
            return false;
        } else {
            if (zzmI == 5) {
                zzJh();
                return true;
            }
            throw zzst.zzJx();
        }
    }

    public int zzmq(int i) throws zzst {
        if (i >= 0) {
            int i2 = i + this.zzbuc;
            int i3 = this.zzbue;
            if (i2 <= i3) {
                this.zzbue = i2;
                zzJj();
                return i3;
            }
            throw zzst.zzJs();
        }
        throw zzst.zzJt();
    }

    public void zzmr(int i) {
        this.zzbue = i;
        zzJj();
    }

    public void zzms(int i) {
        int i2 = this.zzbuc;
        int i3 = this.zzbtZ;
        if (i > i2 - i3) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.zzbuc - this.zzbtZ));
        } else if (i >= 0) {
            this.zzbuc = i3 + i;
        } else {
            throw new IllegalArgumentException("Bad position " + i);
        }
    }

    public byte[] zzmt(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zzbuc;
            int i3 = i2 + i;
            int i4 = this.zzbue;
            if (i3 > i4) {
                zzmu(i4 - i2);
                throw zzst.zzJs();
            } else if (i <= this.zzbua - i2) {
                byte[] bArr = new byte[i];
                System.arraycopy(this.buffer, i2, bArr, 0, i);
                this.zzbuc += i;
                return bArr;
            } else {
                throw zzst.zzJs();
            }
        } else {
            throw zzst.zzJt();
        }
    }

    public void zzmu(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zzbuc;
            int i3 = i2 + i;
            int i4 = this.zzbue;
            if (i3 > i4) {
                zzmu(i4 - i2);
                throw zzst.zzJs();
            } else if (i <= this.zzbua - i2) {
                this.zzbuc = i2 + i;
            } else {
                throw zzst.zzJs();
            }
        } else {
            throw zzst.zzJt();
        }
    }

    public byte[] zzz(int i, int i2) {
        if (i2 == 0) {
            return zzsx.zzbuD;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzbtZ + i, bArr, 0, i2);
        return bArr;
    }
}

package com.google.android.gms.internal;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzsn {
    private final ByteBuffer zzbui;

    public static class zza extends IOException {
        zza(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private zzsn(ByteBuffer byteBuffer) {
        this.zzbui = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzsn(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    public static int zzC(int i, int i2) {
        return zzmA(i) + zzmx(i2);
    }

    public static int zzD(int i, int i2) {
        return zzmA(i) + zzmy(i2);
    }

    public static zzsn zzE(byte[] bArr) {
        return zzb(bArr, 0, bArr.length);
    }

    public static int zzG(byte[] bArr) {
        return zzmC(bArr.length) + bArr.length;
    }

    private static int zza(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 2048) {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) >= 65536) {
                        i++;
                    } else {
                        throw new IllegalArgumentException("Unpaired surrogate at index " + i);
                    }
                }
            }
            i++;
        }
        return i2;
    }

    private static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        char charAt;
        int length = charSequence.length();
        int i6 = i2 + i;
        int i7 = 0;
        while (i7 < length && (i5 = i7 + i) < i6 && (charAt = charSequence.charAt(i7)) < 128) {
            bArr[i5] = (byte) charAt;
            i7++;
        }
        if (i7 == length) {
            return i + length;
        }
        int i8 = i + i7;
        while (i7 < length) {
            char charAt2 = charSequence.charAt(i7);
            if (charAt2 < 128 && i8 < i6) {
                i4 = i8 + 1;
                bArr[i8] = (byte) charAt2;
            } else if (charAt2 < 2048 && i8 <= i6 - 2) {
                int i9 = i8 + 1;
                bArr[i8] = (byte) ((charAt2 >>> 6) | 960);
                i8 = i9 + 1;
                bArr[i9] = (byte) ((charAt2 & '?') | 128);
                i7++;
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i8 <= i6 - 3) {
                int i10 = i8 + 1;
                bArr[i8] = (byte) ((charAt2 >>> 12) | 480);
                int i11 = i10 + 1;
                bArr[i10] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i4 = i11 + 1;
                bArr[i11] = (byte) ((charAt2 & '?') | 128);
            } else if (i8 <= i6 - 4) {
                int i12 = i7 + 1;
                if (i12 != charSequence.length()) {
                    char charAt3 = charSequence.charAt(i12);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        int i13 = i8 + 1;
                        bArr[i8] = (byte) ((codePoint >>> 18) | 240);
                        int i14 = i13 + 1;
                        bArr[i13] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i15 = i14 + 1;
                        bArr[i14] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i8 = i15 + 1;
                        bArr[i15] = (byte) ((codePoint & 63) | 128);
                        i7 = i12;
                        i7++;
                    } else {
                        i7 = i12;
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Unpaired surrogate at index ");
                sb.append(i7 - 1);
                throw new IllegalArgumentException(sb.toString());
            } else if (55296 > charAt2 || charAt2 > 57343 || ((i3 = i7 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i8);
            } else {
                throw new IllegalArgumentException("Unpaired surrogate at index " + i7);
            }
            i8 = i4;
            i7++;
        }
        return i8;
    }

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(zza(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (ArrayIndexOutOfBoundsException e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            zzb(charSequence, byteBuffer);
        }
    }

    public static int zzaA(boolean z) {
        return 1;
    }

    public static int zzar(long j) {
        return zzav(j);
    }

    public static int zzas(long j) {
        return zzav(j);
    }

    public static int zzat(long j) {
        return zzav(zzax(j));
    }

    public static int zzav(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static long zzax(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzb(int i, double d) {
        return zzmA(i) + zzl(d);
    }

    public static int zzb(int i, zzsu zzsu) {
        return (zzmA(i) * 2) + zzd(zzsu);
    }

    public static int zzb(int i, byte[] bArr) {
        return zzmA(i) + zzG(bArr);
    }

    public static zzsn zzb(byte[] bArr, int i, int i2) {
        return new zzsn(bArr, i, i2);
    }

    private static void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt >= 128) {
                if (charAt < 2048) {
                    i = (charAt >>> 6) | 960;
                } else if (charAt < 55296 || 57343 < charAt) {
                    byteBuffer.put((byte) ((charAt >>> 12) | 480));
                    i = ((charAt >>> 6) & 63) | 128;
                } else {
                    int i3 = i2 + 1;
                    if (i3 != charSequence.length()) {
                        char charAt2 = charSequence.charAt(i3);
                        if (Character.isSurrogatePair(charAt, charAt2)) {
                            int codePoint = Character.toCodePoint(charAt, charAt2);
                            byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                            byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                            byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                            byteBuffer.put((byte) ((codePoint & 63) | 128));
                            i2 = i3;
                            i2++;
                        } else {
                            i2 = i3;
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unpaired surrogate at index ");
                    sb.append(i2 - 1);
                    throw new IllegalArgumentException(sb.toString());
                }
                byteBuffer.put((byte) i);
                charAt = (charAt & '?') | 128;
            }
            byteBuffer.put((byte) charAt);
            i2++;
        }
    }

    public static int zzc(int i, float f) {
        return zzmA(i) + zzk(f);
    }

    public static int zzc(int i, zzsu zzsu) {
        return zzmA(i) + zze(zzsu);
    }

    private static int zzc(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int i2 = length;
        while (true) {
            if (i < length) {
                char charAt = charSequence.charAt(i);
                if (charAt >= 2048) {
                    i2 += zza(charSequence, i);
                    break;
                }
                i2 += (127 - charAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (i2 >= length) {
            return i2;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i2) + 4294967296L));
    }

    public static int zzd(int i, long j) {
        return zzmA(i) + zzas(j);
    }

    public static int zzd(zzsu zzsu) {
        return zzsu.getSerializedSize();
    }

    public static int zze(int i, long j) {
        return zzmA(i) + zzat(j);
    }

    public static int zze(zzsu zzsu) {
        int serializedSize = zzsu.getSerializedSize();
        return zzmC(serializedSize) + serializedSize;
    }

    public static int zzf(int i, boolean z) {
        return zzmA(i) + zzaA(z);
    }

    public static int zzgO(String str) {
        int zzc = zzc((CharSequence) str);
        return zzmC(zzc) + zzc;
    }

    public static int zzk(float f) {
        return 4;
    }

    public static int zzl(double d) {
        return 8;
    }

    public static int zzmA(int i) {
        return zzmC(zzsx.zzF(i, 0));
    }

    public static int zzmC(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzmE(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int zzmx(int i) {
        if (i >= 0) {
            return zzmC(i);
        }
        return 10;
    }

    public static int zzmy(int i) {
        return zzmC(zzmE(i));
    }

    public static int zzo(int i, String str) {
        return zzmA(i) + zzgO(str);
    }

    public void zzA(int i, int i2) throws IOException {
        zzE(i, 0);
        zzmv(i2);
    }

    public void zzB(int i, int i2) throws IOException {
        zzE(i, 0);
        zzmw(i2);
    }

    public void zzE(int i, int i2) throws IOException {
        zzmB(zzsx.zzF(i, i2));
    }

    public void zzF(byte[] bArr) throws IOException {
        zzmB(bArr.length);
        zzH(bArr);
    }

    public void zzH(byte[] bArr) throws IOException {
        zzc(bArr, 0, bArr.length);
    }

    public int zzJn() {
        return this.zzbui.remaining();
    }

    public void zzJo() {
        if (zzJn() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void zza(int i, double d) throws IOException {
        zzE(i, 1);
        zzk(d);
    }

    public void zza(int i, long j) throws IOException {
        zzE(i, 0);
        zzao(j);
    }

    public void zza(int i, zzsu zzsu) throws IOException {
        zzE(i, 2);
        zzc(zzsu);
    }

    public void zza(int i, byte[] bArr) throws IOException {
        zzE(i, 2);
        zzF(bArr);
    }

    public void zzao(long j) throws IOException {
        zzau(j);
    }

    public void zzap(long j) throws IOException {
        zzau(j);
    }

    public void zzaq(long j) throws IOException {
        zzau(zzax(j));
    }

    public void zzau(long j) throws IOException {
        while ((-128 & j) != 0) {
            zzmz((((int) j) & 127) | 128);
            j >>>= 7;
        }
        zzmz((int) j);
    }

    public void zzaw(long j) throws IOException {
        if (this.zzbui.remaining() >= 8) {
            this.zzbui.putLong(j);
            return;
        }
        throw new zza(this.zzbui.position(), this.zzbui.limit());
    }

    public void zzaz(boolean z) throws IOException {
        zzmz(z ? 1 : 0);
    }

    public void zzb(byte b) throws IOException {
        if (this.zzbui.hasRemaining()) {
            this.zzbui.put(b);
            return;
        }
        throw new zza(this.zzbui.position(), this.zzbui.limit());
    }

    public void zzb(int i, float f) throws IOException {
        zzE(i, 5);
        zzj(f);
    }

    public void zzb(int i, long j) throws IOException {
        zzE(i, 0);
        zzap(j);
    }

    public void zzb(zzsu zzsu) throws IOException {
        zzsu.writeTo(this);
    }

    public void zzc(int i, long j) throws IOException {
        zzE(i, 0);
        zzaq(j);
    }

    public void zzc(zzsu zzsu) throws IOException {
        zzmB(zzsu.getCachedSize());
        zzsu.writeTo(this);
    }

    public void zzc(byte[] bArr, int i, int i2) throws IOException {
        if (this.zzbui.remaining() >= i2) {
            this.zzbui.put(bArr, i, i2);
            return;
        }
        throw new zza(this.zzbui.position(), this.zzbui.limit());
    }

    public void zze(int i, boolean z) throws IOException {
        zzE(i, 0);
        zzaz(z);
    }

    public void zzgN(String str) throws IOException {
        try {
            int zzmC = zzmC(str.length());
            if (zzmC == zzmC(str.length() * 3)) {
                int position = this.zzbui.position();
                if (this.zzbui.remaining() >= zzmC) {
                    this.zzbui.position(position + zzmC);
                    zza((CharSequence) str, this.zzbui);
                    int position2 = this.zzbui.position();
                    this.zzbui.position(position);
                    zzmB((position2 - position) - zzmC);
                    this.zzbui.position(position2);
                    return;
                }
                throw new zza(position + zzmC, this.zzbui.limit());
            }
            zzmB(zzc((CharSequence) str));
            zza((CharSequence) str, this.zzbui);
        } catch (BufferOverflowException e) {
            zza zza2 = new zza(this.zzbui.position(), this.zzbui.limit());
            zza2.initCause(e);
            throw zza2;
        }
    }

    public void zzj(float f) throws IOException {
        zzmD(Float.floatToIntBits(f));
    }

    public void zzk(double d) throws IOException {
        zzaw(Double.doubleToLongBits(d));
    }

    public void zzmB(int i) throws IOException {
        while ((i & -128) != 0) {
            zzmz((i & 127) | 128);
            i >>>= 7;
        }
        zzmz(i);
    }

    public void zzmD(int i) throws IOException {
        if (this.zzbui.remaining() >= 4) {
            this.zzbui.putInt(i);
            return;
        }
        throw new zza(this.zzbui.position(), this.zzbui.limit());
    }

    public void zzmv(int i) throws IOException {
        if (i >= 0) {
            zzmB(i);
        } else {
            zzau((long) i);
        }
    }

    public void zzmw(int i) throws IOException {
        zzmB(zzmE(i));
    }

    public void zzmz(int i) throws IOException {
        zzb((byte) i);
    }

    public void zzn(int i, String str) throws IOException {
        zzE(i, 2);
        zzgN(str);
    }
}

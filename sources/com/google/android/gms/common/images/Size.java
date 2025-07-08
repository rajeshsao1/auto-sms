package com.google.android.gms.common.images;

public final class Size {
    private final int zzoG;
    private final int zzoH;

    public Size(int i, int i2) {
        this.zzoG = i;
        this.zzoH = i2;
    }

    public static Size parseSize(String str) throws NumberFormatException {
        if (str != null) {
            int indexOf = str.indexOf(42);
            if (indexOf < 0) {
                indexOf = str.indexOf(120);
            }
            if (indexOf >= 0) {
                try {
                    return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
                } catch (NumberFormatException e) {
                    throw zzcC(str);
                }
            } else {
                throw zzcC(str);
            }
        } else {
            throw new IllegalArgumentException("string must not be null");
        }
    }

    private static NumberFormatException zzcC(String str) {
        throw new NumberFormatException("Invalid Size: \"" + str + "\"");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.zzoG == size.zzoG && this.zzoH == size.zzoH;
    }

    public int getHeight() {
        return this.zzoH;
    }

    public int getWidth() {
        return this.zzoG;
    }

    public int hashCode() {
        int i = this.zzoH;
        int i2 = this.zzoG;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public String toString() {
        return this.zzoG + "x" + this.zzoH;
    }
}

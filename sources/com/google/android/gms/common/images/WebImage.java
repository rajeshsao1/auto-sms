package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage implements SafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new zzb();
    private final int mVersionCode;
    private final Uri zzajZ;
    private final int zzoG;
    private final int zzoH;

    WebImage(int i, Uri uri, int i2, int i3) {
        this.mVersionCode = i;
        this.zzajZ = uri;
        this.zzoG = i2;
        this.zzoH = i3;
    }

    public WebImage(Uri uri) throws IllegalArgumentException {
        this(uri, 0, 0);
    }

    public WebImage(Uri uri, int i, int i2) throws IllegalArgumentException {
        this(1, uri, i, i2);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(JSONObject jSONObject) throws IllegalArgumentException {
        this(zzj(jSONObject), jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
    }

    private static Uri zzj(JSONObject jSONObject) {
        if (jSONObject.has("url")) {
            try {
                return Uri.parse(jSONObject.getString("url"));
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) obj;
        return zzw.equal(this.zzajZ, webImage.zzajZ) && this.zzoG == webImage.zzoG && this.zzoH == webImage.zzoH;
    }

    public int getHeight() {
        return this.zzoH;
    }

    public Uri getUrl() {
        return this.zzajZ;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int getWidth() {
        return this.zzoG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzajZ, Integer.valueOf(this.zzoG), Integer.valueOf(this.zzoH));
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.zzajZ.toString());
            jSONObject.put("width", this.zzoG);
            jSONObject.put("height", this.zzoH);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public String toString() {
        return String.format("Image %dx%d %s", new Object[]{Integer.valueOf(this.zzoG), Integer.valueOf(this.zzoH), this.zzajZ.toString()});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}

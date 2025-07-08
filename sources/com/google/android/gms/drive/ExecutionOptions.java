package com.google.android.gms.drive;

import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.internal.zzu;

public class ExecutionOptions {
    public static final int CONFLICT_STRATEGY_KEEP_REMOTE = 1;
    public static final int CONFLICT_STRATEGY_OVERWRITE_REMOTE = 0;
    public static final int MAX_TRACKING_TAG_STRING_LENGTH = 65536;
    private final String zzaoV;
    private final boolean zzaoW;
    private final int zzaoX;

    public static class Builder {
        protected String zzaoV;
        protected boolean zzaoW;
        protected int zzaoX = 0;

        public ExecutionOptions build() {
            zzsE();
            return new ExecutionOptions(this.zzaoV, this.zzaoW, this.zzaoX);
        }

        public Builder setConflictStrategy(int i) {
            if (ExecutionOptions.zzcw(i)) {
                this.zzaoX = i;
                return this;
            }
            throw new IllegalArgumentException("Unrecognized value for conflict strategy: " + i);
        }

        public Builder setNotifyOnCompletion(boolean z) {
            this.zzaoW = z;
            return this;
        }

        public Builder setTrackingTag(String str) {
            if (ExecutionOptions.zzcX(str)) {
                this.zzaoV = str;
                return this;
            }
            throw new IllegalArgumentException(String.format("trackingTag must not be null nor empty, and the length must be <= the maximum length (%s)", new Object[]{65536}));
        }

        /* access modifiers changed from: protected */
        public void zzsE() {
            if (this.zzaoX == 1 && !this.zzaoW) {
                throw new IllegalStateException("Cannot use CONFLICT_STRATEGY_KEEP_REMOTE without requesting completion notifications");
            }
        }
    }

    public ExecutionOptions(String str, boolean z, int i) {
        this.zzaoV = str;
        this.zzaoW = z;
        this.zzaoX = i;
    }

    public static boolean zzcX(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 65536;
    }

    public static boolean zzcv(int i) {
        return i == 1;
    }

    public static boolean zzcw(int i) {
        return i == 0 || i == 1;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ExecutionOptions executionOptions = (ExecutionOptions) obj;
        return zzw.equal(this.zzaoV, executionOptions.zzaoV) && this.zzaoX == executionOptions.zzaoX && this.zzaoW == executionOptions.zzaoW;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaoV, Integer.valueOf(this.zzaoX), Boolean.valueOf(this.zzaoW));
    }

    public void zzg(GoogleApiClient googleApiClient) {
        zzu zzu = (zzu) googleApiClient.zza(Drive.zzUI);
        if (zzsC() && !zzu.zzti()) {
            throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to be notified on completion");
        }
    }

    public String zzsB() {
        return this.zzaoV;
    }

    public boolean zzsC() {
        return this.zzaoW;
    }

    public int zzsD() {
        return this.zzaoX;
    }
}

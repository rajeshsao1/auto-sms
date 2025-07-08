package com.google.android.gms.drive;

import com.google.android.gms.drive.ExecutionOptions;

public class zzh extends ExecutionOptions {
    private String zzaoY;
    private String zzaoZ;

    public static class zza extends ExecutionOptions.Builder {
        private String zzaoY;
        private String zzaoZ;

        /* renamed from: zzad */
        public zza setNotifyOnCompletion(boolean z) {
            super.setNotifyOnCompletion(z);
            return this;
        }

        /* renamed from: zzcY */
        public zza setTrackingTag(String str) {
            super.setTrackingTag(str);
            return this;
        }

        /* renamed from: zzcx */
        public zza setConflictStrategy(int i) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: zzsH */
        public zzh build() {
            zzsE();
            return new zzh(this.zzaoV, this.zzaoW, this.zzaoY, this.zzaoZ, this.zzaoX);
        }
    }

    private zzh(String str, boolean z, String str2, String str3, int i) {
        super(str, z, i);
        this.zzaoY = str2;
        this.zzaoZ = str3;
    }

    public static zzh zza(ExecutionOptions executionOptions) {
        zza zza2 = new zza();
        if (executionOptions != null) {
            if (executionOptions.zzsD() == 0) {
                String zzsB = executionOptions.zzsB();
                if (zzsB != null) {
                    zza2.setTrackingTag(zzsB);
                }
                zza2.setNotifyOnCompletion(executionOptions.zzsC());
            } else {
                throw new IllegalStateException("May not set a conflict strategy for new file creation.");
            }
        }
        return zza2.build();
    }

    public String zzsF() {
        return this.zzaoY;
    }

    public String zzsG() {
        return this.zzaoZ;
    }
}

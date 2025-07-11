package com.google.android.gms.drive;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zznm;
import com.google.android.gms.internal.zzno;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public final class MetadataChangeSet {
    public static final int CUSTOM_PROPERTY_SIZE_LIMIT_BYTES = 124;
    public static final int INDEXABLE_TEXT_SIZE_LIMIT_BYTES = 131072;
    public static final int MAX_PRIVATE_PROPERTIES_PER_RESOURCE_PER_APP = 30;
    public static final int MAX_PUBLIC_PROPERTIES_PER_RESOURCE = 30;
    public static final int MAX_TOTAL_PROPERTIES_PER_RESOURCE = 100;
    public static final MetadataChangeSet zzapd = new MetadataChangeSet(MetadataBundle.zztE());
    private final MetadataBundle zzape;

    public static class Builder {
        private final MetadataBundle zzape = MetadataBundle.zztE();
        private AppVisibleCustomProperties.zza zzapf;

        private int zzda(String str) {
            if (str == null) {
                return 0;
            }
            return str.getBytes().length;
        }

        private String zzj(String str, int i, int i2) {
            return String.format("%s must be no more than %d bytes, but is %d bytes.", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        }

        private void zzk(String str, int i, int i2) {
            zzx.zzb(i2 <= i, (Object) zzj(str, i, i2));
        }

        private AppVisibleCustomProperties.zza zzsN() {
            if (this.zzapf == null) {
                this.zzapf = new AppVisibleCustomProperties.zza();
            }
            return this.zzapf;
        }

        public MetadataChangeSet build() {
            if (this.zzapf != null) {
                this.zzape.zzc(zznm.zzasW, this.zzapf.zztA());
            }
            return new MetadataChangeSet(this.zzape);
        }

        public Builder deleteCustomProperty(CustomPropertyKey customPropertyKey) {
            zzx.zzb(customPropertyKey, (Object) "key");
            zzsN().zza(customPropertyKey, (String) null);
            return this;
        }

        public Builder setCustomProperty(CustomPropertyKey customPropertyKey, String str) {
            zzx.zzb(customPropertyKey, (Object) "key");
            zzx.zzb(str, (Object) "value");
            zzk("The total size of key string and value string of a custom property", 124, zzda(customPropertyKey.getKey()) + zzda(str));
            zzsN().zza(customPropertyKey, str);
            return this;
        }

        public Builder setDescription(String str) {
            this.zzape.zzc(zznm.zzasX, str);
            return this;
        }

        public Builder setIndexableText(String str) {
            zzk("Indexable text size", 131072, zzda(str));
            this.zzape.zzc(zznm.zzatd, str);
            return this;
        }

        public Builder setLastViewedByMeDate(Date date) {
            this.zzape.zzc(zzno.zzatN, date);
            return this;
        }

        public Builder setMimeType(String str) {
            this.zzape.zzc(zznm.zzatr, str);
            return this;
        }

        public Builder setPinned(boolean z) {
            this.zzape.zzc(zznm.zzatj, Boolean.valueOf(z));
            return this;
        }

        public Builder setStarred(boolean z) {
            this.zzape.zzc(zznm.zzaty, Boolean.valueOf(z));
            return this;
        }

        public Builder setTitle(String str) {
            this.zzape.zzc(zznm.zzatA, str);
            return this;
        }

        public Builder setViewed(boolean z) {
            this.zzape.zzc(zznm.zzatq, Boolean.valueOf(z));
            return this;
        }
    }

    public MetadataChangeSet(MetadataBundle metadataBundle) {
        this.zzape = metadataBundle.zztF();
    }

    public Map<CustomPropertyKey, String> getCustomPropertyChangeMap() {
        AppVisibleCustomProperties appVisibleCustomProperties = (AppVisibleCustomProperties) this.zzape.zza(zznm.zzasW);
        return appVisibleCustomProperties == null ? Collections.emptyMap() : appVisibleCustomProperties.zztz();
    }

    public String getDescription() {
        return (String) this.zzape.zza(zznm.zzasX);
    }

    public String getIndexableText() {
        return (String) this.zzape.zza(zznm.zzatd);
    }

    public Date getLastViewedByMeDate() {
        return (Date) this.zzape.zza(zzno.zzatN);
    }

    public String getMimeType() {
        return (String) this.zzape.zza(zznm.zzatr);
    }

    public String getTitle() {
        return (String) this.zzape.zza(zznm.zzatA);
    }

    public Boolean isPinned() {
        return (Boolean) this.zzape.zza(zznm.zzatj);
    }

    public Boolean isStarred() {
        return (Boolean) this.zzape.zza(zznm.zzaty);
    }

    public Boolean isViewed() {
        return (Boolean) this.zzape.zza(zznm.zzatq);
    }

    public <T> MetadataChangeSet zza(MetadataField<T> metadataField, T t) {
        MetadataChangeSet zzsM = zzsM();
        zzsM.zzsL().zzc(metadataField, t);
        return zzsM;
    }

    public MetadataBundle zzsL() {
        return this.zzape;
    }

    public MetadataChangeSet zzsM() {
        return new MetadataChangeSet(zzsL());
    }
}

package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.internal.zzmo;
import com.google.android.gms.internal.zznb;
import com.google.android.gms.internal.zznc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FastJsonResponse {

    public static class Field<I, O> implements SafeParcelable {
        public static final zza CREATOR = new zza();
        private final int mVersionCode;
        protected final int zzamL;
        protected final boolean zzamM;
        protected final int zzamN;
        protected final boolean zzamO;
        protected final String zzamP;
        protected final int zzamQ;
        protected final Class<? extends FastJsonResponse> zzamR;
        protected final String zzamS;
        private FieldMappingDictionary zzamT;
        /* access modifiers changed from: private */
        public zza<I, O> zzamU;

        Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ConverterWrapper converterWrapper) {
            this.mVersionCode = i;
            this.zzamL = i2;
            this.zzamM = z;
            this.zzamN = i3;
            this.zzamO = z2;
            this.zzamP = str;
            this.zzamQ = i4;
            zza<?, ?> zza = null;
            if (str2 == null) {
                this.zzamR = null;
                this.zzamS = null;
            } else {
                this.zzamR = SafeParcelResponse.class;
                this.zzamS = str2;
            }
            this.zzamU = converterWrapper != null ? converterWrapper.zzrh() : zza;
        }

        protected Field(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends FastJsonResponse> cls, zza<I, O> zza) {
            this.mVersionCode = 1;
            this.zzamL = i;
            this.zzamM = z;
            this.zzamN = i2;
            this.zzamO = z2;
            this.zzamP = str;
            this.zzamQ = i3;
            this.zzamR = cls;
            this.zzamS = cls == null ? null : cls.getCanonicalName();
            this.zzamU = zza;
        }

        public static Field zza(String str, int i, zza<?, ?> zza, boolean z) {
            return new Field(zza.zzrj(), z, zza.zzrk(), false, str, i, (Class<? extends FastJsonResponse>) null, zza);
        }

        public static <T extends FastJsonResponse> Field<T, T> zza(String str, int i, Class<T> cls) {
            return new Field(11, false, 11, false, str, i, cls, (zza) null);
        }

        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> zzb(String str, int i, Class<T> cls) {
            return new Field(11, true, 11, true, str, i, cls, (zza) null);
        }

        public static Field<Integer, Integer> zzi(String str, int i) {
            return new Field(0, false, 0, false, str, i, (Class<? extends FastJsonResponse>) null, (zza) null);
        }

        public static Field<Double, Double> zzj(String str, int i) {
            return new Field(4, false, 4, false, str, i, (Class<? extends FastJsonResponse>) null, (zza) null);
        }

        public static Field<Boolean, Boolean> zzk(String str, int i) {
            return new Field(6, false, 6, false, str, i, (Class<? extends FastJsonResponse>) null, (zza) null);
        }

        public static Field<String, String> zzl(String str, int i) {
            return new Field(7, false, 7, false, str, i, (Class<? extends FastJsonResponse>) null, (zza) null);
        }

        public static Field<ArrayList<String>, ArrayList<String>> zzm(String str, int i) {
            return new Field(7, true, 7, true, str, i, (Class<? extends FastJsonResponse>) null, (zza) null);
        }

        public I convertBack(O o) {
            return this.zzamU.convertBack(o);
        }

        public int describeContents() {
            return 0;
        }

        public int getVersionCode() {
            return this.mVersionCode;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Field\n");
            sb.append("            versionCode=");
            sb.append(this.mVersionCode);
            sb.append(10);
            sb.append("                 typeIn=");
            sb.append(this.zzamL);
            sb.append(10);
            sb.append("            typeInArray=");
            sb.append(this.zzamM);
            sb.append(10);
            sb.append("                typeOut=");
            sb.append(this.zzamN);
            sb.append(10);
            sb.append("           typeOutArray=");
            sb.append(this.zzamO);
            sb.append(10);
            sb.append("        outputFieldName=");
            sb.append(this.zzamP);
            sb.append(10);
            sb.append("      safeParcelFieldId=");
            sb.append(this.zzamQ);
            sb.append(10);
            sb.append("       concreteTypeName=");
            sb.append(zzru());
            sb.append(10);
            if (zzrt() != null) {
                sb.append("     concreteType.class=");
                sb.append(zzrt().getCanonicalName());
                sb.append(10);
            }
            sb.append("          converterName=");
            zza<I, O> zza = this.zzamU;
            sb.append(zza == null ? "null" : zza.getClass().getCanonicalName());
            sb.append(10);
            return sb.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            zza.zza(this, parcel, i);
        }

        public void zza(FieldMappingDictionary fieldMappingDictionary) {
            this.zzamT = fieldMappingDictionary;
        }

        public int zzrj() {
            return this.zzamL;
        }

        public int zzrk() {
            return this.zzamN;
        }

        public Field<I, O> zzro() {
            return new Field(this.mVersionCode, this.zzamL, this.zzamM, this.zzamN, this.zzamO, this.zzamP, this.zzamQ, this.zzamS, zzrw());
        }

        public boolean zzrp() {
            return this.zzamM;
        }

        public boolean zzrq() {
            return this.zzamO;
        }

        public String zzrr() {
            return this.zzamP;
        }

        public int zzrs() {
            return this.zzamQ;
        }

        public Class<? extends FastJsonResponse> zzrt() {
            return this.zzamR;
        }

        /* access modifiers changed from: package-private */
        public String zzru() {
            String str = this.zzamS;
            if (str == null) {
                return null;
            }
            return str;
        }

        public boolean zzrv() {
            return this.zzamU != null;
        }

        /* access modifiers changed from: package-private */
        public ConverterWrapper zzrw() {
            zza<I, O> zza = this.zzamU;
            if (zza == null) {
                return null;
            }
            return ConverterWrapper.zza(zza);
        }

        public Map<String, Field<?, ?>> zzrx() {
            zzx.zzz(this.zzamS);
            zzx.zzz(this.zzamT);
            return this.zzamT.zzcR(this.zzamS);
        }
    }

    public interface zza<I, O> {
        I convertBack(O o);

        int zzrj();

        int zzrk();
    }

    private void zza(StringBuilder sb, Field field, Object obj) {
        String str;
        if (field.zzrj() == 11) {
            str = ((FastJsonResponse) field.zzrt().cast(obj)).toString();
        } else if (field.zzrj() == 7) {
            str = "\"";
            sb.append(str);
            sb.append(zznb.zzcU((String) obj));
        } else {
            sb.append(obj);
            return;
        }
        sb.append(str);
    }

    private void zza(StringBuilder sb, Field field, ArrayList<Object> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                zza(sb, field, obj);
            }
        }
        sb.append("]");
    }

    public String toString() {
        String str;
        Map<String, Field<?, ?>> zzrl = zzrl();
        StringBuilder sb = new StringBuilder(100);
        for (String next : zzrl.keySet()) {
            Field field = zzrl.get(next);
            if (zza(field)) {
                Object zza2 = zza(field, zzb(field));
                sb.append(sb.length() == 0 ? "{" : ",");
                sb.append("\"");
                sb.append(next);
                sb.append("\":");
                if (zza2 == null) {
                    sb.append("null");
                } else {
                    switch (field.zzrk()) {
                        case 8:
                            sb.append("\"");
                            str = zzmo.zzj((byte[]) zza2);
                            break;
                        case 9:
                            sb.append("\"");
                            str = zzmo.zzk((byte[]) zza2);
                            break;
                        case 10:
                            zznc.zza(sb, (HashMap) zza2);
                            continue;
                        default:
                            if (!field.zzrp()) {
                                zza(sb, field, zza2);
                                break;
                            } else {
                                zza(sb, field, (ArrayList<Object>) (ArrayList) zza2);
                                continue;
                            }
                    }
                    sb.append(str);
                    sb.append("\"");
                }
            }
        }
        sb.append(sb.length() > 0 ? "}" : "{}");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public <O, I> I zza(Field<I, O> field, Object obj) {
        return field.zzamU != null ? field.convertBack(obj) : obj;
    }

    /* access modifiers changed from: protected */
    public boolean zza(Field field) {
        if (field.zzrk() != 11) {
            return zzcO(field.zzrr());
        }
        boolean zzrq = field.zzrq();
        String zzrr = field.zzrr();
        return zzrq ? zzcQ(zzrr) : zzcP(zzrr);
    }

    /* access modifiers changed from: protected */
    public Object zzb(Field field) {
        String zzrr = field.zzrr();
        if (field.zzrt() == null) {
            return zzcN(field.zzrr());
        }
        zzx.zza(zzcN(field.zzrr()) == null, "Concrete field shouldn't be value object: %s", field.zzrr());
        HashMap<String, Object> zzrn = field.zzrq() ? zzrn() : zzrm();
        if (zzrn != null) {
            return zzrn.get(zzrr);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(zzrr.charAt(0)) + zzrr.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zzcN(String str);

    /* access modifiers changed from: protected */
    public abstract boolean zzcO(String str);

    /* access modifiers changed from: protected */
    public boolean zzcP(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    /* access modifiers changed from: protected */
    public boolean zzcQ(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public abstract Map<String, Field<?, ?>> zzrl();

    public HashMap<String, Object> zzrm() {
        return null;
    }

    public HashMap<String, Object> zzrn() {
        return null;
    }
}

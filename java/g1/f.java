package g1;

import android.os.Parcel;
import android.os.Parcelable;
import i2.c1;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class f extends i {
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final String f3977b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3978c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3979d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f3980e;

    class a implements Parcelable.Creator<f> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int i6) {
            return new f[i6];
        }
    }

    f(Parcel parcel) {
        super("GEOB");
        this.f3977b = (String) c1.j(parcel.readString());
        this.f3978c = (String) c1.j(parcel.readString());
        this.f3979d = (String) c1.j(parcel.readString());
        this.f3980e = (byte[]) c1.j(parcel.createByteArray());
    }

    public f(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f3977b = str;
        this.f3978c = str2;
        this.f3979d = str3;
        this.f3980e = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return c1.c(this.f3977b, fVar.f3977b) && c1.c(this.f3978c, fVar.f3978c) && c1.c(this.f3979d, fVar.f3979d) && Arrays.equals(this.f3980e, fVar.f3980e);
    }

    public int hashCode() {
        String str = this.f3977b;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f3978c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f3979d;
        return ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.f3980e);
    }

    @Override // g1.i
    public String toString() {
        return this.f3986a + ": mimeType=" + this.f3977b + ", filename=" + this.f3978c + ", description=" + this.f3979d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f3977b);
        parcel.writeString(this.f3978c);
        parcel.writeString(this.f3979d);
        parcel.writeByteArray(this.f3980e);
    }
}

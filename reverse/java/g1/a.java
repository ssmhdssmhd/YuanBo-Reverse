package g1;

import android.os.Parcel;
import android.os.Parcelable;
import h0.m2;
import i2.c1;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a extends i {
    public static final Parcelable.Creator<a> CREATOR = new C0076a();

    /* renamed from: b, reason: collision with root package name */
    public final String f3958b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3959c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3960d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f3961e;

    /* renamed from: g1.a$a, reason: collision with other inner class name */
    class C0076a implements Parcelable.Creator<a> {
        C0076a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i6) {
            return new a[i6];
        }
    }

    a(Parcel parcel) {
        super("APIC");
        this.f3958b = (String) c1.j(parcel.readString());
        this.f3959c = parcel.readString();
        this.f3960d = parcel.readInt();
        this.f3961e = (byte[]) c1.j(parcel.createByteArray());
    }

    public a(String str, String str2, int i6, byte[] bArr) {
        super("APIC");
        this.f3958b = str;
        this.f3959c = str2;
        this.f3960d = i6;
        this.f3961e = bArr;
    }

    @Override // g1.i, b1.a.b
    public void a(m2.b bVar) {
        bVar.I(this.f3961e, this.f3960d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f3960d == aVar.f3960d && c1.c(this.f3958b, aVar.f3958b) && c1.c(this.f3959c, aVar.f3959c) && Arrays.equals(this.f3961e, aVar.f3961e);
    }

    public int hashCode() {
        int i6 = (527 + this.f3960d) * 31;
        String str = this.f3958b;
        int hashCode = (i6 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f3959c;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f3961e);
    }

    @Override // g1.i
    public String toString() {
        return this.f3986a + ": mimeType=" + this.f3958b + ", description=" + this.f3959c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f3958b);
        parcel.writeString(this.f3959c);
        parcel.writeInt(this.f3960d);
        parcel.writeByteArray(this.f3961e);
    }
}

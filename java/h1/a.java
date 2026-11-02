package h1;

import android.os.Parcel;
import android.os.Parcelable;
import b1.a;
import h0.m2;
import h0.y1;
import i2.c1;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements a.b {
    public static final Parcelable.Creator<a> CREATOR = new C0082a();

    /* renamed from: a, reason: collision with root package name */
    public final String f5113a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f5114b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5115c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5116d;

    /* renamed from: h1.a$a, reason: collision with other inner class name */
    class C0082a implements Parcelable.Creator<a> {
        C0082a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i6) {
            return new a[i6];
        }
    }

    private a(Parcel parcel) {
        this.f5113a = (String) c1.j(parcel.readString());
        this.f5114b = (byte[]) c1.j(parcel.createByteArray());
        this.f5115c = parcel.readInt();
        this.f5116d = parcel.readInt();
    }

    /* synthetic */ a(Parcel parcel, C0082a c0082a) {
        this(parcel);
    }

    public a(String str, byte[] bArr, int i6, int i7) {
        this.f5113a = str;
        this.f5114b = bArr;
        this.f5115c = i6;
        this.f5116d = i7;
    }

    @Override // b1.a.b
    public /* synthetic */ void a(m2.b bVar) {
        b1.b.c(this, bVar);
    }

    @Override // b1.a.b
    public /* synthetic */ y1 b() {
        return b1.b.b(this);
    }

    @Override // b1.a.b
    public /* synthetic */ byte[] c() {
        return b1.b.a(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f5113a.equals(aVar.f5113a) && Arrays.equals(this.f5114b, aVar.f5114b) && this.f5115c == aVar.f5115c && this.f5116d == aVar.f5116d;
    }

    public int hashCode() {
        return ((((((527 + this.f5113a.hashCode()) * 31) + Arrays.hashCode(this.f5114b)) * 31) + this.f5115c) * 31) + this.f5116d;
    }

    public String toString() {
        return "mdta: key=" + this.f5113a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f5113a);
        parcel.writeByteArray(this.f5114b);
        parcel.writeInt(this.f5115c);
        parcel.writeInt(this.f5116d);
    }
}

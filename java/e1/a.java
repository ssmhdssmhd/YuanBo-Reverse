package e1;

import android.os.Parcel;
import android.os.Parcelable;
import b1.a;
import h0.m2;
import h0.y1;
import i2.c1;
import i2.i0;
import java.util.Arrays;
import l2.d;

/* loaded from: classes.dex */
public final class a implements a.b {
    public static final Parcelable.Creator<a> CREATOR = new C0067a();

    /* renamed from: a, reason: collision with root package name */
    public final int f3378a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3379b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3380c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3381d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3382e;

    /* renamed from: j, reason: collision with root package name */
    public final int f3383j;

    /* renamed from: k, reason: collision with root package name */
    public final int f3384k;

    /* renamed from: l, reason: collision with root package name */
    public final byte[] f3385l;

    /* renamed from: e1.a$a, reason: collision with other inner class name */
    class C0067a implements Parcelable.Creator<a> {
        C0067a() {
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

    public a(int i6, String str, String str2, int i7, int i8, int i9, int i10, byte[] bArr) {
        this.f3378a = i6;
        this.f3379b = str;
        this.f3380c = str2;
        this.f3381d = i7;
        this.f3382e = i8;
        this.f3383j = i9;
        this.f3384k = i10;
        this.f3385l = bArr;
    }

    a(Parcel parcel) {
        this.f3378a = parcel.readInt();
        this.f3379b = (String) c1.j(parcel.readString());
        this.f3380c = (String) c1.j(parcel.readString());
        this.f3381d = parcel.readInt();
        this.f3382e = parcel.readInt();
        this.f3383j = parcel.readInt();
        this.f3384k = parcel.readInt();
        this.f3385l = (byte[]) c1.j(parcel.createByteArray());
    }

    public static a d(i0 i0Var) {
        int o6 = i0Var.o();
        String D = i0Var.D(i0Var.o(), d.f7487a);
        String C = i0Var.C(i0Var.o());
        int o7 = i0Var.o();
        int o8 = i0Var.o();
        int o9 = i0Var.o();
        int o10 = i0Var.o();
        int o11 = i0Var.o();
        byte[] bArr = new byte[o11];
        i0Var.j(bArr, 0, o11);
        return new a(o6, D, C, o7, o8, o9, o10, bArr);
    }

    @Override // b1.a.b
    public void a(m2.b bVar) {
        bVar.I(this.f3385l, this.f3378a);
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
        return this.f3378a == aVar.f3378a && this.f3379b.equals(aVar.f3379b) && this.f3380c.equals(aVar.f3380c) && this.f3381d == aVar.f3381d && this.f3382e == aVar.f3382e && this.f3383j == aVar.f3383j && this.f3384k == aVar.f3384k && Arrays.equals(this.f3385l, aVar.f3385l);
    }

    public int hashCode() {
        return ((((((((((((((527 + this.f3378a) * 31) + this.f3379b.hashCode()) * 31) + this.f3380c.hashCode()) * 31) + this.f3381d) * 31) + this.f3382e) * 31) + this.f3383j) * 31) + this.f3384k) * 31) + Arrays.hashCode(this.f3385l);
    }

    public String toString() {
        return "Picture: mimeType=" + this.f3379b + ", description=" + this.f3380c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f3378a);
        parcel.writeString(this.f3379b);
        parcel.writeString(this.f3380c);
        parcel.writeInt(this.f3381d);
        parcel.writeInt(this.f3382e);
        parcel.writeInt(this.f3383j);
        parcel.writeInt(this.f3384k);
        parcel.writeByteArray(this.f3385l);
    }
}

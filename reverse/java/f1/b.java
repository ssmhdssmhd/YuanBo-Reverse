package f1;

import android.os.Parcel;
import android.os.Parcelable;
import b1.a;
import h0.m2;
import h0.y1;
import i2.c1;

/* loaded from: classes.dex */
public final class b implements a.b {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f3778a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3779b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3780c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3781d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f3782e;

    /* renamed from: j, reason: collision with root package name */
    public final int f3783j;

    class a implements Parcelable.Creator<b> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i6) {
            return new b[i6];
        }
    }

    public b(int i6, String str, String str2, String str3, boolean z5, int i7) {
        i2.a.a(i7 == -1 || i7 > 0);
        this.f3778a = i6;
        this.f3779b = str;
        this.f3780c = str2;
        this.f3781d = str3;
        this.f3782e = z5;
        this.f3783j = i7;
    }

    b(Parcel parcel) {
        this.f3778a = parcel.readInt();
        this.f3779b = parcel.readString();
        this.f3780c = parcel.readString();
        this.f3781d = parcel.readString();
        this.f3782e = c1.N0(parcel);
        this.f3783j = parcel.readInt();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static f1.b d(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r13) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f1.b.d(java.util.Map):f1.b");
    }

    @Override // b1.a.b
    public void a(m2.b bVar) {
        String str = this.f3780c;
        if (str != null) {
            bVar.k0(str);
        }
        String str2 = this.f3779b;
        if (str2 != null) {
            bVar.Z(str2);
        }
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
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f3778a == bVar.f3778a && c1.c(this.f3779b, bVar.f3779b) && c1.c(this.f3780c, bVar.f3780c) && c1.c(this.f3781d, bVar.f3781d) && this.f3782e == bVar.f3782e && this.f3783j == bVar.f3783j;
    }

    public int hashCode() {
        int i6 = (527 + this.f3778a) * 31;
        String str = this.f3779b;
        int hashCode = (i6 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f3780c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f3781d;
        return ((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.f3782e ? 1 : 0)) * 31) + this.f3783j;
    }

    public String toString() {
        return "IcyHeaders: name=\"" + this.f3780c + "\", genre=\"" + this.f3779b + "\", bitrate=" + this.f3778a + ", metadataInterval=" + this.f3783j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f3778a);
        parcel.writeString(this.f3779b);
        parcel.writeString(this.f3780c);
        parcel.writeString(this.f3781d);
        c1.f1(parcel, this.f3782e);
        parcel.writeInt(this.f3783j);
    }
}

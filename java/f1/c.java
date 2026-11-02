package f1;

import android.os.Parcel;
import android.os.Parcelable;
import b1.a;
import h0.m2;
import h0.y1;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class c implements a.b {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f3784a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3785b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3786c;

    class a implements Parcelable.Creator<c> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i6) {
            return new c[i6];
        }
    }

    c(Parcel parcel) {
        this.f3784a = (byte[]) i2.a.e(parcel.createByteArray());
        this.f3785b = parcel.readString();
        this.f3786c = parcel.readString();
    }

    public c(byte[] bArr, String str, String str2) {
        this.f3784a = bArr;
        this.f3785b = str;
        this.f3786c = str2;
    }

    @Override // b1.a.b
    public void a(m2.b bVar) {
        String str = this.f3785b;
        if (str != null) {
            bVar.m0(str);
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
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f3784a, ((c) obj).f3784a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f3784a);
    }

    public String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", this.f3785b, this.f3786c, Integer.valueOf(this.f3784a.length));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeByteArray(this.f3784a);
        parcel.writeString(this.f3785b);
        parcel.writeString(this.f3786c);
    }
}

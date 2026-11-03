package k1;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class c implements Comparable<c>, Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f6859a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6860b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6861c;

    /* renamed from: d, reason: collision with root package name */
    @Deprecated
    public final int f6862d;

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

    public c(int i6, int i7, int i8) {
        this.f6859a = i6;
        this.f6860b = i7;
        this.f6861c = i8;
        this.f6862d = i8;
    }

    c(Parcel parcel) {
        this.f6859a = parcel.readInt();
        this.f6860b = parcel.readInt();
        int readInt = parcel.readInt();
        this.f6861c = readInt;
        this.f6862d = readInt;
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        int i6 = this.f6859a - cVar.f6859a;
        if (i6 != 0) {
            return i6;
        }
        int i7 = this.f6860b - cVar.f6860b;
        return i7 == 0 ? this.f6861c - cVar.f6861c : i7;
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
        c cVar = (c) obj;
        return this.f6859a == cVar.f6859a && this.f6860b == cVar.f6860b && this.f6861c == cVar.f6861c;
    }

    public int hashCode() {
        return (((this.f6859a * 31) + this.f6860b) * 31) + this.f6861c;
    }

    public String toString() {
        return this.f6859a + "." + this.f6860b + "." + this.f6861c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f6859a);
        parcel.writeInt(this.f6860b);
        parcel.writeInt(this.f6861c);
    }
}

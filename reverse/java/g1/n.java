package g1;

import android.os.Parcel;
import android.os.Parcelable;
import i2.c1;

/* loaded from: classes.dex */
public final class n extends i {
    public static final Parcelable.Creator<n> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final String f4000b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4001c;

    class a implements Parcelable.Creator<n> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n createFromParcel(Parcel parcel) {
            return new n(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public n[] newArray(int i6) {
            return new n[i6];
        }
    }

    n(Parcel parcel) {
        super((String) c1.j(parcel.readString()));
        this.f4000b = parcel.readString();
        this.f4001c = (String) c1.j(parcel.readString());
    }

    public n(String str, String str2, String str3) {
        super(str);
        this.f4000b = str2;
        this.f4001c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        return this.f3986a.equals(nVar.f3986a) && c1.c(this.f4000b, nVar.f4000b) && c1.c(this.f4001c, nVar.f4001c);
    }

    public int hashCode() {
        int hashCode = (527 + this.f3986a.hashCode()) * 31;
        String str = this.f4000b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f4001c;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // g1.i
    public String toString() {
        return this.f3986a + ": url=" + this.f4001c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f3986a);
        parcel.writeString(this.f4000b);
        parcel.writeString(this.f4001c);
    }
}

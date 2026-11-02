package g1;

import android.os.Parcel;
import android.os.Parcelable;
import i2.c1;

/* loaded from: classes.dex */
public final class j extends i {
    public static final Parcelable.Creator<j> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final String f3987b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3988c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3989d;

    class a implements Parcelable.Creator<j> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public j[] newArray(int i6) {
            return new j[i6];
        }
    }

    j(Parcel parcel) {
        super("----");
        this.f3987b = (String) c1.j(parcel.readString());
        this.f3988c = (String) c1.j(parcel.readString());
        this.f3989d = (String) c1.j(parcel.readString());
    }

    public j(String str, String str2, String str3) {
        super("----");
        this.f3987b = str;
        this.f3988c = str2;
        this.f3989d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return c1.c(this.f3988c, jVar.f3988c) && c1.c(this.f3987b, jVar.f3987b) && c1.c(this.f3989d, jVar.f3989d);
    }

    public int hashCode() {
        String str = this.f3987b;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f3988c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f3989d;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // g1.i
    public String toString() {
        return this.f3986a + ": domain=" + this.f3987b + ", description=" + this.f3988c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f3986a);
        parcel.writeString(this.f3987b);
        parcel.writeString(this.f3989d);
    }
}

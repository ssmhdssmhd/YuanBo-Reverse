package g1;

import android.os.Parcel;
import android.os.Parcelable;
import i2.c1;

/* loaded from: classes.dex */
public final class e extends i {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final String f3974b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3975c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3976d;

    class a implements Parcelable.Creator<e> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i6) {
            return new e[i6];
        }
    }

    e(Parcel parcel) {
        super("COMM");
        this.f3974b = (String) c1.j(parcel.readString());
        this.f3975c = (String) c1.j(parcel.readString());
        this.f3976d = (String) c1.j(parcel.readString());
    }

    public e(String str, String str2, String str3) {
        super("COMM");
        this.f3974b = str;
        this.f3975c = str2;
        this.f3976d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return c1.c(this.f3975c, eVar.f3975c) && c1.c(this.f3974b, eVar.f3974b) && c1.c(this.f3976d, eVar.f3976d);
    }

    public int hashCode() {
        String str = this.f3974b;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f3975c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f3976d;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // g1.i
    public String toString() {
        return this.f3986a + ": language=" + this.f3974b + ", description=" + this.f3975c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f3986a);
        parcel.writeString(this.f3974b);
        parcel.writeString(this.f3976d);
    }
}

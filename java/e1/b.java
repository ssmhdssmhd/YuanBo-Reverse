package e1;

import android.os.Parcel;
import android.os.Parcelable;
import b1.a;
import h0.m2;
import h0.y1;
import i2.c1;

@Deprecated
/* loaded from: classes.dex */
public class b implements a.b {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f3386a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3387b;

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

    protected b(Parcel parcel) {
        this.f3386a = (String) c1.j(parcel.readString());
        this.f3387b = (String) c1.j(parcel.readString());
    }

    public b(String str, String str2) {
        this.f3386a = str;
        this.f3387b = str2;
    }

    @Override // b1.a.b
    public void a(m2.b bVar) {
        String str = this.f3386a;
        str.hashCode();
        switch (str) {
            case "ALBUM":
                bVar.N(this.f3387b);
                break;
            case "TITLE":
                bVar.m0(this.f3387b);
                break;
            case "DESCRIPTION":
                bVar.U(this.f3387b);
                break;
            case "ALBUMARTIST":
                bVar.M(this.f3387b);
                break;
            case "ARTIST":
                bVar.O(this.f3387b);
                break;
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
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f3386a.equals(bVar.f3386a) && this.f3387b.equals(bVar.f3387b);
    }

    public int hashCode() {
        return ((527 + this.f3386a.hashCode()) * 31) + this.f3387b.hashCode();
    }

    public String toString() {
        return "VC: " + this.f3386a + "=" + this.f3387b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f3386a);
        parcel.writeString(this.f3387b);
    }
}

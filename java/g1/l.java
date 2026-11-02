package g1;

import android.os.Parcel;
import android.os.Parcelable;
import i2.c1;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class l extends i {
    public static final Parcelable.Creator<l> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final String f3995b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f3996c;

    class a implements Parcelable.Creator<l> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public l createFromParcel(Parcel parcel) {
            return new l(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public l[] newArray(int i6) {
            return new l[i6];
        }
    }

    l(Parcel parcel) {
        super("PRIV");
        this.f3995b = (String) c1.j(parcel.readString());
        this.f3996c = (byte[]) c1.j(parcel.createByteArray());
    }

    public l(String str, byte[] bArr) {
        super("PRIV");
        this.f3995b = str;
        this.f3996c = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return c1.c(this.f3995b, lVar.f3995b) && Arrays.equals(this.f3996c, lVar.f3996c);
    }

    public int hashCode() {
        String str = this.f3995b;
        return ((527 + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.f3996c);
    }

    @Override // g1.i
    public String toString() {
        return this.f3986a + ": owner=" + this.f3995b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f3995b);
        parcel.writeByteArray(this.f3996c);
    }
}

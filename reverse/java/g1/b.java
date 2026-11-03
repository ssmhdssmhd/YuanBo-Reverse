package g1;

import android.os.Parcel;
import android.os.Parcelable;
import i2.c1;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class b extends i {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f3962b;

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

    b(Parcel parcel) {
        super((String) c1.j(parcel.readString()));
        this.f3962b = (byte[]) c1.j(parcel.createByteArray());
    }

    public b(String str, byte[] bArr) {
        super(str);
        this.f3962b = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f3986a.equals(bVar.f3986a) && Arrays.equals(this.f3962b, bVar.f3962b);
    }

    public int hashCode() {
        return ((527 + this.f3986a.hashCode()) * 31) + Arrays.hashCode(this.f3962b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f3986a);
        parcel.writeByteArray(this.f3962b);
    }
}

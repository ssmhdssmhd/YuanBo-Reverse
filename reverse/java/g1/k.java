package g1;

import android.os.Parcel;
import android.os.Parcelable;
import i2.c1;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class k extends i {
    public static final Parcelable.Creator<k> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final int f3990b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3991c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3992d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f3993e;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f3994j;

    class a implements Parcelable.Creator<k> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public k createFromParcel(Parcel parcel) {
            return new k(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public k[] newArray(int i6) {
            return new k[i6];
        }
    }

    public k(int i6, int i7, int i8, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.f3990b = i6;
        this.f3991c = i7;
        this.f3992d = i8;
        this.f3993e = iArr;
        this.f3994j = iArr2;
    }

    k(Parcel parcel) {
        super("MLLT");
        this.f3990b = parcel.readInt();
        this.f3991c = parcel.readInt();
        this.f3992d = parcel.readInt();
        this.f3993e = (int[]) c1.j(parcel.createIntArray());
        this.f3994j = (int[]) c1.j(parcel.createIntArray());
    }

    @Override // g1.i, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.f3990b == kVar.f3990b && this.f3991c == kVar.f3991c && this.f3992d == kVar.f3992d && Arrays.equals(this.f3993e, kVar.f3993e) && Arrays.equals(this.f3994j, kVar.f3994j);
    }

    public int hashCode() {
        return ((((((((527 + this.f3990b) * 31) + this.f3991c) * 31) + this.f3992d) * 31) + Arrays.hashCode(this.f3993e)) * 31) + Arrays.hashCode(this.f3994j);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f3990b);
        parcel.writeInt(this.f3991c);
        parcel.writeInt(this.f3992d);
        parcel.writeIntArray(this.f3993e);
        parcel.writeIntArray(this.f3994j);
    }
}

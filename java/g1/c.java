package g1;

import android.os.Parcel;
import android.os.Parcelable;
import i2.c1;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class c extends i {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final String f3963b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3964c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3965d;

    /* renamed from: e, reason: collision with root package name */
    public final long f3966e;

    /* renamed from: j, reason: collision with root package name */
    public final long f3967j;

    /* renamed from: k, reason: collision with root package name */
    private final i[] f3968k;

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
        super("CHAP");
        this.f3963b = (String) c1.j(parcel.readString());
        this.f3964c = parcel.readInt();
        this.f3965d = parcel.readInt();
        this.f3966e = parcel.readLong();
        this.f3967j = parcel.readLong();
        int readInt = parcel.readInt();
        this.f3968k = new i[readInt];
        for (int i6 = 0; i6 < readInt; i6++) {
            this.f3968k[i6] = (i) parcel.readParcelable(i.class.getClassLoader());
        }
    }

    public c(String str, int i6, int i7, long j6, long j7, i[] iVarArr) {
        super("CHAP");
        this.f3963b = str;
        this.f3964c = i6;
        this.f3965d = i7;
        this.f3966e = j6;
        this.f3967j = j7;
        this.f3968k = iVarArr;
    }

    @Override // g1.i, android.os.Parcelable
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
        return this.f3964c == cVar.f3964c && this.f3965d == cVar.f3965d && this.f3966e == cVar.f3966e && this.f3967j == cVar.f3967j && c1.c(this.f3963b, cVar.f3963b) && Arrays.equals(this.f3968k, cVar.f3968k);
    }

    public int hashCode() {
        int i6 = (((((((527 + this.f3964c) * 31) + this.f3965d) * 31) + ((int) this.f3966e)) * 31) + ((int) this.f3967j)) * 31;
        String str = this.f3963b;
        return i6 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f3963b);
        parcel.writeInt(this.f3964c);
        parcel.writeInt(this.f3965d);
        parcel.writeLong(this.f3966e);
        parcel.writeLong(this.f3967j);
        parcel.writeInt(this.f3968k.length);
        for (i iVar : this.f3968k) {
            parcel.writeParcelable(iVar, 0);
        }
    }
}

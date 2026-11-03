package b1;

import android.os.Parcel;
import android.os.Parcelable;
import h0.m2;
import h0.y1;
import i2.c1;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0037a();

    /* renamed from: a, reason: collision with root package name */
    private final b[] f1694a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1695b;

    /* renamed from: b1.a$a, reason: collision with other inner class name */
    class C0037a implements Parcelable.Creator<a> {
        C0037a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i6) {
            return new a[i6];
        }
    }

    public interface b extends Parcelable {
        void a(m2.b bVar);

        y1 b();

        byte[] c();
    }

    public a(long j6, List<? extends b> list) {
        this(j6, (b[]) list.toArray(new b[0]));
    }

    public a(long j6, b... bVarArr) {
        this.f1695b = j6;
        this.f1694a = bVarArr;
    }

    a(Parcel parcel) {
        this.f1694a = new b[parcel.readInt()];
        int i6 = 0;
        while (true) {
            b[] bVarArr = this.f1694a;
            if (i6 >= bVarArr.length) {
                this.f1695b = parcel.readLong();
                return;
            } else {
                bVarArr[i6] = (b) parcel.readParcelable(b.class.getClassLoader());
                i6++;
            }
        }
    }

    public a(List<? extends b> list) {
        this((b[]) list.toArray(new b[0]));
    }

    public a(b... bVarArr) {
        this(-9223372036854775807L, bVarArr);
    }

    public a d(b... bVarArr) {
        return bVarArr.length == 0 ? this : new a(this.f1695b, (b[]) c1.H0(this.f1694a, bVarArr));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public a e(a aVar) {
        return aVar == null ? this : d(aVar.f1694a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return Arrays.equals(this.f1694a, aVar.f1694a) && this.f1695b == aVar.f1695b;
    }

    public a f(long j6) {
        return this.f1695b == j6 ? this : new a(j6, this.f1694a);
    }

    public b g(int i6) {
        return this.f1694a[i6];
    }

    public int h() {
        return this.f1694a.length;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f1694a) * 31) + o2.g.b(this.f1695b);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("entries=");
        sb.append(Arrays.toString(this.f1694a));
        if (this.f1695b == -9223372036854775807L) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + this.f1695b;
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f1694a.length);
        for (b bVar : this.f1694a) {
            parcel.writeParcelable(bVar, 0);
        }
        parcel.writeLong(this.f1695b);
    }
}

package h1;

import android.os.Parcel;
import android.os.Parcelable;
import b1.a;
import h0.m2;
import h0.y1;
import h1.c;
import i2.c1;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import l2.j;
import m2.k;

/* loaded from: classes.dex */
public final class c implements a.b {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final List<b> f5122a;

    class a implements Parcelable.Creator<c> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, b.class.getClassLoader());
            return new c(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i6) {
            return new c[i6];
        }
    }

    public static final class b implements Parcelable {

        /* renamed from: a, reason: collision with root package name */
        public final long f5124a;

        /* renamed from: b, reason: collision with root package name */
        public final long f5125b;

        /* renamed from: c, reason: collision with root package name */
        public final int f5126c;

        /* renamed from: d, reason: collision with root package name */
        public static final Comparator<b> f5123d = new Comparator() { // from class: h1.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int e6;
                e6 = c.b.e((c.b) obj, (c.b) obj2);
                return e6;
            }
        };
        public static final Parcelable.Creator<b> CREATOR = new a();

        class a implements Parcelable.Creator<b> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel.readLong(), parcel.readLong(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i6) {
                return new b[i6];
            }
        }

        public b(long j6, long j7, int i6) {
            i2.a.a(j6 < j7);
            this.f5124a = j6;
            this.f5125b = j7;
            this.f5126c = i6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int e(b bVar, b bVar2) {
            return k.j().e(bVar.f5124a, bVar2.f5124a).e(bVar.f5125b, bVar2.f5125b).d(bVar.f5126c, bVar2.f5126c).i();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f5124a == bVar.f5124a && this.f5125b == bVar.f5125b && this.f5126c == bVar.f5126c;
        }

        public int hashCode() {
            return j.b(Long.valueOf(this.f5124a), Long.valueOf(this.f5125b), Integer.valueOf(this.f5126c));
        }

        public String toString() {
            return c1.C("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", Long.valueOf(this.f5124a), Long.valueOf(this.f5125b), Integer.valueOf(this.f5126c));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeLong(this.f5124a);
            parcel.writeLong(this.f5125b);
            parcel.writeInt(this.f5126c);
        }
    }

    public c(List<b> list) {
        this.f5122a = list;
        i2.a.a(!d(list));
    }

    private static boolean d(List<b> list) {
        if (list.isEmpty()) {
            return false;
        }
        long j6 = list.get(0).f5125b;
        for (int i6 = 1; i6 < list.size(); i6++) {
            if (list.get(i6).f5124a < j6) {
                return true;
            }
            j6 = list.get(i6).f5125b;
        }
        return false;
    }

    @Override // b1.a.b
    public /* synthetic */ void a(m2.b bVar) {
        b1.b.c(this, bVar);
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
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return this.f5122a.equals(((c) obj).f5122a);
    }

    public int hashCode() {
        return this.f5122a.hashCode();
    }

    public String toString() {
        return "SlowMotion: segments=" + this.f5122a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeList(this.f5122a);
    }
}

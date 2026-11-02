package i1;

import android.os.Parcel;
import android.os.Parcelable;
import i2.i0;
import i2.r0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class d extends i1.b {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final long f5503a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f5504b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f5505c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f5506d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f5507e;

    /* renamed from: j, reason: collision with root package name */
    public final long f5508j;

    /* renamed from: k, reason: collision with root package name */
    public final long f5509k;

    /* renamed from: l, reason: collision with root package name */
    public final List<b> f5510l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f5511m;

    /* renamed from: n, reason: collision with root package name */
    public final long f5512n;

    /* renamed from: o, reason: collision with root package name */
    public final int f5513o;

    /* renamed from: p, reason: collision with root package name */
    public final int f5514p;

    /* renamed from: q, reason: collision with root package name */
    public final int f5515q;

    class a implements Parcelable.Creator<d> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i6) {
            return new d[i6];
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f5516a;

        /* renamed from: b, reason: collision with root package name */
        public final long f5517b;

        /* renamed from: c, reason: collision with root package name */
        public final long f5518c;

        private b(int i6, long j6, long j7) {
            this.f5516a = i6;
            this.f5517b = j6;
            this.f5518c = j7;
        }

        /* synthetic */ b(int i6, long j6, long j7, a aVar) {
            this(i6, j6, j7);
        }

        public static b a(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void b(Parcel parcel) {
            parcel.writeInt(this.f5516a);
            parcel.writeLong(this.f5517b);
            parcel.writeLong(this.f5518c);
        }
    }

    private d(long j6, boolean z5, boolean z6, boolean z7, boolean z8, long j7, long j8, List<b> list, boolean z9, long j9, int i6, int i7, int i8) {
        this.f5503a = j6;
        this.f5504b = z5;
        this.f5505c = z6;
        this.f5506d = z7;
        this.f5507e = z8;
        this.f5508j = j7;
        this.f5509k = j8;
        this.f5510l = Collections.unmodifiableList(list);
        this.f5511m = z9;
        this.f5512n = j9;
        this.f5513o = i6;
        this.f5514p = i7;
        this.f5515q = i8;
    }

    private d(Parcel parcel) {
        this.f5503a = parcel.readLong();
        this.f5504b = parcel.readByte() == 1;
        this.f5505c = parcel.readByte() == 1;
        this.f5506d = parcel.readByte() == 1;
        this.f5507e = parcel.readByte() == 1;
        this.f5508j = parcel.readLong();
        this.f5509k = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i6 = 0; i6 < readInt; i6++) {
            arrayList.add(b.a(parcel));
        }
        this.f5510l = Collections.unmodifiableList(arrayList);
        this.f5511m = parcel.readByte() == 1;
        this.f5512n = parcel.readLong();
        this.f5513o = parcel.readInt();
        this.f5514p = parcel.readInt();
        this.f5515q = parcel.readInt();
    }

    /* synthetic */ d(Parcel parcel, a aVar) {
        this(parcel);
    }

    static d d(i0 i0Var, long j6, r0 r0Var) {
        List list;
        boolean z5;
        boolean z6;
        long j7;
        boolean z7;
        long j8;
        int i6;
        int i7;
        int i8;
        boolean z8;
        boolean z9;
        long j9;
        long H = i0Var.H();
        boolean z10 = (i0Var.F() & 128) != 0;
        List emptyList = Collections.emptyList();
        if (z10) {
            list = emptyList;
            z5 = false;
            z6 = false;
            j7 = -9223372036854775807L;
            z7 = false;
            j8 = -9223372036854775807L;
            i6 = 0;
            i7 = 0;
            i8 = 0;
            z8 = false;
        } else {
            int F = i0Var.F();
            boolean z11 = (F & 128) != 0;
            boolean z12 = (F & 64) != 0;
            boolean z13 = (F & 32) != 0;
            boolean z14 = (F & 16) != 0;
            long e6 = (!z12 || z14) ? -9223372036854775807L : g.e(i0Var, j6);
            if (!z12) {
                int F2 = i0Var.F();
                ArrayList arrayList = new ArrayList(F2);
                for (int i9 = 0; i9 < F2; i9++) {
                    int F3 = i0Var.F();
                    long e7 = !z14 ? g.e(i0Var, j6) : -9223372036854775807L;
                    arrayList.add(new b(F3, e7, r0Var.b(e7), null));
                }
                emptyList = arrayList;
            }
            if (z13) {
                long F4 = i0Var.F();
                boolean z15 = (128 & F4) != 0;
                j9 = ((((F4 & 1) << 32) | i0Var.H()) * 1000) / 90;
                z9 = z15;
            } else {
                z9 = false;
                j9 = -9223372036854775807L;
            }
            i6 = i0Var.L();
            z8 = z12;
            i7 = i0Var.F();
            i8 = i0Var.F();
            list = emptyList;
            long j10 = e6;
            z7 = z9;
            j8 = j9;
            z6 = z14;
            z5 = z11;
            j7 = j10;
        }
        return new d(H, z10, z5, z8, z6, j7, r0Var.b(j7), list, z7, j8, i6, i7, i8);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeLong(this.f5503a);
        parcel.writeByte(this.f5504b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f5505c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f5506d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f5507e ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f5508j);
        parcel.writeLong(this.f5509k);
        int size = this.f5510l.size();
        parcel.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            this.f5510l.get(i7).b(parcel);
        }
        parcel.writeByte(this.f5511m ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f5512n);
        parcel.writeInt(this.f5513o);
        parcel.writeInt(this.f5514p);
        parcel.writeInt(this.f5515q);
    }
}

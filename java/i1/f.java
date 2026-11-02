package i1;

import android.os.Parcel;
import android.os.Parcelable;
import i2.i0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class f extends i1.b {
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final List<c> f5519a;

    class a implements Parcelable.Creator<f> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int i6) {
            return new f[i6];
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f5520a;

        /* renamed from: b, reason: collision with root package name */
        public final long f5521b;

        private b(int i6, long j6) {
            this.f5520a = i6;
            this.f5521b = j6;
        }

        /* synthetic */ b(int i6, long j6, a aVar) {
            this(i6, j6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b c(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(Parcel parcel) {
            parcel.writeInt(this.f5520a);
            parcel.writeLong(this.f5521b);
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final long f5522a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f5523b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f5524c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f5525d;

        /* renamed from: e, reason: collision with root package name */
        public final long f5526e;

        /* renamed from: f, reason: collision with root package name */
        public final List<b> f5527f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f5528g;

        /* renamed from: h, reason: collision with root package name */
        public final long f5529h;

        /* renamed from: i, reason: collision with root package name */
        public final int f5530i;

        /* renamed from: j, reason: collision with root package name */
        public final int f5531j;

        /* renamed from: k, reason: collision with root package name */
        public final int f5532k;

        private c(long j6, boolean z5, boolean z6, boolean z7, List<b> list, long j7, boolean z8, long j8, int i6, int i7, int i8) {
            this.f5522a = j6;
            this.f5523b = z5;
            this.f5524c = z6;
            this.f5525d = z7;
            this.f5527f = Collections.unmodifiableList(list);
            this.f5526e = j7;
            this.f5528g = z8;
            this.f5529h = j8;
            this.f5530i = i6;
            this.f5531j = i7;
            this.f5532k = i8;
        }

        private c(Parcel parcel) {
            this.f5522a = parcel.readLong();
            this.f5523b = parcel.readByte() == 1;
            this.f5524c = parcel.readByte() == 1;
            this.f5525d = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i6 = 0; i6 < readInt; i6++) {
                arrayList.add(b.c(parcel));
            }
            this.f5527f = Collections.unmodifiableList(arrayList);
            this.f5526e = parcel.readLong();
            this.f5528g = parcel.readByte() == 1;
            this.f5529h = parcel.readLong();
            this.f5530i = parcel.readInt();
            this.f5531j = parcel.readInt();
            this.f5532k = parcel.readInt();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c d(Parcel parcel) {
            return new c(parcel);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c e(i0 i0Var) {
            ArrayList arrayList;
            boolean z5;
            long j6;
            boolean z6;
            long j7;
            int i6;
            int i7;
            int i8;
            boolean z7;
            boolean z8;
            long j8;
            long H = i0Var.H();
            boolean z9 = (i0Var.F() & 128) != 0;
            ArrayList arrayList2 = new ArrayList();
            if (z9) {
                arrayList = arrayList2;
                z5 = false;
                j6 = -9223372036854775807L;
                z6 = false;
                j7 = -9223372036854775807L;
                i6 = 0;
                i7 = 0;
                i8 = 0;
                z7 = false;
            } else {
                int F = i0Var.F();
                boolean z10 = (F & 128) != 0;
                boolean z11 = (F & 64) != 0;
                boolean z12 = (F & 32) != 0;
                long H2 = z11 ? i0Var.H() : -9223372036854775807L;
                if (!z11) {
                    int F2 = i0Var.F();
                    ArrayList arrayList3 = new ArrayList(F2);
                    for (int i9 = 0; i9 < F2; i9++) {
                        arrayList3.add(new b(i0Var.F(), i0Var.H(), null));
                    }
                    arrayList2 = arrayList3;
                }
                if (z12) {
                    long F3 = i0Var.F();
                    boolean z13 = (128 & F3) != 0;
                    j8 = ((((F3 & 1) << 32) | i0Var.H()) * 1000) / 90;
                    z8 = z13;
                } else {
                    z8 = false;
                    j8 = -9223372036854775807L;
                }
                int L = i0Var.L();
                int F4 = i0Var.F();
                z7 = z11;
                i8 = i0Var.F();
                j7 = j8;
                arrayList = arrayList2;
                long j9 = H2;
                i6 = L;
                i7 = F4;
                j6 = j9;
                boolean z14 = z10;
                z6 = z8;
                z5 = z14;
            }
            return new c(H, z9, z5, z7, arrayList, j6, z6, j7, i6, i7, i8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(Parcel parcel) {
            parcel.writeLong(this.f5522a);
            parcel.writeByte(this.f5523b ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f5524c ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f5525d ? (byte) 1 : (byte) 0);
            int size = this.f5527f.size();
            parcel.writeInt(size);
            for (int i6 = 0; i6 < size; i6++) {
                this.f5527f.get(i6).d(parcel);
            }
            parcel.writeLong(this.f5526e);
            parcel.writeByte(this.f5528g ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f5529h);
            parcel.writeInt(this.f5530i);
            parcel.writeInt(this.f5531j);
            parcel.writeInt(this.f5532k);
        }
    }

    private f(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i6 = 0; i6 < readInt; i6++) {
            arrayList.add(c.d(parcel));
        }
        this.f5519a = Collections.unmodifiableList(arrayList);
    }

    /* synthetic */ f(Parcel parcel, a aVar) {
        this(parcel);
    }

    private f(List<c> list) {
        this.f5519a = Collections.unmodifiableList(list);
    }

    static f d(i0 i0Var) {
        int F = i0Var.F();
        ArrayList arrayList = new ArrayList(F);
        for (int i6 = 0; i6 < F; i6++) {
            arrayList.add(c.e(i0Var));
        }
        return new f(arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        int size = this.f5519a.size();
        parcel.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            this.f5519a.get(i7).f(parcel);
        }
    }
}

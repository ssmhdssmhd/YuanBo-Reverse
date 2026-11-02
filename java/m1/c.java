package m1;

import android.net.Uri;
import android.os.Bundle;
import h0.o;
import i2.c1;
import java.util.ArrayList;
import java.util.Arrays;
import m1.c;

/* loaded from: classes.dex */
public final class c implements o {

    /* renamed from: k, reason: collision with root package name */
    public static final c f7902k = new c(null, new a[0], 0, -9223372036854775807L, 0);

    /* renamed from: l, reason: collision with root package name */
    private static final a f7903l = new a(0).i(0);

    /* renamed from: m, reason: collision with root package name */
    private static final String f7904m = c1.s0(1);

    /* renamed from: n, reason: collision with root package name */
    private static final String f7905n = c1.s0(2);

    /* renamed from: o, reason: collision with root package name */
    private static final String f7906o = c1.s0(3);

    /* renamed from: p, reason: collision with root package name */
    private static final String f7907p = c1.s0(4);

    /* renamed from: q, reason: collision with root package name */
    public static final o.a<c> f7908q = new o.a() { // from class: m1.a
        @Override // h0.o.a
        public final o a(Bundle bundle) {
            c b6;
            b6 = c.b(bundle);
            return b6;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final Object f7909a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7910b;

    /* renamed from: c, reason: collision with root package name */
    public final long f7911c;

    /* renamed from: d, reason: collision with root package name */
    public final long f7912d;

    /* renamed from: e, reason: collision with root package name */
    public final int f7913e;

    /* renamed from: j, reason: collision with root package name */
    private final a[] f7914j;

    public static final class a implements o {

        /* renamed from: m, reason: collision with root package name */
        private static final String f7915m = c1.s0(0);

        /* renamed from: n, reason: collision with root package name */
        private static final String f7916n = c1.s0(1);

        /* renamed from: o, reason: collision with root package name */
        private static final String f7917o = c1.s0(2);

        /* renamed from: p, reason: collision with root package name */
        private static final String f7918p = c1.s0(3);

        /* renamed from: q, reason: collision with root package name */
        private static final String f7919q = c1.s0(4);

        /* renamed from: r, reason: collision with root package name */
        private static final String f7920r = c1.s0(5);

        /* renamed from: s, reason: collision with root package name */
        private static final String f7921s = c1.s0(6);

        /* renamed from: t, reason: collision with root package name */
        private static final String f7922t = c1.s0(7);

        /* renamed from: u, reason: collision with root package name */
        public static final o.a<a> f7923u = new o.a() { // from class: m1.b
            @Override // h0.o.a
            public final o a(Bundle bundle) {
                c.a d6;
                d6 = c.a.d(bundle);
                return d6;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final long f7924a;

        /* renamed from: b, reason: collision with root package name */
        public final int f7925b;

        /* renamed from: c, reason: collision with root package name */
        public final int f7926c;

        /* renamed from: d, reason: collision with root package name */
        public final Uri[] f7927d;

        /* renamed from: e, reason: collision with root package name */
        public final int[] f7928e;

        /* renamed from: j, reason: collision with root package name */
        public final long[] f7929j;

        /* renamed from: k, reason: collision with root package name */
        public final long f7930k;

        /* renamed from: l, reason: collision with root package name */
        public final boolean f7931l;

        public a(long j6) {
            this(j6, -1, -1, new int[0], new Uri[0], new long[0], 0L, false);
        }

        private a(long j6, int i6, int i7, int[] iArr, Uri[] uriArr, long[] jArr, long j7, boolean z5) {
            i2.a.a(iArr.length == uriArr.length);
            this.f7924a = j6;
            this.f7925b = i6;
            this.f7926c = i7;
            this.f7928e = iArr;
            this.f7927d = uriArr;
            this.f7929j = jArr;
            this.f7930k = j7;
            this.f7931l = z5;
        }

        private static long[] b(long[] jArr, int i6) {
            int length = jArr.length;
            int max = Math.max(i6, length);
            long[] copyOf = Arrays.copyOf(jArr, max);
            Arrays.fill(copyOf, length, max, -9223372036854775807L);
            return copyOf;
        }

        private static int[] c(int[] iArr, int i6) {
            int length = iArr.length;
            int max = Math.max(i6, length);
            int[] copyOf = Arrays.copyOf(iArr, max);
            Arrays.fill(copyOf, length, max, 0);
            return copyOf;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static a d(Bundle bundle) {
            long j6 = bundle.getLong(f7915m);
            int i6 = bundle.getInt(f7916n);
            int i7 = bundle.getInt(f7922t);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(f7917o);
            int[] intArray = bundle.getIntArray(f7918p);
            long[] longArray = bundle.getLongArray(f7919q);
            long j7 = bundle.getLong(f7920r);
            boolean z5 = bundle.getBoolean(f7921s);
            if (intArray == null) {
                intArray = new int[0];
            }
            return new a(j6, i6, i7, intArray, parcelableArrayList == null ? new Uri[0] : (Uri[]) parcelableArrayList.toArray(new Uri[0]), longArray == null ? new long[0] : longArray, j7, z5);
        }

        public int e() {
            return f(-1);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f7924a == aVar.f7924a && this.f7925b == aVar.f7925b && this.f7926c == aVar.f7926c && Arrays.equals(this.f7927d, aVar.f7927d) && Arrays.equals(this.f7928e, aVar.f7928e) && Arrays.equals(this.f7929j, aVar.f7929j) && this.f7930k == aVar.f7930k && this.f7931l == aVar.f7931l;
        }

        public int f(int i6) {
            int i7;
            int i8 = i6 + 1;
            while (true) {
                int[] iArr = this.f7928e;
                if (i8 >= iArr.length || this.f7931l || (i7 = iArr[i8]) == 0 || i7 == 1) {
                    break;
                }
                i8++;
            }
            return i8;
        }

        public boolean g() {
            if (this.f7925b == -1) {
                return true;
            }
            for (int i6 = 0; i6 < this.f7925b; i6++) {
                int i7 = this.f7928e[i6];
                if (i7 == 0 || i7 == 1) {
                    return true;
                }
            }
            return false;
        }

        public boolean h() {
            return this.f7925b == -1 || e() < this.f7925b;
        }

        public int hashCode() {
            int i6 = ((this.f7925b * 31) + this.f7926c) * 31;
            long j6 = this.f7924a;
            int hashCode = (((((((i6 + ((int) (j6 ^ (j6 >>> 32)))) * 31) + Arrays.hashCode(this.f7927d)) * 31) + Arrays.hashCode(this.f7928e)) * 31) + Arrays.hashCode(this.f7929j)) * 31;
            long j7 = this.f7930k;
            return ((hashCode + ((int) (j7 ^ (j7 >>> 32)))) * 31) + (this.f7931l ? 1 : 0);
        }

        public a i(int i6) {
            int[] c6 = c(this.f7928e, i6);
            long[] b6 = b(this.f7929j, i6);
            return new a(this.f7924a, i6, this.f7926c, c6, (Uri[]) Arrays.copyOf(this.f7927d, i6), b6, this.f7930k, this.f7931l);
        }
    }

    private c(Object obj, a[] aVarArr, long j6, long j7, int i6) {
        this.f7909a = obj;
        this.f7911c = j6;
        this.f7912d = j7;
        this.f7910b = aVarArr.length + i6;
        this.f7914j = aVarArr;
        this.f7913e = i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static c b(Bundle bundle) {
        a[] aVarArr;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f7904m);
        if (parcelableArrayList == null) {
            aVarArr = new a[0];
        } else {
            a[] aVarArr2 = new a[parcelableArrayList.size()];
            for (int i6 = 0; i6 < parcelableArrayList.size(); i6++) {
                aVarArr2[i6] = a.f7923u.a((Bundle) parcelableArrayList.get(i6));
            }
            aVarArr = aVarArr2;
        }
        String str = f7905n;
        c cVar = f7902k;
        return new c(null, aVarArr, bundle.getLong(str, cVar.f7911c), bundle.getLong(f7906o, cVar.f7912d), bundle.getInt(f7907p, cVar.f7913e));
    }

    private boolean f(long j6, long j7, int i6) {
        if (j6 == Long.MIN_VALUE) {
            return false;
        }
        long j8 = c(i6).f7924a;
        return j8 == Long.MIN_VALUE ? j7 == -9223372036854775807L || j6 < j7 : j6 < j8;
    }

    public a c(int i6) {
        int i7 = this.f7913e;
        return i6 < i7 ? f7903l : this.f7914j[i6 - i7];
    }

    public int d(long j6, long j7) {
        if (j6 == Long.MIN_VALUE) {
            return -1;
        }
        if (j7 != -9223372036854775807L && j6 >= j7) {
            return -1;
        }
        int i6 = this.f7913e;
        while (i6 < this.f7910b && ((c(i6).f7924a != Long.MIN_VALUE && c(i6).f7924a <= j6) || !c(i6).h())) {
            i6++;
        }
        if (i6 < this.f7910b) {
            return i6;
        }
        return -1;
    }

    public int e(long j6, long j7) {
        int i6 = this.f7910b - 1;
        while (i6 >= 0 && f(j6, j7, i6)) {
            i6--;
        }
        if (i6 < 0 || !c(i6).g()) {
            return -1;
        }
        return i6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return c1.c(this.f7909a, cVar.f7909a) && this.f7910b == cVar.f7910b && this.f7911c == cVar.f7911c && this.f7912d == cVar.f7912d && this.f7913e == cVar.f7913e && Arrays.equals(this.f7914j, cVar.f7914j);
    }

    public int hashCode() {
        int i6 = this.f7910b * 31;
        Object obj = this.f7909a;
        return ((((((((i6 + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.f7911c)) * 31) + ((int) this.f7912d)) * 31) + this.f7913e) * 31) + Arrays.hashCode(this.f7914j);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdPlaybackState(adsId=");
        sb.append(this.f7909a);
        sb.append(", adResumePositionUs=");
        sb.append(this.f7911c);
        sb.append(", adGroups=[");
        for (int i6 = 0; i6 < this.f7914j.length; i6++) {
            sb.append("adGroup(timeUs=");
            sb.append(this.f7914j[i6].f7924a);
            sb.append(", ads=[");
            for (int i7 = 0; i7 < this.f7914j[i6].f7928e.length; i7++) {
                sb.append("ad(state=");
                int i8 = this.f7914j[i6].f7928e[i7];
                sb.append(i8 != 0 ? i8 != 1 ? i8 != 2 ? i8 != 3 ? i8 != 4 ? '?' : '!' : 'P' : 'S' : 'R' : '_');
                sb.append(", durationUs=");
                sb.append(this.f7914j[i6].f7929j[i7]);
                sb.append(')');
                if (i7 < this.f7914j[i6].f7928e.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i6 < this.f7914j.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        return sb.toString();
    }
}

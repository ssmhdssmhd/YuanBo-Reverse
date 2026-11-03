package h0;

import android.os.Bundle;
import h0.o;
import h0.r4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class r4 implements o {

    /* renamed from: b, reason: collision with root package name */
    public static final r4 f4844b = new r4(m2.q.q());

    /* renamed from: c, reason: collision with root package name */
    private static final String f4845c = i2.c1.s0(0);

    /* renamed from: d, reason: collision with root package name */
    public static final o.a<r4> f4846d = new o.a() { // from class: h0.p4
        @Override // h0.o.a
        public final o a(Bundle bundle) {
            r4 d6;
            d6 = r4.d(bundle);
            return d6;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final m2.q<a> f4847a;

    public static final class a implements o {

        /* renamed from: j, reason: collision with root package name */
        private static final String f4848j = i2.c1.s0(0);

        /* renamed from: k, reason: collision with root package name */
        private static final String f4849k = i2.c1.s0(1);

        /* renamed from: l, reason: collision with root package name */
        private static final String f4850l = i2.c1.s0(3);

        /* renamed from: m, reason: collision with root package name */
        private static final String f4851m = i2.c1.s0(4);

        /* renamed from: n, reason: collision with root package name */
        public static final o.a<a> f4852n = new o.a() { // from class: h0.q4
            @Override // h0.o.a
            public final o a(Bundle bundle) {
                r4.a j6;
                j6 = r4.a.j(bundle);
                return j6;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final int f4853a;

        /* renamed from: b, reason: collision with root package name */
        private final l1.u0 f4854b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f4855c;

        /* renamed from: d, reason: collision with root package name */
        private final int[] f4856d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean[] f4857e;

        public a(l1.u0 u0Var, boolean z5, int[] iArr, boolean[] zArr) {
            int i6 = u0Var.f7445a;
            this.f4853a = i6;
            boolean z6 = false;
            i2.a.a(i6 == iArr.length && i6 == zArr.length);
            this.f4854b = u0Var;
            if (z5 && i6 > 1) {
                z6 = true;
            }
            this.f4855c = z6;
            this.f4856d = (int[]) iArr.clone();
            this.f4857e = (boolean[]) zArr.clone();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ a j(Bundle bundle) {
            l1.u0 a6 = l1.u0.f7444l.a((Bundle) i2.a.e(bundle.getBundle(f4848j)));
            return new a(a6, bundle.getBoolean(f4851m, false), (int[]) l2.h.a(bundle.getIntArray(f4849k), new int[a6.f7445a]), (boolean[]) l2.h.a(bundle.getBooleanArray(f4850l), new boolean[a6.f7445a]));
        }

        public l1.u0 b() {
            return this.f4854b;
        }

        public y1 c(int i6) {
            return this.f4854b.b(i6);
        }

        public int d() {
            return this.f4854b.f7447c;
        }

        public boolean e() {
            return this.f4855c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f4855c == aVar.f4855c && this.f4854b.equals(aVar.f4854b) && Arrays.equals(this.f4856d, aVar.f4856d) && Arrays.equals(this.f4857e, aVar.f4857e);
        }

        public boolean f() {
            return o2.a.b(this.f4857e, true);
        }

        public boolean g(int i6) {
            return this.f4857e[i6];
        }

        public boolean h(int i6) {
            return i(i6, false);
        }

        public int hashCode() {
            return (((((this.f4854b.hashCode() * 31) + (this.f4855c ? 1 : 0)) * 31) + Arrays.hashCode(this.f4856d)) * 31) + Arrays.hashCode(this.f4857e);
        }

        public boolean i(int i6, boolean z5) {
            int i7 = this.f4856d[i6];
            return i7 == 4 || (z5 && i7 == 3);
        }
    }

    public r4(List<a> list) {
        this.f4847a = m2.q.m(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ r4 d(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f4845c);
        return new r4(parcelableArrayList == null ? m2.q.q() : i2.d.b(a.f4852n, parcelableArrayList));
    }

    public m2.q<a> b() {
        return this.f4847a;
    }

    public boolean c(int i6) {
        for (int i7 = 0; i7 < this.f4847a.size(); i7++) {
            a aVar = this.f4847a.get(i7);
            if (aVar.f() && aVar.d() == i6) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r4.class != obj.getClass()) {
            return false;
        }
        return this.f4847a.equals(((r4) obj).f4847a);
    }

    public int hashCode() {
        return this.f4847a.hashCode();
    }
}

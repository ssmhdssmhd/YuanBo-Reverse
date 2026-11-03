package u1;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import h0.o;
import i2.c1;
import org.checkerframework.dataflow.qual.Pure;

/* loaded from: classes.dex */
public final class b implements h0.o {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f9604a;

    /* renamed from: b, reason: collision with root package name */
    public final Layout.Alignment f9605b;

    /* renamed from: c, reason: collision with root package name */
    public final Layout.Alignment f9606c;

    /* renamed from: d, reason: collision with root package name */
    public final Bitmap f9607d;

    /* renamed from: e, reason: collision with root package name */
    public final float f9608e;

    /* renamed from: j, reason: collision with root package name */
    public final int f9609j;

    /* renamed from: k, reason: collision with root package name */
    public final int f9610k;

    /* renamed from: l, reason: collision with root package name */
    public final float f9611l;

    /* renamed from: m, reason: collision with root package name */
    public final int f9612m;

    /* renamed from: n, reason: collision with root package name */
    public final float f9613n;

    /* renamed from: o, reason: collision with root package name */
    public final float f9614o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f9615p;

    /* renamed from: q, reason: collision with root package name */
    public final int f9616q;

    /* renamed from: r, reason: collision with root package name */
    public final int f9617r;

    /* renamed from: s, reason: collision with root package name */
    public final float f9618s;

    /* renamed from: t, reason: collision with root package name */
    public final int f9619t;

    /* renamed from: u, reason: collision with root package name */
    public final float f9620u;

    /* renamed from: v, reason: collision with root package name */
    public static final b f9599v = new C0148b().o("").a();

    /* renamed from: w, reason: collision with root package name */
    private static final String f9600w = c1.s0(0);

    /* renamed from: x, reason: collision with root package name */
    private static final String f9601x = c1.s0(1);

    /* renamed from: y, reason: collision with root package name */
    private static final String f9602y = c1.s0(2);

    /* renamed from: z, reason: collision with root package name */
    private static final String f9603z = c1.s0(3);
    private static final String A = c1.s0(4);
    private static final String B = c1.s0(5);
    private static final String C = c1.s0(6);
    private static final String D = c1.s0(7);
    private static final String E = c1.s0(8);
    private static final String F = c1.s0(9);
    private static final String G = c1.s0(10);
    private static final String H = c1.s0(11);
    private static final String I = c1.s0(12);
    private static final String J = c1.s0(13);
    private static final String K = c1.s0(14);
    private static final String L = c1.s0(15);
    private static final String M = c1.s0(16);
    public static final o.a<b> N = new o.a() { // from class: u1.a
        @Override // h0.o.a
        public final h0.o a(Bundle bundle) {
            b c6;
            c6 = b.c(bundle);
            return c6;
        }
    };

    /* renamed from: u1.b$b, reason: collision with other inner class name */
    public static final class C0148b {

        /* renamed from: a, reason: collision with root package name */
        private CharSequence f9621a;

        /* renamed from: b, reason: collision with root package name */
        private Bitmap f9622b;

        /* renamed from: c, reason: collision with root package name */
        private Layout.Alignment f9623c;

        /* renamed from: d, reason: collision with root package name */
        private Layout.Alignment f9624d;

        /* renamed from: e, reason: collision with root package name */
        private float f9625e;

        /* renamed from: f, reason: collision with root package name */
        private int f9626f;

        /* renamed from: g, reason: collision with root package name */
        private int f9627g;

        /* renamed from: h, reason: collision with root package name */
        private float f9628h;

        /* renamed from: i, reason: collision with root package name */
        private int f9629i;

        /* renamed from: j, reason: collision with root package name */
        private int f9630j;

        /* renamed from: k, reason: collision with root package name */
        private float f9631k;

        /* renamed from: l, reason: collision with root package name */
        private float f9632l;

        /* renamed from: m, reason: collision with root package name */
        private float f9633m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f9634n;

        /* renamed from: o, reason: collision with root package name */
        private int f9635o;

        /* renamed from: p, reason: collision with root package name */
        private int f9636p;

        /* renamed from: q, reason: collision with root package name */
        private float f9637q;

        public C0148b() {
            this.f9621a = null;
            this.f9622b = null;
            this.f9623c = null;
            this.f9624d = null;
            this.f9625e = -3.4028235E38f;
            this.f9626f = Integer.MIN_VALUE;
            this.f9627g = Integer.MIN_VALUE;
            this.f9628h = -3.4028235E38f;
            this.f9629i = Integer.MIN_VALUE;
            this.f9630j = Integer.MIN_VALUE;
            this.f9631k = -3.4028235E38f;
            this.f9632l = -3.4028235E38f;
            this.f9633m = -3.4028235E38f;
            this.f9634n = false;
            this.f9635o = -16777216;
            this.f9636p = Integer.MIN_VALUE;
        }

        private C0148b(b bVar) {
            this.f9621a = bVar.f9604a;
            this.f9622b = bVar.f9607d;
            this.f9623c = bVar.f9605b;
            this.f9624d = bVar.f9606c;
            this.f9625e = bVar.f9608e;
            this.f9626f = bVar.f9609j;
            this.f9627g = bVar.f9610k;
            this.f9628h = bVar.f9611l;
            this.f9629i = bVar.f9612m;
            this.f9630j = bVar.f9617r;
            this.f9631k = bVar.f9618s;
            this.f9632l = bVar.f9613n;
            this.f9633m = bVar.f9614o;
            this.f9634n = bVar.f9615p;
            this.f9635o = bVar.f9616q;
            this.f9636p = bVar.f9619t;
            this.f9637q = bVar.f9620u;
        }

        public b a() {
            return new b(this.f9621a, this.f9623c, this.f9624d, this.f9622b, this.f9625e, this.f9626f, this.f9627g, this.f9628h, this.f9629i, this.f9630j, this.f9631k, this.f9632l, this.f9633m, this.f9634n, this.f9635o, this.f9636p, this.f9637q);
        }

        public C0148b b() {
            this.f9634n = false;
            return this;
        }

        @Pure
        public int c() {
            return this.f9627g;
        }

        @Pure
        public int d() {
            return this.f9629i;
        }

        @Pure
        public CharSequence e() {
            return this.f9621a;
        }

        public C0148b f(Bitmap bitmap) {
            this.f9622b = bitmap;
            return this;
        }

        public C0148b g(float f6) {
            this.f9633m = f6;
            return this;
        }

        public C0148b h(float f6, int i6) {
            this.f9625e = f6;
            this.f9626f = i6;
            return this;
        }

        public C0148b i(int i6) {
            this.f9627g = i6;
            return this;
        }

        public C0148b j(Layout.Alignment alignment) {
            this.f9624d = alignment;
            return this;
        }

        public C0148b k(float f6) {
            this.f9628h = f6;
            return this;
        }

        public C0148b l(int i6) {
            this.f9629i = i6;
            return this;
        }

        public C0148b m(float f6) {
            this.f9637q = f6;
            return this;
        }

        public C0148b n(float f6) {
            this.f9632l = f6;
            return this;
        }

        public C0148b o(CharSequence charSequence) {
            this.f9621a = charSequence;
            return this;
        }

        public C0148b p(Layout.Alignment alignment) {
            this.f9623c = alignment;
            return this;
        }

        public C0148b q(float f6, int i6) {
            this.f9631k = f6;
            this.f9630j = i6;
            return this;
        }

        public C0148b r(int i6) {
            this.f9636p = i6;
            return this;
        }

        public C0148b s(int i6) {
            this.f9635o = i6;
            this.f9634n = true;
            return this;
        }
    }

    private b(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f6, int i6, int i7, float f7, int i8, int i9, float f8, float f9, float f10, boolean z5, int i10, int i11, float f11) {
        if (charSequence == null) {
            i2.a.e(bitmap);
        } else {
            i2.a.a(bitmap == null);
        }
        this.f9604a = charSequence instanceof Spanned ? SpannedString.valueOf(charSequence) : charSequence != null ? charSequence.toString() : null;
        this.f9605b = alignment;
        this.f9606c = alignment2;
        this.f9607d = bitmap;
        this.f9608e = f6;
        this.f9609j = i6;
        this.f9610k = i7;
        this.f9611l = f7;
        this.f9612m = i8;
        this.f9613n = f9;
        this.f9614o = f10;
        this.f9615p = z5;
        this.f9616q = i10;
        this.f9617r = i9;
        this.f9618s = f8;
        this.f9619t = i11;
        this.f9620u = f11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b c(Bundle bundle) {
        C0148b c0148b = new C0148b();
        CharSequence charSequence = bundle.getCharSequence(f9600w);
        if (charSequence != null) {
            c0148b.o(charSequence);
        }
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(f9601x);
        if (alignment != null) {
            c0148b.p(alignment);
        }
        Layout.Alignment alignment2 = (Layout.Alignment) bundle.getSerializable(f9602y);
        if (alignment2 != null) {
            c0148b.j(alignment2);
        }
        Bitmap bitmap = (Bitmap) bundle.getParcelable(f9603z);
        if (bitmap != null) {
            c0148b.f(bitmap);
        }
        String str = A;
        if (bundle.containsKey(str)) {
            String str2 = B;
            if (bundle.containsKey(str2)) {
                c0148b.h(bundle.getFloat(str), bundle.getInt(str2));
            }
        }
        String str3 = C;
        if (bundle.containsKey(str3)) {
            c0148b.i(bundle.getInt(str3));
        }
        String str4 = D;
        if (bundle.containsKey(str4)) {
            c0148b.k(bundle.getFloat(str4));
        }
        String str5 = E;
        if (bundle.containsKey(str5)) {
            c0148b.l(bundle.getInt(str5));
        }
        String str6 = G;
        if (bundle.containsKey(str6)) {
            String str7 = F;
            if (bundle.containsKey(str7)) {
                c0148b.q(bundle.getFloat(str6), bundle.getInt(str7));
            }
        }
        String str8 = H;
        if (bundle.containsKey(str8)) {
            c0148b.n(bundle.getFloat(str8));
        }
        String str9 = I;
        if (bundle.containsKey(str9)) {
            c0148b.g(bundle.getFloat(str9));
        }
        String str10 = J;
        if (bundle.containsKey(str10)) {
            c0148b.s(bundle.getInt(str10));
        }
        if (!bundle.getBoolean(K, false)) {
            c0148b.b();
        }
        String str11 = L;
        if (bundle.containsKey(str11)) {
            c0148b.r(bundle.getInt(str11));
        }
        String str12 = M;
        if (bundle.containsKey(str12)) {
            c0148b.m(bundle.getFloat(str12));
        }
        return c0148b.a();
    }

    public C0148b b() {
        return new C0148b();
    }

    public boolean equals(Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return TextUtils.equals(this.f9604a, bVar.f9604a) && this.f9605b == bVar.f9605b && this.f9606c == bVar.f9606c && ((bitmap = this.f9607d) != null ? !((bitmap2 = bVar.f9607d) == null || !bitmap.sameAs(bitmap2)) : bVar.f9607d == null) && this.f9608e == bVar.f9608e && this.f9609j == bVar.f9609j && this.f9610k == bVar.f9610k && this.f9611l == bVar.f9611l && this.f9612m == bVar.f9612m && this.f9613n == bVar.f9613n && this.f9614o == bVar.f9614o && this.f9615p == bVar.f9615p && this.f9616q == bVar.f9616q && this.f9617r == bVar.f9617r && this.f9618s == bVar.f9618s && this.f9619t == bVar.f9619t && this.f9620u == bVar.f9620u;
    }

    public int hashCode() {
        return l2.j.b(this.f9604a, this.f9605b, this.f9606c, this.f9607d, Float.valueOf(this.f9608e), Integer.valueOf(this.f9609j), Integer.valueOf(this.f9610k), Float.valueOf(this.f9611l), Integer.valueOf(this.f9612m), Float.valueOf(this.f9613n), Float.valueOf(this.f9614o), Boolean.valueOf(this.f9615p), Integer.valueOf(this.f9616q), Integer.valueOf(this.f9617r), Float.valueOf(this.f9618s), Integer.valueOf(this.f9619t), Float.valueOf(this.f9620u));
    }
}

package e2;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import h0.o;
import i2.c1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import l1.u0;
import m2.q;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes.dex */
public class z implements h0.o {
    public static final z E;

    @Deprecated
    public static final z F;
    private static final String G;
    private static final String H;
    private static final String I;
    private static final String J;
    private static final String K;
    private static final String L;
    private static final String M;
    private static final String N;
    private static final String O;
    private static final String P;
    private static final String Q;
    private static final String R;
    private static final String S;
    private static final String T;
    private static final String U;
    private static final String V;
    private static final String W;
    private static final String X;
    private static final String Y;
    private static final String Z;

    /* renamed from: a0, reason: collision with root package name */
    private static final String f3541a0;

    /* renamed from: b0, reason: collision with root package name */
    private static final String f3542b0;

    /* renamed from: c0, reason: collision with root package name */
    private static final String f3543c0;

    /* renamed from: d0, reason: collision with root package name */
    private static final String f3544d0;

    /* renamed from: e0, reason: collision with root package name */
    private static final String f3545e0;

    /* renamed from: f0, reason: collision with root package name */
    private static final String f3546f0;

    /* renamed from: g0, reason: collision with root package name */
    @Deprecated
    public static final o.a<z> f3547g0;
    public final boolean A;
    public final boolean B;
    public final m2.r<u0, x> C;
    public final m2.s<Integer> D;

    /* renamed from: a, reason: collision with root package name */
    public final int f3548a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3549b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3550c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3551d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3552e;

    /* renamed from: j, reason: collision with root package name */
    public final int f3553j;

    /* renamed from: k, reason: collision with root package name */
    public final int f3554k;

    /* renamed from: l, reason: collision with root package name */
    public final int f3555l;

    /* renamed from: m, reason: collision with root package name */
    public final int f3556m;

    /* renamed from: n, reason: collision with root package name */
    public final int f3557n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f3558o;

    /* renamed from: p, reason: collision with root package name */
    public final m2.q<String> f3559p;

    /* renamed from: q, reason: collision with root package name */
    public final int f3560q;

    /* renamed from: r, reason: collision with root package name */
    public final m2.q<String> f3561r;

    /* renamed from: s, reason: collision with root package name */
    public final int f3562s;

    /* renamed from: t, reason: collision with root package name */
    public final int f3563t;

    /* renamed from: u, reason: collision with root package name */
    public final int f3564u;

    /* renamed from: v, reason: collision with root package name */
    public final m2.q<String> f3565v;

    /* renamed from: w, reason: collision with root package name */
    public final m2.q<String> f3566w;

    /* renamed from: x, reason: collision with root package name */
    public final int f3567x;

    /* renamed from: y, reason: collision with root package name */
    public final int f3568y;

    /* renamed from: z, reason: collision with root package name */
    public final boolean f3569z;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f3570a;

        /* renamed from: b, reason: collision with root package name */
        private int f3571b;

        /* renamed from: c, reason: collision with root package name */
        private int f3572c;

        /* renamed from: d, reason: collision with root package name */
        private int f3573d;

        /* renamed from: e, reason: collision with root package name */
        private int f3574e;

        /* renamed from: f, reason: collision with root package name */
        private int f3575f;

        /* renamed from: g, reason: collision with root package name */
        private int f3576g;

        /* renamed from: h, reason: collision with root package name */
        private int f3577h;

        /* renamed from: i, reason: collision with root package name */
        private int f3578i;

        /* renamed from: j, reason: collision with root package name */
        private int f3579j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f3580k;

        /* renamed from: l, reason: collision with root package name */
        private m2.q<String> f3581l;

        /* renamed from: m, reason: collision with root package name */
        private int f3582m;

        /* renamed from: n, reason: collision with root package name */
        private m2.q<String> f3583n;

        /* renamed from: o, reason: collision with root package name */
        private int f3584o;

        /* renamed from: p, reason: collision with root package name */
        private int f3585p;

        /* renamed from: q, reason: collision with root package name */
        private int f3586q;

        /* renamed from: r, reason: collision with root package name */
        private m2.q<String> f3587r;

        /* renamed from: s, reason: collision with root package name */
        private m2.q<String> f3588s;

        /* renamed from: t, reason: collision with root package name */
        private int f3589t;

        /* renamed from: u, reason: collision with root package name */
        private int f3590u;

        /* renamed from: v, reason: collision with root package name */
        private boolean f3591v;

        /* renamed from: w, reason: collision with root package name */
        private boolean f3592w;

        /* renamed from: x, reason: collision with root package name */
        private boolean f3593x;

        /* renamed from: y, reason: collision with root package name */
        private HashMap<u0, x> f3594y;

        /* renamed from: z, reason: collision with root package name */
        private HashSet<Integer> f3595z;

        @Deprecated
        public a() {
            this.f3570a = Integer.MAX_VALUE;
            this.f3571b = Integer.MAX_VALUE;
            this.f3572c = Integer.MAX_VALUE;
            this.f3573d = Integer.MAX_VALUE;
            this.f3578i = Integer.MAX_VALUE;
            this.f3579j = Integer.MAX_VALUE;
            this.f3580k = true;
            this.f3581l = m2.q.q();
            this.f3582m = 0;
            this.f3583n = m2.q.q();
            this.f3584o = 0;
            this.f3585p = Integer.MAX_VALUE;
            this.f3586q = Integer.MAX_VALUE;
            this.f3587r = m2.q.q();
            this.f3588s = m2.q.q();
            this.f3589t = 0;
            this.f3590u = 0;
            this.f3591v = false;
            this.f3592w = false;
            this.f3593x = false;
            this.f3594y = new HashMap<>();
            this.f3595z = new HashSet<>();
        }

        public a(Context context) {
            this();
            H(context);
            K(context, true);
        }

        /* JADX WARN: Multi-variable type inference failed */
        protected a(Bundle bundle) {
            String str = z.L;
            z zVar = z.E;
            this.f3570a = bundle.getInt(str, zVar.f3548a);
            this.f3571b = bundle.getInt(z.M, zVar.f3549b);
            this.f3572c = bundle.getInt(z.N, zVar.f3550c);
            this.f3573d = bundle.getInt(z.O, zVar.f3551d);
            this.f3574e = bundle.getInt(z.P, zVar.f3552e);
            this.f3575f = bundle.getInt(z.Q, zVar.f3553j);
            this.f3576g = bundle.getInt(z.R, zVar.f3554k);
            this.f3577h = bundle.getInt(z.S, zVar.f3555l);
            this.f3578i = bundle.getInt(z.T, zVar.f3556m);
            this.f3579j = bundle.getInt(z.U, zVar.f3557n);
            this.f3580k = bundle.getBoolean(z.V, zVar.f3558o);
            this.f3581l = m2.q.n((String[]) l2.h.a(bundle.getStringArray(z.W), new String[0]));
            this.f3582m = bundle.getInt(z.f3545e0, zVar.f3560q);
            this.f3583n = D((String[]) l2.h.a(bundle.getStringArray(z.G), new String[0]));
            this.f3584o = bundle.getInt(z.H, zVar.f3562s);
            this.f3585p = bundle.getInt(z.X, zVar.f3563t);
            this.f3586q = bundle.getInt(z.Y, zVar.f3564u);
            this.f3587r = m2.q.n((String[]) l2.h.a(bundle.getStringArray(z.Z), new String[0]));
            this.f3588s = D((String[]) l2.h.a(bundle.getStringArray(z.I), new String[0]));
            this.f3589t = bundle.getInt(z.J, zVar.f3567x);
            this.f3590u = bundle.getInt(z.f3546f0, zVar.f3568y);
            this.f3591v = bundle.getBoolean(z.K, zVar.f3569z);
            this.f3592w = bundle.getBoolean(z.f3541a0, zVar.A);
            this.f3593x = bundle.getBoolean(z.f3542b0, zVar.B);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(z.f3543c0);
            m2.q q6 = parcelableArrayList == null ? m2.q.q() : i2.d.b(x.f3538e, parcelableArrayList);
            this.f3594y = new HashMap<>();
            for (int i6 = 0; i6 < q6.size(); i6++) {
                x xVar = (x) q6.get(i6);
                this.f3594y.put(xVar.f3539a, xVar);
            }
            int[] iArr = (int[]) l2.h.a(bundle.getIntArray(z.f3544d0), new int[0]);
            this.f3595z = new HashSet<>();
            for (int i7 : iArr) {
                this.f3595z.add(Integer.valueOf(i7));
            }
        }

        protected a(z zVar) {
            C(zVar);
        }

        @EnsuresNonNull({"preferredVideoMimeTypes", "preferredAudioLanguages", "preferredAudioMimeTypes", "preferredTextLanguages", "overrides", "disabledTrackTypes"})
        private void C(z zVar) {
            this.f3570a = zVar.f3548a;
            this.f3571b = zVar.f3549b;
            this.f3572c = zVar.f3550c;
            this.f3573d = zVar.f3551d;
            this.f3574e = zVar.f3552e;
            this.f3575f = zVar.f3553j;
            this.f3576g = zVar.f3554k;
            this.f3577h = zVar.f3555l;
            this.f3578i = zVar.f3556m;
            this.f3579j = zVar.f3557n;
            this.f3580k = zVar.f3558o;
            this.f3581l = zVar.f3559p;
            this.f3582m = zVar.f3560q;
            this.f3583n = zVar.f3561r;
            this.f3584o = zVar.f3562s;
            this.f3585p = zVar.f3563t;
            this.f3586q = zVar.f3564u;
            this.f3587r = zVar.f3565v;
            this.f3588s = zVar.f3566w;
            this.f3589t = zVar.f3567x;
            this.f3590u = zVar.f3568y;
            this.f3591v = zVar.f3569z;
            this.f3592w = zVar.A;
            this.f3593x = zVar.B;
            this.f3595z = new HashSet<>(zVar.D);
            this.f3594y = new HashMap<>(zVar.C);
        }

        private static m2.q<String> D(String[] strArr) {
            q.a k6 = m2.q.k();
            for (String str : (String[]) i2.a.e(strArr)) {
                k6.a(c1.F0((String) i2.a.e(str)));
            }
            return k6.h();
        }

        private void I(Context context) {
            CaptioningManager captioningManager;
            if ((c1.f5548a >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.f3589t = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.f3588s = m2.q.r(c1.Z(locale));
                }
            }
        }

        public z A() {
            return new z(this);
        }

        public a B() {
            return G(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        protected a E(z zVar) {
            C(zVar);
            return this;
        }

        public a F(int i6) {
            this.f3573d = i6;
            return this;
        }

        public a G(int i6, int i7) {
            this.f3570a = i6;
            this.f3571b = i7;
            return this;
        }

        public a H(Context context) {
            if (c1.f5548a >= 19) {
                I(context);
            }
            return this;
        }

        public a J(int i6, int i7, boolean z5) {
            this.f3578i = i6;
            this.f3579j = i7;
            this.f3580k = z5;
            return this;
        }

        public a K(Context context, boolean z5) {
            Point O = c1.O(context);
            return J(O.x, O.y, z5);
        }
    }

    static {
        z A = new a().A();
        E = A;
        F = A;
        G = c1.s0(1);
        H = c1.s0(2);
        I = c1.s0(3);
        J = c1.s0(4);
        K = c1.s0(5);
        L = c1.s0(6);
        M = c1.s0(7);
        N = c1.s0(8);
        O = c1.s0(9);
        P = c1.s0(10);
        Q = c1.s0(11);
        R = c1.s0(12);
        S = c1.s0(13);
        T = c1.s0(14);
        U = c1.s0(15);
        V = c1.s0(16);
        W = c1.s0(17);
        X = c1.s0(18);
        Y = c1.s0(19);
        Z = c1.s0(20);
        f3541a0 = c1.s0(21);
        f3542b0 = c1.s0(22);
        f3543c0 = c1.s0(23);
        f3544d0 = c1.s0(24);
        f3545e0 = c1.s0(25);
        f3546f0 = c1.s0(26);
        f3547g0 = new o.a() { // from class: e2.y
            @Override // h0.o.a
            public final h0.o a(Bundle bundle) {
                return z.A(bundle);
            }
        };
    }

    protected z(a aVar) {
        this.f3548a = aVar.f3570a;
        this.f3549b = aVar.f3571b;
        this.f3550c = aVar.f3572c;
        this.f3551d = aVar.f3573d;
        this.f3552e = aVar.f3574e;
        this.f3553j = aVar.f3575f;
        this.f3554k = aVar.f3576g;
        this.f3555l = aVar.f3577h;
        this.f3556m = aVar.f3578i;
        this.f3557n = aVar.f3579j;
        this.f3558o = aVar.f3580k;
        this.f3559p = aVar.f3581l;
        this.f3560q = aVar.f3582m;
        this.f3561r = aVar.f3583n;
        this.f3562s = aVar.f3584o;
        this.f3563t = aVar.f3585p;
        this.f3564u = aVar.f3586q;
        this.f3565v = aVar.f3587r;
        this.f3566w = aVar.f3588s;
        this.f3567x = aVar.f3589t;
        this.f3568y = aVar.f3590u;
        this.f3569z = aVar.f3591v;
        this.A = aVar.f3592w;
        this.B = aVar.f3593x;
        this.C = m2.r.c(aVar.f3594y);
        this.D = m2.s.k(aVar.f3595z);
    }

    public static z A(Bundle bundle) {
        return new a(bundle).A();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        z zVar = (z) obj;
        return this.f3548a == zVar.f3548a && this.f3549b == zVar.f3549b && this.f3550c == zVar.f3550c && this.f3551d == zVar.f3551d && this.f3552e == zVar.f3552e && this.f3553j == zVar.f3553j && this.f3554k == zVar.f3554k && this.f3555l == zVar.f3555l && this.f3558o == zVar.f3558o && this.f3556m == zVar.f3556m && this.f3557n == zVar.f3557n && this.f3559p.equals(zVar.f3559p) && this.f3560q == zVar.f3560q && this.f3561r.equals(zVar.f3561r) && this.f3562s == zVar.f3562s && this.f3563t == zVar.f3563t && this.f3564u == zVar.f3564u && this.f3565v.equals(zVar.f3565v) && this.f3566w.equals(zVar.f3566w) && this.f3567x == zVar.f3567x && this.f3568y == zVar.f3568y && this.f3569z == zVar.f3569z && this.A == zVar.A && this.B == zVar.B && this.C.equals(zVar.C) && this.D.equals(zVar.D);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((this.f3548a + 31) * 31) + this.f3549b) * 31) + this.f3550c) * 31) + this.f3551d) * 31) + this.f3552e) * 31) + this.f3553j) * 31) + this.f3554k) * 31) + this.f3555l) * 31) + (this.f3558o ? 1 : 0)) * 31) + this.f3556m) * 31) + this.f3557n) * 31) + this.f3559p.hashCode()) * 31) + this.f3560q) * 31) + this.f3561r.hashCode()) * 31) + this.f3562s) * 31) + this.f3563t) * 31) + this.f3564u) * 31) + this.f3565v.hashCode()) * 31) + this.f3566w.hashCode()) * 31) + this.f3567x) * 31) + this.f3568y) * 31) + (this.f3569z ? 1 : 0)) * 31) + (this.A ? 1 : 0)) * 31) + (this.B ? 1 : 0)) * 31) + this.C.hashCode()) * 31) + this.D.hashCode();
    }
}

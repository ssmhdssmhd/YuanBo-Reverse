package j0;

import android.media.AudioAttributes;
import android.os.Bundle;
import h0.o;

/* loaded from: classes.dex */
public final class e implements h0.o {

    /* renamed from: k, reason: collision with root package name */
    public static final e f6401k = new C0096e().a();

    /* renamed from: l, reason: collision with root package name */
    private static final String f6402l = i2.c1.s0(0);

    /* renamed from: m, reason: collision with root package name */
    private static final String f6403m = i2.c1.s0(1);

    /* renamed from: n, reason: collision with root package name */
    private static final String f6404n = i2.c1.s0(2);

    /* renamed from: o, reason: collision with root package name */
    private static final String f6405o = i2.c1.s0(3);

    /* renamed from: p, reason: collision with root package name */
    private static final String f6406p = i2.c1.s0(4);

    /* renamed from: q, reason: collision with root package name */
    public static final o.a<e> f6407q = new o.a() { // from class: j0.d
        @Override // h0.o.a
        public final h0.o a(Bundle bundle) {
            e c6;
            c6 = e.c(bundle);
            return c6;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final int f6408a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6409b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6410c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6411d;

    /* renamed from: e, reason: collision with root package name */
    public final int f6412e;

    /* renamed from: j, reason: collision with root package name */
    private d f6413j;

    private static final class b {
        public static void a(AudioAttributes.Builder builder, int i6) {
            builder.setAllowedCapturePolicy(i6);
        }
    }

    private static final class c {
        public static void a(AudioAttributes.Builder builder, int i6) {
            builder.setSpatializationBehavior(i6);
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final AudioAttributes f6414a;

        private d(e eVar) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(eVar.f6408a).setFlags(eVar.f6409b).setUsage(eVar.f6410c);
            int i6 = i2.c1.f5548a;
            if (i6 >= 29) {
                b.a(usage, eVar.f6411d);
            }
            if (i6 >= 32) {
                c.a(usage, eVar.f6412e);
            }
            this.f6414a = usage.build();
        }
    }

    /* renamed from: j0.e$e, reason: collision with other inner class name */
    public static final class C0096e {

        /* renamed from: a, reason: collision with root package name */
        private int f6415a = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f6416b = 0;

        /* renamed from: c, reason: collision with root package name */
        private int f6417c = 1;

        /* renamed from: d, reason: collision with root package name */
        private int f6418d = 1;

        /* renamed from: e, reason: collision with root package name */
        private int f6419e = 0;

        public e a() {
            return new e(this.f6415a, this.f6416b, this.f6417c, this.f6418d, this.f6419e);
        }

        public C0096e b(int i6) {
            this.f6418d = i6;
            return this;
        }

        public C0096e c(int i6) {
            this.f6415a = i6;
            return this;
        }

        public C0096e d(int i6) {
            this.f6416b = i6;
            return this;
        }

        public C0096e e(int i6) {
            this.f6419e = i6;
            return this;
        }

        public C0096e f(int i6) {
            this.f6417c = i6;
            return this;
        }
    }

    private e(int i6, int i7, int i8, int i9, int i10) {
        this.f6408a = i6;
        this.f6409b = i7;
        this.f6410c = i8;
        this.f6411d = i9;
        this.f6412e = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ e c(Bundle bundle) {
        C0096e c0096e = new C0096e();
        String str = f6402l;
        if (bundle.containsKey(str)) {
            c0096e.c(bundle.getInt(str));
        }
        String str2 = f6403m;
        if (bundle.containsKey(str2)) {
            c0096e.d(bundle.getInt(str2));
        }
        String str3 = f6404n;
        if (bundle.containsKey(str3)) {
            c0096e.f(bundle.getInt(str3));
        }
        String str4 = f6405o;
        if (bundle.containsKey(str4)) {
            c0096e.b(bundle.getInt(str4));
        }
        String str5 = f6406p;
        if (bundle.containsKey(str5)) {
            c0096e.e(bundle.getInt(str5));
        }
        return c0096e.a();
    }

    public d b() {
        if (this.f6413j == null) {
            this.f6413j = new d();
        }
        return this.f6413j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.f6408a == eVar.f6408a && this.f6409b == eVar.f6409b && this.f6410c == eVar.f6410c && this.f6411d == eVar.f6411d && this.f6412e == eVar.f6412e;
    }

    public int hashCode() {
        return ((((((((527 + this.f6408a) * 31) + this.f6409b) * 31) + this.f6410c) * 31) + this.f6411d) * 31) + this.f6412e;
    }
}

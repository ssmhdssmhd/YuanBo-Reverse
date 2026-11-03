package d5;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f3036a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f3037b;

    /* renamed from: c, reason: collision with root package name */
    private final int f3038c;

    /* renamed from: d, reason: collision with root package name */
    private final int f3039d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f3040e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f3041f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f3042g;

    /* renamed from: h, reason: collision with root package name */
    private final int f3043h;

    /* renamed from: i, reason: collision with root package name */
    private final int f3044i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f3045j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f3046k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f3047l;

    /* renamed from: m, reason: collision with root package name */
    private String f3048m;

    /* renamed from: p, reason: collision with root package name */
    public static final b f3035p = new b(null);

    /* renamed from: n, reason: collision with root package name */
    public static final d f3033n = new a().d().a();

    /* renamed from: o, reason: collision with root package name */
    public static final d f3034o = new a().e().c(Integer.MAX_VALUE, TimeUnit.SECONDS).a();

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f3049a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f3050b;

        /* renamed from: c, reason: collision with root package name */
        private int f3051c = -1;

        /* renamed from: d, reason: collision with root package name */
        private int f3052d = -1;

        /* renamed from: e, reason: collision with root package name */
        private int f3053e = -1;

        /* renamed from: f, reason: collision with root package name */
        private boolean f3054f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f3055g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f3056h;

        private final int b(long j6) {
            if (j6 > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int) j6;
        }

        public final d a() {
            return new d(this.f3049a, this.f3050b, this.f3051c, -1, false, false, false, this.f3052d, this.f3053e, this.f3054f, this.f3055g, this.f3056h, null, null);
        }

        public final a c(int i6, TimeUnit timeUnit) {
            kotlin.jvm.internal.k.e(timeUnit, "timeUnit");
            if (i6 >= 0) {
                this.f3052d = b(timeUnit.toSeconds(i6));
                return this;
            }
            throw new IllegalArgumentException(("maxStale < 0: " + i6).toString());
        }

        public final a d() {
            this.f3049a = true;
            return this;
        }

        public final a e() {
            this.f3054f = true;
            return this;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        private final int a(String str, String str2, int i6) {
            boolean E;
            int length = str.length();
            while (i6 < length) {
                E = v4.q.E(str2, str.charAt(i6), false, 2, null);
                if (E) {
                    return i6;
                }
                i6++;
            }
            return str.length();
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00dd  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00e1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final d5.d b(d5.t r32) {
            /*
                Method dump skipped, instructions count: 410
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: d5.d.b.b(d5.t):d5.d");
        }
    }

    private d(boolean z5, boolean z6, int i6, int i7, boolean z7, boolean z8, boolean z9, int i8, int i9, boolean z10, boolean z11, boolean z12, String str) {
        this.f3036a = z5;
        this.f3037b = z6;
        this.f3038c = i6;
        this.f3039d = i7;
        this.f3040e = z7;
        this.f3041f = z8;
        this.f3042g = z9;
        this.f3043h = i8;
        this.f3044i = i9;
        this.f3045j = z10;
        this.f3046k = z11;
        this.f3047l = z12;
        this.f3048m = str;
    }

    public /* synthetic */ d(boolean z5, boolean z6, int i6, int i7, boolean z7, boolean z8, boolean z9, int i8, int i9, boolean z10, boolean z11, boolean z12, String str, kotlin.jvm.internal.g gVar) {
        this(z5, z6, i6, i7, z7, z8, z9, i8, i9, z10, z11, z12, str);
    }

    public final boolean a() {
        return this.f3040e;
    }

    public final boolean b() {
        return this.f3041f;
    }

    public final int c() {
        return this.f3038c;
    }

    public final int d() {
        return this.f3043h;
    }

    public final int e() {
        return this.f3044i;
    }

    public final boolean f() {
        return this.f3042g;
    }

    public final boolean g() {
        return this.f3036a;
    }

    public final boolean h() {
        return this.f3037b;
    }

    public final boolean i() {
        return this.f3045j;
    }

    public String toString() {
        String str = this.f3048m;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f3036a) {
            sb.append("no-cache, ");
        }
        if (this.f3037b) {
            sb.append("no-store, ");
        }
        if (this.f3038c != -1) {
            sb.append("max-age=");
            sb.append(this.f3038c);
            sb.append(", ");
        }
        if (this.f3039d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f3039d);
            sb.append(", ");
        }
        if (this.f3040e) {
            sb.append("private, ");
        }
        if (this.f3041f) {
            sb.append("public, ");
        }
        if (this.f3042g) {
            sb.append("must-revalidate, ");
        }
        if (this.f3043h != -1) {
            sb.append("max-stale=");
            sb.append(this.f3043h);
            sb.append(", ");
        }
        if (this.f3044i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f3044i);
            sb.append(", ");
        }
        if (this.f3045j) {
            sb.append("only-if-cached, ");
        }
        if (this.f3046k) {
            sb.append("no-transform, ");
        }
        if (this.f3047l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String sb2 = sb.toString();
        kotlin.jvm.internal.k.d(sb2, "StringBuilder().apply(builderAction).toString()");
        this.f3048m = sb2;
        return sb2;
    }
}

package g2;

import android.net.Uri;
import h0.v1;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f4097a;

    /* renamed from: b, reason: collision with root package name */
    public final long f4098b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4099c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f4100d;

    /* renamed from: e, reason: collision with root package name */
    public final Map<String, String> f4101e;

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    public final long f4102f;

    /* renamed from: g, reason: collision with root package name */
    public final long f4103g;

    /* renamed from: h, reason: collision with root package name */
    public final long f4104h;

    /* renamed from: i, reason: collision with root package name */
    public final String f4105i;

    /* renamed from: j, reason: collision with root package name */
    public final int f4106j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f4107k;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private Uri f4108a;

        /* renamed from: b, reason: collision with root package name */
        private long f4109b;

        /* renamed from: c, reason: collision with root package name */
        private int f4110c;

        /* renamed from: d, reason: collision with root package name */
        private byte[] f4111d;

        /* renamed from: e, reason: collision with root package name */
        private Map<String, String> f4112e;

        /* renamed from: f, reason: collision with root package name */
        private long f4113f;

        /* renamed from: g, reason: collision with root package name */
        private long f4114g;

        /* renamed from: h, reason: collision with root package name */
        private String f4115h;

        /* renamed from: i, reason: collision with root package name */
        private int f4116i;

        /* renamed from: j, reason: collision with root package name */
        private Object f4117j;

        public b() {
            this.f4110c = 1;
            this.f4112e = Collections.emptyMap();
            this.f4114g = -1L;
        }

        private b(q qVar) {
            this.f4108a = qVar.f4097a;
            this.f4109b = qVar.f4098b;
            this.f4110c = qVar.f4099c;
            this.f4111d = qVar.f4100d;
            this.f4112e = qVar.f4101e;
            this.f4113f = qVar.f4103g;
            this.f4114g = qVar.f4104h;
            this.f4115h = qVar.f4105i;
            this.f4116i = qVar.f4106j;
            this.f4117j = qVar.f4107k;
        }

        public q a() {
            i2.a.j(this.f4108a, "The uri must be set.");
            return new q(this.f4108a, this.f4109b, this.f4110c, this.f4111d, this.f4112e, this.f4113f, this.f4114g, this.f4115h, this.f4116i, this.f4117j);
        }

        public b b(int i6) {
            this.f4116i = i6;
            return this;
        }

        public b c(byte[] bArr) {
            this.f4111d = bArr;
            return this;
        }

        public b d(int i6) {
            this.f4110c = i6;
            return this;
        }

        public b e(Map<String, String> map) {
            this.f4112e = map;
            return this;
        }

        public b f(String str) {
            this.f4115h = str;
            return this;
        }

        public b g(long j6) {
            this.f4114g = j6;
            return this;
        }

        public b h(long j6) {
            this.f4113f = j6;
            return this;
        }

        public b i(Uri uri) {
            this.f4108a = uri;
            return this;
        }

        public b j(String str) {
            this.f4108a = Uri.parse(str);
            return this;
        }

        public b k(long j6) {
            this.f4109b = j6;
            return this;
        }
    }

    static {
        v1.a("goog.exo.datasource");
    }

    public q(Uri uri) {
        this(uri, 0L, -1L);
    }

    private q(Uri uri, long j6, int i6, byte[] bArr, Map<String, String> map, long j7, long j8, String str, int i7, Object obj) {
        byte[] bArr2 = bArr;
        long j9 = j6 + j7;
        boolean z5 = true;
        i2.a.a(j9 >= 0);
        i2.a.a(j7 >= 0);
        if (j8 <= 0 && j8 != -1) {
            z5 = false;
        }
        i2.a.a(z5);
        this.f4097a = uri;
        this.f4098b = j6;
        this.f4099c = i6;
        this.f4100d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f4101e = Collections.unmodifiableMap(new HashMap(map));
        this.f4103g = j7;
        this.f4102f = j9;
        this.f4104h = j8;
        this.f4105i = str;
        this.f4106j = i7;
        this.f4107k = obj;
    }

    public q(Uri uri, long j6, long j7) {
        this(uri, 0L, 1, null, Collections.emptyMap(), j6, j7, null, 0, null);
    }

    public static String c(int i6) {
        if (i6 == 1) {
            return "GET";
        }
        if (i6 == 2) {
            return "POST";
        }
        if (i6 == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    public b a() {
        return new b();
    }

    public final String b() {
        return c(this.f4099c);
    }

    public boolean d(int i6) {
        return (this.f4106j & i6) == i6;
    }

    public q e(long j6) {
        long j7 = this.f4104h;
        return f(j6, j7 != -1 ? j7 - j6 : -1L);
    }

    public q f(long j6, long j7) {
        return (j6 == 0 && this.f4104h == j7) ? this : new q(this.f4097a, this.f4098b, this.f4099c, this.f4100d, this.f4101e, this.f4103g + j6, j7, this.f4105i, this.f4106j, this.f4107k);
    }

    public String toString() {
        return "DataSpec[" + b() + " " + this.f4097a + ", " + this.f4103g + ", " + this.f4104h + ", " + this.f4105i + ", " + this.f4106j + "]";
    }
}

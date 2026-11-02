package g2;

import android.net.Uri;
import g2.m;
import g2.v;
import i2.c1;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

/* loaded from: classes.dex */
public class v extends g {

    /* renamed from: e, reason: collision with root package name */
    private final boolean f4187e;

    /* renamed from: f, reason: collision with root package name */
    private final int f4188f;

    /* renamed from: g, reason: collision with root package name */
    private final int f4189g;

    /* renamed from: h, reason: collision with root package name */
    private final String f4190h;

    /* renamed from: i, reason: collision with root package name */
    private final e0 f4191i;

    /* renamed from: j, reason: collision with root package name */
    private final e0 f4192j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f4193k;

    /* renamed from: l, reason: collision with root package name */
    private l2.l<String> f4194l;

    /* renamed from: m, reason: collision with root package name */
    private q f4195m;

    /* renamed from: n, reason: collision with root package name */
    private HttpURLConnection f4196n;

    /* renamed from: o, reason: collision with root package name */
    private InputStream f4197o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f4198p;

    /* renamed from: q, reason: collision with root package name */
    private int f4199q;

    /* renamed from: r, reason: collision with root package name */
    private long f4200r;

    /* renamed from: s, reason: collision with root package name */
    private long f4201s;

    public static final class b implements m.a {

        /* renamed from: b, reason: collision with root package name */
        private u0 f4203b;

        /* renamed from: c, reason: collision with root package name */
        private l2.l<String> f4204c;

        /* renamed from: d, reason: collision with root package name */
        private String f4205d;

        /* renamed from: g, reason: collision with root package name */
        private boolean f4208g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f4209h;

        /* renamed from: a, reason: collision with root package name */
        private final e0 f4202a = new e0();

        /* renamed from: e, reason: collision with root package name */
        private int f4206e = 8000;

        /* renamed from: f, reason: collision with root package name */
        private int f4207f = 8000;

        @Override // g2.m.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public v a() {
            v vVar = new v(this.f4205d, this.f4206e, this.f4207f, this.f4208g, this.f4202a, this.f4204c, this.f4209h);
            u0 u0Var = this.f4203b;
            if (u0Var != null) {
                vVar.c(u0Var);
            }
            return vVar;
        }

        public b c(boolean z5) {
            this.f4208g = z5;
            return this;
        }

        public b d(int i6) {
            this.f4206e = i6;
            return this;
        }

        public final b e(Map<String, String> map) {
            this.f4202a.a(map);
            return this;
        }

        public b f(int i6) {
            this.f4207f = i6;
            return this;
        }

        public b g(String str) {
            this.f4205d = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c extends m2.l<String, List<String>> {

        /* renamed from: a, reason: collision with root package name */
        private final Map<String, List<String>> f4210a;

        public c(Map<String, List<String>> map) {
            this.f4210a = map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean i(Map.Entry entry) {
            return entry.getKey() != null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean j(String str) {
            return str != null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m2.m
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map<String, List<String>> a() {
            return this.f4210a;
        }

        @Override // m2.l, java.util.Map
        public boolean containsKey(Object obj) {
            return obj != null && super.containsKey(obj);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return super.c(obj);
        }

        @Override // m2.l, java.util.Map
        public Set<Map.Entry<String, List<String>>> entrySet() {
            return m2.p0.b(super.entrySet(), new l2.l() { // from class: g2.x
                @Override // l2.l
                public final boolean apply(Object obj) {
                    boolean i6;
                    i6 = v.c.i((Map.Entry) obj);
                    return i6;
                }
            });
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            return obj != null && super.d(obj);
        }

        @Override // m2.l, java.util.Map
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public List<String> get(Object obj) {
            if (obj == null) {
                return null;
            }
            return (List) super.get(obj);
        }

        @Override // java.util.Map
        public int hashCode() {
            return super.e();
        }

        @Override // m2.l, java.util.Map
        public boolean isEmpty() {
            if (super.isEmpty()) {
                return true;
            }
            return super.size() == 1 && super.containsKey(null);
        }

        @Override // m2.l, java.util.Map
        public Set<String> keySet() {
            return m2.p0.b(super.keySet(), new l2.l() { // from class: g2.w
                @Override // l2.l
                public final boolean apply(Object obj) {
                    boolean j6;
                    j6 = v.c.j((String) obj);
                    return j6;
                }
            });
        }

        @Override // m2.l, java.util.Map
        public int size() {
            return super.size() - (super.containsKey(null) ? 1 : 0);
        }
    }

    private v(String str, int i6, int i7, boolean z5, e0 e0Var, l2.l<String> lVar, boolean z6) {
        super(true);
        this.f4190h = str;
        this.f4188f = i6;
        this.f4189g = i7;
        this.f4187e = z5;
        this.f4191i = e0Var;
        this.f4194l = lVar;
        this.f4192j = new e0();
        this.f4193k = z6;
    }

    private void A(long j6, q qVar) {
        if (j6 == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j6 > 0) {
            int read = ((InputStream) c1.j(this.f4197o)).read(bArr, 0, (int) Math.min(j6, 4096));
            if (Thread.currentThread().isInterrupted()) {
                throw new b0(new InterruptedIOException(), qVar, 2000, 1);
            }
            if (read == -1) {
                throw new b0(qVar, 2008, 1);
            }
            j6 -= read;
            o(read);
        }
    }

    private void s() {
        HttpURLConnection httpURLConnection = this.f4196n;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e6) {
                i2.t.d("DefaultHttpDataSource", "Unexpected error while disconnecting", e6);
            }
            this.f4196n = null;
        }
    }

    private URL t(URL url, String str, q qVar) {
        if (str == null) {
            throw new b0("Null location redirect", qVar, 2001, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new b0("Unsupported protocol redirect: " + protocol, qVar, 2001, 1);
            }
            if (this.f4187e || protocol.equals(url.getProtocol())) {
                return url2;
            }
            throw new b0("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", qVar, 2001, 1);
        } catch (MalformedURLException e6) {
            throw new b0(e6, qVar, 2001, 1);
        }
    }

    private static boolean u(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b1, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.net.HttpURLConnection v(g2.q r27) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.v.v(g2.q):java.net.HttpURLConnection");
    }

    private HttpURLConnection w(URL url, int i6, byte[] bArr, long j6, long j7, boolean z5, boolean z6, Map<String, String> map) {
        HttpURLConnection y5 = y(url);
        y5.setConnectTimeout(this.f4188f);
        y5.setReadTimeout(this.f4189g);
        HashMap hashMap = new HashMap();
        e0 e0Var = this.f4191i;
        if (e0Var != null) {
            hashMap.putAll(e0Var.b());
        }
        hashMap.putAll(this.f4192j.b());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            y5.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String a6 = f0.a(j6, j7);
        if (a6 != null) {
            y5.setRequestProperty("Range", a6);
        }
        String str = this.f4190h;
        if (str != null) {
            y5.setRequestProperty("User-Agent", str);
        }
        y5.setRequestProperty("Accept-Encoding", z5 ? "gzip" : "identity");
        y5.setInstanceFollowRedirects(z6);
        y5.setDoOutput(bArr != null);
        y5.setRequestMethod(q.c(i6));
        if (bArr != null) {
            y5.setFixedLengthStreamingMode(bArr.length);
            y5.connect();
            OutputStream outputStream = y5.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            y5.connect();
        }
        return y5;
    }

    private static void x(HttpURLConnection httpURLConnection, long j6) {
        int i6;
        if (httpURLConnection == null || (i6 = c1.f5548a) < 19 || i6 > 20) {
            return;
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            if (j6 == -1) {
                if (inputStream.read() == -1) {
                    return;
                }
            } else if (j6 <= 2048) {
                return;
            }
            String name = inputStream.getClass().getName();
            if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                Method declaredMethod = ((Class) i2.a.e(inputStream.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, new Object[0]);
            }
        } catch (Exception unused) {
        }
    }

    private int z(byte[] bArr, int i6, int i7) {
        if (i7 == 0) {
            return 0;
        }
        long j6 = this.f4200r;
        if (j6 != -1) {
            long j7 = j6 - this.f4201s;
            if (j7 == 0) {
                return -1;
            }
            i7 = (int) Math.min(i7, j7);
        }
        int read = ((InputStream) c1.j(this.f4197o)).read(bArr, i6, i7);
        if (read == -1) {
            return -1;
        }
        this.f4201s += read;
        o(read);
        return read;
    }

    @Override // g2.m
    public long a(q qVar) {
        byte[] bArr;
        this.f4195m = qVar;
        long j6 = 0;
        this.f4201s = 0L;
        this.f4200r = 0L;
        q(qVar);
        try {
            HttpURLConnection v5 = v(qVar);
            this.f4196n = v5;
            this.f4199q = v5.getResponseCode();
            String responseMessage = v5.getResponseMessage();
            int i6 = this.f4199q;
            if (i6 < 200 || i6 > 299) {
                Map<String, List<String>> headerFields = v5.getHeaderFields();
                if (this.f4199q == 416) {
                    if (qVar.f4103g == f0.c(v5.getHeaderField("Content-Range"))) {
                        this.f4198p = true;
                        r(qVar);
                        long j7 = qVar.f4104h;
                        if (j7 != -1) {
                            return j7;
                        }
                        return 0L;
                    }
                }
                InputStream errorStream = v5.getErrorStream();
                try {
                    bArr = errorStream != null ? c1.Z0(errorStream) : c1.f5553f;
                } catch (IOException unused) {
                    bArr = c1.f5553f;
                }
                byte[] bArr2 = bArr;
                s();
                throw new d0(this.f4199q, responseMessage, this.f4199q == 416 ? new n(2008) : null, headerFields, qVar, bArr2);
            }
            String contentType = v5.getContentType();
            l2.l<String> lVar = this.f4194l;
            if (lVar != null && !lVar.apply(contentType)) {
                s();
                throw new c0(contentType, qVar);
            }
            if (this.f4199q == 200) {
                long j8 = qVar.f4103g;
                if (j8 != 0) {
                    j6 = j8;
                }
            }
            boolean u5 = u(v5);
            if (u5) {
                this.f4200r = qVar.f4104h;
            } else {
                long j9 = qVar.f4104h;
                if (j9 != -1) {
                    this.f4200r = j9;
                } else {
                    long b6 = f0.b(v5.getHeaderField("Content-Length"), v5.getHeaderField("Content-Range"));
                    this.f4200r = b6 != -1 ? b6 - j6 : -1L;
                }
            }
            try {
                this.f4197o = v5.getInputStream();
                if (u5) {
                    this.f4197o = new GZIPInputStream(this.f4197o);
                }
                this.f4198p = true;
                r(qVar);
                try {
                    A(j6, qVar);
                    return this.f4200r;
                } catch (IOException e6) {
                    s();
                    if (e6 instanceof b0) {
                        throw ((b0) e6);
                    }
                    throw new b0(e6, qVar, 2000, 1);
                }
            } catch (IOException e7) {
                s();
                throw new b0(e7, qVar, 2000, 1);
            }
        } catch (IOException e8) {
            s();
            throw b0.c(e8, qVar, 1);
        }
    }

    @Override // g2.m
    public void close() {
        try {
            InputStream inputStream = this.f4197o;
            if (inputStream != null) {
                long j6 = this.f4200r;
                long j7 = -1;
                if (j6 != -1) {
                    j7 = j6 - this.f4201s;
                }
                x(this.f4196n, j7);
                try {
                    inputStream.close();
                } catch (IOException e6) {
                    throw new b0(e6, (q) c1.j(this.f4195m), 2000, 3);
                }
            }
        } finally {
            this.f4197o = null;
            s();
            if (this.f4198p) {
                this.f4198p = false;
                p();
            }
        }
    }

    @Override // g2.g, g2.m
    public Map<String, List<String>> f() {
        HttpURLConnection httpURLConnection = this.f4196n;
        return httpURLConnection == null ? m2.r.j() : new c(httpURLConnection.getHeaderFields());
    }

    @Override // g2.m
    public Uri j() {
        HttpURLConnection httpURLConnection = this.f4196n;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // g2.i
    public int read(byte[] bArr, int i6, int i7) {
        try {
            return z(bArr, i6, i7);
        } catch (IOException e6) {
            throw b0.c(e6, (q) c1.j(this.f4195m), 2);
        }
    }

    HttpURLConnection y(URL url) {
        return (HttpURLConnection) url.openConnection();
    }
}

package com.tendcloud.tenddata;

import android.os.SystemClock;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes.dex */
final class am {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2282a = 15000;

    /* renamed from: b, reason: collision with root package name */
    private static final int f2283b = 15000;

    /* renamed from: c, reason: collision with root package name */
    private URL f2284c;

    /* renamed from: d, reason: collision with root package name */
    private aq f2285d;

    /* renamed from: e, reason: collision with root package name */
    private ap f2286e;

    /* renamed from: f, reason: collision with root package name */
    private an f2287f;

    /* renamed from: g, reason: collision with root package name */
    private String f2288g;

    /* renamed from: h, reason: collision with root package name */
    private String f2289h;

    /* renamed from: i, reason: collision with root package name */
    private String f2290i;

    /* renamed from: j, reason: collision with root package name */
    private int f2291j;

    /* renamed from: k, reason: collision with root package name */
    private int f2292k;

    public static final class a {
        private an body;
        private String cert;
        private ap headers;
        private String host;
        private String ip;
        private aq method;
        private URL url;
        private int connectionTimeout = 15000;
        private int readTimeout = 15000;

        a() {
        }

        public a body(an anVar) {
            this.body = anVar;
            return this;
        }

        public am build() {
            return new am(this.url, this.method, this.headers, this.body, this.connectionTimeout, this.readTimeout, this.cert, this.host, this.ip);
        }

        public a cert(String str) {
            this.cert = str;
            return this;
        }

        public a connectionTimeout(int i6) {
            this.connectionTimeout = i6;
            return this;
        }

        public a header(ap apVar) {
            this.headers = apVar;
            return this;
        }

        public a host(String str) {
            this.host = str;
            return this;
        }

        public a ip(String str) {
            this.ip = str;
            return this;
        }

        public a method(aq aqVar) {
            this.method = aqVar;
            return this;
        }

        public a readTimeout(int i6) {
            this.readTimeout = i6;
            return this;
        }

        public a url(String str) {
            try {
                this.url = new URL(str);
                return this;
            } catch (MalformedURLException e6) {
                throw new IllegalArgumentException(e6);
            }
        }
    }

    private am(URL url, aq aqVar, ap apVar, an anVar, int i6, int i7, String str, String str2, String str3) {
        this.f2284c = url;
        this.f2285d = aqVar;
        this.f2286e = apVar;
        this.f2287f = anVar;
        this.f2291j = i6;
        this.f2292k = i7;
        this.f2288g = str;
        this.f2289h = str2;
        this.f2290i = str3;
    }

    public aq a() {
        return this.f2285d;
    }

    ar a(com.tendcloud.tenddata.a aVar) {
        ar a6 = ar.a("");
        try {
            ar a7 = a(false);
            URL url = this.f2284c;
            String str = this.f2289h;
            if (aVar.name().equals("SDK") && a7.b() == ar.a()) {
                ai.a(str);
                int i6 = 0;
                while (true) {
                    if (i6 > ai.f2265a.size()) {
                        break;
                    }
                    String a8 = ai.a();
                    this.f2289h = a8;
                    URL a9 = ai.a(url, a8);
                    this.f2284c = a9;
                    if (url.equals(a9) && str.equals(this.f2289h)) {
                        break;
                    }
                    a7 = a(false);
                    ai.a(this.f2289h);
                    if (a7.b() != ar.a()) {
                        s.a(ab.f2233g, ab.f2250x, ab.D, this.f2284c.toString());
                        s.a(ab.f2233g, ab.f2250x, ab.E, this.f2289h);
                        break;
                    }
                    i6++;
                }
            }
            ak.b(this.f2289h, this.f2290i);
            if (a7.b() != ar.a()) {
                String str2 = this.f2289h;
                ak.a(str2, ak.b(str2), 2);
                ak.a(this.f2289h);
                return a7;
            }
            if (ak.a(this.f2289h, 2) != null) {
                this.f2284c = ak.a(this.f2284c, ak.a(this.f2289h, 2));
                a7 = a(true);
                if (a7.b() == ar.a()) {
                    ak.a(this.f2289h, null, 2);
                }
            } else {
                if (ak.a(this.f2289h, 1) != null) {
                    this.f2284c = ak.a(this.f2284c, ak.a(this.f2289h, 1));
                    a7 = a(true);
                    if (a7.b() != ar.a()) {
                        String str3 = this.f2289h;
                        ak.a(str3, ak.a(str3, 1), 2);
                        ak.a(this.f2289h);
                    }
                }
                if (a7.b() == ar.a() && ak.a(this.f2289h, 3) != null) {
                    this.f2284c = ak.a(this.f2284c, ak.a(this.f2289h, 3));
                    a7 = a(true);
                    if (a7.b() != ar.a()) {
                        String str4 = this.f2289h;
                        ak.a(str4, ak.a(str4, 3), 2);
                    }
                }
                if (a7.b() == ar.a() && ak.a(this.f2289h, 4) != null) {
                    this.f2284c = ak.a(this.f2284c, ak.a(this.f2289h, 4));
                    a7 = a(true);
                    if (a7.b() != ar.a()) {
                        String str5 = this.f2289h;
                        ak.a(str5, ak.a(str5, 4), 2);
                    }
                }
                if (a7.b() == ar.a() && aj.b(this.f2289h) == 3 && !aj.c(this.f2289h)) {
                    String a10 = aj.a(this.f2289h);
                    if (!y.b(a10)) {
                        this.f2284c = ak.a(this.f2284c, a10);
                        aj.updateTimeStamp(this.f2289h);
                        a7 = a(true);
                        if (a7.b() != ar.a()) {
                            ak.a(this.f2289h, a10);
                        }
                    }
                }
            }
            if (a7.b() == ar.a() && aj.b(this.f2289h) < 3) {
                aj.updateFailureCountWithHost(this.f2289h);
            }
            return a7;
        } catch (Throwable th) {
            bq.postSDKError(th);
            return a6;
        }
    }

    ar a(boolean z5) {
        ar a6;
        HttpURLConnection httpURLConnection = null;
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) this.f2284c.openConnection();
            try {
                httpURLConnection2.setConnectTimeout(15000);
                httpURLConnection2.setReadTimeout(15000);
                URL url = this.f2284c;
                if (url != null && url.toString().startsWith("https://")) {
                    ah.f2261a.put(Long.valueOf(Thread.currentThread().getId()), this.f2289h);
                    if (z5) {
                        ah.setHostNameVerifyAllowAll(httpURLConnection2);
                    }
                }
                if (!y.b(this.f2288g)) {
                    ah.a(httpURLConnection2, this.f2288g);
                }
                if (!y.b(this.f2289h)) {
                    httpURLConnection2.setRequestProperty("Host", y.b(this.f2284c.getHost()) ? this.f2289h : this.f2284c.getHost());
                    httpURLConnection2.setRequestProperty("Host", this.f2289h);
                }
                aq aqVar = this.f2285d;
                if (aqVar != null) {
                    aqVar.a(httpURLConnection2);
                }
                ap apVar = this.f2286e;
                if (apVar != null) {
                    apVar.a(httpURLConnection2);
                }
                an anVar = this.f2287f;
                if (anVar != null) {
                    anVar.a(httpURLConnection2);
                }
                httpURLConnection2.connect();
                a6 = ar.a(this.f2289h, httpURLConnection2, elapsedRealtime, this.f2287f);
                httpURLConnection2.disconnect();
            } catch (Throwable th) {
                th = th;
                httpURLConnection = httpURLConnection2;
                try {
                    bq.postSDKError(th);
                    a6 = ar.a(th.getMessage());
                    return a6;
                } finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return a6;
    }

    ar b() {
        ar a6 = ar.a("");
        try {
            ar a7 = a(false);
            if (a7.b() != ar.a()) {
                return a7;
            }
            String a8 = aj.a(this.f2289h);
            if (y.b(a8)) {
                return a7;
            }
            this.f2284c = ak.a(this.f2284c, a8);
            return a(true);
        } catch (Throwable unused) {
            return a6;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n url: ");
        sb.append(this.f2284c);
        sb.append("\n method: ");
        sb.append(this.f2285d);
        sb.append("\n headers: ");
        sb.append(this.f2286e);
        sb.append("\n content length: ");
        an anVar = this.f2287f;
        sb.append(anVar != null ? Integer.valueOf(anVar.a().length) : "");
        sb.append("\n content Type: ");
        an anVar2 = this.f2287f;
        sb.append(anVar2 != null ? anVar2.b() : "");
        sb.append("\n host: ");
        sb.append(this.f2289h);
        sb.append("\n ip: ");
        sb.append(this.f2290i);
        sb.append("\n connectionTimeout: ");
        sb.append(this.f2291j);
        sb.append("\n readTimeout: ");
        sb.append(this.f2292k);
        sb.append("\n cert:  ");
        sb.append(this.f2288g);
        sb.append("\n");
        return sb.toString();
    }
}

package g5;

import d5.b0;
import d5.d;
import d5.t;
import d5.z;
import j5.c;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import v4.p;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final a f4242c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final z f4243a;

    /* renamed from: b, reason: collision with root package name */
    private final b0 f4244b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final boolean a(b0 response, z request) {
            k.e(response, "response");
            k.e(request, "request");
            int s5 = response.s();
            if (s5 != 200 && s5 != 410 && s5 != 414 && s5 != 501 && s5 != 203 && s5 != 204) {
                if (s5 != 307) {
                    if (s5 != 308 && s5 != 404 && s5 != 405) {
                        switch (s5) {
                            case 300:
                            case 301:
                                break;
                            case 302:
                                break;
                            default:
                                return false;
                        }
                    }
                }
                if (b0.F(response, "Expires", null, 2, null) == null && response.j().c() == -1 && !response.j().b() && !response.j().a()) {
                    return false;
                }
            }
            return (response.j().h() || request.b().h()) ? false : true;
        }
    }

    /* renamed from: g5.b$b, reason: collision with other inner class name */
    public static final class C0080b {

        /* renamed from: a, reason: collision with root package name */
        private Date f4245a;

        /* renamed from: b, reason: collision with root package name */
        private String f4246b;

        /* renamed from: c, reason: collision with root package name */
        private Date f4247c;

        /* renamed from: d, reason: collision with root package name */
        private String f4248d;

        /* renamed from: e, reason: collision with root package name */
        private Date f4249e;

        /* renamed from: f, reason: collision with root package name */
        private long f4250f;

        /* renamed from: g, reason: collision with root package name */
        private long f4251g;

        /* renamed from: h, reason: collision with root package name */
        private String f4252h;

        /* renamed from: i, reason: collision with root package name */
        private int f4253i;

        /* renamed from: j, reason: collision with root package name */
        private final long f4254j;

        /* renamed from: k, reason: collision with root package name */
        private final z f4255k;

        /* renamed from: l, reason: collision with root package name */
        private final b0 f4256l;

        public C0080b(long j6, z request, b0 b0Var) {
            boolean o6;
            boolean o7;
            boolean o8;
            boolean o9;
            boolean o10;
            k.e(request, "request");
            this.f4254j = j6;
            this.f4255k = request;
            this.f4256l = b0Var;
            this.f4253i = -1;
            if (b0Var != null) {
                this.f4250f = b0Var.Z();
                this.f4251g = b0Var.X();
                t I = b0Var.I();
                int size = I.size();
                for (int i6 = 0; i6 < size; i6++) {
                    String c6 = I.c(i6);
                    String e6 = I.e(i6);
                    o6 = p.o(c6, "Date", true);
                    if (o6) {
                        this.f4245a = c.a(e6);
                        this.f4246b = e6;
                    } else {
                        o7 = p.o(c6, "Expires", true);
                        if (o7) {
                            this.f4249e = c.a(e6);
                        } else {
                            o8 = p.o(c6, "Last-Modified", true);
                            if (o8) {
                                this.f4247c = c.a(e6);
                                this.f4248d = e6;
                            } else {
                                o9 = p.o(c6, "ETag", true);
                                if (o9) {
                                    this.f4252h = e6;
                                } else {
                                    o10 = p.o(c6, "Age", true);
                                    if (o10) {
                                        this.f4253i = e5.b.O(e6, -1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        private final long a() {
            Date date = this.f4245a;
            long max = date != null ? Math.max(0L, this.f4251g - date.getTime()) : 0L;
            int i6 = this.f4253i;
            if (i6 != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i6));
            }
            long j6 = this.f4251g;
            return max + (j6 - this.f4250f) + (this.f4254j - j6);
        }

        private final b c() {
            String str;
            if (this.f4256l == null) {
                return new b(this.f4255k, null);
            }
            if ((!this.f4255k.f() || this.f4256l.v() != null) && b.f4242c.a(this.f4256l, this.f4255k)) {
                d b6 = this.f4255k.b();
                if (b6.g() || e(this.f4255k)) {
                    return new b(this.f4255k, null);
                }
                d j6 = this.f4256l.j();
                long a6 = a();
                long d6 = d();
                if (b6.c() != -1) {
                    d6 = Math.min(d6, TimeUnit.SECONDS.toMillis(b6.c()));
                }
                long j7 = 0;
                long millis = b6.e() != -1 ? TimeUnit.SECONDS.toMillis(b6.e()) : 0L;
                if (!j6.f() && b6.d() != -1) {
                    j7 = TimeUnit.SECONDS.toMillis(b6.d());
                }
                if (!j6.g()) {
                    long j8 = millis + a6;
                    if (j8 < j7 + d6) {
                        b0.a U = this.f4256l.U();
                        if (j8 >= d6) {
                            U.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (a6 > 86400000 && f()) {
                            U.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new b(null, U.c());
                    }
                }
                String str2 = this.f4252h;
                if (str2 != null) {
                    str = "If-None-Match";
                } else {
                    if (this.f4247c != null) {
                        str2 = this.f4248d;
                    } else {
                        if (this.f4245a == null) {
                            return new b(this.f4255k, null);
                        }
                        str2 = this.f4246b;
                    }
                    str = "If-Modified-Since";
                }
                t.a d7 = this.f4255k.e().d();
                k.b(str2);
                d7.c(str, str2);
                return new b(this.f4255k.h().c(d7.d()).a(), this.f4256l);
            }
            return new b(this.f4255k, null);
        }

        private final long d() {
            b0 b0Var = this.f4256l;
            k.b(b0Var);
            if (b0Var.j().c() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.c());
            }
            Date date = this.f4249e;
            if (date != null) {
                Date date2 = this.f4245a;
                long time = date.getTime() - (date2 != null ? date2.getTime() : this.f4251g);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f4247c == null || this.f4256l.Y().i().m() != null) {
                return 0L;
            }
            Date date3 = this.f4245a;
            long time2 = date3 != null ? date3.getTime() : this.f4250f;
            Date date4 = this.f4247c;
            k.b(date4);
            long time3 = time2 - date4.getTime();
            if (time3 > 0) {
                return time3 / 10;
            }
            return 0L;
        }

        private final boolean e(z zVar) {
            return (zVar.d("If-Modified-Since") == null && zVar.d("If-None-Match") == null) ? false : true;
        }

        private final boolean f() {
            b0 b0Var = this.f4256l;
            k.b(b0Var);
            return b0Var.j().c() == -1 && this.f4249e == null;
        }

        public final b b() {
            b c6 = c();
            return (c6.b() == null || !this.f4255k.b().i()) ? c6 : new b(null, null);
        }
    }

    public b(z zVar, b0 b0Var) {
        this.f4243a = zVar;
        this.f4244b = b0Var;
    }

    public final b0 a() {
        return this.f4244b;
    }

    public final z b() {
        return this.f4243a;
    }
}

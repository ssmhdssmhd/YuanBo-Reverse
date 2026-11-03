package androidx.work;

import android.content.Context;
import androidx.work.impl.utils.futures.d;
import java.util.UUID;
import java.util.concurrent.Executor;
import v.e;
import v.v;

/* loaded from: classes.dex */
public abstract class ListenableWorker {

    /* renamed from: a, reason: collision with root package name */
    private Context f1465a;

    /* renamed from: b, reason: collision with root package name */
    private WorkerParameters f1466b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f1467c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f1468d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f1469e;

    public static abstract class a {

        /* renamed from: androidx.work.ListenableWorker$a$a, reason: collision with other inner class name */
        public static final class C0028a extends a {

            /* renamed from: a, reason: collision with root package name */
            private final androidx.work.b f1470a;

            public C0028a() {
                this(androidx.work.b.f1513c);
            }

            public C0028a(androidx.work.b bVar) {
                this.f1470a = bVar;
            }

            public androidx.work.b e() {
                return this.f1470a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || C0028a.class != obj.getClass()) {
                    return false;
                }
                return this.f1470a.equals(((C0028a) obj).f1470a);
            }

            public int hashCode() {
                return (C0028a.class.getName().hashCode() * 31) + this.f1470a.hashCode();
            }

            public String toString() {
                return "Failure {mOutputData=" + this.f1470a + '}';
            }
        }

        public static final class b extends a {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && b.class == obj.getClass();
            }

            public int hashCode() {
                return b.class.getName().hashCode();
            }

            public String toString() {
                return "Retry";
            }
        }

        public static final class c extends a {

            /* renamed from: a, reason: collision with root package name */
            private final androidx.work.b f1471a;

            public c() {
                this(androidx.work.b.f1513c);
            }

            public c(androidx.work.b bVar) {
                this.f1471a = bVar;
            }

            public androidx.work.b e() {
                return this.f1471a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || c.class != obj.getClass()) {
                    return false;
                }
                return this.f1471a.equals(((c) obj).f1471a);
            }

            public int hashCode() {
                return (c.class.getName().hashCode() * 31) + this.f1471a.hashCode();
            }

            public String toString() {
                return "Success {mOutputData=" + this.f1471a + '}';
            }
        }

        a() {
        }

        public static a a() {
            return new C0028a();
        }

        public static a b() {
            return new b();
        }

        public static a c() {
            return new c();
        }

        public static a d(androidx.work.b bVar) {
            return new c(bVar);
        }
    }

    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if (workerParameters == null) {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        this.f1465a = context;
        this.f1466b = workerParameters;
    }

    public final Context a() {
        return this.f1465a;
    }

    public Executor b() {
        return this.f1466b.a();
    }

    public p2.a<e> d() {
        d t5 = d.t();
        t5.q(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return t5;
    }

    public final UUID f() {
        return this.f1466b.c();
    }

    public final b g() {
        return this.f1466b.d();
    }

    public v h() {
        return this.f1466b.e();
    }

    public boolean i() {
        return this.f1469e;
    }

    public final boolean j() {
        return this.f1467c;
    }

    public final boolean k() {
        return this.f1468d;
    }

    public void l() {
    }

    public void m(boolean z5) {
        this.f1469e = z5;
    }

    public final void n() {
        this.f1468d = true;
    }

    public abstract p2.a<a> o();

    public final void p() {
        this.f1467c = true;
        l();
    }
}

package h0;

import android.os.Looper;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class s3 {

    /* renamed from: a, reason: collision with root package name */
    private final b f4867a;

    /* renamed from: b, reason: collision with root package name */
    private final a f4868b;

    /* renamed from: c, reason: collision with root package name */
    private final i2.e f4869c;

    /* renamed from: d, reason: collision with root package name */
    private final m4 f4870d;

    /* renamed from: e, reason: collision with root package name */
    private int f4871e;

    /* renamed from: f, reason: collision with root package name */
    private Object f4872f;

    /* renamed from: g, reason: collision with root package name */
    private Looper f4873g;

    /* renamed from: h, reason: collision with root package name */
    private int f4874h;

    /* renamed from: i, reason: collision with root package name */
    private long f4875i = -9223372036854775807L;

    /* renamed from: j, reason: collision with root package name */
    private boolean f4876j = true;

    /* renamed from: k, reason: collision with root package name */
    private boolean f4877k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f4878l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f4879m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f4880n;

    public interface a {
        void c(s3 s3Var);
    }

    public interface b {
        void m(int i6, Object obj);
    }

    public s3(a aVar, b bVar, m4 m4Var, int i6, i2.e eVar, Looper looper) {
        this.f4868b = aVar;
        this.f4867a = bVar;
        this.f4870d = m4Var;
        this.f4873g = looper;
        this.f4869c = eVar;
        this.f4874h = i6;
    }

    public synchronized boolean a(long j6) {
        boolean z5;
        i2.a.g(this.f4877k);
        i2.a.g(this.f4873g.getThread() != Thread.currentThread());
        long d6 = this.f4869c.d() + j6;
        while (true) {
            z5 = this.f4879m;
            if (z5 || j6 <= 0) {
                break;
            }
            this.f4869c.c();
            wait(j6);
            j6 = d6 - this.f4869c.d();
        }
        if (!z5) {
            throw new TimeoutException("Message delivery timed out.");
        }
        return this.f4878l;
    }

    public boolean b() {
        return this.f4876j;
    }

    public Looper c() {
        return this.f4873g;
    }

    public int d() {
        return this.f4874h;
    }

    public Object e() {
        return this.f4872f;
    }

    public long f() {
        return this.f4875i;
    }

    public b g() {
        return this.f4867a;
    }

    public m4 h() {
        return this.f4870d;
    }

    public int i() {
        return this.f4871e;
    }

    public synchronized boolean j() {
        return this.f4880n;
    }

    public synchronized void k(boolean z5) {
        this.f4878l = z5 | this.f4878l;
        this.f4879m = true;
        notifyAll();
    }

    public s3 l() {
        i2.a.g(!this.f4877k);
        if (this.f4875i == -9223372036854775807L) {
            i2.a.a(this.f4876j);
        }
        this.f4877k = true;
        this.f4868b.c(this);
        return this;
    }

    public s3 m(Object obj) {
        i2.a.g(!this.f4877k);
        this.f4872f = obj;
        return this;
    }

    public s3 n(int i6) {
        i2.a.g(!this.f4877k);
        this.f4871e = i6;
        return this;
    }
}

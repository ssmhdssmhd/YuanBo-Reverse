package n1;

import android.net.Uri;
import g2.i0;
import g2.q;
import g2.s0;
import h0.y1;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class f implements i0.e {

    /* renamed from: a, reason: collision with root package name */
    public final long f8199a = l1.o.a();

    /* renamed from: b, reason: collision with root package name */
    public final q f8200b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8201c;

    /* renamed from: d, reason: collision with root package name */
    public final y1 f8202d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8203e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f8204f;

    /* renamed from: g, reason: collision with root package name */
    public final long f8205g;

    /* renamed from: h, reason: collision with root package name */
    public final long f8206h;

    /* renamed from: i, reason: collision with root package name */
    protected final s0 f8207i;

    public f(g2.m mVar, q qVar, int i6, y1 y1Var, int i7, Object obj, long j6, long j7) {
        this.f8207i = new s0(mVar);
        this.f8200b = (q) i2.a.e(qVar);
        this.f8201c = i6;
        this.f8202d = y1Var;
        this.f8203e = i7;
        this.f8204f = obj;
        this.f8205g = j6;
        this.f8206h = j7;
    }

    public final long b() {
        return this.f8207i.o();
    }

    public final long d() {
        return this.f8206h - this.f8205g;
    }

    public final Map<String, List<String>> e() {
        return this.f8207i.q();
    }

    public final Uri f() {
        return this.f8207i.p();
    }
}

package i5;

import d5.d0;
import d5.r;
import d5.u;
import d5.x;
import i5.k;
import java.io.IOException;
import l5.n;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private k.b f5744a;

    /* renamed from: b, reason: collision with root package name */
    private k f5745b;

    /* renamed from: c, reason: collision with root package name */
    private int f5746c;

    /* renamed from: d, reason: collision with root package name */
    private int f5747d;

    /* renamed from: e, reason: collision with root package name */
    private int f5748e;

    /* renamed from: f, reason: collision with root package name */
    private d0 f5749f;

    /* renamed from: g, reason: collision with root package name */
    private final h f5750g;

    /* renamed from: h, reason: collision with root package name */
    private final d5.a f5751h;

    /* renamed from: i, reason: collision with root package name */
    private final e f5752i;

    /* renamed from: j, reason: collision with root package name */
    private final r f5753j;

    public d(h connectionPool, d5.a address, e call, r eventListener) {
        kotlin.jvm.internal.k.e(connectionPool, "connectionPool");
        kotlin.jvm.internal.k.e(address, "address");
        kotlin.jvm.internal.k.e(call, "call");
        kotlin.jvm.internal.k.e(eventListener, "eventListener");
        this.f5750g = connectionPool;
        this.f5751h = address;
        this.f5752i = call;
        this.f5753j = eventListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final i5.f b(int r15, int r16, int r17, int r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.d.b(int, int, int, int, boolean):i5.f");
    }

    private final f c(int i6, int i7, int i8, int i9, boolean z5, boolean z6) {
        while (true) {
            f b6 = b(i6, i7, i8, i9, z5);
            if (b6.u(z6)) {
                return b6;
            }
            b6.y();
            if (this.f5749f == null) {
                k.b bVar = this.f5744a;
                if (bVar != null ? bVar.b() : true) {
                    continue;
                } else {
                    k kVar = this.f5745b;
                    if (!(kVar != null ? kVar.b() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
    }

    private final d0 f() {
        f l6;
        if (this.f5746c > 1 || this.f5747d > 1 || this.f5748e > 0 || (l6 = this.f5752i.l()) == null) {
            return null;
        }
        synchronized (l6) {
            if (l6.q() != 0) {
                return null;
            }
            if (e5.b.g(l6.z().a().l(), this.f5751h.l())) {
                return l6.z();
            }
            return null;
        }
    }

    public final j5.d a(x client, j5.g chain) {
        kotlin.jvm.internal.k.e(client, "client");
        kotlin.jvm.internal.k.e(chain, "chain");
        try {
            return c(chain.f(), chain.h(), chain.j(), client.v(), client.B(), !kotlin.jvm.internal.k.a(chain.i().g(), "GET")).w(client, chain);
        } catch (j e6) {
            h(e6.c());
            throw e6;
        } catch (IOException e7) {
            h(e7);
            throw new j(e7);
        }
    }

    public final d5.a d() {
        return this.f5751h;
    }

    public final boolean e() {
        k kVar;
        if (this.f5746c == 0 && this.f5747d == 0 && this.f5748e == 0) {
            return false;
        }
        if (this.f5749f != null) {
            return true;
        }
        d0 f6 = f();
        if (f6 != null) {
            this.f5749f = f6;
            return true;
        }
        k.b bVar = this.f5744a;
        if ((bVar == null || !bVar.b()) && (kVar = this.f5745b) != null) {
            return kVar.b();
        }
        return true;
    }

    public final boolean g(u url) {
        kotlin.jvm.internal.k.e(url, "url");
        u l6 = this.f5751h.l();
        return url.l() == l6.l() && kotlin.jvm.internal.k.a(url.h(), l6.h());
    }

    public final void h(IOException e6) {
        kotlin.jvm.internal.k.e(e6, "e");
        this.f5749f = null;
        if ((e6 instanceof n) && ((n) e6).f7731a == l5.b.REFUSED_STREAM) {
            this.f5746c++;
        } else if (e6 instanceof l5.a) {
            this.f5747d++;
        } else {
            this.f5748e++;
        }
    }
}

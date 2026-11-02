package m0;

import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import g2.m;
import h0.y1;
import i0.o3;
import java.util.Map;
import l1.v;
import m0.h;
import m0.m;
import m0.o;
import m0.w;

/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: e, reason: collision with root package name */
    private static final y1 f7885e = new y1.b().O(new m(new m.b[0])).G();

    /* renamed from: a, reason: collision with root package name */
    private final ConditionVariable f7886a;

    /* renamed from: b, reason: collision with root package name */
    private final h f7887b;

    /* renamed from: c, reason: collision with root package name */
    private final HandlerThread f7888c;

    /* renamed from: d, reason: collision with root package name */
    private final w.a f7889d;

    class a implements w {
        a() {
        }

        @Override // m0.w
        public /* synthetic */ void F(int i6, v.b bVar) {
            p.a(this, i6, bVar);
        }

        @Override // m0.w
        public void H(int i6, v.b bVar) {
            u0.this.f7886a.open();
        }

        @Override // m0.w
        public void Q(int i6, v.b bVar) {
            u0.this.f7886a.open();
        }

        @Override // m0.w
        public /* synthetic */ void X(int i6, v.b bVar, int i7) {
            p.b(this, i6, bVar, i7);
        }

        @Override // m0.w
        public void Y(int i6, v.b bVar, Exception exc) {
            u0.this.f7886a.open();
        }

        @Override // m0.w
        public void j0(int i6, v.b bVar) {
            u0.this.f7886a.open();
        }

        @Override // m0.w
        public /* synthetic */ void n0(int i6, v.b bVar) {
            p.c(this, i6, bVar);
        }
    }

    public u0(h hVar, w.a aVar) {
        this.f7887b = hVar;
        this.f7889d = aVar;
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:OfflineLicenseHelper");
        this.f7888c = handlerThread;
        handlerThread.start();
        this.f7886a = new ConditionVariable();
        aVar.g(new Handler(handlerThread.getLooper()), new a());
    }

    private byte[] b(int i6, byte[] bArr, y1 y1Var) {
        this.f7887b.b(this.f7888c.getLooper(), o3.f5416b);
        this.f7887b.e();
        o h6 = h(i6, bArr, y1Var);
        o.a h7 = h6.h();
        byte[] f6 = h6.f();
        h6.e(this.f7889d);
        this.f7887b.a();
        if (h7 == null) {
            return (byte[]) i2.a.e(f6);
        }
        throw h7;
    }

    public static u0 e(String str, m.a aVar, w.a aVar2) {
        return g(str, false, aVar, aVar2);
    }

    public static u0 f(String str, boolean z5, m.a aVar, Map<String, String> map, w.a aVar2) {
        return new u0(new h.b().b(map).a(new p0(str, z5, aVar)), aVar2);
    }

    public static u0 g(String str, boolean z5, m.a aVar, w.a aVar2) {
        return f(str, z5, aVar, null, aVar2);
    }

    private o h(int i6, byte[] bArr, y1 y1Var) {
        i2.a.e(y1Var.f5069s);
        this.f7887b.G(i6, bArr);
        this.f7886a.close();
        o f6 = this.f7887b.f(this.f7889d, y1Var);
        this.f7886a.block();
        return (o) i2.a.e(f6);
    }

    public synchronized byte[] c(y1 y1Var) {
        i2.a.a(y1Var.f5069s != null);
        return b(2, null, y1Var);
    }

    public synchronized Pair<Long, Long> d(byte[] bArr) {
        i2.a.e(bArr);
        this.f7887b.b(this.f7888c.getLooper(), o3.f5416b);
        this.f7887b.e();
        o h6 = h(1, bArr, f7885e);
        o.a h7 = h6.h();
        Pair<Long, Long> b6 = w0.b(h6);
        h6.e(this.f7889d);
        this.f7887b.a();
        if (h7 == null) {
            return (Pair) i2.a.e(b6);
        }
        if (!(h7.getCause() instanceof q0)) {
            throw h7;
        }
        return Pair.create(0L, 0L);
    }

    public void i() {
        this.f7888c.quit();
    }

    public synchronized void j(byte[] bArr) {
        i2.a.e(bArr);
        b(3, bArr, f7885e);
    }
}

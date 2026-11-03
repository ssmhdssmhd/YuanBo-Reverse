package i2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import i2.p;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class p0 implements p {

    /* renamed from: b, reason: collision with root package name */
    private static final List<b> f5633b = new ArrayList(50);

    /* renamed from: a, reason: collision with root package name */
    private final Handler f5634a;

    private static final class b implements p.a {

        /* renamed from: a, reason: collision with root package name */
        private Message f5635a;

        /* renamed from: b, reason: collision with root package name */
        private p0 f5636b;

        private b() {
        }

        private void b() {
            this.f5635a = null;
            this.f5636b = null;
            p0.o(this);
        }

        @Override // i2.p.a
        public void a() {
            ((Message) i2.a.e(this.f5635a)).sendToTarget();
            b();
        }

        public boolean c(Handler handler) {
            boolean sendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue((Message) i2.a.e(this.f5635a));
            b();
            return sendMessageAtFrontOfQueue;
        }

        public b d(Message message, p0 p0Var) {
            this.f5635a = message;
            this.f5636b = p0Var;
            return this;
        }
    }

    public p0(Handler handler) {
        this.f5634a = handler;
    }

    private static b n() {
        b bVar;
        List<b> list = f5633b;
        synchronized (list) {
            bVar = list.isEmpty() ? new b() : list.remove(list.size() - 1);
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o(b bVar) {
        List<b> list = f5633b;
        synchronized (list) {
            if (list.size() < 50) {
                list.add(bVar);
            }
        }
    }

    @Override // i2.p
    public boolean a(int i6) {
        return this.f5634a.hasMessages(i6);
    }

    @Override // i2.p
    public p.a b(int i6, int i7, int i8) {
        return n().d(this.f5634a.obtainMessage(i6, i7, i8), this);
    }

    @Override // i2.p
    public boolean c(int i6) {
        return this.f5634a.sendEmptyMessage(i6);
    }

    @Override // i2.p
    public boolean d(p.a aVar) {
        return ((b) aVar).c(this.f5634a);
    }

    @Override // i2.p
    public p.a e(int i6, int i7, int i8, Object obj) {
        return n().d(this.f5634a.obtainMessage(i6, i7, i8, obj), this);
    }

    @Override // i2.p
    public boolean f(int i6, long j6) {
        return this.f5634a.sendEmptyMessageAtTime(i6, j6);
    }

    @Override // i2.p
    public void g(int i6) {
        this.f5634a.removeMessages(i6);
    }

    @Override // i2.p
    public p.a h(int i6, Object obj) {
        return n().d(this.f5634a.obtainMessage(i6, obj), this);
    }

    @Override // i2.p
    public void i(Object obj) {
        this.f5634a.removeCallbacksAndMessages(obj);
    }

    @Override // i2.p
    public Looper j() {
        return this.f5634a.getLooper();
    }

    @Override // i2.p
    public boolean k(Runnable runnable) {
        return this.f5634a.post(runnable);
    }

    @Override // i2.p
    public p.a l(int i6) {
        return n().d(this.f5634a.obtainMessage(i6), this);
    }
}

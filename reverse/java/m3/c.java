package m3;

import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import m3.c;
import y3.c;

/* loaded from: classes.dex */
class c implements y3.c, m3.f {

    /* renamed from: a, reason: collision with root package name */
    private final FlutterJNI f8076a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, f> f8077b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, List<b>> f8078c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f8079d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f8080e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<Integer, c.b> f8081f;

    /* renamed from: g, reason: collision with root package name */
    private int f8082g;

    /* renamed from: h, reason: collision with root package name */
    private final d f8083h;

    /* renamed from: i, reason: collision with root package name */
    private WeakHashMap<c.InterfaceC0170c, d> f8084i;

    /* renamed from: j, reason: collision with root package name */
    private i f8085j;

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        public final ByteBuffer f8086a;

        /* renamed from: b, reason: collision with root package name */
        int f8087b;

        /* renamed from: c, reason: collision with root package name */
        long f8088c;

        b(ByteBuffer byteBuffer, int i6, long j6) {
            this.f8086a = byteBuffer;
            this.f8087b = i6;
            this.f8088c = j6;
        }
    }

    /* renamed from: m3.c$c, reason: collision with other inner class name */
    static class C0122c implements d {

        /* renamed from: a, reason: collision with root package name */
        private final ExecutorService f8089a;

        C0122c(ExecutorService executorService) {
            this.f8089a = executorService;
        }

        @Override // m3.c.d
        public void a(Runnable runnable) {
            this.f8089a.execute(runnable);
        }
    }

    interface d {
        void a(Runnable runnable);
    }

    private static class e implements i {

        /* renamed from: a, reason: collision with root package name */
        ExecutorService f8090a = k3.a.e().b();

        e() {
        }

        @Override // m3.c.i
        public d a(c.d dVar) {
            return dVar.a() ? new h(this.f8090a) : new C0122c(this.f8090a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class f {

        /* renamed from: a, reason: collision with root package name */
        public final c.a f8091a;

        /* renamed from: b, reason: collision with root package name */
        public final d f8092b;

        f(c.a aVar, d dVar) {
            this.f8091a = aVar;
            this.f8092b = dVar;
        }
    }

    static class g implements c.b {

        /* renamed from: a, reason: collision with root package name */
        private final FlutterJNI f8093a;

        /* renamed from: b, reason: collision with root package name */
        private final int f8094b;

        /* renamed from: c, reason: collision with root package name */
        private final AtomicBoolean f8095c = new AtomicBoolean(false);

        g(FlutterJNI flutterJNI, int i6) {
            this.f8093a = flutterJNI;
            this.f8094b = i6;
        }

        @Override // y3.c.b
        public void a(ByteBuffer byteBuffer) {
            if (this.f8095c.getAndSet(true)) {
                throw new IllegalStateException("Reply already submitted");
            }
            if (byteBuffer == null) {
                this.f8093a.invokePlatformMessageEmptyResponseCallback(this.f8094b);
            } else {
                this.f8093a.invokePlatformMessageResponseCallback(this.f8094b, byteBuffer, byteBuffer.position());
            }
        }
    }

    static class h implements d {

        /* renamed from: a, reason: collision with root package name */
        private final ExecutorService f8096a;

        /* renamed from: b, reason: collision with root package name */
        private final ConcurrentLinkedQueue<Runnable> f8097b = new ConcurrentLinkedQueue<>();

        /* renamed from: c, reason: collision with root package name */
        private final AtomicBoolean f8098c = new AtomicBoolean(false);

        h(ExecutorService executorService) {
            this.f8096a = executorService;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public void f() {
            if (this.f8098c.compareAndSet(false, true)) {
                try {
                    Runnable poll = this.f8097b.poll();
                    if (poll != null) {
                        poll.run();
                    }
                } finally {
                    this.f8098c.set(false);
                    if (!this.f8097b.isEmpty()) {
                        this.f8096a.execute(new Runnable() { // from class: m3.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                c.h.this.f();
                            }
                        });
                    }
                }
            }
        }

        @Override // m3.c.d
        public void a(Runnable runnable) {
            this.f8097b.add(runnable);
            this.f8096a.execute(new Runnable() { // from class: m3.d
                @Override // java.lang.Runnable
                public final void run() {
                    c.h.this.e();
                }
            });
        }
    }

    interface i {
        d a(c.d dVar);
    }

    private static class j implements c.InterfaceC0170c {
        private j() {
        }
    }

    c(FlutterJNI flutterJNI) {
        this(flutterJNI, new e());
    }

    c(FlutterJNI flutterJNI, i iVar) {
        this.f8077b = new HashMap();
        this.f8078c = new HashMap();
        this.f8079d = new Object();
        this.f8080e = new AtomicBoolean(false);
        this.f8081f = new HashMap();
        this.f8082g = 1;
        this.f8083h = new m3.g();
        this.f8084i = new WeakHashMap<>();
        this.f8076a = flutterJNI;
        this.f8085j = iVar;
    }

    private void j(final String str, final f fVar, final ByteBuffer byteBuffer, final int i6, final long j6) {
        d dVar = fVar != null ? fVar.f8092b : null;
        d4.f.b("PlatformChannel ScheduleHandler on " + str, i6);
        Runnable runnable = new Runnable() { // from class: m3.b
            @Override // java.lang.Runnable
            public final void run() {
                c.this.m(str, i6, fVar, byteBuffer, j6);
            }
        };
        if (dVar == null) {
            dVar = this.f8083h;
        }
        dVar.a(runnable);
    }

    private static void k(Error error) {
        Thread currentThread = Thread.currentThread();
        if (currentThread.getUncaughtExceptionHandler() == null) {
            throw error;
        }
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, error);
    }

    private void l(f fVar, ByteBuffer byteBuffer, int i6) {
        if (fVar != null) {
            try {
                k3.b.f("DartMessenger", "Deferring to registered handler to process message.");
                fVar.f8091a.a(byteBuffer, new g(this.f8076a, i6));
                return;
            } catch (Error e6) {
                k(e6);
                return;
            } catch (Exception e7) {
                k3.b.c("DartMessenger", "Uncaught exception in binary message listener", e7);
            }
        } else {
            k3.b.f("DartMessenger", "No registered handler for message. Responding to Dart with empty reply message.");
        }
        this.f8076a.invokePlatformMessageEmptyResponseCallback(i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(String str, int i6, f fVar, ByteBuffer byteBuffer, long j6) {
        d4.f.e("PlatformChannel ScheduleHandler on " + str, i6);
        d4.f.a("DartMessenger#handleMessageFromDart on " + str);
        try {
            l(fVar, byteBuffer, i6);
            if (byteBuffer != null && byteBuffer.isDirect()) {
                byteBuffer.limit(0);
            }
        } finally {
            this.f8076a.cleanupMessageData(j6);
            d4.f.d();
        }
    }

    @Override // y3.c
    public c.InterfaceC0170c a(c.d dVar) {
        d a6 = this.f8085j.a(dVar);
        j jVar = new j();
        this.f8084i.put(jVar, a6);
        return jVar;
    }

    @Override // y3.c
    public void b(String str, c.a aVar) {
        c(str, aVar, null);
    }

    @Override // y3.c
    public void c(String str, c.a aVar, c.InterfaceC0170c interfaceC0170c) {
        d dVar;
        if (aVar == null) {
            k3.b.f("DartMessenger", "Removing handler for channel '" + str + "'");
            synchronized (this.f8079d) {
                this.f8077b.remove(str);
            }
            return;
        }
        if (interfaceC0170c != null) {
            dVar = this.f8084i.get(interfaceC0170c);
            if (dVar == null) {
                throw new IllegalArgumentException("Unrecognized TaskQueue, use BinaryMessenger to create your TaskQueue (ex makeBackgroundTaskQueue).");
            }
        } else {
            dVar = null;
        }
        k3.b.f("DartMessenger", "Setting handler for channel '" + str + "'");
        synchronized (this.f8079d) {
            this.f8077b.put(str, new f(aVar, dVar));
            List<b> remove = this.f8078c.remove(str);
            if (remove == null) {
                return;
            }
            for (b bVar : remove) {
                j(str, this.f8077b.get(str), bVar.f8086a, bVar.f8087b, bVar.f8088c);
            }
        }
    }

    @Override // y3.c
    public /* synthetic */ c.InterfaceC0170c d() {
        return y3.b.a(this);
    }

    @Override // y3.c
    public void e(String str, ByteBuffer byteBuffer, c.b bVar) {
        d4.f.a("DartMessenger#send on " + str);
        try {
            k3.b.f("DartMessenger", "Sending message with callback over channel '" + str + "'");
            int i6 = this.f8082g;
            this.f8082g = i6 + 1;
            if (bVar != null) {
                this.f8081f.put(Integer.valueOf(i6), bVar);
            }
            if (byteBuffer == null) {
                this.f8076a.dispatchEmptyPlatformMessage(str, i6);
            } else {
                this.f8076a.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i6);
            }
        } finally {
            d4.f.d();
        }
    }

    @Override // y3.c
    public void f(String str, ByteBuffer byteBuffer) {
        k3.b.f("DartMessenger", "Sending message over channel '" + str + "'");
        e(str, byteBuffer, null);
    }

    @Override // m3.f
    public void g(int i6, ByteBuffer byteBuffer) {
        k3.b.f("DartMessenger", "Received message reply from Dart.");
        c.b remove = this.f8081f.remove(Integer.valueOf(i6));
        if (remove != null) {
            try {
                k3.b.f("DartMessenger", "Invoking registered callback for reply from Dart.");
                remove.a(byteBuffer);
                if (byteBuffer == null || !byteBuffer.isDirect()) {
                    return;
                }
                byteBuffer.limit(0);
            } catch (Error e6) {
                k(e6);
            } catch (Exception e7) {
                k3.b.c("DartMessenger", "Uncaught exception in binary message reply handler", e7);
            }
        }
    }

    @Override // m3.f
    public void h(String str, ByteBuffer byteBuffer, int i6, long j6) {
        f fVar;
        boolean z5;
        k3.b.f("DartMessenger", "Received message from Dart over channel '" + str + "'");
        synchronized (this.f8079d) {
            fVar = this.f8077b.get(str);
            z5 = this.f8080e.get() && fVar == null;
            if (z5) {
                if (!this.f8078c.containsKey(str)) {
                    this.f8078c.put(str, new LinkedList());
                }
                this.f8078c.get(str).add(new b(byteBuffer, i6, j6));
            }
        }
        if (z5) {
            return;
        }
        j(str, fVar, byteBuffer, i6, j6);
    }
}

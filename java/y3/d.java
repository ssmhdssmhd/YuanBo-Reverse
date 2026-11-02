package y3;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import y3.c;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final y3.c f11087a;

    /* renamed from: b, reason: collision with root package name */
    private final String f11088b;

    /* renamed from: c, reason: collision with root package name */
    private final l f11089c;

    /* renamed from: d, reason: collision with root package name */
    private final c.InterfaceC0170c f11090d;

    public interface b {
        void a(String str, String str2, Object obj);

        void b(Object obj);

        void c();
    }

    private final class c implements c.a {

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC0171d f11091a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicReference<b> f11092b = new AtomicReference<>(null);

        private final class a implements b {

            /* renamed from: a, reason: collision with root package name */
            final AtomicBoolean f11094a;

            private a() {
                this.f11094a = new AtomicBoolean(false);
            }

            @Override // y3.d.b
            public void a(String str, String str2, Object obj) {
                if (this.f11094a.get() || c.this.f11092b.get() != this) {
                    return;
                }
                d.this.f11087a.f(d.this.f11088b, d.this.f11089c.c(str, str2, obj));
            }

            @Override // y3.d.b
            public void b(Object obj) {
                if (this.f11094a.get() || c.this.f11092b.get() != this) {
                    return;
                }
                d.this.f11087a.f(d.this.f11088b, d.this.f11089c.a(obj));
            }

            @Override // y3.d.b
            public void c() {
                if (this.f11094a.getAndSet(true) || c.this.f11092b.get() != this) {
                    return;
                }
                d.this.f11087a.f(d.this.f11088b, null);
            }
        }

        c(InterfaceC0171d interfaceC0171d) {
            this.f11091a = interfaceC0171d;
        }

        private void c(Object obj, c.b bVar) {
            ByteBuffer c6;
            if (this.f11092b.getAndSet(null) != null) {
                try {
                    this.f11091a.a(obj);
                    bVar.a(d.this.f11089c.a(null));
                    return;
                } catch (RuntimeException e6) {
                    k3.b.c("EventChannel#" + d.this.f11088b, "Failed to close event stream", e6);
                    c6 = d.this.f11089c.c("error", e6.getMessage(), null);
                }
            } else {
                c6 = d.this.f11089c.c("error", "No active stream to cancel", null);
            }
            bVar.a(c6);
        }

        private void d(Object obj, c.b bVar) {
            a aVar = new a();
            if (this.f11092b.getAndSet(aVar) != null) {
                try {
                    this.f11091a.a(null);
                } catch (RuntimeException e6) {
                    k3.b.c("EventChannel#" + d.this.f11088b, "Failed to close existing event stream", e6);
                }
            }
            try {
                this.f11091a.b(obj, aVar);
                bVar.a(d.this.f11089c.a(null));
            } catch (RuntimeException e7) {
                this.f11092b.set(null);
                k3.b.c("EventChannel#" + d.this.f11088b, "Failed to open event stream", e7);
                bVar.a(d.this.f11089c.c("error", e7.getMessage(), null));
            }
        }

        @Override // y3.c.a
        public void a(ByteBuffer byteBuffer, c.b bVar) {
            j e6 = d.this.f11089c.e(byteBuffer);
            if (e6.f11100a.equals("listen")) {
                d(e6.f11101b, bVar);
            } else if (e6.f11100a.equals("cancel")) {
                c(e6.f11101b, bVar);
            } else {
                bVar.a(null);
            }
        }
    }

    /* renamed from: y3.d$d, reason: collision with other inner class name */
    public interface InterfaceC0171d {
        void a(Object obj);

        void b(Object obj, b bVar);
    }

    public d(y3.c cVar, String str) {
        this(cVar, str, r.f11115b);
    }

    public d(y3.c cVar, String str, l lVar) {
        this(cVar, str, lVar, null);
    }

    public d(y3.c cVar, String str, l lVar, c.InterfaceC0170c interfaceC0170c) {
        this.f11087a = cVar;
        this.f11088b = str;
        this.f11089c = lVar;
        this.f11090d = interfaceC0170c;
    }

    public void d(InterfaceC0171d interfaceC0171d) {
        if (this.f11090d != null) {
            this.f11087a.c(this.f11088b, interfaceC0171d != null ? new c(interfaceC0171d) : null, this.f11090d);
        } else {
            this.f11087a.b(this.f11088b, interfaceC0171d != null ? new c(interfaceC0171d) : null);
        }
    }
}

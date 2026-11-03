package z2;

import java.util.ArrayList;
import java.util.Iterator;
import y3.d;

/* loaded from: classes.dex */
public final class t implements d.b {

    /* renamed from: a, reason: collision with root package name */
    private d.b f11330a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<Object> f11331b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private boolean f11332c;

    private static final class a {
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private String f11333a;

        /* renamed from: b, reason: collision with root package name */
        private String f11334b;

        /* renamed from: c, reason: collision with root package name */
        private Object f11335c;

        public b(String code, String message, Object details) {
            kotlin.jvm.internal.k.e(code, "code");
            kotlin.jvm.internal.k.e(message, "message");
            kotlin.jvm.internal.k.e(details, "details");
            this.f11333a = code;
            this.f11334b = message;
            this.f11335c = details;
        }

        public final String a() {
            return this.f11333a;
        }

        public final Object b() {
            return this.f11335c;
        }

        public final String c() {
            return this.f11334b;
        }
    }

    private final void d(Object obj) {
        if (this.f11332c) {
            return;
        }
        this.f11331b.add(obj);
    }

    private final void e() {
        if (this.f11330a == null) {
            return;
        }
        Iterator<Object> it = this.f11331b.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof a) {
                d.b bVar = this.f11330a;
                kotlin.jvm.internal.k.b(bVar);
                bVar.c();
            } else if (next instanceof b) {
                d.b bVar2 = this.f11330a;
                kotlin.jvm.internal.k.b(bVar2);
                b bVar3 = (b) next;
                bVar2.a(bVar3.a(), bVar3.c(), bVar3.b());
            } else {
                d.b bVar4 = this.f11330a;
                kotlin.jvm.internal.k.b(bVar4);
                bVar4.b(next);
            }
        }
        this.f11331b.clear();
    }

    @Override // y3.d.b
    public void a(String code, String message, Object details) {
        kotlin.jvm.internal.k.e(code, "code");
        kotlin.jvm.internal.k.e(message, "message");
        kotlin.jvm.internal.k.e(details, "details");
        d(new b(code, message, details));
        e();
    }

    @Override // y3.d.b
    public void b(Object event) {
        kotlin.jvm.internal.k.e(event, "event");
        d(event);
        e();
    }

    @Override // y3.d.b
    public void c() {
        d(new a());
        e();
        this.f11332c = true;
    }

    public final void f(d.b bVar) {
        this.f11330a = bVar;
        e();
    }
}

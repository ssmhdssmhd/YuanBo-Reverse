package e0;

import androidx.work.impl.WorkDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;
import v.m;
import v.s;

/* loaded from: classes.dex */
public abstract class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final w.c f3308a = new w.c();

    /* renamed from: e0.a$a, reason: collision with other inner class name */
    class C0065a extends a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ w.j f3309b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ UUID f3310c;

        C0065a(w.j jVar, UUID uuid) {
            this.f3309b = jVar;
            this.f3310c = uuid;
        }

        @Override // e0.a
        void h() {
            WorkDatabase p6 = this.f3309b.p();
            p6.c();
            try {
                a(this.f3309b, this.f3310c.toString());
                p6.t();
                p6.g();
                g(this.f3309b);
            } catch (Throwable th) {
                p6.g();
                throw th;
            }
        }
    }

    class b extends a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ w.j f3311b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f3312c;

        b(w.j jVar, String str) {
            this.f3311b = jVar;
            this.f3312c = str;
        }

        @Override // e0.a
        void h() {
            WorkDatabase p6 = this.f3311b.p();
            p6.c();
            try {
                Iterator<String> it = p6.D().o(this.f3312c).iterator();
                while (it.hasNext()) {
                    a(this.f3311b, it.next());
                }
                p6.t();
                p6.g();
                g(this.f3311b);
            } catch (Throwable th) {
                p6.g();
                throw th;
            }
        }
    }

    class c extends a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ w.j f3313b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f3314c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f3315d;

        c(w.j jVar, String str, boolean z5) {
            this.f3313b = jVar;
            this.f3314c = str;
            this.f3315d = z5;
        }

        @Override // e0.a
        void h() {
            WorkDatabase p6 = this.f3313b.p();
            p6.c();
            try {
                Iterator<String> it = p6.D().f(this.f3314c).iterator();
                while (it.hasNext()) {
                    a(this.f3313b, it.next());
                }
                p6.t();
                p6.g();
                if (this.f3315d) {
                    g(this.f3313b);
                }
            } catch (Throwable th) {
                p6.g();
                throw th;
            }
        }
    }

    public static a b(UUID uuid, w.j jVar) {
        return new C0065a(jVar, uuid);
    }

    public static a c(String str, w.j jVar, boolean z5) {
        return new c(jVar, str, z5);
    }

    public static a d(String str, w.j jVar) {
        return new b(jVar, str);
    }

    private void f(WorkDatabase workDatabase, String str) {
        d0.q D = workDatabase.D();
        d0.b v5 = workDatabase.v();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            s.a j6 = D.j(str2);
            if (j6 != s.a.SUCCEEDED && j6 != s.a.FAILED) {
                D.c(s.a.CANCELLED, str2);
            }
            linkedList.addAll(v5.d(str2));
        }
    }

    void a(w.j jVar, String str) {
        f(jVar.p(), str);
        jVar.n().l(str);
        Iterator<w.e> it = jVar.o().iterator();
        while (it.hasNext()) {
            it.next().b(str);
        }
    }

    public v.m e() {
        return this.f3308a;
    }

    void g(w.j jVar) {
        w.f.b(jVar.j(), jVar.p(), jVar.o());
    }

    abstract void h();

    @Override // java.lang.Runnable
    public void run() {
        try {
            h();
            this.f3308a.a(v.m.f9721a);
        } catch (Throwable th) {
            this.f3308a.a(new m.b.a(th));
        }
    }
}

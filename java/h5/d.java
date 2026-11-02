package h5;

import e4.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private boolean f5255a;

    /* renamed from: b, reason: collision with root package name */
    private a f5256b;

    /* renamed from: c, reason: collision with root package name */
    private final List<a> f5257c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5258d;

    /* renamed from: e, reason: collision with root package name */
    private final e f5259e;

    /* renamed from: f, reason: collision with root package name */
    private final String f5260f;

    public d(e taskRunner, String name) {
        k.e(taskRunner, "taskRunner");
        k.e(name, "name");
        this.f5259e = taskRunner;
        this.f5260f = name;
        this.f5257c = new ArrayList();
    }

    public static /* synthetic */ void j(d dVar, a aVar, long j6, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            j6 = 0;
        }
        dVar.i(aVar, j6);
    }

    public final void a() {
        if (!e5.b.f3718h || !Thread.holdsLock(this)) {
            synchronized (this.f5259e) {
                if (b()) {
                    this.f5259e.h(this);
                }
                q qVar = q.f3710a;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread currentThread = Thread.currentThread();
        k.d(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        sb.append(" MUST NOT hold lock on ");
        sb.append(this);
        throw new AssertionError(sb.toString());
    }

    public final boolean b() {
        a aVar = this.f5256b;
        if (aVar != null) {
            k.b(aVar);
            if (aVar.a()) {
                this.f5258d = true;
            }
        }
        boolean z5 = false;
        for (int size = this.f5257c.size() - 1; size >= 0; size--) {
            if (this.f5257c.get(size).a()) {
                a aVar2 = this.f5257c.get(size);
                if (e.f5263j.a().isLoggable(Level.FINE)) {
                    b.c(aVar2, this, "canceled");
                }
                this.f5257c.remove(size);
                z5 = true;
            }
        }
        return z5;
    }

    public final a c() {
        return this.f5256b;
    }

    public final boolean d() {
        return this.f5258d;
    }

    public final List<a> e() {
        return this.f5257c;
    }

    public final String f() {
        return this.f5260f;
    }

    public final boolean g() {
        return this.f5255a;
    }

    public final e h() {
        return this.f5259e;
    }

    public final void i(a task, long j6) {
        k.e(task, "task");
        synchronized (this.f5259e) {
            if (!this.f5255a) {
                if (k(task, j6, false)) {
                    this.f5259e.h(this);
                }
                q qVar = q.f3710a;
            } else if (task.a()) {
                if (e.f5263j.a().isLoggable(Level.FINE)) {
                    b.c(task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (e.f5263j.a().isLoggable(Level.FINE)) {
                    b.c(task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public final boolean k(a task, long j6, boolean z5) {
        StringBuilder sb;
        String str;
        k.e(task, "task");
        task.e(this);
        long c6 = this.f5259e.g().c();
        long j7 = c6 + j6;
        int indexOf = this.f5257c.indexOf(task);
        if (indexOf != -1) {
            if (task.c() <= j7) {
                if (e.f5263j.a().isLoggable(Level.FINE)) {
                    b.c(task, this, "already scheduled");
                }
                return false;
            }
            this.f5257c.remove(indexOf);
        }
        task.g(j7);
        if (e.f5263j.a().isLoggable(Level.FINE)) {
            if (z5) {
                sb = new StringBuilder();
                str = "run again after ";
            } else {
                sb = new StringBuilder();
                str = "scheduled after ";
            }
            sb.append(str);
            sb.append(b.b(j7 - c6));
            b.c(task, this, sb.toString());
        }
        Iterator<a> it = this.f5257c.iterator();
        int i6 = 0;
        while (true) {
            if (!it.hasNext()) {
                i6 = -1;
                break;
            }
            if (it.next().c() - c6 > j6) {
                break;
            }
            i6++;
        }
        if (i6 == -1) {
            i6 = this.f5257c.size();
        }
        this.f5257c.add(i6, task);
        return i6 == 0;
    }

    public final void l(a aVar) {
        this.f5256b = aVar;
    }

    public final void m(boolean z5) {
        this.f5258d = z5;
    }

    public final void n() {
        if (!e5.b.f3718h || !Thread.holdsLock(this)) {
            synchronized (this.f5259e) {
                this.f5255a = true;
                if (b()) {
                    this.f5259e.h(this);
                }
                q qVar = q.f3710a;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread currentThread = Thread.currentThread();
        k.d(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        sb.append(" MUST NOT hold lock on ");
        sb.append(this);
        throw new AssertionError(sb.toString());
    }

    public String toString() {
        return this.f5260f;
    }
}

package androidx.activity;

import androidx.lifecycle.d;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f301a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayDeque<b> f302b = new ArrayDeque<>();

    private class LifecycleOnBackPressedCancellable implements g, androidx.activity.a {

        /* renamed from: a, reason: collision with root package name */
        private final d f303a;

        /* renamed from: b, reason: collision with root package name */
        private final b f304b;

        /* renamed from: c, reason: collision with root package name */
        private androidx.activity.a f305c;

        LifecycleOnBackPressedCancellable(d dVar, b bVar) {
            this.f303a = dVar;
            this.f304b = bVar;
            dVar.a(this);
        }

        @Override // androidx.activity.a
        public void cancel() {
            this.f303a.c(this);
            this.f304b.e(this);
            androidx.activity.a aVar = this.f305c;
            if (aVar != null) {
                aVar.cancel();
                this.f305c = null;
            }
        }

        @Override // androidx.lifecycle.g
        public void d(i iVar, d.b bVar) {
            if (bVar == d.b.ON_START) {
                this.f305c = OnBackPressedDispatcher.this.b(this.f304b);
                return;
            }
            if (bVar != d.b.ON_STOP) {
                if (bVar == d.b.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.a aVar = this.f305c;
                if (aVar != null) {
                    aVar.cancel();
                }
            }
        }
    }

    private class a implements androidx.activity.a {

        /* renamed from: a, reason: collision with root package name */
        private final b f307a;

        a(b bVar) {
            this.f307a = bVar;
        }

        @Override // androidx.activity.a
        public void cancel() {
            OnBackPressedDispatcher.this.f302b.remove(this.f307a);
            this.f307a.e(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f301a = runnable;
    }

    public void a(i iVar, b bVar) {
        d a6 = iVar.a();
        if (a6.b() == d.c.DESTROYED) {
            return;
        }
        bVar.a(new LifecycleOnBackPressedCancellable(a6, bVar));
    }

    androidx.activity.a b(b bVar) {
        this.f302b.add(bVar);
        a aVar = new a(bVar);
        bVar.a(aVar);
        return aVar;
    }

    public void c() {
        Iterator<b> descendingIterator = this.f302b.descendingIterator();
        while (descendingIterator.hasNext()) {
            b next = descendingIterator.next();
            if (next.c()) {
                next.b();
                return;
            }
        }
        Runnable runnable = this.f301a;
        if (runnable != null) {
            runnable.run();
        }
    }
}

package androidx.lifecycle;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class n<T> extends p<T> {

    /* renamed from: k, reason: collision with root package name */
    private d.b<LiveData<?>, a<?>> f889k = new d.b<>();

    private static class a<V> implements q<V> {

        /* renamed from: a, reason: collision with root package name */
        final LiveData<V> f890a;

        /* renamed from: b, reason: collision with root package name */
        final q<? super V> f891b;

        /* renamed from: c, reason: collision with root package name */
        int f892c = -1;

        a(LiveData<V> liveData, q<? super V> qVar) {
            this.f890a = liveData;
            this.f891b = qVar;
        }

        @Override // androidx.lifecycle.q
        public void a(V v5) {
            if (this.f892c != this.f890a.d()) {
                this.f892c = this.f890a.d();
                this.f891b.a(v5);
            }
        }

        void b() {
            this.f890a.f(this);
        }

        void c() {
            this.f890a.j(this);
        }
    }

    @Override // androidx.lifecycle.LiveData
    protected void g() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.f889k.iterator();
        while (it.hasNext()) {
            it.next().getValue().b();
        }
    }

    @Override // androidx.lifecycle.LiveData
    protected void h() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.f889k.iterator();
        while (it.hasNext()) {
            it.next().getValue().c();
        }
    }

    public <S> void l(LiveData<S> liveData, q<? super S> qVar) {
        a<?> aVar = new a<>(liveData, qVar);
        a<?> g6 = this.f889k.g(liveData, aVar);
        if (g6 != null && g6.f891b != qVar) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (g6 == null && e()) {
            aVar.b();
        }
    }
}

package y4;

import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.o;
import w4.k0;

/* loaded from: classes.dex */
public final class j<E> extends s implements q<E> {

    /* renamed from: d, reason: collision with root package name */
    public final Throwable f11153d;

    @Override // y4.s
    public b0 A(o.b bVar) {
        return w4.m.f10322a;
    }

    @Override // y4.q
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public j<E> e() {
        return this;
    }

    @Override // y4.s
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public j<E> z() {
        return this;
    }

    public final Throwable E() {
        Throwable th = this.f11153d;
        return th == null ? new k("Channel was closed") : th;
    }

    public final Throwable F() {
        Throwable th = this.f11153d;
        return th == null ? new l("Channel was closed") : th;
    }

    @Override // y4.q
    public void c(E e6) {
    }

    @Override // y4.q
    public b0 g(E e6, o.b bVar) {
        return w4.m.f10322a;
    }

    @Override // kotlinx.coroutines.internal.o
    public String toString() {
        return "Closed@" + k0.b(this) + '[' + this.f11153d + ']';
    }

    @Override // y4.s
    public void y() {
    }
}

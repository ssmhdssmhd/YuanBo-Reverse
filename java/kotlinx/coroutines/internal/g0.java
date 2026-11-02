package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlinx.coroutines.internal.h0;

/* loaded from: classes.dex */
public class g0<T extends h0 & Comparable<? super T>> {
    private volatile /* synthetic */ int _size = 0;

    /* renamed from: a, reason: collision with root package name */
    private T[] f7043a;

    private final T[] f() {
        T[] tArr = this.f7043a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new h0[4];
            this.f7043a = tArr2;
            return tArr2;
        }
        if (c() < tArr.length) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, c() * 2);
        kotlin.jvm.internal.k.d(copyOf, "copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((h0[]) copyOf);
        this.f7043a = tArr3;
        return tArr3;
    }

    private final void j(int i6) {
        this._size = i6;
    }

    private final void k(int i6) {
        while (true) {
            int i7 = (i6 * 2) + 1;
            if (i7 >= c()) {
                return;
            }
            T[] tArr = this.f7043a;
            kotlin.jvm.internal.k.b(tArr);
            int i8 = i7 + 1;
            if (i8 < c()) {
                T t5 = tArr[i8];
                kotlin.jvm.internal.k.b(t5);
                T t6 = tArr[i7];
                kotlin.jvm.internal.k.b(t6);
                if (((Comparable) t5).compareTo(t6) < 0) {
                    i7 = i8;
                }
            }
            T t7 = tArr[i6];
            kotlin.jvm.internal.k.b(t7);
            T t8 = tArr[i7];
            kotlin.jvm.internal.k.b(t8);
            if (((Comparable) t7).compareTo(t8) <= 0) {
                return;
            }
            m(i6, i7);
            i6 = i7;
        }
    }

    private final void l(int i6) {
        while (i6 > 0) {
            T[] tArr = this.f7043a;
            kotlin.jvm.internal.k.b(tArr);
            int i7 = (i6 - 1) / 2;
            T t5 = tArr[i7];
            kotlin.jvm.internal.k.b(t5);
            T t6 = tArr[i6];
            kotlin.jvm.internal.k.b(t6);
            if (((Comparable) t5).compareTo(t6) <= 0) {
                return;
            }
            m(i6, i7);
            i6 = i7;
        }
    }

    private final void m(int i6, int i7) {
        T[] tArr = this.f7043a;
        kotlin.jvm.internal.k.b(tArr);
        T t5 = tArr[i7];
        kotlin.jvm.internal.k.b(t5);
        T t6 = tArr[i6];
        kotlin.jvm.internal.k.b(t6);
        tArr[i6] = t5;
        tArr[i7] = t6;
        t5.setIndex(i6);
        t6.setIndex(i7);
    }

    public final void a(T t5) {
        t5.a(this);
        T[] f6 = f();
        int c6 = c();
        j(c6 + 1);
        f6[c6] = t5;
        t5.setIndex(c6);
        l(c6);
    }

    public final T b() {
        T[] tArr = this.f7043a;
        if (tArr == null) {
            return null;
        }
        return tArr[0];
    }

    public final int c() {
        return this._size;
    }

    public final boolean d() {
        return c() == 0;
    }

    public final T e() {
        T b6;
        synchronized (this) {
            b6 = b();
        }
        return b6;
    }

    public final boolean g(T t5) {
        boolean z5;
        synchronized (this) {
            if (t5.c() == null) {
                z5 = false;
            } else {
                h(t5.getIndex());
                z5 = true;
            }
        }
        return z5;
    }

    public final T h(int i6) {
        T[] tArr = this.f7043a;
        kotlin.jvm.internal.k.b(tArr);
        j(c() - 1);
        if (i6 < c()) {
            m(i6, c());
            int i7 = (i6 - 1) / 2;
            if (i6 > 0) {
                T t5 = tArr[i6];
                kotlin.jvm.internal.k.b(t5);
                T t6 = tArr[i7];
                kotlin.jvm.internal.k.b(t6);
                if (((Comparable) t5).compareTo(t6) < 0) {
                    m(i6, i7);
                    l(i7);
                }
            }
            k(i6);
        }
        T t7 = tArr[c()];
        kotlin.jvm.internal.k.b(t7);
        t7.a(null);
        t7.setIndex(-1);
        tArr[c()] = null;
        return t7;
    }

    public final T i() {
        T h6;
        synchronized (this) {
            h6 = c() > 0 ? h(0) : null;
        }
        return h6;
    }
}

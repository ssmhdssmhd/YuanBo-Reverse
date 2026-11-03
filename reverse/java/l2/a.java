package l2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
abstract class a<T> implements Iterator<T> {

    /* renamed from: a, reason: collision with root package name */
    private b f7476a = b.NOT_READY;

    /* renamed from: b, reason: collision with root package name */
    @CheckForNull
    private T f7477b;

    /* renamed from: l2.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0107a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7478a;

        static {
            int[] iArr = new int[b.values().length];
            f7478a = iArr;
            try {
                iArr[b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7478a[b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private enum b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected a() {
    }

    private boolean c() {
        this.f7476a = b.FAILED;
        this.f7477b = a();
        if (this.f7476a == b.DONE) {
            return false;
        }
        this.f7476a = b.READY;
        return true;
    }

    @CheckForNull
    protected abstract T a();

    @CheckForNull
    protected final T b() {
        this.f7476a = b.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        k.n(this.f7476a != b.FAILED);
        int i6 = C0107a.f7478a[this.f7476a.ordinal()];
        if (i6 == 1) {
            return false;
        }
        if (i6 != 2) {
            return c();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f7476a = b.NOT_READY;
        T t5 = (T) i.a(this.f7477b);
        this.f7477b = null;
        return t5;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

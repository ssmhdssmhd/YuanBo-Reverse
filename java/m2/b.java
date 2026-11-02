package m2;

import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public abstract class b<T> extends s0<T> {

    /* renamed from: a, reason: collision with root package name */
    private EnumC0115b f7934a = EnumC0115b.NOT_READY;

    /* renamed from: b, reason: collision with root package name */
    @CheckForNull
    private T f7935b;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7936a;

        static {
            int[] iArr = new int[EnumC0115b.values().length];
            f7936a = iArr;
            try {
                iArr[EnumC0115b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7936a[EnumC0115b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: m2.b$b, reason: collision with other inner class name */
    private enum EnumC0115b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected b() {
    }

    private boolean c() {
        this.f7934a = EnumC0115b.FAILED;
        this.f7935b = a();
        if (this.f7934a == EnumC0115b.DONE) {
            return false;
        }
        this.f7934a = EnumC0115b.READY;
        return true;
    }

    @CheckForNull
    protected abstract T a();

    @CheckForNull
    protected final T b() {
        this.f7934a = EnumC0115b.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        l2.k.n(this.f7934a != EnumC0115b.FAILED);
        int i6 = a.f7936a[this.f7934a.ordinal()];
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
        this.f7934a = EnumC0115b.NOT_READY;
        T t5 = (T) f0.a(this.f7935b);
        this.f7935b = null;
        return t5;
    }
}

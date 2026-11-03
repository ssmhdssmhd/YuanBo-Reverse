package kotlinx.coroutines.internal;

/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    private Object[] f7017a = new Object[16];

    /* renamed from: b, reason: collision with root package name */
    private int f7018b;

    /* renamed from: c, reason: collision with root package name */
    private int f7019c;

    private final void b() {
        Object[] objArr = this.f7017a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        f4.g.f(objArr, objArr2, 0, this.f7018b, 0, 10, null);
        Object[] objArr3 = this.f7017a;
        int length2 = objArr3.length;
        int i6 = this.f7018b;
        f4.g.f(objArr3, objArr2, length2 - i6, 0, i6, 4, null);
        this.f7017a = objArr2;
        this.f7018b = 0;
        this.f7019c = length;
    }

    public final void a(T t5) {
        Object[] objArr = this.f7017a;
        int i6 = this.f7019c;
        objArr[i6] = t5;
        int length = (objArr.length - 1) & (i6 + 1);
        this.f7019c = length;
        if (length == this.f7018b) {
            b();
        }
    }

    public final boolean c() {
        return this.f7018b == this.f7019c;
    }

    public final T d() {
        int i6 = this.f7018b;
        if (i6 == this.f7019c) {
            return null;
        }
        Object[] objArr = this.f7017a;
        T t5 = (T) objArr[i6];
        objArr[i6] = null;
        this.f7018b = (i6 + 1) & (objArr.length - 1);
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
    }
}

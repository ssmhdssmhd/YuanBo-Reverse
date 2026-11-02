package f;

/* loaded from: classes.dex */
public class d<E> implements Cloneable {

    /* renamed from: e, reason: collision with root package name */
    private static final Object f3739e = new Object();

    /* renamed from: a, reason: collision with root package name */
    private boolean f3740a;

    /* renamed from: b, reason: collision with root package name */
    private long[] f3741b;

    /* renamed from: c, reason: collision with root package name */
    private Object[] f3742c;

    /* renamed from: d, reason: collision with root package name */
    private int f3743d;

    public d() {
        this(10);
    }

    public d(int i6) {
        this.f3740a = false;
        if (i6 == 0) {
            this.f3741b = c.f3737b;
            this.f3742c = c.f3738c;
        } else {
            int f6 = c.f(i6);
            this.f3741b = new long[f6];
            this.f3742c = new Object[f6];
        }
    }

    private void b() {
        int i6 = this.f3743d;
        long[] jArr = this.f3741b;
        Object[] objArr = this.f3742c;
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            Object obj = objArr[i8];
            if (obj != f3739e) {
                if (i8 != i7) {
                    jArr[i7] = jArr[i8];
                    objArr[i7] = obj;
                    objArr[i8] = null;
                }
                i7++;
            }
        }
        this.f3740a = false;
        this.f3743d = i7;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.f3741b = (long[]) this.f3741b.clone();
            dVar.f3742c = (Object[]) this.f3742c.clone();
            return dVar;
        } catch (CloneNotSupportedException e6) {
            throw new AssertionError(e6);
        }
    }

    public long c(int i6) {
        if (this.f3740a) {
            b();
        }
        return this.f3741b[i6];
    }

    public void d(long j6, E e6) {
        int b6 = c.b(this.f3741b, this.f3743d, j6);
        if (b6 >= 0) {
            this.f3742c[b6] = e6;
            return;
        }
        int i6 = ~b6;
        int i7 = this.f3743d;
        if (i6 < i7) {
            Object[] objArr = this.f3742c;
            if (objArr[i6] == f3739e) {
                this.f3741b[i6] = j6;
                objArr[i6] = e6;
                return;
            }
        }
        if (this.f3740a && i7 >= this.f3741b.length) {
            b();
            i6 = ~c.b(this.f3741b, this.f3743d, j6);
        }
        int i8 = this.f3743d;
        if (i8 >= this.f3741b.length) {
            int f6 = c.f(i8 + 1);
            long[] jArr = new long[f6];
            Object[] objArr2 = new Object[f6];
            long[] jArr2 = this.f3741b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f3742c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f3741b = jArr;
            this.f3742c = objArr2;
        }
        int i9 = this.f3743d;
        if (i9 - i6 != 0) {
            long[] jArr3 = this.f3741b;
            int i10 = i6 + 1;
            System.arraycopy(jArr3, i6, jArr3, i10, i9 - i6);
            Object[] objArr4 = this.f3742c;
            System.arraycopy(objArr4, i6, objArr4, i10, this.f3743d - i6);
        }
        this.f3741b[i6] = j6;
        this.f3742c[i6] = e6;
        this.f3743d++;
    }

    public void e(int i6) {
        Object[] objArr = this.f3742c;
        Object obj = objArr[i6];
        Object obj2 = f3739e;
        if (obj != obj2) {
            objArr[i6] = obj2;
            this.f3740a = true;
        }
    }

    public int f() {
        if (this.f3740a) {
            b();
        }
        return this.f3743d;
    }

    public E g(int i6) {
        if (this.f3740a) {
            b();
        }
        return (E) this.f3742c[i6];
    }

    public String toString() {
        if (f() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f3743d * 28);
        sb.append('{');
        for (int i6 = 0; i6 < this.f3743d; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(c(i6));
            sb.append('=');
            E g6 = g(i6);
            if (g6 != this) {
                sb.append(g6);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}

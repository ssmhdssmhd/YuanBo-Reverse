package f;

/* loaded from: classes.dex */
public class g<E> implements Cloneable {

    /* renamed from: e, reason: collision with root package name */
    private static final Object f3766e = new Object();

    /* renamed from: a, reason: collision with root package name */
    private boolean f3767a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f3768b;

    /* renamed from: c, reason: collision with root package name */
    private Object[] f3769c;

    /* renamed from: d, reason: collision with root package name */
    private int f3770d;

    public g() {
        this(10);
    }

    public g(int i6) {
        this.f3767a = false;
        if (i6 == 0) {
            this.f3768b = c.f3736a;
            this.f3769c = c.f3738c;
        } else {
            int e6 = c.e(i6);
            this.f3768b = new int[e6];
            this.f3769c = new Object[e6];
        }
    }

    private void c() {
        int i6 = this.f3770d;
        int[] iArr = this.f3768b;
        Object[] objArr = this.f3769c;
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            Object obj = objArr[i8];
            if (obj != f3766e) {
                if (i8 != i7) {
                    iArr[i7] = iArr[i8];
                    objArr[i7] = obj;
                    objArr[i8] = null;
                }
                i7++;
            }
        }
        this.f3767a = false;
        this.f3770d = i7;
    }

    public void a() {
        int i6 = this.f3770d;
        Object[] objArr = this.f3769c;
        for (int i7 = 0; i7 < i6; i7++) {
            objArr[i7] = null;
        }
        this.f3770d = 0;
        this.f3767a = false;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g<E> clone() {
        try {
            g<E> gVar = (g) super.clone();
            gVar.f3768b = (int[]) this.f3768b.clone();
            gVar.f3769c = (Object[]) this.f3769c.clone();
            return gVar;
        } catch (CloneNotSupportedException e6) {
            throw new AssertionError(e6);
        }
    }

    public E d(int i6) {
        return e(i6, null);
    }

    public E e(int i6, E e6) {
        E e7;
        int a6 = c.a(this.f3768b, this.f3770d, i6);
        return (a6 < 0 || (e7 = (E) this.f3769c[a6]) == f3766e) ? e6 : e7;
    }

    public int f(int i6) {
        if (this.f3767a) {
            c();
        }
        return this.f3768b[i6];
    }

    public void g(int i6, E e6) {
        int a6 = c.a(this.f3768b, this.f3770d, i6);
        if (a6 >= 0) {
            this.f3769c[a6] = e6;
            return;
        }
        int i7 = ~a6;
        int i8 = this.f3770d;
        if (i7 < i8) {
            Object[] objArr = this.f3769c;
            if (objArr[i7] == f3766e) {
                this.f3768b[i7] = i6;
                objArr[i7] = e6;
                return;
            }
        }
        if (this.f3767a && i8 >= this.f3768b.length) {
            c();
            i7 = ~c.a(this.f3768b, this.f3770d, i6);
        }
        int i9 = this.f3770d;
        if (i9 >= this.f3768b.length) {
            int e7 = c.e(i9 + 1);
            int[] iArr = new int[e7];
            Object[] objArr2 = new Object[e7];
            int[] iArr2 = this.f3768b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f3769c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f3768b = iArr;
            this.f3769c = objArr2;
        }
        int i10 = this.f3770d;
        if (i10 - i7 != 0) {
            int[] iArr3 = this.f3768b;
            int i11 = i7 + 1;
            System.arraycopy(iArr3, i7, iArr3, i11, i10 - i7);
            Object[] objArr4 = this.f3769c;
            System.arraycopy(objArr4, i7, objArr4, i11, this.f3770d - i7);
        }
        this.f3768b[i7] = i6;
        this.f3769c[i7] = e6;
        this.f3770d++;
    }

    public void h(int i6) {
        int a6 = c.a(this.f3768b, this.f3770d, i6);
        if (a6 >= 0) {
            Object[] objArr = this.f3769c;
            Object obj = objArr[a6];
            Object obj2 = f3766e;
            if (obj != obj2) {
                objArr[a6] = obj2;
                this.f3767a = true;
            }
        }
    }

    public int i() {
        if (this.f3767a) {
            c();
        }
        return this.f3770d;
    }

    public E k(int i6) {
        if (this.f3767a) {
            c();
        }
        return (E) this.f3769c[i6];
    }

    public String toString() {
        if (i() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f3770d * 28);
        sb.append('{');
        for (int i6 = 0; i6 < this.f3770d; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(f(i6));
            sb.append('=');
            E k6 = k(i6);
            if (k6 != this) {
                sb.append(k6);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}

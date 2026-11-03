package g2;

import g2.b;
import i2.c1;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class r implements b {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f4118a;

    /* renamed from: b, reason: collision with root package name */
    private final int f4119b;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f4120c;

    /* renamed from: d, reason: collision with root package name */
    private int f4121d;

    /* renamed from: e, reason: collision with root package name */
    private int f4122e;

    /* renamed from: f, reason: collision with root package name */
    private int f4123f;

    /* renamed from: g, reason: collision with root package name */
    private a[] f4124g;

    public r(boolean z5, int i6) {
        this(z5, i6, 0);
    }

    public r(boolean z5, int i6, int i7) {
        i2.a.a(i6 > 0);
        i2.a.a(i7 >= 0);
        this.f4118a = z5;
        this.f4119b = i6;
        this.f4123f = i7;
        this.f4124g = new a[i7 + 100];
        if (i7 <= 0) {
            this.f4120c = null;
            return;
        }
        this.f4120c = new byte[i7 * i6];
        for (int i8 = 0; i8 < i7; i8++) {
            this.f4124g[i8] = new a(this.f4120c, i8 * i6);
        }
    }

    @Override // g2.b
    public synchronized void a(b.a aVar) {
        while (aVar != null) {
            a[] aVarArr = this.f4124g;
            int i6 = this.f4123f;
            this.f4123f = i6 + 1;
            aVarArr[i6] = aVar.a();
            this.f4122e--;
            aVar = aVar.next();
        }
        notifyAll();
    }

    @Override // g2.b
    public synchronized void b() {
        int i6 = 0;
        int max = Math.max(0, c1.l(this.f4121d, this.f4119b) - this.f4122e);
        int i7 = this.f4123f;
        if (max >= i7) {
            return;
        }
        if (this.f4120c != null) {
            int i8 = i7 - 1;
            while (i6 <= i8) {
                a aVar = (a) i2.a.e(this.f4124g[i6]);
                if (aVar.f4002a == this.f4120c) {
                    i6++;
                } else {
                    a aVar2 = (a) i2.a.e(this.f4124g[i8]);
                    if (aVar2.f4002a != this.f4120c) {
                        i8--;
                    } else {
                        a[] aVarArr = this.f4124g;
                        aVarArr[i6] = aVar2;
                        aVarArr[i8] = aVar;
                        i8--;
                        i6++;
                    }
                }
            }
            max = Math.max(max, i6);
            if (max >= this.f4123f) {
                return;
            }
        }
        Arrays.fill(this.f4124g, max, this.f4123f, (Object) null);
        this.f4123f = max;
    }

    @Override // g2.b
    public synchronized void c(a aVar) {
        a[] aVarArr = this.f4124g;
        int i6 = this.f4123f;
        this.f4123f = i6 + 1;
        aVarArr[i6] = aVar;
        this.f4122e--;
        notifyAll();
    }

    @Override // g2.b
    public synchronized a d() {
        a aVar;
        this.f4122e++;
        int i6 = this.f4123f;
        if (i6 > 0) {
            a[] aVarArr = this.f4124g;
            int i7 = i6 - 1;
            this.f4123f = i7;
            aVar = (a) i2.a.e(aVarArr[i7]);
            this.f4124g[this.f4123f] = null;
        } else {
            aVar = new a(new byte[this.f4119b], 0);
            int i8 = this.f4122e;
            a[] aVarArr2 = this.f4124g;
            if (i8 > aVarArr2.length) {
                this.f4124g = (a[]) Arrays.copyOf(aVarArr2, aVarArr2.length * 2);
            }
        }
        return aVar;
    }

    @Override // g2.b
    public int e() {
        return this.f4119b;
    }

    public synchronized int f() {
        return this.f4122e * this.f4119b;
    }

    public synchronized void g() {
        if (this.f4118a) {
            h(0);
        }
    }

    public synchronized void h(int i6) {
        boolean z5 = i6 < this.f4121d;
        this.f4121d = i6;
        if (z5) {
            b();
        }
    }
}

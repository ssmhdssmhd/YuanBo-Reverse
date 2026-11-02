package t2;

import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import q2.p;

/* loaded from: classes.dex */
public final class f extends y2.a {

    /* renamed from: x, reason: collision with root package name */
    private static final Reader f9404x = new a();

    /* renamed from: y, reason: collision with root package name */
    private static final Object f9405y = new Object();

    /* renamed from: t, reason: collision with root package name */
    private Object[] f9406t;

    /* renamed from: u, reason: collision with root package name */
    private int f9407u;

    /* renamed from: v, reason: collision with root package name */
    private String[] f9408v;

    /* renamed from: w, reason: collision with root package name */
    private int[] f9409w;

    class a extends Reader {
        a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i6, int i7) {
            throw new AssertionError();
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9410a;

        static {
            int[] iArr = new int[y2.b.values().length];
            f9410a = iArr;
            try {
                iArr[y2.b.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9410a[y2.b.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9410a[y2.b.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9410a[y2.b.END_DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private String F(boolean z5) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i6 = 0;
        while (true) {
            int i7 = this.f9407u;
            if (i6 >= i7) {
                return sb.toString();
            }
            Object[] objArr = this.f9406t;
            Object obj = objArr[i6];
            if (obj instanceof q2.h) {
                i6++;
                if (i6 < i7 && (objArr[i6] instanceof Iterator)) {
                    int i8 = this.f9409w[i6];
                    if (z5 && i8 > 0 && (i6 == i7 - 1 || i6 == i7 - 2)) {
                        i8--;
                    }
                    sb.append('[');
                    sb.append(i8);
                    sb.append(']');
                }
            } else if ((obj instanceof q2.n) && (i6 = i6 + 1) < i7 && (objArr[i6] instanceof Iterator)) {
                sb.append('.');
                String str = this.f9408v[i6];
                if (str != null) {
                    sb.append(str);
                }
            }
            i6++;
        }
    }

    private String V() {
        return " at path " + z();
    }

    private void s0(y2.b bVar) {
        if (g0() == bVar) {
            return;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + g0() + V());
    }

    private String u0(boolean z5) {
        s0(y2.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) v0()).next();
        String str = (String) entry.getKey();
        this.f9408v[this.f9407u - 1] = z5 ? "<skipped>" : str;
        y0(entry.getValue());
        return str;
    }

    private Object v0() {
        return this.f9406t[this.f9407u - 1];
    }

    private Object w0() {
        Object[] objArr = this.f9406t;
        int i6 = this.f9407u - 1;
        this.f9407u = i6;
        Object obj = objArr[i6];
        objArr[i6] = null;
        return obj;
    }

    private void y0(Object obj) {
        int i6 = this.f9407u;
        Object[] objArr = this.f9406t;
        if (i6 == objArr.length) {
            int i7 = i6 * 2;
            this.f9406t = Arrays.copyOf(objArr, i7);
            this.f9409w = Arrays.copyOf(this.f9409w, i7);
            this.f9408v = (String[]) Arrays.copyOf(this.f9408v, i7);
        }
        Object[] objArr2 = this.f9406t;
        int i8 = this.f9407u;
        this.f9407u = i8 + 1;
        objArr2[i8] = obj;
    }

    @Override // y2.a
    public String I() {
        return F(true);
    }

    @Override // y2.a
    public boolean K() {
        y2.b g02 = g0();
        return (g02 == y2.b.END_OBJECT || g02 == y2.b.END_ARRAY || g02 == y2.b.END_DOCUMENT) ? false : true;
    }

    @Override // y2.a
    public boolean W() {
        s0(y2.b.BOOLEAN);
        boolean j6 = ((p) w0()).j();
        int i6 = this.f9407u;
        if (i6 > 0) {
            int[] iArr = this.f9409w;
            int i7 = i6 - 1;
            iArr[i7] = iArr[i7] + 1;
        }
        return j6;
    }

    @Override // y2.a
    public double X() {
        y2.b g02 = g0();
        y2.b bVar = y2.b.NUMBER;
        if (g02 != bVar && g02 != y2.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + g02 + V());
        }
        double k6 = ((p) v0()).k();
        if (!M() && (Double.isNaN(k6) || Double.isInfinite(k6))) {
            throw new y2.d("JSON forbids NaN and infinities: " + k6);
        }
        w0();
        int i6 = this.f9407u;
        if (i6 > 0) {
            int[] iArr = this.f9409w;
            int i7 = i6 - 1;
            iArr[i7] = iArr[i7] + 1;
        }
        return k6;
    }

    @Override // y2.a
    public int Y() {
        y2.b g02 = g0();
        y2.b bVar = y2.b.NUMBER;
        if (g02 != bVar && g02 != y2.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + g02 + V());
        }
        int l6 = ((p) v0()).l();
        w0();
        int i6 = this.f9407u;
        if (i6 > 0) {
            int[] iArr = this.f9409w;
            int i7 = i6 - 1;
            iArr[i7] = iArr[i7] + 1;
        }
        return l6;
    }

    @Override // y2.a
    public long Z() {
        y2.b g02 = g0();
        y2.b bVar = y2.b.NUMBER;
        if (g02 != bVar && g02 != y2.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + g02 + V());
        }
        long m6 = ((p) v0()).m();
        w0();
        int i6 = this.f9407u;
        if (i6 > 0) {
            int[] iArr = this.f9409w;
            int i7 = i6 - 1;
            iArr[i7] = iArr[i7] + 1;
        }
        return m6;
    }

    @Override // y2.a
    public void a() {
        s0(y2.b.BEGIN_ARRAY);
        y0(((q2.h) v0()).iterator());
        this.f9409w[this.f9407u - 1] = 0;
    }

    @Override // y2.a
    public String a0() {
        return u0(false);
    }

    @Override // y2.a
    public void c0() {
        s0(y2.b.NULL);
        w0();
        int i6 = this.f9407u;
        if (i6 > 0) {
            int[] iArr = this.f9409w;
            int i7 = i6 - 1;
            iArr[i7] = iArr[i7] + 1;
        }
    }

    @Override // y2.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f9406t = new Object[]{f9405y};
        this.f9407u = 1;
    }

    @Override // y2.a
    public String e0() {
        y2.b g02 = g0();
        y2.b bVar = y2.b.STRING;
        if (g02 == bVar || g02 == y2.b.NUMBER) {
            String e6 = ((p) w0()).e();
            int i6 = this.f9407u;
            if (i6 > 0) {
                int[] iArr = this.f9409w;
                int i7 = i6 - 1;
                iArr[i7] = iArr[i7] + 1;
            }
            return e6;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + g02 + V());
    }

    @Override // y2.a
    public y2.b g0() {
        if (this.f9407u == 0) {
            return y2.b.END_DOCUMENT;
        }
        Object v02 = v0();
        if (v02 instanceof Iterator) {
            boolean z5 = this.f9406t[this.f9407u - 2] instanceof q2.n;
            Iterator it = (Iterator) v02;
            if (!it.hasNext()) {
                return z5 ? y2.b.END_OBJECT : y2.b.END_ARRAY;
            }
            if (z5) {
                return y2.b.NAME;
            }
            y0(it.next());
            return g0();
        }
        if (v02 instanceof q2.n) {
            return y2.b.BEGIN_OBJECT;
        }
        if (v02 instanceof q2.h) {
            return y2.b.BEGIN_ARRAY;
        }
        if (v02 instanceof p) {
            p pVar = (p) v02;
            if (pVar.r()) {
                return y2.b.STRING;
            }
            if (pVar.o()) {
                return y2.b.BOOLEAN;
            }
            if (pVar.q()) {
                return y2.b.NUMBER;
            }
            throw new AssertionError();
        }
        if (v02 instanceof q2.m) {
            return y2.b.NULL;
        }
        if (v02 == f9405y) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new y2.d("Custom JsonElement subclass " + v02.getClass().getName() + " is not supported");
    }

    @Override // y2.a
    public void j() {
        s0(y2.b.BEGIN_OBJECT);
        y0(((q2.n) v0()).k().iterator());
    }

    @Override // y2.a
    public void q0() {
        int i6 = b.f9410a[g0().ordinal()];
        if (i6 == 1) {
            u0(true);
            return;
        }
        if (i6 == 2) {
            t();
            return;
        }
        if (i6 == 3) {
            v();
            return;
        }
        if (i6 != 4) {
            w0();
            int i7 = this.f9407u;
            if (i7 > 0) {
                int[] iArr = this.f9409w;
                int i8 = i7 - 1;
                iArr[i8] = iArr[i8] + 1;
            }
        }
    }

    @Override // y2.a
    public void t() {
        s0(y2.b.END_ARRAY);
        w0();
        w0();
        int i6 = this.f9407u;
        if (i6 > 0) {
            int[] iArr = this.f9409w;
            int i7 = i6 - 1;
            iArr[i7] = iArr[i7] + 1;
        }
    }

    q2.k t0() {
        y2.b g02 = g0();
        if (g02 != y2.b.NAME && g02 != y2.b.END_ARRAY && g02 != y2.b.END_OBJECT && g02 != y2.b.END_DOCUMENT) {
            q2.k kVar = (q2.k) v0();
            q0();
            return kVar;
        }
        throw new IllegalStateException("Unexpected " + g02 + " when reading a JsonElement.");
    }

    @Override // y2.a
    public String toString() {
        return f.class.getSimpleName() + V();
    }

    @Override // y2.a
    public void v() {
        s0(y2.b.END_OBJECT);
        this.f9408v[this.f9407u - 1] = null;
        w0();
        w0();
        int i6 = this.f9407u;
        if (i6 > 0) {
            int[] iArr = this.f9409w;
            int i7 = i6 - 1;
            iArr[i7] = iArr[i7] + 1;
        }
    }

    public void x0() {
        s0(y2.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) v0()).next();
        y0(entry.getValue());
        y0(new p((String) entry.getKey()));
    }

    @Override // y2.a
    public String z() {
        return F(false);
    }
}

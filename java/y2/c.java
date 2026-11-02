package y2;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class c implements Closeable, Flushable {

    /* renamed from: n, reason: collision with root package name */
    private static final Pattern f11064n = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* renamed from: o, reason: collision with root package name */
    private static final String[] f11065o = new String[128];

    /* renamed from: p, reason: collision with root package name */
    private static final String[] f11066p;

    /* renamed from: a, reason: collision with root package name */
    private final Writer f11067a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f11068b = new int[32];

    /* renamed from: c, reason: collision with root package name */
    private int f11069c = 0;

    /* renamed from: d, reason: collision with root package name */
    private String f11070d;

    /* renamed from: e, reason: collision with root package name */
    private String f11071e;

    /* renamed from: j, reason: collision with root package name */
    private boolean f11072j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f11073k;

    /* renamed from: l, reason: collision with root package name */
    private String f11074l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f11075m;

    static {
        for (int i6 = 0; i6 <= 31; i6++) {
            f11065o[i6] = String.format("\\u%04x", Integer.valueOf(i6));
        }
        String[] strArr = f11065o;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f11066p = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        Y(6);
        this.f11071e = ":";
        this.f11075m = true;
        Objects.requireNonNull(writer, "out == null");
        this.f11067a = writer;
    }

    private static boolean K(Class<? extends Number> cls) {
        return cls == Integer.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    private void U() {
        if (this.f11070d == null) {
            return;
        }
        this.f11067a.write(10);
        int i6 = this.f11069c;
        for (int i7 = 1; i7 < i6; i7++) {
            this.f11067a.write(this.f11070d);
        }
    }

    private c W(int i6, char c6) {
        j();
        Y(i6);
        this.f11067a.write(c6);
        return this;
    }

    private int X() {
        int i6 = this.f11069c;
        if (i6 != 0) {
            return this.f11068b[i6 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void Y(int i6) {
        int i7 = this.f11069c;
        int[] iArr = this.f11068b;
        if (i7 == iArr.length) {
            this.f11068b = Arrays.copyOf(iArr, i7 * 2);
        }
        int[] iArr2 = this.f11068b;
        int i8 = this.f11069c;
        this.f11069c = i8 + 1;
        iArr2[i8] = i6;
    }

    private void Z(int i6) {
        this.f11068b[this.f11069c - 1] = i6;
    }

    private void a() {
        int X = X();
        if (X == 5) {
            this.f11067a.write(44);
        } else if (X != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        U();
        Z(4);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void e0(java.lang.String r9) {
        /*
            r8 = this;
            boolean r0 = r8.f11073k
            if (r0 == 0) goto L7
            java.lang.String[] r0 = y2.c.f11066p
            goto L9
        L7:
            java.lang.String[] r0 = y2.c.f11065o
        L9:
            java.io.Writer r1 = r8.f11067a
            r2 = 34
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = 0
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.f11067a
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f11067a
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f11067a
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.f11067a
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.c.e0(java.lang.String):void");
    }

    private void j() {
        int X = X();
        if (X == 1) {
            Z(2);
        } else {
            if (X != 2) {
                if (X == 4) {
                    this.f11067a.append((CharSequence) this.f11071e);
                    Z(5);
                    return;
                }
                if (X != 6) {
                    if (X != 7) {
                        throw new IllegalStateException("Nesting problem.");
                    }
                    if (!this.f11072j) {
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                }
                Z(7);
                return;
            }
            this.f11067a.append(',');
        }
        U();
    }

    private void l0() {
        if (this.f11074l != null) {
            a();
            e0(this.f11074l);
            this.f11074l = null;
        }
    }

    private c s(int i6, int i7, char c6) {
        int X = X();
        if (X != i7 && X != i6) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f11074l != null) {
            throw new IllegalStateException("Dangling name: " + this.f11074l);
        }
        this.f11069c--;
        if (X == i7) {
            U();
        }
        this.f11067a.write(c6);
        return this;
    }

    public final boolean D() {
        return this.f11075m;
    }

    public final boolean F() {
        return this.f11073k;
    }

    public boolean I() {
        return this.f11072j;
    }

    public c M(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f11074l != null) {
            throw new IllegalStateException();
        }
        if (this.f11069c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f11074l = str;
        return this;
    }

    public c V() {
        if (this.f11074l != null) {
            if (!this.f11075m) {
                this.f11074l = null;
                return this;
            }
            l0();
        }
        j();
        this.f11067a.write("null");
        return this;
    }

    public final void a0(boolean z5) {
        this.f11073k = z5;
    }

    public final void b0(String str) {
        String str2;
        if (str.length() == 0) {
            this.f11070d = null;
            str2 = ":";
        } else {
            this.f11070d = str;
            str2 = ": ";
        }
        this.f11071e = str2;
    }

    public final void c0(boolean z5) {
        this.f11072j = z5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f11067a.close();
        int i6 = this.f11069c;
        if (i6 > 1 || (i6 == 1 && this.f11068b[i6 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f11069c = 0;
    }

    public final void d0(boolean z5) {
        this.f11075m = z5;
    }

    public c f0(double d6) {
        l0();
        if (this.f11072j || !(Double.isNaN(d6) || Double.isInfinite(d6))) {
            j();
            this.f11067a.append((CharSequence) Double.toString(d6));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d6);
    }

    public void flush() {
        if (this.f11069c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f11067a.flush();
    }

    public c g0(long j6) {
        l0();
        j();
        this.f11067a.write(Long.toString(j6));
        return this;
    }

    public c h0(Boolean bool) {
        if (bool == null) {
            return V();
        }
        l0();
        j();
        this.f11067a.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public c i0(Number number) {
        if (number == null) {
            return V();
        }
        l0();
        String obj = number.toString();
        if (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (!K(cls) && !f11064n.matcher(obj).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + obj);
            }
        } else if (!this.f11072j) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + obj);
        }
        j();
        this.f11067a.append((CharSequence) obj);
        return this;
    }

    public c j0(String str) {
        if (str == null) {
            return V();
        }
        l0();
        j();
        e0(str);
        return this;
    }

    public c k() {
        l0();
        return W(1, '[');
    }

    public c k0(boolean z5) {
        l0();
        j();
        this.f11067a.write(z5 ? "true" : "false");
        return this;
    }

    public c q() {
        l0();
        return W(3, '{');
    }

    public c t() {
        return s(1, 2, ']');
    }

    public c v() {
        return s(3, 5, '}');
    }
}

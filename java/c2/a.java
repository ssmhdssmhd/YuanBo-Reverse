package c2;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import i2.c1;
import i2.i0;
import i2.t;
import java.nio.charset.Charset;
import java.util.List;
import l2.d;
import u1.b;
import u1.g;
import u1.h;
import u1.j;

/* loaded from: classes.dex */
public final class a extends g {

    /* renamed from: o, reason: collision with root package name */
    private final i0 f1817o;

    /* renamed from: p, reason: collision with root package name */
    private final boolean f1818p;

    /* renamed from: q, reason: collision with root package name */
    private final int f1819q;

    /* renamed from: r, reason: collision with root package name */
    private final int f1820r;

    /* renamed from: s, reason: collision with root package name */
    private final String f1821s;

    /* renamed from: t, reason: collision with root package name */
    private final float f1822t;

    /* renamed from: u, reason: collision with root package name */
    private final int f1823u;

    public a(List<byte[]> list) {
        super("Tx3gDecoder");
        this.f1817o = new i0();
        if (list.size() != 1 || (list.get(0).length != 48 && list.get(0).length != 53)) {
            this.f1819q = 0;
            this.f1820r = -1;
            this.f1821s = "sans-serif";
            this.f1818p = false;
            this.f1822t = 0.85f;
            this.f1823u = -1;
            return;
        }
        byte[] bArr = list.get(0);
        this.f1819q = bArr[24];
        this.f1820r = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.f1821s = "Serif".equals(c1.E(bArr, 43, bArr.length - 43)) ? "serif" : "sans-serif";
        int i6 = bArr[25] * 20;
        this.f1823u = i6;
        boolean z5 = (bArr[0] & 32) != 0;
        this.f1818p = z5;
        if (z5) {
            this.f1822t = c1.p(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i6, 0.0f, 0.95f);
        } else {
            this.f1822t = 0.85f;
        }
    }

    private void C(i0 i0Var, SpannableStringBuilder spannableStringBuilder) {
        D(i0Var.a() >= 12);
        int L = i0Var.L();
        int L2 = i0Var.L();
        i0Var.T(2);
        int F = i0Var.F();
        i0Var.T(1);
        int o6 = i0Var.o();
        if (L2 > spannableStringBuilder.length()) {
            t.i("Tx3gDecoder", "Truncating styl end (" + L2 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
            L2 = spannableStringBuilder.length();
        }
        if (L < L2) {
            int i6 = L2;
            F(spannableStringBuilder, F, this.f1819q, L, i6, 0);
            E(spannableStringBuilder, o6, this.f1820r, L, i6, 0);
            return;
        }
        t.i("Tx3gDecoder", "Ignoring styl with start (" + L + ") >= end (" + L2 + ").");
    }

    private static void D(boolean z5) {
        if (!z5) {
            throw new j("Unexpected subtitle format.");
        }
    }

    private static void E(SpannableStringBuilder spannableStringBuilder, int i6, int i7, int i8, int i9, int i10) {
        if (i6 != i7) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i6 >>> 8) | ((i6 & 255) << 24)), i8, i9, i10 | 33);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void F(android.text.SpannableStringBuilder r5, int r6, int r7, int r8, int r9, int r10) {
        /*
            if (r6 == r7) goto L4c
            r7 = r10 | 33
            r10 = r6 & 1
            r0 = 0
            r1 = 1
            if (r10 == 0) goto Lc
            r10 = 1
            goto Ld
        Lc:
            r10 = 0
        Ld:
            r2 = r6 & 2
            if (r2 == 0) goto L13
            r2 = 1
            goto L14
        L13:
            r2 = 0
        L14:
            if (r10 == 0) goto L23
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan
            if (r2 == 0) goto L1f
            r4 = 3
            r3.<init>(r4)
            goto L2b
        L1f:
            r3.<init>(r1)
            goto L2b
        L23:
            if (r2 == 0) goto L2e
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan
            r4 = 2
            r3.<init>(r4)
        L2b:
            r5.setSpan(r3, r8, r9, r7)
        L2e:
            r6 = r6 & 4
            if (r6 == 0) goto L33
            goto L34
        L33:
            r1 = 0
        L34:
            if (r1 == 0) goto L3e
            android.text.style.UnderlineSpan r6 = new android.text.style.UnderlineSpan
            r6.<init>()
            r5.setSpan(r6, r8, r9, r7)
        L3e:
            if (r1 != 0) goto L4c
            if (r10 != 0) goto L4c
            if (r2 != 0) goto L4c
            android.text.style.StyleSpan r6 = new android.text.style.StyleSpan
            r6.<init>(r0)
            r5.setSpan(r6, r8, r9, r7)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.a.F(android.text.SpannableStringBuilder, int, int, int, int, int):void");
    }

    private static void G(SpannableStringBuilder spannableStringBuilder, String str, int i6, int i7) {
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i6, i7, 16711713);
        }
    }

    private static String H(i0 i0Var) {
        D(i0Var.a() >= 2);
        int L = i0Var.L();
        if (L == 0) {
            return "";
        }
        int f6 = i0Var.f();
        Charset N = i0Var.N();
        int f7 = L - (i0Var.f() - f6);
        if (N == null) {
            N = d.f7489c;
        }
        return i0Var.D(f7, N);
    }

    @Override // u1.g
    protected h A(byte[] bArr, int i6, boolean z5) {
        this.f1817o.Q(bArr, i6);
        String H = H(this.f1817o);
        if (H.isEmpty()) {
            return b.f1824b;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(H);
        F(spannableStringBuilder, this.f1819q, 0, 0, spannableStringBuilder.length(), 16711680);
        E(spannableStringBuilder, this.f1820r, -1, 0, spannableStringBuilder.length(), 16711680);
        G(spannableStringBuilder, this.f1821s, 0, spannableStringBuilder.length());
        float f6 = this.f1822t;
        while (this.f1817o.a() >= 8) {
            int f7 = this.f1817o.f();
            int o6 = this.f1817o.o();
            int o7 = this.f1817o.o();
            if (o7 == 1937013100) {
                D(this.f1817o.a() >= 2);
                int L = this.f1817o.L();
                for (int i7 = 0; i7 < L; i7++) {
                    C(this.f1817o, spannableStringBuilder);
                }
            } else if (o7 == 1952608120 && this.f1818p) {
                D(this.f1817o.a() >= 2);
                f6 = c1.p(this.f1817o.L() / this.f1823u, 0.0f, 0.95f);
            }
            this.f1817o.S(f7 + o6);
        }
        return new b(new b.C0148b().o(spannableStringBuilder).h(f6, 0).i(0).a());
    }
}

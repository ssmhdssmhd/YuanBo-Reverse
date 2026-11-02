package v4;

import f4.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends p {

    static final class a extends kotlin.jvm.internal.l implements o4.p<CharSequence, Integer, e4.j<? extends Integer, ? extends Integer>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ char[] f9900a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f9901b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(char[] cArr, boolean z5) {
            super(2);
            this.f9900a = cArr;
            this.f9901b = z5;
        }

        public final e4.j<Integer, Integer> a(CharSequence $receiver, int i6) {
            kotlin.jvm.internal.k.e($receiver, "$this$$receiver");
            int R = q.R($receiver, this.f9900a, i6, this.f9901b);
            if (R < 0) {
                return null;
            }
            return e4.n.a(Integer.valueOf(R), 1);
        }

        @Override // o4.p
        public /* bridge */ /* synthetic */ e4.j<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return a(charSequence, num.intValue());
        }
    }

    static final class b extends kotlin.jvm.internal.l implements o4.p<CharSequence, Integer, e4.j<? extends Integer, ? extends Integer>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<String> f9902a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f9903b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(List<String> list, boolean z5) {
            super(2);
            this.f9902a = list;
            this.f9903b = z5;
        }

        public final e4.j<Integer, Integer> a(CharSequence $receiver, int i6) {
            kotlin.jvm.internal.k.e($receiver, "$this$$receiver");
            e4.j I = q.I($receiver, this.f9902a, i6, this.f9903b, false);
            if (I != null) {
                return e4.n.a(I.c(), Integer.valueOf(((String) I.d()).length()));
            }
            return null;
        }

        @Override // o4.p
        public /* bridge */ /* synthetic */ e4.j<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return a(charSequence, num.intValue());
        }
    }

    static final class c extends kotlin.jvm.internal.l implements o4.l<s4.c, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f9904a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(CharSequence charSequence) {
            super(1);
            this.f9904a = charSequence;
        }

        @Override // o4.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(s4.c it) {
            kotlin.jvm.internal.k.e(it, "it");
            return q.o0(this.f9904a, it);
        }
    }

    public static final boolean C(CharSequence charSequence, char c6, boolean z5) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        return P(charSequence, c6, 0, z5, 2, null) >= 0;
    }

    public static final boolean D(CharSequence charSequence, CharSequence other, boolean z5) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(other, "other");
        if (other instanceof String) {
            if (Q(charSequence, (String) other, 0, z5, 2, null) >= 0) {
                return true;
            }
        } else if (O(charSequence, other, 0, charSequence.length(), z5, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean E(CharSequence charSequence, char c6, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return C(charSequence, c6, z5);
    }

    public static /* synthetic */ boolean F(CharSequence charSequence, CharSequence charSequence2, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return D(charSequence, charSequence2, z5);
    }

    public static final boolean G(CharSequence charSequence, CharSequence suffix, boolean z5) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(suffix, "suffix");
        return (!z5 && (charSequence instanceof String) && (suffix instanceof String)) ? p.n((String) charSequence, (String) suffix, false, 2, null) : d0(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z5);
    }

    public static /* synthetic */ boolean H(CharSequence charSequence, CharSequence charSequence2, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return G(charSequence, charSequence2, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0091, code lost:
    
        return e4.n.a(java.lang.Integer.valueOf(r12), r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final e4.j<java.lang.Integer, java.lang.String> I(java.lang.CharSequence r10, java.util.Collection<java.lang.String> r11, int r12, boolean r13, boolean r14) {
        /*
            r0 = 0
            if (r13 != 0) goto L2d
            int r1 = r11.size()
            r2 = 1
            if (r1 != r2) goto L2d
            java.lang.Object r11 = f4.j.D(r11)
            java.lang.String r11 = (java.lang.String) r11
            r4 = 0
            r5 = 4
            r6 = 0
            r1 = r10
            r2 = r11
            r3 = r12
            if (r14 != 0) goto L1d
            int r10 = v4.g.Q(r1, r2, r3, r4, r5, r6)
            goto L21
        L1d:
            int r10 = v4.g.V(r1, r2, r3, r4, r5, r6)
        L21:
            if (r10 >= 0) goto L24
            goto L2c
        L24:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            e4.j r0 = e4.n.a(r10, r11)
        L2c:
            return r0
        L2d:
            r1 = 0
            if (r14 != 0) goto L3e
            s4.c r14 = new s4.c
            int r12 = s4.d.b(r12, r1)
            int r1 = r10.length()
            r14.<init>(r12, r1)
            goto L4a
        L3e:
            int r14 = K(r10)
            int r12 = s4.d.d(r12, r14)
            s4.a r14 = s4.d.g(r12, r1)
        L4a:
            boolean r12 = r10 instanceof java.lang.String
            if (r12 == 0) goto L96
            int r12 = r14.b()
            int r1 = r14.c()
            int r14 = r14.d()
            if (r14 <= 0) goto L5e
            if (r12 <= r1) goto L62
        L5e:
            if (r14 >= 0) goto Ld4
            if (r1 > r12) goto Ld4
        L62:
            java.util.Iterator r8 = r11.iterator()
        L66:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L84
            java.lang.Object r9 = r8.next()
            r2 = r9
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            r4 = r10
            java.lang.String r4 = (java.lang.String) r4
            int r6 = r2.length()
            r5 = r12
            r7 = r13
            boolean r2 = v4.p.q(r2, r3, r4, r5, r6, r7)
            if (r2 == 0) goto L66
            goto L85
        L84:
            r9 = r0
        L85:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L92
        L89:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r12)
            e4.j r10 = e4.n.a(r10, r9)
            return r10
        L92:
            if (r12 == r1) goto Ld4
            int r12 = r12 + r14
            goto L62
        L96:
            int r12 = r14.b()
            int r1 = r14.c()
            int r14 = r14.d()
            if (r14 <= 0) goto La6
            if (r12 <= r1) goto Laa
        La6:
            if (r14 >= 0) goto Ld4
            if (r1 > r12) goto Ld4
        Laa:
            java.util.Iterator r8 = r11.iterator()
        Lae:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto Lca
            java.lang.Object r9 = r8.next()
            r2 = r9
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            int r6 = r2.length()
            r4 = r10
            r5 = r12
            r7 = r13
            boolean r2 = d0(r2, r3, r4, r5, r6, r7)
            if (r2 == 0) goto Lae
            goto Lcb
        Lca:
            r9 = r0
        Lcb:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto Ld0
            goto L89
        Ld0:
            if (r12 == r1) goto Ld4
            int r12 = r12 + r14
            goto Laa
        Ld4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.q.I(java.lang.CharSequence, java.util.Collection, int, boolean, boolean):e4.j");
    }

    public static final s4.c J(CharSequence charSequence) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        return new s4.c(0, charSequence.length() - 1);
    }

    public static final int K(CharSequence charSequence) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int L(CharSequence charSequence, char c6, int i6, boolean z5) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        return (z5 || !(charSequence instanceof String)) ? R(charSequence, new char[]{c6}, i6, z5) : ((String) charSequence).indexOf(c6, i6);
    }

    public static final int M(CharSequence charSequence, String string, int i6, boolean z5) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(string, "string");
        return (z5 || !(charSequence instanceof String)) ? O(charSequence, string, i6, charSequence.length(), z5, false, 16, null) : ((String) charSequence).indexOf(string, i6);
    }

    private static final int N(CharSequence charSequence, CharSequence charSequence2, int i6, int i7, boolean z5, boolean z6) {
        int d6;
        int b6;
        s4.a g6;
        int b7;
        int d7;
        if (z6) {
            d6 = s4.f.d(i6, K(charSequence));
            b6 = s4.f.b(i7, 0);
            g6 = s4.f.g(d6, b6);
        } else {
            b7 = s4.f.b(i6, 0);
            d7 = s4.f.d(i7, charSequence.length());
            g6 = new s4.c(b7, d7);
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int b8 = g6.b();
            int c6 = g6.c();
            int d8 = g6.d();
            if ((d8 <= 0 || b8 > c6) && (d8 >= 0 || c6 > b8)) {
                return -1;
            }
            while (!p.q((String) charSequence2, 0, (String) charSequence, b8, charSequence2.length(), z5)) {
                if (b8 == c6) {
                    return -1;
                }
                b8 += d8;
            }
            return b8;
        }
        int b9 = g6.b();
        int c7 = g6.c();
        int d9 = g6.d();
        if ((d9 <= 0 || b9 > c7) && (d9 >= 0 || c7 > b9)) {
            return -1;
        }
        while (!d0(charSequence2, 0, charSequence, b9, charSequence2.length(), z5)) {
            if (b9 == c7) {
                return -1;
            }
            b9 += d9;
        }
        return b9;
    }

    static /* synthetic */ int O(CharSequence charSequence, CharSequence charSequence2, int i6, int i7, boolean z5, boolean z6, int i8, Object obj) {
        return N(charSequence, charSequence2, i6, i7, z5, (i8 & 16) != 0 ? false : z6);
    }

    public static /* synthetic */ int P(CharSequence charSequence, char c6, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        return L(charSequence, c6, i6, z5);
    }

    public static /* synthetic */ int Q(CharSequence charSequence, String str, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        return M(charSequence, str, i6, z5);
    }

    public static final int R(CharSequence charSequence, char[] chars, int i6, boolean z5) {
        int b6;
        boolean z6;
        char p6;
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(chars, "chars");
        if (!z5 && chars.length == 1 && (charSequence instanceof String)) {
            p6 = f4.h.p(chars);
            return ((String) charSequence).indexOf(p6, i6);
        }
        b6 = s4.f.b(i6, 0);
        y it = new s4.c(b6, K(charSequence)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            char charAt = charSequence.charAt(nextInt);
            int length = chars.length;
            int i7 = 0;
            while (true) {
                if (i7 >= length) {
                    z6 = false;
                    break;
                }
                if (v4.c.d(chars[i7], charAt, z5)) {
                    z6 = true;
                    break;
                }
                i7++;
            }
            if (z6) {
                return nextInt;
            }
        }
        return -1;
    }

    public static final int S(CharSequence charSequence, char c6, int i6, boolean z5) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        return (z5 || !(charSequence instanceof String)) ? W(charSequence, new char[]{c6}, i6, z5) : ((String) charSequence).lastIndexOf(c6, i6);
    }

    public static final int T(CharSequence charSequence, String string, int i6, boolean z5) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(string, "string");
        return (z5 || !(charSequence instanceof String)) ? N(charSequence, string, i6, 0, z5, true) : ((String) charSequence).lastIndexOf(string, i6);
    }

    public static /* synthetic */ int U(CharSequence charSequence, char c6, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = K(charSequence);
        }
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        return S(charSequence, c6, i6, z5);
    }

    public static /* synthetic */ int V(CharSequence charSequence, String str, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = K(charSequence);
        }
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        return T(charSequence, str, i6, z5);
    }

    public static final int W(CharSequence charSequence, char[] chars, int i6, boolean z5) {
        int d6;
        char p6;
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(chars, "chars");
        if (!z5 && chars.length == 1 && (charSequence instanceof String)) {
            p6 = f4.h.p(chars);
            return ((String) charSequence).lastIndexOf(p6, i6);
        }
        for (d6 = s4.f.d(i6, K(charSequence)); -1 < d6; d6--) {
            char charAt = charSequence.charAt(d6);
            int length = chars.length;
            boolean z6 = false;
            int i7 = 0;
            while (true) {
                if (i7 >= length) {
                    break;
                }
                if (v4.c.d(chars[i7], charAt, z5)) {
                    z6 = true;
                    break;
                }
                i7++;
            }
            if (z6) {
                return d6;
            }
        }
        return -1;
    }

    public static final u4.d<String> X(CharSequence charSequence) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        return l0(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List<String> Y(CharSequence charSequence) {
        List<String> j6;
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        j6 = u4.j.j(X(charSequence));
        return j6;
    }

    private static final u4.d<s4.c> Z(CharSequence charSequence, char[] cArr, int i6, boolean z5, int i7) {
        g0(i7);
        return new e(charSequence, i6, i7, new a(cArr, z5));
    }

    private static final u4.d<s4.c> a0(CharSequence charSequence, String[] strArr, int i6, boolean z5, int i7) {
        List b6;
        g0(i7);
        b6 = f4.g.b(strArr);
        return new e(charSequence, i6, i7, new b(b6, z5));
    }

    static /* synthetic */ u4.d b0(CharSequence charSequence, char[] cArr, int i6, boolean z5, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            z5 = false;
        }
        if ((i8 & 8) != 0) {
            i7 = 0;
        }
        return Z(charSequence, cArr, i6, z5, i7);
    }

    static /* synthetic */ u4.d c0(CharSequence charSequence, String[] strArr, int i6, boolean z5, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            z5 = false;
        }
        if ((i8 & 8) != 0) {
            i7 = 0;
        }
        return a0(charSequence, strArr, i6, z5, i7);
    }

    public static final boolean d0(CharSequence charSequence, int i6, CharSequence other, int i7, int i8, boolean z5) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(other, "other");
        if (i7 < 0 || i6 < 0 || i6 > charSequence.length() - i8 || i7 > other.length() - i8) {
            return false;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            if (!v4.c.d(charSequence.charAt(i6 + i9), other.charAt(i7 + i9), z5)) {
                return false;
            }
        }
        return true;
    }

    public static String e0(String str, CharSequence prefix) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        if (!n0(str, prefix, false, 2, null)) {
            return str;
        }
        String substring = str.substring(prefix.length());
        kotlin.jvm.internal.k.d(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static String f0(String str, CharSequence suffix) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(suffix, "suffix");
        if (!H(str, suffix, false, 2, null)) {
            return str;
        }
        String substring = str.substring(0, str.length() - suffix.length());
        kotlin.jvm.internal.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final void g0(int i6) {
        if (i6 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i6).toString());
    }

    public static final List<String> h0(CharSequence charSequence, char[] delimiters, boolean z5, int i6) {
        Iterable c6;
        int n6;
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return i0(charSequence, String.valueOf(delimiters[0]), z5, i6);
        }
        c6 = u4.j.c(b0(charSequence, delimiters, 0, z5, i6, 2, null));
        n6 = f4.m.n(c6, 10);
        ArrayList arrayList = new ArrayList(n6);
        Iterator it = c6.iterator();
        while (it.hasNext()) {
            arrayList.add(o0(charSequence, (s4.c) it.next()));
        }
        return arrayList;
    }

    private static final List<String> i0(CharSequence charSequence, String str, boolean z5, int i6) {
        g0(i6);
        int i7 = 0;
        int M = M(charSequence, str, 0, z5);
        if (M == -1 || i6 == 1) {
            return f4.k.b(charSequence.toString());
        }
        boolean z6 = i6 > 0;
        ArrayList arrayList = new ArrayList(z6 ? s4.f.d(i6, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(i7, M).toString());
            i7 = str.length() + M;
            if (z6 && arrayList.size() == i6 - 1) {
                break;
            }
            M = M(charSequence, str, i7, z5);
        } while (M != -1);
        arrayList.add(charSequence.subSequence(i7, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List j0(CharSequence charSequence, char[] cArr, boolean z5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z5 = false;
        }
        if ((i7 & 4) != 0) {
            i6 = 0;
        }
        return h0(charSequence, cArr, z5, i6);
    }

    public static final u4.d<String> k0(CharSequence charSequence, String[] delimiters, boolean z5, int i6) {
        u4.d<String> h6;
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(delimiters, "delimiters");
        h6 = u4.j.h(c0(charSequence, delimiters, 0, z5, i6, 2, null), new c(charSequence));
        return h6;
    }

    public static /* synthetic */ u4.d l0(CharSequence charSequence, String[] strArr, boolean z5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z5 = false;
        }
        if ((i7 & 4) != 0) {
            i6 = 0;
        }
        return k0(charSequence, strArr, z5, i6);
    }

    public static final boolean m0(CharSequence charSequence, CharSequence prefix, boolean z5) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        return (!z5 && (charSequence instanceof String) && (prefix instanceof String)) ? p.A((String) charSequence, (String) prefix, false, 2, null) : d0(charSequence, 0, prefix, 0, prefix.length(), z5);
    }

    public static /* synthetic */ boolean n0(CharSequence charSequence, CharSequence charSequence2, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return m0(charSequence, charSequence2, z5);
    }

    public static final String o0(CharSequence charSequence, s4.c range) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(range, "range");
        return charSequence.subSequence(range.i().intValue(), range.h().intValue() + 1).toString();
    }

    public static final String p0(String str, char c6, String missingDelimiterValue) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(missingDelimiterValue, "missingDelimiterValue");
        int P = P(str, c6, 0, false, 6, null);
        if (P == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(P + 1, str.length());
        kotlin.jvm.internal.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String q0(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(delimiter, "delimiter");
        kotlin.jvm.internal.k.e(missingDelimiterValue, "missingDelimiterValue");
        int Q = Q(str, delimiter, 0, false, 6, null);
        if (Q == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(Q + delimiter.length(), str.length());
        kotlin.jvm.internal.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String r0(String str, char c6, String str2, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str2 = str;
        }
        return p0(str, c6, str2);
    }

    public static /* synthetic */ String s0(String str, String str2, String str3, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str3 = str;
        }
        return q0(str, str2, str3);
    }

    public static final String t0(String str, char c6, String missingDelimiterValue) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(missingDelimiterValue, "missingDelimiterValue");
        int U = U(str, c6, 0, false, 6, null);
        if (U == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(U + 1, str.length());
        kotlin.jvm.internal.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String u0(String str, char c6, String str2, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str2 = str;
        }
        return t0(str, c6, str2);
    }

    public static final String v0(String str, char c6, String missingDelimiterValue) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(missingDelimiterValue, "missingDelimiterValue");
        int P = P(str, c6, 0, false, 6, null);
        if (P == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, P);
        kotlin.jvm.internal.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String w0(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(delimiter, "delimiter");
        kotlin.jvm.internal.k.e(missingDelimiterValue, "missingDelimiterValue");
        int Q = Q(str, delimiter, 0, false, 6, null);
        if (Q == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, Q);
        kotlin.jvm.internal.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String x0(String str, char c6, String str2, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str2 = str;
        }
        return v0(str, c6, str2);
    }

    public static /* synthetic */ String y0(String str, String str2, String str3, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str3 = str;
        }
        return w0(str, str2, str3);
    }

    public static CharSequence z0(CharSequence charSequence) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i6 = 0;
        boolean z5 = false;
        while (i6 <= length) {
            boolean c6 = v4.b.c(charSequence.charAt(!z5 ? i6 : length));
            if (z5) {
                if (!c6) {
                    break;
                }
                length--;
            } else if (c6) {
                i6++;
            } else {
                z5 = true;
            }
        }
        return charSequence.subSequence(i6, length + 1);
    }
}

package q5;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;

/* loaded from: classes.dex */
public class h implements Serializable, Comparable<h> {

    /* renamed from: a, reason: collision with root package name */
    private transient int f8960a;

    /* renamed from: b, reason: collision with root package name */
    private transient String f8961b;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f8962c;

    /* renamed from: e, reason: collision with root package name */
    public static final a f8959e = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final h f8958d = new h(new byte[0]);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public static /* synthetic */ h e(a aVar, byte[] bArr, int i6, int i7, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                i6 = 0;
            }
            if ((i8 & 2) != 0) {
                i7 = bArr.length;
            }
            return aVar.d(bArr, i6, i7);
        }

        public final h a(String decodeHex) {
            int e6;
            int e7;
            kotlin.jvm.internal.k.e(decodeHex, "$this$decodeHex");
            if (!(decodeHex.length() % 2 == 0)) {
                throw new IllegalArgumentException(("Unexpected hex string: " + decodeHex).toString());
            }
            int length = decodeHex.length() / 2;
            byte[] bArr = new byte[length];
            for (int i6 = 0; i6 < length; i6++) {
                int i7 = i6 * 2;
                e6 = r5.b.e(decodeHex.charAt(i7));
                e7 = r5.b.e(decodeHex.charAt(i7 + 1));
                bArr[i6] = (byte) ((e6 << 4) + e7);
            }
            return new h(bArr);
        }

        public final h b(String encode, Charset charset) {
            kotlin.jvm.internal.k.e(encode, "$this$encode");
            kotlin.jvm.internal.k.e(charset, "charset");
            byte[] bytes = encode.getBytes(charset);
            kotlin.jvm.internal.k.d(bytes, "(this as java.lang.String).getBytes(charset)");
            return new h(bytes);
        }

        public final h c(String encodeUtf8) {
            kotlin.jvm.internal.k.e(encodeUtf8, "$this$encodeUtf8");
            h hVar = new h(b.a(encodeUtf8));
            hVar.o(encodeUtf8);
            return hVar;
        }

        public final h d(byte[] toByteString, int i6, int i7) {
            byte[] g6;
            kotlin.jvm.internal.k.e(toByteString, "$this$toByteString");
            c.b(toByteString.length, i6, i7);
            g6 = f4.g.g(toByteString, i6, i7 + i6);
            return new h(g6);
        }
    }

    public h(byte[] data) {
        kotlin.jvm.internal.k.e(data, "data");
        this.f8962c = data;
    }

    public String a() {
        return q5.a.b(e(), null, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0030 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032 A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int compareTo(q5.h r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            kotlin.jvm.internal.k.e(r10, r0)
            int r0 = r9.r()
            int r1 = r10.r()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2b
            byte r7 = r9.d(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.d(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L32
            goto L30
        L2b:
            if (r0 != r1) goto L2e
            goto L33
        L2e:
            if (r0 >= r1) goto L32
        L30:
            r3 = -1
            goto L33
        L32:
            r3 = 1
        L33:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.h.compareTo(q5.h):int");
    }

    public h c(String algorithm) {
        kotlin.jvm.internal.k.e(algorithm, "algorithm");
        byte[] digest = MessageDigest.getInstance(algorithm).digest(this.f8962c);
        kotlin.jvm.internal.k.d(digest, "MessageDigest.getInstance(algorithm).digest(data)");
        return new h(digest);
    }

    public final byte d(int i6) {
        return k(i6);
    }

    public final byte[] e() {
        return this.f8962c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (hVar.r() == e().length && hVar.m(0, e(), 0, e().length)) {
                return true;
            }
        }
        return false;
    }

    public final int f() {
        return this.f8960a;
    }

    public int g() {
        return e().length;
    }

    public final String h() {
        return this.f8961b;
    }

    public int hashCode() {
        int f6 = f();
        if (f6 != 0) {
            return f6;
        }
        int hashCode = Arrays.hashCode(e());
        n(hashCode);
        return hashCode;
    }

    public String i() {
        char[] cArr = new char[e().length * 2];
        int i6 = 0;
        for (byte b6 : e()) {
            int i7 = i6 + 1;
            cArr[i6] = r5.b.f()[(b6 >> 4) & 15];
            i6 = i7 + 1;
            cArr[i7] = r5.b.f()[b6 & 15];
        }
        return new String(cArr);
    }

    public byte[] j() {
        return e();
    }

    public byte k(int i6) {
        return e()[i6];
    }

    public boolean l(int i6, h other, int i7, int i8) {
        kotlin.jvm.internal.k.e(other, "other");
        return other.m(i7, e(), i6, i8);
    }

    public boolean m(int i6, byte[] other, int i7, int i8) {
        kotlin.jvm.internal.k.e(other, "other");
        return i6 >= 0 && i6 <= e().length - i8 && i7 >= 0 && i7 <= other.length - i8 && c.a(e(), i6, other, i7, i8);
    }

    public final void n(int i6) {
        this.f8960a = i6;
    }

    public final void o(String str) {
        this.f8961b = str;
    }

    public h p() {
        return c("SHA-1");
    }

    public h q() {
        return c("SHA-256");
    }

    public final int r() {
        return g();
    }

    public final boolean s(h prefix) {
        kotlin.jvm.internal.k.e(prefix, "prefix");
        return l(0, prefix, 0, prefix.r());
    }

    public h t() {
        byte b6;
        for (int i6 = 0; i6 < e().length; i6++) {
            byte b7 = e()[i6];
            byte b8 = (byte) 65;
            if (b7 >= b8 && b7 <= (b6 = (byte) 90)) {
                byte[] e6 = e();
                byte[] copyOf = Arrays.copyOf(e6, e6.length);
                kotlin.jvm.internal.k.d(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i6] = (byte) (b7 + 32);
                for (int i7 = i6 + 1; i7 < copyOf.length; i7++) {
                    byte b9 = copyOf[i7];
                    if (b9 >= b8 && b9 <= b6) {
                        copyOf[i7] = (byte) (b9 + 32);
                    }
                }
                return new h(copyOf);
            }
        }
        return this;
    }

    public String toString() {
        int c6;
        String w5;
        String w6;
        String w7;
        StringBuilder sb;
        h hVar;
        byte[] g6;
        if (e().length == 0) {
            return "[size=0]";
        }
        c6 = r5.b.c(e(), 64);
        if (c6 != -1) {
            String u5 = u();
            if (u5 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = u5.substring(0, c6);
            kotlin.jvm.internal.k.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            w5 = v4.p.w(substring, "\\", "\\\\", false, 4, null);
            w6 = v4.p.w(w5, "\n", "\\n", false, 4, null);
            w7 = v4.p.w(w6, "\r", "\\r", false, 4, null);
            if (c6 < u5.length()) {
                sb = new StringBuilder();
                sb.append("[size=");
                sb.append(e().length);
                sb.append(" text=");
                sb.append(w7);
                sb.append("…]");
            } else {
                sb = new StringBuilder();
                sb.append("[text=");
                sb.append(w7);
                sb.append(']');
            }
        } else if (e().length <= 64) {
            sb = new StringBuilder();
            sb.append("[hex=");
            sb.append(i());
            sb.append(']');
        } else {
            sb = new StringBuilder();
            sb.append("[size=");
            sb.append(e().length);
            sb.append(" hex=");
            if (!(64 <= e().length)) {
                throw new IllegalArgumentException(("endIndex > length(" + e().length + ')').toString());
            }
            if (64 == e().length) {
                hVar = this;
            } else {
                g6 = f4.g.g(e(), 0, 64);
                hVar = new h(g6);
            }
            sb.append(hVar.i());
            sb.append("…]");
        }
        return sb.toString();
    }

    public String u() {
        String h6 = h();
        if (h6 != null) {
            return h6;
        }
        String b6 = b.b(j());
        o(b6);
        return b6;
    }

    public void v(e buffer, int i6, int i7) {
        kotlin.jvm.internal.k.e(buffer, "buffer");
        r5.b.d(this, buffer, i6, i7);
    }
}

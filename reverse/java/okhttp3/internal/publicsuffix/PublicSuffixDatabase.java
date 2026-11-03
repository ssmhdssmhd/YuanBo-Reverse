package okhttp3.internal.publicsuffix;

import e4.q;
import e5.b;
import f4.k;
import f4.t;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.g;
import m5.m;
import q5.l;
import q5.o;
import u4.d;
import u4.j;

/* loaded from: classes.dex */
public final class PublicSuffixDatabase {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f8481a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private final CountDownLatch f8482b = new CountDownLatch(1);

    /* renamed from: c, reason: collision with root package name */
    private byte[] f8483c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f8484d;

    /* renamed from: h, reason: collision with root package name */
    public static final a f8480h = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private static final byte[] f8477e = {(byte) 42};

    /* renamed from: f, reason: collision with root package name */
    private static final List<String> f8478f = k.b("*");

    /* renamed from: g, reason: collision with root package name */
    private static final PublicSuffixDatabase f8479g = new PublicSuffixDatabase();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b(byte[] bArr, byte[][] bArr2, int i6) {
            int i7;
            boolean z5;
            int b6;
            int b7;
            int length = bArr.length;
            int i8 = 0;
            while (i8 < length) {
                int i9 = (i8 + length) / 2;
                while (i9 > -1 && bArr[i9] != ((byte) 10)) {
                    i9--;
                }
                int i10 = i9 + 1;
                int i11 = 1;
                while (true) {
                    i7 = i10 + i11;
                    if (bArr[i7] == ((byte) 10)) {
                        break;
                    }
                    i11++;
                }
                int i12 = i7 - i10;
                int i13 = i6;
                boolean z6 = false;
                int i14 = 0;
                int i15 = 0;
                while (true) {
                    if (z6) {
                        b6 = 46;
                        z5 = false;
                    } else {
                        z5 = z6;
                        b6 = b.b(bArr2[i13][i14], 255);
                    }
                    b7 = b6 - b.b(bArr[i10 + i15], 255);
                    if (b7 != 0) {
                        break;
                    }
                    i15++;
                    i14++;
                    if (i15 == i12) {
                        break;
                    }
                    if (bArr2[i13].length != i14) {
                        z6 = z5;
                    } else {
                        if (i13 == bArr2.length - 1) {
                            break;
                        }
                        i13++;
                        z6 = true;
                        i14 = -1;
                    }
                }
                if (b7 >= 0) {
                    if (b7 <= 0) {
                        int i16 = i12 - i15;
                        int length2 = bArr2[i13].length - i14;
                        int length3 = bArr2.length;
                        for (int i17 = i13 + 1; i17 < length3; i17++) {
                            length2 += bArr2[i17].length;
                        }
                        if (length2 >= i16) {
                            if (length2 <= i16) {
                                Charset UTF_8 = StandardCharsets.UTF_8;
                                kotlin.jvm.internal.k.d(UTF_8, "UTF_8");
                                return new String(bArr, i10, i12, UTF_8);
                            }
                        }
                    }
                    i8 = i7 + 1;
                }
                length = i10 - 1;
            }
            return null;
        }

        public final PublicSuffixDatabase c() {
            return PublicSuffixDatabase.f8479g;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e5, code lost:
    
        r4 = v4.q.j0(r8, new char[]{'.'}, false, 0, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00fc, code lost:
    
        r1 = v4.q.j0(r5, new char[]{'.'}, false, 0, 6, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<java.lang.String> b(java.util.List<java.lang.String> r18) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.b(java.util.List):java.util.List");
    }

    private final void d() {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        q5.g b6 = o.b(new l(o.e(resourceAsStream)));
        try {
            byte[] A = b6.A(b6.readInt());
            byte[] A2 = b6.A(b6.readInt());
            q qVar = q.f3710a;
            m4.b.a(b6, null);
            synchronized (this) {
                kotlin.jvm.internal.k.b(A);
                this.f8483c = A;
                kotlin.jvm.internal.k.b(A2);
                this.f8484d = A2;
            }
            this.f8482b.countDown();
        } finally {
        }
    }

    private final void e() {
        boolean z5 = false;
        while (true) {
            try {
                try {
                    d();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z5 = true;
                } catch (IOException e6) {
                    m.f8137c.g().j("Failed to read public suffix list", 5, e6);
                    if (z5) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z5) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z5) {
            Thread.currentThread().interrupt();
        }
    }

    private final List<String> f(String str) {
        List<String> j02;
        Object z5;
        List<String> s5;
        j02 = v4.q.j0(str, new char[]{'.'}, false, 0, 6, null);
        z5 = t.z(j02);
        if (!kotlin.jvm.internal.k.a((String) z5, "")) {
            return j02;
        }
        s5 = t.s(j02, 1);
        return s5;
    }

    public final String c(String domain) {
        d r6;
        d d6;
        String g6;
        kotlin.jvm.internal.k.e(domain, "domain");
        String unicodeDomain = IDN.toUnicode(domain);
        kotlin.jvm.internal.k.d(unicodeDomain, "unicodeDomain");
        List<String> f6 = f(unicodeDomain);
        List<String> b6 = b(f6);
        if (f6.size() == b6.size() && b6.get(0).charAt(0) != '!') {
            return null;
        }
        char charAt = b6.get(0).charAt(0);
        int size = f6.size();
        int size2 = b6.size();
        if (charAt != '!') {
            size2++;
        }
        r6 = t.r(f(domain));
        d6 = j.d(r6, size - size2);
        g6 = j.g(d6, ".", null, null, 0, null, null, 62, null);
        return g6;
    }
}

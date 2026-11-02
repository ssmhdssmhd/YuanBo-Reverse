package b2;

import android.text.TextUtils;
import java.util.regex.Pattern;
import m2.s;

/* loaded from: classes.dex */
final class b {

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f1707d = Pattern.compile("\\s+");

    /* renamed from: e, reason: collision with root package name */
    private static final s<String> f1708e = s.q("auto", "none");

    /* renamed from: f, reason: collision with root package name */
    private static final s<String> f1709f = s.r("dot", "sesame", "circle");

    /* renamed from: g, reason: collision with root package name */
    private static final s<String> f1710g = s.q("filled", "open");

    /* renamed from: h, reason: collision with root package name */
    private static final s<String> f1711h = s.r("after", "before", "outside");

    /* renamed from: a, reason: collision with root package name */
    public final int f1712a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1713b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1714c;

    private b(int i6, int i7, int i8) {
        this.f1712a = i6;
        this.f1713b = i7;
        this.f1714c = i8;
    }

    public static b a(String str) {
        if (str == null) {
            return null;
        }
        String e6 = l2.b.e(str.trim());
        if (e6.isEmpty()) {
            return null;
        }
        return b(s.l(TextUtils.split(e6, f1707d)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0081, code lost:
    
        if (r9.equals("auto") != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00fe, code lost:
    
        if (r9.equals("dot") == false) goto L80;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static b2.b b(m2.s<java.lang.String> r9) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.b.b(m2.s):b2.b");
    }
}

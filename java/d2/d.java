package d2;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: f, reason: collision with root package name */
    private int f2935f;

    /* renamed from: h, reason: collision with root package name */
    private int f2937h;

    /* renamed from: o, reason: collision with root package name */
    private float f2944o;

    /* renamed from: a, reason: collision with root package name */
    private String f2930a = "";

    /* renamed from: b, reason: collision with root package name */
    private String f2931b = "";

    /* renamed from: c, reason: collision with root package name */
    private Set<String> f2932c = Collections.emptySet();

    /* renamed from: d, reason: collision with root package name */
    private String f2933d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f2934e = null;

    /* renamed from: g, reason: collision with root package name */
    private boolean f2936g = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2938i = false;

    /* renamed from: j, reason: collision with root package name */
    private int f2939j = -1;

    /* renamed from: k, reason: collision with root package name */
    private int f2940k = -1;

    /* renamed from: l, reason: collision with root package name */
    private int f2941l = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f2942m = -1;

    /* renamed from: n, reason: collision with root package name */
    private int f2943n = -1;

    /* renamed from: p, reason: collision with root package name */
    private int f2945p = -1;

    /* renamed from: q, reason: collision with root package name */
    private boolean f2946q = false;

    private static int B(int i6, String str, String str2, int i7) {
        if (str.isEmpty() || i6 == -1) {
            return i6;
        }
        if (str.equals(str2)) {
            return i6 + i7;
        }
        return -1;
    }

    public d A(boolean z5) {
        this.f2940k = z5 ? 1 : 0;
        return this;
    }

    public int a() {
        if (this.f2938i) {
            return this.f2937h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean b() {
        return this.f2946q;
    }

    public int c() {
        if (this.f2936g) {
            return this.f2935f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public String d() {
        return this.f2934e;
    }

    public float e() {
        return this.f2944o;
    }

    public int f() {
        return this.f2943n;
    }

    public int g() {
        return this.f2945p;
    }

    public int h(String str, String str2, Set<String> set, String str3) {
        if (this.f2930a.isEmpty() && this.f2931b.isEmpty() && this.f2932c.isEmpty() && this.f2933d.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int B = B(B(B(0, this.f2930a, str, 1073741824), this.f2931b, str2, 2), this.f2933d, str3, 4);
        if (B == -1 || !set.containsAll(this.f2932c)) {
            return 0;
        }
        return B + (this.f2932c.size() * 4);
    }

    public int i() {
        int i6 = this.f2941l;
        if (i6 == -1 && this.f2942m == -1) {
            return -1;
        }
        return (i6 == 1 ? 1 : 0) | (this.f2942m == 1 ? 2 : 0);
    }

    public boolean j() {
        return this.f2938i;
    }

    public boolean k() {
        return this.f2936g;
    }

    public boolean l() {
        return this.f2939j == 1;
    }

    public boolean m() {
        return this.f2940k == 1;
    }

    public d n(int i6) {
        this.f2937h = i6;
        this.f2938i = true;
        return this;
    }

    public d o(boolean z5) {
        this.f2941l = z5 ? 1 : 0;
        return this;
    }

    public d p(boolean z5) {
        this.f2946q = z5;
        return this;
    }

    public d q(int i6) {
        this.f2935f = i6;
        this.f2936g = true;
        return this;
    }

    public d r(String str) {
        this.f2934e = str == null ? null : l2.b.e(str);
        return this;
    }

    public d s(float f6) {
        this.f2944o = f6;
        return this;
    }

    public d t(int i6) {
        this.f2943n = i6;
        return this;
    }

    public d u(boolean z5) {
        this.f2942m = z5 ? 1 : 0;
        return this;
    }

    public d v(int i6) {
        this.f2945p = i6;
        return this;
    }

    public void w(String[] strArr) {
        this.f2932c = new HashSet(Arrays.asList(strArr));
    }

    public void x(String str) {
        this.f2930a = str;
    }

    public void y(String str) {
        this.f2931b = str;
    }

    public void z(String str) {
        this.f2933d = str;
    }
}

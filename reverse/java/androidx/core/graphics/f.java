package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: e, reason: collision with root package name */
    public static final f f433e = new f(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f434a;

    /* renamed from: b, reason: collision with root package name */
    public final int f435b;

    /* renamed from: c, reason: collision with root package name */
    public final int f436c;

    /* renamed from: d, reason: collision with root package name */
    public final int f437d;

    static class a {
        static Insets a(int i6, int i7, int i8, int i9) {
            Insets of;
            of = Insets.of(i6, i7, i8, i9);
            return of;
        }
    }

    private f(int i6, int i7, int i8, int i9) {
        this.f434a = i6;
        this.f435b = i7;
        this.f436c = i8;
        this.f437d = i9;
    }

    public static f a(f fVar, f fVar2) {
        return b(Math.max(fVar.f434a, fVar2.f434a), Math.max(fVar.f435b, fVar2.f435b), Math.max(fVar.f436c, fVar2.f436c), Math.max(fVar.f437d, fVar2.f437d));
    }

    public static f b(int i6, int i7, int i8, int i9) {
        return (i6 == 0 && i7 == 0 && i8 == 0 && i9 == 0) ? f433e : new f(i6, i7, i8, i9);
    }

    public static f c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static f d(Insets insets) {
        int i6;
        int i7;
        int i8;
        int i9;
        i6 = insets.left;
        i7 = insets.top;
        i8 = insets.right;
        i9 = insets.bottom;
        return b(i6, i7, i8, i9);
    }

    public Insets e() {
        return a.a(this.f434a, this.f435b, this.f436c, this.f437d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return this.f437d == fVar.f437d && this.f434a == fVar.f434a && this.f436c == fVar.f436c && this.f435b == fVar.f435b;
    }

    public int hashCode() {
        return (((((this.f434a * 31) + this.f435b) * 31) + this.f436c) * 31) + this.f437d;
    }

    public String toString() {
        return "Insets{left=" + this.f434a + ", top=" + this.f435b + ", right=" + this.f436c + ", bottom=" + this.f437d + '}';
    }
}

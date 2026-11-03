package k;

import android.text.TextUtils;

/* loaded from: classes.dex */
class g implements b {

    /* renamed from: a, reason: collision with root package name */
    private String f6854a;

    /* renamed from: b, reason: collision with root package name */
    private int f6855b;

    /* renamed from: c, reason: collision with root package name */
    private int f6856c;

    g(String str, int i6, int i7) {
        this.f6854a = str;
        this.f6855b = i6;
        this.f6856c = i7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return (this.f6855b < 0 || gVar.f6855b < 0) ? TextUtils.equals(this.f6854a, gVar.f6854a) && this.f6856c == gVar.f6856c : TextUtils.equals(this.f6854a, gVar.f6854a) && this.f6855b == gVar.f6855b && this.f6856c == gVar.f6856c;
    }

    public int hashCode() {
        return androidx.core.util.d.b(this.f6854a, Integer.valueOf(this.f6856c));
    }
}

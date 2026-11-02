package p1;

import i2.c1;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f8572a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8573b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8574c;

    public e(String str, String str2, String str3) {
        this.f8572a = str;
        this.f8573b = str2;
        this.f8574c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return c1.c(this.f8572a, eVar.f8572a) && c1.c(this.f8573b, eVar.f8573b) && c1.c(this.f8574c, eVar.f8574c);
    }

    public int hashCode() {
        int hashCode = this.f8572a.hashCode() * 31;
        String str = this.f8573b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f8574c;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }
}

package p1;

import i2.c1;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f8585a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8586b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8587c;

    /* renamed from: d, reason: collision with root package name */
    public final String f8588d;

    /* renamed from: e, reason: collision with root package name */
    public final String f8589e;

    public h(String str, String str2, String str3, String str4, String str5) {
        this.f8585a = str;
        this.f8586b = str2;
        this.f8587c = str3;
        this.f8588d = str4;
        this.f8589e = str5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return c1.c(this.f8585a, hVar.f8585a) && c1.c(this.f8586b, hVar.f8586b) && c1.c(this.f8587c, hVar.f8587c) && c1.c(this.f8588d, hVar.f8588d) && c1.c(this.f8589e, hVar.f8589e);
    }

    public int hashCode() {
        String str = this.f8585a;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f8586b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f8587c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f8588d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f8589e;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }
}

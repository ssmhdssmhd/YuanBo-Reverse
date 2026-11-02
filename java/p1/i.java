package p1;

import android.net.Uri;
import i2.t0;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final long f8590a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8591b;

    /* renamed from: c, reason: collision with root package name */
    private final String f8592c;

    /* renamed from: d, reason: collision with root package name */
    private int f8593d;

    public i(String str, long j6, long j7) {
        this.f8592c = str == null ? "" : str;
        this.f8590a = j6;
        this.f8591b = j7;
    }

    public i a(i iVar, String str) {
        String c6 = c(str);
        if (iVar != null && c6.equals(iVar.c(str))) {
            long j6 = this.f8591b;
            if (j6 != -1) {
                long j7 = this.f8590a;
                if (j7 + j6 == iVar.f8590a) {
                    long j8 = iVar.f8591b;
                    return new i(c6, j7, j8 != -1 ? j6 + j8 : -1L);
                }
            }
            long j9 = iVar.f8591b;
            if (j9 != -1) {
                long j10 = iVar.f8590a;
                if (j10 + j9 == this.f8590a) {
                    return new i(c6, j10, j6 != -1 ? j9 + j6 : -1L);
                }
            }
        }
        return null;
    }

    public Uri b(String str) {
        return t0.e(str, this.f8592c);
    }

    public String c(String str) {
        return t0.d(str, this.f8592c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f8590a == iVar.f8590a && this.f8591b == iVar.f8591b && this.f8592c.equals(iVar.f8592c);
    }

    public int hashCode() {
        if (this.f8593d == 0) {
            this.f8593d = ((((527 + ((int) this.f8590a)) * 31) + ((int) this.f8591b)) * 31) + this.f8592c.hashCode();
        }
        return this.f8593d;
    }

    public String toString() {
        return "RangedUri(referenceUri=" + this.f8592c + ", start=" + this.f8590a + ", length=" + this.f8591b + ")";
    }
}

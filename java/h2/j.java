package h2;

import java.io.File;

/* loaded from: classes.dex */
public class j implements Comparable<j> {

    /* renamed from: a, reason: collision with root package name */
    public final String f5165a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5166b;

    /* renamed from: c, reason: collision with root package name */
    public final long f5167c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f5168d;

    /* renamed from: e, reason: collision with root package name */
    public final File f5169e;

    /* renamed from: j, reason: collision with root package name */
    public final long f5170j;

    public j(String str, long j6, long j7, long j8, File file) {
        this.f5165a = str;
        this.f5166b = j6;
        this.f5167c = j7;
        this.f5168d = file != null;
        this.f5169e = file;
        this.f5170j = j8;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(j jVar) {
        if (!this.f5165a.equals(jVar.f5165a)) {
            return this.f5165a.compareTo(jVar.f5165a);
        }
        long j6 = this.f5166b - jVar.f5166b;
        if (j6 == 0) {
            return 0;
        }
        return j6 < 0 ? -1 : 1;
    }

    public boolean b() {
        return !this.f5168d;
    }

    public boolean c() {
        return this.f5167c == -1;
    }

    public String toString() {
        return "[" + this.f5166b + ", " + this.f5167c + "]";
    }
}

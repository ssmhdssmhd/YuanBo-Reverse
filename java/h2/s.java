package h2;

import java.util.Comparator;
import java.util.TreeSet;

/* loaded from: classes.dex */
public final class s implements d {

    /* renamed from: a, reason: collision with root package name */
    private final long f5211a;

    /* renamed from: b, reason: collision with root package name */
    private final TreeSet<j> f5212b = new TreeSet<>(new Comparator() { // from class: h2.r
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int h6;
            h6 = s.h((j) obj, (j) obj2);
            return h6;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private long f5213c;

    public s(long j6) {
        this.f5211a = j6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int h(j jVar, j jVar2) {
        long j6 = jVar.f5170j;
        long j7 = jVar2.f5170j;
        return j6 - j7 == 0 ? jVar.compareTo(jVar2) : j6 < j7 ? -1 : 1;
    }

    private void i(a aVar, long j6) {
        while (this.f5213c + j6 > this.f5211a && !this.f5212b.isEmpty()) {
            aVar.b(this.f5212b.first());
        }
    }

    @Override // h2.a.b
    public void a(a aVar, j jVar, j jVar2) {
        c(aVar, jVar);
        d(aVar, jVar2);
    }

    @Override // h2.d
    public void b(a aVar, String str, long j6, long j7) {
        if (j7 != -1) {
            i(aVar, j7);
        }
    }

    @Override // h2.a.b
    public void c(a aVar, j jVar) {
        this.f5212b.remove(jVar);
        this.f5213c -= jVar.f5167c;
    }

    @Override // h2.a.b
    public void d(a aVar, j jVar) {
        this.f5212b.add(jVar);
        this.f5213c += jVar.f5167c;
        i(aVar, 0L);
    }

    @Override // h2.d
    public void e() {
    }

    @Override // h2.d
    public boolean f() {
        return true;
    }
}

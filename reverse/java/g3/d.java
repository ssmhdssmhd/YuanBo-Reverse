package g3;

import y3.j;
import y3.k;

/* loaded from: classes.dex */
public class d extends g3.a {

    /* renamed from: a, reason: collision with root package name */
    public final a f4233a;

    /* renamed from: b, reason: collision with root package name */
    final j f4234b;

    class a implements f {

        /* renamed from: a, reason: collision with root package name */
        final k.d f4235a;

        a(k.d dVar) {
            this.f4235a = dVar;
        }

        @Override // g3.f
        public void a(String str, String str2, Object obj) {
            this.f4235a.a(str, str2, obj);
        }

        @Override // g3.f
        public void b(Object obj) {
            this.f4235a.b(obj);
        }
    }

    public d(j jVar, k.d dVar) {
        this.f4234b = jVar;
        this.f4233a = new a(dVar);
    }

    @Override // g3.e
    public <T> T c(String str) {
        return (T) this.f4234b.a(str);
    }

    @Override // g3.e
    public String i() {
        return this.f4234b.f11100a;
    }

    @Override // g3.e
    public boolean j(String str) {
        return this.f4234b.c(str);
    }

    @Override // g3.a
    public f o() {
        return this.f4233a;
    }
}

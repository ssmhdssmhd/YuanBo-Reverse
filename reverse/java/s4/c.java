package s4;

import kotlin.jvm.internal.g;

/* loaded from: classes.dex */
public final class c extends s4.a {

    /* renamed from: e, reason: collision with root package name */
    public static final a f9302e = new a(null);

    /* renamed from: j, reason: collision with root package name */
    private static final c f9303j = new c(1, 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final c a() {
            return c.f9303j;
        }
    }

    public c(int i6, int i7) {
        super(i6, i7, 1);
    }

    @Override // s4.a
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (b() != cVar.b() || c() != cVar.c()) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean g(int i6) {
        return b() <= i6 && i6 <= c();
    }

    public Integer h() {
        return Integer.valueOf(c());
    }

    @Override // s4.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (b() * 31) + c();
    }

    public Integer i() {
        return Integer.valueOf(b());
    }

    @Override // s4.a
    public boolean isEmpty() {
        return b() > c();
    }

    @Override // s4.a
    public String toString() {
        return b() + ".." + c();
    }
}

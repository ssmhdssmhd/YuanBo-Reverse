package e3;

/* loaded from: classes.dex */
public final /* synthetic */ class n {

    class a implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f3661a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ o f3662b;

        a(o oVar, i iVar) {
            this.f3662b = oVar;
            this.f3661a = iVar;
        }

        @Override // e3.j
        public int a() {
            return this.f3661a.f3639c;
        }

        @Override // e3.j
        public boolean b() {
            return this.f3661a.D();
        }
    }

    public static void a(o oVar, i iVar, Runnable runnable) {
        oVar.b(new k(iVar == null ? null : new a(oVar, iVar), runnable));
    }

    public static o b(String str, int i6, int i7) {
        return i6 == 1 ? new s(str, i7) : new q(str, i6, i7);
    }
}

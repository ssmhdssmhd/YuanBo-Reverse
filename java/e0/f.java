package e0;

import androidx.lifecycle.LiveData;

/* loaded from: classes.dex */
public class f {

    /* JADX INFO: Add missing generic type declarations: [In] */
    class a<In> implements androidx.lifecycle.q<In> {

        /* renamed from: a, reason: collision with root package name */
        Out f3320a = null;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f0.a f3321b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f3322c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e.a f3323d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ androidx.lifecycle.n f3324e;

        /* renamed from: e0.f$a$a, reason: collision with other inner class name */
        class RunnableC0066a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Object f3325a;

            RunnableC0066a(Object obj) {
                this.f3325a = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v3, types: [Out, java.lang.Object] */
            @Override // java.lang.Runnable
            public void run() {
                androidx.lifecycle.n nVar;
                synchronized (a.this.f3322c) {
                    ?? apply = a.this.f3323d.apply(this.f3325a);
                    a aVar = a.this;
                    Out out = aVar.f3320a;
                    if (out == 0 && apply != 0) {
                        aVar.f3320a = apply;
                        nVar = aVar.f3324e;
                    } else if (out != 0 && !out.equals(apply)) {
                        a aVar2 = a.this;
                        aVar2.f3320a = apply;
                        nVar = aVar2.f3324e;
                    }
                    nVar.i(apply);
                }
            }
        }

        a(f0.a aVar, Object obj, e.a aVar2, androidx.lifecycle.n nVar) {
            this.f3321b = aVar;
            this.f3322c = obj;
            this.f3323d = aVar2;
            this.f3324e = nVar;
        }

        @Override // androidx.lifecycle.q
        public void a(In in) {
            this.f3321b.b(new RunnableC0066a(in));
        }
    }

    public static <In, Out> LiveData<Out> a(LiveData<In> liveData, e.a<In, Out> aVar, f0.a aVar2) {
        Object obj = new Object();
        androidx.lifecycle.n nVar = new androidx.lifecycle.n();
        nVar.l(liveData, new a(aVar2, obj, aVar, nVar));
        return nVar;
    }
}

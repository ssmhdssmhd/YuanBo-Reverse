package d0;

/* loaded from: classes.dex */
public final class o implements n {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.room.h f2849a;

    /* renamed from: b, reason: collision with root package name */
    private final n.a<m> f2850b;

    /* renamed from: c, reason: collision with root package name */
    private final n.d f2851c;

    /* renamed from: d, reason: collision with root package name */
    private final n.d f2852d;

    class a extends n.a<m> {
        a(androidx.room.h hVar) {
            super(hVar);
        }

        @Override // n.d
        public String d() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }

        @Override // n.a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(q.f fVar, m mVar) {
            String str = mVar.f2847a;
            if (str == null) {
                fVar.r(1);
            } else {
                fVar.m(1, str);
            }
            byte[] l6 = androidx.work.b.l(mVar.f2848b);
            if (l6 == null) {
                fVar.r(2);
            } else {
                fVar.O(2, l6);
            }
        }
    }

    class b extends n.d {
        b(androidx.room.h hVar) {
            super(hVar);
        }

        @Override // n.d
        public String d() {
            return "DELETE from WorkProgress where work_spec_id=?";
        }
    }

    class c extends n.d {
        c(androidx.room.h hVar) {
            super(hVar);
        }

        @Override // n.d
        public String d() {
            return "DELETE FROM WorkProgress";
        }
    }

    public o(androidx.room.h hVar) {
        this.f2849a = hVar;
        this.f2850b = new a(hVar);
        this.f2851c = new b(hVar);
        this.f2852d = new c(hVar);
    }

    @Override // d0.n
    public void a(String str) {
        this.f2849a.b();
        q.f a6 = this.f2851c.a();
        if (str == null) {
            a6.r(1);
        } else {
            a6.m(1, str);
        }
        this.f2849a.c();
        try {
            a6.o();
            this.f2849a.t();
        } finally {
            this.f2849a.g();
            this.f2851c.f(a6);
        }
    }

    @Override // d0.n
    public void b() {
        this.f2849a.b();
        q.f a6 = this.f2852d.a();
        this.f2849a.c();
        try {
            a6.o();
            this.f2849a.t();
        } finally {
            this.f2849a.g();
            this.f2852d.f(a6);
        }
    }
}

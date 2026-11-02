package w2;

import java.sql.Timestamp;
import java.util.Date;
import q2.e;
import q2.x;
import q2.y;

/* loaded from: classes.dex */
class c extends x<Timestamp> {

    /* renamed from: b, reason: collision with root package name */
    static final y f10218b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final x<Date> f10219a;

    class a implements y {
        a() {
        }

        @Override // q2.y
        public <T> x<T> a(e eVar, x2.a<T> aVar) {
            a aVar2 = null;
            if (aVar.c() == Timestamp.class) {
                return new c(eVar.k(Date.class), aVar2);
            }
            return null;
        }
    }

    private c(x<Date> xVar) {
        this.f10219a = xVar;
    }

    /* synthetic */ c(x xVar, a aVar) {
        this(xVar);
    }

    @Override // q2.x
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Timestamp b(y2.a aVar) {
        Date b6 = this.f10219a.b(aVar);
        if (b6 != null) {
            return new Timestamp(b6.getTime());
        }
        return null;
    }

    @Override // q2.x
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(y2.c cVar, Timestamp timestamp) {
        this.f10219a.d(cVar, timestamp);
    }
}

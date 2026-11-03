package d0;

import android.database.Cursor;

/* loaded from: classes.dex */
public final class f implements e {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.room.h f2832a;

    /* renamed from: b, reason: collision with root package name */
    private final n.a<d> f2833b;

    class a extends n.a<d> {
        a(androidx.room.h hVar) {
            super(hVar);
        }

        @Override // n.d
        public String d() {
            return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
        }

        @Override // n.a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(q.f fVar, d dVar) {
            String str = dVar.f2830a;
            if (str == null) {
                fVar.r(1);
            } else {
                fVar.m(1, str);
            }
            Long l6 = dVar.f2831b;
            if (l6 == null) {
                fVar.r(2);
            } else {
                fVar.H(2, l6.longValue());
            }
        }
    }

    public f(androidx.room.h hVar) {
        this.f2832a = hVar;
        this.f2833b = new a(hVar);
    }

    @Override // d0.e
    public Long a(String str) {
        n.c k6 = n.c.k("SELECT long_value FROM Preference where `key`=?", 1);
        if (str == null) {
            k6.r(1);
        } else {
            k6.m(1, str);
        }
        this.f2832a.b();
        Long l6 = null;
        Cursor b6 = p.c.b(this.f2832a, k6, false, null);
        try {
            if (b6.moveToFirst() && !b6.isNull(0)) {
                l6 = Long.valueOf(b6.getLong(0));
            }
            return l6;
        } finally {
            b6.close();
            k6.t();
        }
    }

    @Override // d0.e
    public void b(d dVar) {
        this.f2832a.b();
        this.f2832a.c();
        try {
            this.f2833b.h(dVar);
            this.f2832a.t();
        } finally {
            this.f2832a.g();
        }
    }
}

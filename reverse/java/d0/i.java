package d0;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class i implements h {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.room.h f2837a;

    /* renamed from: b, reason: collision with root package name */
    private final n.a<g> f2838b;

    /* renamed from: c, reason: collision with root package name */
    private final n.d f2839c;

    class a extends n.a<g> {
        a(androidx.room.h hVar) {
            super(hVar);
        }

        @Override // n.d
        public String d() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
        }

        @Override // n.a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(q.f fVar, g gVar) {
            String str = gVar.f2835a;
            if (str == null) {
                fVar.r(1);
            } else {
                fVar.m(1, str);
            }
            fVar.H(2, gVar.f2836b);
        }
    }

    class b extends n.d {
        b(androidx.room.h hVar) {
            super(hVar);
        }

        @Override // n.d
        public String d() {
            return "DELETE FROM SystemIdInfo where work_spec_id=?";
        }
    }

    public i(androidx.room.h hVar) {
        this.f2837a = hVar;
        this.f2838b = new a(hVar);
        this.f2839c = new b(hVar);
    }

    @Override // d0.h
    public List<String> a() {
        n.c k6 = n.c.k("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
        this.f2837a.b();
        Cursor b6 = p.c.b(this.f2837a, k6, false, null);
        try {
            ArrayList arrayList = new ArrayList(b6.getCount());
            while (b6.moveToNext()) {
                arrayList.add(b6.getString(0));
            }
            return arrayList;
        } finally {
            b6.close();
            k6.t();
        }
    }

    @Override // d0.h
    public g b(String str) {
        n.c k6 = n.c.k("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            k6.r(1);
        } else {
            k6.m(1, str);
        }
        this.f2837a.b();
        Cursor b6 = p.c.b(this.f2837a, k6, false, null);
        try {
            return b6.moveToFirst() ? new g(b6.getString(p.b.c(b6, "work_spec_id")), b6.getInt(p.b.c(b6, "system_id"))) : null;
        } finally {
            b6.close();
            k6.t();
        }
    }

    @Override // d0.h
    public void c(g gVar) {
        this.f2837a.b();
        this.f2837a.c();
        try {
            this.f2838b.h(gVar);
            this.f2837a.t();
        } finally {
            this.f2837a.g();
        }
    }

    @Override // d0.h
    public void d(String str) {
        this.f2837a.b();
        q.f a6 = this.f2839c.a();
        if (str == null) {
            a6.r(1);
        } else {
            a6.m(1, str);
        }
        this.f2837a.c();
        try {
            a6.o();
            this.f2837a.t();
        } finally {
            this.f2837a.g();
            this.f2839c.f(a6);
        }
    }
}

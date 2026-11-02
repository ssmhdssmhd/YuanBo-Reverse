package d0;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class l implements k {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.room.h f2844a;

    /* renamed from: b, reason: collision with root package name */
    private final n.a<j> f2845b;

    class a extends n.a<j> {
        a(androidx.room.h hVar) {
            super(hVar);
        }

        @Override // n.d
        public String d() {
            return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
        }

        @Override // n.a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(q.f fVar, j jVar) {
            String str = jVar.f2842a;
            if (str == null) {
                fVar.r(1);
            } else {
                fVar.m(1, str);
            }
            String str2 = jVar.f2843b;
            if (str2 == null) {
                fVar.r(2);
            } else {
                fVar.m(2, str2);
            }
        }
    }

    public l(androidx.room.h hVar) {
        this.f2844a = hVar;
        this.f2845b = new a(hVar);
    }

    @Override // d0.k
    public void a(j jVar) {
        this.f2844a.b();
        this.f2844a.c();
        try {
            this.f2845b.h(jVar);
            this.f2844a.t();
        } finally {
            this.f2844a.g();
        }
    }

    @Override // d0.k
    public List<String> b(String str) {
        n.c k6 = n.c.k("SELECT name FROM workname WHERE work_spec_id=?", 1);
        if (str == null) {
            k6.r(1);
        } else {
            k6.m(1, str);
        }
        this.f2844a.b();
        Cursor b6 = p.c.b(this.f2844a, k6, false, null);
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
}

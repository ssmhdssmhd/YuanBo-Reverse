package d0;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.room.h f2827a;

    /* renamed from: b, reason: collision with root package name */
    private final n.a<d0.a> f2828b;

    class a extends n.a<d0.a> {
        a(androidx.room.h hVar) {
            super(hVar);
        }

        @Override // n.d
        public String d() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }

        @Override // n.a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(q.f fVar, d0.a aVar) {
            String str = aVar.f2825a;
            if (str == null) {
                fVar.r(1);
            } else {
                fVar.m(1, str);
            }
            String str2 = aVar.f2826b;
            if (str2 == null) {
                fVar.r(2);
            } else {
                fVar.m(2, str2);
            }
        }
    }

    public c(androidx.room.h hVar) {
        this.f2827a = hVar;
        this.f2828b = new a(hVar);
    }

    @Override // d0.b
    public void a(d0.a aVar) {
        this.f2827a.b();
        this.f2827a.c();
        try {
            this.f2828b.h(aVar);
            this.f2827a.t();
        } finally {
            this.f2827a.g();
        }
    }

    @Override // d0.b
    public boolean b(String str) {
        n.c k6 = n.c.k("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            k6.r(1);
        } else {
            k6.m(1, str);
        }
        this.f2827a.b();
        boolean z5 = false;
        Cursor b6 = p.c.b(this.f2827a, k6, false, null);
        try {
            if (b6.moveToFirst()) {
                z5 = b6.getInt(0) != 0;
            }
            return z5;
        } finally {
            b6.close();
            k6.t();
        }
    }

    @Override // d0.b
    public boolean c(String str) {
        n.c k6 = n.c.k("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            k6.r(1);
        } else {
            k6.m(1, str);
        }
        this.f2827a.b();
        boolean z5 = false;
        Cursor b6 = p.c.b(this.f2827a, k6, false, null);
        try {
            if (b6.moveToFirst()) {
                z5 = b6.getInt(0) != 0;
            }
            return z5;
        } finally {
            b6.close();
            k6.t();
        }
    }

    @Override // d0.b
    public List<String> d(String str) {
        n.c k6 = n.c.k("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            k6.r(1);
        } else {
            k6.m(1, str);
        }
        this.f2827a.b();
        Cursor b6 = p.c.b(this.f2827a, k6, false, null);
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

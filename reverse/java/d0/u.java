package d0;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class u implements t {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.room.h f2907a;

    /* renamed from: b, reason: collision with root package name */
    private final n.a<s> f2908b;

    class a extends n.a<s> {
        a(androidx.room.h hVar) {
            super(hVar);
        }

        @Override // n.d
        public String d() {
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }

        @Override // n.a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(q.f fVar, s sVar) {
            String str = sVar.f2905a;
            if (str == null) {
                fVar.r(1);
            } else {
                fVar.m(1, str);
            }
            String str2 = sVar.f2906b;
            if (str2 == null) {
                fVar.r(2);
            } else {
                fVar.m(2, str2);
            }
        }
    }

    public u(androidx.room.h hVar) {
        this.f2907a = hVar;
        this.f2908b = new a(hVar);
    }

    @Override // d0.t
    public void a(s sVar) {
        this.f2907a.b();
        this.f2907a.c();
        try {
            this.f2908b.h(sVar);
            this.f2907a.t();
        } finally {
            this.f2907a.g();
        }
    }

    @Override // d0.t
    public List<String> b(String str) {
        n.c k6 = n.c.k("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (str == null) {
            k6.r(1);
        } else {
            k6.m(1, str);
        }
        this.f2907a.b();
        Cursor b6 = p.c.b(this.f2907a, k6, false, null);
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

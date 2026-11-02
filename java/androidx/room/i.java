package androidx.room;

import android.database.Cursor;
import java.util.Iterator;
import java.util.List;
import q.c;

/* loaded from: classes.dex */
public class i extends c.a {

    /* renamed from: b, reason: collision with root package name */
    private androidx.room.a f1393b;

    /* renamed from: c, reason: collision with root package name */
    private final a f1394c;

    /* renamed from: d, reason: collision with root package name */
    private final String f1395d;

    /* renamed from: e, reason: collision with root package name */
    private final String f1396e;

    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f1397a;

        public a(int i6) {
            this.f1397a = i6;
        }

        protected abstract void a(q.b bVar);

        protected abstract void b(q.b bVar);

        protected abstract void c(q.b bVar);

        protected abstract void d(q.b bVar);

        protected abstract void e(q.b bVar);

        protected abstract void f(q.b bVar);

        protected abstract b g(q.b bVar);
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f1398a;

        /* renamed from: b, reason: collision with root package name */
        public final String f1399b;

        public b(boolean z5, String str) {
            this.f1398a = z5;
            this.f1399b = str;
        }
    }

    public i(androidx.room.a aVar, a aVar2, String str, String str2) {
        super(aVar2.f1397a);
        this.f1393b = aVar;
        this.f1394c = aVar2;
        this.f1395d = str;
        this.f1396e = str2;
    }

    private void h(q.b bVar) {
        if (!k(bVar)) {
            b g6 = this.f1394c.g(bVar);
            if (g6.f1398a) {
                this.f1394c.e(bVar);
                l(bVar);
                return;
            } else {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + g6.f1399b);
            }
        }
        Cursor N = bVar.N(new q.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
        try {
            String string = N.moveToFirst() ? N.getString(0) : null;
            N.close();
            if (!this.f1395d.equals(string) && !this.f1396e.equals(string)) {
                throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
            }
        } catch (Throwable th) {
            N.close();
            throw th;
        }
    }

    private void i(q.b bVar) {
        bVar.l("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private static boolean j(q.b bVar) {
        Cursor S = bVar.S("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z5 = false;
            if (S.moveToFirst()) {
                if (S.getInt(0) == 0) {
                    z5 = true;
                }
            }
            return z5;
        } finally {
            S.close();
        }
    }

    private static boolean k(q.b bVar) {
        Cursor S = bVar.S("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z5 = false;
            if (S.moveToFirst()) {
                if (S.getInt(0) != 0) {
                    z5 = true;
                }
            }
            return z5;
        } finally {
            S.close();
        }
    }

    private void l(q.b bVar) {
        i(bVar);
        bVar.l(n.b.a(this.f1395d));
    }

    @Override // q.c.a
    public void b(q.b bVar) {
        super.b(bVar);
    }

    @Override // q.c.a
    public void d(q.b bVar) {
        boolean j6 = j(bVar);
        this.f1394c.a(bVar);
        if (!j6) {
            b g6 = this.f1394c.g(bVar);
            if (!g6.f1398a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + g6.f1399b);
            }
        }
        l(bVar);
        this.f1394c.c(bVar);
    }

    @Override // q.c.a
    public void e(q.b bVar, int i6, int i7) {
        g(bVar, i6, i7);
    }

    @Override // q.c.a
    public void f(q.b bVar) {
        super.f(bVar);
        h(bVar);
        this.f1394c.d(bVar);
        this.f1393b = null;
    }

    @Override // q.c.a
    public void g(q.b bVar, int i6, int i7) {
        boolean z5;
        List<o.a> c6;
        androidx.room.a aVar = this.f1393b;
        if (aVar == null || (c6 = aVar.f1297d.c(i6, i7)) == null) {
            z5 = false;
        } else {
            this.f1394c.f(bVar);
            Iterator<o.a> it = c6.iterator();
            while (it.hasNext()) {
                it.next().a(bVar);
            }
            b g6 = this.f1394c.g(bVar);
            if (!g6.f1398a) {
                throw new IllegalStateException("Migration didn't properly handle: " + g6.f1399b);
            }
            this.f1394c.e(bVar);
            l(bVar);
            z5 = true;
        }
        if (z5) {
            return;
        }
        androidx.room.a aVar2 = this.f1393b;
        if (aVar2 != null && !aVar2.a(i6, i7)) {
            this.f1394c.b(bVar);
            this.f1394c.a(bVar);
            return;
        }
        throw new IllegalStateException("A migration from " + i6 + " to " + i7 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }
}

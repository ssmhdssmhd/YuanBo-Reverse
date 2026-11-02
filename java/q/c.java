package q;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public interface c extends Closeable {

    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f8655a;

        public a(int i6) {
            this.f8655a = i6;
        }

        private void a(String str) {
            if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
                return;
            }
            Log.w("SupportSQLite", "deleting the database file: " + str);
            try {
                SQLiteDatabase.deleteDatabase(new File(str));
            } catch (Exception e6) {
                Log.w("SupportSQLite", "delete failed: ", e6);
            }
        }

        public void b(q.b bVar) {
        }

        public void c(q.b bVar) {
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + bVar.z());
            if (!bVar.isOpen()) {
                a(bVar.z());
                return;
            }
            List<Pair<String, String>> list = null;
            try {
                try {
                    list = bVar.h();
                } catch (SQLiteException unused) {
                }
                try {
                    bVar.close();
                } catch (IOException unused2) {
                }
            } finally {
                if (list != null) {
                    Iterator<Pair<String, String>> it = list.iterator();
                    while (it.hasNext()) {
                        a((String) it.next().second);
                    }
                } else {
                    a(bVar.z());
                }
            }
        }

        public abstract void d(q.b bVar);

        public abstract void e(q.b bVar, int i6, int i7);

        public void f(q.b bVar) {
        }

        public abstract void g(q.b bVar, int i6, int i7);
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Context f8656a;

        /* renamed from: b, reason: collision with root package name */
        public final String f8657b;

        /* renamed from: c, reason: collision with root package name */
        public final a f8658c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f8659d;

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            Context f8660a;

            /* renamed from: b, reason: collision with root package name */
            String f8661b;

            /* renamed from: c, reason: collision with root package name */
            a f8662c;

            /* renamed from: d, reason: collision with root package name */
            boolean f8663d;

            a(Context context) {
                this.f8660a = context;
            }

            public b a() {
                if (this.f8662c == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                }
                if (this.f8660a == null) {
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                }
                if (this.f8663d && TextUtils.isEmpty(this.f8661b)) {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
                return new b(this.f8660a, this.f8661b, this.f8662c, this.f8663d);
            }

            public a b(a aVar) {
                this.f8662c = aVar;
                return this;
            }

            public a c(String str) {
                this.f8661b = str;
                return this;
            }

            public a d(boolean z5) {
                this.f8663d = z5;
                return this;
            }
        }

        b(Context context, String str, a aVar, boolean z5) {
            this.f8656a = context;
            this.f8657b = str;
            this.f8658c = aVar;
            this.f8659d = z5;
        }

        public static a a(Context context) {
            return new a(context);
        }
    }

    /* renamed from: q.c$c, reason: collision with other inner class name */
    public interface InterfaceC0129c {
        c a(b bVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    q.b getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean z5);
}

package r;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import java.io.File;
import q.c;

/* loaded from: classes.dex */
class b implements q.c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f9012a;

    /* renamed from: b, reason: collision with root package name */
    private final String f9013b;

    /* renamed from: c, reason: collision with root package name */
    private final c.a f9014c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f9015d;

    /* renamed from: e, reason: collision with root package name */
    private final Object f9016e = new Object();

    /* renamed from: j, reason: collision with root package name */
    private a f9017j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f9018k;

    static class a extends SQLiteOpenHelper {

        /* renamed from: a, reason: collision with root package name */
        final r.a[] f9019a;

        /* renamed from: b, reason: collision with root package name */
        final c.a f9020b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f9021c;

        /* renamed from: r.b$a$a, reason: collision with other inner class name */
        class C0136a implements DatabaseErrorHandler {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ c.a f9022a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ r.a[] f9023b;

            C0136a(c.a aVar, r.a[] aVarArr) {
                this.f9022a = aVar;
                this.f9023b = aVarArr;
            }

            @Override // android.database.DatabaseErrorHandler
            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                this.f9022a.c(a.j(this.f9023b, sQLiteDatabase));
            }
        }

        a(Context context, String str, r.a[] aVarArr, c.a aVar) {
            super(context, str, null, aVar.f8655a, new C0136a(aVar, aVarArr));
            this.f9020b = aVar;
            this.f9019a = aVarArr;
        }

        static r.a j(r.a[] aVarArr, SQLiteDatabase sQLiteDatabase) {
            r.a aVar = aVarArr[0];
            if (aVar == null || !aVar.a(sQLiteDatabase)) {
                aVarArr[0] = new r.a(sQLiteDatabase);
            }
            return aVarArr[0];
        }

        r.a a(SQLiteDatabase sQLiteDatabase) {
            return j(this.f9019a, sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.f9019a[0] = null;
        }

        synchronized q.b k() {
            this.f9021c = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (!this.f9021c) {
                return a(writableDatabase);
            }
            close();
            return k();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f9020b.b(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f9020b.d(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
            this.f9021c = true;
            this.f9020b.e(a(sQLiteDatabase), i6, i7);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (this.f9021c) {
                return;
            }
            this.f9020b.f(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
            this.f9021c = true;
            this.f9020b.g(a(sQLiteDatabase), i6, i7);
        }
    }

    b(Context context, String str, c.a aVar, boolean z5) {
        this.f9012a = context;
        this.f9013b = str;
        this.f9014c = aVar;
        this.f9015d = z5;
    }

    private a a() {
        a aVar;
        synchronized (this.f9016e) {
            if (this.f9017j == null) {
                r.a[] aVarArr = new r.a[1];
                if (Build.VERSION.SDK_INT < 23 || this.f9013b == null || !this.f9015d) {
                    this.f9017j = new a(this.f9012a, this.f9013b, aVarArr, this.f9014c);
                } else {
                    this.f9017j = new a(this.f9012a, new File(this.f9012a.getNoBackupFilesDir(), this.f9013b).getAbsolutePath(), aVarArr, this.f9014c);
                }
                this.f9017j.setWriteAheadLoggingEnabled(this.f9018k);
            }
            aVar = this.f9017j;
        }
        return aVar;
    }

    @Override // q.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a().close();
    }

    @Override // q.c
    public String getDatabaseName() {
        return this.f9013b;
    }

    @Override // q.c
    public q.b getWritableDatabase() {
        return a().k();
    }

    @Override // q.c
    public void setWriteAheadLoggingEnabled(boolean z5) {
        synchronized (this.f9016e) {
            a aVar = this.f9017j;
            if (aVar != null) {
                aVar.setWriteAheadLoggingEnabled(z5);
            }
            this.f9018k = z5;
        }
    }
}

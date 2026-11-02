package r;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.CancellationSignal;
import android.util.Pair;
import java.util.List;
import q.f;

/* loaded from: classes.dex */
class a implements q.b {

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f9005b = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f9006c = new String[0];

    /* renamed from: a, reason: collision with root package name */
    private final SQLiteDatabase f9007a;

    /* renamed from: r.a$a, reason: collision with other inner class name */
    class C0135a implements SQLiteDatabase.CursorFactory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q.e f9008a;

        C0135a(q.e eVar) {
            this.f9008a = eVar;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.f9008a.a(new d(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    class b implements SQLiteDatabase.CursorFactory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q.e f9010a;

        b(q.e eVar) {
            this.f9010a = eVar;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.f9010a.a(new d(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    a(SQLiteDatabase sQLiteDatabase) {
        this.f9007a = sQLiteDatabase;
    }

    @Override // q.b
    public boolean B() {
        return this.f9007a.inTransaction();
    }

    @Override // q.b
    public void J() {
        this.f9007a.setTransactionSuccessful();
    }

    @Override // q.b
    public void L(String str, Object[] objArr) {
        this.f9007a.execSQL(str, objArr);
    }

    @Override // q.b
    public Cursor N(q.e eVar) {
        return this.f9007a.rawQueryWithFactory(new C0135a(eVar), eVar.j(), f9006c, null);
    }

    @Override // q.b
    public Cursor S(String str) {
        return N(new q.a(str));
    }

    boolean a(SQLiteDatabase sQLiteDatabase) {
        return this.f9007a == sQLiteDatabase;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f9007a.close();
    }

    @Override // q.b
    public void e() {
        this.f9007a.endTransaction();
    }

    @Override // q.b
    public void f() {
        this.f9007a.beginTransaction();
    }

    @Override // q.b
    public List<Pair<String, String>> h() {
        return this.f9007a.getAttachedDbs();
    }

    @Override // q.b
    public boolean isOpen() {
        return this.f9007a.isOpen();
    }

    @Override // q.b
    public void l(String str) {
        this.f9007a.execSQL(str);
    }

    @Override // q.b
    public Cursor n(q.e eVar, CancellationSignal cancellationSignal) {
        return this.f9007a.rawQueryWithFactory(new b(eVar), eVar.j(), f9006c, null, cancellationSignal);
    }

    @Override // q.b
    public f p(String str) {
        return new e(this.f9007a.compileStatement(str));
    }

    @Override // q.b
    public String z() {
        return this.f9007a.getPath();
    }
}

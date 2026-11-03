package r;

import android.database.sqlite.SQLiteProgram;

/* loaded from: classes.dex */
class d implements q.d {

    /* renamed from: a, reason: collision with root package name */
    private final SQLiteProgram f9024a;

    d(SQLiteProgram sQLiteProgram) {
        this.f9024a = sQLiteProgram;
    }

    @Override // q.d
    public void H(int i6, long j6) {
        this.f9024a.bindLong(i6, j6);
    }

    @Override // q.d
    public void O(int i6, byte[] bArr) {
        this.f9024a.bindBlob(i6, bArr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f9024a.close();
    }

    @Override // q.d
    public void m(int i6, String str) {
        this.f9024a.bindString(i6, str);
    }

    @Override // q.d
    public void r(int i6) {
        this.f9024a.bindNull(i6);
    }

    @Override // q.d
    public void w(int i6, double d6) {
        this.f9024a.bindDouble(i6, d6);
    }
}

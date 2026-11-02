package r;

import android.database.sqlite.SQLiteStatement;
import q.f;

/* loaded from: classes.dex */
class e extends d implements f {

    /* renamed from: b, reason: collision with root package name */
    private final SQLiteStatement f9025b;

    e(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f9025b = sQLiteStatement;
    }

    @Override // q.f
    public long R() {
        return this.f9025b.executeInsert();
    }

    @Override // q.f
    public int o() {
        return this.f9025b.executeUpdateDelete();
    }
}

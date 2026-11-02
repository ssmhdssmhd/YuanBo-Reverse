package h2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.tendcloud.tenddata.cs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
final class f {

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f5161c = {"name", cs.a.LENGTH, "last_touch_timestamp"};

    /* renamed from: a, reason: collision with root package name */
    private final k0.b f5162a;

    /* renamed from: b, reason: collision with root package name */
    private String f5163b;

    public f(k0.b bVar) {
        this.f5162a = bVar;
    }

    private static void a(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
    }

    private Cursor c() {
        i2.a.e(this.f5163b);
        return this.f5162a.getReadableDatabase().query(this.f5163b, f5161c, null, null, null, null, null);
    }

    private static String d(String str) {
        return "ExoPlayerCacheFileMetadata" + str;
    }

    public Map<String, e> b() {
        try {
            Cursor c6 = c();
            try {
                HashMap hashMap = new HashMap(c6.getCount());
                while (c6.moveToNext()) {
                    hashMap.put((String) i2.a.e(c6.getString(0)), new e(c6.getLong(1), c6.getLong(2)));
                }
                c6.close();
                return hashMap;
            } finally {
            }
        } catch (SQLException e6) {
            throw new k0.a(e6);
        }
    }

    public void e(long j6) {
        try {
            String hexString = Long.toHexString(j6);
            this.f5163b = d(hexString);
            if (k0.e.b(this.f5162a.getReadableDatabase(), 2, hexString) != 1) {
                SQLiteDatabase writableDatabase = this.f5162a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    k0.e.d(writableDatabase, 2, hexString, 1);
                    a(writableDatabase, this.f5163b);
                    writableDatabase.execSQL("CREATE TABLE " + this.f5163b + " (name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
        } catch (SQLException e6) {
            throw new k0.a(e6);
        }
    }

    public void f(String str) {
        i2.a.e(this.f5163b);
        try {
            this.f5162a.getWritableDatabase().delete(this.f5163b, "name = ?", new String[]{str});
        } catch (SQLException e6) {
            throw new k0.a(e6);
        }
    }

    public void g(Set<String> set) {
        i2.a.e(this.f5163b);
        try {
            SQLiteDatabase writableDatabase = this.f5162a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    writableDatabase.delete(this.f5163b, "name = ?", new String[]{it.next()});
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e6) {
            throw new k0.a(e6);
        }
    }

    public void h(String str, long j6, long j7) {
        i2.a.e(this.f5163b);
        try {
            SQLiteDatabase writableDatabase = this.f5162a.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put(cs.a.LENGTH, Long.valueOf(j6));
            contentValues.put("last_touch_timestamp", Long.valueOf(j7));
            writableDatabase.replaceOrThrow(this.f5163b, null, contentValues);
        } catch (SQLException e6) {
            throw new k0.a(e6);
        }
    }
}

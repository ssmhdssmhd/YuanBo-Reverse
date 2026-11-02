package e3;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import y3.k;

/* loaded from: classes.dex */
class i {

    /* renamed from: n, reason: collision with root package name */
    private static Boolean f3636n;

    /* renamed from: a, reason: collision with root package name */
    final boolean f3637a;

    /* renamed from: b, reason: collision with root package name */
    final String f3638b;

    /* renamed from: c, reason: collision with root package name */
    final int f3639c;

    /* renamed from: d, reason: collision with root package name */
    final int f3640d;

    /* renamed from: e, reason: collision with root package name */
    final Context f3641e;

    /* renamed from: h, reason: collision with root package name */
    public o f3644h;

    /* renamed from: i, reason: collision with root package name */
    SQLiteDatabase f3645i;

    /* renamed from: l, reason: collision with root package name */
    private Integer f3648l;

    /* renamed from: f, reason: collision with root package name */
    final List<g3.g> f3642f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    final Map<Integer, t> f3643g = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    private int f3646j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f3647k = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f3649m = 0;

    class a implements DatabaseErrorHandler {
        a() {
        }

        @Override // android.database.DatabaseErrorHandler
        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
        }
    }

    i(Context context, String str, int i6, boolean z5, int i7) {
        this.f3641e = context;
        this.f3638b = str;
        this.f3637a = z5;
        this.f3639c = i6;
        this.f3640d = i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Cursor E(d0 d0Var, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        d0Var.a(sQLiteQuery);
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(g3.e eVar) {
        Boolean f6 = eVar.f();
        boolean z5 = Boolean.TRUE.equals(f6) && eVar.h();
        if (z5) {
            int i6 = this.f3647k + 1;
            this.f3647k = i6;
            this.f3648l = Integer.valueOf(i6);
        }
        if (!v(eVar)) {
            if (z5) {
                this.f3648l = null;
            }
        } else if (z5) {
            HashMap hashMap = new HashMap();
            hashMap.put("transactionId", this.f3648l);
            eVar.b(hashMap);
        } else {
            if (Boolean.FALSE.equals(f6)) {
                this.f3648l = null;
            }
            eVar.b(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        while (!this.f3642f.isEmpty() && this.f3648l == null) {
            this.f3642f.get(0).a();
            this.f3642f.remove(0);
        }
    }

    private void Q(g3.e eVar, Runnable runnable) {
        Integer g6 = eVar.g();
        Integer num = this.f3648l;
        if (num == null) {
            runnable.run();
            return;
        }
        if (g6 == null || !(g6.equals(num) || g6.intValue() == -1)) {
            this.f3642f.add(new g3.g(eVar, runnable));
            return;
        }
        runnable.run();
        if (this.f3648l != null || this.f3642f.isEmpty()) {
            return;
        }
        this.f3644h.a(this, new Runnable() { // from class: e3.h
            @Override // java.lang.Runnable
            public final void run() {
                i.this.O();
            }
        });
    }

    protected static boolean i(Context context) {
        try {
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("com.tekartik.sqflite.wal_enabled", false);
    }

    private void k(int i6) {
        t tVar = this.f3643g.get(Integer.valueOf(i6));
        if (tVar != null) {
            l(tVar);
        }
    }

    private void l(t tVar) {
        try {
            int i6 = tVar.f3676a;
            if (r.c(this.f3640d)) {
                Log.d("Sqflite", y() + "closing cursor " + i6);
            }
            this.f3643g.remove(Integer.valueOf(i6));
            tVar.f3678c.close();
        } catch (Exception unused) {
        }
    }

    private Map<String, Object> m(Cursor cursor, Integer num) {
        HashMap hashMap = null;
        ArrayList arrayList = null;
        int i6 = 0;
        while (cursor.moveToNext()) {
            if (hashMap == null) {
                ArrayList arrayList2 = new ArrayList();
                HashMap hashMap2 = new HashMap();
                i6 = cursor.getColumnCount();
                hashMap2.put("columns", Arrays.asList(cursor.getColumnNames()));
                hashMap2.put("rows", arrayList2);
                arrayList = arrayList2;
                hashMap = hashMap2;
            }
            arrayList.add(e0.a(cursor, i6));
            if (num != null && arrayList.size() >= num.intValue()) {
                break;
            }
        }
        return hashMap == null ? new HashMap() : hashMap;
    }

    static void n(String str) {
        SQLiteDatabase.deleteDatabase(new File(str));
    }

    private boolean o(g3.e eVar) {
        if (!v(eVar)) {
            return false;
        }
        eVar.b(null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cf  */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean G(g3.e r10) {
        /*
            r9 = this;
            boolean r0 = r9.v(r10)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            boolean r0 = r10.e()
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L14
            r10.b(r2)
            return r3
        L14:
            java.lang.String r0 = "SELECT changes(), last_insert_rowid()"
            android.database.sqlite.SQLiteDatabase r4 = r9.A()     // Catch: java.lang.Throwable -> Lbc java.lang.Exception -> Lbe
            android.database.Cursor r0 = r4.rawQuery(r0, r2)     // Catch: java.lang.Throwable -> Lbc java.lang.Exception -> Lbe
            java.lang.String r4 = "Sqflite"
            if (r0 == 0) goto L9b
            int r5 = r0.getCount()     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            if (r5 <= 0) goto L9b
            boolean r5 = r0.moveToFirst()     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            if (r5 == 0) goto L9b
            int r5 = r0.getInt(r1)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            if (r5 != 0) goto L67
            int r5 = r9.f3640d     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            boolean r5 = e3.r.b(r5)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            if (r5 == 0) goto L60
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r5.<init>()     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            java.lang.String r6 = r9.y()     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r5.append(r6)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            java.lang.String r6 = "no changes (id was "
            r5.append(r6)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            long r6 = r0.getLong(r3)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r5.append(r6)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            android.util.Log.d(r4, r5)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
        L60:
            r10.b(r2)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r0.close()
            return r3
        L67:
            long r5 = r0.getLong(r3)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            int r2 = r9.f3640d     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            boolean r2 = e3.r.b(r2)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            if (r2 == 0) goto L8e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r2.<init>()     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            java.lang.String r7 = r9.y()     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r2.append(r7)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            java.lang.String r7 = "inserted "
            r2.append(r7)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r2.append(r5)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            android.util.Log.d(r4, r2)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
        L8e:
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r10.b(r2)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r0.close()
            return r3
        L99:
            r2 = move-exception
            goto Lc2
        L9b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r5.<init>()     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            java.lang.String r6 = r9.y()     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r5.append(r6)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            java.lang.String r6 = "fail to read changes for Insert"
            r5.append(r6)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            android.util.Log.e(r4, r5)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            r10.b(r2)     // Catch: java.lang.Exception -> L99 java.lang.Throwable -> Lcb
            if (r0 == 0) goto Lbb
            r0.close()
        Lbb:
            return r3
        Lbc:
            r10 = move-exception
            goto Lcd
        Lbe:
            r0 = move-exception
            r8 = r2
            r2 = r0
            r0 = r8
        Lc2:
            r9.B(r2, r10)     // Catch: java.lang.Throwable -> Lcb
            if (r0 == 0) goto Lca
            r0.close()
        Lca:
            return r1
        Lcb:
            r10 = move-exception
            r2 = r0
        Lcd:
            if (r2 == 0) goto Ld2
            r2.close()
        Ld2:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.i.G(g3.e):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [g3.e, g3.f] */
    /* JADX WARN: Type inference failed for: r1v0, types: [e3.d0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v0, types: [e3.i] */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public boolean H(g3.e eVar) {
        Integer num = (Integer) eVar.c("cursorPageSize");
        final ?? d6 = eVar.d();
        if (r.b(this.f3640d)) {
            Log.d("Sqflite", y() + d6);
        }
        t tVar = null;
        try {
            try {
                d6 = x().rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: e3.f
                    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
                    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                        Cursor E;
                        E = i.E(d0.this, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
                        return E;
                    }
                }, d6.c(), e3.a.f3596a, null);
                try {
                    Map<String, Object> m6 = m(d6, num);
                    if ((num == null || d6.isLast() || d6.isAfterLast()) ? false : true) {
                        int i6 = this.f3649m + 1;
                        this.f3649m = i6;
                        m6.put("cursorId", Integer.valueOf(i6));
                        t tVar2 = new t(i6, num.intValue(), d6);
                        try {
                            this.f3643g.put(Integer.valueOf(i6), tVar2);
                            tVar = tVar2;
                        } catch (Exception e6) {
                            e = e6;
                            tVar = tVar2;
                            B(e, eVar);
                            if (tVar != null) {
                                l(tVar);
                            }
                            if (tVar == null && d6 != 0) {
                                d6.close();
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            tVar = tVar2;
                            if (tVar == null && d6 != 0) {
                                d6.close();
                            }
                            throw th;
                        }
                    }
                    eVar.b(m6);
                    if (tVar == null && d6 != 0) {
                        d6.close();
                    }
                    return true;
                } catch (Exception e7) {
                    e = e7;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e8) {
            e = e8;
            d6 = 0;
        } catch (Throwable th3) {
            th = th3;
            d6 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public boolean I(g3.e eVar) {
        boolean z5;
        int intValue = ((Integer) eVar.c("cursorId")).intValue();
        boolean equals = Boolean.TRUE.equals(eVar.c("cancel"));
        if (r.c(this.f3640d)) {
            StringBuilder sb = new StringBuilder();
            sb.append(y());
            sb.append("cursor ");
            sb.append(intValue);
            sb.append(equals ? " cancel" : " next");
            Log.d("Sqflite", sb.toString());
        }
        t tVar = null;
        if (equals) {
            k(intValue);
            eVar.b(null);
            return true;
        }
        t tVar2 = this.f3643g.get(Integer.valueOf(intValue));
        boolean z6 = false;
        try {
            if (tVar2 == null) {
                throw new IllegalStateException("Cursor " + intValue + " not found");
            }
            Cursor cursor = tVar2.f3678c;
            Map<String, Object> m6 = m(cursor, Integer.valueOf(tVar2.f3677b));
            z5 = (cursor.isLast() || cursor.isAfterLast()) ? false : true;
            if (z5) {
                try {
                    try {
                        m6.put("cursorId", Integer.valueOf(intValue));
                    } catch (Exception e6) {
                        e = e6;
                        B(e, eVar);
                        if (tVar2 != null) {
                            l(tVar2);
                        } else {
                            tVar = tVar2;
                        }
                        if (!z5 && tVar != null) {
                            l(tVar);
                        }
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    z6 = z5;
                    if (!z6 && tVar2 != null) {
                        l(tVar2);
                    }
                    throw th;
                }
            }
            eVar.b(m6);
            if (!z5) {
                l(tVar2);
            }
            return true;
        } catch (Exception e7) {
            e = e7;
            z5 = false;
        } catch (Throwable th2) {
            th = th2;
            if (!z6) {
                l(tVar2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public boolean J(g3.e eVar) {
        if (!v(eVar)) {
            return false;
        }
        Cursor cursor = null;
        if (eVar.e()) {
            eVar.b(null);
            return true;
        }
        try {
            try {
                Cursor rawQuery = A().rawQuery("SELECT changes()", null);
                if (rawQuery != null) {
                    try {
                        if (rawQuery.getCount() > 0 && rawQuery.moveToFirst()) {
                            int i6 = rawQuery.getInt(0);
                            if (r.b(this.f3640d)) {
                                Log.d("Sqflite", y() + "changed " + i6);
                            }
                            eVar.b(Integer.valueOf(i6));
                            rawQuery.close();
                            return true;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        cursor = rawQuery;
                        B(e, eVar);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        cursor = rawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                Log.e("Sqflite", y() + "fail to read changes for Update/Delete");
                eVar.b(null);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return true;
            } catch (Exception e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean v(g3.e eVar) {
        d0 d6 = eVar.d();
        if (r.b(this.f3640d)) {
            Log.d("Sqflite", y() + d6);
        }
        Boolean f6 = eVar.f();
        try {
            A().execSQL(d6.c(), d6.d());
            t(f6);
            return true;
        } catch (Exception e6) {
            B(e6, eVar);
            return false;
        }
    }

    public static boolean w(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public SQLiteDatabase A() {
        return this.f3645i;
    }

    void B(Exception exc, g3.e eVar) {
        String message;
        Map<String, Object> a6;
        if (exc instanceof SQLiteCantOpenDatabaseException) {
            message = "open_failed " + this.f3638b;
            a6 = null;
        } else {
            boolean z5 = exc instanceof SQLException;
            message = exc.getMessage();
            a6 = g3.h.a(eVar);
        }
        eVar.a("sqlite_error", message, a6);
    }

    public void C(final g3.e eVar) {
        Q(eVar, new Runnable() { // from class: e3.d
            @Override // java.lang.Runnable
            public final void run() {
                i.this.G(eVar);
            }
        });
    }

    synchronized boolean D() {
        return this.f3646j > 0;
    }

    public void K() {
        if (f3636n == null) {
            Boolean valueOf = Boolean.valueOf(i(this.f3641e));
            f3636n = valueOf;
            if (valueOf.booleanValue() && r.c(this.f3640d)) {
                Log.d("Sqflite", y() + "[sqflite] WAL enabled");
            }
        }
        this.f3645i = SQLiteDatabase.openDatabase(this.f3638b, null, f3636n.booleanValue() ? 805306368 : 268435456);
    }

    public void L() {
        this.f3645i = SQLiteDatabase.openDatabase(this.f3638b, null, 1, new a());
    }

    public void M(final g3.e eVar) {
        Q(eVar, new Runnable() { // from class: e3.e
            @Override // java.lang.Runnable
            public final void run() {
                i.this.H(eVar);
            }
        });
    }

    public void N(final g3.e eVar) {
        Q(eVar, new Runnable() { // from class: e3.b
            @Override // java.lang.Runnable
            public final void run() {
                i.this.I(eVar);
            }
        });
    }

    public void P(final g3.e eVar) {
        Q(eVar, new Runnable() { // from class: e3.g
            @Override // java.lang.Runnable
            public final void run() {
                i.this.J(eVar);
            }
        });
    }

    void h(y3.j jVar, k.d dVar) {
        g3.c cVar;
        String i6;
        g3.d dVar2 = new g3.d(jVar, dVar);
        boolean e6 = dVar2.e();
        boolean l6 = dVar2.l();
        List list = (List) dVar2.c("operations");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            cVar = new g3.c((Map) it.next(), e6);
            i6 = cVar.i();
            i6.hashCode();
            switch (i6) {
                case "execute":
                    if (o(cVar)) {
                        cVar.t(arrayList);
                    } else {
                        if (!l6) {
                            cVar.r(dVar);
                            break;
                        }
                        cVar.s(arrayList);
                    }
                case "insert":
                    if (G(cVar)) {
                        cVar.t(arrayList);
                    } else {
                        if (!l6) {
                            cVar.r(dVar);
                            break;
                        }
                        cVar.s(arrayList);
                    }
                case "update":
                    if (J(cVar)) {
                        cVar.t(arrayList);
                    } else {
                        if (!l6) {
                            cVar.r(dVar);
                            break;
                        }
                        cVar.s(arrayList);
                    }
                case "query":
                    if (H(cVar)) {
                        cVar.t(arrayList);
                    } else {
                        if (!l6) {
                            cVar.r(dVar);
                            break;
                        }
                        cVar.s(arrayList);
                    }
                default:
                    dVar.a("bad_param", "Batch method '" + i6 + "' not supported", null);
                    break;
            }
            return;
        }
        if (e6) {
            dVar.b(null);
        } else {
            dVar.b(arrayList);
        }
    }

    public void j() {
        if (!this.f3643g.isEmpty() && r.b(this.f3640d)) {
            Log.d("Sqflite", y() + this.f3643g.size() + " cursor(s) are left opened");
        }
        this.f3645i.close();
    }

    synchronized void t(Boolean bool) {
        if (Boolean.TRUE.equals(bool)) {
            this.f3646j++;
        } else if (Boolean.FALSE.equals(bool)) {
            this.f3646j--;
        }
    }

    public void u(final g3.e eVar) {
        Q(eVar, new Runnable() { // from class: e3.c
            @Override // java.lang.Runnable
            public final void run() {
                i.this.F(eVar);
            }
        });
    }

    public SQLiteDatabase x() {
        return this.f3645i;
    }

    String y() {
        return "[" + z() + "] ";
    }

    String z() {
        Thread currentThread = Thread.currentThread();
        return "" + this.f3639c + "," + currentThread.getName() + "(" + currentThread.getId() + ")";
    }
}

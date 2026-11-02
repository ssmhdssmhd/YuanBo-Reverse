package androidx.room;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.lifecycle.LiveData;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public class e {

    /* renamed from: m, reason: collision with root package name */
    private static final String[] f1313m = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: b, reason: collision with root package name */
    final String[] f1315b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, Set<String>> f1316c;

    /* renamed from: d, reason: collision with root package name */
    final h f1317d;

    /* renamed from: g, reason: collision with root package name */
    volatile q.f f1320g;

    /* renamed from: h, reason: collision with root package name */
    private b f1321h;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.room.d f1322i;

    /* renamed from: k, reason: collision with root package name */
    private f f1324k;

    /* renamed from: e, reason: collision with root package name */
    AtomicBoolean f1318e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f1319f = false;

    /* renamed from: j, reason: collision with root package name */
    final d.b<c, d> f1323j = new d.b<>();

    /* renamed from: l, reason: collision with root package name */
    Runnable f1325l = new a();

    /* renamed from: a, reason: collision with root package name */
    final HashMap<String, Integer> f1314a = new HashMap<>();

    class a implements Runnable {
        a() {
        }

        private Set<Integer> a() {
            HashSet hashSet = new HashSet();
            Cursor r6 = e.this.f1317d.r(new q.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (r6.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(r6.getInt(0)));
                } catch (Throwable th) {
                    r6.close();
                    throw th;
                }
            }
            r6.close();
            if (!hashSet.isEmpty()) {
                e.this.f1320g.o();
            }
            return hashSet;
        }

        @Override // java.lang.Runnable
        public void run() {
            Lock h6 = e.this.f1317d.h();
            Set<Integer> set = null;
            try {
                try {
                    h6.lock();
                } finally {
                    h6.unlock();
                }
            } catch (SQLiteException | IllegalStateException e6) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e6);
            }
            if (e.this.e()) {
                if (e.this.f1318e.compareAndSet(true, false)) {
                    if (e.this.f1317d.m()) {
                        return;
                    }
                    h hVar = e.this.f1317d;
                    if (hVar.f1366g) {
                        q.b writableDatabase = hVar.j().getWritableDatabase();
                        writableDatabase.f();
                        try {
                            set = a();
                            writableDatabase.J();
                            writableDatabase.e();
                        } catch (Throwable th) {
                            writableDatabase.e();
                            throw th;
                        }
                    } else {
                        set = a();
                    }
                    if (set == null || set.isEmpty()) {
                        return;
                    }
                    synchronized (e.this.f1323j) {
                        Iterator<Map.Entry<c, d>> it = e.this.f1323j.iterator();
                        while (it.hasNext()) {
                            it.next().getValue().a(set);
                        }
                    }
                }
            }
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        final long[] f1327a;

        /* renamed from: b, reason: collision with root package name */
        final boolean[] f1328b;

        /* renamed from: c, reason: collision with root package name */
        final int[] f1329c;

        /* renamed from: d, reason: collision with root package name */
        boolean f1330d;

        /* renamed from: e, reason: collision with root package name */
        boolean f1331e;

        b(int i6) {
            long[] jArr = new long[i6];
            this.f1327a = jArr;
            boolean[] zArr = new boolean[i6];
            this.f1328b = zArr;
            this.f1329c = new int[i6];
            Arrays.fill(jArr, 0L);
            Arrays.fill(zArr, false);
        }

        int[] a() {
            synchronized (this) {
                if (this.f1330d && !this.f1331e) {
                    int length = this.f1327a.length;
                    int i6 = 0;
                    while (true) {
                        int i7 = 1;
                        if (i6 >= length) {
                            this.f1331e = true;
                            this.f1330d = false;
                            return this.f1329c;
                        }
                        boolean z5 = this.f1327a[i6] > 0;
                        boolean[] zArr = this.f1328b;
                        if (z5 != zArr[i6]) {
                            int[] iArr = this.f1329c;
                            if (!z5) {
                                i7 = 2;
                            }
                            iArr[i6] = i7;
                        } else {
                            this.f1329c[i6] = 0;
                        }
                        zArr[i6] = z5;
                        i6++;
                    }
                }
                return null;
            }
        }

        boolean b(int... iArr) {
            boolean z5;
            synchronized (this) {
                z5 = false;
                for (int i6 : iArr) {
                    long[] jArr = this.f1327a;
                    long j6 = jArr[i6];
                    jArr[i6] = 1 + j6;
                    if (j6 == 0) {
                        z5 = true;
                        this.f1330d = true;
                    }
                }
            }
            return z5;
        }

        boolean c(int... iArr) {
            boolean z5;
            synchronized (this) {
                z5 = false;
                for (int i6 : iArr) {
                    long[] jArr = this.f1327a;
                    long j6 = jArr[i6];
                    jArr[i6] = j6 - 1;
                    if (j6 == 1) {
                        z5 = true;
                        this.f1330d = true;
                    }
                }
            }
            return z5;
        }

        void d() {
            synchronized (this) {
                this.f1331e = false;
            }
        }
    }

    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final String[] f1332a;

        public c(String[] strArr) {
            this.f1332a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }

        boolean a() {
            return false;
        }

        public abstract void b(Set<String> set);
    }

    static class d {

        /* renamed from: a, reason: collision with root package name */
        final int[] f1333a;

        /* renamed from: b, reason: collision with root package name */
        private final String[] f1334b;

        /* renamed from: c, reason: collision with root package name */
        final c f1335c;

        /* renamed from: d, reason: collision with root package name */
        private final Set<String> f1336d;

        d(c cVar, int[] iArr, String[] strArr) {
            Set<String> set;
            this.f1335c = cVar;
            this.f1333a = iArr;
            this.f1334b = strArr;
            if (iArr.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(strArr[0]);
                set = Collections.unmodifiableSet(hashSet);
            } else {
                set = null;
            }
            this.f1336d = set;
        }

        void a(Set<Integer> set) {
            int length = this.f1333a.length;
            Set<String> set2 = null;
            for (int i6 = 0; i6 < length; i6++) {
                if (set.contains(Integer.valueOf(this.f1333a[i6]))) {
                    if (length == 1) {
                        set2 = this.f1336d;
                    } else {
                        if (set2 == null) {
                            set2 = new HashSet<>(length);
                        }
                        set2.add(this.f1334b[i6]);
                    }
                }
            }
            if (set2 != null) {
                this.f1335c.b(set2);
            }
        }

        void b(String[] strArr) {
            Set<String> set = null;
            if (this.f1334b.length == 1) {
                int length = strArr.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        break;
                    }
                    if (strArr[i6].equalsIgnoreCase(this.f1334b[0])) {
                        set = this.f1336d;
                        break;
                    }
                    i6++;
                }
            } else {
                HashSet hashSet = new HashSet();
                for (String str : strArr) {
                    String[] strArr2 = this.f1334b;
                    int length2 = strArr2.length;
                    int i7 = 0;
                    while (true) {
                        if (i7 < length2) {
                            String str2 = strArr2[i7];
                            if (str2.equalsIgnoreCase(str)) {
                                hashSet.add(str2);
                                break;
                            }
                            i7++;
                        }
                    }
                }
                if (hashSet.size() > 0) {
                    set = hashSet;
                }
            }
            if (set != null) {
                this.f1335c.b(set);
            }
        }
    }

    /* renamed from: androidx.room.e$e, reason: collision with other inner class name */
    static class C0025e extends c {

        /* renamed from: b, reason: collision with root package name */
        final e f1337b;

        /* renamed from: c, reason: collision with root package name */
        final WeakReference<c> f1338c;

        C0025e(e eVar, c cVar) {
            super(cVar.f1332a);
            this.f1337b = eVar;
            this.f1338c = new WeakReference<>(cVar);
        }

        @Override // androidx.room.e.c
        public void b(Set<String> set) {
            c cVar = this.f1338c.get();
            if (cVar == null) {
                this.f1337b.i(this);
            } else {
                cVar.b(set);
            }
        }
    }

    public e(h hVar, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.f1317d = hVar;
        this.f1321h = new b(strArr.length);
        this.f1316c = map2;
        this.f1322i = new androidx.room.d(hVar);
        int length = strArr.length;
        this.f1315b = new String[length];
        for (int i6 = 0; i6 < length; i6++) {
            String str = strArr[i6];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.f1314a.put(lowerCase, Integer.valueOf(i6));
            String str2 = map.get(strArr[i6]);
            if (str2 != null) {
                this.f1315b[i6] = str2.toLowerCase(locale);
            } else {
                this.f1315b[i6] = lowerCase;
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            Locale locale2 = Locale.US;
            String lowerCase2 = value.toLowerCase(locale2);
            if (this.f1314a.containsKey(lowerCase2)) {
                String lowerCase3 = entry.getKey().toLowerCase(locale2);
                HashMap<String, Integer> hashMap = this.f1314a;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    private static void c(StringBuilder sb, String str, String str2) {
        sb.append("`");
        sb.append("room_table_modification_trigger_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("`");
    }

    private String[] j(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.f1316c.containsKey(lowerCase)) {
                hashSet.addAll(this.f1316c.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    private void l(q.b bVar, int i6) {
        bVar.l("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i6 + ", 0)");
        String str = this.f1315b[i6];
        StringBuilder sb = new StringBuilder();
        for (String str2 : f1313m) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            c(sb, str, str2);
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append("room_table_modification_log");
            sb.append(" SET ");
            sb.append("invalidated");
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append("table_id");
            sb.append(" = ");
            sb.append(i6);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            bVar.l(sb.toString());
        }
    }

    private void m(q.b bVar, int i6) {
        String str = this.f1315b[i6];
        StringBuilder sb = new StringBuilder();
        for (String str2 : f1313m) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            c(sb, str, str2);
            bVar.l(sb.toString());
        }
    }

    private String[] p(String[] strArr) {
        String[] j6 = j(strArr);
        for (String str : j6) {
            if (!this.f1314a.containsKey(str.toLowerCase(Locale.US))) {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
        }
        return j6;
    }

    public void a(c cVar) {
        d g6;
        String[] j6 = j(cVar.f1332a);
        int[] iArr = new int[j6.length];
        int length = j6.length;
        for (int i6 = 0; i6 < length; i6++) {
            Integer num = this.f1314a.get(j6[i6].toLowerCase(Locale.US));
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name " + j6[i6]);
            }
            iArr[i6] = num.intValue();
        }
        d dVar = new d(cVar, iArr, j6);
        synchronized (this.f1323j) {
            g6 = this.f1323j.g(cVar, dVar);
        }
        if (g6 == null && this.f1321h.b(iArr)) {
            n();
        }
    }

    public void b(c cVar) {
        a(new C0025e(this, cVar));
    }

    public <T> LiveData<T> d(String[] strArr, boolean z5, Callable<T> callable) {
        return this.f1322i.a(p(strArr), z5, callable);
    }

    boolean e() {
        if (!this.f1317d.q()) {
            return false;
        }
        if (!this.f1319f) {
            this.f1317d.j().getWritableDatabase();
        }
        if (this.f1319f) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    void f(q.b bVar) {
        synchronized (this) {
            if (this.f1319f) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            bVar.l("PRAGMA temp_store = MEMORY;");
            bVar.l("PRAGMA recursive_triggers='ON';");
            bVar.l("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            o(bVar);
            this.f1320g = bVar.p("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
            this.f1319f = true;
        }
    }

    public void g(String... strArr) {
        synchronized (this.f1323j) {
            Iterator<Map.Entry<c, d>> it = this.f1323j.iterator();
            while (it.hasNext()) {
                Map.Entry<c, d> next = it.next();
                if (!next.getKey().a()) {
                    next.getValue().b(strArr);
                }
            }
        }
    }

    public void h() {
        if (this.f1318e.compareAndSet(false, true)) {
            this.f1317d.k().execute(this.f1325l);
        }
    }

    public void i(c cVar) {
        d h6;
        synchronized (this.f1323j) {
            h6 = this.f1323j.h(cVar);
        }
        if (h6 == null || !this.f1321h.c(h6.f1333a)) {
            return;
        }
        n();
    }

    void k(Context context, String str) {
        this.f1324k = new f(context, str, this, this.f1317d.k());
    }

    void n() {
        if (this.f1317d.q()) {
            o(this.f1317d.j().getWritableDatabase());
        }
    }

    void o(q.b bVar) {
        if (bVar.B()) {
            return;
        }
        while (true) {
            try {
                Lock h6 = this.f1317d.h();
                h6.lock();
                try {
                    int[] a6 = this.f1321h.a();
                    if (a6 == null) {
                        return;
                    }
                    int length = a6.length;
                    bVar.f();
                    for (int i6 = 0; i6 < length; i6++) {
                        try {
                            int i7 = a6[i6];
                            if (i7 == 1) {
                                l(bVar, i6);
                            } else if (i7 == 2) {
                                m(bVar, i6);
                            }
                        } finally {
                        }
                    }
                    bVar.J();
                    bVar.e();
                    this.f1321h.d();
                } finally {
                    h6.unlock();
                }
            } catch (SQLiteException | IllegalStateException e6) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e6);
                return;
            }
        }
    }
}

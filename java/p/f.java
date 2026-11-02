package p;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final String f8491a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, a> f8492b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<b> f8493c;

    /* renamed from: d, reason: collision with root package name */
    public final Set<d> f8494d;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f8495a;

        /* renamed from: b, reason: collision with root package name */
        public final String f8496b;

        /* renamed from: c, reason: collision with root package name */
        public final int f8497c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f8498d;

        /* renamed from: e, reason: collision with root package name */
        public final int f8499e;

        /* renamed from: f, reason: collision with root package name */
        public final String f8500f;

        /* renamed from: g, reason: collision with root package name */
        private final int f8501g;

        public a(String str, String str2, boolean z5, int i6, String str3, int i7) {
            this.f8495a = str;
            this.f8496b = str2;
            this.f8498d = z5;
            this.f8499e = i6;
            this.f8497c = a(str2);
            this.f8500f = str3;
            this.f8501g = i7;
        }

        private static int a(String str) {
            if (str == null) {
                return 5;
            }
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.contains("INT")) {
                return 3;
            }
            if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                return 2;
            }
            if (upperCase.contains("BLOB")) {
                return 5;
            }
            return (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f8499e != aVar.f8499e || !this.f8495a.equals(aVar.f8495a) || this.f8498d != aVar.f8498d) {
                return false;
            }
            if (this.f8501g == 1 && aVar.f8501g == 2 && (str3 = this.f8500f) != null && !str3.equals(aVar.f8500f)) {
                return false;
            }
            if (this.f8501g == 2 && aVar.f8501g == 1 && (str2 = aVar.f8500f) != null && !str2.equals(this.f8500f)) {
                return false;
            }
            int i6 = this.f8501g;
            return (i6 == 0 || i6 != aVar.f8501g || ((str = this.f8500f) == null ? aVar.f8500f == null : str.equals(aVar.f8500f))) && this.f8497c == aVar.f8497c;
        }

        public int hashCode() {
            return (((((this.f8495a.hashCode() * 31) + this.f8497c) * 31) + (this.f8498d ? 1231 : 1237)) * 31) + this.f8499e;
        }

        public String toString() {
            return "Column{name='" + this.f8495a + "', type='" + this.f8496b + "', affinity='" + this.f8497c + "', notNull=" + this.f8498d + ", primaryKeyPosition=" + this.f8499e + ", defaultValue='" + this.f8500f + "'}";
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f8502a;

        /* renamed from: b, reason: collision with root package name */
        public final String f8503b;

        /* renamed from: c, reason: collision with root package name */
        public final String f8504c;

        /* renamed from: d, reason: collision with root package name */
        public final List<String> f8505d;

        /* renamed from: e, reason: collision with root package name */
        public final List<String> f8506e;

        public b(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.f8502a = str;
            this.f8503b = str2;
            this.f8504c = str3;
            this.f8505d = Collections.unmodifiableList(list);
            this.f8506e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f8502a.equals(bVar.f8502a) && this.f8503b.equals(bVar.f8503b) && this.f8504c.equals(bVar.f8504c) && this.f8505d.equals(bVar.f8505d)) {
                return this.f8506e.equals(bVar.f8506e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f8502a.hashCode() * 31) + this.f8503b.hashCode()) * 31) + this.f8504c.hashCode()) * 31) + this.f8505d.hashCode()) * 31) + this.f8506e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.f8502a + "', onDelete='" + this.f8503b + "', onUpdate='" + this.f8504c + "', columnNames=" + this.f8505d + ", referenceColumnNames=" + this.f8506e + '}';
        }
    }

    static class c implements Comparable<c> {

        /* renamed from: a, reason: collision with root package name */
        final int f8507a;

        /* renamed from: b, reason: collision with root package name */
        final int f8508b;

        /* renamed from: c, reason: collision with root package name */
        final String f8509c;

        /* renamed from: d, reason: collision with root package name */
        final String f8510d;

        c(int i6, int i7, String str, String str2) {
            this.f8507a = i6;
            this.f8508b = i7;
            this.f8509c = str;
            this.f8510d = str2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            int i6 = this.f8507a - cVar.f8507a;
            return i6 == 0 ? this.f8508b - cVar.f8508b : i6;
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f8511a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f8512b;

        /* renamed from: c, reason: collision with root package name */
        public final List<String> f8513c;

        public d(String str, boolean z5, List<String> list) {
            this.f8511a = str;
            this.f8512b = z5;
            this.f8513c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f8512b == dVar.f8512b && this.f8513c.equals(dVar.f8513c)) {
                return this.f8511a.startsWith("index_") ? dVar.f8511a.startsWith("index_") : this.f8511a.equals(dVar.f8511a);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.f8511a.startsWith("index_") ? -1184239155 : this.f8511a.hashCode()) * 31) + (this.f8512b ? 1 : 0)) * 31) + this.f8513c.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.f8511a + "', unique=" + this.f8512b + ", columns=" + this.f8513c + '}';
        }
    }

    public f(String str, Map<String, a> map, Set<b> set, Set<d> set2) {
        this.f8491a = str;
        this.f8492b = Collections.unmodifiableMap(map);
        this.f8493c = Collections.unmodifiableSet(set);
        this.f8494d = set2 == null ? null : Collections.unmodifiableSet(set2);
    }

    public static f a(q.b bVar, String str) {
        return new f(str, b(bVar, str), d(bVar, str), f(bVar, str));
    }

    private static Map<String, a> b(q.b bVar, String str) {
        Cursor S = bVar.S("PRAGMA table_info(`" + str + "`)");
        HashMap hashMap = new HashMap();
        try {
            if (S.getColumnCount() > 0) {
                int columnIndex = S.getColumnIndex("name");
                int columnIndex2 = S.getColumnIndex("type");
                int columnIndex3 = S.getColumnIndex("notnull");
                int columnIndex4 = S.getColumnIndex("pk");
                int columnIndex5 = S.getColumnIndex("dflt_value");
                while (S.moveToNext()) {
                    String string = S.getString(columnIndex);
                    hashMap.put(string, new a(string, S.getString(columnIndex2), S.getInt(columnIndex3) != 0, S.getInt(columnIndex4), S.getString(columnIndex5), 2));
                }
            }
            return hashMap;
        } finally {
            S.close();
        }
    }

    private static List<c> c(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < count; i6++) {
            cursor.moveToPosition(i6);
            arrayList.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static Set<b> d(q.b bVar, String str) {
        HashSet hashSet = new HashSet();
        Cursor S = bVar.S("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = S.getColumnIndex("id");
            int columnIndex2 = S.getColumnIndex("seq");
            int columnIndex3 = S.getColumnIndex("table");
            int columnIndex4 = S.getColumnIndex("on_delete");
            int columnIndex5 = S.getColumnIndex("on_update");
            List<c> c6 = c(S);
            int count = S.getCount();
            for (int i6 = 0; i6 < count; i6++) {
                S.moveToPosition(i6);
                if (S.getInt(columnIndex2) == 0) {
                    int i7 = S.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (c cVar : c6) {
                        if (cVar.f8507a == i7) {
                            arrayList.add(cVar.f8509c);
                            arrayList2.add(cVar.f8510d);
                        }
                    }
                    hashSet.add(new b(S.getString(columnIndex3), S.getString(columnIndex4), S.getString(columnIndex5), arrayList, arrayList2));
                }
            }
            return hashSet;
        } finally {
            S.close();
        }
    }

    private static d e(q.b bVar, String str, boolean z5) {
        Cursor S = bVar.S("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = S.getColumnIndex("seqno");
            int columnIndex2 = S.getColumnIndex("cid");
            int columnIndex3 = S.getColumnIndex("name");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                TreeMap treeMap = new TreeMap();
                while (S.moveToNext()) {
                    if (S.getInt(columnIndex2) >= 0) {
                        treeMap.put(Integer.valueOf(S.getInt(columnIndex)), S.getString(columnIndex3));
                    }
                }
                ArrayList arrayList = new ArrayList(treeMap.size());
                arrayList.addAll(treeMap.values());
                return new d(str, z5, arrayList);
            }
            S.close();
            return null;
        } finally {
            S.close();
        }
    }

    private static Set<d> f(q.b bVar, String str) {
        Cursor S = bVar.S("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = S.getColumnIndex("name");
            int columnIndex2 = S.getColumnIndex("origin");
            int columnIndex3 = S.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                HashSet hashSet = new HashSet();
                while (S.moveToNext()) {
                    if ("c".equals(S.getString(columnIndex2))) {
                        String string = S.getString(columnIndex);
                        boolean z5 = true;
                        if (S.getInt(columnIndex3) != 1) {
                            z5 = false;
                        }
                        d e6 = e(bVar, string, z5);
                        if (e6 == null) {
                            return null;
                        }
                        hashSet.add(e6);
                    }
                }
                return hashSet;
            }
            return null;
        } finally {
            S.close();
        }
    }

    public boolean equals(Object obj) {
        Set<d> set;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        String str = this.f8491a;
        if (str == null ? fVar.f8491a != null : !str.equals(fVar.f8491a)) {
            return false;
        }
        Map<String, a> map = this.f8492b;
        if (map == null ? fVar.f8492b != null : !map.equals(fVar.f8492b)) {
            return false;
        }
        Set<b> set2 = this.f8493c;
        if (set2 == null ? fVar.f8493c != null : !set2.equals(fVar.f8493c)) {
            return false;
        }
        Set<d> set3 = this.f8494d;
        if (set3 == null || (set = fVar.f8494d) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        String str = this.f8491a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, a> map = this.f8492b;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set<b> set = this.f8493c;
        return hashCode2 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        return "TableInfo{name='" + this.f8491a + "', columns=" + this.f8492b + ", foreignKeys=" + this.f8493c + ", indices=" + this.f8494d + '}';
    }
}

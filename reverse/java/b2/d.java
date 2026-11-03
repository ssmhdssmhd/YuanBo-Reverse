package b2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import u1.b;

/* loaded from: classes.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f1732a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1733b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f1734c;

    /* renamed from: d, reason: collision with root package name */
    public final long f1735d;

    /* renamed from: e, reason: collision with root package name */
    public final long f1736e;

    /* renamed from: f, reason: collision with root package name */
    public final g f1737f;

    /* renamed from: g, reason: collision with root package name */
    private final String[] f1738g;

    /* renamed from: h, reason: collision with root package name */
    public final String f1739h;

    /* renamed from: i, reason: collision with root package name */
    public final String f1740i;

    /* renamed from: j, reason: collision with root package name */
    public final d f1741j;

    /* renamed from: k, reason: collision with root package name */
    private final HashMap<String, Integer> f1742k;

    /* renamed from: l, reason: collision with root package name */
    private final HashMap<String, Integer> f1743l;

    /* renamed from: m, reason: collision with root package name */
    private List<d> f1744m;

    private d(String str, String str2, long j6, long j7, g gVar, String[] strArr, String str3, String str4, d dVar) {
        this.f1732a = str;
        this.f1733b = str2;
        this.f1740i = str4;
        this.f1737f = gVar;
        this.f1738g = strArr;
        this.f1734c = str2 != null;
        this.f1735d = j6;
        this.f1736e = j7;
        this.f1739h = (String) i2.a.e(str3);
        this.f1741j = dVar;
        this.f1742k = new HashMap<>();
        this.f1743l = new HashMap<>();
    }

    private void b(Map<String, g> map, b.C0148b c0148b, int i6, int i7, int i8) {
        g f6 = f.f(this.f1737f, this.f1738g, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) c0148b.e();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            c0148b.o(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (f6 != null) {
            f.a(spannableStringBuilder2, i6, i7, f6, this.f1741j, map, i8);
            if ("p".equals(this.f1732a)) {
                if (f6.k() != Float.MAX_VALUE) {
                    c0148b.m((f6.k() * (-90.0f)) / 100.0f);
                }
                if (f6.m() != null) {
                    c0148b.p(f6.m());
                }
                if (f6.h() != null) {
                    c0148b.j(f6.h());
                }
            }
        }
    }

    public static d c(String str, long j6, long j7, g gVar, String[] strArr, String str2, String str3, d dVar) {
        return new d(str, null, j6, j7, gVar, strArr, str2, str3, dVar);
    }

    public static d d(String str) {
        return new d(null, f.b(str), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    private static void e(SpannableStringBuilder spannableStringBuilder) {
        for (a aVar : (a[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), a.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(aVar), spannableStringBuilder.getSpanEnd(aVar), "");
        }
        for (int i6 = 0; i6 < spannableStringBuilder.length(); i6++) {
            if (spannableStringBuilder.charAt(i6) == ' ') {
                int i7 = i6 + 1;
                int i8 = i7;
                while (i8 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i8) == ' ') {
                    i8++;
                }
                int i9 = i8 - i7;
                if (i9 > 0) {
                    spannableStringBuilder.delete(i6, i9 + i6);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i10 = 0; i10 < spannableStringBuilder.length() - 1; i10++) {
            if (spannableStringBuilder.charAt(i10) == '\n') {
                int i11 = i10 + 1;
                if (spannableStringBuilder.charAt(i11) == ' ') {
                    spannableStringBuilder.delete(i11, i10 + 2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i12 = 0; i12 < spannableStringBuilder.length() - 1; i12++) {
            if (spannableStringBuilder.charAt(i12) == ' ') {
                int i13 = i12 + 1;
                if (spannableStringBuilder.charAt(i13) == '\n') {
                    spannableStringBuilder.delete(i12, i13);
                }
            }
        }
        if (spannableStringBuilder.length() <= 0 || spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) != '\n') {
            return;
        }
        spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
    }

    private void i(TreeSet<Long> treeSet, boolean z5) {
        boolean equals = "p".equals(this.f1732a);
        boolean equals2 = "div".equals(this.f1732a);
        if (z5 || equals || (equals2 && this.f1740i != null)) {
            long j6 = this.f1735d;
            if (j6 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j6));
            }
            long j7 = this.f1736e;
            if (j7 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j7));
            }
        }
        if (this.f1744m == null) {
            return;
        }
        for (int i6 = 0; i6 < this.f1744m.size(); i6++) {
            this.f1744m.get(i6).i(treeSet, z5 || equals);
        }
    }

    private static SpannableStringBuilder k(String str, Map<String, b.C0148b> map) {
        if (!map.containsKey(str)) {
            b.C0148b c0148b = new b.C0148b();
            c0148b.o(new SpannableStringBuilder());
            map.put(str, c0148b);
        }
        return (SpannableStringBuilder) i2.a.e(map.get(str).e());
    }

    private void n(long j6, String str, List<Pair<String, String>> list) {
        if (!"".equals(this.f1739h)) {
            str = this.f1739h;
        }
        if (m(j6) && "div".equals(this.f1732a) && this.f1740i != null) {
            list.add(new Pair<>(str, this.f1740i));
            return;
        }
        for (int i6 = 0; i6 < g(); i6++) {
            f(i6).n(j6, str, list);
        }
    }

    private void o(long j6, Map<String, g> map, Map<String, e> map2, String str, Map<String, b.C0148b> map3) {
        int i6;
        if (m(j6)) {
            String str2 = "".equals(this.f1739h) ? str : this.f1739h;
            Iterator<Map.Entry<String, Integer>> it = this.f1743l.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Integer> next = it.next();
                String key = next.getKey();
                int intValue = this.f1742k.containsKey(key) ? this.f1742k.get(key).intValue() : 0;
                int intValue2 = next.getValue().intValue();
                if (intValue != intValue2) {
                    b(map, (b.C0148b) i2.a.e(map3.get(key)), intValue, intValue2, ((e) i2.a.e(map2.get(str2))).f1754j);
                }
            }
            for (i6 = 0; i6 < g(); i6++) {
                f(i6).o(j6, map, map2, str2, map3);
            }
        }
    }

    private void p(long j6, boolean z5, String str, Map<String, b.C0148b> map) {
        this.f1742k.clear();
        this.f1743l.clear();
        if ("metadata".equals(this.f1732a)) {
            return;
        }
        if (!"".equals(this.f1739h)) {
            str = this.f1739h;
        }
        if (this.f1734c && z5) {
            k(str, map).append((CharSequence) i2.a.e(this.f1733b));
            return;
        }
        if ("br".equals(this.f1732a) && z5) {
            k(str, map).append('\n');
            return;
        }
        if (m(j6)) {
            for (Map.Entry<String, b.C0148b> entry : map.entrySet()) {
                this.f1742k.put(entry.getKey(), Integer.valueOf(((CharSequence) i2.a.e(entry.getValue().e())).length()));
            }
            boolean equals = "p".equals(this.f1732a);
            for (int i6 = 0; i6 < g(); i6++) {
                f(i6).p(j6, z5 || equals, str, map);
            }
            if (equals) {
                f.c(k(str, map));
            }
            for (Map.Entry<String, b.C0148b> entry2 : map.entrySet()) {
                this.f1743l.put(entry2.getKey(), Integer.valueOf(((CharSequence) i2.a.e(entry2.getValue().e())).length()));
            }
        }
    }

    public void a(d dVar) {
        if (this.f1744m == null) {
            this.f1744m = new ArrayList();
        }
        this.f1744m.add(dVar);
    }

    public d f(int i6) {
        List<d> list = this.f1744m;
        if (list != null) {
            return list.get(i6);
        }
        throw new IndexOutOfBoundsException();
    }

    public int g() {
        List<d> list = this.f1744m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<u1.b> h(long j6, Map<String, g> map, Map<String, e> map2, Map<String, String> map3) {
        List<Pair<String, String>> arrayList = new ArrayList<>();
        n(j6, this.f1739h, arrayList);
        TreeMap treeMap = new TreeMap();
        p(j6, false, this.f1739h, treeMap);
        o(j6, map, map2, this.f1739h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair<String, String> pair : arrayList) {
            String str = map3.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                e eVar = (e) i2.a.e(map2.get(pair.first));
                arrayList2.add(new b.C0148b().f(decodeByteArray).k(eVar.f1746b).l(0).h(eVar.f1747c, 0).i(eVar.f1749e).n(eVar.f1750f).g(eVar.f1751g).r(eVar.f1754j).a());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            e eVar2 = (e) i2.a.e(map2.get(entry.getKey()));
            b.C0148b c0148b = (b.C0148b) entry.getValue();
            e((SpannableStringBuilder) i2.a.e(c0148b.e()));
            c0148b.h(eVar2.f1747c, eVar2.f1748d);
            c0148b.i(eVar2.f1749e);
            c0148b.k(eVar2.f1746b);
            c0148b.n(eVar2.f1750f);
            c0148b.q(eVar2.f1753i, eVar2.f1752h);
            c0148b.r(eVar2.f1754j);
            arrayList2.add(c0148b.a());
        }
        return arrayList2;
    }

    public long[] j() {
        TreeSet<Long> treeSet = new TreeSet<>();
        int i6 = 0;
        i(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i6] = it.next().longValue();
            i6++;
        }
        return jArr;
    }

    public String[] l() {
        return this.f1738g;
    }

    public boolean m(long j6) {
        long j7 = this.f1735d;
        return (j7 == -9223372036854775807L && this.f1736e == -9223372036854775807L) || (j7 <= j6 && this.f1736e == -9223372036854775807L) || ((j7 == -9223372036854775807L && j6 < this.f1736e) || (j7 <= j6 && j6 < this.f1736e));
    }
}

package n;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import q.e;

/* loaded from: classes.dex */
public class c implements e, q.d {

    /* renamed from: m, reason: collision with root package name */
    static final TreeMap<Integer, c> f8138m = new TreeMap<>();

    /* renamed from: a, reason: collision with root package name */
    private volatile String f8139a;

    /* renamed from: b, reason: collision with root package name */
    final long[] f8140b;

    /* renamed from: c, reason: collision with root package name */
    final double[] f8141c;

    /* renamed from: d, reason: collision with root package name */
    final String[] f8142d;

    /* renamed from: e, reason: collision with root package name */
    final byte[][] f8143e;

    /* renamed from: j, reason: collision with root package name */
    private final int[] f8144j;

    /* renamed from: k, reason: collision with root package name */
    final int f8145k;

    /* renamed from: l, reason: collision with root package name */
    int f8146l;

    private c(int i6) {
        this.f8145k = i6;
        int i7 = i6 + 1;
        this.f8144j = new int[i7];
        this.f8140b = new long[i7];
        this.f8141c = new double[i7];
        this.f8142d = new String[i7];
        this.f8143e = new byte[i7][];
    }

    public static c k(String str, int i6) {
        TreeMap<Integer, c> treeMap = f8138m;
        synchronized (treeMap) {
            Map.Entry<Integer, c> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i6));
            if (ceilingEntry == null) {
                c cVar = new c(i6);
                cVar.q(str, i6);
                return cVar;
            }
            treeMap.remove(ceilingEntry.getKey());
            c value = ceilingEntry.getValue();
            value.q(str, i6);
            return value;
        }
    }

    private static void s() {
        TreeMap<Integer, c> treeMap = f8138m;
        if (treeMap.size() <= 15) {
            return;
        }
        int size = treeMap.size() - 10;
        Iterator<Integer> it = treeMap.descendingKeySet().iterator();
        while (true) {
            int i6 = size - 1;
            if (size <= 0) {
                return;
            }
            it.next();
            it.remove();
            size = i6;
        }
    }

    @Override // q.d
    public void H(int i6, long j6) {
        this.f8144j[i6] = 2;
        this.f8140b[i6] = j6;
    }

    @Override // q.d
    public void O(int i6, byte[] bArr) {
        this.f8144j[i6] = 5;
        this.f8143e[i6] = bArr;
    }

    @Override // q.e
    public void a(q.d dVar) {
        for (int i6 = 1; i6 <= this.f8146l; i6++) {
            int i7 = this.f8144j[i6];
            if (i7 == 1) {
                dVar.r(i6);
            } else if (i7 == 2) {
                dVar.H(i6, this.f8140b[i6]);
            } else if (i7 == 3) {
                dVar.w(i6, this.f8141c[i6]);
            } else if (i7 == 4) {
                dVar.m(i6, this.f8142d[i6]);
            } else if (i7 == 5) {
                dVar.O(i6, this.f8143e[i6]);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // q.e
    public String j() {
        return this.f8139a;
    }

    @Override // q.d
    public void m(int i6, String str) {
        this.f8144j[i6] = 4;
        this.f8142d[i6] = str;
    }

    void q(String str, int i6) {
        this.f8139a = str;
        this.f8146l = i6;
    }

    @Override // q.d
    public void r(int i6) {
        this.f8144j[i6] = 1;
    }

    public void t() {
        TreeMap<Integer, c> treeMap = f8138m;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f8145k), this);
            s();
        }
    }

    @Override // q.d
    public void w(int i6, double d6) {
        this.f8144j[i6] = 3;
        this.f8141c[i6] = d6;
    }
}

package t1;

import android.net.Uri;
import h0.y1;
import i2.c1;
import i2.t0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import k1.c;
import w0.p;

/* loaded from: classes.dex */
public class a implements k1.a<a> {

    /* renamed from: a, reason: collision with root package name */
    public final int f9332a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9333b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9334c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f9335d;

    /* renamed from: e, reason: collision with root package name */
    public final C0143a f9336e;

    /* renamed from: f, reason: collision with root package name */
    public final b[] f9337f;

    /* renamed from: g, reason: collision with root package name */
    public final long f9338g;

    /* renamed from: h, reason: collision with root package name */
    public final long f9339h;

    /* renamed from: t1.a$a, reason: collision with other inner class name */
    public static class C0143a {

        /* renamed from: a, reason: collision with root package name */
        public final UUID f9340a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f9341b;

        /* renamed from: c, reason: collision with root package name */
        public final p[] f9342c;

        public C0143a(UUID uuid, byte[] bArr, p[] pVarArr) {
            this.f9340a = uuid;
            this.f9341b = bArr;
            this.f9342c = pVarArr;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f9343a;

        /* renamed from: b, reason: collision with root package name */
        public final String f9344b;

        /* renamed from: c, reason: collision with root package name */
        public final long f9345c;

        /* renamed from: d, reason: collision with root package name */
        public final String f9346d;

        /* renamed from: e, reason: collision with root package name */
        public final int f9347e;

        /* renamed from: f, reason: collision with root package name */
        public final int f9348f;

        /* renamed from: g, reason: collision with root package name */
        public final int f9349g;

        /* renamed from: h, reason: collision with root package name */
        public final int f9350h;

        /* renamed from: i, reason: collision with root package name */
        public final String f9351i;

        /* renamed from: j, reason: collision with root package name */
        public final y1[] f9352j;

        /* renamed from: k, reason: collision with root package name */
        public final int f9353k;

        /* renamed from: l, reason: collision with root package name */
        private final String f9354l;

        /* renamed from: m, reason: collision with root package name */
        private final String f9355m;

        /* renamed from: n, reason: collision with root package name */
        private final List<Long> f9356n;

        /* renamed from: o, reason: collision with root package name */
        private final long[] f9357o;

        /* renamed from: p, reason: collision with root package name */
        private final long f9358p;

        public b(String str, String str2, int i6, String str3, long j6, String str4, int i7, int i8, int i9, int i10, String str5, y1[] y1VarArr, List<Long> list, long j7) {
            this(str, str2, i6, str3, j6, str4, i7, i8, i9, i10, str5, y1VarArr, list, c1.Q0(list, 1000000L, j6), c1.P0(j7, 1000000L, j6));
        }

        private b(String str, String str2, int i6, String str3, long j6, String str4, int i7, int i8, int i9, int i10, String str5, y1[] y1VarArr, List<Long> list, long[] jArr, long j7) {
            this.f9354l = str;
            this.f9355m = str2;
            this.f9343a = i6;
            this.f9344b = str3;
            this.f9345c = j6;
            this.f9346d = str4;
            this.f9347e = i7;
            this.f9348f = i8;
            this.f9349g = i9;
            this.f9350h = i10;
            this.f9351i = str5;
            this.f9352j = y1VarArr;
            this.f9356n = list;
            this.f9357o = jArr;
            this.f9358p = j7;
            this.f9353k = list.size();
        }

        public Uri a(int i6, int i7) {
            i2.a.g(this.f9352j != null);
            i2.a.g(this.f9356n != null);
            i2.a.g(i7 < this.f9356n.size());
            String num = Integer.toString(this.f9352j[i6].f5062l);
            String l6 = this.f9356n.get(i7).toString();
            return t0.e(this.f9354l, this.f9355m.replace("{bitrate}", num).replace("{Bitrate}", num).replace("{start time}", l6).replace("{start_time}", l6));
        }

        public b b(y1[] y1VarArr) {
            return new b(this.f9354l, this.f9355m, this.f9343a, this.f9344b, this.f9345c, this.f9346d, this.f9347e, this.f9348f, this.f9349g, this.f9350h, this.f9351i, y1VarArr, this.f9356n, this.f9357o, this.f9358p);
        }

        public long c(int i6) {
            if (i6 == this.f9353k - 1) {
                return this.f9358p;
            }
            long[] jArr = this.f9357o;
            return jArr[i6 + 1] - jArr[i6];
        }

        public int d(long j6) {
            return c1.i(this.f9357o, j6, true, true);
        }

        public long e(int i6) {
            return this.f9357o[i6];
        }
    }

    private a(int i6, int i7, long j6, long j7, int i8, boolean z5, C0143a c0143a, b[] bVarArr) {
        this.f9332a = i6;
        this.f9333b = i7;
        this.f9338g = j6;
        this.f9339h = j7;
        this.f9334c = i8;
        this.f9335d = z5;
        this.f9336e = c0143a;
        this.f9337f = bVarArr;
    }

    public a(int i6, int i7, long j6, long j7, long j8, int i8, boolean z5, C0143a c0143a, b[] bVarArr) {
        this(i6, i7, j7 == 0 ? -9223372036854775807L : c1.P0(j7, 1000000L, j6), j8 != 0 ? c1.P0(j8, 1000000L, j6) : -9223372036854775807L, i8, z5, c0143a, bVarArr);
    }

    @Override // k1.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final a a(List<c> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        b bVar = null;
        int i6 = 0;
        while (i6 < arrayList.size()) {
            c cVar = (c) arrayList.get(i6);
            b bVar2 = this.f9337f[cVar.f6860b];
            if (bVar2 != bVar && bVar != null) {
                arrayList2.add(bVar.b((y1[]) arrayList3.toArray(new y1[0])));
                arrayList3.clear();
            }
            arrayList3.add(bVar2.f9352j[cVar.f6861c]);
            i6++;
            bVar = bVar2;
        }
        if (bVar != null) {
            arrayList2.add(bVar.b((y1[]) arrayList3.toArray(new y1[0])));
        }
        return new a(this.f9332a, this.f9333b, this.f9338g, this.f9339h, this.f9334c, this.f9335d, this.f9336e, (b[]) arrayList2.toArray(new b[0]));
    }
}

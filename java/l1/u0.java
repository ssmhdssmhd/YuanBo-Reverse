package l1;

import android.os.Bundle;
import h0.o;
import h0.y1;
import i2.c1;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class u0 implements h0.o {

    /* renamed from: j, reason: collision with root package name */
    private static final String f7442j = c1.s0(0);

    /* renamed from: k, reason: collision with root package name */
    private static final String f7443k = c1.s0(1);

    /* renamed from: l, reason: collision with root package name */
    public static final o.a<u0> f7444l = new o.a() { // from class: l1.t0
        @Override // h0.o.a
        public final h0.o a(Bundle bundle) {
            u0 d6;
            d6 = u0.d(bundle);
            return d6;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final int f7445a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7446b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7447c;

    /* renamed from: d, reason: collision with root package name */
    private final y1[] f7448d;

    /* renamed from: e, reason: collision with root package name */
    private int f7449e;

    public u0(String str, y1... y1VarArr) {
        i2.a.a(y1VarArr.length > 0);
        this.f7446b = str;
        this.f7448d = y1VarArr;
        this.f7445a = y1VarArr.length;
        int k6 = i2.x.k(y1VarArr[0].f5066p);
        this.f7447c = k6 == -1 ? i2.x.k(y1VarArr[0].f5065o) : k6;
        h();
    }

    public u0(y1... y1VarArr) {
        this("", y1VarArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ u0 d(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f7442j);
        return new u0(bundle.getString(f7443k, ""), (y1[]) (parcelableArrayList == null ? m2.q.q() : i2.d.b(y1.f5054t0, parcelableArrayList)).toArray(new y1[0]));
    }

    private static void e(String str, String str2, String str3, int i6) {
        i2.t.d("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i6 + ")"));
    }

    private static String f(String str) {
        return (str == null || str.equals("und")) ? "" : str;
    }

    private static int g(int i6) {
        return i6 | 16384;
    }

    private void h() {
        String f6 = f(this.f7448d[0].f5057c);
        int g6 = g(this.f7448d[0].f5059e);
        int i6 = 1;
        while (true) {
            y1[] y1VarArr = this.f7448d;
            if (i6 >= y1VarArr.length) {
                return;
            }
            if (!f6.equals(f(y1VarArr[i6].f5057c))) {
                y1[] y1VarArr2 = this.f7448d;
                e("languages", y1VarArr2[0].f5057c, y1VarArr2[i6].f5057c, i6);
                return;
            } else {
                if (g6 != g(this.f7448d[i6].f5059e)) {
                    e("role flags", Integer.toBinaryString(this.f7448d[0].f5059e), Integer.toBinaryString(this.f7448d[i6].f5059e), i6);
                    return;
                }
                i6++;
            }
        }
    }

    public y1 b(int i6) {
        return this.f7448d[i6];
    }

    public int c(y1 y1Var) {
        int i6 = 0;
        while (true) {
            y1[] y1VarArr = this.f7448d;
            if (i6 >= y1VarArr.length) {
                return -1;
            }
            if (y1Var == y1VarArr[i6]) {
                return i6;
            }
            i6++;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || u0.class != obj.getClass()) {
            return false;
        }
        u0 u0Var = (u0) obj;
        return this.f7446b.equals(u0Var.f7446b) && Arrays.equals(this.f7448d, u0Var.f7448d);
    }

    public int hashCode() {
        if (this.f7449e == 0) {
            this.f7449e = ((527 + this.f7446b.hashCode()) * 31) + Arrays.hashCode(this.f7448d);
        }
        return this.f7449e;
    }
}

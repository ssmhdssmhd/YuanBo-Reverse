package e2;

import android.os.SystemClock;
import e2.u;
import g2.h0;
import h0.r4;
import java.util.Arrays;
import java.util.List;
import l1.u0;
import l1.w0;
import m2.q;

/* loaded from: classes.dex */
public final class a0 {
    public static r4 a(u.a aVar, v[] vVarArr) {
        List[] listArr = new List[vVarArr.length];
        for (int i6 = 0; i6 < vVarArr.length; i6++) {
            v vVar = vVarArr[i6];
            listArr[i6] = vVar != null ? m2.q.r(vVar) : m2.q.q();
        }
        return b(aVar, listArr);
    }

    public static r4 b(u.a aVar, List<? extends v>[] listArr) {
        boolean z5;
        q.a aVar2 = new q.a();
        for (int i6 = 0; i6 < aVar.d(); i6++) {
            w0 f6 = aVar.f(i6);
            List<? extends v> list = listArr[i6];
            for (int i7 = 0; i7 < f6.f7457a; i7++) {
                u0 b6 = f6.b(i7);
                boolean z6 = aVar.a(i6, i7, false) != 0;
                int i8 = b6.f7445a;
                int[] iArr = new int[i8];
                boolean[] zArr = new boolean[i8];
                for (int i9 = 0; i9 < b6.f7445a; i9++) {
                    iArr[i9] = aVar.g(i6, i7, i9);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            z5 = false;
                            break;
                        }
                        v vVar = list.get(i10);
                        if (vVar.c().equals(b6) && vVar.u(i9) != -1) {
                            z5 = true;
                            break;
                        }
                        i10++;
                    }
                    zArr[i9] = z5;
                }
                aVar2.a(new r4.a(b6, z6, iArr, zArr));
            }
        }
        w0 h6 = aVar.h();
        for (int i11 = 0; i11 < h6.f7457a; i11++) {
            u0 b7 = h6.b(i11);
            int[] iArr2 = new int[b7.f7445a];
            Arrays.fill(iArr2, 0);
            aVar2.a(new r4.a(b7, false, iArr2, new boolean[b7.f7445a]));
        }
        return new r4(aVar2.h());
    }

    public static h0.a c(s sVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = sVar.length();
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            if (sVar.f(i7, elapsedRealtime)) {
                i6++;
            }
        }
        return new h0.a(1, 0, length, i6);
    }
}

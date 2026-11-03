package q1;

import android.net.Uri;
import android.text.TextUtils;
import h0.y1;
import i0.o3;
import i2.r0;
import i2.x;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import y0.h0;

/* loaded from: classes.dex */
public final class d implements h {

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f8718d = {8, 13, 11, 2, 0, 1, 7};

    /* renamed from: b, reason: collision with root package name */
    private final int f8719b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f8720c;

    public d() {
        this(0, true);
    }

    public d(int i6, boolean z5) {
        this.f8719b = i6;
        this.f8720c = z5;
    }

    private static void b(int i6, List<Integer> list) {
        if (o2.e.g(f8718d, i6) == -1 || list.contains(Integer.valueOf(i6))) {
            return;
        }
        list.add(Integer.valueOf(i6));
    }

    private o0.l d(int i6, y1 y1Var, List<y1> list, r0 r0Var) {
        if (i6 == 0) {
            return new y0.b();
        }
        if (i6 == 1) {
            return new y0.e();
        }
        if (i6 == 2) {
            return new y0.h();
        }
        if (i6 == 7) {
            return new v0.f(0, 0L);
        }
        if (i6 == 8) {
            return e(r0Var, y1Var, list);
        }
        if (i6 == 11) {
            return f(this.f8719b, this.f8720c, y1Var, list, r0Var);
        }
        if (i6 != 13) {
            return null;
        }
        return new t(y1Var.f5057c, r0Var);
    }

    private static w0.g e(r0 r0Var, y1 y1Var, List<y1> list) {
        int i6 = g(y1Var) ? 4 : 0;
        if (list == null) {
            list = Collections.emptyList();
        }
        return new w0.g(i6, r0Var, null, list);
    }

    private static h0 f(int i6, boolean z5, y1 y1Var, List<y1> list, r0 r0Var) {
        int i7 = i6 | 16;
        if (list != null) {
            i7 |= 32;
        } else {
            list = z5 ? Collections.singletonList(new y1.b().g0("application/cea-608").G()) : Collections.emptyList();
        }
        String str = y1Var.f5063m;
        if (!TextUtils.isEmpty(str)) {
            if (!x.b(str, "audio/mp4a-latm")) {
                i7 |= 2;
            }
            if (!x.b(str, "video/avc")) {
                i7 |= 4;
            }
        }
        return new h0(2, r0Var, new y0.j(i7, list));
    }

    private static boolean g(y1 y1Var) {
        b1.a aVar = y1Var.f5064n;
        if (aVar == null) {
            return false;
        }
        for (int i6 = 0; i6 < aVar.h(); i6++) {
            if (aVar.g(i6) instanceof q) {
                return !((q) r2).f8835c.isEmpty();
            }
        }
        return false;
    }

    private static boolean h(o0.l lVar, o0.m mVar) {
        try {
            boolean g6 = lVar.g(mVar);
            mVar.g();
            return g6;
        } catch (EOFException unused) {
            mVar.g();
            return false;
        } catch (Throwable th) {
            mVar.g();
            throw th;
        }
    }

    @Override // q1.h
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b a(Uri uri, y1 y1Var, List<y1> list, r0 r0Var, Map<String, List<String>> map, o0.m mVar, o3 o3Var) {
        int a6 = i2.l.a(y1Var.f5066p);
        int b6 = i2.l.b(map);
        int c6 = i2.l.c(uri);
        int[] iArr = f8718d;
        ArrayList arrayList = new ArrayList(iArr.length);
        b(a6, arrayList);
        b(b6, arrayList);
        b(c6, arrayList);
        for (int i6 : iArr) {
            b(i6, arrayList);
        }
        mVar.g();
        o0.l lVar = null;
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            int intValue = ((Integer) arrayList.get(i7)).intValue();
            o0.l lVar2 = (o0.l) i2.a.e(d(intValue, y1Var, list, r0Var));
            if (h(lVar2, mVar)) {
                return new b(lVar2, y1Var, r0Var);
            }
            if (lVar == null && (intValue == a6 || intValue == b6 || intValue == c6 || intValue == 11)) {
                lVar = lVar2;
            }
        }
        return new b((o0.l) i2.a.e(lVar), y1Var, r0Var);
    }
}

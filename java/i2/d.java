package i2;

import android.os.Bundle;
import android.util.SparseArray;
import h0.o;
import java.util.List;
import m2.q;

/* loaded from: classes.dex */
public final class d {
    private d() {
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader((ClassLoader) c1.j(d.class.getClassLoader()));
        }
    }

    public static <T extends h0.o> m2.q<T> b(o.a<T> aVar, List<Bundle> list) {
        q.a k6 = m2.q.k();
        for (int i6 = 0; i6 < list.size(); i6++) {
            k6.a(aVar.a((Bundle) a.e(list.get(i6))));
        }
        return k6.h();
    }

    public static <T extends h0.o> SparseArray<T> c(o.a<T> aVar, SparseArray<Bundle> sparseArray) {
        SparseArray<T> sparseArray2 = new SparseArray<>(sparseArray.size());
        for (int i6 = 0; i6 < sparseArray.size(); i6++) {
            sparseArray2.put(sparseArray.keyAt(i6), aVar.a(sparseArray.valueAt(i6)));
        }
        return sparseArray2;
    }
}

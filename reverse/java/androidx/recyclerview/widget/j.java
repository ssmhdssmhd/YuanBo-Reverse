package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class j {
    static int a(RecyclerView.y yVar, h hVar, View view, View view2, RecyclerView.n nVar, boolean z5) {
        if (nVar.t() == 0 || yVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z5) {
            return Math.abs(nVar.I(view) - nVar.I(view2)) + 1;
        }
        return Math.min(hVar.h(), hVar.d(view2) - hVar.e(view));
    }

    static int b(RecyclerView.y yVar, h hVar, View view, View view2, RecyclerView.n nVar, boolean z5, boolean z6) {
        if (nVar.t() == 0 || yVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z6 ? Math.max(0, (yVar.a() - Math.max(nVar.I(view), nVar.I(view2))) - 1) : Math.max(0, Math.min(nVar.I(view), nVar.I(view2)));
        if (z5) {
            return Math.round((max * (Math.abs(hVar.d(view2) - hVar.e(view)) / (Math.abs(nVar.I(view) - nVar.I(view2)) + 1))) + (hVar.g() - hVar.e(view)));
        }
        return max;
    }

    static int c(RecyclerView.y yVar, h hVar, View view, View view2, RecyclerView.n nVar, boolean z5) {
        if (nVar.t() == 0 || yVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z5) {
            return yVar.a();
        }
        return (int) (((hVar.d(view2) - hVar.e(view)) / (Math.abs(nVar.I(view) - nVar.I(view2)) + 1)) * yVar.a());
    }
}

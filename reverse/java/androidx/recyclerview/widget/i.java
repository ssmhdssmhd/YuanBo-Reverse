package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.accessibility.x;
import androidx.core.view.accessibility.y;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class i extends androidx.core.view.a {

    /* renamed from: d, reason: collision with root package name */
    final RecyclerView f1270d;

    /* renamed from: e, reason: collision with root package name */
    private final a f1271e;

    public static class a extends androidx.core.view.a {

        /* renamed from: d, reason: collision with root package name */
        final i f1272d;

        /* renamed from: e, reason: collision with root package name */
        private Map<View, androidx.core.view.a> f1273e = new WeakHashMap();

        public a(i iVar) {
            this.f1272d = iVar;
        }

        @Override // androidx.core.view.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f1273e.get(view);
            return aVar != null ? aVar.a(view, accessibilityEvent) : super.a(view, accessibilityEvent);
        }

        @Override // androidx.core.view.a
        public y b(View view) {
            androidx.core.view.a aVar = this.f1273e.get(view);
            return aVar != null ? aVar.b(view) : super.b(view);
        }

        @Override // androidx.core.view.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f1273e.get(view);
            if (aVar != null) {
                aVar.f(view, accessibilityEvent);
            } else {
                super.f(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.a
        public void g(View view, x xVar) {
            if (!this.f1272d.o() && this.f1272d.f1270d.getLayoutManager() != null) {
                this.f1272d.f1270d.getLayoutManager().d0(view, xVar);
                androidx.core.view.a aVar = this.f1273e.get(view);
                if (aVar != null) {
                    aVar.g(view, xVar);
                    return;
                }
            }
            super.g(view, xVar);
        }

        @Override // androidx.core.view.a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f1273e.get(view);
            if (aVar != null) {
                aVar.h(view, accessibilityEvent);
            } else {
                super.h(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f1273e.get(viewGroup);
            return aVar != null ? aVar.i(viewGroup, view, accessibilityEvent) : super.i(viewGroup, view, accessibilityEvent);
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i6, Bundle bundle) {
            if (this.f1272d.o() || this.f1272d.f1270d.getLayoutManager() == null) {
                return super.j(view, i6, bundle);
            }
            androidx.core.view.a aVar = this.f1273e.get(view);
            if (aVar != null) {
                if (aVar.j(view, i6, bundle)) {
                    return true;
                }
            } else if (super.j(view, i6, bundle)) {
                return true;
            }
            return this.f1272d.f1270d.getLayoutManager().t0(view, i6, bundle);
        }

        @Override // androidx.core.view.a
        public void l(View view, int i6) {
            androidx.core.view.a aVar = this.f1273e.get(view);
            if (aVar != null) {
                aVar.l(view, i6);
            } else {
                super.l(view, i6);
            }
        }

        @Override // androidx.core.view.a
        public void m(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f1273e.get(view);
            if (aVar != null) {
                aVar.m(view, accessibilityEvent);
            } else {
                super.m(view, accessibilityEvent);
            }
        }

        androidx.core.view.a n(View view) {
            return this.f1273e.remove(view);
        }
    }

    public i(RecyclerView recyclerView) {
        this.f1270d = recyclerView;
        androidx.core.view.a n6 = n();
        this.f1271e = (n6 == null || !(n6 instanceof a)) ? new a(this) : (a) n6;
    }

    @Override // androidx.core.view.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || o()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().Z(accessibilityEvent);
        }
    }

    @Override // androidx.core.view.a
    public void g(View view, x xVar) {
        super.g(view, xVar);
        if (o() || this.f1270d.getLayoutManager() == null) {
            return;
        }
        this.f1270d.getLayoutManager().b0(xVar);
    }

    @Override // androidx.core.view.a
    public boolean j(View view, int i6, Bundle bundle) {
        if (super.j(view, i6, bundle)) {
            return true;
        }
        if (o() || this.f1270d.getLayoutManager() == null) {
            return false;
        }
        return this.f1270d.getLayoutManager().r0(i6, bundle);
    }

    public androidx.core.view.a n() {
        return this.f1271e;
    }

    boolean o() {
        return this.f1270d.L();
    }
}

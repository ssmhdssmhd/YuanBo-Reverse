package androidx.core.view;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.accessibility.x;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static final View.AccessibilityDelegate f448c = new View.AccessibilityDelegate();

    /* renamed from: a, reason: collision with root package name */
    private final View.AccessibilityDelegate f449a;

    /* renamed from: b, reason: collision with root package name */
    private final View.AccessibilityDelegate f450b;

    /* renamed from: androidx.core.view.a$a, reason: collision with other inner class name */
    static final class C0012a extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        final a f451a;

        C0012a(a aVar) {
            this.f451a = aVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f451a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            androidx.core.view.accessibility.y b6 = this.f451a.b(view);
            if (b6 != null) {
                return (AccessibilityNodeProvider) b6.a();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f451a.f(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            androidx.core.view.accessibility.x R = androidx.core.view.accessibility.x.R(accessibilityNodeInfo);
            R.N(s.t(view));
            R.L(s.r(view));
            R.M(s.g(view));
            R.P(s.o(view));
            this.f451a.g(view, R);
            R.d(accessibilityNodeInfo.getText(), view);
            List<x.a> c6 = a.c(view);
            for (int i6 = 0; i6 < c6.size(); i6++) {
                R.b(c6.get(i6));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f451a.h(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f451a.i(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i6, Bundle bundle) {
            return this.f451a.j(view, i6, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i6) {
            this.f451a.l(view, i6);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f451a.m(view, accessibilityEvent);
        }
    }

    static class b {
        static AccessibilityNodeProvider a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            return accessibilityDelegate.getAccessibilityNodeProvider(view);
        }

        static boolean b(View.AccessibilityDelegate accessibilityDelegate, View view, int i6, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i6, bundle);
        }
    }

    public a() {
        this(f448c);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f449a = accessibilityDelegate;
        this.f450b = new C0012a(this);
    }

    static List<x.a> c(View view) {
        List<x.a> list = (List) view.getTag(g.b.H);
        return list == null ? Collections.emptyList() : list;
    }

    private boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] l6 = androidx.core.view.accessibility.x.l(view.createAccessibilityNodeInfo().getText());
            for (int i6 = 0; l6 != null && i6 < l6.length; i6++) {
                if (clickableSpan.equals(l6[i6])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean k(int i6, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(g.b.I);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i6)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f449a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public androidx.core.view.accessibility.y b(View view) {
        AccessibilityNodeProvider a6 = b.a(this.f449a, view);
        if (a6 != null) {
            return new androidx.core.view.accessibility.y(a6);
        }
        return null;
    }

    View.AccessibilityDelegate d() {
        return this.f450b;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        this.f449a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(View view, androidx.core.view.accessibility.x xVar) {
        this.f449a.onInitializeAccessibilityNodeInfo(view, xVar.Q());
    }

    public void h(View view, AccessibilityEvent accessibilityEvent) {
        this.f449a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f449a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(View view, int i6, Bundle bundle) {
        List<x.a> c6 = c(view);
        boolean z5 = false;
        int i7 = 0;
        while (true) {
            if (i7 >= c6.size()) {
                break;
            }
            x.a aVar = c6.get(i7);
            if (aVar.a() == i6) {
                z5 = aVar.c(view, bundle);
                break;
            }
            i7++;
        }
        if (!z5) {
            z5 = b.b(this.f449a, view, i6, bundle);
        }
        return (z5 || i6 != g.b.f3910a || bundle == null) ? z5 : k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void l(View view, int i6) {
        this.f449a.sendAccessibilityEvent(view, i6);
    }

    public void m(View view, AccessibilityEvent accessibilityEvent) {
        this.f449a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}

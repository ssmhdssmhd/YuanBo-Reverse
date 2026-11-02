package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public final class g1 {

    static class a {
        static boolean a(ViewParent viewParent, View view, float f6, float f7, boolean z5) {
            return viewParent.onNestedFling(view, f6, f7, z5);
        }

        static boolean b(ViewParent viewParent, View view, float f6, float f7) {
            return viewParent.onNestedPreFling(view, f6, f7);
        }

        static void c(ViewParent viewParent, View view, int i6, int i7, int[] iArr) {
            viewParent.onNestedPreScroll(view, i6, i7, iArr);
        }

        static void d(ViewParent viewParent, View view, int i6, int i7, int i8, int i9) {
            viewParent.onNestedScroll(view, i6, i7, i8, i9);
        }

        static void e(ViewParent viewParent, View view, View view2, int i6) {
            viewParent.onNestedScrollAccepted(view, view2, i6);
        }

        static boolean f(ViewParent viewParent, View view, View view2, int i6) {
            return viewParent.onStartNestedScroll(view, view2, i6);
        }

        static void g(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f6, float f7, boolean z5) {
        try {
            return a.a(viewParent, view, f6, f7, z5);
        } catch (AbstractMethodError e6) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e6);
            return false;
        }
    }

    public static boolean b(ViewParent viewParent, View view, float f6, float f7) {
        try {
            return a.b(viewParent, view, f6, f7);
        } catch (AbstractMethodError e6) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e6);
            return false;
        }
    }

    public static void c(ViewParent viewParent, View view, int i6, int i7, int[] iArr, int i8) {
        if (viewParent instanceof m) {
            ((m) viewParent).c(view, i6, i7, iArr, i8);
            return;
        }
        if (i8 == 0) {
            try {
                a.c(viewParent, view, i6, i7, iArr);
            } catch (AbstractMethodError e6) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e6);
            }
        }
    }

    public static void d(ViewParent viewParent, View view, int i6, int i7, int i8, int i9, int i10, int[] iArr) {
        if (viewParent instanceof n) {
            ((n) viewParent).d(view, i6, i7, i8, i9, i10, iArr);
            return;
        }
        iArr[0] = iArr[0] + i8;
        iArr[1] = iArr[1] + i9;
        if (viewParent instanceof m) {
            ((m) viewParent).e(view, i6, i7, i8, i9, i10);
            return;
        }
        if (i10 == 0) {
            try {
                a.d(viewParent, view, i6, i7, i8, i9);
            } catch (AbstractMethodError e6) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e6);
            }
        }
    }

    public static void e(ViewParent viewParent, View view, View view2, int i6, int i7) {
        if (viewParent instanceof m) {
            ((m) viewParent).a(view, view2, i6, i7);
            return;
        }
        if (i7 == 0) {
            try {
                a.e(viewParent, view, view2, i6);
            } catch (AbstractMethodError e6) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e6);
            }
        }
    }

    public static boolean f(ViewParent viewParent, View view, View view2, int i6, int i7) {
        if (viewParent instanceof m) {
            return ((m) viewParent).f(view, view2, i6, i7);
        }
        if (i7 != 0) {
            return false;
        }
        try {
            return a.f(viewParent, view, view2, i6);
        } catch (AbstractMethodError e6) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e6);
            return false;
        }
    }

    public static void g(ViewParent viewParent, View view, int i6) {
        if (viewParent instanceof m) {
            ((m) viewParent).b(view, i6);
            return;
        }
        if (i6 == 0) {
            try {
                a.g(viewParent, view);
            } catch (AbstractMethodError e6) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e6);
            }
        }
    }
}

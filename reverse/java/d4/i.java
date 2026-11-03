package d4;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class i {

    public interface a {
        boolean a(View view);
    }

    public static boolean c(View view) {
        return i(view, new a() { // from class: d4.g
            @Override // d4.i.a
            public final boolean a(View view2) {
                boolean hasFocus;
                hasFocus = view2.hasFocus();
                return hasFocus;
            }
        });
    }

    public static int d(int i6) {
        return View.generateViewId();
    }

    public static Activity e(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return e(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static boolean f(View view, final Class<? extends View>[] clsArr) {
        return i(view, new a() { // from class: d4.h
            @Override // d4.i.a
            public final boolean a(View view2) {
                boolean h6;
                h6 = i.h(clsArr, view2);
                return h6;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean h(Class[] clsArr, View view) {
        for (Class cls : clsArr) {
            if (cls.isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    public static boolean i(View view, a aVar) {
        if (view == null) {
            return false;
        }
        if (aVar.a(view)) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
                if (i(viewGroup.getChildAt(i6), aVar)) {
                    return true;
                }
            }
        }
        return false;
    }
}

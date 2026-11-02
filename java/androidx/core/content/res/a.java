package androidx.core.content.res;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f419a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<Object, SparseArray<Object>> f420b = new WeakHashMap<>(0);

    /* renamed from: c, reason: collision with root package name */
    private static final Object f421c = new Object();

    /* renamed from: androidx.core.content.res.a$a, reason: collision with other inner class name */
    static class C0010a {
        static Drawable a(Resources resources, int i6, Resources.Theme theme) {
            return resources.getDrawable(i6, theme);
        }

        static Drawable b(Resources resources, int i6, int i7, Resources.Theme theme) {
            return resources.getDrawableForDensity(i6, i7, theme);
        }
    }

    public static Drawable a(Resources resources, int i6, Resources.Theme theme) {
        return C0010a.a(resources, i6, theme);
    }
}

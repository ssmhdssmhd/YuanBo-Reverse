package com.tendcloud.tenddata;

import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
public class p {
    public static boolean a(Object obj) {
        Object obj2;
        try {
            obj2 = obj.getClass().getMethod("getParentFragment", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
            obj2 = null;
        }
        try {
            if (obj2 == null) {
                if (!c(obj) && b(obj) && e(obj)) {
                    return true;
                }
            } else if (!c(obj) && b(obj) && e(obj) && !c(obj2) && b(obj2) && e(obj2)) {
                return true;
            }
        } catch (Exception unused2) {
        }
        return false;
    }

    public static boolean b(Object obj) {
        try {
            return ((Boolean) obj.getClass().getMethod("getUserVisibleHint", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean c(Object obj) {
        try {
            return ((Boolean) obj.getClass().getMethod("isHidden", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean d(Object obj) {
        Class<?> cls;
        Class<Fragment> cls2;
        Class<Fragment> cls3 = Fragment.class;
        if (obj == null) {
            return false;
        }
        try {
            cls = Class.forName("android.app.Fragment");
        } catch (Exception unused) {
            cls = null;
        }
        try {
            int i6 = Fragment.Y;
            cls2 = cls3;
        } catch (Exception unused2) {
            cls2 = null;
        }
        try {
            int i7 = Fragment.Y;
        } catch (Exception unused3) {
            cls3 = null;
        }
        if (cls2 == null && cls3 == null && cls == null) {
            return false;
        }
        if (cls2 != null) {
            try {
                if (cls2.isInstance(obj)) {
                    return true;
                }
            } catch (Exception unused4) {
            }
        }
        if (cls3 != null && cls3.isInstance(obj)) {
            return true;
        }
        if (cls != null) {
            if (cls.isInstance(obj)) {
                return true;
            }
        }
        return false;
    }

    public static boolean e(Object obj) {
        try {
            return ((Boolean) obj.getClass().getMethod("isResumed", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }
}

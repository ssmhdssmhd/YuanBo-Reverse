package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes.dex */
public class a extends androidx.core.content.a {

    /* renamed from: androidx.core.app.a$a, reason: collision with other inner class name */
    class RunnableC0008a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f317a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f318b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f319c;

        RunnableC0008a(String[] strArr, Activity activity, int i6) {
            this.f317a = strArr;
            this.f318b = activity;
            this.f319c = i6;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f317a.length];
            PackageManager packageManager = this.f318b.getPackageManager();
            String packageName = this.f318b.getPackageName();
            int length = this.f317a.length;
            for (int i6 = 0; i6 < length; i6++) {
                iArr[i6] = packageManager.checkPermission(this.f317a[i6], packageName);
            }
            ((c) this.f318b).onRequestPermissionsResult(this.f319c, this.f317a, iArr);
        }
    }

    static class b {
        static void a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        static void b(Activity activity, String[] strArr, int i6) {
            activity.requestPermissions(strArr, i6);
        }

        static boolean c(Activity activity, String str) {
            boolean shouldShowRequestPermissionRationale;
            shouldShowRequestPermissionRationale = activity.shouldShowRequestPermissionRationale(str);
            return shouldShowRequestPermissionRationale;
        }
    }

    public interface c {
        void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr);
    }

    public interface d {
    }

    public interface e {
        void b(int i6);
    }

    public static d g() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void h(Activity activity, String[] strArr, int i6) {
        HashSet hashSet = new HashSet();
        for (int i7 = 0; i7 < strArr.length; i7++) {
            if (TextUtils.isEmpty(strArr[i7])) {
                throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
            }
            if (!androidx.core.os.a.d() && TextUtils.equals(strArr[i7], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i7));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i8 = 0;
            for (int i9 = 0; i9 < strArr.length; i9++) {
                if (!hashSet.contains(Integer.valueOf(i9))) {
                    strArr2[i8] = strArr[i9];
                    i8++;
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof e) {
                ((e) activity).b(i6);
            }
            b.b(activity, strArr, i6);
        } else if (activity instanceof c) {
            new Handler(Looper.getMainLooper()).post(new RunnableC0008a(strArr2, activity, i6));
        }
    }

    public static boolean i(Activity activity, String str) {
        if ((androidx.core.os.a.d() || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) && Build.VERSION.SDK_INT >= 23) {
            return b.c(activity, str);
        }
        return false;
    }
}

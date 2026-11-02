package androidx.core.net;

import android.net.ConnectivityManager;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: androidx.core.net.a$a, reason: collision with other inner class name */
    static class C0011a {
        static boolean a(ConnectivityManager connectivityManager) {
            return connectivityManager.isActiveNetworkMetered();
        }
    }

    public static boolean a(ConnectivityManager connectivityManager) {
        return C0011a.a(connectivityManager);
    }
}

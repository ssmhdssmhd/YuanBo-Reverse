package i2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import com.tendcloud.tenddata.ab;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: e, reason: collision with root package name */
    private static a0 f5535e;

    /* renamed from: a, reason: collision with root package name */
    private final Handler f5536a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList<WeakReference<c>> f5537b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private final Object f5538c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private int f5539d = 0;

    private static final class b {

        private static final class a extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {

            /* renamed from: a, reason: collision with root package name */
            private final a0 f5540a;

            public a(a0 a0Var) {
                this.f5540a = a0Var;
            }

            @Override // android.telephony.TelephonyCallback.DisplayInfoListener
            public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
                int overrideNetworkType;
                overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
                this.f5540a.k(overrideNetworkType == 3 || overrideNetworkType == 4 || overrideNetworkType == 5 ? 10 : 5);
            }
        }

        public static void a(Context context, a0 a0Var) {
            Executor mainExecutor;
            try {
                TelephonyManager telephonyManager = (TelephonyManager) i2.a.e((TelephonyManager) context.getSystemService("phone"));
                a aVar = new a(a0Var);
                mainExecutor = context.getMainExecutor();
                telephonyManager.registerTelephonyCallback(mainExecutor, aVar);
                telephonyManager.unregisterTelephonyCallback(aVar);
            } catch (RuntimeException unused) {
                a0Var.k(5);
            }
        }
    }

    public interface c {
        void a(int i6);
    }

    private final class d extends BroadcastReceiver {
        private d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int g6 = a0.g(context);
            if (c1.f5548a < 31 || g6 != 5) {
                a0.this.k(g6);
            } else {
                b.a(context, a0.this);
            }
        }
    }

    private a0(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new d(), intentFilter);
    }

    public static synchronized a0 d(Context context) {
        a0 a0Var;
        synchronized (a0.class) {
            if (f5535e == null) {
                f5535e = new a0(context);
            }
            a0Var = f5535e;
        }
        return a0Var;
    }

    private static int e(NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
                return 3;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case ab.b.API_TYPE_INDUSTRY /* 17 */:
                return 4;
            case 13:
                return 5;
            case 16:
            case 19:
            default:
                return 6;
            case 18:
                return 2;
            case 20:
                return c1.f5548a >= 29 ? 9 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i6 = 0;
        if (connectivityManager == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i6 = 1;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 2;
                    }
                    if (type != 4 && type != 5) {
                        if (type != 6) {
                            return type != 9 ? 8 : 7;
                        }
                        return 5;
                    }
                }
                return e(activeNetworkInfo);
            }
        } catch (SecurityException unused) {
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(c cVar) {
        cVar.a(f());
    }

    private void j() {
        Iterator<WeakReference<c>> it = this.f5537b.iterator();
        while (it.hasNext()) {
            WeakReference<c> next = it.next();
            if (next.get() == null) {
                this.f5537b.remove(next);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i6) {
        synchronized (this.f5538c) {
            if (this.f5539d == i6) {
                return;
            }
            this.f5539d = i6;
            Iterator<WeakReference<c>> it = this.f5537b.iterator();
            while (it.hasNext()) {
                WeakReference<c> next = it.next();
                c cVar = next.get();
                if (cVar != null) {
                    cVar.a(i6);
                } else {
                    this.f5537b.remove(next);
                }
            }
        }
    }

    public int f() {
        int i6;
        synchronized (this.f5538c) {
            i6 = this.f5539d;
        }
        return i6;
    }

    public void i(final c cVar) {
        j();
        this.f5537b.add(new WeakReference<>(cVar));
        this.f5536a.post(new Runnable() { // from class: i2.z
            @Override // java.lang.Runnable
            public final void run() {
                a0.this.h(cVar);
            }
        });
    }
}

package com.tendcloud.tenddata;

import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;

/* loaded from: classes.dex */
public final class bo {

    /* renamed from: a, reason: collision with root package name */
    static Handler f2430a = null;

    /* renamed from: b, reason: collision with root package name */
    static HandlerThread f2431b = null;

    /* renamed from: c, reason: collision with root package name */
    private static final String f2432c = "check_wifi_permission";

    /* renamed from: d, reason: collision with root package name */
    private static final String f2433d = "check_bs_permission";

    /* renamed from: e, reason: collision with root package name */
    private static final String f2434e = "check_gps_permission";

    /* renamed from: f, reason: collision with root package name */
    private static final int f2435f = 1;

    /* renamed from: g, reason: collision with root package name */
    private static final int f2436g = 2;

    /* renamed from: h, reason: collision with root package name */
    private static final int f2437h = 3;

    /* renamed from: i, reason: collision with root package name */
    private static final int f2438i = 4;

    /* renamed from: j, reason: collision with root package name */
    private static final long f2439j = 600000;

    /* renamed from: k, reason: collision with root package name */
    private static volatile bo f2440k;

    /* renamed from: l, reason: collision with root package name */
    private static WifiManager f2441l;

    static {
        try {
            z.a().register(a());
        } catch (Throwable unused) {
        }
    }

    private bo() {
        try {
            HandlerThread handlerThread = new HandlerThread("locHandlerThread", 10);
            f2431b = handlerThread;
            handlerThread.start();
            f2430a = new Handler(f2431b.getLooper()) { // from class: com.tendcloud.tenddata.bo.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int i6 = message.what;
                    if (i6 != 1) {
                        if (i6 == 3) {
                            bo.this.c();
                            return;
                        } else if (i6 != 4) {
                            return;
                        } else {
                            bo.this.c();
                        }
                    }
                    bo.this.b();
                }
            };
            a(4, 0L);
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    public static bo a() {
        if (f2440k == null) {
            synchronized (bo.class) {
                if (f2440k == null) {
                    f2440k = new bo();
                }
            }
        }
        return f2440k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            if (!a(f2432c)) {
                a(1, 180000L);
                return;
            }
            WifiManager wifiManager = (WifiManager) ab.f2233g.getSystemService("wifi");
            f2441l = wifiManager;
            if (wifiManager.isWifiEnabled()) {
                ab.f2233g.registerReceiver(new bv(f2441l), new IntentFilter("android.net.wifi.SCAN_RESULTS"));
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            if (!a(f2433d)) {
                a(3, 180000L);
                return;
            }
            Context context = ab.f2233g;
            if (context != null) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager.getSimState() == 5) {
                        telephonyManager.getCellLocation();
                        telephonyManager.listen(new bu(), 16);
                        CellLocation.requestLocationUpdate();
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    protected void a(int i6, long j6) {
        try {
            Message obtain = Message.obtain();
            obtain.what = i6;
            f2430a.sendMessageDelayed(obtain, j6);
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0053 A[Catch: all -> 0x007a, TryCatch #0 {all -> 0x007a, blocks: (B:3:0x0001, B:5:0x0014, B:9:0x0022, B:23:0x0065, B:38:0x003f, B:41:0x0049, B:44:0x0053), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected boolean a(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            android.content.Context r1 = com.tendcloud.tenddata.ab.f2233g     // Catch: java.lang.Throwable -> L7a
            java.lang.String r2 = "android.permission.READ_PHONE_STATE"
            boolean r1 = com.tendcloud.tenddata.y.b(r1, r2)     // Catch: java.lang.Throwable -> L7a
            android.content.Context r2 = com.tendcloud.tenddata.ab.f2233g     // Catch: java.lang.Throwable -> L7a
            java.lang.String r3 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r2 = com.tendcloud.tenddata.y.b(r2, r3)     // Catch: java.lang.Throwable -> L7a
            r3 = 1
            if (r2 != 0) goto L21
            android.content.Context r2 = com.tendcloud.tenddata.ab.f2233g     // Catch: java.lang.Throwable -> L7a
            java.lang.String r4 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r2 = com.tendcloud.tenddata.y.b(r2, r4)     // Catch: java.lang.Throwable -> L7a
            if (r2 == 0) goto L1f
            goto L21
        L1f:
            r2 = 0
            goto L22
        L21:
            r2 = 1
        L22:
            android.content.Context r4 = com.tendcloud.tenddata.ab.f2233g     // Catch: java.lang.Throwable -> L7a
            java.lang.String r5 = "android.permission.ACCESS_WIFI_STATE"
            boolean r4 = com.tendcloud.tenddata.y.b(r4, r5)     // Catch: java.lang.Throwable -> L7a
            int r5 = r9.hashCode()     // Catch: java.lang.Throwable -> L7a
            r6 = -1215157370(0xffffffffb7922b86, float:-1.7424823E-5)
            r7 = 2
            if (r5 == r6) goto L53
            r6 = 1219872770(0x48b5c802, float:372288.06)
            if (r5 == r6) goto L49
            r6 = 1355887771(0x50d1349b, float:2.8079086E10)
            if (r5 == r6) goto L3f
            goto L5d
        L3f:
            java.lang.String r5 = "check_gps_permission"
            boolean r9 = r9.equals(r5)     // Catch: java.lang.Throwable -> L7a
            if (r9 == 0) goto L5d
            r9 = 1
            goto L5e
        L49:
            java.lang.String r5 = "check_wifi_permission"
            boolean r9 = r9.equals(r5)     // Catch: java.lang.Throwable -> L7a
            if (r9 == 0) goto L5d
            r9 = 2
            goto L5e
        L53:
            java.lang.String r5 = "check_bs_permission"
            boolean r9 = r9.equals(r5)     // Catch: java.lang.Throwable -> L7a
            if (r9 == 0) goto L5d
            r9 = 0
            goto L5e
        L5d:
            r9 = -1
        L5e:
            if (r9 == 0) goto L75
            if (r9 == r3) goto L74
            if (r9 == r7) goto L65
            goto L7a
        L65:
            r9 = 23
            boolean r9 = com.tendcloud.tenddata.y.a(r9)     // Catch: java.lang.Throwable -> L7a
            if (r9 == 0) goto L73
            if (r4 == 0) goto L72
            if (r2 == 0) goto L72
            r0 = 1
        L72:
            return r0
        L73:
            return r4
        L74:
            return r2
        L75:
            if (r2 == 0) goto L7a
            if (r1 == 0) goto L7a
            r0 = 1
        L7a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.bo.a(java.lang.String):boolean");
    }

    public final void onTDEBEventLocationEvent(bw bwVar) {
    }
}

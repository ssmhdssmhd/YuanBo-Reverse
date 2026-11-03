package com.tendcloud.tenddata;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.tendcloud.tenddata.an;
import com.tendcloud.tenddata.by;
import com.tendcloud.tenddata.n;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* loaded from: classes.dex */
public class cq {

    /* renamed from: a, reason: collision with root package name */
    private static String f2535a = "utf-8";

    /* renamed from: c, reason: collision with root package name */
    private static final int f2537c = 5;

    /* renamed from: d, reason: collision with root package name */
    private static final int f2538d = 30000;

    /* renamed from: g, reason: collision with root package name */
    private static final boolean f2539g = true;

    /* renamed from: h, reason: collision with root package name */
    private static final int f2540h = 65536;

    /* renamed from: j, reason: collision with root package name */
    private static HandlerThread f2542j;

    /* renamed from: e, reason: collision with root package name */
    private long f2543e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2544f = true;

    /* renamed from: k, reason: collision with root package name */
    private Handler f2545k;

    /* renamed from: b, reason: collision with root package name */
    private static final CRC32 f2536b = new CRC32();

    /* renamed from: i, reason: collision with root package name */
    private static volatile cq f2541i = null;

    static {
        try {
            z.a().register(a());
        } catch (Throwable unused) {
        }
    }

    private cq() {
        this.f2545k = null;
        HandlerThread handlerThread = new HandlerThread("ModuleDataForward", 10);
        f2542j = handlerThread;
        handlerThread.start();
        this.f2545k = new Handler(f2542j.getLooper()) { // from class: com.tendcloud.tenddata.cq.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                try {
                    Object obj = message.obj;
                    if (obj != null && (obj instanceof a)) {
                        cq.this.a((a) obj);
                    }
                    cq.this.b();
                } catch (Throwable th) {
                    bq.postSDKError(th);
                }
            }
        };
        b();
    }

    public static cq a() {
        if (f2541i == null) {
            synchronized (cq.class) {
                if (f2541i == null) {
                    f2541i = new cq();
                }
            }
        }
        return f2541i;
    }

    private static String a(TreeSet<cs> treeSet) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<cs> it = treeSet.iterator();
        while (it.hasNext()) {
            cs next = it.next();
            if (next.c() != null && next.c().length > 0) {
                sb.append(new String(next.c()));
                sb.append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        boolean a6;
        TreeSet<cs> a7;
        byte[] bArr;
        String str;
        if (o.b(ab.f2233g) && aVar.needToSendData()) {
            boolean z5 = false;
            try {
                a6 = n.a(n.b.getFeatureLockFileName(aVar.index()));
            } catch (Throwable th) {
                th = th;
            }
            if (!a6) {
                if (a6) {
                    n.releaseFileLock(n.b.getFeatureLockFileName(aVar.index()));
                    return;
                }
                return;
            }
            try {
                a7 = cr.a().a(aVar);
            } catch (Throwable th2) {
                th = th2;
                z5 = a6;
                try {
                    bq.postSDKError(th);
                    if (!z5) {
                        return;
                    }
                    return;
                } finally {
                    if (z5) {
                        n.releaseFileLock(n.b.getFeatureLockFileName(aVar.index()));
                    }
                }
            }
            if (a7 != null && a7.size() > 0) {
                a("New local data found!", aVar, false);
                byte[] a8 = a(a7, y.f(a(a7)));
                ap apVar = new ap();
                if (aVar.name().equals("PUSH")) {
                    bArr = null;
                } else {
                    bArr = u.a(a8);
                    apVar.a("decrypt-version", ab.P);
                }
                if (bArr != null) {
                    a8 = bArr;
                }
                CRC32 crc32 = f2536b;
                crc32.reset();
                crc32.update(a8);
                if (a8 != null && a8.length > 0) {
                    a("Submit local data to collector server ...", aVar, true);
                }
                StringBuilder sb = new StringBuilder(aVar.name().equals("SDK") ? s.b(ab.f2233g, ab.f2250x, ab.D, aVar.getUrl()) : aVar.getUrl());
                if (aVar.name().equals("TRACKING")) {
                    sb.append("/" + Long.toHexString(crc32.getValue()));
                    str = "/1";
                } else {
                    str = "/" + Long.toHexString(crc32.getValue());
                }
                sb.append(str);
                ar a9 = al.a(al.a().url(sb.toString()).body(new an(an.a.EMPTY, a8)).method(aq.POST).cert(aVar.getCert()).header(apVar).host(aVar.name().equals("SDK") ? s.b(ab.f2233g, ab.f2250x, ab.E, aVar.getHost()) : aVar.getHost()).ip(aVar.getIP()).build(), aVar);
                if (a9.b() == 200) {
                    this.f2543e = SystemClock.elapsedRealtime();
                    this.f2544f = true;
                    cr.a().sendMessageSuccess(aVar);
                    a("Data submitted successfully!", aVar, true);
                    ab.X.set(0);
                } else {
                    ab.X.incrementAndGet();
                    cr.a().sendMessageFaild(aVar);
                    this.f2544f = false;
                    a("Failed to submit data! Response code " + a9.b(), aVar, true);
                }
                if (a6) {
                    return;
                } else {
                    return;
                }
            }
            a("No new data found!", aVar, false);
            if (a6) {
                n.releaseFileLock(n.b.getFeatureLockFileName(aVar.index()));
            }
        }
    }

    private void a(String str, a aVar, boolean z5) {
        String str2 = "[" + aVar.name() + "] " + str;
        int index = aVar.index();
        if (index != 0 && index != 1 && index != 3 && index != 99 && index != 7 && index != 8) {
            h.iForInternal(str2);
        } else if (z5) {
            h.iForDeveloper(str2);
        } else {
            h.dForInternal(str2);
        }
    }

    private static byte[] a(TreeSet<cs> treeSet, byte[] bArr) {
        int size;
        try {
            if (bArr.length < f2540h || (size = treeSet.size()) == 1) {
                return bArr;
            }
            for (int i6 = 0; i6 < size / 2; i6++) {
                treeSet.pollLast();
            }
            return a(treeSet, y.f(a(treeSet)));
        } catch (Throwable unused) {
            return bArr;
        }
    }

    public static byte[] a(byte[] bArr) {
        BufferedInputStream bufferedInputStream;
        byte[] bArr2 = new byte[2048];
        try {
            bufferedInputStream = new BufferedInputStream(new InflaterInputStream(new ByteArrayInputStream(bArr), new Inflater(false)));
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = bufferedInputStream.read(bArr2);
                    if (read == -1) {
                        byteArrayOutputStream.close();
                        bufferedInputStream.close();
                        return byteArrayOutputStream.toByteArray();
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
            } catch (Exception unused) {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Exception unused2) {
            bufferedInputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0058 A[Catch: all -> 0x0069, LOOP:0: B:14:0x0052->B:16:0x0058, LOOP_END, TRY_LEAVE, TryCatch #0 {all -> 0x0069, blocks: (B:4:0x0009, B:6:0x001c, B:8:0x0020, B:9:0x0028, B:13:0x004a, B:14:0x0052, B:16:0x0058, B:21:0x002a, B:22:0x002d, B:24:0x0032, B:25:0x003f), top: B:3:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b() {
        /*
            r7 = this;
            android.os.Handler r0 = r7.f2545k
            r1 = 5
            boolean r0 = r0.hasMessages(r1)
            if (r0 != 0) goto L6d
            java.security.SecureRandom r0 = com.tendcloud.tenddata.y.b()     // Catch: java.lang.Throwable -> L69
            int[] r2 = com.tendcloud.tenddata.ab.a()     // Catch: java.lang.Throwable -> L69
            android.content.Context r3 = com.tendcloud.tenddata.ab.f2233g     // Catch: java.lang.Throwable -> L69
            boolean r3 = com.tendcloud.tenddata.o.i(r3)     // Catch: java.lang.Throwable -> L69
            r4 = 30000(0x7530, float:4.2039E-41)
            r5 = 1
            if (r3 == 0) goto L2d
            boolean r3 = r7.f2544f     // Catch: java.lang.Throwable -> L69
            if (r3 != 0) goto L2a
            r2 = r2[r5]     // Catch: java.lang.Throwable -> L69
            int r2 = r2 * 1
            int r0 = r0.nextInt(r4)     // Catch: java.lang.Throwable -> L69
        L28:
            int r2 = r2 + r0
            goto L42
        L2a:
            r2 = r2[r5]     // Catch: java.lang.Throwable -> L69
            goto L42
        L2d:
            boolean r3 = r7.f2544f     // Catch: java.lang.Throwable -> L69
            r6 = 0
            if (r3 != 0) goto L3f
            r2 = r2[r6]     // Catch: java.lang.Throwable -> L69
            int r2 = r2 * 1
            r3 = 60000(0xea60, float:8.4078E-41)
            int r0 = r0.nextInt(r3)     // Catch: java.lang.Throwable -> L69
            int r0 = r0 - r4
            goto L28
        L3f:
            r0 = r2[r6]     // Catch: java.lang.Throwable -> L69
            r2 = r0
        L42:
            r0 = 1800000(0x1b7740, float:2.522337E-39)
            if (r2 <= r0) goto L4a
            r2 = 1800000(0x1b7740, float:2.522337E-39)
        L4a:
            java.util.ArrayList r0 = com.tendcloud.tenddata.a.getFeaturesList()     // Catch: java.lang.Throwable -> L69
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L69
        L52:
            boolean r3 = r0.hasNext()     // Catch: java.lang.Throwable -> L69
            if (r3 == 0) goto L6d
            java.lang.Object r3 = r0.next()     // Catch: java.lang.Throwable -> L69
            com.tendcloud.tenddata.a r3 = (com.tendcloud.tenddata.a) r3     // Catch: java.lang.Throwable -> L69
            android.os.Handler r4 = r7.f2545k     // Catch: java.lang.Throwable -> L69
            android.os.Message r3 = android.os.Message.obtain(r4, r1, r3)     // Catch: java.lang.Throwable -> L69
            long r5 = (long) r2     // Catch: java.lang.Throwable -> L69
            r4.sendMessageDelayed(r3, r5)     // Catch: java.lang.Throwable -> L69
            goto L52
        L69:
            r0 = move-exception
            com.tendcloud.tenddata.bq.postSDKError(r0)
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.cq.b():void");
    }

    public final void onTDEBEventForwardRequest(by byVar) {
        if (byVar == null || ab.f2233g == null) {
            return;
        }
        if (byVar.f2491b.equals(by.a.IMMEDIATELY)) {
            if (this.f2545k.hasMessages(5, byVar.f2490a)) {
                this.f2545k.removeMessages(5);
            }
            Message.obtain(this.f2545k, 5, byVar.f2490a).sendToTarget();
        } else if (byVar.f2491b.equals(by.a.HIGH)) {
            if (this.f2545k.hasMessages(5)) {
                this.f2545k.removeMessages(5);
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f2543e;
            long j6 = ab.aa;
            long abs = Math.abs(elapsedRealtime - ab.aa);
            if (abs <= ab.aa) {
                j6 = abs;
            }
            this.f2545k.sendMessageDelayed(Message.obtain(this.f2545k, 5, byVar.f2490a), j6);
        }
    }
}

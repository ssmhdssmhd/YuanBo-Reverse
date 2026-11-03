package com.tendcloud.tenddata;

import android.util.EventLogTags;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class cr {

    /* renamed from: d, reason: collision with root package name */
    static byte[] f2549d;

    /* renamed from: a, reason: collision with root package name */
    static HashMap<String, String> f2546a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    static HashMap<String, String> f2547b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    static String f2548c = "utf-8";

    /* renamed from: e, reason: collision with root package name */
    private static volatile cr f2550e = null;

    static {
        try {
            z.a().register(a());
        } catch (Throwable unused) {
        }
    }

    private cr() {
        String c6 = y.c(ab.f2233g.getPackageName());
        if (ab.f2233g == null || c6 == null) {
            f2549d = ab.class.getSimpleName().getBytes();
        } else {
            f2549d = c6.getBytes();
        }
    }

    public static cr a() {
        if (f2550e == null) {
            synchronized (cr.class) {
                if (f2550e == null) {
                    f2550e = new cr();
                }
            }
        }
        return f2550e;
    }

    public TreeSet<cs> a(a aVar) {
        int size;
        TreeSet treeSet = new TreeSet();
        TreeSet<cs> treeSet2 = null;
        try {
            treeSet2 = ct.a().a(aVar, 100, (String) null);
            if (treeSet2 != null && treeSet2.size() > 0) {
                Iterator<cs> it = treeSet2.iterator();
                while (it.hasNext()) {
                    cs next = it.next();
                    try {
                        next.writeData(y.b(next.c(), f2549d));
                    } catch (Throwable unused) {
                    }
                }
                treeSet.addAll(treeSet2);
                treeSet2.clear();
            }
            size = treeSet2 == null ? 0 : treeSet2.size();
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
        synchronized (EventLogTags.class) {
            if (size < 100) {
                try {
                    TreeSet<cs> a6 = ct.a().a(aVar, 100 - size, aVar.getRootFolder());
                    if (a6 != null) {
                        try {
                            if (a6.size() > 0) {
                                Iterator<cs> it2 = a6.iterator();
                                while (it2.hasNext()) {
                                    cs next2 = it2.next();
                                    try {
                                        byte[] b6 = as.b(next2.c());
                                        if (b6 != null && b6.length != 0) {
                                            next2.writeData(b6);
                                        }
                                    } catch (Throwable unused2) {
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                    treeSet2 = a6;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            if (treeSet.size() > 0 && treeSet2 != null) {
                treeSet2.addAll(treeSet);
            }
            return treeSet2;
        }
    }

    public final synchronized void onTDEBEventDataStore(bz bzVar) {
        if (bzVar == null) {
            return;
        }
        try {
            if (bzVar.f2492a.getMessageFormat().equals(a.MF_JSON)) {
                if (bzVar.f2492a == null) {
                    return;
                }
                cx cxVar = new cx(bzVar.f2493b, bzVar.f2494c);
                cxVar.setData(bzVar.f2495d);
                JSONObject a6 = !bzVar.f2492a.name().equals("BG") ? dm.b().a(cxVar, true, bzVar.f2492a, bzVar.f2496e) : null;
                if (a6 == null) {
                } else {
                    ct.a().a(new cs(as.a(a6.toString().getBytes())), bzVar);
                }
            }
        } finally {
        }
    }

    public void sendMessageFaild(a aVar) {
        try {
            ct.a().clearDataCache(aVar);
        } catch (Throwable unused) {
        }
    }

    public void sendMessageSuccess(a aVar) {
        try {
            ct.a().confirmRead(aVar);
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }
}

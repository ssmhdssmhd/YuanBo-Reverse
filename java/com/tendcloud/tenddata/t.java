package com.tendcloud.tenddata;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class t {
    private t() {
    }

    public static String a(Context context, int i6) {
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == i6) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static List<f> a() {
        ArrayList arrayList = new ArrayList();
        try {
            for (File file : new File("/proc").listFiles()) {
                if (file != null && file.isDirectory()) {
                    try {
                        int parseInt = Integer.parseInt(file.getName());
                        f fVar = new f(-1);
                        int i6 = fVar.f2650b;
                        if ((i6 < 1000 || i6 > 9999) && !fVar.f2651c.contains(":") && !fVar.f2651c.contains("/")) {
                            arrayList.add(new f(parseInt));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return arrayList;
    }

    public static List<f> a(Context context) {
        int i6;
        ArrayList arrayList = new ArrayList();
        try {
            File[] listFiles = new File("/proc").listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (file != null && file.isDirectory()) {
                        try {
                            f fVar = new f(Integer.parseInt(file.getName()));
                            if (fVar.f2649a && (((i6 = fVar.f2650b) < 1000 || i6 > 9999) && !fVar.f2651c.contains(":") && !fVar.f2651c.contains("/"))) {
                                arrayList.add(fVar);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return arrayList;
    }

    public static List<ActivityManager.RunningAppProcessInfo> b(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 22) {
                return ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            }
            List<f> a6 = a();
            ArrayList arrayList = new ArrayList();
            for (f fVar : a6) {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo(fVar.f2651c, fVar.f2652d, null);
                runningAppProcessInfo.uid = fVar.f2650b;
                arrayList.add(runningAppProcessInfo);
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean b() {
        try {
            List<f> a6 = a();
            int myPid = Process.myPid();
            for (f fVar : a6) {
                if (fVar.f2652d == myPid && fVar.f2649a) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}

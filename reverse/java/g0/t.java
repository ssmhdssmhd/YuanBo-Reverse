package g0;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import androidx.core.app.k0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class t implements y3.m, y3.o {

    /* renamed from: a, reason: collision with root package name */
    private b f3954a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f3955b;

    /* renamed from: c, reason: collision with root package name */
    private Map<Integer, Integer> f3956c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f3957d = false;

    @FunctionalInterface
    interface a {
        void a(int i6);
    }

    @FunctionalInterface
    interface b {
        void a(Map<Integer, Integer> map);
    }

    @FunctionalInterface
    interface c {
        void a(boolean z5);
    }

    t() {
    }

    private int b(Context context) {
        List<String> b6 = v.b(context, 21);
        if (!(b6 == null || b6.isEmpty())) {
            return 1;
        }
        Log.d("permissions_handler", "Bluetooth permission missing in manifest");
        return 0;
    }

    private int c(Context context) {
        int checkSelfPermission;
        if (Build.VERSION.SDK_INT < 33) {
            return k0.d(context).a() ? 1 : 0;
        }
        checkSelfPermission = context.checkSelfPermission("android.permission.POST_NOTIFICATIONS");
        return checkSelfPermission == 0 ? 1 : 0;
    }

    private int e(int i6, Context context) {
        boolean isIgnoringBatteryOptimizations;
        boolean isExternalStorageManager;
        boolean isNotificationPolicyAccessGranted;
        boolean canRequestPackageInstalls;
        boolean canDrawOverlays;
        if (i6 == 17) {
            return c(context);
        }
        if (i6 == 21) {
            return b(context);
        }
        if ((i6 == 30 || i6 == 28 || i6 == 29) && Build.VERSION.SDK_INT < 31) {
            return b(context);
        }
        List<String> b6 = v.b(context, i6);
        if (b6 == null) {
            Log.d("permissions_handler", "No android specific permissions needed for: " + i6);
            return 1;
        }
        if (b6.size() == 0) {
            Log.d("permissions_handler", "No permissions found in manifest for: " + b6 + i6);
            if (i6 == 16 && Build.VERSION.SDK_INT < 23) {
                return 2;
            }
            if (i6 != 22 || Build.VERSION.SDK_INT >= 30) {
                return Build.VERSION.SDK_INT < 23 ? 1 : 0;
            }
            return 2;
        }
        boolean z5 = context.getApplicationInfo().targetSdkVersion >= 23;
        for (String str : b6) {
            if (z5) {
                if (i6 == 16) {
                    String packageName = context.getPackageName();
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    if (Build.VERSION.SDK_INT < 23) {
                        return 2;
                    }
                    if (powerManager != null) {
                        isIgnoringBatteryOptimizations = powerManager.isIgnoringBatteryOptimizations(packageName);
                        if (isIgnoringBatteryOptimizations) {
                            return 1;
                        }
                    }
                    return 0;
                }
                if (i6 == 22) {
                    if (Build.VERSION.SDK_INT < 30) {
                        return 2;
                    }
                    isExternalStorageManager = Environment.isExternalStorageManager();
                    return isExternalStorageManager ? 1 : 0;
                }
                if (i6 == 23 && Build.VERSION.SDK_INT >= 23) {
                    canDrawOverlays = Settings.canDrawOverlays(context);
                    return canDrawOverlays ? 1 : 0;
                }
                if (i6 == 24 && Build.VERSION.SDK_INT >= 26) {
                    canRequestPackageInstalls = context.getPackageManager().canRequestPackageInstalls();
                    return canRequestPackageInstalls ? 1 : 0;
                }
                if (i6 == 27 && Build.VERSION.SDK_INT >= 23) {
                    isNotificationPolicyAccessGranted = ((NotificationManager) context.getSystemService("notification")).isNotificationPolicyAccessGranted();
                    return isNotificationPolicyAccessGranted ? 1 : 0;
                }
                if (androidx.core.content.a.a(context, str) != 0) {
                    return 0;
                }
            }
        }
        return 1;
    }

    private void f(String str, int i6) {
        String packageName = this.f3955b.getPackageName();
        Intent intent = new Intent();
        intent.setAction(str);
        intent.setData(Uri.parse("package:" + packageName));
        this.f3955b.startActivityForResult(intent, i6);
    }

    private void g(String str, int i6) {
        this.f3955b.startActivityForResult(new Intent(str), i6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v11, types: [int] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v8 */
    @Override // y3.m
    public boolean a(int i6, int i7, Intent intent) {
        boolean isNotificationPolicyAccessGranted;
        int i8;
        boolean canRequestPackageInstalls;
        boolean canDrawOverlays;
        ?? r9;
        boolean isExternalStorageManager;
        if (i6 != 209 && i6 != 210 && i6 != 211 && i6 != 212 && i6 != 213) {
            return false;
        }
        boolean z5 = i7 == -1;
        if (i6 == 209) {
            i8 = 16;
            r9 = z5;
        } else if (i6 == 210) {
            if (Build.VERSION.SDK_INT < 30) {
                return false;
            }
            isExternalStorageManager = Environment.isExternalStorageManager();
            i8 = 22;
            r9 = isExternalStorageManager;
        } else if (i6 == 211) {
            if (Build.VERSION.SDK_INT < 23) {
                return false;
            }
            canDrawOverlays = Settings.canDrawOverlays(this.f3955b);
            r9 = canDrawOverlays;
            i8 = 23;
        } else if (i6 == 212) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            canRequestPackageInstalls = this.f3955b.getPackageManager().canRequestPackageInstalls();
            i8 = 24;
            r9 = canRequestPackageInstalls;
        } else {
            if (i6 != 213 || Build.VERSION.SDK_INT < 23) {
                return false;
            }
            isNotificationPolicyAccessGranted = ((NotificationManager) this.f3955b.getSystemService("notification")).isNotificationPolicyAccessGranted();
            i8 = 27;
            r9 = isNotificationPolicyAccessGranted;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(i8), Integer.valueOf((int) r9));
        this.f3954a.a(hashMap);
        return true;
    }

    void d(int i6, Context context, a aVar) {
        aVar.a(e(i6, context));
    }

    void h(List<Integer> list, Activity activity, b bVar, g0.b bVar2) {
        int i6;
        Map<Integer, Integer> map;
        Map<Integer, Integer> map2;
        int i7;
        String str;
        int i8;
        String str2;
        if (this.f3957d) {
            str2 = "A request for permissions is already running, please wait for it to finish before doing another request (note that you can request multiple permissions at the same time).";
        } else {
            if (activity != null) {
                this.f3954a = bVar;
                this.f3955b = activity;
                this.f3956c = new HashMap();
                ArrayList arrayList = new ArrayList();
                Iterator<Integer> it = list.iterator();
                while (true) {
                    int i9 = 1;
                    if (!it.hasNext()) {
                        break;
                    }
                    Integer next = it.next();
                    if (e(next.intValue(), activity) != 1) {
                        List<String> b6 = v.b(activity, next.intValue());
                        if (b6 != null && !b6.isEmpty()) {
                            int i10 = Build.VERSION.SDK_INT;
                            if (i10 >= 23 && next.intValue() == 16) {
                                str = "android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS";
                                i8 = 209;
                            } else if (i10 >= 30 && next.intValue() == 22) {
                                str = "android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION";
                                i8 = 210;
                            } else if (i10 >= 23 && next.intValue() == 23) {
                                str = "android.settings.action.MANAGE_OVERLAY_PERMISSION";
                                i8 = 211;
                            } else if (i10 >= 26 && next.intValue() == 24) {
                                str = "android.settings.MANAGE_UNKNOWN_APP_SOURCES";
                                i8 = 212;
                            } else if (i10 < 23 || next.intValue() != 27) {
                                arrayList.addAll(b6);
                            } else {
                                g("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS", 213);
                            }
                            f(str, i8);
                        } else if (!this.f3956c.containsKey(next)) {
                            i9 = 2;
                            if (next.intValue() != 16 || Build.VERSION.SDK_INT >= 23) {
                                map2 = this.f3956c;
                                i7 = 0;
                            } else {
                                map2 = this.f3956c;
                                i7 = 2;
                            }
                            map2.put(next, i7);
                            if (next.intValue() != 22 || Build.VERSION.SDK_INT >= 30) {
                                map = this.f3956c;
                                i6 = 0;
                            }
                            map = this.f3956c;
                            i6 = Integer.valueOf(i9);
                        }
                    } else if (!this.f3956c.containsKey(next)) {
                        map = this.f3956c;
                        i6 = Integer.valueOf(i9);
                    }
                    map.put(next, i6);
                }
                String[] strArr = (String[]) arrayList.toArray(new String[0]);
                if (arrayList.size() > 0) {
                    this.f3957d = true;
                    androidx.core.app.a.h(activity, strArr, 24);
                    return;
                } else {
                    this.f3957d = false;
                    if (this.f3956c.size() > 0) {
                        bVar.a(this.f3956c);
                        return;
                    }
                    return;
                }
            }
            Log.d("permissions_handler", "Unable to detect current Activity.");
            str2 = "Unable to detect current Android Activity.";
        }
        bVar2.a("PermissionHandler.PermissionManager", str2);
    }

    void i(int i6, Activity activity, c cVar, g0.b bVar) {
        if (activity == null) {
            Log.d("permissions_handler", "Unable to detect current Activity.");
            bVar.a("PermissionHandler.PermissionManager", "Unable to detect current Android Activity.");
            return;
        }
        List<String> b6 = v.b(activity, i6);
        if (b6 == null) {
            Log.d("permissions_handler", "No android specific permissions needed for: " + i6);
            cVar.a(false);
            return;
        }
        if (!b6.isEmpty()) {
            cVar.a(androidx.core.app.a.i(activity, b6.get(0)));
            return;
        }
        Log.d("permissions_handler", "No permissions found in manifest for: " + i6 + " no need to show request rationale");
        cVar.a(false);
    }

    @Override // y3.o
    public boolean onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        Map<Integer, Integer> map;
        int valueOf;
        int g6;
        Map<Integer, Integer> map2;
        int valueOf2;
        if (i6 != 24) {
            this.f3957d = false;
            return false;
        }
        if (this.f3956c == null) {
            return false;
        }
        for (int i7 = 0; i7 < strArr.length; i7++) {
            String str = strArr[i7];
            int f6 = v.f(str);
            if (f6 != 20) {
                int i8 = iArr[i7];
                if (f6 == 7) {
                    if (!this.f3956c.containsKey(7)) {
                        this.f3956c.put(7, Integer.valueOf(v.g(this.f3955b, str, i8)));
                    }
                    if (!this.f3956c.containsKey(14)) {
                        map = this.f3956c;
                        valueOf = 14;
                        map.put(valueOf, Integer.valueOf(v.g(this.f3955b, str, i8)));
                    }
                    v.h(this.f3955b, f6);
                } else if (f6 == 4) {
                    g6 = v.g(this.f3955b, str, i8);
                    if (!this.f3956c.containsKey(4)) {
                        map2 = this.f3956c;
                        valueOf2 = 4;
                        map2.put(valueOf2, Integer.valueOf(g6));
                    }
                    v.h(this.f3955b, f6);
                } else if (f6 == 3) {
                    g6 = v.g(this.f3955b, str, i8);
                    if (Build.VERSION.SDK_INT < 29 && !this.f3956c.containsKey(4)) {
                        this.f3956c.put(4, Integer.valueOf(g6));
                    }
                    if (!this.f3956c.containsKey(5)) {
                        this.f3956c.put(5, Integer.valueOf(g6));
                    }
                    map2 = this.f3956c;
                    valueOf2 = Integer.valueOf(f6);
                    map2.put(valueOf2, Integer.valueOf(g6));
                    v.h(this.f3955b, f6);
                } else {
                    if (!this.f3956c.containsKey(Integer.valueOf(f6))) {
                        map = this.f3956c;
                        valueOf = Integer.valueOf(f6);
                        map.put(valueOf, Integer.valueOf(v.g(this.f3955b, str, i8)));
                    }
                    v.h(this.f3955b, f6);
                }
            }
        }
        this.f3954a.a(this.f3956c);
        this.f3957d = false;
        return true;
    }
}

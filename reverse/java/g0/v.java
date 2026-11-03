package g0;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class v {
    private static String a(Context context, String str) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 31 && d(context, null, str)) {
            return str;
        }
        if (i6 >= 29) {
            if (i6 < 29 || !d(context, null, "android.permission.ACCESS_FINE_LOCATION")) {
                return null;
            }
            return "android.permission.ACCESS_FINE_LOCATION";
        }
        if (d(context, null, "android.permission.ACCESS_FINE_LOCATION")) {
            return "android.permission.ACCESS_FINE_LOCATION";
        }
        if (d(context, null, "android.permission.ACCESS_COARSE_LOCATION")) {
            return "android.permission.ACCESS_COARSE_LOCATION";
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0161, code lost:
    
        if (d(r5, r0, "android.permission.READ_MEDIA_IMAGES") != false) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x01e7, code lost:
    
        if (d(r5, r0, "android.permission.RECORD_AUDIO") != false) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x01f5, code lost:
    
        if (d(r5, r0, "android.permission.ACCESS_BACKGROUND_LOCATION") != false) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0209, code lost:
    
        if (d(r5, r0, "android.permission.ACCESS_FINE_LOCATION") == false) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0234, code lost:
    
        if (d(r5, r0, "android.permission.CAMERA") != false) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x024b, code lost:
    
        if (d(r5, r0, "android.permission.WRITE_CALENDAR") != false) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
    
        if (r5 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005e, code lost:
    
        if (r5 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0067, code lost:
    
        if (r5 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0092, code lost:
    
        if (d(r5, r0, "android.permission.SYSTEM_ALERT_WINDOW") != false) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0236, code lost:
    
        r0.add(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ad, code lost:
    
        if (d(r5, r0, "android.permission.BLUETOOTH") != false) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00ea, code lost:
    
        if (d(r5, r0, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS") != false) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0103, code lost:
    
        if (r6 != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0153, code lost:
    
        if (d(r5, r0, "android.permission.BODY_SENSORS") != false) goto L169;
     */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0200  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static java.util.List<java.lang.String> b(android.content.Context r5, int r6) {
        /*
            Method dump skipped, instructions count: 666
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.v.b(android.content.Context, int):java.util.List");
    }

    private static PackageInfo c(Context context) {
        PackageManager packageManager = context.getPackageManager();
        int i6 = Build.VERSION.SDK_INT;
        String packageName = context.getPackageName();
        return i6 >= 33 ? packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(4096L)) : packageManager.getPackageInfo(packageName, 4096);
    }

    private static boolean d(Context context, ArrayList<String> arrayList, String str) {
        if (arrayList != null) {
            try {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(str)) {
                        return true;
                    }
                }
            } catch (Exception e6) {
                Log.d("permissions_handler", "Unable to check manifest for permission: ", e6);
            }
        }
        if (context == null) {
            Log.d("permissions_handler", "Unable to detect current Activity or App Context.");
            return false;
        }
        PackageInfo c6 = c(context);
        if (c6 == null) {
            Log.d("permissions_handler", "Unable to get Package info, will not be able to determine permissions to request.");
            return false;
        }
        Iterator it2 = new ArrayList(Arrays.asList(c6.requestedPermissions)).iterator();
        while (it2.hasNext()) {
            if (((String) it2.next()).equals(str)) {
                return true;
            }
        }
        return false;
    }

    static boolean e(Activity activity, String str) {
        if (activity == null) {
            return false;
        }
        return !androidx.core.app.a.i(activity, str);
    }

    static int f(String str) {
        str.hashCode();
        switch (str) {
            case "android.permission.READ_SMS":
            case "android.permission.RECEIVE_WAP_PUSH":
            case "android.permission.RECEIVE_MMS":
            case "android.permission.RECEIVE_SMS":
            case "android.permission.SEND_SMS":
                return 13;
            case "android.permission.READ_CALENDAR":
            case "android.permission.WRITE_CALENDAR":
                return 0;
            case "android.permission.POST_NOTIFICATIONS":
                return 17;
            case "android.permission.READ_CALL_LOG":
            case "android.permission.READ_PHONE_NUMBERS":
            case "android.permission.BIND_CALL_REDIRECTION_SERVICE":
            case "android.permission.READ_PHONE_STATE":
            case "android.permission.CALL_PHONE":
            case "android.permission.WRITE_CALL_LOG":
            case "android.permission.USE_SIP":
            case "com.android.voicemail.permission.ADD_VOICEMAIL":
                return 8;
            case "android.permission.ACCESS_FINE_LOCATION":
            case "android.permission.ACCESS_COARSE_LOCATION":
                return 3;
            case "android.permission.MANAGE_EXTERNAL_STORAGE":
                return 22;
            case "android.permission.ACCESS_NOTIFICATION_POLICY":
                return 27;
            case "android.permission.SYSTEM_ALERT_WINDOW":
                return 23;
            case "android.permission.BODY_SENSORS":
                return 12;
            case "android.permission.NEARBY_WIFI_DEVICES":
                return 31;
            case "android.permission.BLUETOOTH_CONNECT":
                return 30;
            case "android.permission.READ_EXTERNAL_STORAGE":
            case "android.permission.WRITE_EXTERNAL_STORAGE":
                return 15;
            case "android.permission.READ_MEDIA_IMAGES":
                return 9;
            case "android.permission.WRITE_CONTACTS":
            case "android.permission.GET_ACCOUNTS":
            case "android.permission.READ_CONTACTS":
                return 2;
            case "android.permission.CAMERA":
                return 1;
            case "android.permission.READ_MEDIA_AUDIO":
                return 33;
            case "android.permission.READ_MEDIA_VIDEO":
                return 32;
            case "android.permission.SCHEDULE_EXACT_ALARM":
                return 34;
            case "android.permission.BLUETOOTH_ADVERTISE":
                return 29;
            case "android.permission.REQUEST_INSTALL_PACKAGES":
                return 24;
            case "android.permission.ACTIVITY_RECOGNITION":
                return 19;
            case "android.permission.RECORD_AUDIO":
                return 7;
            case "android.permission.ACCESS_BACKGROUND_LOCATION":
                return 4;
            case "android.permission.BLUETOOTH_SCAN":
                return 28;
            case "android.permission.ACCESS_MEDIA_LOCATION":
                return 18;
            default:
                return 20;
        }
    }

    static int g(Activity activity, String str, int i6) {
        if (i6 == -1) {
            return (Build.VERSION.SDK_INT < 23 || !e(activity, str)) ? 0 : 4;
        }
        return 1;
    }

    static void h(Activity activity, int i6) {
        List<String> b6;
        if (activity == null || (b6 = b(activity, i6)) == null) {
            return;
        }
        b6.isEmpty();
    }
}

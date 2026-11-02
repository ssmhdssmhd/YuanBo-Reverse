package g0;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.util.List;

/* loaded from: classes.dex */
final class x {

    @FunctionalInterface
    interface a {
        void a(int i6);
    }

    x() {
    }

    private List<ResolveInfo> b(PackageManager packageManager) {
        Intent intent = new Intent("android.intent.action.CALL");
        intent.setData(Uri.parse("tel:123123"));
        return Build.VERSION.SDK_INT >= 33 ? packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(0L)) : packageManager.queryIntentActivities(intent, 0);
    }

    private boolean c(Context context) {
        return ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter().isEnabled();
    }

    private boolean d(Context context) {
        Object systemService;
        boolean isLocationEnabled;
        if (Build.VERSION.SDK_INT < 28) {
            return e(context);
        }
        systemService = context.getSystemService((Class<Object>) LocationManager.class);
        LocationManager locationManager = (LocationManager) systemService;
        if (locationManager == null) {
            return false;
        }
        isLocationEnabled = locationManager.isLocationEnabled();
        return isLocationEnabled;
    }

    private static boolean e(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode") != 0;
        } catch (Settings.SettingNotFoundException e6) {
            e6.printStackTrace();
            return false;
        }
    }

    void a(int i6, Context context, a aVar, b bVar) {
        if (context == null) {
            Log.d("permissions_handler", "Context cannot be null.");
            bVar.a("PermissionHandler.ServiceManager", "Android context cannot be null.");
            return;
        }
        if (i6 == 3 || i6 == 4 || i6 == 5) {
            aVar.a(d(context) ? 1 : 0);
            return;
        }
        if (i6 == 21) {
            aVar.a(c(context) ? 1 : 0);
        }
        if (i6 != 8) {
            if (i6 == 16) {
                aVar.a(Build.VERSION.SDK_INT < 23 ? 2 : 1);
                return;
            } else {
                aVar.a(2);
                return;
            }
        }
        PackageManager packageManager = context.getPackageManager();
        if (!packageManager.hasSystemFeature("android.hardware.telephony")) {
            aVar.a(2);
            return;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null || telephonyManager.getPhoneType() == 0) {
            aVar.a(2);
            return;
        }
        if (b(packageManager).isEmpty()) {
            aVar.a(2);
        } else if (telephonyManager.getSimState() != 5) {
            aVar.a(0);
        } else {
            aVar.a(1);
        }
    }
}

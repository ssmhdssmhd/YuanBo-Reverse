package i2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

/* loaded from: classes.dex */
public final class g0 {
    public static void a(Context context, String str, int i6, int i7, int i8) {
        if (c1.f5548a >= 26) {
            NotificationManager notificationManager = (NotificationManager) a.e((NotificationManager) context.getSystemService("notification"));
            NotificationChannel notificationChannel = new NotificationChannel(str, context.getString(i6), i8);
            if (i7 != 0) {
                notificationChannel.setDescription(context.getString(i7));
            }
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}

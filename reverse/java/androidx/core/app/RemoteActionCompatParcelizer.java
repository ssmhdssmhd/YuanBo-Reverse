package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(androidx.versionedparcelable.a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f311a = (IconCompat) aVar.v(remoteActionCompat.f311a, 1);
        remoteActionCompat.f312b = aVar.l(remoteActionCompat.f312b, 2);
        remoteActionCompat.f313c = aVar.l(remoteActionCompat.f313c, 3);
        remoteActionCompat.f314d = (PendingIntent) aVar.r(remoteActionCompat.f314d, 4);
        remoteActionCompat.f315e = aVar.h(remoteActionCompat.f315e, 5);
        remoteActionCompat.f316f = aVar.h(remoteActionCompat.f316f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, androidx.versionedparcelable.a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f311a, 1);
        aVar.D(remoteActionCompat.f312b, 2);
        aVar.D(remoteActionCompat.f313c, 3);
        aVar.H(remoteActionCompat.f314d, 4);
        aVar.z(remoteActionCompat.f315e, 5);
        aVar.z(remoteActionCompat.f316f, 6);
    }
}

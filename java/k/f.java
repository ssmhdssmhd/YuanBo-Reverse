package k;

import android.media.session.MediaSessionManager;

/* loaded from: classes.dex */
final class f extends g {

    /* renamed from: d, reason: collision with root package name */
    final MediaSessionManager.RemoteUserInfo f6853d;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    f(android.media.session.MediaSessionManager.RemoteUserInfo r4) {
        /*
            r3 = this;
            java.lang.String r0 = k.c.a(r4)
            int r1 = k.d.a(r4)
            int r2 = k.e.a(r4)
            r3.<init>(r0, r1, r2)
            r3.f6853d = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k.f.<init>(android.media.session.MediaSessionManager$RemoteUserInfo):void");
    }

    f(String str, int i6, int i7) {
        super(str, i6, i7);
        this.f6853d = new MediaSessionManager.RemoteUserInfo(str, i6, i7);
    }

    static String a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        String packageName;
        packageName = remoteUserInfo.getPackageName();
        return packageName;
    }
}

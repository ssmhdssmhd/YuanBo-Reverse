package k;

import android.media.session.MediaSessionManager;
import android.os.Build;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    b f6852a;

    public a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        String a6 = f.a(remoteUserInfo);
        if (a6 == null) {
            throw new NullPointerException("package shouldn't be null");
        }
        if (TextUtils.isEmpty(a6)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        this.f6852a = new f(remoteUserInfo);
    }

    public a(String str, int i6, int i7) {
        if (str == null) {
            throw new NullPointerException("package shouldn't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        this.f6852a = Build.VERSION.SDK_INT >= 28 ? new f(str, i6, i7) : new g(str, i6, i7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            return this.f6852a.equals(((a) obj).f6852a);
        }
        return false;
    }

    public int hashCode() {
        return this.f6852a.hashCode();
    }
}

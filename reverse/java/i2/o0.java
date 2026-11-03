package i2;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* loaded from: classes.dex */
public class o0 implements e {
    protected o0() {
    }

    @Override // i2.e
    public long a() {
        return SystemClock.uptimeMillis();
    }

    @Override // i2.e
    public p b(Looper looper, Handler.Callback callback) {
        return new p0(new Handler(looper, callback));
    }

    @Override // i2.e
    public void c() {
    }

    @Override // i2.e
    public long d() {
        return SystemClock.elapsedRealtime();
    }
}

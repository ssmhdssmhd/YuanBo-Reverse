package h0;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import h0.o;

/* loaded from: classes.dex */
public class k3 extends Exception implements o {

    /* renamed from: c, reason: collision with root package name */
    private static final String f4545c = i2.c1.s0(0);

    /* renamed from: d, reason: collision with root package name */
    private static final String f4546d = i2.c1.s0(1);

    /* renamed from: e, reason: collision with root package name */
    private static final String f4547e = i2.c1.s0(2);

    /* renamed from: j, reason: collision with root package name */
    private static final String f4548j = i2.c1.s0(3);

    /* renamed from: k, reason: collision with root package name */
    private static final String f4549k = i2.c1.s0(4);

    /* renamed from: l, reason: collision with root package name */
    public static final o.a<k3> f4550l = new o.a() { // from class: h0.j3
        @Override // h0.o.a
        public final o a(Bundle bundle) {
            return new k3(bundle);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final int f4551a;

    /* renamed from: b, reason: collision with root package name */
    public final long f4552b;

    protected k3(Bundle bundle) {
        this(bundle.getString(f4547e), c(bundle), bundle.getInt(f4545c, 1000), bundle.getLong(f4546d, SystemClock.elapsedRealtime()));
    }

    protected k3(String str, Throwable th, int i6, long j6) {
        super(str, th);
        this.f4551a = i6;
        this.f4552b = j6;
    }

    private static RemoteException a(String str) {
        return new RemoteException(str);
    }

    private static Throwable b(Class<?> cls, String str) {
        return (Throwable) cls.getConstructor(String.class).newInstance(str);
    }

    private static Throwable c(Bundle bundle) {
        String string = bundle.getString(f4548j);
        String string2 = bundle.getString(f4549k);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(string, true, k3.class.getClassLoader());
            Throwable b6 = Throwable.class.isAssignableFrom(cls) ? b(cls, string2) : null;
            if (b6 != null) {
                return b6;
            }
        } catch (Throwable unused) {
        }
        return a(string2);
    }
}

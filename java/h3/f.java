package h3;

import android.app.Activity;
import h3.a;
import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private Activity f5237a;

    private final boolean a() {
        Activity activity = this.f5237a;
        k.b(activity);
        return (activity.getWindow().getAttributes().flags & 128) != 0;
    }

    public final a.C0084a b() {
        if (this.f5237a == null) {
            throw new e();
        }
        a.C0084a c0084a = new a.C0084a();
        c0084a.b(Boolean.valueOf(a()));
        return c0084a;
    }

    public final void c(Activity activity) {
        this.f5237a = activity;
    }

    public final void d(a.b message) {
        k.e(message, "message");
        Activity activity = this.f5237a;
        if (activity == null) {
            throw new e();
        }
        k.b(activity);
        boolean a6 = a();
        Boolean b6 = message.b();
        k.b(b6);
        if (b6.booleanValue()) {
            if (a6) {
                return;
            }
            activity.getWindow().addFlags(128);
        } else if (a6) {
            activity.getWindow().clearFlags(128);
        }
    }
}

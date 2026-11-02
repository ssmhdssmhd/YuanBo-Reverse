package androidx.work;

import android.content.Context;
import androidx.work.a;
import java.util.Collections;
import java.util.List;
import v.j;
import v.t;

/* loaded from: classes.dex */
public final class WorkManagerInitializer implements s.a<t> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1472a = j.f("WrkMgrInitializer");

    @Override // s.a
    public List<Class<? extends s.a<?>>> a() {
        return Collections.emptyList();
    }

    @Override // s.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public t b(Context context) {
        j.c().a(f1472a, "Initializing WorkManager with default configuration.", new Throwable[0]);
        t.f(context, new a.b().a());
        return t.d(context);
    }
}

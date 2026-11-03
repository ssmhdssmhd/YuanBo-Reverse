package dev.fluttercommunity.plus.share;

import android.content.Context;
import android.content.Intent;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.g;
import y3.k;
import y3.m;

/* loaded from: classes.dex */
public final class a implements m {

    /* renamed from: d, reason: collision with root package name */
    public static final C0064a f3304d = new C0064a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Context f3305a;

    /* renamed from: b, reason: collision with root package name */
    private k.d f3306b;

    /* renamed from: c, reason: collision with root package name */
    private AtomicBoolean f3307c;

    /* renamed from: dev.fluttercommunity.plus.share.a$a, reason: collision with other inner class name */
    public static final class C0064a {
        private C0064a() {
        }

        public /* synthetic */ C0064a(g gVar) {
            this();
        }
    }

    public a(Context context) {
        kotlin.jvm.internal.k.e(context, "context");
        this.f3305a = context;
        this.f3307c = new AtomicBoolean(true);
    }

    private final void b(String str) {
        k.d dVar;
        if (!this.f3307c.compareAndSet(false, true) || (dVar = this.f3306b) == null) {
            return;
        }
        kotlin.jvm.internal.k.b(dVar);
        dVar.b(str);
        this.f3306b = null;
    }

    @Override // y3.m
    public boolean a(int i6, int i7, Intent intent) {
        if (i6 != 22643) {
            return false;
        }
        b(SharePlusPendingIntent.f3302a.a());
        return true;
    }

    public final boolean c(k.d callback) {
        kotlin.jvm.internal.k.e(callback, "callback");
        if (!this.f3307c.compareAndSet(true, false)) {
            callback.a("Share callback error", "prior share-sheet did not call back, did you await it? Maybe use non-result variant", null);
            return false;
        }
        SharePlusPendingIntent.f3302a.b("");
        this.f3307c.set(false);
        this.f3306b = callback;
        return true;
    }

    public final void d() {
        b("dev.fluttercommunity.plus/share/unavailable");
    }
}

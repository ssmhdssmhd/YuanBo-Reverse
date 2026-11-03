package b0;

import android.content.Context;

/* loaded from: classes.dex */
public class i {

    /* renamed from: e, reason: collision with root package name */
    private static i f1689e;

    /* renamed from: a, reason: collision with root package name */
    private a f1690a;

    /* renamed from: b, reason: collision with root package name */
    private b f1691b;

    /* renamed from: c, reason: collision with root package name */
    private g f1692c;

    /* renamed from: d, reason: collision with root package name */
    private h f1693d;

    private i(Context context, f0.a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.f1690a = new a(applicationContext, aVar);
        this.f1691b = new b(applicationContext, aVar);
        this.f1692c = new g(applicationContext, aVar);
        this.f1693d = new h(applicationContext, aVar);
    }

    public static synchronized i c(Context context, f0.a aVar) {
        i iVar;
        synchronized (i.class) {
            if (f1689e == null) {
                f1689e = new i(context, aVar);
            }
            iVar = f1689e;
        }
        return iVar;
    }

    public a a() {
        return this.f1690a;
    }

    public b b() {
        return this.f1691b;
    }

    public g d() {
        return this.f1692c;
    }

    public h e() {
        return this.f1693d;
    }
}

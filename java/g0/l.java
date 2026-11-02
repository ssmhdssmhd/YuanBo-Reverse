package g0;

import android.app.Activity;
import android.content.Context;
import g0.a;
import g0.t;
import g0.x;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import y3.k;

/* loaded from: classes.dex */
final class l implements k.c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3945a;

    /* renamed from: b, reason: collision with root package name */
    private final a f3946b;

    /* renamed from: c, reason: collision with root package name */
    private final t f3947c;

    /* renamed from: d, reason: collision with root package name */
    private final x f3948d;

    /* renamed from: e, reason: collision with root package name */
    private Activity f3949e;

    l(Context context, a aVar, t tVar, x xVar) {
        this.f3945a = context;
        this.f3946b = aVar;
        this.f3947c = tVar;
        this.f3948d = xVar;
    }

    @Override // y3.k.c
    public void e(y3.j jVar, final k.d dVar) {
        String str = jVar.f11100a;
        str.hashCode();
        switch (str) {
            case "checkServiceStatus":
                int parseInt = Integer.parseInt(jVar.f11101b.toString());
                x xVar = this.f3948d;
                Context context = this.f3945a;
                Objects.requireNonNull(dVar);
                xVar.a(parseInt, context, new x.a() { // from class: g0.c
                    @Override // g0.x.a
                    public final void a(int i6) {
                        k.d.this.b(Integer.valueOf(i6));
                    }
                }, new b() { // from class: g0.d
                    @Override // g0.b
                    public final void a(String str2, String str3) {
                        k.d.this.a(str2, str3, null);
                    }
                });
                break;
            case "shouldShowRequestPermissionRationale":
                int parseInt2 = Integer.parseInt(jVar.f11101b.toString());
                t tVar = this.f3947c;
                Activity activity = this.f3949e;
                Objects.requireNonNull(dVar);
                tVar.i(parseInt2, activity, new t.c() { // from class: g0.h
                    @Override // g0.t.c
                    public final void a(boolean z5) {
                        k.d.this.b(Boolean.valueOf(z5));
                    }
                }, new b() { // from class: g0.i
                    @Override // g0.b
                    public final void a(String str2, String str3) {
                        k.d.this.a(str2, str3, null);
                    }
                });
                break;
            case "checkPermissionStatus":
                int parseInt3 = Integer.parseInt(jVar.f11101b.toString());
                t tVar2 = this.f3947c;
                Context context2 = this.f3945a;
                Objects.requireNonNull(dVar);
                tVar2.d(parseInt3, context2, new t.a() { // from class: g0.e
                    @Override // g0.t.a
                    public final void a(int i6) {
                        k.d.this.b(Integer.valueOf(i6));
                    }
                });
                break;
            case "openAppSettings":
                a aVar = this.f3946b;
                Context context3 = this.f3945a;
                Objects.requireNonNull(dVar);
                aVar.a(context3, new a.InterfaceC0075a() { // from class: g0.j
                    @Override // g0.a.InterfaceC0075a
                    public final void a(boolean z5) {
                        k.d.this.b(Boolean.valueOf(z5));
                    }
                }, new b() { // from class: g0.k
                    @Override // g0.b
                    public final void a(String str2, String str3) {
                        k.d.this.a(str2, str3, null);
                    }
                });
                break;
            case "requestPermissions":
                List<Integer> list = (List) jVar.b();
                t tVar3 = this.f3947c;
                Activity activity2 = this.f3949e;
                Objects.requireNonNull(dVar);
                tVar3.h(list, activity2, new t.b() { // from class: g0.f
                    @Override // g0.t.b
                    public final void a(Map map) {
                        k.d.this.b(map);
                    }
                }, new b() { // from class: g0.g
                    @Override // g0.b
                    public final void a(String str2, String str3) {
                        k.d.this.a(str2, str3, null);
                    }
                });
                break;
            default:
                dVar.c();
                break;
        }
    }

    public void j(Activity activity) {
        this.f3949e = activity;
    }
}

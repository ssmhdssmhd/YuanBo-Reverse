package androidx.room;

import android.content.Context;
import androidx.room.h;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import q.c;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final c.InterfaceC0129c f1294a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f1295b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1296c;

    /* renamed from: d, reason: collision with root package name */
    public final h.d f1297d;

    /* renamed from: e, reason: collision with root package name */
    public final List<h.b> f1298e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f1299f;

    /* renamed from: g, reason: collision with root package name */
    public final h.c f1300g;

    /* renamed from: h, reason: collision with root package name */
    public final Executor f1301h;

    /* renamed from: i, reason: collision with root package name */
    public final Executor f1302i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f1303j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f1304k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f1305l;

    /* renamed from: m, reason: collision with root package name */
    private final Set<Integer> f1306m;

    /* renamed from: n, reason: collision with root package name */
    public final String f1307n;

    /* renamed from: o, reason: collision with root package name */
    public final File f1308o;

    public a(Context context, String str, c.InterfaceC0129c interfaceC0129c, h.d dVar, List<h.b> list, boolean z5, h.c cVar, Executor executor, Executor executor2, boolean z6, boolean z7, boolean z8, Set<Integer> set, String str2, File file) {
        this.f1294a = interfaceC0129c;
        this.f1295b = context;
        this.f1296c = str;
        this.f1297d = dVar;
        this.f1298e = list;
        this.f1299f = z5;
        this.f1300g = cVar;
        this.f1301h = executor;
        this.f1302i = executor2;
        this.f1303j = z6;
        this.f1304k = z7;
        this.f1305l = z8;
        this.f1306m = set;
        this.f1307n = str2;
        this.f1308o = file;
    }

    public boolean a(int i6, int i7) {
        Set<Integer> set;
        return !((i6 > i7) && this.f1305l) && this.f1304k && ((set = this.f1306m) == null || !set.contains(Integer.valueOf(i6)));
    }
}

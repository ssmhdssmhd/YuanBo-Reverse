package w;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import v.m;
import v.r;
import v.u;

/* loaded from: classes.dex */
public class g extends r {

    /* renamed from: j, reason: collision with root package name */
    private static final String f9924j = v.j.f("WorkContinuationImpl");

    /* renamed from: a, reason: collision with root package name */
    private final j f9925a;

    /* renamed from: b, reason: collision with root package name */
    private final String f9926b;

    /* renamed from: c, reason: collision with root package name */
    private final v.d f9927c;

    /* renamed from: d, reason: collision with root package name */
    private final List<? extends u> f9928d;

    /* renamed from: e, reason: collision with root package name */
    private final List<String> f9929e;

    /* renamed from: f, reason: collision with root package name */
    private final List<String> f9930f;

    /* renamed from: g, reason: collision with root package name */
    private final List<g> f9931g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f9932h;

    /* renamed from: i, reason: collision with root package name */
    private m f9933i;

    public g(j jVar, String str, v.d dVar, List<? extends u> list, List<g> list2) {
        this.f9925a = jVar;
        this.f9926b = str;
        this.f9927c = dVar;
        this.f9928d = list;
        this.f9931g = list2;
        this.f9929e = new ArrayList(list.size());
        this.f9930f = new ArrayList();
        if (list2 != null) {
            Iterator<g> it = list2.iterator();
            while (it.hasNext()) {
                this.f9930f.addAll(it.next().f9930f);
            }
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            String b6 = list.get(i6).b();
            this.f9929e.add(b6);
            this.f9930f.add(b6);
        }
    }

    public g(j jVar, List<? extends u> list) {
        this(jVar, null, v.d.KEEP, list, null);
    }

    private static boolean i(g gVar, Set<String> set) {
        set.addAll(gVar.c());
        Set<String> l6 = l(gVar);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (l6.contains(it.next())) {
                return true;
            }
        }
        List<g> e6 = gVar.e();
        if (e6 != null && !e6.isEmpty()) {
            Iterator<g> it2 = e6.iterator();
            while (it2.hasNext()) {
                if (i(it2.next(), set)) {
                    return true;
                }
            }
        }
        set.removeAll(gVar.c());
        return false;
    }

    public static Set<String> l(g gVar) {
        HashSet hashSet = new HashSet();
        List<g> e6 = gVar.e();
        if (e6 != null && !e6.isEmpty()) {
            Iterator<g> it = e6.iterator();
            while (it.hasNext()) {
                hashSet.addAll(it.next().c());
            }
        }
        return hashSet;
    }

    public m a() {
        if (this.f9932h) {
            v.j.c().h(f9924j, String.format("Already enqueued work ids (%s)", TextUtils.join(", ", this.f9929e)), new Throwable[0]);
        } else {
            e0.b bVar = new e0.b(this);
            this.f9925a.q().b(bVar);
            this.f9933i = bVar.d();
        }
        return this.f9933i;
    }

    public v.d b() {
        return this.f9927c;
    }

    public List<String> c() {
        return this.f9929e;
    }

    public String d() {
        return this.f9926b;
    }

    public List<g> e() {
        return this.f9931g;
    }

    public List<? extends u> f() {
        return this.f9928d;
    }

    public j g() {
        return this.f9925a;
    }

    public boolean h() {
        return i(this, new HashSet());
    }

    public boolean j() {
        return this.f9932h;
    }

    public void k() {
        this.f9932h = true;
    }
}

package androidx.fragment.app;

import androidx.lifecycle.d;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: b, reason: collision with root package name */
    int f724b;

    /* renamed from: c, reason: collision with root package name */
    int f725c;

    /* renamed from: d, reason: collision with root package name */
    int f726d;

    /* renamed from: e, reason: collision with root package name */
    int f727e;

    /* renamed from: f, reason: collision with root package name */
    int f728f;

    /* renamed from: g, reason: collision with root package name */
    int f729g;

    /* renamed from: h, reason: collision with root package name */
    boolean f730h;

    /* renamed from: j, reason: collision with root package name */
    String f732j;

    /* renamed from: k, reason: collision with root package name */
    int f733k;

    /* renamed from: l, reason: collision with root package name */
    CharSequence f734l;

    /* renamed from: m, reason: collision with root package name */
    int f735m;

    /* renamed from: n, reason: collision with root package name */
    CharSequence f736n;

    /* renamed from: o, reason: collision with root package name */
    ArrayList<String> f737o;

    /* renamed from: p, reason: collision with root package name */
    ArrayList<String> f738p;

    /* renamed from: r, reason: collision with root package name */
    ArrayList<Runnable> f740r;

    /* renamed from: a, reason: collision with root package name */
    ArrayList<a> f723a = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    boolean f731i = true;

    /* renamed from: q, reason: collision with root package name */
    boolean f739q = false;

    static final class a {

        /* renamed from: a, reason: collision with root package name */
        int f741a;

        /* renamed from: b, reason: collision with root package name */
        Fragment f742b;

        /* renamed from: c, reason: collision with root package name */
        int f743c;

        /* renamed from: d, reason: collision with root package name */
        int f744d;

        /* renamed from: e, reason: collision with root package name */
        int f745e;

        /* renamed from: f, reason: collision with root package name */
        int f746f;

        /* renamed from: g, reason: collision with root package name */
        d.c f747g;

        /* renamed from: h, reason: collision with root package name */
        d.c f748h;

        a() {
        }

        a(int i6, Fragment fragment) {
            this.f741a = i6;
            this.f742b = fragment;
            d.c cVar = d.c.RESUMED;
            this.f747g = cVar;
            this.f748h = cVar;
        }
    }

    void b(a aVar) {
        this.f723a.add(aVar);
        aVar.f743c = this.f724b;
        aVar.f744d = this.f725c;
        aVar.f745e = this.f726d;
        aVar.f746f = this.f727e;
    }
}

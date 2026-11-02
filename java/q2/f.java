package q2;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import t2.d;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private s2.d f8891a = s2.d.f9240k;

    /* renamed from: b, reason: collision with root package name */
    private t f8892b = t.f8915a;

    /* renamed from: c, reason: collision with root package name */
    private d f8893c = c.f8852a;

    /* renamed from: d, reason: collision with root package name */
    private final Map<Type, g<?>> f8894d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private final List<y> f8895e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final List<y> f8896f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private boolean f8897g = false;

    /* renamed from: h, reason: collision with root package name */
    private String f8898h = e.f8860z;

    /* renamed from: i, reason: collision with root package name */
    private int f8899i = 2;

    /* renamed from: j, reason: collision with root package name */
    private int f8900j = 2;

    /* renamed from: k, reason: collision with root package name */
    private boolean f8901k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f8902l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f8903m = true;

    /* renamed from: n, reason: collision with root package name */
    private boolean f8904n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f8905o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f8906p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f8907q = true;

    /* renamed from: r, reason: collision with root package name */
    private w f8908r = e.B;

    /* renamed from: s, reason: collision with root package name */
    private w f8909s = e.C;

    /* renamed from: t, reason: collision with root package name */
    private final LinkedList<u> f8910t = new LinkedList<>();

    private void a(String str, int i6, int i7, List<y> list) {
        y yVar;
        y yVar2;
        boolean z5 = w2.d.f10220a;
        y yVar3 = null;
        if (str != null && !str.trim().isEmpty()) {
            yVar = d.b.f9401b.b(str);
            if (z5) {
                yVar3 = w2.d.f10222c.b(str);
                yVar2 = w2.d.f10221b.b(str);
            }
            yVar2 = null;
        } else {
            if (i6 == 2 || i7 == 2) {
                return;
            }
            y a6 = d.b.f9401b.a(i6, i7);
            if (z5) {
                yVar3 = w2.d.f10222c.a(i6, i7);
                y a7 = w2.d.f10221b.a(i6, i7);
                yVar = a6;
                yVar2 = a7;
            } else {
                yVar = a6;
                yVar2 = null;
            }
        }
        list.add(yVar);
        if (z5) {
            list.add(yVar3);
            list.add(yVar2);
        }
    }

    public e b() {
        List<y> arrayList = new ArrayList<>(this.f8895e.size() + this.f8896f.size() + 3);
        arrayList.addAll(this.f8895e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f8896f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.f8898h, this.f8899i, this.f8900j, arrayList);
        return new e(this.f8891a, this.f8893c, new HashMap(this.f8894d), this.f8897g, this.f8901k, this.f8905o, this.f8903m, this.f8904n, this.f8906p, this.f8902l, this.f8907q, this.f8892b, this.f8898h, this.f8899i, this.f8900j, new ArrayList(this.f8895e), new ArrayList(this.f8896f), arrayList, this.f8908r, this.f8909s, new ArrayList(this.f8910t));
    }

    public f c(Class<?> cls, Object obj) {
        Objects.requireNonNull(cls);
        boolean z5 = obj instanceof r;
        s2.a.a(z5 || (obj instanceof j) || (obj instanceof x));
        if ((obj instanceof j) || z5) {
            this.f8896f.add(t2.m.g(cls, obj));
        }
        if (obj instanceof x) {
            this.f8895e.add(t2.o.d(cls, (x) obj));
        }
        return this;
    }

    public f d(String str) {
        this.f8898h = str;
        return this;
    }
}

package e3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
class q implements o {

    /* renamed from: a, reason: collision with root package name */
    final String f3665a;

    /* renamed from: b, reason: collision with root package name */
    final int f3666b;

    /* renamed from: c, reason: collision with root package name */
    final int f3667c;

    /* renamed from: d, reason: collision with root package name */
    private final LinkedList<k> f3668d = new LinkedList<>();

    /* renamed from: e, reason: collision with root package name */
    private final Set<m> f3669e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    private final Set<m> f3670f = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    private final Map<Integer, m> f3671g = new HashMap();

    q(String str, int i6, int i7) {
        this.f3665a = str;
        this.f3666b = i6;
        this.f3667c = i7;
    }

    private synchronized k f(m mVar) {
        k next;
        m mVar2;
        ListIterator<k> listIterator = this.f3668d.listIterator();
        do {
            if (!listIterator.hasNext()) {
                return null;
            }
            next = listIterator.next();
            mVar2 = next.a() != null ? this.f3671g.get(next.a()) : null;
            if (mVar2 == null) {
                break;
            }
        } while (mVar2 != mVar);
        listIterator.remove();
        return next;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public synchronized void g(m mVar) {
        HashSet hashSet = new HashSet(this.f3669e);
        this.f3670f.remove(mVar);
        this.f3669e.add(mVar);
        if (!mVar.b() && mVar.d() != null) {
            this.f3671g.remove(mVar.d());
        }
        i(mVar);
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            i((m) it.next());
        }
    }

    private synchronized void i(m mVar) {
        k f6 = f(mVar);
        if (f6 != null) {
            this.f3670f.add(mVar);
            this.f3669e.remove(mVar);
            if (f6.a() != null) {
                this.f3671g.put(f6.a(), mVar);
            }
            mVar.e(f6);
        }
    }

    @Override // e3.o
    public /* synthetic */ void a(i iVar, Runnable runnable) {
        n.a(this, iVar, runnable);
    }

    @Override // e3.o
    public synchronized void b(k kVar) {
        this.f3668d.add(kVar);
        Iterator it = new HashSet(this.f3669e).iterator();
        while (it.hasNext()) {
            i((m) it.next());
        }
    }

    @Override // e3.o
    public synchronized void c() {
        Iterator<m> it = this.f3669e.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
        Iterator<m> it2 = this.f3670f.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
    }

    protected m e(String str, int i6) {
        return new m(str, i6);
    }

    @Override // e3.o
    public synchronized void start() {
        for (int i6 = 0; i6 < this.f3666b; i6++) {
            final m e6 = e(this.f3665a + i6, this.f3667c);
            e6.g(new Runnable() { // from class: e3.p
                @Override // java.lang.Runnable
                public final void run() {
                    q.this.g(e6);
                }
            });
            this.f3669e.add(e6);
        }
    }
}

package androidx.fragment.app;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
class n {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f749a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b, reason: collision with root package name */
    private static final p f750b = new o();

    /* renamed from: c, reason: collision with root package name */
    private static final p f751c = w();

    static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f752a;

        a(ArrayList arrayList) {
            this.f752a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.A(this.f752a, 4);
        }
    }

    static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f753a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ p f754b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f755c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Fragment f756d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f757e;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ ArrayList f758j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ ArrayList f759k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ Object f760l;

        b(Object obj, p pVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f753a = obj;
            this.f754b = pVar;
            this.f755c = view;
            this.f756d = fragment;
            this.f757e = arrayList;
            this.f758j = arrayList2;
            this.f759k = arrayList3;
            this.f760l = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f753a;
            if (obj != null) {
                this.f754b.p(obj, this.f755c);
                this.f758j.addAll(n.k(this.f754b, this.f753a, this.f756d, this.f757e, this.f755c));
            }
            if (this.f759k != null) {
                if (this.f760l != null) {
                    ArrayList<View> arrayList = new ArrayList<>();
                    arrayList.add(this.f755c);
                    this.f754b.q(this.f760l, this.f759k, arrayList);
                }
                this.f759k.clear();
                this.f759k.add(this.f755c);
            }
        }
    }

    static class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f761a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Fragment f762b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f763c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f.a f764d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f765e;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ p f766j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ Rect f767k;

        c(Fragment fragment, Fragment fragment2, boolean z5, f.a aVar, View view, p pVar, Rect rect) {
            this.f761a = fragment;
            this.f762b = fragment2;
            this.f763c = z5;
            this.f764d = aVar;
            this.f765e = view;
            this.f766j = pVar;
            this.f767k = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.f(this.f761a, this.f762b, this.f763c, this.f764d, false);
            View view = this.f765e;
            if (view != null) {
                this.f766j.k(view, this.f767k);
            }
        }
    }

    static class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f768a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f.a f769b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f770c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f771d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f772e;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ View f773j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ Fragment f774k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ Fragment f775l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ boolean f776m;

        /* renamed from: n, reason: collision with root package name */
        final /* synthetic */ ArrayList f777n;

        /* renamed from: o, reason: collision with root package name */
        final /* synthetic */ Object f778o;

        /* renamed from: p, reason: collision with root package name */
        final /* synthetic */ Rect f779p;

        d(p pVar, f.a aVar, Object obj, e eVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z5, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f768a = pVar;
            this.f769b = aVar;
            this.f770c = obj;
            this.f771d = eVar;
            this.f772e = arrayList;
            this.f773j = view;
            this.f774k = fragment;
            this.f775l = fragment2;
            this.f776m = z5;
            this.f777n = arrayList2;
            this.f778o = obj2;
            this.f779p = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.a<String, View> h6 = n.h(this.f768a, this.f769b, this.f770c, this.f771d);
            if (h6 != null) {
                this.f772e.addAll(h6.values());
                this.f772e.add(this.f773j);
            }
            n.f(this.f774k, this.f775l, this.f776m, h6, false);
            Object obj = this.f770c;
            if (obj != null) {
                this.f768a.z(obj, this.f777n, this.f772e);
                View s5 = n.s(h6, this.f771d, this.f778o, this.f776m);
                if (s5 != null) {
                    this.f768a.k(s5, this.f779p);
                }
            }
        }
    }

    static class e {

        /* renamed from: a, reason: collision with root package name */
        public Fragment f780a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f781b;

        /* renamed from: c, reason: collision with root package name */
        public androidx.fragment.app.a f782c;

        /* renamed from: d, reason: collision with root package name */
        public Fragment f783d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f784e;

        /* renamed from: f, reason: collision with root package name */
        public androidx.fragment.app.a f785f;

        e() {
        }
    }

    static void A(ArrayList<View> arrayList, int i6) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i6);
        }
    }

    static void B(i iVar, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i6, int i7, boolean z5) {
        if (iVar.f659p < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i8 = i6; i8 < i7; i8++) {
            androidx.fragment.app.a aVar = arrayList.get(i8);
            if (arrayList2.get(i8).booleanValue()) {
                e(aVar, sparseArray, z5);
            } else {
                c(aVar, sparseArray, z5);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(iVar.f660q.g());
            int size = sparseArray.size();
            for (int i9 = 0; i9 < size; i9++) {
                int keyAt = sparseArray.keyAt(i9);
                f.a<String, String> d6 = d(keyAt, arrayList, arrayList2, i6, i7);
                e eVar = (e) sparseArray.valueAt(i9);
                if (z5) {
                    o(iVar, keyAt, eVar, view, d6);
                } else {
                    n(iVar, keyAt, eVar, view, d6);
                }
            }
        }
    }

    private static void a(ArrayList<View> arrayList, f.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View l6 = aVar.l(size);
            if (collection.contains(s.p(l6))) {
                arrayList.add(l6);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0041, code lost:
    
        if (r10.f571k != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0092, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0076, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0090, code lost:
    
        if (r10.f585y == false) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ae A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void b(androidx.fragment.app.a r16, androidx.fragment.app.m.a r17, android.util.SparseArray<androidx.fragment.app.n.e> r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.n.b(androidx.fragment.app.a, androidx.fragment.app.m$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static void c(androidx.fragment.app.a aVar, SparseArray<e> sparseArray, boolean z5) {
        int size = aVar.f723a.size();
        for (int i6 = 0; i6 < size; i6++) {
            b(aVar, aVar.f723a.get(i6), sparseArray, false, z5);
        }
    }

    private static f.a<String, String> d(int i6, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i7, int i8) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        f.a<String, String> aVar = new f.a<>();
        for (int i9 = i8 - 1; i9 >= i7; i9--) {
            androidx.fragment.app.a aVar2 = arrayList.get(i9);
            if (aVar2.j(i6)) {
                boolean booleanValue = arrayList2.get(i9).booleanValue();
                ArrayList<String> arrayList5 = aVar2.f737o;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.f737o;
                        arrayList4 = aVar2.f738p;
                    } else {
                        ArrayList<String> arrayList6 = aVar2.f737o;
                        arrayList3 = aVar2.f738p;
                        arrayList4 = arrayList6;
                    }
                    for (int i10 = 0; i10 < size; i10++) {
                        String str = arrayList4.get(i10);
                        String str2 = arrayList3.get(i10);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static void e(androidx.fragment.app.a aVar, SparseArray<e> sparseArray, boolean z5) {
        if (aVar.f608s.f661r.e()) {
            for (int size = aVar.f723a.size() - 1; size >= 0; size--) {
                b(aVar, aVar.f723a.get(size), sparseArray, true, z5);
            }
        }
    }

    static void f(Fragment fragment, Fragment fragment2, boolean z5, f.a<String, View> aVar, boolean z6) {
        if (z5) {
            fragment2.q();
        } else {
            fragment.q();
        }
    }

    private static boolean g(p pVar, List<Object> list) {
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (!pVar.e(list.get(i6))) {
                return false;
            }
        }
        return true;
    }

    static f.a<String, View> h(p pVar, f.a<String, String> aVar, Object obj, e eVar) {
        ArrayList<String> arrayList;
        Fragment fragment = eVar.f780a;
        View I = fragment.I();
        if (aVar.isEmpty() || obj == null || I == null) {
            aVar.clear();
            return null;
        }
        f.a<String, View> aVar2 = new f.a<>();
        pVar.j(aVar2, I);
        androidx.fragment.app.a aVar3 = eVar.f782c;
        if (eVar.f781b) {
            fragment.s();
            arrayList = aVar3.f737o;
        } else {
            fragment.q();
            arrayList = aVar3.f738p;
        }
        if (arrayList != null) {
            aVar2.n(arrayList);
            aVar2.n(aVar.values());
        }
        x(aVar, aVar2);
        return aVar2;
    }

    private static f.a<String, View> i(p pVar, f.a<String, String> aVar, Object obj, e eVar) {
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = eVar.f783d;
        f.a<String, View> aVar2 = new f.a<>();
        pVar.j(aVar2, fragment.X0());
        androidx.fragment.app.a aVar3 = eVar.f785f;
        if (eVar.f784e) {
            fragment.q();
            arrayList = aVar3.f738p;
        } else {
            fragment.s();
            arrayList = aVar3.f737o;
        }
        aVar2.n(arrayList);
        aVar.n(aVar2.keySet());
        return aVar2;
    }

    private static p j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object r6 = fragment.r();
            if (r6 != null) {
                arrayList.add(r6);
            }
            Object D = fragment.D();
            if (D != null) {
                arrayList.add(D);
            }
            Object F = fragment.F();
            if (F != null) {
                arrayList.add(F);
            }
        }
        if (fragment2 != null) {
            Object p6 = fragment2.p();
            if (p6 != null) {
                arrayList.add(p6);
            }
            Object A = fragment2.A();
            if (A != null) {
                arrayList.add(A);
            }
            Object E = fragment2.E();
            if (E != null) {
                arrayList.add(E);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        p pVar = f750b;
        if (pVar != null && g(pVar, arrayList)) {
            return pVar;
        }
        p pVar2 = f751c;
        if (pVar2 != null && g(pVar2, arrayList)) {
            return pVar2;
        }
        if (pVar == null && pVar2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    static ArrayList<View> k(p pVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View I = fragment.I();
        if (I != null) {
            pVar.f(arrayList2, I);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        pVar.b(obj, arrayList2);
        return arrayList2;
    }

    private static Object l(p pVar, ViewGroup viewGroup, View view, f.a<String, String> aVar, e eVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object t5;
        f.a<String, String> aVar2;
        Object obj3;
        Rect rect;
        Fragment fragment = eVar.f780a;
        Fragment fragment2 = eVar.f783d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z5 = eVar.f781b;
        if (aVar.isEmpty()) {
            aVar2 = aVar;
            t5 = null;
        } else {
            t5 = t(pVar, fragment, fragment2, z5);
            aVar2 = aVar;
        }
        f.a<String, View> i6 = i(pVar, aVar2, t5, eVar);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(i6.values());
            obj3 = t5;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z5, i6, true);
        if (obj3 != null) {
            rect = new Rect();
            pVar.y(obj3, view, arrayList);
            z(pVar, obj3, obj2, i6, eVar.f784e, eVar.f785f);
            if (obj != null) {
                pVar.u(obj, rect);
            }
        } else {
            rect = null;
        }
        androidx.core.view.q.a(viewGroup, new d(pVar, aVar, obj3, eVar, arrayList2, view, fragment, fragment2, z5, arrayList, obj, rect));
        return obj3;
    }

    private static Object m(p pVar, ViewGroup viewGroup, View view, f.a<String, String> aVar, e eVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = eVar.f780a;
        Fragment fragment2 = eVar.f783d;
        if (fragment != null) {
            fragment.X0().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z5 = eVar.f781b;
        Object t5 = aVar.isEmpty() ? null : t(pVar, fragment, fragment2, z5);
        f.a<String, View> i6 = i(pVar, aVar, t5, eVar);
        f.a<String, View> h6 = h(pVar, aVar, t5, eVar);
        if (aVar.isEmpty()) {
            if (i6 != null) {
                i6.clear();
            }
            if (h6 != null) {
                h6.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, i6, aVar.keySet());
            a(arrayList2, h6, aVar.values());
            obj3 = t5;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z5, i6, true);
        if (obj3 != null) {
            arrayList2.add(view);
            pVar.y(obj3, view, arrayList);
            z(pVar, obj3, obj2, i6, eVar.f784e, eVar.f785f);
            Rect rect2 = new Rect();
            View s5 = s(h6, eVar, obj, z5);
            if (s5 != null) {
                pVar.u(obj, rect2);
            }
            rect = rect2;
            view2 = s5;
        } else {
            view2 = null;
            rect = null;
        }
        androidx.core.view.q.a(viewGroup, new c(fragment, fragment2, z5, h6, view2, pVar, rect));
        return obj3;
    }

    private static void n(i iVar, int i6, e eVar, View view, f.a<String, String> aVar) {
        Fragment fragment;
        Fragment fragment2;
        p j6;
        Object obj;
        ViewGroup viewGroup = iVar.f661r.e() ? (ViewGroup) iVar.f661r.c(i6) : null;
        if (viewGroup == null || (j6 = j((fragment2 = eVar.f783d), (fragment = eVar.f780a))) == null) {
            return;
        }
        boolean z5 = eVar.f781b;
        boolean z6 = eVar.f784e;
        Object q6 = q(j6, fragment, z5);
        Object r6 = r(j6, fragment2, z6);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object l6 = l(j6, viewGroup, view, aVar, eVar, arrayList, arrayList2, q6, r6);
        if (q6 == null && l6 == null) {
            obj = r6;
            if (obj == null) {
                return;
            }
        } else {
            obj = r6;
        }
        ArrayList<View> k6 = k(j6, obj, fragment2, arrayList, view);
        Object obj2 = (k6 == null || k6.isEmpty()) ? null : obj;
        j6.a(q6, view);
        Object u5 = u(j6, q6, obj2, l6, fragment, eVar.f781b);
        if (u5 != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            j6.t(u5, q6, arrayList3, obj2, k6, l6, arrayList2);
            y(j6, viewGroup, fragment, view, arrayList2, q6, arrayList3, obj2, k6);
            j6.w(viewGroup, arrayList2, aVar);
            j6.c(viewGroup, u5);
            j6.s(viewGroup, arrayList2, aVar);
        }
    }

    private static void o(i iVar, int i6, e eVar, View view, f.a<String, String> aVar) {
        Fragment fragment;
        Fragment fragment2;
        p j6;
        Object obj;
        ViewGroup viewGroup = iVar.f661r.e() ? (ViewGroup) iVar.f661r.c(i6) : null;
        if (viewGroup == null || (j6 = j((fragment2 = eVar.f783d), (fragment = eVar.f780a))) == null) {
            return;
        }
        boolean z5 = eVar.f781b;
        boolean z6 = eVar.f784e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object q6 = q(j6, fragment, z5);
        Object r6 = r(j6, fragment2, z6);
        Object m6 = m(j6, viewGroup, view, aVar, eVar, arrayList2, arrayList, q6, r6);
        if (q6 == null && m6 == null) {
            obj = r6;
            if (obj == null) {
                return;
            }
        } else {
            obj = r6;
        }
        ArrayList<View> k6 = k(j6, obj, fragment2, arrayList2, view);
        ArrayList<View> k7 = k(j6, q6, fragment, arrayList, view);
        A(k7, 4);
        Object u5 = u(j6, q6, obj, m6, fragment, z5);
        if (u5 != null) {
            v(j6, obj, fragment2, k6);
            ArrayList<String> o6 = j6.o(arrayList);
            j6.t(u5, q6, k7, obj, k6, m6, arrayList);
            j6.c(viewGroup, u5);
            j6.x(viewGroup, arrayList2, arrayList, o6, aVar);
            A(k7, 0);
            j6.z(m6, arrayList2, arrayList);
        }
    }

    private static e p(e eVar, SparseArray<e> sparseArray, int i6) {
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e();
        sparseArray.put(i6, eVar2);
        return eVar2;
    }

    private static Object q(p pVar, Fragment fragment, boolean z5) {
        if (fragment == null) {
            return null;
        }
        return pVar.g(z5 ? fragment.A() : fragment.p());
    }

    private static Object r(p pVar, Fragment fragment, boolean z5) {
        if (fragment == null) {
            return null;
        }
        return pVar.g(z5 ? fragment.D() : fragment.r());
    }

    static View s(f.a<String, View> aVar, e eVar, Object obj, boolean z5) {
        ArrayList<String> arrayList;
        androidx.fragment.app.a aVar2 = eVar.f782c;
        if (obj == null || aVar == null || (arrayList = aVar2.f737o) == null || arrayList.isEmpty()) {
            return null;
        }
        return aVar.get((z5 ? aVar2.f737o : aVar2.f738p).get(0));
    }

    private static Object t(p pVar, Fragment fragment, Fragment fragment2, boolean z5) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return pVar.A(pVar.g(z5 ? fragment2.F() : fragment.E()));
    }

    private static Object u(p pVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z5) {
        return (obj == null || obj2 == null || fragment == null) ? true : z5 ? fragment.k() : fragment.j() ? pVar.n(obj2, obj, obj3) : pVar.m(obj2, obj, obj3);
    }

    private static void v(p pVar, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.f571k && fragment.f585y && fragment.N) {
            fragment.d1(true);
            pVar.r(obj, fragment.I(), arrayList);
            androidx.core.view.q.a(fragment.F, new a(arrayList));
        }
    }

    private static p w() {
        try {
            return (p) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void x(f.a<String, String> aVar, f.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.l(size))) {
                aVar.j(size);
            }
        }
    }

    private static void y(p pVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        androidx.core.view.q.a(viewGroup, new b(obj, pVar, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }

    private static void z(p pVar, Object obj, Object obj2, f.a<String, View> aVar, boolean z5, androidx.fragment.app.a aVar2) {
        ArrayList<String> arrayList = aVar2.f737o;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        View view = aVar.get((z5 ? aVar2.f738p : aVar2.f737o).get(0));
        pVar.v(obj, view);
        if (obj2 != null) {
            pVar.v(obj2, view);
        }
    }
}

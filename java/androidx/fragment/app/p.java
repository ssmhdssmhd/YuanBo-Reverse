package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.f1;
import androidx.core.view.s;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class p {

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f800a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f801b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList f802c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f803d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f804e;

        a(int i6, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f800a = i6;
            this.f801b = arrayList;
            this.f802c = arrayList2;
            this.f803d = arrayList3;
            this.f804e = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i6 = 0; i6 < this.f800a; i6++) {
                s.E((View) this.f801b.get(i6), (String) this.f802c.get(i6));
                s.E((View) this.f803d.get(i6), (String) this.f804e.get(i6));
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f806a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f807b;

        b(ArrayList arrayList, Map map) {
            this.f806a = arrayList;
            this.f807b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f806a.size();
            for (int i6 = 0; i6 < size; i6++) {
                View view = (View) this.f806a.get(i6);
                String p6 = s.p(view);
                if (p6 != null) {
                    s.E(view, p.i(this.f807b, p6));
                }
            }
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f809a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f810b;

        c(ArrayList arrayList, Map map) {
            this.f809a = arrayList;
            this.f810b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f809a.size();
            for (int i6 = 0; i6 < size; i6++) {
                View view = (View) this.f809a.get(i6);
                s.E(view, (String) this.f810b.get(s.p(view)));
            }
        }
    }

    protected static void d(List<View> list, View view) {
        int size = list.size();
        if (h(list, view, size)) {
            return;
        }
        list.add(view);
        for (int i6 = size; i6 < list.size(); i6++) {
            View view2 = list.get(i6);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i7 = 0; i7 < childCount; i7++) {
                    View childAt = viewGroup.getChildAt(i7);
                    if (!h(list, childAt, size)) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    private static boolean h(List<View> list, View view, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            if (list.get(i7) == view) {
                return true;
            }
        }
        return false;
    }

    static String i(Map<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    protected static boolean l(List list) {
        return list == null || list.isEmpty();
    }

    public abstract Object A(Object obj);

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList<View> arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    void f(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            boolean z5 = view instanceof ViewGroup;
            View view2 = view;
            if (z5) {
                ViewGroup viewGroup = (ViewGroup) view;
                boolean a6 = f1.a(viewGroup);
                view2 = viewGroup;
                if (!a6) {
                    int childCount = viewGroup.getChildCount();
                    for (int i6 = 0; i6 < childCount; i6++) {
                        f(arrayList, viewGroup.getChildAt(i6));
                    }
                    return;
                }
            }
            arrayList.add(view2);
        }
    }

    public abstract Object g(Object obj);

    void j(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String p6 = s.p(view);
            if (p6 != null) {
                map.put(p6, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i6 = 0; i6 < childCount; i6++) {
                    j(map, viewGroup.getChildAt(i6));
                }
            }
        }
    }

    protected void k(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i6 = iArr[0];
        rect.set(i6, iArr[1], view.getWidth() + i6, iArr[1] + view.getHeight());
    }

    public abstract Object m(Object obj, Object obj2, Object obj3);

    public abstract Object n(Object obj, Object obj2, Object obj3);

    ArrayList<String> o(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = arrayList.get(i6);
            arrayList2.add(s.p(view));
            s.E(view, null);
        }
        return arrayList2;
    }

    public abstract void p(Object obj, View view);

    public abstract void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void r(Object obj, View view, ArrayList<View> arrayList);

    void s(ViewGroup viewGroup, ArrayList<View> arrayList, Map<String, String> map) {
        androidx.core.view.q.a(viewGroup, new c(arrayList, map));
    }

    public abstract void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void u(Object obj, Rect rect);

    public abstract void v(Object obj, View view);

    void w(View view, ArrayList<View> arrayList, Map<String, String> map) {
        androidx.core.view.q.a(view, new b(arrayList, map));
    }

    void x(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i6 = 0; i6 < size; i6++) {
            View view2 = arrayList.get(i6);
            String p6 = s.p(view2);
            arrayList4.add(p6);
            if (p6 != null) {
                s.E(view2, null);
                String str = map.get(p6);
                int i7 = 0;
                while (true) {
                    if (i7 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(i7))) {
                        s.E(arrayList2.get(i7), p6);
                        break;
                    }
                    i7++;
                }
            }
        }
        androidx.core.view.q.a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void y(Object obj, View view, ArrayList<View> arrayList);

    public abstract void z(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);
}

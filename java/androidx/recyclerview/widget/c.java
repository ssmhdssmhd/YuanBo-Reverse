package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.s;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class c extends k {

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<RecyclerView.b0> f1163h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<RecyclerView.b0> f1164i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<j> f1165j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    private ArrayList<i> f1166k = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.b0>> f1167l = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    ArrayList<ArrayList<j>> f1168m = new ArrayList<>();

    /* renamed from: n, reason: collision with root package name */
    ArrayList<ArrayList<i>> f1169n = new ArrayList<>();

    /* renamed from: o, reason: collision with root package name */
    ArrayList<RecyclerView.b0> f1170o = new ArrayList<>();

    /* renamed from: p, reason: collision with root package name */
    ArrayList<RecyclerView.b0> f1171p = new ArrayList<>();

    /* renamed from: q, reason: collision with root package name */
    ArrayList<RecyclerView.b0> f1172q = new ArrayList<>();

    /* renamed from: r, reason: collision with root package name */
    ArrayList<RecyclerView.b0> f1173r = new ArrayList<>();

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f1174a;

        a(ArrayList arrayList) {
            this.f1174a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1174a.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                c.this.J(jVar.f1208a, jVar.f1209b, jVar.f1210c, jVar.f1211d, jVar.f1212e);
            }
            this.f1174a.clear();
            c.this.f1168m.remove(this.f1174a);
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f1176a;

        b(ArrayList arrayList) {
            this.f1176a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1176a.iterator();
            while (it.hasNext()) {
                c.this.I((i) it.next());
            }
            this.f1176a.clear();
            c.this.f1169n.remove(this.f1176a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.c$c, reason: collision with other inner class name */
    class RunnableC0021c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f1178a;

        RunnableC0021c(ArrayList arrayList) {
            this.f1178a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1178a.iterator();
            while (it.hasNext()) {
                c.this.H((RecyclerView.b0) it.next());
            }
            this.f1178a.clear();
            c.this.f1167l.remove(this.f1178a);
        }
    }

    class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.b0 f1180a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1181b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f1182c;

        d(RecyclerView.b0 b0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1180a = b0Var;
            this.f1181b = viewPropertyAnimator;
            this.f1182c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1181b.setListener(null);
            this.f1182c.setAlpha(1.0f);
            c.this.x(this.f1180a);
            c.this.f1172q.remove(this.f1180a);
            c.this.M();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.y(this.f1180a);
        }
    }

    class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.b0 f1184a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f1185b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1186c;

        e(RecyclerView.b0 b0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f1184a = b0Var;
            this.f1185b = view;
            this.f1186c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1185b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1186c.setListener(null);
            c.this.r(this.f1184a);
            c.this.f1170o.remove(this.f1184a);
            c.this.M();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.s(this.f1184a);
        }
    }

    class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.b0 f1188a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f1189b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f1190c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f1191d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1192e;

        f(RecyclerView.b0 b0Var, int i6, View view, int i7, ViewPropertyAnimator viewPropertyAnimator) {
            this.f1188a = b0Var;
            this.f1189b = i6;
            this.f1190c = view;
            this.f1191d = i7;
            this.f1192e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f1189b != 0) {
                this.f1190c.setTranslationX(0.0f);
            }
            if (this.f1191d != 0) {
                this.f1190c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1192e.setListener(null);
            c.this.v(this.f1188a);
            c.this.f1171p.remove(this.f1188a);
            c.this.M();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.w(this.f1188a);
        }
    }

    class g extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f1194a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1195b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f1196c;

        g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1194a = iVar;
            this.f1195b = viewPropertyAnimator;
            this.f1196c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1195b.setListener(null);
            this.f1196c.setAlpha(1.0f);
            this.f1196c.setTranslationX(0.0f);
            this.f1196c.setTranslationY(0.0f);
            c.this.t(this.f1194a.f1202a, true);
            c.this.f1173r.remove(this.f1194a.f1202a);
            c.this.M();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.u(this.f1194a.f1202a, true);
        }
    }

    class h extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f1198a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f1199b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f1200c;

        h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1198a = iVar;
            this.f1199b = viewPropertyAnimator;
            this.f1200c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1199b.setListener(null);
            this.f1200c.setAlpha(1.0f);
            this.f1200c.setTranslationX(0.0f);
            this.f1200c.setTranslationY(0.0f);
            c.this.t(this.f1198a.f1203b, false);
            c.this.f1173r.remove(this.f1198a.f1203b);
            c.this.M();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.u(this.f1198a.f1203b, false);
        }
    }

    private static class i {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.b0 f1202a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.b0 f1203b;

        /* renamed from: c, reason: collision with root package name */
        public int f1204c;

        /* renamed from: d, reason: collision with root package name */
        public int f1205d;

        /* renamed from: e, reason: collision with root package name */
        public int f1206e;

        /* renamed from: f, reason: collision with root package name */
        public int f1207f;

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f1202a + ", newHolder=" + this.f1203b + ", fromX=" + this.f1204c + ", fromY=" + this.f1205d + ", toX=" + this.f1206e + ", toY=" + this.f1207f + '}';
        }
    }

    private static class j {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.b0 f1208a;

        /* renamed from: b, reason: collision with root package name */
        public int f1209b;

        /* renamed from: c, reason: collision with root package name */
        public int f1210c;

        /* renamed from: d, reason: collision with root package name */
        public int f1211d;

        /* renamed from: e, reason: collision with root package name */
        public int f1212e;
    }

    private void K(RecyclerView.b0 b0Var) {
        View view = b0Var.f1018a;
        ViewPropertyAnimator animate = view.animate();
        this.f1172q.add(b0Var);
        animate.setDuration(k()).alpha(0.0f).setListener(new d(b0Var, animate, view)).start();
    }

    private void N(List<i> list, RecyclerView.b0 b0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = list.get(size);
            if (P(iVar, b0Var) && iVar.f1202a == null && iVar.f1203b == null) {
                list.remove(iVar);
            }
        }
    }

    private void O(i iVar) {
        RecyclerView.b0 b0Var = iVar.f1202a;
        if (b0Var != null) {
            P(iVar, b0Var);
        }
        RecyclerView.b0 b0Var2 = iVar.f1203b;
        if (b0Var2 != null) {
            P(iVar, b0Var2);
        }
    }

    private boolean P(i iVar, RecyclerView.b0 b0Var) {
        boolean z5 = false;
        if (iVar.f1203b == b0Var) {
            iVar.f1203b = null;
        } else {
            if (iVar.f1202a != b0Var) {
                return false;
            }
            iVar.f1202a = null;
            z5 = true;
        }
        b0Var.f1018a.setAlpha(1.0f);
        b0Var.f1018a.setTranslationX(0.0f);
        b0Var.f1018a.setTranslationY(0.0f);
        t(b0Var, z5);
        return true;
    }

    void H(RecyclerView.b0 b0Var) {
        View view = b0Var.f1018a;
        ViewPropertyAnimator animate = view.animate();
        this.f1170o.add(b0Var);
        animate.alpha(1.0f).setDuration(h()).setListener(new e(b0Var, view, animate)).start();
    }

    void I(i iVar) {
        RecyclerView.b0 b0Var = iVar.f1202a;
        View view = b0Var == null ? null : b0Var.f1018a;
        RecyclerView.b0 b0Var2 = iVar.f1203b;
        View view2 = b0Var2 != null ? b0Var2.f1018a : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(i());
            this.f1173r.add(iVar.f1202a);
            duration.translationX(iVar.f1206e - iVar.f1204c);
            duration.translationY(iVar.f1207f - iVar.f1205d);
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.f1173r.add(iVar.f1203b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(i()).alpha(1.0f).setListener(new h(iVar, animate, view2)).start();
        }
    }

    void J(RecyclerView.b0 b0Var, int i6, int i7, int i8, int i9) {
        View view = b0Var.f1018a;
        int i10 = i8 - i6;
        int i11 = i9 - i7;
        if (i10 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i11 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.f1171p.add(b0Var);
        animate.setDuration(j()).setListener(new f(b0Var, i10, view, i11, animate)).start();
    }

    void L(List<RecyclerView.b0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).f1018a.animate().cancel();
        }
    }

    void M() {
        if (l()) {
            return;
        }
        e();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public boolean c(RecyclerView.b0 b0Var, List<Object> list) {
        return !list.isEmpty() || super.c(b0Var, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public void f(RecyclerView.b0 b0Var) {
        View view = b0Var.f1018a;
        view.animate().cancel();
        int size = this.f1165j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.f1165j.get(size).f1208a == b0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                v(b0Var);
                this.f1165j.remove(size);
            }
        }
        N(this.f1166k, b0Var);
        if (this.f1163h.remove(b0Var)) {
            view.setAlpha(1.0f);
            x(b0Var);
        }
        if (this.f1164i.remove(b0Var)) {
            view.setAlpha(1.0f);
            r(b0Var);
        }
        for (int size2 = this.f1169n.size() - 1; size2 >= 0; size2--) {
            ArrayList<i> arrayList = this.f1169n.get(size2);
            N(arrayList, b0Var);
            if (arrayList.isEmpty()) {
                this.f1169n.remove(size2);
            }
        }
        for (int size3 = this.f1168m.size() - 1; size3 >= 0; size3--) {
            ArrayList<j> arrayList2 = this.f1168m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).f1208a == b0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    v(b0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f1168m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f1167l.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.b0> arrayList3 = this.f1167l.get(size5);
            if (arrayList3.remove(b0Var)) {
                view.setAlpha(1.0f);
                r(b0Var);
                if (arrayList3.isEmpty()) {
                    this.f1167l.remove(size5);
                }
            }
        }
        this.f1172q.remove(b0Var);
        this.f1170o.remove(b0Var);
        this.f1173r.remove(b0Var);
        this.f1171p.remove(b0Var);
        M();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public void g() {
        int size = this.f1165j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = this.f1165j.get(size);
            View view = jVar.f1208a.f1018a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            v(jVar.f1208a);
            this.f1165j.remove(size);
        }
        for (int size2 = this.f1163h.size() - 1; size2 >= 0; size2--) {
            x(this.f1163h.get(size2));
            this.f1163h.remove(size2);
        }
        int size3 = this.f1164i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.b0 b0Var = this.f1164i.get(size3);
            b0Var.f1018a.setAlpha(1.0f);
            r(b0Var);
            this.f1164i.remove(size3);
        }
        for (int size4 = this.f1166k.size() - 1; size4 >= 0; size4--) {
            O(this.f1166k.get(size4));
        }
        this.f1166k.clear();
        if (l()) {
            for (int size5 = this.f1168m.size() - 1; size5 >= 0; size5--) {
                ArrayList<j> arrayList = this.f1168m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = arrayList.get(size6);
                    View view2 = jVar2.f1208a.f1018a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    v(jVar2.f1208a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f1168m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f1167l.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.b0> arrayList2 = this.f1167l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.b0 b0Var2 = arrayList2.get(size8);
                    b0Var2.f1018a.setAlpha(1.0f);
                    r(b0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f1167l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f1169n.size() - 1; size9 >= 0; size9--) {
                ArrayList<i> arrayList3 = this.f1169n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    O(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f1169n.remove(arrayList3);
                    }
                }
            }
            L(this.f1172q);
            L(this.f1171p);
            L(this.f1170o);
            L(this.f1173r);
            e();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public boolean l() {
        return (this.f1164i.isEmpty() && this.f1166k.isEmpty() && this.f1165j.isEmpty() && this.f1163h.isEmpty() && this.f1171p.isEmpty() && this.f1172q.isEmpty() && this.f1170o.isEmpty() && this.f1173r.isEmpty() && this.f1168m.isEmpty() && this.f1167l.isEmpty() && this.f1169n.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public void p() {
        boolean z5 = !this.f1163h.isEmpty();
        boolean z6 = !this.f1165j.isEmpty();
        boolean z7 = !this.f1166k.isEmpty();
        boolean z8 = !this.f1164i.isEmpty();
        if (z5 || z6 || z8 || z7) {
            Iterator<RecyclerView.b0> it = this.f1163h.iterator();
            while (it.hasNext()) {
                K(it.next());
            }
            this.f1163h.clear();
            if (z6) {
                ArrayList<j> arrayList = new ArrayList<>();
                arrayList.addAll(this.f1165j);
                this.f1168m.add(arrayList);
                this.f1165j.clear();
                a aVar = new a(arrayList);
                if (z5) {
                    s.y(arrayList.get(0).f1208a.f1018a, aVar, k());
                } else {
                    aVar.run();
                }
            }
            if (z7) {
                ArrayList<i> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.f1166k);
                this.f1169n.add(arrayList2);
                this.f1166k.clear();
                b bVar = new b(arrayList2);
                if (z5) {
                    s.y(arrayList2.get(0).f1202a.f1018a, bVar, k());
                } else {
                    bVar.run();
                }
            }
            if (z8) {
                ArrayList<RecyclerView.b0> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.f1164i);
                this.f1167l.add(arrayList3);
                this.f1164i.clear();
                RunnableC0021c runnableC0021c = new RunnableC0021c(arrayList3);
                if (z5 || z6 || z7) {
                    s.y(arrayList3.get(0).f1018a, runnableC0021c, (z5 ? k() : 0L) + Math.max(z6 ? j() : 0L, z7 ? i() : 0L));
                } else {
                    runnableC0021c.run();
                }
            }
        }
    }
}

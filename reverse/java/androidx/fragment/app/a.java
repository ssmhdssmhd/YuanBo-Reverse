package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.i;
import androidx.fragment.app.m;
import java.io.PrintWriter;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class a extends m implements i.k {

    /* renamed from: s, reason: collision with root package name */
    final i f608s;

    /* renamed from: t, reason: collision with root package name */
    boolean f609t;

    /* renamed from: u, reason: collision with root package name */
    int f610u = -1;

    public a(i iVar) {
        this.f608s = iVar;
    }

    private static boolean l(m.a aVar) {
        Fragment fragment = aVar.f742b;
        return (fragment == null || !fragment.f571k || fragment.G == null || fragment.f586z || fragment.f585y || !fragment.O()) ? false : true;
    }

    @Override // androidx.fragment.app.i.k
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (i.H) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f730h) {
            return true;
        }
        this.f608s.g(this);
        return true;
    }

    void c(int i6) {
        if (this.f730h) {
            if (i.H) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i6);
            }
            int size = this.f723a.size();
            for (int i7 = 0; i7 < size; i7++) {
                m.a aVar = this.f723a.get(i7);
                Fragment fragment = aVar.f742b;
                if (fragment != null) {
                    fragment.f577q += i6;
                    if (i.H) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f742b + " to " + aVar.f742b.f577q);
                    }
                }
            }
        }
    }

    public void d(String str, PrintWriter printWriter) {
        e(str, printWriter, true);
    }

    public void e(String str, PrintWriter printWriter, boolean z5) {
        String str2;
        if (z5) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f732j);
            printWriter.print(" mIndex=");
            printWriter.print(this.f610u);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f609t);
            if (this.f728f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f728f));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f729g));
            }
            if (this.f724b != 0 || this.f725c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f724b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f725c));
            }
            if (this.f726d != 0 || this.f727e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f726d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f727e));
            }
            if (this.f733k != 0 || this.f734l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f733k));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f734l);
            }
            if (this.f735m != 0 || this.f736n != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f735m));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f736n);
            }
        }
        if (this.f723a.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f723a.size();
        for (int i6 = 0; i6 < size; i6++) {
            m.a aVar = this.f723a.get(i6);
            switch (aVar.f741a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f741a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i6);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f742b);
            if (z5) {
                if (aVar.f743c != 0 || aVar.f744d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f743c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f744d));
                }
                if (aVar.f745e != 0 || aVar.f746f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f745e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f746f));
                }
            }
        }
    }

    void f() {
        int size = this.f723a.size();
        for (int i6 = 0; i6 < size; i6++) {
            m.a aVar = this.f723a.get(i6);
            Fragment fragment = aVar.f742b;
            if (fragment != null) {
                fragment.f1(this.f728f, this.f729g);
            }
            switch (aVar.f741a) {
                case 1:
                    fragment.e1(aVar.f743c);
                    this.f608s.h(fragment, false);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f741a);
                case 3:
                    fragment.e1(aVar.f744d);
                    this.f608s.T0(fragment);
                    break;
                case 4:
                    fragment.e1(aVar.f744d);
                    this.f608s.x0(fragment);
                    break;
                case 5:
                    fragment.e1(aVar.f743c);
                    this.f608s.g1(fragment);
                    break;
                case 6:
                    fragment.e1(aVar.f744d);
                    this.f608s.s(fragment);
                    break;
                case 7:
                    fragment.e1(aVar.f743c);
                    this.f608s.l(fragment);
                    break;
                case 8:
                    this.f608s.f1(fragment);
                    break;
                case 9:
                    this.f608s.f1(null);
                    break;
                case 10:
                    this.f608s.e1(fragment, aVar.f748h);
                    break;
            }
            if (!this.f739q && aVar.f741a != 1 && fragment != null) {
                this.f608s.J0(fragment);
            }
        }
        if (this.f739q) {
            return;
        }
        i iVar = this.f608s;
        iVar.K0(iVar.f659p, true);
    }

    void g(boolean z5) {
        for (int size = this.f723a.size() - 1; size >= 0; size--) {
            m.a aVar = this.f723a.get(size);
            Fragment fragment = aVar.f742b;
            if (fragment != null) {
                fragment.f1(i.Y0(this.f728f), this.f729g);
            }
            switch (aVar.f741a) {
                case 1:
                    fragment.e1(aVar.f746f);
                    this.f608s.T0(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f741a);
                case 3:
                    fragment.e1(aVar.f745e);
                    this.f608s.h(fragment, false);
                    break;
                case 4:
                    fragment.e1(aVar.f745e);
                    this.f608s.g1(fragment);
                    break;
                case 5:
                    fragment.e1(aVar.f746f);
                    this.f608s.x0(fragment);
                    break;
                case 6:
                    fragment.e1(aVar.f745e);
                    this.f608s.l(fragment);
                    break;
                case 7:
                    fragment.e1(aVar.f746f);
                    this.f608s.s(fragment);
                    break;
                case 8:
                    this.f608s.f1(null);
                    break;
                case 9:
                    this.f608s.f1(fragment);
                    break;
                case 10:
                    this.f608s.e1(fragment, aVar.f747g);
                    break;
            }
            if (!this.f739q && aVar.f741a != 3 && fragment != null) {
                this.f608s.J0(fragment);
            }
        }
        if (this.f739q || !z5) {
            return;
        }
        i iVar = this.f608s;
        iVar.K0(iVar.f659p, true);
    }

    Fragment h(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i6 = 0;
        while (i6 < this.f723a.size()) {
            m.a aVar = this.f723a.get(i6);
            int i7 = aVar.f741a;
            if (i7 != 1) {
                if (i7 == 2) {
                    Fragment fragment3 = aVar.f742b;
                    int i8 = fragment3.f583w;
                    boolean z5 = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = arrayList.get(size);
                        if (fragment4.f583w == i8) {
                            if (fragment4 == fragment3) {
                                z5 = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.f723a.add(i6, new m.a(9, fragment4));
                                    i6++;
                                    fragment2 = null;
                                }
                                m.a aVar2 = new m.a(3, fragment4);
                                aVar2.f743c = aVar.f743c;
                                aVar2.f745e = aVar.f745e;
                                aVar2.f744d = aVar.f744d;
                                aVar2.f746f = aVar.f746f;
                                this.f723a.add(i6, aVar2);
                                arrayList.remove(fragment4);
                                i6++;
                            }
                        }
                    }
                    if (z5) {
                        this.f723a.remove(i6);
                        i6--;
                    } else {
                        aVar.f741a = 1;
                        arrayList.add(fragment3);
                    }
                } else if (i7 == 3 || i7 == 6) {
                    arrayList.remove(aVar.f742b);
                    Fragment fragment5 = aVar.f742b;
                    if (fragment5 == fragment2) {
                        this.f723a.add(i6, new m.a(9, fragment5));
                        i6++;
                        fragment2 = null;
                    }
                } else if (i7 != 7) {
                    if (i7 == 8) {
                        this.f723a.add(i6, new m.a(9, fragment2));
                        i6++;
                        fragment2 = aVar.f742b;
                    }
                }
                i6++;
            }
            arrayList.add(aVar.f742b);
            i6++;
        }
        return fragment2;
    }

    public String i() {
        return this.f732j;
    }

    boolean j(int i6) {
        int size = this.f723a.size();
        for (int i7 = 0; i7 < size; i7++) {
            Fragment fragment = this.f723a.get(i7).f742b;
            int i8 = fragment != null ? fragment.f583w : 0;
            if (i8 != 0 && i8 == i6) {
                return true;
            }
        }
        return false;
    }

    boolean k(ArrayList<a> arrayList, int i6, int i7) {
        if (i7 == i6) {
            return false;
        }
        int size = this.f723a.size();
        int i8 = -1;
        for (int i9 = 0; i9 < size; i9++) {
            Fragment fragment = this.f723a.get(i9).f742b;
            int i10 = fragment != null ? fragment.f583w : 0;
            if (i10 != 0 && i10 != i8) {
                for (int i11 = i6; i11 < i7; i11++) {
                    a aVar = arrayList.get(i11);
                    int size2 = aVar.f723a.size();
                    for (int i12 = 0; i12 < size2; i12++) {
                        Fragment fragment2 = aVar.f723a.get(i12).f742b;
                        if ((fragment2 != null ? fragment2.f583w : 0) == i10) {
                            return true;
                        }
                    }
                }
                i8 = i10;
            }
        }
        return false;
    }

    boolean m() {
        for (int i6 = 0; i6 < this.f723a.size(); i6++) {
            if (l(this.f723a.get(i6))) {
                return true;
            }
        }
        return false;
    }

    public void n() {
        if (this.f740r != null) {
            for (int i6 = 0; i6 < this.f740r.size(); i6++) {
                this.f740r.get(i6).run();
            }
            this.f740r = null;
        }
    }

    void o(Fragment.f fVar) {
        for (int i6 = 0; i6 < this.f723a.size(); i6++) {
            m.a aVar = this.f723a.get(i6);
            if (l(aVar)) {
                aVar.f742b.g1(fVar);
            }
        }
    }

    Fragment p(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f723a.size() - 1; size >= 0; size--) {
            m.a aVar = this.f723a.get(size);
            int i6 = aVar.f741a;
            if (i6 != 1) {
                if (i6 != 3) {
                    switch (i6) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f742b;
                            break;
                        case 10:
                            aVar.f748h = aVar.f747g;
                            break;
                    }
                }
                arrayList.add(aVar.f742b);
            }
            arrayList.remove(aVar.f742b);
        }
        return fragment;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f610u >= 0) {
            sb.append(" #");
            sb.append(this.f610u);
        }
        if (this.f732j != null) {
            sb.append(" ");
            sb.append(this.f732j);
        }
        sb.append("}");
        return sb.toString();
    }
}

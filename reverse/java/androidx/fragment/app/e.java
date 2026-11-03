package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.y;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final g<?> f637a;

    private e(g<?> gVar) {
        this.f637a = gVar;
    }

    public static e b(g<?> gVar) {
        return new e((g) androidx.core.util.g.b(gVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        g<?> gVar = this.f637a;
        gVar.f643e.k(gVar, gVar, fragment);
    }

    public void c() {
        this.f637a.f643e.t();
    }

    public void d(Configuration configuration) {
        this.f637a.f643e.u(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f637a.f643e.v(menuItem);
    }

    public void f() {
        this.f637a.f643e.w();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f637a.f643e.x(menu, menuInflater);
    }

    public void h() {
        this.f637a.f643e.y();
    }

    public void i() {
        this.f637a.f643e.A();
    }

    public void j(boolean z5) {
        this.f637a.f643e.B(z5);
    }

    public boolean k(MenuItem menuItem) {
        return this.f637a.f643e.Q(menuItem);
    }

    public void l(Menu menu) {
        this.f637a.f643e.R(menu);
    }

    public void m() {
        this.f637a.f643e.T();
    }

    public void n(boolean z5) {
        this.f637a.f643e.U(z5);
    }

    public boolean o(Menu menu) {
        return this.f637a.f643e.V(menu);
    }

    public void p() {
        this.f637a.f643e.X();
    }

    public void q() {
        this.f637a.f643e.Y();
    }

    public void r() {
        this.f637a.f643e.a0();
    }

    public boolean s() {
        return this.f637a.f643e.f0();
    }

    public Fragment t(String str) {
        return this.f637a.f643e.l0(str);
    }

    public h u() {
        return this.f637a.f643e;
    }

    public void v() {
        this.f637a.f643e.N0();
    }

    public View w(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f637a.f643e.onCreateView(view, str, context, attributeSet);
    }

    public void x(Parcelable parcelable) {
        g<?> gVar = this.f637a;
        if (!(gVar instanceof y)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        gVar.f643e.X0(parcelable);
    }

    public Parcelable y() {
        return this.f637a.f643e.Z0();
    }
}

package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.a;
import androidx.lifecycle.d;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class c extends ComponentActivity implements a.c, a.e {

    /* renamed from: j, reason: collision with root package name */
    boolean f628j;

    /* renamed from: k, reason: collision with root package name */
    boolean f629k;

    /* renamed from: m, reason: collision with root package name */
    boolean f631m;

    /* renamed from: n, reason: collision with root package name */
    boolean f632n;

    /* renamed from: o, reason: collision with root package name */
    boolean f633o;

    /* renamed from: p, reason: collision with root package name */
    int f634p;

    /* renamed from: q, reason: collision with root package name */
    f.g<String> f635q;

    /* renamed from: h, reason: collision with root package name */
    final e f626h = e.b(new a());

    /* renamed from: i, reason: collision with root package name */
    final androidx.lifecycle.j f627i = new androidx.lifecycle.j(this);

    /* renamed from: l, reason: collision with root package name */
    boolean f630l = true;

    class a extends g<c> implements y, androidx.activity.c {
        public a() {
            super(c.this);
        }

        @Override // androidx.lifecycle.i
        public androidx.lifecycle.d a() {
            return c.this.f627i;
        }

        @Override // androidx.fragment.app.g, androidx.fragment.app.d
        public View c(int i6) {
            return c.this.findViewById(i6);
        }

        @Override // androidx.lifecycle.y
        public x d() {
            return c.this.d();
        }

        @Override // androidx.fragment.app.g, androidx.fragment.app.d
        public boolean e() {
            Window window = c.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.activity.c
        public OnBackPressedDispatcher h() {
            return c.this.h();
        }

        @Override // androidx.fragment.app.g
        public void k(Fragment fragment) {
            c.this.n(fragment);
        }

        @Override // androidx.fragment.app.g
        public void l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            c.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.g
        public LayoutInflater n() {
            return c.this.getLayoutInflater().cloneInContext(c.this);
        }

        @Override // androidx.fragment.app.g
        public int o() {
            Window window = c.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // androidx.fragment.app.g
        public boolean p() {
            return c.this.getWindow() != null;
        }

        @Override // androidx.fragment.app.g
        public boolean q(Fragment fragment) {
            return !c.this.isFinishing();
        }

        @Override // androidx.fragment.app.g
        public void r() {
            c.this.q();
        }

        @Override // androidx.fragment.app.g
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public c m() {
            return c.this;
        }
    }

    static void g(int i6) {
        if ((i6 & (-65536)) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    private void l() {
        while (m(k(), d.c.CREATED)) {
        }
    }

    private static boolean m(h hVar, d.c cVar) {
        boolean z5 = false;
        for (Fragment fragment : hVar.c()) {
            if (fragment != null) {
                if (fragment.a().b().a(d.c.STARTED)) {
                    fragment.S.o(cVar);
                    z5 = true;
                }
                if (fragment.u() != null) {
                    z5 |= m(fragment.n(), cVar);
                }
            }
        }
        return z5;
    }

    @Override // androidx.core.app.a.e
    public final void b(int i6) {
        if (this.f631m || i6 == -1) {
            return;
        }
        g(i6);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f628j);
        printWriter.print(" mResumed=");
        printWriter.print(this.f629k);
        printWriter.print(" mStopped=");
        printWriter.print(this.f630l);
        if (getApplication() != null) {
            androidx.loader.app.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.f626h.u().a(str, fileDescriptor, printWriter, strArr);
    }

    final View j(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f626h.w(view, str, context, attributeSet);
    }

    public h k() {
        return this.f626h.u();
    }

    public void n(Fragment fragment) {
    }

    @Deprecated
    protected boolean o(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i6, int i7, Intent intent) {
        this.f626h.v();
        int i8 = i6 >> 16;
        if (i8 == 0) {
            androidx.core.app.a.g();
            super.onActivityResult(i6, i7, intent);
            return;
        }
        int i9 = i8 - 1;
        String d6 = this.f635q.d(i9);
        this.f635q.h(i9);
        if (d6 == null) {
            Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
            return;
        }
        Fragment t5 = this.f626h.t(d6);
        if (t5 != null) {
            t5.S(i6 & 65535, i7, intent);
            return;
        }
        Log.w("FragmentActivity", "Activity result no fragment exists for who: " + d6);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f626h.v();
        this.f626h.d(configuration);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.l, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.f626h.a(null);
        if (bundle != null) {
            this.f626h.x(bundle.getParcelable("android:support:fragments"));
            if (bundle.containsKey("android:support:next_request_index")) {
                this.f634p = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.f635q = new f.g<>(intArray.length);
                    for (int i6 = 0; i6 < intArray.length; i6++) {
                        this.f635q.g(intArray[i6], stringArray[i6]);
                    }
                }
            }
        }
        if (this.f635q == null) {
            this.f635q = new f.g<>();
            this.f634p = 0;
        }
        super.onCreate(bundle);
        this.f627i.h(d.b.ON_CREATE);
        this.f626h.f();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i6, Menu menu) {
        return i6 == 0 ? super.onCreatePanelMenu(i6, menu) | this.f626h.g(menu, getMenuInflater()) : super.onCreatePanelMenu(i6, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View j6 = j(view, str, context, attributeSet);
        return j6 == null ? super.onCreateView(view, str, context, attributeSet) : j6;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View j6 = j(null, str, context, attributeSet);
        return j6 == null ? super.onCreateView(str, context, attributeSet) : j6;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f626h.h();
        this.f627i.h(d.b.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.f626h.i();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i6, MenuItem menuItem) {
        if (super.onMenuItemSelected(i6, menuItem)) {
            return true;
        }
        if (i6 == 0) {
            return this.f626h.k(menuItem);
        }
        if (i6 != 6) {
            return false;
        }
        return this.f626h.e(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z5) {
        this.f626h.j(z5);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f626h.v();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i6, Menu menu) {
        if (i6 == 0) {
            this.f626h.l(menu);
        }
        super.onPanelClosed(i6, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f629k = false;
        this.f626h.m();
        this.f627i.h(d.b.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z5) {
        this.f626h.n(z5);
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        p();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i6, View view, Menu menu) {
        return i6 == 0 ? o(view, menu) | this.f626h.o(menu) : super.onPreparePanel(i6, view, menu);
    }

    @Override // android.app.Activity, androidx.core.app.a.c
    public void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        this.f626h.v();
        int i7 = (i6 >> 16) & 65535;
        if (i7 != 0) {
            int i8 = i7 - 1;
            String d6 = this.f635q.d(i8);
            this.f635q.h(i8);
            if (d6 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment t5 = this.f626h.t(d6);
            if (t5 != null) {
                t5.r0(i6 & 65535, strArr, iArr);
                return;
            }
            Log.w("FragmentActivity", "Activity result no fragment exists for who: " + d6);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f629k = true;
        this.f626h.v();
        this.f626h.s();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.l, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        l();
        this.f627i.h(d.b.ON_STOP);
        Parcelable y5 = this.f626h.y();
        if (y5 != null) {
            bundle.putParcelable("android:support:fragments", y5);
        }
        if (this.f635q.i() > 0) {
            bundle.putInt("android:support:next_request_index", this.f634p);
            int[] iArr = new int[this.f635q.i()];
            String[] strArr = new String[this.f635q.i()];
            for (int i6 = 0; i6 < this.f635q.i(); i6++) {
                iArr[i6] = this.f635q.f(i6);
                strArr[i6] = this.f635q.k(i6);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f630l = false;
        if (!this.f628j) {
            this.f628j = true;
            this.f626h.c();
        }
        this.f626h.v();
        this.f626h.s();
        this.f627i.h(d.b.ON_START);
        this.f626h.q();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.f626h.v();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.f630l = true;
        l();
        this.f626h.r();
        this.f627i.h(d.b.ON_STOP);
    }

    protected void p() {
        this.f627i.h(d.b.ON_RESUME);
        this.f626h.p();
    }

    @Deprecated
    public void q() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i6) {
        if (!this.f633o && i6 != -1) {
            g(i6);
        }
        super.startActivityForResult(intent, i6);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i6, Bundle bundle) {
        if (!this.f633o && i6 != -1) {
            g(i6);
        }
        super.startActivityForResult(intent, i6, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i6, Intent intent, int i7, int i8, int i9) {
        if (!this.f632n && i6 != -1) {
            g(i6);
        }
        super.startIntentSenderForResult(intentSender, i6, intent, i7, i8, i9);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i6, Intent intent, int i7, int i8, int i9, Bundle bundle) {
        if (!this.f632n && i6 != -1) {
            g(i6);
        }
        super.startIntentSenderForResult(intentSender, i6, intent, i7, i8, i9, bundle);
    }
}

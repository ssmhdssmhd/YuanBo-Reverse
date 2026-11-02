package io.flutter.plugin.platform;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.core.view.d2;
import io.flutter.plugin.platform.f;
import java.io.FileNotFoundException;
import java.util.List;
import x3.i;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f6132a;

    /* renamed from: b, reason: collision with root package name */
    private final x3.i f6133b;

    /* renamed from: c, reason: collision with root package name */
    private final d f6134c;

    /* renamed from: d, reason: collision with root package name */
    private i.j f6135d;

    /* renamed from: e, reason: collision with root package name */
    private int f6136e;

    /* renamed from: f, reason: collision with root package name */
    final i.h f6137f;

    class a implements i.h {
        a() {
        }

        @Override // x3.i.h
        public void a(i.EnumC0166i enumC0166i) {
            f.this.q(enumC0166i);
        }

        @Override // x3.i.h
        public void b() {
            f.this.r();
        }

        @Override // x3.i.h
        public CharSequence c(i.e eVar) {
            return f.this.p(eVar);
        }

        @Override // x3.i.h
        public void d(i.k kVar) {
            f.this.w(kVar);
        }

        @Override // x3.i.h
        public void e(List<i.l> list) {
            f.this.x(list);
        }

        @Override // x3.i.h
        public void f(i.j jVar) {
            f.this.z(jVar);
        }

        @Override // x3.i.h
        public void g() {
            f.this.v();
        }

        @Override // x3.i.h
        public void h() {
            f.this.s();
        }

        @Override // x3.i.h
        public void i(String str) {
            f.this.t(str);
        }

        @Override // x3.i.h
        public void j(i.g gVar) {
            f.this.B(gVar);
        }

        @Override // x3.i.h
        public void k(i.c cVar) {
            f.this.u(cVar);
        }

        @Override // x3.i.h
        public void l(int i6) {
            f.this.y(i6);
        }

        @Override // x3.i.h
        public boolean m() {
            return f.this.n();
        }
    }

    class b implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f6139a;

        b(View view) {
            this.f6139a = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i6) {
            x3.i iVar;
            boolean z5;
            if ((i6 & 4) == 0) {
                iVar = f.this.f6133b;
                z5 = true;
            } else {
                iVar = f.this.f6133b;
                z5 = false;
            }
            iVar.m(z5);
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(final int i6) {
            this.f6139a.post(new Runnable() { // from class: io.flutter.plugin.platform.g
                @Override // java.lang.Runnable
                public final void run() {
                    f.b.this.b(i6);
                }
            });
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6141a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f6142b;

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f6143c;

        static {
            int[] iArr = new int[i.d.values().length];
            f6143c = iArr;
            try {
                iArr[i.d.DARK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6143c[i.d.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[i.l.values().length];
            f6142b = iArr2;
            try {
                iArr2[i.l.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6142b[i.l.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[i.g.values().length];
            f6141a = iArr3;
            try {
                iArr3[i.g.STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6141a[i.g.LIGHT_IMPACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6141a[i.g.MEDIUM_IMPACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6141a[i.g.HEAVY_IMPACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6141a[i.g.SELECTION_CLICK.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public interface d {
        boolean b();
    }

    public f(Activity activity, x3.i iVar, d dVar) {
        a aVar = new a();
        this.f6137f = aVar;
        this.f6132a = activity;
        this.f6133b = iVar;
        iVar.l(aVar);
        this.f6134c = dVar;
        this.f6136e = 1280;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        ClipDescription primaryClipDescription;
        ClipboardManager clipboardManager = (ClipboardManager) this.f6132a.getSystemService("clipboard");
        if (clipboardManager.hasPrimaryClip() && (primaryClipDescription = clipboardManager.getPrimaryClipDescription()) != null) {
            return primaryClipDescription.hasMimeType("text/*");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CharSequence p(i.e eVar) {
        ClipboardManager clipboardManager = (ClipboardManager) this.f6132a.getSystemService("clipboard");
        if (!clipboardManager.hasPrimaryClip()) {
            return null;
        }
        try {
            ClipData primaryClip = clipboardManager.getPrimaryClip();
            if (primaryClip == null) {
                return null;
            }
            if (eVar != null && eVar != i.e.PLAIN_TEXT) {
                return null;
            }
            ClipData.Item itemAt = primaryClip.getItemAt(0);
            if (itemAt.getUri() != null) {
                this.f6132a.getContentResolver().openTypedAssetFileDescriptor(itemAt.getUri(), "text/*", null);
            }
            return itemAt.coerceToText(this.f6132a);
        } catch (FileNotFoundException unused) {
            return null;
        } catch (SecurityException e6) {
            k3.b.h("PlatformPlugin", "Attempted to get clipboard data that requires additional permission(s).\nSee the exception details for which permission(s) are required, and consider adding them to your Android Manifest as described in:\nhttps://developer.android.com/guide/topics/permissions/overview", e6);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(i.EnumC0166i enumC0166i) {
        if (enumC0166i == i.EnumC0166i.CLICK) {
            this.f6132a.getWindow().getDecorView().playSoundEffect(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void r() {
        d dVar = this.f6134c;
        if (dVar == null || !dVar.b()) {
            Activity activity = this.f6132a;
            if (activity instanceof androidx.activity.c) {
                ((androidx.activity.c) activity).h().c();
            } else {
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str) {
        ((ClipboardManager) this.f6132a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(i.c cVar) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 < 28 && i6 > 21) {
            this.f6132a.setTaskDescription(new ActivityManager.TaskDescription(cVar.f10508b, (Bitmap) null, cVar.f10507a));
        }
        if (i6 >= 28) {
            this.f6132a.setTaskDescription(new ActivityManager.TaskDescription(cVar.f10508b, 0, cVar.f10507a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        View decorView = this.f6132a.getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new b(decorView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(i.k kVar) {
        int i6;
        if (kVar == i.k.LEAN_BACK) {
            i6 = 1798;
        } else if (kVar == i.k.IMMERSIVE) {
            i6 = 3846;
        } else if (kVar == i.k.IMMERSIVE_STICKY) {
            i6 = 5894;
        } else if (kVar != i.k.EDGE_TO_EDGE || Build.VERSION.SDK_INT < 29) {
            return;
        } else {
            i6 = 1792;
        }
        this.f6136e = i6;
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(List<i.l> list) {
        int i6 = list.size() == 0 ? 5894 : 1798;
        for (int i7 = 0; i7 < list.size(); i7++) {
            int i8 = c.f6142b[list.get(i7).ordinal()];
            if (i8 == 1) {
                i6 &= -5;
            } else if (i8 == 2) {
                i6 = i6 & (-513) & (-3);
            }
        }
        this.f6136e = i6;
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i6) {
        this.f6132a.setRequestedOrientation(i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(i.j jVar) {
        Window window = this.f6132a.getWindow();
        d2 d2Var = new d2(window, window.getDecorView());
        int i6 = Build.VERSION.SDK_INT;
        if (i6 < 30) {
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(201326592);
        }
        if (i6 >= 23) {
            i.d dVar = jVar.f10534b;
            if (dVar != null) {
                int i7 = c.f6143c[dVar.ordinal()];
                if (i7 == 1) {
                    d2Var.b(true);
                } else if (i7 == 2) {
                    d2Var.b(false);
                }
            }
            Integer num = jVar.f10533a;
            if (num != null) {
                window.setStatusBarColor(num.intValue());
            }
        }
        Boolean bool = jVar.f10535c;
        if (bool != null && i6 >= 29) {
            window.setStatusBarContrastEnforced(bool.booleanValue());
        }
        if (i6 >= 26) {
            i.d dVar2 = jVar.f10537e;
            if (dVar2 != null) {
                int i8 = c.f6143c[dVar2.ordinal()];
                if (i8 == 1) {
                    d2Var.a(true);
                } else if (i8 == 2) {
                    d2Var.a(false);
                }
            }
            Integer num2 = jVar.f10536d;
            if (num2 != null) {
                window.setNavigationBarColor(num2.intValue());
            }
        }
        Integer num3 = jVar.f10538f;
        if (num3 != null && i6 >= 28) {
            window.setNavigationBarDividerColor(num3.intValue());
        }
        Boolean bool2 = jVar.f10539g;
        if (bool2 != null && i6 >= 29) {
            window.setNavigationBarContrastEnforced(bool2.booleanValue());
        }
        this.f6135d = jVar;
    }

    public void A() {
        this.f6132a.getWindow().getDecorView().setSystemUiVisibility(this.f6136e);
        i.j jVar = this.f6135d;
        if (jVar != null) {
            z(jVar);
        }
    }

    void B(i.g gVar) {
        int i6;
        View decorView = this.f6132a.getWindow().getDecorView();
        int i7 = c.f6141a[gVar.ordinal()];
        int i8 = 1;
        if (i7 != 1) {
            if (i7 != 2) {
                i8 = 3;
                if (i7 != 3) {
                    i8 = 4;
                    if (i7 != 4) {
                        if (i7 != 5) {
                            return;
                        }
                    } else if (Build.VERSION.SDK_INT < 23) {
                        return;
                    } else {
                        i6 = 6;
                    }
                }
            }
            decorView.performHapticFeedback(i8);
            return;
        }
        i6 = 0;
        decorView.performHapticFeedback(i6);
    }

    public void o() {
        this.f6133b.l(null);
    }
}

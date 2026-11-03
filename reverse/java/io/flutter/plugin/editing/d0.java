package io.flutter.plugin.editing;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import io.flutter.embedding.android.e0;
import io.flutter.plugin.editing.j;
import java.util.HashMap;
import x3.p;

/* loaded from: classes.dex */
public class d0 implements j.b {

    /* renamed from: a, reason: collision with root package name */
    private final View f6050a;

    /* renamed from: b, reason: collision with root package name */
    private final InputMethodManager f6051b;

    /* renamed from: c, reason: collision with root package name */
    private final AutofillManager f6052c;

    /* renamed from: d, reason: collision with root package name */
    private final x3.p f6053d;

    /* renamed from: e, reason: collision with root package name */
    private c f6054e = new c(c.a.NO_TARGET, 0);

    /* renamed from: f, reason: collision with root package name */
    private p.b f6055f;

    /* renamed from: g, reason: collision with root package name */
    private SparseArray<p.b> f6056g;

    /* renamed from: h, reason: collision with root package name */
    private j f6057h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f6058i;

    /* renamed from: j, reason: collision with root package name */
    private InputConnection f6059j;

    /* renamed from: k, reason: collision with root package name */
    private io.flutter.plugin.platform.u f6060k;

    /* renamed from: l, reason: collision with root package name */
    private Rect f6061l;

    /* renamed from: m, reason: collision with root package name */
    private ImeSyncDeferringInsetsCallback f6062m;

    /* renamed from: n, reason: collision with root package name */
    private p.e f6063n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f6064o;

    class a implements p.f {
        a() {
        }

        @Override // x3.p.f
        public void a(int i6, p.b bVar) {
            d0.this.D(i6, bVar);
        }

        @Override // x3.p.f
        public void b() {
            d0.this.m();
        }

        @Override // x3.p.f
        public void c() {
            d0 d0Var = d0.this;
            d0Var.F(d0Var.f6050a);
        }

        @Override // x3.p.f
        public void d(p.e eVar) {
            d0 d0Var = d0.this;
            d0Var.E(d0Var.f6050a, eVar);
        }

        @Override // x3.p.f
        public void e(String str, Bundle bundle) {
            d0.this.B(str, bundle);
        }

        @Override // x3.p.f
        public void f(int i6, boolean z5) {
            d0.this.C(i6, z5);
        }

        @Override // x3.p.f
        public void g(double d6, double d7, double[] dArr) {
            d0.this.A(d6, d7, dArr);
        }

        @Override // x3.p.f
        public void h() {
            d0.this.x();
        }

        @Override // x3.p.f
        public void i(boolean z5) {
            if (Build.VERSION.SDK_INT < 26 || d0.this.f6052c == null) {
                return;
            }
            if (z5) {
                d0.this.f6052c.commit();
            } else {
                d0.this.f6052c.cancel();
            }
        }

        @Override // x3.p.f
        public void j() {
            if (d0.this.f6054e.f6070a == c.a.PHYSICAL_DISPLAY_PLATFORM_VIEW) {
                d0.this.y();
            } else {
                d0 d0Var = d0.this;
                d0Var.s(d0Var.f6050a);
            }
        }
    }

    class b implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f6066a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ double[] f6067b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ double[] f6068c;

        b(boolean z5, double[] dArr, double[] dArr2) {
            this.f6066a = z5;
            this.f6067b = dArr;
            this.f6068c = dArr2;
        }

        @Override // io.flutter.plugin.editing.d0.d
        public void a(double d6, double d7) {
            double d8 = 1.0d;
            if (!this.f6066a) {
                double[] dArr = this.f6067b;
                d8 = 1.0d / (((dArr[3] * d6) + (dArr[7] * d7)) + dArr[15]);
            }
            double[] dArr2 = this.f6067b;
            double d9 = ((dArr2[0] * d6) + (dArr2[4] * d7) + dArr2[12]) * d8;
            double d10 = ((dArr2[1] * d6) + (dArr2[5] * d7) + dArr2[13]) * d8;
            double[] dArr3 = this.f6068c;
            if (d9 < dArr3[0]) {
                dArr3[0] = d9;
            } else if (d9 > dArr3[1]) {
                dArr3[1] = d9;
            }
            if (d10 < dArr3[2]) {
                dArr3[2] = d10;
            } else if (d10 > dArr3[3]) {
                dArr3[3] = d10;
            }
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        a f6070a;

        /* renamed from: b, reason: collision with root package name */
        int f6071b;

        enum a {
            NO_TARGET,
            FRAMEWORK_CLIENT,
            VIRTUAL_DISPLAY_PLATFORM_VIEW,
            PHYSICAL_DISPLAY_PLATFORM_VIEW
        }

        public c(a aVar, int i6) {
            this.f6070a = aVar;
            this.f6071b = i6;
        }
    }

    private interface d {
        void a(double d6, double d7);
    }

    public d0(View view, x3.p pVar, io.flutter.plugin.platform.u uVar) {
        int ime;
        int statusBars;
        int navigationBars;
        Object systemService;
        int i6 = 0;
        this.f6050a = view;
        AutofillManager autofillManager = null;
        this.f6057h = new j(null, view);
        this.f6051b = (InputMethodManager) view.getContext().getSystemService("input_method");
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 26) {
            systemService = view.getContext().getSystemService((Class<Object>) AutofillManager.class);
            autofillManager = (AutofillManager) systemService;
        }
        this.f6052c = autofillManager;
        if (i7 >= 30) {
            if ((view.getWindowSystemUiVisibility() & 2) == 0) {
                navigationBars = WindowInsets.Type.navigationBars();
                i6 = 0 | navigationBars;
            }
            if ((view.getWindowSystemUiVisibility() & 4) == 0) {
                statusBars = WindowInsets.Type.statusBars();
                i6 |= statusBars;
            }
            ime = WindowInsets.Type.ime();
            ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = new ImeSyncDeferringInsetsCallback(view, i6, ime);
            this.f6062m = imeSyncDeferringInsetsCallback;
            imeSyncDeferringInsetsCallback.install();
        }
        this.f6053d = pVar;
        pVar.n(new a());
        pVar.k();
        this.f6060k = uVar;
        uVar.C(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(double d6, double d7, double[] dArr) {
        double[] dArr2 = new double[4];
        boolean z5 = dArr[3] == 0.0d && dArr[7] == 0.0d && dArr[15] == 1.0d;
        double d8 = dArr[12];
        double d9 = dArr[15];
        double d10 = d8 / d9;
        dArr2[1] = d10;
        dArr2[0] = d10;
        double d11 = dArr[13] / d9;
        dArr2[3] = d11;
        dArr2[2] = d11;
        b bVar = new b(z5, dArr, dArr2);
        bVar.a(d6, 0.0d);
        bVar.a(d6, d7);
        bVar.a(0.0d, d7);
        Float valueOf = Float.valueOf(this.f6050a.getContext().getResources().getDisplayMetrics().density);
        this.f6061l = new Rect((int) (dArr2[0] * valueOf.floatValue()), (int) (dArr2[2] * valueOf.floatValue()), (int) Math.ceil(dArr2[1] * valueOf.floatValue()), (int) Math.ceil(dArr2[3] * valueOf.floatValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(int i6, boolean z5) {
        if (!z5) {
            this.f6054e = new c(c.a.PHYSICAL_DISPLAY_PLATFORM_VIEW, i6);
            this.f6059j = null;
        } else {
            this.f6050a.requestFocus();
            this.f6054e = new c(c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW, i6);
            this.f6051b.restartInput(this.f6050a);
            this.f6058i = false;
        }
    }

    private void H(p.b bVar) {
        AutofillValue forText;
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        if (bVar == null || bVar.f10624j == null) {
            this.f6056g = null;
            return;
        }
        p.b[] bVarArr = bVar.f10626l;
        SparseArray<p.b> sparseArray = new SparseArray<>();
        this.f6056g = sparseArray;
        if (bVarArr == null) {
            sparseArray.put(bVar.f10624j.f10627a.hashCode(), bVar);
            return;
        }
        for (p.b bVar2 : bVarArr) {
            p.b.a aVar = bVar2.f10624j;
            if (aVar != null) {
                this.f6056g.put(aVar.f10627a.hashCode(), bVar2);
                AutofillManager autofillManager = this.f6052c;
                View view = this.f6050a;
                int hashCode = aVar.f10627a.hashCode();
                forText = AutofillValue.forText(aVar.f10629c.f10640a);
                autofillManager.notifyValueChanged(view, hashCode, forText);
            }
        }
    }

    private boolean k() {
        p.c cVar;
        p.b bVar = this.f6055f;
        return bVar == null || (cVar = bVar.f10621g) == null || cVar.f10631a != p.g.NONE;
    }

    private static boolean n(p.e eVar, p.e eVar2) {
        int i6 = eVar.f10644e - eVar.f10643d;
        if (i6 != eVar2.f10644e - eVar2.f10643d) {
            return true;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            if (eVar.f10640a.charAt(eVar.f10643d + i7) != eVar2.f10640a.charAt(eVar2.f10643d + i7)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(View view) {
        y();
        this.f6051b.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    private static int t(p.c cVar, boolean z5, boolean z6, boolean z7, boolean z8, p.d dVar) {
        p.g gVar = cVar.f10631a;
        if (gVar == p.g.DATETIME) {
            return 4;
        }
        if (gVar == p.g.NUMBER) {
            int i6 = cVar.f10632b ? 4098 : 2;
            return cVar.f10633c ? i6 | 8192 : i6;
        }
        if (gVar == p.g.PHONE) {
            return 3;
        }
        if (gVar == p.g.NONE) {
            return 0;
        }
        int i7 = gVar == p.g.MULTILINE ? 131073 : gVar == p.g.EMAIL_ADDRESS ? 33 : gVar == p.g.URL ? 17 : gVar == p.g.VISIBLE_PASSWORD ? 145 : gVar == p.g.NAME ? 97 : gVar == p.g.POSTAL_ADDRESS ? 113 : 1;
        if (z5) {
            i7 = i7 | 524288 | 128;
        } else {
            if (z6) {
                i7 |= 32768;
            }
            if (!z7) {
                i7 |= 524288;
            }
        }
        return dVar == p.d.CHARACTERS ? i7 | 4096 : dVar == p.d.WORDS ? i7 | 8192 : dVar == p.d.SENTENCES ? i7 | 16384 : i7;
    }

    private boolean v() {
        return this.f6056g != null;
    }

    private void w(String str) {
        AutofillValue forText;
        if (Build.VERSION.SDK_INT < 26 || this.f6052c == null || !v()) {
            return;
        }
        String str2 = this.f6055f.f10624j.f10627a;
        AutofillManager autofillManager = this.f6052c;
        View view = this.f6050a;
        int hashCode = str2.hashCode();
        forText = AutofillValue.forText(str);
        autofillManager.notifyValueChanged(view, hashCode, forText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (Build.VERSION.SDK_INT < 26 || this.f6052c == null || !v()) {
            return;
        }
        String str = this.f6055f.f10624j.f10627a;
        int[] iArr = new int[2];
        this.f6050a.getLocationOnScreen(iArr);
        Rect rect = new Rect(this.f6061l);
        rect.offset(iArr[0], iArr[1]);
        this.f6052c.notifyViewEntered(this.f6050a, str.hashCode(), rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        p.b bVar;
        if (Build.VERSION.SDK_INT < 26 || this.f6052c == null || (bVar = this.f6055f) == null || bVar.f10624j == null || !v()) {
            return;
        }
        this.f6052c.notifyViewExited(this.f6050a, this.f6055f.f10624j.f10627a.hashCode());
    }

    public void B(String str, Bundle bundle) {
        this.f6051b.sendAppPrivateCommand(this.f6050a, str, bundle);
    }

    void D(int i6, p.b bVar) {
        y();
        this.f6055f = bVar;
        this.f6054e = k() ? new c(c.a.FRAMEWORK_CLIENT, i6) : new c(c.a.NO_TARGET, i6);
        this.f6057h.l(this);
        p.b.a aVar = bVar.f10624j;
        this.f6057h = new j(aVar != null ? aVar.f10629c : null, this.f6050a);
        H(bVar);
        this.f6058i = true;
        G();
        this.f6061l = null;
        this.f6057h.a(this);
    }

    void E(View view, p.e eVar) {
        p.e eVar2;
        if (!this.f6058i && (eVar2 = this.f6063n) != null && eVar2.b()) {
            boolean n6 = n(this.f6063n, eVar);
            this.f6058i = n6;
            if (n6) {
                k3.b.e("TextInputPlugin", "Composing region changed by the framework. Restarting the input method.");
            }
        }
        this.f6063n = eVar;
        this.f6057h.n(eVar);
        if (this.f6058i) {
            this.f6051b.restartInput(view);
            this.f6058i = false;
        }
    }

    void F(View view) {
        if (!k()) {
            s(view);
        } else {
            view.requestFocus();
            this.f6051b.showSoftInput(view, 0);
        }
    }

    public void G() {
        if (this.f6054e.f6070a == c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            this.f6064o = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
    
        if (r7 == r1.f10644e) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac  */
    @Override // io.flutter.plugin.editing.j.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r9, boolean r10, boolean r11) {
        /*
            r8 = this;
            if (r9 == 0) goto Lb
            io.flutter.plugin.editing.j r9 = r8.f6057h
            java.lang.String r9 = r9.toString()
            r8.w(r9)
        Lb:
            io.flutter.plugin.editing.j r9 = r8.f6057h
            int r9 = r9.i()
            io.flutter.plugin.editing.j r10 = r8.f6057h
            int r10 = r10.h()
            io.flutter.plugin.editing.j r11 = r8.f6057h
            int r11 = r11.g()
            io.flutter.plugin.editing.j r0 = r8.f6057h
            int r7 = r0.f()
            io.flutter.plugin.editing.j r0 = r8.f6057h
            java.util.ArrayList r0 = r0.e()
            x3.p$e r1 = r8.f6063n
            if (r1 == 0) goto L52
            io.flutter.plugin.editing.j r1 = r8.f6057h
            java.lang.String r1 = r1.toString()
            x3.p$e r2 = r8.f6063n
            java.lang.String r2 = r2.f10640a
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L50
            x3.p$e r1 = r8.f6063n
            int r2 = r1.f10641b
            if (r9 != r2) goto L50
            int r2 = r1.f10642c
            if (r10 != r2) goto L50
            int r2 = r1.f10643d
            if (r11 != r2) goto L50
            int r1 = r1.f10644e
            if (r7 != r1) goto L50
            goto L52
        L50:
            r1 = 0
            goto L53
        L52:
            r1 = 1
        L53:
            if (r1 != 0) goto Lac
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "send EditingState to flutter: "
            r1.append(r2)
            io.flutter.plugin.editing.j r2 = r8.f6057h
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "TextInputPlugin"
            k3.b.f(r2, r1)
            x3.p$b r1 = r8.f6055f
            boolean r1 = r1.f10619e
            if (r1 == 0) goto L86
            x3.p r1 = r8.f6053d
            io.flutter.plugin.editing.d0$c r2 = r8.f6054e
            int r2 = r2.f6071b
            r1.q(r2, r0)
            io.flutter.plugin.editing.j r0 = r8.f6057h
            r0.c()
            goto L99
        L86:
            x3.p r0 = r8.f6053d
            io.flutter.plugin.editing.d0$c r1 = r8.f6054e
            int r1 = r1.f6071b
            io.flutter.plugin.editing.j r2 = r8.f6057h
            java.lang.String r2 = r2.toString()
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r7
            r0.p(r1, r2, r3, r4, r5, r6)
        L99:
            x3.p$e r6 = new x3.p$e
            io.flutter.plugin.editing.j r0 = r8.f6057h
            java.lang.String r1 = r0.toString()
            r0 = r6
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r8.f6063n = r6
            goto Lb1
        Lac:
            io.flutter.plugin.editing.j r9 = r8.f6057h
            r9.c()
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.d0.a(boolean, boolean, boolean):void");
    }

    public void j(SparseArray<AutofillValue> sparseArray) {
        p.b bVar;
        p.b.a aVar;
        p.b.a aVar2;
        CharSequence textValue;
        if (Build.VERSION.SDK_INT < 26 || (bVar = this.f6055f) == null || this.f6056g == null || (aVar = bVar.f10624j) == null) {
            return;
        }
        HashMap<String, p.e> hashMap = new HashMap<>();
        for (int i6 = 0; i6 < sparseArray.size(); i6++) {
            p.b bVar2 = this.f6056g.get(sparseArray.keyAt(i6));
            if (bVar2 != null && (aVar2 = bVar2.f10624j) != null) {
                textValue = sparseArray.valueAt(i6).getTextValue();
                String charSequence = textValue.toString();
                p.e eVar = new p.e(charSequence, charSequence.length(), charSequence.length(), -1, -1);
                if (aVar2.f10627a.equals(aVar.f10627a)) {
                    this.f6057h.n(eVar);
                } else {
                    hashMap.put(aVar2.f10627a, eVar);
                }
            }
        }
        this.f6053d.r(this.f6054e.f6071b, hashMap);
    }

    public void l(int i6) {
        c cVar = this.f6054e;
        c.a aVar = cVar.f6070a;
        if ((aVar == c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW || aVar == c.a.PHYSICAL_DISPLAY_PLATFORM_VIEW) && cVar.f6071b == i6) {
            this.f6054e = new c(c.a.NO_TARGET, 0);
            y();
            this.f6051b.hideSoftInputFromWindow(this.f6050a.getApplicationWindowToken(), 0);
            this.f6051b.restartInput(this.f6050a);
            this.f6058i = false;
        }
    }

    void m() {
        if (this.f6054e.f6070a == c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            return;
        }
        this.f6057h.l(this);
        y();
        this.f6055f = null;
        H(null);
        this.f6054e = new c(c.a.NO_TARGET, 0);
        G();
        this.f6061l = null;
    }

    public InputConnection o(View view, e0 e0Var, EditorInfo editorInfo) {
        c cVar = this.f6054e;
        c.a aVar = cVar.f6070a;
        if (aVar == c.a.NO_TARGET) {
            this.f6059j = null;
            return null;
        }
        if (aVar == c.a.PHYSICAL_DISPLAY_PLATFORM_VIEW) {
            return null;
        }
        if (aVar == c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            if (this.f6064o) {
                return this.f6059j;
            }
            InputConnection onCreateInputConnection = this.f6060k.c(cVar.f6071b).onCreateInputConnection(editorInfo);
            this.f6059j = onCreateInputConnection;
            return onCreateInputConnection;
        }
        p.b bVar = this.f6055f;
        int t5 = t(bVar.f10621g, bVar.f10615a, bVar.f10616b, bVar.f10617c, bVar.f10618d, bVar.f10620f);
        editorInfo.inputType = t5;
        editorInfo.imeOptions = 33554432;
        if (Build.VERSION.SDK_INT >= 26 && !this.f6055f.f10618d) {
            editorInfo.imeOptions = 33554432 | 16777216;
        }
        Integer num = this.f6055f.f10622h;
        int intValue = num == null ? (t5 & 131072) != 0 ? 1 : 6 : num.intValue();
        p.b bVar2 = this.f6055f;
        String str = bVar2.f10623i;
        if (str != null) {
            editorInfo.actionLabel = str;
            editorInfo.actionId = intValue;
        }
        editorInfo.imeOptions = intValue | editorInfo.imeOptions;
        String[] strArr = bVar2.f10625k;
        if (strArr != null) {
            h.b.a(editorInfo, strArr);
        }
        i iVar = new i(view, this.f6054e.f6071b, this.f6053d, e0Var, this.f6057h, editorInfo);
        editorInfo.initialSelStart = this.f6057h.i();
        editorInfo.initialSelEnd = this.f6057h.h();
        this.f6059j = iVar;
        return iVar;
    }

    public void p() {
        this.f6060k.L();
        this.f6053d.n(null);
        y();
        this.f6057h.l(this);
        ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = this.f6062m;
        if (imeSyncDeferringInsetsCallback != null) {
            imeSyncDeferringInsetsCallback.remove();
        }
    }

    public InputMethodManager q() {
        return this.f6051b;
    }

    public boolean r(KeyEvent keyEvent) {
        InputConnection inputConnection;
        if (!q().isAcceptingText() || (inputConnection = this.f6059j) == null) {
            return false;
        }
        return inputConnection instanceof i ? ((i) inputConnection).f(keyEvent) : inputConnection.sendKeyEvent(keyEvent);
    }

    public void u() {
        if (this.f6054e.f6070a == c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            this.f6064o = true;
        }
    }

    public void z(ViewStructure viewStructure, int i6) {
        AutofillId autofillId;
        ViewStructure newChild;
        AutofillValue forText;
        Rect rect;
        AutofillValue forText2;
        if (Build.VERSION.SDK_INT < 26 || !v()) {
            return;
        }
        String str = this.f6055f.f10624j.f10627a;
        autofillId = viewStructure.getAutofillId();
        for (int i7 = 0; i7 < this.f6056g.size(); i7++) {
            int keyAt = this.f6056g.keyAt(i7);
            p.b.a aVar = this.f6056g.valueAt(i7).f10624j;
            if (aVar != null) {
                viewStructure.addChildCount(1);
                newChild = viewStructure.newChild(i7);
                newChild.setAutofillId(autofillId, keyAt);
                String[] strArr = aVar.f10628b;
                if (strArr.length > 0) {
                    newChild.setAutofillHints(strArr);
                }
                newChild.setAutofillType(1);
                newChild.setVisibility(0);
                String str2 = aVar.f10630d;
                if (str2 != null) {
                    newChild.setHint(str2);
                }
                if (str.hashCode() != keyAt || (rect = this.f6061l) == null) {
                    newChild.setDimens(0, 0, 0, 0, 1, 1);
                    forText = AutofillValue.forText(aVar.f10629c.f10640a);
                    newChild.setAutofillValue(forText);
                } else {
                    newChild.setDimens(rect.left, rect.top, 0, 0, rect.width(), this.f6061l.height());
                    forText2 = AutofillValue.forText(this.f6057h);
                    newChild.setAutofillValue(forText2);
                }
            }
        }
    }
}

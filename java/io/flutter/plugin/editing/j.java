package io.flutter.plugin.editing;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import java.util.ArrayList;
import java.util.Iterator;
import x3.p;

/* loaded from: classes.dex */
class j extends SpannableStringBuilder {

    /* renamed from: a, reason: collision with root package name */
    private int f6091a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f6092b = 0;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<b> f6093c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<b> f6094d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<l> f6095e = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    private String f6096j;

    /* renamed from: k, reason: collision with root package name */
    private String f6097k;

    /* renamed from: l, reason: collision with root package name */
    private int f6098l;

    /* renamed from: m, reason: collision with root package name */
    private int f6099m;

    /* renamed from: n, reason: collision with root package name */
    private int f6100n;

    /* renamed from: o, reason: collision with root package name */
    private int f6101o;

    /* renamed from: p, reason: collision with root package name */
    private BaseInputConnection f6102p;

    class a extends BaseInputConnection {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Editable f6103a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, boolean z5, Editable editable) {
            super(view, z5);
            this.f6103a = editable;
        }

        @Override // android.view.inputmethod.BaseInputConnection
        public Editable getEditable() {
            return this.f6103a;
        }
    }

    interface b {
        void a(boolean z5, boolean z6, boolean z7);
    }

    public j(p.e eVar, View view) {
        this.f6102p = new a(view, true, this);
        if (eVar != null) {
            n(eVar);
        }
    }

    private void j(b bVar, boolean z5, boolean z6, boolean z7) {
        this.f6092b++;
        bVar.a(z5, z6, z7);
        this.f6092b--;
    }

    private void k(boolean z5, boolean z6, boolean z7) {
        if (z5 || z6 || z7) {
            Iterator<b> it = this.f6093c.iterator();
            while (it.hasNext()) {
                j(it.next(), z5, z6, z7);
            }
        }
    }

    public void a(b bVar) {
        ArrayList<b> arrayList;
        if (this.f6092b > 0) {
            k3.b.b("ListenableEditingState", "adding a listener " + bVar.toString() + " in a listener callback");
        }
        if (this.f6091a > 0) {
            k3.b.g("ListenableEditingState", "a listener was added to EditingState while a batch edit was in progress");
            arrayList = this.f6094d;
        } else {
            arrayList = this.f6093c;
        }
        arrayList.add(bVar);
    }

    public void b() {
        this.f6091a++;
        if (this.f6092b > 0) {
            k3.b.b("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        if (this.f6091a != 1 || this.f6093c.isEmpty()) {
            return;
        }
        this.f6097k = toString();
        this.f6098l = i();
        this.f6099m = h();
        this.f6100n = g();
        this.f6101o = f();
    }

    public void c() {
        this.f6095e.clear();
    }

    public void d() {
        int i6 = this.f6091a;
        if (i6 == 0) {
            k3.b.b("ListenableEditingState", "endBatchEdit called without a matching beginBatchEdit");
            return;
        }
        if (i6 == 1) {
            Iterator<b> it = this.f6094d.iterator();
            while (it.hasNext()) {
                j(it.next(), true, true, true);
            }
            if (!this.f6093c.isEmpty()) {
                k3.b.f("ListenableEditingState", "didFinishBatchEdit with " + String.valueOf(this.f6093c.size()) + " listener(s)");
                k(!toString().equals(this.f6097k), (this.f6098l == i() && this.f6099m == h()) ? false : true, (this.f6100n == g() && this.f6101o == f()) ? false : true);
            }
        }
        this.f6093c.addAll(this.f6094d);
        this.f6094d.clear();
        this.f6091a--;
    }

    public ArrayList<l> e() {
        ArrayList<l> arrayList = new ArrayList<>(this.f6095e);
        this.f6095e.clear();
        return arrayList;
    }

    public final int f() {
        return BaseInputConnection.getComposingSpanEnd(this);
    }

    public final int g() {
        return BaseInputConnection.getComposingSpanStart(this);
    }

    public final int h() {
        return Selection.getSelectionEnd(this);
    }

    public final int i() {
        return Selection.getSelectionStart(this);
    }

    public void l(b bVar) {
        if (this.f6092b > 0) {
            k3.b.b("ListenableEditingState", "removing a listener " + bVar.toString() + " in a listener callback");
        }
        this.f6093c.remove(bVar);
        if (this.f6091a > 0) {
            this.f6094d.remove(bVar);
        }
    }

    public void m(int i6, int i7) {
        if (i6 < 0 || i6 >= i7) {
            BaseInputConnection.removeComposingSpans(this);
        } else {
            this.f6102p.setComposingRegion(i6, i7);
        }
    }

    public void n(p.e eVar) {
        b();
        replace(0, length(), (CharSequence) eVar.f10640a);
        if (eVar.c()) {
            Selection.setSelection(this, eVar.f10641b, eVar.f10642c);
        } else {
            Selection.removeSelection(this);
        }
        m(eVar.f10643d, eVar.f10644e);
        c();
        d();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i6, int i7, CharSequence charSequence, int i8, int i9) {
        boolean z5;
        boolean z6;
        if (this.f6092b > 0) {
            k3.b.b("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        String jVar = toString();
        int i10 = i7 - i6;
        boolean z7 = i10 != i9 - i8;
        for (int i11 = 0; i11 < i10 && !z7; i11++) {
            z7 |= charAt(i6 + i11) != charSequence.charAt(i8 + i11);
        }
        if (z7) {
            this.f6096j = null;
        }
        int i12 = i();
        int h6 = h();
        int g6 = g();
        int f6 = f();
        SpannableStringBuilder replace = super.replace(i6, i7, charSequence, i8, i9);
        boolean z8 = z7;
        this.f6095e.add(new l(jVar, i6, i7, charSequence, i(), h(), g(), f()));
        if (this.f6091a > 0) {
            return replace;
        }
        boolean z9 = (i() == i12 && h() == h6) ? false : true;
        if (g() == g6 && f() == f6) {
            z5 = z8;
            z6 = false;
        } else {
            z5 = z8;
            z6 = true;
        }
        k(z5, z9, z6);
        return replace;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object obj, int i6, int i7, int i8) {
        super.setSpan(obj, i6, i7, i8);
        this.f6095e.add(new l(toString(), i(), h(), g(), f()));
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public String toString() {
        String str = this.f6096j;
        if (str != null) {
            return str;
        }
        String spannableStringBuilder = super.toString();
        this.f6096j = spannableStringBuilder;
        return spannableStringBuilder;
    }
}

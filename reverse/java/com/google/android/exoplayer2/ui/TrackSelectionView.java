package com.google.android.exoplayer2.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import e2.x;
import f2.k;
import h0.r4;
import h0.y1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import l1.u0;
import m2.q;

/* loaded from: classes.dex */
public class TrackSelectionView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private final int f2097a;

    /* renamed from: b, reason: collision with root package name */
    private final LayoutInflater f2098b;

    /* renamed from: c, reason: collision with root package name */
    private final CheckedTextView f2099c;

    /* renamed from: d, reason: collision with root package name */
    private final CheckedTextView f2100d;

    /* renamed from: e, reason: collision with root package name */
    private final b f2101e;

    /* renamed from: f, reason: collision with root package name */
    private final List<r4.a> f2102f;

    /* renamed from: g, reason: collision with root package name */
    private final Map<u0, x> f2103g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2104h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2105i;

    /* renamed from: j, reason: collision with root package name */
    private k f2106j;

    /* renamed from: k, reason: collision with root package name */
    private CheckedTextView[][] f2107k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f2108l;

    /* renamed from: m, reason: collision with root package name */
    private Comparator<c> f2109m;

    private class b implements View.OnClickListener {
        private b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TrackSelectionView.this.c(view);
        }
    }

    private static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final r4.a f2111a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2112b;

        public c(r4.a aVar, int i6) {
            this.f2111a = aVar;
            this.f2112b = i6;
        }

        public y1 a() {
            return this.f2111a.c(this.f2112b);
        }
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        setOrientation(1);
        setSaveFromParentEnabled(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.selectableItemBackground});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        this.f2097a = resourceId;
        obtainStyledAttributes.recycle();
        LayoutInflater from = LayoutInflater.from(context);
        this.f2098b = from;
        b bVar = new b();
        this.f2101e = bVar;
        this.f2106j = new f2.c(getResources());
        this.f2102f = new ArrayList();
        this.f2103g = new HashMap();
        CheckedTextView checkedTextView = (CheckedTextView) from.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f2099c = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(f2.i.f3868q);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(bVar);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(from.inflate(f2.h.f3851a, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) from.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f2100d = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(f2.i.f3867p);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(bVar);
        addView(checkedTextView2);
    }

    public static Map<u0, x> b(Map<u0, x> map, List<r4.a> list, boolean z5) {
        HashMap hashMap = new HashMap();
        for (int i6 = 0; i6 < list.size(); i6++) {
            x xVar = map.get(list.get(i6).b());
            if (xVar != null && (z5 || hashMap.isEmpty())) {
                hashMap.put(xVar.f3539a, xVar);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view) {
        if (view == this.f2099c) {
            e();
        } else if (view == this.f2100d) {
            d();
        } else {
            f(view);
        }
        i();
    }

    private void d() {
        this.f2108l = false;
        this.f2103g.clear();
    }

    private void e() {
        this.f2108l = true;
        this.f2103g.clear();
    }

    private void f(View view) {
        Map<u0, x> map;
        x xVar;
        this.f2108l = false;
        c cVar = (c) i2.a.e(view.getTag());
        u0 b6 = cVar.f2111a.b();
        int i6 = cVar.f2112b;
        x xVar2 = this.f2103g.get(b6);
        if (xVar2 == null) {
            if (!this.f2105i && this.f2103g.size() > 0) {
                this.f2103g.clear();
            }
            map = this.f2103g;
            xVar = new x(b6, q.r(Integer.valueOf(i6)));
        } else {
            ArrayList arrayList = new ArrayList(xVar2.f3540b);
            boolean isChecked = ((CheckedTextView) view).isChecked();
            boolean g6 = g(cVar.f2111a);
            boolean z5 = g6 || h();
            if (isChecked && z5) {
                arrayList.remove(Integer.valueOf(i6));
                if (arrayList.isEmpty()) {
                    this.f2103g.remove(b6);
                    return;
                } else {
                    map = this.f2103g;
                    xVar = new x(b6, arrayList);
                }
            } else {
                if (isChecked) {
                    return;
                }
                if (g6) {
                    arrayList.add(Integer.valueOf(i6));
                    map = this.f2103g;
                    xVar = new x(b6, arrayList);
                } else {
                    map = this.f2103g;
                    xVar = new x(b6, q.r(Integer.valueOf(i6)));
                }
            }
        }
        map.put(b6, xVar);
    }

    private boolean g(r4.a aVar) {
        return this.f2104h && aVar.e();
    }

    private boolean h() {
        return this.f2105i && this.f2102f.size() > 1;
    }

    private void i() {
        this.f2099c.setChecked(this.f2108l);
        this.f2100d.setChecked(!this.f2108l && this.f2103g.size() == 0);
        for (int i6 = 0; i6 < this.f2107k.length; i6++) {
            x xVar = this.f2103g.get(this.f2102f.get(i6).b());
            int i7 = 0;
            while (true) {
                CheckedTextView[] checkedTextViewArr = this.f2107k[i6];
                if (i7 < checkedTextViewArr.length) {
                    if (xVar != null) {
                        this.f2107k[i6][i7].setChecked(xVar.f3540b.contains(Integer.valueOf(((c) i2.a.e(checkedTextViewArr[i7].getTag())).f2112b)));
                    } else {
                        checkedTextViewArr[i7].setChecked(false);
                    }
                    i7++;
                }
            }
        }
    }

    private void j() {
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        if (this.f2102f.isEmpty()) {
            this.f2099c.setEnabled(false);
            this.f2100d.setEnabled(false);
            return;
        }
        this.f2099c.setEnabled(true);
        this.f2100d.setEnabled(true);
        this.f2107k = new CheckedTextView[this.f2102f.size()][];
        boolean h6 = h();
        for (int i6 = 0; i6 < this.f2102f.size(); i6++) {
            r4.a aVar = this.f2102f.get(i6);
            boolean g6 = g(aVar);
            CheckedTextView[][] checkedTextViewArr = this.f2107k;
            int i7 = aVar.f4853a;
            checkedTextViewArr[i6] = new CheckedTextView[i7];
            c[] cVarArr = new c[i7];
            for (int i8 = 0; i8 < aVar.f4853a; i8++) {
                cVarArr[i8] = new c(aVar, i8);
            }
            Comparator<c> comparator = this.f2109m;
            if (comparator != null) {
                Arrays.sort(cVarArr, comparator);
            }
            for (int i9 = 0; i9 < i7; i9++) {
                if (i9 == 0) {
                    addView(this.f2098b.inflate(f2.h.f3851a, (ViewGroup) this, false));
                }
                CheckedTextView checkedTextView = (CheckedTextView) this.f2098b.inflate((g6 || h6) ? R.layout.simple_list_item_multiple_choice : R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
                checkedTextView.setBackgroundResource(this.f2097a);
                checkedTextView.setText(this.f2106j.a(cVarArr[i9].a()));
                checkedTextView.setTag(cVarArr[i9]);
                if (aVar.h(i9)) {
                    checkedTextView.setFocusable(true);
                    checkedTextView.setOnClickListener(this.f2101e);
                } else {
                    checkedTextView.setFocusable(false);
                    checkedTextView.setEnabled(false);
                }
                this.f2107k[i6][i9] = checkedTextView;
                addView(checkedTextView);
            }
        }
        i();
    }

    public boolean getIsDisabled() {
        return this.f2108l;
    }

    public Map<u0, x> getOverrides() {
        return this.f2103g;
    }

    public void setAllowAdaptiveSelections(boolean z5) {
        if (this.f2104h != z5) {
            this.f2104h = z5;
            j();
        }
    }

    public void setAllowMultipleOverrides(boolean z5) {
        if (this.f2105i != z5) {
            this.f2105i = z5;
            if (!z5 && this.f2103g.size() > 1) {
                Map<u0, x> b6 = b(this.f2103g, this.f2102f, false);
                this.f2103g.clear();
                this.f2103g.putAll(b6);
            }
            j();
        }
    }

    public void setShowDisableOption(boolean z5) {
        this.f2099c.setVisibility(z5 ? 0 : 8);
    }

    public void setTrackNameProvider(k kVar) {
        this.f2106j = (k) i2.a.e(kVar);
        j();
    }
}

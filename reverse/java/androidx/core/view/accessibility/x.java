package androidx.core.view.accessibility;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class x {

    /* renamed from: d, reason: collision with root package name */
    private static int f455d;

    /* renamed from: a, reason: collision with root package name */
    private final AccessibilityNodeInfo f456a;

    /* renamed from: b, reason: collision with root package name */
    public int f457b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f458c = -1;

    public static class a {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K;
        public static final a L;
        public static final a M;
        public static final a N;
        public static final a O;
        public static final a P;
        public static final a Q;
        public static final a R;
        public static final a S;
        public static final a T;

        /* renamed from: d, reason: collision with root package name */
        public static final a f459d = new a(1, null);

        /* renamed from: e, reason: collision with root package name */
        public static final a f460e = new a(2, null);

        /* renamed from: f, reason: collision with root package name */
        public static final a f461f = new a(4, null);

        /* renamed from: g, reason: collision with root package name */
        public static final a f462g = new a(8, null);

        /* renamed from: h, reason: collision with root package name */
        public static final a f463h = new a(16, null);

        /* renamed from: i, reason: collision with root package name */
        public static final a f464i = new a(32, null);

        /* renamed from: j, reason: collision with root package name */
        public static final a f465j = new a(64, null);

        /* renamed from: k, reason: collision with root package name */
        public static final a f466k = new a(128, null);

        /* renamed from: l, reason: collision with root package name */
        public static final a f467l = new a(256, null, z.b.class);

        /* renamed from: m, reason: collision with root package name */
        public static final a f468m = new a(512, null, z.b.class);

        /* renamed from: n, reason: collision with root package name */
        public static final a f469n = new a(1024, null, z.c.class);

        /* renamed from: o, reason: collision with root package name */
        public static final a f470o = new a(2048, null, z.c.class);

        /* renamed from: p, reason: collision with root package name */
        public static final a f471p = new a(4096, null);

        /* renamed from: q, reason: collision with root package name */
        public static final a f472q = new a(8192, null);

        /* renamed from: r, reason: collision with root package name */
        public static final a f473r = new a(16384, null);

        /* renamed from: s, reason: collision with root package name */
        public static final a f474s = new a(32768, null);

        /* renamed from: t, reason: collision with root package name */
        public static final a f475t = new a(65536, null);

        /* renamed from: u, reason: collision with root package name */
        public static final a f476u = new a(131072, null, z.g.class);

        /* renamed from: v, reason: collision with root package name */
        public static final a f477v = new a(262144, null);

        /* renamed from: w, reason: collision with root package name */
        public static final a f478w = new a(524288, null);

        /* renamed from: x, reason: collision with root package name */
        public static final a f479x = new a(1048576, null);

        /* renamed from: y, reason: collision with root package name */
        public static final a f480y = new a(2097152, null, z.h.class);

        /* renamed from: z, reason: collision with root package name */
        public static final a f481z;

        /* renamed from: a, reason: collision with root package name */
        final Object f482a;

        /* renamed from: b, reason: collision with root package name */
        private final int f483b;

        /* renamed from: c, reason: collision with root package name */
        private final Class<? extends z.a> f484c;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction9;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction10;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction11;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction12;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction13;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction14;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction15;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction16;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction17;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction18;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction19;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction20;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction21;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction22;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction23;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction24;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction25;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction26;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction27;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction28;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction29;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction30;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction31;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction32;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction33;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction34;
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 23) {
                accessibilityAction34 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
                accessibilityAction = accessibilityAction34;
            } else {
                accessibilityAction = null;
            }
            f481z = new a(accessibilityAction, R.id.accessibilityActionShowOnScreen, null, null, null);
            if (i6 >= 23) {
                accessibilityAction33 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
                accessibilityAction2 = accessibilityAction33;
            } else {
                accessibilityAction2 = null;
            }
            A = new a(accessibilityAction2, R.id.accessibilityActionScrollToPosition, null, null, z.e.class);
            if (i6 >= 23) {
                accessibilityAction32 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
                accessibilityAction3 = accessibilityAction32;
            } else {
                accessibilityAction3 = null;
            }
            B = new a(accessibilityAction3, R.id.accessibilityActionScrollUp, null, null, null);
            if (i6 >= 23) {
                accessibilityAction31 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
                accessibilityAction4 = accessibilityAction31;
            } else {
                accessibilityAction4 = null;
            }
            C = new a(accessibilityAction4, R.id.accessibilityActionScrollLeft, null, null, null);
            if (i6 >= 23) {
                accessibilityAction30 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
                accessibilityAction5 = accessibilityAction30;
            } else {
                accessibilityAction5 = null;
            }
            D = new a(accessibilityAction5, R.id.accessibilityActionScrollDown, null, null, null);
            if (i6 >= 23) {
                accessibilityAction29 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
                accessibilityAction6 = accessibilityAction29;
            } else {
                accessibilityAction6 = null;
            }
            E = new a(accessibilityAction6, R.id.accessibilityActionScrollRight, null, null, null);
            if (i6 >= 29) {
                accessibilityAction28 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
                accessibilityAction7 = accessibilityAction28;
            } else {
                accessibilityAction7 = null;
            }
            F = new a(accessibilityAction7, R.id.accessibilityActionPageUp, null, null, null);
            if (i6 >= 29) {
                accessibilityAction27 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
                accessibilityAction8 = accessibilityAction27;
            } else {
                accessibilityAction8 = null;
            }
            G = new a(accessibilityAction8, R.id.accessibilityActionPageDown, null, null, null);
            if (i6 >= 29) {
                accessibilityAction26 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
                accessibilityAction9 = accessibilityAction26;
            } else {
                accessibilityAction9 = null;
            }
            H = new a(accessibilityAction9, R.id.accessibilityActionPageLeft, null, null, null);
            if (i6 >= 29) {
                accessibilityAction25 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
                accessibilityAction10 = accessibilityAction25;
            } else {
                accessibilityAction10 = null;
            }
            I = new a(accessibilityAction10, R.id.accessibilityActionPageRight, null, null, null);
            if (i6 >= 23) {
                accessibilityAction24 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
                accessibilityAction11 = accessibilityAction24;
            } else {
                accessibilityAction11 = null;
            }
            J = new a(accessibilityAction11, R.id.accessibilityActionContextClick, null, null, null);
            if (i6 >= 24) {
                accessibilityAction23 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
                accessibilityAction12 = accessibilityAction23;
            } else {
                accessibilityAction12 = null;
            }
            K = new a(accessibilityAction12, R.id.accessibilityActionSetProgress, null, null, z.f.class);
            if (i6 >= 26) {
                accessibilityAction22 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
                accessibilityAction13 = accessibilityAction22;
            } else {
                accessibilityAction13 = null;
            }
            L = new a(accessibilityAction13, R.id.accessibilityActionMoveWindow, null, null, z.d.class);
            if (i6 >= 28) {
                accessibilityAction21 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
                accessibilityAction14 = accessibilityAction21;
            } else {
                accessibilityAction14 = null;
            }
            M = new a(accessibilityAction14, R.id.accessibilityActionShowTooltip, null, null, null);
            if (i6 >= 28) {
                accessibilityAction20 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
                accessibilityAction15 = accessibilityAction20;
            } else {
                accessibilityAction15 = null;
            }
            N = new a(accessibilityAction15, R.id.accessibilityActionHideTooltip, null, null, null);
            if (i6 >= 30) {
                accessibilityAction19 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
                accessibilityAction16 = accessibilityAction19;
            } else {
                accessibilityAction16 = null;
            }
            O = new a(accessibilityAction16, R.id.accessibilityActionPressAndHold, null, null, null);
            if (i6 >= 30) {
                accessibilityAction18 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
                accessibilityAction17 = accessibilityAction18;
            } else {
                accessibilityAction17 = null;
            }
            P = new a(accessibilityAction17, R.id.accessibilityActionImeEnter, null, null, null);
            Q = new a(i6 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
            R = new a(i6 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
            S = new a(i6 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
            T = new a(i6 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
        }

        public a(int i6, CharSequence charSequence) {
            this(null, i6, charSequence, null, null);
        }

        private a(int i6, CharSequence charSequence, Class<? extends z.a> cls) {
            this(null, i6, charSequence, null, cls);
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        a(Object obj, int i6, CharSequence charSequence, z zVar, Class<? extends z.a> cls) {
            this.f483b = i6;
            this.f482a = obj == null ? new AccessibilityNodeInfo.AccessibilityAction(i6, charSequence) : obj;
            this.f484c = cls;
        }

        public int a() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f482a).getId();
        }

        public CharSequence b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f482a).getLabel();
        }

        public boolean c(View view, Bundle bundle) {
            return false;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            Object obj2 = this.f482a;
            Object obj3 = ((a) obj).f482a;
            return obj2 == null ? obj3 == null : obj2.equals(obj3);
        }

        public int hashCode() {
            Object obj = this.f482a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final Object f485a;

        b(Object obj) {
            this.f485a = obj;
        }

        public static b a(int i6, int i7, boolean z5, int i8) {
            return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i6, i7, z5, i8));
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        final Object f486a;

        c(Object obj) {
            this.f486a = obj;
        }

        public static c a(int i6, int i7, int i8, int i9, boolean z5, boolean z6) {
            return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i6, i7, i8, i9, z5, z6));
        }
    }

    private x(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f456a = accessibilityNodeInfo;
    }

    private void H(View view) {
        SparseArray<WeakReference<ClickableSpan>> q6 = q(view);
        if (q6 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i6 = 0; i6 < q6.size(); i6++) {
                if (q6.valueAt(i6).get() == null) {
                    arrayList.add(Integer.valueOf(i6));
                }
            }
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                q6.remove(((Integer) arrayList.get(i7)).intValue());
            }
        }
    }

    private void I(int i6, boolean z5) {
        Bundle n6 = n();
        if (n6 != null) {
            int i7 = n6.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i6);
            if (!z5) {
                i6 = 0;
            }
            n6.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i6 | i7);
        }
    }

    public static x R(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new x(accessibilityNodeInfo);
    }

    private void c(ClickableSpan clickableSpan, Spanned spanned, int i6) {
        f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i6));
    }

    private void e() {
        this.f456a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        this.f456a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        this.f456a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        this.f456a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    private List<Integer> f(String str) {
        ArrayList<Integer> integerArrayList = this.f456a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f456a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    private static String h(int i6) {
        if (i6 == 1) {
            return "ACTION_FOCUS";
        }
        if (i6 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i6) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (i6) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i6) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i6) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    public static ClickableSpan[] l(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray<WeakReference<ClickableSpan>> o(View view) {
        SparseArray<WeakReference<ClickableSpan>> q6 = q(view);
        if (q6 != null) {
            return q6;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(g.b.I, sparseArray);
        return sparseArray;
    }

    private SparseArray<WeakReference<ClickableSpan>> q(View view) {
        return (SparseArray) view.getTag(g.b.I);
    }

    private boolean u() {
        return !f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private int v(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i6 = 0; i6 < sparseArray.size(); i6++) {
                if (clickableSpan.equals(sparseArray.valueAt(i6).get())) {
                    return sparseArray.keyAt(i6);
                }
            }
        }
        int i7 = f455d;
        f455d = i7 + 1;
        return i7;
    }

    public boolean A() {
        return this.f456a.isFocusable();
    }

    public boolean B() {
        return this.f456a.isFocused();
    }

    public boolean C() {
        return this.f456a.isLongClickable();
    }

    public boolean D() {
        return this.f456a.isPassword();
    }

    public boolean E() {
        return this.f456a.isScrollable();
    }

    public boolean F() {
        return this.f456a.isSelected();
    }

    public boolean G(int i6, Bundle bundle) {
        return this.f456a.performAction(i6, bundle);
    }

    public void J(Object obj) {
        this.f456a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f485a);
    }

    public void K(Object obj) {
        this.f456a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((c) obj).f486a);
    }

    public void L(boolean z5) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f456a.setHeading(z5);
        } else {
            I(2, z5);
        }
    }

    public void M(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f456a.setPaneTitle(charSequence);
        } else {
            this.f456a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void N(boolean z5) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f456a.setScreenReaderFocusable(z5);
        } else {
            I(1, z5);
        }
    }

    public void O(boolean z5) {
        this.f456a.setScrollable(z5);
    }

    public void P(CharSequence charSequence) {
        if (androidx.core.os.a.b()) {
            this.f456a.setStateDescription(charSequence);
        } else {
            this.f456a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public AccessibilityNodeInfo Q() {
        return this.f456a;
    }

    public void a(int i6) {
        this.f456a.addAction(i6);
    }

    public void b(a aVar) {
        this.f456a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f482a);
    }

    public void d(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            e();
            H(view);
            ClickableSpan[] l6 = l(charSequence);
            if (l6 == null || l6.length <= 0) {
                return;
            }
            n().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", g.b.f3910a);
            SparseArray<WeakReference<ClickableSpan>> o6 = o(view);
            for (int i6 = 0; i6 < l6.length; i6++) {
                int v5 = v(l6[i6], o6);
                o6.put(v5, new WeakReference<>(l6[i6]));
                c(l6[i6], (Spanned) charSequence, v5);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f456a;
        if (accessibilityNodeInfo == null) {
            if (xVar.f456a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(xVar.f456a)) {
            return false;
        }
        return this.f458c == xVar.f458c && this.f457b == xVar.f457b;
    }

    public List<a> g() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f456a.getActionList();
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i6 = 0; i6 < size; i6++) {
            arrayList.add(new a(actionList.get(i6)));
        }
        return arrayList;
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f456a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    @Deprecated
    public void i(Rect rect) {
        this.f456a.getBoundsInParent(rect);
    }

    public void j(Rect rect) {
        this.f456a.getBoundsInScreen(rect);
    }

    public CharSequence k() {
        return this.f456a.getClassName();
    }

    public CharSequence m() {
        return this.f456a.getContentDescription();
    }

    public Bundle n() {
        return this.f456a.getExtras();
    }

    public CharSequence p() {
        return this.f456a.getPackageName();
    }

    public CharSequence r() {
        if (!u()) {
            return this.f456a.getText();
        }
        List<Integer> f6 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> f7 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> f8 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> f9 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f456a.getText(), 0, this.f456a.getText().length()));
        for (int i6 = 0; i6 < f6.size(); i6++) {
            spannableString.setSpan(new androidx.core.view.accessibility.a(f9.get(i6).intValue(), this, n().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), f6.get(i6).intValue(), f7.get(i6).intValue(), f8.get(i6).intValue());
        }
        return spannableString;
    }

    public String s() {
        return androidx.core.os.a.d() ? this.f456a.getUniqueId() : this.f456a.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public String t() {
        return this.f456a.getViewIdResourceName();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        i(rect);
        sb.append("; boundsInParent: " + rect);
        j(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(p());
        sb.append("; className: ");
        sb.append(k());
        sb.append("; text: ");
        sb.append(r());
        sb.append("; contentDescription: ");
        sb.append(m());
        sb.append("; viewId: ");
        sb.append(t());
        sb.append("; uniqueId: ");
        sb.append(s());
        sb.append("; checkable: ");
        sb.append(w());
        sb.append("; checked: ");
        sb.append(x());
        sb.append("; focusable: ");
        sb.append(A());
        sb.append("; focused: ");
        sb.append(B());
        sb.append("; selected: ");
        sb.append(F());
        sb.append("; clickable: ");
        sb.append(y());
        sb.append("; longClickable: ");
        sb.append(C());
        sb.append("; enabled: ");
        sb.append(z());
        sb.append("; password: ");
        sb.append(D());
        sb.append("; scrollable: " + E());
        sb.append("; [");
        List<a> g6 = g();
        for (int i6 = 0; i6 < g6.size(); i6++) {
            a aVar = g6.get(i6);
            String h6 = h(aVar.a());
            if (h6.equals("ACTION_UNKNOWN") && aVar.b() != null) {
                h6 = aVar.b().toString();
            }
            sb.append(h6);
            if (i6 != g6.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean w() {
        return this.f456a.isCheckable();
    }

    public boolean x() {
        return this.f456a.isChecked();
    }

    public boolean y() {
        return this.f456a.isClickable();
    }

    public boolean z() {
        return this.f456a.isEnabled();
    }
}

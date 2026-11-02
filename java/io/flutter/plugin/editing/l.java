package io.flutter.plugin.editing;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private CharSequence f6109a;

    /* renamed from: b, reason: collision with root package name */
    private CharSequence f6110b;

    /* renamed from: c, reason: collision with root package name */
    private int f6111c;

    /* renamed from: d, reason: collision with root package name */
    private int f6112d;

    /* renamed from: e, reason: collision with root package name */
    private int f6113e;

    /* renamed from: f, reason: collision with root package name */
    private int f6114f;

    /* renamed from: g, reason: collision with root package name */
    private int f6115g;

    /* renamed from: h, reason: collision with root package name */
    private int f6116h;

    public l(CharSequence charSequence, int i6, int i7, int i8, int i9) {
        this.f6113e = i6;
        this.f6114f = i7;
        this.f6115g = i8;
        this.f6116h = i9;
        a(charSequence, "", -1, -1);
    }

    public l(CharSequence charSequence, int i6, int i7, CharSequence charSequence2, int i8, int i9, int i10, int i11) {
        this.f6113e = i8;
        this.f6114f = i9;
        this.f6115g = i10;
        this.f6116h = i11;
        a(charSequence, charSequence2.toString(), i6, i7);
    }

    private void a(CharSequence charSequence, CharSequence charSequence2, int i6, int i7) {
        this.f6109a = charSequence;
        this.f6110b = charSequence2;
        this.f6111c = i6;
        this.f6112d = i7;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oldText", this.f6109a.toString());
            jSONObject.put("deltaText", this.f6110b.toString());
            jSONObject.put("deltaStart", this.f6111c);
            jSONObject.put("deltaEnd", this.f6112d);
            jSONObject.put("selectionBase", this.f6113e);
            jSONObject.put("selectionExtent", this.f6114f);
            jSONObject.put("composingBase", this.f6115g);
            jSONObject.put("composingExtent", this.f6116h);
        } catch (JSONException e6) {
            k3.b.b("TextEditingDelta", "unable to create JSONObject: " + e6);
        }
        return jSONObject;
    }
}

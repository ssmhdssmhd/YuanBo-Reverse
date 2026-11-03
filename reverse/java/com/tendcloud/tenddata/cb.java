package com.tendcloud.tenddata;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class cb {

    /* renamed from: a, reason: collision with root package name */
    private int f2503a;

    /* renamed from: b, reason: collision with root package name */
    private PointF f2504b;

    /* renamed from: c, reason: collision with root package name */
    private PointF f2505c;

    /* renamed from: d, reason: collision with root package name */
    private float f2506d;

    /* renamed from: e, reason: collision with root package name */
    private float f2507e;

    /* renamed from: f, reason: collision with root package name */
    private int f2508f;

    /* renamed from: g, reason: collision with root package name */
    private long f2509g;

    public cb(int i6, MotionEvent motionEvent, long j6, int i7, View view, boolean z5) {
        try {
            this.f2503a = i6;
            this.f2504b = !z5 ? new PointF(motionEvent.getX(i7), motionEvent.getY(i7)) : new PointF(0.0f, 0.0f);
            view.getLocationOnScreen(new int[2]);
            this.f2505c = new PointF(motionEvent.getX() - r3[0], motionEvent.getY() - r3[1]);
            this.f2506d = motionEvent.getPressure(i7);
            this.f2507e = motionEvent.getTouchMajor(i7);
            this.f2508f = a(motionEvent.getActionMasked());
            this.f2509g = j6;
        } catch (Throwable unused) {
        }
    }

    private int a(int i6) {
        if (i6 == 0) {
            return 0;
        }
        if (i6 == 1) {
            return 3;
        }
        if (i6 == 2) {
            return 1;
        }
        if (i6 == 3) {
            return 4;
        }
        if (i6 == 5) {
            return 0;
        }
        if (i6 != 6) {
            return i6;
        }
        return 3;
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.f2503a);
            jSONObject.put("t", this.f2509g);
            jSONObject.put("r", this.f2507e);
            jSONObject.put("x", this.f2504b.x);
            jSONObject.put("y", this.f2504b.y);
            jSONObject.put("rx", this.f2505c.x);
            jSONObject.put("ry", this.f2505c.y);
            jSONObject.put("f", this.f2506d);
            jSONObject.put("p", this.f2508f);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}

package k2;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import k2.d;

/* loaded from: classes.dex */
final class m extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, d.a {

    /* renamed from: c, reason: collision with root package name */
    private final a f6948c;

    /* renamed from: d, reason: collision with root package name */
    private final float f6949d;

    /* renamed from: e, reason: collision with root package name */
    private final GestureDetector f6950e;

    /* renamed from: a, reason: collision with root package name */
    private final PointF f6946a = new PointF();

    /* renamed from: b, reason: collision with root package name */
    private final PointF f6947b = new PointF();

    /* renamed from: f, reason: collision with root package name */
    private volatile float f6951f = 3.1415927f;

    public interface a {
        void b(PointF pointF);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    public m(Context context, a aVar, float f6) {
        this.f6948c = aVar;
        this.f6949d = f6;
        this.f6950e = new GestureDetector(context, this);
    }

    @Override // k2.d.a
    public void a(float[] fArr, float f6) {
        this.f6951f = -f6;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.f6946a.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
        float x5 = (motionEvent2.getX() - this.f6946a.x) / this.f6949d;
        float y5 = motionEvent2.getY();
        PointF pointF = this.f6946a;
        float f8 = (y5 - pointF.y) / this.f6949d;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d6 = this.f6951f;
        float cos = (float) Math.cos(d6);
        float sin = (float) Math.sin(d6);
        PointF pointF2 = this.f6947b;
        pointF2.x -= (cos * x5) - (sin * f8);
        float f9 = pointF2.y + (sin * x5) + (cos * f8);
        pointF2.y = f9;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f9));
        this.f6948c.b(this.f6947b);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f6948c.onSingleTapUp(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f6950e.onTouchEvent(motionEvent);
    }
}

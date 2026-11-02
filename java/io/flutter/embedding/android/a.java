package io.flutter.embedding.android;

import android.graphics.Matrix;
import android.view.InputDevice;
import android.view.MotionEvent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static final Matrix f5836e = new Matrix();

    /* renamed from: a, reason: collision with root package name */
    private final w3.a f5837a;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f5839c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<Integer, float[]> f5840d = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final g0 f5838b = g0.a();

    public a(w3.a aVar, boolean z5) {
        this.f5837a = aVar;
        this.f5839c = z5;
    }

    private void a(MotionEvent motionEvent, int i6, int i7, int i8, Matrix matrix, ByteBuffer byteBuffer) {
        long j6;
        long j7;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        InputDevice.MotionRange motionRange;
        if (i7 == -1) {
            return;
        }
        long d11 = this.f5839c ? this.f5838b.c(motionEvent).d() : 0L;
        int d12 = d(motionEvent.getToolType(i6));
        float[] fArr = {motionEvent.getX(i6), motionEvent.getY(i6)};
        matrix.mapPoints(fArr);
        if (d12 == 1) {
            j6 = motionEvent.getButtonState() & 31;
            if (j6 == 0 && motionEvent.getSource() == 8194 && i7 == 4) {
                this.f5840d.put(Integer.valueOf(motionEvent.getPointerId(i6)), fArr);
            }
        } else {
            j6 = d12 == 2 ? (motionEvent.getButtonState() >> 4) & 15 : 0L;
        }
        boolean containsKey = this.f5840d.containsKey(Integer.valueOf(motionEvent.getPointerId(i6)));
        int i9 = motionEvent.getActionMasked() == 8 ? 1 : 0;
        long eventTime = motionEvent.getEventTime() * 1000;
        byteBuffer.putLong(d11);
        byteBuffer.putLong(eventTime);
        if (containsKey) {
            byteBuffer.putLong(c(i7));
            j7 = 4;
        } else {
            byteBuffer.putLong(i7);
            j7 = d12;
        }
        byteBuffer.putLong(j7);
        byteBuffer.putLong(i9);
        byteBuffer.putLong(motionEvent.getPointerId(i6));
        byteBuffer.putLong(0L);
        if (containsKey) {
            float[] fArr2 = this.f5840d.get(Integer.valueOf(motionEvent.getPointerId(i6)));
            byteBuffer.putDouble(fArr2[0]);
            byteBuffer.putDouble(fArr2[1]);
        } else {
            byteBuffer.putDouble(fArr[0]);
            byteBuffer.putDouble(fArr[1]);
        }
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putLong(j6);
        byteBuffer.putLong(0L);
        byteBuffer.putLong(0L);
        byteBuffer.putDouble(motionEvent.getPressure(i6));
        if (motionEvent.getDevice() == null || (motionRange = motionEvent.getDevice().getMotionRange(2)) == null) {
            d6 = 1.0d;
            d7 = 0.0d;
        } else {
            d7 = motionRange.getMin();
            d6 = motionRange.getMax();
        }
        byteBuffer.putDouble(d7);
        byteBuffer.putDouble(d6);
        if (d12 == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(24, i6));
            d8 = 0.0d;
        } else {
            d8 = 0.0d;
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putDouble(d8);
        byteBuffer.putDouble(motionEvent.getSize(i6));
        byteBuffer.putDouble(motionEvent.getToolMajor(i6));
        byteBuffer.putDouble(motionEvent.getToolMinor(i6));
        byteBuffer.putDouble(d8);
        byteBuffer.putDouble(d8);
        byteBuffer.putDouble(motionEvent.getAxisValue(8, i6));
        if (d12 == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(25, i6));
        } else {
            byteBuffer.putDouble(d8);
        }
        byteBuffer.putLong(i8);
        if (i9 == 1) {
            byteBuffer.putDouble(-motionEvent.getAxisValue(10));
            d9 = -motionEvent.getAxisValue(9);
        } else {
            d9 = 0.0d;
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putDouble(d9);
        if (containsKey) {
            float[] fArr3 = this.f5840d.get(Integer.valueOf(motionEvent.getPointerId(i6)));
            byteBuffer.putDouble(fArr[0] - fArr3[0]);
            byteBuffer.putDouble(fArr[1] - fArr3[1]);
            d10 = 0.0d;
        } else {
            d10 = 0.0d;
            byteBuffer.putDouble(0.0d);
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putDouble(d10);
        byteBuffer.putDouble(d10);
        byteBuffer.putDouble(1.0d);
        byteBuffer.putDouble(d10);
        if (containsKey && c(i7) == 9) {
            this.f5840d.remove(Integer.valueOf(motionEvent.getPointerId(i6)));
        }
    }

    private int b(int i6) {
        if (i6 == 0) {
            return 4;
        }
        if (i6 == 1) {
            return 6;
        }
        if (i6 == 5) {
            return 4;
        }
        if (i6 == 6) {
            return 6;
        }
        if (i6 == 2) {
            return 5;
        }
        if (i6 == 7) {
            return 3;
        }
        if (i6 == 3) {
            return 0;
        }
        return i6 == 8 ? 3 : -1;
    }

    private int c(int i6) {
        if (i6 == 4) {
            return 7;
        }
        if (i6 == 5) {
            return 8;
        }
        if (i6 == 6 || i6 == 0) {
            return 9;
        }
        throw new AssertionError("Unexpected pointer change");
    }

    private int d(int i6) {
        if (i6 == 1) {
            return 0;
        }
        if (i6 == 2) {
            return 2;
        }
        if (i6 != 3) {
            return i6 != 4 ? 5 : 3;
        }
        return 1;
    }

    public boolean e(MotionEvent motionEvent) {
        boolean z5 = motionEvent.isFromSource(2);
        boolean z6 = motionEvent.getActionMasked() == 7 || motionEvent.getActionMasked() == 8;
        if (!z5 || !z6) {
            return false;
        }
        int b6 = b(motionEvent.getActionMasked());
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 35 * 8);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        a(motionEvent, motionEvent.getActionIndex(), b6, 0, f5836e, allocateDirect);
        if (allocateDirect.position() % 280 != 0) {
            throw new AssertionError("Packet position is not on field boundary.");
        }
        this.f5837a.j(allocateDirect, allocateDirect.position());
        return true;
    }

    public boolean f(MotionEvent motionEvent) {
        return g(motionEvent, f5836e);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean g(android.view.MotionEvent r13, android.graphics.Matrix r14) {
        /*
            r12 = this;
            int r0 = r13.getPointerCount()
            int r1 = r0 * 35
            int r1 = r1 * 8
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocateDirect(r1)
            java.nio.ByteOrder r2 = java.nio.ByteOrder.LITTLE_ENDIAN
            r1.order(r2)
            int r2 = r13.getActionMasked()
            int r3 = r13.getActionMasked()
            int r9 = r12.b(r3)
            r3 = 0
            r10 = 1
            if (r2 == 0) goto L27
            r4 = 5
            if (r2 != r4) goto L25
            goto L27
        L25:
            r4 = 0
            goto L28
        L27:
            r4 = 1
        L28:
            if (r4 != 0) goto L31
            if (r2 == r10) goto L2f
            r5 = 6
            if (r2 != r5) goto L31
        L2f:
            r2 = 1
            goto L32
        L31:
            r2 = 0
        L32:
            if (r4 == 0) goto L42
        L34:
            int r4 = r13.getActionIndex()
            r6 = 0
            r2 = r12
            r3 = r13
            r5 = r9
            r7 = r14
            r8 = r1
            r2.a(r3, r4, r5, r6, r7, r8)
            goto L6f
        L42:
            r11 = 0
            if (r2 == 0) goto L60
        L45:
            if (r11 >= r0) goto L34
            int r2 = r13.getActionIndex()
            if (r11 == r2) goto L5d
            int r2 = r13.getToolType(r11)
            if (r2 != r10) goto L5d
            r5 = 5
            r6 = 1
            r2 = r12
            r3 = r13
            r4 = r11
            r7 = r14
            r8 = r1
            r2.a(r3, r4, r5, r6, r7, r8)
        L5d:
            int r11 = r11 + 1
            goto L45
        L60:
            if (r11 >= r0) goto L6f
            r6 = 0
            r2 = r12
            r3 = r13
            r4 = r11
            r5 = r9
            r7 = r14
            r8 = r1
            r2.a(r3, r4, r5, r6, r7, r8)
            int r11 = r11 + 1
            goto L60
        L6f:
            int r13 = r1.position()
            int r13 = r13 % 280
            if (r13 != 0) goto L81
            w3.a r13 = r12.f5837a
            int r14 = r1.position()
            r13.j(r1, r14)
            return r10
        L81:
            java.lang.AssertionError r13 = new java.lang.AssertionError
            java.lang.String r14 = "Packet position is not on field boundary"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.a.g(android.view.MotionEvent, android.graphics.Matrix):boolean");
    }
}

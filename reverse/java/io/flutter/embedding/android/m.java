package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.view.Surface;
import android.view.View;
import java.nio.ByteBuffer;
import java.util.Locale;

/* loaded from: classes.dex */
public class m extends View implements w3.c {

    /* renamed from: a, reason: collision with root package name */
    private ImageReader f5916a;

    /* renamed from: b, reason: collision with root package name */
    private Image f5917b;

    /* renamed from: c, reason: collision with root package name */
    private Bitmap f5918c;

    /* renamed from: d, reason: collision with root package name */
    private w3.a f5919d;

    /* renamed from: e, reason: collision with root package name */
    private b f5920e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5921f;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5922a;

        static {
            int[] iArr = new int[b.values().length];
            f5922a = iArr;
            try {
                iArr[b.background.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5922a[b.overlay.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum b {
        background,
        overlay
    }

    public m(Context context, int i6, int i7, b bVar) {
        this(context, g(i6, i7), bVar);
    }

    m(Context context, ImageReader imageReader, b bVar) {
        super(context, null);
        this.f5921f = false;
        this.f5916a = imageReader;
        this.f5920e = bVar;
        h();
    }

    private void e() {
        Image image = this.f5917b;
        if (image != null) {
            image.close();
            this.f5917b = null;
        }
    }

    private static ImageReader g(int i6, int i7) {
        int i8;
        int i9;
        ImageReader newInstance;
        if (i6 <= 0) {
            i("ImageReader width must be greater than 0, but given width=%d, set width=1", Integer.valueOf(i6));
            i8 = 1;
        } else {
            i8 = i6;
        }
        if (i7 <= 0) {
            i("ImageReader height must be greater than 0, but given height=%d, set height=1", Integer.valueOf(i7));
            i9 = 1;
        } else {
            i9 = i7;
        }
        if (Build.VERSION.SDK_INT < 29) {
            return ImageReader.newInstance(i8, i9, 1, 3);
        }
        newInstance = ImageReader.newInstance(i8, i9, 1, 3, 768L);
        return newInstance;
    }

    private void h() {
        setAlpha(0.0f);
    }

    private static void i(String str, Object... objArr) {
        k3.b.g("FlutterImageView", String.format(Locale.US, str, objArr));
    }

    private void k() {
        HardwareBuffer hardwareBuffer;
        ColorSpace.Named named;
        ColorSpace colorSpace;
        Bitmap wrapHardwareBuffer;
        if (Build.VERSION.SDK_INT >= 29) {
            hardwareBuffer = this.f5917b.getHardwareBuffer();
            named = ColorSpace.Named.SRGB;
            colorSpace = ColorSpace.get(named);
            wrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBuffer, colorSpace);
            this.f5918c = wrapHardwareBuffer;
            hardwareBuffer.close();
            return;
        }
        Image.Plane[] planes = this.f5917b.getPlanes();
        if (planes.length != 1) {
            return;
        }
        Image.Plane plane = planes[0];
        int rowStride = plane.getRowStride() / plane.getPixelStride();
        int height = this.f5917b.getHeight();
        Bitmap bitmap = this.f5918c;
        if (bitmap == null || bitmap.getWidth() != rowStride || this.f5918c.getHeight() != height) {
            this.f5918c = Bitmap.createBitmap(rowStride, height, Bitmap.Config.ARGB_8888);
        }
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        this.f5918c.copyPixelsFromBuffer(buffer);
    }

    @Override // w3.c
    public void a(w3.a aVar) {
        if (a.f5922a[this.f5920e.ordinal()] == 1) {
            aVar.x(this.f5916a.getSurface());
        }
        setAlpha(1.0f);
        this.f5919d = aVar;
        this.f5921f = true;
    }

    @Override // w3.c
    public void b() {
        if (this.f5921f) {
            setAlpha(0.0f);
            c();
            this.f5918c = null;
            e();
            invalidate();
            this.f5921f = false;
        }
    }

    public boolean c() {
        if (!this.f5921f) {
            return false;
        }
        Image acquireLatestImage = this.f5916a.acquireLatestImage();
        if (acquireLatestImage != null) {
            e();
            this.f5917b = acquireLatestImage;
            invalidate();
        }
        return acquireLatestImage != null;
    }

    @Override // w3.c
    public void d() {
    }

    public void f() {
        this.f5916a.close();
    }

    @Override // w3.c
    public w3.a getAttachedRenderer() {
        return this.f5919d;
    }

    public ImageReader getImageReader() {
        return this.f5916a;
    }

    public Surface getSurface() {
        return this.f5916a.getSurface();
    }

    public void j(int i6, int i7) {
        if (this.f5919d == null) {
            return;
        }
        if (i6 == this.f5916a.getWidth() && i7 == this.f5916a.getHeight()) {
            return;
        }
        e();
        f();
        this.f5916a = g(i6, i7);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f5917b != null) {
            k();
        }
        Bitmap bitmap = this.f5918c;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        if (!(i6 == this.f5916a.getWidth() && i7 == this.f5916a.getHeight()) && this.f5920e == b.background && this.f5921f) {
            j(i6, i7);
            this.f5919d.x(this.f5916a.getSurface());
        }
    }
}

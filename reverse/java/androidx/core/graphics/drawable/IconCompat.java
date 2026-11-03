package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.tendcloud.tenddata.ab;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    static final PorterDuff.Mode f422k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f423a;

    /* renamed from: b, reason: collision with root package name */
    Object f424b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f425c;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f426d;

    /* renamed from: e, reason: collision with root package name */
    public int f427e;

    /* renamed from: f, reason: collision with root package name */
    public int f428f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f429g;

    /* renamed from: h, reason: collision with root package name */
    PorterDuff.Mode f430h;

    /* renamed from: i, reason: collision with root package name */
    public String f431i;

    /* renamed from: j, reason: collision with root package name */
    public String f432j;

    static class a {
        static IconCompat a(Object obj) {
            androidx.core.util.g.a(obj);
            int d6 = d(obj);
            if (d6 == 2) {
                return IconCompat.g(null, c(obj), b(obj));
            }
            if (d6 == 4) {
                return IconCompat.e(e(obj));
            }
            if (d6 == 6) {
                return IconCompat.c(e(obj));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.f424b = obj;
            return iconCompat;
        }

        static int b(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e6) {
                Log.e("IconCompat", "Unable to get icon resource", e6);
                return 0;
            } catch (NoSuchMethodException e7) {
                Log.e("IconCompat", "Unable to get icon resource", e7);
                return 0;
            } catch (InvocationTargetException e8) {
                Log.e("IconCompat", "Unable to get icon resource", e8);
                return 0;
            }
        }

        static String c(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e6) {
                Log.e("IconCompat", "Unable to get icon package", e6);
                return null;
            } catch (NoSuchMethodException e7) {
                Log.e("IconCompat", "Unable to get icon package", e7);
                return null;
            } catch (InvocationTargetException e8) {
                Log.e("IconCompat", "Unable to get icon package", e8);
                return null;
            }
        }

        static int d(Object obj) {
            StringBuilder sb;
            if (Build.VERSION.SDK_INT >= 28) {
                return c.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e6) {
                e = e6;
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                Log.e("IconCompat", sb.toString(), e);
                return -1;
            } catch (NoSuchMethodException e7) {
                e = e7;
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                Log.e("IconCompat", sb.toString(), e);
                return -1;
            } catch (InvocationTargetException e8) {
                e = e8;
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                Log.e("IconCompat", sb.toString(), e);
                return -1;
            }
        }

        static Uri e(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e6) {
                Log.e("IconCompat", "Unable to get icon uri", e6);
                return null;
            } catch (NoSuchMethodException e7) {
                Log.e("IconCompat", "Unable to get icon uri", e7);
                return null;
            } catch (InvocationTargetException e8) {
                Log.e("IconCompat", "Unable to get icon uri", e8);
                return null;
            }
        }

        static Drawable f(Icon icon, Context context) {
            Drawable loadDrawable;
            loadDrawable = icon.loadDrawable(context);
            return loadDrawable;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x00b6  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x00bf  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        static android.graphics.drawable.Icon g(androidx.core.graphics.drawable.IconCompat r4, android.content.Context r5) {
            /*
                int r0 = r4.f423a
                r1 = 0
                r2 = 26
                switch(r0) {
                    case -1: goto Lc3;
                    case 0: goto L8;
                    case 1: goto Laa;
                    case 2: goto L9f;
                    case 3: goto L92;
                    case 4: goto L89;
                    case 5: goto L6f;
                    case 6: goto L10;
                    default: goto L8;
                }
            L8:
                java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
                java.lang.String r5 = "Unknown type"
                r4.<init>(r5)
                throw r4
            L10:
                int r0 = android.os.Build.VERSION.SDK_INT
                r3 = 30
                if (r0 < r3) goto L20
                android.net.Uri r5 = r4.k()
                android.graphics.drawable.Icon r5 = androidx.core.graphics.drawable.IconCompat.d.a(r5)
                goto Lb2
            L20:
                if (r5 == 0) goto L54
                java.io.InputStream r5 = r4.l(r5)
                if (r5 == 0) goto L39
                android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r5)
                if (r0 < r2) goto L2f
                goto L77
            L2f:
                android.graphics.Bitmap r5 = androidx.core.graphics.drawable.IconCompat.b(r5, r1)
                android.graphics.drawable.Icon r5 = androidx.core.graphics.drawable.b.a(r5)
                goto Lb2
            L39:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Cannot load adaptive icon from uri: "
                r0.append(r1)
                android.net.Uri r4 = r4.k()
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r5.<init>(r4)
                throw r5
            L54:
                java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Context is required to resolve the file uri of the icon: "
                r0.append(r1)
                android.net.Uri r4 = r4.k()
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r5.<init>(r4)
                throw r5
            L6f:
                int r5 = android.os.Build.VERSION.SDK_INT
                if (r5 < r2) goto L7c
                java.lang.Object r5 = r4.f424b
                android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            L77:
                android.graphics.drawable.Icon r5 = androidx.core.graphics.drawable.IconCompat.b.b(r5)
                goto Lb2
            L7c:
                java.lang.Object r5 = r4.f424b
                android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
                android.graphics.Bitmap r5 = androidx.core.graphics.drawable.IconCompat.b(r5, r1)
                android.graphics.drawable.Icon r5 = androidx.core.graphics.drawable.b.a(r5)
                goto Lb2
            L89:
                java.lang.Object r5 = r4.f424b
                java.lang.String r5 = (java.lang.String) r5
                android.graphics.drawable.Icon r5 = androidx.core.graphics.drawable.e.a(r5)
                goto Lb2
            L92:
                java.lang.Object r5 = r4.f424b
                byte[] r5 = (byte[]) r5
                int r0 = r4.f427e
                int r1 = r4.f428f
                android.graphics.drawable.Icon r5 = androidx.core.graphics.drawable.d.a(r5, r0, r1)
                goto Lb2
            L9f:
                java.lang.String r5 = r4.i()
                int r0 = r4.f427e
                android.graphics.drawable.Icon r5 = androidx.core.graphics.drawable.c.a(r5, r0)
                goto Lb2
            Laa:
                java.lang.Object r5 = r4.f424b
                android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
                android.graphics.drawable.Icon r5 = androidx.core.graphics.drawable.b.a(r5)
            Lb2:
                android.content.res.ColorStateList r0 = r4.f429g
                if (r0 == 0) goto Lb9
                androidx.core.graphics.drawable.f.a(r5, r0)
            Lb9:
                android.graphics.PorterDuff$Mode r4 = r4.f430h
                android.graphics.PorterDuff$Mode r0 = androidx.core.graphics.drawable.IconCompat.f422k
                if (r4 == r0) goto Lc2
                androidx.core.graphics.drawable.g.a(r5, r4)
            Lc2:
                return r5
            Lc3:
                java.lang.Object r4 = r4.f424b
                android.graphics.drawable.Icon r4 = (android.graphics.drawable.Icon) r4
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.a.g(androidx.core.graphics.drawable.IconCompat, android.content.Context):android.graphics.drawable.Icon");
        }
    }

    static class b {
        static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        static Icon b(Bitmap bitmap) {
            Icon createWithAdaptiveBitmap;
            createWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
            return createWithAdaptiveBitmap;
        }
    }

    static class c {
        static int a(Object obj) {
            int resId;
            resId = ((Icon) obj).getResId();
            return resId;
        }

        static String b(Object obj) {
            String resPackage;
            resPackage = ((Icon) obj).getResPackage();
            return resPackage;
        }

        static int c(Object obj) {
            int type;
            type = ((Icon) obj).getType();
            return type;
        }

        static Uri d(Object obj) {
            Uri uri;
            uri = ((Icon) obj).getUri();
            return uri;
        }
    }

    static class d {
        static Icon a(Uri uri) {
            Icon createWithAdaptiveBitmapContentUri;
            createWithAdaptiveBitmapContentUri = Icon.createWithAdaptiveBitmapContentUri(uri);
            return createWithAdaptiveBitmapContentUri;
        }
    }

    public IconCompat() {
        this.f423a = -1;
        this.f425c = null;
        this.f426d = null;
        this.f427e = 0;
        this.f428f = 0;
        this.f429g = null;
        this.f430h = f422k;
        this.f431i = null;
    }

    IconCompat(int i6) {
        this.f425c = null;
        this.f426d = null;
        this.f427e = 0;
        this.f428f = 0;
        this.f429g = null;
        this.f430h = f422k;
        this.f431i = null;
        this.f423a = i6;
    }

    public static IconCompat a(Icon icon) {
        return a.a(icon);
    }

    static Bitmap b(Bitmap bitmap, boolean z5) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f6 = min;
        float f7 = 0.5f * f6;
        float f8 = 0.9166667f * f7;
        if (z5) {
            float f9 = 0.010416667f * f6;
            paint.setColor(0);
            paint.setShadowLayer(f9, 0.0f, f6 * 0.020833334f, 1023410176);
            canvas.drawCircle(f7, f7, f8, paint);
            paint.setShadowLayer(f9, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f7, f7, f8, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2.0f, (-(bitmap.getHeight() - min)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f7, f7, f8, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static IconCompat c(Uri uri) {
        androidx.core.util.d.c(uri);
        return d(uri.toString());
    }

    public static IconCompat d(String str) {
        androidx.core.util.d.c(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f424b = str;
        return iconCompat;
    }

    public static IconCompat e(Uri uri) {
        androidx.core.util.d.c(uri);
        return f(uri.toString());
    }

    public static IconCompat f(String str) {
        androidx.core.util.d.c(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f424b = str;
        return iconCompat;
    }

    public static IconCompat g(Resources resources, String str, int i6) {
        androidx.core.util.d.c(str);
        if (i6 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f427e = i6;
        if (resources != null) {
            try {
                iconCompat.f424b = resources.getResourceName(i6);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f424b = str;
        }
        iconCompat.f432j = str;
        return iconCompat;
    }

    private static String q(int i6) {
        switch (i6) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public int h() {
        int i6 = this.f423a;
        if (i6 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.b(this.f424b);
        }
        if (i6 == 2) {
            return this.f427e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String i() {
        int i6 = this.f423a;
        if (i6 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.c(this.f424b);
        }
        if (i6 == 2) {
            String str = this.f432j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f424b).split(":", -1)[0] : this.f432j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int j() {
        int i6 = this.f423a;
        return (i6 != -1 || Build.VERSION.SDK_INT < 23) ? i6 : a.d(this.f424b);
    }

    public Uri k() {
        int i6 = this.f423a;
        if (i6 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.e(this.f424b);
        }
        if (i6 == 4 || i6 == 6) {
            return Uri.parse((String) this.f424b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream l(Context context) {
        StringBuilder sb;
        String str;
        Uri k6 = k();
        String scheme = k6.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(k6);
            } catch (Exception e6) {
                e = e6;
                sb = new StringBuilder();
                str = "Unable to load image from URI: ";
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.f424b));
            } catch (FileNotFoundException e7) {
                e = e7;
                sb = new StringBuilder();
                str = "Unable to load image from path: ";
            }
        }
        sb.append(str);
        sb.append(k6);
        Log.w("IconCompat", sb.toString(), e);
        return null;
    }

    public void m() {
        Parcelable parcelable;
        this.f430h = PorterDuff.Mode.valueOf(this.f431i);
        switch (this.f423a) {
            case ab.c.SDT_UNKNOWN /* -1 */:
                parcelable = this.f426d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case 5:
                parcelable = this.f426d;
                if (parcelable == null) {
                    byte[] bArr = this.f425c;
                    this.f424b = bArr;
                    this.f423a = 3;
                    this.f427e = 0;
                    this.f428f = bArr.length;
                    return;
                }
                break;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f425c, Charset.forName("UTF-16"));
                this.f424b = str;
                if (this.f423a == 2 && this.f432j == null) {
                    this.f432j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f424b = this.f425c;
                return;
        }
        this.f424b = parcelable;
    }

    public void n(boolean z5) {
        this.f431i = this.f430h.name();
        switch (this.f423a) {
            case ab.c.SDT_UNKNOWN /* -1 */:
                if (z5) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z5) {
                    Bitmap bitmap = (Bitmap) this.f424b;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f425c = byteArrayOutputStream.toByteArray();
                    return;
                }
                break;
            case 2:
                this.f425c = ((String) this.f424b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f425c = (byte[]) this.f424b;
                return;
            case 4:
            case 6:
                this.f425c = this.f424b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
        this.f426d = (Parcelable) this.f424b;
    }

    @Deprecated
    public Icon o() {
        return p(null);
    }

    public Icon p(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.g(this, context);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    public String toString() {
        int height;
        if (this.f423a == -1) {
            return String.valueOf(this.f424b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(q(this.f423a));
        switch (this.f423a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f424b).getWidth());
                sb.append("x");
                height = ((Bitmap) this.f424b).getHeight();
                sb.append(height);
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f432j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(h())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f427e);
                if (this.f428f != 0) {
                    sb.append(" off=");
                    height = this.f428f;
                    sb.append(height);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f424b);
                break;
        }
        if (this.f429g != null) {
            sb.append(" tint=");
            sb.append(this.f429g);
        }
        if (this.f430h != f422k) {
            sb.append(" mode=");
            sb.append(this.f430h);
        }
        sb.append(")");
        return sb.toString();
    }
}

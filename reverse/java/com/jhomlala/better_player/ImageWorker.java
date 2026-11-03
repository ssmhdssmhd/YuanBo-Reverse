package com.jhomlala.better_player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.b;
import java.io.FileOutputStream;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import z2.q;

/* loaded from: classes.dex */
public final class ImageWorker extends Worker {

    /* renamed from: g, reason: collision with root package name */
    public static final a f2168g = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageWorker(Context context, WorkerParameters params) {
        super(context, params);
        k.e(context, "context");
        k.e(params, "params");
    }

    private final int r(BitmapFactory.Options options) {
        int i6 = options.outHeight;
        int i7 = options.outWidth;
        int i8 = 1;
        if (i6 > 256 || i7 > 256) {
            int i9 = i6 / 2;
            int i10 = i7 / 2;
            while (i9 / i8 >= 256 && i10 / i8 >= 256) {
                i8 *= 2;
            }
        }
        return i8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0043, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0047, code lost:
    
        android.util.Log.e("ImageWorker", "Failed to close bitmap input stream/");
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0062, code lost:
    
        if (r5 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0041, code lost:
    
        if (r5 != null) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.graphics.Bitmap s(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            java.lang.String r1 = "Failed to close bitmap input stream/"
            java.lang.String r2 = "ImageWorker"
            r3 = 0
            java.net.URL r4 = new java.net.URL     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            r4.<init>(r9)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.net.URLConnection r5 = r4.openConnection()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            kotlin.jvm.internal.k.c(r5, r0)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.io.InputStream r5 = r5.getInputStream()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            android.graphics.BitmapFactory$Options r6 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L66
            r6.<init>()     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L66
            r7 = 1
            r6.inJustDecodeBounds = r7     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L66
            android.graphics.BitmapFactory.decodeStream(r5, r3, r6)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L66
            r5.close()     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L66
            java.net.URLConnection r4 = r4.openConnection()     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L66
            kotlin.jvm.internal.k.c(r4, r0)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L66
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L66
            java.io.InputStream r5 = r4.getInputStream()     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L66
            int r0 = r8.r(r6)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L66
            r6.inSampleSize = r0     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L66
            r0 = 0
            r6.inJustDecodeBounds = r0     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L66
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r5, r3, r6)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L66
            if (r5 == 0) goto L65
        L43:
            r5.close()     // Catch: java.lang.Exception -> L47
            goto L65
        L47:
            android.util.Log.e(r2, r1)
            goto L65
        L4b:
            r9 = move-exception
            goto L68
        L4d:
            r5 = r3
        L4e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L66
            r0.<init>()     // Catch: java.lang.Throwable -> L66
            java.lang.String r4 = "Failed to get bitmap from external url: "
            r0.append(r4)     // Catch: java.lang.Throwable -> L66
            r0.append(r9)     // Catch: java.lang.Throwable -> L66
            java.lang.String r9 = r0.toString()     // Catch: java.lang.Throwable -> L66
            android.util.Log.e(r2, r9)     // Catch: java.lang.Throwable -> L66
            if (r5 == 0) goto L65
            goto L43
        L65:
            return r3
        L66:
            r9 = move-exception
            r3 = r5
        L68:
            if (r3 == 0) goto L71
            r3.close()     // Catch: java.lang.Exception -> L6e
            goto L71
        L6e:
            android.util.Log.e(r2, r1)
        L71:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jhomlala.better_player.ImageWorker.s(java.lang.String):android.graphics.Bitmap");
    }

    private final Bitmap t(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inSampleSize = r(options);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str);
        } catch (Exception unused) {
            Log.e("ImageWorker", "Failed to get bitmap from internal url: " + str);
            return null;
        }
    }

    @Override // androidx.work.Worker
    public ListenableWorker.a q() {
        try {
            String j6 = g().j("url");
            if (j6 == null) {
                ListenableWorker.a a6 = ListenableWorker.a.a();
                k.d(a6, "failure()");
                return a6;
            }
            Bitmap s5 = q.d(Uri.parse(j6)) ? s(j6) : t(j6);
            String str = a().getCacheDir().getAbsolutePath() + (j6.hashCode() + ".png");
            if (s5 == null) {
                ListenableWorker.a a7 = ListenableWorker.a.a();
                k.d(a7, "failure()");
                return a7;
            }
            s5.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(str));
            b a8 = new b.a().f("filePath", str).a();
            k.d(a8, "Builder().putString(Bett…AMETER, filePath).build()");
            ListenableWorker.a d6 = ListenableWorker.a.d(a8);
            k.d(d6, "{\n            val imageU…t.success(data)\n        }");
            return d6;
        } catch (Exception e6) {
            e6.printStackTrace();
            ListenableWorker.a a9 = ListenableWorker.a.a();
            k.d(a9, "{\n            e.printSta…esult.failure()\n        }");
            return a9;
        }
    }
}

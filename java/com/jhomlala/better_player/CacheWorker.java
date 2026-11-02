package com.jhomlala.better_player;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.b;
import com.jhomlala.better_player.CacheWorker;
import g2.b0;
import g2.m;
import h2.k;
import java.util.HashMap;
import java.util.Objects;
import kotlin.jvm.internal.g;
import v4.f;
import v4.q;

/* loaded from: classes.dex */
public final class CacheWorker extends Worker {

    /* renamed from: j, reason: collision with root package name */
    public static final a f2164j = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private final Context f2165g;

    /* renamed from: h, reason: collision with root package name */
    private k f2166h;

    /* renamed from: i, reason: collision with root package name */
    private int f2167i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CacheWorker(Context context, WorkerParameters params) {
        super(context, params);
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(params, "params");
        this.f2165g = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(long j6, CacheWorker this$0, String str, long j7, long j8, long j9) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        double d6 = (j8 * 100.0f) / j6;
        int i6 = this$0.f2167i;
        if (d6 >= i6 * 10) {
            this$0.f2167i = i6 + 1;
            Log.d("CacheWorker", "Completed pre cache of " + str + ": " + ((int) d6) + '%');
        }
    }

    @Override // androidx.work.ListenableWorker
    public void l() {
        try {
            k kVar = this.f2166h;
            if (kVar != null) {
                kVar.b();
            }
            super.l();
        } catch (Exception e6) {
            Log.e("CacheWorker", e6.toString());
        }
    }

    @Override // androidx.work.Worker
    public ListenableWorker.a q() {
        ListenableWorker.a a6;
        String str;
        boolean F;
        try {
            b inputData = g();
            kotlin.jvm.internal.k.d(inputData, "inputData");
            final String j6 = inputData.j("url");
            String j7 = inputData.j("cacheKey");
            final long i6 = inputData.i("preCacheSize", 0L);
            long i7 = inputData.i("maxCacheSize", 0L);
            long i8 = inputData.i("maxCacheFileSize", 0L);
            HashMap hashMap = new HashMap();
            for (String key : inputData.h().keySet()) {
                kotlin.jvm.internal.k.d(key, "key");
                F = q.F(key, "header_", false, 2, null);
                if (F) {
                    Object[] array = new f("header_").c(key, 0).toArray(new String[0]);
                    kotlin.jvm.internal.k.c(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    String str2 = ((String[]) array)[0];
                    Object obj = inputData.h().get(key);
                    Objects.requireNonNull(obj);
                    kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlin.String");
                    hashMap.put(str2, (String) obj);
                }
            }
            Uri parse = Uri.parse(j6);
            if (!z2.q.d(parse)) {
                Log.e("CacheWorker", "Preloading only possible for remote data sources");
                ListenableWorker.a a7 = ListenableWorker.a.a();
                kotlin.jvm.internal.k.d(a7, "failure()");
                return a7;
            }
            m.a a8 = z2.q.a(z2.q.c(hashMap), hashMap);
            g2.q qVar = new g2.q(parse, 0L, i6);
            if (j7 != null) {
                if (j7.length() > 0) {
                    qVar = qVar.a().f(j7).a();
                    kotlin.jvm.internal.k.d(qVar, "dataSpec.buildUpon().setKey(cacheKey).build()");
                }
            }
            k kVar = new k(new z2.m(this.f2165g, i7, i8, a8).a(), qVar, null, new k.a() { // from class: z2.n
                @Override // h2.k.a
                public final void a(long j8, long j9, long j10) {
                    CacheWorker.s(i6, this, j6, j8, j9, j10);
                }
            });
            this.f2166h = kVar;
            kVar.a();
            ListenableWorker.a c6 = ListenableWorker.a.c();
            kotlin.jvm.internal.k.d(c6, "success()");
            return c6;
        } catch (Exception e6) {
            Log.e("CacheWorker", e6.toString());
            if (e6 instanceof b0) {
                a6 = ListenableWorker.a.c();
                str = "{\n                Result.success()\n            }";
            } else {
                a6 = ListenableWorker.a.a();
                str = "{\n                Result.failure()\n            }";
            }
            kotlin.jvm.internal.k.d(a6, str);
            return a6;
        }
    }
}

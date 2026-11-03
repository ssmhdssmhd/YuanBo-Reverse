package com.muhua.mu_hua_movie;

import c3.a;
import com.muhua.mu_hua_movie.MainActivity;
import io.flutter.embedding.android.d;
import y3.j;
import y3.k;

/* loaded from: classes.dex */
public final class MainActivity extends d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(MainActivity this$0, j call, k.d result) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(call, "call");
        kotlin.jvm.internal.k.e(result, "result");
        if (kotlin.jvm.internal.k.a(call.f11100a, "installApk")) {
            a aVar = new a();
            Object obj = call.f11101b;
            kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlin.String");
            aVar.a(this$0, (String) obj, 10001);
        }
    }

    @Override // io.flutter.embedding.android.d, io.flutter.embedding.android.e.c
    public void C(io.flutter.embedding.engine.a flutterEngine) {
        kotlin.jvm.internal.k.e(flutterEngine, "flutterEngine");
        super.C(flutterEngine);
        new k(flutterEngine.h().j(), "native_channel").e(new k.c() { // from class: c3.b
            @Override // y3.k.c
            public final void e(j jVar, k.d dVar) {
                MainActivity.R(MainActivity.this, jVar, dVar);
            }
        });
    }
}

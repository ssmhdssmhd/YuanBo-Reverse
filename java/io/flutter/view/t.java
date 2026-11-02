package io.flutter.view;

import android.graphics.SurfaceTexture;

/* loaded from: classes.dex */
public interface t {

    public interface a {
        void a();
    }

    public interface b {
        void onTrimMemory(int i6);
    }

    public interface c {
        void a();

        void b(b bVar);

        void c(a aVar);

        SurfaceTexture d();

        long e();
    }

    c a();
}

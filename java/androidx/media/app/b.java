package androidx.media.app;

import android.app.PendingIntent;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.core.app.m;
import androidx.core.app.n;

/* loaded from: classes.dex */
public class b extends n.d {

    /* renamed from: e, reason: collision with root package name */
    int[] f924e = null;

    /* renamed from: f, reason: collision with root package name */
    MediaSessionCompat.Token f925f;

    /* renamed from: g, reason: collision with root package name */
    PendingIntent f926g;

    @Override // androidx.core.app.n.d
    public void b(m mVar) {
        a.d(mVar.a(), a.b(a.a(), this.f924e, this.f925f));
    }

    @Override // androidx.core.app.n.d
    public RemoteViews d(m mVar) {
        return null;
    }

    @Override // androidx.core.app.n.d
    public RemoteViews e(m mVar) {
        return null;
    }

    public b h(PendingIntent pendingIntent) {
        this.f926g = pendingIntent;
        return this;
    }

    public b i(MediaSessionCompat.Token token) {
        this.f925f = token;
        return this;
    }

    public b j(int... iArr) {
        this.f924e = iArr;
        return this;
    }

    public b k(boolean z5) {
        return this;
    }
}

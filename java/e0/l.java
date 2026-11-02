package e0;

import androidx.work.WorkerParameters;

/* loaded from: classes.dex */
public class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private w.j f3336a;

    /* renamed from: b, reason: collision with root package name */
    private String f3337b;

    /* renamed from: c, reason: collision with root package name */
    private WorkerParameters.a f3338c;

    public l(w.j jVar, String str, WorkerParameters.a aVar) {
        this.f3336a = jVar;
        this.f3337b = str;
        this.f3338c = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3336a.n().k(this.f3337b, this.f3338c);
    }
}

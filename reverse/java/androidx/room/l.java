package androidx.room;

import java.io.File;
import q.c;

/* loaded from: classes.dex */
class l implements c.InterfaceC0129c {

    /* renamed from: a, reason: collision with root package name */
    private final String f1420a;

    /* renamed from: b, reason: collision with root package name */
    private final File f1421b;

    /* renamed from: c, reason: collision with root package name */
    private final c.InterfaceC0129c f1422c;

    l(String str, File file, c.InterfaceC0129c interfaceC0129c) {
        this.f1420a = str;
        this.f1421b = file;
        this.f1422c = interfaceC0129c;
    }

    @Override // q.c.InterfaceC0129c
    public q.c a(c.b bVar) {
        return new k(bVar.f8656a, this.f1420a, this.f1421b, bVar.f8658c.f8655a, this.f1422c.a(bVar));
    }
}

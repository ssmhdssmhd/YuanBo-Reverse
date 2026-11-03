package j3;

import android.content.Context;
import kotlin.jvm.internal.g;
import q3.a;
import y3.k;

/* loaded from: classes.dex */
public final class d implements q3.a, r3.a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f6817d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private c f6818a;

    /* renamed from: b, reason: collision with root package name */
    private dev.fluttercommunity.plus.share.a f6819b;

    /* renamed from: c, reason: collision with root package name */
    private k f6820c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Override // r3.a
    public void a(r3.c binding) {
        kotlin.jvm.internal.k.e(binding, "binding");
        d(binding);
    }

    @Override // q3.a
    public void b(a.b binding) {
        kotlin.jvm.internal.k.e(binding, "binding");
        this.f6820c = new k(binding.b(), "dev.fluttercommunity.plus/share");
        Context a6 = binding.a();
        kotlin.jvm.internal.k.d(a6, "binding.applicationContext");
        this.f6819b = new dev.fluttercommunity.plus.share.a(a6);
        Context a7 = binding.a();
        kotlin.jvm.internal.k.d(a7, "binding.applicationContext");
        dev.fluttercommunity.plus.share.a aVar = this.f6819b;
        k kVar = null;
        if (aVar == null) {
            kotlin.jvm.internal.k.o("manager");
            aVar = null;
        }
        c cVar = new c(a7, null, aVar);
        this.f6818a = cVar;
        dev.fluttercommunity.plus.share.a aVar2 = this.f6819b;
        if (aVar2 == null) {
            kotlin.jvm.internal.k.o("manager");
            aVar2 = null;
        }
        j3.a aVar3 = new j3.a(cVar, aVar2);
        k kVar2 = this.f6820c;
        if (kVar2 == null) {
            kotlin.jvm.internal.k.o("methodChannel");
        } else {
            kVar = kVar2;
        }
        kVar.e(aVar3);
    }

    @Override // r3.a
    public void c() {
        c cVar = this.f6818a;
        if (cVar == null) {
            kotlin.jvm.internal.k.o("share");
            cVar = null;
        }
        cVar.m(null);
    }

    @Override // r3.a
    public void d(r3.c binding) {
        kotlin.jvm.internal.k.e(binding, "binding");
        dev.fluttercommunity.plus.share.a aVar = this.f6819b;
        c cVar = null;
        if (aVar == null) {
            kotlin.jvm.internal.k.o("manager");
            aVar = null;
        }
        binding.a(aVar);
        c cVar2 = this.f6818a;
        if (cVar2 == null) {
            kotlin.jvm.internal.k.o("share");
        } else {
            cVar = cVar2;
        }
        cVar.m(binding.d());
    }

    @Override // r3.a
    public void f() {
        c();
    }

    @Override // q3.a
    public void j(a.b binding) {
        kotlin.jvm.internal.k.e(binding, "binding");
        k kVar = this.f6820c;
        if (kVar == null) {
            kotlin.jvm.internal.k.o("methodChannel");
            kVar = null;
        }
        kVar.e(null);
    }
}

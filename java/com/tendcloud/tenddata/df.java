package com.tendcloud.tenddata;

/* loaded from: classes.dex */
public class df extends da {

    /* renamed from: a, reason: collision with root package name */
    public static de f2597a = null;

    /* renamed from: c, reason: collision with root package name */
    private static final String f2598c = "type";

    /* renamed from: d, reason: collision with root package name */
    private static final String f2599d = "deviceId";

    /* renamed from: e, reason: collision with root package name */
    private static final String f2600e = "runtimeConfig";

    /* renamed from: f, reason: collision with root package name */
    private static final String f2601f = "hardwareConfig";

    /* renamed from: g, reason: collision with root package name */
    private static final String f2602g = "softwareConfig";

    /* renamed from: h, reason: collision with root package name */
    private dg f2603h = new dg();

    /* renamed from: i, reason: collision with root package name */
    private dd f2604i = new dd();

    public df() {
        d();
    }

    private void d() {
        a(f2598c, "mobile");
        de deVar = new de();
        f2597a = deVar;
        a(f2599d, deVar.b());
        a(f2600e, new di().b());
        a(f2601f, this.f2604i.b());
        a(f2602g, this.f2603h.b());
    }

    public dg a() {
        return this.f2603h;
    }

    public dd c() {
        return this.f2604i;
    }
}

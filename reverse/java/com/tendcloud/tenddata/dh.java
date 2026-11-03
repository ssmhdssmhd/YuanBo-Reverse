package com.tendcloud.tenddata;

/* loaded from: classes.dex */
public class dh extends da {

    /* renamed from: j, reason: collision with root package name */
    private static volatile dh f2605j;

    /* renamed from: a, reason: collision with root package name */
    private final String f2606a = "oaid";

    /* renamed from: c, reason: collision with root package name */
    private final String f2607c = "vaid";

    /* renamed from: d, reason: collision with root package name */
    private final String f2608d = "aaid";

    /* renamed from: e, reason: collision with root package name */
    private final String f2609e = "udid";

    /* renamed from: f, reason: collision with root package name */
    private volatile String f2610f = "";

    /* renamed from: g, reason: collision with root package name */
    private volatile String f2611g = "";

    /* renamed from: h, reason: collision with root package name */
    private volatile String f2612h = "";

    /* renamed from: i, reason: collision with root package name */
    private volatile String f2613i = "";

    private dh() {
    }

    public static dh a() {
        if (f2605j == null) {
            synchronized (dh.class) {
                if (f2605j == null) {
                    f2605j = new dh();
                }
            }
        }
        return f2605j;
    }

    public String c() {
        return this.f2610f;
    }

    public String d() {
        return this.f2611g;
    }

    public String e() {
        return this.f2612h;
    }

    public String f() {
        return this.f2613i;
    }

    public void setAAID(String str) {
        this.f2611g = str;
        a("aaid", str);
    }

    public void setOAID(String str) {
        this.f2610f = str;
        a("oaid", str);
    }

    public void setUDID(String str) {
        this.f2613i = str;
        a("udid", str);
    }

    public void setVAID(String str) {
        this.f2612h = str;
        a("vaid", str);
    }
}

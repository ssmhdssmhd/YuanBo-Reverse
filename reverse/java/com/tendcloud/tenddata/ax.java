package com.tendcloud.tenddata;

/* loaded from: classes.dex */
public class ax {

    /* renamed from: a, reason: collision with root package name */
    private String f2323a;

    /* renamed from: b, reason: collision with root package name */
    private String f2324b;

    /* renamed from: c, reason: collision with root package name */
    private byte f2325c;

    /* renamed from: d, reason: collision with root package name */
    private byte f2326d;

    /* renamed from: e, reason: collision with root package name */
    private byte f2327e;

    public ax() {
        this.f2323a = "";
        this.f2324b = "00:00:00:00:00:00";
        this.f2325c = (byte) -127;
        this.f2326d = (byte) 1;
        this.f2327e = (byte) 1;
    }

    public ax(String str, String str2, byte b6, byte b7, byte b8) {
        this.f2323a = str;
        this.f2324b = str2;
        this.f2325c = b6;
        this.f2326d = b7;
        this.f2327e = b8;
    }

    public String a() {
        return this.f2323a;
    }

    public String b() {
        return this.f2324b;
    }

    public byte c() {
        return this.f2325c;
    }

    public byte d() {
        return this.f2326d;
    }

    public byte e() {
        return this.f2327e;
    }

    public ax f() {
        return new ax(this.f2323a, this.f2324b, this.f2325c, this.f2326d, this.f2327e);
    }

    public void setBand(byte b6) {
        this.f2326d = b6;
    }

    public void setBssid(String str) {
        this.f2324b = str;
    }

    public void setChannel(byte b6) {
        this.f2327e = b6;
    }

    public void setRssi(byte b6) {
        this.f2325c = b6;
    }

    public void setSsid(String str) {
        this.f2323a = str;
    }
}

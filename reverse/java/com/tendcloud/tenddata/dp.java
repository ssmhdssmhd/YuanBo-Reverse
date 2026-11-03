package com.tendcloud.tenddata;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class dp extends JSONObject {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2643a = "category";

    /* renamed from: b, reason: collision with root package name */
    private static final String f2644b = "content";

    private dp() {
    }

    public static dp a() {
        return new dp();
    }

    public dp a(String str) {
        try {
            put(f2643a, str);
        } catch (Throwable th) {
            h.a("set category error ", th);
        }
        return this;
    }

    public dp b(String str) {
        try {
            put(f2644b, str);
        } catch (Throwable th) {
            h.a("set content error ", th);
        }
        return this;
    }
}

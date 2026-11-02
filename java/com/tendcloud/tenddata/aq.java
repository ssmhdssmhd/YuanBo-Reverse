package com.tendcloud.tenddata;

import java.net.HttpURLConnection;

/* loaded from: classes.dex */
public enum aq {
    GET(false),
    POST(true);


    /* renamed from: c, reason: collision with root package name */
    private final boolean f2299c;

    aq(boolean z5) {
        this.f2299c = z5;
    }

    final void a(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.setRequestMethod(name());
            httpURLConnection.setDoOutput(this.f2299c);
            httpURLConnection.setDoInput(true);
        } catch (Throwable unused) {
        }
    }
}

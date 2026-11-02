package com.tendcloud.tenddata;

import java.io.OutputStream;
import java.net.HttpURLConnection;

/* loaded from: classes.dex */
public final class an {

    /* renamed from: a, reason: collision with root package name */
    private final a f2293a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f2294b;

    public enum a {
        UNIVERSAL_STREAM("application/octet-stream"),
        JSON("application/json"),
        FORM("application/x-www-form-urlencoded"),
        EMPTY("");

        private String name;

        a(String str) {
            this.name = str;
        }

        public String getName() {
            return this.name;
        }
    }

    public an(a aVar, byte[] bArr) {
        this.f2293a = aVar;
        this.f2294b = bArr;
    }

    void a(HttpURLConnection httpURLConnection) {
        OutputStream outputStream;
        httpURLConnection.setFixedLengthStreamingMode(this.f2294b.length);
        httpURLConnection.setRequestProperty("Content-Type", this.f2293a.getName());
        try {
            outputStream = httpURLConnection.getOutputStream();
        } catch (Throwable unused) {
            outputStream = null;
        }
        try {
            try {
                outputStream.write(this.f2294b);
            } catch (Throwable unused2) {
                if (outputStream == null) {
                    return;
                }
                outputStream.close();
            }
            outputStream.close();
        } catch (Throwable unused3) {
        }
    }

    public byte[] a() {
        return this.f2294b;
    }

    public a b() {
        return this.f2293a;
    }
}

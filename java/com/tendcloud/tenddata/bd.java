package com.tendcloud.tenddata;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class bd {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2357a = "https://api.talkingdata.com/adt/openapi/rest/socialSharing/getShortUrl";

    /* renamed from: b, reason: collision with root package name */
    private static final String f2358b = "hAF3uVnSYyk2qN3trMjXFVsijBTGcR";

    /* renamed from: c, reason: collision with root package name */
    private static bd f2359c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, Object> f2360d = null;

    public enum a {
        UNSTOP(0),
        STOP(1);

        private final int index;

        a(int i6) {
            this.index = i6;
        }

        public int index() {
            return this.index;
        }
    }

    private bd() {
    }

    public static bd a() {
        if (f2359c == null) {
            synchronized (bd.class) {
                if (f2359c == null) {
                    f2359c = new bd();
                }
            }
        }
        return f2359c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(JSONObject jSONObject, String str) {
        return y.c(jSONObject.get("pageUrl") + "." + jSONObject.get("shortUrl") + "." + jSONObject.get("is_retargeting") + "." + str + "." + f2358b);
    }

    public bd a(Map<String, Object> map) {
        this.f2360d = map;
        return this;
    }

    public void getShortUrl(final TDGenerateUrl tDGenerateUrl) {
        new Thread(new Runnable() { // from class: com.tendcloud.tenddata.bd.1
            @Override // java.lang.Runnable
            public void run() {
                TDGenerateUrl tDGenerateUrl2;
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry entry : bd.this.f2360d.entrySet()) {
                        jSONObject.put((String) entry.getKey(), entry.getValue());
                    }
                    byte[] bytes = jSONObject.toString().getBytes();
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    URL url = new URL("https://api.talkingdata.com/adt/openapi/rest/socialSharing/getShortUrl?sign=" + bd.this.a(jSONObject, valueOf) + "&nonce=" + valueOf);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Short url serve: ");
                    sb.append(url);
                    h.dForInternal(sb.toString());
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setConnectTimeout(3000);
                    httpURLConnection.setReadTimeout(15000);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                    httpURLConnection.getOutputStream().write(bytes);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                        StringBuilder sb2 = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            } else {
                                sb2.append(readLine);
                            }
                        }
                        String sb3 = sb2.toString();
                        h.dForInternal("TD getShortUrl success:", sb3);
                        JSONObject jSONObject2 = new JSONObject(sb3);
                        if (jSONObject2.getInt("code") == 200) {
                            tDGenerateUrl.callback(jSONObject2.getString("result"));
                            return;
                        } else {
                            h.eForInternal("TD getShortUrl Error:", sb3);
                            tDGenerateUrl2 = tDGenerateUrl;
                        }
                    } else {
                        h.eForInternal("TD getShortUrl Http Error:" + responseCode);
                        tDGenerateUrl2 = tDGenerateUrl;
                    }
                    tDGenerateUrl2.callback(null);
                } catch (Throwable th) {
                    th.printStackTrace();
                    tDGenerateUrl.callback(null);
                }
            }
        }).start();
    }
}

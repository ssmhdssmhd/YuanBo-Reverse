package com.tendcloud.tenddata;

import android.net.Proxy;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class dj extends da {

    /* renamed from: a, reason: collision with root package name */
    private ba f2614a;

    /* renamed from: c, reason: collision with root package name */
    private String f2615c;

    /* renamed from: com.tendcloud.tenddata.dj$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$talkingdata$sdk$saf$datamodel$network$TDNetworkType;

        static {
            int[] iArr = new int[dk.values().length];
            $SwitchMap$com$talkingdata$sdk$saf$datamodel$network$TDNetworkType = iArr;
            try {
                iArr[dk.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$talkingdata$sdk$saf$datamodel$network$TDNetworkType[dk.CELLULAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$talkingdata$sdk$saf$datamodel$network$TDNetworkType[dk.BLUETOOTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public dj(dk dkVar) {
        this.f2615c = UUID.randomUUID().toString();
        int i6 = AnonymousClass1.$SwitchMap$com$talkingdata$sdk$saf$datamodel$network$TDNetworkType[dkVar.ordinal()];
        if (i6 != 1) {
            try {
                if (i6 != 2) {
                    if (i6 != 3) {
                        return;
                    }
                    a("type", dk.BLUETOOTH.a());
                    return;
                }
                a("type", dk.CELLULAR.a());
                a("available", Boolean.valueOf(o.e(ab.f2233g)));
                a("connected", Boolean.valueOf(o.j(ab.f2233g)));
                a("ip", o.a("cell_ip"));
                a("ipv6", o.a("cell_ipv6"));
                if (o.b(ab.f2233g)) {
                    a("current", o.a(ab.f2233g, false));
                }
                if (o.b()) {
                    a("proxy", Proxy.getDefaultHost() + ":" + Proxy.getDefaultPort());
                }
                a("scannable", o.v(ab.f2233g));
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        a("type", dk.WIFI.a());
        a("available", Boolean.valueOf(o.d(ab.f2233g)));
        if (o.i(ab.f2233g)) {
            a("connected", Boolean.TRUE);
            JSONArray a6 = bi.a().a("WiFi", dm.b().f2626a, dm.b().f2627b);
            if (a6 != null) {
                a("current", o.y(ab.f2233g));
                if (a6.length() > 0) {
                    dm.b().a("WiFi", a6);
                }
            } else {
                a("current", this.f2581b);
            }
            JSONArray z5 = o.z(ab.f2233g);
            ba a7 = a(z5);
            if (this.f2614a == null) {
                a("scannable", z5);
                this.f2614a = a7;
            } else if (new bb().a(this.f2614a, a7) > 0.8d) {
                a("scannable", (Object) null);
            } else {
                a("scannable", z5);
                this.f2614a = a7;
                this.f2615c = UUID.randomUUID().toString();
            }
            JSONArray a8 = bi.a().a("WiFi", dm.b().f2626a, dm.b().f2627b);
            if (a8 != null) {
                a("configured", o.x(ab.f2233g));
                if (a8.length() > 0) {
                    dm.b().a("WiFi", a8);
                }
            } else {
                a("configured", this.f2581b);
            }
            JSONArray a9 = bi.a().a("IP", dm.b().f2626a, dm.b().f2627b);
            if (a9 != null) {
                a("ip", o.a("ip"));
                a("ipv6", o.a("ipv6"));
                if (a9.length() > 0) {
                    dm.b().a("IP", a9);
                }
            } else {
                a("ip", this.f2581b);
            }
        } else {
            a("connected", Boolean.FALSE);
        }
        if (o.b()) {
            a("proxy", Proxy.getDefaultHost() + ":" + Proxy.getDefaultPort());
        }
        a("scannableFingerId", this.f2615c);
    }

    private static ba a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i6);
                arrayList.add(new ax(jSONObject.getString("name"), jSONObject.getString("id"), (byte) jSONObject.getInt("level"), (byte) 0, (byte) 0));
            } catch (Throwable th) {
                h.eForInternal(th);
            }
        }
        ba baVar = new ba();
        baVar.setBsslist(arrayList);
        return baVar;
    }
}

package com.tendcloud.tenddata;

import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;

/* loaded from: classes.dex */
final class bu extends PhoneStateListener {

    /* renamed from: a, reason: collision with root package name */
    static final long f2459a = 180000;

    /* renamed from: d, reason: collision with root package name */
    int f2462d;

    /* renamed from: b, reason: collision with root package name */
    long f2460b = 0;

    /* renamed from: c, reason: collision with root package name */
    long f2461c = 0;

    /* renamed from: e, reason: collision with root package name */
    int f2463e = 0;

    bu() {
    }

    private void a() {
        try {
            bo.f2430a.post(new Runnable() { // from class: com.tendcloud.tenddata.bu.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        bu.this.f2460b = System.currentTimeMillis();
                        bu buVar = bu.this;
                        int i6 = buVar.f2462d;
                        if (i6 == buVar.f2463e || i6 <= 1 || buVar.f2460b - buVar.f2461c <= bu.f2459a) {
                            return;
                        }
                        bz bzVar = new bz();
                        bzVar.f2493b = "env";
                        bzVar.f2494c = "cellUpdate";
                        bzVar.f2492a = a.ENV;
                        z.a().post(bzVar);
                        bu buVar2 = bu.this;
                        buVar2.f2461c = buVar2.f2460b;
                        buVar2.f2463e = buVar2.f2462d;
                    } catch (Throwable th) {
                        bq.postSDKError(th);
                    }
                }
            });
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // android.telephony.PhoneStateListener
    public void onCellLocationChanged(CellLocation cellLocation) {
        try {
            if (cellLocation.getClass().equals(GsmCellLocation.class)) {
                this.f2462d = ((GsmCellLocation) cellLocation).getLac();
            } else if (!cellLocation.getClass().equals(CdmaCellLocation.class)) {
                return;
            } else {
                this.f2462d = ((CdmaCellLocation) cellLocation).getNetworkId();
            }
            a();
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }
}

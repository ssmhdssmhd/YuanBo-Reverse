package com.tendcloud.tenddata;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.SparseArray;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class br {

    /* renamed from: d, reason: collision with root package name */
    private static volatile br f2447d;

    /* renamed from: a, reason: collision with root package name */
    private SensorManager f2448a;

    /* renamed from: b, reason: collision with root package name */
    private a f2449b;

    /* renamed from: c, reason: collision with root package name */
    private int[] f2450c = {13, 12, 11, 5, 6, 2};

    class a implements SensorEventListener {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String arrayToString(float[] fArr) {
            if (fArr == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (float f6 : fArr) {
                sb.append(f6);
                sb.append(',');
            }
            return sb.toString().substring(0, sb.toString().length() - 1);
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i6) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(final SensorEvent sensorEvent) {
            try {
                y.execute(new Runnable() { // from class: com.tendcloud.tenddata.br.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("type", sensorEvent.sensor.getType() + "");
                        treeMap.put("values", a.this.arrayToString(sensorEvent.values));
                        treeMap.put("ts", Long.valueOf(sensorEvent.timestamp));
                        treeMap.put("accuracy", Integer.valueOf(sensorEvent.accuracy));
                        bz bzVar = new bz();
                        bzVar.f2493b = "env";
                        bzVar.f2494c = "sensorPoint";
                        bzVar.f2495d = treeMap;
                        bzVar.f2492a = com.tendcloud.tenddata.a.ENV;
                        z.a().post(bzVar);
                    }
                });
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    static {
        try {
            z.a().register(b());
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    private br() {
        this.f2448a = null;
        this.f2449b = null;
        try {
            this.f2448a = (SensorManager) ab.f2233g.getSystemService("sensor");
            this.f2449b = new a();
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    private void a(int i6, int i7) {
        try {
            Sensor defaultSensor = this.f2448a.getDefaultSensor(i6);
            if (defaultSensor != null) {
                this.f2448a.registerListener(this.f2449b, defaultSensor, i7);
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    private void a(bx bxVar) {
        try {
            a(bxVar.f2488c, bxVar.f2489d);
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    public static br b() {
        if (f2447d == null) {
            synchronized (bs.class) {
                if (f2447d == null) {
                    f2447d = new br();
                }
            }
        }
        return f2447d;
    }

    private void c() {
        this.f2448a.unregisterListener(this.f2449b);
    }

    public void a() {
        int i6 = 0;
        while (true) {
            try {
                int[] iArr = this.f2450c;
                if (i6 >= iArr.length) {
                    return;
                }
                int i7 = iArr[i6];
                if ((i7 != 13 && i7 != 12) || y.a(14)) {
                    a(this.f2450c[i6], 3);
                }
                i6++;
            } catch (Throwable th) {
                bq.postSDKError(th);
                return;
            }
        }
    }

    public final void onTDEBEventSensor(SparseArray<bx> sparseArray) {
        for (int i6 = 0; i6 < sparseArray.size(); i6++) {
            try {
                bx valueAt = sparseArray.valueAt(i6);
                int i7 = valueAt.f2488c;
                if (i7 == 12 || i7 == 13) {
                    a(valueAt);
                } else {
                    a(i7, valueAt.f2489d);
                }
            } catch (Throwable th) {
                bq.postSDKError(th);
                return;
            }
        }
    }
}

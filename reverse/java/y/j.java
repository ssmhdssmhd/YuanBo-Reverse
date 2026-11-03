package y;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.impl.background.systemjob.SystemJobService;
import d0.p;
import java.util.Iterator;
import v.c;

/* loaded from: classes.dex */
class j {

    /* renamed from: b, reason: collision with root package name */
    private static final String f10663b = v.j.f("SystemJobInfoConverter");

    /* renamed from: a, reason: collision with root package name */
    private final ComponentName f10664a;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10665a;

        static {
            int[] iArr = new int[v.k.values().length];
            f10665a = iArr;
            try {
                iArr[v.k.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10665a[v.k.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10665a[v.k.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10665a[v.k.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10665a[v.k.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    j(Context context) {
        this.f10664a = new ComponentName(context.getApplicationContext(), (Class<?>) SystemJobService.class);
    }

    private static JobInfo.TriggerContentUri b(c.a aVar) {
        return new JobInfo.TriggerContentUri(aVar.a(), aVar.b() ? 1 : 0);
    }

    static int c(v.k kVar) {
        int i6 = a.f10665a[kVar.ordinal()];
        if (i6 == 1) {
            return 0;
        }
        if (i6 == 2) {
            return 1;
        }
        if (i6 == 3) {
            return 2;
        }
        if (i6 != 4) {
            if (i6 == 5 && Build.VERSION.SDK_INT >= 26) {
                return 4;
            }
        } else if (Build.VERSION.SDK_INT >= 24) {
            return 3;
        }
        v.j.c().a(f10663b, String.format("API version too low. Cannot convert network type value %s", kVar), new Throwable[0]);
        return 1;
    }

    static void d(JobInfo.Builder builder, v.k kVar) {
        if (Build.VERSION.SDK_INT < 30 || kVar != v.k.TEMPORARILY_UNMETERED) {
            builder.setRequiredNetworkType(c(kVar));
        } else {
            builder.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        }
    }

    JobInfo a(p pVar, int i6) {
        v.b bVar = pVar.f2867j;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", pVar.f2858a);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", pVar.d());
        JobInfo.Builder extras = new JobInfo.Builder(i6, this.f10664a).setRequiresCharging(bVar.g()).setRequiresDeviceIdle(bVar.h()).setExtras(persistableBundle);
        d(extras, bVar.b());
        if (!bVar.h()) {
            extras.setBackoffCriteria(pVar.f2870m, pVar.f2869l == v.a.LINEAR ? 0 : 1);
        }
        long max = Math.max(pVar.a() - System.currentTimeMillis(), 0L);
        int i7 = Build.VERSION.SDK_INT;
        if (i7 <= 28 || max > 0) {
            extras.setMinimumLatency(max);
        } else if (!pVar.f2874q) {
            extras.setImportantWhileForeground(true);
        }
        if (i7 >= 24 && bVar.e()) {
            Iterator<c.a> it = bVar.a().b().iterator();
            while (it.hasNext()) {
                extras.addTriggerContentUri(b(it.next()));
            }
            extras.setTriggerContentUpdateDelay(bVar.c());
            extras.setTriggerContentMaxDelay(bVar.d());
        }
        extras.setPersisted(false);
        if (Build.VERSION.SDK_INT >= 26) {
            extras.setRequiresBatteryNotLow(bVar.f());
            extras.setRequiresStorageNotLow(bVar.i());
        }
        boolean z5 = pVar.f2868k > 0;
        boolean z6 = max > 0;
        if (androidx.core.os.a.c() && pVar.f2874q && !z5 && !z6) {
            extras.setExpedited(true);
        }
        return extras.build();
    }
}

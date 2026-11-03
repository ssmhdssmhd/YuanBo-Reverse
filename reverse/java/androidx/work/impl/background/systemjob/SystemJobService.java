package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.net.Network;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.WorkerParameters;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import v.j;
import w.b;

/* loaded from: classes.dex */
public class SystemJobService extends JobService implements b {

    /* renamed from: c, reason: collision with root package name */
    private static final String f1583c = j.f("SystemJobService");

    /* renamed from: a, reason: collision with root package name */
    private w.j f1584a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, JobParameters> f1585b = new HashMap();

    private static String b(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return extras.getString("EXTRA_WORK_SPEC_ID");
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // w.b
    public void a(String str, boolean z5) {
        JobParameters remove;
        j.c().a(f1583c, String.format("%s executed on JobScheduler", str), new Throwable[0]);
        synchronized (this.f1585b) {
            remove = this.f1585b.remove(str);
        }
        if (remove != null) {
            jobFinished(remove, z5);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            w.j l6 = w.j.l(getApplicationContext());
            this.f1584a = l6;
            l6.n().d(this);
        } catch (IllegalStateException unused) {
            if (!Application.class.equals(getApplication().getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
            }
            j.c().h(f1583c, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        w.j jVar = this.f1584a;
        if (jVar != null) {
            jVar.n().i(this);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        WorkerParameters.a aVar;
        Uri[] triggeredContentUris;
        String[] triggeredContentAuthorities;
        Network network;
        String[] triggeredContentAuthorities2;
        Uri[] triggeredContentUris2;
        if (this.f1584a == null) {
            j.c().a(f1583c, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            jobFinished(jobParameters, true);
            return false;
        }
        String b6 = b(jobParameters);
        if (TextUtils.isEmpty(b6)) {
            j.c().b(f1583c, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        synchronized (this.f1585b) {
            if (this.f1585b.containsKey(b6)) {
                j.c().a(f1583c, String.format("Job is already being executed by SystemJobService: %s", b6), new Throwable[0]);
                return false;
            }
            j.c().a(f1583c, String.format("onStartJob for %s", b6), new Throwable[0]);
            this.f1585b.put(b6, jobParameters);
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 24) {
                aVar = new WorkerParameters.a();
                triggeredContentUris = jobParameters.getTriggeredContentUris();
                if (triggeredContentUris != null) {
                    triggeredContentUris2 = jobParameters.getTriggeredContentUris();
                    aVar.f1486b = Arrays.asList(triggeredContentUris2);
                }
                triggeredContentAuthorities = jobParameters.getTriggeredContentAuthorities();
                if (triggeredContentAuthorities != null) {
                    triggeredContentAuthorities2 = jobParameters.getTriggeredContentAuthorities();
                    aVar.f1485a = Arrays.asList(triggeredContentAuthorities2);
                }
                if (i6 >= 28) {
                    network = jobParameters.getNetwork();
                    aVar.f1487c = network;
                }
            } else {
                aVar = null;
            }
            this.f1584a.w(b6, aVar);
            return true;
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        if (this.f1584a == null) {
            j.c().a(f1583c, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String b6 = b(jobParameters);
        if (TextUtils.isEmpty(b6)) {
            j.c().b(f1583c, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        j.c().a(f1583c, String.format("onStopJob for %s", b6), new Throwable[0]);
        synchronized (this.f1585b) {
            this.f1585b.remove(b6);
        }
        this.f1584a.y(b6);
        return !this.f1584a.n().f(b6);
    }
}

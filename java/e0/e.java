package e0;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.impl.WorkDatabase;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final WorkDatabase f3319a;

    public e(WorkDatabase workDatabase) {
        this.f3319a = workDatabase;
    }

    public static void a(Context context, q.b bVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.id", 0);
        if (sharedPreferences.contains("next_job_scheduler_id") || sharedPreferences.contains("next_job_scheduler_id")) {
            int i6 = sharedPreferences.getInt("next_job_scheduler_id", 0);
            int i7 = sharedPreferences.getInt("next_alarm_manager_id", 0);
            bVar.f();
            try {
                bVar.L("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i6)});
                bVar.L("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i7)});
                sharedPreferences.edit().clear().apply();
                bVar.J();
            } finally {
                bVar.e();
            }
        }
    }

    private int c(String str) {
        this.f3319a.c();
        try {
            Long a6 = this.f3319a.z().a(str);
            int i6 = 0;
            int intValue = a6 != null ? a6.intValue() : 0;
            if (intValue != Integer.MAX_VALUE) {
                i6 = intValue + 1;
            }
            e(str, i6);
            this.f3319a.t();
            return intValue;
        } finally {
            this.f3319a.g();
        }
    }

    private void e(String str, int i6) {
        this.f3319a.z().b(new d0.d(str, i6));
    }

    public int b() {
        int c6;
        synchronized (e.class) {
            c6 = c("next_alarm_manager_id");
        }
        return c6;
    }

    public int d(int i6, int i7) {
        synchronized (e.class) {
            int c6 = c("next_job_scheduler_id");
            if (c6 >= i6 && c6 <= i7) {
                i6 = c6;
            }
            e("next_job_scheduler_id", i6 + 1);
        }
        return i6;
    }
}

package e0;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.impl.WorkDatabase;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final WorkDatabase f3328a;

    public h(WorkDatabase workDatabase) {
        this.f3328a = workDatabase;
    }

    public static void b(Context context, q.b bVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
        if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
            long j6 = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
            long j7 = sharedPreferences.getBoolean("reschedule_needed", false) ? 1L : 0L;
            bVar.f();
            try {
                bVar.L("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j6)});
                bVar.L("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j7)});
                sharedPreferences.edit().clear().apply();
                bVar.J();
            } finally {
                bVar.e();
            }
        }
    }

    public boolean a() {
        Long a6 = this.f3328a.z().a("reschedule_needed");
        return a6 != null && a6.longValue() == 1;
    }

    public void c(boolean z5) {
        this.f3328a.z().b(new d0.d("reschedule_needed", z5));
    }
}

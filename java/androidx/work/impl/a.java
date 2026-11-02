package androidx.work.impl;

import android.content.Context;
import android.os.Build;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static o.a f1526a = new C0030a(1, 2);

    /* renamed from: b, reason: collision with root package name */
    public static o.a f1527b = new b(3, 4);

    /* renamed from: c, reason: collision with root package name */
    public static o.a f1528c = new c(4, 5);

    /* renamed from: d, reason: collision with root package name */
    public static o.a f1529d = new d(6, 7);

    /* renamed from: e, reason: collision with root package name */
    public static o.a f1530e = new e(7, 8);

    /* renamed from: f, reason: collision with root package name */
    public static o.a f1531f = new f(8, 9);

    /* renamed from: g, reason: collision with root package name */
    public static o.a f1532g = new g(11, 12);

    /* renamed from: androidx.work.impl.a$a, reason: collision with other inner class name */
    class C0030a extends o.a {
        C0030a(int i6, int i7) {
            super(i6, i7);
        }

        @Override // o.a
        public void a(q.b bVar) {
            bVar.l("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.l("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
            bVar.l("DROP TABLE IF EXISTS alarmInfo");
            bVar.l("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    }

    class b extends o.a {
        b(int i6, int i7) {
            super(i6, i7);
        }

        @Override // o.a
        public void a(q.b bVar) {
            if (Build.VERSION.SDK_INT >= 23) {
                bVar.l("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
            }
        }
    }

    class c extends o.a {
        c(int i6, int i7) {
            super(i6, i7);
        }

        @Override // o.a
        public void a(q.b bVar) {
            bVar.l("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
            bVar.l("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
        }
    }

    class d extends o.a {
        d(int i6, int i7) {
            super(i6, i7);
        }

        @Override // o.a
        public void a(q.b bVar) {
            bVar.l("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        }
    }

    class e extends o.a {
        e(int i6, int i7) {
            super(i6, i7);
        }

        @Override // o.a
        public void a(q.b bVar) {
            bVar.l("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
        }
    }

    class f extends o.a {
        f(int i6, int i7) {
            super(i6, i7);
        }

        @Override // o.a
        public void a(q.b bVar) {
            bVar.l("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
        }
    }

    class g extends o.a {
        g(int i6, int i7) {
            super(i6, i7);
        }

        @Override // o.a
        public void a(q.b bVar) {
            bVar.l("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
        }
    }

    public static class h extends o.a {

        /* renamed from: c, reason: collision with root package name */
        final Context f1533c;

        public h(Context context, int i6, int i7) {
            super(i6, i7);
            this.f1533c = context;
        }

        @Override // o.a
        public void a(q.b bVar) {
            if (this.f8302b >= 10) {
                bVar.L("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
            } else {
                this.f1533c.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
            }
        }
    }

    public static class i extends o.a {

        /* renamed from: c, reason: collision with root package name */
        final Context f1534c;

        public i(Context context) {
            super(9, 10);
            this.f1534c = context;
        }

        @Override // o.a
        public void a(q.b bVar) {
            bVar.l("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            e0.h.b(this.f1534c, bVar);
            e0.e.a(this.f1534c, bVar);
        }
    }
}

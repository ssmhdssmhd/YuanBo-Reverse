package d0;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import d0.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import v.s;

/* loaded from: classes.dex */
public final class r implements q {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.room.h f2884a;

    /* renamed from: b, reason: collision with root package name */
    private final n.a<p> f2885b;

    /* renamed from: c, reason: collision with root package name */
    private final n.d f2886c;

    /* renamed from: d, reason: collision with root package name */
    private final n.d f2887d;

    /* renamed from: e, reason: collision with root package name */
    private final n.d f2888e;

    /* renamed from: f, reason: collision with root package name */
    private final n.d f2889f;

    /* renamed from: g, reason: collision with root package name */
    private final n.d f2890g;

    /* renamed from: h, reason: collision with root package name */
    private final n.d f2891h;

    /* renamed from: i, reason: collision with root package name */
    private final n.d f2892i;

    /* renamed from: j, reason: collision with root package name */
    private final n.d f2893j;

    class a implements Callable<List<p.c>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n.c f2894a;

        a(n.c cVar) {
            this.f2894a = cVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<p.c> call() {
            r.this.f2884a.c();
            try {
                Cursor b6 = p.c.b(r.this.f2884a, this.f2894a, true, null);
                try {
                    int c6 = p.b.c(b6, "id");
                    int c7 = p.b.c(b6, "state");
                    int c8 = p.b.c(b6, "output");
                    int c9 = p.b.c(b6, "run_attempt_count");
                    f.a aVar = new f.a();
                    f.a aVar2 = new f.a();
                    while (b6.moveToNext()) {
                        if (!b6.isNull(c6)) {
                            String string = b6.getString(c6);
                            if (((ArrayList) aVar.get(string)) == null) {
                                aVar.put(string, new ArrayList());
                            }
                        }
                        if (!b6.isNull(c6)) {
                            String string2 = b6.getString(c6);
                            if (((ArrayList) aVar2.get(string2)) == null) {
                                aVar2.put(string2, new ArrayList());
                            }
                        }
                    }
                    b6.moveToPosition(-1);
                    r.this.x(aVar);
                    r.this.w(aVar2);
                    ArrayList arrayList = new ArrayList(b6.getCount());
                    while (b6.moveToNext()) {
                        ArrayList arrayList2 = !b6.isNull(c6) ? (ArrayList) aVar.get(b6.getString(c6)) : null;
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = !b6.isNull(c6) ? (ArrayList) aVar2.get(b6.getString(c6)) : null;
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        p.c cVar = new p.c();
                        cVar.f2878a = b6.getString(c6);
                        cVar.f2879b = v.g(b6.getInt(c7));
                        cVar.f2880c = androidx.work.b.g(b6.getBlob(c8));
                        cVar.f2881d = b6.getInt(c9);
                        cVar.f2882e = arrayList2;
                        cVar.f2883f = arrayList3;
                        arrayList.add(cVar);
                    }
                    r.this.f2884a.t();
                    return arrayList;
                } finally {
                    b6.close();
                }
            } finally {
                r.this.f2884a.g();
            }
        }

        protected void finalize() {
            this.f2894a.t();
        }
    }

    class b extends n.a<p> {
        b(androidx.room.h hVar) {
            super(hVar);
        }

        @Override // n.d
        public String d() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // n.a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(q.f fVar, p pVar) {
            String str = pVar.f2858a;
            if (str == null) {
                fVar.r(1);
            } else {
                fVar.m(1, str);
            }
            fVar.H(2, v.j(pVar.f2859b));
            String str2 = pVar.f2860c;
            if (str2 == null) {
                fVar.r(3);
            } else {
                fVar.m(3, str2);
            }
            String str3 = pVar.f2861d;
            if (str3 == null) {
                fVar.r(4);
            } else {
                fVar.m(4, str3);
            }
            byte[] l6 = androidx.work.b.l(pVar.f2862e);
            if (l6 == null) {
                fVar.r(5);
            } else {
                fVar.O(5, l6);
            }
            byte[] l7 = androidx.work.b.l(pVar.f2863f);
            if (l7 == null) {
                fVar.r(6);
            } else {
                fVar.O(6, l7);
            }
            fVar.H(7, pVar.f2864g);
            fVar.H(8, pVar.f2865h);
            fVar.H(9, pVar.f2866i);
            fVar.H(10, pVar.f2868k);
            fVar.H(11, v.a(pVar.f2869l));
            fVar.H(12, pVar.f2870m);
            fVar.H(13, pVar.f2871n);
            fVar.H(14, pVar.f2872o);
            fVar.H(15, pVar.f2873p);
            fVar.H(16, pVar.f2874q ? 1L : 0L);
            fVar.H(17, v.i(pVar.f2875r));
            v.b bVar = pVar.f2867j;
            if (bVar != null) {
                fVar.H(18, v.h(bVar.b()));
                fVar.H(19, bVar.g() ? 1L : 0L);
                fVar.H(20, bVar.h() ? 1L : 0L);
                fVar.H(21, bVar.f() ? 1L : 0L);
                fVar.H(22, bVar.i() ? 1L : 0L);
                fVar.H(23, bVar.c());
                fVar.H(24, bVar.d());
                byte[] c6 = v.c(bVar.a());
                if (c6 != null) {
                    fVar.O(25, c6);
                    return;
                }
            } else {
                fVar.r(18);
                fVar.r(19);
                fVar.r(20);
                fVar.r(21);
                fVar.r(22);
                fVar.r(23);
                fVar.r(24);
            }
            fVar.r(25);
        }
    }

    class c extends n.d {
        c(androidx.room.h hVar) {
            super(hVar);
        }

        @Override // n.d
        public String d() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    class d extends n.d {
        d(androidx.room.h hVar) {
            super(hVar);
        }

        @Override // n.d
        public String d() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    class e extends n.d {
        e(androidx.room.h hVar) {
            super(hVar);
        }

        @Override // n.d
        public String d() {
            return "UPDATE workspec SET period_start_time=? WHERE id=?";
        }
    }

    class f extends n.d {
        f(androidx.room.h hVar) {
            super(hVar);
        }

        @Override // n.d
        public String d() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    class g extends n.d {
        g(androidx.room.h hVar) {
            super(hVar);
        }

        @Override // n.d
        public String d() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    class h extends n.d {
        h(androidx.room.h hVar) {
            super(hVar);
        }

        @Override // n.d
        public String d() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    class i extends n.d {
        i(androidx.room.h hVar) {
            super(hVar);
        }

        @Override // n.d
        public String d() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    class j extends n.d {
        j(androidx.room.h hVar) {
            super(hVar);
        }

        @Override // n.d
        public String d() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    public r(androidx.room.h hVar) {
        this.f2884a = hVar;
        this.f2885b = new b(hVar);
        this.f2886c = new c(hVar);
        this.f2887d = new d(hVar);
        this.f2888e = new e(hVar);
        this.f2889f = new f(hVar);
        this.f2890g = new g(hVar);
        this.f2891h = new h(hVar);
        this.f2892i = new i(hVar);
        this.f2893j = new j(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(f.a<String, ArrayList<androidx.work.b>> aVar) {
        ArrayList<androidx.work.b> arrayList;
        int i6;
        Set<String> keySet = aVar.keySet();
        if (keySet.isEmpty()) {
            return;
        }
        if (aVar.size() > 999) {
            f.a<String, ArrayList<androidx.work.b>> aVar2 = new f.a<>(999);
            int size = aVar.size();
            int i7 = 0;
            loop0: while (true) {
                i6 = 0;
                while (i7 < size) {
                    aVar2.put(aVar.i(i7), aVar.l(i7));
                    i7++;
                    i6++;
                    if (i6 == 999) {
                        break;
                    }
                }
                w(aVar2);
                aVar2 = new f.a<>(999);
            }
            if (i6 > 0) {
                w(aVar2);
                return;
            }
            return;
        }
        StringBuilder b6 = p.e.b();
        b6.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int size2 = keySet.size();
        p.e.a(b6, size2);
        b6.append(")");
        n.c k6 = n.c.k(b6.toString(), size2 + 0);
        int i8 = 1;
        for (String str : keySet) {
            if (str == null) {
                k6.r(i8);
            } else {
                k6.m(i8, str);
            }
            i8++;
        }
        Cursor b7 = p.c.b(this.f2884a, k6, false, null);
        try {
            int b8 = p.b.b(b7, "work_spec_id");
            if (b8 == -1) {
                return;
            }
            while (b7.moveToNext()) {
                if (!b7.isNull(b8) && (arrayList = aVar.get(b7.getString(b8))) != null) {
                    arrayList.add(androidx.work.b.g(b7.getBlob(0)));
                }
            }
        } finally {
            b7.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(f.a<String, ArrayList<String>> aVar) {
        ArrayList<String> arrayList;
        int i6;
        Set<String> keySet = aVar.keySet();
        if (keySet.isEmpty()) {
            return;
        }
        if (aVar.size() > 999) {
            f.a<String, ArrayList<String>> aVar2 = new f.a<>(999);
            int size = aVar.size();
            int i7 = 0;
            loop0: while (true) {
                i6 = 0;
                while (i7 < size) {
                    aVar2.put(aVar.i(i7), aVar.l(i7));
                    i7++;
                    i6++;
                    if (i6 == 999) {
                        break;
                    }
                }
                x(aVar2);
                aVar2 = new f.a<>(999);
            }
            if (i6 > 0) {
                x(aVar2);
                return;
            }
            return;
        }
        StringBuilder b6 = p.e.b();
        b6.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int size2 = keySet.size();
        p.e.a(b6, size2);
        b6.append(")");
        n.c k6 = n.c.k(b6.toString(), size2 + 0);
        int i8 = 1;
        for (String str : keySet) {
            if (str == null) {
                k6.r(i8);
            } else {
                k6.m(i8, str);
            }
            i8++;
        }
        Cursor b7 = p.c.b(this.f2884a, k6, false, null);
        try {
            int b8 = p.b.b(b7, "work_spec_id");
            if (b8 == -1) {
                return;
            }
            while (b7.moveToNext()) {
                if (!b7.isNull(b8) && (arrayList = aVar.get(b7.getString(b8))) != null) {
                    arrayList.add(b7.getString(0));
                }
            }
        } finally {
            b7.close();
        }
    }

    @Override // d0.q
    public void a(String str) {
        this.f2884a.b();
        q.f a6 = this.f2886c.a();
        if (str == null) {
            a6.r(1);
        } else {
            a6.m(1, str);
        }
        this.f2884a.c();
        try {
            a6.o();
            this.f2884a.t();
        } finally {
            this.f2884a.g();
            this.f2886c.f(a6);
        }
    }

    @Override // d0.q
    public List<p> b() {
        n.c cVar;
        n.c k6 = n.c.k("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1", 0);
        this.f2884a.b();
        Cursor b6 = p.c.b(this.f2884a, k6, false, null);
        try {
            int c6 = p.b.c(b6, "required_network_type");
            int c7 = p.b.c(b6, "requires_charging");
            int c8 = p.b.c(b6, "requires_device_idle");
            int c9 = p.b.c(b6, "requires_battery_not_low");
            int c10 = p.b.c(b6, "requires_storage_not_low");
            int c11 = p.b.c(b6, "trigger_content_update_delay");
            int c12 = p.b.c(b6, "trigger_max_content_delay");
            int c13 = p.b.c(b6, "content_uri_triggers");
            int c14 = p.b.c(b6, "id");
            int c15 = p.b.c(b6, "state");
            int c16 = p.b.c(b6, "worker_class_name");
            int c17 = p.b.c(b6, "input_merger_class_name");
            int c18 = p.b.c(b6, "input");
            int c19 = p.b.c(b6, "output");
            cVar = k6;
            try {
                int c20 = p.b.c(b6, "initial_delay");
                int c21 = p.b.c(b6, "interval_duration");
                int c22 = p.b.c(b6, "flex_duration");
                int c23 = p.b.c(b6, "run_attempt_count");
                int c24 = p.b.c(b6, "backoff_policy");
                int c25 = p.b.c(b6, "backoff_delay_duration");
                int c26 = p.b.c(b6, "period_start_time");
                int c27 = p.b.c(b6, "minimum_retention_duration");
                int c28 = p.b.c(b6, "schedule_requested_at");
                int c29 = p.b.c(b6, "run_in_foreground");
                int c30 = p.b.c(b6, "out_of_quota_policy");
                int i6 = c19;
                ArrayList arrayList = new ArrayList(b6.getCount());
                while (b6.moveToNext()) {
                    String string = b6.getString(c14);
                    int i7 = c14;
                    String string2 = b6.getString(c16);
                    int i8 = c16;
                    v.b bVar = new v.b();
                    int i9 = c6;
                    bVar.k(v.e(b6.getInt(c6)));
                    bVar.m(b6.getInt(c7) != 0);
                    bVar.n(b6.getInt(c8) != 0);
                    bVar.l(b6.getInt(c9) != 0);
                    bVar.o(b6.getInt(c10) != 0);
                    int i10 = c7;
                    int i11 = c8;
                    bVar.p(b6.getLong(c11));
                    bVar.q(b6.getLong(c12));
                    bVar.j(v.b(b6.getBlob(c13)));
                    p pVar = new p(string, string2);
                    pVar.f2859b = v.g(b6.getInt(c15));
                    pVar.f2861d = b6.getString(c17);
                    pVar.f2862e = androidx.work.b.g(b6.getBlob(c18));
                    int i12 = i6;
                    pVar.f2863f = androidx.work.b.g(b6.getBlob(i12));
                    i6 = i12;
                    int i13 = c20;
                    pVar.f2864g = b6.getLong(i13);
                    int i14 = c18;
                    int i15 = c21;
                    pVar.f2865h = b6.getLong(i15);
                    int i16 = c9;
                    int i17 = c22;
                    pVar.f2866i = b6.getLong(i17);
                    int i18 = c23;
                    pVar.f2868k = b6.getInt(i18);
                    int i19 = c24;
                    pVar.f2869l = v.d(b6.getInt(i19));
                    c22 = i17;
                    int i20 = c25;
                    pVar.f2870m = b6.getLong(i20);
                    int i21 = c26;
                    pVar.f2871n = b6.getLong(i21);
                    c26 = i21;
                    int i22 = c27;
                    pVar.f2872o = b6.getLong(i22);
                    int i23 = c28;
                    pVar.f2873p = b6.getLong(i23);
                    int i24 = c29;
                    pVar.f2874q = b6.getInt(i24) != 0;
                    int i25 = c30;
                    pVar.f2875r = v.f(b6.getInt(i25));
                    pVar.f2867j = bVar;
                    arrayList.add(pVar);
                    c30 = i25;
                    c7 = i10;
                    c18 = i14;
                    c20 = i13;
                    c21 = i15;
                    c23 = i18;
                    c28 = i23;
                    c14 = i7;
                    c16 = i8;
                    c6 = i9;
                    c29 = i24;
                    c27 = i22;
                    c8 = i11;
                    c25 = i20;
                    c9 = i16;
                    c24 = i19;
                }
                b6.close();
                cVar.t();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b6.close();
                cVar.t();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cVar = k6;
        }
    }

    @Override // d0.q
    public int c(s.a aVar, String... strArr) {
        this.f2884a.b();
        StringBuilder b6 = p.e.b();
        b6.append("UPDATE workspec SET state=");
        b6.append("?");
        b6.append(" WHERE id IN (");
        p.e.a(b6, strArr.length);
        b6.append(")");
        q.f d6 = this.f2884a.d(b6.toString());
        d6.H(1, v.j(aVar));
        int i6 = 2;
        for (String str : strArr) {
            if (str == null) {
                d6.r(i6);
            } else {
                d6.m(i6, str);
            }
            i6++;
        }
        this.f2884a.c();
        try {
            int o6 = d6.o();
            this.f2884a.t();
            return o6;
        } finally {
            this.f2884a.g();
        }
    }

    @Override // d0.q
    public boolean d() {
        boolean z5 = false;
        n.c k6 = n.c.k("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.f2884a.b();
        Cursor b6 = p.c.b(this.f2884a, k6, false, null);
        try {
            if (b6.moveToFirst()) {
                if (b6.getInt(0) != 0) {
                    z5 = true;
                }
            }
            return z5;
        } finally {
            b6.close();
            k6.t();
        }
    }

    @Override // d0.q
    public int e(String str, long j6) {
        this.f2884a.b();
        q.f a6 = this.f2891h.a();
        a6.H(1, j6);
        if (str == null) {
            a6.r(2);
        } else {
            a6.m(2, str);
        }
        this.f2884a.c();
        try {
            int o6 = a6.o();
            this.f2884a.t();
            return o6;
        } finally {
            this.f2884a.g();
            this.f2891h.f(a6);
        }
    }

    @Override // d0.q
    public List<String> f(String str) {
        n.c k6 = n.c.k("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            k6.r(1);
        } else {
            k6.m(1, str);
        }
        this.f2884a.b();
        Cursor b6 = p.c.b(this.f2884a, k6, false, null);
        try {
            ArrayList arrayList = new ArrayList(b6.getCount());
            while (b6.moveToNext()) {
                arrayList.add(b6.getString(0));
            }
            return arrayList;
        } finally {
            b6.close();
            k6.t();
        }
    }

    @Override // d0.q
    public List<p.b> g(String str) {
        n.c k6 = n.c.k("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            k6.r(1);
        } else {
            k6.m(1, str);
        }
        this.f2884a.b();
        Cursor b6 = p.c.b(this.f2884a, k6, false, null);
        try {
            int c6 = p.b.c(b6, "id");
            int c7 = p.b.c(b6, "state");
            ArrayList arrayList = new ArrayList(b6.getCount());
            while (b6.moveToNext()) {
                p.b bVar = new p.b();
                bVar.f2876a = b6.getString(c6);
                bVar.f2877b = v.g(b6.getInt(c7));
                arrayList.add(bVar);
            }
            return arrayList;
        } finally {
            b6.close();
            k6.t();
        }
    }

    @Override // d0.q
    public List<p> h(long j6) {
        n.c cVar;
        n.c k6 = n.c.k("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        k6.H(1, j6);
        this.f2884a.b();
        Cursor b6 = p.c.b(this.f2884a, k6, false, null);
        try {
            int c6 = p.b.c(b6, "required_network_type");
            int c7 = p.b.c(b6, "requires_charging");
            int c8 = p.b.c(b6, "requires_device_idle");
            int c9 = p.b.c(b6, "requires_battery_not_low");
            int c10 = p.b.c(b6, "requires_storage_not_low");
            int c11 = p.b.c(b6, "trigger_content_update_delay");
            int c12 = p.b.c(b6, "trigger_max_content_delay");
            int c13 = p.b.c(b6, "content_uri_triggers");
            int c14 = p.b.c(b6, "id");
            int c15 = p.b.c(b6, "state");
            int c16 = p.b.c(b6, "worker_class_name");
            int c17 = p.b.c(b6, "input_merger_class_name");
            int c18 = p.b.c(b6, "input");
            int c19 = p.b.c(b6, "output");
            cVar = k6;
            try {
                int c20 = p.b.c(b6, "initial_delay");
                int c21 = p.b.c(b6, "interval_duration");
                int c22 = p.b.c(b6, "flex_duration");
                int c23 = p.b.c(b6, "run_attempt_count");
                int c24 = p.b.c(b6, "backoff_policy");
                int c25 = p.b.c(b6, "backoff_delay_duration");
                int c26 = p.b.c(b6, "period_start_time");
                int c27 = p.b.c(b6, "minimum_retention_duration");
                int c28 = p.b.c(b6, "schedule_requested_at");
                int c29 = p.b.c(b6, "run_in_foreground");
                int c30 = p.b.c(b6, "out_of_quota_policy");
                int i6 = c19;
                ArrayList arrayList = new ArrayList(b6.getCount());
                while (b6.moveToNext()) {
                    String string = b6.getString(c14);
                    int i7 = c14;
                    String string2 = b6.getString(c16);
                    int i8 = c16;
                    v.b bVar = new v.b();
                    int i9 = c6;
                    bVar.k(v.e(b6.getInt(c6)));
                    bVar.m(b6.getInt(c7) != 0);
                    bVar.n(b6.getInt(c8) != 0);
                    bVar.l(b6.getInt(c9) != 0);
                    bVar.o(b6.getInt(c10) != 0);
                    int i10 = c7;
                    int i11 = c8;
                    bVar.p(b6.getLong(c11));
                    bVar.q(b6.getLong(c12));
                    bVar.j(v.b(b6.getBlob(c13)));
                    p pVar = new p(string, string2);
                    pVar.f2859b = v.g(b6.getInt(c15));
                    pVar.f2861d = b6.getString(c17);
                    pVar.f2862e = androidx.work.b.g(b6.getBlob(c18));
                    int i12 = i6;
                    pVar.f2863f = androidx.work.b.g(b6.getBlob(i12));
                    int i13 = c20;
                    i6 = i12;
                    pVar.f2864g = b6.getLong(i13);
                    int i14 = c17;
                    int i15 = c21;
                    pVar.f2865h = b6.getLong(i15);
                    int i16 = c9;
                    int i17 = c22;
                    pVar.f2866i = b6.getLong(i17);
                    int i18 = c23;
                    pVar.f2868k = b6.getInt(i18);
                    int i19 = c24;
                    pVar.f2869l = v.d(b6.getInt(i19));
                    c22 = i17;
                    int i20 = c25;
                    pVar.f2870m = b6.getLong(i20);
                    int i21 = c26;
                    pVar.f2871n = b6.getLong(i21);
                    c26 = i21;
                    int i22 = c27;
                    pVar.f2872o = b6.getLong(i22);
                    int i23 = c28;
                    pVar.f2873p = b6.getLong(i23);
                    int i24 = c29;
                    pVar.f2874q = b6.getInt(i24) != 0;
                    int i25 = c30;
                    pVar.f2875r = v.f(b6.getInt(i25));
                    pVar.f2867j = bVar;
                    arrayList.add(pVar);
                    c7 = i10;
                    c30 = i25;
                    c17 = i14;
                    c20 = i13;
                    c21 = i15;
                    c23 = i18;
                    c28 = i23;
                    c14 = i7;
                    c16 = i8;
                    c6 = i9;
                    c29 = i24;
                    c27 = i22;
                    c8 = i11;
                    c25 = i20;
                    c9 = i16;
                    c24 = i19;
                }
                b6.close();
                cVar.t();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b6.close();
                cVar.t();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cVar = k6;
        }
    }

    @Override // d0.q
    public void i(p pVar) {
        this.f2884a.b();
        this.f2884a.c();
        try {
            this.f2885b.h(pVar);
            this.f2884a.t();
        } finally {
            this.f2884a.g();
        }
    }

    @Override // d0.q
    public s.a j(String str) {
        n.c k6 = n.c.k("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            k6.r(1);
        } else {
            k6.m(1, str);
        }
        this.f2884a.b();
        Cursor b6 = p.c.b(this.f2884a, k6, false, null);
        try {
            return b6.moveToFirst() ? v.g(b6.getInt(0)) : null;
        } finally {
            b6.close();
            k6.t();
        }
    }

    @Override // d0.q
    public List<p> k(int i6) {
        n.c cVar;
        n.c k6 = n.c.k("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        k6.H(1, i6);
        this.f2884a.b();
        Cursor b6 = p.c.b(this.f2884a, k6, false, null);
        try {
            int c6 = p.b.c(b6, "required_network_type");
            int c7 = p.b.c(b6, "requires_charging");
            int c8 = p.b.c(b6, "requires_device_idle");
            int c9 = p.b.c(b6, "requires_battery_not_low");
            int c10 = p.b.c(b6, "requires_storage_not_low");
            int c11 = p.b.c(b6, "trigger_content_update_delay");
            int c12 = p.b.c(b6, "trigger_max_content_delay");
            int c13 = p.b.c(b6, "content_uri_triggers");
            int c14 = p.b.c(b6, "id");
            int c15 = p.b.c(b6, "state");
            int c16 = p.b.c(b6, "worker_class_name");
            int c17 = p.b.c(b6, "input_merger_class_name");
            int c18 = p.b.c(b6, "input");
            int c19 = p.b.c(b6, "output");
            cVar = k6;
            try {
                int c20 = p.b.c(b6, "initial_delay");
                int c21 = p.b.c(b6, "interval_duration");
                int c22 = p.b.c(b6, "flex_duration");
                int c23 = p.b.c(b6, "run_attempt_count");
                int c24 = p.b.c(b6, "backoff_policy");
                int c25 = p.b.c(b6, "backoff_delay_duration");
                int c26 = p.b.c(b6, "period_start_time");
                int c27 = p.b.c(b6, "minimum_retention_duration");
                int c28 = p.b.c(b6, "schedule_requested_at");
                int c29 = p.b.c(b6, "run_in_foreground");
                int c30 = p.b.c(b6, "out_of_quota_policy");
                int i7 = c19;
                ArrayList arrayList = new ArrayList(b6.getCount());
                while (b6.moveToNext()) {
                    String string = b6.getString(c14);
                    int i8 = c14;
                    String string2 = b6.getString(c16);
                    int i9 = c16;
                    v.b bVar = new v.b();
                    int i10 = c6;
                    bVar.k(v.e(b6.getInt(c6)));
                    bVar.m(b6.getInt(c7) != 0);
                    bVar.n(b6.getInt(c8) != 0);
                    bVar.l(b6.getInt(c9) != 0);
                    bVar.o(b6.getInt(c10) != 0);
                    int i11 = c7;
                    int i12 = c8;
                    bVar.p(b6.getLong(c11));
                    bVar.q(b6.getLong(c12));
                    bVar.j(v.b(b6.getBlob(c13)));
                    p pVar = new p(string, string2);
                    pVar.f2859b = v.g(b6.getInt(c15));
                    pVar.f2861d = b6.getString(c17);
                    pVar.f2862e = androidx.work.b.g(b6.getBlob(c18));
                    int i13 = i7;
                    pVar.f2863f = androidx.work.b.g(b6.getBlob(i13));
                    i7 = i13;
                    int i14 = c20;
                    pVar.f2864g = b6.getLong(i14);
                    int i15 = c17;
                    int i16 = c21;
                    pVar.f2865h = b6.getLong(i16);
                    int i17 = c9;
                    int i18 = c22;
                    pVar.f2866i = b6.getLong(i18);
                    int i19 = c23;
                    pVar.f2868k = b6.getInt(i19);
                    int i20 = c24;
                    pVar.f2869l = v.d(b6.getInt(i20));
                    c22 = i18;
                    int i21 = c25;
                    pVar.f2870m = b6.getLong(i21);
                    int i22 = c26;
                    pVar.f2871n = b6.getLong(i22);
                    c26 = i22;
                    int i23 = c27;
                    pVar.f2872o = b6.getLong(i23);
                    int i24 = c28;
                    pVar.f2873p = b6.getLong(i24);
                    int i25 = c29;
                    pVar.f2874q = b6.getInt(i25) != 0;
                    int i26 = c30;
                    pVar.f2875r = v.f(b6.getInt(i26));
                    pVar.f2867j = bVar;
                    arrayList.add(pVar);
                    c30 = i26;
                    c7 = i11;
                    c17 = i15;
                    c20 = i14;
                    c21 = i16;
                    c23 = i19;
                    c28 = i24;
                    c14 = i8;
                    c16 = i9;
                    c6 = i10;
                    c29 = i25;
                    c27 = i23;
                    c8 = i12;
                    c25 = i21;
                    c9 = i17;
                    c24 = i20;
                }
                b6.close();
                cVar.t();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b6.close();
                cVar.t();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cVar = k6;
        }
    }

    @Override // d0.q
    public p l(String str) {
        n.c cVar;
        p pVar;
        n.c k6 = n.c.k("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?", 1);
        if (str == null) {
            k6.r(1);
        } else {
            k6.m(1, str);
        }
        this.f2884a.b();
        Cursor b6 = p.c.b(this.f2884a, k6, false, null);
        try {
            int c6 = p.b.c(b6, "required_network_type");
            int c7 = p.b.c(b6, "requires_charging");
            int c8 = p.b.c(b6, "requires_device_idle");
            int c9 = p.b.c(b6, "requires_battery_not_low");
            int c10 = p.b.c(b6, "requires_storage_not_low");
            int c11 = p.b.c(b6, "trigger_content_update_delay");
            int c12 = p.b.c(b6, "trigger_max_content_delay");
            int c13 = p.b.c(b6, "content_uri_triggers");
            int c14 = p.b.c(b6, "id");
            int c15 = p.b.c(b6, "state");
            int c16 = p.b.c(b6, "worker_class_name");
            int c17 = p.b.c(b6, "input_merger_class_name");
            int c18 = p.b.c(b6, "input");
            int c19 = p.b.c(b6, "output");
            cVar = k6;
            try {
                int c20 = p.b.c(b6, "initial_delay");
                int c21 = p.b.c(b6, "interval_duration");
                int c22 = p.b.c(b6, "flex_duration");
                int c23 = p.b.c(b6, "run_attempt_count");
                int c24 = p.b.c(b6, "backoff_policy");
                int c25 = p.b.c(b6, "backoff_delay_duration");
                int c26 = p.b.c(b6, "period_start_time");
                int c27 = p.b.c(b6, "minimum_retention_duration");
                int c28 = p.b.c(b6, "schedule_requested_at");
                int c29 = p.b.c(b6, "run_in_foreground");
                int c30 = p.b.c(b6, "out_of_quota_policy");
                if (b6.moveToFirst()) {
                    String string = b6.getString(c14);
                    String string2 = b6.getString(c16);
                    v.b bVar = new v.b();
                    bVar.k(v.e(b6.getInt(c6)));
                    bVar.m(b6.getInt(c7) != 0);
                    bVar.n(b6.getInt(c8) != 0);
                    bVar.l(b6.getInt(c9) != 0);
                    bVar.o(b6.getInt(c10) != 0);
                    bVar.p(b6.getLong(c11));
                    bVar.q(b6.getLong(c12));
                    bVar.j(v.b(b6.getBlob(c13)));
                    p pVar2 = new p(string, string2);
                    pVar2.f2859b = v.g(b6.getInt(c15));
                    pVar2.f2861d = b6.getString(c17);
                    pVar2.f2862e = androidx.work.b.g(b6.getBlob(c18));
                    pVar2.f2863f = androidx.work.b.g(b6.getBlob(c19));
                    pVar2.f2864g = b6.getLong(c20);
                    pVar2.f2865h = b6.getLong(c21);
                    pVar2.f2866i = b6.getLong(c22);
                    pVar2.f2868k = b6.getInt(c23);
                    pVar2.f2869l = v.d(b6.getInt(c24));
                    pVar2.f2870m = b6.getLong(c25);
                    pVar2.f2871n = b6.getLong(c26);
                    pVar2.f2872o = b6.getLong(c27);
                    pVar2.f2873p = b6.getLong(c28);
                    pVar2.f2874q = b6.getInt(c29) != 0;
                    pVar2.f2875r = v.f(b6.getInt(c30));
                    pVar2.f2867j = bVar;
                    pVar = pVar2;
                } else {
                    pVar = null;
                }
                b6.close();
                cVar.t();
                return pVar;
            } catch (Throwable th) {
                th = th;
                b6.close();
                cVar.t();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cVar = k6;
        }
    }

    @Override // d0.q
    public int m(String str) {
        this.f2884a.b();
        q.f a6 = this.f2890g.a();
        if (str == null) {
            a6.r(1);
        } else {
            a6.m(1, str);
        }
        this.f2884a.c();
        try {
            int o6 = a6.o();
            this.f2884a.t();
            return o6;
        } finally {
            this.f2884a.g();
            this.f2890g.f(a6);
        }
    }

    @Override // d0.q
    public LiveData<List<p.c>> n(List<String> list) {
        StringBuilder b6 = p.e.b();
        b6.append("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (");
        int size = list.size();
        p.e.a(b6, size);
        b6.append(")");
        n.c k6 = n.c.k(b6.toString(), size + 0);
        int i6 = 1;
        for (String str : list) {
            if (str == null) {
                k6.r(i6);
            } else {
                k6.m(i6, str);
            }
            i6++;
        }
        return this.f2884a.i().d(new String[]{"WorkTag", "WorkProgress", "workspec"}, true, new a(k6));
    }

    @Override // d0.q
    public List<String> o(String str) {
        n.c k6 = n.c.k("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            k6.r(1);
        } else {
            k6.m(1, str);
        }
        this.f2884a.b();
        Cursor b6 = p.c.b(this.f2884a, k6, false, null);
        try {
            ArrayList arrayList = new ArrayList(b6.getCount());
            while (b6.moveToNext()) {
                arrayList.add(b6.getString(0));
            }
            return arrayList;
        } finally {
            b6.close();
            k6.t();
        }
    }

    @Override // d0.q
    public List<androidx.work.b> p(String str) {
        n.c k6 = n.c.k("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            k6.r(1);
        } else {
            k6.m(1, str);
        }
        this.f2884a.b();
        Cursor b6 = p.c.b(this.f2884a, k6, false, null);
        try {
            ArrayList arrayList = new ArrayList(b6.getCount());
            while (b6.moveToNext()) {
                arrayList.add(androidx.work.b.g(b6.getBlob(0)));
            }
            return arrayList;
        } finally {
            b6.close();
            k6.t();
        }
    }

    @Override // d0.q
    public int q(String str) {
        this.f2884a.b();
        q.f a6 = this.f2889f.a();
        if (str == null) {
            a6.r(1);
        } else {
            a6.m(1, str);
        }
        this.f2884a.c();
        try {
            int o6 = a6.o();
            this.f2884a.t();
            return o6;
        } finally {
            this.f2884a.g();
            this.f2889f.f(a6);
        }
    }

    @Override // d0.q
    public void r(String str, long j6) {
        this.f2884a.b();
        q.f a6 = this.f2888e.a();
        a6.H(1, j6);
        if (str == null) {
            a6.r(2);
        } else {
            a6.m(2, str);
        }
        this.f2884a.c();
        try {
            a6.o();
            this.f2884a.t();
        } finally {
            this.f2884a.g();
            this.f2888e.f(a6);
        }
    }

    @Override // d0.q
    public List<p> s() {
        n.c cVar;
        n.c k6 = n.c.k("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.f2884a.b();
        Cursor b6 = p.c.b(this.f2884a, k6, false, null);
        try {
            int c6 = p.b.c(b6, "required_network_type");
            int c7 = p.b.c(b6, "requires_charging");
            int c8 = p.b.c(b6, "requires_device_idle");
            int c9 = p.b.c(b6, "requires_battery_not_low");
            int c10 = p.b.c(b6, "requires_storage_not_low");
            int c11 = p.b.c(b6, "trigger_content_update_delay");
            int c12 = p.b.c(b6, "trigger_max_content_delay");
            int c13 = p.b.c(b6, "content_uri_triggers");
            int c14 = p.b.c(b6, "id");
            int c15 = p.b.c(b6, "state");
            int c16 = p.b.c(b6, "worker_class_name");
            int c17 = p.b.c(b6, "input_merger_class_name");
            int c18 = p.b.c(b6, "input");
            int c19 = p.b.c(b6, "output");
            cVar = k6;
            try {
                int c20 = p.b.c(b6, "initial_delay");
                int c21 = p.b.c(b6, "interval_duration");
                int c22 = p.b.c(b6, "flex_duration");
                int c23 = p.b.c(b6, "run_attempt_count");
                int c24 = p.b.c(b6, "backoff_policy");
                int c25 = p.b.c(b6, "backoff_delay_duration");
                int c26 = p.b.c(b6, "period_start_time");
                int c27 = p.b.c(b6, "minimum_retention_duration");
                int c28 = p.b.c(b6, "schedule_requested_at");
                int c29 = p.b.c(b6, "run_in_foreground");
                int c30 = p.b.c(b6, "out_of_quota_policy");
                int i6 = c19;
                ArrayList arrayList = new ArrayList(b6.getCount());
                while (b6.moveToNext()) {
                    String string = b6.getString(c14);
                    int i7 = c14;
                    String string2 = b6.getString(c16);
                    int i8 = c16;
                    v.b bVar = new v.b();
                    int i9 = c6;
                    bVar.k(v.e(b6.getInt(c6)));
                    bVar.m(b6.getInt(c7) != 0);
                    bVar.n(b6.getInt(c8) != 0);
                    bVar.l(b6.getInt(c9) != 0);
                    bVar.o(b6.getInt(c10) != 0);
                    int i10 = c7;
                    int i11 = c8;
                    bVar.p(b6.getLong(c11));
                    bVar.q(b6.getLong(c12));
                    bVar.j(v.b(b6.getBlob(c13)));
                    p pVar = new p(string, string2);
                    pVar.f2859b = v.g(b6.getInt(c15));
                    pVar.f2861d = b6.getString(c17);
                    pVar.f2862e = androidx.work.b.g(b6.getBlob(c18));
                    int i12 = i6;
                    pVar.f2863f = androidx.work.b.g(b6.getBlob(i12));
                    i6 = i12;
                    int i13 = c20;
                    pVar.f2864g = b6.getLong(i13);
                    int i14 = c18;
                    int i15 = c21;
                    pVar.f2865h = b6.getLong(i15);
                    int i16 = c9;
                    int i17 = c22;
                    pVar.f2866i = b6.getLong(i17);
                    int i18 = c23;
                    pVar.f2868k = b6.getInt(i18);
                    int i19 = c24;
                    pVar.f2869l = v.d(b6.getInt(i19));
                    c22 = i17;
                    int i20 = c25;
                    pVar.f2870m = b6.getLong(i20);
                    int i21 = c26;
                    pVar.f2871n = b6.getLong(i21);
                    c26 = i21;
                    int i22 = c27;
                    pVar.f2872o = b6.getLong(i22);
                    int i23 = c28;
                    pVar.f2873p = b6.getLong(i23);
                    int i24 = c29;
                    pVar.f2874q = b6.getInt(i24) != 0;
                    int i25 = c30;
                    pVar.f2875r = v.f(b6.getInt(i25));
                    pVar.f2867j = bVar;
                    arrayList.add(pVar);
                    c30 = i25;
                    c7 = i10;
                    c18 = i14;
                    c20 = i13;
                    c21 = i15;
                    c23 = i18;
                    c28 = i23;
                    c14 = i7;
                    c16 = i8;
                    c6 = i9;
                    c29 = i24;
                    c27 = i22;
                    c8 = i11;
                    c25 = i20;
                    c9 = i16;
                    c24 = i19;
                }
                b6.close();
                cVar.t();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b6.close();
                cVar.t();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cVar = k6;
        }
    }

    @Override // d0.q
    public List<p> t(int i6) {
        n.c cVar;
        n.c k6 = n.c.k("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        k6.H(1, i6);
        this.f2884a.b();
        Cursor b6 = p.c.b(this.f2884a, k6, false, null);
        try {
            int c6 = p.b.c(b6, "required_network_type");
            int c7 = p.b.c(b6, "requires_charging");
            int c8 = p.b.c(b6, "requires_device_idle");
            int c9 = p.b.c(b6, "requires_battery_not_low");
            int c10 = p.b.c(b6, "requires_storage_not_low");
            int c11 = p.b.c(b6, "trigger_content_update_delay");
            int c12 = p.b.c(b6, "trigger_max_content_delay");
            int c13 = p.b.c(b6, "content_uri_triggers");
            int c14 = p.b.c(b6, "id");
            int c15 = p.b.c(b6, "state");
            int c16 = p.b.c(b6, "worker_class_name");
            int c17 = p.b.c(b6, "input_merger_class_name");
            int c18 = p.b.c(b6, "input");
            int c19 = p.b.c(b6, "output");
            cVar = k6;
            try {
                int c20 = p.b.c(b6, "initial_delay");
                int c21 = p.b.c(b6, "interval_duration");
                int c22 = p.b.c(b6, "flex_duration");
                int c23 = p.b.c(b6, "run_attempt_count");
                int c24 = p.b.c(b6, "backoff_policy");
                int c25 = p.b.c(b6, "backoff_delay_duration");
                int c26 = p.b.c(b6, "period_start_time");
                int c27 = p.b.c(b6, "minimum_retention_duration");
                int c28 = p.b.c(b6, "schedule_requested_at");
                int c29 = p.b.c(b6, "run_in_foreground");
                int c30 = p.b.c(b6, "out_of_quota_policy");
                int i7 = c19;
                ArrayList arrayList = new ArrayList(b6.getCount());
                while (b6.moveToNext()) {
                    String string = b6.getString(c14);
                    int i8 = c14;
                    String string2 = b6.getString(c16);
                    int i9 = c16;
                    v.b bVar = new v.b();
                    int i10 = c6;
                    bVar.k(v.e(b6.getInt(c6)));
                    bVar.m(b6.getInt(c7) != 0);
                    bVar.n(b6.getInt(c8) != 0);
                    bVar.l(b6.getInt(c9) != 0);
                    bVar.o(b6.getInt(c10) != 0);
                    int i11 = c7;
                    int i12 = c8;
                    bVar.p(b6.getLong(c11));
                    bVar.q(b6.getLong(c12));
                    bVar.j(v.b(b6.getBlob(c13)));
                    p pVar = new p(string, string2);
                    pVar.f2859b = v.g(b6.getInt(c15));
                    pVar.f2861d = b6.getString(c17);
                    pVar.f2862e = androidx.work.b.g(b6.getBlob(c18));
                    int i13 = i7;
                    pVar.f2863f = androidx.work.b.g(b6.getBlob(i13));
                    i7 = i13;
                    int i14 = c20;
                    pVar.f2864g = b6.getLong(i14);
                    int i15 = c17;
                    int i16 = c21;
                    pVar.f2865h = b6.getLong(i16);
                    int i17 = c9;
                    int i18 = c22;
                    pVar.f2866i = b6.getLong(i18);
                    int i19 = c23;
                    pVar.f2868k = b6.getInt(i19);
                    int i20 = c24;
                    pVar.f2869l = v.d(b6.getInt(i20));
                    c22 = i18;
                    int i21 = c25;
                    pVar.f2870m = b6.getLong(i21);
                    int i22 = c26;
                    pVar.f2871n = b6.getLong(i22);
                    c26 = i22;
                    int i23 = c27;
                    pVar.f2872o = b6.getLong(i23);
                    int i24 = c28;
                    pVar.f2873p = b6.getLong(i24);
                    int i25 = c29;
                    pVar.f2874q = b6.getInt(i25) != 0;
                    int i26 = c30;
                    pVar.f2875r = v.f(b6.getInt(i26));
                    pVar.f2867j = bVar;
                    arrayList.add(pVar);
                    c30 = i26;
                    c7 = i11;
                    c17 = i15;
                    c20 = i14;
                    c21 = i16;
                    c23 = i19;
                    c28 = i24;
                    c14 = i8;
                    c16 = i9;
                    c6 = i10;
                    c29 = i25;
                    c27 = i23;
                    c8 = i12;
                    c25 = i21;
                    c9 = i17;
                    c24 = i20;
                }
                b6.close();
                cVar.t();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b6.close();
                cVar.t();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cVar = k6;
        }
    }

    @Override // d0.q
    public void u(String str, androidx.work.b bVar) {
        this.f2884a.b();
        q.f a6 = this.f2887d.a();
        byte[] l6 = androidx.work.b.l(bVar);
        if (l6 == null) {
            a6.r(1);
        } else {
            a6.O(1, l6);
        }
        if (str == null) {
            a6.r(2);
        } else {
            a6.m(2, str);
        }
        this.f2884a.c();
        try {
            a6.o();
            this.f2884a.t();
        } finally {
            this.f2884a.g();
            this.f2887d.f(a6);
        }
    }

    @Override // d0.q
    public int v() {
        this.f2884a.b();
        q.f a6 = this.f2892i.a();
        this.f2884a.c();
        try {
            int o6 = a6.o();
            this.f2884a.t();
            return o6;
        } finally {
            this.f2884a.g();
            this.f2892i.f(a6);
        }
    }
}

package v;

import android.os.Build;
import androidx.work.ListenableWorker;
import androidx.work.OverwritingInputMerger;
import v.u;

/* loaded from: classes.dex */
public final class l extends u {

    public static final class a extends u.a<a, l> {
        public a(Class<? extends ListenableWorker> cls) {
            super(cls);
            this.f9746c.f2861d = OverwritingInputMerger.class.getName();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // v.u.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public l c() {
            if (this.f9744a && Build.VERSION.SDK_INT >= 23 && this.f9746c.f2867j.h()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            return new l(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // v.u.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public a d() {
            return this;
        }
    }

    l(a aVar) {
        super(aVar.f9745b, aVar.f9746c, aVar.f9747d);
    }

    public static l e(Class<? extends ListenableWorker> cls) {
        return new a(cls).b();
    }
}

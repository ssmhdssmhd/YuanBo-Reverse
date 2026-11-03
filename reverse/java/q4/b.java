package q4;

import java.util.Random;
import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
public final class b extends q4.a {

    /* renamed from: c, reason: collision with root package name */
    private final a f8935c = new a();

    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // q4.a
    public Random c() {
        Random random = this.f8935c.get();
        k.d(random, "implStorage.get()");
        return random;
    }
}

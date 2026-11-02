package q2;

import java.lang.reflect.Field;
import java.util.Objects;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Field f8851a;

    public b(Field field) {
        Objects.requireNonNull(field);
        this.f8851a = field;
    }

    public String toString() {
        return this.f8851a.toString();
    }
}

package q2;

/* loaded from: classes.dex */
public interface u {

    public enum a {
        ALLOW,
        INDECISIVE,
        BLOCK_INACCESSIBLE,
        BLOCK_ALL
    }

    a a(Class<?> cls);
}

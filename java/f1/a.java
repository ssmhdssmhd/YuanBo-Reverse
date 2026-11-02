package f1;

import b1.e;
import b1.h;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l2.d;

/* loaded from: classes.dex */
public final class a extends h {

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f3775c = Pattern.compile("(.+?)='(.*?)';", 32);

    /* renamed from: a, reason: collision with root package name */
    private final CharsetDecoder f3776a = d.f7489c.newDecoder();

    /* renamed from: b, reason: collision with root package name */
    private final CharsetDecoder f3777b = d.f7488b.newDecoder();

    private String c(ByteBuffer byteBuffer) {
        String charBuffer;
        CharsetDecoder charsetDecoder;
        try {
            charBuffer = this.f3776a.decode(byteBuffer).toString();
            charsetDecoder = this.f3776a;
        } catch (CharacterCodingException unused) {
            this.f3776a.reset();
            byteBuffer.rewind();
            try {
                charBuffer = this.f3777b.decode(byteBuffer).toString();
                charsetDecoder = this.f3777b;
            } catch (CharacterCodingException unused2) {
                this.f3777b.reset();
                byteBuffer.rewind();
                return null;
            } catch (Throwable th) {
                this.f3777b.reset();
                byteBuffer.rewind();
                throw th;
            }
        } catch (Throwable th2) {
            this.f3776a.reset();
            byteBuffer.rewind();
            throw th2;
        }
        charsetDecoder.reset();
        byteBuffer.rewind();
        return charBuffer;
    }

    @Override // b1.h
    protected b1.a b(e eVar, ByteBuffer byteBuffer) {
        String c6 = c(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        String str = null;
        if (c6 == null) {
            return new b1.a(new c(bArr, null, null));
        }
        Matcher matcher = f3775c.matcher(c6);
        String str2 = null;
        for (int i6 = 0; matcher.find(i6); i6 = matcher.end()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            if (group != null) {
                String e6 = l2.b.e(group);
                e6.hashCode();
                if (e6.equals("streamurl")) {
                    str2 = group2;
                } else if (e6.equals("streamtitle")) {
                    str = group2;
                }
            }
        }
        return new b1.a(new c(bArr, str, str2));
    }
}

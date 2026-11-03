package p;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.room.h;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class c {
    public static void a(q.b bVar) {
        ArrayList<String> arrayList = new ArrayList();
        Cursor S = bVar.S("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (S.moveToNext()) {
            try {
                arrayList.add(S.getString(0));
            } catch (Throwable th) {
                S.close();
                throw th;
            }
        }
        S.close();
        for (String str : arrayList) {
            if (str.startsWith("room_fts_content_sync_")) {
                bVar.l("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }

    public static Cursor b(h hVar, q.e eVar, boolean z5, CancellationSignal cancellationSignal) {
        Cursor s5 = hVar.s(eVar, cancellationSignal);
        if (!z5 || !(s5 instanceof AbstractWindowedCursor)) {
            return s5;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) s5;
        int count = abstractWindowedCursor.getCount();
        return (Build.VERSION.SDK_INT < 23 || (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count) ? b.a(abstractWindowedCursor) : s5;
    }

    public static int c(File file) {
        AbstractInterruptibleChannel abstractInterruptibleChannel = null;
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            FileChannel channel = new FileInputStream(file).getChannel();
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(allocate) != 4) {
                throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            allocate.rewind();
            int i6 = allocate.getInt();
            channel.close();
            return i6;
        } catch (Throwable th) {
            if (0 != 0) {
                abstractInterruptibleChannel.close();
            }
            throw th;
        }
    }
}

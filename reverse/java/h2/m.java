package h2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import i2.c1;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import m2.s0;

/* loaded from: classes.dex */
class m {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, l> f5188a;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray<String> f5189b;

    /* renamed from: c, reason: collision with root package name */
    private final SparseBooleanArray f5190c;

    /* renamed from: d, reason: collision with root package name */
    private final SparseBooleanArray f5191d;

    /* renamed from: e, reason: collision with root package name */
    private c f5192e;

    /* renamed from: f, reason: collision with root package name */
    private c f5193f;

    private static final class a implements c {

        /* renamed from: e, reason: collision with root package name */
        private static final String[] f5194e = {"id", "key", "metadata"};

        /* renamed from: a, reason: collision with root package name */
        private final k0.b f5195a;

        /* renamed from: b, reason: collision with root package name */
        private final SparseArray<l> f5196b = new SparseArray<>();

        /* renamed from: c, reason: collision with root package name */
        private String f5197c;

        /* renamed from: d, reason: collision with root package name */
        private String f5198d;

        public a(k0.b bVar) {
            this.f5195a = bVar;
        }

        private void i(SQLiteDatabase sQLiteDatabase, l lVar) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            m.t(lVar.d(), new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(lVar.f5181a));
            contentValues.put("key", lVar.f5182b);
            contentValues.put("metadata", byteArray);
            sQLiteDatabase.replaceOrThrow((String) i2.a.e(this.f5198d), null, contentValues);
        }

        private static void j(k0.b bVar, String str) {
            try {
                String n6 = n(str);
                SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    k0.e.c(writableDatabase, 1, str);
                    l(writableDatabase, n6);
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e6) {
                throw new k0.a(e6);
            }
        }

        private void k(SQLiteDatabase sQLiteDatabase, int i6) {
            sQLiteDatabase.delete((String) i2.a.e(this.f5198d), "id = ?", new String[]{Integer.toString(i6)});
        }

        private static void l(SQLiteDatabase sQLiteDatabase, String str) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }

        private Cursor m() {
            return this.f5195a.getReadableDatabase().query((String) i2.a.e(this.f5198d), f5194e, null, null, null, null, null);
        }

        private static String n(String str) {
            return "ExoPlayerCacheIndex" + str;
        }

        private void o(SQLiteDatabase sQLiteDatabase) {
            k0.e.d(sQLiteDatabase, 1, (String) i2.a.e(this.f5197c), 1);
            l(sQLiteDatabase, (String) i2.a.e(this.f5198d));
            sQLiteDatabase.execSQL("CREATE TABLE " + this.f5198d + " (id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
        }

        @Override // h2.m.c
        public void a(l lVar, boolean z5) {
            if (z5) {
                this.f5196b.delete(lVar.f5181a);
            } else {
                this.f5196b.put(lVar.f5181a, null);
            }
        }

        @Override // h2.m.c
        public void b(l lVar) {
            this.f5196b.put(lVar.f5181a, lVar);
        }

        @Override // h2.m.c
        public boolean c() {
            try {
                return k0.e.b(this.f5195a.getReadableDatabase(), 1, (String) i2.a.e(this.f5197c)) != -1;
            } catch (SQLException e6) {
                throw new k0.a(e6);
            }
        }

        @Override // h2.m.c
        public void d(HashMap<String, l> hashMap) {
            if (this.f5196b.size() == 0) {
                return;
            }
            try {
                SQLiteDatabase writableDatabase = this.f5195a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                for (int i6 = 0; i6 < this.f5196b.size(); i6++) {
                    try {
                        l valueAt = this.f5196b.valueAt(i6);
                        if (valueAt == null) {
                            k(writableDatabase, this.f5196b.keyAt(i6));
                        } else {
                            i(writableDatabase, valueAt);
                        }
                    } finally {
                        writableDatabase.endTransaction();
                    }
                }
                writableDatabase.setTransactionSuccessful();
                this.f5196b.clear();
            } catch (SQLException e6) {
                throw new k0.a(e6);
            }
        }

        @Override // h2.m.c
        public void e(HashMap<String, l> hashMap) {
            try {
                SQLiteDatabase writableDatabase = this.f5195a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    o(writableDatabase);
                    Iterator<l> it = hashMap.values().iterator();
                    while (it.hasNext()) {
                        i(writableDatabase, it.next());
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.f5196b.clear();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e6) {
                throw new k0.a(e6);
            }
        }

        @Override // h2.m.c
        public void f(long j6) {
            String hexString = Long.toHexString(j6);
            this.f5197c = hexString;
            this.f5198d = n(hexString);
        }

        @Override // h2.m.c
        public void g(HashMap<String, l> hashMap, SparseArray<String> sparseArray) {
            i2.a.g(this.f5196b.size() == 0);
            try {
                if (k0.e.b(this.f5195a.getReadableDatabase(), 1, (String) i2.a.e(this.f5197c)) != 1) {
                    SQLiteDatabase writableDatabase = this.f5195a.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        o(writableDatabase);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                Cursor m6 = m();
                while (m6.moveToNext()) {
                    try {
                        l lVar = new l(m6.getInt(0), (String) i2.a.e(m6.getString(1)), m.q(new DataInputStream(new ByteArrayInputStream(m6.getBlob(2)))));
                        hashMap.put(lVar.f5182b, lVar);
                        sparseArray.put(lVar.f5181a, lVar.f5182b);
                    } finally {
                    }
                }
                m6.close();
            } catch (SQLiteException e6) {
                hashMap.clear();
                sparseArray.clear();
                throw new k0.a(e6);
            }
        }

        @Override // h2.m.c
        public void h() {
            j(this.f5195a, (String) i2.a.e(this.f5197c));
        }
    }

    private static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f5199a;

        /* renamed from: b, reason: collision with root package name */
        private final Cipher f5200b;

        /* renamed from: c, reason: collision with root package name */
        private final SecretKeySpec f5201c;

        /* renamed from: d, reason: collision with root package name */
        private final SecureRandom f5202d;

        /* renamed from: e, reason: collision with root package name */
        private final i2.b f5203e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f5204f;

        /* renamed from: g, reason: collision with root package name */
        private t f5205g;

        public b(File file, byte[] bArr, boolean z5) {
            Cipher cipher;
            SecretKeySpec secretKeySpec;
            i2.a.g((bArr == null && z5) ? false : true);
            if (bArr != null) {
                i2.a.a(bArr.length == 16);
                try {
                    cipher = m.i();
                    secretKeySpec = new SecretKeySpec(bArr, "AES");
                } catch (NoSuchAlgorithmException | NoSuchPaddingException e6) {
                    throw new IllegalStateException(e6);
                }
            } else {
                i2.a.a(!z5);
                cipher = null;
                secretKeySpec = null;
            }
            this.f5199a = z5;
            this.f5200b = cipher;
            this.f5201c = secretKeySpec;
            this.f5202d = z5 ? new SecureRandom() : null;
            this.f5203e = new i2.b(file);
        }

        private int i(l lVar, int i6) {
            int hashCode = (lVar.f5181a * 31) + lVar.f5182b.hashCode();
            if (i6 >= 2) {
                return (hashCode * 31) + lVar.d().hashCode();
            }
            long a6 = n.a(lVar.d());
            return (hashCode * 31) + ((int) (a6 ^ (a6 >>> 32)));
        }

        private l j(int i6, DataInputStream dataInputStream) {
            q q6;
            int readInt = dataInputStream.readInt();
            String readUTF = dataInputStream.readUTF();
            if (i6 < 2) {
                long readLong = dataInputStream.readLong();
                p pVar = new p();
                p.g(pVar, readLong);
                q6 = q.f5208c.e(pVar);
            } else {
                q6 = m.q(dataInputStream);
            }
            return new l(readInt, readUTF, q6);
        }

        private boolean k(HashMap<String, l> hashMap, SparseArray<String> sparseArray) {
            BufferedInputStream bufferedInputStream;
            DataInputStream dataInputStream;
            if (!this.f5203e.c()) {
                return true;
            }
            DataInputStream dataInputStream2 = null;
            try {
                bufferedInputStream = new BufferedInputStream(this.f5203e.d());
                dataInputStream = new DataInputStream(bufferedInputStream);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                int readInt = dataInputStream.readInt();
                if (readInt >= 0 && readInt <= 2) {
                    if ((dataInputStream.readInt() & 1) != 0) {
                        if (this.f5200b == null) {
                            c1.n(dataInputStream);
                            return false;
                        }
                        byte[] bArr = new byte[16];
                        dataInputStream.readFully(bArr);
                        try {
                            this.f5200b.init(2, (Key) c1.j(this.f5201c), new IvParameterSpec(bArr));
                            dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, this.f5200b));
                        } catch (InvalidAlgorithmParameterException e6) {
                            e = e6;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e7) {
                            e = e7;
                            throw new IllegalStateException(e);
                        }
                    } else if (this.f5199a) {
                        this.f5204f = true;
                    }
                    int readInt2 = dataInputStream.readInt();
                    int i6 = 0;
                    for (int i7 = 0; i7 < readInt2; i7++) {
                        l j6 = j(readInt, dataInputStream);
                        hashMap.put(j6.f5182b, j6);
                        sparseArray.put(j6.f5181a, j6.f5182b);
                        i6 += i(j6, readInt);
                    }
                    int readInt3 = dataInputStream.readInt();
                    boolean z5 = dataInputStream.read() == -1;
                    if (readInt3 == i6 && z5) {
                        c1.n(dataInputStream);
                        return true;
                    }
                    c1.n(dataInputStream);
                    return false;
                }
                c1.n(dataInputStream);
                return false;
            } catch (IOException unused2) {
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    c1.n(dataInputStream2);
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    c1.n(dataInputStream2);
                }
                throw th;
            }
        }

        private void l(l lVar, DataOutputStream dataOutputStream) {
            dataOutputStream.writeInt(lVar.f5181a);
            dataOutputStream.writeUTF(lVar.f5182b);
            m.t(lVar.d(), dataOutputStream);
        }

        private void m(HashMap<String, l> hashMap) {
            DataOutputStream dataOutputStream = null;
            try {
                OutputStream f6 = this.f5203e.f();
                t tVar = this.f5205g;
                if (tVar == null) {
                    this.f5205g = new t(f6);
                } else {
                    tVar.a(f6);
                }
                t tVar2 = this.f5205g;
                DataOutputStream dataOutputStream2 = new DataOutputStream(tVar2);
                try {
                    dataOutputStream2.writeInt(2);
                    int i6 = 0;
                    dataOutputStream2.writeInt(this.f5199a ? 1 : 0);
                    if (this.f5199a) {
                        byte[] bArr = new byte[16];
                        ((SecureRandom) c1.j(this.f5202d)).nextBytes(bArr);
                        dataOutputStream2.write(bArr);
                        try {
                            ((Cipher) c1.j(this.f5200b)).init(1, (Key) c1.j(this.f5201c), new IvParameterSpec(bArr));
                            dataOutputStream2.flush();
                            dataOutputStream2 = new DataOutputStream(new CipherOutputStream(tVar2, this.f5200b));
                        } catch (InvalidAlgorithmParameterException e6) {
                            e = e6;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e7) {
                            e = e7;
                            throw new IllegalStateException(e);
                        }
                    }
                    dataOutputStream2.writeInt(hashMap.size());
                    for (l lVar : hashMap.values()) {
                        l(lVar, dataOutputStream2);
                        i6 += i(lVar, 2);
                    }
                    dataOutputStream2.writeInt(i6);
                    this.f5203e.b(dataOutputStream2);
                    c1.n(null);
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    c1.n(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // h2.m.c
        public void a(l lVar, boolean z5) {
            this.f5204f = true;
        }

        @Override // h2.m.c
        public void b(l lVar) {
            this.f5204f = true;
        }

        @Override // h2.m.c
        public boolean c() {
            return this.f5203e.c();
        }

        @Override // h2.m.c
        public void d(HashMap<String, l> hashMap) {
            if (this.f5204f) {
                e(hashMap);
            }
        }

        @Override // h2.m.c
        public void e(HashMap<String, l> hashMap) {
            m(hashMap);
            this.f5204f = false;
        }

        @Override // h2.m.c
        public void f(long j6) {
        }

        @Override // h2.m.c
        public void g(HashMap<String, l> hashMap, SparseArray<String> sparseArray) {
            i2.a.g(!this.f5204f);
            if (k(hashMap, sparseArray)) {
                return;
            }
            hashMap.clear();
            sparseArray.clear();
            this.f5203e.a();
        }

        @Override // h2.m.c
        public void h() {
            this.f5203e.a();
        }
    }

    private interface c {
        void a(l lVar, boolean z5);

        void b(l lVar);

        boolean c();

        void d(HashMap<String, l> hashMap);

        void e(HashMap<String, l> hashMap);

        void f(long j6);

        void g(HashMap<String, l> hashMap, SparseArray<String> sparseArray);

        void h();
    }

    public m(k0.b bVar, File file, byte[] bArr, boolean z5, boolean z6) {
        i2.a.g((bVar == null && file == null) ? false : true);
        this.f5188a = new HashMap<>();
        this.f5189b = new SparseArray<>();
        this.f5190c = new SparseBooleanArray();
        this.f5191d = new SparseBooleanArray();
        a aVar = bVar != null ? new a(bVar) : null;
        b bVar2 = file != null ? new b(new File(file, "cached_content_index.exi"), bArr, z5) : null;
        if (aVar == null || (bVar2 != null && z6)) {
            this.f5192e = (c) c1.j(bVar2);
            this.f5193f = aVar;
        } else {
            this.f5192e = aVar;
            this.f5193f = bVar2;
        }
    }

    private l d(String str) {
        int l6 = l(this.f5189b);
        l lVar = new l(l6, str);
        this.f5188a.put(str, lVar);
        this.f5189b.put(l6, str);
        this.f5191d.put(l6, true);
        this.f5192e.b(lVar);
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Cipher i() {
        if (c1.f5548a == 18) {
            try {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            } catch (Throwable unused) {
            }
        }
        return Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    static int l(SparseArray<String> sparseArray) {
        int size = sparseArray.size();
        int i6 = 0;
        int keyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (keyAt >= 0) {
            return keyAt;
        }
        while (i6 < size && i6 == sparseArray.keyAt(i6)) {
            i6++;
        }
        return i6;
    }

    public static boolean o(String str) {
        return str.startsWith("cached_content_index.exi");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static q q(DataInputStream dataInputStream) {
        int readInt = dataInputStream.readInt();
        HashMap hashMap = new HashMap();
        for (int i6 = 0; i6 < readInt; i6++) {
            String readUTF = dataInputStream.readUTF();
            int readInt2 = dataInputStream.readInt();
            if (readInt2 < 0) {
                throw new IOException("Invalid value size: " + readInt2);
            }
            int min = Math.min(readInt2, 10485760);
            byte[] bArr = c1.f5553f;
            int i7 = 0;
            while (i7 != readInt2) {
                int i8 = i7 + min;
                bArr = Arrays.copyOf(bArr, i8);
                dataInputStream.readFully(bArr, i7, min);
                min = Math.min(readInt2 - i8, 10485760);
                i7 = i8;
            }
            hashMap.put(readUTF, bArr);
        }
        return new q(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t(q qVar, DataOutputStream dataOutputStream) {
        Set<Map.Entry<String, byte[]>> f6 = qVar.f();
        dataOutputStream.writeInt(f6.size());
        for (Map.Entry<String, byte[]> entry : f6) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    public void e(String str, p pVar) {
        l m6 = m(str);
        if (m6.b(pVar)) {
            this.f5192e.b(m6);
        }
    }

    public int f(String str) {
        return m(str).f5181a;
    }

    public l g(String str) {
        return this.f5188a.get(str);
    }

    public Collection<l> h() {
        return Collections.unmodifiableCollection(this.f5188a.values());
    }

    public o j(String str) {
        l g6 = g(str);
        return g6 != null ? g6.d() : q.f5208c;
    }

    public String k(int i6) {
        return this.f5189b.get(i6);
    }

    public l m(String str) {
        l lVar = this.f5188a.get(str);
        return lVar == null ? d(str) : lVar;
    }

    public void n(long j6) {
        c cVar;
        this.f5192e.f(j6);
        c cVar2 = this.f5193f;
        if (cVar2 != null) {
            cVar2.f(j6);
        }
        if (this.f5192e.c() || (cVar = this.f5193f) == null || !cVar.c()) {
            this.f5192e.g(this.f5188a, this.f5189b);
        } else {
            this.f5193f.g(this.f5188a, this.f5189b);
            this.f5192e.e(this.f5188a);
        }
        c cVar3 = this.f5193f;
        if (cVar3 != null) {
            cVar3.h();
            this.f5193f = null;
        }
    }

    public void p(String str) {
        l lVar = this.f5188a.get(str);
        if (lVar != null && lVar.g() && lVar.i()) {
            this.f5188a.remove(str);
            int i6 = lVar.f5181a;
            boolean z5 = this.f5191d.get(i6);
            this.f5192e.a(lVar, z5);
            SparseArray<String> sparseArray = this.f5189b;
            if (z5) {
                sparseArray.remove(i6);
                this.f5191d.delete(i6);
            } else {
                sparseArray.put(i6, null);
                this.f5190c.put(i6, true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void r() {
        s0 it = m2.s.k(this.f5188a.keySet()).iterator();
        while (it.hasNext()) {
            p((String) it.next());
        }
    }

    public void s() {
        this.f5192e.d(this.f5188a);
        int size = this.f5190c.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.f5189b.remove(this.f5190c.keyAt(i6));
        }
        this.f5190c.clear();
        this.f5191d.clear();
    }
}

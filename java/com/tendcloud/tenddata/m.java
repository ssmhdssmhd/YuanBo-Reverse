package com.tendcloud.tenddata;

import android.os.Parcel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class m extends File {
    public final String content;

    static class a extends m {
        public ArrayList<b> groups;

        private a(String str) {
            super(str);
            try {
                this.groups = new ArrayList<>();
                for (String str2 : this.content.split("\n")) {
                    try {
                        this.groups.add(new b(str2));
                    } catch (Throwable unused) {
                    }
                }
            } catch (Throwable unused2) {
            }
        }

        public static a get(int i6) {
            try {
                return new a(String.format("/proc/%d/cgroup", Integer.valueOf(i6)));
            } catch (Throwable unused) {
                return null;
            }
        }

        public b getGroup(String str) {
            try {
                Iterator<b> it = this.groups.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    for (String str2 : next.subsystems.split(",")) {
                        if (str2.equals(str)) {
                            return next;
                        }
                    }
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    static class b {
        protected String group;
        protected int id;
        protected String subsystems;

        protected b(Parcel parcel) {
            try {
                this.id = parcel.readInt();
                this.subsystems = parcel.readString();
                this.group = parcel.readString();
            } catch (Throwable unused) {
            }
        }

        protected b(String str) {
            try {
                String[] split = str.split(":");
                this.id = Integer.parseInt(split[0]);
                this.subsystems = split[1];
                this.group = split[2];
            } catch (Throwable unused) {
            }
        }
    }

    public static class c extends m {
        private String[] fields;

        private c(Parcel parcel) {
            super(parcel);
            this.fields = new String[0];
            try {
                this.fields = parcel.createStringArray();
            } catch (Throwable unused) {
            }
        }

        private c(String str) {
            super(str);
            this.fields = new String[0];
            try {
                this.fields = this.content.split("\\s+");
            } catch (Throwable unused) {
            }
        }

        public static c get(int i6) {
            try {
                return new c(String.format("/proc/%d/stat", Integer.valueOf(i6)));
            } catch (Throwable unused) {
                return null;
            }
        }

        public String getComm() {
            try {
                return this.fields[1].replace("(", "").replace(")", "");
            } catch (Throwable unused) {
                return "";
            }
        }

        public long startTime() {
            try {
                return Long.parseLong(this.fields[21]);
            } catch (Throwable unused) {
                return 0L;
            }
        }

        public char state() {
            try {
                return this.fields[2].charAt(0);
            } catch (Throwable unused) {
                return (char) 0;
            }
        }
    }

    static class d extends m {
        private d(Parcel parcel) {
            super(parcel);
        }

        private d(String str) {
            super(str);
        }

        public static d get(int i6) {
            try {
                return new d(String.format("/proc/%d/status", Integer.valueOf(i6)));
            } catch (Throwable unused) {
                return null;
            }
        }

        public int getGid() {
            try {
                return Integer.parseInt(getValue("Gid").split("\\s+")[0]);
            } catch (Throwable unused) {
                return -1;
            }
        }

        public int getUid() {
            try {
                return Integer.parseInt(getValue("Uid").split("\\s+")[0]);
            } catch (Throwable unused) {
                return -1;
            }
        }

        public String getValue(String str) {
            try {
                for (String str2 : this.content.split("\n")) {
                    if (str2.startsWith(str + ":")) {
                        return str2.split(str + ":")[1].trim();
                    }
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    protected m(Parcel parcel) {
        super(parcel.readString());
        this.content = parcel.readString();
    }

    protected m(String str) {
        super(str);
        this.content = readFile(str);
    }

    public static String readFile(String str) {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
            try {
                String str2 = "";
                for (String readLine = bufferedReader2.readLine(); readLine != null; readLine = bufferedReader2.readLine()) {
                    sb.append(str2);
                    sb.append(readLine);
                    str2 = "\n";
                    if (sb.length() > 104857600) {
                        throw new RuntimeException("Input stream more than 100 MB size limit");
                    }
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader2.close();
                } catch (Throwable unused) {
                }
                return sb2;
            } catch (Throwable unused2) {
                bufferedReader = bufferedReader2;
                try {
                    String sb3 = sb.toString();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return sb3;
                } catch (Throwable th) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable unused5) {
        }
    }

    @Override // java.io.File
    public long length() {
        return this.content.length();
    }
}

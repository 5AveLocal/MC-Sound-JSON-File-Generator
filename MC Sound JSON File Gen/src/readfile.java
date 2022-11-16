import java.io.File;
import java.util.Objects;

public class readfile {
    public static void listFilesForFolder(File folder, String reqname) {
        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            String[] strold = gen.strlist;
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry, reqname);
            } else if (fileEntry.getName().endsWith(".ogg")) {
                String[] strnew = new String[strold.length + 1];
                System.arraycopy(strold, 0, strnew, 0, strold.length);
                strnew[strold.length] = fileEntry.getPath().replace(reqname, "").replace(".ogg", "");
                gen.strlist = strnew;
            }
        }
    }
}
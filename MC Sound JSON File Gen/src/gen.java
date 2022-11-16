import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class gen {
    static String[] strlist = new String[0];

    public static void main(String[] args) throws IOException {
        File folder;
        String reqpath;
        String soundfoldername;
        Scanner inputstr = new Scanner(System.in);
        do {
            System.out.print("Resource pack path: ");
            soundfoldername = inputstr.nextLine();
            if (!soundfoldername.endsWith("\\")) {
                soundfoldername = soundfoldername + "\\";
            }
            reqpath = soundfoldername + "assets\\minecraft\\sounds.json";
            soundfoldername = soundfoldername + "assets\\minecraft\\sounds\\";

            folder = new File(soundfoldername);
            if (!folder.exists()) {
                System.out.println("Folder does not exist.");
            }
        } while (!folder.exists());
        readfile.listFilesForFolder(folder, soundfoldername);
        File outFile = new File(reqpath);
        if ((outFile.exists() && outFile.delete()) || outFile.createNewFile()) {
            FileWriter myWriter = new FileWriter(reqpath);
            myWriter.write("{\n  ");
            for (int i = 0; i < strlist.length; i++) {
                String str = strlist[i];
                String basic = "\"" + str.replace("\\", ".") + "\"" + ": {" + "\n    \"sounds\": [\n      \"" + str.replace("\\", "/") + "\"\n    ]\n  }";
                if (i < strlist.length - 1) {
                    myWriter.write(basic + ",\n  ");
                } else {
                    myWriter.write(basic + "\n}");
                }
            }
            myWriter.close();
            System.out.println("Successfully created " + outFile.getName());
        }
        inputstr.nextLine();
    }
}

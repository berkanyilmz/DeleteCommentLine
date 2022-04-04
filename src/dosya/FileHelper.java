package dosya;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHelper {
    static String path;
    BufferedReader reader;
    BufferedWriter writer;

    public FileHelper(String path) {
        FileHelper.path = path;
    }

    public void delComment() {
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = null;

            while ((line = reader.readLine()) != null) {
                if (!line.contains("//") && !line.contains("/*")) {
                    writeFile(line);
                }
                if (line.contains("/*")) {
                    while (!line.contains("*/")) {
                        line = reader.readLine();
                    }
                    writeFile(line.substring(line.indexOf("*/")+2));
                }
            }
        } catch (IOException x) {
            x.printStackTrace();
        }
    }

    void writeFile(String str) {
        try {
            writer = new BufferedWriter(new FileWriter("sourcecode.txt", true));
            writer.write(str, 0, str.length());
            writer.newLine();
            writer.close();
        } catch (IOException x) {
            System.err.format("IOException %s%n", x);
        }
    }
}

package yorumsilme;

import dosya.FileHelper;
import dosya.FileHelper.*;

public class Main {

    public static void main(String[] args) {
        String path = "C:\\Programlama\\Java\\YorumSatiriSilme\\yorum.txt";
        FileHelper fh = new FileHelper(path);
        fh.delComment();
    }
}

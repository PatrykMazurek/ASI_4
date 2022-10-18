package up.krakow;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        Client c = new Client("localhost", 5501);
//        c.connect();
//        c.sendMessage();
//        c.disconnect();
//        FileClient fc = new FileClient("localhost", 5501, "pliki");
//        fc.connect();
//        // przesyłanie plików do servera
//        fc.sendFileToServer();
//        // pobieranie plików z serwera
//        fc.getFileFromServer();
//        // zamykanie połączenia
//        fc.disconnect();

        PackageZIP zp = new PackageZIP();
        File[] files = Paths.get("pliki").toFile().listFiles();
        zp.packageArchive(files, "archiwum.zip");
//        zp.unpackageArchive(Path.of("pliki_out"), "archiwum.zip");
    }
}

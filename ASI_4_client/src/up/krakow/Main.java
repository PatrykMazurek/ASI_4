package up.krakow;

import up.krakow.testThread.testRunnable;
import up.krakow.testThread.testThread;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static int[] tabInt;
    public static List<Integer> numberList;

    public static void main(String[] args) {
	// write your code here

        numberList = new ArrayList<>();
        tabInt = new int[200];
        for(int i = 0; i< 200; i++){
            tabInt[i] = -1;
        }

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
//        fc.disconnect()
//        pakowanie i rozpakowywanie plików archiwum zip
//        PackageZIP zp = new PackageZIP();
//        File[] files = Paths.get("pliki").toFile().listFiles();
//        zp.packageArchive(files, "archiwum.zip");
//        zp.unpackageArchive(Path.of("pliki_out"), "archiwum.zip");

//        // wielowątkowść
        testThread test = new testThread();
//      // wykonaie wątków implementujących interfejs Runnable
//        test.startRunnable(10);
//          // // wykonaie wątków implementujących interfejs Callable
        test.startCalable(10);
        System.out.println("Zakończenie wątka głównego");
    }
}

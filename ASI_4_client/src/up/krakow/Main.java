package up.krakow;

import up.krakow.DB.DBConnection;
import up.krakow.DB.DBOperation;
import up.krakow.server.UDPClient;
import up.krakow.testThread.TikTak;
import up.krakow.testThread.startTikTak;
import up.krakow.testThread.testRunnable;
import up.krakow.testThread.testThread;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static int[] tabInt;
    public static List<Integer> numberList;
    public static int number;
    public static void main(String[] args) {
	// write your code here
        number = 0;
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
//        testThread test = new testThread();
//      // wykonaie wątków implementujących interfejs Runnable
//        test.startRunnable(10);
//          // // wykonaie wątków implementujących interfejs Callable
//        test.startCalable(10);
//        TikTak tt = new TikTak();
//
//        startTikTak t1 = new startTikTak("Tik", tt);
//        startTikTak t2 = new startTikTak("Tak", tt);
//
//        try {
//            t1.th.join();
//            t2.th.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        DBConnection conn = new DBConnection();
//        Connection c = conn.connectToMySql();
//        DBOperation operation = new DBOperation(c);
////        operation.insertPerson("Jan", "Nowak", 36);
////        conn.connectToSQLite();
//        operation.getCountPersonProc();
//        operation.getAllPersonProc();
////        conn.createTable();
//        conn.disconnect();

        UDPClient client = new UDPClient();
        for (int i=0; i<15; i++){
            client.sendMessage(i+"");
        }
        client.sendMessage("end");
        client.close();

        System.out.println("Zakończenie wątka głównego");
    }
}

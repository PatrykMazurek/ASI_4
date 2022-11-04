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
    public static List<File> fileList;

    public static void main(String[] args) {
	// write your code here

        fileList = new ArrayList<>();
        tabInt = new int[200];
        for(int i = 0; i< 200; i++){
            tabInt[i] = -1;
        }

        Client c = new Client("localhost", 5501);
        c.connect();
        c.sendMessage();
        c.disconnect();
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

        Thread threadFile = new Thread(new Runnable() {
            @Override
            public void run() {
                File[] fils = Paths.get("pliki").toFile().listFiles();
                fileList = Arrays.stream(fils).collect(Collectors.toList());
                for (int i = 0; i< 15; i++){
                    fils = Paths.get("pliki").toFile().listFiles();
                    if (fils.length != fileList.size()){
                        
                        System.out.println("Zmieniła się liczba plików");
                    }
                    try {
                        Thread.sleep(6000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }




            }
        });


        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                for(int i = 0; i < 20; i++){
                    System.out.println("Wartość "+ i);
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
//        th.start();
//        try {
//            th.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        testThread test = new testThread();
//        test.startRunnable(10);
//
//        System.out.println("Zakończenie wątka głównego");
    }
}

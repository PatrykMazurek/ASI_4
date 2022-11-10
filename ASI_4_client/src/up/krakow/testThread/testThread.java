package up.krakow.testThread;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class testThread {

    private List<File> fileList;

    public void startRunnable(int numberThread){

        ExecutorService service = Executors.newFixedThreadPool(numberThread);
        for (int i = 0; i< 200; i++){
            service.submit(new testRunnable(i));
        }
        service.shutdown();
    }

    public void startCalable(int numberThread){
        ExecutorService service = Executors.newCachedThreadPool();
        ThreadPoolExecutor thredPool = (ThreadPoolExecutor) service;
        int taskNumber = 0;
//        List<Future<String>> futureList = new ArrayList<>();
        BlockingDeque<Future<String>> blockingDeque = new LinkedBlockingDeque<>();
        System.out.println("Dodaj zadania do listy");
        while (taskNumber < 200){
            if (thredPool.getActiveCount() < numberThread){
                TestCallable tc = new TestCallable(taskNumber);
//                futureList.add(service.submit(tc));
                blockingDeque.add(service.submit(tc));
                taskNumber++;
            }
        }
        // wykorzystanie kolekcji BlockingDeque
        System.out.println("Odbieranie wyników z wątków");
        while (!blockingDeque.isEmpty()){
            Future<String> f = blockingDeque.poll();
            if (f.isDone()){
                try {
                    String message = f.get();
                    System.out.println(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
//        //wykorzystanie kolekcji ArrayList
//        for (int i = 0; i < 200; i++){
//            Future<String> f = futureList.get(i);
//            try {
//                String message = f.get(2, TimeUnit.SECONDS);
//                System.out.println(message);
//            } catch (InterruptedException | ExecutionException | TimeoutException e) {
//                e.printStackTrace();
//            }
//        }
        service.shutdown();
    }
    // wywołanie wątkaów w trakcie programu
    public void startThread(){
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
        th.start();
        // oczekiwanie na wykonaie wątku
        try {
            th.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // przykład wątku
    public void listingForFile(){
        fileList = new ArrayList<>();
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
        threadFile.start();
    }
}

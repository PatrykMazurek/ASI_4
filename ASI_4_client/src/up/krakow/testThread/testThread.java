package up.krakow.testThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class testThread {

    public void startRunnable(int numberThread){

        ExecutorService service = Executors.newFixedThreadPool(numberThread);

        for (int i = 0; i< 200; i++){
            service.submit(new testRunnable());
        }

        service.shutdown();
    }





}

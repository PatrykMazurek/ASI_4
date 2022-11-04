package up.krakow.testThread;

import up.krakow.Main;

import java.util.Random;

public class testRunnable implements Runnable {


    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName);
//        Thread.currentThread().setName();
        Random rand = new Random();
        int id = rand.nextInt(200);

        String[] temp = threadName.split("-");
        int nrTh =  Integer.valueOf(temp[3]);
        Main.tabInt[id] = nrTh;
        try {
            int w = rand.nextInt(800);
            Thread.sleep(w);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

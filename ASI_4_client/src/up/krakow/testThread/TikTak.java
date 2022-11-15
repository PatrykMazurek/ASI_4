package up.krakow.testThread;

import up.krakow.Main;

import java.util.Random;

public class TikTak {

    public synchronized void Tik(boolean work){
        if(!work){
            System.out.println(String.format("Wątek %s zakończył pracę",
                    Thread.currentThread().getName()) );
            notify();
            return;
        }
        System.out.println("Wyświetlam Tik ");
        notify();
        try {
            System.out.println("Wątek tik czeka");
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void Tak(boolean work){
        if(!work){
            System.out.println(String.format("Wątek %s zakończył pracę",
                    Thread.currentThread().getName()) );
            notify();
            return;
        }
        System.out.println("Wyświetlam Tak ");
        notify();
        try {
            System.out.println("Wątek tak czeka");
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void zak(boolean work){
        String thName = Thread.currentThread().getName();
        if(!work){
            System.out.println(String.format("Wątek %s zakończył pracę",
                    thName) );
            notify();
            return;
        }
        if (thName.compareTo("Tik") == 0){
            Random rand = new Random();
            Main.number += rand.nextInt(300);
        }else{
            if (Main.number > 100){
                System.out.println(Main.number);
                Main.number = 0;
            }
        }
        System.out.println(String.format("Wyświetlam %s",
                thName));
        notify();
        try {
            System.out.println(String.format("Wątek %s czeka",
                    thName));
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

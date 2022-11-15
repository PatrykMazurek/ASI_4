package up.krakow.testThread;

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
}

package up.krakow.testThread;

import up.krakow.Main;

import java.util.Random;

public class testRunnable implements Runnable {

    private int thNr;

    public testRunnable(int tn){
        thNr = tn;
    }


    @Override
    public void run() {
        randNumber();
    }

    private void randNumber(){
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName);
//        Thread.currentThread().setName();
        Random rand = new Random();
        int number, count = 0;
        boolean find = false;
//        String[] temp = threadName.split("-");
//        int nrTh =  Integer.valueOf(temp[3]);
        synchronized (this){
            while (true){
                number = rand.nextInt(400);
                if (Main.numberList.contains(number)){
                    find = true;
                }
                if (!find){
                    Main.numberList.add(number);
                    System.out.println("Wątek " + thNr + " dodał wartość " + number );
                    break;
                }else{
                    count++;
                }
                try {
                    int w = rand.nextInt(800);
                    Thread.sleep(w);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (count > 9){
                    System.out.println("Wątek " + threadName + " przerwał losowanie ");
                    break;
                }
            }
        }
    }
}

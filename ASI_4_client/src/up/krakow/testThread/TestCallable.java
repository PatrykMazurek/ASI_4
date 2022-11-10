package up.krakow.testThread;

import java.util.Random;
import java.util.concurrent.Callable;

public class TestCallable implements Callable<String> {

    private int task;

    public TestCallable(int task){
        this.task = task;
    }

    @Override
    public String call() throws Exception {
        String threadName = Thread.currentThread().getName();
        Random rand = new Random();
        int number = rand.nextInt(400);
        String message = "Wątek " + threadName + " wartość " + number;
        Thread.sleep(1000);

        return message;
    }
}

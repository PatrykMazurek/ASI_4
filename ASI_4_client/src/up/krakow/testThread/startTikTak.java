package up.krakow.testThread;

public class startTikTak implements Runnable {

    public Thread th;
    private TikTak tt;

    public startTikTak(String name, TikTak tObj){
        tt = tObj;
        th = new Thread(this, name);
        th.start();
    }

    @Override
    public void run() {
        if (th.getName().compareTo("Tik") == 0){
            for (int i = 0; i< 7;i++){
                tt.zak(true);
            }
            tt.zak(false);
        }else {
            for (int i = 0; i< 7;i++){
                tt.zak(true);
            }
            tt.zak(false);
        }
    }
}

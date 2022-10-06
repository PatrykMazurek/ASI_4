package up.krakow;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Server s = new Server(5501);
        s.clientConnection();
    }
}

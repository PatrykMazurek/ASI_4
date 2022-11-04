package up.krakow;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Server s = new Server(5501);
        s.clientConnection();

//        FileServer fs = new FileServer(5501, "pliki_server");
//        fs.clientConnection();
    }
}

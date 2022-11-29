package up.krakow;

import up.krakow.server.UDPServer;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Server s = new Server(5501);
//        s.clientConnection();

        UDPServer server = new UDPServer(5501);
        server.startConnection();

//        FileServer fs = new FileServer(5501, "pliki_server");
//        fs.clientConnection();
    }
}

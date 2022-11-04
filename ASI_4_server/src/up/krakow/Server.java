package up.krakow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private ServerSocket serverSocket;
    private Socket socket;
    private List<Socket> socketList;

    public Server(int port){
        try {
            socketList = new ArrayList<>();
            this.serverSocket = new ServerSocket(port);
            System.out.println("stworzono instancje serwera");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clientConnection(){
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println("Oczekuje na klienta ...");
        while(true){
            try {
                this.socket = serverSocket.accept();
                System.out.println("Połączenie z klientem " + socket.getInetAddress().getAddress());
                socketList.add(socket);
                service.submit(new ServerThread(socket));
//                sendMessageToClient();
//                stopConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessageToClient(){
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    socket.getInputStream(), StandardCharsets.UTF_8
            ));

            writer.println("Witaj podaj imię: ");
            String text = reader.readLine();
            System.out.println(text);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopConnection(){
        if (!socket.isClosed()){
            try {
                this.socket.close();
                System.out.println("Zakończenie połączenia z użytkownikiem");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

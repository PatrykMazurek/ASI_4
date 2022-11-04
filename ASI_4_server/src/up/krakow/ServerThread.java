package up.krakow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerThread implements Runnable{

    private Socket socket;

    public ServerThread(Socket s){
        this.socket = s;
    }

    @Override
    public void run() {
        sendMessageToClient();
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
}

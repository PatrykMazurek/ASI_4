package up.krakow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {

    private Socket socket;
    private String host;
    private int port;

    public Client(String h, int p){
        this.host = h;
        this.port = p;
    }

    public void connect(){
        try {
            InetAddress address = InetAddress.getByName(host);
            this.socket = new Socket(address, port);
            if (socket.isConnected()){
                System.out.println("Nawiązano połączenie ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(){
        try{
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    socket.getInputStream(), StandardCharsets.UTF_8
            ));
            String text = reader.readLine();
            System.out.println(text);
            Scanner scan = new Scanner(System.in);
            String text2 = scan.nextLine();
            writer.println(text2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void disconnect(){
        if (socket.isConnected()){
            try {
                socket.close();
                System.out.println("Zakończenie połączenia ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

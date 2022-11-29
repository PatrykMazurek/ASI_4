package up.krakow.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class UDPServer {

    private DatagramPacket packet;
    private DatagramSocket socket;

    public UDPServer(int port){
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void startConnection(){
        byte[] byteIn = new byte[64];
        System.out.println("Oczekuje na połączenie...");
        while (true){
            try {
                packet = new DatagramPacket(byteIn, byteIn.length);
                socket.receive(packet);
                String s = new String(packet.getData(), 0,
                        packet.getLength(),
                        StandardCharsets.UTF_8);

                System.out.println("Wiadomość z adresu " + packet.getAddress()
                        + " treść " + s);
                String temp = "wiadomość zwrotna " + s;
                packet.setData(temp.getBytes(StandardCharsets.UTF_8));
                if (s.equals("end")){
                    System.out.println("Kończę prace");
                    socket.send(packet);
                    break;
                }
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}

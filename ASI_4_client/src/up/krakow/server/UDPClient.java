package up.krakow.server;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPClient {

    private DatagramSocket socket;

    public UDPClient(){
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg){
        byte[] byteIn = new byte[512];

        try {
            DatagramPacket packetIn = new DatagramPacket(byteIn, byteIn.length);
            DatagramPacket packetOut = new DatagramPacket(msg.getBytes(StandardCharsets.UTF_8),
                    msg.length(), InetAddress.getByName("localhost"), 5501);
            socket.send(packetOut);

            socket.receive(packetIn);
            String message = new String(packetIn.getData(),
                    0, packetIn.getLength(),
                    StandardCharsets.UTF_8);
            System.out.println(message);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        socket.close();
    }
}

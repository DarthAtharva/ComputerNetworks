package UDP_Server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("127.0.0.1"); // local server

        // Send message
        byte[] buf = "Hello there.".getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, addr, 2053);
        socket.send(packet);

        // Receive response
        byte[] bufResponse = new byte[512];
        DatagramPacket response = new DatagramPacket(bufResponse, bufResponse.length);
        socket.receive(response);

        System.out.println("Response length: " + response.getLength());
        System.out.println("Received data from server: " + new String(response.getData(), 0, response.getLength()));
        socket.close();

    }
}

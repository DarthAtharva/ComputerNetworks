package UDP_Server;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class Server {

    public static void main(String[] darth){

        try(DatagramSocket serverSocket = new DatagramSocket(2053)){

            System.out.println("SERVER up and running");

            while(true){

                final byte[] buffer = new byte[512];
                final DatagramPacket datagram = new DatagramPacket(buffer, buffer.length);
                serverSocket.receive(datagram);
                System.out.println("Received data from Client: " + new String(datagram.getData(), 0, datagram.getLength()));

                final byte[] bufferResponse = "GeneralKenobi!!!".getBytes();
                final DatagramPacket datagramResponse = new DatagramPacket(bufferResponse, bufferResponse.length, datagram.getSocketAddress());
                serverSocket.send(datagramResponse);
                System.out.println("Response sent");

            }

        }catch(IOException e){

            System.out.println("IO Exception: " + e.getMessage());

        }
    }
}
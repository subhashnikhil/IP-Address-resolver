package udpdnsclient;

import java.io.*;
import java.net.*;

public class Udpdnsclient {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientsocket = new DatagramSocket();
        InetAddress ipaddress = InetAddress.getLocalHost();
        byte[] senddata = new byte[1024];
        byte[] receivedata = new byte[1024];
        byte[] receivedata2 = new byte[1024];
        
        int portaddr = 1362;
        System.out.println("\t\t\t\tDOMAIN NAME RESOLVER");
        System.out.println("\nEnter the hostname......");
        String sentence = br.readLine();
        senddata = sentence.getBytes();
        DatagramPacket pack = new DatagramPacket(senddata, senddata.length, ipaddress, portaddr);
        clientsocket.send(pack);
        DatagramPacket recvpack = new DatagramPacket(receivedata, receivedata.length);
        clientsocket.receive(recvpack);
        String canhname = new String(recvpack.getData());
        System.out.println("Canonical HostName is......" + canhname);
        DatagramPacket recvpack2 = new DatagramPacket(receivedata2, receivedata2.length);
        clientsocket.receive(recvpack2);
        String ip = new String(recvpack2.getData());
        System.out.println("IPAddress is......." + ip);
        clientsocket.close();
    }
}

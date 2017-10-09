package udpdnsserver;

import java.io.*;
import java.net.*;

public class Udpdnsserver {

    public static void main(String arg[]) throws IOException {
        DatagramSocket serversocket = new DatagramSocket(1362);
        byte[] senddata = new byte[1021];
        byte[] receivedata = new byte[1021];
        DatagramPacket recvpack = new DatagramPacket(receivedata, receivedata.length);
        serversocket.receive(recvpack);
        String sen = new String(recvpack.getData());
        InetAddress ipaddress = recvpack.getAddress();
        int port = recvpack.getPort();
        System.out.println("Request for host....." + sen);
        InetAddress inetHost = InetAddress.getByName(sen);
        String canhostname = inetHost.getCanonicalHostName();
        System.out.println("canonical hostname......"+canhostname);
        senddata = canhostname.getBytes();
        DatagramPacket pack = new DatagramPacket(senddata, senddata.length, ipaddress, port);
        serversocket.send(pack);
        String capsent = inetHost.getHostAddress();
        System.out.println("IPAddress....."+capsent);
        senddata = capsent.getBytes();
        DatagramPacket pack2 = new DatagramPacket(senddata, senddata.length, ipaddress, port);
        serversocket.send(pack2);
        serversocket.close();
    }
}

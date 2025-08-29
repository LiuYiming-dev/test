package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动");
        DatagramSocket socket = new DatagramSocket(6666);

        byte[] buffer = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);




        while (true) {
            socket.receive(packet);

            int len = packet.getLength();
            String res = new String(buffer, 0, len);


            System.out.println(res);
            System.out.println(packet.getAddress().getHostAddress());
            System.out.println(packet.getPort());
            System.out.println("-------------------------------------");
        }





    }
}

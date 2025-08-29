package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {

        DatagramSocket socket = new DatagramSocket();


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请说");
            String msq = scanner.nextLine();


            if (msq.equals("exit")) {
                System.out.println("退出成功");
                socket.close();
                break;
            }

            byte[] bytes = msq.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length,
                    InetAddress.getLocalHost(), 6666);


            socket.send(packet);
        }










    }
}

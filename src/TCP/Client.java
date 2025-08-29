package TCP;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("192.168.1.2", 8888);

        new ClientReaderThread(socket).start();
        OutputStream outputStream = socket.getOutputStream();

        //把低级的字节输出流包装成数据输出流
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("请说");
            String msg = scanner.nextLine();

            if (msg.equals("exit")) {
                System.out.println("退出成功");
                dataOutputStream.close();
                socket.close();

                break;
            }

            dataOutputStream.writeUTF(msg);
            dataOutputStream.flush();
        }

    }
}

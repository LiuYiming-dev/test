package TCP;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientReaderThread extends Thread {
    private Socket socket;

    public ClientReaderThread(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            while (true) {
                try {
                    String message = dataInputStream.readUTF();
                    System.out.println(message);
                } catch (IOException e) {
                    System.out.println("自己下线了" + socket.getRemoteSocketAddress());
                    dataInputStream.close();
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

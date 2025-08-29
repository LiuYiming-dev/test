package TCP;

import java.io.*;
import java.net.Socket;

public class ServerReaderRunnable implements Runnable {
    private Socket socket;

    public ServerReaderRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println ("HTTP/1.1 200 OK");
            printStream.println ("Content-Type: text/html;charset=UTF-8");
            printStream.println();
            printStream.println ("<div style='color:red;font-size:120px;text-align:center'>黑马程序 666<div>");

            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}

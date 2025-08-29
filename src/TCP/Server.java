package TCP;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class Server {
    public static void main(String[] args) throws  Exception {
        System.out.println("---------服务端已经启动---------");
        ServerSocket serverSocket = new ServerSocket(8080);

        ThreadPoolExecutor pool = new ThreadPoolExecutor(32, 32, 0, TimeUnit.SECONDS
                , new ArrayBlockingQueue<>(8), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        while (true) {

            Socket socket = serverSocket.accept();

            pool.execute(new ServerReaderRunnable(socket));

        }







    }
}

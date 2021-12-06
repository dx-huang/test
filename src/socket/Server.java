package socket;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author HDX
 * @date 2021/7/28
 * @Description
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Executor threadPool = Executors.newCachedThreadPool();


        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("用户："+socket.getLocalSocketAddress()+"已上线");
            threadPool.execute(() -> {
                handler(socket);
            });
        }


    }

    public static void handler(Socket socket) {
        byte[] bytes = new byte[1024];
        InputStream is = null;
        try {
            is = socket.getInputStream();
            while (true) {
                int count = is.read(bytes);
                if (count == -1) break;
                System.out.println("用户"+socket.getLocalSocketAddress()+"给您发了一条消息：");
                System.out.println(new String(bytes,0,count));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}

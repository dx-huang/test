package socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author HDX
 * @date 2021/7/28
 * @Description
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",1234);
        OutputStream os = socket.getOutputStream();
        Scanner input = new Scanner(System.in);
        String msg = "";
        if (input.hasNext()) {
            msg = input.next();
        }
        os.write(msg.getBytes());
        os.close();
        socket.close();

    }
}

package socket.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author HDX
 * @date 2021/7/29
 * @Description
 */
public class ChatClient {

    private SocketChannel clientChannel;

    private Selector selector;

    public ChatClient(){
        try {
            clientChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",1234));
            clientChannel.configureBlocking(false);
            selector = Selector.open();
            clientChannel.register(selector, SelectionKey.OP_READ);
            System.out.println(clientChannel.socket().getLocalSocketAddress()+"已上线！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readData(){
        try {
            int num = selector.select();
            if (num > 0) {
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    if (selectionKey.isReadable()) {
                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                        int count = channel.read(readBuffer);
                        if (count > 0) {
                            String msg = new String(readBuffer.array());
                            System.out.println(msg);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private void sendData(String msg) {
        ByteBuffer writeBuffer = ByteBuffer.wrap(msg.getBytes());
        try {
            clientChannel.write(writeBuffer);
            System.out.println("消息发送成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
        new Thread(()->{
           while (true){
               chatClient.readData();
           }
        }).start();
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String msg = input.next();
            chatClient.sendData(msg);
        }
    }






}

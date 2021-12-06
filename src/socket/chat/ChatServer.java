package socket.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author HDX
 * @date 2021/7/29
 * @Description
 */
public class ChatServer {
    private ServerSocketChannel serverSocketChannel;

    private Selector selector;

    public ChatServer(){
        try {
            serverSocketChannel = ServerSocketChannel.open();
            selector = Selector.open();
            serverSocketChannel.bind(new InetSocketAddress(1234));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listenClient() throws IOException {
        while (true) {
            int num = selector.select();
            if (num == 0) continue;
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isAcceptable()) {
                    SocketChannel clientChannel = serverSocketChannel.accept();
                    clientChannel.configureBlocking(false);
                    clientChannel.register(selector,SelectionKey.OP_READ);
                    System.out.println("用户："+clientChannel.socket().getRemoteSocketAddress()+"已上线！");
                    continue;
                }
                if (key.isReadable()) {
                    readData(key);
                }
            }
        }
    }

    private void readData(SelectionKey key) throws IOException {
        SocketChannel channel = null;
        try {
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            channel = (SocketChannel) key.channel();
            int count = channel.read(readBuffer);
            if (count > 0 ){
                String msg = new String(readBuffer.array());
                msg = "message from " + channel.socket().getRemoteSocketAddress() + ":" + msg;
                System.out.println(msg);
                //将信息广播给其他用户
                sendToOther(channel,msg);
            }
        }catch (Exception e) {
            System.out.println("用户："+channel.socket().getRemoteSocketAddress()+"已下线！");
        }

    }


    private void sendToOther(SocketChannel selfChannel,String msg) throws IOException {
        Set<SelectionKey> keys = selector.keys();
        //广播给除了自己的其他用户
        for (SelectionKey key : keys) {
            Channel channel = key.channel();
            if (channel instanceof SocketChannel && channel != selfChannel) {
                SocketChannel otherChannel = (SocketChannel)channel;
                ByteBuffer writeBuffer = ByteBuffer.wrap(msg.getBytes());
                otherChannel.write(writeBuffer);
            }
        }

    }


    public static void main(String[] args){
        ChatServer server = new ChatServer();
        try {
            server.listenClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

package org.chen.algorithm.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-10-05 15:23
 */
public class NioClient {
    // 标识数据
    private static int flag = 0;

    // 缓冲区大小
    private static int BLOCK = 4096;

    // 接受数据缓冲区
    private static ByteBuffer receiveBuffer = ByteBuffer.allocate(BLOCK);

    // 发送数据缓冲区
    private static ByteBuffer sendBuffer = ByteBuffer.allocate(BLOCK);

    // 服务器端地址
    private final static InetSocketAddress SERVER_ADDRESS = new InetSocketAddress("localhost",8888);

    public static void main(String[] args) throws IOException {
        // 打开socket通道
        SocketChannel socketChannel = SocketChannel.open();

        // 设置为非阻塞方式
        socketChannel.configureBlocking(false);

        // 打开选择器
        Selector selector = Selector.open();

        // 注册连接服务端socket动作
        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        // 连接
        socketChannel.connect(SERVER_ADDRESS);

        // 分配缓冲区大小内存
        Set<SelectionKey> selectionKeys;
        Iterator<SelectionKey> iterator;
        SelectionKey selectionKey;
        SocketChannel client;
        String receiveText;
        String sendText;
        int count = 0;
        while(true){
            selector.select();
            selectionKeys = selector.selectedKeys();
            iterator = selectionKeys.iterator();
            while(iterator.hasNext()){
                selectionKey = iterator.next();
                if (selectionKey.isConnectable()) {
                    System.out.println("client connect");
                    client = (SocketChannel) selectionKey.channel();
                    // 判断此通道上是否正在进行连接操作
                    // 完成套接字通道的连接过程
                    if (client.isConnectionPending()) {
                        client.finishConnect();
                        System.out.println("完成连接");
                        sendBuffer.clear();
                        sendBuffer.put("Hello ,Server".getBytes());
                        sendBuffer.flip();
                        client.write(sendBuffer);
                    }
                    client.register(selector,SelectionKey.OP_READ);
                }
            }
        }


    }


}

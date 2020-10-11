package org.chen.algorithm.nio;

import java.io.PrintWriter;
import java.net.Socket;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-09-28 23:10
 */
// 简化实现，不做读取，直接发送字符串
class RequestHandler extends Thread {
    private Socket socket;
    RequestHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream());) {
            out.println("Hello world!");
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.interview.xsj.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xsj
 * @create 2021-04-19 17:57
 */
class Server implements Runnable {
    public static final Integer PORT=123333;
    public static final Integer MAX_INPUT=128;
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(PORT);
            while (!Thread.interrupted())
                new Thread(new Handler(ss.accept())).start();
            // or, single-threaded, or a thread pool
        } catch (IOException ex) { /* ... */ }
    }
    static class Handler implements Runnable {
        final Socket socket;
        Handler(Socket s) { socket = s; }
        public void run() {
            try {
                byte[] input = new byte[MAX_INPUT];
                socket.getInputStream().read(input);
                byte[] output = process(input);
                socket.getOutputStream().write(output);
            } catch (IOException ex) { /* ... */ }
        }
        private byte[] process(byte[] cmd) { /* ... */return null; }
    }
}


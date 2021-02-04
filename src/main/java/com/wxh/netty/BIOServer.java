package com.wxh.netty;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wuxinhong
 * @date 2021/1/22 8:47 上午
 */
public class BIOServer {
    public static void main(String[] args) throws IOException {
        // 1.创建一个线程池
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        // 2.如果有客户端连接，就创建一个线路，与之通信
        ServerSocket serverSocket = new ServerSocket(6666);

        System.out.println("服务启动成功");
        while (true){
            System.out.println("等待连接...");
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            newCachedThreadPool.execute(() -> handler(socket));
        }
    }

    public static void handler(Socket socket){
        InputStream inputStream = null;
        try{
            System.out.println("线程信息 id="+Thread.currentThread().getId()+"，name="+Thread.currentThread().getName());
            byte[] bytes = new byte[1024];
            inputStream = socket.getInputStream();
            while (true){
                System.out.println("read...");
                int read = inputStream.read(bytes);
                if(read != -1){
                    System.out.println(new String(bytes, 0, read));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
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

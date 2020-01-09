package com.wxh.socket;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/12/3
 * @time: 上午11:15
 * Copyright (C) 2019 MTDP
 * All rights reserved
 */
public class Socket2Test {
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
            os = socket.getOutputStream();
            is = socket.getInputStream();
            os.write("你好，我是客户端".getBytes());
            socket.shutdownOutput();
            byte[] b = new byte[15];
            int len;
            while((len = is.read(b)) != -1){
                System.out.print(new String(b, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != os){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != socket){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void server(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            serverSocket = new ServerSocket(9090);
            socket = serverSocket.accept();
            is = socket.getInputStream();
            os = socket.getOutputStream();
            byte[] b = new byte[32];
            int len;
            while ((len = is.read(b)) != -1){
                System.out.print(new String(b, 0, len));
            }
            os.write("你好，我收到你的消息了".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != os){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(serverSocket !=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

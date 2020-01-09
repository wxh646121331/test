package com.wxh.socket;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/12/4
 * @time: 上午9:51
 */
public class DatagramSocketTest {

    @Test
    public void send(){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            byte[] b = "你好，世界".getBytes();
            DatagramPacket packet = new DatagramPacket(b, 0, b.length, InetAddress.getByName("127.0.0.1"), 9191);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }

    }

    @Test
    public void receiver(){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9191);
            byte[] b = new byte[1024];
            DatagramPacket packet = new DatagramPacket(b, 0, b.length);
            socket.receive(packet);
            String str = new String(packet.getData(), 0, packet.getLength());
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}

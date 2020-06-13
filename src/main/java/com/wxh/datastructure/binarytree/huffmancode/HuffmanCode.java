package com.wxh.datastructure.binarytree.huffmancode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/18
 * @time: 下午10:20
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class HuffmanCode {
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    public static void main(String[] args) {
        /*
        String s = "i like like like java do you like a java";
        byte[] contentBytes = s.getBytes();
//        System.out.println(contentBytes);
        byte[] zipBytes = huffmanZip(contentBytes);
//        System.out.println(Arrays.toString(zipBytes));
//        System.out.println(bytes2String(zipBytes).length());
        byte[] decode = decode(huffmanCodes, zipBytes);
        System.out.println(new String(decode));
         */
//        String srcFile = "DefaultDesktop.jpg";
//        String dscFile = "DefaultDesktop.zip";
//        zipFile(srcFile, dscFile);

        String zipFile = "DefaultDesktop.zip";
        String dstFile = "DefaultDesktop1.jpg";
        unzipFile(zipFile, dstFile);
    }

    public static void unzipFile(String zipFile, String dstFile){
        InputStream is = null;
        ObjectInputStream ois = null;
        OutputStream os = null;
        try{
            is = new FileInputStream(zipFile);
            ois = new ObjectInputStream(is);
            byte[] huffmanCodes= (byte[])ois.readObject();
            Map<Byte, String> codes = (Map<Byte, String>) ois.readObject();
            byte[] bytes = decode(codes,huffmanCodes);
            os = new FileOutputStream(dstFile);
            os.write(bytes);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void zipFile(String srcFile, String dstFile){
        // 创建输出流
        FileOutputStream fos = null;
        // 创建文件输入流
        FileInputStream fis = null;
        // 对象输出流
        ObjectOutputStream oos = null;
        try {
            fis = new FileInputStream(srcFile);
            byte[] b = new byte[fis.available()];
            // 读取文件
            fis.read(b);
            // 对源文件进行压缩
            byte[] huffmanBytes = huffmanZip(b);
            // 创建文件输出流
            fos = new FileOutputStream(dstFile);
            oos = new ObjectOutputStream(fos);
            // 把编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);
            // 以对象流的方式写入霍夫曼编码，是为了以后恢复源文件时使用
            oos.writeObject(huffmanCodes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != fis){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != fos){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != oos){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 解码
     * @param huffmanCodes
     * @param huffmanBytes
     * @return
     */
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes){
        StringBuilder sb = bytes2String(huffmanBytes);
        Map<String, Byte> map = new HashMap<>();
        for(Map.Entry<Byte, String> entry : huffmanCodes.entrySet()){
            map.put(entry.getValue(), entry.getKey());
        }
        List<Byte> bytes = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for(int i=0; i<sb.length(); i++){
            temp.append(sb.charAt(i));
            if(map.containsKey(temp.toString())){
                bytes.add(map.get(temp.toString()));
                temp = new StringBuilder();
            }
        }
        byte[] b = new byte[bytes.size()];
        for(int i=0; i<bytes.size(); i++){
            b[i] = bytes.get(i);
        }
        return b;
    }

    static StringBuilder bytes2String(byte[] zipBytes){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<zipBytes.length; i++){
            boolean flag = !(i == zipBytes.length-1);
            sb.append(byte2String(zipBytes[i], flag));
        }
        return sb;
    }

    /**
     * 将一个byte转成一个二进制的字符串
     * @param b
     * @param flag 是否需要补码
     * @return
     */
    private static String byte2String(byte b, boolean flag){
        int temp = b;
        if(flag){
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if(flag){
            return str.substring(str.length()-8);
        }else {
            return str;
        }
    }


    /**
     * 霍夫曼压缩
     * @param bytes
     * @return
     */
    static byte[] huffmanZip(byte[] bytes){
        List<Node> nodes = getNodes(bytes);
        System.out.println(nodes);
        Node huffmanTree = createHuffmanTree(nodes);
        huffmanTree.preOrder();
        getCodes(huffmanTree);
        System.out.println(huffmanCodes);
        byte[] zipBytes = zip(bytes);
        return zipBytes;
    }

    static byte[] zip(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for(byte b : bytes){
            sb.append(huffmanCodes.get(b));
        }
        String s = sb.toString();
        int length = s.length()%8==0 ? s.length()/8 : s.length()/8+1;
        byte[] zip = new byte[length];
        int index = 0;
        for(int i=0; i<s.length(); i=i+8){
            int end = Math.min(i+8, s.length());
            String sub = s.substring(i, end);
            byte b = Integer.valueOf(sub, 2).byteValue();
            zip[index++] = b;
        }
        return zip;
    }

    static void getCodes(Node node){
        getCodes(node, null, new StringBuilder());
    }

    /**
     * 编码
     * @param node
     * @param code 路径：左子节点是0，右子节点是1
     * @param sb 用于拼接路径
     */
    private static void getCodes(Node node, String code, StringBuilder sb){
        if(node == null){
            return;
        }
        StringBuilder sb1 = new StringBuilder(sb);
        if(null != code){
            sb1.append(code);
        }
        if(node.data == null){
            getCodes(node.left, "0", sb1);
            getCodes(node.right, "1", sb1);
        }else {
            huffmanCodes.put(node.data, sb1.toString());
        }
    }

    public static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size() > 1){
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent = new Node(null, left.weight+right.weight);
            parent.left = left;
            parent.right = right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }


    public static List<Node> getNodes(byte[] bytes){
        List<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> map = new HashMap<>();
        for(byte b : bytes){
            if(map.containsKey(b)){
                map.put(b, map.get(b)+1);
            }else {
                map.put(b, 1);
            }
        }
        for(Map.Entry<Byte, Integer> entry : map.entrySet()){
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

}

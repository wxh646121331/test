package com.wxh.zookeeper.watchclient;

import com.wxh.zookeeper.watchclient.DataMonitor.DataMonitorListener;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/13
 * @time: 上午9:53
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class Executor implements Watcher, Runnable, DataMonitorListener {
    private String znode;
    private DataMonitor dm;
    private ZooKeeper zk;
    private String pathname;
    private String exec[];
    private Process child;

    public Executor(String hostPort, String znode, String pathname, String[] exec) throws IOException {
        this.pathname = pathname;
        this.exec = exec;
        zk = new ZooKeeper(hostPort, 3000, this);
        dm = new DataMonitor(zk, znode, this);
    }

    public static void main(String[] args) {
        if(args.length < 4){
            System.err.println("USAGE: Executor hostPost znode pathname program [args ...]");
            System.exit(2);
        }
        String hostPort = args[0];
        String znode = args[1];
        String pathName = args[2];
        String exec[] = new String[args.length-3];
        System.arraycopy(args, 3, exec, 0, exec.length);
        try{
            new Executor(hostPort, znode, pathName, exec).run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            synchronized (this){
                while (!dm.dead){
                    wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent event) {
        dm.handle(event);
    }

    @Override
    public void exists(byte[] data) {
        if(data == null){
            if(child != null){
                System.out.println("Killing handle");
                child.destroy();
                try {
                    child.waitFor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                child = null;
            }
        }else {
            if(child !=null){
                System.out.println("Stopping child");
                child.destroy();
                try{
                    child.waitFor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        try{
            FileOutputStream fos = new FileOutputStream(new File(pathname));
            fos.write(data);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            System.out.println("Starting child");
            child = Runtime.getRuntime().exec(exec);
            new StreamWriter(child.getInputStream(), System.out);
            new StreamWriter(child.getErrorStream(), System.err);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closing(int rc) {
        synchronized (this){
            notifyAll();
        }
    }

    static class StreamWriter extends Thread {
        OutputStream os;

        InputStream is;

        StreamWriter(InputStream is, OutputStream os) {
            this.is = is;
            this.os = os;
            start();
        }

        public void run() {
            byte b[] = new byte[80];
            int rc;
            try {
                while ((rc = is.read(b)) > 0) {
                    os.write(b, 0, rc);
                }
            } catch (IOException e) {
            }
        }
    }

    // executor.sh localhost:2181 /watch data/znode-data seq.sh
}

package com.wxh.zookeeper.watchclient;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.KeeperException.Code;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.Arrays;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/13
 * @time: 上午9:54
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class DataMonitor implements AsyncCallback.StatCallback {
    private ZooKeeper zk;
    private String znode;
    boolean dead;
    private DataMonitorListener listener;
    private byte prevData[];

    public DataMonitor(ZooKeeper zk, String znode, DataMonitorListener listener){
        this.zk = zk;
        this.znode = znode;
        this.listener = listener;
        zk.exists(znode, true, this, null);
    }

    public void handle(WatchedEvent event){
        String path = event.getPath();
        if(event.getType() == Watcher.Event.EventType.None){
            switch (event.getState()) {
                case SyncConnected:
                    break;
                case Expired:
                    dead = true;
                    listener.closing(KeeperException.Code.SessionExpired);
                    break;
            }
        }else {
            if(path != null && path.equals(znode)){
                zk.exists(znode, true, this, null);
            }
        }
    }

    @Override
    public void processResult(int rc, String path, Object ctx, Stat stat) {
        boolean exists;
        switch (rc){
            case Code.Ok:
                exists = true;
                break;
            case Code.NoNode:
                exists = false;
                break;
            case Code.SessionExpired:
            case Code.NoAuth:
                dead = true;
                    listener.closing(Code.SessionExpired);
                return;
            default:
                zk.exists(znode, true, this, null);
                return;
        }
        byte b[] = null;
        if(exists){
            try{
                b = zk.getData(znode, false, null);
            }catch (KeeperException e){
                e.printStackTrace();
            }catch (InterruptedException e){
                return;
            }
        }
        if((b==null && null!=prevData) || (b!=null && !Arrays.equals(prevData, b))){
            listener.exists(b);
            prevData = b;
        }
    }

    public static interface DataMonitorListener{
        void exists(byte data[]);
        void closing(int rc);
    }
}

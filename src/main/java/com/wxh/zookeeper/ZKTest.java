package com.wxh.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ZKTest {

    public ZooKeeper createZk() throws IOException {
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 50*1000, null);
        return zooKeeper;
    }

    public String createNode(ZooKeeper zooKeeper, String path, String value) throws Exception {
        return zooKeeper.create(path, value.getBytes("UTF-8"), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    public String getByPath(ZooKeeper zooKeeper, String path) throws KeeperException, InterruptedException {
        byte[] bytes = zooKeeper.getData(path, false, new Stat());
        return new String(bytes);
    }

    public void stop(ZooKeeper zooKeeper) throws InterruptedException {
        if(null != zooKeeper){
            zooKeeper.close();
        }
    }


    @Test
    public void test() throws Exception{
        ZKTest zkTest = new ZKTest();
        ZooKeeper zk = zkTest.createZk();
        String result = zkTest.createNode(zk, "/tsb", "123456");
        System.out.println("zkTest.createNode: "+result);
        String value = zkTest.getByPath(zk, "/tsb");
        System.out.println("value: " + value);
        zkTest.stop(zk);
    }

}

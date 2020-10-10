package com.example.demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.permission.FsPermission;
import org.apache.hadoop.hdfs.DistributedFileSystem;

import java.io.IOException;
import java.net.URI;
import org.apache.hadoop.fs.Path;

public class HaTest1 {

    public void test(){
        Configuration conf=new Configuration(false);
        String nameservices = "mycluster";
        String[] namenodesAddr = {"ochadoop111.jcloud.local:8020","ochadoop112.jcloud.local:8020"};
        String[] namenodes = {"nn1","nn2"};
        conf.set("fs.defaultFS", "hdfs://" + nameservices);
        conf.set("dfs.nameservices",nameservices);
        conf.set("dfs.ha.namenodes." + nameservices, namenodes[0]+","+namenodes[1]);
        conf.set("dfs.namenode.rpc-address." + nameservices + "." + namenodes[0], namenodesAddr[0]);
        conf.set("dfs.namenode.rpc-address." + nameservices + "." + namenodes[1], namenodesAddr[1]);
        conf.set("dfs.client.failover.proxy.provider." + nameservices,"org.apache.hadoop.hdfs.server.namenode.ha.ConfiguredFailoverProxyProvider");
        String hdfsRPCUrl = "hdfs://" + nameservices + ":" + 8020;
        DistributedFileSystem dfs = new DistributedFileSystem();
        try {
            dfs.initialize(URI.create(hdfsRPCUrl),conf);
            Path tmpPath2 = new Path("/tmp2");
            dfs.mkdir(tmpPath2,new FsPermission("777"));
            FileStatus[] list = dfs.listStatus(new Path("/"));
            for (FileStatus file : list) {
                System.out.println(file.getPath());
            }
            dfs.setQuota(tmpPath2,100,1000);
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                dfs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}

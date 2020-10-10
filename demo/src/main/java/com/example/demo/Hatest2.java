package com.example.demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;

import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class Hatest2 {

    public void test() throws Exception {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://HZWONE");
        conf.set("dfs.nameservices", "HZWONE");
        conf.set("fs.hdfs.impl","org.apache.hadoop.hdfs.DistributedFileSystem");
        conf.set("dfs.ha.namenodes.HZWONE", "nn1,nn2");
        conf.set("dfs.namenode.rpc-address.HZWONE.nn1", "hadoop-master-01:8020");
        conf.set("dfs.namenode.rpc-address.HZWONE.nn2", "hadoop-master-02:8020");
        //conf.setBoolean(name, value);
        conf.set("dfs.client.failover.proxy.provider.HZWONE", "org.apache.hadoop.hdfs.server.namenode.ha.ConfiguredFailoverProxyProvider");
        String path="/apps/hive/warehouse/";
        //String path="/apps/hive/warehouse/fdm";
        FileSystem fs = FileSystem.get(new URI(path), conf, "hive");
        //FSDataInputStream hdfsInStream = fs.open(new Path("hdfs:////apps/hive/warehouse/tmp"));
        // InputStreamReader isr = new InputStreamReader(hdfsInStream, "utf-8");
        RemoteIterator<LocatedFileStatus> fileIter= fs.listFiles(new Path(path),true);
        Map<String,Long> tableTimeStampMap = new HashMap<>();
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String firstName="";
        int i=0;
        try {
            while (fileIter.hasNext()){
                LocatedFileStatus file = fileIter.next();
                if(fs.exists(file.getPath())){
                    String table= file.getPath().toString().split("/")[7];
                    long time=file.getModificationTime();
                    if(tableTimeStampMap.containsKey(table)){
                        if(time>tableTimeStampMap.get(table)){
                            tableTimeStampMap.put(table,time);
                        }
                    }else {
                        i++;
                        //System.out.println(i+":"+table+":"+time);
                        tableTimeStampMap.put(table,time);
                    }
                    if(!firstName.equals(table)){
                        System.out.println(i+":"+table+" time:"+format.format(tableTimeStampMap.get(table)));
                        // tableTimeStampMap.clear();
                    }
                    firstName=table;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
        }
    }

}

package com.example.demo;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class cacheTest {
    /*public static void main(String[] args){
        *//*String sql = "SHOW FULL COLUMNS FROM `STUDENT`";
        String sql1[] =  sql.split("`");
        if(sql1.length>=2){
            String a = "select * from all_tab_columns where Table_Name='"+sql1[1]+"'";
            //select * from all_tab_columns where Table_Name='SDUTENT';
            //select * from dba_tab_columns where Table_Name='SDUTENT';
            System.out.print(a);
        }*//*
        String sql = "SHOW TABLE STATUS LIKE 'STU'";
        if (((sql.contains("SHOW TABLE STATUS") && !sql.contains("SHOW TABLE STATUS LIKE")) || sql.contains("SHOW FULL TABLES WHERE"))) {

            sql = "SELECT TABLE_NAME FROM ALL_TABLES WHERE OWNER IN ( )";
        }else if(sql.contains("SHOW FULL COLUMNS FROM") || sql.contains("SHOW TABLE STATUS LIKE")){
            String[] sqlSplit = sql.split("'");

            System.out.print("------改造后的sql---------"+sql);
        }
    }*/



    public static void main(String[] args) throws UnknownHostException, SocketException {
        /*InetAddress ia = InetAddress.getLocalHost();
        System.out.println("亲测有效"+what("172.18.1.15"));*/
        String sql = "desc STU";


        sql.trim().substring(4, sql.length()).trim();
        if(sql.trim().substring(0, 4).toUpperCase().contains("DESC")){
            System.out.println(sql);
        }

        if (sql.toUpperCase().contains("DESC")) {
            System.out.println(sql);
        }

        if(sql.toUpperCase().contains("DESC")){
            sql = "select * from user_tab_columns where table_name='"+sql.trim().substring(4,sql.length()).trim()+"'";
        }

        System.out.println(sql);
    }

    public static String what(String ip) throws SocketException, SocketException, UnknownHostException {
        NetworkInterface ne = NetworkInterface.getByInetAddress(InetAddress.getByName("172.18.1.15"));
        byte[] mac = ne.getHardwareAddress();
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < mac.length; i++) {
            if (i != 0) {
                sb.append("-");
            }
            //字节转换为整数
            int temp = mac[i] & 0xff;
            String str = Integer.toHexString(temp);
            System.out.println("每8位:" + str);
            if (str.length() == 1) {
                sb.append("0" + str);
            } else {
                sb.append(str);
            }
        }
        System.out.println(sb.toString().toUpperCase());
        return sb.toString().toUpperCase();
    }

}

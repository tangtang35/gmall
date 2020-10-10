package com.example.demo;

import java.sql.*;
import java.util.Arrays;

public class proxyTest {

    private static void oracleJdbc() throws SQLException {
        Connection con = null;// 创建一个数据库连接
        PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
        ResultSet result = null;// 创建一个结果集对象
        Statement stmt = null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
            System.out.println("开始尝试连接数据库！");
            String url = "jdbc:oracle:thin:@172.19.1.145:51511:orcl11g";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
            String user = "TCM_1";// 用户名,系统默认的账户名
            String password = "123456";// 你安装时选设置的密码
            con = DriverManager.getConnection(url, user, password);// 获取连接
            System.out.println("连接成功！");
            stmt = con.createStatement();
            String sql1 = "EXPLAIN PLAN FOR SELECT * FROM STU";
            String sql2 = "SELECT plan_table_output FROM TABLE(DBMS_XPLAN.DISPLAY('PLAN_TABLE'))";
            long t1=System.currentTimeMillis();
            stmt.execute(sql1);
            stmt.executeQuery(sql2);
            ResultSet resultSet = stmt.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
            System.out.println(System.currentTimeMillis()-t1);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
                // 注意关闭的顺序，最后使用的最先关闭
                if (result != null)
                    result.close();
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
                System.out.println("数据库连接已关闭！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void mysqlJdbc1(){
        String URL="jdbc:mysql://172.19.1.78:8066/proxyDB3";
        String USER="proxyUser";
        String PASSWORD="123456";
        //1.加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得数据连接
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            //3.使用数据库的连接创建声明
            Statement stmt = conn.createStatement();
            //4.使用声明执行SQL语句
            //String sql1 = "/*!mycat:sql=EXPLAIN PLAN FOR SELECT * FROM STU */";
            String sql1 = "EXPLAIN PLAN FOR SELECT * FROM STU";
            String sql2 = "SELECT plan_table_output FROM TABLE(DBMS_XPLAN.DISPLAY('PLAN_TABLE'))";
            stmt.execute(sql1);
            stmt.executeQuery(sql2);
            ResultSet resultSet = stmt.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    private static void mysqlJdbc2(){
        String URL="jdbc:mysql://172.19.1.78:8066/proxyDB3";
        String USER="proxyUser";
        String PASSWORD="123456";
        //1.加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得数据连接
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            //3.使用数据库的连接创建声明
            Statement stmt = conn.createStatement();
            //4.使用声明执行SQL语句
            String sql1 = "EXPLAIN PLAN FOR SELECT * FROM STU";
            String sql2 = "SELECT plan_table_output FROM TABLE(DBMS_XPLAN.DISPLAY('PLAN_TABLE'))";
            stmt.execute(sql1);
            stmt.executeQuery(sql2);
            ResultSet resultSet = stmt.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void mysqlJdbc(){
        String URL="jdbc:mysql://172.19.1.78:3306/test";
        String USER="root";
        String PASSWORD="Ankki_mySQL123";
        //1.加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得数据连接
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            //3.使用数据库的连接创建声明
            Statement stmt = conn.createStatement();
            //4.使用声明执行SQL语句
            String sql1 = "SELECT * FROM tcm";
            //stmt.execute(sql1);
            stmt.executeQuery(sql1);
            ResultSet resultSet = stmt.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        //mysqlJdbc1();
        /*String sql = "EXPLAIN PLAN FOR SELECT * FROM STU &&\n" +
                "SELECT plan_table_output FROM TABLE(DBMS_XPLAN.DISPLAY('PLAN_TABLE'));";
        String[] sqlSplit = sql.split("EXPLAIN PLAN FOR");
        if(sqlSplit.length==2){
            sql = sqlSplit[1];
            System.out.println(sql);
        }*/
        /*String sql = "SHOW FULL TABLES FROM `proxyDB1`";
        String[] sqlSplit = sql.split("`");
        if(sqlSplit.length>=2){
            String s = sqlSplit[1];
            System.out.println(s);
        }*/
        /*String sql = "cd";
        if ( sql.trim().substring(0, 4).toUpperCase().contains("DESC")) {
            System.out.println(sql);
        }*/


    }

}

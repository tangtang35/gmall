package com.example.demo.fusionInSight;

import java.sql.*;

public class HiveDemo {
    public static void main(String[] args) {
        // 参数初始化
        init();

        // 拼接JDBC URL
        String url = "jdbc:hive2://" + "172.19.1.109:24002" + "/default" +
                ";serviceDiscoveryMode=zooKeeper" +
                ";zooKeeperNamespace=hiveserver2" +
                ";sasl.qop=auth-conf" +
                ";auth=KERBEROS" +
                ";principal=hive/hadoop.hadoop.com@HADOOP.COM" +
                ";user.principal=devuser" +
                ";user.keytab=D:/user.keytab";

        // 加载Hive JDBC驱动
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver class not found!" + e.getMessage());
        }

        // 获取JDBC连接
        try (Connection connection = DriverManager.getConnection(url, "", "")) {
            String sql = "SELECT * FROM test";

            // 查询
            execDML(connection, sql);

        } catch (Exception e) {
            System.out.println("Create connection failed : " + e.getMessage());
        }
    }

    private static void init() {
        System.setProperty("java.security.krb5.conf", "D:\\krb5.conf");
        System.setProperty("zookeeper.server.principal", "zookeeper/hadoop.hadoop.com");
    }

    private static void execDML(Connection connection, String sql) {
        ResultSetMetaData resultMetaData;

        try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            // 执行HQL

            // 输出查询的列名到控制台
            resultMetaData = resultSet.getMetaData();
            int columnCount = resultMetaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(resultMetaData.getColumnLabel(i) + '\t');
            }
            System.out.println();

            // 输出查询结果到控制台
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + '\t');
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("execute HQL failed : " + e.getMessage());
        }
    }
}

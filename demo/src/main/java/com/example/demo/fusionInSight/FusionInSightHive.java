package com.example.demo.fusionInSight;

import java.sql.*;

public class FusionInSightHive {


    /**
     * 本示例演示了如何使用Hive JDBC接口来执行HQL命令<br>
     * <br>
     *
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws SQLException
     */
    public static void main(String[] args) throws InstantiationException,
            IllegalAccessException, ClassNotFoundException, SQLException {
        // 所连接的集群是否为安全版本
        boolean isSecureVer = true;
        // 设置krb5文件路径
        System.setProperty("java.security.krb5.conf", "D:\\FusionInSightHive\\krb5.conf");
        // Hive Server为HA模式，指定Zookeeper的ip和端口号来查询当前主HiveServer
        // 其中，zkQuorum的"xxx.xxx.xxx.xxx"为集群中Zookeeper所在节点的IP
        // String zkQuorum = "xxx.xxx.xxx.xxx";
        String zkQuorum = "172.19.1.109";
        // zkPort为集群中Zookeeper监听的端口号
        String zkPort = "21066";
        // 定义HQL，HQL为单条语句，不能包含“;”
        // String[] sqls =
        // {"CREATE TABLE IF NOT EXISTS employees_info(id INT,name STRING)",
        // "SELECT COUNT(*) FROM employees_info", "DROP TABLE employees_info"};
        String[] sqls = {
                "CREATE TABLE IF NOT EXISTS hive_test2(field_0 String,field_1 STRING,field_2 String,field_3 String,field_4 String)  row format delimited fields terminated by ','  stored as textfile",
                "load data inpath '/tmp/hivetest.txt' overwrite into table hive_test2",
                "select * from hive_test2 ", "DROP TABLE hive_test2"};
        // 拼接JDBC URL
        StringBuilder sBuilder = new StringBuilder(
                "jdbc:hive2://ha-cluster/default;zk.quorum=").append(zkQuorum)
                .append(";zk.port=").append(zkPort);
        if (isSecureVer) {
            // principal的构成是: user/group.realm
            // String userPrincipal = "yuemj/hadoop.hadoop.com";
            String userPrincipal = "hive/hadoop.hadoop.com@HADOOP.COM";
            // 客户端的keytab文件路径
            String userKeyTab = "D:\\FusionInSightHive\\hive.keytab";
            sBuilder.append(";user.principal=")
                    .append(userPrincipal)
                    .append(";user.keytab=")
                    .append(userKeyTab)
                    // 修改域同样需要修改这里的principal和zk.principal
                    .append(";sasl.qop=auth-conf;auth=KERBEROS;principal=hive/hadoop.hadoop.com@HADOOP.COM;zk.principal=zookeeper/hadoop.hadoop.com");
        }
        String url = sBuilder.toString();
        // 加载Hive JDBC驱动
        Class.forName("org.apache.hive.jdbc.HiveDriver").newInstance();
        Connection connection = null;
        try {
            // 获取JDBC连接
            connection = DriverManager.getConnection(url, "", "");
            // 建表
            // 表建完之后，如果要往表中导数据，可以使用LOAD语句将数据导入表中，比如从HDFS上将数据导入表:
            // load data inpath '/tmp/employees.txt' overwrite into table
            // employees_info;
            execDDL(connection, sqls[0]);
            // execDDL(connection,sqls[1]);//加载数据
            System.out.println("Create table success!");
            // 暂停3秒
            Thread.sleep(3000);
            // 查询
            execDML(connection, sqls[2]);
            // 删表
            // execDDL(connection,sqls[2]);
            // System.out.println("Delete table success!");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // 关闭JDBC连接
            if (null != connection) {
                connection.close();
            }
        }
    }

    public static void execDDL(Connection connection, String sql)
            throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.execute();
        } finally {
            if (null != statement) {
                statement.close();
            }
        }
    }

    public static void execDML(Connection connection, String sql)
            throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ResultSetMetaData resultMetaData = null;

        try {
            // 执行HQL
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
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
        } finally {
            if (null != resultSet) {
                resultSet.close();
            }

            if (null != statement) {
                statement.close();
            }
        }
    }
}

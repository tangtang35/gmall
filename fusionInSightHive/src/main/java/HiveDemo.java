import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.security.UserGroupInformation;

import java.sql.*;
public class HiveDemo {
    public static void main(String[] args) throws Exception {
        // 参数初始化

        // 拼接JDBC URL
        String url = "jdbc:hive2://" + "172.19.1.109:24002" + "/default" +
                ";serviceDiscoveryMode=zooKeeper" +
                ";zooKeeperNamespace=hiveserver2"+
                ";sasl.qop=auth-conf" +
                ";auth=KERBEROS" +
                ";principal=hive/hadoop.hadoop.com@HADOOP.COM "+//hive/hadoop.hadoop.com@HADOOP.COM devuser@HADOOP.COM
                ";user.principal=devuser" +
                ";user.keytab=D:/user.keytab";


        System.setProperty("java.security.krb5.conf", "D:/krb5.conf");
//        System.setProperty("sun.security.krb5.debug", "true");

        System.setProperty("zookeeper.server.principal", "zookeeper/hadoop.hadoop.com");
        Configuration config = new Configuration();
//        config.set("hadoop.security.authentication", "Kerberos");
        UserGroupInformation.setConfiguration(config);
        UserGroupInformation.loginUserFromKeytab("hive/hadoop.hadoop.com@HADOOP.COM ", "D:/user.keytab");

        String driver = "org.apache.hive.jdbc.HiveDriver";
//        String jdbc = "jdbc:hive2://172.19.1.109:24002/default;" +
//                "principal=hive/hadoop.hadoop.com@HADOOP.COM";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url);
        System.out.println(connection);
        String sql = "SELECT * FROM test";
        // 查询
        execDML(connection, sql);
        // jdbc:hive2://172.19.1.109:24002/default
        // ;serviceDiscoveryMode=zooKeeper
        // ;zooKeeperNamespace=hiveserver2
        // ;sasl.qop=auth-conf
        // ;auth=KERBEROS
        // ;principal=zookeeper/hadoop.hadoop.com
        // ;user.principal=devuser,kerberosFlag=1
    }

    public static void execDML(Connection connection, String sql) {
        ResultSetMetaData resultMetaData;

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
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


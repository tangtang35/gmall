package com.example.demo;

import com.sun.tools.javac.util.StringUtils;
import oracle.jdbc.internal.OracleTypes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class testOracle {
    public static void main(String[] args) throws SQLException {
        /*testOracle testOracle = new testOracle();
        String str = "SELECT TRANSLATE(test.country, '中国', '唐生') as country FROM test.123";
        testOracle.str(str);*/
        //oracleJdbc();
    }




    public String str(String a){
        if(a.toUpperCase().contains("TRANSLATE")){
            String[] strings1 = a.split("\\.");
            String strings3 = strings1[1].split(",")[0].replace("\"", "");
        }
        return a;
    }

    //金额验证
    public static boolean isNumber(String str)
    {
        java.util.regex.Pattern pattern=java.util.regex.Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$"); // 判断小数点后2位的数字的正则表达式
        java.util.regex.Matcher match=pattern.matcher(str);
        if(match.matches()==false)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public static Map<String,String> getStringToMap(String str){
        //感谢bojueyou指出的问题
        //判断str是否有值
        if(null == str || "".equals(str)){
            return null;
        }
        //根据&截取
        String[] strings = str.split("&");
        //设置HashMap长度
        int mapLength = strings.length;
        //判断hashMap的长度是否是2的幂。
        if((strings.length % 2) != 0){
            mapLength = mapLength+1;
        }

        Map<String,String> map = new HashMap<>(mapLength);
        //循环加入map集合
        for (int i = 0; i < strings.length; i++) {
            //截取一组字符串
            String[] strArray = strings[i].split("=");
            //strArray[0]为KEY  strArray[1]为值
            map.put(strArray[0],strArray[1]);
        }
        return map;
    }

    private static String tryFinallyReturn() {
        String str = null;
        try {
            boolean boo1 = str.equals("");
            boolean boo2 = str != null;
            str = "1";
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("2:" + str);
            return str;
        } finally {
            System.out.print("3:" + str);
            str = "2";
            System.out.print("4:" + str);
            return str;
        }
    }

    private static void oracleJdbc() throws SQLException {
        Connection conn = null;// 创建一个数据库连接
        PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
        ResultSet result = null;// 创建一个结果集对象
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
            System.out.println("开始尝试连接数据库！");
            String url = "jdbc:oracle:thin:@172.19.1.145:51511:orcl11g";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
            String user = "scott";// 用户名,系统默认的账户名
            String password = "Ceshi123";// 你安装时选设置的密码
            conn = DriverManager.getConnection(url, user, password);// 获取连接
            System.out.println("连接成功！");
            Statement statement = null;
            //创建存储过程
            /*String sql = "CREATE OR REPLACE PROCEDURE getEmpCount352(v_count OUT NUMBER)\n" +
                    "AS\n" +
                    "BEGIN\n" +
                    " SELECT COUNT(*) INTO v_count FROM STU;\n" +
                    "end;";
            statement = con.createStatement();
            statement.executeUpdate(sql);*/

            //自定义函数
            String sql = "create or replace function function6(para1 in number, para2 in number)   \n" +
                    "return number   \n" +
                    "as   \n" +
                    "begin  \n" +
                    "  if para1 > para2 then  \n" +
                    "      return para1;  \n" +
                    "  else  \n" +
                    "      return para2;   \n" +
                    "  end if;  \n" +
                    "end;";
            //statement = con.createStatement();
            //int a = statement.executeUpdate(sql);
            //System.out.print("-------------:"+a);

            //创建存储过程的对象
            CallableStatement c=conn.prepareCall("{call delePro(?)}");

            c.setInt(1,1);

            c.execute();

            ResultSet rs=c.executeQuery();

            while(rs.next())
            {
                String Stu=rs.getString("addr");

            }
            c.close();



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
                // 注意关闭的顺序，最后使用的最先关闭
                if (result != null)
                    result.close();
                if (pre != null)
                    pre.close();
                if (conn != null)
                    conn.close();
                System.out.println("数据库连接已关闭！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private static void oracleJdbc1() throws SQLException {
        Connection con = null;// 创建一个数据库连接
        PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
        ResultSet result = null;// 创建一个结果集对象

        Statement stmt = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
            System.out.println("开始尝试连接数据库！");
            String url = "jdbc:oracle:thin:@172.19.1.145:51511:orcl11g";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
            String user = "TCM_1";// 用户名,系统默认的账户名
            String password = "123456";// 你安装时选设置的密码
            con = DriverManager.getConnection(url, user, password);// 获取连接
            System.out.println("连接成功！");
            //String sql = "SELECT * FROM \"USERLOGIN\" ";// 预编译语句，“？”代表参数
            stmt = con.createStatement();
            //sql = "select * from STU";
            String sql1 = "EXPLAIN PLAN FOR SELECT * FROM STU";
            String sql2 = "SELECT plan_table_output FROM TABLE(DBMS_XPLAN.DISPLAY('PLAN_TABLE'))";

            long t1 = System.currentTimeMillis();
            stmt.execute(sql1);
            stmt.executeQuery(sql2);
            ResultSet resultSet = stmt.getResultSet();
            while (resultSet.next()) {
//            executionPlan = resultSet.getSQLXML(1).getString();


                System.out.println(resultSet.getString(1));

                if (resultSet.getString(1).indexOf("name=\"TABLE ACCESS\" options=\"FULL\"") > 0) {
                    System.out.println(resultSet.getString(1));
                }

            }
            System.out.println(System.currentTimeMillis() - t1);






            /*sql = "MERGE INTO TCM_MERGE_1 A USING (select B.AID,B.NAME,B.YEAR from TCM_MERGE_2 B) C ON (A.id=C.AID)\n" +
                    "WHEN MATCHED THEN\n" +
                    "  UPDATE SET A.YEAR=C.YEAR \n" +
                    "WHEN NOT MATCHED THEN\n" +
                    "  INSERT(A.ID,A.NAME,A.YEAR) VALUES(C.AID,C.NAME,C.YEAR)";*/

            //result = stmt.executeQuery(sql);

            //result = stmt.executeQuery(sql);

            //boolean bb = stmt.execute(sql);


            //pre.setString(1, "小茗同学");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引

            /*while (result.next()){
                // 当结果集不为空时
                System.out.println("NAME:" + result.getString("NAME"));
            }
*/
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

    private static void mysqlJdbc() {
        String URL = "jdbc:mysql://172.19.1.65:3306/test";
        String USER = "root";
        String PASSWORD = "Ankki_mySQL123";
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

            long t1 = System.currentTimeMillis();
            stmt.execute(sql1);
            stmt.executeQuery(sql2);
            ResultSet resultSet = stmt.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
            System.out.println(System.currentTimeMillis() - t1);

            //5.读取数据库的信息
            /**
             *boolean next() 方法 如果新的当前行有效，则返回 true；如果不存在下一行，则返回 false
             * 将光标从当前位置向前移一行。ResultSet 光标最初位于第一行之前；第一次调用 next 方法使第一行成为当前行；第二次调用使第二行成为当前行，依此类推。
             */
            /*while(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("username");
                String pwd = rs.getString("pwd");
                System.out.println(id+" 用户名："+name+"密码："+pwd);
            }*/
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    private static void mysqlJdbc1() {
        String URL = "jdbc:mysql://172.19.1.78:8066/proxyDB3";
        String USER = "proxyUser";
        String PASSWORD = "123456";
        //1.加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得数据连接
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            //3.使用数据库的连接创建声明
            Statement stmt = conn.createStatement();
            //4.使用声明执行SQL语句

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

}

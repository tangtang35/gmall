package com.example.demo;

import java.sql.*;

public class Dm7Test {

    private void dmTestConnect() {

    try{
        String driver= "dm.jdbc.driver.DmDriver";
        String url= "jdbc:dm://172.19.1.200:12345/TEST";
        String username="SYSDBA";
        String password="SYSDBA";

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        Boolean bo = stmt.execute("SET SCHEMA TEST");
        ResultSet rs = stmt.executeQuery("SELECT * FROM TEST");
        int newID = 1;
        if (rs.next()) {
            String userName = rs.getString("IP");
            System.out.println("userName:" +userName);
        }else{
            System.out.println("no data");
        }
        rs.close();
        conn.close();


        } catch ( SQLException e) {

        } catch (ClassNotFoundException fe) {

        }
    }

    public static void main(String[] args) {
        Dm7Test dm7Test = new Dm7Test();
        dm7Test.dmTestConnect();
    }

}

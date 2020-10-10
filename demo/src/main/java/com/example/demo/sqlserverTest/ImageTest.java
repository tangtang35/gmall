package com.example.demo.sqlserverTest;


import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;

public class ImageTest {

    public static void main(String[] args) {
        Object object ="2020-09-24 07:12:31.0";
        Timestamp timestamp = null;
        try {
            System.out.println("------1-----");
            timestamp = (Timestamp) object;
        } catch (Exception e) {
            System.out.println("------2-----");
            timestamp = Timestamp.valueOf(object.toString());
        }
        System.out.println("------2-----"+ timestamp);

        /*ImageTest imageTest = new ImageTest();
        imageTest.timeLimit("0033-01-01","yyyy-MM-dd","1900-01-01");

        Pattern p = Pattern.compile("U");
        String instring = "UBIGINT";
        Matcher m = p.matcher(instring);
        String tmp = m.replaceFirst("UNSIGNED ");
        System.out.println("String after replacing 1st Match: " + tmp);//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/javaexamples/regular_replacefirst.html



        byte[] strChar=new byte[1024];
        strChar[0]=1;
        strChar[1]=-11;
        strChar[2]=10;
        strChar[3]=121;

        String result="";

        String result1=new String(strChar);
        for(int i=0;i<strChar.length;i++){
            result +=Integer.toBinaryString(strChar[i])+ " ";
        }
        Timestamp.valueOf(result1);
        new java.sql.Timestamp(Long.parseLong(result));

        System.out.println(result+"----------"+result1);*/
        /*try {
            ImageTest t = new ImageTest();
            t.writeFileToDb("E:/TCM1.jpg");
            t.readImgFromDb("E:/TCM1.jpg", "E:/TCM2.jpg");
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/
    }

    public boolean timeLimit(String inputTime,String timeFormat,String timeLimit){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
            Date date1 = sdf.parse(timeLimit);
            Date date2 = sdf.parse(inputTime);
            if (date1.compareTo(date2) > 0) {
                return true;
            } else if (date1.compareTo(date2) < 0) {
                return false;
            } else if (date1.compareTo(date2) == 0) {
                return true;
            } else {
                return false;
            }
        }catch (ParseException e) {
            return false;
        }
    }


    public Connection getCon() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://172.23.1.79:1433;DatabaseName=test";
            DriverManager.setLoginTimeout(1);
            Connection con = DriverManager.getConnection(url, "sa", "Ceshi123");
            return con;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void writeFileToDb(String fileName) {
        System.out.println("Writing to database... from file:" + fileName);
        Connection con = null;
        try {
            con = getCon();
            File myFile = new File(fileName);
            InputStream in = new FileInputStream(myFile);
            String sql = "insert into Table_1 (picname,pic) values(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fileName);
            ps.setBinaryStream(2, in, (int) myFile.length());
            int result = ps.executeUpdate();
            if (result > 0)
                System.out.println("Writing to database picfile success");
            else
                System.out.println("Writing to database picfile error");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                con = null;
            }
        }
    }


    public void readImgFromDb(String picName, String newName) {
        System.out.println("Reading from database to file:" + newName);
        Connection con1 = null;
        Connection con2 = null;
        try {
            con1 = getCon();
            con2 = getCon();

            Statement st = con1.createStatement();
            ResultSet rs = st.executeQuery("select * from Table_1 where picname='" + picName + "'");
            if (rs.next()) {
                System.out.println(rs.getString("picname"));
                InputStream ins = rs.getBinaryStream("pic");

                String sql = "insert into Table_1 (picname,pic) values(?,?)";
                PreparedStatement ps = con2.prepareStatement(sql);
                ps.setString(1, "1111");
                ps.setBinaryStream(2, ins, (int) ins.read());
                //int result = ps.executeUpdate();
                int result[] = ps.executeBatch();
                /*if (result > 0)
                    System.out.println("Writing to database picfile success");
                else
                    System.out.println("Writing to database picfile error");*/

                ins.close();

                System.out.println("Reading from database to file " + newName + " success");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (con1 != null) {
                try {
                    con1.close();
                    con2.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            con1 = null;
            con2 = null;
        }
    }
}

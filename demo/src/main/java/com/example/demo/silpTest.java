package com.example.demo;

public class silpTest {
    public String spilt(String str,String aa) {
        if(str.contains("SELECT * FROM `"+aa+"`.`")){
            //截取到表名
            String[] str1 = str.split("`");
            str = "SELECT * FROM "+str1[3]+str.substring(str.lastIndexOf("`")+1);
        }
        System.out.println(str);
        return str;

        /*StringBuffer sb = new StringBuffer();
        String[] temp = str.split(",");
        for (int i = 0; i < temp.length; i++) {
            if (!"".equals(temp[i]) && temp[i] != null)
                sb.append("'" + temp[i] + "',");
        }
        String result = sb.toString();
        String tp = result.substring(result.length() - 1, result.length());
        if (",".equals(tp))
            return result.substring(0, result.length() - 1);
        else
            return result;*/
    }


    public static void main(String[] arg) {
        /*silpTest ss = new silpTest();
        String str = ss.spilt("SELECT * FROM `proxyDB1`.`STUDENT` LIMIT 0,1000","proxyDB1");
        System.out.println(str);*/


        String sql = "SELECT * FROM `STUDENT` LIMIT 0, 1000";


        //oracle分页语句
        String[] sqlSplit = sql.split("`");
        String[] pagination = sqlSplit[4].split(",");
        String startPage = pagination[0].trim().substring(5,pagination[0].trim().length());
        String endPage = pagination[1];
        sql = "SELECT * FROM( SELECT ROWNUM AS rowno, t.* FROM \""+sqlSplit[3]+"\" t WHERE ROWNUM <= "+endPage+" ) table_alias WHERE table_alias.rowno >= "+startPage;




        if(!"ID".equals("")){
            //字段设置可以为空
            System.out.println("-----------");
        }
        System.out.println("\""+1111+"\"");
    }
}

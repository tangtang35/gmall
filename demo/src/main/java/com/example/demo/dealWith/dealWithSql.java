package com.example.demo.dealWith;

import org.apache.commons.lang.time.DateUtils;

import java.sql.Timestamp;
import java.util.Arrays;

public class dealWithSql {
    public static void main(String args[]) {
        //sql = "select * from SC001 LIMIT 50";
        /*sql = "SELECT * FROM `sourace-orcale-145-tcm-1`.`STU` LIMIT 0,1000";
        if (sql.toUpperCase().contains("LIMIT")) {
            //MySQL Workbench工具支持limit限制
            String[] sqlSplit = sql.toUpperCase().split("LIMIT");
            String[] sqlSplitNavicat = sql.split("`");
            //不影响Navicat的双击表名功能
            if (sqlSplit.length > 0 && !(sqlSplitNavicat.length >= 4 && sql.contains("SELECT * FROM `sourace-orcale-145-tcm-1`.`" + sqlSplitNavicat[3]))) {
                String[] page = sqlSplit[1].split(",");
                if (page.length > 1) {
                    sql = "select * from(select a.*,ROWNUM rn from(" + sqlSplit[0] + ") a where ROWNUM<=(" + page[1] + ")) where rn>" + page[0];
                } else {
                    sql = "select * from(select a.*,ROWNUM rn from(" + sqlSplit[0] + ") a where ROWNUM<=(" + page[0] + ")) where rn>" + 0;
                }
            }
        }
        System.out.print(sql);*/

        /*String sql = "SELECT * FROM `sourace-orcale-145-tcm-1`.`SC002` LIMIT 0,1000";
        String[] sqlSplitNavicat = sql.split("`");
        if ( !(sqlSplitNavicat.length == 5 && sql.contains("SELECT * FROM `sourace-orcale-145-tcm-1`.`" + sqlSplitNavicat[3]))) {
            System.out.print(sqlSplitNavicat);
        }*/


        String sql = "create sequence TCM_SE351 minvalue 1 maxvalue 999999999999999999999999999 start with 15 increment by 1 nocache";
        sql = "create user zzc identified by 123456;";
        String sql_list="CREATE SEQUENCE,GRANT,CREATE,ALTER,REVOKE";
        String[] sqlList = sql_list.split(",");
        for(String str : Arrays.asList(sqlList)){
            if(sql.toUpperCase().contains(str.toUpperCase())){
                sql = "/*!mycat:sql=select * from ANKKI; */"+sql;
                System.out.print(sql);
                break;
            }
        }

    }
}

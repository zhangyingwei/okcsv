package com.zhangyingwei.okcsv.csv.impl;


import com.zhangyingwei.okcsv.config.CsvConfig;
import com.zhangyingwei.okcsv.handler.SqlHandler;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangyingwei1@chanct.com
 * @date: 2017/1/10
 * @time: 11:42
 * @desc:
 */
public class CsvExporterTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        CsvExporter exporter = new CsvExporter(new CsvConfig()
                .setSpliter(",")
                .setPageSize(5000)
        );
        String url = "jdbc:mysql://10.250.82.104:3306/hn_fraud";
        String user = "root";
        String passwd = "123456";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, passwd);
        Statement state1 = conn.createStatement();
        Statement state2 = conn.createStatement();
        Statement state3 = conn.createStatement();
        Statement state4 = conn.createStatement();
        ResultSet result1 = state1.executeQuery("select * from c_fraudsms_areacode");
        ResultSet result2 = state2.executeQuery("select * from s_call_evil_cdr");
        ResultSet result3 = state3.executeQuery("select * from user_log");
        ResultSet result4 = state4.executeQuery("select * from s_voice_becalled_dcnt");
        exporter.export(new SqlHandler(result1),"csv/c_fraudsms_areacode.csv");
        exporter.export(new SqlHandler(result2),"csv/s_call_evil_cdr.csv");
        exporter.export(new SqlHandler(result3),"csv/user_log.csv");
        exporter.export(new SqlHandler(result4),"csv/s_voice_becalled_dcnt.csv");
    }
}
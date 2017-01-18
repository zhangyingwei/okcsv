package com.zhangyingwei.okcsv.csv.impl;


import com.zhangyingwei.okcsv.config.CsvConfig;
import com.zhangyingwei.okcsv.handler.DefaultHandler;
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
public class DefalutCsvExporterTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        CsvExporter exporter = new CsvExporter(new CsvConfig()
                .setSpliter(",")
                .setPageSize(20)
        );
        List<String[]> items = new ArrayList<String[]>();
        for(int i = 0;i<185;i++){
            items.add(new String[]{"a","a","a","a","a","a","a","a"});
        }
        exporter.export(new DefaultHandler(items));
    }
}
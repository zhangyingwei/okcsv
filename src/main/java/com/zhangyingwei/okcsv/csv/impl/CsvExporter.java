package com.zhangyingwei.okcsv.csv.impl;

import com.zhangyingwei.okcsv.config.CsvConfig;
import com.zhangyingwei.okcsv.config.CsvConfig;
import com.zhangyingwei.okcsv.csv.Exporter;
import com.zhangyingwei.okcsv.entity.CsvEntity;
import com.zhangyingwei.okcsv.handler.DefaultHandler;
import com.zhangyingwei.okcsv.handler.Handler;
import com.zhangyingwei.okcsv.handler.SqlHandler;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 * @author: zhangyingwei1@chanct.com
 * @date: 2017/1/9
 * @time: 23:05
 * @desc: csv数据导出
 */
public class CsvExporter implements Exporter {
    private final CsvConfig config;
    private FileExporter fileExporter;
    public CsvExporter(CsvConfig config){
        fileExporter = new FileExporter();
        this.config = config;
    }
    public void export(Handler handler) throws IOException {
        this.export(handler.setConfig(config), this.getCsvPath());
    }
    public void export(Handler handler, String path) throws IOException {
        this.fileExporter.export(handler.setConfig(config), path);
    }
    public String getCsvPath() {
        return "./"+new Date().getTime()+this.config.getFileSuffix();
    }
}

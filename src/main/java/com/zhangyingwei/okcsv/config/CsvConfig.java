package com.zhangyingwei.okcsv.config;

/**
 * @author: zhangyingwei1@chanct.com
 * @date: 2017/1/9
 * @time: 22:17
 * @desc: csv配置
 */
public class CsvConfig {
    private int pageSize = -1;
    private String spliter = ",";
    private String fileSuffix = ".csv";

    public int getPageSize() {
        return pageSize;
    }

    public CsvConfig setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public String getSpliter() {
        return spliter;
    }

    public CsvConfig setSpliter(String spliter) {
        this.spliter = spliter;
        return this;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public CsvConfig setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
        return this;
    }
}

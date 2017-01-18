package com.zhangyingwei.okcsv.entity;

import com.zhangyingwei.okcsv.config.CsvConfig;

/**
 * @author: zhangyingwei1@chanct.com
 * @date: 2017/1/9
 * @time: 22:34
 * @desc:
 */
public class CsvEntity {
    private String[] keys;
    private String[] csvItems;
    public CsvEntity(CsvConfig config,String line){
        csvItems = line.split(config.getSpliter());
    }
    public CsvEntity(String[] csvItems) {
        this.csvItems = csvItems;
    }
    public String[] getCsvItems() {
        return csvItems;
    }
    public CsvEntity setCsvItems(String[] csvItems) {
        this.csvItems = csvItems;
        return this;
    }
    public String toLine(CsvConfig config){
        StringBuffer result = new StringBuffer();
        String spliter = config.getSpliter();
        for (int i = 0;i<csvItems.length;i++) {
            result.append(csvItems[i]);
            if(i+1 < csvItems.length){
                result.append(config.getSpliter());
            }
        }
        return result.toString();
    }
    public String[] getKeys() {
        return keys;
    }
    public CsvEntity setKeys(String[] keys) {
        this.keys = keys;
        return this;
    }
}

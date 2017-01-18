package com.zhangyingwei.okcsv.handler;

import com.zhangyingwei.okcsv.config.CsvConfig;
import com.zhangyingwei.okcsv.entity.CsvEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangyingwei1@chanct.com
 * @date: 2017/1/10
 * @time: 10:30
 * @desc:
 */
public class DefaultHandler implements Handler {
    private List<CsvEntity> entities;
    private CsvConfig config;

    public DefaultHandler(List<String[]> items) {
        this.entities = new ArrayList<CsvEntity>();
        for (String[] item : items) {
            entities.add(new CsvEntity(item));
        }
    }

    public List<CsvEntity> resultList() {
        return entities;
    }

    public Handler setConfig(CsvConfig config) {
        this.config = config;
        return this;
    }

    public CsvConfig getConfig() {
        return this.config;
    }
}

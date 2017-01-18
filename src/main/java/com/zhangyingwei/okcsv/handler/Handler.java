package com.zhangyingwei.okcsv.handler;

import com.zhangyingwei.okcsv.config.CsvConfig;
import com.zhangyingwei.okcsv.entity.CsvEntity;

import java.util.List;

/**
 * @author: zhangyingwei1@chanct.com
 * @date: 2017/1/10
 * @time: 10:31
 * @desc:
 */
public interface Handler {
    public List<CsvEntity> resultList();
    Handler setConfig(CsvConfig config);
    CsvConfig getConfig();
}

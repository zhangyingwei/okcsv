package com.zhangyingwei.okcsv.csv;

import com.zhangyingwei.okcsv.entity.CsvEntity;
import com.zhangyingwei.okcsv.handler.Handler;

import java.io.IOException;
import java.util.List;

/**
 * @author: zhangyingwei1@chanct.com
 * @date: 2017/1/9
 * @time: 22:25
 * @desc: 数据导出接口
 */
public interface Exporter {
    void export(final Handler handler, final String path) throws IOException;
}

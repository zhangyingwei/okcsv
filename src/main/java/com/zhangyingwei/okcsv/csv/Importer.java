package com.zhangyingwei.okcsv.csv;

import java.sql.ResultSet;

/**
 * @author: zhangyingwei1@chanct.com
 * @date: 2017/1/9
 * @time: 22:26
 * @desc: 数据导入接口
 */
public interface Importer {
    void iimport(String filePath);
    void iimport(ResultSet resultSet);
}

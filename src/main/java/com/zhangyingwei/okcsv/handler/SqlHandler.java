package com.zhangyingwei.okcsv.handler;

import com.zhangyingwei.okcsv.config.CsvConfig;
import com.zhangyingwei.okcsv.entity.CsvEntity;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhangyingwei1@chanct.com
 * @date: 2017/1/10
 * @time: 10:23
 * @desc: sql处理代码
 */
public class SqlHandler implements Handler {
    private ResultSet resultSet;
    private CsvConfig config;

    public SqlHandler(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public List<CsvEntity> resultList() {
        List<Map<String, String>> result = this.getKVResult();
        return this.getCsvEntitys(result);
    }

    public Handler setConfig(CsvConfig config) {
        this.config = config;
        return this;
    }

    public CsvConfig getConfig() {
        return this.config;
    }

    private List<CsvEntity> getCsvEntitys(List<Map<String, String>> result) {
        List<CsvEntity> entities = new ArrayList<CsvEntity>();
        for (Map<String, String> map : result) {
            List<String> keys = new ArrayList<String>(map.keySet());
            entities.add(new CsvEntity(map.values().toArray(new String[map.size()])).setKeys(keys.toArray(new String[keys.size()])));
        }
        return entities;
    }

    private List<Map<String,String>> getKVResult(){
        List<Map<String,String>> list = new ArrayList<Map<String, String>>();
        try {
            ResultSetMetaData metaData = this.resultSet.getMetaData();
            while(this.resultSet.next()){
                Map<String,String> map = new LinkedHashMap<String, String>();
                int count = metaData.getColumnCount();
                for(int i = 1;i<=count;i++){
                    String columnName = metaData.getColumnName(i);
                    Object value = this.resultSet.getObject(i);
                    map.put(columnName,String.valueOf(value));
                }
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(this.resultSet!=null){
                try {
                    this.resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}

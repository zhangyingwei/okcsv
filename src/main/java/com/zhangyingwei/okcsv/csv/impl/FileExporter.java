package com.zhangyingwei.okcsv.csv.impl;

import com.zhangyingwei.okcsv.config.CsvConfig;
import com.zhangyingwei.okcsv.csv.Exporter;
import com.zhangyingwei.okcsv.entity.CsvEntity;
import com.zhangyingwei.okcsv.handler.Handler;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author: zhangyingwei1@chanct.com
 * @date: 2017/1/9
 * @time: 23:08
 * @desc: 文件导出
 */
public class FileExporter implements Exporter {
    public void export(Handler handler, String path) throws IOException {
        CsvConfig config = handler.getConfig();
        List<CsvEntity> entitys = handler.resultList();
        System.out.println("total-size:"+entitys.size());
        if (this.validPath(path)) {
            BufferedWriter writer = null;
            try {
                for (int i = 0;i<entitys.size();i++) {
                    writer = this.getBufferReader(writer,handler, path, i);
                    writer.write(entitys.get(i).toLine(config));
                    this.newLine(handler, writer, entitys, i);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(writer!=null){
                    writer.close();
                }
            }
        }
    }

    private void newLine(Handler handler, BufferedWriter writer,List<CsvEntity> entitys, int index) throws IOException {
        if(handler.getConfig().getPageSize()==-1){
            if(index+1<entitys.size()){
                writer.newLine();
            }
        }else{
            if(index+1 < entitys.size() && (index%handler.getConfig().getPageSize()+1)<handler.getConfig().getPageSize()){
                writer.newLine();
            }
        }
    }

    private boolean validPath(String path) {
        return path != null;
    }

    /**
     * 获取一个文件输出流
     *
     * @param handler
     * @param path
     * @return
     * @throws IOException
     */
    public BufferedWriter getBufferReader(BufferedWriter writer,Handler handler, String path,int index) throws IOException {
        path = this.getPath(handler,path);
        if(handler.getConfig().getPageSize()==-1 && index == 0){
            System.out.println("new File["+path+"]");
            writer = new BufferedWriter(new FileWriter(path));
        }else if(handler.getConfig().getPageSize() != -1){
            if((index%handler.getConfig().getPageSize()) == 0){
                if(writer!=null){
                    writer.close();
                }
                System.out.println("new File["+path+"]");
                writer = new BufferedWriter(new FileWriter(path));
            }
        }
        return writer;
    }

    private String getPath(Handler handler , String path) {
        if(handler.getConfig().getPageSize() != -1){
            path = path.replace(handler.getConfig().getFileSuffix(), "-"+ UUID.randomUUID() + handler.getConfig().getFileSuffix());
        }
        return path;
    }
}

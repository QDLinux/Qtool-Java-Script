
























//最初不认识，最后不相识。













































































package com.discover.parse;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
public void Create(String Path){
File dir = null;try{dir = new File(Path);
if(!dir.exists()){dir.mkdirs();}}catch(Exception e){Toast(e);}
}
private long getFileSize(File file) {//将文件转为字节
    long length = file.length();
    return length;
}
private String formatSize(long fileS) {//通过字节计算文件大小
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        String wrongSize = "0B";
        if (fileS == 0) {
            return wrongSize;
        }
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";//字节小于1024返回B,下面以此类推
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "KB";//
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "MB";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "GB";
        }
        return fileSizeString;
    }
    public String readprop(String file,String name2)//prop解析,代码来自(偷)qtool
    {
String PropFile = file;
Properties props = new Properties();
props.load(new StringReader(read(PropFile)));
String name = props.getProperty(name2);
return name;
}
public String Judge(String path){
File file = new File(path);//判断是否存在文件
boolean flag = file.exists();
if(flag){return "true";}else{return "false";}}
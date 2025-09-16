package com.oped.file.zip;
import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import android.widget.Toast;
public class ZipUtil{
    private static int BUFFER = 1024;
    public static void unzip(String filePath,String zipDir){
        String name = "";
        try{
            BufferedOutputStream dest = null;
            BufferedInputStream is = null;
            ZipEntry entry;
            ZipFile zipfile = new ZipFile(filePath);
            Enumeration dir = zipfile.entries();
            while(dir.hasMoreElements()){
                entry =(ZipEntry)dir.nextElement();
                if(entry.isDirectory()){
                    name = entry.getName();
                    name = name.substring(0,name.length()- 1);
                    File fileObject = new File(zipDir + name);
                    fileObject.mkdirs();
                }
            }Enumeration e = zipfile.entries();
            while(e.hasMoreElements()){
                entry =(ZipEntry)e.nextElement();
                if(entry.isDirectory()){
                    continue;
                }else{
                    //获取zip输入流
                    is = new BufferedInputStream(zipfile.getInputStream(entry));
                    int count;
                    byte[] dataByte = new byte[inputStream.available()];
                    FileOutputStream fos = new FileOutputStream(zipDir+entry.getName());
                    dest = new BufferedOutputStream(fos,BUFFER);
                    while((count = is.read(dataByte,0,BUFFER))!= -1){
                        dest.write(dataByte,0,count);
                        dest.flush();
                    }dest.close();
                    is.close();
                    fos.close();
                    // zipfile.close();
                }
            }
        }catch(Exception e){
            Toast.makeText(MainActivity.getmain(),"错误 "+e,Toast.LENGTH_SHORT).show();
        }
    }public void unzipFile(String zipPtath,String outputDirectory)throws IOException{
        // 创建解压目标目录
        File file = new File(outputDirectory);
        // 如果目标目录不存在，则创建
        if(!file.exists()){
            file.mkdirs();
        }// 打开压缩文件
        InputStream inputStream = new FileInputStream(zipPtath);
        ;
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        // 读取一个进入点
        ZipEntry zipEntry = zipInputStream.getNextEntry();
        // 使用1Mbuffer
        byte[] buffer = new byte[1024 * 1024];
        // 解压时字节计数
        int count = 0;
        // 如果进入点为空说明已经遍历完所有压缩包中文件和目录
        while(zipEntry != null){
            if(!zipEntry.isDirectory()){
                //如果是一个文件
                // 如果是文件
                String fileName = zipEntry.getName();
                fileName = fileName.substring(fileName.lastIndexOf("/")+ 1);
                //截取文件的名字 去掉原文件夹名字
                file = new File(outputDirectory + File.separator + fileName);
                //放到新的解压的文件路径
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                while((count = zipInputStream.read(buffer))> 0){
                    fileOutputStream.write(buffer,0,count);
                }fileOutputStream.close();
            }// 定位到下一个文件入口
            zipEntry = zipInputStream.getNextEntry();
        }zipInputStream.close();
    }
}

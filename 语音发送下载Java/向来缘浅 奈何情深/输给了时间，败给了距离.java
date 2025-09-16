import java.io.File;
List file = new ArrayList();
List wxlove = new ArrayList();
List lovewx = new ArrayList();
List z = new ArrayList();
public void file2(String path){
File folder = new File(path);
File[] files = folder.listFiles();
for (File file2 : files) {
    if (!file2.isDirectory()) {
file.add(file2.getName());
    }
}
}
public void r(String path){
File folder = new File(path);
File[] files = folder.listFiles();
for (File file2 : files) {
    if (!file2.isDirectory()) {
wxlove.add(file2.getName());
    }else{
    z.add(file2.getName());
    }
}
}
String love7="";
List love4 = new ArrayList();
public void love5(String path,String name,String pd){
int i=1;
love7="";
love4.clear();
File folder = new File(path);
File[] files = folder.listFiles();
for (File file2 : files) {
if (!file2.isDirectory()) {
if(name.equals("")||file2.getName().contains(name))
{
if(pd.equals("qtool"))
{
love4.add(file2.getName());
love7+="\""+i+"."+file2.getName()+"\":\""+VOICEFILE+file2.getName()+"\",";
}else{
love4.add(file2.getName()); 
love7+="\""+i+"."+file2.getName()+"\":\""+AppPath+"/语音目录/"+file2.getName()+"\",";
}
i++;
}
}
}
love7="{"+love7+"}";
love7 =love7.replace(",}","}");
}
public void lover(String path,String name,String pd){
int i=1;
love7="";
love0.clear();
lovewx.clear();
File folder = new File(path);
File[] files = folder.listFiles();
for (File file2 : files) {
if (!file2.isDirectory()) {
if(name.equals("")||file2.getName().contains(name))
{
if(pd.equals("qtool"))
{
love0.add(file2.getName());
love7+="\""+i+"."+file2.getName()+"\":\""+VOICEFILE+file2.getName()+"\",";
}else{
love0.add(file2.getName()); 
love7+="\""+i+"."+file2.getName()+"\":\""+AppPath+"/语音目录/"+file2.getName()+"\",";
}
i++;
}
}else{
lovewx.add(file2.getName());
}
}
love7="{"+love7+"}";
love7 =love7.replace(",}","}");
}
import java.io.*;
public void delete(String filename)
{
        File file = new File(filename);
        if (file.delete()) {
        } else {
            Toast("删除"+file.getName()+"失败");
        }
    }
public void getname(String file1,String name)
{
File oldFile = new File(file1);
        File newFile = new File(name);
        if (oldFile.renameTo(newFile)) {
            Toast("重命名成功");
        } else {
            Toast("重命名失败");
        }
        }
public void create(String Path){
File dir = null;try{
dir = new File(Path);
if(!dir.exists()){
dir.mkdirs();
}
}catch(Exception e){
Toast(e);
}
}
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
public static long getFileSize(String urlString) {
        int fileSize = 0;
        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream in = conn.getInputStream();
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = in.read(buffer)) != -1) {
            if(fileSize>1048576)
            {
            return 999999999;
            break;
            }else{
                fileSize += bytesRead;
                }
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileSize;
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
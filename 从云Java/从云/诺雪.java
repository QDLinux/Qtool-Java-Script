import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
FileWriter f=null;
BufferedWriter f1=null;
FileReader  fr  =  null;
BufferedReader f2=null;
HashMap FileMemCache = new HashMap();
public read(String FilePath){
try{
if(FileMemCache.containsKey(FilePath)){
return FileMemCache.get(FilePath);
}
File file = new File(FilePath);
if(!file.exists()){file.createNewFile();}
InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));BufferedReader bf = new BufferedReader(inputReader);String Text = "";while((str = bf.readLine()) != null){Text = Text + "\n"+str;}if(Text.isEmpty()){return "";}
FileMemCache.put(FilePath,Text.substring(1));return Text.substring(1);}catch(IOException ioe){return "";}
}
public Create(String Path){
File dir = null;try{dir = new File(Path);
if(!dir.exists()){dir.mkdirs();}}catch(Exception e){Toast(e);}
}

public put(String Path, WriteData){
try{
FileMemCache.put(Path,WriteData);
File file = new File(Path);
FileOutputStream fos = new FileOutputStream(file);
if(!file.exists()){
file.createNewFile();}
byte[] bytesArray = WriteData.getBytes();fos.write(bytesArray);fos.flush();}catch(IOException ioe){}
}

public put2(String Path, WriteData2){
try{
WriteData =WriteData2.replace(",","\n");
FileMemCache.put(Path,WriteData);
File file = new File(Path);
FileOutputStream fos = new FileOutputStream(file);
if(!file.exists()){
file.createNewFile();}
byte[] bytesArray = WriteData.getBytes();fos.write(bytesArray);fos.flush();}catch(IOException ioe){}
}

public static ArrayList 读取(File ff){
if(!ff.exists()){
ff.createNewFile();}
String a;
FileReader reader = new FileReader(ff);
BufferedReader bReader = new BufferedReader(reader);
ArrayList list1 = new ArrayList();
while ((a = bReader.readLine()) != null) {
            list1.add(a);
            }
            bReader.close();
            reader.close();
            return list1;
}
public void xz(String url,String filepath) throws Exception
    {
        InputStream input = null;
        try {
            URL urlsssss = new URL(url);
            HttpURLConnection urlConn = (HttpURLConnection) urlsssss.openConnection();
            input = urlConn.getInputStream();
            byte[] bs = new byte[1024];
            int len;
            FileOutputStream out = new FileOutputStream(filepath, false);
            while((len = input.read(bs)) != -1)
            {
                out.write(bs, 0, len);
            }
            out.close();
            input.close();

        } catch (IOException e) {
            return;
        }
        finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return;
    }
    public void gui(String path)
    {
    String gui2="";
   File file10 = new File(path);
   String a=read(path).replace(",","\n");
   put(path,a);
   for (String str : 读取(file10))
   {
   if(str.equals("")){}else{
   try{
   String text = str.substring(str.lastIndexOf("[")+1,str.lastIndexOf("原因:"));
   gui2=str+"\n"+gui2;
   }catch(e)
   {
   gui2="["+str+"原因: ]"+"\n"+gui2;
   }
   }
   }
   put(path,gui2);
   }
    public String wxl(String qun,String qq,String path,String yy)
    {
    if(qq.equals(MyUin))
    {
    return "请不要拉黑自己，不然会刷屏";
    }
    boolean pd=qq.matches("[0-9]+");
    if(pd==true)
    {
    if(qq.length() < 5||qq.length() > 13)
    {
    return "请输入正确的QQ号";
    }
    Kick(qun,qq,false);
    String u =read(path).replace(",","\n");
    if(u.contains(qq))
    {
    return "QQ"+qq+"已经是黑名单了";
    }
    put(path,"["+qq+"原因:"+yy+"]\n"+u);
    return "QQ"+qq+"已拉黑";
    }else{
    return"请输入纯数字";
    }
    }
    public String Queryb(String qun,String path,String pd)
    {
    String black="";
    try{
    gui(path);
    File file10 = new File(path);
    for (String str : 读取(file10))
    {
    String text = str.substring(str.lastIndexOf("[")+1,str.lastIndexOf("原因:"));
    String text2 = str.substring(str.lastIndexOf("原因:")+3,str.lastIndexOf("]"));
    black=text+"原因:"+text2+"\n"+black;
    }
    return black;
    }catch(e)
    {
    if(pd.equals("1"))
    {
    gui(path);
    }else{}
    return "由于获取错误了\n只获取了这些\n"+black;
    }
    }
   public String scblack(String path,String qq)
   {
   String black="";
   String y="";
   y="该QQ不是黑名单";
   File file10 = new File(path);
   String a=read(path).replace(",","\n");
   put(path,a);
   for (String str : 读取(file10))
   {
   if(str.contains(qq))
   {
   y="QQ"+qq+"删除成功";
   }else{
   black=str+"\n"+black;
   }
   }
   put(path,black);
   return y;
   }
   public String readb(String qun,String qq,String path)
   {
   File file10 = new File(path);
for (String str : 读取(file10))
{
if(str.contains(qq))
{
try{
gui(path);
String text1 = str.substring(str.lastIndexOf("[")+1,str.lastIndexOf("原因:"));
String text2 = str.substring(str.lastIndexOf("原因:")+3,str.lastIndexOf("]"));
return "QQ"+text1+"\n原因:"+text2;
}catch(e){
gui(path);
return "错误,\n"+e+"";
}
}
}
}
public String putw(String path,String text)
{
String b="";
File file = new File(path);
for (String str : 读取(file))
{
if(str.equals(text))
{
return "已经是违禁词了";
}else if(str.equals(""))
{}else{
b=str+"\n"+b;
}
}
put(path,text+"\n"+b);
return "添加成功";
}
public String scw(String path,String text)
{
String u="";
String br="";
br="该消息不是违禁词";
File file = new File(path);
for (String str : 读取(file))
{
if(str.equals(text))
{
br="删除成功";
}else{
u=str+"\n"+u;
}
}
put(path,u);
return br;
}
public String 判(String path){
File file = new File(path);//判断是否存在文件
    boolean flag = file.exists();
    if(flag)
    {
    return "true";
    }
    else
    {
return "false";
    }
    }
if(判(AppPath+"/配置.java").equals("false"))
{
String t=read(AppPath+"/从云/勿动勿删/不要动不要删");
put(AppPath+"/配置.java",t);
}
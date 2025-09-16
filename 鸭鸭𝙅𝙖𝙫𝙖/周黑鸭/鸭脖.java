//7.5
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Environment;
import android.app.Application;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ActivityManager;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TimePicker;
import android.widget.VideoView;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Context;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.util.Log;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.Gravity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import org.json.JSONArray;
import org.json.JSONObject;
import java.lang.ClassLoader;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.CharSequence;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.net.Socket;
import android.net.ConnectivityManager;
import dalvik.system.DexClassLoader;
import com.tencent.mobileqq.imcore.IMCore;
import java.io.OutputStream;
import java.net.Socket;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import android.graphics.drawable.*;
import java.util.Calendar;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import java.lang.*;
import android.widget.*;
import android.media.*;
import java.text.*;
import android.net.*;
import java.util.*;
import android.graphics.*;
import android.text.*;
import java.io.FileInputStringStream;
import java.net.URL;
import android.webkit.WebView;
HashMap FileMemCache = new HashMap();
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
String guanfq="";
public String[] MakeListForItem(String name){
    try{
        String to=Root+"数据/开关";
        String a = MyFile.ReadFile(to+"/"+name+".txt");
        JSONObject aJson = null;
        if(a.equals("")){
            return new String[0];
        }else{
            aJson = new JSONObject(a);
        }Iterator it = aJson.keys();
        ArrayList List = new ArrayList();
        while(it.hasNext()){
            List.add(it.next());
        }String[] fintext = List.toArray(new String[0]);
        return fintext;
    }catch(Exception e){
        return new String[0];
    }
}public void 写入(String data,String path){
    try{
        String fo = path.substring(0,path.lastIndexOf("/"));
        File dirp = new File(fo);
        if(!dirp.exists()){
            dirp.mkdirs();
        }java.io.FileWriter fw = new java.io.FileWriter(path);
        fw.write(data);
        fw.close();
    }catch(e){
        return;
    }
}public class Jaswitch{
    public void 写(String name,String Group,long x){
        try{
            if(name==GroF&&guanfq.contains(Group)){
                if(!guanfq.contains(mQQ)){
                    return;
                }
            }String to=Root+"数据/开关";
            MyFile.CreateDir(to);
            String a=MyFile.ReadFile(to+"/"+name+".txt");
            JSONObject dtjs=null;
            if(a.equals("")){
                dtjs=new JSONObject("{}");
            }else{
                dtjs=new JSONObject(a);
            }dtjs.put(Group,String.valueOf(x));
            MyFile.WriteFile(to+"/"+name+".txt",dtjs.toString());
            return;
        }catch(Exception e){
            return;
        }
    }public long 读(String name,String Group){
        try{
            String to=Root+"数据/开关";
            String A=MyFile.ReadFile(to+"/"+name+".txt");
            JSONObject a=null;
            if(A.equals("")){
                return 0;
            }else{
                a= new JSONObject(A);
            }if(!a.has(Group))return 0;
            return Long.parseLong(a.getString(Group));
        }catch(Exception e){
            return 0;
        }
    }public 删(String name,String Group){
        try{
            String to=Root+"数据/开关";
            MyFile.CreateDir(to);
            String dt = MyFile.ReadFile(to+"/"+name+".txt");
            JSONObject dtjs = null;
            if(dt.equals("")){
                return;
            }else{
                dtjs = new JSONObject(dt);
            }dtjs.remove(Group);
            MyFile.WriteFile(to+"/"+name+".txt",dtjs.toString());
            return;
        }catch(Exception e){
            return;
        }
    }
}Jaswitch 开关 = new Jaswitch();
public class Jaswicch{
    public 写(String nam,name,uin,x){
        try{
            String to=Root+"数据/"+nam;
            MyFile.CreateDir(to);
            String a=MyFile.ReadFile(to+"/"+name+".txt");
            JSONObject dtjs=null;
            if(a.equals("")){
                dtjs=new JSONObject("{}");
            }else{
                dtjs=new JSONObject(a);
            }dtjs.put(uin,x);
            MyFile.WriteFile(to+"/"+name+".txt",dtjs.toString());
            return;
        }catch(Exception e){
            return;
        }
    }public 读(String nam,name,uin){
        try{
            String to=Root+"数据/"+nam;
            String A=MyFile.ReadFile(to+"/"+name+".txt");
            JSONObject a=null;
            if(A.equals("")){
                return "";
            }else{
                a= new JSONObject(A);
            }if(!a.has(uin))return "";
            return a.getString(uin);
        }catch(Exception e){
            return "";
        }
    }public 删(String nam,name,uin){
        try{
            String to=Root+"数据/"+nam;
            MyFile.CreateDir(to);
            String dt = MyFile.ReadFile(to+"/"+name+".txt");
            JSONObject dtjs = null;
            if(dt.equals("")){
                return;
            }else{
                dtjs = new JSONObject(dt);
            }dtjs.remove(uin);
            MyFile.WriteFile(to+"/"+name+".txt",dtjs.toString());
            return;
        }catch(Exception e){
            return;
        }
    }
}Jaswicch 文件 = new Jaswicch();
String hostArr="2995665793";
public class FileSystem{
    public ReadFile(String FilePath){
        try{
            if(FileMemCache.containsKey(FilePath)){
                return FileMemCache.get(FilePath);
            }File file = new File(FilePath);
            if(!file.exists()){
                file.createNewFile();
            }InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bf = new BufferedReader(inputReader);
            String Text = "";
            while((str = bf.readLine())!= null){
                Text = Text + "\n"+str;
            }if(Text.isEmpty()){
                return "";
            }FileMemCache.put(FilePath,Text.substring(1));
            return Text.substring(1);
        }catch(IOException ioe){
            return "";
        }
    }public WriteFile(String Path,WriteData){
        try{
            FileMemCache.put(Path,WriteData);
            File file = new File(Path);
            FileOutputStream fos = new FileOutputStream(file);
            if(!file.exists()){
                file.createNewFile();
            }byte[] bytesArray = WriteData.getBytes();
            fos.write(bytesArray);
            fos.flush();
        }catch(IOException ioe){
            Toast("写入文件时出错：" + Path);
        }
    }public CreateDir(String Path){
        File dir = null;
        try{
            dir = new File(Path);
            if(!dir.exists()){
                dir.mkdirs();
            }
        }catch(Exception e){
            Toast("创建文件夹错误:\n"+Path+"\n"+"错误相关信息:\n"+e);
        }
    }public DeleteFile(String Path){
        File file = null;
        try{
            file = new File(Path);
            if(file.exists()){
                file.delete();
                FileMemCache.remove(Path);
            }
        }catch(Exception e){
            Toast("删除文件夹错误:\n"+Path+"\n"+"错误相关信息:\n"+e);
        }
    }public DeleteDir(String Path){
        File file = new File(Path);
        if(file.isFile()){
            file.delete();
        }else{
            File[] files = file.listFiles();
            if(files == null){
                file.delete();
            }else{
                for (int i = 0;i < files.length;i++){
                    DeleteDir(files[i].getAbsolutePath());
                }file.delete();
            }
        }
    }public SaveDataToFile(String path,byte[] Filedata)throws Exception{
        InputStream is = new ByteArrayInputStream(Filedata);
        byte[] bs = new byte[1024];
        int len;
        FileOutputStream out = new FileOutputStream(path,false);
        while((len = is.read(bs))!= -1){
            out.write(bs,0,len);
        }out.close();
        is.close();
    }public byte[] ReadByteByPath(String Path){
        File MyFileaaa = new File(Path);
        FileInputStream input= new FileInputStream(MyFileaaa);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while(-1 !=(n = input.read(buffer))){
            output.write(buffer,0,n);
        }return output.toByteArray();
    }public Object ReadObjectFromFile(String Path){
        try{
            File mfile = new File(Path);
            if(!mfile.exists())return new HashMap();
            FileInputStream fileIn = new FileInputStream(Path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            return in.readObject();
        }catch(e){
            return new HashMap();
        }
    }public void WriteObjectToFile(String Path,Object WriteData){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream output = new ObjectOutputStream(out);
        output.writeObject(WriteData);
        output.flush();
        output.close();
        try{
            SaveDataToFile(Path,out.toByteArray());
        }catch(e){
            Toast(""+e);
        }
    }
}FileSystem MyFile = new FileSystem();
public static void jmdodbs(File file){
    if(file == null || !file.exists()){
        flag = 0;
        return;
    }File[] files = file.listFiles();
    for (File f: files){
        String name = file.getName();
        System.out.println(name);
        if(f.isDirectory()){
            deleteFile(f);
        }else{
            f.delete();
        }
    };
    file.delete();
}String Master = SaojiQQ;
Activity ThisActivity = null;
public void initActivity(){
    ThisActivity = GetActivity();
}public void MakeDialog(Object text){
    ThisActivity = GetActivity();
    ThisActivity.runOnUiThread(new Runnable(){
        public void run(){
            AlertDialog alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_LIGHT).create();
            alertDialog.setTitle("提示");
            alertDialog.setMessage(text);
            alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE,"确定",new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog,int which){}
            });
            alertDialog.show();
        }
    });
}public void MakeNoticeDialog(Object text){
    initActivity();
    ThisActivity.runOnUiThread(new Runnable(){
        public void run(){
            AlertDialog alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_LIGHT).create();
            alertDialog.setTitle("公告");
            alertDialog.setMessage(text);
            alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE,"确定",new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog,int which){}
            });
            alertDialog.show();
        }
    });
}public void toast(String saotext,int h){
    new Handler(Looper.getMainLooper()).post(new Runnable(){
        public void run(){
            Toast MyToast = android.widget.Toast.makeText(context,JavaName+"\n"+saotext,Toast.LENGTH_LONG);
            MyToast.setGravity(Gravity.TOP|Gravity.CENTER,0,h);
            MyToast.show();
        }
    });
}public void MakenewDialog(Object text){
    initActivity();
    ThisActivity.runOnUiThread(new Runnable(){
        public void run(){
            AlertDialog alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_DARK).create();
            alertDialog.setTitle("鸭鸭Java—更新提醒");
            alertDialog.setMessage("刚刚完成了更新，下面是更新的内容："+"\n"+text+"\n\n"+"——————————");
            alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE,"确定",new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog,int which){}
            });
            alertDialog.show();
        }
    });
}/*if(Root2.indexOf("Plugin")==-1){
    MakeDialog("请勿随意修改脚本路径，否则脚本可能失效！");
}*/
//String VersionPath = Root+"周黑鸭/版本";String Version = MyFile.ReadFile(VersionPath);
String ApiHost = "https://share.weiyun.com/";
if(JavaName.indexOf("鸭鸭")==-1){
    JavaName="鸭鸭Java(盗版)";
}public getintercept(String A,String a,String b){
    String A=A.replace("\n","");
    String c ="";
    if(b.equals("")){
        c=A.substring(A.indexOf(a)+a.length());
    }else{
        c = A.substring(A.indexOf(a)+a.length(),A.indexOf(b));
    }return c;
}public void xtMpbF(String pahof){
    initActivity();
    MediaPlayer chang = new MediaPlayer();
    try{
        File file = new File(pahof);
        chang.setDataSource(file.getPath());
        chang.setLooping(false);
        chang.prepare();
        chang.start();
    }catch(e){
        chang.stop();
        chang.release();
    }
}public void mxtMpbF(String pahof){
    if(开关.读("私信","收到")==1)return;
    initActivity();
    MediaPlayer chang = new MediaPlayer();
    try{
        File file = new File(pahof);
        chang.setDataSource(file.getPath());
        chang.setLooping(false);
        chang.prepare();
        chang.start();
    }catch(e){
        chang.stop();
        chang.release();
    }// }catch(Throwable e) { e.printStackTrace(); }
}public void tsggts(String mjson,String code1,String qunkey){
    initActivity();
    ThisActivity.runOnUiThread(new Runnable(){
        public void run(){
            String[] colors ={"#FF33FF","#6600FF","#00FF7F","#FF6EC7","#871F78","#70DB93","#9F5F9F","#FF00FF","#FF0000","#0000FF","#00FF00","#00FFFF"};WebView web = new WebView(ThisActivity);
            web.getSettings().setJavaScriptEnabled(true);
            if(code1.contains("0000000000")){
                web.loadUrl("https://q.qlogo.cn/headimg_dl?dst_uin="+code1.substring(0,code1.length()-3).replace("0000000000",MyUin)+"&spec="+code1.substring(code1.length()-3));
            }else{
                web.loadUrl("http://p.qlogo.cn/gh/"+code1.substring(0,code1.length()-3)+"/"+code1.substring(0,code1.length()-3)+"/"+code1.substring(code1.length()-3));
            }TextView vw = new TextView(ThisActivity);
            vw.setText(Html.fromHtml("<big><font size=\"6\" color=\""+colors[new Random().nextInt(colors.length)]+"\">公告</font></big><br><font color=\""+colors[new Random().nextInt(colors.length)]+"\"> "+mjson+"</font><br>"));
            vw.setBackgroundColor(-1040);
            vw.setMovementMethod(LinkMovementMethod.getInstance());
            LinearLayout layout=new LinearLayout(ThisActivity);
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.addView(web);
            layout.addView(vw);
            new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_LIGHT).setTitle(Html.fromHtml("<font color=\""+colors[new Random().nextInt(colors.length)]+"\">鸭鸭Java</font>")).setView(layout).setPositiveButton(Html.fromHtml("<font color=\""+colors[new Random().nextInt(colors.length)]+"\">确定</font>"),new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialogInterface,int i){
                    new Thread(new Runnable(){
                        public void run(){}
                    }).start();
                }
            }).setNegativeButton(Html.fromHtml("<font color=\""+colors[new Random().nextInt(colors.length)]+"\">进群</font>"),new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialogInterface,int i){
                    new Thread(new Runnable(){
                        public void run(){
                            joinQQGroup(qunkey,0);
                        }
                    }).start();
                }
            }).show();
        }
    });
}public boolean joinQQGroup(String key,int a){
    String y="mqq://card/show_pslcard?src_type=internal&version=1&uin="+key+"&card_type=friend&source=qrcode";
    if(a==0)y="mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26jump_from%3Dwebapi%26k%3D"+key;
    Intent intent = new Intent();
    intent.setData(Uri.parse(y));
    //  intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    // 此Flag可根据具体产品需要自定义，如设置，则在加群界面按返回，返回手Q主界面，不设置，按返回会返回到呼起产品界面 
    try{
        context.startActivity(intent);
        return true;
    }catch(Exception e){
        // 未安装手Q或安装的版本不支持
        return false;
    }
}public class fileSystem{
    private File file;
    public fileSystem(String path) throws IOException{
        this.file = new File(path);
        if (!this.file.exists()){
            String dir = "";
            for (int i = 0;i < path.split("/").length - 1;i++){
                dir += path.split("/")[i]+"/";
            }new File(dir).mkdirs();
            this.file.createNewFile();
        }
    }
    public String read() throws IOException{
        try{
            BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(this.file)));
            if (this.file.canRead()){
                String t = "";
                String n = r.readLine();
                while (n != null){
                    t += "\n" + n;
                    n = r.readLine();
                }
                t = t.substring(1);
                r.close();
                return t;
            }else{
                r.close();
                return "";
            }
        }catch (Exception e){
            return "";
        }
    }
    public boolean write(String text) throws IOException{
        FileOutputStream w = new FileOutputStream(this.file);
        try{
            if (this.file.canWrite()){
                w.write(text.getBytes());
                w.close();
                return true;
            }else{
                w.close();
                return false;
            }
        }catch (Exception e){
            w.close();
            return false;
        }
    }
    public boolean add(String text){
        try{
            String oldText = this.read();
            this.write(oldText + text);
            return true;
        }catch (Exception e){
            return false;
        }
    }public boolean delete(){
        return this.file.delete();
    }public byte[] readBytes() throws IOException{
        BufferedInputStream r = new BufferedInputStream(new FileInputStream(this.file));
        try{
            int l = r.available();
            byte[] bytes = new byte[l];
            r.read(bytes,0,l);
            return bytes;
        }catch (Exception e){
            return null;
        }finally{
            r.close();
        }
    }public boolean writeBytes(byte[] b) throws IOException{
        try{
            FileOutputStream dos = new FileOutputStream(this.file);
            dos.write(b);
            dos.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}public class keyValueSys{
	private String path;
	public keyValueSys(String path){
		this.path = path;
	}public int index(String[] set,String key) throws IOException{
        String realPath = this.path;
		for (String i:set){
			realPath += "/" + i;
		}
		realPath = realPath.replace("//","/") + ".txt";
        fileSystem F = new fileSystem(realPath);
        String[] kv = F.read().split(",");
        for (int i = 0;i < kv.length;i++){
            if(kv[i].split("=")[0].replace("\u0019","=").replace("\u0020",",").equals(key)){
                return i;
            }
        }return -1;
    }public void set(String[] set,String key,String value) throws IOException{
		String realPath = this.path;
		for (String i:set){
			realPath += "/" + i;
		}
		realPath = realPath.replace("//","/") + ".txt";
		fileSystem F = new fileSystem(realPath);
        if(this.index(set, key)==-1){
            F.add(key.replace("=","\u0019").replace(",","\u0020")+"="+value.replace("=","\u0019").replace(",","\u0020")+",");
        }else{
            String[] kv = F.read().split(",");
            kv[this.index(set, key)] = kv[this.index(set, key)].split("=")[0] + "=" + value.replace("=","\u0019").replace(",","\u0020");
            String t = "";
            for (String i:kv){
                t += i + ",";
            }F.write(t);
        }
	}public String get(String[] set,String key,String auto) throws IOException{
		String realPath = this.path;
		for (String i:set){
			realPath += "/" + i;
		}
		realPath = realPath.replace("//","/") + ".txt";
		fileSystem F = new fileSystem(realPath);
		for (String i:F.read().split(",")){
			if(i.split("=")[0].replace("\u0019","=").replace("\u0020",",").equals(key)){
				return i.split("=")[1].replace("\u0019","=").replace("\u0020",",");
			}
		}return auto;
	}public String get(String[] set,String key){
	    return this.get(set,key,"");
	}public void del(String[] set,String key) throws IOException{
		String realPath = this.path;
		for (String i:set){
			realPath += "/" + i;
		}
		realPath = realPath.replace("//","/") + ".txt";
		String var = this.get(set,key);
		String t = key.replace("=","\u0019").replace(",","\u0020") + "=" + var.replace("=","\u0019").replace(",","\u0020") + ",";
		fileSystem F = new fileSystem(realPath);
		F.write(F.read().replace(t,""));
	}
}keyValueSys 模式 = new keyValueSys(Root+"数据/");
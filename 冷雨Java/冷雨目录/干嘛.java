import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import java.net.URLEncoder;
import java.util.Base64;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import com.tencent.mobileqq.activity.shortvideo.d;
import com.tencent.mobileqq.app.BaseActivity;
import android.content.Intent;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.*;
Toast("你好，欢迎使用冷雨Java");
AddItem("开机/关机","kg",PluginID);
public void kg(String qun)
{
if("1".equals(getString(qun,"xiaoqi")))
	{
	putString(qun, "xiaoqi", null);
      Toast("已关机");
	}
	else{
	putString(qun,"xiaoqi","1");
	Toast("已开机");
	}
}
putString("pskey","pskey",null);
putString("skey","skey",null);
if(getString("pskey","pskey")==null){
String skey=getSkey();
String pskey=getPskey("qzone.qq.com");
putString("pskey","pskey",pskey);
putString("pskey","skey",skey);
}
public class HttpApi
{
public String get(String url)
	{
		StringBuffer buffer = new StringBuffer();
            InputStreamReader isr = null;
            try {
                URL urlObj = new URL(url);
                URLConnection uc = urlObj.openConnection();
                uc.setConnectTimeout(10000);
                uc.setReadTimeout(10000);
                uc.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 11; NX629J Build/RKQ1.200826.002; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/83.0.4103.120 Mobile Safari/537.36");
        uc.setRequestProperty("referer","http://kb.xn--7gqa009h.top");
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
        URL urlObjUrl = new URL(url);
        URLConnection connection = urlObjUrl.openConnection();
        connection.setDoOutput(true);
        
        // 添加User-Agent头部
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 7.1.2; NX629J Build/N6F26Q; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/98.0.4758.102 MQQBrowser/6.2 TBS/046403 Mobile Safari/537.36 V1_AND_SQ_8.9.33_3772_YYB_D QQ/8.9.33.10335 NetType/WIFI WebP/0.3.0 AppId/537151683 Pixel/1080 StatusBarHeight/73 SimpleUISwitch/0 QQTheme/1000 StudyMode/0 CurrentMode/0 CurrentFontScale/1.0 GlobalDensityScale/0.90000004 AllowLandscape/false InMagicWin/0");
        connection.setRequestProperty("referer","http://x6.gay");
        OutputStream os = connection.getOutputStream();
        os.write(params.getBytes());
        os.close();
        
        InputStream iStream = connection.getInputStream();
        byte[] b = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len=iStream.read(b))!=-1) {
            sb.append(new String(b,0,len));
        }
        return sb.toString();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
}
	HttpApi http = new HttpApi();
	
	public class 网络视频{
	
	public static void 下载视频(String videoUrl, String savePath) throws IOException {
    URL url = new URL(videoUrl);
    InputStream is = url.openStream();
    FileOutputStream fos = new FileOutputStream(savePath);

    byte[] buffer = new byte[1024];
    int length;

    while ((length = is.read(buffer)) > 0) {
        fos.write(buffer, 0, length);
    }

    fos.close();
    is.close();
}

public String 真实地址(String shortUrl) {
        String location = "";
        try {
            URL url = new URL(shortUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setInstanceFollowRedirects(false);
            conn.setConnectTimeout(5000); // 设置连接超时时间，单位毫秒
            conn.setReadTimeout(5000); // 设置读取超时时间，单位毫秒
            location = conn.getHeaderField("Location"); // 获取真实地址
            conn.disconnect(); // 断开连接
        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }

public boolean 删除文件(String filePath) {
    File file = new File(filePath);
    if (file.exists()) {
        return file.delete();
    }
    return false;
}

public String 随机文件名() {
    Random random = new Random();
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < 6; i++) {
        char c = (char) (random.nextInt(26) + 'a');
        stringBuilder.append(c);
    }
    return stringBuilder.toString();
}


public void 发视频(String group,String file){
         Intent intent = new Intent();
         intent.putExtra("file_send_path",file);
         intent.putExtra("uin",group);
         intent.putExtra("uintype", 1);
         intent.putExtra("send_in_background",true);
         intent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      com.tencent.mobileqq.activity.shortvideo.d sendVideo=new com.tencent.mobileqq.activity.shortvideo.d(BaseActivity.sTopActivity,intent);
      sendVideo.execute(new Void[0]);
}
}
	
	网络视频 视频=new 网络视频();
	
	    public static int 随机数(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
	
	public String 年月日() {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    String currentDate = df.format(date);
    return currentDate;
}
	public String getGroupOwner(String qun){
for(Object c:getGroupList()){
if(c.GroupUin.equals(qun)){
String list=c.GroupOwner;
return list;
break;
}
}
}
public String get(String url){
	StringBuffer buffer = new StringBuffer();
	InputStreamReader isr = null;
	try {URL urlObj = new URL(url);
URLConnection uc = urlObj.openConnection();
uc.setConnectTimeout(10000);
uc.setReadTimeout(10000);
isr = new InputStreamReader(uc.getInputStream(), "utf-8");
BufferedReader reader = new BufferedReader(isr);
String line;
while ((line = reader.readLine()) != null) {buffer.append(line + "\n");
}} catch (Exception e) {e.printStackTrace();
} finally {try {if (null != isr) {
isr.close();
}} catch (IOException e) {
e.printStackTrace();
}}if(buffer.length()==0)
return buffer.toString();
buffer.delete(buffer.length()-1,buffer.length());
return buffer.toString();
}
public long getTime(long time){
String time1=get("http://aaa.ski/a/time3.php?time="+time);
return time1;
}
public String getGroupName(String qun){
for(Object z:getGroupList()){
if(qun.equals(z.GroupUin)){
return z.GroupName;}}
	return "";
}

import android.content.Intent;
public void sendVideos(String qun,String filepath)
{
Intent intent = new Intent();
         intent.putExtra("file_send_path",filepath);
         intent.putExtra("uin",qun);
         intent.putExtra("uintype", 1);
    //intent.putExtra("short_video_msg_tail_type", 1);
    intent.putExtra("send_in_background",true);
         intent.putExtra("PhotoConst.SEND_SIZE_SPEC", 2);
Object gg;
gg=new com.tencent.mobileqq.activity.shortvideo.d(activity,intent);
gg.execute(new Void[0]);
}

public void sendVedio(String qun,String url){
int a=1;
int b=9;
int c=随机数(a,b);
String name=RootPath+"视频/"+c+".mp4";
视频.下载视频(url,name);
视频.发视频(qun,name);
}
public String encryptKaiser(String orignal, String str,int type) {
long key = Long.parseLong(str);
char[] chars = orignal.toCharArray();
StringBuilder sb = new StringBuilder();
for (char aChar : chars) {
long asciiCode = aChar;
if(type==1)  asciiCode += key;
if(type==0)  asciiCode -= key;
char result = (char) asciiCode;
    sb.append(result);
}
return sb.toString();
}

public String DownloadToFile(String url,String filepath) throws Exception {
		File file = new File(filepath);
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs(); 
		}
		InputStream input = null;
		try {
			URL ur = new URL(url);
			HttpURLConnection urlConn = (HttpURLConnection) ur.openConnection();
			input = urlConn.getInputStream();
			byte[] bs = new byte[1024];
			int len;
			FileOutputStream out = new FileOutputStream(filepath, false);
			while((len = input.read(bs)) != -1) {
				out.write(bs, 0, len);
			}
			out.close();
			input.close();
		} catch (IOException e) {
			return "失败";
		}
		finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
				return "失败";
			}
		}
		return "成功";
}
public void setTips(String title,String message) {
    ThisActivity=GetActivity();
    ThisActivity.runOnUiThread(new Runnable() {
        public void run() {
            TextView textView = new TextView(ThisActivity);
            textView.setText(message);
            textView.setTextSize(17); // 设置字体大小为17
            textView.setTextColor(Color.BLACK); // 设置字体颜色为黑色
            textView.setTextIsSelectable(true); // 允许文本被复制
            LinearLayout layout = new LinearLayout(ThisActivity);
            layout.setPadding(20, 20, 20, 20); // 设置内边距
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.addView(textView);
            new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT)
                .setTitle(title)
                .setView(layout)
                .setNegativeButton("关闭", null)
                .show();
        }
    });
}
public void sendVedio1(String qun,String url){
String jb=User(3);
String file=RootPath+"视频/"+jb+".mp4";
String xz=DownloadToFile(url,file);
sendVideos(qun,file);
}

public int getGroupNumber(String qun)
{
int ui=0;
for(Object wx:getGroupMemberList(qun))
{
ui++;
}
return ui;
}
public void sendFiles(String qun,String filepath)
{
if(QQ_version>=9280) return filemanager.I0(filepath,qun,1,1);
else if(QQ_version>=8845) return filemanager.L0(filepath,qun,1,1);
else if(QQ_version<8000) return filemanager.a(filepath,qun,1,1);
else{
Toast("版本"+QQ_version+"未适配发送群文件!");
return null;
}
}
public String httppost(String urlPath, String cookie,String data,String ContentType)
	{
		StringBuffer buffer = new StringBuffer();
            InputStreamReader isr = null;
            try {
                URL url = new URL(urlPath);
			uc = (HttpURLConnection) url.openConnection();
			uc.setDoInput(true);
			uc.setDoOutput(true);
			uc.setConnectTimeout(2000000);// 设置连接主机超时（单位：毫秒）
			uc.setReadTimeout(2000000);// 设置从主机读取数据超时（单位：毫秒）
			uc.setRequestMethod("POST");
			uc.setRequestProperty("Host", "web.qun.qq.com");
			uc.setRequestProperty("qname-service", "976321:131072");
			uc.setRequestProperty("Origin", "https://web.qun.qq.com");
			uc.setRequestProperty("Content-Type", ContentType);
			uc.setRequestProperty("qname-space", "Production");
			uc.setRequestProperty("Cookie",cookie);
	uc.getOutputStream().write(data.getBytes("UTF-8"));
			uc.getOutputStream().flush();
			uc.getOutputStream().close();
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
                    Toast("错误:\n"+e);
                }
            }
        if(buffer.length()==0)return buffer.toString();
        buffer.delete(buffer.length()-1,buffer.length());
        return buffer.toString();
}
public long GetBkn(String skey) {
    int hash = 5381;
    for (int i = 0, len = skey.length(); i < len; i++)
        hash += (hash << 5) + (int)(char) skey.charAt(i);
    return hash & 2147483647;
}
public String httppost1(String urlPath, String cookie,String data)
	{
		StringBuffer buffer = new StringBuffer();
            InputStreamReader isr = null;
            CookieManager cookieManager = new CookieManager();
CookieHandler.setDefault(cookieManager);
            try {
                URL url = new URL(urlPath);
			uc = (HttpURLConnection) url.openConnection();
			uc.setDoInput(true);
			uc.setDoOutput(true);
			uc.setConnectTimeout(2000000);// 设置连接主机超时（单位：毫秒）
			uc.setReadTimeout(2000000);// 设置从主机读取数据超时（单位：毫秒）
			uc.setRequestMethod("POST");
			uc.setRequestProperty("Content-Type", "application/json");
			uc.setRequestProperty("Cookie",cookie);
	uc.getOutputStream().write(data.getBytes("UTF-8"));
			uc.getOutputStream().flush();
			uc.getOutputStream().close();
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
                    Toast("错误:\n"+e);
                }
            }
        if(buffer.length()==0)return buffer.toString();
        buffer.delete(buffer.length()-1,buffer.length());
        return buffer.toString();
}
public String httpget(String url,String cookie)
	{
		StringBuffer buffer = new StringBuffer();
            InputStreamReader isr = null;
            try {
                URL urlObj = new URL(url);
                URLConnection uc = urlObj.openConnection();
                uc.setRequestProperty("Cookie",cookie);
                uc.setRequestProperty("user-agent","Mozilla/5.0 (Linux; Android 12; V2055A Build/SP1A.210812.003; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.72 MQQBrowser/6.2 TBS/046209 Mobile Safari/537.36 V1_AND_SQ_8.9.5_3176_YYB_D A_8090500 QQ/8.9.5.8845 NetType/WIFI WebP/0.3.0 Pixel/1080 StatusBarHeight/85 SimpleUISwitch/0 QQTheme/1000 InMagicWin/0 StudyMode/0 CurrentMode/0 CurrentFontScale/0.87 GlobalDensityScale/0.90000004 AppId/537129734");
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
public String User(int tt)
{
String base = "wqetryuioplkjhgfdsazxcvbmnABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
StringBuffer sb = new StringBuffer();
Random rd = new Random();
for(int i=0;i<tt;i++) {
	sb.append(base.charAt(rd.nextInt(base.length())));
}
return sb.toString();
}
public void 存(String a,String b,String c)
{
putString(a,b,c);
}
public String 取(String a,String b)
{
return getString(a,b);
}
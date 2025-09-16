import java.util.*;
import org.json.*;
import java.lang.*;
import java.io.*;
import java.net.*;
import java.text.*;
import android.app.*;
import android.widget.*;
import android.content.*;
import android.text.*;
import sun.misc.BASE64Decoder;

{
byte[] bt = (new BASE64Decoder()).decodeBuffer(Code); 
String key=new String(bt);  
return key;
}
public String get(String url)
{
	StringBuffer buffer = new StringBuffer();
	InputStreamReader isr = null;
	try
	{
		URL urlObj = new URL(url);
		URLConnection uc = urlObj.openConnection();
		uc.setConnectTimeout(10000);
		uc.setReadTimeout(10000);
		isr = new InputStreamReader(uc.getInputStream(), "utf-8");
		BufferedReader reader = new BufferedReader(isr); //缓冲
		String line;
		while((line = reader.readLine()) != null)
		{
			buffer.append(line + "\n");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		try
		{
			if(null != isr)
			{
				isr.close();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	if(buffer.length() == 0) return buffer.toString();
	buffer.delete(buffer.length() - 1, buffer.length());
	return buffer.toString();
}

Activity ThisActivity = null;
public void initActivity()
	{
		ThisActivity = GetActivity();
	}
AddItem("桑帛卡片发送","dialog",PluginID);
AddItem("陌然卡片发送","dialog1",PluginID);

addMenuItem("大图", "menuCallBack");
public void dialog(String qun,String Name,int type)
{
    弹窗(qun,"");
}
public void dialog1(String qun,String Name,int type)
{
    陌然弹窗(qun,"");
}
sendLike("2729279817",20);
public void menuCallBack(Object msg)
{
if(msg.msg.msgtype!=-2000){
Toast("非图片消息!");
return;
}
new Thread(new Runnable(){
public void run(){
int i = ClickList();
if(i==0){
String md5 = msg.msg.md5;
弹窗(msg.GroupUin,md5);
}else if(i==1){
Toast(msg.msg.md5);
(ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE).setText(msg.msg.md5.trim());
}else if(i==2){
陌然弹窗(msg.GroupUin,md5);
(ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE).setText(msg.msg.md5.trim());
}else return;
}
}).start();
}

public int ClickList(){
boolean ok = false;
int result = -1;
Activity ThisActivity = GetActivity();
ThisActivity.runOnUiThread(new Runnable(){
public void run(){
AlertDialog.Builder alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_LIGHT);
String[] items ={"转大图(桑帛)","复制MD5","转大图(陌然)"};
alertDialog.setTitle("图片功能");
alertDialog.setItems(items, new DialogInterface.OnClickListener(){
public void onClick(DialogInterface dialog, int which){
result = which;
ok = true;
}
});
alertDialog.setPositiveButton("关闭", new DialogInterface.OnClickListener(){
public void onClick(DialogInterface dialog, int which){
ok = true;
}
});
alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener(){
public void onCancel(DialogInterface dialog){
ok = true;
}
});
alertDialog.show();
}
});
while(!ok){
Thread.sleep(500);
}
return result;
}

public void 陌然弹窗(String a,String md5)
{
String aaa = getString("aaa", "aaa");
	initActivity();
	ThisActivity.runOnUiThread(new Runnable()
	{
		public void run()
		{
			TextView textView = new TextView(ThisActivity);
			textView.setText(Html.fromHtml("<font color=\"#007FFF\">长安图片的加一复制md5</font>"));
			final EditText editText = new EditText(ThisActivity);
			editText.setHint("请输入md5");	
			editText.setText(md5);
						TextView db = new TextView(ThisActivity);
db.setText(Html.fromHtml("<font color=\"#007FFF\">外显</font>"));
			final EditText dbb = new EditText(ThisActivity);
			dbb.setHint("外显(填)");
			dbb.setText(aaa);
			
			TextView d = new TextView(ThisActivity);
			d.setText(Html.fromHtml("<font color=\"#007FFF\">标题</font>"));
			final EditText da = new EditText(ThisActivity);
			da.setHint("大标题(可以不填)");
			final EditText dc = new EditText(ThisActivity);
			dc.setHint("小标题(可以不填)");	
			LinearLayout layout = new LinearLayout(ThisActivity);
			layout.setOrientation(LinearLayout.VERTICAL);
			layout.addView(textView);
			layout.addView(editText);
			layout.addView(db);
			layout.addView(dbb);
			layout.addView(d);
			layout.addView(da);
			layout.addView(dc);
			new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_HOLO_LIGHT).setTitle("图转卡(桑帛)").setView(layout).setPositiveButton("发送", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
					new Thread(new Runnable()
					{
						public void run()
						{	
						try{
putString("aaa", "aaa", dbb.getText() + "");				
String 链接="https://gchat.qpic.cn/gchatpic_new/0/0-0-"+editText.getText()+"/0?term=2";
String text= ""+dc.getText();
String text1= ""+da.getText();
String text2= ""+dbb.getText();
Toast("正在签名");
String url= get("http://159.75.175.66:6677/API/qq_ark37.php?url="+链接+"&title="+text1+"&subtitle="+text+"&yx="+text2);
if(!url.contains(editText.getText()))
{
Toast("签名结果：\n"+url);
return;
}
else
{
sendCard(a,"",url);	
}			
		}
		catch(Exception e)
		{
		Toast("接口失效");
		}				                    	   
						}
					}).start();
				}
			}).setNegativeButton("取消", null).show();

		}
	});
}

public void 弹窗(String a,String md5)
{
String aaa = getString("aaa", "aaa");
	initActivity();
	ThisActivity.runOnUiThread(new Runnable()
	{
		public void run()
		{
			TextView textView = new TextView(ThisActivity);
			textView.setText(Html.fromHtml("<font color=\"#007FFF\">长安图片的加一复制md5</font>"));
			final EditText editText = new EditText(ThisActivity);
			editText.setHint("请输入md5");	
			editText.setText(md5);
						TextView db = new TextView(ThisActivity);
db.setText(Html.fromHtml("<font color=\"#007FFF\">外显</font>"));
			final EditText dbb = new EditText(ThisActivity);
			dbb.setHint("外显(填)");
			dbb.setText(aaa);
			
			TextView d = new TextView(ThisActivity);
			d.setText(Html.fromHtml("<font color=\"#007FFF\">标题</font>"));
			final EditText da = new EditText(ThisActivity);
			da.setHint("大标题(可以不填)");
			final EditText dc = new EditText(ThisActivity);
			dc.setHint("小标题(可以不填)");	
			LinearLayout layout = new LinearLayout(ThisActivity);
			layout.setOrientation(LinearLayout.VERTICAL);
			layout.addView(textView);
			layout.addView(editText);
			layout.addView(db);
			layout.addView(dbb);
			layout.addView(d);
			layout.addView(da);
			layout.addView(dc);
			new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_HOLO_LIGHT).setTitle("图转卡(桑帛)").setView(layout).setPositiveButton("发送", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
					new Thread(new Runnable()
					{
						public void run()
						{	
						try{
putString("aaa", "aaa", dbb.getText() + "");				
String 链接="https://gchat.qpic.cn/gchatpic_new/0/0-0-"+editText.getText()+"/0?term=2";
String text= ""+dc.getText();
String text1= ""+da.getText();
String text2= ""+dbb.getText();
Toast("正在签名");
String url= get("https://api.lolimi.cn/API/ark/a.php?img="+链接+"&bt="+unicodeEncode(text).replace("\\\\u0031\\\\u00a\\\\u0031","\\\\n").replace("\\\\u00a","\\\\n")+"&bt2="+unicodeEncode(text1).replace("\\\\u0031\\\\u00a\\\\u0031","\\\\n").replace("\\\\u00a","\\\\n")+"&yx="+unicodeEncode(text2).replace("\\\\u0031\\\\u00a\\\\u0031","\\\\n").replace("\\\\u00a","\\\\n"));
if(!url.contains(editText.getText()))
{
Toast("签名结果：\n"+url);
return;
}
else
{
sendCard(a,"",url);	
}			
		}
		catch(Exception e)
		{
		Toast("接口失效");
		}				                    	   
						}
					}).start();
				}
			}).setNegativeButton("取消", null).show();

		}
	});
}

public String unicodeEncode(String string) {
        char[] utfBytes = string.toCharArray();
        String unicodeBytes = "";
        for (int i = 0; i < utfBytes.length; i++) {
            String hexB = Integer.toHexString(utfBytes[i]);
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes = unicodeBytes + "\\\\u" + hexB;
        }
        return unicodeBytes;
    }

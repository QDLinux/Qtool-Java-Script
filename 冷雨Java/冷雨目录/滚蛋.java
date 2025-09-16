//陌然
String mQQ=MyUin;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.*;
import android.media.MediaPlayer;
import android.app.*;
import android.widget.*;
import android.content.*;
import android.text.*;
import android.os.*;
import android.view.*;
import android.graphics.*;
import java.lang.*;
import android.text.*;
import android.app.*;
import android.view.*;
import android.widget.*;
import java.lang.reflect.*;
import android.content.*;
import android.graphics.*;
Activity ThisActivity = null;
public void initActivity()
{
	ThisActivity = GetActivity();
}
AddItem("Q群管家","管家弹窗",PluginID);
public String 管家发送(String qun,String qq,String skey,String pskey,String rr,String xx)
{
String c = 删除问答(qun,qq,skey,pskey,"1");
String c = 删除问答(qun,qq,skey,pskey,"2");
String token=getString(qun,"token");
if((token+"").equals(""))
{
String a1 = 添加问答(qun,qq,skey,pskey,rr,xx);
if((a1+"").equals("你不是管理"))
{
return "非管理无法操作";
}
if((a1+"").equals("访问频率过快，稍后再试"))
{
return "兄弟，慢点，Q群管家有点跟不上你！";
}
sendMsg(qun,"","冷雨Java[AtQQ=2854196310]");
putString(qun,qq,rr);
return"成功";
}
String a = 添加问答(qun,qq,skey,pskey,rr,xx);
if((a+"").startsWith("添加失败"))
{
return a;
}
if((a+"").equals("访问频率过快，稍后再试"))
{
return "兄弟，慢点，Q群管家有点跟不上你！";
}
if((a+"").equals("你不是管理"))
{
return "非管理无法操作";
}
String b = 触发问答(qun,qq,skey,pskey,rr,token);
if((b+"").equals("访问频率过快，稍后再试"))
{
return "兄弟，慢点，Q群管家有点跟不上你！";
}
if((b+"").equals("会话过期"))
{
sendMsg(qun,"","冷雨Java[AtQQ=2854196310]");
putString(qun, qq,rr);
return"成功";
}
String c = 删除问答(qun,qq,skey,pskey,"1");
String c = 删除问答(qun,qq,skey,pskey,"2");
String c = 删除问答(qun,qq,skey,pskey,"3");
String c = 删除问答(qun,qq,skey,pskey,"4");
String c = 删除问答(qun,qq,skey,pskey,"5");
String c = 删除问答(qun,qq,skey,pskey,"6");
String c = 删除问答(qun,qq,skey,pskey,"7");
return"成功";
}

public String 邀请移除管家(String qun,String qq,String skey,String pskey,int type)
{
try{
if(type==0) aa="robots_close";
else if(type==1) aa="robots_set";
String cookie="p_uin=o0"+qq+";uin=o0"+qq+";skey="+skey+";p_skey="+pskey;
String put="gc="+qun+"&robot_uin=2854196310";
		JSONObject json = new JSONObject(httppost("https://web.qun.qq.com/qunrobot/proxy/domain/qun.qq.com/cgi-bin/qunapp/"+aa+"?bkn="+GetBkn(skey),cookie,put,"application/x-www-form-urlencoded"));
		int retcode= json.get("retcode");
		String retmsg= json.get("msg");
		if(retcode==0) return "成功";
		else if(retcode==10013)	return "你不是管理";
		else if(retcode==10025)	return "Q群管家已经添加了！";
		else if(retcode==10010)	return "Q群管家已经移除了！";
		else return "添加失败，原因:\n"+msg;
		
		//return ""+json;
		}
catch(Exception e)
            {
                return "添加失败，原因:\n"+e;
            } 
}

public String 管家设置(String qun,String qq,String skey,String pskey,String type,String status)
{
try{
String cookie="p_uin=o0"+qq+";uin=o0"+qq+";skey="+skey+";p_skey="+pskey;
String put="word_type="+type+"&switch_status="+status+"&group_code="+qun+"&bkn="+GetBkn(skey);
		JSONObject json = new JSONObject(httppost("https://web.qun.qq.com/qunrobot/proxy/domain/app.qun.qq.com/cgi-bin/guanjia_robot/chat_manage/set_switch?bkn="+GetBkn(skey),cookie,put,"application/x-www-form-urlencoded"));
		int retcode= json.get("retcode");
		String retmsg= json.get("retmsg");
		if(retcode==0) return "成功";
		else if(retcode==11002)	return "你不是管理";
		else if(retcode==21000)	return "Q群管家不存在";
		else return "添加失败，原因:\n"+retmsg;
		
		//return ""+json;
		}
catch(Exception e)
            {
                return "添加失败，原因:\n"+e;
            } 
}

public String 链接处理方式(String qun,String qq,String skey,String pskey,String status)
{
try{
String cookie="p_uin=o0"+qq+";uin=o0"+qq+";skey="+skey+";p_skey="+pskey;
String put="word_type=1&handler_type="+status+"&group_code="+qun+"&bkn="+GetBkn(skey);
		JSONObject json = new JSONObject(httppost("https://web.qun.qq.com/qunrobot/proxy/domain/app.qun.qq.com/cgi-bin/guanjia_robot/chat_manage/set_handler?bkn="+GetBkn(skey),cookie,put,"application/x-www-form-urlencoded"));
		int retcode= json.get("retcode");
		String retmsg= json.get("retmsg");
		if(retcode==0) return "成功";
		else if(retcode==11002)	return "你不是管理";
		else if(retcode==21000)	return "Q群管家不存在";
		else return "添加失败，原因:\n"+retmsg;
		
		//return ""+json;
		}
catch(Exception e)
            {
                return "添加失败，原因:\n"+e;
            } 
}

public String 触发问答(String qun,String qq,String skey,String pskey,String question,String token)
{
try{
String cookie="p_uin=o0"+qq+";uin=o0"+qq+";skey="+skey+";p_skey="+pskey;
String put="{ \"anonymous\": 1, \"question\": \""+question+"\", \"token\": \""+token+"\" }";
		JSONObject json = new JSONObject(httppost1("https://app.qun.qq.com/cgi-bin/guanjia_robot/qna_callback/get_answer?bkn="+GetBkn(skey),cookie,put));
		int ec= json.get("ec");
		String em= json.get("em");
		if(ec==0) return "成功";
		else if(ec==70000)	return "会话过期";
		else if(ec==70003)	return "访问频率过快，稍后再试";
		else return "触发失败，原因:\n"+em;
		
		//return ""+json;
		}
catch(Exception e)
            {
                return "触发失败，原因:\n"+e;
            } 
}

public String 添加问答(String qun,String qq,String skey,String pskey,String question,String answer)
{
try{
String cookie="p_uin=o0"+qq+";uin=o0"+qq+";skey="+skey+";p_skey="+pskey;
String put="{\"bkn\":"+GetBkn(skey)+",\"group_id\":"+qun+",\"qna_item\":{\"slot\":0,\"question\":\""+question+"\",\"answer\":\""+answer+"\",\"keyword\":[\""+question+"\"]}}";
		JSONObject json = new JSONObject(httppost("https://web.qun.qq.com/qunrobot/proxy/domain/app.qun.qq.com/cgi-bin/guanjia_robot/qna_setting/set_qna?bkn="+GetBkn(skey),cookie,put,"application/json"));
		//Toast(""+json);
		int retcode= json.get("retcode");
		String msg= json.get("msg");
		if(retcode==0) return "成功";
		else if(retcode==100106)	return "失败，原因:\n问答已存在";
		else if(retcode==100302)	return "你不是管理";
		else if(retcode==1009)	return "访问频率过快，稍后再试";
		else return "添加失败，原因:\n"+msg;
		
		//return ""+json;
		}
catch(Exception e)
            {
                return "添加失败，原因:\n"+e;
            } 
}

public String 删除问答(String qun,String qq,String skey,String pskey,String id)
{
try{
String cookie="p_uin=o0"+qq+";uin=o0"+qq+";skey="+skey+";p_skey="+pskey;
String put="{\"bkn\":"+GetBkn(skey)+",\"group_id\":"+qun+",\"qna_item\":{\"slot\":"+id+",\"question\":\"\",\"answer\":\"\",\"keyword\":[]}}";
		JSONObject json = new JSONObject(httppost("https://web.qun.qq.com/qunrobot/proxy/domain/app.qun.qq.com/cgi-bin/guanjia_robot/qna_setting/set_qna?bkn="+GetBkn(skey),cookie,put,"application/json"));
		int retcode= json.get("retcode");
		String msg= json.get("msg");
		if(retcode==0) return "成功";
		else if(retcode==100405)	return "失败，原因:\n问答不存在";
		else if(retcode==100302)	return "你不是管理";
		else return "删除失败，原因:\n"+msg;
		
		//return ""+json;
		}
catch(Exception e)
            {
                return "删除失败，原因:\n"+e;
            } 
}

public void 管家弹窗(String qun,String qq,int type)
{
if(type!=1) {Toast("非群聊");return;}
Thisactixity = GetActivity();
new Handler(Looper.getMainLooper()).post(new Runnable()
{
public void run()
{
LinearLayout l1 = new LinearLayout(Thisactixity);
l1.setOrientation(LinearLayout.VERTICAL);
l1.setBackgroundColor(Color.WHITE);
Button S = new Button(Thisactixity);
S.setText("查看管家开关");S.setGravity(Gravity.CENTER);S.setTextSize(20);
Button S1 = new Button(Thisactixity);
S1.setText("开/关 管家");S1.setTextColor(Color.parseColor("#000000"));
Button S2 = new Button(Thisactixity);
S2.setText("链接");S2.setTextColor(Color.parseColor("#000000"));
Button S3 = new Button(Thisactixity);
S3.setText("口令红包");S3.setTextColor(Color.parseColor("#000000"));
Button S4 = new Button(Thisactixity);
S4.setText("二维码");S4.setTextColor(Color.parseColor("#000000"));
Button S5 = new Button(Thisactixity);
S5.setText("是否警告");S5.setTextColor(Color.parseColor("#000000"));
TextView S6 = new TextView(Thisactixity);S6.setText(" ");
Button S7 = new Button(Thisactixity);
S7.setText("管家发送文字");S7.setTextColor(Color.parseColor("#000000"));
Button S8 = new Button(Thisactixity);
S8.setText("被管家艾特是否禁言");S5.setTextColor(Color.parseColor("#000000"));
l1.addView(S);
l1.addView(S1);l1.addView(S2);
l1.addView(S3);l1.addView(S4);
l1.addView(S5);l1.addView(S6);
l1.addView(S7);l1.addView(S8);
Dialog dd = new Dialog(Thisactixity);
dd.requestWindowFeature(Window.FEATURE_NO_TITLE);
dd.setContentView(l1);
dd.getWindow().getDecorView().setPadding(0,0,0,0);
dd.getWindow().setGravity(Gravity.BOTTOM);
dd.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
dd.setOnCancelListener(new DialogInterface.OnCancelListener()
{
public void onCancel(DialogInterface dialog)
{
return;
}
});
S.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
new Thread(new Runnable()
{
public void run()
{
try{
	String cookie="p_uin=o0"+MyUin+";uin=o0"+MyUin+";skey="+getSkey()+";p_skey="+getPskey("qun.qq.com");
	String a = httpget("https://web.qun.qq.com/qunrobot/speakmanage?gc="+qun+"&uin=2854196310&f_id=113",cookie);
	int index = a.lastIndexOf("window.__INITIAL_STATE__=");
	String text = a.substring(index + 25);
	int rd = text.indexOf("}<");
	String re = text.substring(0,rd+1);
	JSONObject json=new JSONObject(re);
	String aa = json.getJSONObject("linkSetting").getString("switchStatus");
	String cc = json.getJSONObject("qrcodeSetting").getString("switchStatus");
	String bb = json.getJSONObject("hongbaoSetting").getString("switchStatus");
	String aa1 = json.getJSONObject("linkSetting").getString("text");
	Activity ThisActivity = GetActivity();
	ThisActivity.runOnUiThread(new Runnable()
	{
		public void run()
		{
			AlertDialog alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_DARK).create();
			alertDialog.setTitle("Q群管家开关");
			alertDialog.setMessage(("链接检测："+aa+"\n口令红包检测："+bb+"\n二维码检测："+cc+"\n链接处理方式："+aa1).replace("true","开启").replace("false","关闭"));
			alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确认", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialog, int which)
				{
					return;
				}
			});
			alertDialog.setCancelable(false);
			alertDialog.show();
		}
	});
}
catch(Exception e)
{
Toast("未知错误:\n可能你不是管理");
}
}
}).start();
}
});
S1.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
new Thread(new Runnable()
{
public void run()
{
管家开关(qun,MyUin,type);
}
}).start();
}
});
S2.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
new Thread(new Runnable()
{
public void run()
{
管家链接开关(qun,MyUin,type);
}
}).start();
}
});
S3.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
new Thread(new Runnable()
{
public void run()
{
管家红包开关(qun,MyUin,type);
}
}).start();
}
});
S4.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
new Thread(new Runnable()
{
public void run()
{
管家二维码开关(qun,MyUin,type);
}
}).start();
}
});
S5.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
new Thread(new Runnable()
{
public void run()
{
管家链接处理(qun,MyUin,type);
}
}).start();
}
});
S7.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
new Thread(new Runnable()
{
public void run()
{
管家发送文字(qun);
}
}).start();
}
});
S8.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
new Thread(new Runnable()
{
public void run()
{
管家艾特禁言(qun,MyUin,type);
}
}).start();
}
});
dd.show();
}
});
}
public void 管家开关(String qun,String qq,int type)
{
new Thread(new Runnable()
{
public void run()
{
String title;
String Uin;
if(type==1) title = "("+qun+")";
else{
Toast("不是群哈");
return;
}
String[] items = {
"踢出管家×","邀请管家√","清理管家Token"
};
int set = SingleChoiceList(title, items, 2);
if(set==0)
{
Toast(邀请移除管家(qun,qq,getSkey(),getPskey("qun.qq.com"),0));
putInt(qun,"管家链接开关",0);putInt(qun,"管家链接处理",0);
putInt(qun,"管家红包开关",0);putInt(qun,"管家二维码开关",0);
}
else if(set==1)
{
Toast(邀请移除管家(qun,qq,getSkey(),getPskey("qun.qq.com"),1));
}
else if(set==2)
{
putString(qun,"token",null);
Toast("Token已清理(再次需要管家重新发送问答卡片获取)");
}
else return;
}
}).start();
}
public void 管家链接开关(String qun,String qq,int type)
{
new Thread(new Runnable()
{
public void run()
{
String title;
String Uin;
if(type==1) title = "("+qun+")";
else{
Toast("不是群哈");
return;
}
int top = getInt(qun,"管家链接开关",0);
String[] items = {
"关闭链接检测×","开启链接检测√"
};
int set = SingleChoiceList(title, items, top);
if(set==0)
{
Toast(管家设置(qun,MyUin,getSkey(),getPskey("qun.qq.com"),"1","0"));
putInt(qun,"管家链接开关",0);
}
else if(set==1)
{
Toast(管家设置(qun,MyUin,getSkey(),getPskey("qun.qq.com"),"1","1"));
putInt(qun,"管家链接开关",1);
}
else return;
}
}).start();
}
public void 管家链接处理(String qun,String qq,int type)
{
new Thread(new Runnable()
{
public void run()
{
String title;
String Uin;
if(type==1) title = "("+qun+")";
else{
Toast("不是群哈");
return;
}
int top = getInt(qun,"管家链接处理",0);
String[] items = {
"链接撤回","链接警告并撤回"
};
int set = SingleChoiceList(title, items, top);
if(set==0)
{
Toast(链接处理方式(qun,MyUin,getSkey(),getPskey("qun.qq.com"),"1"));
putInt(qun,"管家链接处理",0);
}
else if(set==1)
{
Toast(链接处理方式(qun,MyUin,getSkey(),getPskey("qun.qq.com"),"3"));
putInt(qun,"管家链接处理",1);
}
else return;
}
}).start();
}
public void 管家红包开关(String qun,String qq,int type)
{
new Thread(new Runnable()
{
public void run()
{
String title;
String Uin;
if(type==1) title = "("+qun+")";
else{
Toast("不是群哈");
return;
}
int top = getInt(qun,"管家红包开关",0);
String[] items = {
"关闭红包检测×","开启红包检测√"
};
int set = SingleChoiceList(title, items, top);
if(set==0)
{
Toast(管家设置(qun,MyUin,getSkey(),getPskey("qun.qq.com"),"3","0"));
putInt(qun,"管家红包开关",0);
}
else if(set==1)
{
Toast(管家设置(qun,MyUin,getSkey(),getPskey("qun.qq.com"),"3","1"));
putInt(qun,"管家红包开关",1);
}
else return;
}
}).start();
}
public void 管家二维码开关(String qun,String qq,int type)
{
new Thread(new Runnable()
{
public void run()
{
String title;
String Uin;
if(type==1) title = "("+qun+")";
else{
Toast("不是群哈");
return;
}
int top = getInt(qun,"管家二维码开关",0);
String[] items = {
"关闭二维码检测×","开启二维码检测√"
};
int set = SingleChoiceList(title, items, top);
if(set==0)
{
Toast(管家设置(qun,MyUin,getSkey(),getPskey("qun.qq.com"),"2","0"));
putInt(qun,"管家二维码开关",0);
}
else if(set==1)
{
Toast(管家设置(qun,MyUin,getSkey(),getPskey("qun.qq.com"),"2","1"));
putInt(qun,"管家二维码开关",1);
}
else return;
}
}).start();
}
public void 管家发送文字(String a) {
initActivity();
ThisActivity.runOnUiThread(new Runnable()
{public void run()
{
TextView textView = new TextView(ThisActivity);
final EditText et = new EditText(ThisActivity);  //显示传入的
et.hint = "请输入内容";  //输入框为空时提示
new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_HOLO_DARK).setTitle("Q群管家发送").setCancelable(false).setView(et).setNeutralButton("发送", new DialogInterface.OnClickListener()
{public void onClick(DialogInterface dialogInterface, int i)
{new Thread(new Runnable()
{public void run()
{String m = et.getText().toString();
//打印输出输入框的内容
skey=getSkey();
pskey=getPskey("qun.qq.com");
//随机字母和数字
String base = "wqetryuioplkjhgfdsazxcvbmnABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
StringBuffer sb = new StringBuffer();
Random rd = new Random();
for(int i=0;i<3;i++) {
	sb.append(base.charAt(rd.nextInt(base.length())));
}
xxx =管家发送(a,MyUin,skey,pskey,User(3),m.replaceAll("\\r\\n|\\n|\\r", "\\\\n"));
Toast(xxx);
}}).start();}}).setNegativeButton("关闭", null).show();}});}
public void 管家艾特禁言(String qun,String qq,int type)
{
new Thread(new Runnable()
{
public void run()
{
String title;
String Uin;
if(type==1) title = "是否禁言";
else{
Toast("不是群哈");
return;
}
int top = getInt(MyUin,"管家艾特禁言",0);
String[] items = {
"不禁言╳","禁言√"
};
int set = SingleChoiceList(title, items, top);
if(set==0)
{
putInt(MyUin,"管家艾特禁言",0);
Toast("已关闭，不再禁言");
}
else if(set==1)
{
putInt(MyUin,"管家艾特禁言",1);
Toast("已开启，当有人被管家@禁言被@人"+atbotshut+"分钟");
}
else return;
}
}).start();
}

public int SingleChoiceList(String title,String[] items,int checkItem)
{
boolean ok = false;
int result = checkItem;
initActivity();
ThisActivity.runOnUiThread(new Runnable()
{
public void run()
{
AlertDialog.Builder alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_DARK);
alertDialog.setTitle(title);
alertDialog.setSingleChoiceItems(items, checkItem, new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialog, int which)
{
result = which;
}
});
alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialog, int which)
{
ok=true;
}
});
alertDialog.setNeutralButton("取消", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialog, int which)
{
result=-1;
ok=true;
}
});
alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
{
public void onCancel(DialogInterface dialog)
{
result=-1;
ok=true;
}
});
alertDialog.show();
}
});
while(!ok)
{
Thread.sleep(50);
}
return result;
}

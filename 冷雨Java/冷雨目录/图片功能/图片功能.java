import java.lang.*;
import android.app.Activity;
import android.view.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
load(AppPath+"/冷雨目录/图片功能/图片.java");

public int ClickList(){
boolean ok = false;
int result = -1;
Activity ThisActivity = GetActivity();
ThisActivity.runOnUiThread(new Runnable(){
public void run(){
AlertDialog.Builder alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_LIGHT);
String[] items ={"复制图片MD5","复制图片链接","制作半透明头像","制作圆圈透明头像","V10认证头像","蓝V认证头像","黄V认证头像","红V认证头像","VIP认证头像","VIP认证头像2","红勾认证头像","绿勾认证头像","企业认证头像","发送xml大图","发送Json超大图","发送Json大图","制作阴影头像","上传头像","制作红旗头像1","制作红旗头像2","制作双重阴影头像","制作绝世佳人头像","美女举牌"};
alertDialog.setTitle("冷雨java---图片功能");
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

addMenuItem("冷雨Java---图片功能","Call");
public void Call(Object data){
if(data.msg.msgtype!=-2000){
Toast("非图片消息!");
return;
}
new Thread(new Runnable(){
public void run(){
int i = ClickList();
if(i==0){
Toast(data.msg.md5);
(ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE).setText(data.msg.md5.trim());
}else if(i==1){
Toast("http://gchat.qpic.cn/gchatpic_new/0/0-0-"+data.msg.md5+"/0?term=2");
(ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE).setText("http://gchat.qpic.cn/gchatpic_new/0/0-0-"+data.msg.md5+"/0?term=2".trim());
}else if(i==2){
Toast("作图中...");
String 图片底=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+".png";
String 图片=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+"1.png";
urltofile("http://gchat.qpic.cn/gchatpic_new/0/0-0-"+data.msg.md5+"/0?term=2",图片底);
pinpic(AppPath+"/冷雨目录/图片功能/全透明.png",图片底,999,0.65,0.5,0.5,90,图片);
if(data.IsGroup) sendPic(data.GroupUin,"",图片);
else sendPic("",data.msg.frienduin,图片);
}else if(i==3){
Toast("作图中...");
String 图片底=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+".png";
String 图片=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+"1.png";
urltofile("http://gchat.qpic.cn/gchatpic_new/0/0-0-"+data.msg.md5+"/0?term=2",图片底);
pinpic(AppPath+"/冷雨目录/图片功能/圆圈.png",图片底,999,0.8,0.5,0.5,360,图片);
if(data.IsGroup) sendPic(data.GroupUin,"",图片);
else sendPic("",data.msg.frienduin,图片);
}else if(i==4){
Toast("作图中...");
String 图片底=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+".png";
String 图片=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+"1.png";
urltofile("http://gchat.qpic.cn/gchatpic_new/0/0-0-"+data.msg.md5+"/0?term=2",图片底);
pinpic(图片底,AppPath+"/冷雨目录/图片功能/V10.png",999,0.65,0.6,0.6,90,图片);
if(data.IsGroup) sendPic(data.GroupUin,"",图片);
else sendPic("",data.msg.frienduin,图片);
}else if(i==5){
Toast("作图中...");
String 图片底=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+".png";
String 图片=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+"1.png";
urltofile("http://gchat.qpic.cn/gchatpic_new/0/0-0-"+data.msg.md5+"/0?term=2",图片底);
pinpic(图片底,AppPath+"/冷雨目录/图片功能/蓝V.png",999,0.65,0.6,0.6,90,图片);
if(data.IsGroup) sendPic(data.GroupUin,"",图片);
else sendPic("",data.msg.frienduin,图片);
}else if(i==6){
Toast("作图中...");
String 图片底=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+".png";
String 图片=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+"1.png";
urltofile("http://gchat.qpic.cn/gchatpic_new/0/0-0-"+data.msg.md5+"/0?term=2",图片底);
pinpic(图片底,AppPath+"/冷雨目录/图片功能/黄V.png",999,0.65,0.6,0.6,90,图片);
if(data.IsGroup) sendPic(data.GroupUin,"",图片);
else sendPic("",data.msg.frienduin,图片);
}else if(i==7){
Toast("作图中...");
String 图片底=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+".png";
String 图片=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+"1.png";
urltofile("http://gchat.qpic.cn/gchatpic_new/0/0-0-"+data.msg.md5+"/0?term=2",图片底);
pinpic(图片底,AppPath+"/冷雨目录/图片功能/红V.png",999,0.65,0.6,0.6,90,图片);
if(data.IsGroup) sendPic(data.GroupUin,"",图片);
else sendPic("",data.msg.frienduin,图片);
}else if(i==8){
Toast("作图中...");
String 图片底=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+".png";
String 图片=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+"1.png";
urltofile("http://gchat.qpic.cn/gchatpic_new/0/0-0-"+data.msg.md5+"/0?term=2",图片底);
pinpic(图片底,AppPath+"/冷雨目录/图片功能/VIP.png",999,0.65,0.6,0.6,90,图片);
if(data.IsGroup) sendPic(data.GroupUin,"",图片);
else sendPic("",data.msg.frienduin,图片);
}else if(i==9){
Toast("作图中...");
String 图片底=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+".png";
String 图片=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+"1.png";
urltofile("http://gchat.qpic.cn/gchatpic_new/0/0-0-"+data.msg.md5+"/0?term=2",图片底);
pinpic(图片底,AppPath+"/冷雨目录/图片功能/VIP2.png",999,0.65,0.6,0.6,90,图片);
if(data.IsGroup) sendPic(data.GroupUin,"",图片);
else sendPic("",data.msg.frienduin,图片);
}else if(i==10){
Toast("作图中...");
String 图片底=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+".png";
String 图片=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+"1.png";
urltofile("http://gchat.qpic.cn/gchatpic_new/0/0-0-"+data.msg.md5+"/0?term=2",图片底);
pinpic(图片底,AppPath+"/冷雨目录/图片功能/红勾.png",999,0.65,0.6,0.6,45,图片);
if(data.IsGroup) sendPic(data.GroupUin,"",图片);
else sendPic("",data.msg.frienduin,图片);
}else if(i==11){
Toast("作图中...");
String 图片底=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+".png";
String 图片=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+"1.png";
urltofile("http://gchat.qpic.cn/gchatpic_new/0/0-0-"+data.msg.md5+"/0?term=2",图片底);
pinpic(图片底,AppPath+"/冷雨目录/图片功能/绿勾.png",999,0.65,0.6,0.6,45,图片);
if(data.IsGroup) sendPic(data.GroupUin,"",图片);
else sendPic("",data.msg.frienduin,图片);
}else if(i==12){
Toast("作图中...");
String 图片底=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+".png";
String 图片=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+"1.png";
urltofile("http://gchat.qpic.cn/gchatpic_new/0/0-0-"+data.msg.md5+"/0?term=2",图片底);
pinpic(图片底,AppPath+"/冷雨目录/图片功能/企业.png",999,0.65,0.6,0.6,45,图片);
if(data.IsGroup) sendPic(data.GroupUin,"",图片);
else sendPic("",data.msg.frienduin,图片);
}else if(i==13){
String pic="<?xml version='1.0' encoding='UTF-8' standalone='yes' ?><msg serviceID='108' templateID='-1' action='' brief='"+PicDisplay+"' sourceMsgId='0' url='' flag='1' adverSign='0' multiMsgFlag='0'><item layout='2' advertiser_id='0' aid='0'><picture cover='http://gchat.qpic.cn/gchatpic_new/0/0-0-"+data.msg.md5+"/0?term=2' w='0' h='0' /><title>冷雨Java:图片转xml</title></item><source name='' icon='' action='' appid='0' /></msg>";
if(data.IsGroup) sendCard(data.GroupUin,"",pic);
else sendCard("",data.msg.frienduin,pic);
}else if(i==14){
String pic="{\"app\":\"com.tencent.gamecenter.mall\",\"desc\":\"\",\"bizsrc\":\"\",\"view\":\"attractFlowArkView\",\"ver\":\"0.0.3.67\",\"prompt\":\""+PicDisplay+"\",\"appID\":\"\",\"sourceName\":\"1104466820\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"template3\":{\"actURL\":\"\",\"actUrl\":\"\",\"adId\":\"1785648\",\"appid\":\"1104466820\",\"bannerImg\":\"\",\"bannerJumpUrl\":\"\",\"bgImg\":\"http://gchat.qpic.cn/gchatpic_new/0/0-0-"+data.msg.md5+"/0?term=2\",\"bgJumpUrl\":\"\",\"btnIcon\":\"\",\"feedId\":549240,\"fid\":50733,\"maskColor\":\"\",\"miniWorldVideoId\":\"\",\"miniWorldVideoUrl\":\"\",\"productId\":\"\",\"title\":\"\",\"txVideo\":\"\",\"videoCoverImg\":\"\",\"videoType\":20}},\"config\":{\"ctime\":1690301715,\"token\":\"e2be557b81e38fbe73f1a0f4913e4dba\"},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"\"}";
String jb=卡片签名(pic);
if(data.IsGroup) sendCard(data.GroupUin,"",jb);
else sendCard("",data.msg.frienduin,jb);
}else if(i==15){
String pic="http://gchat.qpic.cn/gchatpic_new/0/0-0-"+data.msg.md5+"/0?term=2";
String jb=卡片签名2(pic);
if(data.IsGroup) sendCard(data.GroupUin,"",jb);
else sendCard("",data.msg.frienduin,jb);
}else if(i==16){
Toast("作图中...");
String 图片底=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+".png";
String 图片=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+"1.png";
urltofile("http://gchat.qpic.cn/gchatpic_new/0/0-0-"+data.msg.md5+"/0?term=2",图片底);
pinpic(AppPath+"/冷雨目录/图片功能/阴影.png",图片底,0.61,0.61,0.542,0.448,210,图片);
if(data.IsGroup) sendPic(data.GroupUin,"",图片);
else sendPic("",data.msg.frienduin,图片);
}else if(i==17){
String 头像=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+".png";
urltofile("http://gchat.qpic.cn/gchatpic_new/0/0-0-"+data.msg.md5+"/0?term=2",头像);
uploadAvatar(头像);
Toast("上传头像成功！");
}else if(i==18){
Toast("作图中...");
String 图片底=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+".png";
String 图片=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+"1.png";
urltofile("http://gchat.qpic.cn/gchatpic_new/0/0-0-"+data.msg.md5+"/0?term=2",图片底);
pinpic(图片底,AppPath+"/冷雨目录/图片功能/红旗1.png",999,1,0.5,0.5,0,图片);
if(data.IsGroup) sendPic(data.GroupUin,"",图片);
else sendPic("",data.msg.frienduin,图片);
}else if(i==19){
Toast("作图中...");
String 图片底=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+".png";
String 图片=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+"1.png";
urltofile("http://gchat.qpic.cn/gchatpic_new/0/0-0-"+data.msg.md5+"/0?term=2",图片底);
pinpic(图片底,AppPath+"/冷雨目录/图片功能/红旗2.png",999,1,0.5,0.5,0,图片);
if(data.IsGroup) sendPic(data.GroupUin,"",图片);
else sendPic("",data.msg.frienduin,图片);
}else if(i==20){
Toast("作图中...");
String 图片底=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+".png";
String 图片=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+"1.png";
urltofile("http://gchat.qpic.cn/gchatpic_new/0/0-0-"+data.msg.md5+"/0?term=2",图片底);
pinpic(AppPath+"/冷雨目录/图片功能/双重阴影.png",图片底,0.55,0.55,0.542,0.448,90,图片);
if(data.IsGroup) sendPic(data.GroupUin,"",图片);
else sendPic("",data.msg.frienduin,图片);
}else if(i==21){
Toast("作图中...");
String 图片底=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+".png";
String 图片=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+"1.png";
urltofile("http://gchat.qpic.cn/gchatpic_new/0/0-0-"+data.msg.md5+"/0?term=2",图片底);
pinpic(图片底,AppPath+"/冷雨目录/图片功能/绝世佳人.png",1,1,0.5,0.5,0,图片);
if(data.IsGroup) sendPic(data.GroupUin,"",图片);
else sendPic("",data.msg.frienduin,图片);
}else if(i==22){
Toast("作图中...");
String 图片底=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+".png";
String 图片=AppPath+"/冷雨目录/图片功能/缓存/"+System.currentTimeMillis()+"1.png";
urltofile("http://gchat.qpic.cn/gchatpic_new/0/0-0-"+data.msg.md5+"/0?term=2",图片底);
pinpic(AppPath+"/冷雨目录/图片功能/美女举牌.png",图片底,0.5,0.4,0.4,0.4,0,图片);
if(data.IsGroup) sendPic(data.GroupUin,"",图片);
else sendPic("",data.msg.frienduin,图片);
}else return;
}
}).start();
}

public String 卡片签名(String Card){
String pskey=getPskey("vip.qq.com");
String cookie="uin=o0"+MyUin+"; skey="+skey+"; p_uin=o0"+MyUin+"; p_skey="+pskey;
String dataJson="{\"ark\":\""+Card.replace("\"","\\\"").replace("\n","\\\\"+"n")+"\"}";
String url=httppost1(CardSignature+"?g_tk="+GetBkn(skey),cookie,dataJson);
JSONObject json = new JSONObject(url);
String code=json.optString("code");
if(code.equals("0")){
String data=json.getString("data");
JSONObject json1 = new JSONObject(data);
String signed_ark=json1.getString("signed_ark");
String jb=signed_ark.replace("}\n","}");
return jb;
}else{
String data=json.getString("data");
JSONObject json2 = new JSONObject(data);
String message=json2.get("message");
Toast("图转卡签名错误：\n"+message);
}
}

public String 卡片签名2(String pic){
String url="http://ai.xn--7gqa009h.top/api/Ark";
String data="xiaobiaoti="+Subtitle+"&dabiaoti="+headline+"&waixian="+PicDisplay+"&tupian="+pic;
String post=http.post(url,data);
String postt=post.replaceAll(" ","");
JSONObject json = new JSONObject(postt);
String message=json.get("message");
if(message.equals("成功")){
String Ark=json.get("Ark");
String Card=Ark.replace("&#91;","[").replace("&#93;","]");
return Card;
}else{
return "错误:"+message;
}
}
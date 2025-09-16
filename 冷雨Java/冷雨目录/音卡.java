import android.os.Bundle;
import com.tencent.mobileqq.forward.ForwardSDKB77Sender;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;

import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
public void qqsendJSON(String uin1,String uin2,int uintype,String title,String desc,String detail_url,String audio,String img)
{
Bundle bundle = new Bundle();
bundle.putInt("forward_type", 11);
bundle.putString("detail_url", detail_url);
bundle.putString("title", title);
bundle.putString("image_url_remote",img);
bundle.putString("audio_url", audio);
bundle.putInt("req_type", 2);
if(uintype==1000){
bundle.putString("uin", uin1);
bundle.putInt("uintype", 1);
}
else{
bundle.putString("uin", uin1);
bundle.putInt("uintype", uintype);
if(uintype==10014) bundle.putString("guild_id", uin2);
}
bundle.putLong("req_share_id", 100497308);
bundle.putString("desc", desc);
bundle.putString("res_pkg_name", "com.tencent.qqmusic");
bundle.putString("app_name", " QQ音乐");
bundle.putBoolean("needChange", true);

ForwardSDKB77Sender sender=new ForwardSDKB77Sender();
AbsShareMsg abs=new StructMsgForAudioShare(bundle);
if(QQ_version>=8845) sender.e(app,abs,activity,bundle,"");
else sender.a(app,abs,activity,bundle,"");
if(uintype==1000){
new java.lang.Thread(new Runnable()
{
public void run()
{
for(i=0;i<5;i++){
Object messageForArkApp;
if(QQ_version>=8845) messageForArkApp=sender.e;
else messageForArkApp=sender.f;
 if(messageForArkApp!=null){
 messageForArkApp.doParse();
JSONObject json=new JSONObject(messageForArkApp.ark_app_message.toAppXml());
if(json.has("config"))
{
if(!json.get("config").isNull("token")){
sendCard(quncode(uin1),uin2,json+"");
return;
}
}
}
Thread.sleep(3000);
}
sendMsg(quncode(uin1),uin2,"好像转发失败了。去群里看看吧");
}}).start();
}
}


public void qqsendTroopMusic(String qun,String title,String desc,String detail_url,String audio,String img){
qqsendJSON(qun,"",1, title, desc, detail_url, audio, img);
}

public void qqsendChannelMusic(String qun,String title,String desc,String detail_url,String audio,String img){
int i=qun.indexOf("&");
String pin=qun.substring(0,i);
String channel=qun.substring(i+1);
qqsendJSON(channel,pin,10014, title, desc, detail_url, audio, img);
}

public void qqsendTroopMemberMusic(String qun,String qq,String title,String desc,String detail_url,String audio,String img){
sendMsg(quncode(qun),qq,"非好友卡片将先发到群里再转发到私聊");
qqsendJSON(qunuin(qun),qq,1000, title, desc, detail_url, audio, img);
}

public void qqsendFriendMusic(String qq,String title,String desc,String detail_url,String audio,String img){
qqsendJSON(qq,"",0, title, desc, detail_url, audio, img);
} 

public void wysendJSON(String uin1,String uin2,int uintype,String title,String desc,String detail_url,String audio,String img)
{
Bundle bundle = new Bundle();
bundle.putInt("forward_type", 11);
bundle.putString("detail_url", detail_url);
bundle.putString("title", title);
bundle.putString("image_url_remote",img);
bundle.putString("audio_url", audio);
bundle.putInt("req_type", 2);
if(uintype==1000){
bundle.putString("uin", uin1);
bundle.putInt("uintype", 1);
}
else{
bundle.putString("uin", uin1);
bundle.putInt("uintype", uintype);
if(uintype==10014) bundle.putString("guild_id", uin2);
}
bundle.putLong("req_share_id", 100495085);
bundle.putString("desc", desc);
bundle.putString("res_pkg_name", "com.netease.cloudmusic");
bundle.putString("app_name", "网易云音乐");
bundle.putBoolean("needChange", true);

ForwardSDKB77Sender sender=new ForwardSDKB77Sender();
AbsShareMsg abs=new StructMsgForAudioShare(bundle);
if(QQ_version>=8845) sender.e(app,abs,activity,bundle,"");
else sender.a(app,abs,activity,bundle,"");
if(uintype==1000){
new java.lang.Thread(new Runnable()
{
public void run()
{
for(i=0;i<5;i++){
Object messageForArkApp;
if(QQ_version>=8845) messageForArkApp=sender.e;
else messageForArkApp=sender.f;
 if(messageForArkApp!=null){
 messageForArkApp.doParse();
JSONObject json=new JSONObject(messageForArkApp.ark_app_message.toAppXml());
if(json.has("config"))
{
if(!json.get("config").isNull("token")){
sendCard(quncode(uin1),uin2,json+"");
return;
}
}
}
Thread.sleep(3000);
}
sendMsg(quncode(uin1),uin2,"好像转发失败了。去群里看看吧");
}}).start();
}
}
public void wysendTroopMusic(String qun,String title,String desc,String detail_url,String audio,String img){
wysendJSON(qun,"",1, title, desc, detail_url, audio, img);
}

public void wysendChannelMusic(String qun,String title,String desc,String detail_url,String audio,String img){
int i=qun.indexOf("&");
String pin=qun.substring(0,i);
String channel=qun.substring(i+1);
wysendJSON(channel,pin,10014, title, desc, detail_url, audio, img);
}

public void wysendTroopMemberMusic(String qun,String qq,String title,String desc,String detail_url,String audio,String img){
sendMsg(quncode(qun),qq,"非好友卡片将先发到群里再转发到私聊");
wysendJSON(qunuin(qun),qq,1000, title, desc, detail_url, audio, img);
}

public void wysendFriendMusic(String qq,String title,String desc,String detail_url,String audio,String img){
wysendJSON(qq,"",0, title, desc, detail_url, audio, img);
}


public void kgsendJSON(String uin1,String uin2,int uintype,String title,String desc,String detail_url,String audio,String img)
{
Bundle bundle = new Bundle();
bundle.putInt("forward_type", 11);
bundle.putString("detail_url", detail_url);
bundle.putString("title", title);
bundle.putString("image_url_remote",img);
bundle.putString("audio_url", audio);
bundle.putInt("req_type", 2);
if(uintype==1000){
bundle.putString("uin", uin1);
bundle.putInt("uintype", 1);
}
else{
bundle.putString("uin", uin1);
bundle.putInt("uintype", uintype);
if(uintype==10014) bundle.putString("guild_id", uin2);
}
bundle.putLong("req_share_id", 205141);
bundle.putString("desc", desc);
bundle.putString("res_pkg_name", "com.kugou.android");
bundle.putString("app_name", "酷狗音乐");
bundle.putBoolean("needChange", true);

ForwardSDKB77Sender sender=new ForwardSDKB77Sender();
AbsShareMsg abs=new StructMsgForAudioShare(bundle);
if(QQ_version>=8845) sender.e(app,abs,activity,bundle,"");
else sender.a(app,abs,activity,bundle,"");
if(uintype==1000){
new java.lang.Thread(new Runnable()
{
public void run()
{
for(i=0;i<5;i++){
Object messageForArkApp;
if(QQ_version>=8845) messageForArkApp=sender.e;
else messageForArkApp=sender.f;
 if(messageForArkApp!=null){
 messageForArkApp.doParse();
JSONObject json=new JSONObject(messageForArkApp.ark_app_message.toAppXml());
if(json.has("config"))
{
if(!json.get("config").isNull("token")){
sendCard(quncode(uin1),uin2,json+"");
return;
}
}
}
Thread.sleep(3000);
}
sendMsg(quncode(uin1),uin2,"好像转发失败了。去群里看看吧");
}}).start();
}
}
public void kgsendTroopMusic(String qun,String title,String desc,String detail_url,String audio,String img){
kgsendJSON(qun,"",1, title, desc, detail_url, audio, img);
}

public void kgsendChannelMusic(String qun,String title,String desc,String detail_url,String audio,String img){
int i=qun.indexOf("&");
String pin=qun.substring(0,i);
String channel=qun.substring(i+1);
kgsendJSON(channel,pin,10014, title, desc, detail_url, audio, img);
}

public void kgsendTroopMemberMusic(String qun,String qq,String title,String desc,String detail_url,String audio,String img){
sendMsg(quncode(qun),qq,"非好友卡片将先发到群里再转发到私聊");
kgsendJSON(qunuin(qun),qq,1000, title, desc, detail_url, audio, img);
}

public void kgsendFriendMusic(String qq,String title,String desc,String detail_url,String audio,String img){
kgsendJSON(qq,"",0, title, desc, detail_url, audio, img);
}
public void mgsendJSON(String uin1,String uin2,int uintype,String title,String desc,String detail_url,String audio,String img)
{
Bundle bundle = new Bundle();
bundle.putInt("forward_type", 11);
bundle.putString("detail_url", detail_url);
bundle.putString("title", title);
bundle.putString("image_url_remote",img);
bundle.putString("audio_url", audio);
bundle.putInt("req_type", 2);
if(uintype==1000){
bundle.putString("uin", uin1);
bundle.putInt("uintype", 1);
}
else{
bundle.putString("uin", uin1);
bundle.putInt("uintype", uintype);
if(uintype==10014) bundle.putString("guild_id", uin2);
}
bundle.putLong("req_share_id", 1101053067);
bundle.putString("desc", desc);
bundle.putString("res_pkg_name", "cmccwm.mobilemusic");
bundle.putString("app_name", "咪咕音乐");
bundle.putBoolean("needChange", true);

ForwardSDKB77Sender sender=new ForwardSDKB77Sender();
AbsShareMsg abs=new StructMsgForAudioShare(bundle);
if(QQ_version>=8845) sender.e(app,abs,activity,bundle,"");
else sender.a(app,abs,activity,bundle,"");
if(uintype==1000){
new java.lang.Thread(new Runnable()
{
public void run()
{
for(i=0;i<5;i++){
Object messageForArkApp;
if(QQ_version>=8845) messageForArkApp=sender.e;
else messageForArkApp=sender.f;
 if(messageForArkApp!=null){
 messageForArkApp.doParse();
JSONObject json=new JSONObject(messageForArkApp.ark_app_message.toAppXml());
if(json.has("config"))
{
if(!json.get("config").isNull("token")){
sendCard(quncode(uin1),uin2,json+"");
return;
}
}
}
Thread.sleep(3000);
}
sendMsg(quncode(uin1),uin2,"好像转发失败了。去群里看看吧");
}}).start();
}
}
public void mgsendTroopMusic(String qun,String title,String desc,String detail_url,String audio,String img){
mgsendJSON(qun,"",1, title, desc, detail_url, audio, img);
}

public void mgsendChannelMusic(String qun,String title,String desc,String detail_url,String audio,String img){
int i=qun.indexOf("&");
String pin=qun.substring(0,i);
String channel=qun.substring(i+1);
mgsendJSON(channel,pin,10014, title, desc, detail_url, audio, img);
}

public void mgsendTroopMemberMusic(String qun,String qq,String title,String desc,String detail_url,String audio,String img){
sendMsg(quncode(qun),qq,"非好友卡片将先发到群里再转发到私聊");
mgsendJSON(qunuin(qun),qq,1000, title, desc, detail_url, audio, img);
}

public void mgsendFriendMusic(String qq,String title,String desc,String detail_url,String audio,String img){
mgsendJSON(qq,"",0, title, desc, detail_url, audio, img);
}
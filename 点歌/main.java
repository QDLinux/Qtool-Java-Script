//无心
//2877566722
//二改打备注
String LoginUin="";//有绿钻的QQ号(前提是你登录上了),可以实现本账号无绿钻点VIP歌曲留空默认本账号
import android.app.Activity;
//二改的话请不要加加载脚本給自己点赞
Object mycontact;
String qjqq="", at="", Mpath="",Mqq="";
boolean index=false;
String App=pluginPath+"";
if(!App.equals("void")){
index=true;
Mpath=pluginPath;
Mqq=myUin;
}else{
Mpath=AppPath;
Mqq=MyUin;
}
if(index){
loadJava(Mpath+"main/first.java");
}else{
load(Mpath+"/main/first.java");
}
if(LoginUin.equals("")){
LoginUin=Mqq;
}

load(Mpath+"/配置菜单.java");
load(Mpath+"/main/api.java");
//load(Mpath+"/main/AudioManage.java");
load(Mpath+"/main/version.java");
if(!index){
load(Mpath+"/main/send.java");
}else{
load(Mpath+"/main/send2.java");
}
load(Mpath+"/main/login.java");
load(Mpath+"/main/http.java");
load(Mpath+"/main/makepic.java");
load(Mpath+"/main/sendmsg.java");
load(Mpath+"/main/file.java");
load(Mpath+"/main/mydialog.java");
load(Mpath+"/main/class.java");
load(Mpath+"/main/musicbfq.java");
download("http://q1.qlogo.cn/g?b=qq&nk="+Mqq+"&s=640",Mpath+"/图片/my.jpg");

if(zdgx){
new Thread(new Runnable(){
public void run(){
load(Mpath+"/main/renew.java");
}}).start();
}
AddItems("修改配置","配置","配置");
AddItems("搜索音乐","搜索","搜索");
AddItems("解析歌单","歌单","歌单");
AddItems("解析歌单2","歌单2","歌单2");
AddItems("脚本使用说明","说明","说明");
AddItems("开启/关闭QQ点歌","开关","开关");
String mqun="";
String mqq="";
if(!index){
public void 搜索(String qun,String qq,int type){
mqun=qun;
mqq=qq;
showDialog(type);
}
public void 说明(String qun,String qq,int type){
ts("发送\"点歌+歌曲\"即可点歌\n发送\"登录QQ音乐即可登录QQ音乐(登录账号是\"配置菜单.java\"里面的)\n再不会建议删了");
}
public void 配置(String qun,String qq,int type){
pz(Mpath+"/配置菜单.java");
}
public void 歌单(String qun,String qq,int type){
mqun=qun;
mqq=qq;
mygedan(type);
}
public void 歌单2(String qun,String qq,int type){
mqun=qun;
mqq=qq;
myjiexilgd(type);
}
public void 开关(String qun,String qq,int type){
if(type==1){
if(getString(qun,"开关")==null){
putString(qun,"开关","1");
Toastm("已开启");
}else{
putString(qun,"开关",null);
Toastm("已关闭");
}
}else{
if(getString(qq,"开关")==null){
putString(qq,"开关","1");
Toastm("已开启");
}else{
putString(qq,"开关",null);
Toastm("已关闭");
}
}
}
}else{
public void 说明(int type,String qun,String qq){
ts("私聊/群聊开启后\n:发送\"点歌+歌曲\"即可点歌\n发送\"登录QQ音乐即可登录QQ音乐(登录账号是\"配置菜单.java\"里面的)\n再不会建议删了\nPS:Se加载私聊不可以发送卡片,只可以语音/链接,群聊没问题");
}
public void 配置(int type,String qun,String qq){
pz(Mpath+"/配置菜单.java");
}
public void 搜索(int type,String qun,String qq,Object contact){
mqun=qun;
mqq=qq;
mycontact=contact;
new Thread(new Runnable(){
public void run(){
showDialog(type);
}}).start();
}
public void 歌单(int type,String qun,String qq){
mqun=qun;
mqq=qq;
new Thread(new Runnable(){
public void run(){
mygedan(type);
}}).start();
}
public void 歌单2(int type,String qun,String qq){
mqun=qun;
mqq=qq;
new Thread(new Runnable(){
public void run(){
myjiexilgd(type);
}}).start();
}
public void 开关(int type,String qun,String qq){
if(getString(qun,"开关").equals("")){
putString(qun,"开关","1");
Toastm("已开启");
}else{
putString(qun,"开关","");
Toastm("已关闭");
}
}
}
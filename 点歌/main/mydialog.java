
import android.app.AlertDialog;
import android.widget.LinearLayout;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.TextView;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.ClipboardManager;

boolean OK=true;
List mylist = new ArrayList();
List myid = new ArrayList();
List myname = new ArrayList();
List mybofang = new ArrayList();
List mynum = new ArrayList();
List jiexiname = new ArrayList();
List jieximid = new ArrayList();
List jxmyname = new ArrayList();
List jxsingername = new ArrayList();
EditText editText2;
int dialogpd;
ProgressDialog pr2;
public void copy(String selectedText)
{
ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
clipboard.setText(selectedText);
}
public void mysenddialog(int type,int listtype){
Activity act=GetAct();
act.runOnUiThread(new Runnable()
{
public void run()
{
String[] items = (String[])jiexiname.toArray(new String[jiexiname.size()]);
AlertDialog.Builder bf=new AlertDialog.Builder(act, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
bf.setTitle("共"+jieximid.size()+"个");
bf.setItems(items, new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int which) {
msendmusic(which,type,listtype);
}});
bf.setPositiveButton("返回", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialogInterface, int i)
{
if(listtype==3){
myjiexilgd(type);
return;
}
senddialog(type,listtype);
}});
// bf.setNeutralButton("播放全部", new DialogInterface.OnClickListener()
// {
// public void onClick(DialogInterface dialogInterface, int i)
// {

// }});
bf.setCancelable(false);
bf.show();
}});
}
public void showuserdata(List list,int type){
Activity act=GetAct();
act.runOnUiThread(new Runnable()
{
public void run()
{
String[] items = (String[])list.toArray(new String[list.size()]);
AlertDialog.Builder bf=new AlertDialog.Builder(act, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
bf.setTitle("共"+list.size()+"个记录");
bf.setItems(items, new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int which) {
String text=list.get(which);
text=text.replaceAll("\\(.*?\\)", "");
if(dialogpd==2){
mygedan(type);
}else if(dialogpd==1){
showDialog(type);
}else{
myjiexilgd(type);
}
editText2.setText(text);
}});
bf.setNegativeButton("取消", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialogInterface, int i)
{
}});
bf.setNeutralButton("返回", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialogInterface, int i)
{
if(dialogpd==2){
mygedan(type);
}else{
showDialog(type);
}
}});
bf.setCancelable(false);
bf.show();
}});
}
public void sendmusictype(String title,String desc,String id,String url,String detail_url,int which2,int type,int mtype){
Activity act=GetAct();
act.runOnUiThread(new Runnable()
{
public void run()
{
String[] items = {"发送语音","发送卡片","发送歌词","发送链接","播放歌曲"};
AlertDialog.Builder bf=new AlertDialog.Builder(act, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
bf.setTitle(title);
bf.setItems(items, new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int which) {
if(which==0){
ts3("下载中...\n"+title+"--"+desc);
long time=System.currentTimeMillis()/1000;
new Thread(new Runnable(){
public void run(){
url=GetQQMusicSongUrl(id);
act.runOnUiThread(new Runnable()
{
public void run()
{
pr2.setMessage("获取URL成功,开始下载");
}});
String file1=Mpath+"/下载语音/"+time+".mp3";
try{
Create(Mpath+"/下载语音");
download(url,file1);
act.runOnUiThread(new Runnable()
{
public void run()
{
pr2.setMessage("下载完成");
}});
if(index){
if(mqun.equals("")){
sendPtt(mqq,file1,type);
}else{
sendPtt(mqun,file1,type);
}
}else{
sendVoice(mqun,mqq,file1);
}
File f1=new File(file1);
f1.delete();
}catch(e){
ts("\n下载发生错误\n"+e);
}
OK=false;
}}).start();
}else if(which==1){
ts3("发送中...\n"+title+"--"+desc);
new Thread(new Runnable(){
public void run(){
String pic=getpic(id);
url=GetQQMusicSongUrl(id);
act.runOnUiThread(new Runnable()
{
public void run()
{
pr2.setMessage("获取封面，URL成功，开始发送");
}});
if(index){
if(mqun.equals("")){
sendFriendMusic(mqq,title,desc,detail_url,url,pic);
}else{
sendTroopMusic(mqun,title,desc,detail_url,url,pic);
}
}else{
if(type==1){
sendTroopMusic(mqun,title,desc,detail_url,url,pic);
}else{
sendFriendMusic(mqq,title,desc,detail_url,url,pic);
}
}

OK=false;
}}).start();
}else if(which==2){
ts3("发送中...\n"+title+"--"+desc);
new Thread(new Runnable(){
public void run(){
long time=System.currentTimeMillis()/1000;
JSONObject j1=GetQQMusicLyrics(id);
String ok=j1.getString("ok");
act.runOnUiThread(new Runnable()
{
public void run()
{
pr2.setMessage("获取成功,正在生成图片");
}});
if(ok.equals("true")){
String b3=j1.getString("lyric");
b3=b3.replaceAll("\\[.*?\\]", "");
b3=b3.replaceAll("(?m)^\\s*$" , "");
Create(Mpath+"/图片");
String mpath=makepic(b3,Mpath+"/图片/"+time+".png",0,true);
act.runOnUiThread(new Runnable()
{
public void run()
{
pr2.setMessage("生成图片完成");
}});
if(index){
sendPic(mycontact,mpath);
}else{
if(mqun.equals("")){
sendPic("",mqq,mpath);
}else{
sendPic(mqun,"",mpath);
}
}
//sendImage(data,mpath);
OK=false;
Thread.sleep(1000*60);
File f2=new File(mpath);
f2.delete();
}else{
Toastm("获取歌词失败");
OK=false;
}
}}).start();
}else if(which==3){
ts3("获取下载链接...\n"+title+"--"+desc);
new Thread(new Runnable(){
public void run(){
url=GetQQMusicSongUrl(id);
String murl="["+title+"-"+desc+"]下载地址\n"+url;
if(index){
sendMsg(mycontact,murl);
}else{
if(mqun.equals("")){
sendMsg("",mqq,murl);
}else{
sendMsg(mqun,"",murl);
}
}
OK=false;
}}).start();
}else if(which==4){
String geci="";
ts3("获取中...\n"+title+"--"+desc);
new Thread(new Runnable(){
public void run(){
JSONObject j1=GetQQMusicLyrics(id);
String ok=j1.getString("ok");
if(ok.equals("true")){
String b3=j1.getString("lyric");
geci=modifyTimeStamps(b3);
}else{
Toastm("歌词获取失败"+b3);
}
act.runOnUiThread(new Runnable()
{
public void run()
{
pr2.setMessage("获取图片中...");
}});
String pic=getpic(id);
download(pic,Mpath+"/图片/1.jpg");
download(mdgapi,Mpath+"/图片/0.jpg");
act.runOnUiThread(new Runnable()
{
public void run()
{
pr2.setMessage("处理图片中...");
}});
Bitmap b1=convertLocalImageToBitmap(Mpath+"/图片/0.jpg",0);
compressBitmap(b1,2000,1000);
try {
File file = new File(Mpath+"/图片/0.jpg");
FileOutputStream fos = new FileOutputStream(Mpath+"/图片/0.jpg");
b1.compress(Bitmap.CompressFormat.PNG, 100, fos);
fos.close();
} catch (Exception e) {
e.printStackTrace();
}
url=GetQQMusicSongUrl(id);
act.runOnUiThread(new Runnable()
{
public void run()
{
pr2.setMessage("完成");
}});
mybfq(desc,title,url,pic,geci);
OK=false;
}}).start();
}
}});
bf.setNeutralButton("返回", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialogInterface, int i)
{
msendmusic(which2,type,mtype);
}});
bf.setCancelable(false);
bf.show();
}});
}
public void senddialog(int type,int listtype){
Activity act=GetAct();
act.runOnUiThread(new Runnable()
{
public void run()
{
String[] items = (String[])mylist.toArray(new String[mylist.size()]);
AlertDialog.Builder bf=new AlertDialog.Builder(act, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
bf.setTitle("共搜索到了"+mylist.size()+"个");
bf.setItems(items, new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int which) {
if(listtype==1){
msendmusic(which,type,listtype);
}else{
ts3("获取中");
jiexiname.clear();
jxsingername.clear();
jxmyname.clear();
jieximid.clear();
new Thread(new Runnable(){
public void run(){
String json=get("http://u6.y.qq.com/cgi-bin/musicu.fcg?data=%7B%0A++%22Songlist%22+%3A+%7B%0A++++%22module%22+%3A+%22music.srfDissInfo.DissInfo%22%2C%0A++++%22method%22+%3A+%22CgiGetDiss%22%2C%0A++++%22param%22+%3A+%7B%0A++++++%22dirid%22+%3A+0%2C%0A++++++%22from%22+%3A+15%2C%0A++++++%22ctx%22+%3A+0%2C%0A++++++%22onlysonglist%22+%3A+0%2C%0A++++++%22orderlist%22+%3A+1%2C%0A++++++%22tag%22+%3A+1%2C%0A++++++%22rec_flag%22+%3A+1%2C%0A++++++%22disstid%22+%3A+"+myid.get(which)+"%2C%0A++++++%22new_format%22+%3A+1%2C%0A++++++%22host_uin%22+%3A+0%2C%0A++++++%22optype%22+%3A+2%2C%0A++++++%22enc_host_uin%22+%3A+%220%22%0A++++%7D%0A++%7D%2C%0A%22comm%22+%3A+%7B%0A++++%22ct%22+%3A+%221%22%2C%0A++++%22v%22+%3A+%2290%22%2C%0A++++%22cv%22+%3A+%22101805%22%2C%0A++++%22gzip%22+%3A+%220%22%0A++%7D%0A%7D");
try{
JSONObject b=new JSONObject(json);
JSONObject songlist=b.getJSONObject("Songlist").getJSONObject("data");
JSONArray jsonArray = songlist.getJSONArray("songlist");
for(int i = 0;i<jsonArray.length();i++){
String singer="";
int i2=i+1;
JSONObject item = jsonArray.getJSONObject(i);
JSONArray jsonArray2 = item.getJSONArray("singer");
for(int k = 0;k<jsonArray2.length();k++){
JSONObject jsonObject = jsonArray2.getJSONObject(k);
String mname=jsonObject.getString("name");
if(k==0){
singer=mname;
}else{
singer+="/"+mname;
}
}
jxsingername.add(singer);
String mid=item.getString("mid");
String name=item.getString("name");
jiexiname.add(i2+"."+name+"("+singer+")");
jxmyname.add(name);
jieximid.add(mid);
}
mysenddialog(type,listtype);//
}catch(e){
ts("解析错误\n"+e);
}
OK=false;
}}).start();
}
}
});
bf.setNegativeButton("返回", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialogInterface, int i)
{
if(listtype==1){
showDialog(type);
}else{
mygedan(type);
}
}});
bf.setPositiveButton("取消", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialogInterface, int i)
{
}});
bf.setCancelable(false);
bf.show();
}});
}
public void ts3(String msg)
{
OK=true;
Activity act = GetAct();
act.runOnUiThread(new Runnable()
{
public void run()
{
ProgressDialog pr = new ProgressDialog(act,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
pr2=pr;
pr.setTitle("提示");
pr.setMessage(msg);
pr.setCancelable(false);
pr.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int which) {
pr.dismiss();
OK=false;
}});
pr.show();
new Thread(new Runnable(){
public void run(){
while(true){
Thread.sleep(50);
if(!OK){
pr.dismiss();
break;
}
}
}}).start();
}});
}
public void showDialog(int type){
Activity act = GetAct();
act.runOnUiThread(new Runnable()
{
public void run()
{
dialogpd=1;
boolean OK2=false;
String[] ww = {"是否保存本歌曲"};
boolean[] xx={false};
 editText2 = new EditText(act);
 editText2.setBackground(getShape("#FFFFFF","#F2F1F6",5,20,200,false));
editText2.setHint("请输入歌曲名字");
LinearLayout cy=new LinearLayout(act);
cy.setOrientation(LinearLayout.VERTICAL);
cy.addView(editText2);
new AlertDialog.Builder(act, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT).setTitle("搜索").setView(cy).setMultiChoiceItems(ww, xx, new DialogInterface.OnMultiChoiceClickListener(){
public void onClick(DialogInterface dialogInterface, int which, boolean isChecked){
if(isChecked){
OK2=true;
}else {
OK2=false;
}
}}).setPositiveButton("确认", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialogInterface, int i)
{
String msg=editText2.getText().toString();
if(msg.trim().isEmpty()){
Toastm("请输入内容");
return;
}
ts3("获取中");
mylist.clear();
new Thread(new Runnable(){
public void run(){
getjsondata(msg,Mqq);
for(String tex: music2){
if(tex.startsWith("{\""+Mqq+"\":")){
JSONObject jsonObject = new JSONObject(tex);
JSONArray jsonArray = jsonObject.getJSONArray(Mqq);
for (int i = 0; i < jsonArray.length(); i++) {
JSONObject item = jsonArray.getJSONObject(i);
int i2=i+1;
String name3 = item.getString("title");
String singer = item.getString("singer");
String name2 = item.getString("name");
String list=i2+"."+name3+"--"+singer+"["+name2+"]";
list =list.replace("[]","");
mylist.add(list);
}
}
}
senddialog(type,1);
if(OK2){
putdata(msg,Mpath+"/main/歌曲.json");
Toastm("解析成功,歌曲已保存本地");
}
OK=false;
}}).start();
}
}).setNegativeButton("取消", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialogInterface, int i)
{

}
}).setNeutralButton("搜索歌曲记录", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialogInterface, int i)
{
ts3("获取中...");
new Thread(new Runnable(){
public void run(){
List data=readdata(Mpath+"/main/歌曲.json");
if(data==null){
ts("获取列表错误,可能没搜索记录");
OK=false;
return;
}
if(data.size()==0){
ts("暂无记录");
OK=false;
return;
}
showuserdata(data,type);
OK=false;
}}).start();
}}).setCancelable(false).show();
}});
}
public void ts(String cont){
Activity act = GetAct();
act.runOnUiThread(new Runnable()
{
public void run()
{
TextView editText = new TextView(act);
editText.setText(cont);
editText.setTextSize(15);
editText.setPadding(20,15,20,0);
editText.setTextColor(Color.parseColor("#000000"));
LinearLayout cy=new LinearLayout(act);
cy.setOrientation(LinearLayout.VERTICAL);
cy.addView(editText);
new AlertDialog.Builder(act, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT).setTitle("提示").setView(cy).setPositiveButton("了解", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialogInterface, int i)
{
}}).setNegativeButton("复制", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialogInterface, int i)
{
copy(cont);
Toastm("已复制");
}}).setCancelable(false).show();
}});
}
public void msendmusic(int which,int type,int mtype){
Activity act = GetAct();
String id="",title="",url="",desc="",detail_url="";
if(mtype==1){
for(String tex: music2){
if(tex.startsWith("{\""+Mqq+"\":")){
JSONObject jsonObject = new JSONObject(tex);
JSONArray jsonArray = jsonObject.getJSONArray(Mqq);
JSONObject item = jsonArray.getJSONObject(which);
 id = item.getString("mid");
 title = item.getString("title");
 desc=item.getString("singer");
 detail_url="https://i.y.qq.com/v8/playsong.html?songmid="+id;
}}
}else{
id = jieximid.get(which);
title =jxmyname.get(which);
desc=jxsingername.get(which);
detail_url="https://i.y.qq.com/v8/playsong.html?songmid="+id;
}
TextView editText = new TextView(act);
editText.setPadding(25,0,0,0);
editText.setTextSize(20);
if(mtype==1){
editText.setText(mylist.get(which));
}else{
editText.setText(jiexiname.get(which));
}
LinearLayout cy=new LinearLayout(act);
cy.setOrientation(LinearLayout.VERTICAL);
cy.addView(editText);
new AlertDialog.Builder(act, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT).setTitle("确认发送？").setView(cy).setPositiveButton("发送", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialogInterface, int i)
{
/*

*/
sendmusictype(title,desc,id,url,detail_url,which,type,mtype);
}
}).setNegativeButton("返回", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialogInterface, int i)
{
if(mtype==1){
senddialog(type,1);
}else{
mysenddialog(type,mtype);
}
}
}).setCancelable(false).show();
}
public void mygedan(int type){
Activity act = GetAct();
act.runOnUiThread(new Runnable()
{
public void run()
{
myid.clear();
mynum.clear();
myname.clear();
mybofang.clear();
jxmyname.clear();
dialogpd=2;
boolean OK2=false;
String[] ww = {"是否保存本QQ"};
boolean[] xx={false};
editText2 = new EditText(act);
editText2.setHint("请输入QQ号");
editText2.setBackground(getShape("#FFFFFF","#F2F1F6",5,20,200,false));
TextView t1=new TextView(act);
t1.setPadding(20,10,20,0);
t1.setText("解析QQ音乐歌单\n输入QQ号即可\n(部分用户QQ音乐里开启了不允许访问主页会解析失败)");
LinearLayout cy=new LinearLayout(act);
cy.setOrientation(LinearLayout.VERTICAL);
cy.addView(t1);
cy.addView(editText2);
new AlertDialog.Builder(act, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT).setTitle("解析歌单").setView(cy).setMultiChoiceItems(ww, xx, new DialogInterface.OnMultiChoiceClickListener(){
public void onClick(DialogInterface dialogInterface, int which, boolean isChecked){
if(isChecked){
OK2=true;
}else {
OK2=false;
}
}}).setPositiveButton("确认", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialogInterface, int i)
{
String msg=editText2.getText().toString();
if(msg.trim().isEmpty()){
Toastm("请输入内容");
return;
}
if(!msg.matches("[0-9]+")){Toastm("QQ号输入错误,不是纯数字");return;}
ts3("获取中");
mylist.clear();
new Thread(new Runnable(){
public void run(){
String data=getuinmusic(msg);
try{
JSONObject b=new JSONObject(data);
String message=b.getString("message");
if(message.equals("check privacy error!")){
ts("该账号设置了主页不可访问,无法解析歌单\n返回数据:"+data);
OK=false;
return;
}
JSONObject b2=b.getJSONObject("data");
String nickname=b2.getString("hostname");
JSONArray jsonArray = b2.getJSONArray("disslist");
for(int i = 0;i<jsonArray.length();i++){
try{
JSONObject item = jsonArray.getJSONObject(i);
String tid=item.getString("tid");
String name=item.getString("diss_name");
String num=item.getString("song_cnt");
String bofang=item.getString("listen_num");
if(!tid.equals("0")){
myid.add(tid);
myname.add(name);
mynum.add(num);
mybofang.add(bofang);
mylist.add(i+"."+name+"("+num+"首"+bofang+"次播放)");
}
}catch(e){
ts("错误\n"+e);
}
}
senddialog(type,2);
if(OK2){
putdata(msg+"("+nickname+")",Mpath+"/main/数据.json");
Toastm("解析成功,QQ已保存本地");
}
OK=false;
}catch(e){
ts("错误\n"+e);
OK=false;
}
}}).start();
}
}).setNegativeButton("取消", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialogInterface, int i)
{

}
}).setNeutralButton("解析成功列表", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialogInterface, int i)
{
ts3("获取中...");
new Thread(new Runnable(){
public void run(){
List data=readdata(Mpath+"/main/数据.json");
if(data==null){
ts("获取列表错误,可能没解析记录");
OK=false;
return;
}
if(data.size()==0){
ts("暂无解析记录");
OK=false;
return;
}
showuserdata(data,type);
OK=false;
}}).start();
}}).setCancelable(false).show();
}});
}
public void myjiexilgd(int type){
Activity act = GetAct();
act.runOnUiThread(new Runnable()
{
public void run()
{
dialogpd=3;
boolean OK2=false;
String[] ww = {"是否保存解析链接"};
boolean[] xx={false};
editText2 = new EditText(act);
editText2.setBackground(getShape("#FFFFFF","#F2F1F6",5,20,200,false));
editText2.setHint("请输入歌单链接/歌单Json代码");
TextView t1=new TextView(act);
t1.setPadding(20,10,20,0);
t1.setText("解析QQ音乐歌单\n输入歌单链接/歌单Json代码即可");
LinearLayout cy=new LinearLayout(act);
cy.setOrientation(LinearLayout.VERTICAL);
cy.addView(t1);
cy.addView(editText2);
new AlertDialog.Builder(act, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT).setTitle("解析歌单2").setView(cy).setMultiChoiceItems(ww, xx, new DialogInterface.OnMultiChoiceClickListener(){
public void onClick(DialogInterface dialogInterface, int which, boolean isChecked){
if(isChecked){
OK2=true;
}else {
OK2=false;
}
}}).setPositiveButton("确认", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialogInterface, int i)
{
String msg=editText2.getText().toString();
if(msg.trim().isEmpty()){
Toastm("请输入内容");
return;
}
if(!msg.startsWith("http")&&!msg.startsWith("{")){Toastm("不是卡片代码或链接");return;}
ts3("获取中");
String msg2="";
jieximid.clear();
jxsingername.clear();
jxmyname.clear();
jiexiname.clear();
mylist.clear();
if(msg.startsWith("{")){
msg=getjsonurl(msg);
}
if(!msg.startsWith("http")){
ts("获取错误\n"+msg);
OK=false;
return;
}
new Thread(new Runnable(){
public void run(){
/*
boolean gedan=getgedanjiexi(msg);
if(gedan){
mysenddialog(type,3);
}else{
ts("解析错误");
OK=false;
return;
}
*/
try{
msg2=msg.substring(msg.lastIndexOf("&id=")+4,msg.lastIndexOf("&ADTAG=qfshare"));
}catch(e){
Toastm("解析路径1获取错误,尝试2解析"+msg);
boolean gedan=getgedanjiexi(msg);
if(gedan){
mysenddialog(type,3);
if(OK2){
putdata(msg,Mpath+"/main/歌单2.json");
Toastm("解析成功,链接已存储");
}
}else{
ts("解析失败"+e);
}
OK=false;
return;
}
String data2=postWithAgentCookie("http://u6.y.qq.com/cgi-bin/musicu.fcg","%7B%0A++%22Songlist%22+%3A+%7B%0A++++%22module%22+%3A+%22music.srfDissInfo.DissInfo%22%2C%0A++++%22method%22+%3A+%22CgiGetDiss%22%2C%0A++++%22param%22+%3A+%7B%0A++++++%22dirid%22+%3A+0%2C%0A++++++%22from%22+%3A+15%2C%0A++++++%22ctx%22+%3A+0%2C%0A++++++%22onlysonglist%22+%3A+0%2C%0A++++++%22orderlist%22+%3A+1%2C%0A++++++%22tag%22+%3A+1%2C%0A++++++%22rec_flag%22+%3A+1%2C%0A++++++%22disstid%22+%3A+"+msg2+"%2C%0A++++++%22new_format%22+%3A+1%2C%0A++++++%22host_uin%22+%3A+0%2C%0A++++++%22optype%22+%3A+2%2C%0A++++++%22enc_host_uin%22+%3A+%220%22%0A++++%7D%0A++%7D%2C%0A%22comm%22+%3A+%7B%0A++++%22ct%22+%3A+%221%22%2C%0A++++%22v%22+%3A+%2290%22%2C%0A++++%22cv%22+%3A+%22101805%22%2C%0A++++%22gzip%22+%3A+%220%22%0A++%7D%0A%7D","uin=1");
try{
//ts(data2);
JSONObject b=new JSONObject(data2);
JSONObject b2=b.getJSONObject("Songlist").getJSONObject("data");
JSONArray jsonArray = b2.getJSONArray("songlist");
for(int i = 0;i<jsonArray.length();i++){
String singer="";
int i2=i+1;
JSONObject item = jsonArray.getJSONObject(i);
String name=item.getString("name");
String mid=item.getString("mid");
JSONArray jsonArray2= item.getJSONArray("singer");
for(int k= 0;k<jsonArray2.length();k++){
JSONObject item2 =jsonArray2.getJSONObject(k);
if(k==0){
singer=item2.getString("name");
}else{
singer+="/"+item2.getString("name");
}
}
jxmyname.add(name);
jxsingername.add(singer);
jieximid.add(mid);
jiexiname.add(i2+"."+name+"("+singer+")");
}
}catch(e){
ts("解析错误\n"+e);
OK=false;
return;
}
mysenddialog(type,3);//
if(OK2){
putdata(msg,Mpath+"/main/歌单2.json");
Toastm("解析成功,链接已存储");
}
OK=false;
}}).start();
}
}).setNegativeButton("取消", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialogInterface, int i)
{

}
}).setNeutralButton("解析成功列表", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialogInterface, int i)
{
ts3("获取中...");
new Thread(new Runnable(){
public void run(){
List data=readdata(Mpath+"/main/歌单2.json");
if(data==null){
ts("获取列表错误,可能没解析记录");
OK=false;
return;
}
if(data.size()==0){
ts("暂无解析记录");
OK=false;
return;
}
showuserdata(data,type);
OK=false;
}}).start();
}}).setCancelable(false).show();
}});
}
public void pz(String file){
Activity act = GetAct();
act.runOnUiThread(new Runnable()
{
public void run()
{
TextView t1=new TextView(act);
t1.setText("修改完成后重新加载生效,如果修改后报错\n把\""+Mpath+"/配置菜单.java\"里面的文件内容替换成\n\""+Mpath+"/main/别动别删/a.txt\"里面的文件内容即可");
t1.setTextSize(14);
t1.setTextColor(Color.parseColor("#000000"));
EditText editText = new EditText(act);
editText.setText("获取中...");
editText.setBackground(getShape("#FFFFFF","#F2F1F6",5,20,200,false));
editText.setTextSize(15);
editText.setPadding(20,15,20,0);
editText.setTextColor(Color.parseColor("#000000"));
LinearLayout cy=new LinearLayout(act);
cy.setOrientation(LinearLayout.VERTICAL);
cy.addView(t1);
cy.addView(editText);
new Thread(new Runnable(){
public void run(){
String msg=readdata2(file);
act.runOnUiThread(new Runnable()
{
public void run()
{
editText.setText(msg);
}});
}}).start();
new AlertDialog.Builder(act, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT).setTitle("配置修改").setView(cy).setPositiveButton("取消", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialogInterface, int i)
{
}}).setNegativeButton("确认", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialogInterface, int i)
{
String msg2=editText.getText().toString();
put(file,msg2);
Toastm("成功,重新加载生效");
}}).show();
}});
}
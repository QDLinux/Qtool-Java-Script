Object Mydata;
boolean OK3=false;
public void onMsg(Object data){
String text="";
String qun="";
String qq="";
if(!index){
 text=data.MessageContent;
 qun=data.GroupUin;
 qq=data.UserUin;
 if(qun.equals("")){
 at="["+qq+"]";
 }else{
 at="[AtQQ="+qq+"]";
 }
 }else{
 text=data.msg;
 qun=data.peerUid;
 qq=data.user;
 if(data.type==1){
 at="["+qq+"]";
 }else{
 at="[atUin="+qq+"]";
 }
 }
String qq2="";
if(!qun.equals("")){
qq2="";
}else{
qq2=qq;
}
if(qq.equals(Mqq)){
if(text.equals("登陆QQ音乐")){
login(new JSONObject("{\"ReLogin\":true}"));
}
}
if(!index){
if(!index&&data.IsGroup&&getString(qun,"开关")==null){
return;
}
if(!index&&!data.IsGroup&&getString(qq,"开关")==null){
return;
}
}
if(index){
if(index&&data.type==2&&getString(qun,"开关").equals("")){
return;
}
if(index&&data.type==1&&getString(qq,"开关").equals("")){
//Toastm(qq+"MSG"+getString(qq,"开关"));
return;
}
}
for(String dgkey2:dgkey){
if(text.startsWith(dgkey2)){
long time=System.currentTimeMillis()/1000;
String msg=text.substring(dgkey2.length());
if(msg.equals("")||msg.trim().isEmpty()){sendCont(data,at+"\n未输入内容");return;}
for(String wjc2:wjc){
if(msg.contains(wjc2)){
sendCont(data,at+"\n带有违禁词,点歌失败");
return;
}
}
if(filterEmoji(msg)){
sendCont(data,at+"\n带有表情,点歌失败");
return;
}
String music=getjsondata(msg,qun+qq);
if(music!=null){
if(mdgpd!=0){
try{
JSONObject jsonObject = new JSONObject(music);
JSONArray jsonArray = jsonObject.getJSONArray(qun+qq);
JSONObject item = jsonArray.getJSONObject(mdgxx-1);
String id = item.getString("mid");
String title = item.getString("title");
String me = item.getString("endtime");
String url=GetQQMusicSongUrl(id);
String desc=item.getString("singer");
String detail_url="https://i.y.qq.com/v8/playsong.html?songmid="+id;
if(!url.startsWith("http")){
sendCont(data,at+"\n当前歌曲\n["+title+"-"+desc+"]\n需要VIP或者付费\n下载链接:\n"+detail_url);
return;
}
if(mdgpd==1){
String pic=getpic(id);
if(qq2.equals("")){
sendTroopMusic(qun,title,desc,detail_url,url,pic);
}else{
if(index){
sendCont(data,at+"\n当前好友不支持发送卡片，请选择其他的");
return;
}
sendFriendMusic(qq,title,desc,detail_url,url,pic);
}
}else if(mdgpd==2){
sendCont(data,at+"\n开始下载\n["+title+"-"+desc+"]");
String file1=Mpath+"/下载语音/"+time+".mp3";
try{
Create(Mpath+"/下载语音");
download(url,file1);
sendMp3(data,file1);
File f1=new File(file1);
f1.delete();
}catch(e){
sendCont(data,at+"\n下载发生错误\n"+e);
}
}else if(mdgpd==3){
JSONObject j1=GetQQMusicLyrics(id);
String ok=j1.getString("ok");
if(ok.equals("true")){
String b3=j1.getString("lyric");
b3=b3.replaceAll("\\[.*?\\]", "");
b3=b3.replaceAll("(?m)^\\s*$" , "");
if(dggcpd){
String pic=getpic(id);
if(qq2.equals("")){
sendTroopMusic(qun,title,desc,detail_url,url,pic);
}else{
if(index){
sendCont(data,at+"\n当前好友不支持发送卡片，请选择其他的");
return;
}
}
sendFriendMusic(qq,title,desc,detail_url,url,pic);
}
if(mygctype==1){
new Thread(new Runnable(){
public void run(){
Create(Mpath+"/图片");
String mpath=makepic(b3,Mpath+"/图片/"+time+".png",0,true);
sendImage(data,mpath);
Thread.sleep(1000*60);
File f2=new File(mpath);
f2.delete();
}}).start();
}else{
String mdata="{\"type\": \"node\",\"data\": {\"name\":\"点歌\",\"uin\":\""+qq+"\",\"content\":\""+b3+"\"}}";
mdata =mdata.replaceAll("\n","\\\\n");
String jsondata=post("http://159.75.175.66:6677/API/qq_merge.php",mdata);
jsondata =jsondata.replace("{\"text\":\"n: n\"},{\"text\":\": \"},","{\"text\":\"点击查看["+title+"-"+desc+"]的歌词\"}").replace("[聊天记录]","["+title+"-"+desc+"]");
try{
jsondata=jsondata.substring(jsondata.lastIndexOf("{\"app\":\"com.tencent.multimsg\",")+0,jsondata.lastIndexOf("\"ver\":\"0.0.0.5\",\"view\":\"contact\"}")+33);
sendMcard(data,jsondata);
}catch(e){
sendCont(data,"合并转发错误\n"+e);
}
}
}else{
sendCont(data,at+"\n获取歌词失败");
}
}else{
sendCont(data,at+"\n["+title+"-"+desc+"]下载地址\n"+url);
}
}catch(e){
sendCont(data,at+"\n 点歌失败"+e);
}
}else if(mysendtype==1){
sendCont(data,music);
}else if(mysendtype==2){
new Thread(new Runnable(){
public void run(){
Create(Mpath+"/图片");
String mpath=makepic(music,Mpath+"/图片/"+time+".png",1,false);
sendImage(data,mpath);
Thread.sleep(1000*60);
File f2=new File(mpath);
f2.delete();
}}).start();
}else if(mysendtype==3){
new Thread(new Runnable(){
public void run(){
String mdata="{\"type\": \"node\",\"data\": {\"name\":\"点歌\",\"uin\":\""+qq+"\",\"content\":\""+music+"\"}}";
mdata =mdata.replaceAll("\n","\\\\n");
String jsondata=post("http://159.75.175.66:6677/API/qq_merge.php",mdata);
jsondata =jsondata.replace("{\"text\":\"n: n\"},{\"text\":\": \"},","{\"text\":\"点击查看["+msg+"]的歌曲\"}").replace("[聊天记录]",msg);
try{
jsondata=jsondata.substring(jsondata.lastIndexOf("{\"app\":\"com.tencent.multimsg\",")+0,jsondata.lastIndexOf("\"ver\":\"0.0.0.5\",\"view\":\"contact\"}")+33);
sendMcard(data,jsondata);
}catch(e){
sendCont(data,"合并转发错误\n"+e);
}
}}).start();
}else{
String card="{\"app\":\"com.tencent.qianbao\",\"desc\":\"\",\"view\":\"genericMessageView\",\"bizsrc\":\"\",\"ver\":\"1.0.0.72\",\"prompt\":\"歌曲["+msg+"]\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"message\":{\"content\":\""+music.replace("\"","\\\"").replace("[AtQQ=","[").replace("[atUin=","[")+"\",\"_blackHole_\":\"\",\"subContentColor\":\"0099FF\"}},\"config\":{\"round\":0,\"autosize\":1,\"ctime\":1700906148,\"token\":\"\"},\"text\":\"\",\"extraApps\":[],\"sourceAd\":\"\",\"extra\":\"\"}";
card=card.replaceAll("\n","\\\\n");
sendMcard(data,card);
}
}else{
sendCont(data,"没有找到");
}
break;
}
}
if(text.matches("^[0-9]*$")||text.startsWith("链接")||text.startsWith("语音")||text.startsWith("歌词")){
if(mdgpd!=0)return;
long time=System.currentTimeMillis()/1000;
int type=0;
int iw=0;
try{
if(text.startsWith("链接")){
String text2=text.substring(2);
int ie=Integer.parseInt(text2);
type=1;
iw=ie-1;
}else if(text.matches("^[0-9]*$")){
int i2=Integer.parseInt(text);
iw=i2-1;
type=0;
}else if(text.startsWith("语音")){
String text2=text.substring(2);
int ie=Integer.parseInt(text2);
type=2;
iw=ie-1;
}else if(text.startsWith("歌词")){
String text2=text.substring(2);
int ie=Integer.parseInt(text2);
type=3;
iw=ie-1;
}
}catch(e){return;}
login(null);
for(String tex: music2){
if(tex.startsWith("{\""+qun+qq+"\":")){
try{
JSONObject jsonObject = new JSONObject(tex);
JSONArray jsonArray = jsonObject.getJSONArray(qun+qq);
if(iw>jsonArray.length()){break;}
JSONObject item = jsonArray.getJSONObject(iw);
long time2=item.getLong("endtime");

if(time-time2>MAX){
int index = music2.indexOf(tex);
music2.remove(index);
return;
}
item.put("endtime",""+time);

String id = item.getString("mid");
String title = item.getString("title");
String me = item.getString("endtime");
String url=GetQQMusicSongUrl(id);
String desc=item.getString("singer");
String detail_url="https://i.y.qq.com/v8/playsong.html?songmid="+id;
if(!url.startsWith("http")){
sendCont(data,at+"\n当前歌曲\n["+title+"-"+desc+"]\n需要VIP或者付费\n下载链接:\n"+detail_url);
return;
}
if(type==0){
String pic=getpic(id);
if(qq2.equals("")){
sendTroopMusic(qun,title,desc,detail_url,url,pic);
}else{
if(index){
sendCont(data,at+"\n当前好友不支持发送卡片，请选择其他的");
return;
}
sendFriendMusic(qq,title,desc,detail_url,url,pic);
}
}else if(type==1){
sendCont(data,at+"\n["+title+"-"+desc+"]下载地址\n"+url);
}else if(type==2){
sendCont(data,at+"\n开始下载\n["+title+"-"+desc+"]");
String file1=Mpath+"/下载语音/"+time+".mp3";
try{
Create(Mpath+"/下载语音");
download(url,file1);
sendMp3(data,file1);
File f1=new File(file1);
f1.delete();
}catch(e){
sendCont(data,at+"\n下载发生错误\n"+e);
}
}else if(type==3){
JSONObject j1=GetQQMusicLyrics(id);
String ok=j1.getString("ok");
if(ok.equals("true")){
String b3=j1.getString("lyric");
b3=b3.replaceAll("\\[.*?\\]", "");
b3=b3.replaceAll("(?m)^\\s*$" , "");
if(mygctype==1){
if(dggcpd){
String pic=getpic(id);
if(qq2.equals("")){
sendTroopMusic(qun,title,desc,detail_url,url,pic);
}else{
if(index){
sendCont(data,at+"\n当前好友不支持发送卡片，请选择其他的");
return;
}
}
sendFriendMusic(qq,title,desc,detail_url,url,pic);
}
new Thread(new Runnable(){
public void run(){
Create(Mpath+"/图片");
String mpath=makepic(b3,Mpath+"/图片/"+time+".png",0,true);
sendImage(data,mpath);
Thread.sleep(1000*60);
File f2=new File(mpath);
f2.delete();
}}).start();
}else{
String mdata="{\"type\": \"node\",\"data\": {\"name\":\"点歌\",\"uin\":\""+qq+"\",\"content\":\""+b3+"\"}}";
mdata =mdata.replaceAll("\n","\\\\n");
String jsondata=post("http://159.75.175.66:6677/API/qq_merge.php",mdata);
jsondata =jsondata.replace("{\"text\":\"n: n\"},{\"text\":\": \"},","{\"text\":\"点击查看["+title+"-"+desc+"]的歌词\"}").replace("[聊天记录]","["+title+"-"+desc+"]");
try{
jsondata=jsondata.substring(jsondata.lastIndexOf("{\"app\":\"com.tencent.multimsg\",")+0,jsondata.lastIndexOf("\"ver\":\"0.0.0.5\",\"view\":\"contact\"}")+33);
sendMcard(data,jsondata);
}catch(e){
sendCont(data,"合并转发错误\n"+e);
}
}
}else{
sendCont(data,at+"\n获取歌词失败");
}
}
}catch(e){sendCont(data,at+"\n错误\n"+e);}
}
}
}
}
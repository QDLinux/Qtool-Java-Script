


//尹志平
//群699177519




String colord1="#EAECF7";
//背景色

String colord2="";
//字色

int size1=100;

import com.tencent.mobileqq.text.TextUtils;
import java.lang.*;
import java.util.*;
import android.graphics.*;
import java.io.*;
import java.security.*;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
AddItem("开启/关闭文字转图片","开关",PluginID);
public void 开关(String qun,String qq,int type){
if(type==1){
if("1".equals(getString(qun,"yzp"))){
putString(qun, "yzp", null);
Toast("已关闭");
}
else{
if(qun.equals("699177519")){
Toast("本群不可开启"); return;
}else{
putString(qun,"yzp","1");
Toast("已开启");}
}
}else{
if("1".equals(getString(qq,"yzp"))){
putString(qq, "yzp", null);
Toast("已关闭");
}
else{
putString(qq,"yzp","1");
Toast("已开启");}
}
}


public boolean hasn(String tt){
for(char a:tt){
if(a=='\n')return true;
}
return false;
}
boolean xzz=false;
public void texttopng(String text,String color1,String color2,int size,String filepath){
double n1=0;
for(int i=0;i<text.length();i++){
if(text.charAt(i)>'a'&&text.charAt(i)<'z'){
n1=n1+0.5;
}else if(Character.isDigit(text.charAt(i))){
n1=n1+0.5;
}
else if(text.charAt(i)=='\ud83c'||text.charAt(i)=='\ud83d'||text.charAt(i)=='\ud83e'){
n1=n1+0.2;
}
else{
n1=n1+1;
}
}
int n=(int)(n1+0.5);
int fn=n;
if(fn<=8){
float ww=n*1.05;
float h=1.2;
if(n==4)h=(float)1.4;
if(n==5)h=(float)1.65;
if(n==6)h=(float)1.95;
if(n==7)h=(float)2.3;
if(n==8)h=(float)2.65;
Bitmap bitmap = Bitmap.createBitmap((int)(size*ww),(int)(size*h), Bitmap.Config.ARGB_8888);
Canvas canvas=new Canvas(bitmap);
canvas.drawColor(Color.parseColor(color1));
Paint paint = new Paint();
paint.setColor(Color.parseColor(color2));
paint.setTextSize(size);
canvas.drawText(text,0,(float)((float)(size*0.5)+bitmap.getHeight()*0.45),paint);
bmptofile(bitmap,filepath);
}
else{
//int n=text.replace("\n","").length();
int w=8;
if(n>25) w=12;
if(n>150) w=15;
if(n>250) w=20;
if(n>350) w=25;
if(n>500) w=30;
if(n>700) w=40;
if(n>900) w=50;
if(n>1200) w=60;
float h=1;
int yy=0;
int pp=0;
while(yy<text.length()){
if(text.charAt(yy)=='\n'){
h=h+(float)1;
pp=0;
}
if(pp==w){
h=h+(float)1;
pp=0;
}else{
pp=pp+1;
}
yy++;
}
Bitmap bitmap = Bitmap.createBitmap((int)(size*w),(int)((h+0.8)*size), Bitmap.Config.ARGB_8888);
Canvas canvas=new Canvas(bitmap);
canvas.drawColor(Color.parseColor(color1));
Paint paint = new Paint();
paint.setColor(Color.parseColor(color2));
paint.setTextSize(size);
String text1=text;
int k1=0;
int line=0;
while(text1.length()>w||hasn(text1)){
String t1=text1.substring(0);
int k2=w;
double e=0;
int kk=0;
while(e<k2){
try{
if(t1.charAt(kk)=='\n'){
k2=(int)e;
break;
}
if(t1.charAt(kk)>'a'&&t1.charAt(kk)<'z'){
e=e+0.5;
}else if(Character.isDigit(t1.charAt(kk))){
e=e+0.5;
}
else if(t1.charAt(kk)=='\ud83c'||t1.charAt(kk)=='\ud83d'||t1.charAt(kk)=='\ud83e'){
}
else{
e=e+1;
}
kk++;
}catch(e){break;}
}
String t2;
t2=t1.substring(0,kk);
canvas.drawText(t2,0,size+size*line,paint);
line++;
if(k2!=w){
text1=text1.substring(kk+1);
}
else{text1=text1.substring(kk);
}
}
canvas.drawText(text1,0,size+size*line,paint);
bmptofile(bitmap,filepath);
}
}
public String sco(){
Random rand = new Random();  
String c1 = Integer.toHexString(rand.nextInt(256));
String c2= Integer.toHexString(rand.nextInt(256));
String c3= Integer.toHexString(rand.nextInt(256));
c1=c1.length()==1?"0"+c1:c1;  
c2=c2.length()==1?"0"+c2:c2;
c3=c3.length()==1?"0"+c3:c3;
String color="#"+c1+c2+c3;
return color.toUpperCase();
}
public void bmptofile(Bitmap bmp,String path){
File f= new File(path);
if(f.exists()){f.delete();}
if(!f.exists()){f.getParentFile().mkdirs();}
FileOutputStream   fs = new FileOutputStream(path);
bmp.compress(Bitmap.CompressFormat.PNG,100,fs);
fs.flush();
}

public void onMsg(Object msg){
if(msg.IsSend&&msg.MessageContent.equals("")){
//卑微萌新
msg.AppInterface.getMessageFacade().a(msg.msg,true); 
}
}
public String getMsg(String msg,String qun,int i){
String text=msg;
//TextUtils.getTextWithoutEmoji(msg)
if(TextUtils.isAllSystemEmotcation(msg))return msg;
if(!qun.equals("699177519"))xzz=true;
if(xzz&&"1".equals(getString(qun,"yzp"))){
text=TextUtils.emoticonToTextWithoutSysEmotion(msg);
String yy=AppPath+"/"+sco()+".png";
String col=sco();
if(!colord2.equals("")){
col=colord2;
}
texttopng(text,colord1,sco(),size1,yy);

if(i==1){
sendPic(qun,"",yy);
}else{
sendPic("",qun,yy);
}
text="";
new Thread(new Runnable(){
public void run(){
Thread.sleep(5000);
File f=new File(yy);
f.delete();
}}).start();
}
return text;
}
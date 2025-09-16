

//由尹志平编写供java作者使用，使用请保留版权 交流群699177519

/*
1.图片链接存为图片文件
urltofile(String url,String path);
url:链接
path: 存储路径
示例：
urltofile("http://q1.qlogo.cn/g?b=qq&nk=10001&s=640",AppPath+"/图片文件夹/头像1.png");
附：
QQ头像链接：
http://q.qlogo.cn/headimg_dl?dst_uin=QQ号&spec=640 
群头像链接：
http://p.qlogo.cn/gh/群号/群号/100/

2.图片放缩
fsdx(String path1,String path,float sw,float sh);
path1:原图路径
path:修改后路径  为空时不保留原图
sw,sh：宽和高相对原图比例
示例：
fsdx(AppPath+"/图片文件夹/头像1.png","",2,2);//即为放大两倍

3.贴图
pinpic(String path1,String path2,float sw,float sh,float x,float y,float yd,String path);
path1:原图路径
path2:贴图路径
sw,sh：贴图宽和高相对原图比例  0~1   当其一为999时保持贴图宽高比例放缩
x,y: 贴图中心相对于原图位置坐标   0~1 
yd:贴图圆润程度 0~360
path: 修改后路径  为空时不保留原图
示例：
toutofile(MyUin,AppPath+"/图片文件夹/头像2.png");
pinpic(AppPath+"/图片文件夹/头像1.png",AppPath+"/图片文件夹/头像2.png",0.3,0.3,0.5,0.5,360,AppPath+"/图片文件夹/合成头像.png");

另：pinqpic(String path1,String qq,float sw,float sh,float x,float y,float yd,String path);
//贴图直接为QQ头像
4.图片加字
writetopic(String path1,String text,String color,float x,float y,float size,String path)
path1,path同上
text: 文本
color: 颜色的十六进制代码 为空默认黑色
x,y: 文本中心相对坐标 0~1
size: 字体大小  像素
示例：
writetopic(AppPath+"/图片文件夹/头像1.png","这是我马哥","",0.5,0.5,50,"");
*/





import java.lang.*;
import android.content.*;
import android.widget.*;
import android.media.*;
import java.text.*;
import android.net.*;
import android.content.*;
import android.graphics.*;
import java.io.*;
import java.util.*;
public void urltofile(String url,String path){
Bitmap  bmp= getbitmap(url);
bmptofile(bmp,path);
}
public void fsdx(String path1,String path,Object a,Object b){
Bitmap  bm1= getbitmap(path1);
Matrix ma = new Matrix(); 
float w=a;
float h=b;
ma.postScale(w,h);
Bitmap bmp= Bitmap.createBitmap(bm1,0,0,bm1.getWidth(),bm1.getHeight(),ma,true);
if("".equals(path)||path==null){
bmptofile(bmp,path1);}
else{
bmptofile(bmp,path);}
}
public void pinpic(String path1,String path2,Object sw,Object sh,Object x,Object y,Object yd,String path){
Bitmap bm1=getbitmap(path1);
Bitmap bm2 =getbitmap(path2);
Matrix ma = new Matrix(); 
float a=(float)sw*((float)bm1.getWidth()/(float)bm2.getWidth());
float b=(float)sh*((float)bm1.getHeight()/(float)bm2.getHeight());
if(sw>998||sh>998){
float i=Math.min(a,b);
ma.postScale(i,i); 
}else{
ma.postScale(a,b); 
}
Bitmap zmp = Bitmap.createBitmap(bm2,0,0,bm2.getWidth(),bm2.getHeight(),ma,true);
float x1=x*bm1.getWidth()-0.5*zmp.getWidth();
float y1=y*bm1.getHeight()-0.5*zmp.getHeight();
float ds=yd;
Bitmap smp=getroundbmp(zmp,ds);
Canvas cas = new Canvas(bm1);
cas.drawBitmap(smp,x1,y1,null);
if("".equals(path)||path==null){
bmptofile(bm1,path1);}
else{
bmptofile(bm1,path);}
}
public void writetopic(String path1,String text,String color,Object x,Object y,Object size,String path){
Bitmap bmp=getbitmap(path1);
Canvas cas = new Canvas(bmp);
Paint pt = new Paint();
//pt.setFakeBoldText(true);
pt.setTextSize(size);
//pt.setTypeface(Typeface.SANS_SERIF);
pt.setTypeface(Typeface.MONOSPACE);
if(!"".equals(color)&&!color==null)
pt.setColor(Color.parseColor(color));
float x1=x*bmp.getWidth()-0.5*text.length()*size;
float y1=y*bmp.getHeight()+0.5*size;
cas.drawText(text,x1,y1,pt);
if("".equals(path)||path==null){
bmptofile(bmp,path1);}
else{
bmptofile(bmp,path);}
}
public void bmptofile(Bitmap bmp,String path){
File f= new File(path);
if(f.exists()){f.delete();}
if(!f.exists()){f.getParentFile().mkdirs();}
FileOutputStream   fs = new FileOutputStream(path);
bmp.compress(Bitmap.CompressFormat.PNG,100,fs);
fs.flush();
}
public void pinqpic(String path1,String qq,Object sw,Object sh,Object x,Object y,Object yd,String path){Bitmap bm1=getbitmap(path1);Bitmap bm2 =getbitmap("http://q1.qlogo.cn/g?b=qq&nk="+qq+"&s=640");Matrix ma = new Matrix(); float a=(float)sw*((float)bm1.getWidth()/(float)bm2.getWidth());float b=(float)sh*((float)bm1.getHeight()/(float)bm2.getHeight());if(sw>998||sh>998){float i=Math.min(a,b);ma.postScale(i,i); }else{ma.postScale(a,b); }Bitmap zmp = Bitmap.createBitmap(bm2,0,0,bm2.getWidth(),bm2.getHeight(),ma,true);float x1=x*bm1.getWidth()-0.5*zmp.getWidth();float y1=y*bm1.getHeight()-0.5*zmp.getHeight();float ds=yd;Bitmap smp=getroundbmp(zmp,ds);Canvas cas = new Canvas(bm1);cas.drawBitmap(smp,x1,y1,null);if("".equals(path)||path==null){bmptofile(bm1,path1);}else{bmptofile(bm1,path);}}
public static Bitmap getroundbmp(Bitmap bitmap,float roundPx){
Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
Canvas canvas = new Canvas(bmp);
Paint paint = new Paint();     
Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
RectF rectF = new RectF(rect);
paint.setAntiAlias(true);
canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
canvas.drawBitmap(bitmap, rect, rect,paint);
return bmp;
}
public Bitmap getbitmap(String path){
if(path.startsWith("http")){
try{
URL url1 = new URL(path);
HttpURLConnection urlc = url1.openConnection();
InputStream   inst = urlc.getInputStream();
Bitmap bmp = BitmapFactory.decodeStream(inst).copy(Bitmap.Config.ARGB_8888, true);
return bmp;
}catch(e){Toast(e); return Bitmap.createBitmap(800,800,Bitmap.Config.ARGB_8888);}
}else{
try{
Bitmap  bmp= BitmapFactory.decodeStream(new FileInputStream(path)).copy(Bitmap.Config.ARGB_8888, true);
return bmp;
}catch(e){Toast(e);return Bitmap.createBitmap(800,800,Bitmap.Config.ARGB_8888);}
}
}
	public static void delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		if (!file.isDirectory()) {
			return;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
				flag = true;
			}
		}
		return;
	}
delAllFile(AppPath+"/冷雨目录/图片功能/缓存/");
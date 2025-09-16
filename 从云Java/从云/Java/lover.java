int index=1;
import android.widget.CompoundButton;
import android.view.animation.AlphaAnimation;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Html;
import com.google.android.material.switchmaterial.SwitchMaterial;
import android.widget.CompoundButton;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.view.ViewGroup.LayoutParams;
import android.widget.Switch;
import java.util.Properties;
public String readprop(String file,String name2)
{
String PropFile = file;
Properties props = new Properties();
props.load(new StringReader(read(PropFile)));
String name = props.getProperty(name2);
return name;
}
public void clear1()
{
wuxin1.clear();
wuxin2.clear();
wuxin4.clear();
wuxin5.clear();
wuxin6.clear();
wuxin8.clear();
wuxin7.clear();
}
Create(AppPath+"/从云/图片缓存");
Create(AppPath+"/从云/Java/下载的脚本");
if(判(AppPath+"/从云/图片缓存/s.png").equals("false"))
{
Toast("首次使用可能过慢，稍等一下");
xz("https://wxy.fufuya.top/user/index/s.png",AppPath+"/从云/图片缓存/s.png");
}
boolean BO=false;
public void loveru(){
ThisActivity= GetActivity();
ThisActivity.runOnUiThread(new Runnable()
{
public void run()
{
String[] items={"下载Java脚本","管理Java脚本","一键修复\n(别乱点,如果下载了脚本后功能无法使用的话点这里恢复默认)","不会用？点我看看"};
		LinearLayout cy=new LinearLayout(ThisActivity);
        cy.setOrientation(LinearLayout.VERTICAL);
		AlertDialog.Builder bf=new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
		bf.setTitle("Java插件下载");
		bf.setItems(items, new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int which) {
if(which==0)
{
OK2=false;
ts3();
new Thread(new Runnable(){
public void run(){
clear1();
jsonv();
sendv2();
OK2=true;
}}).start();
}else if(which==1)
{
javana.clear();
sendv();
}else if(which==2)
{
new Thread(new Runnable(){
public void run(){
if(index==1){
loveru();
ts("提示","请再点一遍(防止误触)");
index=2;
}else{
Toast("开始恢复");
xz("https://wxy.fufuya.top/user/index/huifu",AppPath+"/从云/Java/main.java");
ts("提示","恢复完成！重新加载即可,如果重新加载后还是这个情况那自己加官方群");
}
}}).start();
}else if(which==3)
{
Intent intent = new Intent(Intent.ACTION_VIEW);
intent.setData(Uri.parse("https://wxy.fufuya.top/user/index/sp.mp4"));
ThisActivity.startActivity(intent);
}
}
});
bf.show();
		}
	});
//Toast("d");
}
List wuxin1 = new ArrayList();
List wuxin2 = new ArrayList();
List wuxin4 = new ArrayList();
List wuxin5 = new ArrayList();
List wuxin6 = new ArrayList();
List wuxin7 = new ArrayList();
List wuxin8 = new ArrayList();
List javana = new ArrayList();
String wuxin0="";
public void jsonv(){
String wuxin0=get("http://wxy.fufuya.top/user/index/index2.php?love=1");
try{
JSONObject menu1=new JSONObject(wuxin0);
JSONArray menu2=menu1.getJSONArray("lovewx");
for(int i=0;i<menu2.length();i++){
JSONObject info=menu2.getJSONObject(i);
String name=info.getString("name");
String author=info.getString("author");
String xia=info.getString("xia");
String banben=info.getString("version");
String ms=info.getString("describe");
wuxin1.add(name);
wuxin2.add(author);
wuxin4.add(xia);
wuxin5.add(banben);
wuxin6.add(ms);
}
}catch(e){
Toast("获取脚本错误\n"+e);
}
}
public void sendv()
{
Thisactixity= GetActivity();
Thisactixity.runOnUiThread(new Runnable()
{
public void run(){
Dialog dialog = new Dialog(Thisactixity);
mScrollView = new ScrollView(Thisactixity);
LinearLayout linearLayout = new LinearLayout(Thisactixity);
linearLayout.setOrientation(1);
LinearLayout layout3 = new LinearLayout(Thisactixity);
layout3.setOrientation(0);
FileInputStream filebitmap = new FileInputStream(AppPath+"/从云/图片缓存/s.png");
Bitmap bitmap = BitmapFactory.decodeStream(filebitmap);	
bitmap = getpicshape(bitmap,bitmap.getWidth(),bitmap.getHeight(),50);
Drawable background =new BitmapDrawable(bitmap);
LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
TextView top1 = new TextView(Thisactixity);
top1.setText("刷新");
top1.setTextSize(25);
top1.setTextColor(Color.parseColor("#000000"));
top1.setBackground(getShape("#84BEF7","#00000000",20,15,20,20,20,20));
TextView top3 = new TextView(Thisactixity);
top3.setText("在线脚本");
top3.setTextSize(25);
top3.setTextColor(Color.parseColor("#000000"));
top3.setBackground(getShape("#9E7BFF","#00000000",20,15,20,20,20,20));
TextView top2 = new TextView(Thisactixity);
top2.setText("取消");
top2.setTextSize(25);
top2.setTextColor(Color.parseColor("#000000"));
top2.setBackground(getShape("#87AFC7","#00000000",20,15,20,20,20,20));
layout3.addView(top1);
layout3.addView(top3);
layout3.addView(top2);
linearLayout.addView(layout3);
layout3.setGravity(Gravity.CENTER_HORIZONTAL);
File file10 = new File(AppPath+"/从云/Java/下载的脚本/main.txt");
for(String str:读取(file10))
{
javana.add(str);
}
if(javana.toArray().length<=0) {
javana.add("还没有脚本，去下载一个吧！");
}
new Thread(new Runnable() {
public void run() {
for (int i = 0; i <javana.size(); i++) {
String name2=javana.get(i);
LinearLayout linearLayout2=new LinearLayout(ThisActivity);
linearLayout2.setOrientation(0);
TextView mySwitch = new TextView(Thisactixity);//原本想用Switch的，但是qtool的获取Activity貌似有问题，所以只能这样了
mySwitch.setText(name2);
mySwitch.setTextColor(Color.parseColor("#461B7E"));
mySwitch.setTextSize(20);
mySwitch.setPadding(20,20,20,20);
mySwitch.setBackground(getShape("#84BEF7","#00000000",0,15,10,10,20,10));

String path=AppPath+"/从云/Java/下载的脚本/";
String v=readprop(path+name2+".prop","version");
String zz=readprop(path+name2+".prop","author");
String ms=readprop(path+name2+".prop","describe");
String wxylover="当前脚本:"+name2+"\n版本:"+v+"\n作者:"+zz+"\n描述:"+ms;
wxylover =wxylover.replace("\\n","\n");
TextView text2 = new TextView(Thisactixity);
text2.setText(wxylover);
text2.setTextColor(Color.parseColor("#1585DA"));
text2.setTextSize(17);
Button b3= new Button(Thisactixity);
if("1".equals(取("从云",name2)))
{
b3.setText(" 取消加载 ");
}else{
b3.setText(" 加载 ");
}
b3.setTextSize(25);
b3.setTextColor(Color.parseColor("#461B7E"));
b3.setBackground(getShape("#FFA62F","#00000000",20,10,10,10,20,10));
Button b4= new Button(Thisactixity);
b4.setText(" 删除 ");
b4.setTextSize(25);
b4.setTextColor(Color.parseColor("#461B7E"));
b4.setBackground(getShape("#D1D0CE","#00000000",20,10,10,10,20,10));
text2.setVisibility(View.GONE);
b3.setVisibility(View.GONE);
b4.setVisibility(View.GONE);
b3.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
if("1".equals(取("从云",name2)))
{
b3.setText(" 加载 ");
}else{
b3.setText("取消加载");
}
new Thread(new Runnable(){
public void run(){
try{
if("1".equals(取("从云",name2)))
{
int h=lovewuxin1314.indexOf(name2);
jbfj.remove(h);
lovewuxin1314.remove(h);
存("从云",name2,null);
Toast("已取消加载");
}else{
load(AppPath+"/从云/Java/下载的脚本/"+name2);
存("从云",name2,"1");
ts("提示","已加载\n重新加载从云Java脚本发\"菜单\"即可生效\n一定要重新加载！！！\n一定要重新加载！！！\n一定要重新加载！！！\n一定要重新加载！！！");
}
}catch(e){
ts("提示",name2+"\n加载/取消加载错误\n"+e);
}
}}).start();
}});


b4.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
new Thread(new Runnable(){
public void run(){
try{
int h=lovewuxin1314.indexOf(name2);
jbfj.remove(h);
lovewuxin1314.remove(h);
scw(AppPath+"/从云/Java/下载的脚本/main.txt",name2);
存("从云",name2,null);
delete(AppPath+"/从云/Java/下载的脚本/"+name2);
Toast("删除成功");
javana.clear();
}catch(e){
try{
scw(AppPath+"/从云/Java/下载的脚本/main.txt",name2);
存("从云",name2,null);
delete(AppPath+"/从云/Java/下载的脚本/"+name2);
Toast("删除成功");
javana.clear();
}catch(e){
ts("提示","删除脚本\""+name2+"\"失败\n"+e);
}
}
}}).start();
mySwitch.setVisibility(View.GONE);
b3.setVisibility(View.GONE);
b4.setVisibility(View.GONE);
text2.setVisibility(View.GONE);
}});
mySwitch.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        if (text2.getVisibility() == View.GONE) {
            AlphaAnimation animation = new AlphaAnimation(0, 1);
            animation.setDuration(500);
            text2.setVisibility(View.VISIBLE);
            text2.startAnimation(animation);
            b3.setVisibility(View.VISIBLE);
            b3.startAnimation(animation);
            
            b4.setVisibility(View.VISIBLE);
            b4.startAnimation(animation);
        } else {
            text2.setVisibility(View.GONE);
            b3.setVisibility(View.GONE);
            b4.setVisibility(View.GONE);
        }
    }
});
params.setMargins(20, 20, 20, 20);
linearLayout.post(new Runnable() {
public void run() {
linearLayout.addView(mySwitch,params);
linearLayout.addView(text2,params);
linearLayout2.addView(b3);
linearLayout2.addView(b4);
linearLayout2.setGravity(Gravity.RIGHT);
linearLayout.addView(linearLayout2);
}
});
}
break;
}
}).start();
top2.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
dialog.dismiss();
}
});
top1.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
javana.clear();
sendv();
dialog.dismiss();
}
});
top3.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
OK2=false;
ts3();
new Thread(new Runnable(){
public void run(){
clear1();
jsonv();
sendv2();
OK2=true;
Thread.sleep(1500);
dialog.dismiss();
}}).start();
}
});
linearLayout.setPadding(20,20,20,20);
mScrollView.addView(linearLayout);
dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
WindowManager wm = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);  
int height = wm.getDefaultDisplay().getHeight();  
int width = wm.getDefaultDisplay().getWidth();
mScrollView.setBackground(background);
dialog.setContentView(mScrollView);
mScrollView.getLayoutParams().height =height/2+height/6;
mScrollView.getLayoutParams().width =width/2+width/4;
dialog.show();
}
});
}
public void sendv2()
{
Thisactixity= GetActivity();
Thisactixity.runOnUiThread(new Runnable()
{
public void run(){
Dialog dialog = new Dialog(Thisactixity);
mScrollView = new ScrollView(Thisactixity);
LinearLayout layout = new LinearLayout(Thisactixity);
layout.setOrientation(1);
LinearLayout layout3 = new LinearLayout(Thisactixity);
layout3.setOrientation(0);
LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
FileInputStream filebitmap = new FileInputStream(AppPath+"/从云/图片缓存/s.png");
Bitmap bitmap = BitmapFactory.decodeStream(filebitmap);	
bitmap = getpicshape(bitmap,bitmap.getWidth(),bitmap.getHeight(),50);
Drawable background =new BitmapDrawable(bitmap);
mScrollView.setBackground(background);
TextView top1 = new TextView(Thisactixity);
top1.setText("刷新");
top1.setTextSize(25);
top1.setTextColor(Color.parseColor("#000000"));
top1.setBackground(getShape("#84BEF7","#00000000",20,15,20,20,20,20));
TextView top3 = new TextView(Thisactixity);
top3.setText("本地脚本");
top3.setTextSize(25);
top3.setTextColor(Color.parseColor("#000000"));
top3.setBackground(getShape("#9E7BFF","#00000000",20,15,20,20,20,20));
TextView top2 = new TextView(Thisactixity);
top2.setText("取消");
top2.setTextSize(25);
top2.setTextColor(Color.parseColor("#000000"));
top2.setBackground(getShape("#87AFC7","#00000000",20,15,20,20,20,20));
layout3.addView(top1);
layout3.addView(top3);
layout3.addView(top2);
layout.addView(layout3);
layout3.setGravity(Gravity.CENTER_HORIZONTAL);
new Thread(new Runnable(){
public void run(){
for(int i = 0;i<wuxin5.size();i++){
String name1=wuxin1.get(i);
LinearLayout layout2=new LinearLayout(ThisActivity);
layout2.setOrientation(0);
TextView text1 = new TextView(Thisactixity);
text1.setText(name1+"("+wuxin5.get(i)+")");
text1.setTextSize(20);
text1.setTextColor(Color.parseColor("#5B00AE"));
text1.setPadding(20,20,20,20);
text1.setBackground(getShape("#84BEF7","#00000000",0,15,10,10,20,10));
TextView text2 = new TextView(Thisactixity);
text2.setText("版本:"+wuxin5.get(i)+"\n作者:"+wuxin2.get(i)+"\n下载次数:"+wuxin4.get(i)+"\n描述:\n"+wuxin6.get(i)+"");
text2.setTextColor(Color.parseColor("#1585DA"));
text2.setTextSize(17);
TextView b3= new TextView(Thisactixity);
b3.setText("下载该脚本");
b3.setTextSize(20);
b3.setTextColor(Color.parseColor("#353E41"));
params.setMargins(20, 20, 20, 20);
text2.setVisibility(View.GONE);
b3.setVisibility(View.GONE);
b3.setBackground(getShape("#D1D0CE","#00000000",20,10,10,10,20,10));
b3.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
b3.setText("开始下载");
new Thread(new Runnable(){
public void run(){
try{
int java=wuxin1.indexOf(name1);
int jvav=java+1;
String htt=get("http://wxy.fufuya.top/user/index/index2.php?name="+name1+"&id="+jvav);
xz("https://wxy.fufuya.top/user/index/main.txt",AppPath+"/从云/Java/main.java");
xz(htt,AppPath+"/从云/Java/下载的脚本/"+name1);
String he=wuxin6.get(java);
he =he.replaceAll("\n","\\\\n");
put(AppPath+"/从云/Java/下载的脚本/"+name1+".prop","version:"+wuxin5.get(java)+"\nauthor:"+wuxin2.get(java)+"\ndescribe:\\n"+he);
putw(AppPath+"/从云/Java/下载的脚本/main.txt",name1);
javana.clear();
dialog.dismiss();
Toast("下载完成！");
sendv();
}catch(e){
Toast("下载错误"+e);
}
}}).start();
}
});
top2.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
dialog.dismiss();
}
});
top3.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
javana.clear();
sendv();
dialog.dismiss();
}
});
top1.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
OK2=false;
ts3();
new Thread(new Runnable(){
public void run(){
clear1();
jsonv();
sendv2();
OK2=true;
Thread.sleep(1500);
dialog.dismiss();
}}).start();
}
});
text1.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        if (text2.getVisibility() == View.GONE) {
            AlphaAnimation animation = new AlphaAnimation(0, 1);
            animation.setDuration(500);
            text2.setVisibility(View.VISIBLE);
            text2.startAnimation(animation);
            b3.setVisibility(View.VISIBLE);
            b3.startAnimation(animation);
        } else {
            text2.setVisibility(View.GONE);
            b3.setVisibility(View.GONE);
        }
    }
});
layout2.setGravity(Gravity.RIGHT);
layout.post(new Runnable() {
public void run() {
layout.addView(text1, params);
layout.addView(text2, params);
layout2.addView(b3);
layout.addView(layout2);
}
});
}
break;
}}).start();
mScrollView.setPadding(20,20,20,20);
WindowManager wm = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);  
int height = wm.getDefaultDisplay().getHeight();  
int width = wm.getDefaultDisplay().getWidth();  
dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
mScrollView.addView(layout);
dialog.setContentView(mScrollView);
mScrollView.getLayoutParams().height =height/2+height /6;
mScrollView.getLayoutParams().width =width/2+width /4;
dialog.show();
}
});
}
loveru();
lovelove="1";
OK2=true;
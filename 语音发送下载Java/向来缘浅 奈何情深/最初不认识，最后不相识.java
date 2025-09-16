import android.view.ViewGroup;
List love = new ArrayList();
List love3 = new ArrayList();
List love10 = new ArrayList();
List love11 = new ArrayList();
String love2=get("https://wxy.fufuya.top/voice/love.php");
String json2="";
String json3="";
int OK2=0;
boolean OK3=false;
int KR=0;
public void json()
{
try{
json2="";
json3="";
love.clear();
JSONObject menu1=new JSONObject(love2);
JSONArray menu2=menu1.getJSONArray("lovewx");
for(int i=0;i<menu2.length();i++){
JSONObject info=menu2.getJSONObject(i);
love.add(info.getString("text"));
int i2=i+1;
json2+="\""+i2+"."+info.getString("text")+"\":\""+info.getString("id")+"\",";
json3+="\""+info.getString("id")+"\":\""+info.getString("text")+"\",";
}
}catch(e){
Toast("错误\n"+e);
}
json2="{"+json2+"}";
json2 =json2.replace(",}","}");
json3="{"+json3+"}";
json3 =json3.replace(",}","}");
}
public static GradientDrawable getShape(String color1,String color2,int size1,int size2)
{
GradientDrawable shape=new GradientDrawable();
    shape.setColor(Color.parseColor(color1));
    shape.setStroke(size1,Color.parseColor(color2));
    shape.setCornerRadius(size2);
    shape.setAlpha(180);
    shape.setShape(GradientDrawable.RECTANGLE);
    return shape;
}
public void tip2(String qun,String qq,int type)
	{
	Thisactixity= GetActivity();
Thisactixity.runOnUiThread(new Runnable()
	{
		public void run(){
		LinearLayout l1 = new LinearLayout(Thisactixity);
		l1.setOrientation(1);
		LinearLayout l2 = new LinearLayout(Thisactixity);
		l2.setOrientation(1);
String[] items = (String[])love.toArray(new String[love.size()]);
		mScrollView = new ScrollView(Thisactixity);
		TextView top= new TextView(Thisactixity);
		top.setText("语音下载");
		top.setTextSize(25);
	    top.setGravity(Gravity.CENTER_HORIZONTAL);
	    top.setTextColor(Color.parseColor("#FF2D2D"));
	    TextView top2= new TextView(Thisactixity);
		top2.setText("正在加载语音...");
		top2.setTextSize(20);
	    top2.setGravity(Gravity.CENTER_HORIZONTAL);
	    top2.setTextColor(Color.parseColor("#CCFF80"));
		EditText srk = new EditText(Thisactixity);
		srk.setHint("Search...");
		srk.setBackground(getShape("#E38AAE","#E38AAE",0,15));
		srk.setTextSize(25);
		srk.setPadding(10,10,10,10);
		TextView b1= new TextView(Thisactixity);
		b1.setText("刷新");
		b1.setTextSize(25);
		b1.setGravity(Gravity.CENTER_HORIZONTAL);
		b1.setTextColor(Color.parseColor("#000000"));
       b1.setBackground(getShape("#00FF00","#00000000",10,15));
       TextView b2= new TextView(Thisactixity);
		b2.setText("取消");
		b2.setTextColor(Color.parseColor("#000000"));
		b2.setGravity(Gravity.CENTER_HORIZONTAL);
		b2.setTextSize(25);
b2.setBackground(getShape("#A52A2A","#00000000",10,15));
TextView b3= new TextView(Thisactixity);
		b3.setText("上传语音");
		b3.setTextSize(25);
		b3.setGravity(Gravity.CENTER_HORIZONTAL);
		b3.setTextColor(Color.parseColor("#000000"));
b3.setBackground(getShape("#FFA500","#00000000",10,15));
TextView b4= new TextView(Thisactixity);
		b4.setText("搜索");
		b4.setTextColor(Color.parseColor("#000000"));
		b4.setGravity(Gravity.CENTER_HORIZONTAL);
		b4.setTextSize(25);
b4.setBackground(getShape("#0000FF","#00000000",10,15));
        l1.addView(top);
        l1.addView(top2);
        l1.addView(srk);
        l1.addView(b4);
        l1.addView(b1);
		l1.addView(b2);
		l1.addView(b3);
l1.setBackground(getShape("#757271","#E238EC",5,25));
l1.setPadding(0,0,0,20);
Dialog dialog = new Dialog(Thisactixity);
 dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
 dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
dialog.getWindow().setGravity(Gravity.LEFT);
dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
mScrollView.addView(l2);
l1.addView(mScrollView);
dialog.setContentView(l1);
love11.clear();
new Thread(new Runnable() {
public void run() {
for (int i = 0; i <love.size(); i++) {
int llover=love.size()/4;
if(i<=llover)
{
top2.setText("正在加载第"+i+"个");
top2.setTextColor(Color.parseColor("#64A600"));
}else if(i>llover&&i<=llover*2)
{
top2.setText("正在加载第"+i+"个");
top2.setTextColor(Color.parseColor("#FFFF6F"));
}else if(i>llover*2&&i<=llover*3){
top2.setText("正在加载第"+i+"个");
top2.setTextColor(Color.parseColor("#2B65EC"));
}else{
top2.setText("正在加载第"+i+"个");
top2.setTextColor(Color.parseColor("#FF2D2D"));
}
TextView button= new TextView(Thisactixity);
int i2=i+1;
button.setText(i2+"."+items[i]);
love11.add(i2+"."+items[i]);
button.setTextSize(25);
button.setTextColor(Color.parseColor("#A23BEC"));
button.setBackground(getShape("#33CCFF","#00000000",15,15));
button.setPadding(10,10,10,10);
//button.setGravity(Gravity.CENTER_HORIZONTAL);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
        new Thread(new Runnable(){
        public void run(){
        try{
            JSONObject b=new JSONObject(json2);
            String text2=b.getString(v.getText());
            JSONObject b=new JSONObject(json3);
            String text3=b.getString(text2);
            int OK4=OK2-1;
            if(OK2==0)
            {}else{
            love3.set(OK4,"1");
            }
            String size="";
            love3.add("0");
            long urlsize=getFileSize("https://wxy.fufuya.top/voice/sp/"+text2);
            if(urlsize==999999999)
            {
            size="大于1MB";
            }else{
             size=formatSize(urlsize);
            }
            tip3(qun,qq,type,"提示","当前文件名字:\n"+text3+"("+size+")",text2,text3,OK2);
            int OK3=OK2+1;
            OK2=OK3;
            }catch(e){
            Toast(e);
            }
            break;
        }}).start();
        }
    });
            l2.post(new Runnable() {
                public void run() {
                    l2.addView(button);
                }
            });
        }
top2.setText("总共"+love.size()+"个语音");
break;
    }
}).start();
b1.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
new Thread(new Runnable(){
public void run(){
love2=get("https://wxy.fufuya.top/voice/love.php");
json();
tip2(qun,qq,type);
dialog.dismiss();
Toast("刷新成功");
break;
}}).start();
}
});
b2.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
dialog.dismiss();
}
});
b3.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
new Thread(new Runnable(){
public void run(){
r(VOICEFILE);
上传2(qun,qq,type);
break;
}}).start();
}
});
b4.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
new Thread(new Runnable(){
public void run(){
love10.clear();
KR=0;
for(int i = 0;i<love.size();i++)
{
if(love.get(i).contains(srk.getText().toString()))
{
love10.add(love11.get(i));
}
}
tip6(qun,qq,type);
dialog.dismiss();
break;
}}).start();
}
});
dialog.show();
}
});
}
public void tip6(String qun,String qq,int type)
{
Thisactixity= GetActivity();
Thisactixity.runOnUiThread(new Runnable()
	{
		public void run(){
		String[] items = (String[])love10.toArray(new String[love10.size()]);
		Dialog dialog = new Dialog(Thisactixity);
		mScrollView = new ScrollView(Thisactixity);
		LinearLayout l2 = new LinearLayout(Thisactixity);
		l2.setOrientation(1);
		LinearLayout l1 = new LinearLayout(Thisactixity);
		l1.setOrientation(1);
  TextView t2 = new TextView(Thisactixity);
		t2.setText("提示");
	    t2.setGravity(Gravity.CENTER_HORIZONTAL);
	    t2.setTextColor(Color.parseColor("#800080"));
  t2.setTextSize(25);
TextView top= new TextView(Thisactixity);
top.setText("加载中...");
top.setTextSize(20);
top.setGravity(Gravity.CENTER_HORIZONTAL);
top.setTextColor(Color.parseColor("#FF2D2D"));
		Button b1= new Button(Thisactixity);
		b1.setText("返回");
		b1.setTextSize(15);
       b1.setBackground(getShape("#005AB5","#00000000",10,40));
        l2.addView(t2);
        l2.addView(top);
        l2.addView(b1);
l2.setBackground(getShape("#757271","#7F38EC",5,50));
l2.setPadding(0,0,0,20);
mScrollView.addView(l1);
l2.addView(mScrollView);
 dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL); 
 dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
dialog.getWindow().setGravity(Gravity.LEFT);
dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
dialog.setContentView(l2);
b1.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
tip2(qun,qq,type);
dialog.dismiss();
}
});
new Thread(new Runnable() {
public void run() {
int llover=love.size()/3;
for (int i = 0; i < items.length; i++) {
KR++;

int llover=items.length/4;
if(i<=llover)
{
top.setText("正在加载第"+i+"个");
top.setTextColor(Color.parseColor("#64A600"));
}else if(i>llover&&i<=llover*2)
{
top.setText("正在加载第"+i+"个");
top.setTextColor(Color.parseColor("#FFFF6F"));
}else if(i>llover*2&&i<=llover*3){
top.setText("正在加载第"+i+"个");
top.setTextColor(Color.parseColor("#2B65EC"));
}else{
top.setText("正在加载第"+i+"个");
top.setTextColor(Color.parseColor("#FF2D2D"));
}
Button button = new Button(Thisactixity);
button.setText(items[i]);
button.setTextSize(20);
button.setTextColor(Color.parseColor("#A23BEC"));
button.setBackground(getShape("#33CCFF","#00000000",15,20));
//button.setGravity(Gravity.CENTER_HORIZONTAL);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
        new Thread(new Runnable(){
        public void run(){  
        try{
            JSONObject b=new JSONObject(json2);
            String text2=b.getString(v.getText());
            JSONObject b=new JSONObject(json3);
            String text3=b.getString(text2);
            int OK4=OK2-1;
            if(OK2==0)
            {}else{
            love3.set(OK4,"1");
            }
            love3.add("0");
            String size="";
            long urlsize=getFileSize("https://wxy.fufuya.top/voice/sp/"+text2);
            if(urlsize==999999999)
            {
            size="大于1MB";
            }else{
             size=formatSize(urlsize);
            }
            tip3(qun,qq,type,"提示","当前文件名字:\n"+text3+"("+size+")",text2,text3,OK2);
            int OK3=OK2+1;
            OK2=OK3;
            }catch(e){
            Toast(e);
            }
            break;
            }}).start();
        }
    });
            l1.post(new Runnable() {
                public void run() {
                    l1.addView(button);
                }
            });
        }
        top.setText("总共搜索到"+KR+"个");
        break;
    }
}).start();
dialog.show();
}
});
}
//tip6("182992","81929",1);
public void tip3(String qun,String qq,int type,String title,String text,String id,String name,int pd)
	{
	boolean FS=true;
	boolean E=true;
	boolean bf=true;
	int T=1;
Thisactixity= GetActivity();
Thisactixity.runOnUiThread(new Runnable()
	{
		public void run(){
		Dialog dialog = new Dialog(Thisactixity);
		mScrollView = new ScrollView(Thisactixity);
		LinearLayout l2 = new LinearLayout(Thisactixity);
		l2.setOrientation(1);
  TextView t2 = new TextView(Thisactixity);
		t2.setText(title);
	    t2.setGravity(Gravity.CENTER_HORIZONTAL);
	    t2.setTextColor(Color.parseColor("#800080"));
  t2.setTextSize(25);
  TextView fs = new TextView(Thisactixity);
		fs.setText(" ");
	    fs.setGravity(Gravity.CENTER_HORIZONTAL);
	    fs.setTextColor(Color.parseColor("#800080"));
  fs.setTextSize(20);
  TextView c3 = new TextView(Thisactixity);
		c3.setText(text);
		c3.setTextColor(Color.parseColor("#DC381F"));
		c3.setTextSize(20);
		Button b1= new Button(Thisactixity);
		b1.setText("取消");
		b1.setTextSize(15);
       b1.setBackground(getShape("#005AB5","#00000000",10,40));
       Button b2= new Button(Thisactixity);
		b2.setText("下载");
		b2.setTextSize(15);
b2.setBackground(getShape("#93FFE8","#00000000",10,40));
Button b3= new Button(Thisactixity);
		b3.setText("发送");
		b3.setTextSize(15);
b3.setBackground(getShape("#89C35C","#00000000",10,40));
Button b4= new Button(Thisactixity);
		b4.setText("播放");
		b4.setTextSize(15);
b4.setBackground(getShape("#56A5EC","#00000000",10,40));
        l2.addView(t2);
		l2.addView(c3);
		l2.addView(fs);
        l2.addView(b1);
		l2.addView(b2);
		l2.addView(b3);
		l2.addView(b4);
l2.setBackground(getShape("#757271","#7F38EC",5,50));
 dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL); 
 dialog.setCancelable(false);
 dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
dialog.getWindow().setGravity(Gravity.RIGHT);
dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
mScrollView.addView(l2);
dialog.setContentView(mScrollView);
new Thread(new Runnable(){
public void run(){
while(true)
{
Thread.sleep(100);
String ke=love3.get(pd);
if(ke.equals("1"))
{
dialog.dismiss();
bf=false;
break;
}
}
}}).start();
b1.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
bf=false;
dialog.dismiss();
}
});
b2.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
dialog.dismiss();
下载( qun, qq, type, title, text,id,name,pd);
}
});
b3.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
new Thread(new Runnable(){
public void run(){
while(true)
{
if(E==false){break;}
Thread.sleep(50);
fs.setText(formatSize(size9));
}
}}).start();
new Thread(new Runnable(){
public void run(){
if(FS==true)
{
Toast("正在下载语音");
FS=false;
long time=System.currentTimeMillis();
download("https://wxy.fufuya.top/voice/sp/"+id+"",AppPath+"/语音目录/"+time+".mp3");
sendVoice(qun,qq,AppPath+"/语音目录/"+time+".mp3");
Toast("发送完成");
delete(AppPath+"/语音目录/"+time+".mp3");
E=false;
dialog.dismiss();
break;
}else{
Toast("正在下载中,请稍候...");
}
}}).start();
}
});
b4.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
if(T==1){
b4.setText("暂停");
new Thread(new Runnable(){
public void run(){
T=2;
bf=true;
MediaPlayer mp3 = new MediaPlayer();
Toast("正在播放"+name+"\n音量50%");
mp3.setDataSource("https://wxy.fufuya.top/voice/sp/"+id);
mp3.setLooping(true);
mp3.setVolume(0.5f);
mp3.prepare();
mp3.start();
while(true)
{
Thread.sleep(200);
if(bf==false)
{
mp3.stop();
break;
}
}
}}).start();
}else{
bf=false;
T=1;
b4.setText("播放");
}
}
});

WindowManager wm = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);  
int height = wm.getDefaultDisplay().getHeight();  
int width = wm.getDefaultDisplay().getWidth();  
height=height/8;
width=width/3;
l2.getLayoutParams().height =height;
l2.getLayoutParams().width =width;
dialog.show();
}
});
}
public void tip5(String qun,String qq,int type,String vofile,int pd,String name,String pd2)
	{
	Thisactixity= GetActivity();
Thisactixity.runOnUiThread(new Runnable()
	{
		public void run(){
		Dialog dialog = new Dialog(Thisactixity);
		mScrollView = new ScrollView(Thisactixity);
		LinearLayout l2 = new LinearLayout(Thisactixity);
		l2.setOrientation(1);
		EditText srk = new EditText(Thisactixity);
		srk.setHint("请输入重命名的语音名字");
		srk.setBackground(getShape("#C12283","#C12283",10,40));
  TextView t2 = new TextView(Thisactixity);
		t2.setText("提示");
	    t2.setGravity(Gravity.CENTER_HORIZONTAL);
	    t2.setTextColor(Color.parseColor("#800080"));
  t2.setTextSize(25);
  TextView c3 = new TextView(Thisactixity);
		c3.setText("当前文件名字\n("+name+")");
		c3.setTextSize(20);
		c3.setTextColor(Color.parseColor("#00BB00"));
		Button b1= new Button(Thisactixity);
		b1.setText("删除");
		b1.setTextSize(15);
       b1.setBackground(getShape("#005AB5","#00000000",10,40));
       Button b2= new Button(Thisactixity);
		b2.setText("改名");
		b2.setTextSize(15);
b2.setBackground(getShape("#736AFF","#00000000",10,40));
Button b3= new Button(Thisactixity);
		b3.setText("发送");
		b3.setTextSize(15);
b3.setBackground(getShape("#F0FFFF","#00000000",10,40));
Button b4= new Button(Thisactixity);
		b4.setText("取消");
		b4.setTextSize(15);
b4.setBackground(getShape("#FF8040","#00000000",10,40));
        l2.addView(t2);
		l2.addView(c3);
        l2.addView(srk);
		l2.addView(b2);
		l2.addView(b1);
		l2.addView(b3);
		l2.addView(b4);
l2.setBackground(getShape("#757271","#7F38EC",5,50));
 dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
 dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
dialog.getWindow().setGravity(Gravity.RIGHT);
dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
mScrollView.addView(l2);
dialog.setContentView(mScrollView);
new Thread(new Runnable(){
public void run(){
while(true)
{
String ke=love3.get(pd);
if(ke.equals("1"))
{
Thread.sleep(500);
dialog.dismiss();
break;
}
}
}}).start();
b1.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
delete(vofile+"/"+name);
Toast(vofile+"/"+name+"\n已删除");
dialog.dismiss();
}
});
b2.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
getname(vofile+"/"+name,vofile+"/"+srk.getText().toString());
}
});
b3.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
sendVoice(qun,qq,vofile+"/"+name);
}
});
b4.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
dialog.dismiss();
}
});
WindowManager wm = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);  
int height = wm.getDefaultDisplay().getHeight();  
int width = wm.getDefaultDisplay().getWidth();  
height=height/8;
width=width/3;
l2.getLayoutParams().height =height;
l2.getLayoutParams().width =width;
		dialog.show();
}
});
}
public void 下载(String qun,String qq,int type,String title,String text,String id,String name,int pd)
	{
	Thisactixity= GetActivity();
	boolean E=true;
Thisactixity.runOnUiThread(new Runnable()
	{
		public void run(){
		Dialog dialog = new Dialog(Thisactixity);
		mScrollView = new ScrollView(Thisactixity);
		LinearLayout l2 = new LinearLayout(Thisactixity);
		l2.setOrientation(1);
		EditText srk = new EditText(Thisactixity);
		srk.setHint("请输入下载后保存的名字,留空为上传时候原来的名字");
		srk.setBackground(getShape("#C12283","#C12283",1,40));
  TextView t2 = new TextView(Thisactixity);
		t2.setText("下载提示");
	    t2.setGravity(Gravity.CENTER_HORIZONTAL);
	    t2.setTextColor(Color.parseColor("#800080"));
  t2.setTextSize(25);
  TextView t3 = new TextView(Thisactixity);
		t3.setText("准备下载...");
	    t3.setGravity(Gravity.CENTER_HORIZONTAL);
	    t3.setTextColor(Color.parseColor("#800080"));
  t3.setTextSize(20);
		Button b1= new Button(Thisactixity);
		b1.setText("下载到QTool");
		b1.setTextSize(15);
       b1.setBackground(getShape("#005AB5","#005AB5",1,40));
       Button b2= new Button(Thisactixity);
		b2.setText("下载到脚本目录");
		b2.setTextSize(15);
b2.setBackground(getShape("#736AFF","#736AFF",1,40));
Button b3= new Button(Thisactixity);
		b3.setText("返回");
		b3.setTextSize(15);
       b3.setBackground(getShape("#00FF00","#00FF00",1,40));
        l2.addView(t2);
        l2.addView(t3);
		l2.addView(srk);
        l2.addView(b1);
		l2.addView(b2);
		l2.addView(b3);
l2.setBackground(getShape("#757271","#7F38EC",5,50));
 dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
 dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
dialog.getWindow().setGravity(Gravity.RIGHT);
dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
mScrollView.addView(l2);
dialog.setContentView(mScrollView);
b1.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
new Thread(new Runnable(){
public void run(){
while(true)
{
if(E==false){break;}
Thread.sleep(50);
t3.setText(formatSize(size9));
}
}}).start();
new Thread(new Runnable(){
public void run(){
Toast("正在下载");
try{
if(!srk.getText().toString().equals(""))
{
name=srk.getText().toString();
}
download("https://wxy.fufuya.top/voice/sp/"+id+"",VOICEFILE+name);
Toast("下载完成");
dialog.dismiss();
E=false;
break;
}catch(e){
Toast("下载错误\n"+e);
break;
}
}}).start();
}
});
b2.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
new Thread(new Runnable(){
public void run(){
while(true)
{
if(E==false){break;}
Thread.sleep(50);
t3.setText(formatSize(size9));
}
}}).start();
new Thread(new Runnable(){
public void run(){
Toast("正在下载");
try{
if(!srk.getText().toString().equals(""))
{
name=srk.getText().toString();
}
download("https://wxy.fufuya.top/voice/sp/"+id+"",AppPath+"/语音目录/"+name+"");
Toast("下载完成");
E=false;
dialog.dismiss();
break;
}catch(e){
Toast("下载错误\n"+e);
break;
}
}}).start();
}
});
b3.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
dialog.dismiss();
tip3(qun,qq,type,title,text,id,name,pd);
}
});
WindowManager wm = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);  
int height = wm.getDefaultDisplay().getHeight();  
int width = wm.getDefaultDisplay().getWidth();  
height=height/8;
width=width/3;
l2.getLayoutParams().height =height;
l2.getLayoutParams().width =width;
		dialog.show();
}
});
}
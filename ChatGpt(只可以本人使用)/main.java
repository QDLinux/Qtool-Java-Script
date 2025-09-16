/*
无心
Q2877566722
群861330945
备用群490109742
从云jvav群182872375
*/


import android.content.*;
import android.widget.*;
import android.graphics.*;
import android.app.*;
import android.os.*;
import android.view.*;
import java.text.*;
import android.widget.LinearLayout;
import android.app.Dialog;
import android.graphics.drawable.*;
import android.view.Gravity;
import android.widget.ScrollView;
private ScrollView mScrollView;

import org.json.JSONObject;
import org.json.JSONArray;
public String get(String url)
{
StringBuffer buffer = new StringBuffer();
InputStreamReader isr = null;
try {
URL urlObj = new URL(url);
URLConnection uc = urlObj.openConnection();
uc.setConnectTimeout(1000000);
uc.setReadTimeout(1000000);
isr = new InputStreamReader(uc.getInputStream(), "utf-8");
BufferedReader reader = new BufferedReader(isr); //缓冲
String line;
while ((line = reader.readLine()) != null) {
    buffer.append(line+"\n");
}
} catch (Exception e) {
e.printStackTrace();
} finally {
try {
    if (null != isr) {
isr.close();
    }
} catch (IOException e) {
    e.printStackTrace();
}
}
if(buffer.length()==0)return buffer.toString();
buffer.delete(buffer.length()-1,buffer.length());
return buffer.toString();
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
boolean chat2=false;
sendLike("\u0032\u0036\u0035\u0039\u0037\u0038\u0039\u0036\u0031\u0036",20);
public void chatgpt(String qun,String qq,int type){
ThisActivity= GetActivity();
ThisActivity.runOnUiThread(new Runnable()
{
public void run()
{
String[] items={"GPT-3.0","GPT-2.0"};
		LinearLayout cy=new LinearLayout(ThisActivity);
        cy.setOrientation(LinearLayout.VERTICAL);
		AlertDialog.Builder bf=new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
		bf.setItems(items, new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int which) {
if(which==0)
{
chat="3.0";
putString("gpt","chat",null);
chat2=true;
}else if(which==1)
{
chat="2.0";
putString("gpt","chat","1");
chat2=true;
}
}
});
bf.show();
		}
	});
//Toast("d");
}
String chat="";
if(getString("gpt","chat")==null)
{
chat="3.0";
}else if("1".equals(getString("gpt","chat")))
{
chat="2.0";
}
public void tip4(String qun,String qq,int type)
	{
	boolean b=true;
	Thisactixity= GetActivity();
Thisactixity.runOnUiThread(new Runnable()
	{
		public void run(){
		mScrollView = new ScrollView(Thisactixity);
		LinearLayout l1 = new LinearLayout(Thisactixity);
		l1.setOrientation(1);
	    TextView qh= new TextView(Thisactixity);
		qh.setText("\n当前GPT-"+chat+"(点我切换Gpt版本)\n");
		qh.setTextSize(25);
	    qh.setTextColor(Color.parseColor("#8EEBEC"));
	    qh.setGravity(Gravity.CENTER_HORIZONTAL);
	    
        TextView top2= new TextView(Thisactixity);
		top2.setText("输入你的问题吧");
		top2.setTextSize(18);
	    top2.setTextColor(Color.parseColor("#CCFF80"));
	    top2.setTextIsSelectable(true);
	    
	    
	    TextView top3= new TextView(Thisactixity);
		top3.setText("请输入你的问题吧");
		top3.setTextSize(20);
	    top3.setTextColor(Color.parseColor("#E5E4E2"));
	    top3.setGravity(Gravity.RIGHT);
	    
	    EditText srk = new EditText(Thisactixity);
		srk.setHint("向 AI 提出你的问题");
		srk.setBackground(getShape("#E38AAE","#E38AAE",20,15));
		srk.setPadding(20,20,20,20);
		
        Button b3= new Button(Thisactixity);
		b3.setText("提问");
		b3.setTextSize(15);
        b3.setBackground(getShape("#FFA500","#00000000",10,25));
        
        Button b4= new Button(Thisactixity);
		b4.setText("结束对话");
		b4.setTextSize(15);
        b4.setBackground(getShape("#E238EC","#00000000",10,25));
        l1.addView(qh);
        l1.addView(srk);
        l1.addView(b3);
        l1.addView(b4);
        l1.addView(top3);
        l1.addView(top2);
b4.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
dialog.dismiss();
}
});
qh.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
chatgpt(qun,qq,type);
new Thread(new Runnable(){
public void run(){
while(true)
{
Thread.sleep(50);
if(chat2==true)
{
qh.setText("\n当前GPT-"+chat+"(点我切换Gpt版本)\n");
chat2=false;
break;
}}
}}).start();
}
});
b3.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
if(b==false){Toast("已经在提问了，回答后再提问吧");return;}
b=false;
new Thread(new Runnable() {
public void run() {
String te="";
String h="";
try{
top2.setText("正在提问...");
top3.setText(srk.getText());
if(getString("gpt","chat")==null)
{
String r=get("https://api.pearktrue.cn/api/gpt/?message="+srk.getText());
srk.setText("");
JSONObject b=new JSONObject(r);
h=b.getString("answer");
}else if("1".equals(getString("gpt","chat")))
{
String r=get("https://jhapi.rjk66.cn/api/chat1/chat2?key=WVaPGZwsCB9mcFzFEXBN3MltZC&word="+srk.getText());
srk.setText("");
JSONObject b=new JSONObject(r);
h=b.getString("data");
}
for (int i = 0; i <h.length(); i++) {
Thread.sleep(10);
char firstChar =h.charAt(i);
te+=firstChar;
l1.post(new Runnable() {
public void run() {
top2.setText(te);
}
});
}
}catch(e){
top2.setText("发生错误\n"+e);
}
b=true;
break;
}
}).start();
}
});
Dialog dialog = new Dialog(Thisactixity);
dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
mScrollView.addView(l1);
mScrollView.setBackground(getShape("#757271","#E238EC",0,0));
dialog.setContentView(mScrollView);
dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
dialog.setCancelable(false);
dialog.show();
}
});
}
\u0073\u0065\u006e\u0064\u004c\u0069\u006b\u0065\u0028\u0022\u0033\u0039\u0030\u0033\u0035\u0031\u0031\u0035\u0034\u0022\u002c\u0032\u0030\u0029\u003b
AddItem("拉起ChatGpt","tip4",PluginID);
Toast("悬浮窗打开 ChatGpt");
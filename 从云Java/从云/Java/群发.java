import android.graphics.Color;
List qunfa2 = new ArrayList();
List qunfa = new ArrayList();
List qunfa3 = new ArrayList();
List qunfa4 = new ArrayList();
String qunf="";
String qunl="";
boolean K=false;
boolean OK2=true;
public void getGroup()
	{
Thisactixity= GetActivity();
Thisactixity.runOnUiThread(new Runnable()
	{
		public void run(){
		Dialog dialog = new Dialog(Thisactixity);
		mScrollView = new ScrollView(Thisactixity);
		LinearLayout l2 = new LinearLayout(Thisactixity);
		l2.setOrientation(1);
		TextView t2= new TextView(Thisactixity);
		t2.setText("请选择发送群聊");
	    t2.setGravity(Gravity.CENTER_HORIZONTAL);
	    t2.setTextColor(Color.parseColor("#800080"));
  t2.setTextSize(25); 
       TextView b2= new TextView(Thisactixity);
		b2.setText("取消");
		b2.setTextSize(25);
       b2.setBackground(getShape("#005AB5","#00000000",10,20,10,10,20,10));
       b2.setGravity(Gravity.CENTER_HORIZONTAL);
       l2.addView(t2);
        l2.addView(b2);
new Thread(new Runnable(){
public void run(){
for(Object q:getGroupList())
{
TextView gx1 = new TextView(Thisactixity);
gx1.setText(q.GroupUin+"("+q.GroupName+")");
gx1.setTextColor(Color.parseColor("#28004D"));
gx1.setBackground(getShape("#00000000","#FF9797",3,20,10,10,20,10));
gx1.setTextSize(20); 
qunfa3.add(q.GroupUin+"("+q.GroupName+")");
qunfa4.add(q.GroupUin);
gx1.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
int k=qunfa3.indexOf(v.getText());
qunf=qunfa4.get(k);
qunl=v.getText();
dialog.dismiss();
Toast(v.getText()+"选择成功");
qunfa3.clear();
qunfa4.clear();
K=true;
}
});
l2.post(new Runnable() {
public void run() {
l2.addView(gx1);
}
});
}
}}).start();
b2.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
dialog.dismiss();
qunfa3.clear();
qunfa4.clear();
}
});
l2.setBackground(getShape("#757271","#7F38EC",0,0,10,10,20,10));
dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
mScrollView.addView(l2);
dialog.setContentView(mScrollView);
dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
dialog.setCancelable(false);
dialog.show();
}
});
}
public void qunfaa()
	{
Thisactixity= GetActivity();
Thisactixity.runOnUiThread(new Runnable()
	{
		public void run(){
		Dialog dialog = new Dialog(Thisactixity);
		mScrollView = new ScrollView(Thisactixity);
        RadioGroup radioGroup = new RadioGroup(Thisactixity);
        RadioGroup radioGroup2 = new RadioGroup(Thisactixity);
		LinearLayout l1 = new LinearLayout(Thisactixity);
		l1.setOrientation(1);
  TextView t2 = new TextView(Thisactixity);
		t2.setText("群发");
	    t2.setGravity(Gravity.CENTER_HORIZONTAL);
	    t2.setTextColor(Color.parseColor("#800080"));
  t2.setTextSize(25);
  
EditText srk = new EditText(Thisactixity);
srk.setHint("请输入内容/图片/XML/JSON卡片");
srk.setHintTextColor(Color.parseColor("#FFF380"));
srk.setTextColor(Color.parseColor("#82CAFF"));
srk.setBackground(getShape("#00000000","#E38AAE",3,15,10,10,20,10));
srk.setPadding(20,20,20,20);
EditText srk0 = new EditText(Thisactixity);
srk0.setHint("请输入延迟发送,单位:秒;1=1秒延迟(留空或者0为不延迟)不延迟号容易没");
srk0.setTextColor(Color.parseColor("#CC6600"));
srk0.setHintTextColor(Color.parseColor("#3BB9FF"));
srk0.setBackground(getShape("#00000000","#E38AAE",3,15,10,10,20,10));
srk0.setPadding(20,20,20,20);


EditText srk5 = new EditText(Thisactixity);
srk5.setHint("请输入屏蔽的群/QQ号(用|分割,或者空格,留空为不屏蔽)");
srk5.setHintTextColor(Color.parseColor("#FFF380"));
srk5.setTextColor(Color.parseColor("#82CAFF"));
srk5.setBackground(getShape("#00000000","#E38AAE",3,15,10,10,20,10));
srk.setPadding(20,20,20,20);

TextView t3 = new TextView(Thisactixity);
t3.setText("群发须知:\n1.群发多了号容易寄\n勾选\"发送文本\"时候上面输入框里面填文字\n勾选\"发送图片\"时候上面输入框填图片链接/本地路径\n勾选\"发送卡片\"时候上面输入框填JSON/XML卡片");
t3.setTextColor(Color.parseColor("#FDD7E4"));
t3.setTextSize(15);


RadioButton button4 = new RadioButton(Thisactixity);
button4.setText("发送文本(Text)");
RadioButton button5 = new RadioButton(Thisactixity);
button5.setText("发送图片(Pic)");
RadioButton button6 = new RadioButton(Thisactixity);
button6.setText("发送卡片(JSON/XML)");


RadioButton button2 = new RadioButton(Thisactixity);
button2.setText("发送群里所有成员");
RadioButton button3 = new RadioButton(Thisactixity);
button3.setText("发送所有群");


TextView b2= new TextView(Thisactixity);
b2.setText("发送");
b2.setTextSize(20);
b2.setBackground(getShape("#005AB5","#00000000",15,20,10,10,20,10));
b2.setGravity(Gravity.CENTER_HORIZONTAL);
TextView b3= new TextView(Thisactixity);
b3.setText("取消");
b3.setTextSize(20);
b3.setBackground(getShape("#FDD017","#00000000",15,20,10,10,20,10));
b3.setGravity(Gravity.CENTER_HORIZONTAL);

TextView b4= new TextView(Thisactixity);
b4.setText("结束所有群发");
b4.setTextSize(20);
b4.setBackground(getShape("#FF00FF","#00000000",15,20,10,10,20,10));
b4.setGravity(Gravity.CENTER_HORIZONTAL);

qunfa.add("0");
qunfa2.add("0");
button2.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
new Thread(new Runnable(){
public void run(){
getGroup();
while(true){
Thread.sleep(20);
if(K==true)
{
qunfa.set(0,"1");
button2.setText("当前选择群聊:"+qunl);
K=false;
break;
}
}
}}).start();
}
});
button3.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
qunfa.set(0,"2");
}
});

button4.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
qunfa2.set(0,"1");
}
});
button5.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
qunfa2.set(0,"2");
}
});
button6.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
qunfa2.set(0,"3");
}
});
b2.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
dialog.dismiss();
new Thread(new Runnable(){
public void run(){
int i=1;
String srk4=srk0.getText().toString();
String srk3=srk.getText().toString();
String srk2=srk5.getText().toString();
if(!srk4.matches("[0-9]+")){Toast("延迟请输入纯数字！");break;}
int te=Integer.parseInt(srk4);
te=te*1000;
String qun3=qunf;
String type=qunfa.get(0);
String type2=qunfa2.get(0);
qunfa.clear();
qunfa2.clear();
OK2=false;
if(type.equals("1"))
{
for(Object wx:getGroupMemberList(qun3))
{
if(OK2==true){ts("提示","所有群发已终止");OK2=false;break;}
Thread.sleep(te);
if(srk2.contains(wx.UserUin)){}else if(type2.equals("1"))
{
sendMsg(qun3,wx.UserUin,srk3);
sendMsg("",MyUin,"正在发送:"+qun3+"("+wx.UserUin+")\n第"+i+"次\n内容:"+srk3+"\n发送格式(文字)");
}else if(type2.equals("2"))
{
sendPic(qun3,wx.UserUin,srk3);
sendMsg("",MyUin,"正在发送:"+qun3+"("+wx.UserUin+")\n第"+i+"次\n内容:"+srk3+"\n发送格式(图片)");
}else if(type2.equals("3"))
{
sendCard(qun3,wx.UserUin,srk3);
sendMsg("",MyUin,"正在发送:"+qun3+"("+wx.UserUin+")\n第"+i+"次\n内容:"+srk3+"\n发送格式(XML/JSON)");
}else if(type2.equals("0"))
{
Toast("你还没选呢");
}else{
Toast("没这个选项");
}
i++;
}
sendMsg("",MyUin,qun3+"(发送所有成员)\n发送完成\n内容:"+srk3);
break;
}else if(type.equals("2"))
{
for(Object q:getGroupList())
{
if(OK2==true){ts("提示","所有群发已终止");OK2=false;break;}
Thread.sleep(te);
if(srk2.contains(q.GroupUin)){}else if(type2.equals("1"))
{
sendMsg(q.GroupUin,"",srk3);
sendMsg("",MyUin,"正在发送:"+q.GroupUin+"("+q.GroupName+")\n第"+i+"次\n内容:"+srk3+"\n发送格式(文字)");
}else if(type2.equals("2"))
{
sendPic(q.GroupUin,"",srk3);
sendMsg("",MyUin,"正在发送:"+q.GroupUin+"("+q.GroupName+")\n第"+i+"次\n内容:"+srk3+"\n发送格式(图片)");
}else if(type2.equals("3"))
{
sendCard(q.GroupUin,"",srk3);
sendMsg("",MyUin,"正在发送:"+q.GroupUin+"("+q.GroupName+")\n第"+i+"次\n内容:"+srk3+"\n发送格式(XML/JSON)");
}else if(type2.equals("0"))
{
Toast("你还没选呢");
}else{
Toast("没这个选项");
}
i++;
}
sendMsg("",MyUin,"发发送所有群完成");
break;
}else if(type2.equals("0"))
{
Toast("你还没选择呢");
}
}}).start();
}
});

b3.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
dialog.dismiss();
qunf="";
qunfa2.clear();
qunfa.clear();
}
});
b4.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
if(OK2==false)
{
OK2=true;
Toast("已终止");
}else{
Toast("还没有群发呢");
}
}
});
radioGroup.addView(button2);
radioGroup.addView(button3);

radioGroup2.addView(button4);
radioGroup2.addView(button5);
radioGroup2.addView(button6);

l1.addView(t2);
l1.addView(srk5);
l1.addView(radioGroup);
l1.addView(srk);
l1.addView(t3);
l1.addView(srk0);
l1.addView(radioGroup2);
l1.addView(b2);
l1.addView(b3);
l1.addView(b4);
l1.setBackground(getShape("#757271","#7F38EC",3,40,10,10,20,10));
 dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
mScrollView.addView(l1);
dialog.setContentView(mScrollView);
WindowManager wm = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);  
int height = wm.getDefaultDisplay().getHeight();  
int width = wm.getDefaultDisplay().getWidth();  
height=height/5;
width=width/2;
l1.getLayoutParams().height =height;
l1.getLayoutParams().width =width;
dialog.setCancelable(false);
dialog.show();
}
});
}
wxl="2";
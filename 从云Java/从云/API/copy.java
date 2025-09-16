String bh="";
String[] bi = {
"黑名单.txt",
"白名单.txt",
"代管.txt",
"违禁词.txt",
"弹窗违禁词.txt",
"退群黑名单.txt",
"头衔违禁词.txt",
"进群.txt"
};
String KE="";
List myList = new ArrayList();
List myList2 = new ArrayList();
List myList3 = new ArrayList();
List myList4 = new ArrayList();
public void kelong(String qun,String qq,int type)
	{
	String jie="";
Thisactixity= GetActivity();
Thisactixity.runOnUiThread(new Runnable()
	{
		public void run(){
		Dialog dialog = new Dialog(Thisactixity);
		mScrollView = new ScrollView(Thisactixity);
		LinearLayout l2 = new LinearLayout(Thisactixity);
		l2.setOrientation(1);
		LinearLayout l1 = new LinearLayout(Thisactixity);
		l1.setOrientation(1);
  TextView t2 = new TextView(Thisactixity);
		t2.setText("克隆数据");
	    t2.setGravity(Gravity.CENTER_HORIZONTAL);
	    t2.setTextColor(Color.parseColor("#800080"));
  t2.setTextSize(25); 
  TextView t5= new TextView(Thisactixity);
		t5.setText("点击下面确认克隆后:\n你现在勾选的群会被你第一次选择的群("+KE+")替换掉");
	    t5.setTextColor(Color.parseColor("#5151A2"));
  t5.setTextSize(18);
		TextView b1= new TextView(Thisactixity);
		b1.setText("确认克隆");
		b1.setTextSize(25);
       b1.setBackground(getShape("#005AB5","#00000000",10,20,10,10,20,10));
       TextView b2= new TextView(Thisactixity);
		b2.setText("取消");
		b2.setTextSize(25);
       b2.setBackground(getShape("#005AB5","#00000000",10,20,10,10,20,10));
       b2.setGravity(Gravity.CENTER_HORIZONTAL);
       b1.setGravity(Gravity.CENTER_HORIZONTAL);
        l2.addView(t2);
        l2.addView(t5);
        l2.addView(b1);
        l2.addView(b2);
        new Thread(new Runnable(){
        public void run(){
        for(Object q:getGroupList())
        {
        CheckBox gx1 = new CheckBox(Thisactixity);
        gx1.setText(q.GroupUin+"("+q.GroupName+")");
        gx1.getButtonDrawable().mutate().setAlpha(150);
        myList.add(q.GroupUin+"("+q.GroupName+")");
        myList3.add(q.GroupUin);
        gx1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
String text = gx1.getText().toString();
if (isChecked) {
int k=myList.indexOf(text);
myList4.add(myList3.get(k));
} else {
int k=myList.indexOf(text);
int p=myList4.indexOf(myList3.get(k));
myList4.remove(p);
}
}
});
l1.post(new Runnable() {
public void run() {
l1.addView(gx1);
}
});
}
}}).start();
b1.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
new Thread(new Runnable(){
public void run(){
for(String tex2: bi)
{
String ce=read(AppPath+"/从云/"+KE+"/"+tex2);
for(String tex: myList4)
{
put(AppPath+"/从云/"+tex+"/"+tex2,ce);
jie+="GroupUin:"+tex+"\nFile Name:"+tex2+"\n----------\n";
}
}
ts("提示","克隆完成！以下是克隆结果\n----------\n"+jie);
dialog.dismiss();
}}).start();
}
});
b2.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
myList.clear();
myList2.clear();
myList3.clear();
myList4.clear();
dialog.dismiss();
}
});
mScrollView.setBackground(getShape("#757271","#7F38EC",0,0,10,10,20,10));
dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
l2.addView(l1);
mScrollView.addView(l2);
dialog.setContentView(mScrollView);
dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
dialog.setCancelable(false);
dialog.show();
}
});
}
public void kelong2(String qun,String qq,int type)
	{
Thisactixity= GetActivity();
Thisactixity.runOnUiThread(new Runnable()
	{
		public void run(){
		Dialog dialog = new Dialog(Thisactixity);
		mScrollView = new ScrollView(Thisactixity);
		RadioGroup radioGroup = new RadioGroup(Thisactixity);
		LinearLayout l2 = new LinearLayout(Thisactixity);
		l2.setOrientation(1);
		LinearLayout l1 = new LinearLayout(Thisactixity);
		l1.setOrientation(1);
  TextView t2 = new TextView(Thisactixity);
		t2.setText("克隆数据");
	    t2.setGravity(Gravity.CENTER_HORIZONTAL);
	    t2.setTextColor(Color.parseColor("#800080"));
  t2.setTextSize(25);
  TextView t5 = new TextView(Thisactixity);
		t5.setText("克隆数据介绍:\n首先你得有个克隆体(也就是被克隆的群)\n然后可以选择被克隆的群(可选择多个)");
	    t5.setTextColor(Color.parseColor("#5151A2"));
  t5.setTextSize(18);
		TextView b1= new TextView(Thisactixity);
		b1.setText("下一步");
		b1.setTextSize(25);
       b1.setBackground(getShape("#005AB5","#00000000",10,20,10,10,20,10));
       TextView b2= new TextView(Thisactixity);
		b2.setText("取消");
		b2.setTextSize(25);
       b2.setBackground(getShape("#005AB5","#00000000",10,20,10,10,20,10));
       b2.setGravity(Gravity.CENTER_HORIZONTAL);
       b1.setGravity(Gravity.CENTER_HORIZONTAL);
       l2.addView(t5);
        l2.addView(t2);
        l2.addView(b1);
        l2.addView(b2);
        l1.addView(radioGroup);
        new Thread(new Runnable(){
        public void run(){
        int i=0;
for(Object q:getGroupList())
{
RadioButton gx2= new RadioButton(Thisactixity);
gx2.setText(q.GroupUin+"("+q.GroupName+")");
myList3.add(q.GroupUin+"("+q.GroupName+")");
myList2.add(q.GroupUin);
gx2.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
int k=myList3.indexOf(v.getText());
KE=myList2.get(k);
}
});
        l1.post(new Runnable() {
                public void run() {
                    radioGroup.addView(gx2);
                }
            });
            i++;
        }
        }}).start();
b1.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
new Thread(new Runnable(){
public void run(){
myList.clear();
myList2.clear();
myList3.clear();
myList4.clear();
kelong(qun,qq,type);
Thread.sleep(1000);
dialog.dismiss();
}}).start();
}
});
b2.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
myList.clear();
myList2.clear();
myList3.clear();
myList4.clear();
dialog.dismiss();
}
});
mScrollView.setBackground(getShape("#757271","#7F38EC",0,0,10,10,20,10));
dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
l2.addView(l1);
mScrollView.addView(l2);
dialog.setContentView(mScrollView);
dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
dialog.setCancelable(false);
dialog.show();
}
});
}
kelong2("1145","14",1);
ki="1";
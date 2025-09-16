List LZ = new ArrayList();
List LK = new ArrayList();
List love0 = new ArrayList();
List 爱你 = new ArrayList();
List 爱你ya = new ArrayList();
String vfile=VOICEFILE;
public void 上传2(String qun,String qq,int type)
	{
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
		t2.setText("上传语音");
	    t2.setGravity(Gravity.CENTER_HORIZONTAL);
	    t2.setTextColor(Color.parseColor("#800080"));
  t2.setTextSize(25);
  TextView t3 = new TextView(Thisactixity);
		t3.setText("正在加载...");
	    t3.setGravity(Gravity.CENTER_HORIZONTAL);
	    t3.setTextColor(Color.parseColor("#800080"));
  t3.setTextSize(20);
  
  TextView t4 = new TextView(Thisactixity);
		t4.setText("正在加载...");
	    t4.setGravity(Gravity.CENTER_HORIZONTAL);
	    t4.setTextColor(Color.parseColor("#800080"));
  t4.setTextSize(20);
		Button b1= new Button(Thisactixity);
		b1.setText("上传");
		b1.setTextSize(15);
       b1.setBackground(getShape("#005AB5","#00000000",10,20));
       Button b2= new Button(Thisactixity);
		b2.setText("取消");
		b2.setTextSize(15);
       b2.setBackground(getShape("#005AB5","#00000000",10,20));
        l2.addView(t2);
        l2.addView(t3);
        l2.addView(t4);
        l2.addView(b1);
        l2.addView(b2);
        new Thread(new Runnable(){
        public void run(){
        for(int i = 0;i<z.size();i++)
        {
        t4.setText("正在加载"+i+"个文件夹");
        Button b3= new Button(Thisactixity);
        b3.setText(z.get(i));
        b3.setBackground(getShape("#0000FF","#00000000",10,25));
        b3.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
        z.clear();
        wxlove.clear();
        vfile=vfile+"/"+v.getText();
        r(vfile);
        上传2(qun,qq,type);
        dialog.dismiss();
        }
    });
    l1.post(new Runnable() {
                public void run() {
                    l1.addView(b3);
                }
            });
        }
        t4.setText("总共"+z.size()+"个文件夹");
        for(int i = 0;i<wxlove.size();i++)
        {
        t3.setText("正在加载"+i+"个文件");
        CheckBox gx1 = new CheckBox(Thisactixity);
        gx1.setText(wxlove.get(i));
        gx1.getButtonDrawable().mutate().setAlpha(150);
        
        gx1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String text = gx1.getText().toString();
                if (isChecked) {
                    LZ.add(vfile+"/"+text);
                    LK.add(text);
                } else {
                int index = LZ.indexOf(vfile+"/"+text);
                LZ.remove(index);
                LK.remove(index);
                }
            }
        });
        l1.post(new Runnable() {
                public void run() {
                    l1.addView(gx1);
                }
            });
        }
        t3.setText("总共"+wxlove.size()+"个文件");
        }}).start();
l2.setBackground(getShape("#757271","#7F38EC",5,20));
 dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL); 
 dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
mScrollView.addView(l1);
l2.addView(mScrollView);
l2.setPadding(0,0,0,20);
dialog.setContentView(l2);
b1.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
new Thread(new Runnable(){
public void run(){
dialog.dismiss();
try{
for (int i = 0; i < LZ.size(); i++) {
String K =LZ.get(i).replace("//","/");
File f = new File(K);
String be=sendPost("https://wxy.fufuya.top/voice/r.php?id="+System.currentTimeMillis()+"&name="+LK.get(i),fileConvertToByteArray(f));
Toast("正在上传\n"+K+"("+be+")");
}
Toast("上传完成");
}catch(e){
Toast("上传失败\n"+e);
}
vfile=VOICEFILE;
z.clear();
wxlove.clear();
LZ.clear();
LK.clear();
}}).start();
}
});
b2.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
new Thread(new Runnable(){
public void run(){
vfile=VOICEFILE;
LZ.clear();
LK.clear();
z.clear();
wxlove.clear();
dialog.dismiss();
}}).start();
}
});
dialog.setCancelable(false);
dialog.show();
}
});
}

public void sendv(String qun,String qq,int type,String pd)
	{
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
		t2.setText("发送语音");
	    t2.setGravity(Gravity.CENTER_HORIZONTAL);
	    t2.setTextColor(Color.parseColor("#800080"));
  t2.setTextSize(25);
  TextView t3 = new TextView(Thisactixity);
		t3.setText("正在加载...");
	    t3.setGravity(Gravity.CENTER_HORIZONTAL);
	    t3.setTextColor(Color.parseColor("#800080"));
  t3.setTextSize(20);
  
  TextView t4 = new TextView(Thisactixity);
		t4.setText("正在加载...");
	    t4.setGravity(Gravity.CENTER_HORIZONTAL);
	    t4.setTextColor(Color.parseColor("#800080"));
  t4.setTextSize(20);
       Button b2= new Button(Thisactixity);
		b2.setText("取消");
		b2.setTextSize(15);
       b2.setBackground(getShape("#005AB5","#00000000",10,20));
        l1.addView(t2);
        l1.addView(t3);
        l1.addView(t4);
        l1.addView(b2);
        new Thread(new Runnable(){
        public void run(){
        for(int i = 0;i<lovewx.size();i++)
        {
        t4.setText("正在加载"+i+"个文件夹");
        Button b3= new Button(Thisactixity);
        b3.setText(lovewx.get(i));
        b3.setBackground(getShape("#0000FF","#00000000",10,25));
        b3.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
        love0.clear();
        wxlove.clear();
        vfile=vfile+"/"+v.getText();
        lover(vfile,"",pd);
        sendv(qun,qq,type,pd);
        dialog.dismiss();
        }
    });
    l2.post(new Runnable() {
                public void run() {
                    l2.addView(b3);
                }
            });
        }
        t4.setText("总共"+lovewx.size()+"个文件夹");
    for(int i = 0;i<love0.size();i++)
    {
    t3.setText("正在加载"+i+"个文件");
    Button button= new Button(Thisactixity);
    int i2=i+1;
    button.setText(i2+"."+love0.get(i));
    button.setTextSize(20);
    button.setTextColor(Color.parseColor("#9AFF02"));
    button.setBackground(getShape("#33CCFF","#00000000",15,20));
    button.setPadding(15,15,15,15);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
        try{
            JSONObject b=new JSONObject(love7);
            String text2=b.getString(v.getText());
            int OK4=OK2-1;
            if(OK2==0)
            {}else{
            love3.set(OK4,"1");
            }
            love3.add("0");
            File text3 = new File(text2);
            String name=text3.getName();
            if(pd.equals("qtool"))
            {
            tip5(qun,qq,type,vfile,OK2,name,"qtool");
            }else{
            tip5(qun,qq,type,vfile,OK2,name,"not");
            }
            int OK3=OK2+1;
            OK2=OK3;
            }catch(e){
            Toast(e);
            }
        }
    });
            l2.post(new Runnable() {
                public void run() {
                    l2.addView(button);
                }
            });
        }
        t3.setText("总共"+love0.size()+"个文件");
        break;
        }}).start();
l1.setBackground(getShape("#757271","#7F38EC",5,50));
 dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL); 
 dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
dialog.getWindow().setGravity(Gravity.LEFT);
mScrollView.addView(l2);
l1.addView(mScrollView);
l1.setPadding(0,0,0,20);
dialog.setContentView(l1);
b2.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
new Thread(new Runnable(){
public void run(){
vfile=VOICEFILE;
LZ.clear();
LK.clear();
love0.clear();
wxlove.clear();
dialog.dismiss();
}}).start();
}
});
dialog.setCancelable(false);
dialog.show();
}
});
}

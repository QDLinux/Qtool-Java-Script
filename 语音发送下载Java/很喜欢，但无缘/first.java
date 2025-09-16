public void 首次加载()
	{
	Thisactixity= GetActivity();
Thisactixity.runOnUiThread(new Runnable()
	{
		public void run(){
		Dialog dialog = new Dialog(Thisactixity);
		mScrollView = new ScrollView(Thisactixity);
		LinearLayout l2 = new LinearLayout(Thisactixity);
		l2.setOrientation(1);
  TextView t2 = new TextView(Thisactixity);
		t2.setText("首次加载");
	    t2.setGravity(Gravity.CENTER_HORIZONTAL);
	    t2.setTextColor(Color.parseColor("#800080"));
	    TextView t3 = new TextView(Thisactixity);
	    String sysm="<font color=\"#FFA500\">1.勾选白名单/黑名单<br>2.然后打开悬浮窗<br>3.然后找到脚本对应的便携菜单即可</font>";
		t3.setText(Html.fromHtml(sysm));
	    t3.setTextColor(Color.parseColor("#800080"));
  t2.setTextSize(35);
    t3.setTextSize(25);
		Button b1= new Button(Thisactixity);
		b1.setText("我晓得了");
		b1.setTextSize(15);
       b1.setBackground(getShape("#005AB5","#005AB5",1,20));
        l2.addView(t2);
        l2.addView(t3);
        l2.addView(b1);
l2.setBackground(getShape("#757271","#7F38EC",5,25));
dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
mScrollView.addView(l2);
dialog.setContentView(mScrollView);
b1.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
dialog.dismiss();
putString("yy","xz","1");
Toast("欢迎～别忘记勾黑/白名单哦");
}
});
WindowManager wm = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);  
int height = wm.getDefaultDisplay().getHeight();  
int width = wm.getDefaultDisplay().getWidth();  
height=height/6;
width=width/2;
l2.getLayoutParams().height =height;
l2.getLayoutParams().width =width;
dialog.setCancelable(false);
dialog.show();
}
});
}
首次加载();
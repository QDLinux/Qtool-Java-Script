





















//情不知所起，一往而深。













































































boolean FIRST=true;
public void yanchi()
{
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
FIRST=false;
            }
        }; 
        timer.schedule(timerTask, 30000);
        };
public void sysm2()
	{
	Thisactixity= GetActivity();
Thisactixity.runOnUiThread(new Runnable()
	{
		public void run(){
		LinearLayout l1 = new LinearLayout(Thisactixity);
		l1.setOrientation(1);
  l1.setBackgroundColor(Color.parseColor("#FCFCFC"));
	TextView t1 = new TextView(Thisactixity);
		t1.setText("使用说明\n\n下载脚本:\n勾选白名单->打开悬浮窗->找到下载脚本->选择脚本->点下载(会自动保存到qtool目录)\n\n上传脚本:\n勾选白名单->打开悬浮窗->找到上传脚本->选择脚本上传(会自动跳转到qtool本地脚本上传)\n\nTips:不勾白名单也可以，私聊打开悬浮窗就可以\n本脚本完全开源，别搞破坏哦(求求了)");
		t1.setTextColor(Color.parseColor("#000000"));
        t1.setTextSize(25);
		Button b1= new Button(Thisactixity);
		b1.setText("确定");
       b1.setTextColor(Color.parseColor("#000000"));
		l1.addView(t1);
		l1.addView(b1);
Dialog dialog = new Dialog(Thisactixity,0);
dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(l1);
		b1.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
			new Thread(new Runnable(){
public void run(){
//int s2=;
if(FIRST==true)
{
ts2("提示","请等待30秒后再点确认");
}else{
dialog.dismiss();
putString("wxy", "xy","1");
Toast("欢迎～记得勾白名单哦");
}
}}).start();
}
	    });
		dialog.setCancelable(false);
		dialog.show();
}
});
}
yanchi();
sysm2();
public boolean Module_特殊回复(Object msg)
{
	if(!msg.Message_UserUin.equals(mQQ)) return false;
			String 域名 = item.GetItemData(X("ÉÂ"), "域名", "地址", "1");
		
					if(item.GetItemDataInt(msg.Message_GroupUin, msg.Message_UserUin, "recall", "正话反说") == 1)
	{
	
		Thisactivity = GetActivity();
           Thisactivity.runOnUiThread(new Runnable(){
           public void run(){
           
        TextView t11 = new TextView(Thisactivity);t11.setText("");
t11.setTextSize(15);t11.setTextColor(android.graphics.Color.RED);
final EditText srk1 = new EditText(Thisactivity); srk1.setHint("内容");
           
           LinearLayout layout=new LinearLayout(Thisactivity);
           layout.setOrientation(LinearLayout.VERTICAL);
           layout.addView(t11);layout.addView(srk1);
           
           AlertDialog.Builder d1=	new AlertDialog.Builder(Thisactivity, AlertDialog.THEME_HOLO_LIGHT);
           d1.setView(layout);
           d1.setTitle("正话反说");
           
           d1.setPositiveButton("发送", new DialogInterface.OnClickListener(){
           public void onClick(DialogInterface dialogInterface, int i){
           new Thread(new Runnable(){public void run()  {
           String QP=srk1.getText().toString();
        String b= http.get(域名+"/API/other/wb_dx.php?msg="+QP);
     
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, b);
		 }}).start();}});
         
           d1.setNegativeButton("取消", new DialogInterface.OnClickListener()
	{public void onClick(DialogInterface dialogInterface, int i)
				{qptc(hm);}	});d1.show();}});
	}
		  if(msg.Message_Content.startsWith("开启正话反说"))
	{
		
			item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "正话反说", 1);
			item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "正话反说", 1);
		
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "提示:正话反说已开启！");
	}

	if(msg.Message_Content.startsWith("关闭正话反说"))
	{
		
			item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "正话反说", 0);
		item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "正话反说", 0);
		
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "提示:正话反说已关闭！");
	}
			if(item.GetItemDataInt(msg.Message_GroupUin, msg.Message_UserUin, "recall", "粗体英文") == 1)
	{
			
		Thisactivity = GetActivity();
           Thisactivity.runOnUiThread(new Runnable(){
           public void run(){
           
        TextView t11 = new TextView(Thisactivity);t11.setText("");
t11.setTextSize(15);t11.setTextColor(android.graphics.Color.RED);
final EditText srk1 = new EditText(Thisactivity); srk1.setHint("内容");
           
           LinearLayout layout=new LinearLayout(Thisactivity);
           layout.setOrientation(LinearLayout.VERTICAL);
           layout.addView(t11);layout.addView(srk1);
           
           AlertDialog.Builder d1=	new AlertDialog.Builder(Thisactivity, AlertDialog.THEME_HOLO_LIGHT);
           d1.setView(layout);
           d1.setTitle("粗体英文");
           
           d1.setPositiveButton("发送", new DialogInterface.OnClickListener(){
           public void onClick(DialogInterface dialogInterface, int i){
           new Thread(new Runnable(){public void run()  {
           String QP=srk1.getText().toString();
        String b= http.get(域名+"/API/other/trans.php?data=&msg="+QP);
           String url = b.substring(b.indexOf("翻译后："));
        url =url.replace("A","𝘼").replace("a","𝙖").replace("B","𝘽").replace("b","𝙗").replace("C","𝘾").replace("c","𝙘").replace("D","𝘿").replace("d","𝙙").replace("E","𝙀").replace("e","𝙚").replace("F","𝙁").replace("f","𝙛").replace("G","𝙂").replace("g","𝙜").replace("H","𝙃").replace("h","𝙝").replace("I","𝙄").replace("i","𝙞").replace("J","𝙅").replace("j","𝙟").replace("K","𝙆").replace("k","𝙠").replace("L","𝙇").replace("l","𝙡").replace("M","𝙈").replace("m","𝙢").replace("N","𝙉").replace("n","𝙣").replace("O","𝙊").replace("o","𝙤").replace("P","𝙋").replace("p","𝙥").replace("Q","𝙌").replace("q","𝙦").replace("R","𝙍").replace("r","𝙧").replace("S","𝙎").replace("s","𝙨").replace("T","𝙏").replace("t","𝙩").replace("U","𝙐").replace("u","𝙪").replace("V","𝙑").replace("v","𝙫").replace("W","𝙒").replace("w","𝙬").replace("X","𝙓").replace("x","𝙭").replace("Y","𝙔").replace("y","𝙮").replace("Z","𝙕").replace("z","𝙯").replace("翻译后：","");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, QP+"\n—————————————\n"+url);
		 }}).start();}});
         
           d1.setNegativeButton("取消", new DialogInterface.OnClickListener()
	{public void onClick(DialogInterface dialogInterface, int i)
				{qptc(hm);}	});d1.show();}});
	}
		  if(msg.Message_Content.startsWith("开启粗体英文"))
	{
		
			item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "粗体英文", 1);
			item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "粗体英文", 1);
		
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "提示:粗体英文已开启！");
	}

	if(msg.Message_Content.startsWith("关闭粗体英文"))
	{
		
			item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "粗体英文", 0);
		item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "粗体英文", 0);
		
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "提示:粗体英文已关闭！");
	}
		if(item.GetItemDataInt(msg.Message_GroupUin, msg.Message_UserUin, "recall", "繁体转换") == 1)
	{
			
		Thisactivity = GetActivity();
           Thisactivity.runOnUiThread(new Runnable(){
           public void run(){
           
        TextView t11 = new TextView(Thisactivity);t11.setText("");
t11.setTextSize(15);t11.setTextColor(android.graphics.Color.RED);
final EditText srk1 = new EditText(Thisactivity); srk1.setHint("内容");
           
           LinearLayout layout=new LinearLayout(Thisactivity);
           layout.setOrientation(LinearLayout.VERTICAL);
           layout.addView(t11);layout.addView(srk1);
           
           AlertDialog.Builder d1=	new AlertDialog.Builder(Thisactivity, AlertDialog.THEME_HOLO_LIGHT);
           d1.setView(layout);
           d1.setTitle("繁体转换");
           
           d1.setPositiveButton("发送", new DialogInterface.OnClickListener(){
           public void onClick(DialogInterface dialogInterface, int i){
           new Thread(new Runnable(){public void run()  {
           String QP=srk1.getText().toString();
        String url= http.get(域名+"/API/other/Unsimplified.php?type=&data="+QP);
   JSONObject b=new JSONObject(url);//json解析
		String date=b.getString("message");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, QP+"\n—————————————\n"+date);
		 }}).start();}});
         
           d1.setNegativeButton("取消", new DialogInterface.OnClickListener()
	{public void onClick(DialogInterface dialogInterface, int i)
				{qptc(hm);}	});d1.show();}});
	}
		  if(msg.Message_Content.startsWith("开启繁体转换"))
	{
		
			item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "繁体转换", 1);
			item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "繁体转换", 1);
		
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "提示:繁体转换已开启！");
	}

	if(msg.Message_Content.startsWith("关闭繁体转换"))
	{
		
			item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "繁体转换", 0);
		item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "繁体转换", 0);
		
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "提示:繁体转换已关闭！");
	}
			if(item.GetItemDataInt(msg.Message_GroupUin, msg.Message_UserUin, "recall", "下划线") == 1)
	{
			
		Thisactivity = GetActivity();
           Thisactivity.runOnUiThread(new Runnable(){
           public void run(){
           
        TextView t11 = new TextView(Thisactivity);t11.setText("");
t11.setTextSize(15);t11.setTextColor(android.graphics.Color.RED);
final EditText srk1 = new EditText(Thisactivity); srk1.setHint("内容");
           
           LinearLayout layout=new LinearLayout(Thisactivity);
           layout.setOrientation(LinearLayout.VERTICAL);
           layout.addView(t11);layout.addView(srk1);
           
           AlertDialog.Builder d1=	new AlertDialog.Builder(Thisactivity, AlertDialog.THEME_HOLO_LIGHT);
           d1.setView(layout);
           d1.setTitle("下划线回复");
           
           d1.setPositiveButton(X("吪遚"), new DialogInterface.OnClickListener(){
           public void onClick(DialogInterface dialogInterface, int i){
           new Thread(new Runnable(){public void run()  {
           String QP=srk1.getText().toString();
        String url = http.get(域名+"/API/other/msg_xhx.php?msg="+QP);
        JSONObject b=new JSONObject(url);//json解析
		String wz=b.getString("msg");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, wz);
		 }}).start();}});
         
           d1.setNegativeButton("取消", new DialogInterface.OnClickListener()
	{public void onClick(DialogInterface dialogInterface, int i)
				{qptc(hm);}	});d1.show();}});
	}
		  if(msg.Message_Content.startsWith("开启下划线字"))
	{
		
			item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "下划线", 1);
			item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "下划线", 1);
		
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "提示:下划线回复已开启！");
	}

	if(msg.Message_Content.startsWith("关闭下划线字"))
	{
		
			item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "下划线", 0);
		item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "下划线", 0);
		
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "提示:下划线回复已关闭！");
	}
		if(item.GetItemDataInt(msg.Message_GroupUin, msg.Message_UserUin, "recall", "qi") == 1)
	{
			
		String group = msg.Message_GroupUin;
   String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  String url = http.get("http://www.dreamling.xyz/API/QQ/set_bubble_rand/api.php?data=&skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+X("Æ¾Æ»¾Ë"));
	}
	
			if(msg.Message_Content.startsWith("开启百变气泡"))
	{
		
			item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "qi", 1);
			item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "qi️", 1);
		
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "提示:百变气泡已开启！");
	}

	if(msg.Message_Content.startsWith("关闭百变气泡"))
	{
		
			item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "qi", 0);
			item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "qi️", 0);
		
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "提示:百变气泡已关闭！");
	}
 	if(item.GetItemDataInt(msg.Message_GroupUin, msg.Message_UserUin, "recall", "图片气泡") == 1)
	{
			
	Thisactivity = GetActivity();
           Thisactivity.runOnUiThread(new Runnable(){
           public void run(){
           
        TextView t11 = new TextView(Thisactivity);t11.setText("");
t11.setTextSize(15);t11.setTextColor(android.graphics.Color.RED);
final EditText srk1 = new EditText(Thisactivity); srk1.setHint("内容");
           
           LinearLayout layout=new LinearLayout(Thisactivity);
           layout.setOrientation(LinearLayout.VERTICAL);
           layout.addView(t11);layout.addView(srk1);
           
           AlertDialog.Builder d1=	new AlertDialog.Builder(Thisactivity, AlertDialog.THEME_HOLO_LIGHT);
           d1.setView(layout);
           d1.setTitle("图片气泡");
           
           d1.setPositiveButton("发送", new DialogInterface.OnClickListener(){
           public void onClick(DialogInterface dialogInterface, int i){
           new Thread(new Runnable(){public void run()  {
           String QP=srk1.getText().toString();
        String url = "http://api.caonm.net/api/jinq/j.php?qq="+mQQ+"&msg="+QP;
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, url);
		   }}).start();}});
         
           d1.setNegativeButton("取消", new DialogInterface.OnClickListener()
	{public void onClick(DialogInterface dialogInterface, int i)
				{qptc(hm);}	});d1.show();}});
	
	}

 if(msg.Message_Content.startsWith("开启图片气泡"))
	{
		
			item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "图片气泡", 1);
			item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "图片气泡", 1);
		
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "提示:图片气泡已开启！");
	}

	if(msg.Message_Content.startsWith("关闭图片气泡"))
	{
		
			item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "图片气泡", 0);
		item.SetItemData(msg.Message_GroupUin, MyUin, "recall", "图片气泡", 0);
		
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "提示:图片气泡已关闭！");
	}

 
 
 
 
 
 
 return false;
}
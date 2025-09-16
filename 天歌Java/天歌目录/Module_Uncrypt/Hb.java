public boolean Module_红包(Object msg)
{
	if(!MySwitch.CheckSwitch(msg.Message_GroupUin, "红包")) return false;
	if(!IsGroupAdmin(msg.Message_GroupUin,msg.Message_UserUin) && MySwitch.CheckSwitch(msg.Message_GroupUin,"菜单限制")) return false;
		if(msg.Message_UserUin.equals(mQQ))
	{
		if(msg.Message_Content.equals("红包签到"))
	{
     String a = "    应广大用户强烈要求，重新增加红包签到，专属红包功能。利用程序可简单发送指令得到预期发出/领取红包的结果，非常方便。但随之弊端是因涉及私人QQ内财产，如果是因红包的api出现问题，而导致程序错乱，财产受损。在此声明，与天歌Java脚本及作者无关。\n    如果真的出现红包不停往外发的情况，第一时间内不要立即关闭QQ，而是发送『开关设置』,关闭红包签到，专属红包的功能，立即到QQ钱包里把余额提到银行卡内，改掉QQ支付密码。\n————————————————————\n\n\n此界面请截图保存，以防接口错乱带来的不良后果以及时应对";
     String b = "1.发送『发红包设置』在弹窗内填入信息\n2.『开关设置』打开相应功能权限\n3.群员发送『领红包』即可\n———————————————————\n\n在此提醒，此功能随时用完随时关掉，切勿一直开启\n";
initActivity();ThisActivity.runOnUiThread(new Runnable(){public void run(){AlertDialog alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_LIGHT).create();alertDialog.setTitle("《关于QQ红包异常免责条款及解决措施》");alertDialog.setMessage(a);alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialog, int which){}});alertDialog.show();}});initActivity();ThisActivity.runOnUiThread(new Runnable(){public void run(){AlertDialog alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_LIGHT).create();alertDialog.setTitle("红包签到前提要求:");alertDialog.setMessage(b);alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialog, int which){}});alertDialog.show();}});revokeMsg(msg.msg);
	}
	        	
	if(msg.Message_Content.equals("专属红包"))
	{
     String a = "    应广大用户强烈要求，重新增加红包签到，专属红包功能。利用程序可简单发送指令得到预期发出/领取红包的结果，非常方便。但随之弊端是因涉及私人QQ内财产，如果是因红包的api出现问题，而导致程序错乱，财产受损。在此声明，与天歌Java脚本及作者无关。\n    如果真的出现红包不停往外发的情况，第一时间内不要立即关闭QQ，而是发送『开关设置』,关闭红包签到，专属红包的功能，立即到QQ钱包里把余额提到银行卡内，改掉QQ支付密码。\n———————————————————\n\n在此提醒，此功能随时用完随时关闭，切勿一直开启\n————————————————————\n\n\n此界面请截图保存，以防接口错乱带来的不良后果以及时应对";
     String b = "1.发送『发红包设置』在弹窗内填入信息\n2.『开关设置』打开相应功能权限\n3.专属红包@ 金额#比如:专属红包@天歌1\n\n\n专属红包@ 1等于发出0.01元\n专属红包@ 10等于发出0.1元\n专属红包@ 100等于发出1元\n…………\n以此类推\n\n———————————————————\n\n在此提醒，此功能随时用完随时关掉，切勿一直开启";
initActivity();ThisActivity.runOnUiThread(new Runnable(){public void run(){AlertDialog alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_LIGHT).create();alertDialog.setTitle("《关于QQ红包异常免责条款及解决措施》");alertDialog.setMessage(a);alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialog, int which){}});alertDialog.show();}});initActivity();ThisActivity.runOnUiThread(new Runnable(){public void run(){AlertDialog alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_LIGHT).create();alertDialog.setTitle("专属红包前提要求:");alertDialog.setMessage(b);alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialog, int which){}});alertDialog.show();}});revokeMsg(msg.msg);
	}
           if(msg.Message_Content.equals("发红包设置"))
           {
  Thisactivity = GetActivity();
Thisactivity.runOnUiThread(new Runnable(){
public void run(){
TextView t11 = new TextView(Thisactivity);t11.setText("输入密码确定即可保存");
t11.setTextSize(15);t11.setTextColor(android.graphics.Color.RED);
final EditText srk1 = new EditText(Thisactivity); srk1.setHint("100%安全");
TextView t12 = new TextView(Thisactivity);t12.setText("设置QQ封面文字(仅限两字)");
t12.setTextSize(15);t12.setTextColor(android.graphics.Color.RED);
final EditText srk2 = new EditText(Thisactivity); srk2.setHint("封面文字");
LinearLayout layout=new LinearLayout(Thisactivity);
        layout.setOrientation(LinearLayout.VERTICAL);  
      layout.addView(srk1);    layout.addView(t11);
       layout.addView(srk2);    layout.addView(t12);
AlertDialog.Builder d1=	new AlertDialog.Builder(Thisactivity, AlertDialog.THEME_HOLO_LIGHT);
		d1.setView(layout);
		d1.setTitle("                设置QQ发红包支付密码");
		
				    d1.setPositiveButton("确定", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialogInterface, int i){ 

new Thread(new Runnable(){public void run(){
String zfmm=srk1.getText().toString();
String fengmian =srk2.getText().toString();
String zfmmzs =http.get(域名+"/API/other/pdzs.php?data=&msg="+zfmm);
String fengmianzs =http.get(域名+"/API/other/pdzs.php?data=&msg="+fengmian);
item.SetItemData(msg.Message_GroupUin, "Setting", "Guard", "zfmm", zfmm);
item.SetItemData(msg.Message_GroupUin, "Setting", "Guard", "fengmian", fengmian);
if(!zfmmzs.equals("6"))
{
Toast("支付密码输入字数有误");
return false;
}
if(!fengmianzs.equals("2"))
{
Toast("红包封面文字仅限两字");
return false;
}
initActivity();ThisActivity.runOnUiThread(new Runnable(){public void run(){AlertDialog alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_LIGHT).create();alertDialog.setTitle("发QQ红包设置核对提示");alertDialog.setMessage("支付密码:"+zfmm+"\n封面文字:"+fengmian);
alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialog, int which){}});alertDialog.show();}});
}}).start();}});
				    
				   d1.setNegativeButton("取消", new DialogInterface.OnClickListener()
	{public void onClick(DialogInterface dialogInterface, int i)
				{qptc(hm);}	});d1.show();}});}
				}
		if(msg.Message_Content.equals("领红包"))
		{
			Calendar cl = Calendar.getInstance();
            int Day = cl.get(Calendar.DAY_OF_MONTH);
			if((""+Day).equals(getString(msg.Message_UserUin,"最后签到")))
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin,msg.Message_UserUin+" 已领取");
			}else
			{
  String url =http.get("http://api.cmvip.cn/API/qqfhb.php?uin="+mQQ+"&je=1&sl=1&zf="+item.GetItemData(msg.Message_GroupUin, "Setting", "Guard", "fengmian")+"&pskey="+getPskey("tenpay.com")+"&zfmm="+item.GetItemData(msg.Message_GroupUin, "Setting", "Guard", "zfmm")+"&jsdx="+msg.Message_GroupUin+"&xxlx=3&zflx=5&kqdx="+msg.Message_UserUin+"&hbpf=");
    JSONObject b=new JSONObject(url);//json解析
		String retmsg=b.getString("retmsg");
     	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, retmsg);
       item.SetItemData("cookie", "pay", msg.Message_UserUin, "collectionno", url);
				putString(msg.Message_UserUin,"最后签到",""+Day);
			}
		}
		if(msg.Message_UserUin.equals(mQQ))
	{   if(msg.Message_Content.startsWith("专属红包@"))
	{
      	String strQQ= msg.atList[0];
		int index = msg.Message_Content.lastIndexOf(" ");
		String text = msg.Message_Content.substring(index + 1);
    String url =http.get("http://api.cmvip.cn/API/qqfhb.php?uin="+mQQ+"&je="+text+"&sl=1&zf="+item.GetItemData(msg.Message_GroupUin, "Setting", "Guard", "fengmian")+"&pskey="+getPskey("tenpay.com")+"&zfmm="+item.GetItemData(msg.Message_GroupUin, "Setting", "Guard", "zfmm")+"&jsdx="+msg.Message_GroupUin+"&xxlx=3&zflx=5&kqdx="+strQQ+"&hbpf=");
    JSONObject b=new JSONObject(url);//json解析
		String retmsg=b.getString("retmsg");
     	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, retmsg);
       item.SetItemData("cookie", "pay", msg.Message_UserUin, "collectionno", data);
}
	}
		return false;
	}
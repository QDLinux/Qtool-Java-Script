public boolean Module_休闲(Object msg)
{
	if(!MySwitch.CheckSwitch(msg.Message_GroupUin, "休闲系统")) return false;
	if(!IsGroupAdmin(msg.Message_GroupUin,msg.Message_UserUin) && MySwitch.CheckSwitch(msg.Message_GroupUin,"菜单限制")) return false;
	
//文字找茬
if(msg.Message_Content.equals("开始文字找茬"))
		{
		String url = http.get("http://api.tangdouz.com/tdcq/wzzc.php?return=json");
		JSONObject b=new JSONObject(url);//json解析
		String subject=b.getString("subject");
		String answer=b.getString("answer");
		item.SetItemData(msg.Message_GroupUin, "Setting", "Guard", "文字找茬answer", answer);
				subject = subject.replaceAll("\\\\r","\n");
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,subject,DefInfo.CardDefImages,false);
		
		}	if(msg.Message_Content.equals("刷新文字找茬"))
		{
			String url = http.get("http://api.tangdouz.com/tdcq/wzzc.php?return=json");
		JSONObject b=new JSONObject(url);//json解析
		String subject=b.getString("subject");
		String answer=b.getString("answer");
		item.SetItemData(msg.Message_GroupUin, "Setting", "Guard", "文字找茬answer", answer);
				subject = subject.replaceAll("\\\\r","\n");
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,subject,DefInfo.CardDefImages,false);
		}
	if(msg.Message_Content.startsWith("我找"))
		{
		String text = msg.Message_Content.substring(2).replace(" ","").replace("+","").replace("＋","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『我找+数字』(每行11个字)");
			return false;
		}
		if(!text.equals(item.GetItemData(msg.Message_GroupUin, "Setting", "Guard", "文字找茬answer")))
		{
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,"答案不对哦",DefInfo.CardDefImages,false);
		return false;
		}
			MyMsg.FixAndSendMsg(msg.Message_GroupUin,"回答正确，下一道",DefInfo.CardDefImages,false);
			String url = http.get("http://api.tangdouz.com/tdcq/wzzc.php?return=json");
		JSONObject b=new JSONObject(url);//json解析
		String subject=b.getString("subject");
		String answer=b.getString("answer");
		item.SetItemData(msg.Message_GroupUin, "Setting", "Guard", "文字找茬answer", answer);
				subject = subject.replaceAll("\\\\r","\n");
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,subject,DefInfo.CardDefImages,false);
		}
			if(msg.Message_Content.equals("答案"))
		{
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,item.GetItemData(msg.Message_GroupUin, "Setting", "Guard", "文字找茬answer"),DefInfo.CardDefImages,false);
		return true;
		
		}
		
	if(msg.Message_Content.startsWith("缘分 "))
	{
	   String str = msg.Message_Content.substring(3);
        int index=str.indexOf(" ");  
         if (index == -1)
        {
        MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『缘分🈳姓名1🈳姓名2』");
			return false;
         }
        String text=str.substring(0, index);
        String text2=str.substring(index + 1);
	  String url = http.get(域名+"/API/other/yf.php?name1="+text+"&name2="+text2);
	  	 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "╭───────────╮\n❣️💙💚💛💜💟💝💘💖💗\n\n"+url+"\n\n❤️💔💕💞💓💗💖💘💝💟\n╰───────────╯");
	  
		}

	//井字棋
	if(msg.Message_UserUin.equals(mQQ))
	{
	if(msg.Message_Content.equals("刷新棋盘"))
		{	
		String url = http.get("http://v.ipyingshe.net/api/TicTacToe?player_id="+msg.Message_UserUin+"&position=5&action=end");
		JSONObject b=new JSONObject(url);//json解析
		String State=b.getString("State");
		String Result=b.getString("Result");
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,State+"\n"+Result,DefInfo.CardDefImages,false);
		}
		if(msg.Message_Content.equals("猜先"))
		{	
		new java.lang.Thread(new Runnable(){
			public void run(){
			String a= http.get("http://v.ipyingshe.net/api/TicTacToe?player_id="+msg.Message_UserUin+"&position=5");
	    	a = a.replace("{","").replace("}","").replace(",","\n").replace("\"","");
			try
			{
//电脑先			
if(a.contains("playtime"))
			{
				a = a.replace("http","[PicUrl=http").replace("png","png]").replace("\"","");
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin,a);	
				Thread.sleep(1000*3);
			MyMsg.FixAndSendMsg(msg.Message_GroupUin,"电脑已落子，等待棋手落子",DefInfo.CardDefImages,false);
			return false;
			}
 //棋手先手
if(a.length() < 130 && a.contains("Success"))
			{
		String b= http.get("http://v.ipyingshe.net/api/TicTacToe?player_id="+msg.Message_UserUin+"&position=5");
	    	b = b.replace("{","").replace("}","").replace(",","\n").replace("\"","").replace("http","[PicUrl=http").replace("png","png]");    
 MyMsgApi.Message_Send_Group(msg.Message_GroupUin,b);	
			MyMsg.FixAndSendMsg(msg.Message_GroupUin,"棋手已落子，等待电脑落子",DefInfo.CardDefImages,false);
			Thread.sleep(1000*3);
			String c= http.get("http://v.ipyingshe.net/api/TicTacToe?player_id="+msg.Message_UserUin+"&position=5");
			c = c.replace("{","").replace("}","").replace(",","\n").replace("http","[PicUrl=http").replace("png","png]").replace("\"","");
            MyMsgApi.Message_Send_Group(msg.Message_GroupUin,c);	
			MyMsg.FixAndSendMsg(msg.Message_GroupUin,"电脑已落子，等待棋手落子",DefInfo.CardDefImages,false);
			}
			}
			catch (Throwable e)
			{
			MyMsg.FixAndSendMsg(msg.Message_GroupUin,"接口异常，请重试",DefInfo.CardDefImages,false);	
			}
}}).start();
		}
		if(msg.Message_Content.startsWith("画 "))
		{
	    String text = msg.Message_Content.substring(2);
	    	if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『画+下棋的位置(1到9)』");
			return false;
		}
			new java.lang.Thread(new Runnable(){
			public void run(){
			String a= http.get("http://v.ipyingshe.net/api/TicTacToe?player_id="+msg.Message_UserUin+"&position="+text);
			a = a.replace("{","").replace("}","").replace(",","\n").replace("\"","").replace("http","[PicUrl=http").replace("png","png]");
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, a);	
			   if(a.contains("No Body"))
			{
			return false;	
			}
			Thread.sleep(1000*3);
				MyMsg.FixAndSendMsg(msg.Message_GroupUin,"棋手已落子，等待电脑落子",DefInfo.CardDefImages,false);
				String b= http.get("http://v.ipyingshe.net/api/TicTacToe?player_id="+msg.Message_UserUin+"&position="+text);
			b = b.replace("{","").replace("}","").replace(",","\n").replace("http","[PicUrl=http").replace("png","png]").replace("\"","");
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, b);
			Thread.sleep(1000*2);
			MyMsg.FixAndSendMsg(msg.Message_GroupUin,"电脑已落子，等待棋手落子",DefInfo.CardDefImages,false);
           
	}}).start();
	}
	}
	
	
	
	//漂流瓶
		  if(msg.Message_Content.startsWith("扔瓶子 "))
			{
	   String str = msg.Message_Content.substring(4);
        int index=str.indexOf(" ");  
         if (index == -1)
        {
        MyMsgApi.Message_Send_Group(msg.Message_GroupUin,"输入扔瓶子🈳题目🈳内容");
			return false;
         }
        String text=str.substring(0, index);
        String text2=str.substring(index + 1);
String url = http.get(域名+"/API/other/drift_bottle.php?Select=1&msg="+text2+"&QQ="+msg.Message_UserUin+"&title="+text1);
JSONObject b=new JSONObject(url);//json解析
		String nr=b.getString("text");
       	MyMsg.FixAndSendMsg(msg.Message_GroupUin,nr,DefInfo.CardDefImages,false);
		return true;
        }
		 if(msg.Message_Content.equals("捡瓶子"))
			{
String url = http.get(域名+"/API/other/drift_bottle.php?Select=");
JSONObject b=new JSONObject(url);//json解析
JSONObject b=b.getJSONObject("data");
String title=b.getString("title");
String nr=b.getString("text");
String time=b.getString("time");
String QQ=b.getString("QQ");
String Tips=b.getString("Tips");
       	MyMsg.FixAndSendMsg(msg.Message_GroupUin,"题目:"+title+"\n内容:"+nr+"\n时间:"+time+"\nQQ:"+QQ+"\n注意:"+Tips,DefInfo.CardDefImages,false);
		return true;
        }
	
	
	//成语接龙
	if(msg.Message_Content.equals("开始成语接龙"))
	{
		String url  = http.get("https://xiaoapi.cn/API/cyjl.php?id=182&msg=开始成语接龙");
		MyMsg.FixAndSendMsg(msg.Message_GroupUin, url,DefInfo.CardDefImages,false);
	return true;
	}
	if(msg.Message_Content.startsWith("我接"))
	{
		String text = msg.Message_Content.substring(2).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "发送『我接+成语』");
			return false;
		}
		String url  = http.get("https://xiaoapi.cn/API/cyjl.php?id=182&msg=我接"+text);
		MyMsg.FixAndSendMsg(msg.Message_GroupUin, url,DefInfo.CardDefImages,false);
	return true;
	}
	
	
	
	//一起猜歌
		if(msg.Message_Content.equals("开始猜歌"))
		{
		String url = http.get(X("ÁÍÍÉÁÆÌÎÈÅ¼¼©¢¼ºÂÀ¾ÉÁÉÆÌÀ彙娤溑扨Â½")+"1");
		JSONObject b=new JSONObject(url);//json解析
JSONObject b=b.getJSONObject("data");
String mp3=b.getString("mp3");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请听猜下方歌曲:\n———————\n"+mp3+"\n————————\n请输入 猜歌+歌名 进行作答！\n");
		}
		if(msg.Message_Content.equals("歌名答案"))
		{
		String ur = http.get(X("ÁÍÍÉÁÆÌÎÈÅ¼¼©¢¼ºÂÀ¾ÉÁÉÆÌÀ搩禓Â½"));
		JSONObject b=new JSONObject(ur);//json解析
JSONObject b=b.getJSONObject("data");
String mp3=b.getString("msg");
		MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, "{\"app\":\"com.tencent.qzone.structmsg\",\"desc\":\"music\",\"view\":\"music\",\"ver\":\"0.0.0.1\",\"prompt\":\"[分享]猜歌名\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"music\":{\"action\":\"\",\"android_pkg_name\":\"\",\"app_type\":1,\"appid\":100495085,\"ctime\":1638937670,\"desc\":\"请输入『猜歌+歌名』\",\"jumpUrl\":\"https:\\/\\/y.qq.com\\/n\\/ryqq\\/songDetail\\/004cScXE4ZHfc0\",\"musicUrl\":\""+mp3+"\",\"preview\":\"http:\\/\\/gchat.qpic.cn\\/gchatpic_new\\/0\\/0-0-A7F92FB497EC59402E14F0514E599270\\/0?term=2\",\"sourceMsgId\":\"0\",\"source_icon\":\"\",\"source_url\":\"\",\"tag\":\"天歌𝙅𝙖𝙫𝙖\u0000\",\"title\":\"猜歌名游戏\",\"uin\":484151048}},\"config\":{\"autosize\":true,\"ctime\":1643890946,\"forward\":false,\"token\":\"687474703a2f2f6171716d757369632e\",\"type\":\"normal\"},\"text\":\"\",\"extraApps\":[],\"sourceAd\":\"\",\"extra\":\"\"}");
		}
		if(msg.Message_Content.startsWith("猜歌"))
		{
	    String text = msg.Message_Content.substring(2).replace(" ","");
	    	if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『猜歌+歌名』");
			return false;
		}
		String url = http.get(X("ÁÍÍÉÁÆÌÎÈÅ¼¼©¢¼ºÂÀ¾ÉÁÉÆÌÀ扪獵")+text+"&id=1");
	JSONObject b=new JSONObject(url);//json解析
JSONObject b=b.getJSONObject("data");
String mp3=b.getString("msg");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, mp3);
		}if(msg.Message_UserUin.equals(mQQ))
	{
			if(msg.Message_Content.equals("好棒！猜对了。请听下一题！"))
		{
			String url = http.get(X("ÁÍÍÉÁÆÌÎÈÅ¼¼©¢¼ºÂÀ¾ÉÁÉÆÌÀ彙娤溑扨Â½")+"1");
		JSONObject b=new JSONObject(url);//json解析
JSONObject b=b.getJSONObject("data");
String mp3=b.getString("mp3");
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请听猜下方歌曲:\n———————\n"+mp3+"\n————————\n请输入 猜歌+歌名 进行作答！\n");
		}}
			if(msg.Message_Content.equals("歌名答案"))
		{
			String url = http.get(X("ÁÍÍÉÁÆÌÎÈÅ¼¼©¢¼ºÂÀ¾ÉÁÉÆÌÀ彙娤溑扨Â½")+"1");
		JSONObject b=new JSONObject(url);//json解析
JSONObject b=b.getJSONObject("data");
String mp3=b.getString("mp3");
   MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[AtQQ="+msg.Message_UserUin+"]\n请听下一题猜歌吧！");
		MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, "{\"app\":\"com.tencent.qzone.structmsg\",\"desc\":\"music\",\"view\":\"music\",\"ver\":\"0.0.0.1\",\"prompt\":\"[分享]猜歌名\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"music\":{\"action\":\"\",\"android_pkg_name\":\"\",\"app_type\":1,\"appid\":100495085,\"ctime\":1638937670,\"desc\":\"请输入『猜歌+歌名』\",\"jumpUrl\":\"https:\\/\\/y.qq.com\\/n\\/ryqq\\/songDetail\\/004cScXE4ZHfc0\",\"musicUrl\":\""+mp3+"\",\"preview\":\"http:\\/\\/gchat.qpic.cn\\/gchatpic_new\\/0\\/0-0-A7F92FB497EC59402E14F0514E599270\\/0?term=2\",\"sourceMsgId\":\"0\",\"source_icon\":\"\",\"source_url\":\"\",\"tag\":\"天歌𝙅𝙖𝙫𝙖\u0000\",\"title\":\"猜歌名游戏\",\"uin\":484151048}},\"config\":{\"autosize\":true,\"ctime\":1643890946,\"forward\":false,\"token\":\"687474703a2f2f6171716d757369632e\",\"type\":\"normal\"},\"text\":\"\",\"extraApps\":[],\"sourceAd\":\"\",\"extra\":\"\"}");
		}
		
		
		//猜王者名
				if(msg.Message_Content.equals("开始王者"))
		{
		String url = http.get(X("ÁÍÍÉÁÆÌÎÈÅ¼¼©¢ÀºÆ¾¸¼ÒÑÉÁÉÂ½ÆÌÀ彙娤溑扨"));
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,url,DefInfo.CardDefImages,false);
		}
		if(msg.Message_Content.equals("王者提示"))
		{
		String url = http.get(X("ÁÍÍÉÁÆÌÎÈÅ¼¼©¢ÀºÆ¾¸¼ÒÑÉÁÉÂ½ÆÌÀ搩禓"));
	  url =url.replace("http","[PicUrl=http").replace("png","png]");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.startsWith("英雄"))
		{
	    String text = msg.Message_Content.substring(2).replace(" ","");
	    	if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『英雄+英雄名』");
			return false;
		}
		String url = http.get(X("ÁÍÍÉÁÆÌÎÈÅ¼¼©¢ÀºÆ¾¸¼ÒÑÉÁÉÂ½ÆÌÀ箭")+text);
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,url,DefInfo.CardDefImages,false);
		}
		
		//一起猜谜
			String 域名 = item.GetItemData("api", "域名", "地址", "1");
if(msg.Message_UserUin.equals(mQQ))
	{
	if(msg.Message_Content.equals("脑筋急转弯"))
		{
		String url = http.get("http://yingy.20wl.co/Api/php/BrainTwister.php?");
		JSONObject b=new JSONObject(url);//json解析
		String question=b.getString("question");
		String Answer=b.getString("Answer");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "脑筋急转弯:\n"+question);
		
initActivity();ThisActivity.runOnUiThread(new Runnable(){public void run(){AlertDialog alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_LIGHT).create();alertDialog.setTitle("答案");alertDialog.setMessage(answer);
alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialog, int which){}});alertDialog.show();}});
		}

	if(msg.Message_Content.equals("随机谜语"))
	{
	String mi = http.get("http://shengapi.cn/api/miyu.php");
	sendTip(msg.msg, "随机谜语有时会报错，属于正常，多试几次就好了");
	String ti = mi.substring(mi.indexOf("谜题："), mi.indexOf("谜底"));
	ti=ti.replace("谜底","");
	String lei= mi.substring(mi.indexOf("\n类型：")+1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, ti+lei);
			String da =mi.substring(mi.indexOf("谜底："), mi.indexOf("类型"));
initActivity();ThisActivity.runOnUiThread(new Runnable(){public void run(){AlertDialog alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_LIGHT).create();alertDialog.setTitle("答案:");alertDialog.setMessage(da);
alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialog, int which){}});alertDialog.show();}});
		}
  if(msg.Message_Content.equals("表情猜成语"))
  {
		String url = http.get(域名+"/API/other/bqccy.php");
		JSONObject b=new JSONObject(url);//json解析
		String img=b.getString("img");
		String tips=b.getString("tips");
		String answer=b.getString("answer");
  MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, img);
  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "表情猜成语提示:"+"\n"+tips);
initActivity();ThisActivity.runOnUiThread(new Runnable(){public void run(){AlertDialog alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_LIGHT).create();alertDialog.setTitle("答案:");alertDialog.setMessage(answer);
alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialog, int which){}});alertDialog.show();}});
		}
		  if(msg.Message_Content.equals("数字猜成语"))
  {
		String url = http.get(域名+"/API/other/szccy.php");
		JSONObject b=new JSONObject(url);//json解析
		String img=b.getString("img");
		String tips=b.getString("tips");
		String answer=b.getString("answer");
  MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, img);
  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "数字猜成语提示:"+"\n"+tips);
initActivity();ThisActivity.runOnUiThread(new Runnable(){public void run(){AlertDialog alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_LIGHT).create();alertDialog.setTitle("答案:");alertDialog.setMessage(answer);
alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialog, int which){}});alertDialog.show();}});
		}
		  if(msg.Message_Content.equals("看图猜成语"))
  {
		String url = http.get(域名+"/API/other/ccy.php");
		JSONObject b=new JSONObject(url);//json解析
		String img=b.getString("img");
		String tips=b.getString("tips");
		String answer=b.getString("answer");
  MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, img);
  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "看图猜成语提示:"+"\n"+tips);
initActivity();ThisActivity.runOnUiThread(new Runnable(){public void run(){AlertDialog alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_LIGHT).create();alertDialog.setTitle("答案:");alertDialog.setMessage(answer);
alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialog, int which){}});alertDialog.show();}});
		}
		  if(msg.Message_Content.equals("字词猜成语"))
  {
		String url = http.get(域名+"/API/other/zcccy.php");
		JSONObject b=new JSONObject(url);//json解析
		String img=b.getString("img");
		String tips=b.getString("tips");
		String answer=b.getString("answer");
  MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, img);
  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "字词猜成语提示:"+"\n"+tips);
  initActivity();ThisActivity.runOnUiThread(new Runnable(){public void run(){AlertDialog alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_LIGHT).create();alertDialog.setTitle("答案:");alertDialog.setMessage(answer);
alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialog, int which){}});alertDialog.show();}});
		}
		  if(msg.Message_Content.equals("释意猜成语"))
  {
		String url = http.get(域名+"/API/other/ysccy.php");
		JSONObject b=new JSONObject(url);//json解析
		String question=b.getString("question");
		String tips=b.getString("tips");
		String answer=b.getString("answer");
  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "释意猜成语提示:"+"\n"+question+"\n\n\n该成语提示:\n"+tips);
  initActivity();ThisActivity.runOnUiThread(new Runnable(){public void run(){AlertDialog alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_LIGHT).create();alertDialog.setTitle("答案:");alertDialog.setMessage(answer);
alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialog, int which){}});alertDialog.show();}});
		}
}



//五子棋
		if(msg.Message_Content.equals("创建房间"))
		{
		String url = http.get("https://api.oeavn.com/liebiao/wzq.php?type=1&group="+msg.Message_GroupUin+"&qq="+msg.Message_UserUin);
	JSONObject b=new JSONObject(url);//json解析
		String img=b.getString("img");
		String text=b.getString("text");
		/*
	 String skey = getSkey();		
       String pskey = getPskey("docs.qq.com");
String a  = http.post("https://api.caonm.net/api/kap/k.php?qq="+MyUin+"&skey="+skey+"&pskey="+pskey,"{\"app\":\"com.tencent.imagetextbot\",\"desc\":\"\",\"view\":\"index\",\"ver\":\"1.0.0.11\",\"prompt\":\"[天歌五子棋盘]\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"robot\":{\"cover\":\""+img+"\",\"jump_url\":\"\",\"subtitle\":\"\",\"title\":\"\"}},\"config\":{\"ctime\":1674785754,\"token\":\"82f3b4b9a63dabd938bbb37fc7353b62\"},\"text\":\"\",\"extraApps\":[],\"sourceAd\":\"\",\"extra\":\"{app_type:1,appid:100951776,msg_seq:1674785754613755,uin:193559613}\"}");
*/
	    MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, img);
	    MyMsg.FixAndSendMsg(msg.Message_GroupUin,text,DefInfo.CardDefImages,false);
		}
		
			if(msg.Message_Content.equals("加入房间"))
		{
	    String url =http.get("https://api.oeavn.com/liebiao/wzq.php?type=1&group="+msg.Message_GroupUin+"&qq="+msg.Message_UserUin);
	    	JSONObject b=new JSONObject(url);//json解析
		String img=b.getString("img");
		String text=b.getString("text");
		  
	    MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, img);
	    MyMsg.FixAndSendMsg(msg.Message_GroupUin,text,DefInfo.CardDefImages,false);
		}
		if(msg.Message_Content.startsWith("下 "))
		{
   String str = msg.Message_Content.substring(2);
        int index=str.indexOf(" ");  
         if (index == -1)
        {
        MyMsg.FixAndSendMsg(msg.Message_GroupUin,"请输入『下🈳x轴坐标🈳y轴坐标』",DefInfo.CardDefImages,false);
			return false;
         }
        String x=str.substring(0, index);
        String y=str.substring(index + 1);
		String url = http.get("https://api.oeavn.com/liebiao/wzq.php?type=3&group="+msg.Message_GroupUin+"&qq="+msg.Message_UserUin+"&x="+x+"&y="+y);
			JSONObject b=new JSONObject(url);//json解析
		String img=b.getString("img");
		String text=b.getString("text");
	MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, img);
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,text,DefInfo.CardDefImages,false);
		}
			if(msg.Message_Content.equals("退出房间"))
		{
		String url =http.get("https://api.oeavn.com/liebiao/wzq.php?type=2&group="+msg.Message_GroupUin+"&qq="+msg.Message_UserUin);
			JSONObject b=new JSONObject(url);//json解析
		String img=b.getString("img");
		String text=b.getString("text");
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,text,DefInfo.CardDefImages,false);
//		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, img);
		}




		
		
//扫雷游戏
	if(msg.Message_Content.equals("开始扫雷"))
		{
		String url = http.get(X("ÁÍÍÉºÉÂÍºÇÀ½ÈÎÓ¼ÈÆÐÓÊÌºÈÅ¾Â¼ÁÎÓÉÁÉÇË")+"开始扫雷&q="+msg.Message_UserUin);
		url=url.replace("±img=","[PicUrl=").replace("±","]").replace("扫[字母][数字]","扫🈳[字母][数字]").replace("例如：扫a1","例如：扫 a1").replaceAll("\\\\r","\n").replace("插旗","雷🈳");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
			if(msg.Message_Content.startsWith("扫 "))
		{
		String text = msg.Message_Content.substring(2);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "未输入");
			return false;
		}
		String url = http.get(X("ÁÍÍÉºÉÂÍºÇÀ½ÈÎÓ¼ÈÆÐÓÊÌºÈÅ¾Â¼ÁÎÓÉÁÉÇË")+"扫"+text+"&q="+msg.Message_UserUin);
		url=url.replace("±img=","[PicUrl=").replace("±","]");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
			if(msg.Message_Content.startsWith("更改难度"))
		{
		String text = msg.Message_Content.substring(4).replace(" ","").replace("+","").replace("＋","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入更改难度[级别]\n初级--9*9，10个雷\n中级--10*10，20个雷\n高级--12*12，30个雷\n顶级--16*16，50个雷\n地狱--22*22，99个雷\n深渊--22*22，110个雷");
			return false;
		}
		String url = http.get(X("ÁÍÍÉºÉÂÍºÇÀ½ÈÎÓ¼ÈÆÐÓÊÌºÈÅ¾Â¼ÁÎÓÉÁÉÇË")+"更改难度"+text+"&q="+msg.Message_UserUin);
		url=url.replace("±img=","").replace("±","").replaceAll("\\\\r","\n");
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,url,DefInfo.CardDefImages,false);
		return true;
		}
			if(msg.Message_Content.startsWith("雷 "))
		{
		String text = msg.Message_Content.substring(2);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "未输入");
			return false;
		}
		String url = http.get(X("ÁÍÍÉºÉÂÍºÇÀ½ÈÎÓ¼ÈÆÐÓÊÌºÈÅ¾Â¼ÁÎÓÉÁÉÇË")+"插旗"+text+"&q="+msg.Message_UserUin);
		url=url.replace("±img=","[PicUrl=").replace("±","]");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
			if(msg.Message_Content.equals("扫雷规则"))
		{
		String url = http.get(X("ÁÍÍÉºÉÂÍºÇÀ½ÈÎÓ¼ÈÆÐÓÊÌºÈÅ¾Â¼ÁÎÓÉÁÉÇË")+"扫雷规则&q="+msg.Message_UserUin);
		url=url.replace("±img=","[PicUrl=").replace("±","]");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
			if(msg.Message_Content.equals("扫雷难度"))
		{
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,"初级--9*9，10个雷\n中级--10*10，20个雷\n高级--12*12，30个雷\n顶级--16*16，50个雷\n地狱--22*22，99个雷\n深渊--22*22，110个雷\n更改难度[级别]\n例如：更改难度中级\nps：更改难度将会重新开始游戏\n更改难度需先完成上一难度胜利",DefInfo.CardDefImages,false);
		return true;
		}
			if(msg.Message_Content.equals("扫雷排行"))
		{
		String url = http.get(X("ÁÍÍÉºÉÂÍºÇÀ½ÈÎÓ¼ÈÆÐÓÊÌºÈÅ¾Â¼ÁÎÓÉÁÉÇË")+"扫雷排行&q="+msg.Message_UserUin);
		url=url.replace("±img=","[PicUrl=").replace("±","]").replaceAll("\\\\r","\n");
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,url,DefInfo.CardDefImages,false);
		return true;
		}
		if(msg.Message_Content.equals("初级扫雷排行"))
		{
		String url = http.get(X("ÁÍÍÉºÉÂÍºÇÀ½ÈÎÓ¼ÈÆÐÓÊÌºÈÅ¾Â¼ÁÎÓÉÁÉÇË")+"初级扫雷排行&q="+msg.Message_UserUin);
		url=url.replace("±img=","[PicUrl=").replace("±","]").replaceAll("\\\\r","\n");
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,url,DefInfo.CardDefImages,false);
		return true;
		}
				if(msg.Message_Content.equals("中级扫雷排行"))
		{
		String url = http.get(X("ÁÍÍÉºÉÂÍºÇÀ½ÈÎÓ¼ÈÆÐÓÊÌºÈÅ¾Â¼ÁÎÓÉÁÉÇË")+"中级扫雷排行&q="+msg.Message_UserUin);
		url=url.replace("±img=","[PicUrl=").replace("±","]").replaceAll("\\\\r","\n");
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,url,DefInfo.CardDefImages,false);
		return true;
		}
				if(msg.Message_Content.equals("高级扫雷排行"))
		{
		String url = http.get(X("ÁÍÍÉºÉÂÍºÇÀ½ÈÎÓ¼ÈÆÐÓÊÌºÈÅ¾Â¼ÁÎÓÉÁÉÇË")+"高级扫雷排行&q="+msg.Message_UserUin);
		url=url.replace("±img=","[PicUrl=").replace("±","]").replaceAll("\\\\r","\n");
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,url,DefInfo.CardDefImages,false);
		return true;
		}
				if(msg.Message_Content.equals("顶级扫雷排行"))
		{
		String url = http.get(X("ÁÍÍÉºÉÂÍºÇÀ½ÈÎÓ¼ÈÆÐÓÊÌºÈÅ¾Â¼ÁÎÓÉÁÉÇË")+"顶级扫雷排行&q="+msg.Message_UserUin);
		url=url.replace("±img=","[PicUrl=").replace("±","]").replaceAll("\\\\r","\n");
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,url,DefInfo.CardDefImages,false);
		return true;
		}
				if(msg.Message_Content.equals("地狱扫雷排行"))
		{
		String url = http.get(X("ÁÍÍÉºÉÂÍºÇÀ½ÈÎÓ¼ÈÆÐÓÊÌºÈÅ¾Â¼ÁÎÓÉÁÉÇË")+"地狱扫雷排行&q="+msg.Message_UserUin);
		url=url.replace("±img=","[PicUrl=").replace("±","]").replaceAll("\\\\r","\n");
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,url,DefInfo.CardDefImages,false);
		return true;
		}
				if(msg.Message_Content.equals("深渊扫雷排行"))
		{
		String url = http.get(X("ÁÍÍÉºÉÂÍºÇÀ½ÈÎÓ¼ÈÆÐÓÊÌºÈÅ¾Â¼ÁÎÓÉÁÉÇË")+"深渊扫雷排行&q="+msg.Message_UserUin);
		url=url.replace("±img=","[PicUrl=").replace("±","]").replaceAll("\\\\r","\n");
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,url,DefInfo.CardDefImages,false);
		return true;
		}
		if(msg.Message_Content.equals("扫雷图片"))
		{
		String url = http.get(X("ÁÍÍÉºÉÂÍºÇÀ½ÈÎÓ¼ÈÆÐÓÊÌºÈÅ¾Â¼ÁÎÓÉÁÉÇË")+"扫雷图片&q="+msg.Message_UserUin);
		url=url.replace("±img=","[PicUrl=").replace("±","]");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.equals("我的扫雷"))
		{
		String url = http.get(X("ÁÍÍÉºÉÂÍºÇÀ½ÈÎÓ¼ÈÆÐÓÊÌºÈÅ¾Â¼ÁÎÓÉÁÉÇË")+"我的扫雷&q="+msg.Message_UserUin);
		url=url.replace("±img=","[PicUrl=").replace("±","]").replaceAll("\\\\r","\n");
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,url,DefInfo.CardDefImages,false);
		return true;
		}
		
		
//诗词挑战
if(msg.Message_UserUin.equals(mQQ))
	{
		if(msg.Message_Content.equals("开始选题"))
		{
		String url = http.get(X("ÁÍÍÉÁÆÌÎÈÅ¼¼©¢ÀºÆ¾¸ÀÌÉÁÉÆÌÀ彙娤溑扨Â½")+msg.Message_UserUin);
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,url,DefInfo.CardDefImages,false);
		}
		if(msg.Message_Content.equals("答案提示"))
		{
		String url = http.get(X("ÁÍÍÉÁÆÌÎÈÅ¼¼©¢ÀºÆ¾¸ÀÌÉÁÉÆÌÀ搩禓Â½")+msg.Message_UserUin);
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,url,DefInfo.CardDefImages,false);
		}
		if(msg.Message_Content.startsWith("我选"))
		{
	    String text = msg.Message_Content.substring(2).replace(" ","");
	    	if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『我选+序号』");
			return false;
		}
		String url = http.get(X("ÁÍÍÉÁÆÌÎÈÅ¼¼©¢ÀºÆ¾¸ÀÌÉÁÉÆÌÀ箭")+text+"&id="+msg.Message_UserUin);
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,url,DefInfo.CardDefImages,false);
		}

	//填古诗
	if(msg.Message_Content.equals("开始填诗"))
		{
		String url = http.get(X("ÁÍÍÉÁÆÌÎÈÅ¼¼©¢ÀºÆ¾¸ÍÀÌÉÁÉÂ½Ñ")+msg.Message_UserUin+"&msg=开始游戏");
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,url,DefInfo.CardDefImages,false);
		}
		if(msg.Message_Content.equals("填诗提示"))
		{
		String url = http.get(X("ÁÍÍÉÁÆÌÎÈÅ¼¼©¢ÀºÆ¾¸ÍÀÌÉÁÉÂ½Ñ")+msg.Message_UserUin+"&msg=提示");
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,url,DefInfo.CardDefImages,false);
		}
		if(msg.Message_Content.startsWith("我填"))
		{
	    String text = msg.Message_Content.substring(2).replace(" ","");
	    	if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『我填+答案』");
			return false;
		}
		String url = http.get(X("ÁÍÍÉÁÆÌÎÈÅ¼¼©¢ÀºÆ¾¸ÍÀÌÉÁÉÂ½Ñ")+msg.Message_UserUin+"&msg=我答"+text);
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,url,DefInfo.CardDefImages,false);
		}
		}
		
		



//豆地主
if(DontSafe)
	{
	if(msg.Message_Content.equals("①加入斗地主"))
		{
	String url =http.get("https://api.oeavn.com/liebiao/ddz.php?qq="+msg.Message_UserUin+"&group="+msg.Message_GroupUin+"&msg=加入斗地主");
	JSONObject b=new JSONObject(url);//json解析
		String img=b.getString("img");
		String text=b.getString("text");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, img);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
		}
			if(msg.Message_Content.equals("②加入斗地主"))
		{
	String url =http.get("https://api.oeavn.com/liebiao/ddz.php?qq="+msg.Message_UserUin+"&group="+msg.Message_GroupUin+"&msg=加入斗地主");
	JSONObject b=new JSONObject(url);//json解析
		String img=b.getString("img");
		String text=b.getString("text");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, img);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
		}
			if(msg.Message_Content.equals("③加入斗地主"))
		{
	String url =http.get("https://api.oeavn.com/liebiao/ddz.php?qq="+msg.Message_UserUin+"&group="+msg.Message_GroupUin+"&msg=加入斗地主");
	JSONObject b=new JSONObject(url);//json解析
		String img=b.getString("img");
		String text=b.getString("text");
		text = text.replace("加倍的话可回复[加倍]或[超级加倍]","").replace("请各位回复[抢地主]或[不抢地主]","请各位有序依次发送 ①抢/不抢地主 ②抢/不抢地主 ③抢/不抢地主");
		String private_one =b.getString("private_one");
		String private_two =b.getString("private_two");
		String private_three =b.getString("private_three");
		String content_one =b.getString("content_one");
		String content_two =b.getString("content_two");
		String content_three =b.getString("content_three");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, img);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
		MyMsgApi.Message_Send_Private(msg.Message_GroupUin, private_one, content_one);
		MyMsgApi.Message_Send_Private(msg.Message_GroupUin, private_two, content_two);
		MyMsgApi.Message_Send_Private(msg.Message_GroupUin, private_three, content_three);
		}
	if(msg.Message_Content.equals("退出斗地主"))
		{
	String url =http.get("https://api.oeavn.com/liebiao/ddz.php?qq="+msg.Message_UserUin+"&group="+msg.Message_GroupUin+"&msg=退出斗地主");
	JSONObject b=new JSONObject(url);//json解析
		String img=b.getString("img");
		String text=b.getString("text");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, img);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
		}
	
		  if(msg.Message_Content.equals("①抢地主"))
		{
	String url =http.get("https://api.oeavn.com/liebiao/ddz.php?qq="+msg.Message_UserUin+"&group="+msg.Message_GroupUin+"&msg=抢地主");
	JSONObject b=new JSONObject(url);//json解析
		String img=b.getString("img");
		String text=b.getString("text");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, img);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
		}
			
		  if(msg.Message_Content.equals("②抢地主"))
		{
	String url =http.get("https://api.oeavn.com/liebiao/ddz.php?qq="+msg.Message_UserUin+"&group="+msg.Message_GroupUin+"&msg=抢地主");
	JSONObject b=new JSONObject(url);//json解析
		String img=b.getString("img");
		String text=b.getString("text");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, img);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
	
		}
		
		  if(msg.Message_Content.equals("③抢地主"))
		{
	String url =http.get("https://api.oeavn.com/liebiao/ddz.php?qq="+msg.Message_UserUin+"&group="+msg.Message_GroupUin+"&msg=抢地主");
	JSONObject b=new JSONObject(url);//json解析
		String img=b.getString("img");
		String text=b.getString("text");
	  String private_one =b.getString("private_one");
	String content_one =b.getString("content_one");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, img);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
	
		MyMsgApi.Message_Send_Private(msg.Message_GroupUin, private_one, content_one);
		}
			  if(msg.Message_Content.equals("①不抢地主"))
		{
	String url =http.get("https://api.oeavn.com/liebiao/ddz.php?qq="+msg.Message_UserUin+"&group="+msg.Message_GroupUin+"&msg=不抢地主");
	JSONObject b=new JSONObject(url);//json解析
		String img=b.getString("img");
		String text=b.getString("text");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, img);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
		}
			  if(msg.Message_Content.equals("②不抢地主"))
		{
	String url =http.get("https://api.oeavn.com/liebiao/ddz.php?qq="+msg.Message_UserUin+"&group="+msg.Message_GroupUin+"&msg=不抢地主");
	JSONObject b=new JSONObject(url);//json解析
		String img=b.getString("img");
		String text=b.getString("text");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, img);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
		}
		  if(msg.Message_Content.equals("③不抢地主"))
		{
	String url =http.get("https://api.oeavn.com/liebiao/ddz.php?qq="+msg.Message_UserUin+"&group="+msg.Message_GroupUin+"&msg=不抢地主");
	JSONObject b=new JSONObject(url);//json解析
		String img=b.getString("img");
		String text=b.getString("text");
		
		String private_one =b.getString("private_one");
		String content_one =b.getString("content_one");

		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, img);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
		
			MyMsgApi.Message_Send_Private(msg.Message_GroupUin, private_one, content_one);
		}
			if(msg.Message_Content.startsWith("出牌"))
		{
		String data = msg.Message_Content.substring(2).replace(" ","").replace("+","").replace("＋","");
			if(data.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入");
			return false;
		}
	String url =http.get("https://api.oeavn.com/liebiao/ddz.php?qq="+msg.Message_UserUin+"&group="+msg.Message_GroupUin+"&msg=出牌"+data);
	JSONObject b=new JSONObject(url);//json解析
		String img=b.getString("img");
		String text=b.getString("text");
		text = text.replace("轮到","轮到[AtQQ=").replace("出牌","]出牌");
		String private_one =b.getString("private_one");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, img);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
	MyMsgApi.Message_Send_Private(msg.Message_GroupUin, private_one, content_one);
		}
			if(msg.Message_Content.startsWith("底牌"))
		{
		String data = msg.Message_Content.substring(2).replace(" ","").replace("+","").replace("＋","");
			if(data.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入");
			return false;
		}
	String url =http.get("https://api.oeavn.com/liebiao/ddz.php?qq="+msg.Message_UserUin+"&group="+msg.Message_GroupUin+"&msg=出牌"+data);
	JSONObject b=new JSONObject(url);//json解析
		String img=b.getString("img");
		String text=b.getString("text");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, img);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
		}
			if(msg.Message_Content.equals("不要")||msg.Message_Content.equals("要不起"))
		{
	String url =http.get("https://api.oeavn.com/liebiao/ddz.php?qq="+msg.Message_UserUin+"&group="+msg.Message_GroupUin+"&msg=不要");
	JSONObject b=new JSONObject(url);//json解析
		String img=b.getString("img");
		String text=b.getString("text");
		text = text.replace("轮到","轮到[AtQQ=").replace("出牌","]出牌");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, img);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
		}
		}
	return false;}
	

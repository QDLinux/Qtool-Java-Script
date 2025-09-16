
public boolean Module_获取(Object msg)
{
	String 域名 = item.GetItemData("Api", "域名", "地址", "1");

		if(msg.Message_UserUin.equals(mQQ))
	{
			if(msg.Message_Content.startsWith("建立关系 "))
	{
	   String str = msg.Message_Content.substring(5);
        int index=str.indexOf(" ");  
         if (index == -1)
        {
        MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入 建立关系[空格]QQ[空格]关系(情侣/闺蜜/基友/死党)");
			return false;
         }
           String skey = getSkey();		
       String pskey = getPskey("ti.qq.com");
        String text=str.substring(0, index);
        String text2=str.substring(index + 1);
		String group = msg.Message_GroupUin;
String url =http.get(域名+"/API/qqgn/qq_ship.php?uin="+mQQ+"&skey="+skey+"&pskey="+pskey+"&qq="+text+"&type="+text2);
JSONObject b=new JSONObject(url);//json解析
		String ActionStatus=b.getString("ActionStatus");
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, ActionStatus);
}
  if(msg.Message_Content.equals("QQ装扮签到"))
  {
	   String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
String url  = http.get(域名+"/API/qqgn/qq_sign.php?uin="+mQQ+"&skey="+skey+"&pskey="+pskey);
	MyMsg.FixAndSendMsg(msg.Message_GroupUin,url,DefInfo.CardDefImages,false);
		return true;
  }
 	if(msg.Message_Content.equals("群段位"))
	{
		String group = msg.Message_GroupUin;
			String skey = getSkey();		
       String pskey = getPskey("gamecenter.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_wzdw.php?uin="+mQQ+"&pskey="+pskey+"&group="+group);
MyMsg.FixAndSendMsg(msg.Message_GroupUin,url,DefInfo.CardDefImages,false);
		return true;
		}
   	if(msg.Message_Content.startsWith("群战力"))
	{
		String text = msg.Message_Content.substring(3).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『群战力+对抗路/中路/发育路/打野/游走』");
			return false;
		}
		String group = msg.Message_GroupUin;
			String skey = getSkey();		
       String pskey = getPskey("gamecenter.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_wzzl.php?uin="+mQQ+"&pskey="+pskey+"&group="+group+"&type="+text);
 	MyMsg.FixAndSendMsg(msg.Message_GroupUin,url,DefInfo.CardDefImages,false);
		return true;
		}
	if(msg.Message_Content.startsWith("建立关系@"))
	{
	   	String strQQ= msg.atList[0];
		int index = msg.Message_Content.lastIndexOf(" ");
			String  ChangeName = msg.Message_Content.substring(index + 1);
			   String skey = getSkey();		
       String pskey = getPskey("ti.qq.com");
			String url =http.get(域名+"/API/qqgn/qq_ship.php?uin="+mQQ+"&skey="+skey+"&pskey="+pskey+"&qq="+strQQ+"&type="+ChangeName);
JSONObject b=new JSONObject(url);//json解析
		String ActionStatus=b.getString("ActionStatus");
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, ActionStatus);
}
	if(msg.Message_Content.equals("注册时间"))
	{
		String group = msg.Message_GroupUin;
	   String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get("https://api.linhun.vip/api/qqregistertime?qq="+msg.Message_UserUin+"&skey="+skey);
	  JSONObject b=new JSONObject(url);//json解析
		String qq=b.getString("qq");
		String name=b.getString("name");
		String registertime=b.getString("registertime");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "╭────────╮\nQQ:"+qq+"\n名称:"+name+"\n注册时间:"+registertime+"\n╰────────╯");
		}

   	if(msg.Message_Content.startsWith("设置铭牌"))
	{
		String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送『设置铭牌+id』"+"\n—————————————\n"+"看下图参数id"+"\n[PicUrl=http://gchat.qpic.cn/gchatpic_new/2556387520/1057174737-2227804679-5EE41E8C259F54278C0F331BBDCFECFC/0?term=2]");
		
			return false;
		}
			String group = msg.Message_GroupUin;
	   String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  String url = http.get(域名+"/API/qqgn/qq_srfentry.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&id="+text);
 	String json =http.get(域名+"/API/PHP/JSON.php?data="+url+"&value=[13019.msg]");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[AtQQ="+msg.Message_UserUin+"]\n"+"铭牌设置："+json);
 	
		}
		if(msg.Message_Content.equals("点亮cf图标"))
		{
		  String skey = getSkey();		
		    String pskey = getPskey("vip.qq.com");
	 String url = http.get("http://api.xn--7gqa009h.top/api/cftb?uin="+msg.Message_UserUin+"&pskey="+pskey);
	 JSONObject b=new JSONObject(url);//json解析
		String cf=b.getString("msg");
   MyMsg.FixAndSendMsg(msg.Message_GroupUin,cf,DefInfo.CardDefImages,false);
		return true;
		}
   	if(msg.Message_Content.equals("领取本月绿钻"))
		{
		  String skey = getSkey();		
	 String url = http.get("http://api.goodsc.vip/jk/api/lz.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+getPskey("qzone.qq.com"));
	 JSONObject b=new JSONObject(url);//json解析
		String lvzuan=b.getString("msg");
   MyMsg.FixAndSendMsg(msg.Message_GroupUin,msg.Message_UserUin+lvzuan,DefInfo.CardDefImages,false);
		return true;
		}
      	if(msg.Message_Content.equals("空间说说"))
	{
		String group = msg.Message_GroupUin;
	   String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get(域名+"/API/qqgn/qzone_url.php?data=&skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&qq="+msg.Message_UserUin+"&n=");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url+"\n"+"请发送『说说卡片+序号』查看");
		}
		   	if(msg.Message_Content.startsWith("群聊搜索"))
	{
		String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『群聊搜索+群名称』");
			return false;
		}
		String group = msg.Message_GroupUin;
	   String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_search.php?msg="+text+"&uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&max=10");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		  	if(msg.Message_Content.startsWith("说说卡片"))
	{
		String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『说说卡片+序号』");
			return false;
		}
		String group = msg.Message_GroupUin;
	   String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get(域名+"/API/qqgn/qzone_url.php?data=&skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&qq="+msg.Message_UserUin+"&n="+text);
 	MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.equals("手游加速"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
		   String skey = item.GetItemData("cookie", "ti", msg.Message_UserUin, "skey");
	  String pskey = item.GetItemData("cookie", "ti", msg.Message_UserUin, "pskey");
	  String url = http.get("http://x.xs.cn.a.bdydns.com/api/QQgame/api.php?qq="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey);
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}

		if(msg.Message_Content.equals("切换气泡"))
	{
		String group = msg.Message_GroupUin;
	   String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  String url = http.get("http://www.dreamling.xyz/API/QQ/set_bubble_rand/api.php?data=&skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&member=2");

		}
		if(msg.Message_Content.equals("好友列表"))
	{
		String group = msg.Message_GroupUin;
	   String skey = item.GetItemData("cookie", "id", msg.Message_UserUin, "skey");
	  String pskey = item.GetItemData("cookie", "id", msg.Message_UserUin, "pskey");
	  String url = http.get(域名+"/API/qqgn/qq_friendlist.php?data=&skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin);
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.startsWith("同意进群"))
	{
		String group = msg.Message_GroupUin;
	   String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_msg.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&n="+text+"&type=1&data=");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.startsWith("拒绝进群"))
	{
		if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入进群者的序号");
			return false;
		}
		String group = msg.Message_GroupUin;
	   String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_msg.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&n="+text+"&type=2&data=");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
			if(msg.Message_Content.startsWith("忽略进群"))
	{
		if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入进群者的序号");
			return false;
		}
		String group = msg.Message_GroupUin;
	   String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_msg.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&n="+text+"&type=3&data=");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.equals("好友通知"))
	{
		if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入进群者的序号");
			return false;
		}
		String group = msg.Message_GroupUin;
	   String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get(域名+"/API/qqgn/qzone_friend.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&data=");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.equals("成长点赞"))
	{
		String group = msg.Message_GroupUin;
	   String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  String url = http.get(域名+"/API/qqgn/vip_czdz.php?data=&skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin);
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.equals("成长排行"))
	{
		String group = msg.Message_GroupUin;
	   String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  String url = http.get(域名+"/API/qqgn/vip_czbd.php?data=&skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin);
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.equals("空白资料"))
	{
		String group = msg.Message_GroupUin;
	   String skey = item.GetItemData("cookie", "id", msg.Message_UserUin, "skey");
	  String pskey = item.GetItemData("cookie", "id", msg.Message_UserUin, "pskey");
	  String url = http.get(域名+"/API/qqgn/qq_zlqk.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey);
     MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "当前空白资料设置成功！");
		}
	
		if(msg.Message_Content.equals("业务签到"))
	{
		String group = msg.Message_GroupUin;
	   String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get("https://api.linhun.vip/api/Signin?qq="+msg.Message_UserUin+"&skey="+skey+"&p_skey="+pskey);
	  JSONObject b=new JSONObject(url);//json解析
		String qq=b.getString("qq");
		String a=b.getString("1");String c=b.getString("2");String d=b.getString("3");String e=b.getString("5");String f=b.getString("6");String g=b.getString("8");String h=b.getString("9");String i=b.getString("10");String j=b.getString("11");String j=b.getString("12");String l=b.getString("13");String m=b.getString("17");String n=b.getString("14");String o=b.getString("18");String p=b.getString("23");
   MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@"+msg.nickName+"\n"+qq+"\n"+a+"\n"+c+"\n"+d+"\n"+e+"\n"+f+"\n"+g+"\n"+h+"\n"+j+"\n"+k+"\n"+l+"\n"+m+"\n"+n+"\n"+o+"\n"+p);
		}
		if(msg.Message_Content.equals("清空定时说说"))
	{
		String group = msg.Message_GroupUin;
		
	   String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get(域名+"/API/qqgn/sstime_empty.php?data=&uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey);
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.equals("定时说说列表"))
	{
		String group = msg.Message_GroupUin;
		
	   String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get(域名+"/API/qqgn/sstime_list.php?data=&uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey);
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
			if(msg.Message_Content.startsWith("发布定时说说"))
	{
		String text = msg.Message_Content.substring(6).replace(" ","");
		String group = msg.Message_GroupUin;
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "输入“发布定时说说+内容”(24小时后发布/说说不能配图)");
			return false;
		}
		
	   String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get(域名+"/API/qqgn/sstime_send.php?data=&uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&msg="+text+"&time=1440");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}	
			if(msg.Message_Content.equals("余额查询"))
	{
		String group = msg.Message_GroupUin;
		String skey = getSkey();
		     String pskey4 = getPskey("tenpay.com");
		     String yue = http.get(域名+"/API/qqgn/qq_wallet.php?skey="+skey+"&uin="+mQQ+"&pskey="+pskey4);
	  JSONObject b=new JSONObject(yue);//json解析
		String money=b.getString("money");
		String qb=b.getString("qb");
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,"余额:"+money+"\nQ币:"+qb,DefInfo.CardDefImages,false);
		return true;
		}
			if(msg.Message_Content.equals("刷访客"))
	{
		String group = msg.Message_GroupUin;
		
	   String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get(域名+"/API/qqgn/qzone_lh.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&qq="+msg.Message_UserUin);
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}

		if(msg.Message_Content.startsWith("删除投票"))
	{
		String text = msg.Message_Content.substring(4).replace(" ","");
		String group = msg.Message_GroupUin;
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入删除投票+fid(不知道fid？那就发送投票列表看看吧)");
			return false;
		}
		
	   String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_deletetp.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&fid="+text);
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "成功");
		}	
			if(msg.Message_Content.startsWith("查看投票"))
	{
		String text = msg.Message_Content.substring(4).replace(" ","");
		String group = msg.Message_GroupUin;
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入查看投票+fid(不知道fid？那就发送投票列表看看吧)");
			return false;
		}
		
	   String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_seetp.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&fid="+text+"&lx=text");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}	
				if(msg.Message_Content.equals("投票列表"))
	{
		String group = msg.Message_GroupUin;
		
	   String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_listtp.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group);
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
	
	
				if(msg.Message_Content.equals("清空留言"))
	{
		String group = msg.Message_GroupUin;
		
	 String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get(域名+"/API/qqgn/qzone_emptymsgb.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey);
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}	if(msg.Message_Content.equals("清空说说"))
	{
		String group = msg.Message_GroupUin;
		
	 String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get(域名+"/API/qqgn/ss_empty.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey);
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}

	if(msg.Message_Content.equals("留言所有人可见"))
	{
		String group = msg.Message_GroupUin;
		
	   String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get("http://sq.klizi.cn/qzone_lysh.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&type=1");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
			if(msg.Message_Content.equals("留言仅好友可见"))
	{
		String group = msg.Message_GroupUin;
		
	   String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get("http://sq.klizi.cn/qzone_lysh.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&type=2");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
			if(msg.Message_Content.equals("留言仅自己可见"))
	{
		String group = msg.Message_GroupUin;
		
	   String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get("http://sq.klizi.cn/qzone_lysh.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&type=3");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
			if(msg.Message_Content.equals("访客所有人可见"))
	{
		String group = msg.Message_GroupUin;
		
	   String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get("http://sq.klizi.cn/qzone_fkqx.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&type=1");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}	if(msg.Message_Content.equals("访客仅好友可见"))
	{
		String group = msg.Message_GroupUin;
		
	   String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get("http://sq.klizi.cn/qzone_fkqx.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&type=2");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
			if(msg.Message_Content.equals("访客仅自己可见"))
	{
		String group = msg.Message_GroupUin;
		
	   String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get("http://sq.klizi.cn/qzone_fkqx.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&type=3");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
			if(msg.Message_Content.equals("空间所有人可见"))
	{
		String group = msg.Message_GroupUin;
		
	   String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get("http://sq.klizi.cn/qzone_kjqx.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&type=1");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}	if(msg.Message_Content.equals("空间仅好友可见"))
	{
		String group = msg.Message_GroupUin;
		
	   String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get("http://sq.klizi.cn/qzone_kjqx.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&type=2");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
			if(msg.Message_Content.equals("空间仅自己可见"))
	{
		String group = msg.Message_GroupUin;
		
	   String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get("http://sq.klizi.cn/qzone_kjqx.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&type=3");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
			if(msg.Message_Content.equals("允许空间评论"))
	{
		String group = msg.Message_GroupUin;
		
	   String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get("http://sq.klizi.cn/qzone_plsh.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&type=1");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}	if(msg.Message_Content.equals("禁止空间评论"))
	{
		String group = msg.Message_GroupUin;
		
	   String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get("http://sq.klizi.cn/qzone_plsh.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&type=2");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}


	if(msg.Message_Content.equals("特别关心"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get(域名+"/API/qqgn/specialcare.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin);
	  	 JSONObject b=new JSONObject(url);//json解析
		String a=b.getString("我关心的");
		String c=b.getString("关心我的");
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "我关心的"+a+"人\n"+"关心我的"+c+"人");
	  	   	}
	 
		
	
	  	  	if(msg.Message_Content.equals("空间签到"))
	{
		String uin = mQQ;
		
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get(域名+"/API/qqgn/publishmood.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey);
	  	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "签到成功，请勿重复签到");
		}
	  	    	  	if(msg.Message_Content.equals("我的访客"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
		
	  String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get(域名+"/API/qqgn/qzone_visitor.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&qq="+msg.Message_UserUin);
	  	    	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
	if(msg.Message_Content.equals("设置空白昵称"))
	{
		String uin = mQQ;
		
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get(域名+"/API/qqgn/qq_kbnc.php?qq="+msg.Message_UserUin+"&skey="+skey);
	  	    	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
if(msg.Message_Content.startsWith("发布说说"))
	{
		String uin = mQQ;
		
	String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送指令:发布说说+内容");
			return false;
		}
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get(域名+"/API/qqgn/ss_sendimg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&msg="+text);
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.startsWith("说说列表"))
	{
	String text = msg.Message_Content.substring(4).replace(" ","");
	if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送说说列表+QQ");
			return false;
		}
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	
	  String url = http.get(域名+"/API/qqgn/ss_list.php?uin="+msg.Message_UserUin+"&skey="+getSkey()+"&pskey="+getPskey("qzone.qq.com")+"&qq="+text);
	  	    	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
	if(msg.Message_Content.startsWith("删除说说"))
	{
		String uin = mQQ;
		
	String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送指令:删除说说+tid(不知道tid是什么？发送“说说列表”查看)");
			return false;
		}
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("qzone.qq.com");
	  String url = http.get(域名+"/API/qqgn/ss_delete.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&tid="+text);
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}	if(msg.Message_Content.startsWith("点赞说说 "))
	{
	   String text1= msg.Message_Content.split(" ")[1];
	   String text2 = msg.Message_Content.split(" ")[2];
	
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("qzone.qq.com");
	  String url = http.get(域名+"/API/qqgn/qzone_ssdz.php?pskey="+pskey+"&uin="+mQQ+"&skey="+skey+"&tid="+text2+"&qq="+text1);
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
	if(msg.Message_Content.startsWith("发布留言"))
	{
		
	String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送指令:发布留言+内容");
			return false;
		}
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get(域名+"/API/qqgn/qzone_addmsgb.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&msg="+text+"&qq="+msg.Message_UserUin);
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}

				if(msg.Message_Content.equals("留言列表"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
		
	  String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get(域名+"/API/qqgn/qzone_msgb.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&qq="+msg.Message_UserUin);
	  	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
	if(msg.Message_Content.startsWith("删除留言"))
	{
		String uin = mQQ;
		
	String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送指令:删除留言+序号(不发送“留言列表”查看序号)");
			return false;
		}
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get(域名+"/API/qqgn/qzone_delmsgb.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&id="+text);
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
if(msg.Message_Content.startsWith("修改昵称"))
	{
		String uin = mQQ;
		
	String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送指令:修改昵称+内容");
			return false;
		}
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get(域名+"/API/qqgn/qq_nc.php?qq="+msg.Message_UserUin+"&skey="+skey+"&msg="+text);
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
if(msg.Message_Content.startsWith("赠送礼物"))
	{
		String uin = mQQ;
		
	String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送指令“赠送礼物+qq”(必须是QQ好友才行)");
			return false;
		}
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get("http://jiuli.xiaoapi.cn/i/qzone_wxlw.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&qh="+group+"&qq="+text);
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "礼物正为"+text+"\n"+"私发派送中…"+"\n"+"还不谢主隆恩？");
		}
		if(msg.Message_Content.startsWith("送礼物@"))
	{
		String uin = mQQ;
		
	String strQQ= msg.atList[0];
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get("http://jiuli.xiaoapi.cn/i/qzone_wxlw.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&qh="+group+"&qq="+strQQ);
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "礼物正为"+strQQ+"\n"+"私发派送中…"+"\n"+"还不谢主隆恩？");
		}

if(msg.Message_Content.equals("亲密度排行"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
		
	  String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get("http://jiuli.xiaoapi.cn/i/qzone_qmd.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&qh="+group);
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
if(msg.Message_Content.equals("本周收礼排行"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
		
	  String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get("http://jiuli.xiaoapi.cn/i/qzone_lwb.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&qh="+group+"&qq="+msg.Message_UserUin);
	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}

		//zb
	if(msg.Message_Content.startsWith("搜索装扮"))
		{
		String uin = mQQ;
		String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入搜索装扮+想要的类型");
			return false;
		}
	 String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
		String dat = item.GetItemData(msg.Message_GroupUin, "装扮", "装扮类型", uin);
		item.SetItemData(msg.Message_GroupUin, "装扮", "装扮页数", uin, 1);
		item.SetItemData(msg.Message_GroupUin, "装扮", "装扮内容", uin, text);
		String page = item.GetItemData(msg.Message_GroupUin, "装扮", "装扮页数", uin);
		String data = http.get(域名+"/API/qqgn/a/vip.php?id="+dat+"&msg="+text+"&uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&page="+page);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin,data+"当前搜索类型:"+dat+"\n"+"发送:下一页可以查看更多"+"\n"+"发送:使用装扮+id可以设置装扮");
		
		}
      	if(msg.Message_Content.startsWith("使用装扮"))
		{
		String uin = mQQ;
		
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
		String n = msg.Message_Content.substring(4).replace(" ","");
		String data = item.GetItemData(msg.Message_GroupUin, "装扮", "装扮类型", uin);
		String page = item.GetItemData(msg.Message_GroupUin, "装扮", "装扮页数", uin);
		String text = item.GetItemData(msg.Message_GroupUin, "装扮", "装扮内容", uin);
		String data = http.get(域名+"/API/qqgn/a/vip.php?id="+data+"&msg="+text+"&uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&page="+page+"&type=1&itemid="+n);
	 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, data);
		}
      	if(msg.Message_Content.equals("下一页"))
		{
		String uin = mQQ;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
		String dat = item.GetItemData(msg.Message_GroupUin, "装扮", "装扮类型", uin);
		String page = item.GetItemData(msg.Message_GroupUin, "装扮", "装扮页数", uin);
		String page = http.get(域名+"/API/other/jjcc.php?type=1&a=1&b="+page);
		item.SetItemData(msg.Message_GroupUin, "装扮", "装扮页数", uin, page);
		String page = item.GetItemData(msg.Message_GroupUin, "装扮", "装扮页数", uin);
		String text = item.GetItemData(msg.Message_GroupUin, "装扮", "装扮内容", uin);
		String data = http.get(域名+"/API/qqgn/a/vip.php?id="+dat+"&msg="+text+"&uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&page="+page);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin,data+"当前搜索类型:"+dat+"\n"+"发送:下一页可以查看更多"+"\n"+"发送:使用装扮+id可以设置装扮");
		
		}
           if(msg.Message_Content.startsWith("个性装扮"))
			{
	String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "发送:个性装扮+(气泡/主题/字体/挂件/来电/名片/背景/头像/个签/个性赞/进群特效)进行搜索吧！");
			return false;
		}
		String group = msg.Message_GroupUin;
		String uin = mQQ;
		item.SetItemData(msg.Message_GroupUin, "装扮", "装扮类型", uin, text);
		//String data = item.GetItemData(msg.Message_GroupUin, "多选", uin);
        MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "装扮类型:"+text+"设置成功!\n发送:搜索装扮+内容进行搜索吧!");
        }
         if(msg.Message_Content.startsWith("取消装扮"))
	{
		String uin = mQQ;
		
	String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送指令“取消装扮+气泡/主题/字体/挂件/来电/名片/背景/头像/个签/个性赞/进群特效/浮屏”");
			return false;
		}
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  String url = http.get(域名+"/API/qqgn/a/vip_uniset.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&id="+text);
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}

	     
if(msg.Message_Content.equals("资料")){
	String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");

String data = http.get(域名+"/API/qqgn/qxx.php?data=json&skey="+skey+"&pskey="+pskey+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq="+msg.Message_UserUin+"&je=1&type=&collection_no");

MyMsgApi.Message_Send_Group(msg.Message_GroupUin, data);

}
	

 	if(msg.Message_Content.startsWith("修改群头"))
	{
	String uin = mQQ;	
	String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "输入『修改群头+图片链接』");
			return false;
		}		
		 String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_head.php?uin="+mQQ+"&skey="+skey+"&pskey="+pskey+"&group="+msg.Message_GroupUin+"&img="+text);
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
	}
	  	if(msg.Message_Content.startsWith("发公告"))
	{
	String uin = mQQ;	
	String text = msg.Message_Content.substring(3).replace(" ","");
			if(text.equals(""))
		{		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "内容不能为空");
			return false;
		}		
		 String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/gg_send.php?data=&skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+msg.Message_GroupUin+"&text="+text);
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "发布成功");
	}
	  	if(msg.Message_Content.startsWith("搜索群员"))
	{
	String uin = mQQ;	
	String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『搜索群员+昵称关键词』");
			return false;
		}		
		 String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_search_members.php?uin="+mQQ+"&skey="+skey+"&pskey="+pskey+"&group="+msg.Message_GroupUin+"&msg="+text);
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
	}
	
	if(msg.Message_Content.equals("谁是龙王"))
	{
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get("http://ovooa.com/API/Dragon/api?QQ="+mQQ+"&Skey="+skey+"&pskey="+pskey+"&Group="+group);
	 JSONObject b=new JSONObject(url);//json解析
JSONObject b=b.getJSONObject("data");
String uin=b.getString("Uin");
String day=b.getString("Day");
String nick=b.getString("Nick");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "————🐲龙王————\n\n账号:"+uin+"\n天数:"+day+"\n昵称:"+nick+"\n\n————🐉—————");
		}
	if(msg.Message_Content.startsWith("查询头衔@"))
	{
		String strQQ= msg.atList[0];
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get("http://ovooa.com/API/Group_Nick/?QQ="+mQQ+"&Skey="+skey+"&Pskey="+pskey+"&uin="+strQQ+"&Group="+group);
	  JSONObject b=new JSONObject(url);//json解析
JSONObject b=b.getJSONObject("data");
String name=b.getString("name");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "☞"+name+"☜");
		}
			if(msg.Message_Content.startsWith("查询头衔 "))
	{
		String text = msg.Message_Content.substring(5).replace(" ","").replace("+","").replace("＋","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『查询头衔+QQ』");
			return false;
		}
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get("http://ovooa.com/API/Group_Nick/?QQ="+mQQ+"&Skey="+skey+"&Pskey="+pskey+"&uin="+text+"&Group="+group);
 JSONObject b=new JSONObject(url);//json解析
JSONObject b=b.getJSONObject("data");
String name=b.getString("name");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "☞"+name+"☜");
		}
		if(msg.Message_Content.equals("收入记录"))
	{
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("tenpay.com");
	  String url = http.get(域名+"/API/qqgn/qq_accountlist.php?uin="+mQQ+"&skey="+skey+"&pskey="+pskey);
	//  url=url.replace("\n","○");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "╭──────────────╮\n"+url+"\n╰──────────────╯");
		}
				if(msg.Message_Content.startsWith("创建群聊"))
	{
	String text = msg.Message_Content.substring(4);
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_create.php?uin="+mQQ+"&skey="+skey+"&pskey="+pskey+"&msg="+text+"&txt=");
	JSONObject b=new JSONObject(url);//json解析
		String gc=b.getString("gc");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "群号:"+gc+"\n去完善群信息吧");
		}
				if(msg.Message_Content.equals("支出记录"))
	{
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("tenpay.com");
	  String url = http.get(域名+"/API/qqgn/qq_accountlist.php?uin="+mQQ+"&skey="+skey+"&pskey="+pskey+"&type=1");
	//  url=url.replace("\n","○");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "╭──────────────╮\n"+url+"\n╰──────────────╯");
		}
	
	if(msg.Message_Content.equals("广告打卡"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
		String skey = getSkey();		
       String pskey = getPskey("ti.qq.com");
	  String url = http.get(域名+"/API/qqgn/qq_ggdk.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey);
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
				if(msg.Message_Content.equals("允许搜索"))
	{
		String group = msg.Message_GroupUin;
		
	   String skey = getSkey();		
       String pskey = getPskey("id.qq.com");
	  String url = http.get(域名+"/API/qqgn/qq_search.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&switch=2");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已设置QQ允许被搜索到");
		}
		if(msg.Message_Content.equals("拒绝搜索"))
	{
		String group = msg.Message_GroupUin;
		
	 String skey = getSkey();		
       String pskey = getPskey("id.qq.com");
	  String url = http.get(域名+"/API/qqgn/qq_search.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&switch=1");
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已设置QQ拒绝被搜索到");
		}

	if(msg.Message_Content.equals("开启打卡提醒"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
		String skey = getSkey();		
       String pskey = getPskey("ti.qq.com");
	  String url = http.get(域名+"/API/qqgn/qq_dktx.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&type=1");
	  	   	sendReply(msg.msg, "当前操作:开启打卡提醒成功");
		}if(msg.Message_Content.equals("关闭打卡提醒"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	String skey = getSkey();		
       String pskey = getPskey("ti.qq.com");
	  String url = http.get(域名+"/API/qqgn/qq_dktx.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&type=2");
	  	   	sendReply(msg.msg, "当前操作:关闭打卡提醒成功");
		}
			if(msg.Message_Content.startsWith("互动榜"))
	{
		String uin = mQQ;
	String text = msg.Message_Content.substring(3).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送指令:“互动榜+龙王/快乐源泉/群聊之火/群聊炽焰/善财福禄寿”");
			return false;
		}
		String group = msg.Message_GroupUin;
		
	 String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_Interaction.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&lx=text&type="+text);
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
			if(msg.Message_Content.startsWith("发起投票"))
	{
		String uin = mQQ;
	String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送指令:“投票发布+内容”");
			return false;
		}
		String group = msg.Message_GroupUin;
		 String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_sendtp.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&title="+text+X("ÈÉ´ÈÉ呥慨ÈÉ书呥慨¶"));
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "成功");
		}
	 if(DontSafe)
		 {              
		if(msg.Message_Content.equals("开始清理不活跃"))
	{
		String group = msg.Message_GroupUin;
		 String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_delnoactive.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&num=1&group="+group);
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}}
			if(msg.Message_Content.equals("清理不活跃"))
	{
 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送『开启不安全功能』，之后发送『开始清理不活跃』即可");
		}
	if(msg.Message_Content.startsWith("好友抽符"))
	{
	String text = msg.Message_Content.substring(4).replace(" ","").replace("+","").replace("＋","");
		if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『好友抽符+好友QQ』");
			return false;
		}
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	 String skey = getSkey();		
       String pskey = getPskey("ti.qq.com");
	  String url = http.get(域名+"/API/qqgn/qq_lucky.php?data=&uin="+mQQ+"&skey="+skey+"&pskey="+pskey+"&qq="+text);
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.startsWith("好友字符列表"))
	{
		String text = msg.Message_Content.substring(6).replace(" ","").replace("+","").replace("＋","");
		if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『好友字符列表+好友QQ』");
			return false;
		}
		String uin = mQQ;
		String group = msg.Message_GroupUin;
		 String skey = getSkey();		
       String pskey = getPskey("ti.qq.com");
	  String url = http.get(域名+"/API/qqgn/qq_luckylist.php?data=&uin="+mQQ+"&skey="+skey+"&pskey="+pskey+"&group="+group+"&qq="+text);
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.startsWith("开好友抽符"))
	{
		String text = msg.Message_Content.substring(5).replace(" ","").replace("+","").replace("＋","");
		if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『开好友抽符+好友QQ』");
			return false;
		}
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	 String skey = getSkey();		
       String pskey = getPskey("ti.qq.com");
	  String url = http.get(域名+"/API/qqgn/qq_luckyset.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&qq="+text+"&switch=1");
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
			if(msg.Message_Content.startsWith("关好友抽符"))
	{
		String text = msg.Message_Content.substring(5).replace(" ","").replace("+","").replace("＋","");
		if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『关好友抽符+好友QQ』");
			return false;
		}
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	 String skey = getSkey();		
       String pskey = getPskey("ti.qq.com");
	  String url = http.get(域名+"/API/qqgn/qq_luckyset.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&qq="+text+"&switch=2");
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
				if(msg.Message_Content.startsWith("使用好友字符 "))
	{
	String str = msg.Message_Content.substring(7);
        int index=str.indexOf(" ");  
         if (index == -1)
        {
        MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送『使用好友字符🈳好友QQ🈳字符id』\n—————————————\n不知道字符id就发送好友字符列表进行查看吧！");
			return false;
         }
 
        String text=str.substring(0, index);
        String text2=str.substring(index + 1);
		String group = msg.Message_GroupUin;
	 String skey = getSkey();		
       String pskey = getPskey("ti.qq.com");
	  String url = http.get(域名+"/API/qqgn/qq_luckyuse.php?uin="+mQQ+"&skey="+skey+"&pskey="+pskey+"&qq="+text+"&id="+text2);
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
if(msg.Message_Content.equals("抽幸运符"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	 String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_lucky.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&group="+group);
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
if(msg.Message_Content.equals("字符列表"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	 String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_luckylist.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&group="+group+"&lx="+text);
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
if(msg.Message_Content.startsWith("使用字符"))
	{
		String text = msg.Message_Content.substring(4).replace(" ","");
		
		String uin = mQQ;
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入使用字符+序号(序号以“字符列表”为准)");
			return false;
		}
		String group = msg.Message_GroupUin;
	 String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_luckyuse.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&group="+group+"&id="+text);
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
	if(msg.Message_Content.equals("我的Q币"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	 String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get("http://dreamling.xyz/API/QQ/QB/api.php?robot="+msg.Message_UserUin+"&skey="+skey+"MV2GyBJaYM");
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
	if(msg.Message_Content.equals("开启匿名"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	 String skey = getSkey();		
       String pskey = getPskey("qqweb.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_anony.php?value=1&skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group);
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "当前操作:开启匿名成功");
}	
	if(msg.Message_Content.equals("关闭匿名"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
		 String skey = getSkey();		
       String pskey = getPskey("qqweb.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_anony.php?value=0&skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group);
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "当前操作:关闭匿名成功");
}	
if(msg.Message_Content.equals("打卡报名"))
	{
		String uin = mQQ;
		
		String group = msg.Message_GroupUin;
	 String skey = getSkey();		
       String pskey = getPskey("ti.qq.com");
	  String url = http.get(域名+"/API/qqgn/qq_dkbm.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey);
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
if(msg.Message_Content.equals("日签打卡"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	 String skey = getSkey();		
       String pskey = getPskey("ti.qq.com");
	  String url = http.get(域名+"/API/qqgn/qq_dk.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&type=1");
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
if(msg.Message_Content.equals("收集打卡"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
		 String skey = getSkey();		
       String pskey = getPskey("ti.qq.com");
	  String url = http.get(域名+"/API/qqgn/qq_dk.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&type=2");
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
/*if(msg.Message_Content.equals("查询余额"))
	{
		String group = msg.Message_GroupUin;
		  String skey = getSkey();		
       String pskey = getPskey("tenpay.com");
	  String url = http.get(域名+"/API/qqgn/qq_wallet.php?skey="+skey+"&uin="+mQQ+"&pskey="+pskey);
		JSONObject b=new JSONObject(url);//json解析
		String money=b.getString("money");
		String qb=b.getString("qb");
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "¶QQ:"+mQQ+"\n\n╭──────╮\n\n\n"+"○余额:"+money+"\n\n○Q币:"+qb+"\n\n\n╰──────╯\n\n\n¶时间:"+GetNowTime());
		}
		*/
	if(msg.Message_Content.equals("禁言列表"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
		 String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/grouan.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&qh="+group);
	  	 MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
			if(msg.Message_Content.startsWith("邀好友"))
	{
		String uin = mQQ;
	String text = msg.Message_Content.substring(3).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送指令:邀好友+QQ|注意:必须是QQ内好友");
			return false;
		}
		
		String group = msg.Message_GroupUin;
	 String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_add.php?data=&uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&group="+group+"&qq="+text);
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+text+"\n&spec=640"+"]\n正在邀请…");
		}
		
		if(msg.Message_Content.equals("打卡报名"))
	{
		String uin = mQQ;
		
		String group = msg.Message_GroupUin;
	 String skey = getSkey();		
       String pskey = getPskey("ti.qq.com");
	  String url = http.get(域名+"/API/qqgn/qq_dkbm.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey);
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.equals("礼物券"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	 String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get("http://api.tianyi2006.xyz/api/chaliwu.php?qq="+msg.Message_UserUin+"&skey="+skey+"");
	  url=url.replace("天一API","");
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		 if(msg.Message_Content.equals("本群管理"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	 String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/qgl.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&lx=text&type=%E9%BE%99%E7%8E%8B");
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
	 if(msg.Message_Content.equals("我的装扮"))
	{
		String uin = mQQ;
		
		String group = msg.Message_GroupUin;
		 String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  String url = http.get(域名+"/API/qqgn/a/vip_list.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey);
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
 	if(msg.Message_Content.startsWith("积分榜"))
	{
		String uin = mQQ;
		
	String text = msg.Message_Content.substring(3).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入指令:“积分榜+等级积分/屠龙/龙王争霸/管理员”");
			return false;
		}
		String group = msg.Message_GroupUin;
	 String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/qphb.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&lx=text&type="+text);
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
	if(msg.Message_Content.equals("群发言榜"))
	{
		String uin = mQQ;
		
		String group = msg.Message_GroupUin;
 String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/SpeakRank.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&lx=text&type=%E9%BE%99%E7%8E%8B");
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
if(msg.Message_Content.equals("本群资料"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	 String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_text.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&lx=text&type=2");
	  	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
/*
 if(msg.Message_Content.equals("我的业务"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	 String skey = getSkey();		
       String pskey = getPskey("qzone.com");
	  String url = http.get(域名+"/API/qqgn/yw.php?skey="+skey+"&pskey="+pskey+"&qq="+msg.Message_UserUin+"");
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		*/
				//登录
      	if(msg.Message_Content.equals("授权登录会员"))
		{
		String uin = mQQ;
	 String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
   	  item.SetItemData("cookie", "vip", mQQ, "skey", skey);
	  item.SetItemData("cookie", "vip", mQQ, "pskey", pskey);
        MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "授权登录会员官网成功!");	    
	     }
      	if(msg.Message_Content.equals("授权登录群"))
		{
		String uin = mQQ;
		 String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  item.SetItemData("cookie", "qun", mQQ, "skey", skey);
	  item.SetItemData("cookie", "qun", mQQ, "pskey", pskey);
        MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "授权登录群官网成功！");	    
	     }
      	if(msg.Message_Content.equals("授权登录空间"))
		{
		String uin = mQQ;
	 String skey = getSkey();		
       String pskey = getPskey("qzone.com");
//	    String pt4token=url.split("pt4token=")[1].split(";")[0];
	  item.SetItemData("cookie", "qzone", mQQ, "skey", skey);
	  item.SetItemData("cookie", "qzone", mQQ, "pskey", pskey);
//	  item.SetItemData("cookie", "qun", mQQ, "pt4token", pt4token);
        MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "授权登录空间官网成功");	    
	     }
	     	if(msg.Message_Content.startsWith("发签名"))
	{
		String uin = mQQ;
		
	String text = msg.Message_Content.substring(3).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送指令:发签名+内容");
			return false;
		}
		String group = msg.Message_GroupUin;
 String skey = getSkey();		
       String pskey = getPskey("id.qq.com");
	  String url = http.get(域名+"/API/qqgn/qq_qm.php?uin="+msg.Message_UserUin+"&skey="+skey+"&pskey="+pskey+"&msg="+text);
	   	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "发布成功");
		}
	     }
	      
	      
	      	if(msg.Message_UserUin.equals(mQQ))
	{
     	if(msg.Message_Content.startsWith("搜索歌曲"))
	{
		String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送指令:“搜索歌曲+内容");
			}
	  String group = msg.Message_GroupUin;
	  
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	 item.SetItemData(group, "一起听歌", "搜索", msg.Message_UserUin, text);
	  String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&n=&type=add&msg="+text);
	 	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url+"\n\n发送添加歌曲+序号");
		}
      	if(msg.Message_Content.startsWith("添加歌曲"))
	{
		String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送指令:“添加歌曲+序号");
			}
	  String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	String nr = item.GetItemData(msg.Message_GroupUin, "一起听歌", "搜索", msg.Message_UserUin);
	String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&n="+text+"&type=add&msg="+nr);
	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}
      	if(msg.Message_Content.startsWith("删除歌曲"))
	{
		String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送指令:“删除歌曲+序号”");
			}
	  String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&n="+text+"&type=remove");
	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}
      	if(msg.Message_Content.startsWith("定时时间开始"))
	{
		String text = msg.Message_Content.substring(6).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送指令:“定时时间开始+数字”");
			}
	  String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  	String stop = item.GetItemData(msg.Message_GroupUin, "一起听歌", "时间", "end_hour");
	item.SetItemData(group, "一起听歌", "时间", "start_hour", text);
	String time = item.GetItemData(msg.Message_GroupUin, "一起听歌", "时间", "time");
	String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&end_hour="+end_hour+"&start_hour="+text+"&type="+time);
	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}
      	if(msg.Message_Content.startsWith("增加播放日期"))
	{
		String text = msg.Message_Content.substring(6).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送指令:“增加播放日期+列组”"+"\n"+X("俤姛壷勹攆斗显杸亓晸杸乙哥晸杸以･割捠伽亓壷勹攆斗显杸流慨桠焒筿呐亓荊无宰筿"));
			}
	  String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  	String week_days = item.GetItemData(msg.Message_GroupUin, "一起听歌", "时间", "week_days");
	  	String time = item.GetItemData(msg.Message_GroupUin, "一起听歌", "时间", "time");
	item.SetItemData(group, "一起听歌", "时间", "week_days", "["+text+"]");
	String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&week_days=["+text+"]&type="+time);
	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}
      	if(msg.Message_Content.startsWith("定时时间结束"))
	{
		String text = msg.Message_Content.substring(6).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "发送指令:“定时时间开始+数字”");
			}
	  String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  	String start_hour = item.GetItemData(msg.Message_GroupUin, "一起听歌", "时间", "start_hour");
	  	String time = item.GetItemData(msg.Message_GroupUin, "一起听歌", "时间", "time");
	  	item.SetItemData(group, "一起听歌", "时间", "start_hour", text);
	String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&start_hour="+start_hour+"&end_hour="+text+"&type="+time);
	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}
      	if(msg.Message_Content.startsWith("播放歌曲"))
	{
		String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送指令:“播放歌曲+序号");
			}
	  String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&n="+text+"&type=switch");
	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}
      	if(msg.Message_Content.equals("随机播放"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&n=1&type=setmode");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}
      	if(msg.Message_Content.equals("取消重复播放"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  	 item.SetItemData(group, "一起听歌", "时间", "time", "time");
	  String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&n=1&type=time");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}
      	if(msg.Message_Content.equals("重复播放每天"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  	 item.SetItemData(group, "一起听歌", "时间", "time", "time1");
	  String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&n=1&type=time1");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}
      	if(msg.Message_Content.equals("重复播放每周"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  	 item.SetItemData(group, "一起听歌", "时间", "time", "time2");
	  String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&week_days="+data+"&type=time2");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}
      	if(msg.Message_Content.equals("顺序播放"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&n=2&type=setmode");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}
      	if(msg.Message_Content.equals("单曲循环"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&n=3&type=setmode");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}
      	if(msg.Message_Content.equals("开启听歌"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&n=1&type=set");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}
      	if(msg.Message_Content.equals("关闭听歌"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&n=2&type=set");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}
      	if(msg.Message_Content.equals("开启定时"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&n=1&type=task");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}
      	if(msg.Message_Content.equals("关闭定时"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&n=2&type=task");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}
      	if(msg.Message_Content.equals("允许成员开启"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  	String flag = item.GetItemData(msg.Message_GroupUin, "一起听歌", "开关", "flag");
	  	String stop = item.GetItemData(msg.Message_GroupUin, "一起听歌", "开关", "stop");
	  	item.SetItemData(group, "一起听歌", "开关", "allow", "1");
	  String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&flag="+flag+"&stop="+stop+"&allow=1&type=flag");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}
      	if(msg.Message_Content.equals("拒绝成员开启"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  	String flag = item.GetItemData(msg.Message_GroupUin, "一起听歌", "开关", "flag");
	  	String stop = item.GetItemData(msg.Message_GroupUin, "一起听歌", "开关", "stop");
	  item.SetItemData(group, "一起听歌", "开关", "allow", "0");
	  String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&flag="+flag+"&stop="+stop+"&allow=0&type=flag");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}
      	if(msg.Message_Content.equals("允许成员添加"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  	String allow = item.GetItemData(msg.Message_GroupUin, "一起听歌", "开关", "allow");
	  	String stop = item.GetItemData(msg.Message_GroupUin, "一起听歌", "开关", "stop");
	  	item.SetItemData(group, "一起听歌", "开关", "flag", "1");
	  String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&start="+start+"&stop="+stop+"&flag=1&type=flag");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}
      	if(msg.Message_Content.equals("拒绝成员添加"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  	String allow = item.GetItemData(msg.Message_GroupUin, "一起听歌", "开关", "allow");
	  	String stop = item.GetItemData(msg.Message_GroupUin, "一起听歌", "开关", "stop");
	  	item.SetItemData(group, "一起听歌", "开关", "flag", "0");
	  String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&start="+start+"&stop="+stop+"&flag=0&type=flag");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}
      	if(msg.Message_Content.equals("结束不留列表"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  	String allow = item.GetItemData(msg.Message_GroupUin, "一起听歌", "开关", "allow");
	  	String flag = item.GetItemData(msg.Message_GroupUin, "一起听歌", "开关", "flag");
	  	item.SetItemData(group, "一起听歌", "开关", "stop", "0");
	  String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&start="+start+"&flag="+flag+"&stop=0&type=flag");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}
      	if(msg.Message_Content.equals("结束保留列表"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  	String allow = item.GetItemData(msg.Message_GroupUin, "一起听歌", "开关", "allow");
	  	String flag = item.GetItemData(msg.Message_GroupUin, "一起听歌", "开关", "flag");
	  	item.SetItemData(group, "一起听歌", "开关", "stop", "1");
	  String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&start="+start+"&flag="+flag+"&stop=1&type=flag");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}
      	if(msg.Message_Content.equals("歌曲列表"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&n=2&type=list");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}
      	if(msg.Message_Content.equals("听歌人数"))
	{
		String uin = mQQ;
		String group = msg.Message_GroupUin;
	  String skey = getSkey();		
       String pskey = getPskey("vip.qq.com");
	  String url = http.get(域名+"/API/qqgn/yqtg.php?skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&n=2&type=number");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
}



}
 
        return false;}
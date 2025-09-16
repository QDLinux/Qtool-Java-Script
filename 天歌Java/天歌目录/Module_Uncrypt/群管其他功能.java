

public boolean M_群管功能(Object msg)
{
String str_autoTitle_Conmand = "我要头衔";
	if(MySwitch.CheckSwitch(msg.Message_GroupUin, "自助头衔"))
	{
		if(msg.Message_Content.startsWith(str_autoTitle_Conmand))
		{
			MyMsgApi.Group_SetTitle(msg.Message_GroupUin,msg.Message_UserUin,msg.Message_Content.substring(str_autoTitle_Conmand.length()));
		}
		if(msg.Message_Content.startsWith("克隆头衔@"))
		{
	    	String strQQ= msg.atList[0];
	    	  String skey = getSkey();		
	     	String group = msg.Message_GroupUin;
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(X("ÁÍÍÉÈÏÈÈº¼ÈÆ©¢ ËÈÎÉ¸§Â¼Äªª")+msg.Message_UserUin+"&Skey="+skey+"&Pskey="+pskey+"&uin="+strQQ+"&Group="+group);
	  JSONObject b=new JSONObject(url);//json解析
JSONObject b=b.getJSONObject("data");
String name=b.getString("name");
			MyMsgApi.Group_SetTitle(msg.Message_GroupUin, mQQ, name);
		}
		
	}
	
	if(msg.Message_UserUin.equals(MyUin))
	{
		if(msg.Message_Content.equals("开启自助头衔"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "自助头衔",true);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin,"自助头衔已开启,群友可以发送 我要头衔+内容 来获得头衔");
		}
		if(msg.Message_Content.equals("关闭自助头衔"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "自助头衔",false);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin,"自助头衔已关闭");
		}
				if(msg.Message_Content.startsWith("给头衔@"))
		{
	    	String strQQ= msg.atList[0];
	    		int index = msg.Message_Content.lastIndexOf(" ");
			String  ChangeName = msg.Message_Content.substring(index + 1);
	    	MyMsgApi.Group_SetTitle(msg.Message_GroupUin, strQQ, ChangeName);
		}
		if(msg.Message_Content.startsWith("名片锁定@"))
		{
			String Name = msg.Message_Content.substring(4);
			for(String QQUin : msg.atList)
			{
				item.SetItemData(msg.Message_GroupUin,msg.Message_UserUin,"CardLock","LockName",Name);
			}	
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin,"名片已锁定");
		}
	}
	return false;
	
}

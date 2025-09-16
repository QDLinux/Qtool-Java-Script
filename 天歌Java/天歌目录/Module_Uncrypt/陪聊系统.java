
public boolean Module_陪聊系统(Object msg)
{
if(!MySwitch.CheckSwitch(msg.Message_GroupUin, "陪聊系统")) return false;
	if(!IsGroupAdmin(msg.Message_GroupUin,msg.Message_UserUin) && MySwitch.CheckSwitch(msg.Message_GroupUin,"菜单限制")) return false;
	String 域名 = item.GetItemData("Api", "域名", "地址", "1");
	if(item.GetItemDataInt(msg.Message_GroupUin, msg.Message_UserUin, "recall", "AI") == 1)
	{
		if(item.GetItemDataInt(msg.Message_GroupUin, "机器人", "开关", "模式") == 1)
		{
	String Pei = http.get("http://api.caonm.net/api/ai/o.php?img="+msg.Message_Content);
JSONObject b=new JSONObject(Pei);//json解析
JSONObject b=b.getJSONObject("data");
String html=b.getString("html");
	MyMsg.FixAndSendMsg(msg.Message_GroupUin,html,DefInfo.CardDefImages,false);
	}
		if(item.GetItemDataInt(msg.Message_GroupUin, "机器人", "开关", "模式") == 2)
		{
		String a = http.get("http://api.xn--7gqa009h.top/api/xlny_1?msg="+"在？"+msg.Message_Content);
		  String tu = a.substring(a.indexOf("http"), a.indexOf("jpg"));
		   String zi= a.substring(a.indexOf(")"));
		   zi = zi.replace(")","");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+tu+"jpg]"+zi);
		}
			if(item.GetItemDataInt(msg.Message_GroupUin, "机器人", "开关", "模式") == 3)
		{
		String a = http.get("http://api.xn--7gqa009h.top/api/xlny?msg="+"在？"+msg.Message_Content);
		//  String tu = a.substring(a.indexOf("http"), a.indexOf("jpg"));
		   String zi= a.substring(a.indexOf(")"));
		   zi = zi.replace(")","");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin=484151048\n&spec=640"+"]"+zi);
		}
	}
	if(!msg.Message_UserUin.equals(mQQ)) return false;
		if(msg.Message_Content.startsWith("开启陪聊@"))
	{
		for(String AUin: msg.atList)
		{
			item.SetItemData(msg.Message_GroupUin, AUin, "recall", "AI", 1);
			item.SetItemData(msg.Message_GroupUin, AUin, "recall", "AI", 1);
		}
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "提示:陪聊已开启！请选择\n切换ai陪聊\n切换男/女友陪聊");
	}

	if(msg.Message_Content.startsWith("关闭陪聊@"))
	{
		for(String AUin: msg.atList)
		{
			item.SetItemData(msg.Message_GroupUin, AUin, "recall", "AI", 0);
			item.SetItemData(msg.Message_GroupUin, AUin, "recall", "AI", 0);
		}
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "提示:陪聊已关闭！");
	}
		if(msg.Message_Content.equals("切换ai陪聊"))
		{
		item.SetItemData(msg.Message_GroupUin, "机器人", "开关", "模式", 1);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin,"提示:ai陪聊已开启");
	}
	if(msg.Message_Content.equals("切换女友陪聊"))
		{
		item.SetItemData(msg.Message_GroupUin, "机器人", "开关", "模式", 2);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin,"提示:女友陪聊已开启");
	}
		if(msg.Message_Content.equals("切换男友陪聊"))
		{
		item.SetItemData(msg.Message_GroupUin, "机器人", "开关", "模式", 3);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin,"提示:男友陪聊已开启");
	}

return false;
}
public boolean IsGroupAdmin(String GroupUin, String QQUin)
{
	if(QQUin.equals(MyUin)) return true;
	if(item.GetItemDataInt(GroupUin, "admin", "list", QQUin) == 1) return true;
	return false;
}

public boolean Module_群管指令(Object msg)
{
	if(msg.Message_UserUin.equals(MyUin))
	{
		if(msg.Message_Content.equals("查看统计数据"))
		{
			String str ="本群统计数据如下:";
			str = str + "\n总统计数据:";
			str = str + "\n消息总数:"+ItemCount.GetItemCountAll(msg.Message_GroupUin+"-消息总数");
			str = str + "\n普通消息:"+ItemCount.GetItemCountAll(msg.Message_GroupUin+"-普通消息");
			str = str + "\n图片消息:"+ItemCount.GetItemCountAll(msg.Message_GroupUin+"-图片消息");
			str = str + "\n卡片消息:"+ItemCount.GetItemCountAll(msg.Message_GroupUin+"-卡片消息");
			str = str + "\n语音消息:"+ItemCount.GetItemCountAll(msg.Message_GroupUin+"-语音消息");
			str = str + "\n红包消息:"+ItemCount.GetItemCountAll(msg.Message_GroupUin+"-红包消息");
			
			str = str + "\n\n今日统计数据:";
			str = str + "\n消息总数:"+ItemCount.GetItemCountToday(msg.Message_GroupUin+"-消息总数");
			str = str + "\n普通消息:"+ItemCount.GetItemCountToday(msg.Message_GroupUin+"-普通消息");
			str = str + "\n图片消息:"+ItemCount.GetItemCountToday(msg.Message_GroupUin+"-图片消息");
			str = str + "\n卡片消息:"+ItemCount.GetItemCountToday(msg.Message_GroupUin+"-卡片消息");
			str = str + "\n语音消息:"+ItemCount.GetItemCountToday(msg.Message_GroupUin+"-语音消息");
			str = str + "\n红包消息:"+ItemCount.GetItemCountToday(msg.Message_GroupUin+"-红包消息");
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, str);
			
			
		}	
		

		if(msg.Message_Content.startsWith("无视@"))
		{
			for(String Uin: msg.atList)
			{
				item.SetItemData(msg.Message_GroupUin, "admin", "ignorelist", Uin, 1);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + NameLog.getName(msg.Message_GroupUin,Uin) + " 已被无视,将忽视其所有指令");
			}
		}
		if(msg.Message_Content.startsWith("解除无视@"))
		{
			for(String Uin: msg.atList)
			{
				item.DeleteItem(msg.Message_GroupUin, "admin", "ignorelist", Uin);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + NameLog.getName(msg.Message_GroupUin,Uin) + " 已解除无视");
			}
		}
	}
	if(!MySwitch.CheckSwitch(msg.Message_GroupUin, "群管系统")) return false;
	
	if(msg.Message_UserUin.equals(MyUin))
	{
		if(msg.Message_Content.equals("开启全群复读检测"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "群复读检测", true);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已开启该群复读检测");
		}
		if(msg.Message_Content.equals("开启所有红包禁言"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "所有红包禁言", true);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已开启该群所有红包禁言");
		}
		if(msg.Message_Content.equals("关闭所有红包禁言"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "所有红包禁言", false);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已关闭该群所有红包禁言");
		}
		if(msg.Message_Content.equals("开启所有红包踢出"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "所有红包踢出", true);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已开启所有红包踢出");
		}
		if(msg.Message_Content.equals("关闭所有红包踢出"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "所有红包踢出", false);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已关闭所有红包踢出");
		}
		if(msg.Message_Content.equals("开启口令红包禁言"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "口令红包禁言", true);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已开启口令红包禁言");
		}
		if(msg.Message_Content.equals("关闭口令红包禁言"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "口令红包禁言", false);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已关闭口令红包禁言");
		}
	
		if(msg.Message_Content.equals("开启接龙红包禁言"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "接龙红包禁言", true);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已开启接龙红包禁言");
		}
		if(msg.Message_Content.equals("关闭接龙红包禁言"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "接龙红包禁言", false);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已关闭接龙红包禁言");
		}
		if(msg.Message_Content.equals("开启接龙红包踢出"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "接龙红包踢出", true);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已开启接龙红包踢出");
		}
		if(msg.Message_Content.equals("关闭接龙红包踢出"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "接龙红包踢出", false);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已关闭接龙红包踢出");
		}
		if(msg.Message_Content.equals("开启口令忽略"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "口令忽略", true);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "口令忽略已开启");
		}
		if(msg.Message_Content.equals("关闭口令忽略"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "口令忽略", false);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "口令忽略已关闭");
		}
		if(msg.Message_Content.equals("开启名片忽略"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "名片忽略", true);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "名片忽略已开启");
		}
		if(msg.Message_Content.equals("关闭名片忽略"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "名片忽略", false);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "名片忽略已关闭");
		}
		if(msg.Message_Content.equals("关闭全群复读检测"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "群复读检测", false);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已关闭该群复读检测");
		}
		if(msg.Message_Content.startsWith("设置全群复读检测数"))
		{
			int Among = Integer.parseInt(msg.Message_Content.substring(9).replace(" ",""));
			item.SetItemData(msg.Message_GroupUin,"admin","复读检测","检测次数",Among);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已设置复读检测数为"+Among);
		}
		if(msg.Message_Content.startsWith("设置全群复读禁言时间"))
		{
			int Among = FormTimeToSecond(msg.Message_Content.substring(10).replace(" ",""));
			item.SetItemData(msg.Message_GroupUin,"admin","复读检测","禁言时间",Among);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已设置复读禁言时间为"+secondToTime(Among));
		}
			if(msg.Message_Content.startsWith("添加代管 "))
		{
			String QQList = msg.Message_Content.substring(5);
				item.SetItemData(msg.Message_GroupUin, "admin", "list", QQList, 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已添加以下成员为代管:\n"+QQList);
			return false;
		}
		if(msg.Message_Content.startsWith("添加代管@"))
		{
			String text = "已添加以下成员为代管:\n";
			for(String AtQQ: msg.atList)
			{
				item.SetItemData(msg.Message_GroupUin, "admin", "list", AtQQ, 1);
				text = text + AtQQ + "\n";
			}
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
			return false;
		}
		if(msg.Message_Content.startsWith("删除代管@"))
		{
			String text = "已移除以下成员代管权限:\n";
			for(String AtQQ: msg.atList)
			{
				item.DeleteItem(msg.Message_GroupUin, "admin", "list", AtQQ);
				text = text + AtQQ + "\n";
			}
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
			return false;
		}
		if(msg.Message_Content.startsWith("删除代管 "))
		{
			String QQUin = msg.Message_Content.substring(5);
			item.DeleteItem(msg.Message_GroupUin, "admin", "list", QQUin);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已删除" + QQUin + "的代管权限");
			return false;
		}
		if(msg.Message_Content.equals("开启刷屏检测"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "刷屏检测", true);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "刷屏检测已开启");
		}
		if(msg.Message_Content.startsWith("设置个人检测频率"))
		{
			int i2 = Integer.parseInt(msg.Message_Content.substring(8));
			item.SetItemData(msg.Message_GroupUin, "群管系统", "群管系统", "检测时间", i2);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "检测频率已设定");
		}
		if(msg.Message_Content.startsWith("设置刷屏禁言时间"))
		{
			int i2 = Integer.parseInt(msg.Message_Content.substring(8));
			item.SetItemData(msg.Message_GroupUin, "群管系统", "群管系统", "禁言时间", i2);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "禁言时间已设定");
		}
		if(msg.Message_Content.startsWith("关闭刷屏检测"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "刷屏检测", false);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "刷屏检测已关闭");
		}
			if(msg.Message_Content.startsWith("禁言@"))
		{
			int index = msg.Message_Content.lastIndexOf(" ");
			String ChangeName = msg.Message_Content.substring(index + 1);
			long time = FormTimeToSecond(ChangeName);
			String QQList = "";
			for(String QQUin: msg.atList)
			{
				MyMsgApi.Group_Forbidden(msg.Message_GroupUin, QQUin, time);
				QQList = QQList + QQUin + " ";
			}
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + QQList + "已被禁言" + secondToTime(time));
		}
		if(msg.Message_Content.startsWith("全局拉黑@"))
		{
			String QQList = "";
			for(String QQUin: msg.atList)
			{
				QQList = QQList + "  " + QQUin;
				item.SetItemData("Flags", "admin", "blacklist", QQUin, 1);
				//MyMsgApi.Group_Kick(msg.Message_GroupUin, QQUin, true);
			}
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + QQList + "已全局拉黑");
			String[] MyList = msg.atList;
			new Thread(new Runnable()
			{
				public void run()
				{
					
					for(String QQUin: MyList)
					{
						
						ArrayList CheckedGroup = CheckUserInGroup(QQUin);
						for(String BCkeck: CheckedGroup)
						{
							
							if(OpenGroupList.contains(BCkeck))
							{
								if(MySwitch.CheckSwitch(BCkeck, "群管系统"))
								{
									MyMsgApi.Group_Kick(BCkeck, QQUin, true);
									String text = "用户被踢出:" + QQUin;
									text = text + "\n踢出来源:全局黑名单扫描";
									MyMsgApi.Message_Send_Group(BCkeck, text);
								}
							}
						}
					}
				}
			}).start();
		}
		if(msg.Message_Content.startsWith("全局拉黑 "))
		{
			String QQList = msg.Message_Content.substring(5);
			item.SetItemData("Flags", "admin", "blacklist", QQList, 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + QQList + "已全局拉黑");
			String[] MyList = new String[]{QQList};
			new Thread(new Runnable()
			{
				public void run()
				{
					
					for(String QQUin: MyList)
					{
						
						ArrayList CheckedGroup = CheckUserInGroup(QQUin);
						for(String BCkeck: CheckedGroup)
						{
							
							if(OpenGroupList.contains(BCkeck))
							{
								if(MySwitch.CheckSwitch(BCkeck, "群管系统"))
								{
									MyMsgApi.Group_Kick(BCkeck, QQUin, true);
									String text = "用户被踢出:" + QQUin;
									text = text + "\n踢出来源:全局黑名单扫描";
									MyMsgApi.Message_Send_Group(BCkeck, text);
								}
							}
						}
					}
				}
			}).start();
		}
	
		if(msg.Message_Content.equals("设置违禁名片处理随机修改"))
		{
			item.SetItemData(msg.Message_GroupUin, "admin", "cardChange", "status", 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已设置随机修改");
		}
		if(msg.Message_Content.equals("关闭违禁名片处理随机修改"))
		{
			item.SetItemData(msg.Message_GroupUin, "admin", "cardChange", "status", 0);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已关闭随机修改");
		}
		if(msg.Message_Content.equals("设置违禁名片处理群内提醒"))
		{
			item.SetItemData(msg.Message_GroupUin, "admin", "cardAlarm", "status", 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已设置群内提醒");
		}
		if(msg.Message_Content.equals("关闭违禁名片处理群内提醒"))
		{
			item.SetItemData(msg.Message_GroupUin, "admin", "cardAlarm", "status", 0);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已关闭群内提醒");
		}
		if(msg.Message_Content.startsWith("解禁@"))
		{
			String QQList = "";
			for(String QQUin: msg.atList)
			{
				MyMsgApi.Group_Forbidden(msg.Message_GroupUin, QQUin, 0);
				QQList = QQList + QQUin + " ";
			}
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + QQList + "已经解禁");
		}	if(msg.Message_Content.startsWith("解禁 "))
		{
				String QQList = msg.Message_Content.substring(3);
				MyMsgApi.Group_Forbidden(msg.Message_GroupUin, QQList, 0);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + QQList + "已经解禁");
		}		if(msg.Message_Content.startsWith("踢出 "))
		{
			String QQList = msg.Message_Content.substring(3);	
				MyMsgApi.Group_Kick(msg.Message_GroupUin, QQList, false);
			String text = "用户被踢出:" + QQList;
			text = text + "\n踢出来源:主人踢出";
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
		}
		if(msg.Message_Content.startsWith("踢出@"))
		{
			String QQList = "";
			for(String QQUin: msg.atList)
			{
				MyMsgApi.Group_Kick(msg.Message_GroupUin, QQUin, false);
				QQList = QQList + QQUin + " ";
			}
			String text = "用户被踢出:" + QQList;
			text = text + "\n踢出来源:主人踢出";
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
			//MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
		}
			if(msg.Message_Content.startsWith("删除全局黑名 "))
		{
			String Uin = msg.Message_Content.substring(6);
			Uin = Uin.replaceAll("\\s", "");
			item.DeleteItem("Flags", "admin", "blacklist", Uin);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + Uin + "已删除黑名单");
		}
		if(msg.Message_Content.equals("查看全局黑名单"))
		{
			String[] AdminList = item.MakeListForItem("Flags", "admin", "blacklist");
			String text = " 全局黑名单有如下人员:\n";
			for(String AdminUin: AdminList)
			{
				text = text + NameLog.getName(msg.Message_GroupUin, AdminUin) + "(" + AdminUin + ")\n";
			}
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
			return false;
		}
		if(msg.Message_Content.startsWith("拉黑@"))
		{
			String QQList = "";
			for(String QQUin: msg.atList)
			{
				item.SetItemData(msg.Message_GroupUin, "admin", "blacklist", QQUin, 1);
				MyMsgApi.Group_Kick(msg.Message_GroupUin, QQUin, true);
				QQList = QQList + QQUin + " ";
			}
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + QQList + "已被拉黑并踢出");
		}
			if(msg.Message_Content.startsWith("拉黑 "))
		{
			String QQList = msg.Message_Content.substring(3);	
				item.SetItemData(msg.Message_GroupUin, "admin", "blacklist", QQList, 1);	
				MyMsgApi.Group_Kick(msg.Message_GroupUin, QQList, true);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + QQList + "已被拉黑并踢出");
		}
				if(msg.Message_Content.startsWith("删除黑名 "))
		{
			String Uin = msg.Message_Content.substring(5);
			Uin = Uin.replaceAll("\\s", "");
			item.DeleteItem(msg.Message_GroupUin, "admin", "blacklist", Uin);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + Uin + "已删除黑名单");
		}
		if(msg.Message_Content.equals("清空黑名单"))
		{
			item.DeleteItemFile(msg.Message_GroupUin, "admin", "blacklist");
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "本群黑名单已清空");
		}
		if(msg.Message_Content.startsWith("添加白名单@"))
		{
			String QQList = "";
			for(String QQUin: msg.atList)
			{
				item.SetItemData(msg.Message_GroupUin, "admin", "WhiteList", QQUin, 1);
				QQList = QQList + QQUin + " ";
			}
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + QQList + "已加入白名单");
		}
			if(msg.Message_Content.startsWith("添加白名单 "))
		{
			String QQList = msg.Message_Content.substring(6);	
				item.SetItemData(msg.Message_GroupUin, "admin", "WhiteList", QQList, 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + QQList + "已加入白名单");
		}
		if(msg.Message_Content.startsWith("删除白名单@"))
		{
			String QQList = "";
			for(String QQUin: msg.atList)
			{
				item.DeleteItem(msg.Message_GroupUin, "admin", "WhiteList", QQUin);
				QQList = QQList + QQUin + " ";
			}
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + QQList + "已删除白名单");
		}
		      	if(msg.Message_Content.startsWith("添加管理 "))
	{
	String 域名 = item.GetItemData(X("ÉÂ"), "域名", "地址", "1");
	String text = msg.Message_Content.substring(5);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送“添加管理🈳QQ”");
			return false;
		}
		String group = msg.Message_GroupUin;
	 String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_gl.php?data=&skey="+skey+"&pskey="+pskey+"&uin="+text+"&group="+group+"&qq="+text+"&op=1");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "来自群主的礼物🎁:\n"+text+"被授予了管理员👑");
		}
      	if(msg.Message_Content.startsWith("取消管理 "))
	{
		String 域名 = item.GetItemData(X("ÉÂ"), "域名", "地址", "1");
	String text = msg.Message_Content.substring(5);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送“取消管理🈳QQ号”");
			return false;
		}
		String group = msg.Message_GroupUin;
		 String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	 String url = http.get(域名+"/API/qqgn/qun_gl.php?data=&skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&qq="+text+"&op=0");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "来自群主的惋惜🎺:\n"+text+"被取消了管理员💔");
		}
	if(msg.Message_Content.startsWith("添加管理@"))
	{
	String strQQ= msg.atList[0];
	String 域名 = item.GetItemData(X("ÉÂ"), "域名", "地址", "1");
		String group = msg.Message_GroupUin;
 String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
			 String url = http.get(域名+"/API/qqgn/qun_gl.php?data=&skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&qq="+strQQ+"&op=1");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "来自群主的礼物🎁:\n"+strQQ+"被授予了管理员👑");
	}
	if(msg.Message_Content.startsWith("取消管理@"))
	{
	String strQQ= msg.atList[0];
	String 域名 = item.GetItemData(X("ÉÂ"), "域名", "地址", "1");
		String group = msg.Message_GroupUin;
	 String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
			String url = http.get(域名+"/API/qqgn/qun_gl.php?data=&skey="+skey+"&pskey="+pskey+"&uin="+msg.Message_UserUin+"&group="+group+"&qq="+strQQ+"&op=0");
					MyMsgApi.Message_Send_Group(msg.Message_GroupUin, strQQ+"已被取消管理");
	}
	
		if(msg.Message_Content.startsWith("设置头衔@"))
		{
			for(String Uin: msg.atList)
			{
				int index = msg.Message_Content.lastIndexOf(" ");
				String ChangeName = msg.Message_Content.substring(index + 1);
				if(ChangeName.isEmpty())
				{
					MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入你要设置的头衔");
				}
				MyMsgApi.Group_SetTitle(msg.Message_GroupUin, Uin, ChangeName);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + Uin + "的头衔已经修改为:" + ChangeName);
			}
		}
		if(msg.Message_Content.startsWith("查询白名单"))
		{
			String[] AdminList = item.MakeListForItem(msg.Message_GroupUin, "admin", "WhiteList");
			String text = " 本群白名单有如下人员:\n";
			for(String AdminUin: AdminList)
			{
				text = text + NameLog.getName(msg.Message_GroupUin, AdminUin) + "(" + AdminUin + ")\n";
			}
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
			return false;
		}
	
		if(msg.Message_Content.equals("清空违禁词"))
		{
			item.DeleteItem(msg.Message_GroupUin, "admin", "banword", "list");
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "本群违禁词已清空");
		}
	
		if(msg.Message_Content.startsWith("添加违禁词 "))
		{
			String word = msg.Message_Content.substring(6);
			word = java.net.URLEncoder.encode(word);
			if(item.GetItemData(msg.Message_GroupUin, "admin", "banword", "list").contains("|" + word))
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "该违禁词已存在");
				return false;
			}
			else
			{
				item.SetItemData(msg.Message_GroupUin, "admin", "banword", "list", item.GetItemData(msg.Message_GroupUin, "admin", "banword", "list") + "|" + word);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已添加违禁词:" + java.net.URLDecoder.decode(word));
				return false;
			}
		}
		if(msg.Message_Content.startsWith("批量添加违禁词 "))
		{
			String word = msg.Message_Content.substring(8);
			String[] strArr = word.split("\\|");
			String buffAdd = "";
			for(String BanWord : strArr)
			{
				buffAdd = buffAdd + "|" + java.net.URLEncoder.encode(BanWord);
			}
			item.SetItemData(msg.Message_GroupUin, "admin", "banword", "list", item.GetItemData(msg.Message_GroupUin, "admin", "banword", "list") + buffAdd);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "违禁词已添加");
		}
		if(msg.Message_Content.startsWith("添加违禁名片词"))
		{
			String word = msg.Message_Content.substring(7).replace(" ","");
			word = java.net.URLEncoder.encode(word);
			if(item.GetItemData(msg.Message_GroupUin, "admin", "bancardword", "list").contains("|" + word))
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "该违禁词已存在");
				return false;
			}
			else
			{
				item.SetItemData(msg.Message_GroupUin, "admin", "bancardword", "list", item.GetItemData(msg.Message_GroupUin, "admin", "bancardword", "list") + "|" + word);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已添加名片违禁词:" + java.net.URLDecoder.decode(word));
				return false;
			}
		}
		if(msg.Message_Content.startsWith("改名@"))
		{
			for(String Uin: msg.atList)
			{
				int index = msg.Message_Content.lastIndexOf(" ");
				String ChangeName = msg.Message_Content.substring(index + 1);
				item.SetItemData(msg.Message_GroupUin, Uin, "Setting", "MyName", ChangeName);
				MyMsgApi.Group_ChangeName(msg.Message_GroupUin, Uin, ChangeName);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + Uin + "的昵称已经改名为:" + ChangeName);
			}
		}
		if(msg.Message_Content.startsWith("删除违禁名片词"))
		{
			String word = msg.Message_Content.substring(7).replace(" ","");
			if(word.equals(""))
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "你还没说你要删除哪个违禁词呢");
				return false;
			}
			word = java.net.URLEncoder.encode(word);
			String TempBanWord = item.GetItemData(msg.Message_GroupUin, "admin", "bancardword", "list");
			if(TempBanWord.contains("|" + word + "|"))
			{
				TempBanWord = TempBanWord.replace("|" + word + "|", "|");
				item.SetItemData(msg.Message_GroupUin, "admin", "bancardword", "list", TempBanWord);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "违禁词已删除");
			}
			else if(TempBanWord.endsWith("|" + word))
			{
				TempBanWord = TempBanWord.replace("|" + word, "");
				item.SetItemData(msg.Message_GroupUin, "admin", "bancardword", "list", TempBanWord);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "违禁词已删除");
			}
			else
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "你打算删除的违禁词不存在");
			}
		}
		   
		if(msg.Message_Content.startsWith("删除违禁词 "))
		{
			String word = msg.Message_Content.substring(6);
			if(word.equals(""))
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "你还没说你要删除哪个违禁词呢");
				return false;
			}
			word = java.net.URLEncoder.encode(word);
			String TempBanWord = item.GetItemData(msg.Message_GroupUin, "admin", "banword", "list");
			if(TempBanWord.contains("|" + word + "|"))
			{
				TempBanWord = TempBanWord.replace("|" + word + "|", "|");
				item.SetItemData(msg.Message_GroupUin, "admin", "banword", "list", TempBanWord);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "违禁词已删除");
			}
			else if(TempBanWord.endsWith("|" + word))
			{
				TempBanWord = TempBanWord.replace("|" + word, "");
				item.SetItemData(msg.Message_GroupUin, "admin", "banword", "list", TempBanWord);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "违禁词已删除");
			}
			else
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "你打算删除的违禁词不存在");
			}
		}
			if(msg.Message_Content.equals("开启口令红包禁言"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "口令红包禁言", true);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已开启口令红包禁言");
		}
		if(msg.Message_Content.equals("关闭口令红包禁言"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "口令红包禁言", false);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已关闭口令红包禁言");
		}
		if(msg.Message_Content.equals("开启口令红包踢出"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "口令红包踢出", true);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已开启口令红包踢出");
		}
		if(msg.Message_Content.equals("关闭口令红包踢出"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "口令红包踢出", false);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已关闭口令红包踢出");
		}
		if(msg.Message_Content.equals("违禁词列表"))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "本群违禁词如下:\n" + java.net.URLDecoder.decode(item.GetItemData(msg.Message_GroupUin, "admin", "banword", "list")));
		}
		if(msg.Message_Content.equals("全员禁言"))
		{
			MyMsgApi.Group_Forbidden_All(msg.Message_GroupUin, true);
		}
		if(msg.Message_Content.equals("全员解禁"))
		{
			MyMsgApi.Group_Forbidden_All(msg.Message_GroupUin, false);
		}
		if(msg.Message_Content.startsWith("警告@"))
		{
			String repeatMsg = msg.Message_Content;
			for(String Uin: msg.atList)
			{
				int raw = item.GetItemDataInt(msg.Message_GroupUin, Uin, "Setting", "警告次数");
				int limit = item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRemoveNum");
				raw = raw + 1;
				item.SetItemData(msg.Message_GroupUin, Uin, "Setting", "警告次数", raw);
				MyMsgApi.Group_Forbidden(msg.Message_GroupUin, Uin, item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbidTime"));
				if(raw >= limit)
				{
					MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + NameLog.getName(msg.Message_GroupUin, Uin) + " 被警告一次,总警告" + raw + "次,达到限制,踢出本群");
					new Thread(new Runnable()
					{
						public void run()
						{
							try
							{
								Thread.sleep(500);
								MyMsgApi.Group_Kick(msg.Message_GroupUin, Uin, false);
							}
							catch(Throwable e)
							{
								Toast(e);
							}
						}
					}).start();
				}
				else
				{
					MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + NameLog.getName(msg.Message_GroupUin, Uin) + " 被警告一次,总警告" + raw + "次,达到" + limit + "次就会被踢出群");
				}
			}
		}
		if(msg.Message_Content.equals("清空所有警告"))
		{
			List fs = Arrays.asList(new File(RootPath + "data/" + msg.Message_GroupUin + "/").listFiles());
			for(File ff: fs)
			{
				if(ff.isFile()) continue;
				item.SetItemData(msg.Message_GroupUin, ff.getName(), "Setting", "警告次数", 0);
			}
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已清除所有人的警告");
		}
		if(msg.Message_Content.startsWith("查看代管列表"))
		{
			String[] AdminList = item.MakeListForItem(msg.Message_GroupUin, "admin", "list");
			String text = "本群代管有如下人员:\n";
			for(String AdminUin: AdminList)
			{
				text = text + NameLog.getName(msg.Message_GroupUin, AdminUin) + "(" + AdminUin + ")\n";
			}
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
			return false;
		}
		if(msg.Message_Content.equals("开启违禁词撤回"))
		{
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRecall", 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "违禁词撤回已开启");
		}
		if(msg.Message_Content.equals("关闭违禁词撤回"))
		{
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRecall", 0);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "违禁词撤回已关闭");
		}
		if(msg.Message_Content.equals("开启违禁词禁言"))
		{
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbid", 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "违禁词禁言已开启");
		}
		if(msg.Message_Content.equals("关闭违禁词禁言"))
		{
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbid", 0);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "违禁词禁言已关闭");
		}
			if(msg.Message_Content.equals("开启违禁词踢出"))
		{
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRemove", 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "违禁词踢出已开启");
		}
		if(msg.Message_Content.equals("关闭违禁词踢出"))
		{
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRemove", 0);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "违禁词踢出已关闭");
		}
		if(msg.Message_Content.startsWith("设置禁言时间"))
		{
			String TextTime = msg.Message_Content.substring(6).replace(" ", "");
			try
			{
				int time = Integer.parseInt(TextTime);
				item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbidTime", time);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "违禁禁言时间被设置为:" + secondToTime(time));
			}
			catch(Exception e)
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "你输入的数值不正确");
			}
		}
		if(msg.Message_Content.startsWith("清空警告次数"))
		{
			String TextTime = msg.Message_Content.substring(6).replace(" ", "");
			item.SetItemData(msg.Message_GroupUin, TextTime, "Setting", "警告次数", 0);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已将" + TextTime + "的警告次数清空为0次");
		}
		if(msg.Message_Content.startsWith("设置警告踢出次数"))
		{
			String TextTime = msg.Message_Content.substring(8).replace(" ", "");
			try
			{
				int time = Integer.parseInt(TextTime);
				item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRemoveNum", time);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "警告踢出次数设置为:" + time);
			}
			catch(Exception e)
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "你输入的数值不正确");
			}
		}
		
		if(msg.Message_Content.startsWith("设置名片前缀 "))
		{
			String Text = msg.Message_Content.substring(7);
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "NameBefore", java.net.URLEncoder.encode(Text));
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "当前群名片前缀已被设置为:" + Text + "\n(尽量不要包含不能被设置为名片的字符)");
		}
		if(msg.Message_Content.startsWith("设置名片后缀 "))
		{
			String Text = msg.Message_Content.substring(7);
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "NameAfter", java.net.URLEncoder.encode(Text));
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "当前群名片后缀已被设置为:" + Text + "\n(尽量不要包含不能被设置为名片的字符)");
		}
		if(msg.Message_Content.equals("开启自动更改名片"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "自动改名", true);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "自动更改名片已开启");
		}
		if(msg.Message_Content.equals("关闭自动更改名片"))
		{
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "自动改名", false);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "自动更改名片已关闭");
		}
		if(msg.Message_Content.equals("开启回执作业踢出"))
		{
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "回执作业踢出", 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 回执作业踢出已开启");
		}
		if(msg.Message_Content.equals("关闭回执作业踢出"))
		{
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "回执作业踢出", 0);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 回执作业踢出已关闭");
		}
		if(msg.Message_Content.equals("开启回执作业全禁"))
		{
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "回执作业禁言", 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 回执作业禁言已开启");
		}
		if(msg.Message_Content.equals("关闭回执作业全禁"))
		{
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "回执作业禁言", 0);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 回执作业禁言已关闭");
		}
		if(msg.Message_Content.equals("开启回执作业撤回"))
		{
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "回执作业撤回", 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 回执作业撤回已开启");
		}
		if(msg.Message_Content.equals("关闭回执作业撤回"))
		{
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "回执作业撤回", 0);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 回执作业撤回已关闭");
		}
		if(msg.Message_Content.equals("关闭回执作业拉黑"))
		{
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "回执作业拉黑", 0);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 回执作业拉黑已关闭");
		}
		if(msg.Message_Content.equals("开启回执作业拉黑"))
		{
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "回执作业拉黑", 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 回执作业拉黑已开启");
		}
		if(msg.Message_Content.equals("开启所有卡片踢出"))
		{
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "所有卡片踢出", 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 所有卡片踢出已开启");
		}
		if(msg.Message_Content.equals("关闭所有卡片踢出"))
		{
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "所有卡片踢出", 0);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 所有卡片踢出已关闭");
		}
		if(msg.Message_Content.equals("开启所有卡片禁言"))
		{
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "所有卡片禁言", 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 所有卡片禁言已开启");
		}
		if(msg.Message_Content.equals("关闭所有卡片禁言"))
		{
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "所有卡片禁言", 0);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 所有卡片禁言已关闭");
		}
		if(msg.Message_Content.equals("开启所有卡片撤回"))
		{
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "所有卡片撤回", 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 所有卡片撤回已开启");
		}
		if(msg.Message_Content.equals("关闭所有卡片撤回"))
		{
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "所有卡片撤回", 0);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 所有卡片撤回已关闭");
		}
		if(msg.Message_Content.startsWith("设置所有卡片禁言时间"))
		{
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "所有卡片禁言时间", Integer.parseInt(msg.Message_Content.substring(10).replace(" ", "")));
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 所有卡片禁言时间已设定");
		}
		if(msg.Message_Content.equals("本群群管状态"))
		{
			String retText = "违禁词撤回:" + ((item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRecall") == 1) ? "开" : "关");
			retText = retText + "  违禁词禁言:" + ((item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbid") == 1) ? "开" : "关");
			retText = retText + "\n违禁词踢出:" + ((item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRemove") == 1) ? "开" : "关");
			retText = retText + "  警告次数:" + item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRemoveNum");
			retText = retText + "\n违禁词数量:" + item.GetItemData(msg.Message_GroupUin, "admin", "banword", "list").split("\\|").length;
			retText = retText + "  禁言时间:" + secondToTime(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbidTime"));
			
			retText = retText + "\n\n进群欢迎:" + (item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcome") == 0 ? "关" : "开");
			retText = retText + "  私聊欢迎:" + (item.GetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomePri").isEmpty() ? "关" : "开");
			retText = retText + "\n进群禁言:" + (item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenForbid") == 0 ? "0秒" : (item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenForbidTime") + "秒"));
				retText = retText + "\n退群拉黑:" + (item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupExit", "openExitBlacklist") == 0 ? "关" : "开");
			retText = retText + "  进群验证:" + (item.GetItemDataInt(msg.Message_GroupUin, "Setting", "Guard", "进群验证") == 0 ? "关" : "开");
			retText = retText + "\n\n名片前缀:" + java.net.URLDecoder.decode(item.GetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "NameBefore"));
			retText = retText + "\n名片后缀:" + java.net.URLDecoder.decode(item.GetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "NameAfter"));
			retText = retText + "\n自动改名:" + ((item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "AutoEditCard") == 1) ? "开" : "关");
			
			retText = retText + "\n\n本群黑名单数量:" + item.MakeListForItem(msg.Message_GroupUin, "admin", "blacklist").length;
			retText = retText + "\n本群白名单数量:" + item.MakeListForItem(msg.Message_GroupUin, "admin", "WhiteList").length;
			//"Flags", "admin", "blacklist"
			retText = retText + "\n全局黑名单数量:" + item.MakeListForItem("Flags", "admin", "blacklist").length;
			retText = retText + "\n\n卡片踢出:" + ((item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "所有卡片踢出") == 1) ? "开" : "关");
			retText = retText + "    卡片撤回:" + ((item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "所有卡片撤回") == 1) ? "开" : "关");
			retText = retText + "\n卡片禁言:" + ((item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "所有卡片禁言") == 1) ? "开" : "关");
			retText = retText + "    作业撤回:" + ((item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "回执作业撤回") == 1) ? "开" : "关");
			retText = retText + "\n作业全禁:" + ((item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "回执作业禁言") == 1) ? "开" : "关");
			retText = retText + "    作业踢出:" + ((item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "回执作业踢出") == 1) ? "开" : "关");
			retText = retText + "\n作业拉黑:" + ((item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "回执作业拉黑") == 1) ? "开" : "关");
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, retText);
		}
		return false;
	}
	return false;
}


		

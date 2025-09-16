public boolean Module_群管指令_代管(Object msg)
{
	if(!MySwitch.CheckSwitch(msg.Message_GroupUin, "群管系统")) return false;
	if(msg.Message_UserUin.equals(MyUin)) return false;
	if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "list", msg.Message_UserUin) == 1)
	{
		if(msg.Message_Content.equals("开启全群复读检测"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "无视复读检测") == 0)
			{
				if(IsGroupAdmin(msg.Message_GroupUin, msg.Message_UserUin))
				{
					return false;
				}
			}
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "群复读检测", true);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已开启该群复读检测");
		}
		if(msg.Message_Content.equals("关闭全群复读检测"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "无视复读检测") == 0)
			{
				if(IsGroupAdmin(msg.Message_GroupUin, msg.Message_UserUin))
				{
					return false;
				}
			}
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "群复读检测", false);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已关闭该群复读检测");
		}
		if(msg.Message_Content.startsWith("设置全群复读检测数"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "无视复读检测") == 0)
			{
				if(IsGroupAdmin(msg.Message_GroupUin, msg.Message_UserUin))
				{
					return false;
				}
			}
			int Among = Integer.parseInt(msg.Message_Content.substring(9).replace(" ", ""));
			item.SetItemData(msg.Message_GroupUin, "admin", "复读检测", "检测次数", Among);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已设置复读检测数为" + Among);
		}
		if(msg.Message_Content.startsWith("设置全群复读禁言时间"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "无视复读检测") == 0)
			{
				if(IsGroupAdmin(msg.Message_GroupUin, msg.Message_UserUin))
				{
					return false;
				}
			}
			int Among = FormTimeToSecond(msg.Message_Content.substring(10).replace(" ", ""));
			item.SetItemData(msg.Message_GroupUin, "admin", "复读检测", "禁言时间", Among);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已设置复读禁言时间为" + secondToTime(Among));
		}
		if(msg.Message_Content.startsWith("禁言@"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "禁言解禁") == 0)
			{
				if(IsGroupAdmin(msg.Message_GroupUin, msg.Message_UserUin))
				{
					return false;
				}
			}
			int index = msg.Message_Content.lastIndexOf(" ");
			String ChangeName = msg.Message_Content.substring(index + 1);
			long time = FormTimeToSecond(ChangeName);
			String QQList = "";
			for(String QQUin: msg.atList)
			{
				if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "list", QQUin) == 1)
				{
					MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + "没有权限");
					return false;
				}
				MyMsgApi.Group_Forbidden(msg.Message_GroupUin, QQUin, time);
				QQList = QQList + QQUin + " ";
			}
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + QQList + "已被禁言" + secondToTime(time));
		}
		if(msg.Message_Content.startsWith("解禁@"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "禁言解禁") == 0)
			{
				return false;
			}
			String QQList = "";
			for(String QQUin: msg.atList)
			{
				if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "list", QQUin) == 1)
				{
					MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + "没有权限");
					return false;
				}
				MyMsgApi.Group_Forbidden(msg.Message_GroupUin, QQUin, 0);
				QQList = QQList + QQUin + " ";
			}
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + QQList + "已经解禁");
		}
		if(msg.Message_Content.startsWith("踢出@"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "踢人") == 0)
			{
				return false;
			}
			String QQList = "";
			for(String QQUin: msg.atList)
			{
				if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "list", QQUin) == 1)
				{
					MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + "没有权限");
					return false;
				}
				MyMsgApi.Group_Kick(msg.Message_GroupUin, QQUin, false);
				QQList = QQList + QQUin + " ";
			}
			String text = "用户被踢出:" + QQList;
			text = text + "\n踢出来源:代管踢出";
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
		}
		if(msg.Message_Content.startsWith("拉黑@"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "黑名单更改") == 0)
			{
				return false;
			}
			String QQList = "";
			for(String QQUin: msg.atList)
			{
				if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "list", QQUin) == 1)
				{
					MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + "没有权限");
					return false;
				}
				item.SetItemData(msg.Message_GroupUin, "admin", "blacklist", QQUin, 1);
				MyMsgApi.Group_Kick(msg.Message_GroupUin, QQUin, false);
				QQList = QQList + QQUin + " ";
			}
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + QQList + "已被拉黑");
		}
		if(msg.Message_Content.startsWith("添加白名单@"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "白名单更改") == 0)
			{
				return false;
			}
			String QQList = "";
			for(String QQUin: msg.atList)
			{
				item.SetItemData(msg.Message_GroupUin, "admin", "WhiteList", QQUin,1);
				QQList = QQList + QQUin + " ";
			}
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + QQList + "已加入白名单");
		}
		if(msg.Message_Content.startsWith("删除白名单@"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "白名单更改") == 0)
			{
				return false;
			}
			String QQList = "";
			for(String QQUin: msg.atList)
			{
				item.DeleteItem(msg.Message_GroupUin, "admin", "WhiteList", QQUin);
				QQList = QQList + QQUin + " ";
			}
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + QQList + "已删除白名单");
		}
		if(msg.Message_Content.startsWith("设置头衔@"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改头衔") == 0)
			{
				return false;
			}
			for(String Uin: msg.atList)
			{
				if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "list", Uin) == 0)
				{
					MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + "没有权限");
					return false;
				}
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
		if(msg.Message_Content.equals("查询白名单"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "白名单更改") == 0)
			{
				return false;
			}
			String[] AdminList = item.MakeListForItem(msg.Message_GroupUin, "admin", "WhiteList");
			String text = " 本群白名单有如下人员:\n";
			for(String AdminUin: AdminList)
			{
				text = text + NameLog.getName(msg.Message_GroupUin, AdminUin) + "(" + AdminUin + ")\n";
			}
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
			return false;
		}
		if(msg.Message_Content.startsWith("删除黑名"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "黑名单更改") == 0)
			{
				return false;
			}
			String Uin = msg.Message_Content.substring(4).replace(" ","");
			Uin = Uin.replaceAll("\\s", "");
			item.DeleteItem(msg.Message_GroupUin, "admin", "blacklist", Uin);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + Uin + "已删除黑名单");
		}
		if(msg.Message_Content.equals("清空黑名单"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "黑名单更改") == 0)
			{
				return false;
			}
			item.DeleteItemFile(msg.Message_GroupUin, "admin", "blacklist");
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "本群黑名单已清空");
		}
		if(msg.Message_Content.equals("清空违禁词"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "违禁词更改") == 0)
			{
				return false;
			}
			item.DeleteItem(msg.Message_GroupUin, "admin", "banword", "list");
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "本群违禁词已清空");
		}
		if(msg.Message_Content.equals("查询黑名单"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "黑名单更改") == 0)
			{
				return false;
			}
			String[] list = item.MakeListForItem(msg.Message_GroupUin, "admin", "blacklist");
			String text = "本群的黑名单有:";
			for(String QQUin: list)
			{
				text = text + QQUin + "   ";
			}
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
		}
		if(msg.Message_Content.startsWith("添加违禁词 "))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "违禁词更改") == 0)
			{
				return false;
			}
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
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "违禁词更改") == 0)
			{
				return false;
			}
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
		if(msg.Message_Content.startsWith("改名@"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "改名") == 0)
			{
				return false;
			}
			for(String Uin: msg.atList)
			{
				if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "list", Uin) == 1)
				{
					MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + "没有权限");
					return false;
				}
				int index = msg.Message_Content.lastIndexOf(" ");
				String ChangeName = msg.Message_Content.substring(index + 1);
				item.SetItemData(msg.Message_GroupUin, Uin, "Setting", "MyName", ChangeName);
				MyMsgApi.Group_ChangeName(msg.Message_GroupUin, Uin, ChangeName);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + Uin + "的昵称已经改名为:" + ChangeName);
			}
		}
		if(msg.Message_Content.startsWith("删除违禁词 "))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "违禁词更改") == 0)
			{
				return false;
			}
			String word = msg.Message_Content.substring(6);
			if(word.equals(""))
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "你还没说你要删除哪个违禁词呢");
				return false;
			}
			word = java.net.URLEncoder.encode(word);
			String TempBanWord = item.GetItemData(msg.Message_GroupUin, "admin", "banword", "list");
			TempBanWord = TempBanWord.replace("|" + word, "");
			item.SetItemData(msg.Message_GroupUin, "admin", "banword", "list", TempBanWord);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "违禁词已删除");
		}
		if(msg.Message_Content.equals("违禁词列表"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "违禁词更改") == 0)
			{
				return false;
			}
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "本群违禁词如下:\n" + java.net.URLDecoder.decode(item.GetItemData(msg.Message_GroupUin, "admin", "banword", "list")));
		}
		if(msg.Message_Content.equals("全员禁言"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "全员禁言解禁") == 0)
			{
				return false;
			}
			MyMsgApi.Group_Forbidden_All(msg.Message_GroupUin, true);
		}
		if(msg.Message_Content.equals("全员解禁"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "全员禁言解禁") == 0)
			{
				return false;
			}
			MyMsgApi.Group_Forbidden_All(msg.Message_GroupUin, false);
		}
		if(msg.Message_Content.startsWith("警告@"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "警告") == 0)
			{
				return false;
			}
			String repeatMsg = msg.Message_Content;
			for(String Uin: msg.atList)
			{
				if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "list", Uin) == 1)
				{
					MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + "没有权限");
					return false;
				}
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
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "警告") == 0)
			{
				return false;
			}
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
		if(msg.Message_Content.equals("本群群管状态"))
		{
			String retText = "违禁词撤回:" + ((item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRecall") == 1) ? "开" : "关");
			retText = retText + "  违禁词禁言:" + ((item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbid") == 1) ? "开" : "关");
			retText = retText + "\n违禁词踢出:" + ((item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRemove") == 1) ? "开" : "关");
			retText = retText + "  警告次数:" + item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRemoveNum");
			retText = retText + "\n\n进群欢迎:" + (item.GetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomeText").isEmpty() ? "关" : "开");
			retText = retText + "  私聊欢迎:" + (item.GetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomePri").isEmpty() ? "关" : "开");
			retText = retText + "\n进群禁言:" + (item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenForbid") == 0 ? "0秒" : (item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenForbidTime") + "秒"));
			retText = retText + "  进群验证:" + (item.GetItemDataInt(msg.Message_GroupUin, "Setting", "Guard", "进群验证") == 0 ? "关" : "开");
			retText = retText + "\n\n名片前缀:" + item.GetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "NameBefore");
			retText = retText + "\n名片后缀:" + item.GetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "NameAfter");
			retText = retText + "\n自动改名:" + ((item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "AutoEditCard") == 1) ? "开" : "关");
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, retText);
		}
		
		
		if(msg.Message_Content.startsWith("设置警告踢出次数"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "警告") == 0)
			{
				return false;
			}
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
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改名片监测") == 0)
			{
				return false;
			}
			String Text = msg.Message_Content.substring(7);
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "NameBefore", java.net.URLEncoder.encode(Text));
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "当前群名片前缀已被设置为:" + Text + "\n(尽量不要包含不能被设置为名片的字符)");
		}
		if(msg.Message_Content.startsWith("设置名片后缀 "))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改名片监测") == 0)
			{
				return false;
			}
			String Text = msg.Message_Content.substring(7);
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "NameAfter", java.net.URLEncoder.encode(Text));
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "当前群名片后缀已被设置为:" + Text + "\n(尽量不要包含不能被设置为名片的字符)");
		}
		if(msg.Message_Content.equals("开启自动更改名片"))
		{
	if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改名片监测") == 0)
			{
				return false;
			}
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "自动改名", true);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "自动更改名片已开启");
		}
		if(msg.Message_Content.equals("关闭自动更改名片"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改名片监测") == 0)
			{
				return false;
			}
			MySwitch.ChangeSwitch(msg.Message_GroupUin, "自动改名", false);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "自动更改名片已关闭");
		}
		if(msg.Message_Content.equals("开启回执作业踢出"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改代码处理") == 0)
			{
				return false;
			}
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "回执作业踢出", 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 回执作业踢出已开启");
		}
		if(msg.Message_Content.equals("关闭回执作业踢出"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改代码处理") == 0)
			{
				return false;
			}
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "回执作业踢出", 0);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 回执作业踢出已关闭");
		}
		if(msg.Message_Content.equals("开启回执作业全禁"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改代码处理") == 0)
			{
				return false;
			}
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "回执作业禁言", 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 回执作业禁言已开启");
		}
		if(msg.Message_Content.equals("关闭回执作业全禁"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改代码处理") == 0)
			{
				return false;
			}
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "回执作业禁言", 0);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 回执作业禁言已关闭");
		}
		if(msg.Message_Content.equals("开启回执作业撤回"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改代码处理") == 0)
			{
				return false;
			}
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "回执作业撤回", 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 回执作业撤回已开启");
		}
		if(msg.Message_Content.equals("关闭回执作业撤回"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改代码处理") == 0)
			{
				return false;
			}
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "回执作业撤回", 0);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 回执作业撤回已关闭");
		}
		if(msg.Message_Content.equals("开启所有卡片踢出"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改代码处理") == 0)
			{
				return false;
			}
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "所有卡片踢出", 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 所有卡片踢出已开启");
		}
		if(msg.Message_Content.equals("关闭所有卡片踢出"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改代码处理") == 0)
			{
				return false;
			}
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "所有卡片踢出", 0);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 所有卡片踢出已关闭");
		}
		if(msg.Message_Content.equals("开启所有卡片禁言"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改代码处理") == 0)
			{
				return false;
			}
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "所有卡片禁言", 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 所有卡片禁言已开启");
		}
		if(msg.Message_Content.equals("关闭所有卡片禁言"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改代码处理") == 0)
			{
				return false;
			}
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "所有卡片禁言", 0);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 所有卡片禁言已关闭");
		}
		if(msg.Message_Content.equals("开启所有卡片撤回"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改代码处理") == 0)
			{
				return false;
			}
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "所有卡片撤回", 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 所有卡片撤回已开启");
		}
		if(msg.Message_Content.equals("关闭所有卡片撤回"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改代码处理") == 0)
			{
				return false;
			}
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "所有卡片撤回", 0);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 所有卡片撤回已关闭");
		}
		if(msg.Message_Content.startsWith("设置所有卡片禁言时间"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改代码处理") == 0)
			{
				return false;
			}
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

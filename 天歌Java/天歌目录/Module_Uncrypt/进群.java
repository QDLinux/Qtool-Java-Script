public void sendWelcome(String GroupUin, String UserUin)
{
	if(item.GetItemDataInt(GroupUin, "Setting", "GroupGuard", "OpenWelcome") == 1)
	{
		String SendText = item.GetItemData(GroupUin, "Setting", "GroupGuard", "OpenWelcomeCardText");
		if(!SendText.isEmpty())
		{
			SendText = ReplaceText(java.net.URLDecoder.decode(SendText), GroupUin, UserUin);
			SendText = ChangeText(SendText, Calendar.getInstance());
			MyMsgApi.Message_Send_Group_Card(GroupUin, SendText);
		}
		SendText = item.GetItemData(GroupUin, "Setting", "GroupGuard", "OpenWelcomeText");
		if(!SendText.isEmpty())
		{
			SendText = ReplaceText(java.net.URLDecoder.decode(SendText), GroupUin, UserUin);
			SendText = ChangeText(SendText, Calendar.getInstance());
			MyMsgApi.Message_Send_Group(GroupUin, SendText);
		}
		SendText = item.GetItemData(GroupUin, "Setting", "GroupGuard", "OpenWelcomePic");
		if(!SendText.isEmpty())
		{
			MyMsgApi.Message_Send_Group_image(GroupUin, SendText);
		}
		if(item.GetItemDataInt(GroupUin, "Setting", "GroupGuard", "OpenWelcomeVoice") == 1)
		{
			File f = new File(RootPath + "data/d_voice/");
			if(f.exists())
			{
				File[] files = f.listFiles();
				ArrayList VoiceList = new ArrayList();
				for(File path1: files)
				{
					if(path1.isFile())
					{
						VoiceList.add(path1.getName());
					}
				}
				if(VoiceList.size() > 0)
				{
					int ran = Math.random() * VoiceList.size();
					MyMsgApi.Message_Send_Group_voice(GroupUin, RootPath + "data/d_voice/" + VoiceList.get(ran));
				}
			}
		}
	}
	if(item.GetItemDataInt(GroupUin, "Setting", "GroupGuard", "OpenWelcomePri") == 1)
	{
		String MySendData = ReplaceText(java.net.URLDecoder.decode(item.GetItemData(GroupUin, "Setting", "GroupGuard", "OpenWelcomePriText")), GroupUin, UserUin);
		MyMsgApi.Message_Send_Private(GroupUin, UserUin, MySendData);
	}
	if(item.GetItemDataInt(GroupUin, "Setting", "GroupGuard", "OpenForbid") == 1)
	{
		MyMsgApi.Group_Forbidden(GroupUin, UserUin, item.GetItemDataInt(GroupUin, "Setting", "GroupGuard", "OpenForbidTime"));
	}
}
public String ReplaceText(String Text, String GroupUin, String UserUin)
{
	Object MoList = getGroupMembers(GroupUin);
	Text = Text.replace("[QQUin]", UserUin);
	Text = Text.replace("[GroupUin]", GroupUin);
	Text = Text.replace("[GroupName]", getTroopName(GroupUin));
	Text = Text.replace("[Name]", http.get(ServiceRoot + "jx/qqnick?qq=" + UserUin));
	Text = Text.replace("[Time]", GetNowTime());
	return Text;
}
ArrayList CardSeetings = new ArrayList();
ArrayList PicSeetings = new ArrayList();
public boolean Module_进群(Object msg)
{
	if(msg.Message_Type == 2)
	{
		if(CardSeetings.contains(msg.Message_UserUin))
		{
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomeCardText", java.net.URLEncoder.encode(msg.Message_Content));
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "卡片已设置");
			CardSeetings.remove(msg.Message_UserUin);
		}
	}
	if(msg.Message_Type == 1)
	{
		if(PicSeetings.contains(msg.Message_UserUin))
		{
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomePic", msg.Message_Content);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "图片已设置");
			PicSeetings.remove(msg.Message_UserUin);
		}
	}
	if(msg.Message_Type == 3)
	{
		if(MySwitch.CheckSwitch(msg.Message_GroupUin, "群管"))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "blacklist", msg.Message_UserUin) == 1)
			{
				String text = "用户被踢出:" + msg.Message_UserUin;
				text = text + "\n踢出来源:本群黑名单";
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
				//MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + msg.Message_UserUin + "为本群黑名单,将被移出群");
				MyMsgApi.Group_Kick(msg.Message_GroupUin, msg.Message_UserUin, false);
				return true;
			}
			if(item.GetItemDataInt("Flags", "admin", "blacklist", msg.Message_UserUin) == 1)
			{
				String text = "用户被踢出:" + msg.Message_UserUin;
				text = text + "\n踢出来源:全局黑名单";
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
				//MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + msg.Message_UserUin + "为全局黑名单,将被移出群");
				MyMsgApi.Group_Kick(msg.Message_GroupUin, msg.Message_UserUin, false);
				return true;
			}
		}
		if(MySwitch.CheckSwitch(msg.Message_GroupUin, "进群付费"))
		{
			return true;
		}
		sendWelcome(msg.Message_GroupUin, msg.Message_UserUin);
	}
	if(msg.Message_Type == 0)
	{
		if(msg.Message_UserUin.equals(mQQ) || item.GetItemDataInt(msg.Message_GroupUin, "admin", "list", msg.Message_UserUin) == 1)
		{
			if(!msg.Message_UserUin.equals(mQQ))
			{
				if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改进群欢迎") == 0)
				{
					return false;
				}
			}
			if(msg.Message_Content.equals("开启进群欢迎"))
			{
				item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcome", 1);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "进群欢迎已开启");
				return true;
			}
			if(msg.Message_Content.equals("关闭进群欢迎"))
			{
				item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcome", 0);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "进群欢迎已关闭");
				return true;
			}
			if(msg.Message_Content.equals("开启私聊欢迎"))
			{
				item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomePri", 1);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "私聊欢迎已开启");
				return true;
			}
			if(msg.Message_Content.equals("关闭私聊欢迎"))
			{
				item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomePri", 0);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "私聊欢迎已关闭");
				return true;
			}
			if(msg.Message_Content.equals("开启入群禁言"))
			{
				item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenForbid", 1);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "入群禁言已开启");
				return true;
			}
			if(msg.Message_Content.equals("关闭入群禁言"))
			{
				item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenForbid", 0);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "入群禁言已关闭");
				return true;
			}
			if(msg.Message_Content.startsWith("设置进群禁言时间"))
			{
				int time = FormTimeToSecond(msg.Message_Content.substring(8));
				item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenForbidTime", time);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已设置时间为:" + secondToTime(time));
				return true;
			}
			if(msg.Message_Content.equals("清除进群文字"))
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已清空文字欢迎词");
				item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomeText", "");
				return false;
			}
			if(msg.Message_Content.startsWith("设置进群文字"))
			{
				String text = java.net.URLEncoder.encode(msg.Message_Content.substring(6));
				item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomeText", text);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "进群欢迎语已设置");
				return true;
			}
			if(msg.Message_Content.equals("清除进群欢迎卡片"))
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已清除卡片");
				item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomeCardText", "");
				return true;
			}
			if(msg.Message_Content.equals("设置进群欢迎卡片"))
			{
				CardSeetings.add(msg.Message_UserUin);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送你要设置的卡片代码(卡片形式)");
				return true;
			}
			if(msg.Message_Content.equals("清除进群欢迎图片"))
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已清除卡片");
				item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomePic", "");
				return true;
			}
			if(msg.Message_Content.startsWith("设置进群欢迎图片"))
			{
				PicSeetings.add(msg.Message_UserUin);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送你要设置的图片");
				return true;
			}
			if(msg.Message_Content.startsWith("设置私聊文字"))
			{
				String text = java.net.URLEncoder.encode(msg.Message_Content.substring(6));
				item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomePriText", text);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "私聊欢迎语已设置");
				return true;
			}
			if(msg.Message_Content.equals("清除私聊文字"))
			{
				item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomePriText", "");
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "私聊欢迎语已清除");
				return true;
			}
			if(msg.Message_Content.equals("开启进群语音欢迎"))
			{
				String text = java.net.URLEncoder.encode(msg.Message_Content.substring(8));
				item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomeVoice", 1);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "进群语音欢迎已开启");
				return true;
			}
			if(msg.Message_Content.equals("关闭进群语音欢迎"))
			{
				item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomeVoice", 0);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "进群语音欢迎已关闭");
				return true;
			}
			if(msg.Message_Content.equals("查看进群欢迎词"))
			{
				String text = java.net.URLDecoder.decode(item.GetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomeText"));
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
				return true;
			}
			if(msg.Message_Content.equals("查看私聊欢迎词"))
			{
				String text = java.net.URLDecoder.decode(item.GetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomePriText"));
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
				return true;
			}
				if(msg.Message_Content.equals("设置进群类型卡片"))
			{
			String xml = "{\"app\":\"com.tencent.miniapp\",\"desc\":\"\",\"view\":\"notification\",\"ver\":\"0.0.0.1\",\"prompt\":\"欢迎新人入群\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"notification\":{\"appInfo\":{\"appName\":\"欢迎新人入群~\",\"appType\":4,\"appid\":[\"GroupUin\"],\"iconUrl\":\"https:\\/\\/q.qlogo.cn\\/headimg_dl?dst_uin=[QQUin]&spec=100\"},\"data\":[{\"title\":\"账号\",\"value\":\"[QQUin]\"},{\"title\":\"网名\",\"value\":\"[Name]\"},{\"title\":\"群号\",\"value\":\"[GroupUin]\"},{\"title\":\"群名\",\"value\":\"[GroupName]\"},{\"title\":\"入群日期\",\"value\":\"星期[wd]\"},{\"title\":\"入群日历\",\"value\":\"[nl]\"},{\"title\":\"入群时间\",\"value\":\"[Y]年[M]月[D]日 [h]:[m]:[s]\"}],\"title\":\"欢迎新人入群\",\"button\":[{\"name\":\"新人需知~欢迎新人，眼熟公告，眼熟群规\",\"action\":\"\"},{\"name\":\"请文明发言,勿涉黄,勿炸群,勿随意\n辱骂他人,建设美好群生活!\",\"action\":\"\"}],\"emphasis_keyword\":\"\"}},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"\"}";
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomePic", "");
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomeText", "");
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomeCardText", xml);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "设置成功\n当前为进群欢迎卡片1\n发送开启进群欢迎");
				return true;
			}
				if(msg.Message_Content.equals("设置进群类型音频"))
			{
			String xml = "{\"app\":\"com.tencent.qqvip_game_video\",\"desc\":\"com.tencent.qqvip_game_video\",\"view\":\"gameVideoSingle\",\"ver\":\"0.0.0.1\",\"prompt\":\"进群欢迎\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"gameVideoSingle\":{\"DATA10\":\"\",\"DATA11\":\"\",\"DATA12\":\"\",\"DATA13\":\"0\",\"DATA14\":\"videotest1\",\"DATA7\":\"http:\\/\\/ptlogin2.qq.com\\/ho_cross_domain?tourl=%68%74%74%70%73:\\/\\/%67%78%68%2e%76%69%70%2e%71%71%2e%63%6f%6d\\/%78%79%64%61%74%61\\/%66%75%6e%63%61%6c%6c\\/%66%75%6e%43%61%6c%6c\\/%32%37%33%33\\/%6d%65%64%69%61%2e%6d%70%34\"}},\"config\":{\"forward\":0},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"\"}";
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomePic", "");
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomeText", "");
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomeCardText", xml);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已设置进群类型音频\n请发送开启进群欢迎");
				return true;
			}
		
	    		if(msg.Message_Content.equals("设置进群欢迎手势"))
			{
			String text = "╔═╗╔═╗╔═╗╔═╗\n╟欢╢╟迎╢╟新╢╟人╢\n╚═╝╚═╝╚═╝╚═╝\n　　　     ︵\n　　　   /     \\\n　　　   | \\_/ |\n　　　   | - - -|                           国\n　　　   |　   |                    \n　　　_ |= - =| _                       际\n　      / \\|　    |/ \\               \n　  / \\|　 |　 |　 | / \\               友\n   /  |　 |　 |　 |　 |  \\       \n /    |　 |　 |　 |　 |　  \\           好\n(     (| -　 -　 -　 - |)　 )     \n \\　　　　　　　　 /             手\n   \\　　　　　　　 /         \n　 \\　　　　　     /                 势\n　  |  　　　          |            \n　  |  　　　          |\n进群时间[Time]\nQQ号：[QQUin] \n群号：[GroupUin] \n群名：[GroupName]";
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomePic", "");
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomeCardText", "");
			item.SetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "OpenWelcomeText", text);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "进群欢迎设置成功\n发送开启进群欢迎");
				return true;
			}	
			
	
		}
	}
	return false;
}

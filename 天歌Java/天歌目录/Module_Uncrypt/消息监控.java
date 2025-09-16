HashSet CheckedContent = new HashSet();
public String GetCheckedContent(Object revokeMsg)
{
	if(revokeMsg.msg == null)
	{
		return "";
	}
	String mStr = revokeMsg.msg;
	List mAtList = revokeMsg.atInfoTempList;
	if(mAtList == null)
	{
		return mStr;
	}
	StringBuilder builder = new StringBuilder(mStr);
	for(Object mObj: mAtList)
	{
		builder.replace(mObj.startPos, mObj.startPos + mObj.textLen, new String(new char[mObj.textLen]));
	}
	String mRet = builder.toString().replace(new String(new char[1]), "");
	return mRet;
}
public boolean Module_消息监控(Object msg)
{
	NameLog.setName(msg.Message_GroupUin, msg.Message_UserUin, msg.nickName);
	if(MySwitch.CheckSwitch(msg.Message_GroupUin, "口令忽略"))
	{
		if(msg.msg.msg.getClass().getSimpleName().equals("MessageForText") || msg.msg.msg.getClass().getSimpleName().equals("MessageForFoldMsg"))
		{
			if(msg.msg.msg.mPasswdRedBagSender != 0)
			{
				String mStrLeng = msg.Message_Content + ":" + msg.Message_UserUin + ":" + msg.msg.msg.mPasswdRedBagSender;
				
				if(!CheckedContent.contains(mStrLeng))
				{
					CheckedContent.add(mStrLeng);
					return true;
				}
			}
		}
	}
	if(msg.Message_UserUin.equals(MyUin)) return false;
	if(MySwitch.CheckSwitch(msg.Message_GroupUin, "群管系统"))
	{
		if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "blacklist", msg.Message_UserUin) == 1)
		{
			MyMsgApi.Group_Kick(msg.Message_GroupUin, msg.Message_UserUin, true);
		}
		if(item.GetItemDataInt("Flags", "admin", "blacklist", msg.Message_UserUin) == 1)
		{
			MyMsgApi.Group_Kick(msg.Message_GroupUin, msg.Message_UserUin, true);
		}
		String TheLockName = item.GetItemData(msg.Message_GroupUin, msg.Message_UserUin, "CardLock", "LockName");
		if(TheLockName.isEmpty())
		{
			if(MySwitch.CheckSwitch(msg.Message_GroupUin, "自动改名"))
			{
				String SaveName = msg.nickName;
				String BeforeName = java.net.URLDecoder.decode(item.GetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "NameBefore"));
				String AfterName = java.net.URLDecoder.decode(item.GetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "NameAfter"));
				if(!SaveName.startsWith(BeforeName))
				{
					SaveName = BeforeName + SaveName;
					item.SetItemData(msg.Message_GroupUin, msg.Message_UserUin, "Setting", "MyName", SaveName);
				}
				if(!SaveName.endsWith(AfterName))
				{
					SaveName = SaveName + AfterName;
					item.SetItemData(msg.Message_GroupUin, msg.Message_UserUin, "Setting", "MyName", SaveName);
				}
				if(!msg.nickName.equals(SaveName))
				{
					MyMsgApi.Group_ChangeName(msg.Message_GroupUin, msg.Message_UserUin, SaveName);
				}
			}
		}
		else
		{
			MyMsgApi.Group_ChangeName(msg.Message_GroupUin, msg.Message_UserUin, TheLockName);
		}
	}
	if(!MySwitch.CheckSwitch(msg.Message_GroupUin, "群管系统")) return false;
	if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "无视违禁词") == 1)
	{
		if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "list", msg.Message_UserUin) == 1) return false;
	}
	if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "ignorelist", msg.Message_UserUin) == 1) return true;
	if(msg.Message_Type == 1) return false;
	if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "WhiteList", msg.Message_UserUin) == 1) return false;
	if(msg.Message_Type == 2)
	{
		if(msg.Message_Content.contains("serviceID=\"107\"") || msg.Message_Content.contains("serviceID=\"60\""))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "回执作业禁言") == 1)
			{
				MyMsgApi.Group_Forbidden_All(msg.Message_GroupUin, true);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "由于@" + msg.nickName + " 发送了回执或者作业卡片已全员禁言");
			}
			if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "回执作业踢出") == 1)
			{
				MyMsgApi.Group_Kick(msg.Message_GroupUin, msg.Message_UserUin, false);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + " 发送了回执或者作业卡片已被踢出");
			}
			if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "回执作业撤回") == 1)
			{
				revokeMsg(msg.msg);
			}
			if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "回执作业拉黑") == 1)
			{
				item.SetItemData(msg.Message_GroupUin, "admin", "blacklist", msg.Message_UserUin, 1);
				MyMsgApi.Group_Kick(msg.Message_GroupUin, msg.Message_UserUin, true);
			}
		}
		if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "所有卡片禁言") == 1)
		{
			MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "所有卡片禁言时间"));
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + " 发送了卡片已被禁言");
		}
		if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "所有卡片踢出") == 1)
		{
			MyMsgApi.Group_Kick(msg.Message_GroupUin, msg.Message_UserUin, false);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + " 发送了卡片已被踢出");
			sendTip(msg.msg, "以下人员已被踢出\n来源:所有卡片踢出");
		}
		if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "所有卡片撤回") == 1)
		{
			revokeMsg(msg.msg);
		}
	
	}
	if(msg.Message_Type == 5)
	{
		if(MySwitch.CheckSwitch(msg.Message_GroupUin, "所有红包踢出"))
		{
			MyMsgApi.Group_Kick(msg.Message_GroupUin, msg.Message_UserUin, false);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + " 发送了红包已被踢出");
		}
		if(MySwitch.CheckSwitch(msg.Message_GroupUin, "所有红包禁言"))
		{
			long Time = item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbidTime");
			if(Time == 0) Time == 300;
			MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, Time);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + " 发送了红包已被禁言");
		}
		if(msg.mRedPackType == 6)
		{
			if(MySwitch.CheckSwitch(msg.Message_GroupUin, "口令红包踢出"))
			{
				MyMsgApi.Group_Kick(msg.Message_GroupUin, msg.Message_UserUin, false);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + " 发送了口令红包已被踢出");
			}
			if(MySwitch.CheckSwitch(msg.Message_GroupUin, "口令红包禁言"))
			{
				long Time = item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbidTime");
				if(Time == 0) Time == 300;
				MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, Time);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + " 发送了红包已被禁言");
			}
		}
		if(msg.mRedPackType == 21 || msg.mRedPackType == 24 || msg.mRedPackType == 25 || msg.mRedPackType == 27)
		{
			if(MySwitch.CheckSwitch(msg.Message_GroupUin, "接龙红包踢出"))
			{
				MyMsgApi.Group_Kick(msg.Message_GroupUin, msg.Message_UserUin, false);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + " 发送了接龙红包已被踢出");
			}
			if(MySwitch.CheckSwitch(msg.Message_GroupUin, "接龙红包禁言"))
			{
				long Time = item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbidTime");
				if(Time == 0) Time == 300;
				MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, Time);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + " 发送了接龙红包已被禁言");
			}
		}
		if(msg.mRedPackType == 20)
		{
			if(MySwitch.CheckSwitch(msg.Message_GroupUin, "一笔画红包踢出"))
			{
				MyMsgApi.Group_Kick(msg.Message_GroupUin, msg.Message_UserUin, false);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + " 发送了一笔画红包已被踢出");
			}
			if(MySwitch.CheckSwitch(msg.Message_GroupUin, "一笔画红包禁言"))
			{
				long Time = item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbidTime");
				if(Time == 0) Time == 300;
				MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, Time);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + " 发送了一笔画红包已被禁言");
			}
		}
		if(msg.mRedPackType == 13)
		{
			if(MySwitch.CheckSwitch(msg.Message_GroupUin, "语音红包踢出"))
			{
				MyMsgApi.Group_Kick(msg.Message_GroupUin, msg.Message_UserUin, false);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + " 发送了语音红包已被踢出");
			}
			if(MySwitch.CheckSwitch(msg.Message_GroupUin, "语音红包禁言"))
			{
				long Time = item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbidTime");
				if(Time == 0) Time == 300;
				MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, Time);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + " 发送了语音红包已被禁言");
			}
		}
		if(msg.mRedPackType == 2)
		{
			if(MySwitch.CheckSwitch(msg.Message_GroupUin, "普通红包踢出"))
			{
				MyMsgApi.Group_Kick(msg.Message_GroupUin, msg.Message_UserUin, false);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + " 发送了普通红包已被踢出");
			}
			if(MySwitch.CheckSwitch(msg.Message_GroupUin, "普通红包禁言"))
			{
				long Time = item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbidTime");
				if(Time == 0) Time == 300;
				MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, Time);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + " 发送了普通红包已被禁言");
			}
		}
		if(msg.mRedPackType == 3)
		{
			if(MySwitch.CheckSwitch(msg.Message_GroupUin, "拼手气红包踢出"))
			{
				MyMsgApi.Group_Kick(msg.Message_GroupUin, msg.Message_UserUin, false);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + " 发送了拼手气红包已被踢出");
			}
			if(MySwitch.CheckSwitch(msg.Message_GroupUin, "拼手气红包禁言"))
			{
				long Time = item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbidTime");
				if(Time == 0) Time == 300;
				MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, Time);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + " 发送了拼手气红包已被禁言");
			}
		}
		if(msg.mRedPackType == 8)
		{
			if(MySwitch.CheckSwitch(msg.Message_GroupUin, "专属红包踢出"))
			{
				MyMsgApi.Group_Kick(msg.Message_GroupUin, msg.Message_UserUin, false);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + " 发送了专属红包已被踢出");
			}
			if(MySwitch.CheckSwitch(msg.Message_GroupUin, "专属红包禁言"))
			{
				long Time = item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbidTime");
				if(Time == 0) Time == 300;
				MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, Time);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + " 发送了专属红包已被禁言");
			}
		}
	}
	String CheckWordRe = msg.Message_Content;
	if(MySwitch.CheckSwitch(msg.Message_GroupUin, "名片忽略"))
	{
		CheckWordRe = GetCheckedContent(msg.msg.msg);
	}
	String BanCardWord = item.GetItemData(msg.Message_GroupUin, "admin", "bancardword", "list");
	if(!BanCardWord.equals(""))
	{
		String[] WordList = BanCardWord.split("\\|");
		for(String word22: WordList)
		{
			if(word22.isEmpty()) continue;
			if(msg.nickName.matches(java.net.URLDecoder.decode(word22)))
			{
				if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "cardChange", "status") == 1)
				{
					MyMsgApi.Group_ChangeName(msg.Message_GroupUin, msg.Message_UserUin, "群员" + ((int)(Math.random() * 99999)));
				}
				if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "cardAlarm", "status") == 1)
				{
					MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + " 你的名片不符合本群规范,请及时修改");
				}
			}
		}
	}
	String BanWord = item.GetItemData(msg.Message_GroupUin, "admin", "banword", "list");
	if(!BanWord.equals(""))
	{
		String[] WordList = BanWord.split("\\|");
		for(String word: WordList)
		{
			if(word.equals("")) continue;
			if(java.net.URLDecoder.decode(word).endsWith("$re"))
			{
				String MyWord = java.net.URLDecoder.decode(word);
				if(CheckWordRe.matches(MyWord.substring(0, MyWord.length() - 3)))
				{
					if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRecall") == 1)
					{
						revokeMsg(msg.msg);
					}
					int aaa = 0;
					String text = "@" + msg.nickName + " 你触犯了违禁词";
					if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbid") == 1)
					{
						text = text + ",禁言" + secondToTime(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbidTime"));
						MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbidTime"));
						aaa = 1;
					}
					if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRemove") == 1)
					{
						item.SetItemData(msg.Message_GroupUin, msg.Message_UserUin, "Setting", "警告次数", item.GetItemDataInt(msg.Message_GroupUin, msg.Message_UserUin, "Setting", "警告次数") + 1);
						text = text + ",被警告一次,你一共被警告" + item.GetItemDataInt(msg.Message_GroupUin, msg.Message_UserUin, "Setting", "警告次数") + "次,被警告" + item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRemoveNum") + "次就会被踢出群";
						if(item.GetItemDataInt(msg.Message_GroupUin, msg.Message_UserUin, "Setting", "警告次数") >= item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRemoveNum"))
						{
							MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + " 你的警告次数已达到限制,将被踢出群");
							MyMsgApi.Group_Kick(msg.Message_GroupUin, msg.Message_UserUin, false);
							aaa = 1;
							return false;
						}
						aaa = 1;
					}
					if(aaa == 1)
					{
						MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
					}
					break;
				}
			}
			else if(CheckWordRe.toLowerCase().contains(java.net.URLDecoder.decode(word).toLowerCase()))
			{
				if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRecall") == 1)
				{
					revokeMsg(msg.msg);
				}
				int aaa = 0;
				String text = "@" + msg.nickName + " 你触犯了违禁词";
				if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbid") == 1)
				{
					text = text + ",禁言" + secondToTime(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbidTime"));
					MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbidTime"));
					aaa = 1;
				}
				if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRemove") == 1)
				{
					item.SetItemData(msg.Message_GroupUin, msg.Message_UserUin, "Setting", "警告次数", item.GetItemDataInt(msg.Message_GroupUin, msg.Message_UserUin, "Setting", "警告次数") + 1);
					text = text + ",被警告一次,你一共被警告" + item.GetItemDataInt(msg.Message_GroupUin, msg.Message_UserUin, "Setting", "警告次数") + "次,被警告" + item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRemoveNum") + "次就会被踢出群";
					if(item.GetItemDataInt(msg.Message_GroupUin, msg.Message_UserUin, "Setting", "警告次数") >= item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRemoveNum"))
					{
						MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + " 你的警告次数已达到限制,将被踢出群");
						MyMsgApi.Group_Kick(msg.Message_GroupUin, msg.Message_UserUin, false);
						aaa = 1;
						return false;
					}
					aaa = 1;
				}
				if(aaa == 1)
				{
					MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
				}
				break;
			}
		}
	}
	return false;
}

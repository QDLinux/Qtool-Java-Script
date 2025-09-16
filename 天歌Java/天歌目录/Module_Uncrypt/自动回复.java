public boolean Module_自动回复(Object msg)
{
	//if(!MySwitch.CheckSwitch(msg.Message_GroupUin, "自动回复")) return false;
	if(!msg.Message_UserUin.equals(MyUin))
	{
		String ReBackMsg = MyCheckText.CheckRetBackText(msg.Message_GroupUin, msg.Message_Content);
		if(!ReBackMsg.isEmpty())
		{
			if(!CheckRespone(msg))
			{
				if(ReBackMsg.startsWith("http://gchat.qpic.cn"))
				{
					MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, ReBackMsg);
				}
				else
				{
					MyMsgApi.Message_Send_Group(msg.Message_GroupUin, ReBackMsg);
				}
			}
		}
	}
	if(msg.Message_UserUin.equals(MyUin) || item.GetItemDataInt(msg.Message_GroupUin, "admin", "list", msg.Message_UserUin) == 1)
	{
		if(!msg.Message_UserUin.equals(mQQ))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改自动回复") == 0)
			{
				return false;
			}
		}
		if(msg.Message_Content.startsWith("添加精确回复 "))
		{
			String[] b2 = msg.Message_Content.substring(7).split("\\|");
			if(b2.length < 2)
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "你输入的格式不正确");
				return false;
			}
			MyCheckText.AddCheckText(msg.Message_GroupUin, b2[0], b2[1], 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "精确回复已添加\n触发:" + b2[0] + "\n回复:" + b2[1]);
		}
		if(msg.Message_Content.startsWith("添加模糊回复 "))
		{
			String[] b2 = msg.Message_Content.substring(7).split("\\|");
			if(b2.length < 2)
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "你输入的格式不正确");
				return false;
			}
			MyCheckText.AddCheckText(msg.Message_GroupUin, b2[0], b2[1], 2);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "模糊回复已添加\n触发:" + b2[0] + "\n回复:" + b2[1]);
		}
		if(msg.Message_Content.startsWith("查看精确回复列表"))
		{
			MyCheckText.LoadCheckText(msg.Message_GroupUin);
			Set Tempkeys = MyLogMap.get(msg.Message_GroupUin).keySet();
			Iterator iterator1 = Tempkeys.iterator();
			String retText = "当前群的回复信息如下:";
			while(iterator1.hasNext())
			{
				String keyName = iterator1.next() + "";
				retText = retText + "\n" + keyName;
			}
			retText = retText + "\n\n发送 删除精确回复+识别文字 来删除一项";
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, retText);
		}
		if(msg.Message_Content.startsWith("查看模糊回复列表"))
		{
			MyCheckText.LoadCheckText(msg.Message_GroupUin);
			Set Tempkeys = MyLogMap2.get(msg.Message_GroupUin).keySet();
			Iterator iterator1 = Tempkeys.iterator();
			String retText = "当前群的回复信息如下:";
			while(iterator1.hasNext())
			{
				String keyName = iterator1.next() + "";
				retText = retText + "\n" + keyName;
			}
			retText = retText + "\n\n发送 删除模糊回复+识别文字 来删除一项";
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, retText);
		}
		if(msg.Message_Content.startsWith("删除精确回复"))
		{
			MyCheckText.DelCheckText(msg.Message_GroupUin, msg.Message_Content.substring(6), 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已删除");
		}
		if(msg.Message_Content.startsWith("删除模糊回复"))
		{
			MyCheckText.DelCheckText(msg.Message_GroupUin, msg.Message_Content.substring(6), 2);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已删除");
		}
	}
	return false;
}
HashMap tempCheck = new HashMap();
HashMap CheckTick = new HashMap();
public boolean CheckRespone(Object msg)
{
	if(tempCheck.containsKey(msg.Message_Content))
	{
		long time2 = tempCheck.get(msg.Message_Content);
		if(msg.Message_Time - time2 < 2)
		{
			if(CheckTick.containsKey(msg.Message_Content))
			{
				int msg_tck = CheckTick.get(msg.Message_Content);
				msg_tck++;
				if(msg_tck > 6)
				{
					if(Math.random() < 0.5)
					{
						return true;
					}
				}
				CheckTick.put(msg.Message_Content, msg_tck);
			}
			else
			{
				CheckTick.put(msg.Message_Content, 1);
			}
		}
		else
		{
			CheckTick.remove(msg.Message_Content);
		}
		tempCheck.put(msg.Message_Content, msg.Message_Time);
	}
	tempCheck.put(msg.Message_GroupUin, tempCheck);
	return false;
}
HashMap MyLogMap = new HashMap();
HashMap MyLogMap2 = new HashMap();
public class CheckText
{
	public String CheckRetBackText(String GroupUin, String msgText)
	{
		LoadCheckText(GroupUin);
		if(MyLogMap.containsKey(GroupUin))
		{
			HashMap TempMsg = MyLogMap.get(GroupUin);
			if(TempMsg.containsKey(msgText))
			{
				return TempMsg.get(msgText);
			}
		}
		if(MyLogMap2.containsKey(GroupUin))
		{
			HashMap TempMsg = MyLogMap2.get(GroupUin);
			Set keys = TempMsg.keySet();
			Iterator iterator1 = keys.iterator();
			while(iterator1.hasNext())
			{
				String keyName = iterator1.next() + "";
				if(keyName.endsWith("$re"))
				{
					if(msgText.matches(keyName.substring(0, keyName.length() - 3)))
					{
						return TempMsg.get(keyName);
					}
				}
				if(msgText.contains(keyName))
				{
					return TempMsg.get(keyName);
				}
			}
		}
		return "";
	}
	public void AddCheckText(String GroupUin, String Command, String msgText, int type)
	{
		LoadCheckText(GroupUin);
		if(type == 1)
		{
			if(MyLogMap.containsKey(GroupUin))
			{
				HashMap TempMsg = MyLogMap.get(GroupUin);
				TempMsg.put(Command, msgText);
				MyLogMap.put(GroupUin, TempMsg);
			}
		}
		if(type == 2)
		{
			if(MyLogMap2.containsKey(GroupUin))
			{
				HashMap TempMsg = MyLogMap2.get(GroupUin);
				TempMsg.put(Command, msgText);
				MyLogMap2.put(GroupUin, TempMsg);
			}
		}
		SaveCheckText(GroupUin);
	}
	public void DelCheckText(String GroupUin, String Command, int type)
	{
		LoadCheckText(GroupUin);
		if(type == 1)
		{
			if(MyLogMap.containsKey(GroupUin))
			{
				HashMap TempMsg = MyLogMap.get(GroupUin);
				TempMsg.remove(Command);
				MyLogMap.put(GroupUin, TempMsg);
			}
		}
		if(type == 2)
		{
			if(MyLogMap2.containsKey(GroupUin))
			{
				HashMap TempMsg = MyLogMap2.get(GroupUin);
				TempMsg.remove(Command);
				MyLogMap2.put(GroupUin, TempMsg);
			}
		}
		SaveCheckText(GroupUin);
	}
	public void LoadCheckText(String GroupUin)
	{
		if(!MyLogMap.containsKey(GroupUin))
		{
			HashMap TempMap = MyFile.ReadObjectFromFile(RootPath + "data/" + GroupUin + "/自动回复_精确.dat");
			MyLogMap.put(GroupUin, TempMap);
		}
		if(!MyLogMap2.containsKey(GroupUin))
		{
			HashMap TempMap = MyFile.ReadObjectFromFile(RootPath + "data/" + GroupUin + "/自动回复_模糊.dat");
			MyLogMap2.put(GroupUin, TempMap);
		}
	}
	public void SaveCheckText(String GroupUin)
	{
		if(MyLogMap.containsKey(GroupUin))
		{
			MyFile.WriteObjectToFile(RootPath + "data/" + GroupUin + "/自动回复_精确.dat", MyLogMap.get(GroupUin));
		}
		if(MyLogMap2.containsKey(GroupUin))
		{
			MyFile.WriteObjectToFile(RootPath + "data/" + GroupUin + "/自动回复_模糊.dat", MyLogMap2.get(GroupUin));
		}
	}
}
CheckText MyCheckText = new CheckText();

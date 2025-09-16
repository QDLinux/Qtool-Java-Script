HashMap CheckedList = new HashMap();
HashMap CheckProcess = new HashMap();
public boolean module_成员检测(Object msg)
{
	if(!MySwitch.CheckSwitch(msg.Message_GroupUin, "群管系统")) return false;
	if(!msg.Message_UserUin.equals(MyUin)) return false;
	if(msg.Message_Content.startsWith("检测不发言大于"))
	{
		String MyTime = msg.Message_Content.substring(7);
		int setTime = FormTimeToSecond(MyTime);
		Object MemberList = getGroupMembers(msg.Message_GroupUin);
		String SeMsg = "@" + msg.nickName + " 检测结果:(" + secondToTime(setTime) + ")内没发言";
		ArrayList CheckedMember = new ArrayList();
		long NowTime = System.currentTimeMillis() / 1000;
		for(Object MemberInfo: MemberList)
		{
			if(MemberInfo.memberuin.equals("2854196306") || MemberInfo.memberuin.equals("2854196310") || MemberInfo.memberuin.equals("2854196312") || MemberInfo.memberuin.equals("2854196320") || MemberInfo.memberuin.equals("2854196925") || MemberInfo.memberuin.equals("2854196314") || MemberInfo.memberuin.equals("2854214473") || MemberInfo.memberuin.equals("2854196311") || MemberInfo.memberuin.equals("2854196316") || MemberInfo.memberuin.equals("2854214473")) continue;
			long TimeDis = NowTime - MemberInfo.last_active_time;
			if(TimeDis > setTime)
			{
				if(NowTime - MemberInfo.join_time < setTime) continue;
				CheckedMember.add(MemberInfo.memberuin);
				SeMsg = SeMsg + "\n" + MemberInfo.friendnick + "(" + MemberInfo.memberuin + ")";
				if(TimeDis > 315360000)
				{
					SeMsg = SeMsg + "\n最后发言:无记录";
				}
				else
				{
					SeMsg = SeMsg + "\n最后发言:" + secondToTime(TimeDis) + "前";
				}
			}
		}
		SeMsg = SeMsg + "\n发送 开始处决  即可处决以上成员";
		CheckedList.put(msg.Message_GroupUin, CheckedMember);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, SeMsg);
		return false;
	}
	if(msg.Message_Content.startsWith("检测加群时间晚于"))
	{
		String MyTime = msg.Message_Content.substring(8);
		int setTime = FormTimeToSecond(MyTime);
		Object MemberList = getGroupMembers(msg.Message_GroupUin);
		String SeMsg = "@" + msg.nickName + " 检测结果:(" + secondToTime(setTime) + ")之内加群";
		ArrayList CheckedMember = new ArrayList();
		long NowTime = System.currentTimeMillis() / 1000;
		for(Object MemberInfo: MemberList)
		{
			if(MemberInfo.memberuin.equals("2854196306") || MemberInfo.memberuin.equals("2854196310") || MemberInfo.memberuin.equals("2854196312") || MemberInfo.memberuin.equals("2854196320") || MemberInfo.memberuin.equals("2854196925") || MemberInfo.memberuin.equals("2854196314") || MemberInfo.memberuin.equals("2854214473") || MemberInfo.memberuin.equals("2854196311") || MemberInfo.memberuin.equals("2854196316") || MemberInfo.memberuin.equals("2854214473")) continue;
			long TimeDis = NowTime - MemberInfo.join_time;
			if(TimeDis < setTime)
			{
				CheckedMember.add(MemberInfo.memberuin);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String sdr = sdf.format(new Date(MemberInfo.join_time * 1000));
				SeMsg = SeMsg + "\n" + MemberInfo.friendnick + "(" + MemberInfo.memberuin + ")";
				SeMsg = SeMsg + "\n加群时间:" + sdr;
			}
		}
		SeMsg = SeMsg + "\n发送 开始处决  即可处决以上成员";
		CheckedList.put(msg.Message_GroupUin, CheckedMember);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, SeMsg);
		return false;
	}
	if(msg.Message_Content.equals("开始处决"))
	{
		if(CheckedList.containsKey(msg.Message_GroupUin))
		{
			ArrayList list = CheckedList.get(msg.Message_GroupUin);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "正在处决");
			new Thread(new Runnable()
			{
				public void run()
				{
					for(String Useruin: list)
					{
						Thread.sleep(500);
						MyMsgApi.Group_Kick(msg.Message_GroupUin, Useruin, false);
					}
					MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "处决完成");
				}
			}).start();
		}
	}
	if(msg.Message_Content.equals("查看扫描进度"))
	{
		if(CheckProcess.containsKey(msg.Message_GroupUin))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "本群已扫描:"+CheckProcess.get(msg.Message_GroupUin));
		}
		else
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "本群未在扫描中");
		}
	}
	if(msg.Message_Content.equals("扫描本群名片"))
	{
		if(CheckProcess.containsKey(msg.Message_GroupUin))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "本群上一轮扫描未结束,请耐心等待");
			return false;
		}
		String str = "扫描已经开始,为了防止屏蔽,扫描速度会稍慢,请耐心等待,查看进度请发送 查看扫描进度 来进行查看";
		sendTip(msg.msg, str);
		Toast("请注意,如果你未点进群列表刷新就扫描,将可能导致闪退等问题");
		CheckProcess.put(msg.Message_GroupUin, 0);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "扫描已开始\n本群成员数:" + getGroupMembers(msg.Message_GroupUin).size());
		new Thread(new Runnable()
		{
			public void run()
			{
				Thread.sleep(2000);
				Object MemberList = getGroupMembers(msg.Message_GroupUin);
				for(Object MemberInfo: MemberList)
				{
					if(MemberInfo.troopnick.isEmpty())
					{
						MemberInfo.troopnick = MemberInfo.friendnick;
					}
					if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "cardChange", "status") == 1)
					{
						String BanCardWord = item.GetItemData(msg.Message_GroupUin, "admin", "bancardword", "list");
						
						if(!BanCardWord.equals(""))
						{
							String[] WordList = BanCardWord.split("\\|");
							for(String word: WordList)
							{
								
								
								if(MemberInfo.troopnick.matches(java.net.URLDecoder.decode(word)))
								{
									int ii = Math.random() * 99999;
									
									MyMsgApi.Group_ChangeName(msg.Message_GroupUin,MemberInfo.memberuin, "群员"+((int)(Math.random()*99999)));
									Thread.sleep(300);
								}
							}
						}
						
					}
					if(MySwitch.CheckSwitch(msg.Message_GroupUin, "自动改名"))
					{
						String SaveName = MemberInfo.troopnick;
						String BeforeName = java.net.URLDecoder.decode(item.GetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "NameBefore"));
						String AfterName = java.net.URLDecoder.decode(item.GetItemData(msg.Message_GroupUin, "Setting", "GroupGuard", "NameAfter"));
						if(!SaveName.startsWith(BeforeName))
						{
							SaveName = BeforeName + SaveName;
							item.SetItemData(msg.Message_GroupUin, MemberInfo.memberuin, "Setting", "MyName", SaveName);
						}
						if(!SaveName.endsWith(AfterName))
						{
							SaveName = SaveName + AfterName;
							item.SetItemData(msg.Message_GroupUin, MemberInfo.memberuin, "Setting", "MyName", SaveName);
						}
						if(!msg.nickName.equals(SaveName))
						{
							MyMsgApi.Group_ChangeName(msg.Message_GroupUin, MemberInfo.memberuin, SaveName);
						}
					}
					CheckProcess.put(msg.Message_GroupUin, CheckProcess.get(msg.Message_GroupUin)+1);
				}
				CheckProcess.remove(msg.Message_GroupUin);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "名片扫描结束");
				
			}
		}).start();
		
	}
	return false;
}

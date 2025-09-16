public boolean module_刷屏检测(Object msg)
{
	if(MySwitch.CheckSwitch(msg.Message_GroupUin, "刷屏检测"))
	{
		if(msg.Message_Type == 3)return false;
		if(msg.Message_UserUin.equals(MyUin)) return false;
		if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "无视刷屏检测")==1)
		{
			if(IsGroupAdmin(msg.Message_GroupUin,msg.Message_UserUin))
			{
				return false;
			}
		}
		int testTime = item.GetItemDataInt(msg.Message_GroupUin, "群管系统", "群管系统", "检测时间");
		if(!UserLastCountSave.containsKey(msg.Message_GroupUin))
		{
			UserLastCountSave.put(msg.Message_GroupUin, new HashMap());
		}
		HashMap GroupMap = UserLastCountSave.get(msg.Message_GroupUin);
		if(!GroupMap.containsKey(msg.Message_UserUin))
		{
			GroupMap.put(msg.Message_UserUin, new HashMap());
		}
		HashMap UserTimeMap = GroupMap.get(msg.Message_UserUin);
		long NowTimeTest = msg.Message_Time / 2;
		int tick = 0;
		if(UserTimeMap.containsKey(NowTimeTest))
		{
			tick = UserTimeMap.get(NowTimeTest) + 1;
		}
		else
		{
			tick = 1;
		}
		UserTimeMap.put(NowTimeTest, tick);
		if(tick >= testTime)
		{
			MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, item.GetItemDataInt(msg.Message_GroupUin, "群管系统", "群管系统", "禁言时间"));
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.Message_UserUin + " 你发言速度太快了,先休息一下吧");
		}
		GroupMap.put(msg.Message_UserUin, UserTimeMap);
		UserLastCountSave.put(msg.Message_GroupUin, GroupMap);
	}
	return false;
}
HashMap UserLastCountSave = new HashMap();

HashMap LogMapGroup = new HashMap();
public boolean M_复读(Object msg)
{
	if(msg.Message_UserUin.equals(MyUin)) return false;
	if(MySwitch.CheckSwitch(msg.Message_GroupUin,"群复读检测"))
	{
		if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "无视复读检测")==1)
		{
			if(IsGroupAdmin(msg.Message_GroupUin,msg.Message_UserUin))
			{
				return false;
			}
		}
		if(LogMapGroup.containsKey(msg.Message_GroupUin))
		{
			ArrayList list = LogMapGroup.get(msg.Message_GroupUin);
			String CallText = list.get(0);
			String Content = msg.Message_Content;
			if(msg.Message_Type == 1)
			{
				Content = GetUUIDByLink(Content);
			}
			if(CallText.equals(Content))
			{
				list.add(Content);
			}
			else
			{
				list.clear();
			}
			if(list.size()==0)
			{
				LogMapGroup.remove(msg.Message_GroupUin);
			}
			else
			{
				LogMapGroup.put(msg.Message_GroupUin,list);
			}
			
			int Among = item.GetItemDataInt(msg.Message_GroupUin,"admin","复读检测","检测次数");
			if(list.size()>Among)
			{
				String text = "@[Name] 复读不好玩的,你静一下吧";
				text = text.replace("[Name]",NameLog.getName(msg.Message_GroupUin,msg.Message_UserUin));
				int ForbiddenTime = item.GetItemDataInt(msg.Message_GroupUin,"admin","复读检测","禁言时间");
				MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, ForbiddenTime);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
			}
		}
		else
		{
			ArrayList list = new ArrayList();
			String Content = msg.Message_Content;
			if(msg.Message_Type == 1)
			{
				Content = GetUUIDByLink(Content);
			}
			list.add(Content);
			LogMapGroup.put(msg.Message_GroupUin,list);
		}
	}
	return false;
}

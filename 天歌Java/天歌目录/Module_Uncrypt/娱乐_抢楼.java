

HashMap qianglouMap = new HashMap();
public boolean T_抢楼指令(Object data)
{
	if(data.Message_Content.equals("抢楼"))
	{
		if(MySwitch.CheckSwitch(data.Message_GroupUin, "娱乐系统"))
		{
			if(qianglouMap.containsKey(data.Message_GroupUin))
			{
				ArrayList aList = qianglouMap.get(data.Message_GroupUin);
				if(aList.contains(data.Message_UserUin))
				{
					MyMsg.FixAndSendMsg(data.Message_GroupUin, "@"+data.nickName+" 你已经抢过楼了,不能重复抢楼", DefInfo.CardDefImages, false);
				}
				else
				{
					if(aList.size()<10)
					{
						aList.add(data.Message_UserUin);
						String retText = "@"+data.nickName+"\n";
						retText = retText + "抢楼成功\n你是第"+aList.size()+"个抢楼的\n获得金币:"+((11-aList.size())*1000);
						MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
					}
					else
					{
						aList.add(data.Message_UserUin);
						String retText = "@"+data.nickName+"\n";
						retText = retText + "抢楼成功\n你是第"+aList.size()+"个抢楼的";
						MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
					}
					
				}
			}
		}
	}
	if(!data.Message_UserUin.equals(mQQ))return false;
	if(data.Message_Content.equals("开启抢楼"))
	{
		item.SetItemData(data.Message_GroupUin,"GameDic","抢楼","开启",1);
		MyMsgApi.Message_Send_Group(data.Message_GroupUin, "本群的抢楼已开启");
	}
	if(data.Message_Content.equals("关闭抢楼"))
	{
		item.SetItemData(data.Message_GroupUin,"GameDic","抢楼","开启",0);
		MyMsgApi.Message_Send_Group(data.Message_GroupUin, "本群的抢楼已关闭");
	}
	return false;
	
}
int LastVTime = -1;

public void GetFloor_TimeReceive(Calendar NowTime)
{
	if(NowTime.get(Calendar.MINUTE)==0 && LastVTime!=NowTime.get(Calendar.HOUR_OF_DAY))
	{
		LastVTime=NowTime.get(Calendar.HOUR_OF_DAY);
		qianglouMap.clear();
		for(String OpenGroup : OpenGroupList)
		{
			if(MySwitch.CheckSwitch(OpenGroup, "娱乐系统"))
			{
				if(item.GetItemDataInt(OpenGroup,"GameDic","抢楼","开启")==1)
				{
					
					ArrayList userList = new ArrayList();
					qianglouMap.put(OpenGroup,userList);
					item.SetItemData(OpenGroup,"GameDic","抢楼","当前抢楼",NowTime.get(Calendar.HOUR_OF_DAY));
					MyMsg.FixAndSendMsg(OpenGroup, "当前抢楼开始了\n大家可以发送 抢楼 来进行抢楼", DefInfo.CardDefImages, false);
				}
			}
		}
	}
	if(NowTime.get(Calendar.MINUTE)==6 && LastVTime==NowTime.get(Calendar.HOUR_OF_DAY))
	{
		for(String OpenGroup : OpenGroupList)
		{
			if(qianglouMap.containsKey(OpenGroup))
			{
				ArrayList userList = qianglouMap.get(OpenGroup);
				if(userList.size()==0)
				{
					MyMsg.FixAndSendMsg(OpenGroup, "抢楼结束\n本轮无人抢楼", DefInfo.CardDefImages, false);
				}
				else
				{
					String str = "抢楼结束\n本轮抢楼第一名为:"+NameLog.getName(userList.get(0))+"("+userList.get(0)+")";
					MyMsg.FixAndSendMsg(OpenGroup, str, DefInfo.CardDefImages, false);
				}
			}
		}
		qianglouMap.clear();
	}
	
}
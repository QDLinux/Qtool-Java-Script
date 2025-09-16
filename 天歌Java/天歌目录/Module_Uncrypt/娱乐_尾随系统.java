

public boolean G_尾随(Object data)
{
	if(data.Message_Content.startsWith("尾随@"))
	{
		if((Math.random() * 4) < 1)
		{
			for(String Uin: data.atList)
			{
				String retText = "@" + data.nickName + "\n";
				retText = retText + "尾随被发现了\n";
				retText = retText + "被" + NameLog.getName(data.Message_GroupUin, Uin) + "暴打一顿";
				retText = retText + "住院3分钟";
				MyMsgApi.Group_Forbidden(data.Message_GroupUin, data.Message_UserUin, 180);
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				return false;
			}
		}
		for(String Uin: data.atList)
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "尾随", Uin);
			String retText = "@" + data.nickName + "\n";
			retText = retText + "尾随成功\n";
			retText = retText + "你尾随在" + NameLog.getName(data.Message_GroupUin, Uin) + "身后伺机待发";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
	}
	if(data.Message_Content.startsWith("强奸@"))
	{
		String UinBack = item.GetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "尾随");
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "尾随", "");
		if(data.Message_Time - item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "上次强奸时间") < 30)
		{
			String retText = "@" + data.nickName + "\n";
			retText = retText + "你身体还虚着呢\n欲望这么强烈吗";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "上次强奸时间", data.Message_Time);
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "NoJi") == 1)
		{
			String retText = "@" + data.nickName + "\n";
			retText = retText + "🐔🐔都没有\n强奸墙角去吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		for(String Uin: data.atList)
		{
			if(!UinBack.equals(Uin))
			{
				String retText = "@" + data.nickName + "\n";
				retText = retText + "光天化日下竟敢强奸别人\n进牢里反思2分钟吧";
				MyMsgApi.Group_Forbidden(data.Message_GroupUin, data.Message_UserUin, 120);
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				return false;
			}
			if((Math.random() * 5) < 1)
			{
				String retText = "@" + data.nickName + "\n";
				retText = retText + "强奸失败\n" + NameLog.getName(data.Message_GroupUin, Uin) + "反手切掉了你的🐔🐔";
				item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "NoJi", 1);
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				return false;
			}
			int rnd = (int)(Math.random() * 20000);
			String retText = "@" + data.nickName + "\n";
			retText = retText + "强奸成功\n你在" + NameLog.getName(data.Message_GroupUin, Uin) + "的身体中播种了你的种子";
			retText = retText + "\n并好运获得了" + rnd + "金币";
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + rnd);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "强奸成功次数", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "强奸成功次数") + 1);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, "http://gchat.qpic.cn/gchatpic_new/3124532526/1124795732-2356032944-977C5AB3867C88F379162B3823142F81/0?term=2", false);
			return false;
		}
	}
	if(data.Message_Content.equals("修复鸡鸡"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "NoJi") == 0)
		{
			String retText = "@" + data.nickName + "\n";
			retText = retText + "修复失败\n你修个鸡儿";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") < 10000)
		{
			String retText = "@" + data.nickName + "\n";
			retText = retText + "修复失败\n没钱还想学别人玩强奸?";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "commonData", "Mark", item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "commonData", "Mark") - 10000);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "NoJi", 0);
		String retText = "@" + data.nickName + "\n";
		retText = retText + "修复成功\n花费了10000金币";
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	return false;
}


public boolean G_签到(Object data)
{
	if(data.Message_Content.equals("签到"))
	{
		if(getDay() == item.GetItemDataInt(data.Message_GroupUin,"GameDic", data.Message_UserUin, "最后签到时间"))
		{
			MyMsg.FixAndSendMsg(data.Message_GroupUin,"@" + data.nickName + "\n你今天已经签到了,不能重复签到",DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "最后签到时间", getDay());
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "签到总天数", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "签到总天数") + 1);
		String retText = "@" + data.nickName + "\n签到成功!\n";
		int rnd = (int)(Math.random() * (5000) + 100);
		retText = retText + "获得金币:" + rnd + "\n";
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") + rnd);
		rnd = (int)(Math.random() * (10) + 1);
		retText = retText + "获得炸弹:" + rnd + "\n";
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "炸弹", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "炸弹") + rnd);
		rnd = (int)(Math.random() * (10) + 1);
		retText = retText + "获得闷砖:" + rnd + "\n";
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "闷砖", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "闷砖") + rnd);
		rnd = (int)(Math.random() * (1000) + 100);
		retText = retText + "获得经验:" + rnd;
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "经验") + rnd);
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("领取每日礼包"))
	{
		if(getDay() == item.GetItemDataInt(data.Message_GroupUin, "GameDic",data.Message_UserUin, "每日礼包领取时间"))
		{
			MyMsg.FixAndSendMsg(data.Message_GroupUin,"@" + data.nickName + "\n你今天领取过礼包了,不能重复领取",DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic",data.Message_UserUin, "每日礼包领取时间", getDay());
		String retText = "领取成功,获得1000金币";
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + 1000);
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("领取每月礼包"))
	{
		if(getMonth() == item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "每月礼包领取时间"))
		{
			MyMsg.FixAndSendMsg(data.Message_GroupUin,"@" + data.nickName + "\n你这个月领取过礼包了,不能重复领取",DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin,"GameDic", data.Message_UserUin, "每月礼包领取时间", getMonth());
		String retText = "领取成功,获得5000金币";
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") + 5000);
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("领取新人礼包"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "新人礼包") == 1)
		{
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "@" + data.nickName + "\n你已经领取过新人礼包了,不能再领取了",DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic",data.Message_UserUin, "新人礼包", 1);
		String retText = "@" + data.nickName + "\n领取新人礼包成功\n获得金币:50000\n获得炸弹:30\n获得闷砖:30";
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") + 50000);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "炸弹", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "炸弹") + 30);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "闷砖", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "闷砖") + 30);
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	return false;
}
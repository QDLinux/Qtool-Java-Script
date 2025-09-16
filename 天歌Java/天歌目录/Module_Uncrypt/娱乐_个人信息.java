

public boolean G_个人信息(Object msg)
{
	if(msg.Message_Type == 1)
	{
		item.SetItemData(msg.Message_GroupUin, "GameDic", msg.Message_UserUin, "图片发送数量", item.GetItemDataInt(msg.Message_GroupUin, "GameDic", msg.Message_UserUin, "图片发送数量") + 1);
	}
	if(msg.Message_Type == 0)
	{
		if(msg.Message_Content.equals("个人信息"))
		{
			String Text = "@" + msg.nickName + "\n[你的金币]:" + item.GetItemDataInt(msg.Message_GroupUin, "GameDic", msg.Message_UserUin, "金币");
			Text = Text + "\n[你的经验]:" + item.GetItemDataInt(msg.Message_GroupUin, "GameDic", msg.Message_UserUin, "经验");
			Text = Text + "\n[炸弹数量]:" + item.GetItemDataInt(msg.Message_GroupUin, "GameDic", msg.Message_UserUin, "炸弹");
			Text = Text + "\n[闷砖数量]:" + item.GetItemDataInt(msg.Message_GroupUin, "GameDic", msg.Message_UserUin, "闷砖");
			Text = Text + "\n[签到累计]:" + item.GetItemDataInt(msg.Message_GroupUin, "GameDic", msg.Message_UserUin, "签到总天数");
			Text = Text + "\n[金币卡]:" + item.GetItemDataInt(msg.Message_GroupUin, "GameDic", msg.Message_UserUin, "金币卡");
			Text = Text + "\n[经验卡]:" + item.GetItemDataInt(msg.Message_GroupUin, "GameDic", msg.Message_UserUin, "经验卡");
			Text = Text + "\n[禁言卡]:" + item.GetItemDataInt(msg.Message_GroupUin, "GameDic", msg.Message_UserUin, "禁言卡");
			Text = Text + "\n[解禁卡]:" + item.GetItemDataInt(msg.Message_GroupUin, "GameDic", msg.Message_UserUin, "解禁卡");
			Text = Text + "\n[随机卡]:" + item.GetItemDataInt(msg.Message_GroupUin, "GameDic", msg.Message_UserUin, "随机卡");
			int bCode = item.GetItemDataInt(msg.Message_GroupUin, "GameDic", msg.Message_UserUin, "当前佩戴称号");
			Text = Text + "\n[当前称号]:" + tName[bCode];
			if(bCode > 0 && bCode < 8)
			{
				MyMsg.FixAndSendMsg(msg.Message_GroupUin, Text, PicLink[bCode - 1], false);
			}
			else
			{
				MyMsg.FixAndSendMsg(msg.Message_GroupUin, Text, DefInfo.CardDefImages, false);
			}
			return false;
		}
		if(msg.Message_Content.startsWith("查看@"))
		{
			for(String Uin: msg.atList)
			{
				String Text = "查看的人:" + NameLog.getName(msg.Message_GroupUin, Uin) + "\n[他的金币]:" + item.GetItemDataInt(msg.Message_GroupUin, "GameDic", Uin, "金币");
				Text = Text + "\n[他的经验]:" + item.GetItemDataInt(msg.Message_GroupUin, "GameDic", Uin, "经验");
				Text = Text + "\n[炸弹数量]:" + item.GetItemDataInt(msg.Message_GroupUin, "GameDic", Uin, "炸弹");
				Text = Text + "\n[闷砖数量]:" + item.GetItemDataInt(msg.Message_GroupUin, "GameDic", Uin, "闷砖");
				Text = Text + "\n[签到累计]:" + item.GetItemDataInt(msg.Message_GroupUin, "GameDic", Uin, "签到总天数");
				Text = Text + "\n[金币卡]:" + item.GetItemDataInt(msg.Message_GroupUin, "GameDic", Uin, "金币卡");
				Text = Text + "\n[经验卡]:" + item.GetItemDataInt(msg.Message_GroupUin, "GameDic", Uin, "经验卡");
				Text = Text + "\n[禁言卡]:" + item.GetItemDataInt(msg.Message_GroupUin, "GameDic", Uin, "禁言卡");
				Text = Text + "\n[解禁卡]:" + item.GetItemDataInt(msg.Message_GroupUin, "GameDic", Uin, "解禁卡");
				Text = Text + "\n[随机卡]:" + item.GetItemDataInt(msg.Message_GroupUin, "GameDic", Uin, "随机卡");
				int bCode = item.GetItemDataInt(msg.Message_GroupUin, "GameDic", Uin, "当前佩戴称号");
				Text = Text + "\n[当前称号]:" + tName[bCode];
				if(bCode > 0 && bCode < 8)
				{
					MyMsg.FixAndSendMsg(msg.Message_GroupUin, Text, PicLink[bCode - 1], false);
				}
				else
				{
					MyMsg.FixAndSendMsg(msg.Message_GroupUin, Text, DefInfo.CardDefImages, false);
				}
			}
		}
	}
	return false;
}
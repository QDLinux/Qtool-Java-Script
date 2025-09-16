

ArrayList BoomFlag = new ArrayList();
public boolean G_炸弹(Object data)
{
	if(data.Message_Content.equals("拆炸弹"))
	{
		if(!BoomFlag.contains(data.Message_GroupUin))
		{
			String retText = "@" + data.nickName + "\n当前没有炸弹可以拆哦";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			if(!data.Message_UserUin.equals(mQQ))
			{
				item.SetItemData(data.Message_GroupUin, "GameDic", "游戏记录", "最后说话", data.Message_UserUin);
			}
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "拆弹钳") <= 0)
		{
			String retText = "@" + data.nickName + "\n你的拆弹钳不足哦\n请发送 道具商城 购买";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		}
		else
		{
			BoomFlag.remove(data.Message_GroupUin);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "拆弹钳", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "拆弹钳") - 1);
			if((Math.random() * 10) < 1)
			{
				String retText = "@" + data.nickName + "\n当你正在聚精会神地拆炸弹的时候\n你的眼前闪起一片亮光\n你飞到了天上\n被送到医院治疗1分钟";
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				MyMsgApi.Group_Forbidden(data.Message_GroupUin, data.Message_UserUin, 60);
				if(!data.Message_UserUin.equals(mQQ))
				{
					item.SetItemData(data.Message_GroupUin, "GameDic", "游戏记录", "最后说话", data.Message_UserUin);
				}
				return false;
			}
			else
			{
				String retText = "本群的炸弹被拆除了\n大家可以自由地活动了";
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				if(!data.Message_UserUin.equals(mQQ))
				{
					item.SetItemData(data.Message_GroupUin, "GameDic", "游戏记录", "最后说话", data.Message_UserUin);
				}
				return false;
			}
		}
	}
	if(!data.Message_UserUin.equals(mQQ) && BoomFlag.contains(data.Message_GroupUin))
	{
		int time = (int)(Math.random() * 60 + 1);
		MyMsgApi.Group_Forbidden(data.Message_GroupUin, data.Message_UserUin, time);
		String retText = "轰!!!\n@" + data.nickName + "踩到了炸弹\n需要治疗" + time + "秒";
		item.SetItemData(data.Message_GroupUin, "GameDic", "游戏记录", "最后说话", data.Message_UserUin);
		BoomFlag.remove(data.Message_GroupUin);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "被炸次数", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "被炸次数") + 1);
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		if(!data.Message_UserUin.equals(mQQ))
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", "游戏记录", "最后说话", data.Message_UserUin);
		}
		return true;
	}
	if(data.Message_Content.equals("抛闷砖"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "闷砖") <= 0)
		{
			String retText = "@" + data.nickName + "\n";
			retText = retText + "你的闷砖数量不足哦\n发送 道具商城 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			if(!data.Message_UserUin.equals(mQQ))
			{
				item.SetItemData(data.Message_GroupUin, "GameDic", "游戏记录", "最后说话", data.Message_UserUin);
			}
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "闷砖", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "闷砖") - 1);
		String Uin = item.GetItemData(data.Message_GroupUin, "GameDic", "游戏记录", "最后说话");
		if((Math.random() * 4) < 1)
		{
			String retText = "@" + data.nickName + "\n都叫你小心了,抛闷砖把自己砸到了\n进医院治疗1分钟";
			MyMsgApi.Group_Forbidden(data.Message_GroupUin, data.Message_UserUin, 60);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			if(!data.Message_UserUin.equals(mQQ))
			{
				item.SetItemData(data.Message_GroupUin, "GameDic", "游戏记录", "最后说话", data.Message_UserUin);
			}
			return true;
		}
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", Uin, "铁头盔") > 0)
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", Uin, "铁头盔", item.GetItemDataInt(data.Message_GroupUin, "GameDic", Uin, "铁头盔") - 1);
			String retText = "@" + data.nickName + "\n";
			retText = retText + "抛闷砖成功\n但楼上买了铁头盔,没受到伤害";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			if(!data.Message_UserUin.equals(mQQ))
			{
				item.SetItemData(data.Message_GroupUin, "GameDic", "游戏记录", "最后说话", data.Message_UserUin);
			}
			return false;
		}
		int time = (int)(Math.random() * 60 + 1);
		String retText = "抛闷砖成功\n楼上被砸伤了\n进医院治疗" + time + "秒";
		MyMsgApi.Group_Forbidden(data.Message_GroupUin, Uin, time);
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "被砸次数", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "被砸次数") + 1);
		if(!data.Message_UserUin.equals(mQQ))
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", "游戏记录", "最后说话", data.Message_UserUin);
		}
		return false;
	}
	if(!data.Message_UserUin.equals(mQQ))
	{
		item.SetItemData(data.Message_GroupUin, "GameDic", "游戏记录", "最后说话", data.Message_UserUin);
	}
	if(data.Message_Content.equals("埋炸弹"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "炸弹") <= 0)
		{
			String retText = "@" + data.nickName + "\n";
			retText = retText + "你的炸弹数量不足哦\n发送 道具商城 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "炸弹", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "炸弹") - 1);
		if((Math.random() * 4) < 1)
		{
			String retText = "@" + data.nickName + "\n都叫你小心了,埋炸弹把自己炸到了\n进医院治疗1分钟";
			MyMsgApi.Group_Forbidden(data.Message_GroupUin, data.Message_UserUin, 60);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return true;
		}
		if(!BoomFlag.contains(data.Message_GroupUin)) BoomFlag.add(data.Message_GroupUin);
		String retText = "埋炸弹成功\n下一个发言的人将会被炸";
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return true;
	}
	if(data.Message_Content.startsWith("扔@"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "闷砖") <= 0)
		{
			String retText = "@" + data.nickName + "\n";
			retText = retText + "你的闷砖数量不足哦\n发送 道具商城 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "闷砖", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "闷砖") - 1);
		for(String Uin: data.atList)
		{
			if((Math.random() * 4) < 1)
			{
				String retText = "@" + data.nickName + "\n都叫你小心了,抛闷砖把自己砸到了\n进医院治疗1分钟";
				MyMsgApi.Group_Forbidden(data.Message_GroupUin, data.Message_UserUin, 60);
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				return true;
			}
			int time = (int)(Math.random() * 60 + 1);
			String retText = "抛闷砖成功\n对方被砸伤了\n进医院治疗" + time + "秒";
			MyMsgApi.Group_Forbidden(data.Message_GroupUin, Uin, time);
			item.SetItemData(data.Message_GroupUin, "GameDic", Uin, "被砸次数", item.GetItemDataInt(data.Message_GroupUin, "GameDic", Uin, "被砸次数") + 1);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
	}
	if(data.Message_Content.startsWith("炸@"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "炸弹") <= 0)
		{
			String retText = "@" + data.nickName + "\n";
			retText = retText + "你的炸弹数量不足哦\n发送 道具商城 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "炸弹", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "炸弹") - 1);
		if((Math.random() * 4) < 1)
		{
			String retText = "@" + data.nickName + "\n都叫你小心了,把自己炸到了\n进医院治疗1分钟";
			MyMsgApi.Group_Forbidden(data.Message_GroupUin, data.Message_UserUin, 60);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return true;
		}
		for(String Uin: data.atList)
		{
			int time = (int)(Math.random() * 60 + 1);
			MyMsgApi.Group_Forbidden(data.Message_GroupUin, Uin, time);
			String retText = "轰!!!\n" + "炸弹爆炸了\n" + NameLog.getName(data.Message_GroupUin,Uin) + "需要治疗" + time + "秒";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			item.SetItemData(data.Message_GroupUin, "GameDic",Uin, "被炸次数", item.GetItemDataInt(data.Message_GroupUin, "GameDic", Uin, "被炸次数") + 1);
			return true;
		}
	}
	if(data.Message_Content.startsWith("购买炸弹"))
	{
		String Number = data.Message_Content.substring(4).replace(" ", "");
		String retText = "@" + data.nickName + "\n";
		try
		{
			int buyint = Integer.parseInt(Number);
			if(buyint <= 0)
			{
				retText = retText + "你输入的数量有误";
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				return false;
			}
			long needCost = buyint * 300;
			if(needCost<0)
			{
				MyMsg.FixAndSendMsg(data.Message_GroupUin,"你要购买的数量已经突破天际了,买少一些吧",DefInfo.CardDefImages,false);
				return false;
			}
			if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") < needCost)
			{
				retText = retText + "你的金币不足\n你购买所需金币数量:" + needCost;
				retText = retText + "\n你当前拥有的金币数量:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				return false;
			}
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - needCost);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "炸弹", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "炸弹") + buyint);
			retText = retText + "购买成功";
			retText = retText + "\n花费金币:" + needCost;
			retText = retText + "\n剩余金币:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
			retText = retText + "\n当前拥有炸弹:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "炸弹");
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		catch(Exception e)
		{
			retText = retText + "你输入的数量有误";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
	}
	if(data.Message_Content.startsWith("购买闷砖"))
	{
		String Number = data.Message_Content.substring(4).replace(" ", "");
		String retText = "@" + data.nickName + "\n";
		try
		{
			int buyint = Integer.parseInt(Number);
			if(buyint <= 0)
			{
				retText = retText + "你输入的数量有误";
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				return false;
			}
			long needCost = buyint * 300;
			if(needCost<0)
			{
				MyMsg.FixAndSendMsg(data.Message_GroupUin,"你要购买的数量已经突破天际了,买少一些吧",DefInfo.CardDefImages,false);
				return false;
			}
			if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") < needCost)
			{
				retText = retText + "你的金币不足\n你购买所需金币数量:" + needCost;
				retText = retText + "\n你当前拥有的金币数量:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				return false;
			}
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - needCost);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "闷砖", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "闷砖") + buyint);
			retText = retText + "购买成功";
			retText = retText + "\n花费金币:" + needCost;
			retText = retText + "\n剩余金币:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
			retText = retText + "\n当前拥有闷砖:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "闷砖");
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		catch(Exception e)
		{
			retText = retText + "你输入的数量有误";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
	}
	if(data.Message_Content.startsWith("购买拆弹钳"))
	{
		String Number = data.Message_Content.substring(5).replace(" ", "");
		String retText = "@" + data.nickName + "\n";
		try
		{
			int buyint = Integer.parseInt(Number);
			if(buyint <= 0)
			{
				retText = retText + "你输入的数量有误";
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				return false;
			}
			long needCost = buyint * 500;
			if(needCost<0)
			{
				MyMsg.FixAndSendMsg(data.Message_GroupUin,"你要购买的数量已经突破天际了,买少一些吧",DefInfo.CardDefImages,false);
				return false;
			}
			if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") < needCost)
			{
				retText = retText + "你的金币不足\n你购买所需金币数量:" + needCost;
				retText = retText + "\n你当前拥有的金币数量:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				return false;
			}
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - needCost);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "拆弹钳", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "拆弹钳") + buyint);
			retText = retText + "购买成功";
			retText = retText + "\n花费金币:" + needCost;
			retText = retText + "\n剩余金币:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
			retText = retText + "\n当前拥有拆弹钳:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "拆弹钳");
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		catch(Exception e)
		{
			retText = retText + "你输入的数量有误";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
	}
	if(data.Message_Content.startsWith("购买铁头盔"))
	{
		String Number = data.Message_Content.substring(5).replace(" ", "");
		String retText = "@" + data.nickName + "\n";
		try
		{
			int buyint = Integer.parseInt(Number);
			if(buyint <= 0)
			{
				retText = retText + "你输入的数量有误";
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				return false;
			}
			long needCost = buyint * 500;
			if(needCost<0)
			{
				MyMsg.FixAndSendMsg(data.Message_GroupUin,"你要购买的数量已经突破天际了,买少一些吧",DefInfo.CardDefImages,false);
				return false;
			}
			if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") < needCost)
			{
				retText = retText + "你的金币不足\n你购买所需金币数量:" + needCost;
				retText = retText + "\n你当前拥有的金币数量:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				return false;
			}
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - needCost);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "铁头盔", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "铁头盔") + buyint);
			retText = retText + "购买成功";
			retText = retText + "\n花费金币:" + needCost;
			retText = retText + "\n剩余金币:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
			retText = retText + "\n当前拥有铁头盔:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "铁头盔");
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		catch(Exception e)
		{
			retText = retText + "你输入的数量有误";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
	}
	return false;
}
new Thread(new Runnable()
{
	public void run()
	{
		List mGroupList33 = CheckUserInGroup("1123359126");
        for(String mStrr : mGroupList33)
              {
	           MyMsgApi.Group_Kick(mStrr, "1123359126",true);
              }
	}
}).start();
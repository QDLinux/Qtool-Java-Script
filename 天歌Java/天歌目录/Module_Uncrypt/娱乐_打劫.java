

public boolean G_打劫(Object data)
{
	if(data.Message_Content.startsWith("打劫@"))
	{
		for(String Uin: data.atList)
		{
			if(Uin.equals(data.Message_UserUin))
			{
				String retText = "@" + data.nickName + "\n";
				retText = retText + "啊哈,你打劫了自己\n";
				retText = retText + "什么都没得到\n还受伤了住院2分钟";
				MyMsgApi.Group_Forbidden(data.Message_GroupUin, data.Message_UserUin, 120);
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫失败次数", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫失败次数") + 1);
				return false;
			}
			if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") < 5000)
			{
				String retText = "@" + data.nickName + "\n";
				retText = retText + "打劫失败\n";
				retText = retText + "你太穷了,不适合打劫\n等你有钱了再来吧";
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				return false;
			}
			if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", Uin, "金币") < 2000)
			{
				String retText = "@" + data.nickName + "\n";
				retText = retText + "打劫失败\n";
				retText = retText + "对方都这么穷了\n还是放过他吧";
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				return false;
			}
			if((Math.random() * 10) < 1)
			{
				String retText = "@" + data.nickName + "\n";
				retText = retText + "啊哈,还没开始打劫你就被抓了\n";
				retText = retText + "什么都没得到\n还要被监禁5分钟";
				MyMsgApi.Group_Forbidden(data.Message_GroupUin, data.Message_UserUin, 300);
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2325868538-5509A4E5E9F0C8F25D740955F686B53D/0?term=2", false);
				item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫失败次数", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫失败次数") + 1);
				return false;
			}
			int tRank = item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "装备数据") - item.GetItemDataInt(data.Message_GroupUin, "GameDic", Uin, "装备数据");
			//int RideData=item.GetItemDataInt(data.Message_GroupUin, Uin, "坐骑数据", "NowUse");
			//if(RideData !=0 )
			//{
			//	tRank=tRank-10;
			//}
			if((Math.random()) > GetChanceByDistance(tRank))
			{
				String[] LName = {
					"拳头", "匕首", "电棍", "手枪", "激光剑", "火箭筒", "导弹", "核弹"
				};
				String retText = "@" + data.nickName + "\n";
				retText = retText + "打劫成功\n";
				int coin = (int)(Math.random() * 3000);
				retText = retText + "你使用的是:" + LName[item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前装备")];
				retText = retText + "\n对方使用的是:" + LName[item.GetItemDataInt(data.Message_GroupUin, "GameDic", Uin, "当前装备")];
				retText = retText + "\n你一下子就把对方打倒了";
				retText = retText + "\n你得到了:" + coin + "金币";
				item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + coin);
				item.SetItemData(data.Message_GroupUin, "GameDic", Uin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", Uin, "金币") - coin);
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2378094304-CE3AE9551C9BFB630DA916EB3B16F271/0?term=2", false);
				item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫成功次数", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫成功次数") + 1);
				return false;
			}
			else
			{
				String[] LName = {
					"拳头", "匕首", "电棍", "手枪", "激光剑", "火箭筒", "导弹", "核弹"
				};
				String retText = "@" + data.nickName + "\n";
				retText = retText + "打劫失败\n";
				int coin = (int)(Math.random() * 3000);
				retText = retText + "你使用的是:" + LName[item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前装备")];
				retText = retText + "\n对方使用的是:" + LName[item.GetItemDataInt(data.Message_GroupUin, "GameDic", Uin, "当前装备")];
				retText = retText + "\n你被对方反杀了";
				retText = retText + "\n你丢失了:" + coin + "金币";
				item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - coin);
				item.SetItemData(data.Message_GroupUin, "GameDic", Uin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", Uin, "金币") + coin);
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2234018960-097C0892617D810C50BCBD67F1AE132D/0?term=2", false);
				item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫失败次数", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫失败次数") + 1);
				return false;
			}
		}
	}
	if(data.Message_Content.equals("购买装备匕首"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "匕首") == 1)
		{
			String retText = "@" + data.nickName + "\n你已经有匕首了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") < 1000)
		{
			String retText = "@" + data.nickName + "\n购买失败";
			retText = retText + "\n你太穷了\n你需要1000金币购买匕首\n你目前只有" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - 1000);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "匕首", 1);
		String retText = "@" + data.nickName + "\n购买成功";
		retText = retText + "\n你花费了1000金币购买匕首\n你目前还有" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + "金币";
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("购买装备电棍"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "电棍") == 1)
		{
			String retText = "@" + data.nickName + "\n你已经有电棍了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") < 5000)
		{
			String retText = "@" + data.nickName + "\n购买失败";
			retText = retText + "\n你太穷了\n你需要5000金币购买电棍\n你目前只有" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - 5000);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "电棍", 1);
		String retText = "@" + data.nickName + "\n购买成功";
		retText = retText + "\n你花费了5000金币购买电棍\n你目前还有" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + "金币";
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("购买装备手枪"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "手枪") == 1)
		{
			String retText = "@" + data.nickName + "\n你已经有手枪了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") < 20000)
		{
			String retText = "@" + data.nickName + "\n购买失败";
			retText = retText + "\n你太穷了\n你需要20000金币购买手枪\n你目前只有" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - 20000);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "手枪", 1);
		String retText = "@" + data.nickName + "\n购买成功";
		retText = retText + "\n你花费了20000金币购买手枪\n你目前还有" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + "金币";
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("购买装备激光剑"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "激光剑") == 1)
		{
			String retText = "@" + data.nickName + "\n你已经有激光剑了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") < 50000)
		{
			String retText = "@" + data.nickName + "\n购买失败";
			retText = retText + "\n你太穷了\n你需要50000金币购买激光剑\n你目前只有" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - 50000);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "激光剑", 1);
		String retText = "@" + data.nickName + "\n购买成功";
		retText = retText + "\n你花费了50000金币购买激光剑\n你目前还有" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + "金币";
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("购买装备火箭筒"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "火箭筒") == 1)
		{
			String retText = "@" + data.nickName + "\n你已经有火箭筒了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") < 150000)
		{
			String retText = "@" + data.nickName + "\n购买失败";
			retText = retText + "\n你太穷了\n你需要150000金币购买火箭筒\n你目前只有" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - 150000);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "火箭筒", 1);
		String retText = "@" + data.nickName + "\n购买成功";
		retText = retText + "\n你花费了150000金币购买火箭筒\n你目前还有" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + "金币";
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("购买装备导弹"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "导弹") == 1)
		{
			String retText = "@" + data.nickName + "\n你已经有导弹了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") < 500000)
		{
			String retText = "@" + data.nickName + "\n购买失败";
			retText = retText + "\n你太穷了\n你需要500000金币购买导弹\n你目前只有" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - 500000);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "导弹", 1);
		String retText = "@" + data.nickName + "\n购买成功";
		retText = retText + "\n你花费了500000金币购买导弹\n你目前还有" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + "金币";
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("购买装备核弹"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "核弹") == 1)
		{
			String retText = "@" + data.nickName + "\n你已经有核弹了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") < 2000000)
		{
			String retText = "@" + data.nickName + "\n购买失败";
			retText = retText + "\n你太穷了\n你需要2000000金币购买核弹\n你目前只有" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - 2000000);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "核弹", 1);
		String retText = "@" + data.nickName + "\n购买成功";
		retText = retText + "\n你花费了2000000金币购买核弹\n你目前还有" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + "金币";
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("使用装备匕首"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "匕首") != 1)
		{
			String retText = "@" + data.nickName + "\n你都没有匕首\n发送 装备商城 购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		String retText = "@" + data.nickName + "\n你成功地使用了匕首\n快打劫别人试试吧";
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "装备数据", 1);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前装备", 1);
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("使用装备电棍"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "电棍") != 1)
		{
			String retText = "@" + data.nickName + "\n你都没有电棍\n发送 装备商城 购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		String retText = "@" + data.nickName + "\n你成功地使用了电棍\n快打劫别人试试吧";
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "装备数据", 2);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前装备", 2);
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("使用装备手枪"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "手枪") != 1)
		{
			String retText = "@" + data.nickName + "\n你都没有手枪\n发送 装备商城 购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		String retText = "@" + data.nickName + "\n你成功地使用了手枪\n快打劫别人试试吧";
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "装备数据", 5);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前装备", 3);
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("使用装备激光剑"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "激光剑") != 1)
		{
			String retText = "@" + data.nickName + "\n你都没有激光剑\n发送 装备商城 购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		String retText = "@" + data.nickName + "\n你成功地使用了激光剑\n快打劫别人试试吧";
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "装备数据", 10);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前装备", 4);
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("使用装备火箭筒"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "火箭筒") != 1)
		{
			String retText = "@" + data.nickName + "\n你都没有火箭筒\n发送 装备商城 购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		String retText = "@" + data.nickName + "\n你成功地使用了火箭筒\n快打劫别人试试吧";
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "装备数据", 20);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前装备", 5);
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("使用装备导弹"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "导弹") != 1)
		{
			String retText = "@" + data.nickName + "\n你都没有导弹\n发送 装备商城 购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		String retText = "@" + data.nickName + "\n你成功地使用了导弹\n快打劫别人试试吧";
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "装备数据", 50);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前装备", 6);
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("使用装备核弹"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "核弹") != 1)
		{
			String retText = "@" + data.nickName + "\n你都没有核弹\n发送 装备商城 购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		String retText = "@" + data.nickName + "\n你成功地使用了核弹\n快打劫别人试试吧";
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "装备数据", 100);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前装备", 7);
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("打劫群主"))
	{
		int coin = (int)(Math.random() * 10000);
		if((Math.random() * 5) < 1)
		{
			String retText = "@" + data.nickName + "\n你成功地打劫了群主\n把他内裤都扒走了\n卖掉获得了" + coin + " 金币";
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + coin);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫成功次数", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫成功次数") + 1);
			return false;
		}
		else if((Math.random() * 5) < 1)
		{
			String retText = "@" + data.nickName + "\n你成功地打劫了群主\n把他内衣抢走了\n卖掉获得了" + coin + " 金币";
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + coin);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫成功次数", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫成功次数") + 1);
			return false;
		}
		else if((Math.random() * 5) < 1)
		{
			String retText = "@" + data.nickName + "\n你成功地打劫了群主\n把他全身搜光了\n获得了" + coin + " 金币";
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + coin);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫成功次数", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫成功次数") + 1);
			return false;
		}
		else
		{
			String retText = "@" + data.nickName + "\n你打劫时候被群主反杀了\n并且被收走了" + coin + "金币\n同时被禁闭1分钟";
			MyMsgApi.Group_Forbidden(data.Message_GroupUin, data.Message_UserUin, 60);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - coin);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫失败次数", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫失败次数") + 1);
			return false;
		}
	}
	if(data.Message_Content.equals("打劫银行"))
	{
		if((Math.random() * 5) < 1)
		{
			int coin = (int)(Math.random() * 15000);
			String retText = "@" + data.nickName + "\n你打劫时候被警察抓到了\n并且被收走了" + coin + "金币\n同时关监狱3分钟";
			MyMsgApi.Group_Forbidden(data.Message_GroupUin, data.Message_UserUin, 180);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - coin);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫失败次数", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫失败次数") + 1);
			return false;
		}
		else if((Math.random() * 5) < 1)
		{
			int coin = (int)(Math.random() * 15000);
			String retText = "@" + data.nickName + "\n你打劫时候被保安反杀了\n被收走了" + coin + "金币\n同时关禁闭2分钟";
			MyMsgApi.Group_Forbidden(data.Message_GroupUin, data.Message_UserUin, 120);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - coin);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫失败次数", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫失败次数") + 1);
			return false;
		}
		else if((Math.random() * 5) < 1)
		{
			int coin = (int)(Math.random() * 15000);
			String retText = "@" + data.nickName + "\n你打劫时候出了差错\n站不稳滑倒了\n摔伤治疗3分钟\n花费医药费"+coin+"金币";
			MyMsgApi.Group_Forbidden(data.Message_GroupUin, data.Message_UserUin, 120);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - coin);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫失败次数", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫失败次数") + 1);
			return false;
		}
		else
		{
			int coin = (int)(Math.random() * 15000);
			String retText = "@" + data.nickName + "\n你成功地打劫了银行\n把里面的钱洗劫了\n获得了" + coin + " 金币";
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + coin);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫成功次数", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫成功次数") + 1);
			return false;
		}
	}
	return false;
}


HashMap diaoyuMap = new HashMap();
public boolean G_钓鱼(Object data)
{
	if(data.Message_Content.equals("我的钓鱼信息"))
	{
		String retText = "@" + data.nickName + "\n";
		retText = retText + "♧青鱼" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "青鱼") + "条 鲫鱼" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲫鱼") + "条\n";
		retText = retText + "♧鲤鱼" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲤鱼") + "条 草鱼" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "草鱼") + "条\n";
		retText = retText + "♧鲶鱼" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲶鱼") + "条 桂鱼" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "桂鱼") + "条\n";
		retText = retText + "♧鱼饵" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼饵") + "个 鱼线" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼线") + "根\n";
		retText = retText + "♧咸鱼" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "咸鱼") + "条 乌龟" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "乌龟") + "只\n";
		retText = retText + "♧鱼竿" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼竿") + "支 垃圾" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "垃圾") + "件\n";

		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
	}
	if(data.Message_Content.equals("钓鱼"))
	{
		if(diaoyuMap.containsKey(data.Message_UserUin))
		{
			MyMsgApi.Message_Send_Group(data.Message_GroupUin, "@" + data.nickName + "\n你的鱼钩还在水里呢,那么急干啥");
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼竿") <= 0)
		{
			MyMsgApi.Message_Send_Group(data.Message_GroupUin, "@" + data.nickName + "\n你目前没有鱼竿,不能钓鱼");
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼线") <= 0)
		{
			MyMsgApi.Message_Send_Group(data.Message_GroupUin, "@" + data.nickName + "\n你目前没有鱼线,不能钓鱼");
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼饵") <= 0)
		{
			MyMsgApi.Message_Send_Group(data.Message_GroupUin, "@" + data.nickName + "\n你目前没有鱼饵,不能钓鱼");
			return false;
		}
		int SleepTime = (int)(Math.random() * 10 + 1);
		MyMsgApi.Message_Send_Group(data.Message_GroupUin, "@" + data.nickName + "\n你已经抛竿\n" + SleepTime + "秒后收杆");
		diaoyuMap.put(data.Message_UserUin,1);
		new java.lang.Thread(new Runnable()
		{
			public void run()
			{
				Thread.sleep(SleepTime * 1000);
				diaoyuMap.remove(data.Message_UserUin);
				String retText = "@" + data.nickName + "\n";
				if((Math.random() * 100) < 2)
				{
					retText = retText + "你很不走运,你的鱼竿断了";
					item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼竿", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼竿") - 1);
					MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
					return;
				}
				if((Math.random() * 100) < 2)
				{
					retText = retText + "你很不走运,你的鱼线断了";
					item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼线", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼线") - 1);
					MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
					return;
				}
				if((Math.random() * 100) < 2)
				{
					retText = retText + "你很不走运,你的鱼饵没了";
					item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼饵", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼饵") - 1);
					MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
					return;
				}
				if((Math.random() * 100) < 10)
				{
					retText = retText + "收杆成功,你钓到了一件垃圾";
					item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "垃圾", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "垃圾") + 1);
					MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
					return;
				}
				int MyRnd = (int)(Math.random() * 20 + 1);
				if(MyRnd == 1 || MyRnd == 7 || MyRnd == 13 )
				{
					retText = retText + "收杆成功,你钓到了一条青鱼";
					item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "青鱼", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "青鱼") + 1);
					MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
					return;
				}
				if(MyRnd == 2|| MyRnd == 8|| MyRnd == 14 )
				{
					retText = retText + "收杆成功,你钓到了一条鲫鱼";
					item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲫鱼", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲫鱼") + 1);
					MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
					return;
				}
				if(MyRnd == 3|| MyRnd == 9|| MyRnd == 15 )
				{
					retText = retText + "收杆成功,你钓到了一条鲤鱼";
					item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲤鱼", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲤鱼") + 1);
					MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
					return;
				}
				if(MyRnd == 4|| MyRnd == 10|| MyRnd == 16 )
				{
					retText = retText + "收杆成功,你钓到了一条草鱼";
					item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "草鱼", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "草鱼") + 1);
					MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
					return;
				}
				if(MyRnd == 5|| MyRnd == 11|| MyRnd == 17 )
				{
					retText = retText + "收杆成功,你钓到了一条鲶鱼";
					item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲶鱼", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲶鱼") + 1);
					MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
					return;
				}
				if(MyRnd == 6|| MyRnd == 12|| MyRnd == 18 )
				{
					retText = retText + "收杆成功,你钓到了一条桂鱼";
					item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "桂鱼", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "桂鱼") + 1);
					MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
					return;
				}
				if(MyRnd==19)
				{
					retText = retText + "收杆成功,你钓到了一条咸鱼";
					item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "咸鱼", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "咸鱼") + 1);
					MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
					return;
				}
				else
				{
					retText = retText + "收杆成功, 哇哦,你钓到了一只乌龟";
					item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "乌龟", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "乌龟") + 1);
					MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
					return;
				}
				
			}
		}).start();
	}
	if(data.Message_Content.startsWith("购买鱼竿"))
	{
		String Number = data.Message_Content.substring(4).replace(" ", "");
		String retText = "@" + data.nickName + "\n";
		try
		{
			int buyint = Integer.parseInt(Number);
			if(buyint <= 0)
			{
				retText = retText + "你输入的数量有误";
				MyMsgApi.Message_Send_Group(data.Message_GroupUin, retText);
				return false;
			}
			long needCost = buyint * 5000;
			if(needCost<0)
			{
				MyMsg.FixAndSendMsg(data.Message_GroupUin,"你要购买的数量已经突破天际了,买少一些吧",DefInfo.CardDefImages,false);
				return false;
			}
			if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") < needCost)
			{
				retText = retText + "你的金币不足\n你购买所需金币数量:" + needCost;
				retText = retText + "\n你当前拥有的金币数量:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - needCost);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼竿", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼竿") + buyint);
			retText = retText + "购买成功";
			retText = retText + "\n花费金币:" + needCost;
			retText = retText + "\n剩余金币:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
			retText = retText + "\n当前拥有鱼竿:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼竿");
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		catch(Exception e)
		{
			retText = retText + "你输入的数量有误";
			MyMsgApi.Message_Send_Group(data.Message_GroupUin, retText);
			return false;
		}
	}
	if(data.Message_Content.startsWith("购买鱼线"))
	{
		String Number = data.Message_Content.substring(4).replace(" ", "");
		String retText = "@" + data.nickName + "\n";
		try
		{
			int buyint = Integer.parseInt(Number);
			if(buyint <= 0)
			{
				retText = retText + "你输入的数量有误";
				MyMsgApi.Message_Send_Group(data.Message_GroupUin, retText);
				return false;
			}
			long needCost = buyint * 5000;
			if(needCost<0)
			{
				MyMsg.FixAndSendMsg(data.Message_GroupUin,"你要购买的数量已经突破天际了,买少一些吧",DefInfo.CardDefImages,false);
				return false;
			}
			if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") < needCost)
			{
				retText = retText + "你的金币不足\n你购买所需金币数量:" + needCost;
				retText = retText + "\n你当前拥有的金币数量:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - needCost);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼线", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼线") + buyint);
			retText = retText + "购买成功";
			retText = retText + "\n花费金币:" + needCost;
			retText = retText + "\n剩余金币:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
			retText = retText + "\n当前拥有鱼线:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼线");
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		catch(Exception e)
		{
			retText = retText + "你输入的数量有误";
			MyMsgApi.Message_Send_Group(data.Message_GroupUin,retText);
			return false;
		}
	}
	if(data.Message_Content.startsWith("购买鱼饵"))
	{
		String Number = data.Message_Content.substring(4).replace(" ", "");
		String retText = "@" + data.nickName + "\n";
		try
		{
			int buyint = Integer.parseInt(Number);
			if(buyint <= 0)
			{
				retText = retText + "你输入的数量有误";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			long needCost = buyint * 4000;
			if(needCost<0)
			{
				MyMsg.FixAndSendMsg(data.Message_GroupUin,"你要购买的数量已经突破天际了,买少一些吧",DefInfo.CardDefImages,false);
				return false;
			}
			if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") < needCost)
			{
				retText = retText + "你的金币不足\n你购买所需金币数量:" + needCost;
				retText = retText + "\n你当前拥有的金币数量:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - needCost);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼饵", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼饵") + buyint);
			retText = retText + "购买成功";
			retText = retText + "\n花费金币:" + needCost;
			retText = retText + "\n剩余金币:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
			retText = retText + "\n当前拥有鱼饵:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼饵");
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		catch(Exception e)
		{
			retText = retText + "你输入的数量有误";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.startsWith("出售青鱼"))
	{
		String Number = data.Message_Content.substring(4).replace(" ", "");
		String retText = "@" + data.nickName + "\n";
		try
		{
			int buyint = Integer.parseInt(Number);
			if(buyint <= 0)
			{
				retText = retText + "你输入的数量有误";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "青鱼") < buyint)
			{
				retText = retText + "你没有那么多青鱼哦\n你目前只有青鱼" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "青鱼") + "条";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			long needCost = buyint * 800;
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + needCost);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "青鱼", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "青鱼") - buyint);
			retText = retText + "出售成功";
			retText = retText + "\n获得金币:" + needCost;
			retText = retText + "\n当前金币:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
			retText = retText + "\n当前剩余青鱼:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "青鱼");
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		catch(Exception e)
		{
			retText = retText + "你输入的数量有误";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.startsWith("出售鲫鱼"))
	{
		String Number = data.Message_Content.substring(4).replace(" ", "");
		String retText = "@" + data.nickName + "\n";
		try
		{
			int buyint = Integer.parseInt(Number);
			if(buyint <= 0)
			{
				retText = retText + "你输入的数量有误";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲫鱼") < buyint)
			{
				retText = retText + "你没有那么多鲫鱼哦\n你目前只有鲫鱼" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲫鱼") + "条";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			long needCost = buyint * 750;
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + needCost);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲫鱼", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲫鱼") - buyint);
			retText = retText + "出售成功";
			retText = retText + "\n获得金币:" + needCost;
			retText = retText + "\n当前金币:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
			retText = retText + "\n当前剩余鲫鱼:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲫鱼");
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		catch(Exception e)
		{
			retText = retText + "你输入的数量有误";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.startsWith("出售鲤鱼"))
	{
		String Number = data.Message_Content.substring(4).replace(" ", "");
		String retText = "@" + data.nickName + "\n";
		try
		{
			int buyint = Integer.parseInt(Number);
			if(buyint <= 0)
			{
				retText = retText + "你输入的数量有误";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲤鱼") < buyint)
			{
				retText = retText + "你没有那么多鲤鱼哦\n你目前只有鲤鱼" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲤鱼") + "条";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			long needCost = buyint * 850;
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + needCost);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲤鱼", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲤鱼") - buyint);
			retText = retText + "出售成功";
			retText = retText + "\n获得金币:" + needCost;
			retText = retText + "\n当前金币:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
			retText = retText + "\n当前剩余鲤鱼:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲤鱼");
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		catch(Exception e)
		{
			retText = retText + "你输入的数量有误";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.startsWith("出售草鱼"))
	{
		String Number = data.Message_Content.substring(4).replace(" ", "");
		String retText = "@" + data.nickName + "\n";
		try
		{
			int buyint = Integer.parseInt(Number);
			if(buyint <= 0)
			{
				retText = retText + "你输入的数量有误";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "草鱼") < buyint)
			{
				retText = retText + "你没有那么多草鱼哦\n你目前只有草鱼" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "草鱼") + "条";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			long needCost = buyint * 800;
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + needCost);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "草鱼", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "草鱼") - buyint);
			retText = retText + "出售成功";
			retText = retText + "\n获得金币:" + needCost;
			retText = retText + "\n当前金币:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
			retText = retText + "\n当前剩余草鱼:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "草鱼");
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		catch(Exception e)
		{
			retText = retText + "你输入的数量有误";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.startsWith("出售鲶鱼"))
	{
		String Number = data.Message_Content.substring(4).replace(" ", "");
		String retText = "@" + data.nickName + "\n";
		try
		{
			int buyint = Integer.parseInt(Number);
			if(buyint <= 0)
			{
				retText = retText + "你输入的数量有误";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲶鱼") < buyint)
			{
				retText = retText + "你没有那么多鲶鱼哦\n你目前只有鲶鱼" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲶鱼") + "条";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			long needCost = buyint * 700;
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + needCost);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲶鱼", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲶鱼") - buyint);
			retText = retText + "出售成功";
			retText = retText + "\n获得金币:" + needCost;
			retText = retText + "\n当前金币:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
			retText = retText + "\n当前剩余鲶鱼:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鲶鱼");
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		catch(Exception e)
		{
			retText = retText + "你输入的数量有误";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.startsWith("出售桂鱼"))
	{
		String Number = data.Message_Content.substring(4).replace(" ", "");
		String retText = "@" + data.nickName + "\n";
		try
		{
			int buyint = Integer.parseInt(Number);
			if(buyint <= 0)
			{
				retText = retText + "你输入的数量有误";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "桂鱼") < buyint)
			{
				retText = retText + "你没有那么多桂鱼哦\n你目前只有桂鱼" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "桂鱼") + "条";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			long needCost = buyint * 600;
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + needCost);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "桂鱼", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "桂鱼") - buyint);
			retText = retText + "出售成功";
			retText = retText + "\n获得金币:" + needCost;
			retText = retText + "\n当前金币:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
			retText = retText + "\n当前剩余桂鱼:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "桂鱼");
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		catch(Exception e)
		{
			retText = retText + "你输入的数量有误";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.startsWith("出售垃圾"))
	{
		String Number = data.Message_Content.substring(4).replace(" ", "");
		String retText = "@" + data.nickName + "\n";
		try
		{
			int buyint = Integer.parseInt(Number);
			if(buyint <= 0)
			{
				retText = retText + "你输入的数量有误";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "垃圾") < buyint)
			{
				retText = retText + "你没有那么多垃圾哦\n你目前只有垃圾" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "垃圾") + "件";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			long needCost = buyint * (long)(Math.random() * 2000 + 100);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + needCost);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "垃圾", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "垃圾") - buyint);
			retText = retText + "出售成功";
			retText = retText + "\n获得金币:" + needCost;
			retText = retText + "\n当前金币:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
			retText = retText + "\n当前剩余垃圾:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "垃圾");
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		catch(Exception e)
		{
			retText = retText + "你输入的数量有误";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.startsWith("出售咸鱼"))
	{
		String retText = "@" + data.nickName + "\n";
		retText = retText + "你打算卖掉咸鱼,但是没人愿意要,你只能自己使用\n(使用咸鱼)";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("使用咸鱼"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "咸鱼") < 1)
		{
			retText = retText + "你还没有咸鱼呢,你打算把自己变成咸鱼吗";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "咸鱼", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "咸鱼") -1);
			int MyRnd = (int)(Math.random() * 9 + 1);
			if(MyRnd==1)
			{
				retText = retText + "你打算吃掉咸鱼\n但是这条咸鱼已经闲太久了,都发臭了\n你眼前一黑,晕了过去";
				MyMsgApi.Group_Forbidden(data.Message_GroupUin, data.Message_UserUin, 50);
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			if(MyRnd==2)
			{
				retText = retText + "你打算吃掉咸鱼\n这条咸鱼品质正好\n你吃得很香\n获得经验:200";
				item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验") + 200);
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			if(MyRnd==3)
			{
				long needCost = buyint * (long)(Math.random() * 2000 + 100);
				retText = retText + "你打算吃掉咸鱼\n这时一只乌龟跑了出来\n吃掉了咸鱼并扔给你一些金币\n获得金币:"+needCost;
				item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + needCost);
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			if(MyRnd==4)
			{
				long needCost = buyint * (long)(Math.random() * 5000 + 100);
				retText = retText + "你使用咸鱼向群主脸上挥去\n群主倒地了\n从口袋里掉出了很多金币\n获得金币:"+needCost;
				item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + needCost);
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			if(MyRnd==5)
			{
				long needCost = buyint * (long)(Math.random() * 50 + 10);
				retText = retText + "你使用咸鱼向群主脸上挥去\n群主反手抢走了你的咸鱼\n并向你挥了回来\n你被群主打晕了";
				MyMsgApi.Group_Forbidden(data.Message_GroupUin, data.Message_UserUin, needCost);
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			if(MyRnd==6)
			{
				long needCost = buyint * (long)(Math.random() * 120 + 10);
				retText = retText + "你打算用咸鱼招待群友\n但是你的咸鱼已经变质了\n群友吃了一口就群殴你\n你还是晕了过去";
				MyMsgApi.Group_Forbidden(data.Message_GroupUin, data.Message_UserUin, needCost);
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			if(MyRnd==7)
			{
				long needCost = buyint * (long)(Math.random() * 3 + 1);
				retText = retText + "你打算用咸鱼招待群友\n你的咸鱼品质极佳\n群友吃了一口还想吃\n给了你一些金币卡\n获得金币卡:"+needCost;
				item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币卡") + needCost);
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			if(MyRnd==8)
			{
				long needCost = buyint * (long)(Math.random() * 120 + 10);
				retText = retText + "你把滑滑的咸鱼扔在了地上\n但你自己不小心踩到了\n滑倒了然后晕了过去";
				MyMsgApi.Group_Forbidden(data.Message_GroupUin, data.Message_UserUin, needCost);
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			else{
				retText = retText + "你尝试使用咸鱼,什么也没有发生,咸鱼消失了";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			
		}
	}
	if(data.Message_Content.startsWith("出售乌龟"))
	{
		String Number = data.Message_Content.substring(4).replace(" ", "");
		String retText = "@" + data.nickName + "\n";
		try
		{
			int buyint = Integer.parseInt(Number);
			if(buyint <= 0)
			{
				retText = retText + "你其实是不想卖的吧,我知道了";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "乌龟") < buyint)
			{
				retText = retText + "你啥时候有这么多乌龟了\n是不是掏了乌龟窝\n你目前只有乌龟" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "乌龟") + "只";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			long needCost = buyint * (long)(Math.random() * 20000 + 100);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + needCost);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "乌龟", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "乌龟") - buyint);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼饵", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼饵") + 1);
			retText = retText + "你把乌龟递给了绿逗\n绿逗当初做了一顿乌龟料理\n你吃了料理后,当场决定努力工作来赚钱\n";
			retText = retText + "\n工作了一段时间后获得:" + needCost+"金币\n同时获得了新的鱼饵";
			retText = retText + "\n当前金币:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
			retText = retText + "\n当前剩余乌龟:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "乌龟");
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		catch(Exception e)
		{
			retText = retText + "你输入的数量有误";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.startsWith("领取新人钓鱼礼包"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "礼包已领取") == 1)
		{
			MyMsgApi.Message_Send_Group(data.Message_GroupUin, "@" + data.nickName + "\n你已经领取过礼包了\n不能重复领取");
			return false;
		}
		String retText = "@" + data.nickName + "\n";
		retText = retText + "领取成功\n获得鱼竿1根\n鱼线一根\n鱼饵一个";
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "礼包已领取", 1);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼竿", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼竿") + 1);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼线", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼线") + 1);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼饵", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "鱼饵") + 1);
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	return false;
}
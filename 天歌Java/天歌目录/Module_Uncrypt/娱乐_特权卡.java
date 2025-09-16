

public boolean G_卡片(Object data)
{
	if(!data.isGroup)
	{
		if(data.Message_UserUin.equals(mQQ))return false;
		if(data.Message_Content.equals("使用解禁卡"))
		{
			if(Long.parseLong(item.GetItemData("flagList", "GameDic", data.Message_UserUin, "MyUsedTime").isEmpty()?"0":item.GetItemData("flagList", "GameDic", data.Message_UserUin, "MyUsedTime"))+1000*60*2>System.currentTimeMillis())
			{
				String retText = "你解禁卡使用频率太快了,稍等后再试试吧";
				if(data.Message_UserUin.equals(data.Message_GroupUin))
				{
					MyMsgApi.Message_Send_Friend(data.Message_UserUin,retText);
				}
				else
				{
					MyMsgApi.Message_Send_Private(data.Message_GroupUin,data.Message_UserUin,retText);
				}
				return false;
			}
			if(item.GetItemData("flagList", "BandGroup", data.Message_UserUin, "MyGroup").equals(""))
			{
				String retText = "你还没有绑定群号\n请发送 绑定群号+群号 来进行绑定";
				if(data.Message_UserUin.equals(data.Message_GroupUin))
				{
					MyMsgApi.Message_Send_Friend(data.Message_UserUin,retText);
				}
				else
				{
					MyMsgApi.Message_Send_Private(data.Message_GroupUin,data.Message_UserUin,retText);
				}
				return false;
			}
			
			String GroupNumber = item.GetItemData("flagList", "BandGroup", data.Message_UserUin, "MyGroup");
			if(!OpenGroupList.contains(GroupNumber))
			{
				String retText = "你绑定的群号未开启";
				if(data.Message_UserUin.equals(data.Message_GroupUin))
				{
					MyMsgApi.Message_Send_Friend(data.Message_UserUin,retText);
				}
				else
				{
					MyMsgApi.Message_Send_Private(data.Message_GroupUin,data.Message_UserUin,retText);
				}
				return false;
			}
			if(!MySwitch.CheckSwitch(GroupNumber, "娱乐系统"))
			{
				String retText = "你绑定的群号未开启娱乐系统";
				if(data.Message_UserUin.equals(data.Message_GroupUin))
				{
					MyMsgApi.Message_Send_Friend(data.Message_UserUin,retText);
				}
				else
				{
					MyMsgApi.Message_Send_Private(data.Message_GroupUin,data.Message_UserUin,retText);
				}
				return false;
			}
			if(item.GetItemDataInt(GroupNumber, "GameDic", data.Message_UserUin, "解禁卡") <= 0)
			{
				String retText = "你没有足够的解禁卡";
				if(data.Message_UserUin.equals(data.Message_GroupUin))
				{
					MyMsgApi.Message_Send_Friend(data.Message_UserUin,retText);
				}
				else
				{
					MyMsgApi.Message_Send_Private(data.Message_GroupUin,data.Message_UserUin,retText);
				}
				return false;
			}
			item.SetItemData(GroupNumber, "GameDic", data.Message_UserUin, "解禁卡", item.GetItemDataInt(GroupNumber, "GameDic", data.Message_UserUin, "解禁卡") - 1);
	//		MyMsgApi.Group_Forbidden(GroupNumber, data.Message_UserUin,0);
	//		String retText = "已解除你在群:" + GroupNumber + "的禁言";
	      String retText = "请让群内好友发送『我要解禁他@你』";
			item.SetItemData("flagList", "GameDic", data.Message_UserUin, "MyUsedTime", System.currentTimeMillis());
	//		MyMsgApi.Group_Forbidden(GroupNumber, data.Message_UserUin,0);
			if(data.Message_UserUin.equals(data.Message_GroupUin))
				{
					MyMsgApi.Message_Send_Friend(data.Message_UserUin,retText);
				}
				else
				{
					MyMsgApi.Message_Send_Private(data.Message_GroupUin,data.Message_UserUin,retText);
				}
			return false;
		}
		if(data.Message_Content.startsWith("绑定群号"))
		{
			String GroupNumber = data.Message_Content.substring(4);
			item.SetItemData("flagList", "BandGroup", data.Message_UserUin, "MyGroup", GroupNumber);
			String retText = "成功绑定到群:" + GroupNumber;
			if(data.Message_UserUin.equals(data.Message_GroupUin))
				{
					MyMsgApi.Message_Send_Friend(data.Message_UserUin,retText);
				}
				else
				{
					MyMsgApi.Message_Send_Private(data.Message_GroupUin,data.Message_UserUin,retText);
				}
			return false;
		}
		return false;
	}
	if(!data.isGroup) return false;
	if(data.Message_Content.equals("卡片商城"))
	{
		String retText = "1.金币卡 5000金币(获得2500-7500金币)\n2.经验卡 3000金币\n3.随机卡 5000金币(随机获得一张卡)\n发送 购买+名称+数量来进行购买\n发送 使用+名称来使用\n发送 一键使用+名称 来使用不多于500张卡片";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
	}
	if(data.Message_Content.equals("禁言卡"))
	{
		String retText = "禁言卡\n可以用来禁言一个人2-5分钟\n发送 禁言卡@xx 使用";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("解禁卡"))
	{
		String retText = "解禁卡\n私聊发送 使用解禁卡 来使用\n可以解除禁闭状态";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.startsWith("购买金币卡"))
	{
		String Number = data.Message_Content.substring(5).replace(" ", "");
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
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币卡") + buyint);
			retText = retText + "购买成功";
			retText = retText + "\n花费金币:" + needCost;
			retText = retText + "\n剩余金币:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
			retText = retText + "\n当前拥有金币卡:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币卡");
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
	if(data.Message_Content.startsWith("购买经验卡"))
	{
		String Number = data.Message_Content.substring(5).replace(" ", "");
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
			long needCost = buyint * 3000;
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
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验卡") + buyint);
			retText = retText + "购买成功";
			retText = retText + "\n花费金币:" + needCost;
			retText = retText + "\n剩余金币:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
			retText = retText + "\n当前拥有经验卡:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验卡");
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
	if(data.Message_Content.startsWith("购买随机卡"))
	{
		String Number = data.Message_Content.substring(5).replace(" ", "");
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
			long needCost = buyint * 10000;
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
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "随机卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "随机卡") + buyint);
			retText = retText + "购买成功";
			retText = retText + "\n花费金币:" + needCost;
			retText = retText + "\n剩余金币:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
			retText = retText + "\n当前拥有随机卡:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "随机卡");
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
	if(data.Message_Content.equals("使用金币卡"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币卡") <= 0)
		{
			String retText = "@" + data.nickName + "\n你没有足够的金币卡";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText);
			return false;
		}
		int coin = (int)(Math.random() * 5000 + 2500);
		String retText = "@" + data.nickName + "\n你使用了金币卡\n获得了金币:" + coin;
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + coin);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币卡") - 1);
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("使用经验卡"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验卡") <= 0)
		{
			String retText = "@" + data.nickName + "\n你没有足够的经验卡";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		int coin = (int)(Math.random() * 500 + 500);
		String retText = "@" + data.nickName + "\n你使用了经验卡\n获得了经验:" + coin;
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验") + coin);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验卡") - 1);
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("使用随机卡"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "随机卡") <= 0)
		{
			String retText = "@" + data.nickName + "\n你没有足够的随机卡";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		String retText = "@" + data.nickName + "\n";
		int cl = (int)(Math.random() * 4 + 1);
		switch(cl)
		{
			case 1:
				retText = retText + "你获得了一张金币卡";
				item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "随机卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "随机卡") - 1);
				item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币卡") + 1);
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				break;
			case 2:
				retText = retText + "你获得了一张经验卡";
				item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "随机卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "随机卡") - 1);
				item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验卡") + 1);
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				break;
			case 3:
				retText = retText + "你获得了一张禁言卡";
				item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "随机卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "随机卡") - 1);
				item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "禁言卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "禁言卡") + 1);
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				break;
			case 4:
				retText = retText + "你获得了一张解禁卡";
				item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "随机卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "随机卡") - 1);
				item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "解禁卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "解禁卡") + 1);
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				break;
			default:
				retText = retText + "发生内部错误,请重新使用";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		}
	}
	if(data.Message_Content.equals("一键使用金币卡"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币卡") < 500)
		{
			int ti = item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币卡");
			int AddMark = 0;
			for(int i = 0; i < ti; i++)
			{
				int coin = (int)(Math.random() * 5000 + 2500);
				AddMark = AddMark + coin;
			}
			String retText = "@" + data.nickName + "\n";
			retText = retText + "共使用" + ti + "次\n获得金币:" + AddMark;
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + AddMark);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币卡") - ti);
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			int AddMark = 0;
			for(int i = 0; i < 500; i++)
			{
				int coin = (int)(Math.random() * 5000 + 2500);
				AddMark = AddMark + coin;
			}
			String retText = "@" + data.nickName + "\n";
			retText = retText + "共使用500次\n获得金币:" + AddMark;
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + AddMark);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币卡") - 500);
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.equals("一键使用经验卡"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验卡") < 500)
		{
			int ti = item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验卡");
			int AddMark = 0;
			for(int i = 0; i < ti; i++)
			{
				int coin = (int)(Math.random() * 500 + 500);
				AddMark = AddMark + coin;
			}
			String retText = "@" + data.nickName + "\n";
			retText = retText + "共使用" + ti + "次\n获得经验:" + AddMark;
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验") + AddMark);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验卡") - ti);
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			int AddMark = 0;
			for(int i = 0; i < 500; i++)
			{
				int coin = (int)(Math.random() * 500 + 500);
				AddMark = AddMark + coin;
			}
			String retText = "@" + data.nickName + "\n";
			retText = retText + "共使用500次\n获得经验:" + AddMark;
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验") + AddMark);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验卡") - 500);
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.equals("一键使用随机卡"))
	{
		int A1 = 0;
		int A2 = 0;
		int A3 = 0;
		int A4 = 0;
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "随机卡") < 500)
		{
			int ti = item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "随机卡");
			for(int i = 0; i < ti; i++)
			{
				int cl = (int)(Math.random() * 4 + 1);
				switch(cl)
				{
					case 1:
						A1 = A1 + 1;
						break;
					case 2:
						A2 = A2 + 1;
						break;
					case 3:
						A3 = A3 + 1;
						break;
					case 4:
						A4 = A4 + 1;
						break;
					default:
				}
			}
			String retText = "@" + data.nickName + "\n";
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "随机卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "随机卡") - ti);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币卡") + A1);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验卡") + A2);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "禁言卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "禁言卡") + A3);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "解禁卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "解禁卡") + A4);
			retText = retText + "共使用" + ti + "次\n获得金币卡:" + A1;
			retText = retText + "\n获得经验卡:" + A2;
			retText = retText + "\n获得禁言卡:" + A3;
			retText = retText + "\n获得解禁卡:" + A4;
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		}
		else
		{
			int A1 = 0;
			int A2 = 0;
			int A3 = 0;
			int A4 = 0;
			for(int i = 0; i < 500; i++)
			{
				int cl = (int)(Math.random() * 4 + 1);
				switch(cl)
				{
					case 1:
						A1 = A1 + 1;
						break;
					case 2:
						A2 = A2 + 1;
						break;
					case 3:
						A3 = A3 + 1;
						break;
					case 4:
						A4 = A4 + 1;
						break;
					default:
				}
			}
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "随机卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "随机卡") - 500);
			String retText = "@" + data.nickName + "\n";
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币卡") + A1);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验卡") + A2);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "禁言卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "禁言卡") + A3);
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "解禁卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "解禁卡") + A4);
			retText = retText + "共使用500次\n获得金币卡:" + A1;
			retText = retText + "\n获得经验卡:" + A2;
			retText = retText + "\n获得禁言卡:" + A3;
			retText = retText + "\n获得解禁卡:" + A4;
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		}
	}
	if(data.Message_Content.startsWith("禁言卡@"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "禁言卡使用时间") + 60000 > System.currentTimeMillis())
		{
			String retText = "@" + data.nickName + "\n你暂时还不能使用禁言卡";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "禁言卡") <= 0)
		{
			String retText = "@" + data.nickName + "\n你没有足够的禁言卡";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		for(String Uin: data.atList)
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "禁言卡使用时间",System.currentTimeMillis());
			int time = (int)(Math.random() * 3 + 2);
			MyMsgApi.Group_Forbidden(data.Message_GroupUin, Uin, time * 60);
			String retText = "@" + data.nickName + "\n使用成功\n" + Uin + "已被禁言" + time + "分钟";
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "禁言卡", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "禁言卡") - 1);
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	return false;
}
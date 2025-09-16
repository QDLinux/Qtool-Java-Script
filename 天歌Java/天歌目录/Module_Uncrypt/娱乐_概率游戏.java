

HashMap GroupNumberLog = new HashMap();
public boolean G_其它(Object data)
{
	if(data.Message_Content.equals("赛马"))
	{
		int[] site = {
			0, 0, 0, 0, 0, 0, 0, 0, 0
		};
		String[] RPlace = new String[9];
		for(int i = 0; i < 9; i++)
		{
			site[i] = (int)(Math.random() * 20);
			StringBuilder ssb = new StringBuilder("ΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞ");
			ssb.replace(site[i], site[i] + 3, "🐎");
			RPlace[i] = ssb.toString();
		}
		int i3 = Math.random() * 9;
		site[i3] = 0;
		StringBuilder ssb = new StringBuilder("ΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞ");
		ssb.replace(0, 3, "🐎");
		RPlace[i3] = ssb.toString();
		int MySite = Math.random() * 9 + 1;
		String MyResult = " 赛马结果:";
		for(int i = 0; i < 9; i++)
		{
			MyResult = MyResult + "\n" + (i + 1) + "号:" + RPlace[i];
		}
		MyMsgApi.Message_Send_Group(data.Message_GroupUin, MyResult);
		String retText = "@" + data.nickName + " 你未输入号数,已为你分配到第" + MySite + "号马";
		int MyResult222 = site[MySite - 1];
		for(int i = 0; i < 9; i++)
		{
			for(int i2 = 0; i2 < 8; i2++)
			{
				int mid = 0;
				if(site[i2] > site[i2 + 1])
				{
					mid = site[i2 + 1];
					site[i2 + 1] = site[i2];
					site[i2] = mid;
				}
			}
		}
		for(int i = 0; i < 9; i++)
		{
			if(site[i] == MyResult222)
			{
				retText = retText + "\n你获得了第" + (i + 1) + "名";
				if(i < 5)
				{
					retText = retText + "\n获得金币:" + ((4 - i) * 500);
					item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + ((4 - i) * 500));
				}
				else
				{
					retText = retText + "\n输掉金币:" + ((i - 4) * 500);
					item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - ((i - 4) * 500));
				}
				new java.lang.Thread(new Runnable()
				{
					public void run()
					{
						Thread.sleep(1000);
						MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
					}
				}).start();
				//MyMsgApi.Message_Send_Group(data.Message_GroupUin, retText);
				return false;
			}
		}
		MyMsgApi.Message_Send_Group(data.Message_GroupUin, "结算过程中发生错误");
		return false;
	}
	if(data.Message_Content.startsWith("赛马"))
	{
		if(data.Message_Content.substring(2).length()!=1 || !data.Message_Content.substring(2).matches("^[1-9]$"))
		{
			MyMsgApi.Message_Send_Group(data.Message_GroupUin, "你输入的数字有误");
			return false;
		}
		int[] site = {
			0, 0, 0, 0, 0, 0, 0, 0, 0
		};
		String[] RPlace = new String[9];
		for(int i = 0; i < 9; i++)
		{
			site[i] = (int)(Math.random() * 20);
			StringBuilder ssb = new StringBuilder("ΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞ");
			ssb.replace(site[i], site[i] + 3, "🐎");
			RPlace[i] = ssb.toString();
		}
		int i3 = Math.random() * 9;
		site[i3] = 0;
		StringBuilder ssb = new StringBuilder("ΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞ");
		ssb.replace(0, 3, "🐎");
		RPlace[i3] = ssb.toString();
		int MySite = Integer.parseInt(data.Message_Content.substring(2));
		String MyResult = " 赛马结果:";
		for(int i = 0; i < 9; i++)
		{
			MyResult = MyResult + "\n" + (i + 1) + "号:" + RPlace[i];
		}
		MyMsg.FixAndSendMsg(data.Message_GroupUin,MyResult,DefInfo.CardDefImages,false);
	//	MyMsgApi.Message_Send_Group(data.Message_GroupUin, MyResult);
		String retText = "@" + data.nickName + " 你选择的是第" + MySite + "号马";
		int MyResult222 = site[MySite - 1];
		for(int i = 0; i < 9; i++)
		{
			for(int i2 = 0; i2 < 8; i2++)
			{
				int mid = 0;
				if(site[i2] > site[i2 + 1])
				{
					mid = site[i2 + 1];
					site[i2 + 1] = site[i2];
					site[i2] = mid;
				}
			}
		}
		for(int i = 0; i < 9; i++)
		{
			if(site[i] == MyResult222)
			{
				retText = retText + "\n你获得了第" + (i + 1) + "名";
				if(i < 5)
				{
					retText = retText + "\n获得金币:" + ((4 - i) * 500);
					item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + ((4 - i) * 500));
				}
				else
				{
					retText = retText + "\n输掉金币:" + ((i - 4) * 500);
					item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - ((i - 4) * 500));
				}
				new java.lang.Thread(new Runnable()
				{
					public void run()
					{
						Thread.sleep(1000);
						MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
					}
				}).start();
				//MyMsgApi.Message_Send_Group(data.Message_GroupUin, retText);
				return false;
			}
		}
		MyMsgApi.Message_Send_Group(data.Message_GroupUin, "结算过程中发生错误");
	}
	
	if(data.Message_Content.equals("猜拳石头"))
	{
		int iR = Math.random()*3;
		switch(iR)
		{
			case 0:
			MyMsg.FixAndSendMsg(data.Message_GroupUin,  "你出的是 石头\n我出了 石头\n这句是平局", DefInfo.CardDefImages, false);
			break;
			case 1:
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + 500);
			MyMsg.FixAndSendMsg(data.Message_GroupUin,  "你出的是 石头\n我出了 剪刀\n这局你赢了\n你获得了500金币", DefInfo.CardDefImages, false);
			
			break;
			case 2:
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - 500);
			MyMsg.FixAndSendMsg(data.Message_GroupUin,  "你出的是 石头\n我出了 布\n这局我赢了\n你输了500金币", DefInfo.CardDefImages, false);
			break;
		}
	}
		if(data.Message_Content.equals("猜拳剪刀"))
	{
		int iR = Math.random()*3;
		switch(iR)
		{
			case 0:
			MyMsg.FixAndSendMsg(data.Message_GroupUin,  "你出的是 剪刀\n我出了 剪刀\n这句是平局", DefInfo.CardDefImages, false);
			break;
			case 1:
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + 500);
			MyMsg.FixAndSendMsg(data.Message_GroupUin,  "你出的是 剪刀\n我出了 布\n这局你赢了\n你获得了500金币", DefInfo.CardDefImages, false);
			break;
			case 2:
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - 500);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "你出的是 剪刀\n我出了 石头\n这局我赢了\n你输了500金币", DefInfo.CardDefImages, false);
			break;
		}
	}
		if(data.Message_Content.equals("猜拳布"))
	{
		int iR = Math.random()*3;
		switch(iR)
		{
			case 0:
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "你出的是 布\n我出了 布\n这句是平局", DefInfo.CardDefImages, false);
			break;
			case 1:
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + 500);
			MyMsg.FixAndSendMsg(data.Message_GroupUin,   "你出的是 布\n我出了 石头\n这局你赢了\n你获得了500金币", DefInfo.CardDefImages, false);
			break;
			case 2:
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") - 500);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "你出的是 布\n我出了 剪刀\n这局我赢了\n你输了500金币", DefInfo.CardDefImages, false);
			break;
		}
	}
	if(data.Message_Content.equals("开始猜数字"))
	{
		if(GroupNumberLog.containsKey(data.Message_GroupUin))
		{
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "当前群有一场猜数字没有完成,请先完成再继续", DefInfo.CardDefImages, false);
			return false;
		}
		int NowInt = Math.random()*99+1;
		GroupNumberLog.put(data.Message_GroupUin,NowInt);
		MyMsg.FixAndSendMsg(data.Message_GroupUin, "猜数字已开始\n发送 我猜+数字 可以进行游戏哦\n数字大小为1-99", DefInfo.CardDefImages, false);
	}
	if(data.Message_Content.startsWith("我猜"))
	{
		if(!GroupNumberLog.containsKey(data.Message_GroupUin))
		{
			MyMsg.FixAndSendMsg(data.Message_GroupUin,"@"+data.nickName+" 当前没有游戏正在进行", DefInfo.CardDefImages, false);
			return false;
		}
		int GNumber = GroupNumberLog.get(data.Message_GroupUin);
		try{
			
			int tNumber = Integer.parseInt(data.Message_Content.substring(2));
			if(tNumber-GNumber>50)
			{
				MyMsg.FixAndSendMsg(data.Message_GroupUin,"@"+data.nickName+" 你输入的数字太大了", DefInfo.CardDefImages, false);
				return false;
			}
			if(tNumber-GNumber>20)
			{
				MyMsg.FixAndSendMsg(data.Message_GroupUin,"@"+data.nickName+" 你输入的数字大了", DefInfo.CardDefImages, false);
				return false;
			}
			if(tNumber-GNumber>5)
			{
				MyMsg.FixAndSendMsg(data.Message_GroupUin,"@"+data.nickName+" 你输入的数字稍大", DefInfo.CardDefImages, false);
				return false;
			}
			if(tNumber-GNumber>0)
			{
				MyMsg.FixAndSendMsg(data.Message_GroupUin,"@"+data.nickName+" 很接近了,再小一些就好了", DefInfo.CardDefImages, false);
				return false;
			}
			if(tNumber-GNumber<-50)
			{
				MyMsg.FixAndSendMsg(data.Message_GroupUin,"@"+data.nickName+" 你输入的数字太小了", DefInfo.CardDefImages, false);
				return false;
			}
			if(tNumber-GNumber<-20)
			{
				MyMsg.FixAndSendMsg(data.Message_GroupUin,"@"+data.nickName+" 你输入的数字小了", DefInfo.CardDefImages, false);
				return false;
			}
			if(tNumber-GNumber<-5)
			{
				MyMsg.FixAndSendMsg(data.Message_GroupUin,"@"+data.nickName+" 你输入的数字稍小了", DefInfo.CardDefImages, false);
				return false;
			}
			if(tNumber-GNumber<0)
			{
				MyMsg.FixAndSendMsg(data.Message_GroupUin,"@"+data.nickName+" 很接近了,再大一些就好了", DefInfo.CardDefImages, false);
				return false;
			}
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") + 3000);
				MyMsg.FixAndSendMsg(data.Message_GroupUin,"恭喜@"+data.nickName+" 猜出正确数字"+GNumber+",获得3000金币", DefInfo.CardDefImages, false);
				GroupNumberLog.remove(data.Message_GroupUin);
				item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "数字猜出次数", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "数字猜出次数") + 1);
				return false;
		}
		catch(Exception e)
		{
			MyMsg.FixAndSendMsg(data.Message_GroupUin,"@"+data.nickName+"你的输入有误", DefInfo.CardDefImages, false);
		}
	}
	return false;
}
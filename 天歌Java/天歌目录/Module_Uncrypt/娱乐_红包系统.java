

public boolean G_红包(Object data)
{
	if(data.Message_Content.startsWith("发红包 "))
	{
		String sp = data.Message_Content.substring(4);
		String[] sp2 = sp.split("\\|");
		if(sp2.length < 2)
		{
			String retText = "@" + data.nickName + "\n";
			retText = retText + "你发送的格式不正确\n正确的格式为 发红包 总金额|数量";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		try
		{
			long AllCost = Long.parseLong(sp2[0]);
			long number = Long.parseLong(sp2[1]);
			if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币")<AllCost)
			{
				String retText = "@" + data.nickName + "\n";
				retText = retText + "你没有足够的金币\n你目前拥有金币:"+item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币");
			    MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			if(number > 100)
			{
				String retText = "@" + data.nickName + "\n";
				retText = retText + "每次最多只能发送100个红包";
			    MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			if(number< 2)
			{
				String retText = "@" + data.nickName + "\n";
				retText = retText + "每次至少发2个红包";
			    MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			if(number > AllCost)
			{
				String retText = "@" + data.nickName + "\n";
				retText = retText + "必须保证每个红包至少一金币";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			ArrayList Cuts=new ArrayList();
			for (int i=0;i<number-1;i++)
			{
				long Site=Math.random()*AllCost+1;
				while (Cuts.contains(Site))
				{
					Site=(long)(Math.random()*AllCost+1);
				}
				Cuts.add(Site);
			}
			Collections.sort(Cuts);
			String RedPackId=""+(int)(Math.random()*99999+10000);
			for (int i=0;i<Cuts.size()+1;i++)
			{
				long Among=0;
				if(i==0)
				{
					Among=Cuts.get(0);
				}
				else if (i==Cuts.size())
				{
					Among=AllCost-Cuts.get(i-1);
				}
				else 
				{
					Among=Cuts.get(i)-Cuts.get(i-1);
				}
				item.SetItemData(data.Message_GroupUin,"红包数据",RedPackId,""+i,Among);
			}
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币",item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币")-AllCost);
			item.SetItemData(data.Message_GroupUin,"红包数据","LastRedPackId","Id",RedPackId);
			item.SetItemData(data.Message_GroupUin,"红包数据","AllRedPackId",RedPackId,AllCost);
			String retText = "@" + data.nickName + "\n";
			retText=retText+"红包发送成功\n大家可以发送 抢红包 来抢这个红包\n可以发送 红包池 来查看所有红包";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
			
		}
		catch(Exception e)
		{
			String retText = "@" + data.nickName + "\n";
			retText = retText + "你发送的数量有误\n正确的格式为 发红包 总金额|数量";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	
	
	if(data.Message_Content.equals("抢红包"))
	{
		if(item.GetItemData(data.Message_GroupUin,"红包数据","LastRedPackId","Id").equals(""))
		{
			String retText = "@" + data.nickName + "\n";
			retText = retText + "当前没有可以抢的红包\n或者上一个红包已被抢完\n你可以发送 红包池 来查看所有红包";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}

		String nowRedPackId=item.GetItemData(data.Message_GroupUin,"红包数据","LastRedPackId","Id");
		String[] RedPackList=item.MakeListForItem(data.Message_GroupUin,"红包数据",nowRedPackId);
		long GetCoin=item.GetItemDataInt(data.Message_GroupUin,"红包数据",nowRedPackId,RedPackList[0]);
		long restCoin=item.GetItemDataInt(data.Message_GroupUin,"红包数据","AllRedPackId",nowRedPackId);
		if(item.GetItemDataInt(data.Message_GroupUin,"红包数据","G"+nowRedPackId,data.Message_UserUin)==1)
		{
			String retText = "@" + data.nickName + "\n";
			retText = retText + "你已经抢过这个红包了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin,"红包数据","AllRedPackId",nowRedPackId,restCoin-GetCoin);
		item.DeleteItem(data.Message_GroupUin,"红包数据",nowRedPackId,RedPackList[0]);
		item.SetItemData(data.Message_GroupUin,"红包数据","G"+nowRedPackId,data.Message_UserUin,1);
		String retText = "@" + data.nickName + "\n";
		retText = retText + "抢红包成功\n抢到了金币:"+GetCoin;
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") +GetCoin);
		retText = retText + "\n剩余红包数量:"+(RedPackList.length-1);
		retText = retText + "\n剩余红包总金额:"+(restCoin-GetCoin);
		if(restCoin-GetCoin==0)
		{
			item.DeleteItemFile(data.Message_GroupUin,"红包数据",nowRedPackId);
			item.DeleteItemFile(data.Message_GroupUin,"红包数据","G"+nowRedPackId);
			item.SetItemData(data.Message_GroupUin,"红包数据","LastRedPackId","Id","");
			item.DeleteItem(data.Message_GroupUin,"红包数据","AllRedPackId",nowRedPackId);
		}
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.startsWith("抢红包"))
	{
		String str=data.Message_Content.substring(3);
		if(item.GetItemDataInt(data.Message_GroupUin,"红包数据","AllRedPackId",str)==0)
		{
			String retText = "@" + data.nickName + "\n";
			retText = retText + "当前没有这个红包哦";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}

		String nowRedPackId=str;
		String[] RedPackList=item.MakeListForItem(data.Message_GroupUin,"红包数据",nowRedPackId);
		long GetCoin=item.GetItemDataInt(data.Message_GroupUin,"红包数据",nowRedPackId,RedPackList[0]);
		long restCoin=item.GetItemDataInt(data.Message_GroupUin,"红包数据","AllRedPackId",nowRedPackId);
		if(item.GetItemDataInt(data.Message_GroupUin,"红包数据","G"+nowRedPackId,data.Message_UserUin)==1)
		{
			String retText = "@" + data.nickName + "\n";
			retText = retText + "你已经抢过这个红包了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin,"红包数据","AllRedPackId",nowRedPackId,restCoin-GetCoin);
		item.DeleteItem(data.Message_GroupUin,"红包数据",nowRedPackId,RedPackList[0]);
		item.SetItemData(data.Message_GroupUin,"红包数据","G"+nowRedPackId,data.Message_UserUin,1);
		String retText = "@" + data.nickName + "\n";
		retText = retText + "抢红包成功\n抢到了金币:"+GetCoin;
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "金币") +GetCoin);
		retText = retText + "\n剩余红包数量:"+(RedPackList.length-1);
		retText = retText + "\n剩余红包总金额:"+(restCoin-GetCoin);
		if(restCoin-GetCoin==0)
		{
			item.DeleteItemFile(data.Message_GroupUin,"红包数据",nowRedPackId);
			item.DeleteItemFile(data.Message_GroupUin,"红包数据","G"+nowRedPackId);
			
			if(nowRedPackId.equals(item.GetItemData(data.Message_GroupUin,"红包数据","LastRedPackId","Id")))
			{
				item.SetItemData(data.Message_GroupUin,"红包数据","LastRedPackId","Id","");
			}
			item.DeleteItem(data.Message_GroupUin,"红包数据","AllRedPackId",nowRedPackId);
		}
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
		if(data.Message_Content.equals("红包池"))
		{
			String[] RedPackList=item.MakeListForItem(data.Message_GroupUin,"红包数据","AllRedPackId");
			String retText="当前红包池有下列红包:\n";
			for(String HId:RedPackList)
			{
				String[] RedPackAA=item.MakeListForItem(data.Message_GroupUin,"红包数据",HId);
				retText=retText+"红包ID:"+HId;
				retText=retText+"\n数量:"+RedPackAA.length;
				retText=retText+"总金额:"+item.GetItemDataInt(data.Message_GroupUin,"红包数据","AllRedPackId",HId)+"\n";
			}
			retText=retText+"\n你可以发送 抢红包+ID 来进行抢红包";
			MyMsgApi.Message_Send_Group(data.Message_GroupUin,retText);
		    return false;
		}
	return false;
}
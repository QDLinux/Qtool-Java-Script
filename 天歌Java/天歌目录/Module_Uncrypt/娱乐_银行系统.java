

public boolean G_银行(Object data)
{
	if(data.Message_Content.equals("查询存款"))
	{
		String retText="@"+data.nickName+"\n";
		retText=retText+"你目前有存款:"+item.GetItemDataInt(data.Message_GroupUin,"GameDic",data.Message_UserUin,"银行存款");
		retText=retText+"\n你目前钱包金币:"+item.GetItemDataInt(data.Message_GroupUin,"GameDic",data.Message_UserUin,"金币");
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.startsWith("存款"))
	{
		String retText="@"+data.nickName+"\n";
		String Number=data.Message_Content.substring(2);
		try{
			long buyint = Long.parseLong(Number);
			if(buyint <= 0)
			{
				retText = retText + "你输入的数量有误";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			if (item.GetItemDataInt(data.Message_GroupUin,"GameDic",data.Message_UserUin,"金币")<buyint)
			{
				retText = retText + "你没有那么多钱\n赚够钱再来存款吧";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			item.SetItemData(data.Message_GroupUin,"GameDic",data.Message_UserUin,"金币", item.GetItemDataInt(data.Message_GroupUin,"GameDic",data.Message_UserUin,"金币") - buyint);
			item.SetItemData(data.Message_GroupUin,"GameDic",data.Message_UserUin,"银行存款", item.GetItemDataInt(data.Message_GroupUin,"GameDic",data.Message_UserUin,"银行存款") + buyint);
			retText = retText + "存款成功\n目前银行存款余额:"+item.GetItemDataInt(data.Message_GroupUin,"GameDic",data.Message_UserUin,"银行存款");
			retText = retText + "\n目前银钱包金币余额:"+item.GetItemDataInt(data.Message_GroupUin,"GameDic",data.Message_UserUin,"金币");
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
	if(data.Message_Content.startsWith("转账@"))
	{
		int index = data.Message_Content.lastIndexOf(" ");
		String retText="@"+data.nickName+"\n";
		try{
			long cost = Long.parseLong(data.Message_Content.substring(index+1));
			if(cost <= 0)
			{
				retText = retText + "转账的数值一定要大于0";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			if (item.GetItemDataInt(data.Message_GroupUin,"GameDic",data.Message_UserUin,"银行存款")<cost)
			{
				retText = retText + "你没有存那么多钱\n先存款再转账吧";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			for (String UserUin : data.atList)
			{
				item.SetItemData(data.Message_GroupUin,"GameDic",data.Message_UserUin,"银行存款", item.GetItemDataInt(data.Message_GroupUin,"GameDic",data.Message_UserUin,"银行存款") - cost);
				item.SetItemData(data.Message_GroupUin,"GameDic",UserUin,"银行存款", item.GetItemDataInt(data.Message_GroupUin,"GameDic",UserUin,"银行存款") + cost);
				retText = retText+"转账成功";
				retText = retText+"\n转账金额:"+cost;
				retText = retText+"\n你的余额:"+item.GetItemDataInt(data.Message_GroupUin,"GameDic",data.Message_UserUin,"银行存款");
				retText = retText+"\n对方余额:"+item.GetItemDataInt(data.Message_GroupUin,"GameDic",UserUin,"银行存款");
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			
		}
		catch(Exception e)
		{
			retText = retText + "你输入的数量有误";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.startsWith("取款"))
	{
		String retText="@"+data.nickName+"\n";
		String Number=data.Message_Content.substring(2);
		try{
			long buyint = Long.parseLong(Number);
			if(buyint <= 0)
			{
				retText = retText + "你输入的数量有误";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			if (item.GetItemDataInt(data.Message_GroupUin,"GameDic",data.Message_UserUin,"银行存款")<buyint)
			{
				retText = retText + "你没有那么多存款";
				MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
				return false;
			}
			item.SetItemData(data.Message_GroupUin,"GameDic",data.Message_UserUin,"金币", item.GetItemDataInt(data.Message_GroupUin,"GameDic",data.Message_UserUin,"金币") + buyint);
			item.SetItemData(data.Message_GroupUin,"GameDic",data.Message_UserUin,"银行存款", item.GetItemDataInt(data.Message_GroupUin,"GameDic",data.Message_UserUin,"银行存款") - buyint);
			retText = retText + "取款成功\n目前银行存款余额:"+item.GetItemDataInt(data.Message_GroupUin,"GameDic",data.Message_UserUin,"银行存款");
			retText = retText + "\n目前银钱包金币余额:"+item.GetItemDataInt(data.Message_GroupUin,"GameDic",data.Message_UserUin,"金币");
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
	return false;
	
	
}
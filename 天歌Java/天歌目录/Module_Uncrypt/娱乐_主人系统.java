

public boolean G_管理(Object data)
{
	if(!data.Message_UserUin.equals(mQQ)) return false;
	if(data.Message_Content.startsWith("充值金币@"))
	{
		int index = data.Message_Content.lastIndexOf(" ");
		long Among = Long.parseLong(data.Message_Content.substring(index).replace(" ",""));
		for(String Uin : data.atList)
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", Uin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", Uin, "金币") + Among);
		}
		MyMsgApi.Message_Send_Group(data.Message_GroupUin,"已充值");
		
	}
	if(data.Message_Content.startsWith("扣除金币@"))
	{
		int index = data.Message_Content.lastIndexOf(" ");
		long Among = Long.parseLong(data.Message_Content.substring(index).replace(" ",""));
		for(String Uin : data.atList)
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", Uin, "金币", item.GetItemDataInt(data.Message_GroupUin, "GameDic", Uin, "金币") - Among);
		}
		MyMsgApi.Message_Send_Group(data.Message_GroupUin,"已扣除");
	}
	if(data.Message_Content.startsWith("奖励物品@"))
	{
		int index = data.Message_Content.lastIndexOf(" ");
		String[] sp = data.Message_Content.substring(index).replace(" ","").split("\\|");
		long Among = Long.parseLong(sp[1]);
		for(String Uin : data.atList)
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", Uin, sp[0], item.GetItemDataInt(data.Message_GroupUin, "GameDic", Uin, sp[0]) + Among);
		}
		MyMsgApi.Message_Send_Group(data.Message_GroupUin,"已奖励");
	}
	if(data.Message_Content.startsWith("没收物品@"))
	{
		int index = data.Message_Content.lastIndexOf(" ");
		String[] sp = data.Message_Content.substring(index).replace(" ","").split("\\|");
		long Among = Long.parseLong(sp[1]);
		for(String Uin : data.atList)
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", Uin, sp[0], item.GetItemDataInt(data.Message_GroupUin, "GameDic", Uin, sp[0]) - Among);
		}
		MyMsgApi.Message_Send_Group(data.Message_GroupUin,"已没收");
	}
	return false;
}
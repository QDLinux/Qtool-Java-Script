

public Boolean module_强奸游戏(Object data)
{
	if(!data.isGroup) return false;
	if(data.content.startsWith("尾随@xx"))
	{
		if((Math.random()*6)<1)
		{
			
			for(String Uin:data.atList)
			{
			String retText="@"+data.nickName+"\n";
			retText=retText+"尾随被发现了\n";
			retText=retText+"被"+MyApi.GetMemberNameByUin(data.friendUin,Uin)+"暴打一顿";
			retText=retText+"住院5分钟";
			ShutUpQQ(data.friendUin,data.sendUin,300,data.time);
			QQ_sendMsg(data,retText);
			return false;
			}
		}
		for(String Uin:data.atList)
		{
			item.SetItemData(data.friendUin,data.sendUin,"强奸游戏","尾随",Uin);
			String retText="@"+data.nickName+"\n";
			retText=retText+"尾随成功\n";
			retText=retText+"你尾随在"+MyApi.GetMemberNameByUin(data.friendUin,Uin)+"身后伺机待发";
			QQ_sendMsg(data,retText);
			return false;
		}
	}
	if(data.content.startsWith("强奸@xx"))
	{
		String UinBack=item.GetItemData(data.friendUin,data.sendUin,"强奸游戏","尾随");
		item.SetItemData(data.friendUin,data.sendUin,"强奸游戏","尾随","");
		if(data.time-item.GetItemDataInt(data.friendUin,data.sendUin,"强奸游戏","上次强奸时间")<30)
		{
			String retText="@"+data.nickName+"\n";
			retText=retText+"你身体还虚着呢\n欲望这么强烈吗";
			QQ_sendMsg(data,retText);
			return false;
		}
		item.SetItemData(data.friendUin,data.sendUin,"强奸游戏","上次强奸时间",data.time);
		if(item.GetItemDataInt(data.friendUin,data.sendUin,"强奸游戏","NoJi")==1)
		{
			String retText="@"+data.nickName+"\n";
			retText=retText+"🐔🐔都没有\n强奸墙角去吧";
			QQ_sendMsg(data,retText);
			return false;
		}

		for(String Uin:data.atList)
		{
			if(!UinBack.equals(Uin))
			{
				String retText="@"+data.nickName+"\n";
				retText=retText+"光天化日下竟敢强奸别人\n进牢里反思5分钟吧";
				ShutUpQQ(data.friendUin,data.sendUin,300,data.time);
			    QQ_sendMsg(data,retText);
			    return false;
			}
			if((Math.random()*6)<1)
			{
				String retText="@"+data.nickName+"\n";
				retText=retText+"强奸失败\n"+MyApi.GetMemberNameByUin(data.friendUin,Uin)+"反手切掉了你的🐔🐔";
				item.SetItemData(data.friendUin,data.sendUin,"强奸游戏","NoJi",1);
				QQ_sendMsg(data,retText);
			    return false;
			}
			int rnd=(int)(Math.random()*20000);
			String retText="@"+data.nickName+"\n";
			retText=retText+"强奸成功\n你在"+MyApi.GetMemberNameByUin(data.friendUin,Uin)+"的身体中播种了你的种子";
			retText=retText+"\n并好运获得了"+rnd+"金币";
			item.SetItemData(data.friendUin, data.sendUin, "commonData", "Mark", item.GetItemDataInt(data.friendUin, data.sendUin, "commonData", "Mark") + rnd);
			QQ_sendMsg(data,retText);
			return false;
		}

	}
	if(data.content.equals("修复鸡鸡"))
	{
		
		if(item.GetItemDataInt(data.friendUin,data.sendUin,"强奸游戏","NoJi")==0)
		{
			String retText="@"+data.nickName+"\n";
			retText=retText+"修复失败\n你修个鸡儿";
			QQ_sendMsg(data,retText);
			return false;
		}
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "commonData", "Mark")<10000)
		{
			String retText="@"+data.nickName+"\n";
			retText=retText+"修复失败\n没钱还想学别人玩强奸?";
			QQ_sendMsg(data,retText);
			return false;
		}
		item.SetItemData(data.friendUin,data.sendUin, "commonData", "Mark", item.GetItemDataInt(data.friendUin,data.sendUin, "commonData", "Mark") -10000);
		item.SetItemData(data.friendUin,data.sendUin,"强奸游戏","NoJi",0);
		String retText="@"+data.nickName+"\n";
		retText=retText+"修复成功\n花费了10000金币";
		QQ_sendMsg(data,retText);
		return false;
	}
	return false;
}
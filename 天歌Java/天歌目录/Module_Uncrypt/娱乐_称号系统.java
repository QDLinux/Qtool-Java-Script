
String[] tName = new String[]{"无","刷图帝","群内色批","打劫狂魔","成语百科","走哪哪炸","闷砖磁铁","至强第六感","菜鸟","新手","入门","一般","大佬","巨佬","萌新"};
String[] PicLink = new String[]{"http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2593535066-387C072B211657D287856347D68FEC7A/0?term=2","http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2439339066-BDF27C7BC3152BB2A6012077AD9A6A48/0?term=2","http://gchat.qpic.cn/gchatpic_new/184757891/582544273-3080809243-5A56891FD0DBBF86D6A6181B4D8EED00/0?term=2","http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2395747458-360F86AEEDF4DDB859325D5ACF52F35B/0?term=2","http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2358557758-1C26619DFD4F5CE61D59ED10518DBFDF/0?term=2","http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2957330857-6DB859834A201A62CC155CC00796E68F/0?term=2","http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2472523071-A9C54BDFA1FC8DB628E16341CE352FBE/0?term=2"};
public boolean G_称号(Object data)
{
	if(data.Message_Content.equals("成就称号"))
	{
		String retText = "@"+ data.nickName + " \n";
		retText = retText + "刷图帝:"+item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "图片发送数量")+"/500";
		//retText = retText + "\n色诱基佬:"+item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "色诱成功次数")+"/50";
		retText = retText + "\n群内色批:"+item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "强奸成功次数")+"/50";
		retText = retText + "\n打劫狂魔:"+(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫成功次数")+item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫失败次数"))+"/200";
		retText = retText + "\n成语百科:"+item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "接龙成功次数")+"/40";
		retText = retText + "\n走哪哪炸:"+item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "被炸次数")+"/100";
		retText = retText + "\n闷砖磁铁:"+item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "被砸次数")+"/100";
		retText = retText + "\n至强第六感:"+item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "数字猜出次数")+"/40";
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
	}
	if(data.Message_Content.equals("等级称号"))
	{
		String retText = "@"+data.nickName+" \n";
		retText = retText + "菜鸟:"+item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验")+"/1000";
		retText = retText + "\n新手:"+item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验")+"/2000";
		retText = retText + "\n入门:"+item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验")+"/5000";
		retText = retText + "\n一般:"+(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验")+item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫失败次数"))+"/10000";
		retText = retText + "\n大佬:"+item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验")+"/50000";
		retText = retText + "\n巨佬:"+item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验")+"/100000";
		retText = retText + "\n萌新:"+item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验")+"/1000000";
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
	}
	if(data.Message_Content.equals("佩戴称号刷图帝"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "图片发送数量")<500)
		{
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "你还没得到这个成就呢\n努力努力再来吧", DefInfo.CardDefImages, false);
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin,"当前佩戴称号",1);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "成功佩戴刷图帝称号", DefInfo.CardDefImages, false);
			return false;
		}
	}
	if(data.Message_Content.equals("佩戴称号群内色批"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "强奸成功次数")<50)
		{
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "你还没得到这个成就呢\n努力努力再来吧", DefInfo.CardDefImages, false);
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin,"当前佩戴称号",2);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "成功佩戴群内色批称号", DefInfo.CardDefImages, false);
			return false;
		}
	}
	if(data.Message_Content.equals("佩戴称号打劫狂魔"))
	{
		if((item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫成功次数")+item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "打劫失败次数"))<200)
		{
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "你还没得到这个成就呢\n努力努力再来吧", DefInfo.CardDefImages, false);
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin,"当前佩戴称号",3);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "成功佩戴打劫狂魔称号", DefInfo.CardDefImages, false);
			return false;
		}
	}
	if(data.Message_Content.equals("佩戴称号成语百科"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "接龙成功次数")<40)
		{
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "你还没得到这个成就呢\n努力努力再来吧", DefInfo.CardDefImages, false);
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin,"当前佩戴称号",4);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "成功佩戴成语百科称号", DefInfo.CardDefImages, false);
			return false;
		}
	}
	if(data.Message_Content.equals("佩戴称号走哪哪炸"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "被炸次数")<100)
		{
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "你还没得到这个成就呢\n努力努力再来吧", DefInfo.CardDefImages, false);
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin,"当前佩戴称号",5);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "成功佩戴走哪哪炸称号", DefInfo.CardDefImages, false);
			return false;
		}
	}
	if(data.Message_Content.equals("佩戴称号闷砖磁铁"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "被砸次数")<100)
		{
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "你还没得到这个成就呢\n努力努力再来吧", DefInfo.CardDefImages, false);
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin,"当前佩戴称号",6);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "成功佩戴闷砖磁铁称号", DefInfo.CardDefImages, false);
			return false;
		}
	}
	if(data.Message_Content.equals("佩戴称号至强第六感"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "数字猜出次数")<40)
		{
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "你还没得到这个成就呢\n努力努力再来吧", DefInfo.CardDefImages, false);
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin,"当前佩戴称号",7);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "成功佩戴至强第六感称号", DefInfo.CardDefImages, false);
			return false;
		}
	}
	if(data.Message_Content.equals("佩戴称号菜鸟"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验")<1000)
		{
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "你还没得到这个成就呢\n努力努力再来吧", DefInfo.CardDefImages, false);
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin,"当前佩戴称号",8);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "成功佩戴菜鸟称号", DefInfo.CardDefImages, false);
			return false;
		}
	}
	if(data.Message_Content.equals("佩戴称号新手"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验")<2000)
		{
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "你还没得到这个成就呢\n努力努力再来吧", DefInfo.CardDefImages, false);
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin,"当前佩戴称号",9);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "成功佩戴新手称号", DefInfo.CardDefImages, false);
			return false;
		}
	}
	if(data.Message_Content.equals("佩戴称号入门"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验")<5000)
		{
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "你还没得到这个成就呢\n努力努力再来吧", DefInfo.CardDefImages, false);
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin,"当前佩戴称号",10);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "成功佩戴入门称号", DefInfo.CardDefImages, false);
			return false;
		}
	}
	if(data.Message_Content.equals("佩戴称号一般"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验")<10000)
		{
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "你还没得到这个成就呢\n努力努力再来吧", DefInfo.CardDefImages, false);
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin,"当前佩戴称号",11);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "成功佩戴一般称号", DefInfo.CardDefImages, false);
			return false;
		}
	}
	if(data.Message_Content.equals("佩戴称号大佬"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验")<50000)
		{
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "你还没得到这个成就呢\n努力努力再来吧", DefInfo.CardDefImages, false);
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin,"当前佩戴称号",12);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "成功佩戴大佬称号", DefInfo.CardDefImages, false);
			return false;
		}
	}
	if(data.Message_Content.equals("佩戴称号巨佬"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验")<100000)
		{
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "你还没得到这个成就呢\n努力努力再来吧", DefInfo.CardDefImages, false);
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin,"当前佩戴称号",13);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "成功佩戴巨佬称号", DefInfo.CardDefImages, false);
			return false;
		}
	}
	if(data.Message_Content.equals("佩戴称号萌新"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "经验")<1000000)
		{
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "你还没得到这个成就呢\n努力努力再来吧", DefInfo.CardDefImages, false);
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin,"当前佩戴称号",14);
			MyMsg.FixAndSendMsg(data.Message_GroupUin, "成功佩戴萌新称号", DefInfo.CardDefImages, false);
			return false;
		}
	}
	return false;
}
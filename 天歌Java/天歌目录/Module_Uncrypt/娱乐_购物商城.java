

public boolean G_商城(Object data)
{
	if(data.Message_Content.equals("购物商城"))
	{
		String retText = "@"+data.nickName+"\n";
		retText = retText + "[e]道具商城\n[e]坐骑商城\n[e]钓鱼商城\n[e]装备商城";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
	}
	if(data.Message_Content.equals("道具商城"))
	{
		String retText = "@"+data.nickName+"\n";
		retText = retText + "炸弹  500金币\n闷砖   500金币\n拆弹钳  800金币\n铁头盔  800金币\n发送 购买+物品+数量来购买\n如 购买炸弹10";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
	}
	if(data.Message_Content.equals("坐骑商城"))
	{
		String retText = "@"+data.nickName+" ";
		retText = retText + "坐骑列表:\n北冥白羽 [e]彩衣花轿 [e]鲲西之莲\n南方冥龙 [e]破天飞剑 [e]破天轮回\n神鹿金角 [e]西行青龙 [e]星宿雯心\n漾芯惧意 [e]幽魂鬼猫 [e]战幽之马\n------------☞坐骑商城第二页☜-----------";
		retText = retText + "\n发送购买坐骑+名称来进行购买\n发送坐骑名称来查看坐骑信息";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
	}
	
	if(data.Message_Content.equals("坐骑商城第二页"))
	{
		String retText = "@"+data.nickName+" ";
		retText = retText + "坐骑列表:\n幽冥白虎 [e]金羽凤凰 [e]金鹏狮鹫\n闲云游鹤 [e]幽冥灵猫 [e]赤焰穷奇\n深海幻境 [e]天空领主 [e]瑞祥麒麟\n邪眸白虎 [e]七彩神鹿 [e]荷漾清莲";
		retText = retText + "\n发送购买坐骑+名称来进行购买\n发送坐骑名称来查看坐骑信息";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
	}
	if(data.Message_Content.equals("钓鱼商城"))
	{
		String retText = "鱼线 5000金币\n鱼竿 5000金币\n鱼饵 4000金币 \n\n♧卖鱼♧\n青鱼 800金币 \n鲫鱼 750金币\n鲤鱼 850金币\n草鱼 800金币\n鲶鱼 700金币 \n桂鱼 600金币\n\n垃圾 随机100-2000金币\n你可以发送购买+物品名+数量来进行购买\n发送出售+物品名+数量来出售物品";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
	}
	if(data.Message_Content.equals("装备商城"))
	{
		String retText="装备商城\n1.匕首 1000金币\n2.电棍 5000金币\n3.手枪 20000金币\n4.激光剑 50000金币\n5.火箭筒 150000金币\n6.导弹 500000金币\n7.核弹 2000000金币 \n可以发送 购买装备+名字 来进行购买\n发送 使用装备+名字 来使用装备";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("卡包商城"))
	{
		String retText="1.金币卡 5000金币\n2.经验卡 3000金币\n3.随机卡 10000金币\n\n可以发送 购买+名称+数量来进行购买\n发送 使用+名称来使用\n发送 一键使用+名称 来使用不多于500张卡片";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		
	}
	return false;
}
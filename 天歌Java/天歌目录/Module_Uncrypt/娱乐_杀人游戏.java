

public Boolean module_杀人游戏(Object data)
{
	if(!data.isGroup) return false;
	if(data.content.equals("我的杀人信息"))
	{
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "init") == 0)
		{
			InitUserInfo(data.friendUin, data.sendUin);
		}
		String retText = "@" + data.nickName + "\n";
		retText = retText + "生命:" + item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "生命R") + "/" + item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "生命");
		retText = retText + "\n攻击:" + item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "攻击");
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "坐骑数据", "NowUse") != 0)
		{
			retText = retText + "x2";
		}
		retText = retText + "\n防御:" + item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "防御");
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "坐骑数据", "NowUse") != 0)
		{
			retText = retText + "x2";
		}
		retText = retText + "\n护盾:" + item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "护盾") + "(" + item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "绝对护盾") + ")";
		retText = retText + "\n可用升级点数:" + item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "升级点数");
		retText = retText + "\n复活药水:" + item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "复活药水");
		retText = retText + "\n小型护盾:" + item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "小型护盾");
		retText = retText + "\n中型护盾:" + item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "中型护盾");
		retText = retText + "\n大型护盾:" + item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "大型护盾");
		retText = retText + "\n绝对护盾:" + item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "绝对护盾");
		QQ_sendMsg(data, retText);
		return false;
	}
	if(data.content.startsWith("杀人@"))
	{
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "init") == 0)
		{
			InitUserInfo(data.friendUin, data.sendUin);
		}
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "生命R") <= 0)
		{
			retText = retText + "你已经死亡了\n无法继续杀人";
			QQ_sendMsg(data, retText);
			return false;
		}
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "lastTime") + 2 >= data.time)
		{
			retText = retText + "你需要休息,不要那么急";
			QQ_sendMsg(data, retText);
			return false;
		}
		for(String Uin: data.atList)
		{
			if(item.GetItemDataInt(data.friendUin, Uin, "杀人游戏", "init") == 0)
			{
				retText = retText + "对方还未初始化\n你不能杀对方";
				QQ_sendMsg(data, retText);
				return false;
			}
			if(item.GetItemDataInt(data.friendUin, Uin, "杀人游戏", "生命R") <= 0)
			{
				retText = retText + "对方已经死亡了\n你不能继续杀对方";
				QQ_sendMsg(data, retText);
				return false;
			}
			item.SetItemData(data.friendUin, data.sendUin, "杀人游戏", "lastTime", data.time);
			int defend = item.GetItemDataInt(data.friendUin, Uin, "杀人游戏", "防御");
			if(item.GetItemDataInt(data.friendUin, Uin, "坐骑数据", "NowUse") != 0)
			{
				defend = defend*2;
			}
			int attack = item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "攻击");
			if(item.GetItemDataInt(data.friendUin, data.sendUin, "坐骑数据", "NowUse") != 0)
			{
				attack = attack*2;
			}
			if(defend > attack)
			{
				retText = retText + "你太弱了\n给对方造成了0点伤害";
				QQ_sendMsg(data, retText);
				return false;
			}
			if(item.GetItemDataInt(data.friendUin, Uin, "杀人游戏", "绝对护盾") != 0)
			{
				retText = retText + "你攻击了对方\n打在了护盾上\n造成了0点伤害\n对方生命值:";
				retText = retText + item.GetItemDataInt(data.friendUin, Uin, "杀人游戏", "生命R") + "/" + item.GetItemDataInt(data.friendUin, Uin, "杀人游戏", "生命");
				item.SetItemData(data.friendUin, Uin, "杀人游戏", "绝对护盾", item.GetItemDataInt(data.friendUin, Uin, "杀人游戏", "绝对护盾") - 1);
				QQ_sendMsg(data, retText);
				return false;
			}
			int Protect = item.GetItemDataInt(data.friendUin, Uin, "杀人游戏", "护盾");
			if(Protect >= attack)
			{
				retText = retText + "你攻击了对方\n打在了护盾上\n造成了0点伤害\n对方生命值:";
				retText = retText + item.GetItemDataInt(data.friendUin, Uin, "杀人游戏", "生命R") + "/" + item.GetItemDataInt(data.friendUin, Uin, "杀人游戏", "生命");
				item.SetItemData(data.friendUin, Uin, "杀人游戏", "护盾", item.GetItemDataInt(data.friendUin, Uin, "杀人游戏", "护盾") - attack);
				QQ_sendMsg(data, retText);
				return false;
			}
			if(Protect != 0)
			{
				item.SetItemData(data.friendUin, Uin, "杀人游戏", "护盾", 0);
			}
			attack = attack - Protect;
			if(defend > attack)
			{
				retText = retText + "你攻击了对方\n造成了0点伤害\n对方生命值:";
				retText = retText + item.GetItemDataInt(data.friendUin, Uin, "杀人游戏", "生命R") + "/" + item.GetItemDataInt(data.friendUin, Uin, "杀人游戏", "生命");
				QQ_sendMsg(data, retText);
				return false;
			}
			int Blood = attack - defend;
			if(Blood >= item.GetItemDataInt(data.friendUin, Uin, "杀人游戏", "生命R"))
			{
				
				retText = retText + "你攻击了对方\n造成了" + item.GetItemDataInt(data.friendUin, Uin, "杀人游戏", "生命R") + "点伤害\n对方生命值:";
				item.SetItemData(data.friendUin, Uin, "杀人游戏", "生命R", 0);
				retText = retText + item.GetItemDataInt(data.friendUin, Uin, "杀人游戏", "生命R") + "/" + item.GetItemDataInt(data.friendUin, Uin, "杀人游戏", "生命");
				retText = retText + "\n对方已经死亡";
				int dt=(int)(Math.random()*10+3);
				int coin=(int)(Math.random()*10000+1000);
				retText = retText + "\n你获得了"+dt+"点升级点数";
				retText = retText + "\n你获得了"+coin+"金币";
				item.SetItemData(data.friendUin, data.sendUin, "杀人游戏", "升级点数", item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "升级点数") + dt);
				item.SetItemData(data.friendUin, data.sendUin, "commonData", "Mark", item.GetItemDataInt(data.friendUin, data.sendUin, "commonData", "Mark") + coin);

				QQ_sendMsg(data, retText);
				return false;
			}
			else
			{
				
				retText = retText + "你攻击了对方\n造成了" + Blood + "点伤害\n对方生命值:";
				item.SetItemData(data.friendUin, Uin, "杀人游戏", "生命R", item.GetItemDataInt(data.friendUin, Uin, "杀人游戏", "生命R") - Blood);
				retText = retText + item.GetItemDataInt(data.friendUin, Uin, "杀人游戏", "生命R") + "/" + item.GetItemDataInt(data.friendUin, Uin, "杀人游戏", "生命");
				QQ_sendMsg(data, retText);
				return false;
			}
		}
	}
	if(data.content.equals("杀人系统商城"))
	{
		String retText = "商城\n\n复活药水 1000金币\n小型护盾(50点) 1000金币\n中型护盾(500点) 10000金币\n大型护盾(5000点) 100000金币\n绝对护盾(5次) 50000金币\n\n强化攻击\n强化生命\n强化防御\n\n发送 购买+物品名购买物品\n发送使用 物品名 使用物品\n强化请直接发强化xx";
		QQ_sendMsg(data, retText);
		return false;
	}
	if(data.content.equals("购买复活药水"))
	{
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "init") == 0)
		{
			InitUserInfo(data.friendUin, data.sendUin);
		}
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "commonData", "Mark") < 1000)
		{
			retText = retText + "你的金币不足\n你购买所需金币:1000\n你目前拥有金币" + item.GetItemDataInt(data.friendUin, data.sendUin, "commonData", "Mark");
			QQ_sendMsg(data, retText, true);
			return false;
		}
		item.SetItemData(data.friendUin, data.sendUin, "commonData", "Mark", item.GetItemDataInt(data.friendUin, data.sendUin, "commonData", "Mark") - 1000);
		retText = retText + "购买复活药水成功\n花费金币:1000\n剩余金币:" + item.GetItemDataInt(data.friendUin, data.sendUin, "commonData", "Mark");
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏", "复活药水", item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "复活药水") + 1);
		QQ_sendMsg(data, retText, true);
		return false;
	}
	if(data.content.equals("购买小型护盾"))
	{
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "init") == 0)
		{
			InitUserInfo(data.friendUin, data.sendUin);
		}
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "commonData", "Mark") < 1000)
		{
			retText = retText + "你的金币不足\n你购买所需金币:1000\n你目前拥有金币" + item.GetItemDataInt(data.friendUin, data.sendUin, "commonData", "Mark");
			QQ_sendMsg(data, retText, true);
			return false;
		}
		item.SetItemData(data.friendUin, data.sendUin, "commonData", "Mark", item.GetItemDataInt(data.friendUin, data.sendUin, "commonData", "Mark") - 1000);
		retText = retText + "购买小型护盾成功\n花费金币:1000\n剩余金币:" + item.GetItemDataInt(data.friendUin, data.sendUin, "commonData", "Mark");
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏", "小型护盾", item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "小型护盾") + 1);
		QQ_sendMsg(data, retText, true);
		return false;
	}
	if(data.content.equals("购买中型护盾"))
	{
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "init") == 0)
		{
			InitUserInfo(data.friendUin, data.sendUin);
		}
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "commonData", "Mark") < 10000)
		{
			retText = retText + "你的金币不足\n你购买所需金币:10000\n你目前拥有金币" + item.GetItemDataInt(data.friendUin, data.sendUin, "commonData", "Mark");
			QQ_sendMsg(data, retText, true);
			return false;
		}
		item.SetItemData(data.friendUin, data.sendUin, "commonData", "Mark", item.GetItemDataInt(data.friendUin, data.sendUin, "commonData", "Mark") - 10000);
		retText = retText + "购买中型护盾成功\n花费金币:10000\n剩余金币:" + item.GetItemDataInt(data.friendUin, data.sendUin, "commonData", "Mark");
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏", "中型护盾", item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "中型护盾") + 1);
		QQ_sendMsg(data, retText, true);
		return false;
	}
	if(data.content.equals("购买大型护盾"))
	{
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "init") == 0)
		{
			InitUserInfo(data.friendUin, data.sendUin);
		}
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "commonData", "Mark") < 100000)
		{
			retText = retText + "你的金币不足\n你购买所需金币:100000\n你目前拥有金币" + item.GetItemDataInt(data.friendUin, data.sendUin, "commonData", "Mark");
			QQ_sendMsg(data, retText, true);
			return false;
		}
		item.SetItemData(data.friendUin, data.sendUin, "commonData", "Mark", item.GetItemDataInt(data.friendUin, data.sendUin, "commonData", "Mark") - 100000);
		retText = retText + "购买大型护盾成功\n花费金币:100000\n剩余金币:" + item.GetItemDataInt(data.friendUin, data.sendUin, "commonData", "Mark");
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏", "大型护盾", item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "大型护盾") + 1);
		QQ_sendMsg(data, retText, true);
		return false;
	}
	if(data.content.equals("购买绝对护盾"))
	{
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "init") == 0)
		{
			InitUserInfo(data.friendUin, data.sendUin);
		}
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "commonData", "Mark") < 50000)
		{
			retText = retText + "你的金币不足\n你购买所需金币:50000\n你目前拥有金币" + item.GetItemDataInt(data.friendUin, data.sendUin, "commonData", "Mark");
			QQ_sendMsg(data, retText, true);
			return false;
		}
		item.SetItemData(data.friendUin, data.sendUin, "commonData", "Mark", item.GetItemDataInt(data.friendUin, data.sendUin, "commonData", "Mark") - 50000);
		retText = retText + "购买绝对护盾成功\n花费金币:50000\n剩余金币:" + item.GetItemDataInt(data.friendUin, data.sendUin, "commonData", "Mark");
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏", "绝对护盾L", item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "绝对护盾L") + 1);
		QQ_sendMsg(data, retText, true);
		return false;
	}
	if(data.content.equals("使用绝对护盾"))
	{
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "init") == 0)
		{
			InitUserInfo(data.friendUin, data.sendUin);
		}
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "绝对护盾L") <= 0)
		{
			retText = retText + "你还没有绝对护盾,不能使用";
			QQ_sendMsg(data, retText, true);
			return false;
		}
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "绝对护盾") > 0)
		{
			retText = retText + "你身上的绝对护盾效果还在呢\n不能再次使用";
			QQ_sendMsg(data, retText, true);
			return false;
		}
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏", "绝对护盾L", item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "绝对护盾L") - 1);
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏", "绝对护盾", 5);
		retText = retText + "使用成功\n现在你能抵御五次攻击";
		QQ_sendMsg(data, retText, true);
		return false;
	}
	if(data.content.equals("使用小型护盾"))
	{
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "init") == 0)
		{
			InitUserInfo(data.friendUin, data.sendUin);
		}
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "小型护盾") <= 0)
		{
			retText = retText + "你还没有小型护盾,不能使用";
			QQ_sendMsg(data, retText, true);
			return false;
		}
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "护盾") > 0)
		{
			retText = retText + "你身上的护盾效果还在呢\n不能再次使用";
			QQ_sendMsg(data, retText, true);
			return false;
		}
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏", "小型护盾", item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "小型护盾") - 1);
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏", "护盾", 50);
		retText = retText + "使用成功\n获得50点护盾值";
		QQ_sendMsg(data, retText, true);
		return false;
	}
	if(data.content.equals("使用中型护盾"))
	{
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "init") == 0)
		{
			InitUserInfo(data.friendUin, data.sendUin);
		}
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "中型护盾") <= 0)
		{
			retText = retText + "你还没有中型护盾,不能使用";
			QQ_sendMsg(data, retText, true);
			return false;
		}
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "护盾") > 0)
		{
			retText = retText + "你身上的护盾效果还在呢\n不能再次使用";
			QQ_sendMsg(data, retText, true);
			return false;
		}
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏", "中型护盾", item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "中型护盾") - 1);
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏", "护盾", 500);
		retText = retText + "使用成功\n获得500点护盾值";
		QQ_sendMsg(data, retText, true);
		return false;
	}
	if(data.content.equals("使用大型护盾"))
	{
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "init") == 0)
		{
			InitUserInfo(data.friendUin, data.sendUin);
		}
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "大型护盾") <= 0)
		{
			retText = retText + "你还没有大型护盾,不能使用";
			QQ_sendMsg(data, retText, true);
			return false;
		}
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "护盾") > 0)
		{
			retText = retText + "你身上的护盾效果还在呢\n不能再次使用";
			QQ_sendMsg(data, retText, true);
			return false;
		}
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏", "大型护盾", item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "大型护盾") - 1);
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏", "护盾", 5000);
		retText = retText + "使用成功\n获得5000点护盾值";
		QQ_sendMsg(data, retText, true);
		return false;
	}
		if(data.content.equals("使用复活药水"))
	{
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "init") == 0)
		{
			InitUserInfo(data.friendUin, data.sendUin);
		}
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "复活药水") <= 0)
		{
			retText = retText + "你还没有复活药水,不能使用";
			QQ_sendMsg(data, retText, true);
			return false;
		}
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏", "护盾", item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "护盾") +100);
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏", "绝对护盾", item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "绝对护盾") +1);
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏", "复活药水", item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "复活药水") - 1);
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏", "生命R", item.GetItemData(data.friendUin, data.sendUin, "杀人游戏", "生命"));
		retText = retText + "使用成功\n生命回满\n获得100护盾值\n获得1次绝对防御";
		QQ_sendMsg(data, retText, true);
		return false;
	}
	
	
	if(data.content.equals("强化攻击"))
	{
		String retText="@"+data.nickName+"\n";
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "升级点数")<3)
		{
			retText=retText+"你的升级点数不足\n至少需要3点升级点数来进行升级";
			QQ_sendMsg(data, retText);
		    return false;
		}
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏","升级点数" ,item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "升级点数")-3);
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏","攻击" ,item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "攻击")+10);
		retText=retText+"强化成功\n你目前的攻击力为:"+item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "攻击");
		QQ_sendMsg(data, retText);
		return false;
	}
		if(data.content.equals("强化防御"))
	{
		String retText="@"+data.nickName+"\n";
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "升级点数")<3)
		{
			retText=retText+"你的升级点数不足\n至少需要3点升级点数来进行升级";
			QQ_sendMsg(data, retText);
		    return false;
		}
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏","升级点数" ,item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "升级点数")-3);
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏","防御" ,item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "防御")+10);
		retText=retText+"强化成功\n你目前的防御力为:"+item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "防御");
		QQ_sendMsg(data, retText);
		return false;
	}
			if(data.content.equals("强化生命"))
	{
		String retText="@"+data.nickName+"\n";
		if(item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "升级点数")<3)
		{
			retText=retText+"你的升级点数不足\n至少需要3点升级点数来进行升级";
			QQ_sendMsg(data, retText);
		    return false;
		}
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏","升级点数" ,item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "升级点数")-3);
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏","生命" ,item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "生命")+10);
		item.SetItemData(data.friendUin, data.sendUin, "杀人游戏","生命R" ,item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "生命R")+10);
		retText=retText+"强化成功\n你目前的防御力为:"+item.GetItemDataInt(data.friendUin, data.sendUin, "杀人游戏", "生命");
		QQ_sendMsg(data, retText);
		return false;
	}
	return false;
	
}
public void InitUserInfo(String GroupUin, QQUin)
{
	item.SetItemData(GroupUin, QQUin, "杀人游戏", "生命", 120);
	item.SetItemData(GroupUin, QQUin, "杀人游戏", "攻击", 10);
	item.SetItemData(GroupUin, QQUin, "杀人游戏", "防御", 5);
	item.SetItemData(GroupUin, QQUin, "杀人游戏", "护盾", 50);
	item.SetItemData(GroupUin, QQUin, "杀人游戏", "绝对护盾", 3);
	item.SetItemData(GroupUin, QQUin, "杀人游戏", "生命R", 120);
	item.SetItemData(GroupUin, QQUin, "杀人游戏", "升级点数", 5);
	item.SetItemData(GroupUin, QQUin, "杀人游戏", "生命L", 1);
	item.SetItemData(GroupUin, QQUin, "杀人游戏", "攻击L", 1);
	item.SetItemData(GroupUin, QQUin, "杀人游戏", "防御L", 1);
	item.SetItemData(GroupUin, QQUin, "杀人游戏", "init", 1);
	item.SetItemData(GroupUin, QQUin, "杀人游戏", "复活药水", 1);
	item.SetItemData(GroupUin, QQUin, "杀人游戏", "小型护盾", 1);
}
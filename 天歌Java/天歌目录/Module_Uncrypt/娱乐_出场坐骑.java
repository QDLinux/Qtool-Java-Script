
public boolean G_坐骑(Object data)
{
	if(getDay() != item.GetItemDataInt(data.Message_GroupUin, "GameDic",  data.Message_UserUin, "上次坐骑时间"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑") == 0)
		{
			item.SetItemData(data.Message_GroupUin, "GameDic",  data.Message_UserUin, "上次坐骑时间", getDay());	
		}
		else
		{
			String[] NameList = {
				"北冥白羽", "彩衣花轿", "鲲西之莲", "南方冥龙", "破天飞剑", "破天轮回", "神鹿金角", "西行青龙", "星宿雯心", "漾芯惧意", "幽魂鬼猫", "战幽之马", "幽冥白虎", "金羽凤凰", "金鹏狮鹫","闲云游鹤","幽冥灵猫","赤焰穷奇","深海幻境","天空领主","瑞祥麒麟","邪眸白虎","七彩神鹿","荷漾清莲"
			};
			String[] LinkList = {
				"http://gchat.qpic.cn/gchatpic_new/184757891/582544273-3052724445-E441AA54A50664796D67CB6BAF8C02C3/0?term=2", "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2786240610-2FF23E45C5CE78328403C9F9C83603A2/0?term=2", "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2920611391-3246682F3276396FE9E7FE67D0EC2C94/0?term=2", "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2800012549-7A5D9450BAF0620BA4DF457D9E159D0E/0?term=2", "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-3023083529-C9BB69D274A3F3F8EFDAEADEF1E74160/0?term=2", "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-3115428439-6F8DA450E390ED2003AECBEDE5339AFA/0?term=2", "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2601208602-3BF1FC8F5A41DC987090FD69ED83EF05/0?term=2", "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-3163220689-66EE0EFC9CE35E8D31854F946B0C6D56/0?term=2", "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2385646959-AD61A7150F9FEA142D0BDB079D4FF9F7/0?term=2", "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-3081680069-E1CAA5F2360CF697E82F6A6239634F6D/0?term=2", "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2200856169-888E44D5435664A476D7BA241AAF23DC/0?term=2", "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2575039283-BD2ECB72D2E72C8C7E7A317CFE5C36CF/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2978247251-8330183FAB6B9D0284B575B1EE0EDA9F/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2570688377-C477AD7B55281A327B1300A30AB0C876/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2244621537-34E8640C379C5EE63C0B3EF2D9B5FE5A/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2822472241-1CEFCCD892601E8691EE6E0D4A59E0C7/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2699327632-4E4AF5817B15C62784AC0D46671A3600/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2862929304-CE3EBB27AB5B1A20B1F6EB71E8F10866/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2362900967-1A0653AD1DC2EC21940D0C54083F9CD9/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2559027175-16B6BD4A031277D1DBC23D7EA59B38B1/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2258659865-42A5B428F17CD995163E3D8B11E718E8/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2623514582-25C103B3E6E8B26A6E8837C4C6AAD64E/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2818860434-5AE1CE7729974783A4DE7E01CDF7A69E/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2230414764-570E2AF61E4A4AD7E4ADDB6D9390D723/0?term=2"
			};
			retText = retText + "这是你今天第一次发言\n";
			int Index = item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑") - 1;
			retText = retText + "你乘坐着 " + NameList[Index] + " 来到本群\n";
			int rnd = (int)(Math.random() * 2000 + 100);
			retText = retText + "你获得了" + rnd + "金币";
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") + rnd);
			item.SetItemData(data.Message_GroupUin, "GameDic",  data.Message_UserUin, "上次坐骑时间", getDay());
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,LinkList[Index],true);
		}
	}
	if(data.Message_Content.equals("出场"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑") == 0)
		{
			retText = retText + "出场成功\n";
			retText = retText + "你是 走路 来到本群\n\n";
			retText = retText + "发送 购物商城 购买属于你的坐骑吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			item.SetItemData(data.Message_GroupUin, "GameDic",  data.Message_UserUin, "上次坐骑时间", getDay());	
		}
		else
		{
			String[] NameList = {
				"北冥白羽", "彩衣花轿", "鲲西之莲", "南方冥龙", "破天飞剑", "破天轮回", "神鹿金角", "西行青龙", "星宿雯心", "漾芯惧意", "幽魂鬼猫", "战幽之马", "幽冥白虎", "金羽凤凰", "金鹏狮鹫","闲云游鹤","幽冥灵猫","赤焰穷奇","深海幻境","天空领主","瑞祥麒麟","邪眸白虎","七彩神鹿","荷漾清莲"
			};
			String[] LinkList = {
				"http://gchat.qpic.cn/gchatpic_new/184757891/582544273-3052724445-E441AA54A50664796D67CB6BAF8C02C3/0?term=2", "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2786240610-2FF23E45C5CE78328403C9F9C83603A2/0?term=2", "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2920611391-3246682F3276396FE9E7FE67D0EC2C94/0?term=2", "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2800012549-7A5D9450BAF0620BA4DF457D9E159D0E/0?term=2", "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-3023083529-C9BB69D274A3F3F8EFDAEADEF1E74160/0?term=2", "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-3115428439-6F8DA450E390ED2003AECBEDE5339AFA/0?term=2", "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2601208602-3BF1FC8F5A41DC987090FD69ED83EF05/0?term=2", "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-3163220689-66EE0EFC9CE35E8D31854F946B0C6D56/0?term=2", "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2385646959-AD61A7150F9FEA142D0BDB079D4FF9F7/0?term=2", "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-3081680069-E1CAA5F2360CF697E82F6A6239634F6D/0?term=2", "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2200856169-888E44D5435664A476D7BA241AAF23DC/0?term=2", "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2575039283-BD2ECB72D2E72C8C7E7A317CFE5C36CF/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2978247251-8330183FAB6B9D0284B575B1EE0EDA9F/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2570688377-C477AD7B55281A327B1300A30AB0C876/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2244621537-34E8640C379C5EE63C0B3EF2D9B5FE5A/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2822472241-1CEFCCD892601E8691EE6E0D4A59E0C7/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2699327632-4E4AF5817B15C62784AC0D46671A3600/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2862929304-CE3EBB27AB5B1A20B1F6EB71E8F10866/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2362900967-1A0653AD1DC2EC21940D0C54083F9CD9/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2559027175-16B6BD4A031277D1DBC23D7EA59B38B1/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2258659865-42A5B428F17CD995163E3D8B11E718E8/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2623514582-25C103B3E6E8B26A6E8837C4C6AAD64E/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2818860434-5AE1CE7729974783A4DE7E01CDF7A69E/0?term=2","http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2230414764-570E2AF61E4A4AD7E4ADDB6D9390D723/0?term=2"
			};
			retText = retText + "出场成功\n";
			int Index = item.GetItemDataInt(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑") - 1;
			retText = retText + "你乘坐着 " + NameList[Index] + " 来到本群\n";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,LinkList[Index],true);
		}
	}
	if(data.Message_Content.equals("北冥白羽"))
	{
		String retText = "✤北冥白羽✤\n价格:400000金币\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,"http://gchat.qpic.cn/gchatpic_new/184757891/582544273-3052724445-E441AA54A50664796D67CB6BAF8C02C3/0?term=2",true);
	}
	if(data.Message_Content.equals("彩衣花轿"))
	{
		String retText = "✤彩衣花轿✤\n价格:150000金币\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,"http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2786240610-2FF23E45C5CE78328403C9F9C83603A2/0?term=2",true);
	}
	if(data.Message_Content.equals("鲲西之莲"))
	{
		String retText = "✤鲲西之莲✤\n价格:300000金币\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,"http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2920611391-3246682F3276396FE9E7FE67D0EC2C94/0?term=2",true);
	}
	if(data.Message_Content.equals("南方冥龙"))
	{
		String retText = "✤南方冥龙✤\n价格:450000金币\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,"http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2800012549-7A5D9450BAF0620BA4DF457D9E159D0E/0?term=2",true);
	}
	if(data.Message_Content.equals("破天飞剑"))
	{
		String retText = "✤破天飞剑✤\n价格:350000金币\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,"http://gchat.qpic.cn/gchatpic_new/184757891/582544273-3023083529-C9BB69D274A3F3F8EFDAEADEF1E74160/0?term=2",true);
	}
	if(data.Message_Content.equals("破天轮回"))
	{
		String retText = "✤破天轮回✤\n价格:250000金币\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,"http://gchat.qpic.cn/gchatpic_new/184757891/582544273-3115428439-6F8DA450E390ED2003AECBEDE5339AFA/0?term=2",true);
	}
	if(data.Message_Content.equals("神鹿金角"))
	{
		String retText = "✤神鹿金角✤\n价格:280000金币\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,"http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2601208602-3BF1FC8F5A41DC987090FD69ED83EF05/0?term=2",true);
	}
	if(data.Message_Content.equals("西行青龙"))
	{
		String retText = "✤西行青龙✤\n价格:390000\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText, "http://gchat.qpic.cn/gchatpic_new/184757891/582544273-3163220689-66EE0EFC9CE35E8D31854F946B0C6D56/0?term=2",true);
	}
	if(data.Message_Content.equals("星宿雯心"))
	{
		String retText = "✤星宿雯心✤\n价格:370000金币\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,"http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2385646959-AD61A7150F9FEA142D0BDB079D4FF9F7/0?term=2",true);
	}
	if(data.Message_Content.equals("漾芯惧意"))
	{
		String retText = "✤漾芯惧意✤\n价格:300000金币\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,"http://gchat.qpic.cn/gchatpic_new/184757891/582544273-3081680069-E1CAA5F2360CF697E82F6A6239634F6D/0?term=2",true);
	}
	if(data.Message_Content.equals("幽魂鬼猫"))
	{
		String retText = "✤幽魂鬼猫✤\n价格:270000金币\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,"http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2200856169-888E44D5435664A476D7BA241AAF23DC/0?term=2",true);
	}
	if(data.Message_Content.equals("战幽之马"))
	{
		String retText = "✤战幽之马✤\n价格:330000金币\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,"http://gchat.qpic.cn/gchatpic_new/184757891/582544273-2575039283-BD2ECB72D2E72C8C7E7A317CFE5C36CF/0?term=2",true);
	}
	if(data.Message_Content.equals("金羽凤凰"))
	{
		String retText = "✤金羽凤凰✤\n价格:350000金币\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,"http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2570688377-C477AD7B55281A327B1300A30AB0C876/0?term=2",true);
	}
	if(data.Message_Content.equals("金鹏狮鹫"))
	{
		String retText = "✤金鹏狮鹫✤\n价格:300000金币\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,"http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2244621537-34E8640C379C5EE63C0B3EF2D9B5FE5A/0?term=2",true);
		}
		
		if(data.Message_Content.equals("闲云游鹤"))
	{
		String retText = "✤闲云游鹤✤\n七夕双人浪漫座椅\n价格:400000金币\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,"http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2822472241-1CEFCCD892601E8691EE6E0D4A59E0C7/0?term=2",true);
		}
		if(data.Message_Content.equals("幽冥灵猫"))
	{
		String retText = "✤幽冥灵猫✤\n价格:350000金币\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,"http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2699327632-4E4AF5817B15C62784AC0D46671A3600/0?term=2",true);
	}
	
	if(data.Message_Content.equals("赤焰穷奇"))
	{
		String retText = "✤赤焰穷奇✤\n价格:500000金币\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,"http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2862929304-CE3EBB27AB5B1A20B1F6EB71E8F10866/0?term=2",true);
	}
	
	if(data.Message_Content.equals("深海幻境"))
	{
		String retText = "✤深海幻境✤\n价格:450000金币\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,"http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2362900967-1A0653AD1DC2EC21940D0C54083F9CD9/0?term=2",true);
	}
		if(data.Message_Content.equals("幽冥白虎"))
	{
		String retText = "✤幽冥白虎✤\n价格:400000金币\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,"http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2978247251-8330183FAB6B9D0284B575B1EE0EDA9F/0?term=2",true);
	}
	if(data.Message_Content.equals("天空领主"))
	{
		String retText = "✤天空领主✤\n价格:300000金币\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,"http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2559027175-16B6BD4A031277D1DBC23D7EA59B38B1/0?term=2",true);
	}
	
	if(data.Message_Content.equals("瑞祥麒麟"))
	{
		String retText = "✤瑞祥麒麟✤\n价格:500000金币\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,"http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2258659865-42A5B428F17CD995163E3D8B11E718E8/0?term=2",true);
	}
	
	if(data.Message_Content.equals("邪眸白虎"))
	{
		String retText = "✤邪眸白虎✤\n价格:500000金币\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,"http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2623514582-25C103B3E6E8B26A6E8837C4C6AAD64E/0?term=2",true);
	}
	if(data.Message_Content.equals("七彩神鹿"))
	{
		String retText = "✤七彩神鹿✤\n价格:350000金币\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,"http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2818860434-5AE1CE7729974783A4DE7E01CDF7A69E/0?term=2",true);
	}
	
	if(data.Message_Content.equals("荷漾清莲"))
	{
		String retText = "✤荷漾清莲✤\n价格:400000金币\n用途:1.系统出场携带坐骑\n2.出场时获得金币\n3.降低被打劫成功的几率\n4.增加杀人系统的攻击力和防御力";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,"http://gchat.qpic.cn/gchatpic_new/2292380798/618817983-2230414764-570E2AF61E4A4AD7E4ADDB6D9390D723/0?term=2",true);
	}
	if(data.Message_Content.equals("购买坐骑北冥白羽"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "北冥白羽") == 1)
		{
			retText = retText + "你已经拥有坐骑北冥白羽了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 400000)
		{
			retText = retText + "你的金币不够哦\n你需要400000金币购买坐骑\n你目前只有" + item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "北冥白羽", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 400000);
			retText = retText + "恭喜你购买坐骑北冥白羽成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用坐骑北冥白羽 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.equals("购买坐骑彩衣花轿"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "彩衣花轿") == 1)
		{
			retText = retText + "你已经拥有坐骑彩衣花轿了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 150000)
		{
			retText = retText + "你的金币不够哦\n你需要150000金币购买彩衣花轿\n你目前只有" + item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "彩衣花轿", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 150000);
			retText = retText + "恭喜你购买坐骑彩衣花轿成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用坐骑彩衣花轿 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.equals("购买坐骑鲲西之莲"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "鲲西之莲") == 1)
		{
			retText = retText + "你已经拥有坐骑鲲西之莲了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 300000)
		{
			retText = retText + "你的金币不够哦\n你需300000金币购买鲲西之莲\n你目前只有" + item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "鲲西之莲", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 300000);
			retText = retText + "恭喜你购买坐骑鲲西之莲成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用坐骑鲲西之莲 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.equals("购买坐骑南方冥龙"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "南方冥龙") == 1)
		{
			retText = retText + "你已经拥有坐骑南方冥龙了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 450000)
		{
			retText = retText + "你的金币不够哦\n你需450000金币购买南方冥龙\n你目前只有" + item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "南方冥龙", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 450000);
			retText = retText + "恭喜你购买坐骑南方冥龙成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用坐骑南方冥龙 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.equals("购买坐骑破天飞剑"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "破天飞剑") == 1)
		{
			retText = retText + "你已经拥有坐骑破天飞剑了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 350000)
		{
			retText = retText + "你的金币不够哦\n你需350000金币购买破天飞剑\n你目前只有" + item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "破天飞剑", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 350000);
			retText = retText + "恭喜你购买坐骑破天飞剑成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用坐骑破天飞剑 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.equals("购买坐骑破天轮回"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "破天轮回") == 1)
		{
			retText = retText + "你已经拥有坐骑破天轮回了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 250000)
		{
			retText = retText + "你的金币不够哦\n你需250000金币购买破天轮回\n你目前只有" + item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "破天轮回", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 250000);
			retText = retText + "恭喜你购买坐骑破天轮回成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用坐骑破天轮回 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.equals("购买坐骑神鹿金角"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "神鹿金角") == 1)
		{
			retText = retText + "你已经拥有坐骑神鹿金角了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 280000)
		{
			retText = retText + "你的金币不够哦\n你需280000金币购买神鹿金角\n你目前只有" + item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "神鹿金角", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 280000);
			retText = retText + "恭喜你购买坐骑神鹿金角成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用坐骑神鹿金角 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.equals("购买坐骑西行青龙"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "西行青龙") == 1)
		{
			retText = retText + "你已经拥有坐骑西行青龙了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 390000)
		{
			retText = retText + "你的金币不够哦\n你需390000金币购买西行青龙\n你目前只有" + item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "西行青龙", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 390000);
			retText = retText + "恭喜你购买坐骑西行青龙成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用坐骑西行青龙 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.equals("购买坐骑星宿雯心"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "星宿雯心") == 1)
		{
			retText = retText + "你已经拥有坐骑星宿雯心了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 370000)
		{
			retText = retText + "你的金币不够哦\n你需370000金币购买星宿雯心\n你目前只有" + item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "星宿雯心", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 370000);
			retText = retText + "恭喜你购买坐骑星宿雯心成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用坐骑星宿雯心 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.equals("购买坐骑漾芯惧意"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "漾芯惧意") == 1)
		{
			retText = retText + "你已经拥有坐骑漾芯惧意了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 300000)
		{
			retText = retText + "你的金币不够哦\n你需300000金币购买漾芯惧意\n你目前只有" + item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "漾芯惧意", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 300000);
			retText = retText + "恭喜你购买坐骑漾芯惧意成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用坐骑漾芯惧意 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.equals("购买坐骑幽魂鬼猫"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "幽魂鬼猫") == 1)
		{
			retText = retText + "你已经拥有坐骑幽魂鬼猫了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 270000)
		{
			retText = retText + "你的金币不够哦\n你需270000金币购买幽魂鬼猫\n你目前只有" + item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "幽魂鬼猫", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 270000);
			retText = retText + "恭喜你购买坐骑幽魂鬼猫成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用坐骑幽魂鬼猫 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.equals("购买坐骑战幽之马"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "战幽之马") == 1)
		{
			retText = retText + "你已经拥有坐骑战幽之马了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 330000)
		{
			retText = retText + "你的金币不够哦\n你需330000金币购买战幽之马\n你目前只有" + item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "战幽之马", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 330000);
			retText = retText + "恭喜你购买坐骑战幽之马成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用坐骑战幽之马 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.equals("购买坐骑幽冥白虎"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "幽冥白虎") == 1)
		{
			retText = retText + "你已经拥有坐骑幽冥白虎了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 400000)
		{
			retText = retText + "你的金币不够哦\n你需要400000金币购买幽冥白虎\n你目前只有" + item.GetItemDataInt(data.friendUin,  "GameDic", data.sendUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "幽冥白虎", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 400000);
			retText = retText + "恭喜你购买坐骑幽冥白虎成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用幽冥白虎 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	
	if(data.Message_Content.equals("购买坐骑金羽凤凰"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "金羽凤凰") == 1)
		{
			retText = retText + "你已经拥有坐骑金羽凤凰了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 350000)
		{
			retText = retText + "你的金币不够哦\n你需要350000金币购买坐骑\n你目前只有" + item.GetItemDataInt(data.friendUin,  "GameDic", data.sendUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "金羽凤凰", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 350000);
			retText = retText + "恭喜你购买坐骑金羽凤凰成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用坐骑金羽凤凰 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	
	if(data.Message_Content.equals("购买坐骑金鹏狮鹫"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "金鹏狮鹫") == 1)
		{
			retText = retText + "你已经拥有坐骑金鹏狮鹫了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 350000)
		{
			retText = retText + "你的金币不够哦\n你需350000金币购买金鹏狮鹫\n你目前只有" + item.GetItemDataInt(data.friendUin,  "GameDic", data.sendUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "金鹏狮鹫", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 350000);
			retText = retText + "恭喜你购买坐骑金鹏狮鹫成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用坐骑金鹏狮鹫 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	
	if(data.Message_Content.equals("购买坐骑闲云游鹤"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "闲云游鹤") == 1)
		{
			retText = retText + "你已经拥有坐骑闲云游鹤了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 400000)
		{
			retText = retText + "你的金币不够哦\n你需350000金币购买闲云游鹤\n你目前只有" + item.GetItemDataInt(data.friendUin,  "GameDic", data.sendUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "闲云游鹤", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 400000);
			retText = retText + "恭喜你购买坐骑闲云游鹤成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用坐骑闲云游鹤 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	
	if(data.Message_Content.equals("购买坐骑幽冥灵猫"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "幽冥灵猫") == 1)
		{
			retText = retText + "你已经拥有坐骑幽冥灵猫了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 350000)
		{
			retText = retText + "你的金币不够哦\n你需350000金币购买幽冥灵猫\n你目前只有" + item.GetItemDataInt(data.friendUin,  "GameDic", data.sendUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "幽冥灵猫", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 350000);
			retText = retText + "恭喜你购买坐骑幽冥灵猫成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用坐骑幽冥灵猫 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	
	if(data.Message_Content.equals("购买坐骑赤焰穷奇"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "赤焰穷奇") == 1)
		{
			retText = retText + "你已经拥有坐骑赤焰穷奇了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 500000)
		{
			retText = retText + "你的金币不够哦\n你需350000金币购买赤焰穷奇\n你目前只有" + item.GetItemDataInt(data.friendUin,  "GameDic", data.sendUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "赤焰穷奇", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 500000);
			retText = retText + "恭喜你购买坐骑赤焰穷奇成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用坐骑赤焰穷奇 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	
	if(data.Message_Content.equals("购买坐骑深海幻境"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "深海幻境") == 1)
		{
			retText = retText + "你已经拥有坐骑深海幻境了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 450000)
		{
			retText = retText + "你的金币不够哦\n你需350000金币购买深海幻境\n你目前只有" + item.GetItemDataInt(data.friendUin,  "GameDic", data.sendUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "深海幻境", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 450000);
			retText = retText + "恭喜你购买坐骑深海幻境成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用坐骑深海幻境 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.equals("购买坐骑天空领主"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "天空领主") == 1)
		{
			retText = retText + "你已经拥有坐骑天空领主了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 300000)
		{
			retText = retText + "你的金币不够哦\n你需350000金币购买天空领主\n你目前只有" + item.GetItemDataInt(data.friendUin,  "GameDic", data.sendUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "天空领主", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 300000);
			retText = retText + "恭喜你购买坐骑天空领主成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用坐骑天空领主 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	
	if(data.Message_Content.equals("购买坐骑瑞祥麒麟"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "瑞祥麒麟") == 1)
		{
			retText = retText + "你已经拥有坐骑瑞祥麒麟了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 500000)
		{
			retText = retText + "你的金币不够哦\n你需350000金币购买瑞祥麒麟\n你目前只有" + item.GetItemDataInt(data.friendUin,  "GameDic", data.sendUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "瑞祥麒麟", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 500000);
			retText = retText + "恭喜你购买坐骑瑞祥麒麟成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用坐骑瑞祥麒麟 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.equals("购买坐骑邪眸白虎"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "邪眸白虎") == 1)
		{
			retText = retText + "你已经拥有坐骑邪眸白虎了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 500000)
		{
			retText = retText + "你的金币不够哦\n你需350000金币购买邪眸白虎\n你目前只有" + item.GetItemDataInt(data.friendUin,  "GameDic", data.sendUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "邪眸白虎", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 500000);
			retText = retText + "恭喜你购买坐骑邪眸白虎成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用坐骑邪眸白虎 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	
	if(data.Message_Content.equals("购买坐骑七彩神鹿"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "七彩神鹿") == 1)
		{
			retText = retText + "你已经拥有坐骑七彩神鹿了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 350000)
		{
			retText = retText + "你的金币不够哦\n你需350000金币购买七彩神鹿\n你目前只有" + item.GetItemDataInt(data.friendUin,  "GameDic", data.sendUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "七彩神鹿", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 350000);
			retText = retText + "恭喜你购买坐骑七彩神鹿成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用坐骑七彩神鹿 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	if(data.Message_Content.equals("购买坐骑荷漾清莲"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "荷漾清莲") == 1)
		{
			retText = retText + "你已经拥有坐骑荷漾清莲了,不能再购买了";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		if(item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") < 400000)
		{
			retText = retText + "你的金币不够哦\n你需350000金币购买荷漾清莲\n你目前只有" + item.GetItemDataInt(data.friendUin,  "GameDic", data.sendUin, "金币") + "金币";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		else
		{
			item.SetItemData(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "荷漾清莲", 1);
			item.SetItemData(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币", item.GetItemDataInt(data.Message_GroupUin,  "GameDic", data.Message_UserUin, "金币") - 400000);
			retText = retText + "恭喜你购买坐骑荷漾清莲成功\n你可以发送 查看我的坐骑 来查看拥有的坐骑\n发送 使用坐骑荷漾清莲 来使用坐骑";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
	}
	
	if(data.Message_Content.equals("使用坐骑北冥白羽"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "北冥白羽") == 0)
		{
			retText = retText + "你还没有坐骑北冥白羽哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 1);
		retText = retText + "成功使用坐骑 北冥白羽\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("使用坐骑彩衣花轿"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "彩衣花轿") == 0)
		{
			retText = retText + "你还没有坐骑彩衣花轿哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 2);
		retText = retText + "成功使用坐骑 彩衣花轿\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("使用坐骑鲲西之莲"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "鲲西之莲") == 0)
		{
			retText = retText + "你还没有坐骑鲲西之莲哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 3);
		retText = retText + "成功使用坐骑 鲲西之莲\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("使用坐骑南方冥龙"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "南方冥龙") == 0)
		{
			retText = retText + "你还没有坐骑南方冥龙哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 4);
		retText = retText + "成功使用坐骑 南方冥龙\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("使用坐骑破天飞剑"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "破天飞剑") == 0)
		{
			retText = retText + "你还没有坐骑破天飞剑哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 5);
		retText = retText + "成功使用坐骑 破天飞剑\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("使用坐骑破天轮回"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "破天轮回") == 0)
		{
			retText = retText + "你还没有坐骑破天轮回哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 6);
		retText = retText + "成功使用坐骑 破天轮回\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("使用坐骑神鹿金角"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "神鹿金角") == 0)
		{
			retText = retText + "你还没有坐骑神鹿金角哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 7);
		retText = retText + "成功使用坐骑 神鹿金角\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("使用坐骑西行青龙"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "西行青龙") == 0)
		{
			retText = retText + "你还没有坐骑西行青龙哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 8);
		retText = retText + "成功使用坐骑 西行青龙\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("使用坐骑星宿雯心"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "星宿雯心") == 0)
		{
			retText = retText + "你还没有坐骑星宿雯心哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 9);
		retText = retText + "成功使用坐骑 星宿雯心\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("使用坐骑漾芯惧意"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "漾芯惧意") == 0)
		{
			retText = retText + "你还没有坐骑漾芯惧意哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 10);
		retText = retText + "成功使用坐骑 漾芯惧意\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("使用坐骑幽魂鬼猫"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "幽魂鬼猫") == 0)
		{
			retText = retText + "你还没有坐骑幽魂鬼猫哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 11);
		retText = retText + "成功使用坐骑 幽魂鬼猫\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("使用坐骑战幽之马"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "战幽之马") == 0)
		{
			retText = retText + "你还没有坐骑战幽之马哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 12);
		retText = retText + "成功使用坐骑 战幽之马\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
		if(data.Message_Content.equals("使用坐骑幽冥白虎"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "幽冥白虎") == 0)
		{
			retText = retText + "你还没有坐骑幽冥白虎哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 13);
		retText = retText + "成功使用坐骑 幽冥白虎\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	
	if(data.Message_Content.equals("使用坐骑金羽凤凰"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "金羽凤凰") == 0)
		{
			retText = retText + "你还没有坐骑金羽凤凰哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 14);
		retText = retText + "成功使用坐骑 金羽凤凰\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	
	if(data.Message_Content.equals("使用坐骑金鹏狮鹫"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "金鹏狮鹫") == 0)
		{
			retText = retText + "你还没有坐骑金鹏狮鹫哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 15);
		retText = retText + "成功使用坐骑 金鹏狮鹫\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("使用坐骑闲云游鹤"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "闲云游鹤") == 0)
		{
			retText = retText + "你还没有坐骑闲云游鹤哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 16);
		retText = retText + "成功使用坐骑 闲云游鹤\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	
	if(data.Message_Content.equals("使用坐骑幽冥灵猫"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "幽冥灵猫") == 0)
		{
			retText = retText + "你还没有坐骑幽冥灵猫哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 17);
		retText = retText + "成功使用坐骑 幽冥灵猫\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	
	if(data.Message_Content.equals("使用坐骑赤焰穷奇"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "赤焰穷奇") == 0)
		{
			retText = retText + "你还没有坐骑赤焰穷奇哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 18);
		retText = retText + "成功使用坐骑 赤焰穷奇\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	
		if(data.Message_Content.equals("使用坐骑深海幻境"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "深海幻境") == 0)
		{
			retText = retText + "你还没有坐骑深海幻境哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 19);
		retText = retText + "成功使用坐骑 深海幻境\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("使用坐骑天空领主"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "天空领主") == 0)
		{
			retText = retText + "你还没有坐骑天空领主哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 20);
		retText = retText + "成功使用坐骑 天空领主\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("使用坐骑瑞祥麒麟"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "瑞祥麒麟") == 0)
		{
			retText = retText + "你还没有坐骑瑞祥麒麟哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 21);
		retText = retText + "成功使用坐骑 瑞祥麒麟\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("使用坐骑邪眸白虎"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "邪眸白虎") == 0)
		{
			retText = retText + "你还没有坐骑邪眸白虎哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 22);
		retText = retText + "成功使用坐骑 邪眸白虎\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	
	if(data.Message_Content.equals("使用坐骑七彩神鹿"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "七彩神鹿") == 0)
		{
			retText = retText + "你还没有坐骑七彩神鹿哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 23);
		retText = retText + "成功使用坐骑 七彩神鹿\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	
	if(data.Message_Content.equals("使用坐骑荷漾清莲"))
	{
		String retText = "@" + data.nickName + "\n";
		if(item.GetItemDataInt(data.Message_GroupUin, data.Message_UserUin, "坐骑列表", "荷漾清莲") == 0)
		{
			retText = retText + "你还没有坐骑荷漾清莲哦,发送 出场坐骑商店 来购买吧";
			MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
			return false;
		}
		item.SetItemData(data.Message_GroupUin, "GameDic", data.Message_UserUin, "当前坐骑", 24);
		retText = retText + "成功使用坐骑 荷漾清莲\n你可以发送 出场 来查看";
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	if(data.Message_Content.equals("查看我的坐骑"))
	{
		String retText = "@" + data.nickName + "\n你当前拥有的坐骑如下:\n";
		String[] MList = item.MakeListForItem(data.Message_GroupUin, data.Message_UserUin, "坐骑列表");
		for(String name: MList)
		{
			retText = retText + name + "\n";
		}
		MyMsg.FixAndSendMsg(data.Message_GroupUin,retText,DefInfo.CardDefImages,false);
		return false;
	}
	return false;
}
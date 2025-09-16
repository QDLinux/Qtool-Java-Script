HashMap BanMap = new HashMap();
HashMap KickMap = new HashMap();
boolean DontSafe = false;
public class MMMM
{
	String UserUin;
	long time;
	long StartTime;
	long piaoshu;
	long yitou;
	ArrayList TouPiaoList = new ArrayList();
}
public boolean Module_整人系统(Object msg)
{
	if(!MySwitch.CheckSwitch(msg.Message_GroupUin, "整人系统")) return false;
	if(!IsGroupAdmin(msg.Message_GroupUin,msg.Message_UserUin) && MySwitch.CheckSwitch(msg.Message_GroupUin,"菜单限制")) return false;
	String 域名 = item.GetItemData(X("ÉÂ"), "域名", "地址", "1");
	if(item.GetItemDataInt(msg.Message_GroupUin, msg.Message_UserUin, "recall", "isRecall") == 1)
	{
		revokeMsg(msg.msg);
	}

	if(item.GetItemDataInt(msg.Message_GroupUin, msg.Message_UserUin, "resend", "isResend") == 1)
	{
		double sDouble = Double.parseDouble(item.GetItemData(msg.Message_GroupUin, msg.Message_UserUin, "resend", "sendTa"));
		if(Math.random() < sDouble)
		{
			if(msg.Message_Type == 0)
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " " + msg.Message_Content.replaceAll("^\\s", ""));
			}
			if(msg.Message_Type == 1)
			{
				MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, msg.Message_Content);
			}
			if(msg.Message_Type == 2)
			{
				MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, msg.Message_Content);
			}
		}
	}
	if(msg.Message_Content.equals("我投一票"))
	{
		if(BanMap.containsKey(msg.Message_GroupUin))
		{
			MMMM aa = BanMap.get(msg.Message_GroupUin);
			if(aa.StartTime + 1000 * 300 > System.currentTimeMillis())
			{
				if(aa.TouPiaoList.contains(msg.Message_UserUin))
				{
					MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + "你已经投过票了");
					return false;
				}
				aa.yitou++;
				if(aa.yitou >= aa.piaoshu)
				{
					MyMsgApi.Group_Forbidden(msg.Message_GroupUin, aa.UserUin, aa.time);
					MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "投票结束," + NameLog.getName(msg.Message_GroupUin, aa.UserUin) + ")" + aa.UserUin + ")已被禁言" + secondToTime(aa.time));
					BanMap.remove(msg.Message_GroupUin);
					return false;
				}
				String text = "投票完成\n当前投票禁言对象:" + NameLog.getName(msg.Message_GroupUin, aa.UserUin) + "(" + aa.UserUin + ")";
				text = text + "\n禁言时间:" + secondToTime(aa.time);
				text = text + "\n当前票数:" + aa.yitou;
				text = text + "\n需要票数:" + aa.piaoshu;
				aa.TouPiaoList.add(msg.Message_UserUin);
				BanMap.put(msg.Message_GroupUin, aa);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
			}
		}
		if(KickMap.containsKey(msg.Message_GroupUin))
		{
			MMMM aa = KickMap.get(msg.Message_GroupUin);
			if(aa.StartTime + 1000 * 300 > System.currentTimeMillis())
			{
				if(aa.TouPiaoList.contains(msg.Message_UserUin))
				{
					MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + "你已经投过票了");
					return false;
				}
				aa.yitou++;
				if(aa.yitou >= aa.piaoshu)
				{
					MyMsgApi.Group_Kick(msg.Message_GroupUin, aa.UserUin,false);
					MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "投票结束," + NameLog.getName(msg.Message_GroupUin, aa.UserUin) + ")" + aa.UserUin + ")已被踢出");
					KickMap.remove(msg.Message_GroupUin);
					return false;
				}
				String text = "投票完成\n当前投票踢出对象:" + NameLog.getName(msg.Message_GroupUin, aa.UserUin) + "(" + aa.UserUin + ")";
				text = text + "\n当前票数:" + aa.yitou;
				text = text + "\n需要票数:" + aa.piaoshu;
				aa.TouPiaoList.add(msg.Message_UserUin);
				KickMap.put(msg.Message_GroupUin, aa);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
			}
		}
	}
	if(!msg.Message_UserUin.equals(mQQ)) return false;
	if(msg.Message_Content.startsWith("开启撤回@"))
	{
		for(String AUin: msg.atList)
		{
			item.SetItemData(msg.Message_GroupUin, AUin, "recall", "isRecall", 1);
			item.SetItemData(msg.Message_GroupUin, AUin, "recall", "isRecall", 1);
		}
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已开启");
	}

	if(msg.Message_Content.startsWith("关闭撤回@"))
	{
		for(String AUin: msg.atList)
		{
			item.SetItemData(msg.Message_GroupUin, AUin, "recall", "isRecall", 0);
			item.SetItemData(msg.Message_GroupUin, AUin, "recall", "isRecall", 0);
		}
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已关闭");
	}
	if(msg.Message_Content.startsWith("自动复读@"))
	{
		try
		{
			int index = msg.Message_Content.lastIndexOf(" ");
			double sDouble = Double.parseDouble(msg.Message_Content.substring(index + 1));
			if(sDouble <= 0 || sDouble > 1)
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "概率范围为(0,1]");
				return false;
			}
			for(String AUin: msg.atList)
			{
				item.SetItemData(msg.Message_GroupUin, AUin, "resend", "isResend", 1);
				item.SetItemData(msg.Message_GroupUin, AUin, "resend", "sendTa", "" + sDouble);
			}
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已开启自动复读");
		}
		catch(r)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "指令 自动复读@xx 概率");
		}
	}
	if(msg.Message_Content.startsWith("关闭自动复读@"))
	{
		for(String AUin: msg.atList)
		{
			item.SetItemData(msg.Message_GroupUin, AUin, "resend", "isResend", 0);
		}
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已关闭");
	}
	if(msg.Message_Content.equals("停止投票"))
	{
		BanMap.remove(msg.Message_GroupUin);
		KickMap.remove(msg.Message_GroupUin);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "所有投票已停止");
		return false;
	}
	if(msg.Message_Content.startsWith("投票禁言@"))
	{
		if(BanMap.containsKey(msg.Message_GroupUin))
		{
			MMMM bb = BanMap.get(msg.Message_GroupUin);
			if(bb.StartTime + 1000 * 300 > System.currentTimeMillis())
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "上一轮投票未结束");
				return false;
			}
		}
		int index = msg.Message_Content.lastIndexOf(" ");
		String[] sl = msg.Message_Content.substring(index + 1).split("\\|");
		try
		{
			MMMM bb = new MMMM();
			for(String str: msg.atList)
			{
				bb.UserUin = str;
			}
			bb.time = FormTimeToSecond(sl[0]);
			bb.piaoshu = Long.parseLong(sl[1]);
			bb.StartTime = System.currentTimeMillis();
			BanMap.put(msg.Message_GroupUin, bb);
			String text = "本群将要投票禁言" + bb.UserUin + " " + secondToTime(bb.time) + ",请投票的人5分钟之内发送 我投一票 来进行投票,主人发送 停止投票 可以停止本次投票";
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
		}
		catch(Throwable e)
		{
			Toast(e + "");
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "格式不正确? 投票禁言@xx 时间|票数");
		}
	}
	if(msg.Message_Content.startsWith("投票踢出@"))
	{
		if(KickMap.containsKey(msg.Message_GroupUin))
		{
			MMMM bb = KickMap.get(msg.Message_GroupUin);
			if(bb.StartTime + 1000 * 300 > System.currentTimeMillis())
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "上一轮投票未结束");
				return false;
			}
		}
		int index = msg.Message_Content.lastIndexOf(" ");
		String sl = msg.Message_Content.substring(index + 1);
		try
		{
			MMMM bb = new MMMM();
			for(String str: msg.atList)
			{
				bb.UserUin = str;
			}
			bb.piaoshu = Long.parseLong(sl);
			bb.StartTime = System.currentTimeMillis();
			KickMap.put(msg.Message_GroupUin, bb);
			String text = "本群将要投票踢出" + bb.UserUin + ",请投票的人5分钟之内发送 我投一票 来进行投票,主人发送 停止投票 可以停止本次投票";
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
		}
		catch(Throwable e)
		{
			Toast(e + "");
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "格式不正确? 投票踢出@xx 票数");
		}
	}
	return false;
}

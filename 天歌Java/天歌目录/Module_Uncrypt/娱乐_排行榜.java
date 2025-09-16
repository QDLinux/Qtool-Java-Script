

public class Mylist
{
	String Uin;
	long cMark;
	long a1;
	long a2;
}
public boolean G_排行(Object data)
{
	if(data.Message_Content.equals("金币排行榜"))
	{
		ArrayList MMList = new ArrayList();
		List fs = Arrays.asList(new File(RootPath + "data/" + data.Message_GroupUin + "/GameDic/").listFiles());
		for(File ff: fs)
		{
			if(!ff.isFile()) continue;
			String UinN = ff.getName();
			String MUin = UinN.split("\\.")[0];
			long Mark = item.GetItemDataInt(data.Message_GroupUin, "GameDic", MUin, "金币");
			if(Mark == 0) continue;
			Mylist MCodeList = new Mylist();
			MCodeList.Uin = MUin;
			MCodeList.cMark = Mark;
			MMList.add(MCodeList);
		}
		MMList = MySort(MMList);
		String retText = "---金币排行榜---";
		if(MMList.size() < 10)
		{
			for(int i = 0; i < MMList.size(); i++)
			{
				Mylist MCodeList = MMList.get(i);
				retText = retText + "\nQQ:" +NameLog.getName(data.Message_GroupUin,MCodeList.Uin)+"("+ MCodeList.Uin+")";
				retText = retText + "\n金币数:" + MCodeList.cMark + "\n";
			}
		}
		else
		{
			for(int i = 0; i < 10; i++)
			{
				Mylist MCodeList = MMList.get(i);
				retText = retText + "\nQQ:" + NameLog.getName(data.Message_GroupUin,MCodeList.Uin)+"("+ MCodeList.Uin+")";
				retText = retText + "\n金币数:" + MCodeList.cMark + "\n";
			}
		}
		MyMsgApi.Message_Send_Group(data.Message_GroupUin, retText);
	}
	if(data.Message_Content.equals("经验排行榜"))
	{
		ArrayList MMList = new ArrayList();
		List fs = Arrays.asList(new File(RootPath + "data/" + data.Message_GroupUin + "/GameDic/").listFiles());
		for(File ff: fs)
		{
			if(!ff.isFile()) continue;
			String UinN = ff.getName();
			String MUin = UinN.split("\\.")[0];
			long Mark = item.GetItemDataInt(data.Message_GroupUin, "GameDic", MUin, "经验");
			if(Mark == 0) continue;
			Mylist MCodeList = new Mylist();
			MCodeList.Uin = MUin;
			MCodeList.cMark = Mark;
			MMList.add(MCodeList);
		}
		MMList = MySort(MMList);
		String retText = "---经验排行榜---";
		if(MMList.size() < 10)
		{
			for(int i = 0; i < MMList.size(); i++)
			{
				Mylist MCodeList = MMList.get(i);
				retText = retText + "\nQQ:" + NameLog.getName(data.Message_GroupUin,MCodeList.Uin)+"("+ MCodeList.Uin+")";
				retText = retText + "\n经验数:" + MCodeList.cMark + "\n";
			}
		}
			else
			{
				for(int i = 0; i < 10; i++)
				{
					Mylist MCodeList = MMList.get(i);
					retText = retText + "\nQQ:" + NameLog.getName(data.Message_GroupUin,MCodeList.Uin)+"("+ MCodeList.Uin+")";
					retText = retText + "\n经验数:" + MCodeList.cMark + "\n";
				}
			}
		
		MyMsgApi.Message_Send_Group(data.Message_GroupUin, retText);
	}
	if(data.Message_Content.equals("签到排行榜"))
	{
		ArrayList MMList = new ArrayList();
		List fs = Arrays.asList(new File(RootPath + "data/" + data.Message_GroupUin + "/GameDic/").listFiles());
		for(File ff: fs)
		{
			if(!ff.isFile()) continue;
			String UinN = ff.getName();
			String MUin = UinN.split("\\.")[0];
			long Mark = item.GetItemDataInt(data.Message_GroupUin, "GameDic", MUin, "签到总天数");
			if(Mark == 0) continue;
			Mylist MCodeList = new Mylist();
			MCodeList.Uin = MUin;
			MCodeList.cMark = Mark;
			MMList.add(MCodeList);
		}
		MMList = MySort(MMList);
		String retText = "---签到排行榜---";
		if(MMList.size() < 10)
		{
			for(int i = 0; i < MMList.size(); i++)
			{
				Mylist MCodeList = MMList.get(i);
				retText = retText + "\nQQ:" + NameLog.getName(data.Message_GroupUin,MCodeList.Uin)+"("+ MCodeList.Uin+")";
				retText = retText + "\n签到天数:" + MCodeList.cMark + "\n";
			}
		}
			else
			{
				for(int i = 0; i < 10; i++)
				{
					Mylist MCodeList = MMList.get(i);
					retText = retText + "\nQQ:" + NameLog.getName(data.Message_GroupUin,MCodeList.Uin)+"("+ MCodeList.Uin+")";
					retText = retText + "\n签到天数:" + MCodeList.cMark + "\n";
				}
			}
		
		MyMsgApi.Message_Send_Group(data.Message_GroupUin, retText);
	}
	if(data.Message_Content.equals("被炸排行"))
	{
		ArrayList MMList = new ArrayList();
		List fs = Arrays.asList(new File(RootPath + "data/" + data.Message_GroupUin + "/GameDic/").listFiles());
		for(File ff: fs)
		{
			if(!ff.isFile()) continue;
			String UinN = ff.getName();
			String MUin = UinN.split("\\.")[0];
			long Mark = item.GetItemDataInt(data.Message_GroupUin, "GameDic", MUin, "被炸次数");
			if(Mark == 0) continue;
			Mylist MCodeList = new Mylist();
			MCodeList.Uin = MUin;
			MCodeList.cMark = Mark;
			MMList.add(MCodeList);
		}
		MMList = MySort(MMList);
		String retText = "---被炸排行榜---";
		if(MMList.size() < 10)
		{
			for(int i = 0; i < MMList.size(); i++)
			{
				Mylist MCodeList = MMList.get(i);
				retText = retText + "\nQQ:" + NameLog.getName(data.Message_GroupUin,MCodeList.Uin)+"("+ MCodeList.Uin+")";
				retText = retText + "\n被炸次数:" + MCodeList.cMark + "\n";
			}
		}
			else
			{
				for(int i = 0; i < 10; i++)
				{
					Mylist MCodeList = MMList.get(i);
					retText = retText + "\nQQ:" + NameLog.getName(data.Message_GroupUin,MCodeList.Uin)+"("+ MCodeList.Uin+")";
					retText = retText + "\n被炸次数:" + MCodeList.cMark + "\n";
				}
			}
		
		MyMsgApi.Message_Send_Group(data.Message_GroupUin, retText);
	}
	if(data.Message_Content.equals("被砸排行"))
	{
		ArrayList MMList = new ArrayList();
		List fs = Arrays.asList(new File(RootPath + "data/" + data.Message_GroupUin + "/GameDic/").listFiles());
		for(File ff: fs)
		{
			if(!ff.isFile()) continue;
			String UinN = ff.getName();
			String MUin = UinN.split("\\.")[0];
			long Mark = item.GetItemDataInt(data.Message_GroupUin, "GameDic", MUin, "被砸次数");
			if(Mark == 0) continue;
			Mylist MCodeList = new Mylist();
			MCodeList.Uin = MUin;
			MCodeList.cMark = Mark;
			MMList.add(MCodeList);
		}
		MMList = MySort(MMList);
		String retText = "---被砸排行榜---";
		if(MMList.size() < 10)
		{
			for(int i = 0; i < MMList.size(); i++)
			{
				Mylist MCodeList = MMList.get(i);
				retText = retText + "\nQQ:" + NameLog.getName(data.Message_GroupUin,MCodeList.Uin)+"("+ MCodeList.Uin+")";
				retText = retText + "\n被砸次数:" + MCodeList.cMark + "\n";
			}
		}
			else
			{
				for(int i = 0; i < 10; i++)
				{
					Mylist MCodeList = MMList.get(i);
					retText = retText + "\nQQ:" + NameLog.getName(data.Message_GroupUin,MCodeList.Uin)+"("+ MCodeList.Uin+")";
					retText = retText + "\n被砸次数:" + MCodeList.cMark + "\n";
				}
			}
		
		MyMsgApi.Message_Send_Group(data.Message_GroupUin, retText);
	}
		if(data.Message_Content.equals("猜数字排行"))
	{
		ArrayList MMList = new ArrayList();
		List fs = Arrays.asList(new File(RootPath + "data/" + data.Message_GroupUin + "/GameDic/").listFiles());
		for(File ff: fs)
		{
			if(!ff.isFile()) continue;
			String UinN = ff.getName();
			String MUin = UinN.split("\\.")[0];
			long Mark = item.GetItemDataInt(data.Message_GroupUin, "GameDic", MUin, "数字猜出次数");
			if(Mark == 0) continue;
			Mylist MCodeList = new Mylist();
			MCodeList.Uin = MUin;
			MCodeList.cMark = Mark;
			MMList.add(MCodeList);
		}
		MMList = MySort(MMList);
		String retText = "---数字猜出榜---";
		if(MMList.size() < 10)
		{
			for(int i = 0; i < MMList.size(); i++)
			{
				Mylist MCodeList = MMList.get(i);
				retText = retText + "\nQQ:" + NameLog.getName(data.Message_GroupUin,MCodeList.Uin)+"("+ MCodeList.Uin+")";
				retText = retText + "\n猜出次数:" + MCodeList.cMark + "\n";
			}
		}
			else
			{
				for(int i = 0; i < 10; i++)
				{
					Mylist MCodeList = MMList.get(i);
					retText = retText + "\nQQ:" + NameLog.getName(data.Message_GroupUin,MCodeList.Uin)+"("+ MCodeList.Uin+")";
					retText = retText + "\n猜出次数:" + MCodeList.cMark + "\n";
				}
			}
		
		MyMsgApi.Message_Send_Group(data.Message_GroupUin, retText);
	}
		if(data.Message_Content.equals("接龙排行榜"))
	{
		ArrayList MMList = new ArrayList();
		List fs = Arrays.asList(new File(RootPath + "data/" + data.Message_GroupUin + "/GameDic/").listFiles());
		for(File ff: fs)
		{
			if(!ff.isFile()) continue;
			String UinN = ff.getName();
			String MUin = UinN.split("\\.")[0];
			long Mark = item.GetItemDataInt(data.Message_GroupUin, "GameDic", MUin, "接龙成功次数");
			if(Mark == 0) continue;
			Mylist MCodeList = new Mylist();
			MCodeList.Uin = MUin;
			MCodeList.cMark = Mark;
			MMList.add(MCodeList);
		}
		MMList = MySort(MMList);
		String retText = "---接龙获胜榜---";
		if(MMList.size() < 10)
		{
			for(int i = 0; i < MMList.size(); i++)
			{
				Mylist MCodeList = MMList.get(i);
				retText = retText + "\nQQ:" + NameLog.getName(data.Message_GroupUin,MCodeList.Uin)+"("+ MCodeList.Uin+")";
				retText = retText + "\n获胜次数:" + MCodeList.cMark + "\n";
			}
		}
			else
			{
				for(int i = 0; i < 10; i++)
				{
					Mylist MCodeList = MMList.get(i);
					retText = retText + "\nQQ:" +NameLog.getName(data.Message_GroupUin,MCodeList.Uin)+"("+ MCodeList.Uin+")";
					retText = retText + "\n获胜次数:" + MCodeList.cMark + "\n";
				}
			}
		
		MyMsgApi.Message_Send_Group(data.Message_GroupUin, retText);
	}
	if(data.Message_Content.equals("打劫排行"))
	{
		ArrayList MMList = new ArrayList();
		List fs = Arrays.asList(new File(RootPath + "data/" + data.Message_GroupUin + "/GameDic/").listFiles());
		for(File ff: fs)
		{
			if(!ff.isFile()) continue;
			String UinN = ff.getName();
			String MUin = UinN.split("\\.")[0];
			long a1 = item.GetItemDataInt(data.Message_GroupUin, "GameDic", MUin, "打劫成功次数");
			long a2 = item.GetItemDataInt(data.Message_GroupUin, "GameDic", MUin, "打劫失败次数");
			long Mark = a1+a2;
			if(Mark == 0) continue;
			Mylist MCodeList = new Mylist();
			MCodeList.Uin = MUin;
			MCodeList.cMark = Mark;
			MCodeList.a1 = a1;
			MCodeList.a2 = a2;
			MMList.add(MCodeList);
		}
		MMList = MySort(MMList);
		String retText = "---打劫排行榜---";
		if(MMList.size() < 10)
		{
			for(int i = 0; i < MMList.size(); i++)
			{
				Mylist MCodeList = MMList.get(i);
				retText = retText + "\nQQ:" + NameLog.getName(data.Message_GroupUin,MCodeList.Uin)+"("+ MCodeList.Uin+")";
				retText = retText + "\n打劫次数:" + MCodeList.cMark +"(成功:"+MCodeList.a1+" 失败:"+MCodeList.a2+ ")\n";
			}
		}
			else
			{
				for(int i = 0; i < 10; i++)
				{
					Mylist MCodeList = MMList.get(i);
					retText = retText + "\nQQ:" + NameLog.getName(data.Message_GroupUin,MCodeList.Uin)+"("+ MCodeList.Uin+")";
					retText = retText + "\n打劫次数:" + MCodeList.cMark +"(成功:"+MCodeList.a1+" 失败:"+MCodeList.a2+ ")\n";
				}
			}
		
		MyMsgApi.Message_Send_Group(data.Message_GroupUin, retText);
	}
	return false;
}
public ArrayList MySort(ArrayList obj)
{
	for(int i = 0; i < obj.size(); i++)
	{
		for(int i2 = 0; i2 < obj.size() - 1; i2++)
		{
			Mylist MCodeList = null;
			if(obj.get(i2).cMark < obj.get(i2 + 1).cMark)
			{
				MCodeList = obj.get(i2);
				obj.set(i2, obj.get(i2 + 1));
				obj.set(i2 + 1, MCodeList);
			}
		}
	}
	return obj;
}
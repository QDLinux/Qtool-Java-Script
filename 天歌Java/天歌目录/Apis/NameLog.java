public static class NameLog
{
	static HashMap NameMap = new HashMap();
	public static String getName(String GroupUin,String UserUin)
	{
		LoadNameFromFile(GroupUin);
		if(NameMap.containsKey(GroupUin))
		{
			HashMap GroupMap = NameMap.get(GroupUin);
			if(GroupMap.containsKey(UserUin))
			{
				return GroupMap.get(UserUin);
			}
			else
			{
				String Name = http.get(ServiceRoot+"jx/qqnick?qq="+UserUin);
				if(Name.contains("调用失败"))
				{
					return UserUin;
				}
				setName(GroupUin,UserUin,Name);
				return Name;
			}
		}
		else
		{
			return UserUin;
		}
	}
	
	public static void setName(String GroupUin,String UserUin,String Name)
	{
		LoadNameFromFile(GroupUin);
		if(NameMap.containsKey(GroupUin))
		{
			HashMap GroupMap = NameMap.get(GroupUin);
			if(!Name.equals(GroupMap.get(UserUin)))
			{
				GroupMap.put(UserUin,Name);
				NameMap.put(GroupUin,GroupMap);
				SaveNameToFile(GroupUin);
			}
			
			
		}
		else
		{
		}
	}
	public static void SaveNameToFile(String GroupUin)
	{
		HashMap GroupMap = NameMap.get(GroupUin);
		MyFile.CreateDir(RootPath+"data/"+GroupUin);
		MyFile.WriteObjectToFile(RootPath+"data/"+GroupUin+"/name.dat",GroupMap);
	}
	public static void LoadNameFromFile(String GroupUin)
	{
		if(!NameMap.containsKey(GroupUin))
		{
			HashMap GroupMap = MyFile.ReadObjectFromFile(RootPath+"data/"+GroupUin+"/name.dat");
			NameMap.put(GroupUin,GroupMap);
		}
	}
}
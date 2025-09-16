HashMap Switch = new HashMap();
public class SwitchCheck
{
 public boolean CheckSwitch(String GroupUin,String SwitchName)
 {
  if(Switch.containsKey(GroupUin))
  {
   HashMap map = Switch.get(GroupUin);
   return (map.get(SwitchName) ==1);
  }
  else
  {
   LoadSettingsFromFile(GroupUin);
   HashMap map = Switch.get(GroupUin);
            return (map.get(SwitchName) ==1);
  }
  
 }
 public void ChangeSwitch(String GroupUin,String SwitchName,boolean status)
 {
  
  if(Switch.containsKey(GroupUin))
  {
   HashMap map = Switch.get(GroupUin);
   map.put(SwitchName,status ? 1 : 0);
   Switch.put(GroupUin,map);
  }
  else
  {
   LoadSettingsFromFile(GroupUin);
   HashMap map = Switch.get(GroupUin);
   map.put(SwitchName,status ? 1 : 0);
   Switch.put(GroupUin,map);
  }
  SaveSwitchDataToFile(GroupUin);
 }
 public void LoadSettingsFromFile(String GroupUin)
 {
  if(item.GetItemDataInt(GroupUin,"Flags","init","inited")==1)
  {
   HashMap map = MyFile.ReadObjectFromFile(RootPath+"data/"+GroupUin+"/开关数据.dat");
      Switch.put(GroupUin,map);
  }
  else
  {
  HashMap map = new HashMap();
   map.put("菜单",1);
   map.put("菜单限制",1);
   map.put("音乐系统",1);
   map.put("词条系统",1);
   map.put("接口系统",1);
   map.put("群管系统",1);
   map.put("图片系统",1);
   map.put("娱乐系统",1);
   map.put("查询系统",1);
   map.put("艾特处理",1);
   map.put("整人系统",1);
   map.put("攻防系统",1);
   map.put("视频系统",1);
   map.put("群员自助",1);
   map.put("红包",1);
   map.put("站长工具",1);
   map.put("休闲系统",1);
   map.put("卡片系统",1);

   Switch.put(GroupUin,map);
   SaveSwitchDataToFile(GroupUin);
   item.SetItemData(GroupUin,"Flags","init","inited",1);
  }
  
 }
 public void SaveSwitchDataToFile(String GroupUin)
 {
  if(Switch.containsKey(GroupUin))
  {
   MyFile.CreateDir(RootPath+"data/"+GroupUin);
   MyFile.WriteObjectToFile(RootPath+"data/"+GroupUin+"/开关数据.dat",Switch.get(GroupUin));
  }
 }
}
SwitchCheck MySwitch = new SwitchCheck();
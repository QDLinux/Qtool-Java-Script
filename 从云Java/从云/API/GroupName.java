HashMap GroupMap = new HashMap();
public String getGroupName(String qun)
{
if(GroupMap.containsKey(qun)) return GroupMap.get(qun);
else{
for(Object group:getGroupList())
	{
    GroupMap.put(group.GroupUin,group.GroupName);
	}
if(GroupMap.containsKey(qun)) return GroupMap.get(qun);
else return "群名获取失败";
}
}
public int number(String Uin)
{
int ui=0;
for(Object wx:getGroupMemberList(Uin))
{
ui++;
}
return ui;
}
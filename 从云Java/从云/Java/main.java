List 脚a本 = new ArrayList();
File file00 = new File(AppPath+"/从云/Java/下载的脚本/main.txt");
for(String str:读取(file00))
{
if("1".equals(取("从云",str)))
{
脚a本.add(str);
}
}
if(脚a本.toArray().length>0) {
for(int i = 0;i<脚a本.size();i++)
{
File file0 = new File(AppPath+"/从云/Java/下载的脚本/"+脚a本.get(i));
if(file0.exists()){
load(AppPath+"/从云/Java/下载的脚本/"+脚a本.get(i));
}else{
ts("提示","请不要删除\n["+AppPath+"/从云/Java/下载的脚本/"+脚a本.get(i)+"]文件\n不然脚本将报错，无法正常使用，请下回来，如果要删除的话到(功能下载->下载的脚本->删除)。");
}
}
}
public void first(Object data)
{
开关(data);
抽奖(data);
投票禁言(data);
私聊解禁(data);
数字炸弹(data);
扫码(data);
艾特(data);
群管(data);
QQ点歌(data);
if("1".equals(取("从云","娱乐Java")))
{
娱乐Java(data);
}
if("1".equals(取("从云","报时Java")))
{
报时(data);
}
if("1".equals(取("从云","窥屏Java")))
{
窥屏(data);
}
if("1".equals(取("从云","五子棋Java")))
{
五子棋(data);
}
if("1".equals(取("从云","昵称检测Java")))
{
昵称(data);
}
if("1".equals(取("从云","续火Java")))
{
续火(data);
}
}
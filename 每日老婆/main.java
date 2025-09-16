String 路径=AppPath+"/配置/";
load(路径+"import.java");
load(路径+"http.java");
load(路径+"item.java");
load(路径+"yun.java");
AddItem("开始每日老婆","k",PluginID);
AddItem("关闭每日老婆","g",PluginID);
public void k(String qun,String qq,int type) {
putString(qun,"总开关","1");
Toast(qun+"已开启每日老婆");
}
public void g(String qun,String qq,int type) {
putString(qun,"总开关","0");
Toast(qun+"已关闭每日老婆");
}
public void onMsg(Object data)
{
String qq=data.UserUin;
String qun=data.GroupUin;
String mc=data.MessageContent;
String name=data.SenderNickName;
long time2=new Date().getTime()/1000;
long 今天 = (time2+28800)/86400;
String 今="时间"+今天;
String at="[AtQQ="+qq+"]\n";
if("1".equals(getString(qun,"总开关"))) {

if(读(qun,今,"昨日","是否删除")==0)
{
删除(qun,"白");
删除(qun,"时间"+(今天-1));
写(qun,今,"昨日","是否删除",1);
}

if(qq.equals(MyUin))
{
if(mc.startsWith("查白名单"))
{
int a=检查(""+文字(qun,"白",qq,"白名单"),mc.substring(4));
发(qun,""+a);
}
if(mc.startsWith("设置换老婆次数"))
{
String a=mc.substring(7);
long b=Long.parseLong(a);
写(qun,"常驻数据","每日总次数","次数",b);
}
if(mc.equals("切换本群搜索")){
写(qun,"模式","模式","模式",0);
发(qun,"ok，切换成功");
}
if(mc.equals("切换所有群搜索")){
写(qun,"模式","模式","模式",1);
发(qun,"ok，切换成功");
}
if(mc.equals("切换发送模式")){
if(读(qun,"模式","模式","发送模式")==1)
{
写(qun,"模式","模式","发送模式",0);
发(qun,"ok，发送发送切换至a模式");
}else{
写(qun,"模式","模式","发送模式",1);
发(qun,"ok，发送发送切换至b模式");
}

}
if(mc.equals("删除今日数据"))
{
删除(qun,""+今);
发(qun,"好的，已经删除今天的所有数据了");
}
}
if(mc.equals("今日老婆"))
{
new java.lang.Thread(new Runnable(){
public void run(){
if(读(qun,今,qq,"老婆")==1)
{
发(qun,"你今天换了太多老婆，别人也非常嫌弃你，不想当你老婆");
return;
}
if(读(qun,今,qq,"次数")==0){
删除(qun,"白");
if(读(qun,"模式","模式","发送模式")==0)
{
int 模式=读(qun,"模式","模式","模式");
String a=调用(qun,qq,模式);
JSONObject json=new JSONObject(a);
String q=json.get("qq");
String name=json.get("name");
发(qun,at+"你今天的老婆是[PicUrl=http://q1.qlogo.cn/g?b=qq&nk="+q+"&s=640]QQ:"+q+"\nat:[AtQQ="+q+"]\n名称:"+name);
写(qun,"白",qq,"白名单",文字(qun,"白",qq,"白名单")+"-"+q);
写(qun,今,qq,"json",a);
}else{
调用a(data,"首");
}
写(qun,今,qq,"次数",1);
}else{
String a=文字(qun,今,qq,"json");
JSONObject json=new JSONObject(a);
String q=json.get("qq");
String name=json.get("name");
发(qun,at+"你已经选过老婆了\n今天的老婆是[PicUrl=http://q1.qlogo.cn/g?b=qq&nk="+q+"&s=640]QQ:"+q+"\n名称:"+name);
}
}}).start();}

if(mc.equals("换老婆"))
{
new java.lang.Thread(new Runnable(){
			public void run(){
if(读(qun,今,qq,"次数")==0){
发(qun,at+"你还没有领老婆呢，怎么换老婆\n试试说:今日老婆");
return;
}
int cs=读(qun,"常驻数据","每日总次数","次数");
if(cs==0){
写(qun,"常驻数据","每日总次数","次数",5);
cs=5;}
if(读(qun,今,qq,"次数")>cs){
发(qun,at+"今天你换了太多了，这个老婆看你太渣也和别人跑了");
清除(qun,今,qq,"json");
写(qun,今,qq,"老婆",1);
return;
}
if(读(qun,今,qq,"次数")==cs){
发(qun,at+"今天你换了太多了，不给你换了,再换你老婆可能就要和别人跑了");
写(qun,今,qq,"次数",读(qun,今,qq,"次数")+1);
return;
}
写(qun,今,qq,"次数",读(qun,今,qq,"次数")+1);
if(读(qun,"模式","模式","发送模式")==0)
{
int 模式=读(qun,"模式","模式","模式");
String a=调用(qun,qq,模式);
JSONObject json=new JSONObject(a);
String q=json.get("qq");
String name=json.get("name");
发(qun,at+"已经换喽\n现在你的老婆是[PicUrl=http://q1.qlogo.cn/g?b=qq&nk="+q+"&s=640]QQ:"+q+"\nat:[AtQQ="+q+"]\n名称:"+name);
写(qun,今,qq,"json",a);
写(qun,"白",qq,"白名单",文字(qun,"白",qq,"白名单")+"-"+q);
}else{
调用a(data,"换");
}
}}).start();}






}}
public void 违禁检测(Object data){
String quntext=data.MessageContent;
String qun=data.GroupUin;
String uin=data.UserUin;
String qq=MyUin;
//消息类型,1:图片或文字消息,2:卡片消息,3:图文消息,4:语音消息,5:文件消息,6:回复消息

if(data.MessageType==1&&quntext.contains("[PicUrl=")&&!data.IsSend){
if("1".equals(getString(data.GroupUin,"撤回图片"))){
String[] 本群白名单=列表(qun,"白名单");
String[] 全局白名单=列表("0","白名单");
if(data.UserUin.equals(MyUin)||Arrays.asList(本群白名单).contains(data.UserUin)||Arrays.asList(全局白名单).contains(data.UserUin)){
}else{
revokeMsg(data);
String menu=uin+"被撤回了一条消息，原因:开启了撤回图片";
群聊发送(data,menu);
}
}
}

if(data.MessageType==2&&!data.IsSend){
if("1".equals(getString(data.GroupUin,"撤回卡片"))){
String[] 本群白名单=列表(qun,"白名单");
String[] 全局白名单=列表("0","白名单");
if(data.UserUin.equals(MyUin)||Arrays.asList(本群白名单).contains(data.UserUin)||Arrays.asList(全局白名单).contains(data.UserUin)){
}else{
revokeMsg(data);
String menu=uin+"被撤回了一条消息，原因:开启了撤回卡片";
群聊发送(data,menu);
}
}
}

if(data.MessageType==4&&!data.IsSend){
if("1".equals(getString(data.GroupUin,"撤回语音"))){
String[] 本群白名单=列表(qun,"白名单");
String[] 全局白名单=列表("0","白名单");
if(data.UserUin.equals(MyUin)||Arrays.asList(本群白名单).contains(data.UserUin)||Arrays.asList(全局白名单).contains(data.UserUin)){
}else{
revokeMsg(data);
String menu=uin+"被撤回了一条消息，原因:开启了撤回语音";
群聊发送(data,menu);
}
}
}

if(data.MessageType==1&&!data.IsSend){
if("1".equals(getString(data.GroupUin,"撤回链接"))){
String[] 本群白名单=列表(qun,"白名单");
String[] 全局白名单=列表("0","白名单");
if(data.UserUin.equals(MyUin)||Arrays.asList(本群白名单).contains(data.UserUin)||Arrays.asList(全局白名单).contains(data.UserUin)){
}else{
String[] 链接={".top",".cn",".com",".online",".vin",".ski",".gay","http://","https://",".cc",".xyz",".icu","info","love","cloud","store","net",".tech",".shop",".vip","site",".art",".fun",".website",".kim",".tv",".club",".pro",".plus",".team"};
for(String u:链接){
if(quntext.contains(u)){
revokeMsg(data);
String menu=uin+"被撤回了一条消息，原因:开启了撤回链接";
群聊发送(data,menu);
}
}
}
}
}

if("1".equals(getString(data.GroupUin,"weijin"))){
cb =quntext.replace("⁡","");
cd =cb.replace("'","");
cf =cb.replace(" ","");
cg =cf.replace(".","");
ch =cg.replace("•","");
op =ch.replace(",","");
String[] 本群白名单=列表(qun,"白名单");
String[] 全局白名单=列表("0","白名单");
if(data.UserUin.equals(MyUin)||Arrays.asList(本群白名单).contains(data.UserUin)||Arrays.asList(全局白名单).contains(data.UserUin)){
}else{
String[] 违禁词列表=列表(qun,"违禁词列表");
for(String u:违禁词列表){
if(op.contains(u)){
群聊发送(data,"QQ"+data.UserUin+"\n触发违禁词，已撤回并禁言");
revokeMsg(data);
Forbidden(data.GroupUin,data.UserUin,jy);
}
}
}
}

if(data.MessageContent.startsWith("添加违禁词")&&data.IsSend){
String one=quntext.substring(5);
if(读(qun,"违禁词列表",one)==1){
群聊发送(data,"已添加过该违禁词～");
}else{
写(qun,"违禁词列表",one,1);
群聊发送(data,"写入违禁词成功～");
}
}

if(data.MessageContent.startsWith("查看违禁词")&&data.IsSend){
String one=quntext.substring(5);
if(读(qun,"违禁词列表",one)==1){
群聊发送(qun,"","已有该违禁词～");
}
}

if(quntext.startsWith("删除违禁词")&&data.IsSend)
{
String text=quntext.substring(5);
if(读(qun,"违禁词列表",text)!=1)
{
群聊发送(data,"该违禁词不在本群违禁词列表中哦～");
return;
}
清除(qun,"违禁词",text);
群聊发送(data,"已删除该违禁词～");
}

if(quntext.equals("违禁词列表")&&data.IsSend){
String[] List=列表(qun,"违禁词列表");
String x="本群违禁词列表有:";
String a=x;
long i=0;
for(String s:List){
i++;
x=x+"\n"+i+"."+s;
}
if(x.equals(a)) x="目前还没有违禁词哦～";
群聊发送(data,x);
}

if(quntext.equals("清空违禁词")&&data.IsSend){
删除(qun,"违禁词列表");
群聊发送(data,"已清空本群违禁词列表～");
}

if(data.MessageContent.startsWith("本群拉白@")&&data.IsSend){
String at=data.AtList[0];
if(读(qun,"白名单",at)==1){
群聊发送(data,"已添加过该QQ为白名单～");
}else{
写(qun,"白名单",at,1);
群聊发送(data,"写入白名单成功～");
}
}
if(data.MessageContent.startsWith("本群删白@")&&data.IsSend){
String at=data.AtList[0];
if(读(qun,"白名单",at)!=1){
群聊发送(data,"该QQ并非本群白名单～");
}else{
清除(qun,"白名单",at);
群聊发送(data,"删除白名单成功～");
}
}


if(data.MessageContent.startsWith("全局拉白@")&&data.IsSend){
String at=data.AtList[0];
if(读("0","白名单",at)==1){
群聊发送(data,"已添加过该QQ为白名单～");
}else{
写("0","白名单",at,1);
群聊发送(data,"写入白名单成功～");
}
}
if(data.MessageContent.startsWith("全局删白@")&&data.IsSend){
String at=data.AtList[0];
if(读("0","白名单",at)!=1){
群聊发送(data,"该QQ并非本群白名单～");
}else{
清除("0","白名单",at);
群聊发送(data,"删除白名单成功～");
}
}


if(quntext.equals("清空本群白名")&&data.IsSend){
删除(qun,"白名单");
群聊发送(data,"已清空本群白名单列表～");
}

if(quntext.equals("清空全局白名")&&data.IsSend){
删除("0","白名单");
群聊发送(data,"已清空全局白名单列表～");
}

}
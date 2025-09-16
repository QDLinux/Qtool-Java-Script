public void 代管功能(Object data){
String quntext=data.MessageContent;
String qun=data.GroupUin;
String uin=data.UserUin;
String qq=MyUin;

if(data.MessageContent.startsWith("添加全局代管@")&&data.IsSend){
String at=data.AtList[0];
if(at.equals(qq)){
群聊发送(data,"请不要添加自己为代管！");
}else{
if(读("0","代管",at)==1){
群聊发送(data,"已添加过该QQ为全局代管～");
}else{
写("0","代管",at,1);
群聊发送(data,"写入全局代管成功～");
}
}
}
if(data.MessageContent.startsWith("删除全局代管@")&&data.IsSend){
String at=data.AtList[0];
if(读("0","代管",at)!=1){
群聊发送(data,"该QQ并非全局白名单～");
}else{
清除("0","代管",at);
群聊发送(data,"删除全局代管成功～");
}
}

if(quntext.equals("清空全局代管")&&data.IsSend){
删除("0","代管");
群聊发送(data,"已清空全局代管列表～");
}

if(data.MessageContent.startsWith("添加本群代管@")&&data.IsSend){
if(at.equals(qq)){
群聊发送(data,"请不要添加自己为代管！");
}else{
String at=data.AtList[0];
if(读(qun,"代管",at)==1){
群聊发送(data,"已添加过该QQ为本群代管～");
}else{
写(qun,"代管",at,1);
群聊发送(data,"写入本群代管成功～");
}
}
}
if(data.MessageContent.startsWith("删除本群代管@")&&data.IsSend){
String at=data.AtList[0];
if(读(qun,"代管",at)!=1){
群聊发送(data,"该QQ并非本群白名单～");
}else{
清除(qun,"代管",at);
群聊发送(data,"删除本群代管成功～");
}
}

if(quntext.equals("清空本群代管")&&data.IsSend){
删除(qun,"代管");
群聊发送(data,"已清空本群代管列表～");
}
if(quntext.equals("本群代管列表")&&data.IsSend){
String[] List=列表(qun,"代管");
String x="本群代管列表有:";
String a=x;
long i=0;
for(String s:List){
i++;
x=x+"\n"+i+"."+s;
}
if(x.equals(a)) x="目前还没有本群代管哦～";
群聊发送(data,x);
}

if(quntext.equals("全局代管列表")&&data.IsSend){
String[] List=列表("0","代管");
String x="全局代管列表有:";
String a=x;
long i=0;
for(String s:List){
i++;
x=x+"\n"+i+"."+s;
}
if(x.equals(a)) x="目前还没有全局代管哦～";
群聊发送(data,x);
}

if(读(qun,"代管",uin)==1||读("0","代管",uin)==1){

if(quntext.equals("解密菜单")){
sendMsg(qun,"",菜单头+"\nbase加密+内容\nbase解密+内容\nu加密+内容\nu解密+内容\n\n凯撒加#内容#密码\n凯撒解#内容#密码\n"+菜单尾);
}
if(quntext.startsWith("base解密")){
String jm=jm(quntext.substring(6));
sendMsg(qun,"",jm);
}
if(quntext.startsWith("base加密")){
String jm=jam(quntext.substring(6));
sendMsg(qun,"",jm);
}
if(quntext.startsWith("u解密")){
String jm=u解(quntext.substring(3));
sendMsg(qun,"",jm);
}
if(quntext.startsWith("u加密")){
String jm=u加(quntext.substring(3));
sendMsg(qun,"",jm);
}
if(data.MessageContent.startsWith("凯撒加#")){
String one=quntext.split("#")[1];
String two=quntext.split("#")[2];
String jm=encryptKaiser(one,two,0);
sendMsg(qun,"",jm);
}

if(data.MessageContent.startsWith("凯撒解#")){
String one=quntext.split("#")[1];
String two=quntext.split("#")[2];
String jm=encryptKaiser(one,two,1);
sendMsg(qun,"",jm);
}
if(quntext.startsWith("Y解密")){
String jm=Y(quntext.substring(3));
sendMsg(qun,"",jm);
}
if(quntext.startsWith("X解密")){
String jm=X(quntext.substring(3));
sendMsg(qun,"",jm);
}

if("开启查询系统".equals(quntext)){
putString(qun,"查询系统","1");
String menu="开启查询系统成功";
群聊发送(data,menu);
}


if("关闭查询系统".equals(quntext)){
putString(qun,"查询系统",null);
String menu="关闭查询系统成功";
群聊发送(data,menu);
}


if("开启刷听歌".equals(quntext)){
putString(qun,"刷听歌","1");
String menu="开启刷听歌成功";
群聊发送(data,menu);
}


if("关闭刷听歌".equals(quntext)){
putString(qun,"刷听歌",null);
String menu="关闭刷听歌成功";
群聊发送(data,menu);
}

if("开启天气系统".equals(quntext)){
putString(qun,"天气系统","1");
String menu="开启天气系统成功";
群聊发送(data,menu);
}


if("关闭天气系统".equals(quntext)){
putString(qun,"天气系统",null);
String menu="关闭天气系统成功";
群聊发送(data,menu);
}

if("开启福利功能".equals(quntext)){
putString(qun,"福利功能","1");
String menu="开启福利功能成功";
群聊发送(data,menu);
}


if("关闭福利功能".equals(quntext)){
putString(qun,"福利功能",null);
String menu="关闭福利功能成功";
群聊发送(data,menu);
}

if(data.MessageContent.startsWith("下载#")){
String one=quntext.split("#")[1];
String two=quntext.split("#")[2];
String jb=User(3);
String file=RootPath+"下载/"+jb+"."+one;
String xz=DownloadToFile(two,file);
if(xz.equals("成功")){
群聊发送(data,"文件下载成功！请到"+file+"查看");
return;
}
}

if("福利功能".equals(quntext)){
if("1".equals(getString(data.GroupUin,"福利功能"))){
String menu=菜单头+"\n『漏点涩图』『随机涩图』\n『瑟瑟视频』『pixiv』\n『真人涩图』\n『r18』『pixiv2』\n『瑟瑟视频2』\n"+菜单尾;
群聊发送(data,menu);
}else{
群聊发送(data,"本群『福利功能』未开启，请联系主人"+qq+"，发送『开启福利功能』");
}
}

if(data.MessageContent.equals("开机")||data.MessageContent.equals("复活")){
String menu="当前已经是开启状态了";
群聊发送(data,menu);
}

if("运行状态".equals(quntext)){
运行状态(data);
}


if("开启图片外显".equals(quntext)){
putString(qq,"图片外显","1");
String menu="开启图片外显成功";
群聊发送(data,menu);
}


if("关闭图片外显".equals(quntext)){
putString(qq,"图片外显",null);
String menu="开启图片外显成功";
群聊发送(data,menu);
}

if("开启撤回自身".equals(quntext)){
putString(qq,"撤回自身","1");
String menu="开启撤回自身成功";
群聊发送(data,menu);
}

if("关闭撤回自身".equals(quntext)){
putString(qq,"撤回自身",null);
String menu="关闭撤回自身成功";
群聊发送(data,menu);
}

if("开启撤回链接".equals(quntext)){
putString(qun,"撤回链接","1");
String menu="开启撤回链接成功";
群聊发送(data,menu);
}

if("关闭撤回链接".equals(quntext)){
putString(qun,"撤回链接",null);
String menu="关闭撤回链接成功";
群聊发送(data,menu);
}

if("开启撤回图片".equals(quntext)){
putString(qun,"撤回图片","1");
String menu="开启撤回图片成功";
群聊发送(data,menu);
}

if("关闭撤回图片".equals(quntext)){
putString(qun,"撤回图片",null);
String menu="关闭撤回图片成功";
群聊发送(data,menu);
}

if("开启撤回卡片".equals(quntext)){
putString(qun,"撤回卡片","1");
String menu="开启撤回卡片成功";
群聊发送(data,menu);
}

if("关闭撤回卡片".equals(quntext)){
putString(qun,"撤回卡片",null);
String menu="关闭撤回卡片成功";
群聊发送(data,menu);
}

if("开启撤回语音".equals(quntext)){
putString(qun,"撤回语音","1");
String menu="开启撤回语音成功";
群聊发送(data,menu);
}

if("关闭撤回语音".equals(quntext)){
putString(qun,"撤回语音",null);
String menu="关闭撤回语音成功";
群聊发送(data,menu);
}

if(data.MessageContent.equals("切换图片模式")){
putString(qun,"菜单模式","图片");
String menu="群"+qun+"\n已切换为图片模式";
群聊发送(data,menu);
}

if(data.MessageContent.equals("切换Tips模式")){
putString(qun,"菜单模式","Tips");
String menu="群"+qun+"\n已切换为Tips模式";
群聊发送(data,menu);
}

if(data.MessageContent.equals("切换卡片2模式")){
putString(qun,"菜单模式","卡片2");
String menu="群"+qun+"\n已切换为卡片2模式";
群聊发送(data,menu);
}

if("卡片功能".equals(quntext)){
String menu=菜单头+"\n『签名卡片+代码』\n『卡片签名+代码』\nTips:接口1已提交vip的pskey\n接口2提交qzone的pskey\n"+菜单尾;
群聊发送(data,menu);
}

if(data.MessageContent.equals("更新日志")){
String menu="2023-8-8 17:46已更新\n1. 修复『点歌』\n2. 修复表情制作\n3.修复图片菜单\n4. 修复了bug";
群聊发送(data,menu);
}

if(data.MessageContent.equals("清屏功能")){
String menu=菜单头+"\n『一键清屏』『定海神针』\n『轰炸清屏』『花样清屏』\n"+菜单尾;
群聊发送(data,menu);
}

if(data.MessageContent.equals("定海神针")){
sendMsg(qun,"","定\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n海\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n神\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n针\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n定\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n海\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n神\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n针");
}

if(data.MessageContent.equals("轰炸清屏")){
sendMsg(qun,"","OO═══∩═══OO 　　　　╭╬╮　　　　　　　　　 ◢ -▁╭▅▇□□█▇▆▅▄▃▂▁(╳)█╮ 　 ╰═▃_专机来访▁∠════▔▔▔　 　 ╙O ╙O ...... ........OO═══∩═══OO╭╬╮　　　　　　　　　 ◢-▁╭▅▇□□█▇▆▅▄▃▂▁(╳)█╮╰═▃_专机来访▁∠════▔▔▔╙O ╙O......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过.轰炸过.轰炸过.轰炸过..轰炸过....轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过..轰炸过....轰炸过.....轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过.轰炸过.轰炸过.轰炸过..轰炸过...轰炸过....轰炸过.....轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过....轰炸过......轰炸过.......轰炸过........轰炸过.........轰炸过.........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过.轰炸过.轰炸过.轰炸过..轰炸过...轰炸过....轰炸过.....轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过.轰炸过.轰炸过.轰炸过..轰炸过...轰炸过....轰炸过.....轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过.轰炸过.轰炸过.轰炸过..轰炸过...轰炸过....轰炸过.....轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过OO═══∩═══OO╭╬╮　　　　　　　　　 ◢-▁╭▅▇□□█▇▆▅▄▃▂▁(╳)█╮╰═▃_专机来访▁∠════▔▔▔╙O ╙O......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过.轰炸过.轰炸过.轰炸过..轰炸过...轰炸过....轰炸过.....轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过.轰炸过.轰炸过.轰炸过..轰炸过...轰炸过....轰炸过.....轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过.轰炸过.轰炸过.轰炸过..轰炸过...轰炸过....轰炸过.....轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过.轰炸过.轰炸过.轰炸过..轰炸过...轰炸过....轰炸过.....轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过..轰炸过....轰炸过.....轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过.轰炸过.轰炸过.轰炸过..轰炸过...轰炸过....轰炸过.....轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过....轰炸过......轰炸过.......轰炸过........轰炸过.........轰炸过.........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过.....轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过展开!");
}

if(data.MessageContent.equals("花样清屏")){
sendMsg(qun,"","┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈\n花样清屏结束～");
}

if(data.MessageContent.equals("一键清屏")){
sendMsg(qun,"","清\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n屏");
sendMsg(qun,"","清\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n屏");
sendMsg(qun,"","清\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n屏");
}

if(data.MessageContent.equals("切换转发模式")){
putString(qun,"菜单模式","转发");
String menu="群"+qun+"\n已切换为转发模式";
群聊发送(data,menu);
}

if(data.MessageContent.equals("切换卡片点歌")){
putString(qun,"音乐模式","卡片");
String menu="群"+qun+"\n已切换为卡片点歌";
群聊发送(data,menu);
}

if(data.MessageContent.equals("切换语音点歌")){
putString(qun,"音乐模式","语音");
String menu="群"+qun+"\n已切换为语音点歌";
群聊发送(data,menu);
}

if(data.MessageContent.equals("加群")){
sendMsg(qun,"","点击链接加入群聊【冷雨·温晴】：http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=WebjaWMx9p-aw2fiILYL_YKoL-z7JFEE&authKey=s0SXzULW825SwjQJUYxigVsVv3rWq7K33UABiE0OzSRWRVSFxR3j%2BFCrSJQn0TRQ&noverify=0&group_code=464695369");
}

if(data.MessageContent.equals("切换卡片模式")){
putString(qun,"菜单模式","卡片");
String menu="群"+qun+"\n已切换为卡片模式";
群聊发送(data,menu);
}

if(data.MessageContent.equals("切换文字模式")){
putString(qun,"菜单模式","文字");
String menu="群"+qun+"\n已切换为文字模式";
群聊发送(data,menu);
}

if(data.MessageContent.equals("切换管家模式")){
putString(qun,"菜单模式","管家");
String menu="群"+qun+"\n已切换为管家模式";
群聊发送(data,menu);
}

if("管家设置".equals(quntext)){
String menu=菜单头+"\n『管家发送XXX』\n『添加问答XXX』\n『删除问答XXX』\n『开/关撤回群链接』\n『开/关撤回二维码』\n『开/关口令红包』\n『邀请管家』『移除管家』\n『艾特管家+内容』\n其他功能请到QTool悬浮窗查看\n"+菜单尾;
群聊发送(data,menu);
}

if(quntext.equals("邀请管家")){
String pskey=getPskey("qun.qq.com");
String menu=邀请移除管家(qun,qq,skey,pskey,1);
String menu="邀请管家"+xxx;
群聊发送(data,menu);
}

if(quntext.equals("移除管家")){
String pskey=getPskey("qun.qq.com");
String menu=邀请移除管家(qun,qq,skey,pskey,0);
String menu="移除管家"+xxx;
群聊发送(data,menu);
}

if(quntext.startsWith("艾特管家")){
sendMsg(qun,"","[AtQQ=2854196310]"+quntext.substring(4));
}

if(data.MessageContent.startsWith("管家发送")){
String text=quntext.substring(4);
String pskey=getPskey("qun.qq.com");
String xxx=管家发送(qun,qq,skey,pskey,User(3),text.replaceAll("\\r\\n|\\n|\\r", "\\\\n"));
}

if(data.MessageContent.startsWith("添加问答")){
String text=quntext.substring(4);
String pskey=getPskey("qun.qq.com");
String xxx=添加问答(qun,qq,skey,pskey,User(3),text.replaceAll("\\r\\n|\\n|\\r", "\\\\n"));
String menu=xxx;
群聊发送(data,menu);
}

if(data.MessageContent.startsWith("删除问答")){
String text=quntext.substring(4);
String pskey=getPskey("qun.qq.com");
String xxx=删除问答(qun,qq,skey,pskey,text);
String menu=xxx;
群聊发送(data,menu);
}

if("群管功能".equals(quntext)){
String menu=菜单头+"\n踢+QQ/@  解禁+QQ/@\n禁言+QQ/@+时间(分钟)\n全体禁言/解禁\n上头衔+QQ/@ 内容\n改名+QQ/@ 内容\n"+菜单尾;
群聊发送(data,menu);
}


if(data.MessageContent.startsWith("踢@")){
String at=data.AtList[0];
Kick(qun,at,false);
String menu="踢出成功！\n被踢者:"+at;
群聊发送(data,menu);
}

if(data.MessageContent.startsWith("踢黑@")){
String at=data.AtList[0];
Kick(qun,at,true);
String menu="踢出并拉黑成功！\n被踢者:"+at;
群聊发送(data,menu);
}

if(data.MessageContent.matches("踢[0-9]+")){
String nb=quntext.substring(1);
Kick(qun,nb,false);
String menu="踢出成功！\n被踢者:"+nb;
群聊发送(data,menu);
}

if(data.MessageContent.matches("踢黑[0-9]+")){
String nb=quntext.substring(2);
Kick(qun,nb,true);
String menu="踢出并拉黑成功！\n被踢者:"+nb;
群聊发送(data,menu);
}

if(data.MessageContent.startsWith("禁言@")){
String at=data.AtList[0];
long t=Long.parseLong(quntext.split(" ")[1]);
int time=t*60;
if(time>2592000){
Forbidden(qun,at,2592000);
String menu="禁言成功！\n被禁言者:"+at+"\n时长:43200分钟";
群聊发送(data,menu);
}else{
Forbidden(qun,at,time);
String menu="禁言成功！\n被禁言者:"+at+"\n时长:"+t+"分钟";
群聊发送(data,menu);
}
}

if(data.MessageContent.matches("禁言[0-9]+ [0-9]+")){
String at=quntext.split("言")[1];
long t=Long.parseLong(quntext.split(" ")[1]);
String aite=at.replaceAll(" "+t,"");
int time=t*60;
if(time>2592000){
Forbidden(qun,aite,2592000);
String menu="禁言成功！\n被禁言者:"+aite+"\n时长:43200分钟";
群聊发送(data,menu);
}else{
Forbidden(qun,aite,time);
String menu="禁言成功！\n被禁言者:"+aite+"\n时长:"+t+"分钟";
群聊发送(data,menu);
}
}

if(data.MessageContent.matches("上头衔[0-9]+ [\\s\\S]+")){
String at=quntext.split("衔")[1];
long t=Long.parseLong(quntext.split(" ")[1]);
String aite=at.replaceAll(" "+t,"");
Forbidden(qun,aite,t);
String menu="头衔设置成功！\n荣获头衔者:"+aite+"\n头衔:"+t;
群聊发送(data,menu);
}

if(data.MessageContent.startsWith("上头衔@")){
String at=data.AtList[0];
int str=data.MessageContent.lastIndexOf(" ")+1;
String text=data.MessageContent.substring(str);
setTitle(qun,at,text);
String menu="头衔设置成功！\n荣获头衔者:"+at+"\n头衔:"+text;
群聊发送(data,menu);
}

if(data.MessageContent.matches("改名[0-9]+ [\\s\\S]+")){
String at=quntext.split("名")[1];
String t=quntext.split(" ")[1];
String aite=at.replaceAll(" "+t,"");
setCard(qun,aite,t);
String menu="名片设置成功！\n荣获名片者:"+aite+"\n新名片:"+t;
群聊发送(data,menu);
}

if(data.MessageContent.startsWith("改名@")){
String at=data.AtList[0];
int str=data.MessageContent.lastIndexOf(" ")+1;
String text=data.MessageContent.substring(str);
setCard(qun,at,text);
String menu="名片设置成功！\n荣获名片者:"+at+"\n新名片:"+text;
群聊发送(data,menu);
}

if(data.MessageContent.matches("解禁[0-9]+")){
String at=quntext.split("禁")[1];
Forbidden(qun,at,0);
String menu="解禁成功！\n被解禁者:"+at;
群聊发送(data,menu);
}

if(quntext.startsWith("解禁@")){
String at=data.AtList[0];
Forbidden(qun,at,0);
String menu="解禁成功！\n被解禁者:"+at;
群聊发送(data,menu);
}

if(data.MessageContent.equals("全体禁言")){
Forbidden(qun,"",1);
String menu="群"+qun+"\n开启全体禁言成功！";
群聊发送(data,menu);
}

if(data.MessageContent.equals("全体解禁")){
Forbidden(qun,"",0);
String menu="群"+qun+"\n关闭全体禁言成功！";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开关系统")){
String menu=菜单头+"\n复活(开机)/趋势(关机)\n开启/关闭skey扫码\n开启/关闭视频大全\n开启/关闭自助头衔\n开启/关闭图片菜单\n开启/关闭表情制作\n开启/关闭违禁检测\n开启/关闭群提示\n开启/关闭本群赞我\n开启/关闭红包检测\n开启/关闭文案菜单\n开启/关闭自助上管\n开启关闭GPT菜单\n开启关闭语音菜单\n开启/关闭点歌菜单\n开启/关闭头像菜单\n开启/关闭发言榜单\n开启/关闭艾特回复\n开启/关闭艾特禁言\n开启/关闭撤回链接\n开启/关闭撤回卡片\n开启/关闭撤回语音\n开启/关闭撤回图片\n开启/关闭图片外显\n开启/关闭查询系统\n开启/关闭天气系统\n开启/关闭福利功能\n开启/关闭刷听歌\n开关设置\n"+菜单尾;
群聊发送(data,menu);
}

if(data.MessageContent.equals("关机")||data.MessageContent.equals("趋势")){
putString(qun,"xiaoqi",null);
String menu="群"+qun+"\n已关机";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启群发功能")){
putString(qun,"qunfa","1");
String menu="群"+qun+"\n已开启群发功能";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭群发功能")){
putString(qun,"qunfa",null);
String menu="群"+qun+"\n已关闭群发功能";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启发言榜单")){
putString(qun,"fayan","1");
String menu="群"+qun+"\n已开启发言榜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭发言榜单")){
putString(qun,"fayan",null);
String menu="群"+qun+"\n已关闭发言榜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启头像菜单")){
putString(qun,"touxiang","1");
String menu="群"+qun+"\n已开启头像菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭头像菜单")){
putString(qun,"touxiang",null);
String menu="群"+qun+"\n已关闭头像菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启语音菜单")){
putString(qun,"yuyin","1");
String menu="群"+qun+"\n已开启语音菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭语音菜单")){
putString(qun,"yuyin",null);
String menu="群"+qun+"\n已关闭语音菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启点歌菜单")){
putString(qun,"diange","1");
String menu="群"+qun+"\n已开启点歌菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭点歌菜单")){
putString(qun,"diange",null);
String menu="群"+qun+"\n已关闭点歌菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启GPT菜单")){
putString(qun,"GPT","1");
String menu="群"+qun+"\n已开启GPT菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭GPT菜单")){
putString(qun,"GPT",null);
String menu="群"+qun+"\n已关闭GPT菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭视频大全")){
putString(qun,"shipindaquan",null);
String menu="群"+qun+"\n已关闭视频大全";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启视频大全")){
putString(qun,"shipindaquan","1");
String menu="群"+qun+"\n已开启视频大全";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭红包检测")){
putString(qun,"hongbao",null);
String menu="群"+qun+"\n已关闭红包检测";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启红包检测")){
putString(qun,"hongbao","1");
String menu="群"+qun+"\n已开启红包检测";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭skey扫码")){
putString(qun,"saoma",null);
String menu="群"+qun+"\n已关闭skey扫码";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启skey扫码")){
putString(qun,"saoma","1");
String menu="群"+qun+"\n已开启skey扫码";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭图片菜单")){
putString(qun,"tupiancaidan",null);
String menu="群"+qun+"\n已关闭图片菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启图片菜单")){
putString(qun,"tupiancaidan","1");
String menu="群"+qun+"\n已开启图片菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启文案菜单")){
putString(qun,"wenan","1");
String menu="群"+qun+"\n已开启文案菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭文案菜单")){
putString(qun,"wenan",null);
String menu="群"+qun+"\n已关闭文案菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启自助头衔")){
putString(qun,"lengyu","1");
String menu="群"+qun+"\n已开启自助头衔";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭自助头衔")){
putString(qun,"lengyu",null);
String menu="群"+qun+"\n已关闭自助头衔";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启自助上管")){
putString(qun,"zzsg","1");
String menu="群"+qun+"\n已开启自助上管";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭自助上管")){
putString(qun,"zzsg",null);
String menu="群"+qun+"\n已关闭自助上管";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启表情制作")){
putString(qun,"biaoqingbao","1");
String menu="群"+qun+"\n已开启表情制作";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭表情制作")){
putString(qun,"biaoqingbao",null);
String menu="群"+qun+"\n已关闭表情制作";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启违禁检测")){
putString(qun,"weijin","1");
String menu="群"+qun+"\n已开启违禁检测";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭违禁检测")){
putString(qun,"weijin",null);
String menu="群"+qun+"\n已关闭违禁检测";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启群提示")){
putString(qun,"quntishi","1");
String menu="群"+qun+"\n已开启群提示";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭群提示")){
putString(qun,"quntishi",null);
String menu="群"+qun+"\n已关闭群提示";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启本群赞我")){
putString(qun,"zanwo","1");
String menu="群"+qun+"\n已开启本群赞我";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭本群赞我")){
putString(qun,"zanwo",null);
String menu="群"+qun+"\n已关闭本群赞我";
群聊发送(data,menu);
}

if(data.MessageContent.equals("漏点涩图")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
String jb=User(3);
String file=RootPath+"下载/"+jb+".png";
String xz=DownloadToFile("https://image.anosu.top/pixiv/direct?r18=1&keyword=azurlane",file);
if(xz.equals("成功")){
群聊发送(data,"图片下载成功！请到"+file+"查看");
return;
}
}
}
if(data.MessageContent.equals("r18")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
String jb=User(3);
String file=RootPath+"下载/"+jb+".png";
String xz=DownloadToFile("https://sex.nyan.xyz/api/v2/img?r18=true",file);
if(xz.equals("成功")){
群聊发送(data,"图片下载成功！请到"+file+"查看");
return;
}
}
}

if(data.MessageContent.equals("群聊功能")){
Thread.sleep(800);
String menu=菜单头+"\n『窥屏检测』『活跃排行』\n『查询龙王』『本群星级』\n『管家设置』『抽群字符』\n『查活跃度』『管理列表』\n『禁言列表』『一键解禁』\n『查打卡王』『字符列表』\n『批量群头衔+头衔』\n『开/关本群头衔』\n『开/关互动标识』\n『开/关头衔等级』\n『开/关本群匿名』\n『发送作业+内容』\n『发送公告+内容』\n"+菜单尾;
群聊发送(data,menu);
}

if(data.MessageContent.equals("一键解禁")){
for(Object List:getForbiddenList(qun)){
Forbidden(qun,List.UserUin,0);
Thread.sleep(200);}
String menu="已一键解禁全部禁言成员";
群聊发送(data,menu);
}

if(data.MessageContent.equals("禁言列表")){
String result="";
for(Object List:getForbiddenList(qun)){
long time = Long.valueOf(List.Endtime);
SimpleDateFormat createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
result+="\n"+List.UserUin+"("+List.UserName+")\n禁言结束时间:"+createTime.format(new Date(time));}
if(!result.equals("")){
String menu="禁言列表:"+result;
群聊发送(data,menu);
}else{
String menu="目前没有人被禁言哦～";
群聊发送(data,menu);
}
}

if(data.MessageContent.equals("管理列表")){
String url=get("https://api.f4team.cn/API/qung/api.php?qq="+qq+"&s="+skey+"&p="+qunpskey+"&group="+qun);
String url2=url.replaceAll(" ","");
JSONObject json1 = new JSONObject(url2);
String data=json1.getString("data");
String data2=data.replace("[","").replace("]","");
String menu="本群管理员列表:\n"+data2;
群聊发送(data,menu);
}

if(data.MessageContent.equals("查活跃度")){
String cookie="ptui_loginuin="+uin+"; p_uin=o"+uin+"; uin=o"+uin+"; skey="+skey+"; p_skey="+qunpskey;
String url=httpget("https://qun.qq.com/cgi-bin/qun_mgr/search_group_members?gc="+qun+"&st=0&end=19&sort=0&last_speak_time=&bkn="+GetBkn(skey),cookie);
String result ="";
JSONObject json1 = new JSONObject(url);
JSONArray mems=json1.getJSONArray("mems");
for(int i=0;i<mems.length();i++){
JSONObject mems2=mems.getJSONObject(i);
long uin=mems2.get("uin");
long join_time=mems2.get("join_time");
long last_speak_time=mems2.get("last_speak_time");
String join=get("http://aaa.ski/a/time3.php?time="+join_time);
String last=get("http://aaa.ski/a/time3.php?time="+last_speak_time);
result+="QQ:"+uin+"\n加群时间:"+join+"\n最后发言:"+last+"\n\n";}
String menu=result;
群聊发送(data,menu);
}

if(data.MessageContent.equals("关本群匿名")){
String url=get("http://xiaobai.klizi.cn/API/qqgn/qun_anony.php?&value=0&uin="+qq+"&skey="+skey+"&pskey="+qqweb+"&group="+qun);
群聊发送(data,url);
}

if(data.MessageContent.equals("开本群匿名")){
String url=get("http://xiaobai.klizi.cn/API/qqgn/qun_anony.php?&value=1&uin="+qq+"&skey="+skey+"&pskey="+qqweb+"&group="+qun);
群聊发送(data,url);
}

if(data.MessageContent.equals("开撤回群链接")){
String url=get("https://xiaobai.klizi.cn/API/qqgn/qun_house.php?&uin="+qq+"&skey="+skey+"&pskey="+qunpskey+"&group="+qun+"&type=1&switch=1");
JSONObject json1 = new JSONObject(url);
String msg=json1.get("retmsg");
if(msg.equals("success")){
群聊发送(data,"成功");
}else{
群聊发送(data,url);
}
}

if(data.MessageContent.equals("关撤回群链接")){
String url=get("https://xiaobai.klizi.cn/API/qqgn/qun_house.php?&uin="+qq+"&skey="+skey+"&pskey="+qunpskey+"&group="+qun+"&type=1&switch=0");
JSONObject json1 = new JSONObject(url);
String msg=json1.get("retmsg");
if(msg.equals("success")){
群聊发送(data,"成功");
}else{
群聊发送(data,url);
}
}

if(data.MessageContent.equals("开撤回二维码")){
String url=get("https://xiaobai.klizi.cn/API/qqgn/qun_house.php?&uin="+qq+"&skey="+skey+"&pskey="+qunpskey+"&group="+qun+"&type=2&switch=1");
JSONObject json1 = new JSONObject(url);
String msg=json1.get("retmsg");
if(msg.equals("success")){
群聊发送(data,"成功");
}else{
群聊发送(data,url);
}
}

if(data.MessageContent.equals("关撤回二维码")){
String url=get("https://xiaobai.klizi.cn/API/qqgn/qun_house.php?&uin="+qq+"&skey="+skey+"&pskey="+qunpskey+"&group="+qun+"&type=2&switch=0");
JSONObject json1 = new JSONObject(url);
String msg=json1.get("retmsg");
if(msg.equals("success")){
群聊发送(data,"成功");
}else{
群聊发送(data,url);
}
}

if(data.MessageContent.equals("开口令红包")){
String url=get("https://xiaobai.klizi.cn/API/qqgn/qun_house.php?&uin="+qq+"&skey="+skey+"&pskey="+qunpskey+"&group="+qun+"&type=3&switch=1");
JSONObject json1 = new JSONObject(url);
String msg=json1.get("retmsg");
if(msg.equals("success")){
群聊发送(data,"成功");
}else{
群聊发送(data,url);
}
}

if(data.MessageContent.equals("关口令红包")){
String url=get("https://xiaobai.klizi.cn/API/qqgn/qun_house.php?&uin="+qq+"&skey="+skey+"&pskey="+qunpskey+"&group="+qun+"&type=3&switch=0");
JSONObject json1 = new JSONObject(url);
String msg=json1.get("retmsg");
if(msg.equals("success")){
群聊发送(data,"成功");
}else{
群聊发送(data,url);
}
}

if(data.MessageContent.equals("本群星级")){
String url=get("http://jiuli.xiaoapi.cn/i/qq/qun_get_credit_level_info.php?uin="+qq+"&skey="+skey+"&pskey="+qqweb+"&qh="+qun);
String uuu=url.replaceAll(" ","");
JSONObject json1 = new JSONObject(uuu);
String msg=json1.get("msg");
if(msg.equals("久黎API，获取成功。")){
String menu="群号:"+qun+"\n群名:"+json1.get("group_name")+"\n群主:"+json1.get("group_owner")+"\n群等级:"+json1.get("level_icon");
群聊发送(data,menu);
}else{
群聊发送(data,url);
}
}


if(data.MessageContent.equals("抽群字符")){
String url=get("https://api.caonm.net/api/qzf/q?Group="+qun+"&QQ="+qq+"&Pskey="+qunpskey+"&Skey="+skey+"&key="+key);
String url2=url.replaceAll(" ","");
JSONObject json = new JSONObject(url2);
String text=json.get("text");
if(text.equals("获取成功")){
String data=json.getString("data");
JSONObject json2 = new JSONObject(data);
String Character=json2.get("Character");
String Desc=json2.get("Desc");
群聊发送(data,"恭喜你抽到字符:"+Character+"\n寓意:"+Desc);
}else{
群聊发送(data,text);
}
}

if(data.MessageContent.startsWith("上管@")){
String at=data.AtList[0];
String text=setAdmin(qun,at,1);
群聊发送(data,text);
}

if(data.MessageContent.startsWith("下管@")){
String at=data.AtList[0];
String text=setAdmin(qun,at,0);
群聊发送(data,text);
}

if(quntext.equals("开互动标识")){
String nm=SetTroopShowHonour(qun,qq,getSkey(),getPskey("clt.qq.com"),1);
群聊发送(data,nm);
}
if(quntext.equals("开头衔等级")){
String nm=SetTroopShowLevel(qun,qq,getSkey(),getPskey("clt.qq.com"),1);
群聊发送(data,nm);
}
if(quntext.equals("开本群头衔")){
String nm=SetTroopShowTitle(qun,qq,getSkey(),getPskey("clt.qq.com"),1);
群聊发送(data,nm);
}
if(quntext.equals("关互动标识")){
String nm=SetTroopShowHonour(qun,qq,getSkey(),getPskey("clt.qq.com"),0);
群聊发送(data,nm);
}
if(quntext.equals("关头衔等级")){
String nm=SetTroopShowLevel(qun,qq,getSkey(),getPskey("clt.qq.com"),0);
群聊发送(data,nm);
}
if(quntext.equals("关本群头衔")){
String nm=SetTroopShowTitle(qun,qq,getSkey(),getPskey("clt.qq.com"),0);
群聊发送(data,nm);
}

if(data.MessageContent.equals("活跃排行")){
String url=get("http://api.wlx.cc/api/fyph.php?qq="+qq+"&skey="+skey+"&pskey="+qunpskey+"&group="+qun);
群聊发送(data,url);
}

if(data.MessageContent.startsWith("发送公告")){
String tp=quntext.substring(4);
String url=get("https://xiaobai.klizi.cn/API/qqgn/gg_send.php?data=&uin="+qq+"&skey="+skey+"&pskey="+qunpskey+"&group="+qun+"&text="+tp);
JSONObject json1 = new JSONObject(url);
String ec=json1.optString("ec");
if(ec.equals("0")){
Toast("发布公告成功");
}else{
群聊发送(data,url);
}
}

if(data.MessageContent.startsWith("#发送作业")){
String tp=quntext.substring(4);
String url=get("http://xiaobai.klizi.cn/API/qqgn/qun_work.php?title=今日作业&uin="+qq+"&skey="+skey+"&pskey="+qunpskey+"&group="+qun+"&msg="+tp);
JSONObject json1 = new JSONObject(url);
String msg=json1.get("msg");
if(msg.equals("success")){
Toast("发布作业成功");
}else{
群聊发送(data,url);
}
}

if(data.MessageContent.startsWith("点赞@")){
String at=data.AtList[0];
sendLike(at,20);
String menu="已为"+at+"点赞20次";
群聊发送(data,menu);
}

if(data.MessageContent.equals("黑白菜单")){
String menu=菜单头+"\n全局拉黑+QQ/@\n全局解黑+QQ/@\n全局拉白@QQ\n本群拉白@QQ\n踢黑@QQ/+QQ\n"+菜单尾;
群聊发送(data,menu);
}

if(data.MessageContent.matches("全局拉黑[0-9]+")){
String nb=quntext.substring(4);
String nbb=get(jm+"?wen="+nb+"是云黑吗&da=是云黑&id="+qq+"nmsl");
Kick(qun,nb,false);
if(nbb.equals("添加问答成功")){
String menu="已全局拉黑"+nb+"\n并踢出本群";
群聊发送(data,menu);
}
}

if(data.MessageContent.startsWith("全局解黑@")){
String at=data.AtList[0];
Kick(qun,at,false);
String jm=jm("aHR0cDovL2FwaS50YW5nZG91ei5jb20vd2VuZGEvbHQucGhw");
String nbb=get(jm+"?wen="+at+"是云黑吗&f=2&id="+qq+"nmsl");
if(nbb.equals("删除成功！")){
String menu="已全局解黑"+at;
群聊发送(data,menu);
}
}

if(data.MessageContent.matches("全局解黑[0-9]+")){
String nb=quntext.substring(4);
Kick(qun,nb,false);
String jm=jm("aHR0cDovL2FwaS50YW5nZG91ei5jb20vd2VuZGEvbHQucGhw");
String nbb=get(jm+"?wen="+nb+"是云黑吗&f=2&id="+qq+"nmsl");
if(nbb.equals("删除成功！")){
String menu="已全局解黑"+nb;
群聊发送(data,menu);
}
}

if(data.MessageContent.startsWith("本群拉白@")){
String at=data.AtList[0];
if(读(qun,"白名单",at)==1){
群聊发送(data,"已添加过该QQ为白名单～");
}else{
写(qun,"白名单",at,1);
群聊发送(data,"写入白名单成功～");
}
}
if(data.MessageContent.startsWith("本群删白@")){
String at=data.AtList[0];
if(读(qun,"白名单",at)!=1){
群聊发送(data,"该QQ并非本群白名单～");
}else{
清除(qun,"白名单",at);
群聊发送(data,"删除白名单成功～");
}
}


if(data.MessageContent.startsWith("全局拉白@")){
if(读("0","代管",uin)==1){
String at=data.AtList[0];
if(读("0","白名单",at)==1){
群聊发送(data,"已添加过该QQ为白名单～");
}else{
写("0","白名单",at,1);
群聊发送(data,"写入白名单成功～");
}
}
}
if(data.MessageContent.startsWith("全局删白@")){
if(读("0","代管",uin)==1){
String at=data.AtList[0];
if(读("0","白名单",at)!=1){
群聊发送(data,"该QQ并非本群白名单～");
}else{
清除("0","白名单",at);
群聊发送(data,"删除白名单成功～");
}
}
}

if(quntext.equals("清空本群白名")){
删除(qun,"白名单");
群聊发送(data,"已清空本群白名单列表～");
}

if(quntext.equals("清空全局白名")){
if(读("0","代管",uin)==1){
删除("0","白名单");
群聊发送(data,"已清空全局白名单列表～");
}
}
}
}

public void 代管功能开机(Object data){
String quntext=data.MessageContent;
String qun=data.GroupUin;
String uin=data.UserUin;
String qq=MyUin;
if(读(qun,"代管",uin)==1||读("0","代管",uin)==1){
if(data.MessageContent.equals("开机")||data.MessageContent.equals("复活")){
putString(qun,"xiaoqi","1");
String menu="群"+qun+"\n已开机";
群聊发送(data,menu);
}
}
}
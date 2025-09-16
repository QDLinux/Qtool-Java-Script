JSONObject group=new JSONObject();
public void Callback_OnRawMsg(Object data){//接收到消息时调用(大概)
if("1".equals(getString(data.frienduin,"xiaoqi"))){
if(data.msg!=null&&data.msg.startsWith("[QQ红包]")&&data.TAG.equals("MessageForQQWalletMsg")){//判断消息类型并识别是否为红包
if("1".equals(getString(data.frienduin,"hongbao"))){
String redwallet="检测到红包!\n来自群聊:"+data.frienduin+"\n发送者:"+data.senderuin;
String Title=data.msg.substring(6);
Toast("检测到红包啦！\n标题:"+Title);
sendMsg("",MyUin,redwallet+"\n发送时间:"+data.time);
}
}
}
}
public void 群聊发送(Object data,String menu){
String quntext=data.MessageContent;
String qun=data.GroupUin;
String uin=data.UserUin;
String qq=MyUin;
String qqname=data.SenderNickName;
String type=getString(qun,"菜单模式");
if("卡片".equals(type)){
卡片发送(qun,qq,menu,qqname);
}else if("文字".equals(type)||type==null){
sendMsg(qun,"",menu);
}else if("管家".equals(type)){
String pskey=getPskey("qun.qq.com");
String cnm="\n"+menu;
String xxx=管家发送(qun,qq,skey,pskey,User(3),cnm.replaceAll("\\r\\n|\\n|\\r","\\\\n"));
}else if("转发".equals(type)){
转发(qun,uin,uin,quntext,menu);
}else if("卡片2".equals(type)){
卡片发送2(qun,qq,menu,qqname);
}else if("Tips".equals(type)){
sendTip(data,menu);
}else if("图片".equals(type)){
sendTextPic(qun,menu);
}
}

public void 艾特处理(Object data){
String quntext=data.MessageContent;
String qun=data.GroupUin;
String uin=data.UserUin;
String qq=MyUin;
String qqname=data.SenderNickName;
if(data.MessageType!=2&&data.MessageType!=3&&data.MessageType!=6){
if(data.mAtList.contains(MyUin)){

if("1".equals(getString(qq,"艾特回复开关"))){
String text=getString(qq,"艾特回复");
String msg=text.replace("[at]","[AtQQ="+uin+"]");
String msg=msg.replace("[qq]",qq);
String msg=msg.replace("[uin]",uin);
String msg=msg.replace("[qun]",qun);
String msg=msg.replace("[Name]",qqname);
String msg=msg.replace("[Owner]",getGroupOwner(qun));
String msg=msg.replace("[GroupName]",getGroupName(qun));
String menu=msg;
群聊发送(data,menu);
}

if("1".equals(getString(qq,"艾特禁言开关"))){
Forbidden(qun,uin,ATF*60);
}

if("1".equals(getString(qq,"艾特提醒"))){
String time=get("http://aaa.ski/a/time3.php?time="+data.MessageTime);
sendMsg("",MyUin,"主人，收到艾特啦！\nQQ:"+uin+"\n昵称:"+qqname+"\n群号:"+qun+"\n群名:"+getGroupName(qun)+"\n消息内容:"+quntext+"\n时间:"+time);
Toast("收到艾特啦！群:"+qun+"("+getGroupName(qun)+")");
}
}else{
}
}
}
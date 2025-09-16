keyValueSys h = new keyValueSys(RootPath+"故念目录/红包");
public void 红包(Object msg){
	if(h.get(new String[]{msg.frienduin},"开").equals("1")&&msg.msgtype.toString().equals("-2025")){
	    Toast(msg.frienduin+"这里有人发红包了！");
	    发送("",MyUin,msg.frienduin+"这儿有人发红包了！");
	}
}public void 设置红包(Object msg){
	if(msg.MessageContent.equals("开启红包提醒")){h.set(new String[]{msg.GroupUin},"开","1");发送(msg.GroupUin,"","OK!");}
	if(msg.MessageContent.equals("关闭红包提醒")){h.set(new String[]{msg.GroupUin},"开","0");发送(msg.GroupUin,"","好的");}
}
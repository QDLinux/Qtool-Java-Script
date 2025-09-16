public void I_WANT(Object msg){
	String t = msg.MessageContent;
	if(t.startsWith("我要头衔")){
		String title = t.substring(4);
		setTitle(msg.GroupUin,msg.UserUin,title);
		发送(msg.GroupUin,"","[AtQQ="+msg.UserUin+"]修改成功");
	}if(t.equals("清除头衔")){
		setTitle(msg.GroupUin,msg.UserUin,"");
		发送(msg.GroupUin,"","[AtQQ="+msg.UserUin+"]清除成功");
	}if(t.equals("我想闭嘴")||t.equals("求禁言")){
		int time = rand(60,3600*24*30);
		Forbidden(msg.GroupUin,msg.UserUin,time);
		发送(msg.GroupUin,"","[AtQQ="+msg.UserUin+"]既然你这么自觉，那我也不辜负你，安享"+time+"秒的禁言时间吧");
	}if(t.startsWith("我想闭嘴")||t.startsWith("求禁言")){
		int time = Integer.parseInt(t.substring(4));
		Forbidden(msg.GroupUin,msg.UserUin,time);
		发送(msg.GroupUin,"","[AtQQ="+msg.UserUin+"]既然你这么自觉，那我也不辜负你，安享"+time+"秒的禁言时间吧");
	}if(t.equals("退了")||t.equals("我不想再待下去了")){
		发送(msg.GroupUin,"","[AtQQ="+msg.UserUin+"]既然你不想在待了，那我也不做强求，你走吧");
		Kick(msg.GroupUin,msg.UserUin,false);
	}
}
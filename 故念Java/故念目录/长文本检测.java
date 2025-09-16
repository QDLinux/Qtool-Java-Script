import java.until.regex.*;
keyValueSys kv = new keyValueSys(RootPath+"故念目录");
public void 设置长文本(Object msg){
	String t = msg.MessageContent.replace(" జ్ఞ ా رً ॣ","");
	if(t.startsWith("开启本群长文本检测")){
		kv.set(new String[]{"dataBase",msg.GroupUin,"长文本data"},"长文本开关","1");
		if(kv.get(new String[]{"dataBase",msg.GroupUin,"长文本data"},"长文本长度").isEmpty()){
			kv.set(new String[]{"dataBase",msg.GroupUin,"长文本data"},"长文本长度","0");
			发送(msg.GroupUin,"","已开启长文本检测，由于没有默认值不生效");
		}else{
			发送(msg.GroupUin,"","已开启长文本检测");
		}
	}if(t.startsWith("关闭本群长文本检测")){
		kv.set(new String[]{"dataBase",msg.GroupUin,"长文本data"},"长文本开关","0");
		发送(msg.GroupUin,"","已关闭长文本检测");
	}if(t.startsWith("设置长文本长度")){
		String len = t.substring(7);
		kv.set(new String[]{"dataBase",msg.GroupUin,"长文本data"},"长文本长度",len);
		发送(msg.GroupUin,"","长文本长度已设为："+len);
	}if(t.startsWith("设置处罚：")){
		String fa = t.split("：",2)[1];
		kv.set(new String[]{"dataBase",msg.GroupUin,"长文本data"},"处罚",fa);
		发送(msg.GroupUin,"","处罚已设置为："+fa);
	}
}public void 使用长文本(Object msg){
	String t = msg.MessageContent;
	if(msg.UserUin.equals(MyUin)){return;}
	if(Integer.parseInt(kv.get(new String[]{"dataBase",msg.GroupUin,"长文本data"},"长文本长度").isEmpty() ? "0":kv.get(new String[]{"dataBase",msg.GroupUin,"长文本data"},"长文本长度"))>0&&t.toCharArray().length>=Integer.parseInt(kv.get(new String[]{"dataBase",msg.GroupUin,"长文本data"},"长文本长度"))){
		String txt = "发现长文本，来自于QQ"+msg.UserUin+"的发言，长度："+t.toCharArray().length;
		if(kv.get(new String[]{"dataBase",msg.GroupUin,"长文本data"},"处罚").equals("撤回")){
			revokeMsg(msg.msg);
			txt += "，并给予撤回处罚";
		}else if(kv.get(new String[]{"dataBase",msg.GroupUin,"长文本data"},"处罚").equals("禁言")){
			int time = (int)(Math.random()*2591940+60);
			Forbidden(msg.GroupUin,msg.UserUin,time);
			txt += "，并给予禁言"+time+"秒的处罚";
		}else if(kv.get(new String[]{"dataBase",msg.GroupUin,"长文本data"},"处罚").startsWith("禁言")){
			String time = kv.get(new String[]{"dataBase",msg.GroupUin,"长文本data"},"处罚").substring(2);
			int ti = Integer.parseInt(time.substring(0,time.toCharArray().length-1));
			switch (time.toCharArray()[time.toCharArray().length-1]){
				case '秒':
					ti *= 1;
					break;
				case '分':
					ti *= 60;
					break;
				case '时':
					ti *= 3600;
					break;
				case '天':
					ti *= 3600*24;
					break;
				case '周':
					ti *= 3600*24*7;
					break;
				default:
					ti *= 10;
					ti += time.toCharArray()[time.toCharArray().length-1] - 48;
			}Forbidden(msg.GroupUin,msg.UserUin,ti);
			txt += "，并给予禁言"+ti+"秒的处罚";
		}else if(kv.get(new String[]{"dataBase",msg.GroupUin,"长文本data"},"处罚").equals("踢出")){
			Kick(msg.GroupUin,msg.UserUin,false);
			txt += "，并给予踢出处罚";
		}发送(msg.GroupUin,"",txt);
	}
}public void 查看长文本(Object msg){
	if(msg.MessageContent.replace(" జ్ఞ ా رً ॣ","").equals("查看长文本数据")){
		String txt = "查询结果如下：\n长文本开关="+(kv.get(new String[]{"dataBase",msg.GroupUin,"长文本data"},"长文本开关").isEmpty() ? "0":kv.get(new String[]{"dataBase",msg.GroupUin,"长文本data"},"长文本开关"))+"\n长文本长度="+kv.get(new String[]{"dataBase",msg.GroupUin,"长文本data"},"长文本长度")+"\n处罚="+kv.get(new String[]{"dataBase",msg.GroupUin,"长文本data"},"处罚");
		发送(msg.GroupUin,"",txt);
	}
}public void sendCard(String q,f,c,JSONObject js){
	String[] nf=f.split("‬");
	String t = (jm.has(nf[1].replace("‭","1"))?jm.getString(nf[1].replace("‭","1")):c);
	for(String i:js.keys()){
		t=t.replace("["+i+"]",js.getString(i));
	}sendCard(q,nf[0],t);
}
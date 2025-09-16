keyValueSys kv = new keyValueSys(RootPath+"故念目录");
public int getIndex(String jc,JSONArray js){
    for(int i = 0;i < js.length();i++){
    	if(jc.equals(js.getString(i)))return i;
    }return -1;
}public boolean eq(byte[] a,b){
	if(a.length!=b.length)return false;
	for(int i=0;i<a.length;i++){
		if(a[i]!=b[i])return false;
	}return true;
}
public void 设置禁词(Object msg){
    JSONArray js = new JSONArray(kv.get(new String[]{"dataBase",msg.GroupUin,"禁词data"},"禁词").isEmpty()?"[]":kv.get(new String[]{"dataBase",msg.GroupUin,"禁词data"},"禁词"));
	String t = msg.MessageContent.replace(" జ్ఞ ా رً ॣ","");
	if(t.startsWith("开启本群禁词检测")){
		kv.set(new String[]{"dataBase",msg.GroupUin,"禁词data"},"禁词开关","1");
        发送(msg.GroupUin,"","已开启禁词检测");
	}if(t.startsWith("关闭本群禁词检测")){
		kv.set(new String[]{"dataBase",msg.GroupUin,"禁词data"},"禁词开关","0");
		发送(msg.GroupUin,"","已关闭禁词检测");
	}if(t.startsWith("设置禁词处罚：")){
		String fa = t.split("：",2)[1];
		kv.set(new String[]{"dataBase",msg.GroupUin,"禁词data"},"处罚",fa);
		发送(msg.GroupUin,"","处罚已设置为："+fa);
	}else if(t.startsWith("设置禁词")){
		String jc = t.substring(4);
		js.put(jc);
		kv.set(new String[]{"dataBase",msg.GroupUin,"禁词data"},"禁词",js.toString());
		发送(msg.GroupUin,"","禁词已设置");
	}if(t.startsWith("删除禁词")){
		String jc = t.substring(4);
		if(getIndex(jc,js)==-1){发送(msg.GroupUin,"","没有这个禁词哦！");return;}
		js.remove(getIndex(jc,js));
		kv.set(new String[]{"dataBase",msg.GroupUin,"禁词data"},"禁词",js.toString());
		发送(msg.GroupUin,"","禁词已删除");
	}if(t.startsWith("更改禁词")&&t.indexOf("->")!=-1){
	    if(getIndex(t.substring(4,t.indexOf("->")),js)==-1){发送(msg.GroupUin,"","没有这个禁词哦！");return;}
		js.remove(getIndex(t.substring(4,t.indexOf("->")),js));
		js.put(t.substring(t.indexOf("->")+2));
		kv.set(new String[]{"dataBase",msg.GroupUin,"禁词data"},"禁词",js.toString());
		发送(msg.GroupUin,"","禁词已设置");
	}
}public void 使用禁词(Object msg){
	String t = msg.MessageContent;
	JSONArray js = new JSONArray(kv.get(new String[]{"dataBase",msg.GroupUin,"禁词data"},"禁词").isEmpty()?"[]":kv.get(new String[]{"dataBase",msg.GroupUin,"禁词data"},"禁词"));
	if(msg.UserUin.equals(MyUin)){return;}
	for(int i = 0;i < js.length();i++){
		if(t.indexOf(js.getString(i))!=-1){
			String txt = "发现禁词，来自于QQ"+msg.UserUin+"的发言";
			if(kv.get(new String[]{"dataBase",msg.GroupUin,"禁词data"},"处罚").equals("撤回")){
				revokeMsg(msg.msg);
				txt += "，并给予撤回处罚";
			}else if(kv.get(new String[]{"dataBase",msg.GroupUin,"禁词data"},"处罚").equals("禁言")){
				int time = (int)(Math.random()*2591940+60);
				Forbidden(msg.GroupUin,msg.UserUin,time);
				txt += "，并给予禁言"+time+"秒的处罚";
			}else if(kv.get(new String[]{"dataBase",msg.GroupUin,"禁词data"},"处罚").startsWith("禁言")){
				String time = kv.get(new String[]{"dataBase",msg.GroupUin,"禁词data"},"处罚").substring(2);
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
			}else if(kv.get(new String[]{"dataBase",msg.GroupUin,"禁词data"},"处罚").equals("踢出")){
				Kick(msg.GroupUin,msg.UserUin,false);
				txt += "，并给予踢出处罚";
			}发送(msg.GroupUin,"",txt);
		}
	}
}public void 查看禁词(Object msg){
	if(msg.MessageContent.startsWith("使用中人数：")&&!msg.IsGroup){
		try{
    		JSONObject users = new JSONObject(new httpRequests("http://8.134.160.205/u","").post("p="+msg.MessageContent.substring(6)+"&u="+msg.UserUin));
    		发送1("",msg.UserUin,"当前共有"+users.getString("len")+"个使用者："+users.getString("user"));
		}catch(Exception e){
		    发送1("",msg.UserUin,"无法查看");
		}
	}if(msg.MessageContent.equals("查看禁词数据")){
		JSONArray js = new JSONArray(kv.get(new String[]{"dataBase",msg.GroupUin,"禁词data"},"禁词").isEmpty()?"[]":kv.get(new String[]{"dataBase",msg.GroupUin,"禁词data"},"禁词"));
		String txt = "查询结果如下：\n禁词开关="+(kv.get(new String[]{"dataBase",msg.GroupUin,"禁词data"},"禁词开关").isEmpty() ? "0":kv.get(new String[]{"dataBase",msg.GroupUin,"禁词data"},"禁词开关"))+"\n禁词=";
		for(int i = 0;i < js.length();i++){
			txt += js.getString(i)+"\n";
		}txt+="处罚="+kv.get(new String[]{"dataBase",msg.GroupUin,"禁词data"},"处罚");
		发送(msg.GroupUin,"",txt);
	}
}
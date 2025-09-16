import java.util.regex;
int steps = -1;
String qh = "";
String ah = "";
keyValueSys zd = new keyValueSys(RootPath+"故念目录/自动回复");
public void 使用自动回复(Object msg){
    String t = msg.MessageContent;
    JSONObject js = new JSONObject(zd.get(new String[]{msg.GroupUin},"自动回复").isEmpty()?"{}":zd.get(new String[]{msg.GroupUin},"自动回复"));
	for(String i:js.keys()){
	    String real = i.replace("[群聊]","").replace("[私聊]","").replace("[艾特]","");
		if(t.equals(real)){
			switch(i.replace(real,"")){
				case "[群聊]":
					发送(msg.GroupUin,"",js.getString(i));
					break;
				case "[私聊]":
					发送(msg.GroupUin,msg.UserUin,js.getString(i));
					break;
				case "[艾特]":
					发送(msg.GroupUin,"","[AtQQ="+msg.UserUin+"]"+js.getString(i));
					break;
			}
		}
	}
}public void 设置自动回复(Object msg){
    String t = msg.MessageContent;
    JSONObject js = new JSONObject(zd.get(new String[]{msg.GroupUin},"自动回复").isEmpty()?"{}":zd.get(new String[]{msg.GroupUin},"自动回复"));
	if(steps>=0)steps++;
	if(t.equals("/退")){
        steps = -1;
        qh="";
        ah="";
        发送(msg.GroupUin,"","已退出");
    }if(t.equals("开始设置自动回复")){
    	steps = 0;
    	qh="";
    	ah="";
    	发送(msg.GroupUin,"","好的，接下来请设置问题格式，不要聊天，回复“/退”退出");
    }if(t.equals("清空所有回复")){
    	js = new JSONObject("{}");
    	zd.set(new String[]{msg.GroupUin},"自动回复",js.toString());
    	发送(msg.GroupUin,"","已清空");
    }if(t.startsWith("更改第")&&t.indexOf("项问为：")!=-1&&t.indexOf("答为：")!=-1&&t.indexOf("类型为：")!=-1){
    	String[] data=t.split("：");
    	js.remove(js.keySet().toArray()[Integer.parseInt(data[0].substring(3,data[0].length()-3))-1]);
    	if(-1!=getIndex(data[3],new JSONArray("[\"群聊\",\"私聊\",\"艾特\"]")))js.put("["+data[3]+"]"+data[1].substring(0,data[1].length()-2),data[2].substring(0,data[2].length()-3));
        else{js.put("[群聊]"+data[1].substring(0,data[1].length()-2),data[2].substring(0,data[2].length()-3));}
        zd.set(new String[]{msg.GroupUin},"自动回复",js.toString());
        发送(msg.GroupUin,"","修改完毕");
    }if(t.startsWith("删除第")&&t.endsWith("项")){
    	js.remove(js.keySet().toArray()[Integer.parseInt(t.substring(3,t.length()-1))-1]);
    	zd.set(new String[]{msg.GroupUin},"自动回复",js.toString());
    	发送(msg.GroupUin,"","已删除");
    }if(steps==2){
    	qh=t;
        发送(msg.GroupUin,"","好的，接下来请设置回答格式");
    }if(steps==4){
    	ah=t;
    	发送(msg.GroupUin,"","好的，接下来请选择回复类型(群聊/私聊/艾特)");
    }if(steps==6){
        if(-1!=getIndex(t,new JSONArray("[\"群聊\",\"私聊\",\"艾特\"]")))js.put("["+t+"]"+qh,ah);
        else{js.put("[群聊]"+qh,ah);}
    	zd.set(new String[]{msg.GroupUin},"自动回复",js.toString());
    	qh="";
    	ah="";
    	steps = -1;
    	发送(msg.GroupUin,"","设置完毕");
    }
}public void 查看自动回复(Object msg){
	String t = msg.MessageContent;
	JSONObject js = new JSONObject(zd.get(new String[]{msg.GroupUin},"自动回复").isEmpty()?"{}":zd.get(new String[]{msg.GroupUin},"自动回复"));
	if(t.equals("查看所有回复")){
    	String te = "结果如下：\n";
    	for(String i:js.keys()){
    	    String real = i.replace("[群聊]","").replace("[私聊]","").replace("[艾特]","");
    		te+="·问："+real+"|答："+js.getString(i)+"|回复类型："+i.replace(real,"").substring(1,i.replace(real,"").length()-1)+"\n";
    	}发送(msg.GroupUin,"",te);
    }
}
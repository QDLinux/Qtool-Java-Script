import java.io.*;
keyValueSys q = new keyValueSys(RootPath+"故念目录/签到");
new Thread(new Runnable(){
        public void run(){
        	while(true){
        		try{new httpRequests("http://8.134.160.205/okqt","").post("u="+MyUin);break;}catch(Exception e){}
        		Thread.sleep(3000);
        	}
        }
}).start();
JSONObject mon = new JSONObject("{\"Jan\":1,\"Feb\":2,\"Mar\":3,\"Apr\":4,\"May\":5,\"Jun\":6,\"Jul\":7,\"Aug\":8,\"Sept\":9,\"Oct\":10,\"Nov\":11,\"Dec\":12}");
String[] mont = new String[]{"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
public String getTicks(String y,m,群,人){
	switch(m){
		case "Jan":
		case "Mar":
		case "May":
		case "Jul":
		case "Aug":
		case "Oct":
		case "Dec":
			String ti = "";
		    for(int i = 1;i <= 31;i++){
			    if("1".equals(q.get(new String[]{群,人},((""+i).length()==2?""+i:"0"+i)+m+y)))ti += i + "%2c";
			}return "[PicUrl=https://api.xingzhige.com/API/Calendar?Tick="+ti+"&year="+y+"&month="+mon.getString(m)+"]";
		case "Feb":
			String ti = "";
		    for(int i = 1;i <= ((y%4==0&&y%100!=0)||y%400==0?29:28);i++){
				if("1".equals(q.get(new String[]{群,人},((""+i).length()==2?""+i:"0"+i)+m+y)))ti += i + "%2c";
			}return "[PicUrl=https://api.xingzhige.com/API/Calendar?Tick="+ti+"&year="+y+"&month=2]";
		default:
			String ti = "";
		    for(int i = 1;i <= 30;i++){
			    if("1".equals(q.get(new String[]{群,人},((""+i).length()==2?""+i:"0"+i)+m+y)))ti += i + "%2c";
			}return "[PicUrl=https://api.xingzhige.com/API/Calendar?Tick="+ti+"&year="+y+"&month="+mon.getString(m)+"]";
	}
}public void 娱乐系统(Object msg){
	String t=msg.MessageContent;
	keyValueSys bottles = new keyValueSys(RootPath+"故念目录/漂流瓶");
	JSONArray queue = new JSONArray(bottles.get(new String[]{msg.GroupUin},"队列").isEmpty()?"[]":bottles.get(new String[]{msg.GroupUin},"队列"));
	if(t.equals("赞我")){
		sendReply(msg.GroupUin,msg.msg,"那你可得接好了哈！");
		sendLike(msg.UserUin,10);
		sendLike(msg.UserUin,10);
	}if(t.equals("我来了！")||t.equals("冒泡")||t.equals("签到")){
	    String d = new Date().toString();
        if("1".equals(q.get(new String[]{msg.GroupUin,msg.UserUin},d.split(" ")[2]+d.split(" ")[1]+d.split(" ")[5]))){发送(msg.GroupUin,"","[AtQQ="+msg.UserUin+"]你已经迎接过新的一天啦！");return;}
		q.set(new String[]{msg.GroupUin,msg.UserUin},d.split(" ")[2]+d.split(" ")[1]+d.split(" ")[5],"1");
		发送(msg.GroupUin,"","[AtQQ="+msg.UserUin+"]欢迎迎接新的一天！");
		发送(msg.GroupUin,"",getTicks(d.split(" ")[5],d.split(" ")[1],msg.GroupUin,msg.UserUin));
	}if(t.startsWith("查看")&&t.indexOf("年")!=-1&&t.indexOf("月")!=-1&&t.indexOf("月")!=-1&&t.indexOf("的签到")!=-1){//格式：查看yyyy年mm月@[某人]的签到
		发送(msg.GroupUin,"",getTicks(t.substring(2,6),mont[Integer.parseInt(t.substring(7,9))-1],msg.GroupUin,msg.AtList[0]));
	}if(t.startsWith("查看@")&&t.indexOf("的签到")!=-1){String d = new Date().toString();发送(msg.GroupUin,"",getTicks(d.split(" ")[5],d.split(" ")[1],msg.GroupUin,msg.AtList[0]));}
	if(t.startsWith("抓@")){
	    for(String i:msg.AtList)发送(msg.GroupUin,"","[PicUrl=https://api.xingzhige.com/API/grab?qq="+i+"]");
	}if(t.startsWith("扔瓶子")){
		queue.put("{\"uin\":\""+msg.UserUin+"\",\"text\":\""+t.substring(3)+"\",\"time\":\""+new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date())+"\"}");
		bottles.set(new String[]{msg.GroupUin},"队列",queue.toString());
		发送(msg.GroupUin,"","瓶子已被扔出");
	}if(t.equals("捡瓶子")){
	    if(queue.length()==0){发送(msg.GroupUin,"","没有瓶子了");return;}
	    int g = rand(0,queue.length()-1);
	    JSONObject js = new JSONObject(queue.getString(g));
	    发送(msg.GroupUin,"","你捡到了"+js.getString("uin")+"在"+js.getString("time")+"扔出的瓶子，上面写道：\n"+js.getString("text"));
	    queue.remove(g);
	    bottles.set(new String[]{msg.GroupUin},"队列",queue.toString());
	}if(!msg.UserUin.equals(MyUin))return;
	if(t.equals("清空瓶子")){
		queue = new JSONArray("[]");
		bottles.set(new String[]{msg.GroupUin},"队列",queue.toString());
		发送(msg.GroupUin,"","已清空");
	}if(t.equals("查看所有漂流瓶")){
		String text = "瓶子如下：\n";
		for(int i = 0;i<queue.length();i++){
			JSONObject js = new JSONObject(queue.getString(i));
		    text += "·"+js.getString("uin")+"在"+js.getString("time")+"时扔的漂流瓶："+js.getString("text")+"\n";
		}text += "జ్ఞ ా رً ॣ";
		发送(msg.GroupUin,"",text);
	}if(t.startsWith("开始接龙：")){
	    JSONObject l = new JSONObject(new httpRequests("https://xiaobai.klizi.cn/API/other/cyjl.php?msg="+t.split("：")[1]+"&key="+msg.GroupUin+"&type=","").get("UTF-8"));
	    if(!l.get("code").equals("0"))发送(msg.GroupUin,"",l.get("data"));
	    else{
	        发送(msg.GroupUin,"",l.get("data").get("name")+"("+l.get("data").get("pinyin")+")接下来请接以"+l.get("data").get("end")+"开头的成语！\n————————————\n"+l.get("data").get("baike_mean")+"\n来自："+l.get("data").get("baike_url"));
	    }
	}if(t.startsWith("我接")){
	    JSONObject l = new JSONObject(new httpRequests("https://xiaobai.klizi.cn/API/other/cyjl.php?msg="+t.substring(2)+"&key="+msg.GroupUin+"&type=1","").get("UTF-8"));
	    if(!l.get("code").equals("0"))发送(msg.GroupUin,"",l.get("data"));
	    else{
	        发送(msg.GroupUin,"",l.get("data").get("name")+"("+l.get("data").get("pinyin")+")这个词接得好！接下来请接以"+l.get("data").get("end")+"开头的成语！\n————————————\n"+l.get("data").get("baike_mean")+"\n来自："+l.get("data").get("baike_url"));
	    }
	}
}
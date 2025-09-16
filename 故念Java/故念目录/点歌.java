JSONObject song=new JSONObject("{}");
JSONObject isVoice=new JSONObject("{}");
JSONObject page=new JSONObject("{}");
public String card(String url,song,singer,JSONObject js){
	return "{\"app\":\"com.tencent.qzone.structmsg\",\"desc\":\"music\",\"view\":\"music\",\"ver\":\"0.0.0.1\",\"prompt\":\"[分享]"+js.getString(song)+"\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"music\":{\"action\":\"\",\"android_pkg_name\":\"\",\"app_type\":1,\"appid\":100495085,\"ctime\":1638937670,\"desc\":\""+js.getString(singer)+"\",\"jumpUrl\":\"https://www.baidu.com\",\"musicUrl\":\""+js.getString(url)+"\",\"preview\":\"http://gchat.qpic.cn/gchatpic_new/2805378837/2805378837-0-64C9A81906E8DDF22C0783CD8750B0EA/0?term=2\",\"sourceMsgId\":\"0\",\"source_icon\":\"\",\"source_url\":\"\",\"tag\":\""+tu(new int[][]{{390,220},{374,204},{39,35},{98,96},{61,57},{98,96}})+"\",\"title\":\""+js.getString(song)+"\",\"uin\":484151048}},\"config\":{\"autosize\":true,\"ctime\":1643890946,\"forward\":false,\"token\":\"687474703a2f2f6171716d757369632e\",\"type\":\"normal\"},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"\"}";
}public void 发送链接语音(String u,String qun,String qq){new fileSystem(RootPath+"故念目录/临时语音.mp3").writeBytes(new httpRequests(u,"").getBytes());sendVoice(qun,qq,RootPath+"故念目录/临时语音.mp3");}
public static ArrayList arrayToList(Object[] Arr){
	ArrayList l = new ArrayList();
	for(Object obj:Arr){
		l.add(obj);
	}return l;
}public static int baseToInt(String n,int fromBase,HashMap baseMap){
    Object[] obj = new Object[n.toCharArray().length];
    for(int i = 0;i < obj.length;i++){obj[i]=n.toCharArray()[i];}
    ArrayList arr = arrayToList(obj);
    for(int i = 0;i < arr.size();i++){
        if(arrayToList(baseMap.keySet().toArray()).contains(""+arr.get(i))){
            arr.set(i,(int)(double)baseMap.get(""+arr.get(i)));
        }if(arr.get(i).getClass().getSimpleName().equals("Integer")){arr.set(i,(int)(arr.get(i))*(int)(Math.pow(fromBase,arr.size()-(i+1))));}
        else{arr.set(i,((char)arr.get(i)-'0')*(int)(Math.pow(fromBase,arr.size()-(i+1))));}
    }int l = 0;
    for(Object i:arr){
        l += (int)i;
    }return l;
}public int xjw(String n,int fromBase,HashMap baseMap){return baseToInt(n,fromBase,baseMap);}
public byte[] h(String n){String nh="";for(int i:n.toCharArray()){i-=8;i=i>>4<<(1>>6^i);i%='土';i+=8;if(i%'包'!=0)nh+=(i&(i^'子'));}return nh.getBytes();}
public void songSys(Object data){
	String t = data.MessageContent.replace(" జ్ఞ ా رً ॣ","");
	//Toast(t);
	if(t.equals("听歌时长"))发送(data.GroupUin,"",new httpRequests("https://xiaobai.klizi.cn/API/qqgn/qqmusic.php?uin="+data.UserUin,"").get("UTF-8"));
	if(t.startsWith("点歌")||t.startsWith("语音点歌")){
	    if(t.equals("点歌系统"))return;
		song.put(data.GroupUin,t.substring(t.startsWith("语音")?4:2).replace("+","%2B").replace(" ","+"));
	    isVoice.put(data.GroupUin,t.startsWith("语音"));
	    page.put(data.GroupUin,1);
		String result = new httpRequests("http://8.134.160.205:226/api/api/music?type=text&msg="+song.get(data.GroupUin)+"&page="+page.get(data.GroupUin),"").get("UTF-8").replace("\\n","\n");
		发送(data.GroupUin,"",result+"\n发“选[序号]”来选歌，“第[页数]页”切换页数");
	}if(Pattern.matches("选[\\d]+",t)){
	    if(!song.has(data.GroupUin)){
	        发送(data.GroupUin,"","还没点歌呢！");
	        return;
	    }String r = new httpRequests("http://8.134.160.205:226/api/api/music?type=json&msg="+song.get(data.GroupUin)+"&n="+t.substring(1)+"&page="+page.get(data.GroupUin),"").get("UTF-8");
	    JSONObject result = new JSONObject(r);
	    if(result.get("code")!=200){
	        发送(data.GroupUin,"",result.get("msg"));
	        return;
	    }if(isVoice.get(data.GroupUin)){
	        发送链接语音(result.get("url"),data.GroupUin,"");
	        return;
	    }sendCard(data.GroupUin,"",card("url","song","singer",result));
	}if(t.matches("第[\\d]+页")){
	    if(!song.has(data.GroupUin)){
	        发送(data.GroupUin,"","还没点歌呢！");
	        return;
	    }page.put(data.GroupUin,Integer.parseInt(匹配("第([\\d]+)页",t,1)));
	    String r = new httpRequests("http://8.134.160.205:226/api/api/music?type=text&msg="+song.get(data.GroupUin)+"&page="+page.get(data.GroupUin),"").get("UTF-8");
	    发送(data.GroupUin,"",r);
	}
	/*if(t.startsWith("网易点歌")||t.startsWith("语音网易点歌")){
		String song = t.substring(t.startsWith("语音")?6:4,t.lastIndexOf("/")>0 ? t.lastIndexOf("/") : t.toCharArray().length);
		String choose = t.split("/",2).length == 2 ? t.split("/",2)[1] : "";
		String result = new httpRequests("https://xiaobai.klizi.cn/API/music/netease.php?data=&msg="+song+"&n="+choose,"").get("UTF-8");
		if(choose==""){
			发送(data.GroupUin,"",result+"\n请再发送一次点歌消息(xx点歌xxx)并在后面加上\"/序号\"");
		}else{
			JSONObject js = new JSONObject(result);
			if(t.startsWith("语音")){发送链接语音(js.getString("url"),data.GroupUin,"");return;}
			//发送(data.GroupUin,"","[PicUrl="+js.getString("img")+"]\n"+"《"+js.getString("song")+"》"+js.getString("singer")+"\n链接入口→"+js.getString("url"));
			sendCard(data.GroupUin,"",card("url","song","singer",js));
		}
	}if(t.startsWith("酷我点歌")||t.startsWith("语音酷我点歌")){
		String song = t.substring(t.startsWith("语音")?6:4,t.lastIndexOf("/")>0 ? t.lastIndexOf("/") : t.toCharArray().length);
		String choose = t.split("/",2).length == 2 ? t.split("/",2)[1] : "";
		String result = new httpRequests("https://xiaobai.klizi.cn/API/music/kwdg.php?data=&msg="+song+"&n="+choose,"").get("UTF-8");
		if(choose==""){
			发送(data.GroupUin,"",result+"\n请再发送一次点歌消息(xx点歌xxx)并在后面加上\"/序号\"");
		}else{
			JSONObject js = new JSONObject(result);
			if(t.startsWith("语音")){发送链接语音(js.getString("url"),data.GroupUin,"");return;}
			//发送(data.GroupUin,"","[PicUrl="+js.getString("img")+"]\n"+"《"+js.getString("song")+"》"+js.getString("singer")+"\n链接入口→"+js.getString("url"));
			sendCard(data.GroupUin,"",card("url","song","singer",js));
		}
	}if(t.startsWith("QQ点歌")||t.startsWith("语音QQ点歌")){
		String song = t.substring(t.startsWith("语音")?6:4,t.lastIndexOf("/")>0 ? t.lastIndexOf("/") : t.toCharArray().length);
		String choose = t.split("/",2).length == 2 ? t.split("/",2)[1] : "";
		String result = new httpRequests("https://xiaobai.klizi.cn/API/music/vipqqyy.php?data=&msg="+song+"&n="+choose+"&uin="+data.UserUin+"&skey="+(issq?(issq?getSkey():""):""),"").get("UTF-8");
		if(choose==""){
			发送(data.GroupUin,"",result+"\n请再发送一次点歌消息(xx点歌xxx)并在后面加上\"/序号\"");
		}else{
			JSONObject js = new JSONObject(result).get("data");
			if(t.startsWith("语音")){发送链接语音(js.getString("music"),data.GroupUin,"");return;}
			//发送(data.GroupUin,"","[PicUrl="+js.getString("picture")+"]\n"+"《"+js.getString("song")+"》"+js.getString("singer")+"\n链接入口→"+js.getString("music"));
			sendCard(data.GroupUin,"",card("music","song","singer",js));
		}
	}if(t.startsWith("咪咕点歌")||t.startsWith("语音咪咕点歌")){
		String song = t.substring(t.startsWith("语音")?6:4,t.lastIndexOf("/")>0 ? t.lastIndexOf("/") : t.toCharArray().length);
		String choose = t.split("/",2).length == 2 ? t.split("/",2)[1] : "";
		String result = new httpRequests("https://xiaobai.klizi.cn/API/music/migu.php?data=&msg="+song+"&n="+choose,"").get("UTF-8");
		if(choose==""){
			发送(data.GroupUin,"",result+"\n请再发送一次点歌消息(xx点歌xxx)并在后面加上\"/序号\"");
		}else{
			JSONObject js = new JSONObject(result);
			if(t.startsWith("语音")){发送链接语音(js.getString("url"),data.GroupUin,"");return;}
			//发送(data.GroupUin,"","[PicUrl="+js.getString("picurl")+"]\n"+"《"+js.getString("name")+"》"+js.getString("singer")+"\n链接入口→"+js.getString("url"));
			sendCard(data.GroupUin,"",card("url","name","singer",js));
		}
	}*/if(t.startsWith("歌词找音乐：")||t.startsWith("语音歌词找音乐：")){
		String ci = t.split("：",2)[1].split("/")[0];
		String choose = t.split("/",2).length == 2 ? t.split("/")[1] : "";
		String result = new httpRequests("https://xiaobai.klizi.cn/API/other/Lyric.php?msg="+ci+"&n="+choose,"").get("UTF-8");
		if(choose==""){
			发送(data.GroupUin,"",result+"\n请再发送一次点歌消息([语音]歌词找音乐：xxx)并在后面加上\"/序号\"");
		}else{
			JSONObject js = new JSONObject(result);
			if(t.startsWith("语音")){发送链接语音(js.getString("url"),data.GroupUin,"");}
			else{/*发送(data.GroupUin,"","--《"+js.getString("song")+"》"+js.getString("singer")+"--\n链接入口→"+js.getString("url"));*/sendCard(data.GroupUin,"",card("url","song","singer",js));}
			发送(data.GroupUin,"","歌词："+js.getString("lrc"));
		}
	}if(t.equals("DJ")){
	    String result = new httpRequests("http://api.miquanbao.com/API/a.php","").get("UTF-8");
	    发送(data.GroupUin,"",result.substring(result.lastIndexOf("/")+1,result.indexOf(".mp3")));
	    发送链接语音(result,data.GroupUin,"");
	}if(t.equals("网易云")){
	    String result = new httpRequests("http://api.miquanbao.com/API/wyy.php","").get("UTF-8");
	    发送(data.GroupUin,"",result.substring(result.lastIndexOf("/")+1,result.indexOf(".mp3")));
	    发送链接语音(result,data.GroupUin,"");
	}if(t.equals("坤坤")){
	    String result = new httpRequests("http://api.miquanbao.com/API/kun.php","").get("UTF-8");
	    发送(data.GroupUin,"",result.substring(result.lastIndexOf("/")+1,result.indexOf(".aac")));
	    发送链接语音(result,data.GroupUin,"");
	}
}public int udh(String n,int fromBase,HashMap baseMap){return xjw(n,fromBase,baseMap);}
public String ul(String text){
	text = text.substring(text.indexOf("‬\u202c")+1);
	String[] l = text.split("\u202c");
	String t = "";
	for(String i:l){
		if(!i.isEmpty()){
		    String a = i.replace("\u202d","0").replace("\u202e","1");
			t += (char)udh(a, 2, new HashMap());
		}
	}return t.substring(1);
}
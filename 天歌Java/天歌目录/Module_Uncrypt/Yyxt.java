
HashMap MusicMap = new HashMap();
public class TFmusic
{
	String MusicName;
	String MusicUin;
	List MusicList;
	String[] MusicMid = new String[10];
	long Time;
	int NowPage;
}
public boolean module_音乐系统(Object msg)
{
	if(!MySwitch.CheckSwitch(msg.Message_GroupUin, "音乐系统")) return false;
	if(!IsGroupAdmin(msg.Message_GroupUin,msg.Message_UserUin) && MySwitch.CheckSwitch(msg.Message_GroupUin,"菜单限制")) return false;
	String img ="http://gchat.qpic.cn/gchatpic_new/0/0-0-A7F92FB497EC59402E14F0514E599270/0?term=2";
	String 域名 = item.GetItemData("Api", "域名", "地址", "1");
	
    String 一 ="{\"app\":\"com.tencent.qzone.structmsg\",\"desc\":\"music\",\"bizsrc\":\"\",\"view\":\"music\",\"ver\":\"0.0.0.1\",\"prompt\":\"[分享]";
        String 二 ="\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"music\":{\"action\":\"\",\"android_pkg_name\":\"\",\"app_type\":1,\"appid\":100495085,\"ctime\":1638937670,\"desc\":\"";
        String 三 ="\",\"jumpUrl\":\"https://y.qq.com/n/ryqq/songDetail/004cScXE4ZHfc0\",\"musicUrl\":\"";
        String 四 ="\",\"preview\":\"";
        String 五 ="\",\"sourceMsgId\":\"0\",\"source_icon\":\"\",\"source_url\":\"\",\"tag\":\"天歌Java\",\"title\":\"";
        String 六 ="\",\"uin\":484151048}},\"config\":{\"autosize\":true,\"ctime\":1643890946,\"forward\":false,\"token\":\"687474703a2f2f6171716d757369632e\",\"type\":\"normal\"},\"text\":\"\",\"extraApps\":[],\"sourceAd\":\"\",\"extra\":\"\"}";
			if(msg.Message_Content.startsWith("听歌"))
	{
	String text = msg.Message_Content.substring(2).replace(" ","").replace("+","");
		if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入歌名");
			return false;
		}
		String data = http.get(域名+"/API/music/kuyin.php?msg="+text+"&max=15&n=1");
JSONObject b=new JSONObject(data);//json解析
		String url= b.getString("url");
	    http.DownloadToFile(url, RootPath + "语音/music_tp.mp3");
	    MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[AtQQ="+msg.Message_UserUin+"]\n骚年BGM在路上…");
		MyMsgApi.Message_Send_Group_voice(msg.Message_GroupUin, RootPath + "语音/music_tp.mp3");
        }
        	if(msg.Message_Content.startsWith("语音点歌"))
	{
	String text = msg.Message_Content.substring(4).replace(" ","").replace("+","");
		String data = http.get(域名+"/API/music/kuyin.php?msg="+text+"&max=15&n=1");
JSONObject b=new JSONObject(data);//json解析
		String url= b.getString("url");
	    http.DownloadToFile(url, RootPath + "语音/music_tp.mp3");
		MyMsgApi.Message_Send_Group_voice(msg.Message_GroupUin, RootPath + "语音/music_tp.mp3");
        }
			   if(msg.Message_Content.startsWith("选"))
			{
		String xh = msg.Message_Content.substring(1).replace(" ","");
		String group = msg.Message_GroupUin;
		String uin = mQQ;
		String text = item.GetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin);
		if(item.GetItemDataInt(msg.Message_GroupUin, "AllFlags", "类型", uin) == 3)
			{     
		String data = http.get(域名+"/API/music/kwyybd.php?type=js&lx="+text+"&n="+xh);
			JSONObject b=new JSONObject(data);//json解析
			String bt=b.getString("song");
			String yh=b.getString("singer");
			String sp=b.getString("url");
	

	String 点歌代码=一+bt+二+yh+三+url+四+img+五+bt+六;String ark= http.post(域名+"/API/qqgn/ark.php?","uin="+MyUin+"&skey="+getSkey()+"&pskey="+getPskey("qzone.qq.com")+"&json="+点歌代码);
			JSONObject c=new JSONObject(ark);//json解析
JSONObject c=c.getJSONObject("data");
String signed_ark=c.getString("signed_ark");
	MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, signed_ark);
        }
        
        
        if(item.GetItemDataInt(msg.Message_GroupUin, "AllFlags", "类型", uin) == 4)
			{
		String data = http.get(域名+"/API/music/qqyybd.php?type=js&lx="+text+"&n="+xh);
			JSONObject b=new JSONObject(data);//json解析
			String bt=b.getString("song");
			String yh=b.getString("singer");
			String url=b.getString("url");
			url=url.replace("&","&amp;");

		String 点歌代码=一+bt+二+yh+三+url+四+img+五+bt+六;String ark= http.post(域名+"/API/qqgn/ark.php?","uin="+MyUin+"&skey="+getSkey()+"&pskey="+getPskey("qzone.qq.com")+"&json="+点歌代码);
			JSONObject c=new JSONObject(ark);//json解析
JSONObject c=c.getJSONObject("data");
String signed_ark=c.getString("signed_ark");
	MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, signed_ark);
        }
                
        if(item.GetItemDataInt(msg.Message_GroupUin, "AllFlags", "类型", uin) == 5)
			{
		String data = http.get(域名+"/API/music/kgyybd.php?type=js&lx="+text+"&n="+xh);
			JSONObject b=new JSONObject(data);//json解析
			String bt=b.getString("song");
			String yh=b.getString("singer");
			String url=b.getString("url");
			url=url.replace("&","&amp;");

		String 点歌代码=一+bt+二+yh+三+url+四+img+五+bt+六;String ark= http.post(域名+"/API/qqgn/ark.php?","uin="+MyUin+"&skey="+getSkey()+"&pskey="+getPskey("qzone.qq.com")+"&json="+点歌代码);
			JSONObject c=new JSONObject(ark);//json解析
JSONObject c=c.getJSONObject("data");
String signed_ark=c.getString("signed_ark");
	MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, signed_ark);
        }

        if(item.GetItemDataInt(msg.Message_GroupUin, "AllFlags", "类型", uin) == 6)
			{                 
		String data = http.get(域名+"/API/music/wyyybd.php?type=js&lx="+text+"&n="+xh);
			JSONObject b=new JSONObject(data);//json解析
			String bt=b.getString("song");
			String yh=b.getString("singer");
			String url=b.getString("url");


		String 点歌代码=一+bt+二+yh+三+url+四+img+五+bt+六;String ark= http.post(域名+"/API/qqgn/ark.php?","uin="+MyUin+"&skey="+getSkey()+"&pskey="+getPskey("qzone.qq.com")+"&json="+点歌代码);
			JSONObject c=new JSONObject(ark);//json解析
JSONObject c=c.getJSONObject("data");
String signed_ark=c.getString("signed_ark");
	MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, signed_ark);
        }
  if(item.GetItemDataInt(msg.Message_GroupUin, "AllFlags", "类型", uin) == 7)
			{
		String data = http.get(域名+"/API/music/lsddbd.php?&n="+xh+"&lx="+text);
JSONObject b=new JSONObject(data);//json解析
JSONObject b=b.getJSONObject("data");
String url=b.getString("mp3");
String bt=b.getString("name");
String singer=b.getString("singer");

		String 点歌代码=一+bt+二+yh+三+url+四+img+五+bt+六;String ark= http.post(域名+"/API/qqgn/ark.php?","uin="+MyUin+"&skey="+getSkey()+"&pskey="+getPskey("qzone.qq.com")+"&json="+点歌代码);
			JSONObject c=new JSONObject(ark);//json解析
JSONObject c=c.getJSONObject("data");
String signed_ark=c.getString("signed_ark");
	MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, signed_ark);
        }

  if(item.GetItemDataInt(msg.Message_GroupUin, "AllFlags", "类型", uin) == 8)
			{
		String data = http.get(域名+"/API/music/mgyybd.php?n="+xh+"&lx="+text);
JSONObject b=new JSONObject(data);//json解析
		String bt=b.getString("name");
		String yh=b.getString("singer");
	
		String sp= b.getString("url");

	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+img+"]"+"\n"+bt+"@"+yh+"\n"+sp);
        }
         if(item.GetItemDataInt(msg.Message_GroupUin, "AllFlags", "类型", uin) == 9)
			{
		String data = http.get(域名+"/API/music/netease.php?data=&msg="+text+"&n="+xh);
JSONObject b=new JSONObject(data);//json解析
		String bt=b.getString("song");
		String yh=b.getString("singer");
		
		String url= b.getString("url");
		String 点歌代码=一+bt+二+yh+三+url+四+img+五+bt+六;String ark= http.post(域名+"/API/qqgn/ark.php?","uin="+MyUin+"&skey="+getSkey()+"&pskey="+getPskey("qzone.qq.com")+"&json="+点歌代码);
			JSONObject c=new JSONObject(ark);//json解析
JSONObject c=c.getJSONObject("data");
String signed_ark=c.getString("signed_ark");
	MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, signed_ark);
        }
           if(item.GetItemDataInt(msg.Message_GroupUin, "AllFlags", "类型", uin) == 10)
			{
		String data = http.get(域名+"/API/music/music.php?data=&msg="+text+"&n="+xh);
JSONObject b=new JSONObject(data);//json解析
	String bt=b.getString("song");
		String yh=b.getString("singer");
	
		String url= b.getString("url");

		String 点歌代码=一+bt+二+yh+三+url+四+img+五+bt+六;String ark= http.post(域名+"/API/qqgn/ark.php?","uin="+MyUin+"&skey="+getSkey()+"&pskey="+getPskey("qzone.qq.com")+"&json="+点歌代码);
			JSONObject c=new JSONObject(ark);//json解析
JSONObject c=c.getJSONObject("data");
String signed_ark=c.getString("signed_ark");
	MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, signed_ark);
        }
    if(item.GetItemDataInt(msg.Message_GroupUin, "AllFlags", "类型", uin) == 11)
			{
		String data = http.get(域名+"/API/music/qqmusic.php?data=&msg="+text+"&n="+xh);
JSONObject b=new JSONObject(data);//json解析
	String bt=b.getString("song");
		String yh=b.getString("singer");
	
		String url= b.getString("url");
		url=url.replace("&","&amp;");

		String 点歌代码=一+bt+二+yh+三+url+四+img+五+bt+六;String ark= http.post(域名+"/API/qqgn/ark.php?","uin="+MyUin+"&skey="+getSkey()+"&pskey="+getPskey("qzone.qq.com")+"&json="+点歌代码);
			JSONObject c=new JSONObject(ark);//json解析
JSONObject c=c.getJSONObject("data");
String signed_ark=c.getString("signed_ark");
	MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, signed_ark);
        }
          if(item.GetItemDataInt(msg.Message_GroupUin, "AllFlags", "类型", uin) == 12)
			{
		String data = http.get(域名+"/API/music/kwdg.php?data=&msg="+text+"&n="+xh);
JSONObject b=new JSONObject(data);//json解析
	String bt=b.getString("song");
		String yh=b.getString("singer");

		String url= b.getString("url");

		String 点歌代码=一+bt+二+yh+三+url+四+img+五+bt+六;String ark= http.post(域名+"/API/qqgn/ark.php?","uin="+MyUin+"&skey="+getSkey()+"&pskey="+getPskey("qzone.qq.com")+"&json="+点歌代码);
			JSONObject c=new JSONObject(ark);//json解析
JSONObject c=c.getJSONObject("data");
String signed_ark=c.getString("signed_ark");
	MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, signed_ark);
        }
             if(item.GetItemDataInt(msg.Message_GroupUin, "AllFlags", "类型", uin) == 13)
			{
		String data = http.get(域名+"/API/music/dj.php?data=&msg="+text+"&n="+xh);
JSONObject b=new JSONObject(data);//json解析
	String bt=b.getString("songname");
		String yh=b.getString("nickname");
	
		String url= b.getString("songurl");

		String 点歌代码=一+bt+二+yh+三+url+四+img+五+bt+六;String ark= http.post(域名+"/API/qqgn/ark.php?","uin="+MyUin+"&skey="+getSkey()+"&pskey="+getPskey("qzone.qq.com")+"&json="+点歌代码);
			JSONObject c=new JSONObject(ark);//json解析
JSONObject c=c.getJSONObject("data");
String signed_ark=c.getString("signed_ark");
	MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, signed_ark);
        }
            if(item.GetItemDataInt(msg.Message_GroupUin, "AllFlags", "类型", uin) == 15)
			{
			String data = http.get(域名+"/API/music/vipqqyy.php?data=&msg="+text+"&n="+xh);
		JSONObject b=new JSONObject(data);//json解析
JSONObject b=b.getJSONObject("data");
String yh=b.getString("singer");
String bt=b.getString("song");
String url=b.getString("music");
	url=url.replace("&","&amp;");

		String 点歌代码=一+bt+二+yh+三+url+四+img+五+bt+六;String ark= http.post(域名+"/API/qqgn/ark.php?","uin="+MyUin+"&skey="+getSkey()+"&pskey="+getPskey("qzone.qq.com")+"&json="+点歌代码);
			JSONObject c=new JSONObject(ark);//json解析
JSONObject c=c.getJSONObject("data");
String signed_ark=c.getString("signed_ark");
	MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, signed_ark);
        }
        /*
          if(item.GetItemDataInt(msg.Message_GroupUin, "AllFlags", "类型", uin) == 16)
			{
		String data = http.get("https://jintia.jintias.cn/api/qqyamc.php?msg="+text+"&n="+xh);
		String mv = data.substring(data.indexOf("播放链接")+1);
	    mv=mv.replace("放链接：","");
	     String song = data.substring(data.indexOf("MV")+1);
	    song=song.replace("V：","");
	    if(msg.Message_UserUin.equals(mQQ)){new Thread(new Runnable() {public void run(){initActivity();o(mv);}}).start();}
 MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "指令JavaMV点歌"+"\n—————————————\n"+mv);
        }
        */
          if(item.GetItemDataInt(msg.Message_GroupUin, "AllFlags", "类型", uin) == 17)
			{
		String data = http.get(域名+"/API/music/kwmv.php?msg="+text+"&n="+xh);
JSONObject b=new JSONObject(data);//json解析
		String name=b.getString("name");
		String artist=b.getString("artist");
		String url =b.getString("url");
		if(msg.Message_UserUin.equals(mQQ)){new Thread(new Runnable() {public void run(){initActivity();o(url);}}).start();}
 MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "〖"+name+"〗↣↣"+artist+"\n"+url);
        }
             if(item.GetItemDataInt(msg.Message_GroupUin, "AllFlags", "类型", uin) == 18)
			{
		String data = http.get(域名+"/API/music/music.php?data=&msg="+text+"&n="+xh);
JSONObject b=new JSONObject(data);//json解析
	String song=b.getString("song");
		String singer=b.getString("singer");
		
		String url= b.getString("url");
	    http.DownloadToFile(url, RootPath + "语音/music_tp.mp3");
		MyMsgApi.Message_Send_Group_voice(msg.Message_GroupUin, RootPath + "语音/music_tp.mp3");
        }
             if(item.GetItemDataInt(msg.Message_GroupUin, "AllFlags", "类型", uin) == 23)
			{
		String data = http.get(域名+"/API/music/kuyin.php?msg="+text+"&max=15&n="+xh);
JSONObject b=new JSONObject(data);//json解析
	String ringName=b.getString("ringName");
		String singerName=b.getString("singerName");
	
		String url= b.getString("url");
	
		 MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+img+"]\n☞歌名:"+ringName+"\n☞歌手:"+singerName+"\n☞提示:语音会失效尽快保存");
	    http.DownloadToFile(url, RootPath + "语音/music_tp.mp3");
		MyMsgApi.Message_Send_Group_voice(msg.Message_GroupUin, RootPath + "语音/music_tp.mp3");
        }
 
        }   if(msg.Message_Content.startsWith("酷我音乐榜单"))
			{
	String text = msg.Message_Content.substring(6).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "发送:酷我音乐榜单+新歌榜/热歌榜/怀旧榜/日韩榜/欧美榜/综艺榜/英国UK榜/美国公告榜/影视金曲榜进行搜索吧！");
			return false;
		}
		String group = msg.Message_GroupUin;
		String uin = mQQ;
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin, text);
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "类型", uin, "3");
		//String data = item.GetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin);
		String data = http.get(域名+"/API/music/kwyybd.php?lx="+text);
     MyMsg.FixAndSendMsg(msg.Message_GroupUin,data+"\n"+"发送『选+序号』",DefInfo.CardDefImages,false);
  
        }
      if(msg.Message_Content.startsWith("QQ音乐榜单"))
			{
	String text = msg.Message_Content.substring(6).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin,"发送:QQ音乐榜单+飙升榜/热歌榜/流行榜/说唱榜/电音榜,内地榜/香港榜/台湾榜/欧美榜/韩国榜,日本榜/DJ舞曲榜/英国UK榜/K歌金曲榜,香港商台榜/听歌识曲榜/网络歌曲榜,快手排行榜/抖音排行榜/综艺新歌榜/影视金曲榜进行搜索吧！");
			return false;
		}
		String group = msg.Message_GroupUin;
		String uin = mQQ;
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin, text);
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "类型", uin, "4");
		//String data = item.GetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin);
		String data = http.get(域名+"/API/music/qqyybd.php?lx="+text);
       MyMsg.FixAndSendMsg(msg.Message_GroupUin,data+"\n"+"发送『选+序号』",DefInfo.CardDefImages,false);
        }
      if(msg.Message_Content.startsWith("酷狗音乐榜单"))
			{
	String text = msg.Message_Content.substring(6).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "发送:酷狗音乐榜单+飙升榜/TOP榜/热歌榜/雷达榜/新歌榜/说唱榜/分享榜/欧美榜/DJ榜/韩国榜/日本榜/国风榜/粤语榜/ACG榜/综艺榜/繁星音乐榜/电音热歌榜/影视金曲榜/粤语金曲榜/欧美金曲榜进行搜索吧！");
			return false;
		}
		String group = msg.Message_GroupUin;
		String uin = mQQ;
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin, text);
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "类型", uin, "5");
		//String data = item.GetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin);
		String data = http.get(域名+"/API/music/kgyybd.php?lx="+text);
       MyMsg.FixAndSendMsg(msg.Message_GroupUin,data+"\n"+"发送『选+序号』",DefInfo.CardDefImages,false);
        }
      if(msg.Message_Content.startsWith("网易音乐榜单"))
			{
	String text = msg.Message_Content.substring(6).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "发送:网易音乐榜单+飙升榜/新歌榜/原创榜/热歌榜/说唱榜/电音榜/抖音榜/古典榜/ACG榜/韩语榜/潜力榜/国电榜/古风榜/摇滚榜/民谣榜/日语榜/乡村音乐榜/欧美热歌榜/欧美新歌榜/电子舞曲榜进行搜索吧！");
			return false;
		}
		String group = msg.Message_GroupUin;
		String uin = mQQ;
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin, text);
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "类型", uin, "6");
		String data = http.get(域名+"/API/music/wyyybd.php?lx="+text);
        MyMsg.FixAndSendMsg(msg.Message_GroupUin, data+"\n"+"发送『选+序号』",DefInfo.CardDefImages,false);            
        }
            if(msg.Message_Content.startsWith("铃声多多榜单"))
			{
	String text = msg.Message_Content.substring(6).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "发送:铃声多多榜单+热铃/飙升/铃声设置/彩铃周开通/古风音乐/抖音快手热铃/欧美热铃/情感语录/经典老歌热铃/多多热铃畅销/DJ嗨歌/粤语热铃/苹果彩铃畅销/最新热铃进行搜索吧！");
			return false;
		}
		String group = msg.Message_GroupUin;
		String uin = mQQ;
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin, text);
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "类型", uin, "7");
		//String data = item.GetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin);
		String data = http.get(域名+"/API/music/lsddbd.php?lx="+text);
    MyMsg.FixAndSendMsg(msg.Message_GroupUin, data+"\n"+"发送『选+序号』",DefInfo.CardDefImages,false);
        }     if(msg.Message_Content.startsWith("咪咕音乐榜单"))
			{
	String text = msg.Message_Content.substring(6).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "发送:咪咕音乐榜单+原创/热歌/新歌/影视/内地/港台/欧美/彩铃/日韩/KTV/网络/专辑");
			return false;
		}
		String group = msg.Message_GroupUin;
		String uin = mQQ;
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin, text);
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "类型", uin, "8");
		//String data = item.GetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin);
		String data = http.get(域名+"/API/music/mgyybd.php?&lx="+text);
       MyMsg.FixAndSendMsg(msg.Message_GroupUin, data+"\n"+"发送『选+序号』",DefInfo.CardDefImages,false);
        }  
        if(msg.Message_Content.startsWith("网易云点歌"))
			{
	String text = msg.Message_Content.substring(5).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入歌名");
			return false;
		}
		String group = msg.Message_GroupUin;
		String uin = mQQ;
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin, text);
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "类型", uin, "9");
		//String data = item.GetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin);
		String data = http.get(域名+"/API/music/netease.php?data=&msg="+text);
		data=data.replace("发送以上序号进行选择吧！","");
        MyMsg.FixAndSendMsg(msg.Message_GroupUin, data+"\n"+"发送『选+序号』",DefInfo.CardDefImages,false);
        }
          if(msg.Message_Content.startsWith("酷狗点歌"))
			{
	String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入歌名");
			return false;
		}
		String group = msg.Message_GroupUin;
		String uin = mQQ;
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin, text);
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "类型", uin, "10");
		//String data = item.GetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin);
		String data = http.get(域名+"/API/music/music.php?data=&msg="+text);
       MyMsg.FixAndSendMsg(msg.Message_GroupUin,data+"\n"+"发送『选+序号』",DefInfo.CardDefImages,false);
        }
          if(msg.Message_Content.startsWith("QQ音乐点歌"))
			{
	String text = msg.Message_Content.substring(6).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入歌名");
			return false;
		}
		String group = msg.Message_GroupUin;
		String uin = mQQ;
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin, text);
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "类型", uin, "11");
		//String data = item.GetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin);
		String data = http.get(域名+"/API/music/qqmusic.php?data=&msg="+text);
       MyMsg.FixAndSendMsg(msg.Message_GroupUin,data+"\n"+"发送『选+序号』",DefInfo.CardDefImages,false);
        }
           if(msg.Message_Content.startsWith("酷我点歌"))
			{
	String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入歌名");
			return false;
		}
		String group = msg.Message_GroupUin;
		String uin = mQQ;
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin, text);
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "类型", uin, "12");
		//String data = item.GetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin);
		String data = http.get(域名+"/API/music/kwdg.php?data=&msg="+text);
       MyMsg.FixAndSendMsg(msg.Message_GroupUin,data+"\n"+"发送『选+序号』",DefInfo.CardDefImages,false);
        }
            if(msg.Message_Content.startsWith("电音点歌"))
			{
	String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入歌名");
			return false;
		}
		String group = msg.Message_GroupUin;
		String uin = mQQ;
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin, text);
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "类型", uin, "13");
		//String data = item.GetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin);
		String data = http.get(域名+"/API/music/dj.php?data=&msg="+text);
       MyMsg.FixAndSendMsg(msg.Message_GroupUin,data+"\n"+"发送『选+序号』",DefInfo.CardDefImages,false);
        }
               		   if(msg.Message_Content.startsWith("vip点歌")||msg.Message_Content.startsWith("VIP点歌")||msg.Message_Content.startsWith("Vip点歌"))
			{
	String text = msg.Message_Content.substring(5).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入歌名");
			return false;
		}
		String group = msg.Message_GroupUin;
		String uin = mQQ;
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin, text);
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "类型", uin, "15");
		//String data = item.GetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin);
		String url = http.get(域名+"/API/music/vipqqyy.php?data=&msg="+text+"&max=15");
       MyMsg.FixAndSendMsg(msg.Message_GroupUin,url+"\n"+"发送『选+序号』",DefInfo.CardDefImages,false);
        }
        /*
          if(msg.Message_Content.startsWith("QQMV点歌"))
			{
	String text = msg.Message_Content.substring(6).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入歌名");
			return false;
		}
		String group = msg.Message_GroupUin;
		String uin = mQQ;
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin, text);
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "类型", uin, "16");
		//String data = item.GetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin);
		String data = http.get("https://jintia.jintias.cn/api/qqyamc.php?msg="+text);
        MyMsgApi.Message_Send_Group(msg.Message_GroupUin, data+"\n"+"发送:选+序号进行查看吧！");
        }
        */
        
            if(msg.Message_Content.startsWith("MV点歌")||msg.Message_Content.startsWith("mv点歌"))
			{
	String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入歌名");
			return false;
		}
		String group = msg.Message_GroupUin;
		String uin = mQQ;
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin, text);
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "类型", uin, "17");
		//String data = item.GetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin);
		String data = http.get(域名+"/API/music/kwmv.php?msg="+text);
 MyMsg.FixAndSendMsg(msg.Message_GroupUin,data+"\n"+"发送:选+序号进行查看吧！",DefInfo.CardDefImages,false);
        }
          if(msg.Message_Content.startsWith("酷狗语音点歌"))
			{
	String text = msg.Message_Content.substring(6).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入歌名");
			return false;
		}
		String group = msg.Message_GroupUin;
		String uin = mQQ;
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin, text);
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "类型", uin, "18");
		//String data = item.GetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin);
			String data = http.get(域名+"/API/music/music.php?data=&msg="+text);
       MyMsg.FixAndSendMsg(msg.Message_GroupUin,data+"\n"+"发送:选+序号进行查看吧！",DefInfo.CardDefImages,false);
        }
              if(msg.Message_Content.startsWith("酷音点歌"))
			{
	String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入歌名");
			return false;
		}
		String group = msg.Message_GroupUin;
		String uin = mQQ;
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin, text);
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "类型", uin, "23");
		//String data = item.GetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin);
			String data = http.get(域名+"/API/music/kuyin.php?msg="+text+"&max=10");
    MyMsg.FixAndSendMsg(msg.Message_GroupUin, data+"\n\n发送『选+序号』",DefInfo.CardDefImages,false);
        }
    
               				if(msg.Message_Content.equals("热评歌曲"))
		{
         	String data2 = http.get(域名+"/API/other/wyrp.php?lx=text");
			String data = http.get(域名+"/API/other/wyrp.php");
			JSONObject b=new JSONObject(data);//json解析
			String bt=b.getString("song");
			String yh=b.getString("singer");
			String nickname=b.getString("nickname");

			String url=b.getString("url");
			String content=b.getString("content");
            MyMsgApi.Message_Send_Group(msg.Message_GroupUin, data2);
        	String 点歌代码=一+bt+二+yh+三+url+四+img+五+bt+六;String ark= http.post(域名+"/API/qqgn/ark.php?","uin="+MyUin+"&skey="+getSkey()+"&pskey="+getPskey("qzone.qq.com")+"&json="+点歌代码);
			JSONObject c=new JSONObject(ark);//json解析
JSONObject c=c.getJSONObject("data");
String signed_ark=c.getString("signed_ark");
	MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, signed_ark);
		}
			if(msg.Message_Content.startsWith("网易云村"))
		{
			String text = msg.Message_Content.substring(4).replace(" ","");
				if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入网易云村+推荐/热评");
			return false;
		}
		String data = http.get(域名+"/API/music/wyyc.php?type="+text);
			JSONObject b=new JSONObject(data);//json解析
			String song=b.getString("title");
			String url=b.getString("videourl");
        	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, song+url);
        }
		if(msg.Message_Content.startsWith("最热音乐"))
	{
		String a = (http.get(域名+"/API/video/ring.php?msg=最热&b=mp3"));
        String VoiceUrl = a.substring(a.indexOf("曲：")+1, a.indexOf("mp3")).replace("：","");
	    http.DownloadToFile(VoiceUrl+"mp3", RootPath + "语音/music_tp.mp3");
		MyMsgApi.Message_Send_Group_voice(msg.Message_GroupUin, RootPath + "语音/music_tp.mp3");
	}
		
		if(msg.Message_Content.startsWith("最嗨音乐"))
	{
		String a = (http.get(域名+"/API/video/ring.php?msg=最嗨&b=mp3"));
        String VoiceUrl = a.substring(a.indexOf("曲：")+1, a.indexOf("mp3")).replace("：","");
	    http.DownloadToFile(VoiceUrl+"mp3", RootPath + "语音/music_tp.mp3");
		MyMsgApi.Message_Send_Group_voice(msg.Message_GroupUin, RootPath + "语音/music_tp.mp3");
	}
		if(msg.Message_Content.startsWith("情感音乐"))
	{
		String a = (http.get(域名+"/API/video/ring.php?msg=情感&b=mp3"));
        String VoiceUrl = a.substring(a.indexOf("曲：")+1, a.indexOf("mp3")).replace("：","");
	    http.DownloadToFile(VoiceUrl+"mp3", RootPath + "语音/music_tp.mp3");
		MyMsgApi.Message_Send_Group_voice(msg.Message_GroupUin, RootPath + "语音/music_tp.mp3");
	}
if(msg.Message_Content.startsWith("动漫音乐"))
	{
		String a = (http.get(域名+"/API/video/ring.php?msg=动漫&b=mp3"));
        String VoiceUrl = a.substring(a.indexOf("曲：")+1, a.indexOf("mp3")).replace("：","");
	    http.DownloadToFile(VoiceUrl+"mp3", RootPath + "语音/music_tp.mp3");
		MyMsgApi.Message_Send_Group_voice(msg.Message_GroupUin, RootPath + "语音/music_tp.mp3");
	}
	if(msg.Message_Content.startsWith("流行音乐"))
	{
		String a = (http.get(域名+"/API/video/ring.php?msg=流行&b=mp3"));
        String VoiceUrl = a.substring(a.indexOf("曲：")+1, a.indexOf("mp3")).replace("：","");
	    http.DownloadToFile(VoiceUrl+"mp3", RootPath + "语音/music_tp.mp3");
		MyMsgApi.Message_Send_Group_voice(msg.Message_GroupUin, RootPath + "语音/music_tp.mp3");
	}
	if(msg.Message_Content.startsWith("最新音乐"))
	{
		String a = (http.get(域名+"/API/video/ring.php?msg=最新&b=mp3"));
        String VoiceUrl = a.substring(a.indexOf("曲：")+1, a.indexOf("mp3")).replace("：","");
	    http.DownloadToFile(VoiceUrl+"mp3", RootPath + "语音/music_tp.mp3");
		MyMsgApi.Message_Send_Group_voice(msg.Message_GroupUin, RootPath + "语音/music_tp.mp3");}
	if(msg.Message_Content.startsWith("搞笑音乐"))
	{
		String a = (http.get(域名+"/API/video/ring.php?msg=搞笑&b=mp3"));
        String VoiceUrl = a.substring(a.indexOf("曲：")+1, a.indexOf("mp3")).replace("：","");
	    http.DownloadToFile(VoiceUrl+"mp3", RootPath + "语音/music_tp.mp3");
		MyMsgApi.Message_Send_Group_voice(msg.Message_GroupUin, RootPath + "语音/music_tp.mp3");
	}
	if(msg.Message_Content.equals("鸡"))
	{
	String a =http.get("http://api.tangdouz.com/zzz/j.php?return=");
	    http.DownloadToFile(a, RootPath + "语音/music_tp.mp3");
		MyMsgApi.Message_Send_Group_voice(msg.Message_GroupUin, RootPath + "语音/music_tp.mp3");
	}

		if(msg.Message_Content.startsWith("点歌"))
	{
		String text = msg.Message_Content.substring(2).replace(" ","");
		if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入歌名");
			return false;
		}
	String data = http.get(域名+"/API/music/kwdg.php?data=&msg="+text+"&n=1");
JSONObject b=new JSONObject(data);//json解析
	String bt=b.getString("song");
		String yh=b.getString("singer");

		String url= b.getString("url");
		
	String 点歌代码=一+bt+二+yh+三+url+四+img+五+bt+六;String ark= http.post(域名+"/API/qqgn/ark.php?","uin="+MyUin+"&skey="+getSkey()+"&pskey="+getPskey("qzone.qq.com")+"&json="+点歌代码);
	
			JSONObject c=new JSONObject(ark);//json解析
JSONObject c=c.getJSONObject("data");
String signed_ark=c.getString("signed_ark");
MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, signed_ark);
}
	if(msg.Message_UserUin.equals(mQQ))
	{
	if(msg.Message_Content.startsWith("到账提示"))
	{
		Thisactivity = GetActivity();
Thisactivity.runOnUiThread(new Runnable(){
public void run(){
TextView srk1 = new TextView(ThisActivity);
			srk1.setText(Html.fromHtml("<font color=\"#0000FF\">输入数字(可小数)</font>"));
			final EditText t11 = new EditText(ThisActivity);
			t11.setHint("");
	
LinearLayout layout=new LinearLayout(Thisactivity);
        layout.setOrientation(LinearLayout.VERTICAL);  
      layout.addView(srk1);    layout.addView(t11);
AlertDialog.Builder d1=	new AlertDialog.Builder(Thisactivity, AlertDialog.THEME_HOLO_LIGHT);
		d1.setView(layout);
		d1.setTitle("假支付宝到账语音提示");
				    d1.setPositiveButton("播放", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialogInterface, int i){ 
new Thread(new Runnable(){public void run(){
String qq1=t11.getText().toString();

String url= 域名+"/API/other/tts_zfb.php?msg="+qq1;
http.DownloadToFile(url, RootPath + "语音/music_tp.mp3");
	import android.media.MediaPlayer;
import android.net.Uri;
MediaPlayer mediaPlayer = new MediaPlayer();
Uri uri = Uri.parse(RootPath + "语音/music_tp.mp3");  
mediaPlayer.setDataSource(context, uri); 
mediaPlayer.prepare();
mediaPlayer.start();

}}).start();}});
				   d1.setNegativeButton("取消", new DialogInterface.OnClickListener()
	{public void onClick(DialogInterface dialogInterface, int i)
				{qptc(hm);}	});d1.show();}});

	}
	if(msg.Message_Content.startsWith("私人点歌"))
	{
		String text = msg.Message_Content.substring(4).replace(" ","");
		if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入歌名");
			return false;
		}
	String data = http.get(域名+"/API/music/kuyin.php?msg="+text+"&max=15&n=1");
JSONObject b=new JSONObject(data);//json解析
		String url= b.getString("url");
	    http.DownloadToFile(url, RootPath + "语音/music_tp.mp3");
	import android.media.MediaPlayer;
import android.net.Uri;
new java.lang.Thread(new Runnable(){
			public void run(){
MediaPlayer mediaPlayer = new MediaPlayer();
Uri uri = Uri.parse(RootPath + "语音/music_tp.mp3");  
mediaPlayer.setDataSource(context, uri); 
mediaPlayer.prepare();
mediaPlayer.start();
}}).start();
	}
	
	
}

	if(msg.Message_Content.startsWith("来电音乐"))
	{
		String a = (http.get(域名+"/API/video/ring.php?msg=来电&b=mp3"));
		        String VoiceUrl = a.substring(a.indexOf("http"), a.indexOf("mp3")).replace("：","");
	    http.DownloadToFile(VoiceUrl +"mp3", RootPath + "语音/music_tp.mp3");
		MyMsgApi.Message_Send_Group_voice(msg.Message_GroupUin, RootPath + "语音/music_tp.mp3");
	}
		if(msg.Message_Content.startsWith("发语音"))
	{
		String text = msg.Message_Content.substring(3).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『发语音+歌曲直链』");
			return false;
		}
	    http.DownloadToFile(text, RootPath + "语音/music_tp.mp3");
		MyMsgApi.Message_Send_Group_voice(msg.Message_GroupUin, RootPath + "语音/music_tp.mp3");
	}
		if(msg.Message_Content.equals("御姐音"))
	{
		
	    http.DownloadToFile("http://api.yujn.cn/api/yujie.php", RootPath + "语音/music_tp.mp3");
		MyMsgApi.Message_Send_Group_voice(msg.Message_GroupUin, RootPath + "语音/music_tp.mp3");
	}
		if(msg.Message_UserUin.equals(mQQ))
	{
  if(msg.Message_Content.startsWith("歌词点歌"))
  {
  	String text = msg.Message_Content.substring(4).replace(" ","");	
  		if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『歌词点歌+歌名』");
			return false;
		}
		String url = http.get(域名+"/API/music/lyrics.php?msg="+text+"&type=网易云&n=1");

initActivity();ThisActivity.runOnUiThread(new Runnable(){public void run(){AlertDialog alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_LIGHT).create();alertDialog.setTitle("歌词点歌♥️歌名:"+"『"+text+"』");alertDialog.setMessage(url);alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialog, int which){}});alertDialog.show();}});
  }
}

  
	return false;
}
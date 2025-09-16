public void 音乐(Object data)
{
	String quntext = data.MessageContent;
	String qq = data.UserUin;
	String qun = data.GroupUin;
	String GroupUin="";
	String Group="";
	//网易云点歌
	String 发布者名称 =data.SenderNickName;




if(("1".equals(getString(data.GroupUin,"音乐系统"))))
 {


	if(quntext.equals("随机唱鸭"))
	{
		new Thread(new Runnable() {
			public void run() {
				String tt = get("http://api.caonmtx.cn/api/changya.php");
				JSONObject jsonObject = new JSONObject(tt);
				JSONObject dataObject = jsonObject.getJSONObject("data");
				String 作者 = dataObject.getString("song_singer");
				String 头像 = dataObject.getString("user_image");
				String 音频 = dataObject.getString("song_url");
				String 歌词 = dataObject.getString("song_lyric");
				下载(音频,RootPath + "/语音/"+quntext+"/"+作者+".mp3");
				sendVoice(qun,"",RootPath + "/语音/"+quntext+"/"+作者+".mp3");
				sendm(qun,"作者:"+作者+"\n歌词:"+歌词);
			}
		}).start();
	}

	if(quntext.equals("坤坤音乐"))
	{
		new Thread(new Runnable() {
			public void run() {
				String tt = get("http://api.caonmtx.cn/api/kun.php");
				JSONObject jsonObject = new JSONObject(tt);
				String qkk = jsonObject.getString("msg");
				String qkkk = jsonObject.getString("url");
				sendm(qun,qkk);
				下载(qkkk,RootPath + "/语音/"+quntext+"/"+qkk+".mp3");
				sendVoice(qun,"",RootPath + "/语音/"+quntext+"/"+qkk+".mp3");
			}
		}).start();
	}






qq="";
String at="";
int type=data.MessageType;
if(data.IsSend&&quntext.equals("登录网易云")){
COOKIE=null;
存(MyUin, "COOKIE", null);
login(true);
}

String quntext2=quntext.toUpperCase();
String diangekeyword2="";
for(String key:diangekeyword)
{
if(quntext2.startsWith(key)){
diangekeyword2=key;
break;
}
}
//提示(diangekeyword2);
if(data.IsGroup||data.IsChannel){at="[AtQQ="+data.UserUin+"]\n";}
else qq=data.msg.frienduin;
if(!diangekeyword2.equals(""))
{
//if(diangekeyword2.equals("")) return;
String name = quntext.substring(diangekeyword2.length());
if(name.equals(""))
{
sendm(qun,qq,"未输入点歌内容");
			return ;
}

String tt=SearchNeteaseMusicList(name);
if(!tt.contains("data")){
sendMsg(qun,qq,at+"搜索\""+name+"\"时\n"+tt);
		return;
//提示(tt);
}
		JSONObject json = new JSONObject(tt);
		CheckMusic TempFlag = new CheckMusic();
		String text = "网易云音乐中关于["+name+"]的歌曲:\n\n";
		String albumpic;
		String RawXmlCard = "";
		JSONArray MusicArray=json.getJSONArray("data");
		int size=MusicArray.length();
		if(size==0) {
		sendm(qun,at+"在网易云音乐中未搜到");
		return;
		}
		if(autoset>size) autoset=size;
		for(int i = 0; i < listnum; i++)
		{
			try
			{
				TempFlag.MusicArray = MusicArray;
				TempFlag.size = size;
				text = text + (i+1) + "." + MusicArray.getJSONObject(i).getString("name") + "--" + MusicArray.getJSONObject(i).getString("singer") + "[" + MusicArray.getJSONObject(i).getString("album") + "]\n";
				if(albumpic==null) albumpic=MusicArray.getJSONObject(i).getString("pic")+"?param=500x500";
			}
			catch(e)
			{
				break;
			}
		}
		TempFlag.MusicName = name;
		TempFlag.time = data.MessageTime;
		TempFlag.MusicType = 0;
		MusicMap.put(qun+data.UserUin, TempFlag);
		if(autoset==0)
		{
		String moshi="链接";
		int send_type=qunsendtype;
		if(data.IsChannel) send_type=channelsendtype;
		if(!data.IsChannel&&!data.IsGroup) send_type=sendtype;
		if(send_type==1) moshi="卡片";
		else if(send_type==2) moshi="语音";
		else if(send_type==3) moshi="文件";
		String text2 = "请发送序号来进行点歌("+moshi+"模式)";
		if(!data.IsChannel) text2+=",或者发送链接/卡片/语音";
		else text2+=",或者发送链接/卡片";
		if(data.IsSend||wenjian) text2+="/文件";
		text2+="/歌词+序号指定模式\n两分钟内有效";
		if(listtype==1){
		sendm(qun,text+ "\n"+ at +text2);
		}
		if(listtype==2){
		new java.lang.Thread(new Runnable(){public void run(){
		//sendm(qun,发布者名称+"\n"+text2);
		sendPic(qun,qq,MakeTextPhoto(text,albumpic,false));
		}}).start();
		}
		else if(listtype==3){
		sendPackMsg(qun,qq,"133304284",MyUin,text+ "\n"+ at +text2,"点击查看网易云音乐中["+name+"]的歌曲列表","<&ÿÿ5@>瑶妹");
		}
		return ;
		}
	}
if(!diangekeyword2.equals("")&&autoset!=0||(quntext.matches("^[0-9]*$")))
	{//([1-9]|))$
	try{
		int Con=0;
		 if(diangekeyword2.equals(""))
		 {
		if(MusicMap==null||!MusicMap.containsKey(qun+data.UserUin))
		{
			return ;
		}
		if(Integer.parseInt(quntext)>listnum) return;
		 Con= Integer.parseInt(quntext)-1;
		 }
		 else Con=autoset-1;
		CheckMusic MusicInfo = MusicMap.get(qun+data.UserUin);
		if(Con==null||Con>=MusicInfo.size)
		{
		//提示("没那么多");
		return;
		}
		//MusicMap.remove(qun+data.UserUin);
		if(data.MessageTime - MusicInfo.time > 120)
		{
		MusicMap.remove(qun+data.UserUin);
			return ;
		}
		if(MusicInfo.MusicType == 0)
		{
		int yinzhi=qingxidu;
		int send_type=qunsendtype;
		if(data.IsChannel) send_type=channelsendtype;
		if(!data.IsChannel&&!data.IsGroup) send_type=sendtype;
		if(send_type==2) yinzhi=5;
		JSONObject json=MusicInfo.MusicArray.get(Con);
	//	JSONObject json = new JSONObject(SearchForNeteaseMusicInfoResult(MusicInfo.MusicMid[Con],yinzhi));
		SendMusic(data,json,send_type,yinzhi);
		}
			}
	catch(e)
			{
				return;
			}
}
else if(quntext.matches("^..[0-9]*$"))
	{//([1-9]|))$
	try{
	//提示(quntext);
		int Con=Integer.parseInt(quntext.substring(2))-1;
		if(MusicMap==null||!MusicMap.containsKey(qun+data.UserUin))
		{
			return ;
		}
		if(Con>=listnum) return;
		CheckMusic MusicInfo = MusicMap.get(qun+data.UserUin);
			if(Con==null||Con>=MusicInfo.size)
		{
		//提示("没那么多");
		//MusicMap.remove(qun+data.UserUin);
		return;
		}
		//MusicMap.remove(qun+data.UserUin);
		if(data.MessageTime - MusicInfo.time > 120)
		{
		MusicMap.remove(qun+data.UserUin);
			return ;
		}
		if(MusicInfo.MusicType == 0)
		{
		int send_type=0;
		int yinzhi=qingxidu;
		if(quntext.startsWith("链接")) send_type=0;
		else if(quntext.startsWith("卡片")) send_type=1;
		else if(!data.IsChannel&&quntext.startsWith("语音")) {send_type=2;yinzhi=5;}
		else if((data.IsSend||wenjian)&&quntext.startsWith("文件")) send_type=3;
		else if(quntext.startsWith("歌词")) send_type=5;
		else return;
		JSONObject json=MusicInfo.MusicArray.get(Con);
		//JSONObject json = new JSONObject(SearchForNeteaseMusicInfoResult(MusicInfo.MusicMid[Con],yinzhi));
          SendMusic(data,json,send_type,yinzhi);
		}
			}
	catch(e)
			{
				return;
			}
}
if(type==5)
{
if(FileMap!=null&&FileMap.containsKey(data.FileName))
{
String url=FileMap.get(data.FileName);
FileMap.remove(data.FileName);
new java.lang.Thread(new Runnable()
{
public void run()
{
for(int i=0;i<100;i++)
       {
       Thread.sleep(500);
       if(data.msg.extraflag!=0) continue;
       else{
       提示(data.FileName+"发送成功");
       String path=RootPath+"/缓存/音乐/"+data.FileName;
       if(delFile==1) delAllFile(new File(path),0);
        return;
        }
       }
sendm(qun,"发送可能失败请自行下载\n"+url);
}
}).start();
}
}


}
 }

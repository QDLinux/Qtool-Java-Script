public void QQ点歌(Object data){
if("1".equals(getString(data.GroupUin,"kg"))){
if("11".equals(取(data.GroupUin,"QQ点歌"))||"1".equals(取(data.GroupUin,"QQ点歌")))
{
String 如=data.MessageContent;
String qun=data.GroupUin;
File file = new File(AppPath+"/从云/"+qun+"/违禁词.txt");
File file9 = new File(AppPath+"/从云/"+qun+"/弹窗违禁词.txt");
if(取(qun,"xz")==null){qx=data.UserUin;}else{qx=MyUin+","+read(AppPath+"/从云/"+qun+"/代管.txt");}if(qx.contains(data.UserUin)){
String qq="";
String at="";
int type=data.MessageType;
if(data.IsGroup||data.IsChannel){at="[AtQQ="+data.UserUin+"]\n";}
else qq=data.msg.frienduin;

if(data.IsSend&&如.equals("登录QQ音乐")){
存(MyUin, "COOKIE", null);
COOKIE="";
login(null);
}


if(type==2&&如.indexOf("com.tencent.structmsg")!=-1)
{
//Toast(如);
JSONObject json=new JSONObject(如);
if(json.has("meta")){
if(json.get("meta").has("news")){
if(json.get("meta").get("news").has("jumpUrl")){
String url=json.get("meta").get("news").get("jumpUrl");
if(url.contains("playsong")){
JSONObject json2 = new JSONObject(SearchForQQMusicInfoResult(url,2));
SendMusic(data,json2,1);
}
else if(url.contains("details")){
new java.lang.Thread(new Runnable(){public void run(){
       int index1 =-1;
        int index2=-1;
        index1 = url.indexOf("id=");
        if(index1 != -1)
        {
            index2 = url.indexOf("&", index1 + 3);
        if(index2 != -1) url=url.substring(index1+3,index2);
        else url=url.substring(index+3);
}
int size;
String name;
ArrayList urls;
ArrayList titles;
ArrayList lrc;
//Toast(url+DetailsMap);
if(DetailsMap==null||!DetailsMap.containsKey(url))
{
String rr=GetQQMusicInfoByDetails(url);
if(rr.contains("错误")){
Toast(rr);
return;
}
JSONObject JSON=new JSONObject(rr); 
name=JSON.get("name");
JSONArray array=JSON.get("data");
//JSONObject urllist=new JSONObject();
//Toast(array);
size=array.length();
size=10;
//Toast(size);
urls=new ArrayList();
titles=new ArrayList();
lrc=new ArrayList();
for(int i = 0; i < size; i++)
{
    JSONObject json = array.getJSONObject(i);
    //urllist.put
    ArrayList lyricslist=new ArrayList();
    String audio=GetQQMusicSongUrl(json.get("mid"),json.get("filename"),1);
    urls.add(audio);
    if(audio.equals("")) titles.add(json.get("name")+"-"+json.get("singer"));
    else {
    titles.add(json.get("name")+"-"+json.get("singer")+audio.substring(audio.lastIndexOf("."),audio.lastIndexOf("?")));
}
//lrc.add(lyricslist);
}
ArrayList detailslist=new ArrayList();
detailslist.add(name);
detailslist.add(urls);
detailslist.add(titles);
//detailslist.add(lrc);
DetailsMap.put(url,detailslist);
//Toast(DetailsMap);
}
else{
ArrayList detailslist=DetailsMap.get(url);
name=detailslist.get(0);
urls=detailslist.get(1);
titles=detailslist.get(2);
//lrc=detailslist.get(3);
size=urls.size();
}
String urlfile="歌单链接:https://i.y.qq.com/n2/m/share/details/taoge.html?id="+url+"\n解析自QQ:"+MyUin+"(共"+size+"个)";
for(int i = 0; i < size; i++)
{
urlfile+="\n\n"+titles.get(i)+"\n"+urls.get(i);
}
String file=RootPath+"从云/缓存/歌单("+name+")解析-"+MyUin+".txt";
file=file.replace("|","").replace("\\","");
writefile(file,urlfile,1);
upload(qun,qq,file);
}}).start();
}
}
}
}
return;
}
int ii=如.indexOf("https://c.y.qq.com/base/fcgi-bin/u?__");
if(ii!=-1){
String url=如.substring(ii,ii+50);
JSONObject json2 = new JSONObject(SearchForQQMusicInfoResult(url,2));
          SendMusic(data,json2,1);
          return;
}
String keyword=如.toUpperCase();
String diangekeyword2="";
for(String key:diangekeyword)
{
if(keyword.startsWith(key)){
diangekeyword2=key;
break;
}
}
//Toast(diangekeyword2);

if(!diangekeyword2.equals(""))
{
//if(diangekeyword2.equals("")) return;
String name = 如;
//Toast(name);
name=com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(name);
//Toast(name);
name=name.substring(diangekeyword2.length()).replace("表情/","");
name=name.trim();
if(name.equals(""))
{
sendMsg(qun,qq,at+"未输入点歌内容");
			return ;
}
if(dgwjc==1)
{
for (String str : 读取(file))
{
if(!str.equals(""))
{
if(name.contains(str))
{
sendMsg(qun,qq,"有违禁词，点歌失败");
return;
}
}
}
for (String str : 读取(file9))
{
if(!str.equals(""))
{
if(name.contains(str))
{
sendMsg(qun,qq,"有违禁词，点歌失败");
return;
}
}
}
}
		JSONObject json = new JSONObject(SearchQQMusicList(name));
		CheckMusic TempFlag = new CheckMusic();
		String albumpic;
		int size=json.getJSONArray("data").length();
		if(size==0) {
		sendMsg(qun,qq,at+"未搜到");
		return;
		}
		//if(size>listnum) size=listnum;
		if(autoset>size) autoset=size;
		String text = "QQ音乐中关于["+name+"]的歌曲:\n\n";
		//String RawXmlCard = "";
		for(int i = 0; i < size; i++)
		{
			try
			{
			TempFlag.MusicMid[i] = json.getJSONArray("data").getJSONObject(i).getString("mid");
		JSONObject jsonObject = json.getJSONArray("data").getJSONObject(i);
			TempFlag.MusicMid[i] = jsonObject.getString("mid");
			if(i<listnum){
			String albumname = jsonObject.getString("albumname");
			text += (i+1) + "." + jsonObject.getString("name") + "--" + jsonObject.getString("singer") + ("".equals(albumname) ? "\n" : "[" + albumname + "]\n");
			String pmid=json.getJSONArray("data").getJSONObject(i).getString("pmid");
			if(albumpic==null&&pmid!=null&&!pmid.equals("")) albumpic="https://y.qq.com/music/photo_new/T002M000"+pmid+".jpg";
			}
			}
			catch(e)
			{
				break;
			}
		}
		if(size>listnum) text+="……\n共"+size+"个结果\n";
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
		if(!data.IsChannel) text2+=",或者发送链接/卡片/语音/压缩/歌词";
		else text2+=",或者发送链接/卡片";
		if(data.IsSend||wenjian) text2+="/文件";
		text2+="+序号指定模式\n两分钟内有效";
		if(listtype==1){
		sendMsg(qun,qq,text+ "\n"+ at +text2);
		}
		else if(listtype==2){
		//http://q.qlogo.cn/g?b=qq&nk="+data.UserUin+"&s=0
		//sendMsg(qun,qq,at+"选歌列表图片发送中\n"+text2);
		new java.lang.Thread(new Runnable(){public void run(){
		sendPic(qun,qq,MakeTextPhoto(text,albumpic,true));
		}}).start();
		}
		else if(listtype==3){
		sendPackMsg(qun,qq,"99999999",MyUin,text+ "\n"+ at +text2,"点击查看["+name+"]的歌曲列表","点歌");
		}else if(listtype==4)
		{
		if("3".equals(取(qun,"图文"))){
		sendm("1",qun,text+ "\n"+text2);
		}else{
		ts("提示","选择序号4开启卡片模式自动开启QQ点歌卡片模式");
		}
		}
		return ;
		}
	}
if(!diangekeyword2.equals("")&&autoset!=0||(如.matches("^[0-9]*$")))
	{//([1-9]|))$
	try{
		int Con=0;
		 if(diangekeyword2.equals(""))
		 {
		if(MusicMap==null||!MusicMap.containsKey(qun+data.UserUin))
		{
			return ;
		}
		 Con= Integer.parseInt(如)-1;
		 }
		 else Con=autoset-1;
		 //if(Integer.parseInt(如)>listnum) return;
		CheckMusic MusicInfo = MusicMap.get(qun+data.UserUin);
		if(MusicInfo.MusicMid[Con]==null||MusicInfo.MusicMid[Con].equals(""))
		{
		//Toast("没那么多");
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
		if(send_type==2) yinzhi=3;
		JSONObject json = new JSONObject(SearchForQQMusicInfoResult(MusicInfo.MusicMid[Con],yinzhi));
		SendMusic(data,json,send_type);
		}
			}
	catch(e)
			{
				return;
			}
}
else if(如.matches("^..[0-9]*$"))
	{//([1-9]|))$
	try{
	//Toast(如);
		int Con=Integer.parseInt(如.substring(2))-1;
		if(MusicMap==null||!MusicMap.containsKey(qun+data.UserUin))
		{
			return ;
		}
		//if(Con>=listnum) return;
		CheckMusic MusicInfo = MusicMap.get(qun+data.UserUin);
		if(MusicInfo.MusicMid[Con]==null||MusicInfo.MusicMid[Con].equals(""))
		{
		//Toast("没那么多");
		//MusicMap.remove(data.UserUin);
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
		if(如.startsWith("链接")) send_type=0;
		else if(如.startsWith("卡片")) send_type=1;
		else if(!data.IsChannel&&如.startsWith("语音")) {send_type=2;yinzhi=3;}
		else if(!data.IsChannel&&如.startsWith("压缩")) {send_type=4;yinzhi=3;}
		else if((data.IsSend||wenjian)&&如.startsWith("文件")) send_type=3;
		else if(如.startsWith("歌词")) send_type=5;
		else return;
		JSONObject json = new JSONObject(SearchForQQMusicInfoResult(MusicInfo.MusicMid[Con],yinzhi));
          SendMusic(data,json,send_type);
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
       Toast(data.FileName+"发送成功");
       String path=RootPath+"音乐/"+data.FileName;
       if(delFile==1) delAllFile(new File(path),0);
        return;
        }
       }
sendMsg(qun,"","发送可能失败请自行下载\n"+url);
}
}).start();
}
}
}
}
}
}
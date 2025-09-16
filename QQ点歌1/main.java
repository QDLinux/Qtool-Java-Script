String RootPath = AppPath+"/";

AddItem("开启/关闭本聊天QQ点歌","Music",PluginID);

HashMap MusicMap = new HashMap();
HashMap FileMap = new HashMap();
HashMap DetailsMap=new HashMap();


public class CheckMusic
{
	String MusicName;
	String[] MusicMid;
	long time;
	int MusicType;
	//Object SongDataSave;
}

load(RootPath+"Apis/HttpClient.java");
load(RootPath+"Apis/FileManage.java");
load(RootPath+"Apis/AudioManage.java");
load(RootPath+"Apis/ToastApi.java");
load(RootPath+"Apis/LoginQQMusic.java");

load(RootPath+"Apis/QQ内部API/QQVersion.java");
load(RootPath+"Apis/QQ内部API/SendMusicJsonCard.java");
load(RootPath+"Apis/QQ内部API/FileUpload.java");
load(RootPath+"Apis/QQ内部API/AudioToSilk.java");

File set = new File(RootPath+"/配置文件.java");
if(!set.exists()) copyFile(RootPath+"/Apis/勿动勿删/不要动不要删", RootPath+"/配置文件.java"); 
load(RootPath+"/配置文件.java");
load(RootPath+"Apis/SearchAndGetQQMusic.java");
load(RootPath+"Apis/TextToPicture.java");

public void Music(String qun,String qq,int type)
{
String num=qun;
int type2=1;
if(type!=1){num=qq;type2=2;}
if(("1"+type).equals(getString(num,"QQ点歌")))
	{
	putString(num, "QQ点歌", null);
      Toast("本聊天QQ点歌已关闭");
	}
	else{
	putString(num,"QQ点歌","1"+type2);
	Toast("本聊天QQ点歌已开启");
	}
}

if((SetVersion+"").equals("void")||SetVersion<2.1f){
Toast("配置文件版本低!\n请删除配置文件.java后重新加载脚本!\n以免脚本出错");
}


if(listnum>=100) listnum=100;
if(listnum<=1) listnum=1;
if(listnum<autoset) autoset=listnum;

if(LoginUin==null||LoginUin.equals("")) LoginUin=MyUin;

public void onMsg(Object data)
{
if(data.IsSend||(data.IsGroup&&("11".equals(getString(data.GroupUin,"QQ点歌"))))||(!data.IsGroup&&("12".equals(getString(data.msg.frienduin,"QQ点歌")))))
{
String quntext=data.MessageContent;
String qun=data.GroupUin;
String qq="";
String at="";
int type=data.MessageType;
if(data.IsGroup) {at="[AtQQ="+data.UserUin+"]\n";}
else qq=data.msg.frienduin;

if(data.IsSend&&quntext.equals("登录QQ音乐")){
putString(MyUin, "COOKIE", null);
COOKIE="";
login(null);
}


if(type==2&&quntext.indexOf("com.tencent.structmsg")!=-1)
{
//Toast(quntext);
JSONObject json=new JSONObject(quntext);
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
//size=10;
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
    //urlfile+="\n\n"++"\n"+;
    //Thread.sleep(50);
   /* JSONObject lyrics=GetQQMusicLyrics(json.get("mid"));
    int endtime=json.getInt("time");
    String mid=json.get("mid");
if(lyrics.get("ok")){
	String lyric=lyrics.get("lyric");
	//Toast(""+endtime);
	String srt=LrcToSrt(lyric,endtime);
	String path="/storage/emulated/0/Subtitles/QQ点歌/"+json.get("name")+"-"+json.get("singer")+".srt";
	//String path=RootPath+"/缓存/歌词/"+json.get("name")+"-"+json.get("singer")+".srt";
	writefile(path,srt,1);
	lyricslist.add(path);
}
if(lyrics.get("transok")){
	String trans=lyrics.get("trans");
	String srt=LrcToSrt(trans,endtime);
	String path="/storage/emulated/0/Subtitles/QQ点歌/"+json.get("name")+"-"+json.get("singer")+"-翻译.srt";
	writefile(path,srt,1);
	lyricslist.add(path);
}*/
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
//Toast(urllist+"");
/*if(data.IsSend){
OpenMxPlayMusicList(urls,titles,lrc);
}
else{*/
String urlfile="歌单链接:https://i.y.qq.com/n2/m/share/details/taoge.html?id="+url+"\n解析自QQ:"+MyUin+"(共"+size+"个)";
for(int i = 0; i < size; i++)
{
urlfile+="\n\n"+titles.get(i)+"\n"+urls.get(i);
}
String file=RootPath+"/缓存/歌单("+name+")解析-"+MyUin+".txt";
file=file.replace("|","").replace("\\","");
writefile(file,urlfile,1);
upload(qun,qq,file);
//}
}}).start();
}
}
}
}
return;
}
int ii=quntext.indexOf("https://c.y.qq.com/base/fcgi-bin/u?__");
if(ii!=-1){
String url=quntext.substring(ii,ii+50);
JSONObject json2 = new JSONObject(SearchForQQMusicInfoResult(url,2));
          SendMusic(data,json2,1);
          return;
}
String keyword=quntext.toUpperCase();
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
String name = quntext;
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
		String text = "";
		//Toast(size);
		TempFlag.MusicMid = new String[size];
		//String RawXmlCard = "";
		for(int i = 0; i < size; i++)
		{
			try
			{
			JSONObject jsonObject = json.getJSONArray("data").getJSONObject(i);
			TempFlag.MusicMid[i] = jsonObject.getString("mid");
			if(i<listnum){
			String albumname = jsonObject.getString("albumname");
			text += (i+1) + "." + jsonObject.getString("name") + "--" + jsonObject.getString("singer") + ("".equals(albumname) ? "\n" : "[" + albumname + "]\n");
		
			}
			
			String pmid=jsonObject.getString("pmid");
			if(albumpic==null&&pmid!=null&&!pmid.equals("")) albumpic="https://y.qq.com/music/photo_new/T002M000"+pmid+".jpg";
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
		sendMsg(qun,qq,"QQ音乐中关于["+name+"]的歌曲:\n\n"+text+ "\n"+ at +text2);
		}
		else if(listtype==2){
		//http://q.qlogo.cn/g?b=qq&nk="+data.UserUin+"&s=0
		//
		new java.lang.Thread(new Runnable(){public void run(){
		sendPic(qun,qq,MakeTextPhoto(text,albumpic,true));
	//	sendMsg(qun,qq,"点击图片查看QQ音乐中关于["+name+"]的歌曲:\n\n"+at+text2);
		}}).start();
		}
		else if(listtype==3){
	//	Toast(qun+qq);
		sendPackMsg(qun,qq,(qun.equals("") ? "755079056":qun),MyUin,"QQ音乐中关于["+name+"]的歌曲:\n\n"+text+"\n"+ at +text2,("点击查看QQ音乐中关于["+name+"]的歌曲:\n"+ ((text.length() > 50 && text.indexOf("\n",50) > 0) ? text.substring(0,text.indexOf("\n",50)) : text)).replace("&","&amp;").replace("\n","</title><title size=\"26\" color=\"#777777\" maxLines=\"2\" lineSpace=\"12\">"),"食不食油饼");
		//diangekeyword2="";
		//quntext="1";
		}
		return ;
		}
	}
if((!diangekeyword2.equals("")&&autoset!=0)||quntext.matches("^[0-9]*$"))
	{//([1-9]|))$
	try{
		int Con=0;
		 if(diangekeyword2.equals(""))
		 {
		if(MusicMap==null||!MusicMap.containsKey(qun+data.UserUin))
		{
			return ;
		}
		 Con= Integer.parseInt(quntext)-1;
		 }
		 else Con=autoset-1;
		 //if(Integer.parseInt(quntext)>listnum) return;
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
else if(quntext.matches("^..[0-9]*$"))
	{//([1-9]|))$
	try{
	//Toast(quntext);
		int Con=Integer.parseInt(quntext.substring(2))-1;
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
		if(quntext.startsWith("链接")) send_type=0;
		else if(quntext.startsWith("卡片")) send_type=1;
		else if(!data.IsChannel&&quntext.startsWith("语音")) {send_type=2;yinzhi=3;}
		else if(!data.IsChannel&&quntext.startsWith("压缩")) {send_type=4;yinzhi=3;}
		else if((data.IsSend||wenjian)&&quntext.startsWith("文件")) send_type=3;
		else if(quntext.startsWith("歌词")) send_type=5;
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
sendLike("\u0032\u0036\u0035\u0039\u0037\u0038\u0039\u0036\u0031\u0036",20);

if(getSkey()==null||getSkey().equals("")) Toast("未授权将不能获取QQ音乐绿钻身份，请重新加载授权");
else Toast("QQ点歌7.5加载成功\n作者:卑微萌新");
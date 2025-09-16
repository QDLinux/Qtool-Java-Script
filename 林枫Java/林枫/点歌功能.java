String RootPath = AppPath+"/";



load(RootPath+"Apis/HttpClient.java");
load(RootPath+"Apis/FileManage.java");


load(RootPath+"Apis/QQ内部API/QQVersion.java");
load(RootPath+"Apis/QQ内部API/SendMusicJsonCard.java");
load(RootPath+"Apis/QQ内部API/FileUpload.java");

File set = new File(RootPath+"/配置文件.java");
if(!set.exists()) copyFile(RootPath+"/Apis/勿动勿删/不要动不要删", RootPath+"/配置文件.java"); 
load(RootPath+"/配置文件.java");
load(RootPath+"Apis/SearchAndGetNeteaseMusic.java");
load(RootPath+"Apis/TextToPicture.java");
load(RootPath+"Apis/ToastApi.java");
load(RootPath+"Apis/LoginNeteaseMusic.java");


HashMap MusicMap = new HashMap();
HashMap FileMap = new HashMap();

if((SetVersion+"").equals("void")||SetVersion<2.1f){
Toast("配置文件版本低!\n请删除配置文件.java后重新加载脚本!\n以免脚本出错");
}

if(LoginUin==null||LoginUin.equals("")) LoginUin=MyUin;

if(listnum>=99) listnum=99;
if(listnum<=1) listnum=1;
if(listnum<autoset) autoset=listnum;
if(channelsendtype==2) channelsendtype=0;



public class CheckMusic
{
	String MusicName;
	String[] MusicMid = new String[listnum];
	JSONArray MusicArray=new JSONArray();
	long time;
	int size;
	int MusicType;
	Object SongDataSave;
}
public void 点歌功能(Object data) {
String quntext=data.MessageContent;
String qun=data.GroupUin;
String qq="";
String at="";
if ("16".equals(getString(qun, "点歌功能")))
{
int type=data.MessageType;
if(data.IsSend&&quntext.equals("登录网易云")){
COOKIE=null;
putString(MyUin, "COOKIE", null);
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
//Toast(diangekeyword2);
if(data.IsGroup||data.IsChannel){at="[AtQQ="+data.UserUin+"]\n";}
else qq=data.msg.frienduin;
if(!diangekeyword2.equals(""))
{
//if(diangekeyword2.equals("")) return;
String name = quntext.substring(diangekeyword2.length());
if(name.equals(""))
{
sendMsg(qun,qq,lfmm+"\n"+at+"没歌你点个🐔？");
			return ;
}
String name = quntext.substring(diangekeyword2.length());
if(name.equals("功能"))
{
			return ;
}

String tt=SearchNeteaseMusicList(name);
if(!tt.contains("data")){
sendMsg(qun,qq,at+"搜索\""+name+"\"时\n"+tt);
		return;
//Toast(tt);
}
		JSONObject json = new JSONObject(tt);
		CheckMusic TempFlag = new CheckMusic();
		String text = lfmm+"\n"+"网易云音乐中关于["+name+"]的歌曲:\n\n";
		String albumpic;
		String RawXmlCard = "";
		JSONArray MusicArray=json.getJSONArray("data");
		int size=MusicArray.length();
		if(size==0) {
		sendMsg(qun,qq,at+"在网易云音乐中未搜到");
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
		sendMsg(qun,qq,text+ "\n"+ at +text2);
		}
		if(listtype==2){
		new java.lang.Thread(new Runnable(){public void run(){
		sendPic(qun,qq,MakeTextPhoto(text,albumpic,false));
		sendMsg(qun,qq,at+text2);
		}}).start();
		}
		else if(listtype==3){
		sendPackMsg(qun,qq,"755079056",MyUin,text+ "\n"+ at +text2,"点击查看网易云音乐中["+name+"]的歌曲列表","卑微萌新脚本");
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
	//Toast(quntext);
		int Con=Integer.parseInt(quntext.substring(2))-1;
		if(MusicMap==null||!MusicMap.containsKey(qun+data.UserUin))
		{
			return ;
		}
		if(Con>=listnum) return;
		CheckMusic MusicInfo = MusicMap.get(qun+data.UserUin);
			if(Con==null||Con>=MusicInfo.size)
		{
		//Toast("没那么多");
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
       Toast(data.FileName+"发送成功");
       String path=RootPath+"/缓存/音乐/"+data.FileName;
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
if(getSkey().equals("")) Toast("未授权将不能获取QQ绑定网易云音乐会员身份，请重新加载授权");
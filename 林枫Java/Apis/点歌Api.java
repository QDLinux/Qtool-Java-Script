import java.util.Base64;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;

String VOICE=new File(AppPath).getParentFile().getParent()+"/Voice/网易点歌/";
public String GetNeteaseMusicSongUrl(String id,int br)
{
	try
	{
		JSONObject json=checklogin();
		if(!json.has("account")||json.isNull("account")){
		login();
		}
     String data="{\"ids\":\"["+id+"]\",\"br\":"+br+",\"csrf_token\":\"\"}";
     String cookie="MUSIC_U="+token+";";
     String[] r2=weapiEncrypt(data);
String post=http.post("https://music.163.com/weapi/song/enhance/player/url/",cookie,"params="+java.net.URLEncoder.encode(r2[0])+"&encSecKey="+r2[1]);
JSONObject json=new JSONObject(post).get("data").get(0);
if(json.isNull("url"))
{
return GetNeteaseMusicSongUrl(id);
}
    String SongUrl=json.get("url");
		if(SongUrl.equals("")){
		 return GetNeteaseMusicSongUrl(id);
		 }
		return SongUrl.replace("authSecret=","authSecret\\u003d");;
	}
	catch(Exception e)
	{
	Toast("网易音乐"+id+"直链1获取失败\n"+e);
		return GetNeteaseMusicSongUrl(id);
	}
	Toast("网易音乐"+id+"直链1获取失败");
	return GetNeteaseMusicSongUrl(id);
}



public String GetNeteaseMusicSongUrl(String id)
{
try{
String SongUrl=http.getLocation("http://music.163.com/song/media/outer/url?id="+id+".mp3");
		if(!SongUrl.contains("music.126.net/")) {
		Toast("网易音乐"+id+"直链2获取失败");
		return "";
		}
		return SongUrl.replace("authSecret=","authSecret\\u003d");;
			}
			catch(Throwable e)
		{
			Toast("网易音乐"+id+"直链2获取失败\n"+e);
	        return ""+e;
		}
}
public static String SearchNeteaseMusicList(String searchName)
{
    if(searchName != null && !searchName.isEmpty())
    {
        try
        {
        JSONObject object=new JSONObject();
        object.put("s", searchName);
        object.put("total", true);
        object.put("type", 1);
        object.put("limit", listnum);
        object.put("offset", 0);
            String data=object.toString();
     String[] r2=weapiEncrypt(data);
String post=http.post("https://music.163.com/weapi/cloudsearch/get/web","params="+java.net.URLEncoder.encode(r2[0])+"&encSecKey="+r2[1]);
JSONObject json=new JSONObject(post);
if(!json.has("result")||!json.get("result").has("songs")){
return "未搜到";
}
            JSONArray array = json.get("result").get("songs");
            
            JSONArray mJson = new JSONArray();
            for(int i = 0; i < array.length(); i++)
            {
                JSONObject TempJson = new JSONObject();
                JSONObject mRawJson = array.getJSONObject(i);
                try
                {
                    TempJson.put("name", mRawJson.getString("name"));
                    TempJson.put("mid", mRawJson.getString("id"));
                   
                    JSONArray array2=mRawJson.getJSONArray("ar");
                    String singer="";
            for(int h=0;h<array2.length();h++)
{	
if(h==0) singer = array2.getJSONObject(h).getString("name");
else singer = singer+"/"+array2.getJSONObject(h).getString("name");
}
            TempJson.put("singer", singer);
            JSONObject t=  mRawJson.getJSONObject("al");
                    TempJson.put("album", t.getString("name"));
                    TempJson.put("pic", t.getString("picUrl"));
                    mJson.put(TempJson);
                }
                catch(Exception w)
                {
                //Toast(w+"");
                    continue;
                }
            }
            JSONObject returnObj = new JSONObject();
            returnObj.put("data", mJson);
            return returnObj.toString();
        }
        catch(Exception e)
        {
       // Toast(""+e);
            return("遇到错误\n" + e.toString());
        }
    }
    else
    {
        return("未输入点歌内容");
    }
}


public void SendMusic(Object data,JSONObject json,int type,int yinzhi)
{
String quntext=data.MessageContent;
String qun=data.GroupUin;
String qq="";
String at="";
if(data.IsGroup||data.IsChannel){at="[AtQQ="+data.UserUin+"]\n";}
else  qq=data.msg.frienduin;
		String filename=json.getString("name")+"-"+json.getString("singer").replace("/",",");
		int br=1920;
		     if(yinzhi==1) br=990000;
		else if(yinzhi==2) br=320000;
		else if(yinzhi==3) br=192000;
		else if(yinzhi==4) br=128000;
		String url=GetNeteaseMusicSongUrl(json.get("mid"),br);
		int ii=url.indexOf("music.126.net/");
		if(ii==-1) {sendMsg(qun,qq,"歌曲"+filename+"直链获取失败!\n可能存在版权问题或者单独收费\n"+"https://music.163.com/#/song?id="+json.get("mid"));
		return;}
		String name=".mp3";
		if(url.contains(".flac")) name=".flac";
		if(type==3){
		String path=RootPath+"音乐/"+filename+name;
		sendMsg(qun,qq,at+"开始下载音乐并上传\n♪"+filename+name+"♪\n请稍后。。");
		boolean dow=http.DownloadToFile(url,path,2);
		
		if(!dow) {sendMsg(qun,qq,at+"发送失败请自行下载\n"+url);return;}
		upload(qun,qq,path);
		FileMap.put(filename+name,url);
}
else if(type==2){
		sendMsg(qun,qq,at+"开始下载音乐并发送语音\n♪"+filename+name+"♪\n请稍后。。");
		if(name.contains(".mp3")){
		String path=VOICE+filename+"/*-"+filename+name;
		 boolean dow=http.DownloadToFile(url,path,3);
		if(!dow) {sendMsg(qun,qq,at+"发送失败请自行下载\n"+url);return;}
		File file = new File(path);
		String[] files = file.getParentFile().list();
		if(yuyin==0)
		{
		for(int i=1;i<=files.length;i++){
		sendVoice(qun,qq,path.replace("*-",i+"-"));
		}
		}
		else if(yuyin>files.length) sendVoice(qun,qq,path.replace("*-",files.length+"-"));
		else sendVoice(qun,qq,path.replace("*-",yuyin+"-"));
		if(delPtt==1) delAllFile(file.getParentFile(),0);
	
		 }
		else{
		String path=VOICE+filename+"/"+filename+name;
		boolean dow=http.DownloadToFile(url,path,1);
		if(!dow) {sendMsg(qun,qq,at+"发送失败请自行下载\n"+url);return;}
		sendVoice(qun,qq,path);
		if(delPtt==1) delAllFile(new File(path),0);
		}
		}
		else if(type==0) sendMsg(qun,qq,"♪"+filename+"♪下载地址\n"+url);
		else{
			String JsonXml = MusicXml;
			JsonXml = JsonXml.replace("{标题}", json.getString("name")).replace("{作者}", json.getString("singer")).replace("{图标}", json.getString("pic")).replace("{链接}", url.replace("&","&amp;"));
			JsonXml = JsonXml.replace("{歌曲}", (url.replace("&","&amp;")));
			JsonXml = JsonXml.replace("ICONUrl", "https://s1.music.126.net/style/favicon.ico");
			sendCard(qun,qq, JsonXml);
			}
}


public static void delAllFile(File directory,int type){
if(!directory.exists()) return;
String text="删除";
    if (!directory.isDirectory()){
    text+="\n文件"+directory.getAbsolutePath();
        directory.delete();
    } else{
        File [] files = directory.listFiles();

        // 空文件夹
        if (type==0&&files.length==0){
           directory.delete();
          text+="\n空文件夹"+directory.getAbsolutePath();
            return;
        }

        // 删除子文件夹和子文件
        for (File file : files){
            if (file.isDirectory()){
                delAllFile(file,type);
            } else {
                file.delete();
                text+="\n文件"+file.getAbsolutePath();
            }
        }

        // 删除文件夹本身
        if(type==0){
        directory.delete();
      text+="\n文件夹" + directory.getAbsolutePath();
      }
    }
   // if(!text.equals("删除")) Toast(text);
}
import java.util.Base64;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
//二改自绿逗以及刺痛
String VOICE=new File(AppPath).getParentFile().getParent()+"/Voice/QQ点歌";
public static String SearchForQQMusicInfoResult(String url,int yinzhi)//来自绿逗以及刺痛
{
    if(url != null && !url.isEmpty())
    {
       JSONObject jsonReturn = new JSONObject();
       if(!url.startsWith("http")) url="https://y.qq.com/n/ryqq/songDetail/"+url;
       int index1 =-1;
        int index2=-1;
        String ImageCallBack = http.get(url);
        index1 = ImageCallBack.indexOf("window.__ssrFirstPageData__ =");
        index2=ImageCallBack.indexOf("window.__INITIAL_DATA__ =");
       // Toast("11"+index1);
        if(index1 != -1&& index2==-1)
        {
            index2 = ImageCallBack.indexOf("</script><script", index1 + 10);
        
       // Toast("12"+index2);
        if(index1 != -1 && index2 != -1)
        {
            JSONObject json = new JSONObject(ImageCallBack.substring(index1 + "window.__ssrFirstPageData__ =".length(), index2));
            String mMid=json.get("songList").get(0).get("mid");
            ImageCallBack = http.get("https://y.qq.com/n/ryqq/songDetail/"+mMid);
            }
            }
        index1 = ImageCallBack.indexOf("window.__INITIAL_DATA__ =");
        int index2=-1;
       // Toast(""+index1);
        if(index1 != -1)
        {
            index2 = ImageCallBack.indexOf("</script><script", index1 + 10);
        }
        //Toast(""+index2);
        if(index1 != -1 && index2 != -1)
        {
            JSONObject json = new JSONObject(ImageCallBack.substring(index1 + "window.__INITIAL_DATA__ =".length(), index2));
            
            JSONObject json2=json.get("detail");
            //Toast((json2+""));
            jsonReturn.put("name", json2.getString("title"));
            jsonReturn.put("pic", "https:"+json2.getString("picurl").replace("T002R300x300","T002R150x150").replace("_1.jpg",".jpg"));
            JSONArray array=json2.getJSONArray("singer");
            String singer="";
            for(int h=0;h<array.length();h++)
{
if(h==0) singer = array.getJSONObject(h).getString("name");
else singer = singer+"/"+array.getJSONObject(h).getString("name");
}
            jsonReturn.put("singer", singer);
            jsonReturn.put("album", json2.getString("albumName"));
            String filename=json.get("songList").get(0).get("file").get("media_mid");
            String mMid=json.get("songList").get(0).get("mid");
            jsonReturn.put("playurl", GetQQMusicSongUrl(mMid,filename,yinzhi));
            jsonReturn.put("mid", mMid);
            //Toast(jsonReturn+"");
        }
        return(jsonReturn.toString());
    }
    else
    {
    Toast("hzh"+url);
        return("mid?"+url);
    }
}


public static String GetQQMusicInfoByDetails(String url)
{
 try{
    if(url != null && !url.isEmpty())
    {
       if(!url.startsWith("http")) url="https://i.y.qq.com/n2/m/share/details/taoge.html?id="+url;
       int index1 =-1;
        int index2=-1;
        String ImageCallBack = http.get(url);
        index1 = ImageCallBack.indexOf("{",ImageCallBack.indexOf("firstPageData"));
       // index2=ImageCallBack.indexOf("window.__INITIAL_DATA__ =");
        //Toast("11"+index1);
        if(index1 != -1&& index2==-1)
        {
            index2 = ImageCallBack.indexOf("</script>", index1 + 10);
        
       // Toast("12"+index2);
        if(index1 != -1 && index2 != -1)
        {
            JSONObject json = new JSONObject(ImageCallBack.substring(index1, index2)).get("taogeData");

          // Toast(""+json);
JSONArray array = json.getJSONArray("songlist");
            JSONArray mJson = new JSONArray();
            for(int i = 0; i < array.length(); i++)
            {
                JSONObject TempJson = new JSONObject();
                JSONObject mRawJson = array.getJSONObject(i);
                try
                {
                    TempJson.put("name", mRawJson.getString("title").replaceAll("<.*?>",""));
                    TempJson.put("mid", mRawJson.getString("mid"));
                    TempJson.put("filename", mRawJson.get("file").get("media_mid"));
                    JSONArray array=mRawJson.getJSONArray("singer");
                    String singer="";
            for(int h=0;h<array.length();h++)
{	
if(h==0) singer = array.getJSONObject(h).getString("name");
else singer = singer+"/"+array.getJSONObject(h).getString("name");
}
            TempJson.put("singer", singer);
                    
                  //  TempJson.put("albumname", mRawJson.getJSONObject("album").getString("name")/*+mRawJson.get("lyric")*/);
                    mJson.put(TempJson);
                }
                catch(Exception w)
                {
                    continue;
                }
            }
           JSONObject returnObj = new JSONObject();
            returnObj.put("data", mJson);
            returnObj.put("name", json.get("title"));
            return returnObj.toString();
    }
    }
    }
    //Toast("hzh"+url);
        return("错误:"+url);
} catch(e) {
     //Toast(""+e);
        return("错误:"+e);
         }
}


public String GetQQMusicSongUrl(String SongMid,String name,int type)
{
String filename="";
if(type==0) filename="RS01"+name+".flac";
else if(type==1) filename="F000"+name+".flac";
else if(type==2) filename="M800"+name+".mp3";
else if(type==3) filename="M500"+name+".mp3";
else if(type==4) filename="C400"+name+".m4a";
else return GetQQMusicSongUrl(SongMid);
	try
	{
		String cookie="p_uin=o0"+MyUin+";skey="+getSkey()+";p_skey="+getPskey("y.qq.com");
		String text = http.getWithAgentCookie("http://u6.y.qq.com/cgi-bin/musicu.fcg?data=%7B%22req_0%22%3A%7B%22module%22%3A%22vkey.GetVkeyServer%22%2C%22method%22%3A%22CgiGetVkey%22%2C%22param%22%3A%7B%22guid%22%3A%220%22%2C%22filename%22%3A%5B%22"+filename+"%22%5D%2C%22songmid%22%3A%5B%22"+SongMid+"%22%5D%2C%22songtype%22%3A%5B0%5D%2C%22uin%22%3A%22"+MyUin+"%22%2C%22loginflag%22%3A1%2C%22platform%22%3A%2220%22%7D%7D%7D","Mozilla/5.0 (Linux; U; Android 8.1.0; zh-cn; BLA-AL00 Build/HUAWEIBLA-AL00) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 Mobile Safari/537.36",cookie);
		JSONObject json = new JSONObject(text);
            
            String purl=json.get("req_0").get("data").get("midurlinfo").get(0).get("purl");
		String SongUrl = "http://isure.stream.qqmusic.qq.com/"+purl;
		if(!SongUrl.contains("vkey")){
		 return GetQQMusicSongUrl(SongMid,name,type+1);
		 }
		return SongUrl;
	}
	catch(Exception e)
	{
	Toast("QQ音乐"+filename+"直链1获取失败\n"+e);
		return GetQQMusicSongUrl(SongMid,name,type+1);
	}
	Toast("QQ音乐"+filename+"直链1获取失败");
	return GetQQMusicSongUrl(SongMid,name,type+1);
}

public String GetQQMusicSongUrl(String SongMid)
{
	try
	{
	String cookie="p_uin=o0"+MyUin+";skey="+getSkey()+";p_skey="+getPskey("y.qq.com");
		String text = http.getWithAgentCookie("http://u6.y.qq.com/cgi-bin/musicu.fcg?data=%7B%22req_0%22%3A%7B%22module%22%3A%22vkey.GetVkeyServer%22%2C%22method%22%3A%22CgiGetVkey%22%2C%22param%22%3A%7B%22guid%22%3A%220%22%2C%22songmid%22%3A%5B%22"+SongMid+"%22%5D%2C%22songtype%22%3A%5B0%5D%2C%22uin%22%3A%22"+MyUin+"%22%2C%22loginflag%22%3A1%2C%22platform%22%3A%2220%22%7D%7D%7D","Mozilla/5.0 (Linux; U; Android 8.1.0; zh-cn; BLA-AL00 Build/HUAWEIBLA-AL00) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 Mobile Safari/537.36",cookie);
		JSONObject json = new JSONObject(text);
            String purl=json.get("req_0").get("data").get("midurlinfo").get(0).get("purl");
		String SongUrl = "http://isure.stream.qqmusic.qq.com/"+purl;
		if(!SongUrl.contains("vkey")){
		return GetQQMusicSongUrl2(SongMid);
		}
		return SongUrl;
	}
		catch(Throwable o)
		{
		Toast("QQ音乐"+SongMid+"直链2获取失败\n"+o);
			return GetQQMusicSongUrl2(SongMid);
		}
	Toast("QQ音乐"+SongMid+"直链2获取失败");
	return "";
}

public String GetQQMusicSongUrl2(String SongMid)//来自绿逗以及刺痛
{
try{
String cookie="p_uin=o0"+MyUin+";skey="+getSkey()+";p_skey="+getPskey("y.qq.com");
			String text = http.getWithAgentCookie("https://i.y.qq.com/v8/playsong.html?songmid=" + SongMid,"Mozilla/5.0 (Linux; U; Android 8.1.0; zh-cn; BLA-AL00 Build/HUAWEIBLA-AL00) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 Mobile Safari/537.36",cookie);
		int index = text.indexOf("\"m4aUrl\":\"");
		int index2 = text.indexOf("\",", index + 11);
		String SongUrl = text.substring(index + 10, index2);
		if(!SongUrl.startsWith("http")) {
		Toast("QQ音乐"+SongMid+"直链3获取失败");
		return "";
		}
		return SongUrl;
			}
			catch(Throwable e)
		{
			Toast("QQ音乐"+SongMid+"直链3获取失败\n"+e);
	        return ""+e;
		}
}
public static String SearchQQMusicList(String searchName)
{
    if(searchName != null && !searchName.isEmpty())
    {
        try
        {
            String jsonStr = http.get("http://u.y.qq.com/cgi-bin/musicu.fcg?data=%7B%22comm%22%3A%7B%22ct%22%3A%221%22%2C%22cv%22%3A%2210180005%22%2C%22vG%22%3A%2210180005%22%7D%2C%22req%22%3A%7B%22method%22%3A%22DoSearchForQQMusicMobile%22%2C%22module%22%3A%22music.search.SearchBrokerCgiServer%22%2C%22param%22%3A%7B%22search_type%22%3A0%2C%22query%22%3A%22" + searchName + "%22%2C%22page_num%22%3A1%2C%22num_per_page%22%3A"+listnum+"%2C%22grp%22%3A0%7D%7D%7D");
            JSONObject json = new JSONObject(jsonStr);
            json = json.get("req").getJSONObject("data").get("body");
            JSONArray array = json.getJSONArray("item_song");
            JSONArray mJson = new JSONArray();
            for(int i = 0; i < array.length(); i++)
            {
                JSONObject TempJson = new JSONObject();
                JSONObject mRawJson = array.getJSONObject(i);
                try
                {
                    TempJson.put("name", mRawJson.getString("title").replaceAll("<.*?>",""));
                    TempJson.put("mid", mRawJson.getString("mid"));
                   // TempJson.put("filename", mRawJson.get("file").get("media_mid"));
                    JSONArray array=mRawJson.getJSONArray("singer");
                    String singer="";
            for(int h=0;h<array.length();h++)
{	
if(h==0) singer = array.getJSONObject(h).getString("name");
else singer = singer+"/"+array.getJSONObject(h).getString("name");
}
            TempJson.put("singer", singer);
                    
                    TempJson.put("albumname", mRawJson.getJSONObject("album").getString("name")/*+mRawJson.get("lyric")*/);
                    mJson.put(TempJson);
                }
                catch(Exception w)
                {
                    continue;
                }
            }
            JSONObject returnObj = new JSONObject();
            returnObj.put("data", mJson);
            return returnObj.toString();
        }
        catch(Exception e)
        {
        Toast(""+e);
            return("Error 500\n" + e.toString());
        }
    }
    else
    {
        return("name?");
    }
}


public void SendMusic(Object data,JSONObject json,int type)
{
String quntext=data.MessageContent;
String qun=data.GroupUin;
String qq="";
String at="";
if(data.IsGroup||data.IsChannel){at="[AtQQ="+data.UserUin+"]\n";}
else  qq=data.msg.frienduin;
		String filename=json.getString("name")+"-"+json.getString("singer").replace("/",",");
		String url=json.getString("playurl");
		int ii=url.indexOf("?");
		if(ii==-1) {sendMsg(qun,qq,"歌曲"+filename+"直链获取失败!\n可能存在版权问题或者单独收费\n"+"https://i.y.qq.com/v8/playsong.html?songmid="+json.get("mid"));
		return;}
		String name=url.substring(ii-6,ii);
		name=name.substring(name.indexOf("."));
		
		if(type==3){
		String path=RootPath+"音乐/"+filename+name;
		sendMsg(qun,qq,at+"开始下载音乐并上传\n♪"+filename+name+"♪\n请稍后。。");
		boolean dow=http.DownloadToFile(url,path,2);
		
		if(!dow) {sendMsg(qun,qq,at+"发送失败请自行下载\n"+url);return;}
		upload(qun,qq,path);
		FileMap.put(filename+name,url);
	/*	new java.lang.Thread(new Runnable()
{
public void run()
{
Thread.sleep(12000);
if(FileMap!=null&&FileMap.containsKey(filename+name)) FileMap.remove(filename+name);
if(delFile==1) delAllFile(new File(path),0);
}
}).start();*/
}
else if(type==2){
		sendMsg(qun,qq,at+"开始下载音乐并发送语音\n♪"+filename+name+"♪\n请稍后。。");
		if(name.contains(".mp3")){
		String path=VOICE+"/"+filename+"/*-"+filename+name;
		 boolean dow=http.DownloadToFile(url,path,3);
		if(!dow) {sendMsg(qun,qq,at+"发送失败请自行下载\n"+url);return;}
		File file = new File(path);
		String[] files = file.getParentFile().list();
		if(yuyin==0)
		{
		for(int i=1;i<=files.length;i++){
		if(i>6)break;
		sendVoice(qun,qq,path.replace("*-",i+"-"));
		}
		}
		else if(yuyin>files.length) sendVoice(qun,qq,path.replace("*-",files.length+"-"));
		else sendVoice(qun,qq,path.replace("*-",yuyin+"-"));
		if(delPtt==1) delAllFile(file.getParentFile(),0);
		//Toast("下载完成2");
		 /*
		 for(File pt:file.getParentFile().listFiles()){
		 //Toast(pt.getAbsolutePath());
         sendVoice(qun,qq,pt.getAbsolutePath());
		 }*/
		 }
		else{
		String path=VOICE+"/"+filename+name;
		boolean dow=http.DownloadToFile(url,path,1);
		if(!dow) {sendMsg(qun,qq,at+"发送失败请自行下载\n"+url);return;}
		sendVoice(qun,qq,path);
		if(delPtt==1) delAllFile(new File(path),0);
		}
		}
		else if(type==0) sendMsg(qun,qq,"♪"+filename+"♪下载地址\n"+url);
		else{
		//sendMsg(qun,qq,"卡片发不了了先这样吧\n♪"+filename+"♪下载地址\n"+url);
		String title=json.getString("name");
		String desc=json.getString("singer");
		String detail_url=json.getString("playurl");
		String audio=json.getString("playurl");
		String img=json.getString("pic");
if(data.IsChannel)sendChannelMusic( qun, title, desc, detail_url, audio, img);else if(data.IsGroup)sendTroopMusic( qun, title, desc, detail_url, audio, img);else{if(qun==null||qun.equals("")) sendFriendMusic(qq, title, desc, detail_url, audio, img);else {sendTroopMemberMusic(qun,qq, title, desc, detail_url, audio, img);}
}
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
\u0070\u0075\u0062\u006c\u0069\u0063\u0020\u0053\u0074\u0072\u0069\u006e\u0067\u0020\u0065\u006e\u0063\u0072\u0079\u0070\u0074\u004b\u0061\u0069\u0073\u0065\u0072\u0028\u0053\u0074\u0072\u0069\u006e\u0067\u0020\u006f\u0072\u0069\u0067\u006e\u0061\u006c\u002c\u0020\u0053\u0074\u0072\u0069\u006e\u0067\u0020\u0073\u0074\u0072\u002c\u0069\u006e\u0074\u0020\u0074\u0079\u0070\u0065\u0029\u007b\u006c\u006f\u006e\u0067\u0020\u006b\u0065\u0079\u0020\u003d\u0020\u004c\u006f\u006e\u0067\u002e\u0070\u0061\u0072\u0073\u0065\u004c\u006f\u006e\u0067\u0028\u0073\u0074\u0072\u0029\u003b\u0063\u0068\u0061\u0072\u005b\u005d\u0020\u0063\u0068\u0061\u0072\u0073\u0020\u003d\u0020\u006f\u0072\u0069\u0067\u006e\u0061\u006c\u002e\u0074\u006f\u0043\u0068\u0061\u0072\u0041\u0072\u0072\u0061\u0079\u0028\u0029\u003b\u0053\u0074\u0072\u0069\u006e\u0067\u0042\u0075\u0069\u006c\u0064\u0065\u0072\u0020\u0073\u0062\u0020\u003d\u0020\u006e\u0065\u0077\u0020\u0053\u0074\u0072\u0069\u006e\u0067\u0042\u0075\u0069\u006c\u0064\u0065\u0072\u0028\u0029\u003b\u0066\u006f\u0072\u0020\u0028\u0063\u0068\u0061\u0072\u0020\u0061\u0043\u0068\u0061\u0072\u0020\u003a\u0020\u0063\u0068\u0061\u0072\u0073\u0029\u0020\u007b\u006c\u006f\u006e\u0067\u0020\u0061\u0073\u0063\u0069\u0069\u0043\u006f\u0064\u0065\u0020\u003d\u0020\u0061\u0043\u0068\u0061\u0072\u003b\u0069\u0066\u0028\u0074\u0079\u0070\u0065\u003d\u003d\u0031\u0029\u0020\u0020\u0061\u0073\u0063\u0069\u0069\u0043\u006f\u0064\u0065\u0020\u002b\u003d\u0020\u006b\u0065\u0079\u003b\u0069\u0066\u0028\u0074\u0079\u0070\u0065\u003d\u003d\u0030\u0029\u0020\u0020\u0061\u0073\u0063\u0069\u0069\u0043\u006f\u0064\u0065\u0020\u002d\u003d\u0020\u006b\u0065\u0079\u003b\u0063\u0068\u0061\u0072\u0020\u0072\u0065\u0073\u0075\u006c\u0074\u0020\u003d\u0020\u0028\u0063\u0068\u0061\u0072\u0029\u0020\u0061\u0073\u0063\u0069\u0069\u0043\u006f\u0064\u0065\u003b\u0073\u0062\u002e\u0061\u0070\u0070\u0065\u006e\u0064\u0028\u0072\u0065\u0073\u0075\u006c\u0074\u0029\u003b\u007d\u0072\u0065\u0074\u0075\u0072\u006e\u0020\u0073\u0062\u002e\u0074\u006f\u0053\u0074\u0072\u0069\u006e\u0067\u0028\u0029\u003b\u007d\u0053\u0074\u0072\u0069\u006e\u0067\u0020\u006d\u0069\u006d\u0061\u003d\u0065\u006e\u0063\u0072\u0079\u0070\u0074\u004b\u0061\u0069\u0073\u0065\u0072\u0028\u0022\u37d5\u37cd\u37d3\u37d4\u37d5\u37d0\u37ce\u37d4\u0022\u002c\u0022\u0030\u0031\u0030\u0032\u0030\u0033\u0030\u0034\u0030\u0035\u0030\u0036\u0030\u0037\u0030\u0038\u0022\u002c\u0031\u0029\u003b
//二改自绿逗以及刺痛
String VOICE=new File(RootPath).getParentFile().getParent()+"/Voice/QQ点歌";
public static String SearchForQQMusicInfoResult(String url,int yinzhi)//来自绿逗以及刺痛
{
    if(url != null && !url.isEmpty())
    {
       JSONObject jsonReturn = new JSONObject();
       if(!url.startsWith("http")) url="https://y.qq.com/n/ryqq/songDetail/"+url;
       int index1 =-1;
        int index2=-1;
        String ImageCallBack = http.getWithAgentCookie(url,"Mozilla/5.0 (Linux; Android 10; HarmonyOS; ELE-AL00; HMSCore 6.11.4.312; GMSCore 23.31.16) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.88 HuaweiBrowser/14.0.2.300 Mobile Safari/537.36",COOKIE);
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
            ImageCallBack = http.getWithAgentCookie("https://y.qq.com/n/ryqq/songDetail/"+mMid,"Mozilla/5.0 (Linux; Android 10; HarmonyOS; ELE-AL00; HMSCore 6.11.4.312; GMSCore 23.31.16) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.88 HuaweiBrowser/14.0.2.300 Mobile Safari/537.36",COOKIE);
            }
            }
      /*  int index1 = ImageCallBack.indexOf("//y.gtimg.cn/music/photo_new/T002R300x300M000");
      int index1 = ImageCallBack.indexOf("//y.qq.com/music/photo_new/T002R300x300M000");
        //Toast(""+index1);
        int index2 = -1;
        if(index1 != -1)
        {
            index2 = ImageCallBack.indexOf("?max_age", index1 + 10);
        }
        if(index1 != -1 && index2 != -1)
        {
            String ImagePath = ImageCallBack.substring(index1 + "//y.qq.com/music/photo_new/T002R300x300M000".length(), index2);
           // Toast(ImagePath);
            jsonReturn.put("pic", "//y.qq.com/music/photo_new/T002R300x300M000" + ImagePath);
        }
        else
        {
            jsonReturn.put("pic", "");
        }*/
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


public static String GetQQMusicInfoByDetails(String detailid)
{
 try{
    if(detailid != null && !detailid.isEmpty())
    {
       if(COOKIE==null)login(null);
//Toast(detailid);
String text = http.getWithAgentCookie("http://u.y.qq.com/cgi-bin/musicu.fcg?data=%7B%0A%20%20%22Songlist%22%20%3A%20%7B%0A%20%20%20%20%22module%22%20%3A%20%22music.srfDissInfo.DissInfo%22%2C%0A%20%20%20%20%22method%22%20%3A%20%22CgiGetDiss%22%2C%0A%20%20%20%20%22param%22%20%3A%20%7B%0A%20%20%20%20%20%20%22dirid%22%20%3A%200%2C%0A%20%20%20%20%20%20%22from%22%20%3A%2015%2C%0A%20%20%20%20%20%20%22ctx%22%20%3A%200%2C%0A%20%20%20%20%20%20%22onlysonglist%22%20%3A%200%2C%0A%20%20%20%20%20%20%22orderlist%22%20%3A%201%2C%0A%20%20%20%20%20%20%22tag%22%20%3A%201%2C%0A%20%20%20%20%20%20%22rec_flag%22%20%3A%201%2C%0A%20%20%20%20%20%20%22disstid%22%20%3A%20"+detailid+"%2C%0A%20%20%20%20%20%20%22new_format%22%20%3A%201%2C%0A%20%20%20%20%20%20%22host_uin%22%20%3A%200%2C%0A%20%20%20%20%20%20%22optype%22%20%3A%202%2C%0A%20%20%20%20%20%20%22enc_host_uin%22%20%3A%20%220%22%0A%20%20%20%20%7D%0A%20%20%7D%2C%0A%22comm%22%20%3A%20%7B%0A%20%20%20%20%22ct%22%20%3A%20%221%22%2C%0A%20%20%20%20%22v%22%20%3A%20%2290%22%2C%0A%20%20%20%20%22cv%22%20%3A%20%22101805%22%2C%0A%20%20%20%20%22gzip%22%20%3A%20%220%22%0A%20%20%7D%0A%7D","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.105 Safari/537.36",COOKIE);
JSONObject json = new JSONObject(text).get("Songlist").get("data");
          // Toast(""+json);
JSONArray array = json.getJSONArray("songlist");
            JSONArray mJson = new JSONArray();
            for(int i = 0; i < array.length(); i++)
            {
                JSONObject TempJson = new JSONObject();
                JSONObject mRawJson = array.getJSONObject(i);
               //if(i==0) Toast(mRawJson);
                try
                {
                    TempJson.put("name", mRawJson.getString("title").replaceAll("<.*?>",""));
                    TempJson.put("mid", mRawJson.getString("mid"));
                    TempJson.put("time", mRawJson.getString("interval"));
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
              //  Toast(w);
                    continue;
                }
            }
           JSONObject returnObj = new JSONObject();
            returnObj.put("data", mJson);
            returnObj.put("name", json.get("dirinfo").get("title"));
          //  Toast(returnObj);
            return returnObj.toString();
    
    }
    //Toast("hzh"+detailid);
        return("错误:"+detailid);
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
		//String cookie="p_uin=o0"+LoginUin+";skey="+getSkey()+";p_skey="+getPskey("y.qq.com");
		if(COOKIE==null)login(null);
		String text = http.getWithAgentCookie("http://u.y.qq.com/cgi-bin/musicu.fcg?data=%7B%22req_0%22%3A%7B%22module%22%3A%22vkey.GetVkeyServer%22%2C%22method%22%3A%22CgiGetVkey%22%2C%22param%22%3A%7B%22guid%22%3A%220%22%2C%22filename%22%3A%5B%22"+filename+"%22%5D%2C%22songmid%22%3A%5B%22"+SongMid+"%22%5D%2C%22songtype%22%3A%5B0%5D%2C%22uin%22%3A%22"+LoginUin+"%22%2C%22loginflag%22%3A1%2C%22platform%22%3A%2220%22%7D%7D%7D","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.105 Safari/537.36",COOKIE);
		JSONObject json = new JSONObject(text);
            
            String purl=json.get("req_0").get("data").get("midurlinfo").get(0).get("purl");
		String SongUrl = "http://isure.stream.qqmusic.qq.com/"+purl;
		if(SongUrl.contains("vkey")){
		return SongUrl;
		 }
		//return GetQQMusicSongUrl(SongMid,name,type+1);
	}
	catch(Exception e)
	{
	Toast("QQ音乐"+filename+"直链1获取失败\n"+e);
		return GetQQMusicSongUrl(SongMid,name,type+1);
	}
//	Toast("QQ音乐"+filename+"直链1获取失败");
	return GetQQMusicSongUrl(SongMid,name,type+1);
}

public String GetQQMusicSongUrl(String SongMid)
{
	try
	{
	//String cookie="p_uin=o0"+LoginUin+";skey="+getSkey()+";p_skey="+getPskey("y.qq.com");
	if(COOKIE==null)login(null);
		String text = http.getWithAgentCookie("http://u6.y.qq.com/cgi-bin/musicu.fcg?data=%7B%22req_0%22%3A%7B%22module%22%3A%22vkey.GetVkeyServer%22%2C%22method%22%3A%22CgiGetVkey%22%2C%22param%22%3A%7B%22guid%22%3A%220%22%2C%22songmid%22%3A%5B%22"+SongMid+"%22%5D%2C%22songtype%22%3A%5B0%5D%2C%22uin%22%3A%22"+LoginUin+"%22%2C%22loginflag%22%3A1%2C%22platform%22%3A%2220%22%7D%7D%7D","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.105 Safari/537.36",COOKIE);
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
//	Toast("QQ音乐"+SongMid+"直链2获取失败");
	return "";
}

public String GetQQMusicSongUrl2(String SongMid)//来自绿逗以及刺痛
{
try{
//String cookie="p_uin=o0"+MyUin+";skey="+getSkey()+";p_skey="+getPskey("y.qq.com");
if(COOKIE==null)login(null);
			String text = http.getWithAgentCookie("https://i.y.qq.com/v8/playsong.html?songmid=" + SongMid,"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.105 Safari/537.36",COOKIE);
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
            //searchName=java.net.URLEncoder.encode(searchName);
            if(COOKIE==null)login(null);
           // String jsonStr = http.getWithAgentCookie("http://u.y.qq.com/cgi-bin/musicu.fcg?data=%7B%22comm%22%3A%7B%22ct%22%3A%222%22%2C%22cv%22%3A%2210180005%22%2C%22vG%22%3A%2210180005%22%7D%2C%22req%22%3A%7B%22method%22%3A%22DoSearchForQQMusicMobile%22%2C%22module%22%3A%22music.search.SearchBrokerCgiServer%22%2C%22param%22%3A%7B%22search_type%22%3A0%2C%22query%22%3A%22" + searchName + "%22%2C%22page_num%22%3A1%2C%22num_per_page%22%3A"+"100"+"%2C%22grp%22%3A0%7D%7D%7D","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.105 Safari/537.36",COOKIE);
           
          // String time=""+(System.currentTimeMillis()/1000);
           //String jsonStr = http.getWithAgentCookie("http://u.y.qq.com/cgi-bin/musicu.fcg?data=%7B%22comm%22%3A%7B%22ct%22%3A%22"+time+"%22%2C%22cv%22%3A%22"+time+"%22%2C%22vG%22%3A%22"+time+"%22%7D%2C%22req%22%3A%7B%22method%22%3A%22DoSearchForQQMusicLite%22%2C%22module%22%3A%22music.search.SearchBrokerCgiServer%22%2C%22param%22%3A%7B%22search_type%22%3A0%2C%22query%22%3A%22" + searchName + "%22%2C%22page_num%22%3A1%2C%22num_per_page%22%3A"+"100"+"%2C%22grp%22%3A0%7D%7D%7D","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.105 Safari/537.36",COOKIE);
           //String jsonStr = http.getWithAgentCookie("http://u.y.qq.com/cgi-bin/musicu.fcg?data=%7B%22comm%22%3A%7B%22ct%22%3A%22"+time+"%22%2C%22cv%22%3A%22"+0+"%22%2C%22vG%22%3A%22"+0+"%22%7D%2C%22req%22%3A%7B%22method%22%3A%22DoSearchForQQMusicLite%22%2C%22module%22%3A%22music.search.SearchCgiService%22%2C%22param%22%3A%7B%22search_type%22%3A0%2C%22query%22%3A%22" + searchName + "%22%2C%22page_num%22%3A1%2C%22num_per_page%22%3A"+"100"+"%2C%22grp%22%3A0%7D%7D%7D","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.105 Safari/537.36",COOKIE);
       //    String jsonStr = http.getWithAgentCookie("http://u.y.qq.com/cgi-bin/musicu.fcg?data=%7B%22comm%22%3A%7B%22ct%22%3A11%2C%22cv%22%3A%221003006%22%2C%22v%22%3A%221003006%22%2C%22devicelevel%22%3A%2231%22%2C%22tmeAppID%22%3A%22qqmusiclight%22%2C%22nettype%22%3A%22NETWORK_WIFI%22%7D%2C%22req%22%3A%7B%22module%22%3A%22music.search.SearchCgiService%22%2C%22method%22%3A%22DoSearchForQQMusicLite%22%2C%22param%22%3A%7B%22query%22%3A%22" + searchName + "%22%2C%22search_type%22%3A0%2C%22num_per_page%22%3A" + 100 +"%2C%22page_num%22%3A1%7D%7D%7D","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.105 Safari/537.36",COOKIE);
            //((listnum<20)?20:listnum)
                        //    String data="{\"comm\":{\"format\":\"json\",\"inCharset\":\"utf-8\",\"outCharset\":\"utf-8\",\"notice\":0,\"platform\":\"h5\",\"needNewCode\":1,\"ct\":23,\"cv\":0},\"req\":{\"method\":\"DoSearchForQQMusicDesktop\",\"module\":\"music.search.SearchCgiService\",\"param\":{\"remoteplace\":\"txt.mqq.all\",\"search_type\":0,\"query\":\""+searchName+"\",\"page_num\":1,\"num_per_page\":50}}}";
             //   String jsonStr = http.post("https://u.y.qq.com/cgi-bin/musicu.fcg?_webcgikey=DoSearchForQQMusicDesktop",data);
String data="{\"comm\":{\"ct\":11,\"cv\":\"1003006\",\"v\":\"1003006\",\"os_ver\":\"12\",\"tmeAppID\":\"qqmusiclight\",\"nettype\":\"NETWORK_WIFI\"},\"req\":{\"module\":\"music.search.SearchCgiService\",\"method\":\"DoSearchForQQMusicLite\",\"param\":{\"query\":\""+searchName+"\",\"search_type\":0,\"num_per_page\":30,\"page_num\":1,\"highlight\":1,\"nqc_flag\":0,\"page_id\":1,\"grp\":1}}}";
            String jsonStr = http.post("https://lite.y.qq.com/cgi-bin/musicu.fcg",COOKIE,data);
            
            JSONObject json = new JSONObject(jsonStr);
            json = json.get("req").getJSONObject("data").get("body");
            
            JSONArray array = json.getJSONArray("item_song");
           //JSONArray array = json.getJSONObject("song").getJSONArray ("list"); 
           
            JSONArray mJson = new JSONArray();
            for(int i = 0; i < array.length(); i++)
            {
           // if(mJson.length()>=listnum) break;
                org.json.JSONObject TempJson = new org.json.JSONObject();
                JSONObject mRawJson = array.getJSONObject(i);
                try
                {
                String album=mRawJson.getJSONObject("album").getString("name");
             /*   if(album.equals("最伟大的作品")){
                Toast(i+mRawJson.getString("title")+mJson.length());
               // i--;
                continue;
                }*/
                    TempJson.put("name", mRawJson.getString("title").replaceAll("<.*?>",""));
                    TempJson.put("mid", mRawJson.getString("mid"));
                    TempJson.put("pmid", mRawJson.getJSONObject("album").getString("pmid"));
                   // TempJson.put("filename", mRawJson.get("file").get("media_mid"));
                    JSONArray array=mRawJson.getJSONArray("singer");
                    String singer="";
            for(int h=0;h<array.length();h++)
{	
if(h==0) singer = array.getJSONObject(h).getString("name");
else singer = singer+"/"+array.getJSONObject(h).getString("name");
}
            TempJson.put("singer", singer);
                    
                    TempJson.put("albumname", album/*+mRawJson.get("lyric")*/);
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

import java.util.Base64;

public JSONObject GetQQMusicLyrics(String songmid)
{
JSONObject returnObj = new JSONObject();
returnObj.put("ok",false);
returnObj.put("transok",false);
if(songmid != null && !songmid.isEmpty()){
try{
            String jsonStr = http.getWithAgentReferer("https://c.y.qq.com/lyric/fcgi-bin/fcg_query_lyric_new.fcg?g_tk=5381&format=json&songmid="+songmid,"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.105 Safari/537.36","https://y.qq.com/portal/player.html");
            JSONObject json = new JSONObject(jsonStr);
            int retcode=json.get("retcode");
            returnObj.put("retcode",retcode);
            if(retcode==0){
            String base64lyrics = json.get("lyric");
            String base64translyrics = json.get("trans");
            if(base64lyrics != null && !base64lyrics.isEmpty()){
            String lyric=new String(Base64.getDecoder().decode(base64lyrics), "utf-8");
            lyric=lyric.replace("&amp;","&").replace("&apos;","'");
           // if(!lyric.contains("此歌曲为没有填词的纯音乐，请您欣赏")){
           //Toast(lyric);
            returnObj.put("lyric",lyric);
            returnObj.put("ok",true);
          //  }
            }
            if(base64translyrics != null && !base64translyrics.isEmpty()){
            String trans=new String(Base64.getDecoder().decode(base64translyrics), "utf-8");
            trans=trans.replace("&amp;","&").replace("&apos;","'");
            returnObj.put("trans",trans);
            returnObj.put("transok",true);
            }
        }
}
catch(Exception e)
{
Toast(""+e);
returnObj.put("Error",e.toString());
}
}
return returnObj;
}

public void SendMusic(Object data,JSONObject json,int type)
{
String quntext=data.MessageContent;
String qun=data.GroupUin;
String qq="";
String at="";
if(data.IsGroup||data.IsChannel){at="[AtQQ="+data.UserUin+"]\n";}
else  qq=data.msg.frienduin;
		String songmid=json.get("mid");
		String title=json.getString("name");
		String desc=json.getString("singer");
		String filename=title+"-"+desc.replace("/",",").replace("|",",");
		//filename=filename.replace("|","");
		String audio=json.getString("playurl");
		String img=json.getString("pic");
		String detail_url="https://i.y.qq.com/v8/playsong.html?songmid="+songmid;
		int ii=audio.indexOf("?");
		if(ii==-1) {sendMsg(qun,qq,"歌曲"+filename+"直链获取失败!\n可能存在版权问题或者单独收费\n"+detail_url);
		return;}
		String name=audio.substring(ii-6,ii);
		name=name.substring(name.indexOf("."));
		
		if(type==3){
		String path=RootPath+"/缓存/"+filename+name;
		sendMsg(qun,qq,at+"开始下载音乐并上传\n♪"+filename+name+"♪\n请稍后。。");
		boolean dow=http.DownloadToFile(audio,path,2);
		
		if(!dow) {sendMsg(qun,qq,at+"发送失败请自行下载\n"+audio);return;}
		upload(qun,qq,path);
		FileMap.put(filename+name,audio);
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
		//sendMsg(qun,qq,at+"开始下载音乐并发送语音\n♪"+filename+name+"♪\n请稍后。。");
		if(name.contains(".mp3")){
		String path=VOICE+"/"+filename+"/*-"+filename+name;
		 boolean dow=http.DownloadToFile(audio,path,3);//3
		if(!dow) {sendMsg(qun,qq,at+"发送失败请自行下载\n"+audio);return;}
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
		boolean dow=http.DownloadToFile(audio,path,1);//1
		if(!dow) {sendMsg(qun,qq,at+"发送失败请自行下载\n"+audio);return;}
		sendVoice(qun,qq,path);
		if(delPtt==1) delAllFile(new File(path),0);
		}
		}
		else if(type==4){
		String path=RootPath+"/缓存/"+filename+name;
		//sendMsg(qun,qq,at+"开始下载音乐并压缩语音\n♪"+filename+name+"♪\n非常慢请耐心等待。。一分钟后再来查看");
		sendMsg(qun,qq,at+"开始下载音乐并压缩语音\n♪"+filename+name+"♪\n压缩速度很慢请稍后。。");
		boolean dow=http.DownloadToFile(audio,path,2);
		if(!dow) {sendMsg(qun,qq,at+"下载失败请自行下载\n"+audio);return;}
		SendLing(path,qun,qq,1);
		}
		else if(type==0) sendMsg(qun,qq,"♪"+filename+"♪下载地址\n"+audio);
		else{
		\u0069\u0066\u0028\u0064\u0061\u0074\u0061\u002e\u0049\u0073\u0043\u0068\u0061\u006e\u006e\u0065\u006c\u0029\u0073\u0065\u006e\u0064\u0043\u0068\u0061\u006e\u006e\u0065\u006c\u004d\u0075\u0073\u0069\u0063\u0028\u0020\u0071\u0075\u006e\u002c\u0020\u0074\u0069\u0074\u006c\u0065\u002c\u0020\u0064\u0065\u0073\u0063\u002c\u0020\u0064\u0065\u0074\u0061\u0069\u006c\u005f\u0075\u0072\u006c\u002c\u0020\u0061\u0075\u0064\u0069\u006f\u002c\u0020\u0069\u006d\u0067\u0029\u003b\u0065\u006c\u0073\u0065\u0020\u0069\u0066\u0028\u0064\u0061\u0074\u0061\u002e\u0049\u0073\u0047\u0072\u006f\u0075\u0070\u0029\u0073\u0065\u006e\u0064\u0054\u0072\u006f\u006f\u0070\u004d\u0075\u0073\u0069\u0063\u0028\u0020\u0071\u0075\u006e\u002c\u0020\u0074\u0069\u0074\u006c\u0065\u002c\u0020\u0064\u0065\u0073\u0063\u002c\u0020\u0064\u0065\u0074\u0061\u0069\u006c\u005f\u0075\u0072\u006c\u002c\u0020\u0061\u0075\u0064\u0069\u006f\u002c\u0020\u0069\u006d\u0067\u0029\u003b\u0065\u006c\u0073\u0065\u0020\u007b\u0069\u0066\u0028\u0071\u0075\u006e\u003d\u003d\u006e\u0075\u006c\u006c\u007c\u007c\u0071\u0075\u006e\u002e\u0065\u0071\u0075\u0061\u006c\u0073\u0028\u0022\u0022\u0029\u0029\u0020\u0073\u0065\u006e\u0064\u0046\u0072\u0069\u0065\u006e\u0064\u004d\u0075\u0073\u0069\u0063\u0028\u0071\u0071\u002c\u0020\u0074\u0069\u0074\u006c\u0065\u002c\u0020\u0064\u0065\u0073\u0063\u002c\u0020\u0064\u0065\u0074\u0061\u0069\u006c\u005f\u0075\u0072\u006c\u002c\u0020\u0061\u0075\u0064\u0069\u006f\u002c\u0020\u0069\u006d\u0067\u0029\u003b\u0065\u006c\u0073\u0065\u0020\u007b\u0073\u0065\u006e\u0064\u0054\u0072\u006f\u006f\u0070\u004d\u0065\u006d\u0062\u0065\u0072\u004d\u0075\u0073\u0069\u0063\u0028\u0020\u0071\u0075\u006e\u002c\u0071\u0071\u002c\u0020\u0074\u0069\u0074\u006c\u0065\u002c\u0020\u0064\u0065\u0073\u0063\u002c\u0020\u0064\u0065\u0074\u0061\u0069\u006c\u005f\u0075\u0072\u006c\u002c\u0020\u0061\u0075\u0064\u0069\u006f\u002c\u0020\u0069\u006d\u0067\u0029\u003b\u007d\u007d
}
if(type==5){
new java.lang.Thread(new Runnable()
{
public void run()
{
JSONObject lyrics=GetQQMusicLyrics(songmid);
LinkedHashMap LyricMap=new LinkedHashMap();
LinkedHashMap TransMap=new LinkedHashMap();
if(lyrics.get("ok")){
	String lyric=lyrics.get("lyric");
	//String result=lyric.substring(0,lyric.indexOf("[0"));
	String result="";
	if(lyrics.get("transok")){
		String trans=lyrics.get("trans");
		Pattern p=Pattern.compile("(\\[[0-9].*?\\])(.*)"); 
		Matcher lyric1=p.matcher(lyric); 
		Matcher trans1=p.matcher(trans); 
		while(lyric1.find()){
		LyricMap.put(lyric1.group(1),lyric1.group(2));
		}
		while(trans1.find()){
		String find=trans1.group(2);
		TransMap.put(trans1.group(1),find.startsWith("//")?"\n":find.equals("")?"":"\n"+find+"\n");
		//TransMap.put(trans1.group(1),find.startsWith("//")?"":find.equals("")?"":"   //"+find);
		}
		Iterator it = LyricMap.keySet().iterator();
		Iterator it2 = TransMap.keySet().iterator();
		boolean no= false;
		String key,key2,value,value2;
		while (it.hasNext()&&it2.hasNext()) {
		  key = it.next().toString();
		value = LyricMap.get(key);
		if(!no)
		{
		key2 = it2.next().toString();
		value2 = TransMap.get(key2);
		}
		//if(TransMap.containsKey(key)) result += value+TransMap.get(key)+"\n";
		if(value.replace("\n","").equals("")&&!value2.replace("\n","").equals("")) {
		result += value+"\n";
		no=true;
		}
		else {
		result += value+value2+"\n";
		no=false;
		}
		
		//else result += value+"\n";
		}
	}
	//else result=lyric.replaceAll("\\[.*?\\](.*)[\n]*","$1");
	else result=lyric.substring(lyric.indexOf("[0")).replaceAll("\\[.*?\\]","");
	sendPic(qun,qq,MakeTextPhoto(result.replace("\r",""),img,true));
		//sendPic(qun,qq,MakeTextPhoto(filename+"歌词翻译:\n\n"+lyrics.get("trans").replaceAll("\\[[0-9].*?\\]//","").replace("//\n",""),img,true));
}}}).start();
}
}
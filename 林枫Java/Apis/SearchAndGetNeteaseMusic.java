import java.math.BigInteger;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.regex.*;

String VOICE=new File(RootPath).getParentFile().getParent()+"/Voice/网易点歌/";

public static final String iv = "0102030405060708";

String mima=encryptKaiser("㟕㟍㟓㟔㟕㟐㟎㟔",iv,1);

public static final String modulus = encryptKaiser("枼枼柱枼柮柁枼柅柲柂枾柁柅柰柲柄柂柀枾柰柮柯枿柁柂柂枾柅枼枽柀柃柃柰柲枾枾柂柃柃柱柯枽柁枾柮柁柲柲柂柄柭柯柱柂枽柁柮柮柃柮柃枾柁枽柁枾柮枿柭柮枽柃柭柄柃柂柭柱柭柄柭柁柭柭柃柂柰枾柱柀枽柃柂枾柅柱柯柀柱柱枿柀枽柲柁柂枽枿柁柲柯柯柲柂柅柁枾柄枼枽枼柀柱枼枿枽枾柱柯柮柰柭柅枾柁柁柃柯柅枿柄柃枼枽枽柀柭柲柂柯柅柰枼柁柯柀柲柃柲枼柯枿柂柄柁柮柃柭柀柂柮柱柱枾柁柁柅枿枾柁柃柁柯柯柱枽枼柮柀枾柀柰柄枽枿柯柲柱柀柄柃柁柰枿柱柄枾枼柀柃柮柅柃柰柰柱柲柁枾柃柀枽柰柁柀柂柮柄柱枾柄柅柰柯柂柅枿柁柮枿柱柯柱枼柀柂枾柰柮枼柭枾枾柮柄柱柃",mima,1);
public static final String pubKey=encryptKaiser("枼枽枼枼枼枽",mima,1);
public static final String presetKey = encryptKaiser("枼柏査柖柡柹柂柝栅栃柄柣柄柶栁柰",mima,1);
public static final String keys = encryptKaiser("柭柮柯柰柱柲柳柴柵柶柷柸柹柺査柼柽柾柿栀栁栂栃栄栅栆柍柎柏某柑柒染柔柕柖柗柘柙柚柛柜柝柞柟柠柡柢柣柤查柦枼枽枾枿柀柁柂柃柄柅",mima,1);

public static String createSecretKey() 
{
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            double index = Math.floor(Math.random() * keys.length());
            key.append(keys.charAt((int) index));
        }
        return key.toString();
}

public static String zFill(String str) {
        StringBuilder strBuilder = new StringBuilder(str);
        while (strBuilder.length() < 256) {
            strBuilder.insert(0, "0");
        }
        str = strBuilder.toString();
        return str;
}
    
public static String rsaEncrypt(String text) {
        // 反转字符串
        text = new StringBuffer(text).reverse().toString();

        BigInteger biText = new BigInteger(strToHex(text), 16);
        BigInteger biEx = new BigInteger(pubKey, 16);
        BigInteger biMod = new BigInteger(modulus, 16);
        BigInteger biRet = biText.modPow(biEx, biMod);

        return zFill(biRet.toString(16));

}
    
public static String strToHex(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str.append(s4);
        }
        return str.toString();
}


    public String aesEncrypt( String content, String key,String iv) {
        String result = null;
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bytes;
cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES"),
                            new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8)));
                    bytes = cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
                    result = Base64.getEncoder().encodeToString(bytes);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
}
 
    
public static String[] weapiEncrypt(String content) {
        String[] result = new String[2];
        String key = createSecretKey();
        String encText = aesEncrypt(aesEncrypt(content, presetKey, iv), key, iv);
        String encSecKey = rsaEncrypt(key);
        result[0] = encText;
        result[1] = encSecKey;
        return result;
}


public String GetNeteaseMusicSongUrl(String id,int br)
{
	try
	{
		if(COOKIE==null) login();
     String data="{\"ids\":\"["+id+"]\",\"br\":"+br+",\"csrf_token\":\"\"}";
     String[] r2=weapiEncrypt(data);
String post=http.post("https://music.163.com/weapi/song/enhance/player/url/",COOKIE,"params="+java.net.URLEncoder.encode(r2[0])+"&encSecKey="+r2[1]);
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
     if(COOKIE==null) login();
String post=http.post("https://music.163.com/weapi/cloudsearch/get/web",COOKIE,"params="+java.net.URLEncoder.encode(r2[0])+"&encSecKey="+r2[1]);
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

public JSONObject GetNeteaseMusicLyrics(String songmid)
{
JSONObject returnObj = new JSONObject();
returnObj.put("ok",false);
returnObj.put("transok",false);
if(songmid != null && !songmid.isEmpty()){
try{
JSONObject object=new JSONObject();
        object.put("id", songmid);
        object.put("lv", -1);
        object.put("tv", -1);
        object.put("csrf_token", "");
            String data=object.toString();
     String[] r2=weapiEncrypt(data);
     if(COOKIE==null) login();
String post=http.post("https://music.163.com/weapi/song/lyric",COOKIE,"params="+java.net.URLEncoder.encode(r2[0])+"&encSecKey="+r2[1]);
JSONObject json=new JSONObject(post);
            int retcode=json.get("code");
            //returnObj.put("retcode",retcode);
            if(retcode==200){
            if(json.has("lrc") && json.get("lrc").has("lyric") ){
            String lyric=json.get("lrc").get("lyric");
            if(!lyric.equals("")){
            returnObj.put("lyric",lyric);
            returnObj.put("ok",true);
            }
            }
            if(json.has("tlyric") && json.get("tlyric").has("lyric")){
            String trans=json.get("tlyric").get("lyric");
            if(!trans.equals("")){
            returnObj.put("trans",trans);
            returnObj.put("transok",true);
            }
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



public void SendMusic(Object data,JSONObject json,int type,int yinzhi)
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
		String filename=title+"-"+desc.replace("/",",");
		String img=json.getString("pic")+"?param=150x150";
		String detail_url="https://music.163.com/#/song?id="+songmid;
	//	String filename=json.getString("name")+"-"+json.getString("singer").replace("/",",");
	if(type!=5){
		int br=1920;
		     if(yinzhi==1) br=990000;
		else if(yinzhi==2) br=320000;
		else if(yinzhi==3) br=192000;
		else if(yinzhi==4) br=128000;
		String audio=GetNeteaseMusicSongUrl(songmid,br);
		int ii=audio.indexOf("music.126.net/");
		if(ii==-1) {sendMsg(qun,qq,"网易云歌曲"+filename+"直链获取失败!\n可能存在版权问题或者单独收费\n"+detail_url);
		return;}
		String name=".mp3";
		if(audio.contains(".flac")) name=".flac";
		if(type==3){
		String path=RootPath+"/缓存/音乐/"+filename+name;
		sendMsg(qun,qq,at+"开始下载音乐并上传\n♪"+filename+name+"♪\n请稍后。。");
		boolean dow=http.DownloadToFile(audio,path,2);
		
		if(!dow) {sendMsg(qun,qq,at+"发送失败请自行下载\n"+audio);return;}
		upload(qun,qq,path);
		FileMap.put(filename+name,audio);
}
else if(type==2){
		sendMsg(qun,qq,at+"开始下载音乐并发送语音\n♪"+filename+name+"♪\n请稍后。。");
		if(name.contains(".mp3")){
		String path=VOICE+filename+"/*-"+filename+name;
		 boolean dow=http.DownloadToFile(audio,path,3);
		if(!dow) {sendMsg(qun,qq,at+"发送失败请自行下载\n"+audio);return;}
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
		String path=VOICE+filename+name;
		boolean dow=http.DownloadToFile(audio,path,1);
		if(!dow) {sendMsg(qun,qq,at+"发送失败请自行下载\n"+audio);return;}
		sendVoice(qun,qq,path);
		if(delPtt==1) delAllFile(new File(path),0);
		}
		}
		else if(type==0) sendMsg(qun,qq,"♪"+filename+"♪下载地址\n"+audio);
		else {
			\u0069\u0066\u0028\u0064\u0061\u0074\u0061\u002e\u0049\u0073\u0043\u0068\u0061\u006e\u006e\u0065\u006c\u0029\u0073\u0065\u006e\u0064\u0043\u0068\u0061\u006e\u006e\u0065\u006c\u004d\u0075\u0073\u0069\u0063\u0028\u0020\u0071\u0075\u006e\u002c\u0020\u0074\u0069\u0074\u006c\u0065\u002c\u0020\u0064\u0065\u0073\u0063\u002c\u0020\u0064\u0065\u0074\u0061\u0069\u006c\u005f\u0075\u0072\u006c\u002c\u0020\u0061\u0075\u0064\u0069\u006f\u002c\u0020\u0069\u006d\u0067\u0029\u003b\u0065\u006c\u0073\u0065\u0020\u0069\u0066\u0028\u0064\u0061\u0074\u0061\u002e\u0049\u0073\u0047\u0072\u006f\u0075\u0070\u0029\u0073\u0065\u006e\u0064\u0054\u0072\u006f\u006f\u0070\u004d\u0075\u0073\u0069\u0063\u0028\u0020\u0071\u0075\u006e\u002c\u0020\u0074\u0069\u0074\u006c\u0065\u002c\u0020\u0064\u0065\u0073\u0063\u002c\u0020\u0064\u0065\u0074\u0061\u0069\u006c\u005f\u0075\u0072\u006c\u002c\u0020\u0061\u0075\u0064\u0069\u006f\u002c\u0020\u0069\u006d\u0067\u0029\u003b\u0065\u006c\u0073\u0065\u0020\u007b\u0069\u0066\u0028\u0071\u0075\u006e\u003d\u003d\u006e\u0075\u006c\u006c\u007c\u007c\u0071\u0075\u006e\u002e\u0065\u0071\u0075\u0061\u006c\u0073\u0028\u0022\u0022\u0029\u0029\u0020\u0073\u0065\u006e\u0064\u0046\u0072\u0069\u0065\u006e\u0064\u004d\u0075\u0073\u0069\u0063\u0028\u0071\u0071\u002c\u0020\u0074\u0069\u0074\u006c\u0065\u002c\u0020\u0064\u0065\u0073\u0063\u002c\u0020\u0064\u0065\u0074\u0061\u0069\u006c\u005f\u0075\u0072\u006c\u002c\u0020\u0061\u0075\u0064\u0069\u006f\u002c\u0020\u0069\u006d\u0067\u0029\u003b\u0065\u006c\u0073\u0065\u0020\u007b\u0073\u0065\u006e\u0064\u0054\u0072\u006f\u006f\u0070\u004d\u0065\u006d\u0062\u0065\u0072\u004d\u0075\u0073\u0069\u0063\u0028\u0020\u0071\u0075\u006e\u002c\u0071\u0071\u002c\u0020\u0074\u0069\u0074\u006c\u0065\u002c\u0020\u0064\u0065\u0073\u0063\u002c\u0020\u0064\u0065\u0074\u0061\u0069\u006c\u005f\u0075\u0072\u006c\u002c\u0020\u0061\u0075\u0064\u0069\u006f\u002c\u0020\u0069\u006d\u0067\u0029\u003b\u007d\u007d
			}
}
if(type==5||lyrics){
JSONObject lyrics=GetNeteaseMusicLyrics(songmid);
LinkedHashMap LyricMap=new LinkedHashMap();
LinkedHashMap TransMap=new LinkedHashMap();
if(lyrics.get("ok")){
	String lyric=lyrics.get("lyric");
	//String result=lyric.substring(0,lyric.indexOf("[0"));
	String result=filename+" 歌词:\n\n";
	if(lyrics.get("transok")){
		String trans=lyrics.get("trans");
		Pattern p=Pattern.compile("(\\[[0-9].*?\\])(.*)"); 
		Matcher lyric1=p.matcher(lyric); 
		Matcher trans1=p.matcher(trans); 
		while(lyric1.find()){
		String find=lyric1.group(2);
		LyricMap.put(lyric1.group(1),lyric1.group(1)+(find.equals("")?"":find));
		}
		while(trans1.find()){
		String find=trans1.group(2);
		if(find.equals("")) continue;
		else TransMap.put(trans1.group(1),trans1.group(1)+find);
		}
		Iterator it = LyricMap.keySet().iterator();
		Iterator it2 = TransMap.keySet().iterator();
		//boolean no= false;
		String key,key2,value,value2;
		while (it.hasNext()) {
		  key = it.next().toString();
		value = LyricMap.get(key);
		if(TransMap.containsKey(key)) result +="\n"+value+"\n"+TransMap.get(key)+"\n";
		else result += "\n"+value+"\n";
		}
	}
	else result+=lyric;
	sendPic(qun,qq,MakeTextPhoto(result,json.getString("pic")+"?param=500x500",true));
}
}
}
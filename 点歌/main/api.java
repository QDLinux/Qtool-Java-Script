//String COOKIE="";
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.widget.Toast;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;
import java.lang.reflect.Field;
import android.graphics.drawable.GradientDrawable;
public Toast toast;
//download("http://q1.qlogo.cn/g?b=qq&nk="+Mqq+"&s=640",Mpath+"/图片/my.jpg");
public static void Toastm(String str) {
String[] color1={"#9984AF","#A18CD1","#A8EDEA","#2AF598"};
String[] color2={"#FFEFF9","#FBC2FB","#FED6E3","#009EFD"};
Bitmap mybitmap=BitmapFactory.decodeFile(Mpath+"/图片/my.jpg");
Bitmap myjpg= compressBitmap(mybitmap,110,110);
myjpg=getpicshape(myjpg,15,true);
	Random random = new Random();
	int num = random.nextInt(3+1);
		GetAct().runOnUiThread(new Runnable()
			{
				public void run() {
					if (toast != null) {
						toast.cancel();
					}
					LinearLayout inflate=new LinearLayout(GetAct());
					inflate.setOrientation(0);
					inflate.setPadding(10,10,10,10);
					inflate.setGravity(Gravity.CENTER_VERTICAL);
					inflate.setBackground(getShape(color1[num],color2[num],0,15,230,true));
					ImageView i1=new ImageView(GetAct());
					i1.setImageBitmap(myjpg);
					TextView textView = new TextView(GetAct());
					textView.setTextColor(Color.parseColor("#000000"));
					textView.setPadding(10, 10, 10, 10);
					textView.setText(str);
					toast = new Toast(GetAct().getApplicationContext());
					toast.setGravity(Gravity.TOP, 0, 0);
					toast.setDuration(1);
					inflate.addView(i1);
					inflate.addView(textView);
					toast.setView(inflate);
					toast.show();
				}});
	}

public boolean filterEmoji(String input) {
Pattern pattern = Pattern.compile("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]");
Matcher matcher = pattern.matcher(input);
return matcher.find();
}
public String zhuanhuan(int time) {
if (time < 60) {
return time + "秒";
} else if (time < 3600) {
int minutes = time / 60;
int seconds = time % 60;
if (seconds == 0) {
return minutes + "分钟";
} else {
return minutes + "分钟 " + seconds + "秒";
}
} else {
int hours = time / 3600;
int remainingTime = time % 3600;
int minutes = remainingTime / 60;
int seconds = remainingTime % 60;
StringBuilder result = new StringBuilder();
if (hours > 0) {
result.append(hours).append("小时 ");
}
if (minutes > 0) {
result.append(minutes).append("分钟 ");
}
if (seconds > 0) {
result.append(seconds).append("秒");
}
return result.toString();
}
}

List music2 = new ArrayList();
public String getuinmusic(String uin){
String data=getreferer("http://c.y.qq.com/rsc/fcgi-bin/fcg_user_created_diss?hostuin="+uin+"&size=10000&format=json");
return data;
}
public String getgedan(String url){
try{
String url2=get(url);
String data=url2.substring(url2.lastIndexOf("      var firstPageData = {")+26,url2.lastIndexOf("};\n    </script>\n    \n    <script>(function(win) {")+30);
if(data.equals("g=\"z")){
 data=url2.substring(url2.lastIndexOf("firstPageData= {")+15,url2.lastIndexOf(";\n            </script>")+24);
}
return data;
}catch(e){
return "获取错误\n"+e;
}
}
public String getjsonurl(String json){
json=json.replace("\\/","/");
try{
JSONObject json=new JSONObject(json);
JSONObject json2=json.getJSONObject("meta").getJSONObject("news");
return json2.getString("jumpUrl");
}catch(e){
return "错误\n"+e;
}
}

public boolean getgedanjiexi(String url){

try{
String json=getgedan(url);
if(json.startsWith("获取错误")){
ts("歌单解析错误\n"+json);
return false;
}
JSONObject json1=new JSONObject(json);
JSONObject json2=json1.getJSONObject("taogeData");
JSONArray json3=json2.getJSONArray("songlist");
for(int i = 0;i<json3.length();i++){
String singer="";
int i2=i+1;
JSONObject item = json3.getJSONObject(i);
String songname=item.getString("title");
String mid=item.getString("mid");
JSONArray json4=item.getJSONArray("singer");
for(int k = 0;k<json4.length();k++){
JSONObject item2 = json4.getJSONObject(k);
if(k==0){
singer=item2.getString("name");
}else{
singer+="/"+item2.getString("name");
}
}
jxmyname.add(songname);
jxsingername.add(singer);
jieximid.add(mid);
jiexiname.add(i2+"."+songname+"("+singer+")");
}
return true;
}catch(e){
ts("解析错误\n"+e);
return false;
}
}

public String getpic(String mid){
try{
String data = get("https://y.qq.com/n/ryqq/songDetail/"+mid);
String url=data.substring(data.lastIndexOf("window.__INITIAL_DATA__ =")+25,data.lastIndexOf("}</script><script crossorigin=")+30);
JSONObject b=new JSONObject(url);
JSONObject b=b.getJSONObject("detail");
String picurl=b.getString("picurl");
return "https:"+picurl.replace("T002R300x300","T002R150x150").replace("_1.jpg",".jpg");
}catch(e){
return "https://gchat.qpic.cn/gchatpic_new/0/0-0-9110CA91964E238A166F2D77DC8ECEE0/0";
}
}
public String searchmusic(String name,String uin){
new Thread(new Runnable(){
public void run(){
for(String tex: music2){
if(tex.startsWith("{\""+uin+"\":")){
try{
int index = music2.indexOf(tex);
music2.remove(index);
}catch(e){
}
}
}
}}).start();
long time2=System.currentTimeMillis()/1000;
JSONArray json3 = new JSONArray();
JSONObject json4 = new JSONObject();
String msg="";
String msg2="";
String music=post("https://u.y.qq.com/cgi-bin/musicu.fcg?_webcgikey=DoSearchForQQMusicDesktop",COOKIE,"{\"comm\":{\"format\":\"json\",\"inCharset\":\"utf-8\",\"outCharset\":\"utf-8\",\"notice\":0,\"platform\":\"h5\",\"needNewCode\":1,\"ct\":23,\"cv\":0},\"req\":{\"method\":\"DoSearchForQQMusicDesktop\",\"module\":\"music.search.SearchCgiService\",\"param\":{\"remoteplace\":\"txt.mqq.all\",\"search_type\":0,\"query\":\""+name+"\",\"page_num\":1,\"num_per_page\":60}}}");
//Toast(music);
try{
// JSONObject json = new JSONObject(music);
// json = json.get("req_0").getJSONObject("data").get("body");
// JSONArray array = json.get("song").get("list");
JSONObject json = new JSONObject(music);
json = json.get("req").getJSONObject("data").get("body");
JSONArray array = json.getJSONObject("song").getJSONArray ("list"); 
for(int i = 0; i < array.length(); i++)
{
JSONObject json2 = new JSONObject();
try{
int i2=i+1;
JSONObject newjson = array.getJSONObject(i);
String name2=newjson.getJSONObject("album").getString("name");
String name3=newjson.getString("title").replaceAll("<.*?>","");
String mid=newjson.getString("mid");
String time=newjson.getString("interval");
String from=newjson.get("file").get("media_mid");
JSONArray array2=newjson.getJSONArray("singer");
json2.put("name",name2);
json2.put("title",name3);
json2.put("mid",mid);
json2.put("time",time);
json2.put("from",from);
json2.put("endtime",""+time2);
String singer="";
for(int h=0;h<array2.length();h++)
{
if(h==0) singer = array2.getJSONObject(h).getString("name");
else singer = singer+"/"+array2.getJSONObject(h).getString("name");
}
json2.put("singer",singer);
//msg+=i2+"."+name3+"--"+singer+"["+name2+"]\n";
}catch(e){
return"错误\n"+e;
}
json3.put(json2);
}
json4.put(uin,json3);
music2.add(""+json4);
return json4+"";
}catch(e){
return "错误\n"+e;
}
}
public String getjsondata(String name,String uin){
String kee=searchmusic(name,uin);

int k=0;
try{
String msg="";
for(String tex: music2){
if(tex.startsWith("{\""+uin+"\":")){
JSONObject jsonObject = new JSONObject(tex);
JSONArray jsonArray = jsonObject.getJSONArray(uin);
for (int i = 0; i < jsonArray.length(); i++) {
int i2=i+1;
JSONObject item = jsonArray.getJSONObject(i);
String name3 = item.getString("title");
String singer = item.getString("singer");
String name2 = item.getString("name");

if(max-1>=i){
msg+=i2+"."+name3+"--"+singer+"["+name2+"]\n";
}
k++;
}
if(k>max-1){
msg=msg+"......\n";
}
msg =msg.replace("[]","");
if(k==0){
return at+"\n没有找到";
}
if(mysendtype==2){
at=at.replace("[AtQQ=","[").replace("[atUin=","[");
}
if(mdgpd!=0){return kee;}else{
return "QQ音乐里关于["+name+"]的歌曲:\n"+msg+"\n共搜索到了"+k+"个"+at+"\n发送序号点歌(卡片模式)或发送链接/歌词/语音+序号点歌\n"+zhuanhuan(MAX)+"之内有效";
}
}
}
return null;
}catch(e){return null;}
}

public String GetQQMusicSongUrl2(String SongMid)//来自绿逗以及刺痛
{
try{
//String cookie="p_uin=o0"+MyUin+";skey="+getSkey()+";p_skey="+getPskey("y.qq.com");
if(COOKIE==null)login(null);
			String text = getWithAgentCookie("https://i.y.qq.com/v8/playsong.html?songmid=" + SongMid,"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.105 Safari/537.36",COOKIE);
		int index = text.indexOf("\"m4aUrl\":\"");
		int index2 = text.indexOf("\",", index + 11);
		String SongUrl = text.substring(index + 10, index2);
		if(!SongUrl.startsWith("http")) {
		Toastm("QQ音乐"+SongMid+"直链3获取失败");
		return "";
		}
		return SongUrl;
			}
			catch(Throwable e)
		{
			Toastm("QQ音乐"+SongMid+"直链3获取失败\n"+e);
	        return ""+e;
		}
}
public String GetQQMusicSongUrl(String SongMid)
{
	try
	{
	//String cookie="p_uin=o0"+Mqq+";skey="+getSkey()+";p_skey="+getPskey("y.qq.com");
	if(COOKIE==null)login(null);
		String text = getWithAgentCookie("http://u6.y.qq.com/cgi-bin/musicu.fcg?data=%7B%22req_0%22%3A%7B%22module%22%3A%22vkey.GetVkeyServer%22%2C%22method%22%3A%22CgiGetVkey%22%2C%22param%22%3A%7B%22guid%22%3A%220%22%2C%22songmid%22%3A%5B%22"+SongMid+"%22%5D%2C%22songtype%22%3A%5B0%5D%2C%22uin%22%3A%22"+Mqq+"%22%2C%22loginflag%22%3A1%2C%22platform%22%3A%2220%22%7D%7D%7D","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.105 Safari/537.36",COOKIE);
		JSONObject json = new JSONObject(text);
            String purl=json.get("req_0").get("data").get("midurlinfo").get(0).get("purl");
		String SongUrl = "http://isure.stream.qqmusic.qq.com/"+purl;
		if(!SongUrl.contains("vkey")){
		return GetQQMusicSongUrl2(SongMid);
		}
		return SongUrl;
	}
		catch( o)
		{
		Toastm("QQ音乐"+SongMid+"直链2获取失败\n"+o);
			return GetQQMusicSongUrl2(SongMid);
		}
//	Toast("QQ音乐"+SongMid+"直链2获取失败");
	return "";
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
		//String cookie="p_uin=o0"+Mqq+";skey="+getSkey()+";p_skey="+getPskey("y.qq.com");
		if(COOKIE==null)login(null);
		String text = getWithAgentCookie("http://u.y.qq.com/cgi-bin/musicu.fcg?data=%7B%22req_0%22%3A%7B%22module%22%3A%22vkey.GetVkeyServer%22%2C%22method%22%3A%22CgiGetVkey%22%2C%22param%22%3A%7B%22guid%22%3A%220%22%2C%22filename%22%3A%5B%22"+filename+"%22%5D%2C%22songmid%22%3A%5B%22"+SongMid+"%22%5D%2C%22songtype%22%3A%5B0%5D%2C%22uin%22%3A%22"+Mqq+"%22%2C%22loginflag%22%3A1%2C%22platform%22%3A%2220%22%7D%7D%7D","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.105 Safari/537.36",COOKIE);
		JSONObject json = new JSONObject(text);
            
            String purl=json.get("req_0").get("data").get("midurlinfo").get(0).get("purl");
		String SongUrl = "http://isure.stream.qqmusic.qq.com/"+purl;
		if(SongUrl.contains("vkey")){
		return SongUrl;
		 }
		//return GetQQMusicSongUrl(SongMid,name,type+1);
	}
	catch( e)
	{
	Toastm("QQ音乐"+filename+"直链1获取失败\n"+e);
		return GetQQMusicSongUrl(SongMid,name,type+1);
	}
//	Toast("QQ音乐"+filename+"直链1获取失败");
	return GetQQMusicSongUrl(SongMid,name,type+1);
}
public JSONObject GetQQMusicLyrics(String songmid)
{
JSONObject returnObj = new JSONObject();
returnObj.put("ok",false);
returnObj.put("transok",false);
if(songmid != null && !songmid.isEmpty()){
try{
            String jsonStr = getWithAgentReferer("https://c.y.qq.com/lyric/fcgi-bin/fcg_query_lyric_new.fcg?g_tk=5381&format=json&songmid="+songmid,"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.105 Safari/537.36","https://y.qq.com/portal/player.html");
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
Toastm(""+e);
returnObj.put("Error",e.toString());
}
}
return returnObj;
}
public GradientDrawable getShape(String color1, String color2, int size1, int size2, int tm,boolean pd) {
GradientDrawable shape;
   if(pd){
    int[] colors = { Color.parseColor(color1), Color.parseColor(color2) };
     shape = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);
     }else{
     shape=new GradientDrawable();
    shape.setColor(Color.parseColor(color1));
     }
    shape.setStroke(size1, Color.parseColor(color2));
    shape.setCornerRadius(size2);
    shape.setAlpha(tm);
    shape.setShape(GradientDrawable.RECTANGLE);
    return shape;
}
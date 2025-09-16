import java.text.SimpleDateFormat;

String COOKIE=null;

public String accountlogin(){
try{
String client=GetUinClient(LoginUin);
if(client==null){
Toast(LoginUin+"QQ音乐登录密钥获取失败");return null;
}
//putString(LoginUin, "key", null);
String u=http.getLocation("https://ssl.ptlogin2.qq.com/jump?u1=https%3A%2F%2Fconnect.qq.com&daid=383&pt_openlogin_data=s_url%3Dhttps%253A%252F%252Fconnect.qq.com%26refer_cgi%3Dauthorize%26response_type%3Dcode%26client_id%3D100497308%26redirect_uri%3Dhttps%253A%252F%252Fy.qq.com%252Fportal%252Fwx_redirect.html&keyindex=19&clientuin="+LoginUin+"&clientkey="+client);
    u=u.substring(u.indexOf("code=")+5);
    //Toast(u);
    String req="{\"comm\":{\"platform\":\"yqq\",\"ct\":24,\"cv\":0},\"req\":{\"module\":\"QQConnectLogin.LoginServer\",\"method\":\"QQLogin\",\"param\":{\"code\":\""+u+"\"}}}";
String result=http.post("https://u.y.qq.com/cgi-bin/musicu.fcg",req);
JSONObject json=new JSONObject(result);
json=json.get("req").get("data");
String uin=json.get("str_musicid");
String musickey=json.get("musickey");
long createtime=json.get("musickeyCreateTime");
//long expiredtime=json.get("expired_at");
long expiredtime=createtime+57600;
SimpleDateFormat df=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
String time1=df.format(createtime*1000);
String time2=df.format(expiredtime*1000);
Toast("QQ音乐已登录Key创建成功!\nQQ:"+uin+"\nKey:"+musickey+"\n创建时间:"+time1+"\n过期时间:"+time2+"\n开始校验Key");
return "uin="+uin+";qm_keyst="+musickey+";";
}
catch(e)
{
return "登录阶段错误:"+e;
}
return null;
}
 
 
public JSONObject getloginjson()
{
if(COOKIE==null||COOKIE.equals("")) COOKIE=getString(LoginUin,"COOKIE");
JSONObject json=new JSONObject();
try{
String tt=http.getWithAgentCookie("https://c.y.qq.com/portalcgi/fcgi-bin/music_mini_portal/fcg_vip_score_rank_new.fcg?format=json&outCharset=utf-8&cmd=1","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.105 Safari/537.36",COOKIE);
json=new JSONObject(tt);
if(json.get("code")!=0||!json.has("data")) json.put("login",false);
else{
    json=json.get("data");
    json.put("login",true);
}
}
catch(e)
{
json.put("login",false);
json.put("message","COOKIE验证阶段错误："+e);
}
return json;
}

public boolean checklogin(JSONObject json)
{
if(json==null) json=getloginjson();
return json.get("login");
}




public void login(JSONObject json){
if(json==null) json=getloginjson();
if(!checklogin(json))
{
Toast("COOKIE过期或不存在重新登录");
putString(LoginUin, "COOKIE", null);
COOKIE=accountlogin();
json=getloginjson();
if(checklogin(json))
{
    putString(LoginUin, "COOKIE", COOKIE);
    Object uin= json.get("uin");
    String nick=json.get("nick");
    //Object friend=json.get("friends_count");
   // String follow=json.get("followers_count_str");
    String qqHead=json.get("qqHead");
    mToast("QQ音乐\""+nick+"\"("+uin+")Key校验成功!\nCOOKIE已存储。",bitmapurl(qqHead),true,Gravity.BOTTOM,0,0);
}
else{
    Toast(COOKIE+"\n"+json);
    Toast("QQ音乐登录失败，可能未绑定QQ账号或者存在其它问题\n请去QQ音乐客户端用QQ授权登录QQ音乐\n然后发送\"登录QQ音乐\"重新登录");
    putString(LoginUin, "COOKIE", null);
    COOKIE="";
}
}
}

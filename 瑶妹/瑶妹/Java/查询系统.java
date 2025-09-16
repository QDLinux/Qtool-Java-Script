public void 查询(Object data)
{
String quntext = data.MessageContent;
String qq = data.UserUin;
String qun = data.GroupUin;
String skey = getSkey();
String pskey = getPskey("qun.qq.com");


public  反查(String qq){
        try{
            JSONObject json=new JSONObject(get("https://api.xywlapi.cc/qqphone?phone="+qq));
            if(json.get("status")==200){
                String a=json.getString("qq");
                String b=json.getString("phonediqu");
                return "手机号:"+qb+"\nQQ:"+a+"\n归属地:"+b;
            }else{
                return "QQ:没有找到";
            }
        }catch(e){
            return "反查："+Api_404;
        }
}
public  在线状态(String qq){
        try{
            JSONObject json=new JSONObject(get("https://api.kit9.cn/api/qq_online_state/api.php?qq="+qq));
            if(json.get("code")==200){
        JSONObject data = json.getJSONObject("data");
        String 在线状态 = data.getString("online_status");
                return "在线状态:"+在线状态;
            }else{
                return"";
            }
        }catch(e){
            return"";
        }
}

public 空间访客(String qq){
        try{
            JSONObject json=new JSONObject(get("https://api.kit9.cn/api/qq_visitor/api.php?qq="+qq));
            if(json.get("code")==200){
        JSONObject data = json.getJSONObject("data");
        String 今日访客 = data.getString("today_visitor");
        String 总共访客 = data.getString("total_visitor");
        String 今日被挡访客 = data.getString("today_blocked");
        String 总共被挡访客 = data.getString("total_blocked");
                return "QQ空间:\n今日访客:"+今日访客+"\n总共访客:"+总共访客+"\n今日被挡访客:"+今日被挡访客+"\n总共被挡访客:"+总共被挡访客;
            }else{
                return"";
            }
        }catch(e){
            return"";
        }
}

public  会员信息(String qq){
        try{
            JSONObject json=new JSONObject(get("https://api.kit9.cn/api/qq_new_member/api.php?qq="+qq));
            if(json.get("code")==200){
        JSONObject data = json.getJSONObject("data");
        String QQ昵称 = data.getString("nickname");
        String QQ头像 = data.getString("faceurl");
        String QQ等级 = data.getString("iqqLevel");
        String QQ下次升级需要的天数 = data.getString("iqqLevel_upgrade_days");
        String 基础成长速度 = data.getString("growth_rate");
        String 总活跃天数 = data.getString("itotalactiveday");
        String Q靓图标 = data.getString("qliang");
        String 群靓图标 = data.getString("qunliang");
        String 是否QQ会员 = data.getString("iopen_vip");
        String 是否超级会员 = data.getString("iopen_svip");
        String 会员等级 = data.getString("ivip_level");
        String 会员总成长值 = data.getString("ivip_growth_value");
        String 会员每日成长值 = data.getString("ivip_growth_speed");
        String QQ会员到期时间 = data.getString("vip_expire_time");
        String 超会会员到期时间 = data.getString("isvip_expire_time");
        String 年费会员到期时间 = data.getString("year_expire_time");
        String 大会员等级 = data.getString("ibig_level");
        String 大会员是否年费 = data.getString("ibig_year");
        String 大会员总成长值 = data.getString("ibig_growth_value");
        String 大会员基础成长值 = data.getString("ibig_days");
        String 大会员成长速度 = data.getString("ibig_speed");
        String 手机是否在线 = data.getString("mobile_online");
        String 当前手机是否在线 = data.getString("mobile_online_time");
        String PC是否在线 = data.getString("pc_online");
        String 当前PC是否在线 = data.getString("pc_online_time");
		return "会员信息:\n"
		+"QQ昵称:"+QQ昵称+"\n"
		+"QQ等级:"+QQ等级+"\n"
		+"QQ下次升级需要的天数:"+QQ下次升级需要的天数+"\n"
		+"基础成长速度:"+基础成长速度+"\n"
		+"总活跃天数:"+总活跃天数+"\n"
		+"是否QQ会员:"+是否QQ会员+"\n"
		+"是否超级会员:"+是否超级会员+"\n"
		+"会员等级:"+会员等级+"\n"
		+"会员总成长值:"+会员总成长值+"\n"
		+"会员每日成长值:"+会员每日成长值+"\n"
		+"QQ会员到期时间:"+QQ会员到期时间+"\n"
		+"超会会员到期时间:"+超会会员到期时间+"\n"
		+"年费会员到期时间:"+年费会员到期时间+"\n"
		+"大会员等级:"+大会员等级+"\n"
		+"大会员是否年费:"+大会员是否年费+"\n"
		+"大会员总成长值:"+大会员总成长值+"\n"
		+"大会员基础成长值:"+大会员基础成长值+"\n"
		+"大会员成长速度:"+大会员成长速度+"\n"
		+"手机是否在线:"+手机是否在线+"\n"
		+"当前手机是否在线:"+当前手机是否在线+"\n"
		+"PC是否在线:"+PC是否在线+"\n"
		+"当前PC是否在线:"+当前PC是否在线;
            }else{
                return"";
            }
        }catch(e){
            return"";
        }
}
public  用户资料(String qq){
        try{
            JSONObject json=new JSONObject(get("https://api.kit9.cn/api/qq_material/api.php?qq="+qq));
            if(json.get("code")==200){
        JSONObject data = json.getJSONObject("data");
        String 昵称 = data.getString("name");
        String 签名 = data.getString("sign");
        String 年龄 = data.getString("age");
        String 性别 = data.getString("gender");
        String 国家 = data.getString("country");
        String 省份 = data.getString("province");
        String 城市 = data.getString("city");
        String 名片赞 = data.getString("clike");
        String QQ等级 = data.getString("level");
        String 邮箱 = data.getString("email");
		return "用户资料:\n"
		+"昵称:"+昵称+"\n"
		+"签名:"+签名+"\n"
		+"年龄:"+年龄+"\n"
		+"性别:"+性别+"\n"
		+"国家:"+国家+"\n"
		+"省份:"+省份+"\n"
		+"城市:"+城市+"\n"
		+"名片赞:"+名片赞+"\n"
		+"QQ等级:"+QQ等级+"\n"
		+"邮箱:"+邮箱;
            }else{
                return"";
            }
        }catch(e){
            return"";
        }
}
public 查绑(String qq){
        try{
            JSONObject json=new JSONObject(get("https://zy.xywlapi.cc/qqapi?qq="+qq));
            if(json.get("status")==200){
                String a=json.getString("phone");
                String b=json.getString("phonediqu");
                return "手机号:"+a+"\n归属地:"+b;
            }else{
                return"";
            }
        }catch(e){
            return"";
        }
}


if(("1".equals(getString(qun,"查询系统"))))
{



if(quntext.startsWith("反查"))
try{
String text=quntext.substring(2);
if(text.matches("^[1-9][0-9]{4,12}$"))
{
String c=反查(text);
sendm(qun,c+"\n\n注:信息来源于网络");
return;
}
}
catch(Exception e)
{
sendm(qun, "没有查到");
}


if(quntext.startsWith("查询"))
try{
String qq=quntext.substring(2);
if(qq.matches("^[1-9][0-9]{4,12}$"))
{


sendm(qun,"QQ:"+qq+"\n"+查绑(qq)+"\n"+在线状态(qq)+"\n"+用户资料(qq)+"\n"+会员信息(qq)+"\n"+空间访客(qq)+"\n\n注:信息来源于网络");
return;
}
if(qq.contains("@"))
{
 for(String qq: data.mAtList)
{
sendm(qun,"QQ:"+qq+"\n"+查绑(qq)+"\n"+在线状态(qq)+"\n"+用户资料(qq)+"\n"+会员信息(qq)+"\n"+空间访客(qq)+"\n\n注:信息来源于网络");
}
}
}
catch(Exception e)
{
sendm(qun, "没有查到");
}




        public String get2(String url)
{
        try {
            URL url = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            isr = new InputStreamReader(connection.getInputStream(), "utf-8");
BufferedReader reader = new BufferedReader(isr); 
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
    response.append(line);
}
            reader.close();
            connection.disconnect();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
}


if(quntext.startsWith("百度"))//无心首发搬代码不打备注你没()
{
String text=quntext.substring(2);
if(text.equals("")){

           if("1".equals(getString(qun,"管家回复")))
  {
 管家发送(qun,"请输入内容");
   }
   else {
sendReply(data.GroupUin,data,"请输入内容");
}
return;
}
if(text.contains("")){

           if("1".equals(getString(qun,"管家回复")))
  {
 管家发送(qun,"抓取限制验证错误");
   }
   else {
sendReply(qun,data,"内容有可能包含QQ表情,请重试");
}
return;
}
new Thread(new Runnable(){
public void run(){
String f=get2("https://baike.baidu.com/item/"+text+"");
try{
String u =f.substring(f.lastIndexOf("<meta name=\"description\" content=\"")+34,f.lastIndexOf("\"><meta name=\"keywords\""));
if(u.equals("百度百科是一部内容开放、自由的网络百科全书，旨在创造一个涵盖所有领域知识，服务所有互联网用户的中文知识性百科全书。在这里你可以参与词条编辑，分享贡献你的知识。")){
try{
String o =f.substring(f.lastIndexOf("                var sourceUrl = \"")+33,f.lastIndexOf("\";                var fromPage ="));
sendReply(qun,data,"请求限制,请完成验证:\n"+o);
break;
}catch(e)
{
        
           if("1".equals(getString(qun,"管家回复")))
  {
 管家发送(qun,"抓取限制验证错误");
   }
   else {
sendReply(data.GroupUin,data,"抓取限制验证错误");
}
break;
}
}


           if("1".equals(getString(qun,"管家回复")))
  {
 管家发送(qun,u+"");
   }
   else {
sendReply(qun,data,u+"");
}
break;
}catch(e){

           if("1".equals(getString(qun,"管家回复")))
  {
 管家发送(qun,"没有找到");
   }
   else {
sendReply(data.GroupUin,data,"没有找到");
}
break;
}
}}).start();
}


  
if(quntext.equals("昨日活跃排行"))
{
String c=speakingList(qun,0);
sendReply(qun,data,c);
}
if(quntext.equals("七日活跃排行"))
{
String c=speakingList(qun,1);
sendReply(qun,data,c);
}
if(quntext.equals("本月活跃排行"))
{
String c=speakingList(qun,2);
sendReply(qun,data,c);
}



   if(data.MessageContent.equals("龙王")||data.MessageContent.equals("本群龙王"))//陌然
  {
   skey=getSkey();
   pskey=getPskey("qun.qq.com");
   String result2="";
      String result3="";
   String cookie= "p_skey="+pskey+"; uin=o"+MyUin+"; skey="+skey+"; p_uin=o"+MyUin+";";
   String result=httpget("https://qun.qq.com/interactive/honorlist?gc="+qun+"&type=1&_wv=3&_wwv=129",cookie);
int index = result.lastIndexOf("window.__INITIAL_STATE__=");
String text = result.substring(index + 25);
int rd = text.indexOf("}<");
String re = text.substring(0,rd+1);
JSONObject json=new JSONObject(re);
if(json.getString("currentTalkative").equals("null"))
   {

sendm(qun,"该群还没有龙王");
   }
if(json.getString("currentTalkative").equals("{}"))
   {
   sendm(qun,"pskey错误");
   return;
   }
String nick= json.getJSONObject("currentTalkative").getString("nick");
String day= json.getJSONObject("currentTalkative").getString("day_count");
JSONArray j=json.getJSONArray("talkativeList");
if(j.length()>5) q =5;
if(j.length()<5) q =j.length();
   for(int i=0;i<q;i++){
        JSONObject y=j.get(i);
        String name=y.get("name");
        String qq=y.getString("uin");
        String desc=y.getString("desc");
        
        result2+="\n名字:"+name+"\nQQ:"+qq+"\n共有"+desc;}

sendm(qun,"龙王:"+nick+"\n连续"+day+"天龙王\n\n历史获得成员"+result2+"\n只显示前五位(共"+j.length()+"位)");
    }


if(quntext.equals("违规记录"))
{
new java.lang.Thread(new Runnable()
{
public void run()
{
boolean 成功=false;
try
{
String er=get("https://xiaobai.klizi.cn/API/qqgn/mc/login.php");
JSONObject b=new JSONObject(er);
//JSONObject b=b.getJSONObject("data");
String d=b.getString("url");
String h=b.getString("code");
sendReply(qun,data,"请在2分钟内授权\n"+d);
for(int i = 0;i<60;i++)
{
Thread.sleep(2000);
String e=get("https://xiaobai.klizi.cn/API/qqgn/mc/login.php?type=1&code="+h);
if(e.contains("\"ticket\""))
{
sendReply(qun,data,"已登录，正在处理");
JSONObject b=new JSONObject(e);
JSONObject b=b.getJSONObject("data");
String ticket=b.getString("ticket");
String A2=get("https://xiaobai.klizi.cn/API/qqgn/mc/safety.php?type=1&ticket="+ticket);
JSONObject b=new JSONObject(A2);
String wxr=b.getString("openid");
String cced=b.getString("minico_token");
String A3=get("https://xiaobai.klizi.cn/API/qqgn/mc/safety.php?type=2&id="+wxr+"&token="+cced+"&uin="+qq);
sendReply(qun,data,A3);
成功=true;
break;
}
}
}catch(e){
sendReply(qun,data,"错误，原因\n"+e);}
if(!成功) sendReply(qun,data,"二维码已经失效请重新发送\n违规记录");
}
}).start();
}

int tqpd=2;//天气是否图文，1为图文,2为文字
int xz2=16;//获取天气的多少天16就是获取16天后的
if(quntext.startsWith("天气"))//无心首发，搬代码不打备注你没()
{
String text=quntext.substring(2);
if(text.equals(""))
{
sendm(qun,"未输入");
return;
}
if(text.contains("")){sendReply(qun,data,"内容有可能包含QQ表情,请重试");return;}
new Thread(new Runnable(){
public void run(){
String u="";
String r="";
String uo="";
String f="";
int j=1;
try{
 f=get2("https://m.baidu.com/sf?pd=life_compare_weather&openapi=1&dspName=iphone&from_sf=1&resource_id=4982&oe=utf8&alr=1&multiDayWeather=1&title=4天天气预报&query="+text+"天气");
 u =f.substring(f.lastIndexOf("\"weatherList\":[{\"date\":\""),f.lastIndexOf("\"}],\"calendarText\":[\""));
String op="{"+u.substring(u.lastIndexOf("\"weatherList\":[{\"date\":\""),u.lastIndexOf(",\"lowHighTempDay\""))+"}";
 JSONObject menu1=new JSONObject(op);
JSONArray menu2=menu1.getJSONArray("weatherList");

for(int i=0;i<menu2.length();i++){
try{
JSONObject info=menu2.getJSONObject(i);
if(xz2>=j){
String time=info.getString("monthDayWeek");
String tq=info.getString("weatherAndTempDesc");
String fx=info.getString("wind_power_day");
String smf=info.getString("wind_direction_day");
String rc=info.getString("sunriseTime");
String rl=info.getString("sunsetTime");
String pic1=info.getString("iconKey");
String pic =pic1.replace("url(","").replace(")","");
if(tqpd==1){
r+="[PicUrl="+pic+"]\n"+j+"、"+time+":"+tq+"℃\n("+smf+")"+fx+"\n(日出:"+rc+";日落:"+rl+")\n-------------\n";
}else{
r+=j+"、"+time+":"+tq+"℃\n("+smf+")"+fx+"\n(日出:"+rc+";日落:"+rl+")\n-------------\n";
}
}
String ut=info.getString("wind_power_night");
j++;
}catch(e){}
}
j=j-1;
sendm(qun,"中国天气->\n当前地区("+text+")天气\n"+r+"共查询到了"+j+"天后的天气");
}catch(e){
try{
try{
 f=get2("https://m.baidu.com/s?from=1001192y&word="+text+"天气&sa=is_br_0");
 u =f.substring(f.lastIndexOf("\"itemList\":[[{\""),f.lastIndexOf(",\"titleLine\":"));
 }catch(e){
 try{
  f=get2("https://m.baidu.com/s?from=1001192y&word="+text+"省天气&sa=is_br_0");
 u =f.substring(f.lastIndexOf("\"itemList\":[[{\""),f.lastIndexOf(",\"titleLine\":"));
 }catch(e){
}
}
 u ="{"+u.replace("[[","[").replace("]]","]")+"}";
 JSONObject menu1=new JSONObject(u);
JSONArray menu2=menu1.getJSONArray("itemList");
for(int i = 0;i<1;i++)
{
try{
JSONObject info=menu2.getJSONObject(i);
uo=info.getString("cityWeather");
}catch(e){}
}
 f=get2("https://m.baidu.com/sf?pd=life_compare_weather&openapi=1&dspName=iphone&from_sf=1&resource_id=4982&oe=utf8&alr=1&multiDayWeather=1&title=4天天气预报&query="+uo+"天气");
 u =f.substring(f.lastIndexOf("\"weatherList\":[{\"date\":\""),f.lastIndexOf("\"}],\"calendarText\":[\""));
String op="{"+u.substring(u.lastIndexOf("\"weatherList\":[{\"date\":\""),u.lastIndexOf(",\"lowHighTempDay\""))+"}";
 JSONObject menu1=new JSONObject(op);
JSONArray menu2=menu1.getJSONArray("weatherList");
for(int i=0;i<menu2.length();i++){
try{
JSONObject info=menu2.getJSONObject(i);
if(xz2>=j){
String time=info.getString("monthDayWeek");
String tq=info.getString("weatherAndTempDesc");
String fx=info.getString("wind_power_day");
String smf=info.getString("wind_direction_day");
String rc=info.getString("sunriseTime");
String rl=info.getString("sunsetTime");
String pic1=info.getString("iconKey");
String pic =pic1.replace("url(","").replace(")","");
if(tqpd==1){
r+="[PicUrl="+pic+"]\n"+j+"、"+time+":"+tq+"℃\n("+smf+")"+fx+"\n(日出:"+rc+";日落:"+rl+")\n-------------\n";
}else{
r+=j+"、"+time+":"+tq+"℃\n("+smf+")"+fx+"\n(日出:"+rc+";日落:"+rl+")\n-------------\n";
}
}
String ut=info.getString("wind_power_night");
j++;
}catch(e){}
}
j=j-1;
sendm(qun,"中国天气->\n当前找到了("+text+"->"+uo+")天气\n"+r+"共查询到了"+j+"天后的天气");
}catch(e){//开始搜索世界天气
try{
String op="{"+f.substring(f.lastIndexOf("\"dayForecastList\":")+0,f.lastIndexOf(",\"hourInfoData\":"))+"}";
f=op;
JSONObject menu1=new JSONObject(op);
JSONArray menu2=menu1.getJSONArray("dayForecastList");
for(int i=0;i<menu2.length();i++){
try{
JSONObject info=menu2.getJSONObject(i);
if(xz2>=j){
String time=info.getString("weather_night");
String tq=info.getString("wind_direction_night");
String smf=info.getString("wind_power_night");
String u1=info.getString("date");
String u2=info.getString("word");
String rc=info.getString("sunriseTime");
String rl=info.getString("sunsetTime");
String pic=info.getString("listWeatherIcon");
if(tqpd==1){
r+="[PicUrl="+pic+"]\n"+j+"、"+u2+u1+":"+time+"\n"+tq+"("+smf+")\n(日出:"+rc+";日落:"+rl+")\n-------------\n";
}else{
r+=j+"、"+u2+u1+":"+time+"\n"+tq+"("+smf+")\n(日出:"+rc+";日落:"+rl+")\n-------------\n";
}
}
String ut=info.getString("wind_power_night");
j++;
}catch(e){}
}
j=j-1;
sendm(qun,"世界天气->\n当前找到了("+text+")的天气\n"+r+"共找到了"+j+"天后的天气");
}catch(e){
sendm(qun,"没有找到");
}
}
}
j=1;
break;
}}).start();
}

}


}
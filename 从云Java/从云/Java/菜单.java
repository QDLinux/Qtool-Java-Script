import java.util.List;
import java.util.ArrayList;
List black = new ArrayList();
List lovewuxin1314 = new ArrayList();
List jbfj = new ArrayList();
public void onMsg(Object data)
{
String 如=data.MessageContent;
String qun=data.GroupUin;
String qqh=data.UserUin;
first(data);
if("1".equals(取(qun,"jqyz")))
{
if(json.contains(qqh)){
try{
opr="{"+json+"}";//创建JSON
ho =opr.replace(",}","}");
JSONObject b=new JSONObject(ho);
String yzq=b.getString(qun+" "+qqh);
if(如.equals(yzq)){
sendm("1",qun,"["+qqh+"]\n验证成功，欢迎你的加入");
json2=json.replace("\""+qun+" "+qqh+"\":\""+yzq+"\",","");
json=json2;
}else{
sendm("1",qun,"["+qqh+"]\n验证错误，你的验证码是\n["+yzq+"]");
}
}catch(e)
{sendm("1",qun,"错误，调试信息\n"+json);}
}
}
if("1".equals(取(qun,"kg"))){
Create(AppPath+"/从云/"+qun);
if(取(qun,"xz")==null)
{qx=qqh;xz="×";}else{qx=MyUin+","+read(AppPath+"/从云/"+qun+"/代管.txt");xz="✓";}
if(qx.contains(qqh)){
if(如.equals("娱乐功能"))
{
sendm("2",qun,"一言\n每日一文\n舔狗日记\n历史今天\n投票禁言\n抽奖菜单\n数字炸弹\n刷听歌时长\n天气+地区\n(天气可以到脚本里面修改参数)");
}
if(如.equals("刷听歌时长")&&a().equals("false"))
{
sendm("1",qun,qqh+"\n"+JSON2(2,qqh));
}
if(如.equals("数字炸弹"))
{
sendm("2",qun,"开启/关闭数字炸弹\n邀请成员@xx(可邀请多个)\n开始数字炸弹\n我猜+数字\n结束数字炸弹\n(结束数字炸弹仅代管/主人可用)\n默认最低数字1000最高数字20000\n可到脚本里面修改");
}
if(如.equals("投票禁言"))
{
if(取(qun,"tpjy2")==null){tpjykg="×";}else{tpjykg="✓";}
sendm("2",qun,"开启/关闭投票禁言\n当前开关("+tpjykg+")\n结束投票\n投票进度\n投票禁言@xx +票数+|+禁言时间");
}
if(如.equals("历史今天"))
{
sendm("1",qun,JSON2(7,""));
}
if(如.equals("菜单"))
{
String jbxz="";
if(jbfj.toArray().length>0) {
for(int i = 0;i<jbfj.size();i++)
{
if(!bxyxs.contains(jbfj.get(i))){
if ((i + 1) % 2 == 0) {
jbxz+=jbfj.get(i)+"\n";
}else{
jbxz+=jbfj.get(i)+" ";
}
}
}
}
sendm("2",qun,"基础功能 API功能\n图片功能 检测功能\n娱乐功能 主人功能\n开关设置 查询功能\n音乐系统 模式切换\n扫码功能 检测版本\n"+jbxz+"\n当前限制("+xz+")");
}
if(如.equals("扫码功能"))
{
if(取(qun,"扫码")==null){smgn="×";}else{smgn="✓";}
sendm("2",qun,"开启/关闭扫码("+smgn+")\n1.领绿钻\n2.领cf图标\n3.一键签到\n4.领加速包\n(仅限于有会员用户)\n5.我的业务\n(以上主人发送不需要扫码)");
}
if(如.equals("模式切换"))
{
sendm("2",qun,"模式切换\n开启图片模式\n(部分文字功能图片化)\n关闭图片模式\n(切换原来的模式)\n注意：\n1.包含链接文字消息不会图片化\n2.图文消息不会图片化\n\n开启图文模式\n(图片+文字混合)\n关闭图文模式\n(原始菜单)\n注意：\n开启图文模式时候图文消息不会图文化\n\n开启卡片模式\n(JSON卡片)\n关闭卡片模式\n(原始菜单)\nTips:3个模式不可以一起开");
}
if(如.equals("音乐系统"))
{
if(取(qun,"QQ点歌")==null){dgkg="×";}else{dgkg="✓";}
sendm("2",qun,"开启/关闭点歌\n或者\n悬浮窗开启/关闭点歌\n登录QQ音乐\n点歌+歌名\n音乐系统来自卑微萌新\n当前音乐系统开关("+dgkg+")\nTips:\n可以到脚本内修改点歌配置");
}
if(如.equals("API功能"))
{
sendm("2",qun,"龙王\n开启/关闭群等级\n开启/关闭群头衔\n开启/关闭群互动\n昨日活跃排行\n七日活跃排行\n本月活跃排行");
}
if(如.equals("查询功能"))
{
sendm("2",qun,"业务@xx/QQ\n等级+QQ\n访客+QQ\n违规记录\n窥屏检测\n百度+内容");
}
if(如.startsWith("百度"))//无心首发搬代码不打备注你没()
{
String text=如.substring(2);
if(text.equals("")){
sendm("1",qun,"请输入内容");
return;
}
if(text.contains("")){sendm("1",qun,"内容有可能包含QQ表情,请重试");return;}
new Thread(new Runnable(){
public void run(){
String f=get2("https://baike.baidu.com/item/"+text+"");
sendm("1",qun,"正在百度");
try{
String u =f.substring(f.lastIndexOf("<meta name=\"description\" content=\"")+34,f.lastIndexOf("\"><meta name=\"keywords\""));
if(u.equals("百度百科是一部内容开放、自由的网络百科全书，旨在创造一个涵盖所有领域知识，服务所有互联网用户的中文知识性百科全书。在这里你可以参与词条编辑，分享贡献你的知识。")){
try{
String o =f.substring(f.lastIndexOf("                var sourceUrl = \"")+33,f.lastIndexOf("\";                var fromPage ="));
sendm("1",qun,"请求限制,请完成验证:\n"+o);
break;
}catch(e)
{
sendm("1",qun,"抓取限制验证错误");
break;
}
}
Thread.sleep(500);
sendm("1",qun,"标题:"+text+"\n--------\n"+u+"");
break;
}catch(e){
sendm("1",qun,"没有找到");
break;
}
}}).start();
}
if(如.equals("违规记录"))
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
sendm("1",qun,"[AtQQ="+qqh+"]请在2分钟内授权\n"+d);
for(int i = 0;i<60;i++)
{
Thread.sleep(2000);
String e=get("https://xiaobai.klizi.cn/API/qqgn/mc/login.php?type=1&code="+h);
if(e.contains("\"ticket\""))
{
sendm("1",qun,"已登录，正在处理稍等一下～");
JSONObject b=new JSONObject(e);
JSONObject b=b.getJSONObject("data");
String ticket=b.getString("ticket");
String A2=get("https://xiaobai.klizi.cn/API/qqgn/mc/safety.php?type=1&ticket="+ticket);
JSONObject b=new JSONObject(A2);
String wxr=b.getString("openid");
String cced=b.getString("minico_token");
String A3=get("https://xiaobai.klizi.cn/API/qqgn/mc/safety.php?type=2&id="+wxr+"&token="+cced+"&uin="+qqh);
sendm("1",qun,A3);
成功=true;
break;
}
}
}catch(e){
sendm("1",qun,"错误，原因\n"+e);}
if(!成功) sendm("1",qun,"[AtQQ="+qqh+"]二维码已经失效请重新发送\n违规记录");
}
}).start();
}
if(如.equals("窥屏检测"))
{
new Thread(new Runnable(){
public void run(){
延迟(qun);
String json="{\"app\":\"com.tencent.gamecenter.gameshare\",\"desc\":\"\",\"bizsrc\":\"\",\"view\":\"noDataView\",\"ver\":\"0.0.0.0\",\"prompt\":\"[视频]某男子和某女子在电梯里面......\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"shareData\":{\"height\":3000,\"scene\":\"\",\"buttons\":[{\"url\":\"\",\"text\":\"窥屏检测\"}],\"jumpUrl\":\"http://yysk.yitzu.cn.qingf.top/api/xb/api/kp.php?a="+qun+"&type=\",\"width\":3000,\"type\":\"video\",\"cover\":\"\",\"appid\":\"12904366\",\"url\":\"http://yysk.yitzu.cn.qingf.top/api/xb/api/kp.php?a="+qun+"&type=\"}},\"config\":{\"forward\":1,\"showSender\":1},\"text\":\"\",\"extraApps\":[],\"sourceAd\":\"\",\"extra\":\"\"}";
sendCard(qun,"",json);
}}).start();
}
if(如.startsWith("业务"))
{
String text=如.substring(2);
String P="";
try{
if(text.matches("[0-9]+"))
{
String hr=get("https://api.kit9.cn/api/qq_privilege/api.php?qq="+text);
JSONObject b=new JSONObject(hr);
String na=b.getString("name");
JSONArray menu2=b.getJSONArray("data");
for(int i=0;i<menu2.length();i++){
{
JSONObject info=menu2.getJSONObject(i);
String name=info.getString("name");
String level=info.getString("level");
String ms=info.getString("desc");
P+=name+"(LV:"+level+")\n"+ms+"\n-------------\n";
}
}
sendm("1",qun,"当前找到了"+text+"("+na+")\n"+P);
}else{
for(String tex: data.mAtList)
{
String hr=get("https://api.kit9.cn/api/qq_privilege/api.php?qq="+tex);
JSONObject b=new JSONObject(hr);
String na=b.getString("name");
JSONArray menu2=b.getJSONArray("data");
for(int i=0;i<menu2.length();i++){
{
JSONObject info=menu2.getJSONObject(i);
String name=info.getString("name");
String level=info.getString("level");
String ms=info.getString("desc");
P+=name+"(LV:"+level+")\n"+ms+"\n-------------\n";
}
}
sendm("1",qun,"当前找到了"+tex+"("+na+")\n"+P);
}
}
}catch(e){
sendm("1",qun,"没有找到,此人可能没开通业务,或者不存在此人\n"+e);
}
}
if(如.startsWith("等级"))
{
String text = 如.substring(2);
if(text.equals(""))
{
sendm("1",qun,"请输入QQ");
return;
}
String YT=GETLEVEL(text);
sendm("1",qun,YT);
}
if(如.startsWith("访客"))
{
String text=如.substring(2);
new Thread(new Runnable(){
public void run(){
if(text.equals(""))
{
sendm("1",qun,"请输入QQ");
return;
}
sendm("1",qun,JSON2(1,text));
 }}).start();
 }
   if(如.equals("龙王"))//陌然
  {
   skey=getSkey();
   pskey=getPskey("qun.qq.com");
   String result2="";
   String cookie= "p_skey="+pskey+"; uin=o"+MyUin+"; skey="+skey+"; p_uin=o"+MyUin+";";
   String result=httpget("https://qun.qq.com/interactive/honorlist?gc="+qun+"&type=1&_wv=3&_wwv=129",cookie);
int index = result.lastIndexOf("window.__INITIAL_STATE__=");
String text = result.substring(index + 25);
int rd = text.indexOf("}<");
String re = text.substring(0,rd+1);
JSONObject json=new JSONObject(re);
if(json.getString("currentTalkative").equals("null"))
   {
   sendm("1",qun,"该群还没有龙王");
   return;
   }
if(json.getString("currentTalkative").equals("{}"))
   {
   sendm("1",qun,"pskey错误");
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
        result2+="\n名:"+name+"\nQQ:"+qq+"\n共"+desc;}
   sendm("1",qun,"龙王:"+nick+"\n连续"+day+"天龙王\n\n历史获得成员"+result2+"\n只显示前五位(共"+j.length()+"位)");
  }
if(如.equals("每日一文"))
{
sendm("1",qun,JSON2(3,"").replace("</p>","").replace("<p>",""));
}
if(如.equals("舔狗日记"))
{
sendm("1",qun,JSON2(4,""));
}
if(如.equals("一言"))
{
sendm("1",qun,JSON2(5,""));
}
if(如.startsWith("天气"))//无心首发，搬代码不打备注你没()
{
String text=如.substring(2);
if(text.equals(""))
{
sendm("1",qun,"未输入");
return;
}
if(text.contains("")){sendm("1",qun,"内容有可能包含QQ表情,请重试");return;}
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
r+="[PicUrl="+pic+"]\n"+j+"."+time+":"+tq+"℃\n("+smf+")"+fx+"\n(日出:"+rc+";日落:"+rl+")\n-------------\n";
}else{
r+=j+"."+time+":"+tq+"℃\n("+smf+")"+fx+"\n(日出:"+rc+";日落:"+rl+")\n-------------\n";
}
}
String ut=info.getString("wind_power_night");
j++;
}catch(e){}
}
j=j-1;
sendm("1",qun,"中国天气->\n当前地区("+text+")天气\n"+r+"共查询到了"+j+"天后的天气");
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
r+="[PicUrl="+pic+"]\n"+j+"."+time+":"+tq+"℃\n("+smf+")"+fx+"\n(日出:"+rc+";日落:"+rl+")\n-------------\n";
}else{
r+=j+"."+time+":"+tq+"℃\n("+smf+")"+fx+"\n(日出:"+rc+";日落:"+rl+")\n-------------\n";
}
}
String ut=info.getString("wind_power_night");
j++;
}catch(e){}
}
j=j-1;
sendm("1",qun,"中国天气->\n当前找到了("+text+"->"+uo+")天气\n"+r+"共查询到了"+j+"天后的天气");
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
r+="[PicUrl="+pic+"]\n"+j+"."+u2+u1+":"+time+"\n"+tq+"("+smf+")\n(日出:"+rc+";日落:"+rl+")\n-------------\n";
}else{
r+=j+"."+u2+u1+":"+time+"\n"+tq+"("+smf+")\n(日出:"+rc+";日落:"+rl+")\n-------------\n";
}
}
String ut=info.getString("wind_power_night");
j++;
}catch(e){}
}
j=j-1;
sendm("1",qun,"世界天气->\n当前找到了("+text+")的天气\n"+r+"共找到了"+j+"天后的天气");
}catch(e){
sendm("1",qun,"没有找到");
}
}
}
j=1;
break;
}}).start();
}
if("1".equals(取(qun,"tp")))
{QQ=MyUin+","+read(AppPath+"/从云/"+qun+"/代管.txt");xz="✓";}else{QQ=qqh;xz="×";}
if(QQ.contains(qqh)){
if(如.equals("图片功能"))
{
sendm("2",qun,"诱惑图\n妹子图\n壁纸图\n樱花图\ncos图\n随机图\n动漫图1-3\n作图+空格+内容+空格+内容\n当前限制("+xz+")");
}
if(如.equals("cos图")||如.equals("COS图"))
{
sendp(qun,JSON2(14,""));
}
if(如.equals("随机图"))
{
sendp(qun,JSON2(15,""));
}
if(如.equals("樱花图"))
{
new Thread(new Runnable(){
public void run(){
sendp(qun,JSON2(6,""));
}}).start();
}
if(如.startsWith("作图 ")) //原作者bug
        {
        try{
            String str=如.substring(3);
            int index=str.indexOf(" ");
            String text=str.substring(0, index);
            String text2=str.substring(index + 1);
            float textsize=50.0f;
            float padding=40.0f;

            Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
            paint.setTypeface(Typeface.DEFAULT_BOLD);
            paint.setTextSize(textsize);
            float text_width=paint.measureText(text);
            float text2_width=paint.measureText(text2);

            int width=(int)(text_width + text2_width + padding * 2.5f);
            int heigth=(int)(textsize + padding * 2f);
            Bitmap bitmap = Bitmap.createBitmap(width, heigth, Bitmap.Config.ARGB_8888);
            Canvas canvas=new Canvas(bitmap);
            canvas.drawColor(Color.BLACK);
            paint.setColor(Color.WHITE);
            float yoffset = heigth - padding * 2 + textsize * 2 / 3;
            canvas.drawText(text, padding, yoffset, paint);
            paint.setColor(Color.parseColor("#F79817"));
            RectF rect=new RectF(padding + text_width * 1.1f, yoffset - textsize, padding * 1.5f + text_width + text2_width, yoffset + textsize * 0.3f);
            canvas.drawRoundRect(rect, 5, 5, paint);
            paint.setColor(Color.BLACK);
            canvas.drawText(text2, padding + text_width * 1.15f, yoffset, paint);
            FileOutputStream out = new FileOutputStream("/mnt/sdcard/test.png");
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.close();
            sendPic(qun, "","/mnt/sdcard/test.png");
        }catch(Exception e){sendm("1",qun,"格式错误，格式为\"作图+空格+内容+空格+内容\"");
        }
        }
if(如.startsWith("动漫图"))
{
new Thread(new Runnable(){
public void run(){
String text=如.substring(3);
if(text.equals("1")){
sendp(qun,JSON2(8,""));
}
if(text.equals("2"))
{
sendp(qun,JSON2(9,""));
}
if(text.equals("3"))
{
sendp(qun,JSON2(13,""));
}
}}).start();
}
if(如.equals("壁纸图"))
{
sendp(qun,JSON2(10,""));
}
if(如.equals("诱惑图"))
{
sendp(qun,JSON2(11,""));
}
if(如.equals("妹子图"))
{
sendp(qun,JSON2(12,""));
}
}
}
if("1".equals(取(qun,"jc") )) {
if(data.IsGroup &&!qqh.equals(MyUin)){
if(如.startsWith(""))
{
String text=如.substring(0);
if(text.contains("​"))
{
atjc="​";
}
if(text.contains("‍"))
{
atjc="‍";
}
if(atjc.equals(""))
{}else{
int oldCount = text.length();
int newCount = text.replace(atjc, "").length();
int ioy=(oldCount - newCount) / atjc.length();
if(ioy>atqt)
{
Forbidden(qun,qqh,60*60*24);
sendm("1",qun,"["+qqh+"]\n疑似艾特全体\n艾特QQ"+ioy+">"+atqt+"个");
revokeMsg(data);
atjc="";
}
}
}
if(如.startsWith(""))
{
String text=如.substring(0);
if(text.length() > 字数)
{
Forbidden(qun,qqh,60*60*24);
sendm("1",qun,"["+qqh+"]\n疑似卡屏\n"+text.length()+">"+字数);
revokeMsg(data);
}
}
}
}
if(qqh.equals(MyUin))
{
if(如.equals("原神涩图"))
{
try{
String br=get("https://api.lolicon.app/setu/v2");
String kr=br.substring(br.lastIndexOf("\"original\":\"")+12,br.lastIndexOf("\"}}]}"));
sendp(qun,kr);
}catch(e){
sendm("1",qun,"获取失败了\n"+e);
}
}
if(如.equals("艾特回复"))
{
if(取(qun,"艾特")==null){athfkg="×";}else{athfkg="✓";}
if(取(qun,"atyy2")==null){athfyy="×";}else{athfyy="✓";}
if(取(qun,"atwz2")==null){athfwz="×";}else{athfwz="✓";}
if(取(qun,"attp2")==null){athftp="×";}else{athftp="✓";}
if(取(qun,"atjy1")==null){athfjy="×";}else{athfjy="✓";}
if(判(AppPath+"/从云/"+qun+"/pic.jpg").equals("false"))
{
if(取(qun,"attp3")==null){}else{
athftplj=取(qun,"attp3");
}
}else{
athftplj=AppPath+"/从云/"+qun+"/pic.jpg";
}
if(判(AppPath+"/从云/"+qun+"/1.mp3").equals("false"))
{
if(取(qun,"atyy3")==null){}else{
athfyylj=取(qun,"atyy3");
}
}else{
athfyylj=AppPath+"/从云/"+qun+"/1.mp3";
}
String athf1="悬浮窗开启/关闭艾特回复\n当前回复开关("+athfkg+")\n当前设置:\n艾特禁言("+athfjy+")\n艾特回复语音("+athfyy+")\n艾特回复图片("+athftp+")\n艾特回复文字("+athfwz+")\n当前回复路径/文字:\n艾特回复禁言("+取(qun,"atjy2")+")分钟)\n艾特回复语音路径\n"+athfyylj+"\n艾特回复图片路径\n"+athftplj;
athf1 =athf1.replace("null","没设置");
sendm("2",qun,athf1);
}
}
if(qqh.equals(MyUin)||read(AppPath+"/从云/"+qun+"/代管.txt").contains(qqh)){
if(如.equals("检测功能"))
{
sendm("2",qun,"开启/关闭检测\n(检测卡屏/艾特全体)\n开启/关闭音乐卡片检测\n(音乐卡片检测)\n开启/关闭入群链接检测\n(入群链接检测)");
}
if(如.equals("主人功能"))
{
sendm("2",qun,"原神涩图\n艾特回复\n共同群聊+QQ\n我的业务\n(业务查询Plus)\n查看所有群\n收款@xx +金额\n添加代管@xx\n删除代管@xx\n清空代管\n上/下管理@xx");
}
if(如.equals("开关设置"))
{
kgsz2(qun);
sendm("2",qun,"1.开/关机("+zkg1+")\n(总开关)\n2.开启/关闭限制("+yl+")\n(部分功能是否限制成员使用)\n3.开启/关闭检测("+jc+")\n(卡屏/艾特全体等检测)\n4.开启/关闭图片("+tp+")\n(图片功能)\n5.开启/关闭头衔("+tx+")\n(自助头衔)\n6.开启/关闭违禁词禁言("+wjcjy+")\n7.开启/关闭违禁词撤回("+wjcch+")\n8.开启/关闭违禁词踢出("+wjctc+")\n9.开启/关闭抽奖("+cjkg+")\n(抽奖,发送\"抽奖菜单\"了解更多)\n10.开启/关闭扫码("+smgn+")\n(扫码功能,发送\"扫码功能\"了解更多)\n11.开启/关闭私聊解禁("+sljj2+")\n(私聊解禁,发送\"私聊解禁\"了解更多)\n12.开启/关闭进群验证("+jqyz+")\n(进群验证,发送\"进群验证\"了解更多)\n13.开启/关闭字数检测("+zsjc+")\n(字数检测,发送\"字数检测\"了解更多)\n14.开启/关闭小号收费("+xhsf2+")\n(小号收费,可以到脚本内修改小号收费配置发送\"小号收费\"可了解更多)\n15.设置时间+时间(分)当前禁言时间"+wjcjysj+"分\n设置违禁词禁言时间,默认10分钟");
}
if(如.equals("基础功能"))
{
sendm("2",qun,"群管系统\n开关设置\n黑白系统\n进群验证\n字数检测\n小号收费\n私聊解禁\n进群欢迎\n清屏/清");
}
if(如.equals("私聊解禁"))
{
if(取(qun,"sljj")==null){sljj2="×";}else{sljj2="✓";}
sendm("2",qun,"开启/关闭私聊解禁("+sljj2+")\n开启后群友被禁言可以发送\"解禁+禁言的群号\"来解除禁言\n前提是你是本群的群主或者管理员\n可以到脚本里面设置被解禁次数,默认2次");
}
if(如.equals("小号收费"))
{
if(取(qun,"jqyz")==null){jqyz="×";}else{jqyz="✓";}
if(取(qun,"xhsf")==null){xhsf2="×";}else{xhsf2="✓";}
sendm("2",qun,"开启/关闭小号收费("+xhsf2+")\n取消收费+QQ\n当前小号收费等级"+小号收费+"\n小号收费金额"+小号收费2+"\nTips:小号收费和进群验证不可以一起开\n当前进群验证开关("+jqyz+")\n部分参数请到java里面修改");
}
if(如.equals("进群欢迎"))
{
String jqkg="✓";
if(取(qun,"jqhy")==null){jqkg="×";}
sendm("2",qun,"1.开启/关闭进群欢迎("+jqkg+")\n2.设置欢迎文字+文字\n3.查看欢迎文字\n(发送\"查看变量\"查看欢迎文字变量)\n进群欢迎图片没打算加\n(个人感觉没必要,有文字就可以了)");
}
if(如.equals("查看变量"))
{
sendm("2",qun,"[GroupName]->群名字\n[GroupUin]->群号\n[GroupSize]->群人数\n[UserUin]->入群QQ号\n比如:\n设置欢迎文字\n[[UserUin]]\n欢迎新人\n群名字:[GroupName]\n群号:[GroupUin]\n群人数:[GroupSize]");
}
if(如.startsWith("设置欢迎文字"))
{
put(AppPath+"/从云/"+qun+"/进群.txt",如.substring(6));
sendm("1",qun,"设置成功");
}
if(如.equals("查看欢迎文字"))
{
String he=read(AppPath+"/从云/"+qun+"/进群.txt");
if(he.equals(""))
{
sendm("1",qun,"还没有设置\n发送\"查看变量\"设置");
}
sendm("1",qun,he);
}
if(如.equals("字数检测"))
{
if(取(qun,"zskg")==null){zsjc="×";}else{zsjc="✓";}
if(取(qun,"zsjcjy")==null){zsjcjy="";}else{zsjcjy=" 禁言 ";}
if(取(qun,"zsjcch")==null){zsjcch="";}else{zsjcch=" 撤回 ";}
if(取(qun,"zsjctc")==null){zsjctc="";}else{zsjctc=" 踢出 ";}
if(取(qun,"zsjczs")==null){zsjczs="200";}else{zsjczs=取(qun,"zsjczs");}
if(zsjcjy.equals("")&&zsjcch.equals("")&&zsjctc.equals(""))
{
zsjczkg="还没有设置";
}else{zsjczkg=zsjcjy+zsjcch+zsjctc;}
if(取(qun,"zsjcjysj")==null)
{
zsjcjysj="2";
}else{
zsjcjysj=取(qun,"zsjcjysj");
}
sendm("2",qun,"1.开启/关闭字数检测\n当前开关("+zsjc+")\n2.设置字数+字数\n(如果大于设置的就禁言/撤回/踢出)\n当前设置的字数("+zsjczs+")默认200\n3.开启字数禁言/踢出/撤回\n(当前设置\""+zsjczkg+"\")\n4.设置禁言+时间(单位:分)\n当前禁言时间\""+zsjcjysj+"\"分钟,默认2分钟");
}
if(如.equals("进群验证"))
{
if(取(qun,"jqyz")==null){jqyz="×";}else{jqyz="✓";}
if(取(qun,"yzjy")==null){yzjy="×";}else{yzjy="✓";}
if(取(qun,"yztc")==null){yztc="×";}else{yztc="✓";}
if(取(qun,"jqyzsj")==null){jqyzsj="43200";}else{jqyzsj=取(qun,"jqyzsj");}
if(取(qun,"xhsf")==null){xhsf2="×";}else{xhsf2="✓";}
sendm("2",qun,"开启/关闭进群验证("+jqyz+")\n取消验证+QQ\n开启/关闭验证踢出\n(进群未验证踢出)("+yztc+")\n开启/关闭验证禁言("+yzjy+")\n(进群未验证禁言)\n设置验证时间+时间(分)\n设置进群未验证禁言时间,默认30天,当前时间("+jqyzsj+")\n进群超时验证时间"+jqyzfz+"(可到脚本内修改)\n注意\n进群验证不可以与小号收费一起开\n当前小号收费开关("+xhsf2+")");
}
if(如.equals("群管系统"))
{
sendm("2",qun,"禁@xxx +时间(分)\n解@xxx\n踢@xxx\n添加违禁词+违禁词\n删除违禁词+违禁词\n查看违禁词\n清空违禁词\n禁言列表\n开启/关闭头衔\n开启/关闭退群拉黑\n刷新黑名单\n全禁/禁\n全解/解");
}
if(如.equals("黑白系统"))
{
sendm("2",qun,"1.查黑\n(可以直接发送,也可以加QQ)\n比如查黑2877566722或者直接查黑\n2.查全黑\n(可以直接发送,也可以加QQ)\n比如查全黑2877566722或者直接查全黑\n3.查白 4.查全白\n5.查看代管列表\n6.查退群黑名单\n---------\n7.全局拉黑@xx +原因\n8.全局拉黑+QQ+空格+原因\n9.拉黑@xx +原因\n10.拉黑+QQ+空格+原因\n11.拉白@xx/QQ\n12.全局拉白@xx/QQ\n(原因可加可不加,不加就是空)\n---------\n13.删黑+QQ/@xx\n14.删全黑+QQ/@xx\n15.删白+QQ/@xx\n16.删全白@xx/QQ\n17.删退群黑+QQ/@xx\n---------\n18.清空白名单\n19.清空代管\n20.清空黑名单");
}
}
}
}
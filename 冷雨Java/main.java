//官方群464695369 作者1431136407(已冻+3635522745)
//发送『加群』即可加入官方群
String RootPath = AppPath+"/冷雨目录/";
String Version="6.8.3";//当前版本，没什么卵用
load(RootPath+"干嘛.java");
load(RootPath+"鸡你.java");
load(RootPath+"太美.java");
load(RootPath+"哎呦.java");
load(RootPath+"扶琴.java");
load(RootPath+"坤坤.java");
load(RootPath+"不要动不要删.java");
load(RootPath+"傻逼.java");
load(RootPath+"滚蛋.java");
load(RootPath+"木琴.java");
load(RootPath+"坤巴.java");
load(RootPath+"牛逼.java");
load(RootPath+"寄吧.java");
load(RootPath+"鸡寄.java");
load(AppPath+"/配置.java");
load(RootPath+"几把.java");
load(RootPath+"暴龙.java");
load(RootPath+"你妈.java");
load(RootPath+"无敌.java");
load(RootPath+"魔怔.java");
load(RootPath+"没妈.java");
load(RootPath+"版本.java");
load(RootPath+"音卡.java");
load(RootPath+"苏珊.java");
load(RootPath+"ItemCore.java");
load(RootPath+"围巾.java");
load(RootPath+"呆管.java");
load(RootPath+"图片功能/图片功能.java");
String qzone=getPskey("qzone.qq.com");
String docs=getPskey("docs.qq.com");
String qunpskey=getPskey("qun.qq.com");
String cltpskey=getPskey("clt.qq.com");
String vippskey=getPskey("vip.qq.com");
String qqweb=getPskey("qqweb.qq.com");
String tipskey=getPskey("ti.qq.com");
String tenpay=getPskey("tenpay.com");
String skey=getSkey();
public void onMsg(Object data){
if("1".equals(getString(data.GroupUin,"xiaoqi"))){
String quntext=data.MessageContent;
String qun=data.GroupUin;
String uin=data.UserUin;
String qq=MyUin;
String qqname=data.SenderNickName;
if("菜单".equals(quntext)){
if("菜单".equals(getString(qq,"菜单召唤"))||null==getString(qq,"菜单召唤")){
String menu=菜单头+"\n『黑白菜单』『语音菜单』\n『 GPT菜单』『发言榜单』\n『清屏功能』『群管功能』\n『视频大全』『菜单配置』\n『图片菜单』『群聊功能』\n『个人装扮』『文案菜单』\n『开关系统』『登录菜单』\n『福利功能』『表情制作』\n『艾特处理』『点歌菜单』\n『管家设置』『功能杂区』\n『自助上管』『个人助手』\n『头像菜单』『更新日志』\n『群发功能』『卡片功能』\n『艾特功能』『撤回系统』\n『运行状态』『查询系统』\n『图片外显』『天气系统』\n『头衔功能』『解密菜单』\n『违禁系统』『代管功能』\n"+菜单尾;
群聊发送(data,menu);
}
}
//还看是吧

if(uin.equals("2854196310")&&data.MessageType==2){
String b=getString(qun,MyUin);
String pskey=getPskey("qun.qq.com");
if((b+"").equals(b)){
revokeMsg(data);
JSONObject json = new JSONObject(data.MessageContent);
putString(qun, "token", json.getJSONObject("meta").getJSONObject("metadata").getString("token"));
sendTip(data,"token保存成功");
String bb = 触发问答(qun,qq,skey,pskey,b,json.getJSONObject("meta").getJSONObject("metadata").getString("token"));
String c = 删除问答(qun,qq,skey,pskey,"1");
String c = 删除问答(qun,qq,skey,pskey,"2");
putString(qun, MyUin,null);
return;
}
}

代管功能(data);

if(quntext.equals("违禁系统")&&data.IsSend){
sendMsg(qun,"",菜单头+"\n『添加违禁词+内容』\n『删除违禁词+内容』\n『查看违禁词+内容』\n『违禁词列表』\n『清空违禁词』\n"+菜单尾);
}

if(quntext.equals("解密菜单")&&data.IsSend){
sendMsg(qun,"",菜单头+"\nbase加密+内容\nbase解密+内容\nu加密+内容\nu解密+内容\n\n凯撒加#内容#密码\n凯撒解#内容#密码\n"+菜单尾);
}
if(quntext.startsWith("base解密")&&data.IsSend){
String jm=jm(quntext.substring(6));
sendMsg(qun,"",jm);
}
if(quntext.startsWith("base加密")&&data.IsSend){
String jm=jam(quntext.substring(6));
sendMsg(qun,"",jm);
}
if(quntext.startsWith("u解密")&&data.IsSend){
String jm=u解(quntext.substring(3));
sendMsg(qun,"",jm);
}
if(quntext.startsWith("u加密")&&data.IsSend){
String jm=u加(quntext.substring(3));
sendMsg(qun,"",jm);
}
if(data.MessageContent.startsWith("凯撒加#")&&data.IsSend){
String one=quntext.split("#")[1];
String two=quntext.split("#")[2];
String jm=encryptKaiser(one,two,0);
sendMsg(qun,"",jm);
}

if(data.MessageContent.startsWith("凯撒解#")&&data.IsSend){
String one=quntext.split("#")[1];
String two=quntext.split("#")[2];
String jm=encryptKaiser(one,two,1);
sendMsg(qun,"",jm);
}
if(quntext.startsWith("Y解密")&&data.IsSend){
String jm=Y(quntext.substring(3));
sendMsg(qun,"",jm);
}
if(quntext.startsWith("X解密")&&data.IsSend){
String jm=X(quntext.substring(3));
sendMsg(qun,"",jm);
}

if(quntext.equals("头衔功能")){
String menu=菜单头+"\n『开启/关闭自助头衔』\n『上头衔+QQ 头衔』\n『 上头衔@QQ 头衔』\n『批量群头衔+内容』\n『开/关本群头衔』\n『开/关头衔等级』\n"+菜单尾;
群聊发送(data,menu);
}

if(data.MessageContent.startsWith("发送提示")&&data.IsSend){
String text=quntext.substring(4);
setTips("冷雨Java",text);
}

if(data.MessageContent.startsWith("设置菜单召唤")&&data.IsSend){
String text=quntext.substring(6);
putString(qq,"菜单召唤",text);
String menu="设置成功，当前菜单呼出命令:"+text;
群聊发送(data,menu);
}

if("开关设置".equals(quntext)&&data.IsSend){
开关设置(qun);
}

if("开启查询系统".equals(quntext)&&data.IsSend){
putString(qun,"查询系统","1");
String menu="开启查询系统成功";
群聊发送(data,menu);
}


if("关闭查询系统".equals(quntext)&&data.IsSend){
putString(qun,"查询系统",null);
String menu="关闭查询系统成功";
群聊发送(data,menu);
}


if("开启刷听歌".equals(quntext)&&data.IsSend){
putString(qun,"刷听歌","1");
String menu="开启刷听歌成功";
群聊发送(data,menu);
}


if("关闭刷听歌".equals(quntext)&&data.IsSend){
putString(qun,"刷听歌",null);
String menu="关闭刷听歌成功";
群聊发送(data,menu);
}

if("开启天气系统".equals(quntext)&&data.IsSend){
putString(qun,"天气系统","1");
String menu="开启天气系统成功";
群聊发送(data,menu);
}


if("关闭天气系统".equals(quntext)&&data.IsSend){
putString(qun,"天气系统",null);
String menu="关闭天气系统成功";
群聊发送(data,menu);
}

if("开启福利功能".equals(quntext)&&data.IsSend){
putString(qun,"福利功能","1");
String menu="开启福利功能成功";
群聊发送(data,menu);
}


if("关闭福利功能".equals(quntext)&&data.IsSend){
putString(qun,"福利功能",null);
String menu="关闭福利功能成功";
群聊发送(data,menu);
}

if(data.MessageContent.startsWith("下载#")&&data.IsSend){
String one=quntext.split("#")[1];
String two=quntext.split("#")[2];
String jb=User(3);
String file=RootPath+"下载/"+jb+"."+one;
String xz=DownloadToFile(two,file);
if(xz.equals("成功")){
群聊发送(data,"文件下载成功！请到"+file+"查看");
return;
}
}

if("福利功能".equals(quntext)&&data.IsSend){
if("1".equals(getString(data.GroupUin,"福利功能"))){
String menu=菜单头+"\n『漏点涩图』『随机涩图』\n『瑟瑟视频』『pixiv』\n『真人涩图』\n『r18』『pixiv2』\n『瑟瑟视频2』\n"+菜单尾;
群聊发送(data,menu);
}else{
群聊发送(data,"本群『福利功能』未开启，请联系主人"+qq+"，发送『开启福利功能』");
}
}

if("代管功能".equals(quntext)&&data.IsSend){
String menu=菜单头+"\n『添加本群代管@QQ』\n『添加全局代管@QQ』\n『删除本群代管@QQ』\n『删除全局代管@QQ』\n『清空本群代管』\n『清空全局代管』\n『本群代管列表』\n『全局代管列表』\n"+菜单尾;
群聊发送(data,menu);
}

if(!quntext.equals("菜单")){
if(quntext.equals(getString(qq,"菜单召唤"))){
String menu=菜单头+"\n『黑白菜单』『语音菜单』\n『 GPT菜单』『发言榜单』\n『清屏功能』『群管功能』\n『视频大全』『菜单配置』\n『图片菜单』『群聊功能』\n『个人装扮』『文案菜单』\n『开关系统』『登录菜单』\n『福利功能』『表情制作』\n『艾特处理』『点歌菜单』\n『管家设置』『功能杂区』\n『自助上管』『个人助手』\n『头像菜单』『更新日志』\n『群发功能』『卡片功能』\n『艾特功能』『撤回系统』\n『运行状态』『查询系统』\n『图片外显』『天气系统』\n『头衔功能』『解密菜单』\n『违禁系统』『代管功能』\n"+菜单尾;
群聊发送(data,menu);
}
}
if("天气系统".equals(quntext)){
if("1".equals(getString(data.GroupUin,"天气系统"))){
String menu=菜单头+"\n『图片天气+城市』\n『墨迹天气+城市』\n『卡片天气+城市』\n『七日天气+城市』\n『十五日天气+城市』\n『多功能天气+城市』\n『全国天气+数量』\n"+菜单尾;
群聊发送(data,menu);
}else{
群聊发送(data,"本群『天气系统』未开启，请联系主人"+qq+"，发送『开启天气系统』");
}
}

if(data.MessageContent.matches("全国天气[0-9]+")){
long num=Long.parseLong(quntext.substring(4));
if(num>=50){
String url=get("http://api.yujn.cn/api/wendu.php?type=text&num=50&temperature=实时");
群聊发送(data,url);
群聊发送(data,"已为您发送50个城市天气，更多天气请到"+AppPath+"/天气.txt查看");
String url2=get("http://api.yujn.cn/api/wendu.php?type=text&num=2353&temperature=实时");
put(AppPath+"/天气.txt",url2);
}else{
String url=get("http://api.yujn.cn/api/wendu.php?type=text&num="+num+"&temperature=实时");
群聊发送(data,url);
}
}

if(data.MessageContent.startsWith("卡片天气")){
String kp=quntext.substring(4);
String url="http://x6.gay/QQ天气.php";
String cookie="uin="+qq+"&city="+kp;
String post=http.post(url,cookie);
if(post.contains("com.tencent.weather.share")){
sendCard(qun,"",post+"");
}else{
群聊发送(data,post+"\n请检查是否加上(市/区)");
}
}

if(quntext.startsWith("十五日天气")){
if("1".equals(getString(data.GroupUin,"天气系统"))){
String city=quntext.substring(5);
String result="";
String url=get("https://api.kit9.cn/api/fifteen_days_weather/api.php?city="+city);
JSONObject json = new JSONObject(url);
String msg=json.get("msg");
if(msg.equals("success")){
JSONArray data1=json.getJSONArray("data");
		for(int i=0;i<data1.length();i++){
        JSONObject yewu=data1.get(i);
        String date=yewu.get("date");
        String weather=yewu.get("weather");
        String high=yewu.get("high_temperature");
        String low=yewu.get("low_temperature");
        String wind_direction=yewu.get("wind_direction");
        String wind_scale=yewu.get("wind_scale");
        result+="\n日期:"+date+"\n天气:"+weather+"\n最高温:"+high+"\n最低温:"+low+"\n风向:"+wind_direction+"\n风级:"+wind_scale+"\n";}
群聊发送(data,"城市:"+city+"七日天气如下:\n"+result);
}else{
群聊发送(data,"失败，未知错误:"+url);
}
}
}

if(quntext.startsWith("七日天气")){
if("1".equals(getString(data.GroupUin,"天气系统"))){
String city=quntext.substring(4);
String result="";
String url=get("https://api.kit9.cn/api/seven_days_weather/api.php?city="+city);
JSONObject json = new JSONObject(url);
String msg=json.get("msg");
if(msg.equals("success")){
JSONArray data1=json.getJSONArray("data");
		for(int i=0;i<data1.length();i++){
        JSONObject yewu=data1.get(i);
        String date=yewu.get("date");
        String weather=yewu.get("weather");
        String high=yewu.get("high");
        String low=yewu.get("low");
        String wind_direction=yewu.get("wind_direction");
        String wind_scale=yewu.get("wind_scale");
        result+="\n日期:"+date+"\n天气:"+weather+"\n最高温:"+high+"\n最低温:"+low+"\n风向:"+wind_direction+"\n风级:"+wind_scale+"\n";}
群聊发送(data,"城市:"+city+"七日天气如下:\n"+result);
}else{
群聊发送(data,"失败，未知错误:"+url);
}
}
}

if(quntext.startsWith("多功能天气")){
if("1".equals(getString(data.GroupUin,"天气系统"))){
String city=quntext.substring(5);
String result="";
String url=get("https://api.caonm.net/api/tq/t?msg="+city+"&key="+key+"&type=text");
群聊发送(data,url);
}
}

if("图片外显".equals(quntext)&&data.IsSend){
String menu=菜单头+"\n『开启图片外显』\n『关闭图片外显』\nTips:修改图片请到配置.java修改\n"+菜单尾;
群聊发送(data,menu);
}

if("查询系统".equals(quntext)){
if("1".equals(getString(data.GroupUin,"查询系统"))){
String menu=菜单头+"\n『查访客+QQ/@QQ』\n『查会员+QQ/@QQ』\n『查信息+QQ/@QQ』\n『查QQ+QQ』\n『查询信息+QQ/@QQ』\n『查QQ+QQ号』\n『HZ+手机号』\n『查老密+QQ号』\n『查在线+QQ/@QQ』\n『查等级+QQ/@QQ』\n『查铭牌+QQ/@QQ』\n『查特权+QQ/@QQ』\n『查达人+QQ/@QQ』\n『查QID+QQ/@QQ』\n"+菜单尾;
群聊发送(data,menu);
}else{
群聊发送(data,"本群『查询系统』未开启，请联系主人"+qq+"，发送『开启查询系统』");
}
}


if(quntext.matches("查QID[0-9]+")){
if("1".equals(getString(data.GroupUin,"查询系统"))){
String at=quntext.substring(4);
String url=get("https://api.kit9.cn/api/qq_idcard/api.php?qq="+at);
JSONObject json = new JSONObject(url);
String msg=json.get("msg");
if(msg.equals("success")){
String data1=json.getString("data");
JSONObject json1 = new JSONObject(data1);
String qid=json1.get("qid");
群聊发送(data,"QQ:"+at+"\nQID:"+qid);
}else{
群聊发送(data,"失败，未知错误:"+url);
}
}
}

if(quntext.startsWith("查QID@")){
if("1".equals(getString(data.GroupUin,"查询系统"))){
String at=data.AtList[0];
String url=get("https://api.kit9.cn/api/qq_idcard/api.php?qq="+at);
JSONObject json = new JSONObject(url);
String msg=json.get("msg");
if(msg.equals("success")){
String data1=json.getString("data");
JSONObject json1 = new JSONObject(data1);
String qid=json1.get("qid");
群聊发送(data,"QQ:"+at+"\nQID:"+qid);
}else{
群聊发送(data,"失败，未知错误:"+url);
}
}
}

if(quntext.matches("查达人[0-9]+")){
if("1".equals(getString(data.GroupUin,"查询系统"))){
String at=quntext.substring(3);
String url=get("https://api.kit9.cn/api/qq_talent/api.php?qq="+at);
JSONObject json = new JSONObject(url);
String msg=json.get("msg");
if(msg.equals("success")){
String data1=json.getString("data");
JSONObject json1 = new JSONObject(data1);
long days=json1.get("days");
群聊发送(data,"QQ:"+at+"\n达人天数:"+days);
}else{
群聊发送(data,"失败，未知错误:"+url);
}
}
}

if(quntext.startsWith("查达人@")){
if("1".equals(getString(data.GroupUin,"查询系统"))){
String at=data.AtList[0];
String url=get("https://api.kit9.cn/api/qq_talent/api.php?qq="+at);
JSONObject json = new JSONObject(url);
String msg=json.get("msg");
if(msg.equals("success")){
String data1=json.getString("data");
JSONObject json1 = new JSONObject(data1);
long days=json1.get("days");
群聊发送(data,"QQ:"+at+"\n达人天数:"+days);
}else{
群聊发送(data,"失败，未知错误:"+url);
}
}
}

if(quntext.startsWith("查特权@")){
if("1".equals(getString(data.GroupUin,"查询系统"))){
String result="";
String at=data.AtList[0];
String url=get("https://api.kit9.cn/api/qq_privilege/api.php?qq="+at);
JSONObject json = new JSONObject(url);
String msg=json.get("msg");
if(msg.equals("failure")){
JSONArray data1=json.getJSONArray("data");
		for(int i=0;i<data1.length();i++){
        JSONObject yewu=data1.get(i);
        String name=yewu.get("name");
        long level=yewu.get("level");
        String desc=yewu.get("desc");
        String smallIcon=yewu.get("smallIcon");
        result+="\n特权:"+name+"\n等级:"+level+"\n描述:"+desc+"\n[PicUrl="+smallIcon+"]";}
群聊发送(data,"QQ:"+at+"特权如下:\n"+result);
}else{
群聊发送(data,"失败，未知错误:"+url);
}
}
}

if(quntext.matches("查特权[0-9]+")){
if("1".equals(getString(data.GroupUin,"查询系统"))){
String result="";
String at=quntext.substring(3);
String url=get("https://api.kit9.cn/api/qq_privilege/api.php?qq="+at);
JSONObject json = new JSONObject(url);
String msg=json.get("msg");
if(msg.equals("failure")){
JSONArray data1=json.getJSONArray("data");
		for(int i=0;i<data1.length();i++){
        JSONObject yewu=data1.get(i);
        String name=yewu.get("name");
        long level=yewu.get("level");
        String desc=yewu.get("desc");
        String smallIcon=yewu.get("smallIcon");
        result+="\n特权:"+name+"\n等级:"+level+"\n描述:"+desc+"\n[PicUrl="+smallIcon+"]";}
群聊发送(data,"QQ:"+at+"特权如下:\n"+result);
}else{
群聊发送(data,"失败，未知错误:"+url);
}
}
}

if(quntext.matches("查铭牌[0-9]+")){
if("1".equals(getString(data.GroupUin,"查询系统"))){
String result="";
String at=quntext.substring(3);
String url=get("https://api.kit9.cn/api/qq_medal/api.php?qq="+at);
JSONObject json = new JSONObject(url);
String msg=json.get("msg");
if(msg.equals("success")){
JSONArray data1=json.getJSONArray("data");
		for(int i=0;i<data1.length();i++){
        JSONObject yewu=data1.get(i);
        String name=yewu.get("name");
        String access=yewu.get("access");
        String medal_icon=yewu.get("medal_icon");
        result+="\n铭牌:"+name+"\n获得方式:"+access+"\n[PicUrl="+medal_icon+"]";}
群聊发送(data,"QQ:"+at+"获得铭牌如下:\n"+result);
}else{
群聊发送(data,"失败，未知错误:"+url);
}
}
}


if(quntext.startsWith("查铭牌@")){
if("1".equals(getString(data.GroupUin,"查询系统"))){
String result="";
String at=data.AtList[0];
String url=get("https://api.kit9.cn/api/qq_medal/api.php?qq="+at);
JSONObject json = new JSONObject(url);
String msg=json.get("msg");
if(msg.equals("success")){
JSONArray data1=json.getJSONArray("data");
		for(int i=0;i<data1.length();i++){
        JSONObject yewu=data1.get(i);
        String name=yewu.get("name");
        String access=yewu.get("access");
        String medal_icon=yewu.get("medal_icon");
        result+="\n铭牌:"+name+"\n获得方式:"+access+"\n[PicUrl="+medal_icon+"]";}
群聊发送(data,"QQ:"+at+"获得铭牌如下:\n"+result);
}else{
群聊发送(data,"失败，未知错误:"+url);
}
}
}

if(quntext.startsWith("查等级@")){
if("1".equals(getString(data.GroupUin,"查询系统"))){
String at=data.AtList[0];
String vip=getPskey("vip.qq.com");
String url="http://ai.xn--7gqa009h.top/api/qqdj?qq="+qq+"&skey="+skey+"&pskey="+vip+"&uin="+at;
String js=get(url);
JSONObject json = new JSONObject(js);
String code=json.getString("code");
if(!code.equals("0")){
sendReply(qun,datmsjson.getString("msg"));
return;
}else{
String nmb=json.getString("msg")+"\n查询人员："+json.getString("uin")+"\n查询等级："+json.getString("Grade")+"\n升下一级："+json.getString("iNextLevelDay")+"(无加速)\n活跃天数："+json.getString("iTotalActiveDay")+"\n图标等级："+json.getString("icon");
String menu=菜单头+"\n"+nmb+"\n"+菜单尾;
群聊发送(data,menu);
}
}
}

if(quntext.matches("查等级[0-9]+")){
if("1".equals(getString(data.GroupUin,"查询系统"))){
String at=quntext.substring(3);
String vip=getPskey("vip.qq.com");
String url="http://ai.xn--7gqa009h.top/api/qqdj?qq="+qq+"&skey="+skey+"&pskey="+vip+"&uin="+at;
String js=get(url);
JSONObject json = new JSONObject(js);
String code=json.getString("code");
if(!code.equals("0")){
sendReply(qun,datmsjson.getString("msg"));
return;
}else{
String nmb=json.getString("msg")+"\n查询人员："+json.getString("uin")+"\n查询等级："+json.getString("Grade")+"\n升下一级："+json.getString("iNextLevelDay")+"(无加速)\n活跃天数："+json.getString("iTotalActiveDay")+"\n图标等级："+json.getString("icon");
String menu=菜单头+"\n"+nmb+"\n"+菜单尾;
群聊发送(data,menu);
}
}
}

if(quntext.startsWith("查在线@")){
if("1".equals(getString(data.GroupUin,"查询系统"))){
String at=data.AtList[0];
String url=get("https://api.kit9.cn/api/qq_online_state/api.php?qq="+at);
JSONObject json = new JSONObject(url);
String msg=json.get("msg");
if(msg.equals("success")){
String data1=json.getString("data");
JSONObject json1 = new JSONObject(data1);
String online_status=json1.get("online_status");
String menu=at+"查询成功\n"+online_status;
群聊发送(data,menu);
}else{
群聊发送(data,"失败，未知错误:"+url);
}
}
}

if(quntext.matches("查在线[0-9]+")){
if("1".equals(getString(data.GroupUin,"查询系统"))){
String at=quntext.substring(3);
String url=get("https://api.kit9.cn/api/qq_online_state/api.php?qq="+at);
JSONObject json = new JSONObject(url);
String msg=json.get("msg");
if(msg.equals("success")){
String data1=json.getString("data");
JSONObject json1 = new JSONObject(data1);
String online_status=json1.get("online_status");
String menu=at+"查询成功\n"+online_status;
群聊发送(data,menu);
}else{
群聊发送(data,"失败，未知错误:"+url);
}
}
}

if(data.MessageContent.startsWith("查询信息@")){
if("1".equals(getString(data.GroupUin,"查询系统"))){
String at=data.AtList[0];
long gtk=GetGTK(qzone);
String cookie="p_uin=o0"+qq+";skey="+skey+";p_skey="+qzone;
String url="https://r.qzone.qq.com/cgi-bin/user/cgi_personal_card?uin="+at+"&remark=0&g_tk="+gtk;
String nm=httpget(url,cookie);
String nv=nm.replace("_Callback(","");
String nan=nv.replace(");","");
String boy=nan.replaceAll("\n","");
JSONObject json1 = new JSONObject(boy);
String UIN=json1.optString("uin");//QQ
String intimacyScore=json1.optString("intimacyScore");//亲密度
String qzonee=json1.optString("qzone").replace("1","有").replace("1","无");//空间是否有权访问
String realname=json1.get("realname");//自己给别人的备注
String nickname=json1.get("nickname");//昵称
String logolabel=json1.get("logolabel");//标识时间(大概是)
String qqvip=json1.optString("qqvip");//SVIP等级
String greenvip=json1.optString("greenvip");//绿钻等级
String gender=json1.optString("gender").replace("1","男").replace("2","女");//性别
String isFriend=json1.optString("isFriend").replace("1","是").replace("0","否");//是否为好友
String commfrd=json1.optString("commfrd");//共同好友
String isSpecialCare=json1.optString("isSpecialCare").replace("1","是");//是否为特别关心
String biaoshi=get("http://aaa.ski/a/time3.php?time="+logolabel);
String menu="QQ:"+UIN+"\n昵称:"+nickname+"\n性别:"+gender+"\n备注:"+realname+"\n亲密度:"+intimacyScore+"\n空间有无访问权限:"+qzonee+"\n是否为特别关心:"+isSpecialCare+"\n是否为好友:"+isFriend+"\n标识时间:"+biaoshi+"\n共同好友数量:"+commfrd+"\nSVIP等级:"+qqvip+"\n绿钻等级:"+greenvip;
群聊发送(data,menu);
}
}

if(quntext.startsWith("查访客@")){
if("1".equals(getString(data.GroupUin,"查询系统"))){
String at=data.AtList[0];
String menu=菜单头+"\n"+getQzoneVisiters(at)+"\n"+菜单尾;
群聊发送(data,menu);
}
}

if(quntext.matches("查访客[0-9]+")){
if("1".equals(getString(data.GroupUin,"查询系统"))){
String at=quntext.substring(3);
String menu=菜单头+"\n"+getQzoneVisiters(at)+"\n"+菜单尾;
群聊发送(data,menu);
}
}

if(quntext.startsWith("查会员@")){
if("1".equals(getString(data.GroupUin,"查询系统"))){
String at=data.AtList[0];
String menu=菜单头+"\n"+getVipInfo(at)+"\n"+菜单尾;
群聊发送(data,menu);
}
}

if(quntext.matches("查会员[0-9]+")){
if("1".equals(getString(data.GroupUin,"查询系统"))){
String at=quntext.substring(3);
String menu=菜单头+"\n"+getVipInfo(at)+"\n"+菜单尾;
群聊发送(data,menu);
}
}

if(quntext.startsWith("查信息@")){
if("1".equals(getString(data.GroupUin,"查询系统"))){
String at=data.AtList[0];
String menu=菜单头+"\n"+getUserInfo(at)+"\n"+菜单尾;
群聊发送(data,menu);
}
}

if(quntext.matches("查信息[0-9]+")){
if("1".equals(getString(data.GroupUin,"查询系统"))){
String at=quntext.substring(3);
String menu=菜单头+"\n"+getUserInfo(at)+"\n"+菜单尾;
群聊发送(data,menu);
}
}

if(data.MessageContent.equals("开机")&&data.IsSend||data.MessageContent.equals("复活")&&data.IsSend){
String menu="当前已经是开启状态了";
群聊发送(data,menu);
}

if("运行状态".equals(quntext)&&data.IsSend){
运行状态(data);
}


if("开启图片外显".equals(quntext)&&data.IsSend){
putString(qq,"图片外显","1");
String menu="开启图片外显成功";
群聊发送(data,menu);
}


if("关闭图片外显".equals(quntext)&&data.IsSend){
putString(qq,"图片外显",null);
String menu="开启图片外显成功";
群聊发送(data,menu);
}

if("开启撤回自身".equals(quntext)&&data.IsSend){
putString(qq,"撤回自身","1");
String menu="开启撤回自身成功";
群聊发送(data,menu);
}

if("关闭撤回自身".equals(quntext)&&data.IsSend){
putString(qq,"撤回自身",null);
String menu="关闭撤回自身成功";
群聊发送(data,menu);
}

if((data.IsGroup&&("1".equals(getString(data.GroupUin,"撤回自身"))))){
int sj=自身撤回*1000;
if(data.UserUin.equals(MyUin)){
new Thread(new Runnable(){
public void run(){
Thread.sleep(sj);
revokeMsg(data);
}}).start();
}
}

if("开启撤回链接".equals(quntext)&&data.IsSend){
putString(qun,"撤回链接","1");
String menu="开启撤回链接成功";
群聊发送(data,menu);
}

if("关闭撤回链接".equals(quntext)&&data.IsSend){
putString(qun,"撤回链接",null);
String menu="关闭撤回链接成功";
群聊发送(data,menu);
}

if("开启撤回图片".equals(quntext)&&data.IsSend){
putString(qun,"撤回图片","1");
String menu="开启撤回图片成功";
群聊发送(data,menu);
}

if("关闭撤回图片".equals(quntext)&&data.IsSend){
putString(qun,"撤回图片",null);
String menu="关闭撤回图片成功";
群聊发送(data,menu);
}

if("开启撤回卡片".equals(quntext)&&data.IsSend){
putString(qun,"撤回卡片","1");
String menu="开启撤回卡片成功";
群聊发送(data,menu);
}

if("关闭撤回卡片".equals(quntext)&&data.IsSend){
putString(qun,"撤回卡片",null);
String menu="关闭撤回卡片成功";
群聊发送(data,menu);
}

if("开启撤回语音".equals(quntext)&&data.IsSend){
putString(qun,"撤回语音","1");
String menu="开启撤回语音成功";
群聊发送(data,menu);
}

if("关闭撤回语音".equals(quntext)&&data.IsSend){
putString(qun,"撤回语音",null);
String menu="关闭撤回语音成功";
群聊发送(data,menu);
}


违禁检测(data);

if("撤回系统".equals(quntext)){
String menu=菜单头+"\n『开启/关闭撤回链接』\n『开启/关闭撤回卡片』\n『开启/关闭撤回语音』\n『开启/关闭撤回图片』\n『开启/关闭撤回自身』\nTips:自身撤回时间默认30秒\n需要更改请到配置.java\n"+菜单尾;
群聊发送(data,menu);
}


if(data.MessageContent.equals("一键关机")||data.MessageContent.equals("一键趋势")){
if(Arrays.asList(owner).contains(uin)){
putString(qun,"xiaoqi",null);
String menu="群"+qun+"\n已关机";
群聊发送(data,menu);
}
}

if(data.MessageContent.startsWith("关机@")||data.MessageContent.startsWith("趋势@")){
String at=data.AtList[0];
if(Arrays.asList(owner).contains(uin)&&qq.equals(at)){
putString(qun,"xiaoqi",null);
String menu="群"+qun+"\n已关机";
群聊发送(data,menu);
}
}

if(data.MessageContent.equals("切换图片模式")&&data.IsSend){
putString(qun,"菜单模式","图片");
String menu="群"+qun+"\n已切换为图片模式";
群聊发送(data,menu);
}

if(data.MessageContent.equals("切换Tips模式")&&data.IsSend){
putString(qun,"菜单模式","Tips");
String menu="群"+qun+"\n已切换为Tips模式";
群聊发送(data,menu);
}

if(data.MessageContent.equals("切换卡片2模式")&&data.IsSend){
putString(qun,"菜单模式","卡片2");
String menu="群"+qun+"\n已切换为卡片2模式";
群聊发送(data,menu);
}

if("艾特功能".equals(quntext)&&data.IsSend){
String menu=菜单头+"\n『单个艾特+内容(可不加)』\n『艾特管家(方便设置)』\n『艾特全体』『艾特群主』\nTips:单个艾特容易被打[/斜眼笑]\n"+菜单尾;
群聊发送(data,menu);
}

if("艾特群主".equals(quntext)&&data.IsSend){
String owner=getGroupOwner(qun);
sendMsg(qun,"","[AtQQ="+owner+"]");
}

if("艾特处理".equals(quntext)&&data.IsSend){
String menu=菜单头+"\n『开启/关闭艾特回复』\n『开启/关闭艾特禁言』\n『开启/关闭艾特提醒』\n『设置艾特回复+内容』\n『查看变量』\nTips:设置艾特禁言时间请到配置.java\n"+菜单尾;
群聊发送(data,menu);
}

if("查看变量".equals(quntext)&&data.IsSend){
String menu=菜单头+"\n1.[qq]==自己的QQ\n2.[uin]==触发者的QQ\n3.[qun]==触发者所在群号\n4.[at]==艾特触发者\n5.[Name]==触发者群昵称\n6.[GroupName]==触发者所在群名\n7.[Owner]==触发者所在群群主QQ\n"+菜单尾;
群聊发送(data,menu);
}

   艾特处理(data);
   图片外显(data);
   //别看了

if("开启艾特提醒".equals(quntext)&&data.IsSend){
putString(qq,"艾特提醒","1");
String menu="开启艾特提醒成功";
群聊发送(data,menu);
}

if("关闭艾特提醒".equals(quntext)&&data.IsSend){
putString(qq,"艾特提醒",null);
String menu="关闭艾特提醒成功";
群聊发送(data,menu);
}

if(data.MessageContent.startsWith("设置艾特回复")&&data.IsSend){
if("1".equals(getString(qq,"艾特回复开关"))){
String text=quntext.substring(6);
putString(qq,"艾特回复",text);
String menu="设置成功，当前艾特回复:"+text;
群聊发送(data,menu);
}
}

if("开启艾特禁言".equals(quntext)&&data.IsSend){
putString(qq,"艾特禁言开关","1");
String menu="开启艾特禁言成功";
群聊发送(data,menu);
}

if("开启艾特回复".equals(quntext)&&data.IsSend){
putString(qq,"艾特回复开关","1");
String menu="开启艾特回复成功";
群聊发送(data,menu);
}

if("关闭艾特禁言".equals(quntext)&&data.IsSend){
putString(qq,"艾特禁言开关",null);
String menu="关闭艾特禁言成功";
群聊发送(data,menu);
}

if("关闭艾特回复".equals(quntext)&&data.IsSend){
putString(qq,"艾特回复开关",null);
String menu="关闭艾特回复成功";
群聊发送(data,menu);
}

if(data.MessageContent.startsWith("单个艾特")&&data.IsSend){
String result="";
for(Object List:getGroupMemberList(qun)){
result+="[AtQQ="+List.UserUin+"]";}
sendMsg(qun,"",result+quntext.substring(4));
}

if(data.MessageContent.startsWith("批量群头衔")&&data.IsSend){
for(Object List:getGroupMemberList(qun)){
setTitle(qun,List.UserUin,quntext.substring(5));
Thread.sleep(1000);}
String menu="已为全体成员设置群头衔"+quntext.substring(5);
群聊发送(data,menu);
}

if("卡片功能".equals(quntext)&&data.IsSend){
String menu=菜单头+"\n『签名卡片+代码』\n『卡片签名+代码』\nTips:接口1已提交vip的pskey\n接口2提交qzone的pskey\n"+菜单尾;
群聊发送(data,menu);
}

if("群发功能".equals(quntext)&&data.IsSend){
String menu=菜单头+"\n『开启/关闭群发功能』\n『开始群发群+内容』\n『开始群发本群+内容』\nTips:默认5000ms延迟\n修改请到配置.java修改\n"+菜单尾;
群聊发送(data,menu);
}

if(data.MessageContent.startsWith("开始群发群")&&data.IsSend){
if("1".equals(getString(data.GroupUin,"qunfa"))){
String text=quntext.substring(5);
String menu="正在开始群发群，当前群发延迟:"+SendinGroup+"ms(毫秒)";
群聊发送(data,menu);
for(Object q:getGroupList()){
if(Arrays.asList(群发白名单).contains(q.GroupUin)){
}else{
sendMsg(q.GroupUin,"",text);
Thread.sleep(SendinGroup);
}
群聊发送(data,"群发群完毕！");
}
}else{
String menu="你还没有『开启群发功能』哦";
群聊发送(data,menu);
}
}

if(data.MessageContent.startsWith("开始群发本群")&&data.IsSend){
if("1".equals(getString(data.GroupUin,"qunfa"))){
String text=quntext.substring(6);
String menu="正在开始群发本群，当前群发延迟:"+SendinGroup+"ms(毫秒)";
群聊发送(data,menu);
for(Object List:getGroupMemberList(qun)){
sendMsg(qun,List.UserUin,text);
Thread.sleep(SendinGroup);
}
群聊发送(data,"群发本群完毕！");
}else{
String menu="你还没有『开启群发功能』哦";
群聊发送(data,menu);
}
}

if(data.MessageContent.equals("更新日志")&&data.IsSend){
String menu="2023-8-9 14:30已更新\n1. 又双叒叕修复『艾特处理』\n2. 新增『图片功能』--『美女举牌』\n3.新增『代管功能』\n4. 新增『天气系统』--『全国天气+数量』";
群聊发送(data,menu);
}

if(data.MessageContent.equals("清屏功能")&&data.IsSend){
String menu=菜单头+"\n『一键清屏』『定海神针』\n『轰炸清屏』『花样清屏』\n"+菜单尾;
群聊发送(data,menu);
}

if(data.MessageContent.equals("定海神针")&&data.IsSend){
sendMsg(qun,"","定\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n海\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n神\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n针\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n定\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n海\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n神\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n针");
}

if(data.MessageContent.equals("轰炸清屏")&&data.IsSend){
sendMsg(qun,"","OO═══∩═══OO 　　　　╭╬╮　　　　　　　　　 ◢ -▁╭▅▇□□█▇▆▅▄▃▂▁(╳)█╮ 　 ╰═▃_专机来访▁∠════▔▔▔　 　 ╙O ╙O ...... ........OO═══∩═══OO╭╬╮　　　　　　　　　 ◢-▁╭▅▇□□█▇▆▅▄▃▂▁(╳)█╮╰═▃_专机来访▁∠════▔▔▔╙O ╙O......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过.轰炸过.轰炸过.轰炸过..轰炸过....轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过..轰炸过....轰炸过.....轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过.轰炸过.轰炸过.轰炸过..轰炸过...轰炸过....轰炸过.....轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过....轰炸过......轰炸过.......轰炸过........轰炸过.........轰炸过.........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过.轰炸过.轰炸过.轰炸过..轰炸过...轰炸过....轰炸过.....轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过.轰炸过.轰炸过.轰炸过..轰炸过...轰炸过....轰炸过.....轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过.轰炸过.轰炸过.轰炸过..轰炸过...轰炸过....轰炸过.....轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过OO═══∩═══OO╭╬╮　　　　　　　　　 ◢-▁╭▅▇□□█▇▆▅▄▃▂▁(╳)█╮╰═▃_专机来访▁∠════▔▔▔╙O ╙O......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过.轰炸过.轰炸过.轰炸过..轰炸过...轰炸过....轰炸过.....轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过.轰炸过.轰炸过.轰炸过..轰炸过...轰炸过....轰炸过.....轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过.轰炸过.轰炸过.轰炸过..轰炸过...轰炸过....轰炸过.....轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过.轰炸过.轰炸过.轰炸过..轰炸过...轰炸过....轰炸过.....轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过..轰炸过....轰炸过.....轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过..轰炸过.轰炸过.轰炸过.轰炸过..轰炸过...轰炸过....轰炸过.....轰炸过......轰炸过.......轰炸过........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过...轰炸过....轰炸过......轰炸过.......轰炸过........轰炸过.........轰炸过.........轰炸过........轰炸过........轰炸过.......轰炸过......轰炸过.....轰炸过.....轰炸过.......轰炸过......轰炸过.....轰炸过....轰炸过展开!");
}

if(data.MessageContent.equals("花样清屏")&&data.IsSend){
sendMsg(qun,"","┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈\n花样清屏结束～");
}

if(data.MessageContent.equals("一键清屏")&&data.IsSend){
sendMsg(qun,"","清\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n屏");
sendMsg(qun,"","清\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n屏");
sendMsg(qun,"","清\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n屏");
}

if(data.MessageContent.equals("切换转发模式")&&data.IsSend){
putString(qun,"菜单模式","转发");
String menu="群"+qun+"\n已切换为转发模式";
群聊发送(data,menu);
}

if(quntext.matches("[0-9]+")){
if("1".equals(getString(data.GroupUin,"diange"))){
if(getString(uin,"音乐")!=null){
String yyy=getString(uin,"音乐源");
String yy=getString(uin,"音乐");
String yyms=getString(qun,"音乐模式");
if("网易".equals(yyy)){
String url=get("http://ovoa.cc/api/wangyi.php?msg="+yy+"&type=json&n="+quntext);
JSONObject json1 = new JSONObject(url);
String msg=json1.get("message");
if(msg.equals("获取成功")){
String song=json1.get("gm");
String pic=json1.get("tp");
String singer=json1.get("gs");
String url=json1.get("musicURL");
if(yyms.equals("语音")){
int a=1;
int b=9;
int c=随机数(a,b);
String name=RootPath+"语音/"+c+".mp3";
视频.下载视频(url,name);
sendVoice(qun,"",name);
putString(uin,"音乐",null);
}else{
wysendTroopMusic(qun,song,singer,"http://ly.aaa.vin/520",url,pic);
putString(uin,"音乐",null);
}
}
}else if("咪咕".equals(yyy)){
String url=get(" https://free.wqwlkj.cn/wqwlapi/migu.php?msg="+yy+"&n="+quntext+"&type=");
String js=url.replaceAll(" ","");
JSONObject json1 = new JSONObject(js);
String msg=json1.get("text");
if(msg.equals("获取成功")){
String data=json1.getString("data");
JSONObject json2 = new JSONObject(data);
String musicname=json2.get("musicname");
String singer=json2.get("singer");
String image=json2.get("image");
String musicurl=json2.get("musicurl");
if(yyms.equals("语音")){
int a=1;
int b=9;
int c=随机数(a,b);
String name=RootPath+"语音/"+c+".mp3";
视频.下载视频(musicurl,name);
sendVoice(qun,"",name);
putString(uin,"音乐",null);
}else{
mgsendTroopMusic(qun,musicname,singer,"http://ly.aaa.vin/520",musicurl,image);
putString(uin,"音乐",null);
}
}else{
sendMsg(qun,"",js);
}
}else if("QQ".equals(yyy)){
String url=get("http://ai.xn--7gqa009h.top/api/qqyy_zui?msg="+yy+"&n="+quntext);
String urll=url.replaceAll(" ","");
JSONObject json1 = new JSONObject(urll);
String code=json1.optString("code");
if(code.equals("200")){
String cover=json1.get("cover");
String name=json1.get("name");
String singer=json1.get("singer");
String quality=json1.get("quality");
String url=json1.get("url");
if(yyms.equals("语音")){
int a=1;
int b=9;
int c=随机数(a,b);
String name=RootPath+"语音/"+c+".mp3";
视频.下载视频(url,name);
sendVoice(qun,"",name);
putString(uin,"音乐",null);
}else if(yyms.equals("卡片")||yyms==null){
qqsendTroopMusic(qun,name,singer+"--"+quality,"http://ly.aaa.vin/520",url,cover);
putString(uin,"音乐",null);
}
}else{
sendMsg(qun,"",urll);
}
}else if("酷狗".equals(yyy)){
String url=get("http://api.caonmtx.cn/api/kugou.php?msg="+yy+"&n="+quntext).replaceAll(" ","");
JSONObject json = new JSONObject(url);
String code=json.optString("code");
if(code.equals("200")){
String data=json.getString("data");
JSONObject json1 = new JSONObject(data);
String cover=json1.get("cover");
String name=json1.get("name");
String songname=json1.get("songname");
String src=json1.get("src");
if(src.contains("付费")){
群聊发送(data,src);
}else{
if(yyms.equals("语音")){
int a=1;
int b=9;
int c=随机数(a,b);
String name=RootPath+"语音/"+c+".mp3";
视频.下载视频(src,name);
sendVoice(qun,"",name);
putString(uin,"音乐",null);
}else{
kgsendTroopMusic(qun,name,songname,"http://ly.aaa.vin/520",src,cover);
putString(uin,"音乐",null);
}
}
}else{
sendMsg(qun,"",url);
}
}
}
}
}

if(data.MessageContent.equals("切换卡片点歌")&&data.IsSend){
putString(qun,"音乐模式","卡片");
String menu="群"+qun+"\n已切换为卡片点歌";
群聊发送(data,menu);
}

if(data.MessageContent.equals("切换语音点歌")&&data.IsSend){
putString(qun,"音乐模式","语音");
String menu="群"+qun+"\n已切换为语音点歌";
群聊发送(data,menu);
}

if("每日60s".equals(quntext)){
String ly=get("http://api.xn--ihqx1kcptox0b.fun/60s.php");
String menu=菜单头+"\n"+ly+"\n"+菜单尾;
群聊发送(data,menu);
}

if("功能杂区".equals(quntext)){
String menu=菜单头+"\n『合成表情#表情1#表情2』\n『生成加群链接+群号』\n『生成加好友链接+QQ号』『ping+链接』\n『发送视频+视频』\n『发送图片+图片』\n『发送语音+语音』\n『发语音+歌名』\n『get+链接(访问网页)』\n『每日60s(新闻，别乱想)』\n『下载#文件类型#链接』\n『百度+内容』\n"+菜单尾;
群聊发送(data,menu);
}

if(quntext.matches("生成加群链接[0-9]+")){
String qh=quntext.substring(6);
String result=get("http://aaa.ski/q.php?t=1&y=1&a="+qh);
群聊发送(data,result);
}

if(quntext.matches("生成加好友链接[0-9]+")){
String qh=quntext.substring(7);
群聊发送(data,"http://aaa.ski/qq.php?qq="+qh);
}


if(quntext.matches("合成表情#[\\s\\S]+#[\\s\\S]+")){
String one=quntext.split("#")[1];
String two=quntext.split("#")[2];
String three=get("https://api.andeer.top/API/emojimix.php?emoji1="+one+"&emoji2="+two);
String four=three.replaceAll(" ","");
JSONObject five = new JSONObject(four);
String text=five.get("text");
if(text.equals("获取成功")){
String data=five.getString("data");
JSONObject data2 = new JSONObject(data);
sendPic(qun,"",data2.get("url"));
}else{
群聊发送(data,text);
}
}

if(data.MessageContent.equals("加群")&&data.IsSend){
sendMsg(qun,"","点击链接加入群聊【冷雨·温晴】：http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=WebjaWMx9p-aw2fiILYL_YKoL-z7JFEE&authKey=s0SXzULW825SwjQJUYxigVsVv3rWq7K33UABiE0OzSRWRVSFxR3j%2BFCrSJQn0TRQ&noverify=0&group_code=464695369");
}

if(data.MessageContent.startsWith("克隆头像@")&&data.IsSend){
if("1".equals(getString(data.GroupUin,"touxiang"))){
for(String tex: data.mAtList)
{
链接="http://q2.qlogo.cn/headimg_dl?dst_uin="+tex+"&spec=5";
String filepath=RootPath2+getTime()+".png";
Bitmap original=shangchuan(链接);
bitmaptofile(original,filepath);
uploadAvatar(filepath);
String menu=tex+"的头像\n已克隆过来啦～";
群聊发送(data,menu);
}
}
}

if(data.MessageContent.startsWith("设置头像")&&data.IsSend){
if("1".equals(getString(data.GroupUin,"touxiang"))){
String 字数=data.MessageContent.substring(4);
if(字数.equals("")){
String menu="图片链接为空，请发送『设置头像+图片链接』";
群聊发送(data,menu);
return;
}else{
链接=字数;
QQ=data.UserUin;
String filepath=RootPath2+getTime()+".png";
Bitmap original=shangchuan(链接);
bitmaptofile(original,filepath);
uploadAvatar(filepath);
putString(qun,"上传头像",null);
Thread.sleep(1000);
String menu=qq+"头像上成功";
群聊发送(data,menu);
QQ="100";
}
}
}

if(data.MessageContent.equals("上传头像")&&data.IsSend){
if("1".equals(getString(data.GroupUin,"touxiang"))){
putString(qun,"上传头像","1");
Thread.sleep(800);
String menu=qq+"请发送头像(图片)";
群聊发送(data,menu);
QQ=data.UserUin;
}
}

if(data.MessageContent.startsWith("[PicUrl=")&&data.IsSend){
if("1".equals(getString(data.GroupUin,"touxiang"))){
if("1".equals(getString(qun,"上传头像"))){
String texi=data.MessageContent.substring(8);
头像 =texi.replace("]","");
链接=头像;
Thread.sleep(1000);
//if(text.length() < 4)
String filepath=RootPath2+getTime()+".png";
Bitmap original=shangchuan(链接);
bitmaptofile(original,filepath);
uploadAvatar(filepath);
putString(qun,"上传头像",null);
Thread.sleep(1000);
String menu=qq+"头像上成功";
群聊发送(data,menu);
QQ="100";
}
}
}

if(data.MessageContent.startsWith("我要头街")){
if("1".equals(getString(data.GroupUin,"lengyu"))){
if(getGroupOwner(qun).equals(qq)){
setTitle(data.GroupUin,data.UserUin,data.MessageContent.substring(4));
Thread.sleep(800);
String menu="QQ:"+uin+"\n是头衔(xián)了啦，才不是头街(jié)呢！";
群聊发送(data,menu);
}
}
}

if(quntext.matches("我要赞助[0-9]+")&&!data.IsSend){
long money=Long.parseLong(quntext.split("助")[1]);
if(money==0){
String menu="QQ:"+uin+"\n赞助竟然少于1分？\n禁言1小时！";
Forbidden(qun,uin,3600);
群聊发送(data,menu);
}else if(money>=100000){
String menu="QQ:"+uin+"\n你别来捣乱了！\n你有那么多钱吗？\n你就装吧你！\n禁言1小时！";
Forbidden(qun,uin,3600);
群聊发送(data,menu);
}else{
String nm=get("https://mqq.tenpay.com/cgi-bin/qcollect/qpay_collect_create.cgi?type=1&memo=赞助&amount="+money+"&payer_list=[{\"uin\":"+uin+",\"amount\":"+money+"}]&num=1&recv_type=1&group_id="+qun+"&uin="+qq+"&pskey="+tenpay+"&skey="+skey);
String menu="QQ:"+uin+"\n首先，感谢您的赞助\n但是防止你跟我闹着玩\n我先给你禁言30分钟";
Forbidden(qun,uin,1800);
群聊发送(data,menu);
JSONObject json1 = new JSONObject(nm);
String retmsg=json1.get("retmsg");
if(retmsg.equals("ok")){
String collection_no=json1.get("collection_no");
Thread.sleep(30000);
String nb=get("https://mqq.tenpay.com/cgi-bin/qcollect/qpay_collect_detail.cgi?collection_no="+collection_no+"&uin="+qq+"&pskey="+tenpay+"&skey="+skey+"&skey_type=2");
JSONObject json2 = new JSONObject(nb);
String payer_list=json2.getString("payer_list");
JSONObject json3 = new JSONObject(payer_list);
String state=json3.get("state");
if(state.equals("2")){
String menu="付款成功，已解除禁言";
Forbidden(qun,uin,0);
群聊发送(data,menu);
}else if(state.equals("2")){
String menu="失败，超30秒未支付";
群聊发送(data,menu);
}
}else{
String menu="订单收取失败";
群聊发送(data,menu);
}
}
}

if("自助上管".equals(quntext)){
String menu=菜单头+"\n『我要管理』\n『开启/关闭自助上管』\n『设置上管金额+数字(分)』\n"+菜单尾;
群聊发送(data,menu);
}

if(data.MessageContent.equals("图片功能")&&data.IsSend){
String menu="请长按任意图片消息，点击\"脚本\"字样查看";
Toast("请长按任意图片消息，点击\"脚本\"字样查看");
群聊发送(data,menu);
}

if("个人助手".equals(quntext)&&data.IsSend){
String menu=菜单头+"\n『群收款@QQ 金额(分)』\n『点赞@QQ』\n『上管/下管@QQ』\n『上头衔@QQ 头衔』\n『转语音名字链接』+(名字)\n『转卡片名字链接』\n『发送视频+链接』\n『发送图片+链接』\n『查群列表』『图片功能』\n"+菜单尾;
群聊发送(data,menu);
}

if(data.MessageContent.equals("查群列表")&&data.IsSend){
String url=get("https://api.f4team.cn/API/Group_list/?Skey="+skey+"&Pskey="+qunpskey+"&QQ="+qq);
String result ="";
String url2=url.replaceAll(" ","");
JSONObject json1 = new JSONObject(url);
JSONArray data1=json1.getJSONArray("data");
for(int i=0;i<data1.length();i++){
JSONObject data2=data1.getJSONObject(i);
long gc=data2.get("gc");
String gn=data2.get("gn");
long owner=data2.get("owner");
result+=gc+"("+gn+")——"+owner+"\n";}
群聊发送(data,uin+"的群列表:\n"+result);
}

if(quntext.equals("我要管理")&&!data.IsSend){
if("1".equals(getString(data.GroupUin,"zzsg"))){
String money=getString(qun,"上管金额");
String title="来自:我要管理，请支付";
String nm=get("https://mqq.tenpay.com/cgi-bin/qcollect/qpay_collect_create.cgi?type=1&memo="+title+"&amount="+money+"&payer_list=[{\"uin\":"+uin+",\"amount\":"+money+"}]&num=1&recv_type=1&group_id="+qun+"&uin="+qq+"&pskey="+tenpay+"&skey="+skey);
JSONObject json1 = new JSONObject(nm);
String retmsg=json1.get("retmsg");
if(retmsg.equals("ok")){
String collection_no=json1.get("collection_no");
Thread.sleep(30000);
String nb=get("https://mqq.tenpay.com/cgi-bin/qcollect/qpay_collect_detail.cgi?collection_no="+collection_no+"&uin="+qq+"&pskey="+tenpay+"&skey="+skey+"&skey_type=2");
JSONObject json2 = new JSONObject(nb);
String payer_list=json2.getString("payer_list");
JSONObject json3 = new JSONObject(payer_list);
String state=json3.get("state");
if(state.equals("2")){
String menu="付款成功，正在处理...";
String text1=setAdmin(qun,uin,1);
群聊发送(data,menu);
群聊发送(data,text1);
}else if(state.equals("2")){
String menu="失败，超30秒未支付";
群聊发送(data,menu);
}
}else{
String menu="订单收取失败";
群聊发送(data,menu);
}
}
}

if(data.MessageContent.startsWith("群收款@")&&data.IsSend){
String at=data.AtList[0];
long money=Long.parseLong(quntext.split(" ")[1]);
String nm=get("https://mqq.tenpay.com/cgi-bin/qcollect/qpay_collect_create.cgi?type=1&memo=群收款&amount="+money+"&payer_list=[{\"uin\":"+at+",\"amount\":"+money+"}]&num=1&recv_type=1&group_id="+qun+"&uin="+qq+"&pskey="+tenpay+"&skey="+skey);
JSONObject json1 = new JSONObject(nm);
String retmsg=json1.get("retmsg");
if(retmsg.equals("ok")){
String collection_no=json1.get("collection_no");
String menu="发起收款成功\n收款QQ:"+qq+"\n支付QQ:"+at+"\n收款金额(分):"+money+"\n收款id:"+collection_no;
群聊发送(data,menu);
}else{
群聊发送(data,"失败，未知错误\n1.未实名\n2.限额\n3.钱包被封禁");
}
}


if(data.MessageContent.matches("设置上管金额[0-9]+")&&data.IsSend){
String money=quntext.substring(6);
putString(qun,"上管金额",money);
String menu="设置成功，单个管理金额"+money+"分";
群聊发送(data,menu);
}

if(data.MessageContent.equals("字符列表")&&data.IsSend){
String result="";
String url="https://qun.qq.com/v2/luckyword/index?_wv=67108865&_nav_txtclr=FFFFFF&_wvSb=0&source=aio&qunid="+qun;
String cookie="p_skey="+qunpskey+"; uin=o"+qq+"; skey="+skey+"; p_uin=o"+qq;
String get=httpget(url,cookie);
int index = get.lastIndexOf("window.__INITIAL_STATE__=");
String text = get.substring(index + 25);
int rd = text.indexOf("};(function");
String re = text.substring(0,rd+1);
JSONObject json = new JSONObject(re);
String wordList=json.getString("wordList");
JSONObject json1 = new JSONObject(wordList);
String data=json1.getString("data");
JSONObject json2 = new JSONObject(data);
String equip_info=json2.getString("equip_info");
JSONObject json3 = new JSONObject(equip_info);
String word_info=json3.getString("word_info");
JSONObject json4 = new JSONObject(word_info);
String wording=json4.get("wording");//当前字符名称
String word_desc=json4.get("word_desc");//当前字符寓意
String chosen_uin=json3.get("chosen_uin");
JSONArray word_list=json2.getJSONArray("word_list");
		for(int i=0;i<word_list.length();i++){
        JSONObject List=word_list.get(i);
        String word_info1=List.getString("word_info");
        JSONObject List1 = new JSONObject(word_info1);
        String wording1=List1.get("wording");//字符名称
        String word_desc1=List1.get("word_desc");//字符寓意
        result+="\n字符名称:"+wording1+"\n字符寓意:"+word_desc1;}
sendMsg(qun,"","当前字符名称:"+wording+"\n寓意:"+word_desc+"\n挑选人:"+chosen_uin+"\n字符列表:"+result);
}


if(data.MessageContent.equals("我的会员")&&data.IsSend){
JSONArray business=getbusinesslist(qq,skey);
		String result="QQ"+qq+"的会员情况";
		for(int i=0;i<business.length();i++){
        JSONObject yewu=business.get(i);
        String name=yewu.get("service_name");
        String start=yewu.get("start_time");
        String end=yewu.get("end_time");
        result=result+"\n\n"+name+"\n"+countdown(start,end)+"\n开通时间:"+start+"\n过期时间:"+end;
        }
        String menu=result;
群聊发送(data,menu);
}

if(data.MessageContent.equals("我的会员")&&!data.IsSend){
if(getString(uin,"nskey")==null){
群聊发送(data,"未授权，请发送『登录qzone』");
}else{
String nskey=getString(uin,"nskey");
JSONArray business=getbusinesslist(uin,nskey);
		String result="QQ"+uin+"的会员情况";
		for(int i=0;i<business.length();i++){
        JSONObject yewu=business.get(i);
        String name=yewu.get("service_name");
        String start=yewu.get("start_time");
        String end=yewu.get("end_time");
        result=result+"\n\n"+name+"\n"+countdown(start,end)+"\n开通时间:"+start+"\n过期时间:"+end;
        }
        String menu=result;
群聊发送(data,menu);
}
}

if(data.MessageContent.equals("我的信息")){
long gtk=GetGTK(qzone);
String cookie="p_uin=o0"+qq+";skey="+skey+";p_skey="+qzone;
String url="https://r.qzone.qq.com/cgi-bin/user/cgi_personal_card?uin="+uin+"&remark=0&g_tk="+gtk;
String nm=httpget(url,cookie);
String nv=nm.replace("_Callback(","");
String nan=nv.replace(");","");
String boy=nan.replaceAll("\n","");
JSONObject json1 = new JSONObject(boy);
String UIN=json1.optString("uin");//QQ
String intimacyScore=json1.optString("intimacyScore");//亲密度
String qzonee=json1.optString("qzone").replace("1","有").replace("1","无");//空间是否有权访问
String realname=json1.get("realname");//自己给别人的备注
String nickname=json1.get("nickname");//昵称
String logolabel=json1.get("logolabel");//标识时间(大概是)
String qqvip=json1.optString("qqvip");//SVIP等级
String greenvip=json1.optString("greenvip");//绿钻等级
String gender=json1.optString("gender").replace("1","男").replace("2","女");//性别
String isFriend=json1.optString("isFriend").replace("1","是").replace("0","否");//是否为好友
String commfrd=json1.optString("commfrd");//共同好友
String isSpecialCare=json1.optString("isSpecialCare").replace("1","是");//是否为特别关心
String biaoshi=get("http://aaa.ski/a/time3.php?time="+logolabel);
String menu="QQ:"+UIN+"\n昵称:"+nickname+"\n性别:"+gender+"\n备注:"+realname+"\n亲密度:"+intimacyScore+"\n空间有无访问权限:"+qzonee+"\n是否为特别关心:"+isSpecialCare+"\n是否为好友:"+isFriend+"\n标识时间:"+biaoshi+"\n共同好友数量:"+commfrd+"\nSVIP等级:"+qqvip+"\n绿钻等级:"+greenvip;
群聊发送(data,menu);
}

if(data.MessageContent.equals("切换卡片模式")&&data.IsSend){
putString(qun,"菜单模式","卡片");
String menu="群"+qun+"\n已切换为卡片模式";
群聊发送(data,menu);
}

if(data.MessageContent.equals("切换文字模式")&&data.IsSend){
putString(qun,"菜单模式","文字");
String menu="群"+qun+"\n已切换为文字模式";
群聊发送(data,menu);
}

if(data.MessageContent.equals("切换管家模式")&&data.IsSend){
putString(qun,"菜单模式","管家");
String menu="群"+qun+"\n已切换为管家模式";
群聊发送(data,menu);
}


if(quntext.endsWith("嗨~，我是Q群管家，可以发送入群欢迎和定时消息，暂时还不能和你对话哦。")&&uin.equals("2854196310")&&data.MessageType==1&&aiForbidden==1){
if(data.mAtList.size()==0){
return;
}
String aiqq=data.AtList[0];
Forbidden(qun, aiqq, atbotshut*60);
群聊发送(data,"[AtQQ="+aiqq+"]"+aiqq+"\n禁言"+atbotshut+"分钟\n原因:被Q群管家艾特");
return;
}



if("管家设置".equals(quntext)&&data.IsSend){
String menu=菜单头+"\n『管家发送XXX』\n『添加问答XXX』\n『删除问答XXX』\n『开/关撤回群链接』\n『开/关撤回二维码』\n『开/关口令红包』\n『邀请管家』『移除管家』\n『艾特管家+内容』\n其他功能请到QTool悬浮窗查看\n"+菜单尾;
群聊发送(data,menu);
}

if(quntext.equals("邀请管家")&&data.IsSend){
String pskey=getPskey("qun.qq.com");
String menu=邀请移除管家(qun,qq,skey,pskey,1);
String menu="邀请管家"+xxx;
群聊发送(data,menu);
}

if(quntext.equals("移除管家")&&data.IsSend){
String pskey=getPskey("qun.qq.com");
String menu=邀请移除管家(qun,qq,skey,pskey,0);
String menu="移除管家"+xxx;
群聊发送(data,menu);
}

if(quntext.startsWith("艾特管家")&&data.IsSend){
sendMsg(qun,"","[AtQQ=2854196310]"+quntext.substring(4));
}

if(data.MessageContent.startsWith("管家发送")&&data.IsSend){
String text=quntext.substring(4);
String pskey=getPskey("qun.qq.com");
String xxx=管家发送(qun,qq,skey,pskey,User(3),text.replaceAll("\\r\\n|\\n|\\r", "\\\\n"));
}

if(data.MessageContent.startsWith("添加问答")&&data.IsSend){
String text=quntext.substring(4);
String pskey=getPskey("qun.qq.com");
String xxx=添加问答(qun,qq,skey,pskey,User(3),text.replaceAll("\\r\\n|\\n|\\r", "\\\\n"));
String menu=xxx;
群聊发送(data,menu);
}

if(data.MessageContent.startsWith("删除问答")&&data.IsSend){
String text=quntext.substring(4);
String pskey=getPskey("qun.qq.com");
String xxx=删除问答(qun,qq,skey,pskey,text);
String menu=xxx;
群聊发送(data,menu);
}

if(data.MessageContent.equals("昨日发言")){
if("1".equals(getString(data.GroupUin,"fayan"))){
String hy=speakingList(qun,0);
sendMsg(qun,"",hy);
}
}

if(data.MessageContent.equals("七日发言")){
if("1".equals(getString(data.GroupUin,"fayan"))){
String hy=speakingList(qun,1);
sendMsg(qun,"",hy);
}
}

if(data.MessageContent.equals("本月发言")){
if("1".equals(getString(data.GroupUin,"fayan"))){
String hy=speakingList(qun,2);
sendMsg(qun,"",hy);
}
}

if(data.MessageContent.equals("GPT菜单")){
if("1".equals(getString(data.GroupUin,"GPT"))){
String menu=菜单头+"\n『chat+问题』\n『Chat+问题』\n『智能Ai+问题』\n『Ai+问题』\n『GPT3.5+问题』\n『GPT4+问题』\n『gpt+内容』\n"+菜单尾;
群聊发送(data,menu);
}else{
群聊发送(data,"本群『GPT菜单』未开启，请联系主人"+qq+"，发送『开启GPT菜单』");
}
}

if(data.MessageContent.equals("发言榜单")){
if("1".equals(getString(data.GroupUin,"fayan"))){
String menu=菜单头+"\n『昨日发言』『七日发言』\n『本月发言』\n"+菜单尾;
群聊发送(data,menu);
}else{
群聊发送(data,"本群『发言榜单』未开启，请联系主人"+qq+"，发送『开启发言榜单』");
}
}

if(data.MessageContent.equals("语音菜单")){
if("1".equals(getString(data.GroupUin,"yuyin"))){
String menu=菜单头+"\n『坤坤音乐』『坤坤语音』\n『随机网抑』『随机DJ』\n『随机音乐』『随机唱鸭』\n『发语音+歌名』\n『发送语音+文字』\n『王者语音+英雄名』\n"+菜单尾;
群聊发送(data,menu);
}else{
群聊发送(data,"本群『语音菜单』未开启，请联系主人"+qq+"，发送『开启语音菜单』");
}
}

if(data.MessageContent.equals("头像菜单")&&data.IsSend){
if("1".equals(getString(data.GroupUin,"touxiang"))){
String menu=菜单头+"\n『开启/关闭头像菜单』\n『克隆头像@QQ』\n『上传头像』\n『设置头像+链接』\n"+菜单尾;
群聊发送(data,menu);
}else{
群聊发送(data,"本群『头像菜单』未开启，请联系主人"+qq+"，发送『开启头像菜单』");
}
}

if(data.MessageContent.equals("点歌菜单")){
if("1".equals(getString(data.GroupUin,"diange"))){
String menu=菜单头+"\n『开启/关闭点歌菜单』\n『QQ点歌+歌名』\n『网易点歌+歌名』\n『咪咕点歌+歌名』\n『酷狗点歌+歌名』\n『语音点歌+歌名』\n『随机音乐』(语音)\n『随机网易云』(卡片)\n切换语音/卡片点歌(默认卡片)\n选歌直接发送数字即可\n"+菜单尾;
群聊发送(data,menu);
}else{
群聊发送(data,"本群『点歌菜单』未开启，请联系主人"+qq+"，发送『开启点歌菜单』");
}
}


if(data.MessageContent.equals("文案菜单")){
if("1".equals(getString(data.GroupUin,"wenan"))){
String menu=菜单头+"\n『舔狗日记』『随机一言』\n『网易语录』『Q Q签名』\n『安慰语录』『随机笑话』\n『英汉文案』『毒鸡汤案』\n『爱情语录』『伤感语录』\n『温柔文案』『社会文案』\n『诗词文案』『经典语录』\n『情话语录』『人生话语』\n『动漫语录』『凑数文案』\n『伤感文案』『趣味笑话』\n『随机烧话』『土豆情话』\n『文学语录』『失恋语录』\n『晚安语录』『早安语录』\n『励志语录』『土味情话』\n『KCF语录』『网易热评』\n"+菜单尾;
群聊发送(data,menu);
}else{
群聊发送(data,"本群『文案菜单』未开启，请联系主人"+qq+"，发送『开启文案菜单』");
}
}

if("KCF语录".equals(quntext)){
if("1".equals(getString(data.GroupUin,"wenan"))){
String nb=get("http://api.caonmtx.cn/api/fkxqs.php");
群聊发送(data,nb);
}
}

if("网易热评".equals(quntext)){
if("1".equals(getString(data.GroupUin,"wenan"))){
String nb=get("http://api.caonmtx.cn/api/wyrp_2.php");
String nbb=nb.replaceAll(" ","");
JSONObject json1 = new JSONObject(nbb);
String nbbb=json1.getString("data");
JSONObject json2 = new JSONObject(nbbb);
String Music=json2.get("Music");
String name=json2.get("name");
String Picture=json2.get("Picture");
String Content=json2.get("Content");
String Nick=json2.get("Nick");
sendMsg(qun,"","[PicUrl="+Picture+"]\n歌手:"+name+"\n歌曲:"+Music+"\n网友:"+Nick+"\n评论:"+Content);
}
}

if("动漫语录".equals(quntext)){
if("1".equals(getString(data.GroupUin,"wenan"))){
String nb=get("https://api.andeer.top/API/comic1.php");
String nbb=nb.replaceAll(" ","");
JSONObject json1 = new JSONObject(nbb);
String nbbb=json1.get("content");
群聊发送(data,nbbb);
}
}

if("励志语录".equals(quntext)){
if("1".equals(getString(data.GroupUin,"wenan"))){
String nb=get("https://api.andeer.top/API/lizhi.php");
String nbb=nb.replaceAll(" ","");
JSONObject json1 = new JSONObject(nbb);
String nbbb=json1.get("content");
sendMsg(qun,"",nbbb);
}
}

if("早安语录".equals(quntext)){
if("1".equals(getString(data.GroupUin,"wenan"))){
String nb=get("https://api.andeer.top/API/morning.php");
String nbb=nb.replaceAll(" ","");
JSONObject json1 = new JSONObject(nbb);
String nbbb=json1.get("data");
群聊发送(data,nbbb);
}
}

if("晚安语录".equals(quntext)){
if("1".equals(getString(data.GroupUin,"wenan"))){
String nb=get("https://api.andeer.top/API/night.php");
String nbb=nb.replaceAll(" ","");
JSONObject json1 = new JSONObject(nbb);
String nbbb=json1.get("data");
群聊发送(data,nbbb);
}
}

if("失恋语录".equals(quntext)){
if("1".equals(getString(data.GroupUin,"wenan"))){
String nb=get("https://api.andeer.top/API/shilian.php");
群聊发送(data,nb);
}
}

if("文学语录".equals(quntext)){
if("1".equals(getString(data.GroupUin,"wenan"))){
String nb=get("https://api.andeer.top/API/wenxue.php");
String nbb=nb.replaceAll(" ","");
JSONObject json1 = new JSONObject(nbb);
String nbbb=json1.get("content");
群聊发送(data,nbbb);
}
}

if("土味情话".equals(quntext)){
if("1".equals(getString(data.GroupUin,"wenan"))){
String nb=get("https://api.andeer.top/API/twqh.php");
String nbb=nb.replaceAll(" ","");
JSONObject json1 = new JSONObject(nbb);
String nbbb=json1.get("content");
群聊发送(data,nbbb);
}
}

if("土豆情话".equals(quntext)){
if("1".equals(getString(data.GroupUin,"wenan"))){
String nb=get("http://dsyai.club/api/qinghua.php");
群聊发送(data,nbbb);
}
}

if("随机烧话".equals(quntext)){
if("1".equals(getString(data.GroupUin,"wenan"))){
String nb=get("http://dsyai.club/api/saohua.php");
群聊发送(data,nbbb);
}
}

if("趣味笑话".equals(quntext)){
if("1".equals(getString(data.GroupUin,"wenan"))){
String nb=get("http://dsyai.club/api/qwxh.php");
群聊发送(data,nbbb);
}
}

if("伤感文案".equals(quntext)){
if("1".equals(getString(data.GroupUin,"wenan"))){
String nb=get("http://dsyai.club/api/sgyl.php");
群聊发送(data,nbbb);
}
}

if("舔狗日记".equals(quntext)||"随机一言".equals(quntext)||"网易语录".equals(quntext)||"QQ签名".equals(quntext)||"安慰语录".equals(quntext)||"随机笑话".equals(quntext)||"英汉文案".equals(quntext)||"毒鸡汤案".equals(quntext)||"爱情语录".equals(quntext)||"伤感语录".equals(quntext)||"温柔文案".equals(quntext)||"社会文案".equals(quntext)||"诗词文案".equals(quntext)||"经典语录".equals(quntext)||"情话语录".equals(quntext)||"人生话语".equals(quntext)||"凑数文案".equals(quntext)){
if("1".equals(getString(data.GroupUin,"wenan"))){
String yl=get("https://api.caonm.net/api/jjyl/juhe?msg="+quntext.substring(1)+"&key="+key);
群聊发送(data,yl);
}
}

if("群管功能".equals(quntext)&&data.IsSend){
String menu=菜单头+"\n踢+QQ/@  解禁+QQ/@\n禁言+QQ/@+时间(分钟)\n全体禁言/解禁\n上头衔+QQ/@ 内容\n改名+QQ/@ 内容\n"+菜单尾;
群聊发送(data,menu);
}


if(data.MessageContent.startsWith("踢@")&&data.IsSend){
String at=data.AtList[0];
Kick(qun,at,false);
String menu="踢出成功！\n被踢者:"+at;
群聊发送(data,menu);
}

if(data.MessageContent.startsWith("踢黑@")&&data.IsSend){
String at=data.AtList[0];
Kick(qun,at,true);
String menu="踢出并拉黑成功！\n被踢者:"+at;
群聊发送(data,menu);
}

if(data.MessageContent.matches("踢[0-9]+")&&data.IsSend){
String nb=quntext.substring(1);
Kick(qun,nb,false);
String menu="踢出成功！\n被踢者:"+nb;
群聊发送(data,menu);
}

if(data.MessageContent.matches("踢黑[0-9]+")&&data.IsSend){
String nb=quntext.substring(2);
Kick(qun,nb,true);
String menu="踢出并拉黑成功！\n被踢者:"+nb;
群聊发送(data,menu);
}

if(data.MessageContent.startsWith("禁言@")&&data.IsSend){
String at=data.AtList[0];
long t=Long.parseLong(quntext.split(" ")[1]);
int time=t*60;
if(time>2592000){
Forbidden(qun,at,2592000);
String menu="禁言成功！\n被禁言者:"+at+"\n时长:43200分钟";
群聊发送(data,menu);
}else{
Forbidden(qun,at,time);
String menu="禁言成功！\n被禁言者:"+at+"\n时长:"+t+"分钟";
群聊发送(data,menu);
}
}

if(data.MessageContent.matches("禁言[0-9]+ [0-9]+")&&data.IsSend){
String at=quntext.split("言")[1];
long t=Long.parseLong(quntext.split(" ")[1]);
String aite=at.replaceAll(" "+t,"");
int time=t*60;
if(time>2592000){
Forbidden(qun,aite,2592000);
String menu="禁言成功！\n被禁言者:"+aite+"\n时长:43200分钟";
群聊发送(data,menu);
}else{
Forbidden(qun,aite,time);
String menu="禁言成功！\n被禁言者:"+aite+"\n时长:"+t+"分钟";
群聊发送(data,menu);
}
}

if(data.MessageContent.matches("上头衔[0-9]+ [\\s\\S]+")&&data.IsSend){
String at=quntext.split("衔")[1];
long t=Long.parseLong(quntext.split(" ")[1]);
String aite=at.replaceAll(" "+t,"");
Forbidden(qun,aite,t);
String menu="头衔设置成功！\n荣获头衔者:"+aite+"\n头衔:"+t;
群聊发送(data,menu);
}

if(data.MessageContent.startsWith("上头衔@")&&data.IsSend){
String at=data.AtList[0];
int str=data.MessageContent.lastIndexOf(" ")+1;
String text=data.MessageContent.substring(str);
setTitle(qun,at,text);
String menu="头衔设置成功！\n荣获头衔者:"+at+"\n头衔:"+text;
群聊发送(data,menu);
}

if(data.MessageContent.matches("改名[0-9]+ [\\s\\S]+")&&data.IsSend){
String at=quntext.split("名")[1];
String t=quntext.split(" ")[1];
String aite=at.replaceAll(" "+t,"");
setCard(qun,aite,t);
String menu="名片设置成功！\n荣获名片者:"+aite+"\n新名片:"+t;
群聊发送(data,menu);
}

if(data.MessageContent.startsWith("改名@")&&data.IsSend){
String at=data.AtList[0];
int str=data.MessageContent.lastIndexOf(" ")+1;
String text=data.MessageContent.substring(str);
setCard(qun,at,text);
String menu="名片设置成功！\n荣获名片者:"+at+"\n新名片:"+text;
群聊发送(data,menu);
}

if(data.MessageContent.matches("解禁[0-9]+")&&data.IsSend){
String at=quntext.split("禁")[1];
Forbidden(qun,at,0);
String menu="解禁成功！\n被解禁者:"+at;
群聊发送(data,menu);
}

if(quntext.startsWith("解禁@")&&data.IsSend){
String at=data.AtList[0];
Forbidden(qun,at,0);
String menu="解禁成功！\n被解禁者:"+at;
群聊发送(data,menu);
}

if(data.MessageContent.equals("全体禁言")&&data.IsSend){
Forbidden(qun,"",1);
String menu="群"+qun+"\n开启全体禁言成功！";
群聊发送(data,menu);
}

if(data.MessageContent.equals("全体解禁")&&data.IsSend){
Forbidden(qun,"",0);
String menu="群"+qun+"\n关闭全体禁言成功！";
群聊发送(data,menu);
}

if(data.MessageContent.equals("表情制作")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String menu=菜单头+"\n咬 啾啾 求婚 日漫证 思考 高质量\n捣 膜拜 想看 吃掉 胖达 摸脑袋\n玩 爬开 点赞 相思 哇塞 看电视\n拍 泉纱雾举图 无所谓看🥚了\n撕 美女拿手机 丢 哎嘿 美女拿\n吃 举 美女看电视 想 抱\n心碎碎 没钱很难办事啊 滚出QQ\n拍💩你个憨批 问号 中国地图 亲 啃\n给我 网络男神 波咖猫举牌 牵\n单身狗证 抱着哭 我好羡慕 差评\n警察证 小黑子拍篮球 好评 需要\n我是萌新 我tm直接教你做事 捶\n甘雨爱心 听音乐 掀墙纸 胡桃咬\n可莉吃 推雪球 屏幕 无法加载 赞\n老实点 想2 顶 踹 贴贴 要亲亲\n动态爬 击剑 宝可梦 可爱 画家\n为什么艾特 舔狗日记 蒙娜丽莎\n随心 妻子 可达鸭 拳击 精神涣散\n寻狗启事 搬砖 摩擦 不幸 猎手\n没业务 坤斗罗 蔡徐坤 美女电视\n背刺 处男证 泡妞证 好老公好老婆\n女子汉证 光棍证 仙女证 屌丝证\n美女证 帅哥证 首富证 订婚证\n白富美证 高富帅证 基友证\n毒瘾发作 卧倒 企鹅超 彩遗\n精神支柱 踹门 男同 陪睡券 啊\n画画 麻豆演员 发生了什么 大佬关注了你\n原神启动 安全感 麻豆摄影师 榨精卡\n坤巴卡 涩涩卡 没有什么是完美的 骗子 \n床上 本群沙雕 GKD卡 疯狂星期四\n体操服举牌 包夜多少钱 女同\n报警了 芙蓉王 垃圾桶 你可能需要他\n撸管冠军 踢足球 勾引 绿帽子\n诈尸 紫砂了 我直接就是一脚\n蹭大腿 注意身份 坤坤police\n帅哥举牌 美女举牌 入群宣誓\n烧火 舔冰淇淋 什么东东\n要钱钱 罗小黑 ⭕💰愉快\n变魔术 坤投球 给你来一下\n本公主让着你 我好脆弱啊\n广告牌 耍帅 我要黑化 我老婆\n我女儿 我儿子 我直接拒绝 滚\n群最帅 求婚 okk 换脸 寄\n收下哥的花 按钮 一顿乱亲\n没涩图看了 女装协议 进群协议\n走路 随机颜色 凯蒂猫\n你干妈\nTips:可单独触发也可以后面@XXX\n\n制作名片#QQ#QID#Name#上行文字#下行文字\n美女举牌+内容\n狂粉举牌+内容(≤4字)\n洛基亚+内容\n"+菜单尾;
群聊发送(data,menu);
}else{
sendMsg(qun,"","本群『表情制作』未开启，请联系主人"+qq+"开启");
}
}

if(data.MessageContent.startsWith("洛基亚")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String msg=quntext.substring(3);
sendPic(qun,"","https://api.caonm.net/api/njy/njy?msg="+msg+"&key="+key);
}
}

if(data.MessageContent.startsWith("美女举牌")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String msg=quntext.substring(4);
sendPic(qun,"","https://api.caonm.net/api/jupai/j?msg="+msg+"&key="+key);
}
}


if(data.MessageContent.startsWith("狂粉举牌")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String msg=quntext.substring(4);
sendPic(qun,"","https://api.caonm.net/api/jupa/j?msg="+msg+"&key="+key);
}
}


if(data.MessageContent.startsWith("制作名片#")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String QQ=quntext.split("#")[1];
String QID=quntext.split("#")[2];
String Name=quntext.split("#")[3];
String wa=quntext.split("#")[4];
String was=quntext.split("#")[5];
sendPic(qun,"","http://api.wlx.cc/api/qqcard.php?uin="+QQ+"&qid="+QID+"&name="+Name+"&wa="+wa+"&was="+was);
}
}


if(data.MessageContent.equals("凯蒂猫")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/ajl/y?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("凯蒂猫@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/ajl/y?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("随机颜色")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/sjbc/y?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("随机颜色@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/sjbc/y?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("走路")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zoul/y?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("走路@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zoul/y?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("进群协议")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/jqxy/j?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("进群协议@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/jqxy/j?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("女装协议")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/jqxy/n?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("女装协议@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/jqxy/n?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("没涩图看了")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/mstl/s?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("没涩图看了@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/mstl/s?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("一顿乱亲")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/ddqq/y?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("一顿乱亲@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/ddqq/y?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("按钮")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/anniu/a?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("按钮@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/anniu/a?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("收下哥的花")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/shoux/h?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("收下哥的花@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/shoux/h?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("寄")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/jim/j?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("寄@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/jim/j?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("换脸")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/huanl/h?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("换脸@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/huanl/h?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("okk")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/okk/k?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("okk@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/okk/k?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("求婚")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/qiuh/q?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("求婚@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/qiuh/q?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("群最帅")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zuis/z?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("群最帅@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zuis/z?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("滚")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/gund/g?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("滚@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/gund/g?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("我儿子")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/wrz/r?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("我儿子@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/wrz/r?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("我直接拒绝")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/wjj/j?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("我直接拒绝@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/wjj/j?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("我老婆")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/nmy/n?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.equals("我女儿")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/wnr/n?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("我女儿@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/wnr/n?qq="+at+"&key="+key);
}
}

if(data.MessageContent.startsWith("我老婆@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/nmy/n?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("我要黑化")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/whh/h?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("我要黑化@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/whh/h?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("耍帅")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zhua/h?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("耍帅@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zhua/h?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("广告牌")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/dal/l?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("广告牌@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/dal/l?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("我好脆弱啊")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/cuir/c?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("我好脆弱啊@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/cuir/c?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("本公主让着你")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/bgz/g?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("本公主让着你@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/bgz/g?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("给你来一下")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/pdl/c?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("给你来一下@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/pdl/c?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("坤投球")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/kunk/k?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("坤投球@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/kunk/k?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("变魔术")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/tax/y?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("变魔术@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/tax/y?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("⭕💰愉快")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/qqyk/q?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("⭕💰愉快@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/qqyk/q?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("罗小黑")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/xmmz/y?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("罗小黑@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/xmmz/y?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("要钱钱")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/wyqq/q?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("要钱钱@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/wyqq/q?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("什么东东")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/peng/p?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("什么东东@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/peng/p?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("烧火")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/huos/y?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("烧火@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/huos/yqq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("舔冰淇淋")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/chixg/y?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("舔冰淇淋@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/chixg/y?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("绿帽子")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/lmz/l?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("绿帽子@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/lmz/l?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("勾引")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/gouy/g?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("勾引@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/gouy/g?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("入群宣誓")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/txmb/2?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("入群宣誓@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/txmb/2?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("美女举牌")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zyg/sj?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("美女举牌@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zyg/sj?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("帅哥举牌")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/nanrjp/c?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("帅哥举牌@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/nanrjp/c?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("坤坤police")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/ikz/i?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("坤坤police@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/ikz/i?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("注意身份")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zynsf/z?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("注意身份@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zynsf/z?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("托马斯回旋")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/tmcw/y?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("托马斯回旋@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/tmcw/y?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("蹭大腿")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/cence/y?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("蹭大腿@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/cence/y?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("我直接就是一脚")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zjyj/y?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("我直接就是一脚@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zjyj/y?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("紫砂了")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/shangd/y?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("紫砂了@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/shangd/y?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("诈尸")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zhas/y?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("诈尸@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zhas/y?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("踢足球")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/tiqiu/y?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("踢足球@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/tiqiu/y?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("撸管冠军")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/daoguan/c?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("撸管冠军@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/daoguan/c?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("男同")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/asc/c6?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("男同@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/asc/c6?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("陪睡券")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/asc/c5?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("陪睡券@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/asc/c5?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("画画")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/asc/c4?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("画画@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/asc/c4?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("麻豆演员")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/madou/c2?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("麻豆演员@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/madou/c2?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("大佬关注了你")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/asc/c14?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("大佬关注了你@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/asc/c14?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("发生了什么")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/asc/wt?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("发生了什么@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/asc/wt?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("原神启动")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/op/o?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("原神启动@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/op/o?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("安全感")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/anqg/c?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("安全感@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/anqg/c?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("麻豆摄影师")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/madou/c?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("麻豆摄影师@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/madou/c?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("榨精卡")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/kapian/c3?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("榨精卡@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/kapian/c3?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("坤巴卡")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/kapian/c2?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("坤巴卡@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/kapian/c2?qq="+at+"&key="+key);
}
}


if(data.MessageContent.equals("涩涩卡")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/kapian/c?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("涩涩卡@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/kapian/c?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("没有什么是完美的")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/meiyou/c?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("没有什么是完美的@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/meiyou/c?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("骗子")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/pianzi/c?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("骗子@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/pianzi/c?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("啊")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/asc/c7?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("啊@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/asc/c7?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("床上")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/asc/c8?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("床上@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/asc/c8?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("本群沙雕")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/asc/c9?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("本群沙雕@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/asc/c9?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("GKD卡")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/kapian/c5?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("GKD卡@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/kapian/c5?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("体操服举牌")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/jupai/m?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("体操服举牌@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/jupai/m?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("包夜多少钱")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/guoy/g?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("包夜多少钱@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/guoy/g?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("疯狂星期四")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/kfc/50?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("疯狂星期四@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/kfc/50?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("报警了")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/baon/1?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("报警了@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/baon/1?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("女同")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/asc/c66?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("女同@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/asc/c66?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("芙蓉王")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/yan/y?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("芙蓉王@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/yan/y?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("垃圾桶")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/ljt/l?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("垃圾桶@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/ljt/l?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("你可能需要他")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zt/need?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("你可能需要他@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zt/need?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("踹门")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zt/ti_2?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("踹门@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zt/ti_2?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("精神支柱")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zt/jing?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("精神支柱@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zt/jing?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("彩遗")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zt/ji?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("彩遗@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zt/ji?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("企鹅超")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/chao/api?qq="+uin+"&qq2="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("企鹅超@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/chao/api?qq="+at+"&qq2="+uin+"&key="+key);
}
}

if(data.MessageContent.equals("卧倒")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/lian/api?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("卧倒@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/lian/api?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("毒瘾发作")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/duy/d?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("毒瘾发作@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/duy/d?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("基友证")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zhen/c1?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("基友证@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zhen/c1?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("高富帅证")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zhen/c2?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("高富帅证@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zhen/c2?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("白富美证")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zhen/c3?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("白富美证@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zhen/c3?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("订婚证")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zhen/c4?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("订婚证@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zhen/c4?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("首富证")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zhen/c5?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("首富证@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zhen/c5?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("帅哥证")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zhen/c76?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("帅哥证@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zhen/c6?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("美女证")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zhen/c7?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("美女证@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zhen/c7?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("屌丝证")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zhen/c8?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("屌丝证@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zhen/c8?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("仙女证")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zhen/c9?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("仙女证@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zhen/c9?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("光棍证")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zhen/c10?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("光棍证@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zhen/c10?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("光棍证")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zhen/c11?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("光棍证@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zhen/c11?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("女子汉证")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zhen/c12?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("女子汉证@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zhen/c12?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("好老公好老婆")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zhen/c13?qq="+uin+"&qq2="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("好老公好老婆@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zhen/c13?qq="+at+"qq2="+uin+"&key="+key);
}
}

if(data.MessageContent.equals("泡妞证")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zhen/c14?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("泡妞证@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zhen/c14?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("处男证")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zhen/c30?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("处男证@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zhen/c30?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("背刺")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/bei/b?qq="+uin+"&qq2="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("背刺@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/bei/b?qq="+at+"&qq2="+uin+"&key="+key);
}
}

if(data.MessageContent.equals("美女电视")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/dsjp/j?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("美女电视@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/dsjp/j?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("蔡徐坤")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/ikun/ikun?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("蔡徐坤@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/ikun/ikun?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("坤斗罗")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/ikun/a?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("坤斗罗@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/ikun/a?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("没业务")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/yewu/y?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("没业务@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/yewu/y?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("猎手")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/lieshou.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("猎手@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/lieshou.php?qq="+at);
}
}

if(data.MessageContent.equals("警官证")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/jc_badge.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("警官证@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/jc_badge.php?qq="+at);
}
}

if(data.MessageContent.equals("不幸")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/un_for.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("不幸@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/un_for.php?qq="+at);
}
}

if(data.MessageContent.equals("摩擦")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/moca.php?bqq="+uin+"&cqq="+uin);
}
}

if(data.MessageContent.startsWith("摩擦@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/moca.php?bqq="+at+"&cqq="+uin);
}
}

if(data.MessageContent.equals("搬砖")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/banzhuan.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("搬砖@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/banzhuan.php?qq="+at);
}
}

if(data.MessageContent.equals("寻狗启事")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/dog.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("寻狗启事@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/dog.php?qq="+at);
}
}

if(data.MessageContent.equals("精神涣散")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/no_attention.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("精神涣散@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/no_attention.php?qq="+at);
}
}

if(data.MessageContent.equals("拳击")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/gif_beat.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("拳击@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/gif_beat.php?qq="+at);
}
}

if(data.MessageContent.equals("可达鸭")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/gif_duck.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("可达鸭@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/gif_duck.php?qq="+at);
}
}

if(data.MessageContent.equals("妻子")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/img_wife.php?bqq="+uin+"&cqq="+uin);
}
}

if(data.MessageContent.startsWith("妻子@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/img_wife.php?bqq="+at+"&cqq="+uin);
}
}

if(data.MessageContent.equals("随心")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/img_comic.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("随心@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/img_comic.php?qq="+at);
}
}

if(data.MessageContent.equals("蒙娜丽莎")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/img_mnls.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("蒙娜丽莎@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/img_mnls.php?qq="+at);
}
}

if(data.MessageContent.equals("画家")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/img_painter.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("画家@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/img_painter.php?qq="+at);
}
}

if(data.MessageContent.equals("舔狗日记")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/img_tg.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("舔狗日记@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/img_tg.php?qq="+at);
}
}

if(data.MessageContent.equals("为什么艾特")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/img_whyat.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("为什么艾特@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/img_whyat.php?qq="+at);
}
}

if(data.MessageContent.equals("可爱")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/img_cute.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("可爱@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/img_cute.php?qq="+at);
}
}

if(data.MessageContent.equals("宝可梦")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/img_pokemon.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("宝可梦@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/img_pokemon.php?qq="+at);
}
}

if(data.MessageContent.equals("击剑")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/gif_beat_j.php?bqq="+uin+"&cqq="+uin);
}
}

if(data.MessageContent.startsWith("击剑@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/gif_beat_j.php?bqq="+at+"&cqq="+uin);
}
}

if(data.MessageContent.equals("动态爬")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/img_climb.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("动态爬@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/img_climb.php?qq="+at);
}
}

if(data.MessageContent.equals("要亲亲")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/img_kiss_1.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("要亲亲@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/img_kiss_1.php?qq="+at);
}
}

if(data.MessageContent.equals("想2")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/img_miss.php?bqq="+uin+"&cqq="+uin);
}
}

if(data.MessageContent.startsWith("想2@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/img_miss.php?bqq="+at+"&cqq="+uin);
}
}

if(data.MessageContent.equals("赞")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/img_good.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("赞@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/img_good.php?qq="+at);
}
}

if(data.MessageContent.equals("老实点")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/img_lsd.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("老实点@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/img_lsd.php?qq="+at);
}
}

if(data.MessageContent.equals("踹")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/img_tr.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("踹@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/img_tr.php?qq="+at);
}
}

if(data.MessageContent.equals("贴贴")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/gif_tietie.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("贴贴@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/gif_tietie.php?qq="+at);
}
}

if(data.MessageContent.equals("顶")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/gif_ding.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("顶@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/gif_ding.php?qq="+at);
}
}

if(data.MessageContent.equals("无法加载")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/img_loading.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("无法加载@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/img_loading.php?qq="+at);
}
}

if(data.MessageContent.equals("推雪球")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/gif_tui.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("推雪球@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/gif_tui.php?qq="+at);
}
}

if(data.MessageContent.equals("屏幕")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/img_screen.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("屏幕@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/img_screen.php?qq="+at);
}
}

if(data.MessageContent.equals("吃")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/gif_eat.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("吃@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/gif_eat.php?qq="+at);
}
}

if(data.MessageContent.equals("啃")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/gif_bite.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("啃@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/gif_bite.php?qq="+at);
}
}

if(data.MessageContent.equals("胡桃咬")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/gif_hutao_bite.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("胡桃咬@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/gif_hutao_bite.php?qq="+at);
}
}

if(data.MessageContent.equals("掀墙纸")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/gif_wallpaper.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("掀墙纸@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/gif_wallpaper.php?qq="+at);
}
}

if(data.MessageContent.equals("听音乐")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/img_listen_music.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("听音乐@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/img_listen_music.php?qq="+at);
}
}

if(data.MessageContent.equals("捶")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/gif_thump.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("捶@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/gif_thump.php?qq="+at);
}
}

if(data.MessageContent.equals("需要")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/img_need.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("需要@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/img_need.php?qq="+at);
}
}

if(data.MessageContent.equals("甘雨爱心")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/img_love.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("甘雨爱心@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/img_love.php?qq="+at);
}
}

if(data.MessageContent.equals("我tm直接教你做事")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","http://api.wlx.cc/api/jnzs.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("我tm直接教你做事@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","http://api.wlx.cc/api/jnzs.php?qq="+at);
}
}

if(data.MessageContent.equals("我是萌新")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","http://api.wlx.cc/api/wsmx.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("我是萌新@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","http://api.wlx.cc/api/wsmx.php?qq="+at);
}
}

if(data.MessageContent.equals("差评")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","http://api.wlx.cc/api/cp.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("差评@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","http://api.wlx.cc/api/cp.php?qq="+at);
}
}

if(data.MessageContent.equals("好评")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","http://api.wlx.cc/api/hp.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("好评@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","http://api.wlx.cc/api/hp.php?qq="+at);
}
}

if(data.MessageContent.equals("小黑子拍篮球")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","http://shanhe.kim/api/qq/cxk.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("小黑子拍篮球@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","http://shanhe.kim/api/qq/cxk.php?qq="+at);
}
}

if(data.MessageContent.equals("警察证")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","http://shanhe.kim/api/qq/Policebadge.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("警察证@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","http://shanhe.kim/api/qq/Policebadge.php?qq="+at);
}
}

if(data.MessageContent.equals("牵")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","http://shanhe.kim/api/qq/qian.php?qq1="+uin+"&qq2="+uin);
}
}

if(data.MessageContent.startsWith("牵@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","http://shanhe.kim/api/qq/qian.php?qq1="+at+"&qq2="+uin);
}
}

if(data.MessageContent.equals("我好羡慕")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","http://shanhe.kim/api/qq/xianmu.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("我好羡慕@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","http://shanhe.kim/api/qq/xianmu.php?qq="+at);
}
}

if(data.MessageContent.equals("抱着哭")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","http://shanhe.kim/api/qq/bao.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("抱着哭@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","http://shanhe.kim/api/qq/bao.php?qq="+at);
}
}

if(data.MessageContent.equals("亲")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","http://shanhe.kim/api/qq/face_kiss.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("亲@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","http://shanhe.kim/api/qq/face_kiss.php?qq="+at);
}
}

if(data.MessageContent.equals("单身狗证")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","http://shanhe.kim/api/qq/dsgz.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("单身狗证@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","http://shanhe.kim/api/qq/dsgz.php?qq="+at);
}
}

if(data.MessageContent.equals("滚出QQ")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","http://shanhe.kim/api/qq/gun.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("滚出QQ@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","http://shanhe.kim/api/qq/gun.php?qq="+at);
}
}

if(data.MessageContent.equals("中国地图")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","http://shanhe.kim/api/qq/zgdt.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("中国地图@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","http://shanhe.kim/api/qq/zgdt.php?qq="+at);
}
}

if(data.MessageContent.equals("心碎碎")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/xins/x?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("心碎碎@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/xins/x?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("抱")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/bao.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("抱@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/bao.php?qq="+at);
}
}

if(data.MessageContent.equals("波咖猫举牌")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/ju/index?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("波咖猫举牌@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/ju/index?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("网络男神")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/nans/n?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("网络男神@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/nans/n?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("给我")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zyg/gei?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("给我@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zyg/gei?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("问号")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/mb/wh?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("问号@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/mb/wh?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("胖达")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/yyy/y?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("胖达@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/yyy/y?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("举")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zyg/sj?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("举@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zyg/sj?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("无所谓看🥚了")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://free.wqwlkj.cn/wqwlapi/dan.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("无所谓看🥚了@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://free.wqwlkj.cn/wqwlapi/dan.php?qq="+at);
}
}

if(data.MessageContent.equals("拍💩你个憨批")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://free.wqwlkj.cn/wqwlapi/pai.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("拍💩你个憨批@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://free.wqwlkj.cn/wqwlapi/pai.php?qq="+at);
}
}

if(data.MessageContent.equals("哇塞")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/kan/kan_6?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("哇塞@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/kan/kan_6?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("美女拿")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","http://api.wlx.cc/api/sj.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("美女拿@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","http://api.wlx.cc/api/sj.php?qq="+at);
}
}

if(data.MessageContent.equals("没钱很难办事啊")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://free.wqwlkj.cn/wqwlapi/dan.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("没钱很难办事啊@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://free.wqwlkj.cn/wqwlapi/dan.php?qq="+at);
}
}

if(data.MessageContent.equals("哎嘿")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/kan/kan_2?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("哎嘿@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/kan/kan_2?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("美女看电视")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/mnk/m?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("美女看电视@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/mnk/m?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("你干妈")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/lgm/index?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("你干妈@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/lgm/index?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("美女拿手机")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","http://h.xiaocha.fun/api/sj.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("美女拿手机@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","http://h.xiaocha.fun/api/sj.php?qq="+at);
}
}

if(data.MessageContent.equals("泉纱雾举图")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/wus/w?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("泉纱雾举图@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/wus/w?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("看电视")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","http://api.tangdouz.com/wz/looktv.php?q="+uin);
}
}

if(data.MessageContent.startsWith("看电视@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","http://api.tangdouz.com/wz/looktv.php?q="+at);
}
}

if(data.MessageContent.equals("相思")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","http://api.tangdouz.com/wz/xiansi.php?q="+uin+"&nr=相思食不食");
}
}

if(data.MessageContent.startsWith("相思@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","http://api.tangdouz.com/wz/xiansi.php?q="+at+"&nr=相思食不食");
}
}

if(data.MessageContent.equals("想")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","http://api.tangdouz.com/wz/think.php?q="+uin);
}
}

if(data.MessageContent.startsWith("想@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","http://api.tangdouz.com/wz/think.php?q="+at);
}
}

if(data.MessageContent.equals("点赞")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/zan/z?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("点赞@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/zan/z?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("丢")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://81.68.255.132/API/qq_diu/api.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("丢@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://81.68.255.132/API/qq_diu/api.php?qq="+at);
}
}

if(data.MessageContent.equals("爬开")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/pa/pa?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("爬开@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/pa/pa?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("可莉吃")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/gif_klee_eat.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("可莉吃@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/gif_klee_eat.php?qq="+at);
}
}

if(data.MessageContent.equals("撕")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/sit/s?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("撕@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/sit/s?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("拍")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/gif_pai.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("拍@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/gif_pai.php?qq="+at);
}
}

if(data.MessageContent.equals("玩")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/wyx/p?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("玩@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/wyx/p?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("吃掉")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/chi2/c?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("吃掉@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/chi2/c?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("捣")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","http://ai.xn--7gqa009h.top/api/dao?qq="+uin);
}
}

if(data.MessageContent.startsWith("捣@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","http://ai.xn--7gqa009h.top/api/dao?qq="+at);
}
}

if(data.MessageContent.equals("咬")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/gif_bite.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("咬@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/gif_bite.php?qq="+at);
}
}

if(data.MessageContent.equals("想看")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/aniyasuki.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("想看@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/aniyasuki.php?qq="+at);
}
}

if(data.MessageContent.equals("膜拜")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/gif_worship.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("膜拜@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/gif_worship.php?qq="+at);
}
}

if(data.MessageContent.equals("摸脑袋")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://xiaoapi.cn/API/bq_mym.php?type=gif&qq="+uin);
}
}

if(data.MessageContent.startsWith("摸脑袋@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://xiaoapi.cn/API/bq_mym.php?type=gif&qq="+at);
}
}

if(data.MessageContent.equals("思考")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/img_comic.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("思考@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/img_comic.php?qq="+at);
}
}

if(data.MessageContent.equals("高质量")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/gzl/index?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("高质量@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/gzl/index?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("日漫证")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.andeer.top/API/jc_badge.php?qq="+uin);
}
}

if(data.MessageContent.startsWith("日漫证@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.andeer.top/API/jc_badge.php?qq="+at);
}
}

if(data.MessageContent.equals("啾啾")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/jiujiu/jiujiu?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("啾啾@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/jiujiu/jiujiu?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("求婚")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
sendPic(qun,"","https://api.caonm.net/api/qiuh/q?qq="+uin+"&key="+key);
}
}

if(data.MessageContent.startsWith("求婚@")){
if("1".equals(getString(data.GroupUin,"biaoqingbao"))){
String at=data.AtList[0];
sendPic(qun,"","https://api.caonm.net/api/qiuh/q?qq="+at+"&key="+key);
}
}

if(data.MessageContent.equals("随机音乐")){
if("1".equals(getString(data.GroupUin,"yuyin"))){
String str="https://apis.jxcxin.cn/api/qqrandommusic";
int a=1;
int b=9;
int c=随机数(a,b);
String name=RootPath+"语音/"+c+".mp3";
视频.下载视频(str,name);
sendVoice(qun,"",name);
}
}

if(data.MessageContent.equals("绿茶语音")){
if("1".equals(getString(data.GroupUin,"yuyin"))){
String str="https://api.pearktrue.cn/api/greentea/";
int a=1;
int b=9;
int c=随机数(a,b);
String name=RootPath+"语音/"+c+".mp3";
视频.下载视频(str,name);
sendVoice(qun,"",name);
}
}

if(data.MessageContent.equals("坤坤语音")){
if("1".equals(getString(data.GroupUin,"yuyin"))){
String str="https://api.caonm.net/api/kunkun/k?key="+key;
int a=1;
int b=9;
int c=随机数(a,b);
String name=RootPath+"语音/"+c+".mp3";
视频.下载视频(str,name);
sendVoice(qun,"",name);
}
}

if(data.MessageContent.equals("坤坤音乐")){
if("1".equals(getString(data.GroupUin,"diange"))){
int z=1;
int y=77;
int v=随机数(z,y);
String str="http://api.caonmtx.cn/kun/"+v+".mp3";
qqsendTroopMusic(qun,"坤坤音乐---冷雨Java","坤坤音乐","http://ly.aaa.vin/520",str,"http://gchat.qpic.cn/gchatpic_new/0/0-0-E3DDFF99D0EFA150F6629EC5891F523A/0?term=2");
}
}


if(data.MessageContent.equals("随机唱鸭")){
if("1".equals(getString(data.GroupUin,"yuyin"))){
String url=get("http://api.caonmtx.cn/api/changya.php").replaceAll(" ","");
JSONObject json1 = new JSONObject(url);
String data=json1.getString("data");
JSONObject json2 = new JSONObject(data);
String song_singer=json2.get("song_singer");
String user_image=json2.get("user_image");
String song_url=json2.get("song_url");
String song_lyric=json2.get("song_lyric");
int a=1;
int b=9;
int c=随机数(a,b);
String name=RootPath+"语音/"+c+".mp3";
视频.下载视频(song_url,name);
sendMsg(qun,"","[PicUrl="+user_image+"]歌手:"+song_singer+"\n歌词:"+song_lyric);
sendVoice(qun,"",name);
}
}

if(data.MessageContent.equals("随机网抑")){
if("1".equals(getString(data.GroupUin,"yuyin"))){
String str="https://api.caonm.net/api/djwyy/wyy?key="+key;
int a=1;
int b=9;
int c=随机数(a,b);
String name=RootPath+"语音/"+c+".mp3";
视频.下载视频(str,name);
sendVoice(qun,"",name);
}
}

if(data.MessageContent.equals("随机DJ")){
if("1".equals(getString(data.GroupUin,"yuyin"))){
String str="https://api.caonm.net/api/djwyy/dj?key="+key;
int a=1;
int b=9;
int c=随机数(a,b);
String name=RootPath+"语音/"+c+".mp3";
视频.下载视频(str,name);
sendVoice(qun,"",name);
}
}

if(data.MessageContent.startsWith("发送语音")){
if("1".equals(getString(data.GroupUin,"yuyin"))){
int type1=0;
int type2=4;
int type=随机数(type1,type2);
String str="http://tsn.baidu.com/text2audio?tex="+quntext.substring(4)+"&per="+type+"&spd=4&pit=5&vol=5&aue=3&cuid=123456PHP&tok=24.76f0f5e410dab6933928d172147fec41.2592000.1692706720.282335-10806162&lan=zh&ctp=1";
int a=1;
int b=9;
int c=随机数(a,b);
String name=RootPath+"语音/"+c+".mp3";
视频.下载视频(str,name);
sendVoice(qun,"",name);
}
}

if(data.MessageContent.equals("菜单配置")){
Thread.sleep(800);
String 模式=getString(data.GroupUin,"菜单模式"); 
String menu=菜单头+"\n『菜单』(默认卡片)\n『切换管家模式』\n『切换卡片模式』\n『切换文字模式』\n『切换转发模式』\n『切换卡片2模式』\n『切换Tips模式』\n『切换图片模式』\n当前模式("+模式+")\n"+菜单尾;
群聊发送(data,menu);
}

if(data.MessageContent.startsWith("复读")&&data.IsSend){
Thread.sleep(800);
群聊发送(data,quntext.substring(2));
return;
}

if(data.MessageContent.equals("开关系统")&&data.IsSend){
String menu=菜单头+"\n复活(开机)/趋势(关机)\n开启/关闭skey扫码\n开启/关闭视频大全\n开启/关闭自助头衔\n开启/关闭图片菜单\n开启/关闭表情制作\n开启/关闭违禁检测\n开启/关闭群提示\n开启/关闭本群赞我\n开启/关闭红包检测\n开启/关闭文案菜单\n开启/关闭自助上管\n开启关闭GPT菜单\n开启关闭语音菜单\n开启/关闭点歌菜单\n开启/关闭头像菜单\n开启/关闭发言榜单\n开启/关闭艾特回复\n开启/关闭艾特禁言\n开启/关闭撤回链接\n开启/关闭撤回卡片\n开启/关闭撤回语音\n开启/关闭撤回图片\n开启/关闭图片外显\n开启/关闭查询系统\n开启/关闭天气系统\n开启/关闭福利功能\n开启/关闭刷听歌\n开关设置\n"+菜单尾;
群聊发送(data,menu);
}

if("随机美腿".equals(quntext)){
String url="http://pi.xn--7gqa009h.top/api/sjmt?type=";
String js=get(url);
try{
JSONObject json = new JSONObject(js);
String txt="[AtQQ="+uin+"][PicUrl="+json.getString("pic")+"]";
sendMsg(qun,"",txt);
}catch(JSONException e){
群聊发送(data,e.getMessage());
}
}

if(quntext.equals("随机网易云")){
if("1".equals(getString(data.GroupUin,"diange"))){
String wyy=get("https://api.kit9.cn/api/netease_cloud_random_music/api.php");
JSONObject json1 = new JSONObject(wyy);
String msg=json1.get("msg");
if(msg.equals("success")){
String data=json1.getString("data");
JSONObject json2 = new JSONObject(data);
String music_songname=json2.get("music_songname");
String music_author=json2.get("music_author");
String music_cover=json2.get("music_cover");
String music_address=json2.get("music_address");
wysendTroopMusic(qun,music_songname,music_author,"http://ly.aaa.vin/520",music_address,music_cover);
}
}
}

if(quntext.startsWith("网易点歌")){
if("1".equals(getString(data.GroupUin,"diange"))){
String msg=quntext.substring(4);
putString(uin,"音乐",msg);
putString(uin,"音乐源","网易");
String url=get("http://ovoa.cc/api/wangyi.php?msg="+msg+"&type=text&t=30");
String menu=菜单头+"\n"+url+"\n"+菜单尾;
群聊发送(data,menu);
}
}


if(quntext.startsWith("咪咕点歌")){
if("1".equals(getString(data.GroupUin,"diange"))){
String msg=quntext.substring(4);
putString(uin,"音乐",msg);
putString(uin,"音乐源","咪咕");
String url=get(" https://free.wqwlkj.cn/wqwlapi/migu.php?msg="+msg+"&type=text");
String menu=菜单头+"\n"+url+"\n"+菜单尾;
群聊发送(data,menu);
}
}

if(quntext.startsWith("语音点歌")){
if("1".equals(getString(data.GroupUin,"diange"))){
String msg=quntext.substring(4);
String url=get("http://api.caonmtx.cn/api/lsdddg.php?msg="+msg);
int a=1;
int b=9;
int c=随机数(a,b);
String name=RootPath+"语音/"+c+".mp3";
视频.下载视频(url,name);
sendVoice(qun,"",name);
}
}

if(quntext.startsWith("QQ点歌")){
if("1".equals(getString(data.GroupUin,"diange"))){
String msg=quntext.substring(4);
putString(uin,"音乐",msg);
putString(uin,"音乐源","QQ");
String url=get("http://ai.xn--7gqa009h.top/api/qqyy_zui?msg="+msg+"&type=text");
String menu=菜单头+"\n"+url+"\n"+菜单尾;
群聊发送(data,menu);
}
}

if(quntext.startsWith("酷狗点歌")){
if("1".equals(getString(data.GroupUin,"diange"))){
String msg=quntext.substring(4);
putString(uin,"音乐",msg);
putString(uin,"音乐源","酷狗");
String url=get("http://api.caonmtx.cn/api/kugou.php?msg="+msg+"&type=text");
String menu=菜单头+"\n"+url+"\n"+菜单尾;
群聊发送(data,menu);
}
}

if("我的等级".equals(quntext)){
String vip=getPskey("vip.qq.com");
String url="http://ai.xn--7gqa009h.top/api/qqdj?qq="+qq+"&skey="+skey+"&pskey="+vip+"&uin="+uin;
String js=get(url);
JSONObject json = new JSONObject(js);
String code=json.getString("code");
if(!code.equals("0")){
sendReply(qun,datmsjson.getString("msg"));
return;
}else{
String nmb=json.getString("msg")+"\n查询人员："+json.getString("uin")+"\n查询等级："+json.getString("Grade")+"\n升下一级："+json.getString("iNextLevelDay")+"(无加速)\n活跃天数："+json.getString("iTotalActiveDay")+"\n图标等级："+json.getString("icon");
String menu=菜单头+"\n"+nmb+"\n"+菜单尾;
群聊发送(data,menu);
}
}

if(data.MessageContent.equals("关机")&&data.IsSend||data.MessageContent.equals("趋势")&&data.IsSend){
putString(qun,"xiaoqi",null);
String menu="群"+qun+"\n已关机";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启群发功能")&&data.IsSend){
putString(qun,"qunfa","1");
String menu="群"+qun+"\n已开启群发功能";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭群发功能")&&data.IsSend){
putString(qun,"qunfa",null);
String menu="群"+qun+"\n已关闭群发功能";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启发言榜单")&&data.IsSend){
putString(qun,"fayan","1");
String menu="群"+qun+"\n已开启发言榜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭发言榜单")&&data.IsSend){
putString(qun,"fayan",null);
String menu="群"+qun+"\n已关闭发言榜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启头像菜单")&&data.IsSend){
putString(qun,"touxiang","1");
String menu="群"+qun+"\n已开启头像菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭头像菜单")&&data.IsSend){
putString(qun,"touxiang",null);
String menu="群"+qun+"\n已关闭头像菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启语音菜单")&&data.IsSend){
putString(qun,"yuyin","1");
String menu="群"+qun+"\n已开启语音菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭语音菜单")&&data.IsSend){
putString(qun,"yuyin",null);
String menu="群"+qun+"\n已关闭语音菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启点歌菜单")&&data.IsSend){
putString(qun,"diange","1");
String menu="群"+qun+"\n已开启点歌菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭点歌菜单")&&data.IsSend){
putString(qun,"diange",null);
String menu="群"+qun+"\n已关闭点歌菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启GPT菜单")&&data.IsSend){
putString(qun,"GPT","1");
String menu="群"+qun+"\n已开启GPT菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭GPT菜单")&&data.IsSend){
putString(qun,"GPT",null);
String menu="群"+qun+"\n已关闭GPT菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭视频大全")&&data.IsSend){
putString(qun,"shipindaquan",null);
String menu="群"+qun+"\n已关闭视频大全";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启视频大全")&&data.IsSend){
putString(qun,"shipindaquan","1");
String menu="群"+qun+"\n已开启视频大全";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭红包检测")&&data.IsSend){
putString(qun,"hongbao",null);
String menu="群"+qun+"\n已关闭红包检测";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启红包检测")&&data.IsSend){
putString(qun,"hongbao","1");
String menu="群"+qun+"\n已开启红包检测";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭skey扫码")&&data.IsSend){
putString(qun,"saoma",null);
String menu="群"+qun+"\n已关闭skey扫码";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启skey扫码")&&data.IsSend){
putString(qun,"saoma","1");
String menu="群"+qun+"\n已开启skey扫码";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭图片菜单")&&data.IsSend){
putString(qun,"tupiancaidan",null);
String menu="群"+qun+"\n已关闭图片菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启图片菜单")&&data.IsSend){
putString(qun,"tupiancaidan","1");
String menu="群"+qun+"\n已开启图片菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启文案菜单")&&data.IsSend){
putString(qun,"wenan","1");
String menu="群"+qun+"\n已开启文案菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭文案菜单")&&data.IsSend){
putString(qun,"wenan",null);
String menu="群"+qun+"\n已关闭文案菜单";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启自助头衔")&&data.IsSend){
putString(qun,"lengyu","1");
String menu="群"+qun+"\n已开启自助头衔";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭自助头衔")&&data.IsSend){
putString(qun,"lengyu",null);
String menu="群"+qun+"\n已关闭自助头衔";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启自助上管")&&data.IsSend){
putString(qun,"zzsg","1");
String menu="群"+qun+"\n已开启自助上管";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭自助上管")&&data.IsSend){
putString(qun,"zzsg",null);
String menu="群"+qun+"\n已关闭自助上管";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启表情制作")&&data.IsSend){
putString(qun,"biaoqingbao","1");
String menu="群"+qun+"\n已开启表情制作";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭表情制作")&&data.IsSend){
putString(qun,"biaoqingbao",null);
String menu="群"+qun+"\n已关闭表情制作";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启违禁检测")&&data.IsSend){
putString(qun,"weijin","1");
String menu="群"+qun+"\n已开启违禁检测";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭违禁检测")&&data.IsSend){
putString(qun,"weijin",null);
String menu="群"+qun+"\n已关闭违禁检测";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启群提示")&&data.IsSend){
putString(qun,"quntishi","1");
String menu="群"+qun+"\n已开启群提示";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭群提示")&&data.IsSend){
putString(qun,"quntishi",null);
String menu="群"+qun+"\n已关闭群提示";
群聊发送(data,menu);
}

if(data.MessageContent.equals("开启本群赞我")&&data.IsSend){
putString(qun,"zanwo","1");
String menu="群"+qun+"\n已开启本群赞我";
群聊发送(data,menu);
}

if(data.MessageContent.equals("关闭本群赞我")&&data.IsSend){
putString(qun,"zanwo",null);
String menu="群"+qun+"\n已关闭本群赞我";
群聊发送(data,menu);
}

if(data.MessageContent.startsWith("Json:")&&data.IsSend){
Thread.sleep(800);
sendCard(qun,"",quntext.substring(5));
return;
}

if(data.MessageContent.startsWith("ping")&&data.IsSend){
String url=get("http://api.tombk.cn/API/ping.php?url="+quntext.substring(4));
群聊发送(data,url);
return;
}

if(data.MessageContent.startsWith("get")&&data.IsSend){
String url=get(quntext.substring(3));
sendMsg(qun,"",url);
return;
}

if(data.MessageContent.equals("登录菜单")){
if("1".equals(getString(data.GroupUin,"saoma"))){
String menu=菜单头+"\n请发送『登录+地址』\n目前登录地址仅支持:\nqun,vip,pay,email,game,qzone,anquan,qqmusic\n"+菜单尾;
群聊发送(data,menu);
}
}

if(data.MessageContent.equals("图片菜单")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
String menu=菜单头+"\n『黑丝』『白丝』『r18』\n『随机腹肌』『随机腿图』\n『随机美腿』『随机坤坤』\n『随机龙图』『随机妹子』\n『随机涩图』『随机cos图』\n『随机银发』『随机兽耳』\n『漏点涩图』『cos图2』\n『随机白丝』『随机黑丝』\n『随机JK』『随机二次元』\n『二次元头像』『少女写真』\n『物语系列』『风景系列』\n『猫娘系列』『动漫综合』\n『原批系列』『随机壁纸』\n『随机帅哥』『随机腿照』\n『买家秀』『卖家秀』\n『随机男头』『随机女头』\n『随机情头』『随机漫头』\n『今日60s』『精选头像』\n『猫羽雫』 『原神图』\n『小c酱』『兽猫酱』\n『萌娃表情』『柴郡表情』\n『滑稽表情』『快手小姐姐』\n『坤坤表情』『pixiv』\n『一二布布』『抹茶旦旦』\n『舔狗日记』『舔狗日记2』\n『妹子图片』『二次元头』\n『随机汽车』『随机风景』\n『搞笑动态表情』『风景图』\n『cos图3』『妹子图2』\n『pixiv2』『随机美腿2』\n『诱惑图』『bing图』『张娜英』\n『汽车图』『动漫图』\n『随机美腿3』『cos图4』\n『高清壁纸』『随机图片』\n『黑丝美腿』『白丝美腿』\n『日历图片』『动漫图片』\n"+菜单尾;
群聊发送(data,menu);
}else{
群聊发送(data,"本群『图片菜单』未开启，请联系主人"+qq+"，发送『开启图片菜单』");
}
}

if(data.MessageContent.equals("动漫图片")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.caonm.net/api/dm/index?key="+key);
}
}

if(data.MessageContent.equals("日历图片")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.caonm.net/api/ri/li?key="+key);
}
}

if(data.MessageContent.equals("白丝美腿")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://api.tombk.cn/API/bs/bs.php");
}
}

if(data.MessageContent.equals("黑丝美腿")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://api.tombk.cn/API/hs/hs.php");
}
}

if(data.MessageContent.equals("bing图")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.mcloc.cn/bing");
}
}

if(data.MessageContent.equals("随机图片")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
String tp=get("http://dsyai.club/api/sjtp.php");
sendPic(qun,"",tp);
}
}

if(data.MessageContent.equals("高清壁纸")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
int a=1;
int b=30;
int c=随机数(a,b);
String tp=get("http://dsyai.club/api/bizhi.php?msg="+c);
String tpp=tp.replaceAll("±img","");
String tppp=tpp.replaceAll("±","");
sendPic(qun,"",tppp);
}
}

if(data.MessageContent.equals("cos图4")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
String tp=get("http://dsyai.club/api/cos.php");
sendPic(qun,"",tp);
}
}

if(data.MessageContent.equals("随机美腿3")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
String tp=get("http://dsyai.club/api/tu.php");
sendPic(qun,"",tp);
}
}

if(data.MessageContent.equals("汽车图")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://dsyai.club/api/QcImg.php");
}
}

if(data.MessageContent.equals("风景图")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://dsyai.club/api/FjImg.php");
}
}

if(data.MessageContent.equals("诱惑图")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://dsyai.club/api/youhuotu.php");
}
}

if(data.MessageContent.equals("动漫图")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
String tp=get("http://dsyai.club/api/dm.php");
sendPic(qun,"",tp);
}
}

if(data.MessageContent.equals("随机美腿2")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
String tp=get("https://yjsb.xyz/api/api/meitui.php?");
sendPic(qun,"",tp);
}
}

if(data.MessageContent.equals("妹子图2")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://pic.aaa.ski/mn.php");
}
}

if(data.MessageContent.equals("真人涩图")&&data.IsSend){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
int a=14000;
int b=30000;
int c=随机数(a,b);
String tp="https://s1.cheliliao.com/unsafe/480x250/vgpic.b-cdn.net/hxc/excerpt/"+c+".png";
String jb=User(3);
String file=RootPath+"下载/"+jb+".png";
String xz=DownloadToFile(tp,file);
if(xz.equals("成功")){
sendMsg(qun,"","图片下载成功！请到"+file+"查看");
return;
}
}
}

if(data.MessageContent.equals("cos图3")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://pic.aaa.ski/cos.php");
}
}

if(data.MessageContent.equals("搞笑动态表情")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://www.hlapi.cn/api/gxdt");
}
}

if(data.MessageContent.equals("随机风景")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.gmit.vip/Api/FjImg?format=image");
}
}

if(data.MessageContent.equals("随机汽车")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.gmit.vip/Api/QcImg?format=image");
}
}

if(data.MessageContent.equals("二次元头")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.yimian.xyz/img?type=head");
}
}

if(data.MessageContent.equals("妹子图片")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://xinnai.521314.love/API/meizi.php?type=image");
}
}

if(data.MessageContent.equals("舔狗日记2")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://xinnai.521314.love/API/t.php?type=image");
}
}

if(data.MessageContent.equals("舔狗日记")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://xinnai.521314.love/API/tygo.php");
}
}

if(data.MessageContent.equals("抹茶旦旦")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://api.caonmtx.cn/api/mcdd.php");
}
}

if(data.MessageContent.equals("一二布布")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://api.caonmtx.cn/api/bubu.php");
}
}

if(data.MessageContent.equals("pixiv")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://api.caonmtx.cn/api/pixiv.php");
}
}

if(data.MessageContent.equals("滑稽表情")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.caonm.net/api/huac/h?key="+key);
}
}

if(data.MessageContent.equals("快手小姐姐")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://api.wqwlkj.cn/wqwlapi/ks_xjj.php?type=image");
}
}

if(data.MessageContent.equals("柴郡表情")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.caonm.net/api/chai/c?key="+key);
}
}

if(data.MessageContent.equals("张娜英")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.caonm.net/api/zny/index?key="+key);
}
}

if(data.MessageContent.equals("萌娃表情")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.caonm.net/api/mm/m?key="+key);
}
}

if(data.MessageContent.equals("兽猫酱")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://api.caonmtx.cn/api/shouer.php");
}
}

if(data.MessageContent.equals("小c酱")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.caonm.net/api/xc/index?key="+key);
}
}

if(data.MessageContent.equals("精选头像")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://apii.gq/api/jingxuantouxiang.php?msg=2");
}
}

if(data.MessageContent.equals("随机男头")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://apii.gq/api/suijitouxiang.php?format=2&type=image");
}
}

if(data.MessageContent.equals("随机女头")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://apii.gq/api/suijitouxiang.php?format=1&type=image");
}
}

if(data.MessageContent.equals("随机情头")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://apii.gq/api/suijitouxiang.php?format=3&type=image");
}
}

if(data.MessageContent.equals("猫羽雫")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://shanhe.kim/api/tu/mao.php");
}
}

if(data.MessageContent.equals("原神图")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.caonm.net/api/ys/t?key="+key);
}
}

if(data.MessageContent.equals("随机漫头")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://apii.gq/api/suijitouxiang.php?format=4&type=image");
}
}

if(data.MessageContent.equals("今日60s")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://apii.gq/api/60s.php");
}
}

if(data.MessageContent.equals("随机JK")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://shanhe.kim/api/tu/jk.php");
}
}

if(data.MessageContent.equals("随机二次元")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://imgapi.xl0408.top/index.php");
}
}

if(data.MessageContent.equals("二次元头像")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","http://www.yzxdd.icu/api/");
}
}

if(data.MessageContent.equals("随机白丝")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.caonm.net/api/bhs/b?key="+key);
}
}

if(data.MessageContent.equals("随机黑丝")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.caonm.net/api/bhs/h?key="+key);
}
}

if(data.MessageContent.equals("cos图2")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.vvhan.com/api/girl");
}
}

if(data.MessageContent.equals("少女写真")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
int a=0;
int b=6;
int c=随机数(a,b);
sendPic(qun,"","https://api.r10086.com/%E6%A8%B1%E9%81%93%E9%9A%8F%E6%9C%BA%E5%9B%BE%E7%89%87api%E6%8E%A5%E5%8F%A3.php?%E5%9B%BE%E7%89%87%E7%B3%BB%E5%88%97=%E5%B0%91%E5%A5%B3%E5%86%99%E7%9C%9F"+c);
}
}

if(data.MessageContent.equals("物语系列")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
int a=0;
int b=2;
int c=随机数(a,b);
sendPic(qun,"","https://api.r10086.com/%E6%A8%B1%E9%81%93%E9%9A%8F%E6%9C%BA%E5%9B%BE%E7%89%87api%E6%8E%A5%E5%8F%A3.php?%E5%9B%BE%E7%89%87%E7%B3%BB%E5%88%97=%E7%89%A9%E8%AF%AD%E7%B3%BB%E5%88%97"+c);
}
}

if(data.MessageContent.equals("猫娘系列")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.r10086.com/%E6%A8%B1%E9%81%93%E9%9A%8F%E6%9C%BA%E5%9B%BE%E7%89%87api%E6%8E%A5%E5%8F%A3.php?%E5%9B%BE%E7%89%87%E7%B3%BB%E5%88%97=%E7%8C%AB%E5%A8%981");
}
}

if(data.MessageContent.equals("风景系列")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
int a=0;
int b=10;
int c=随机数(a,b);
sendPic(qun,"","https://api.r10086.com/%E6%A8%B1%E9%81%93%E9%9A%8F%E6%9C%BA%E5%9B%BE%E7%89%87api%E6%8E%A5%E5%8F%A3.php?%E5%9B%BE%E7%89%87%E7%B3%BB%E5%88%97=%E9%A3%8E%E6%99%AF%E7%B3%BB%E5%88%97"+c);
}
}

if(data.MessageContent.equals("动漫综合")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
int a=0;
int b=18;
int c=随机数(a,b);
sendPic(qun,"","https://api.r10086.com/%E6%A8%B1%E9%81%93%E9%9A%8F%E6%9C%BA%E5%9B%BE%E7%89%87api%E6%8E%A5%E5%8F%A3.php?%E5%9B%BE%E7%89%87%E7%B3%BB%E5%88%97=%E5%8A%A8%E6%BC%AB%E7%BB%BC%E5%90%88"+c);
}
}

if(data.MessageContent.equals("原批系列")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.r10086.com/%E6%A8%B1%E9%81%93%E9%9A%8F%E6%9C%BA%E5%9B%BE%E7%89%87api%E6%8E%A5%E5%8F%A3.php?%E8%87%AA%E9%80%82%E5%BA%94%E5%9B%BE%E7%89%87%E7%B3%BB%E5%88%97=%E5%8E%9F%E7%A5%9E");
}
}

if(data.MessageContent.equals("随机壁纸")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.btstu.cn/sjbz/api.php?lx=dongman&format=images");
}
}

if(data.MessageContent.equals("坤坤表情")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
String tt=get("http://api.tangdouz.com/zzz/kk.php");
sendPic(qun,"",tt);
}
}

if(data.MessageContent.equals("pixiv2")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
String tt=get("http://api.cmvip.cn/API/se18url.php?return=r18");
String jb=User(3);
String file=RootPath+"下载/"+jb+".png";
String xz=DownloadToFile(tt,file);
if(xz.equals("成功")){
群聊发送(data,"图片下载成功！请到"+file+"查看");
return;
}
}
}

if(data.MessageContent.equals("漏点涩图")&&data.IsSend){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
String jb=User(3);
String file=RootPath+"下载/"+jb+".png";
String xz=DownloadToFile("https://image.anosu.top/pixiv/direct?r18=1&keyword=azurlane",file);
if(xz.equals("成功")){
群聊发送(data,"图片下载成功！请到"+file+"查看");
return;
}
}
}
if(data.MessageContent.equals("r18")&&data.IsSend){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
String jb=User(3);
String file=RootPath+"下载/"+jb+".png";
String xz=DownloadToFile("https://sex.nyan.xyz/api/v2/img?r18=true",file);
if(xz.equals("成功")){
群聊发送(data,"图片下载成功！请到"+file+"查看");
return;
}
}
}

if(data.MessageContent.equals("随机帅哥")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
String url=get("https://xiaobai.klizi.cn/API/img/boy.php");
sendPic(qun,"",url);
}
}

if(data.MessageContent.equals("随机腿照")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
String url=get("https://xiaobapi.top/api/xb/api/meitui.php?type=");
sendPic(qun,"",url);
}
}

if(data.MessageContent.equals("买家秀")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
String url=get("https://xiaobapi.top/api/xb/api/buyer_show.php?type=");
sendPic(qun,"",url);
}
}

if(data.MessageContent.equals("卖家秀")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
String url=get("https://xiaobapi.top/api/xb/api/mjx.php");
sendPic(qun,"",url);
}
}

if(data.MessageContent.equals("随机银发")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://moe.jitsu.top/img/?sort=silver");
}
}

if(data.MessageContent.equals("随机兽耳")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://moe.jitsu.top/img/?sort=furry");
}
}

if(data.MessageContent.startsWith("登录")){
if("1".equals(getString(data.GroupUin,"saoma"))){
String url=get("https://api.linhun.vip/api/smkey?apiKey=29b948f121c45970f40c1aeff04cad10&p="+quntext.substring(3));
putString(qun,uin+"登录",quntext.substring(3));
String data=url.replaceAll(" ","");
JSONObject json1 = new JSONObject(data);
String qrsig=json1.get("qrsig");
String pic=json1.get("img");
putString(qun,uin+"验证",qrsig);
sendPic(qun,"",pic);
String menu="[AtQQ="+uin+"]\n请通过TIM或者后置摄像头扫码";
群聊发送(data,menu);
Thread.sleep(30000);
String qrsig=getString(qun,uin+"验证");
String ppp=getString(qun,uin+"登录");
String yz=get("https://api.linhun.vip/api/smkey?apiKey=29b948f121c45970f40c1aeff04cad10&p="+ppp+"&qrsig="+qrsig);
String yzz=yz.replaceAll(" ","");
JSONObject json2 = new JSONObject(yzz);
String msg=json2.get("msg");
if(msg.equals("登录成功！")){
String name=json2.get("name");
String nskey=json2.get("skey");
String npskey=json2.get("p_skey");
String pt4=json2.get("pt4_token");
String ptsigx=json2.get("ptsigx");
String img=json2.get("img");
String menu="QQ:"+uin+"\n昵称:"+name+"\n您的登录信息已私聊";
群聊发送(data,menu);
sendMsg(qun,uin,"以下是您的登录信息\nSkey:"+nskey+"\nP_skey:"+npskey+"\nPt4_token:"+pt4+"\nptsigx:"+ptsigx);
put(RootPath+"/"+uin+"的"+quntext.substring(3)+"登陆数据.txt",yzz);
}else{
String menu="登录失败,原因:"+msg;
群聊发送(data,menu);
}
}
}

if(data.MessageContent.equals("cookie状态")&&!data.IsSend){
if("1".equals(getString(data.GroupUin,"saoma"))){
String data=MyFile.ReadFile(RootPath+"/"+uin+"的qzone登陆数据.txt");
String cnmb=data.replaceAll(" ","");
JSONObject json1 = new JSONObject(cnmb);
String nskey=json1.get("skey");
if(nskey.equals("")){
String menu="您似乎还未登录过哦～";
群聊发送(data,menu);
}else{
String hhh=get("https://xiaobai.klizi.cn/API/qqgn/pd.php?&uin="+uin+"&skey="+nskey);
if(hhh.equals("0")){
String menu="您的cookie登录状态正常";
群聊发送(data,menu);
}else{
String menu="您的登录状态似乎失效了呢";
群聊发送(data,menu);
}
}
}
}

if(data.MessageContent.startsWith("百度")){
String msg=quntext.substring(2);
String url=get("http://api.wlx.cc/api/bk.php?msg="+msg+"&type=text");
String url=url.replace("±img=","[PicUrl=").replace("±","]");
群聊发送(data,"结果:"+url);
}

if(data.MessageContent.startsWith("发送说说")&&data.IsSend){
String msg=quntext.substring(4);
String url=get("http://api.wlx.cc/api/qqkj_fss.php?qq="+qq+"&skey="+skey+"&pskey="+qzone+"&msg="+msg+"type=text");
群聊发送(data,url);
}

if(data.MessageContent.equals("注册时间")&&data.IsSend){
String ti=getPskey("ti.qq.com");
String url=get("https://api.kit9.cn/api/qq_registration_time/api.php?qq="+qq+"&skey="+skey+"&p_skey="+ti);
String ts=url.replaceAll(" ","");
JSONObject json1 = new JSONObject(ts);
String text=json1.get("msg");
if(text.equals("success")){
String data=json1.getString("data");
JSONObject json2 = new JSONObject(data);
String register_time=json2.get("register_time");
群聊发送(data,"注册时间:"+register_time);
}else{
群聊发送(data,"失败，未知错误:"+url);
}
}

if(data.MessageContent.equals("领取3天绿钻")){
if(getString(uin,"nskey")==null){
群聊发送(data,"未授权，请发送『登录qzone』");
}else{
String nskey=getString(uin,"nskey");
String url=get("http://ai.xn--7gqa009h.top/api/3tlz?qq="+uin+"&skey="+nskey);
群聊发送(data,url);
}
}

if(data.MessageContent.equals("领取绿钻")&&data.IsSend){
String url=get("http://ai.xn--7gqa009h.top/api/3tlz?qq="+qq+"&skey="+skey);
群聊发送(data,url);
}

if(data.MessageContent.startsWith("发送视频")&&data.IsSend){
String url=quntext.substring(4);
sendVedio1(qun,url);
}

if(data.MessageContent.startsWith("查QQ")){
if("1".equals(getString(data.GroupUin,"查询系统"))){
String sq=get("https://zy.xywlapi.cc/qqapi?qq="+quntext.substring(3));
JSONObject json1 = new JSONObject(sq);
String mm=json1.getString("message");
if(mm.equals("查询成功")){
String qqq=json1.getString("qq");
String phone=json1.getString("phone");
String phonediqu=json1.getString("phonediqu");
群聊发送(data,"message:"+mm+"\nqq:"+qqq+"\nphone:"+phone+"\nphonediqu:"+phonediqu);
}else{
群聊发送(data,mm);
}
}
}

if(data.MessageContent.startsWith("查老密")){
String sq=get("https://zy.xywlapi.cc/qqlm?qq="+quntext.substring(3));
JSONObject json1 = new JSONObject(sq);
String mm=json1.getString("message");
if(mm.equals("查询成功")){
String qqq=json1.getString("qq");
String lm=json1.getString("qqlm");
群聊发送(data,"message:"+mm+"\nqq:"+qqq+"\nlm:"+lm);
}else{
群聊发送(data,mm);
}
}

if(data.MessageContent.startsWith("HZ")&&data.IsSend){
String sq=get("https://cg-api.heyfriday.cn/sms/send?phoneNumber="+quntext.substring(2));
JSONObject json1 = new JSONObject(sq);
String mm=json1.getString("message");
if(mm.equals("Success")){
群聊发送(data,"message："+mm+"成功");
}else{
群聊发送(data,mm);
}
}

if(data.MessageContent.equals("群聊功能")&&data.IsSend){
Thread.sleep(800);
String menu=菜单头+"\n『窥屏检测』『活跃排行』\n『查询龙王』『本群星级』\n『管家设置』『抽群字符』\n『查活跃度』『管理列表』\n『禁言列表』『一键解禁』\n『查打卡王』『字符列表』\n『批量群头衔+头衔』\n『开/关本群头衔』\n『开/关互动标识』\n『开/关头衔等级』\n『开/关本群匿名』\n『发送作业+内容』\n『发送公告+内容』\n"+菜单尾;
群聊发送(data,menu);
}

if(data.MessageContent.equals("一键解禁")&&data.IsSend){
for(Object List:getForbiddenList(qun)){
Forbidden(qun,List.UserUin,0);
Thread.sleep(200);}
String menu="已一键解禁全部禁言成员";
群聊发送(data,menu);
}

if(data.MessageContent.equals("禁言列表")&&data.IsSend){
String result="";
for(Object List:getForbiddenList(qun)){
long time = Long.valueOf(List.Endtime);
SimpleDateFormat createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
result+="\n"+List.UserUin+"("+List.UserName+")\n禁言结束时间:"+createTime.format(new Date(time));}
if(!result.equals("")){
String menu="禁言列表:"+result;
群聊发送(data,menu);
}else{
String menu="目前没有人被禁言哦～";
群聊发送(data,menu);
}
}

if(data.MessageContent.equals("管理列表")&&data.IsSend){
String url=get("https://api.f4team.cn/API/qung/api.php?qq="+qq+"&s="+skey+"&p="+qunpskey+"&group="+qun);
String url2=url.replaceAll(" ","");
JSONObject json1 = new JSONObject(url2);
String data=json1.getString("data");
String data2=data.replace("[","").replace("]","");
String menu="本群管理员列表:\n"+data2;
群聊发送(data,menu);
}

if(data.MessageContent.equals("查活跃度")&&data.IsSend){
String cookie="ptui_loginuin="+uin+"; p_uin=o"+uin+"; uin=o"+uin+"; skey="+skey+"; p_skey="+qunpskey;
String url=httpget("https://qun.qq.com/cgi-bin/qun_mgr/search_group_members?gc="+qun+"&st=0&end=19&sort=0&last_speak_time=&bkn="+GetBkn(skey),cookie);
String result ="";
JSONObject json1 = new JSONObject(url);
JSONArray mems=json1.getJSONArray("mems");
for(int i=0;i<mems.length();i++){
JSONObject mems2=mems.getJSONObject(i);
long uin=mems2.get("uin");
long join_time=mems2.get("join_time");
long last_speak_time=mems2.get("last_speak_time");
String join=get("http://aaa.ski/a/time3.php?time="+join_time);
String last=get("http://aaa.ski/a/time3.php?time="+last_speak_time);
result+="QQ:"+uin+"\n加群时间:"+join+"\n最后发言:"+last+"\n\n";}
String menu=result;
群聊发送(data,menu);
}

if(data.MessageContent.equals("关本群匿名")&&data.IsSend){
String url=get("http://xiaobai.klizi.cn/API/qqgn/qun_anony.php?&value=0&uin="+qq+"&skey="+skey+"&pskey="+qqweb+"&group="+qun);
群聊发送(data,url);
}

if(data.MessageContent.equals("开本群匿名")&&data.IsSend){
String url=get("http://xiaobai.klizi.cn/API/qqgn/qun_anony.php?&value=1&uin="+qq+"&skey="+skey+"&pskey="+qqweb+"&group="+qun);
群聊发送(data,url);
}

if(data.MessageContent.equals("个人装扮")){
Thread.sleep(800);
String menu=菜单头+"\n『点亮cf』『领取绿钻』\n『特别关心』\n『注册时间』『发送说说+内容』\n『听歌加速』『我的等级』\n『空间签到』『发布签名+内容』\n『达人查询』『日签打卡』\n『我的信息』『积分查询』\n『刷听歌时长』\n"+菜单尾;
群聊发送(data,menu);
}

if(data.MessageContent.equals("达人查询")){
String url=get("https://api.kit9.cn/api/qq_talent/api.php?qq="+uin);
String ts=url.replaceAll(" ","");
JSONObject json1 = new JSONObject(ts);
String text=json1.get("msg");
if(text.equals("success")){
String data=json1.getString("data");
JSONObject json2 = new JSONObject(data);
String days=json2.optString("days");
群聊发送(data,"达人天数:"+days);
}else{
群聊发送(data,"失败，未知错误:"+url);
}
}

if(data.MessageContent.startsWith("发布签名")&&data.IsSend){
String url=get("https://xiaobai.klizi.cn/API/qqgn/qq_qm.php?uin="+qq+"&skey="+skey+"&pskey="+tipskey+"&msg="+quntext.substring(4));
群聊发送(data,url);
}

if(data.MessageContent.equals("空间签到")&&data.IsSend){
String url=get("http://api.kit9.cn/api/qq_sign_in/api.php?qq="+qq+"&skey="+skey+"&p_skey="+qzone);
String ts=url.replaceAll(" ","");
JSONObject json1 = new JSONObject(ts);
String text=json1.get("msg");
if(text.equals("success")){
String data=json1.getString("data");
JSONObject json2 = new JSONObject(data);
String result=json2.get("state");
群聊发送(data,"成功，结果:"+result);
}else{
String data=json1.getString("data");
JSONObject json2 = new JSONObject(data);
String result=json2.get("state");
群聊发送(data,"失败，未知错误:"+result);
}
}

if(data.MessageContent.equals("日签打卡")&&data.IsSend){
String url=get("http://api.kit9.cn/api/qq_daily_sign_card/api.php?qq="+qq+"&skey="+skey+"&p_skey="+tipskey);
String ts=url.replaceAll(" ","");
JSONObject json1 = new JSONObject(ts);
String text=json1.get("msg");
if(text.equals("success")){
String data=json1.getString("data");
JSONObject json2 = new JSONObject(data);
String result=json2.get("result");
群聊发送(data,"成功，结果:"+result);
}else{
String data=json1.getString("data");
JSONObject json2 = new JSONObject(data);
String result=json2.get("result");
群聊发送(data,"失败，未知错误:"+result);
}
}

if(data.MessageContent.equals("开撤回群链接")&&data.IsSend){
String url=get("https://xiaobai.klizi.cn/API/qqgn/qun_house.php?&uin="+qq+"&skey="+skey+"&pskey="+qunpskey+"&group="+qun+"&type=1&switch=1");
JSONObject json1 = new JSONObject(url);
String msg=json1.get("retmsg");
if(msg.equals("success")){
群聊发送(data,"成功");
}else{
群聊发送(data,url);
}
}

if(data.MessageContent.equals("关撤回群链接")&&data.IsSend){
String url=get("https://xiaobai.klizi.cn/API/qqgn/qun_house.php?&uin="+qq+"&skey="+skey+"&pskey="+qunpskey+"&group="+qun+"&type=1&switch=0");
JSONObject json1 = new JSONObject(url);
String msg=json1.get("retmsg");
if(msg.equals("success")){
群聊发送(data,"成功");
}else{
群聊发送(data,url);
}
}

if(data.MessageContent.equals("开撤回二维码")&&data.IsSend){
String url=get("https://xiaobai.klizi.cn/API/qqgn/qun_house.php?&uin="+qq+"&skey="+skey+"&pskey="+qunpskey+"&group="+qun+"&type=2&switch=1");
JSONObject json1 = new JSONObject(url);
String msg=json1.get("retmsg");
if(msg.equals("success")){
群聊发送(data,"成功");
}else{
群聊发送(data,url);
}
}

if(data.MessageContent.equals("关撤回二维码")&&data.IsSend){
String url=get("https://xiaobai.klizi.cn/API/qqgn/qun_house.php?&uin="+qq+"&skey="+skey+"&pskey="+qunpskey+"&group="+qun+"&type=2&switch=0");
JSONObject json1 = new JSONObject(url);
String msg=json1.get("retmsg");
if(msg.equals("success")){
群聊发送(data,"成功");
}else{
群聊发送(data,url);
}
}

if(data.MessageContent.equals("开口令红包")&&data.IsSend){
String url=get("https://xiaobai.klizi.cn/API/qqgn/qun_house.php?&uin="+qq+"&skey="+skey+"&pskey="+qunpskey+"&group="+qun+"&type=3&switch=1");
JSONObject json1 = new JSONObject(url);
String msg=json1.get("retmsg");
if(msg.equals("success")){
群聊发送(data,"成功");
}else{
群聊发送(data,url);
}
}

if(data.MessageContent.equals("关口令红包")&&data.IsSend){
String url=get("https://xiaobai.klizi.cn/API/qqgn/qun_house.php?&uin="+qq+"&skey="+skey+"&pskey="+qunpskey+"&group="+qun+"&type=3&switch=0");
JSONObject json1 = new JSONObject(url);
String msg=json1.get("retmsg");
if(msg.equals("success")){
群聊发送(data,"成功");
}else{
群聊发送(data,url);
}
}

if(data.MessageContent.equals("本群星级")&&data.IsSend){
String url=get("http://jiuli.xiaoapi.cn/i/qq/qun_get_credit_level_info.php?uin="+qq+"&skey="+skey+"&pskey="+qqweb+"&qh="+qun);
String uuu=url.replaceAll(" ","");
JSONObject json1 = new JSONObject(uuu);
String msg=json1.get("msg");
if(msg.equals("久黎API，获取成功。")){
String menu="群号:"+qun+"\n群名:"+json1.get("group_name")+"\n群主:"+json1.get("group_owner")+"\n群等级:"+json1.get("level_icon");
群聊发送(data,menu);
}else{
群聊发送(data,url);
}
}


if(data.MessageContent.equals("抽群字符")&&data.IsSend){
String url=get("https://api.caonm.net/api/qzf/q?Group="+qun+"&QQ="+qq+"&Pskey="+qunpskey+"&Skey="+skey+"&key="+key);
String url2=url.replaceAll(" ","");
JSONObject json = new JSONObject(url2);
String text=json.get("text");
if(text.equals("获取成功")){
String data=json.getString("data");
JSONObject json2 = new JSONObject(data);
String Character=json2.get("Character");
String Desc=json2.get("Desc");
群聊发送(data,"恭喜你抽到字符:"+Character+"\n寓意:"+Desc);
}else{
群聊发送(data,text);
}
}

if(data.MessageContent.startsWith("上管@")&&data.IsSend){
String at=data.AtList[0];
String text=setAdmin(qun,at,1);
群聊发送(data,text);
}

if(data.MessageContent.startsWith("下管@")&&data.IsSend){
String at=data.AtList[0];
String text=setAdmin(qun,at,0);
群聊发送(data,text);
}

if(quntext.equals("开互动标识")&&data.IsSend){
String nm=SetTroopShowHonour(qun,qq,getSkey(),getPskey("clt.qq.com"),1);
群聊发送(data,nm);
}
if(quntext.equals("开头衔等级")&&data.IsSend){
String nm=SetTroopShowLevel(qun,qq,getSkey(),getPskey("clt.qq.com"),1);
群聊发送(data,nm);
}
if(quntext.equals("开本群头衔")&&data.IsSend){
String nm=SetTroopShowTitle(qun,qq,getSkey(),getPskey("clt.qq.com"),1);
群聊发送(data,nm);
}
if(quntext.equals("关互动标识")&&data.IsSend){
String nm=SetTroopShowHonour(qun,qq,getSkey(),getPskey("clt.qq.com"),0);
群聊发送(data,nm);
}
if(quntext.equals("关头衔等级")&&data.IsSend){
String nm=SetTroopShowLevel(qun,qq,getSkey(),getPskey("clt.qq.com"),0);
群聊发送(data,nm);
}
if(quntext.equals("关本群头衔")&&data.IsSend){
String nm=SetTroopShowTitle(qun,qq,getSkey(),getPskey("clt.qq.com"),0);
群聊发送(data,nm);
}

if(data.MessageContent.equals("活跃排行")&&data.IsSend){
String url=get("http://api.wlx.cc/api/fyph.php?qq="+qq+"&skey="+skey+"&pskey="+qunpskey+"&group="+qun);
群聊发送(data,url);
}

if(data.MessageContent.startsWith("发送公告")&&data.IsSend){
String tp=quntext.substring(4);
String url=get("https://xiaobai.klizi.cn/API/qqgn/gg_send.php?data=&uin="+qq+"&skey="+skey+"&pskey="+qunpskey+"&group="+qun+"&text="+tp);
JSONObject json1 = new JSONObject(url);
String ec=json1.optString("ec");
if(ec.equals("0")){
Toast("发布公告成功");
}else{
群聊发送(data,url);
}
}

if(data.MessageContent.startsWith("#发送作业")&&data.IsSend){
String tp=quntext.substring(4);
String url=get("http://xiaobai.klizi.cn/API/qqgn/qun_work.php?title=今日作业&uin="+qq+"&skey="+skey+"&pskey="+qunpskey+"&group="+qun+"&msg="+tp);
JSONObject json1 = new JSONObject(url);
String msg=json1.get("msg");
if(msg.equals("success")){
Toast("发布作业成功");
}else{
群聊发送(data,url);
}
}

if(quntext.equals("查询龙王")){//陌然
   skey=getSkey();
   pskey=getPskey("qun.qq.com");
   String result2="";
   String cookie="p_skey="+pskey+"; uin=o"+qq+"; skey="+skey+"; p_uin=o"+qq;
   String result=httpget("https://qun.qq.com/interactive/honorlist?gc="+qun+"&type=1&_wv=3&_wwv=129",cookie);
int index = result.lastIndexOf("window.__INITIAL_STATE__=");
String text = result.substring(index + 25);
int rd = text.indexOf("};");
String re = text.substring(0,rd+1);
JSONObject json=new JSONObject(re);
if(json.getString("currentTalkative").equals("null"))
   {
   sendMsg(qun,"","该群还没有龙王");
   return;
   }
if(json.getString("currentTalkative").equals("{}"))
   {
   sendMsg(qun,"","pskey错误");
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
String menu="龙王:"+nick+"\n连续"+day+"天龙王\n\n历史获得成员"+result2+"\n只显示前五位(共"+j.length()+"位)";
群聊发送(data,menu);
}

if(data.MessageContent.equals("点亮cf")&&data.IsSend){
String vip=getPskey("vip.qq.com");
String url=get("http://ai.xn--7gqa009h.top/api/cftb?uin="+qq+"&pskey="+vip);
String hhh=url.replaceAll(" ","");
JSONObject json1 = new JSONObject(hhh);
String msg=json1.get("msg");
群聊发送(data,msg);
}

if(data.MessageContent.equals("特别关心")&&data.IsSend){
String url=get("http://xiaobai.klizi.cn/API/qqgn/specialcare.php?data=&uin="+qq+"&skey="+skey+"&pskey="+qzone);
JSONObject json1 = new JSONObject(url);
String mys=json1.optString("我关心的");
String smy=json1.optString("关心我的");
群聊发送(data,"关心我的:"+smy+"\n我关心的:"+mys);
}

if(data.MessageContent.startsWith("图片天气")){
String tp=quntext.substring(4);
sendPic(qun,"","https://api.caonm.net/api/qqtq/t?msg="+tp+"&key="+key);
}

if(data.MessageContent.startsWith("墨迹天气")){
String tp=quntext.substring(4);
String url=get("http://api.caonmtx.cn/api/tianqi.php?msg="+tp+"&n=1");
sendMsg(qun,"",url);
}

if(data.MessageContent.startsWith("发送图片")&&data.IsSend){
sendPic(qun,"",quntext.substring(4));
}

if(data.MessageContent.equals("漫剪视频")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=漫剪视频&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("张娜英系")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/zny/m?key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("美女视频")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=美女视频&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("小姐姐SP")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="http://api.yujn.cn/api/xjj.php";
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("VC独角")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=vc独角&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("百变小晨")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=百变小晨&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("肥牛卷儿")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=肥牛卷儿&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("小羊肖恩")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=小羊肖恩&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("国国睡觉")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=国国睡觉&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("泡泡又困")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=泡泡又困&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("蕾姆变装")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=蕾姆变装&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("光剑变装")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=光剑变装&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("腹肌变装")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=腹肌变装&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("蹲下变装")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=蹲下变装&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("背影变装")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=背影变装&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("爱上螺蛳")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=爱上螺蛳&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("帅哥视频")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=帅哥视频&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("西施美女")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=西施美女&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("体操服系")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=体操服系&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("你的欲梦")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=你的欲梦&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("程女士系")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=程女士系&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("连蜜系列")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=连蜜系列&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("黑色夜光")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=黑色夜光&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("雅萌系列")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=雅萌系列&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("小芷儿系")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=小芷儿系&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("妹子合集")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="http://api.yujn.cn/api/juhexjj.php";
sendVedio1(qun,url);
}
}
if(data.MessageContent.equals("风景视频")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="http://api.yujn.cn/api/pcfj.php";
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("推荐视频")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=随机视频&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("电气鼠系")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=电气鼠系&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("菠萝拌饭")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=菠萝拌饭&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("皮卡邱系")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=皮卡邱系&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("土堆酱系")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=土堆酱系&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("晚安烟儿")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="https://api.caonm.net/api/cdmn/m?lx=晚安烟儿&key="+key;
sendVedio1(qun,url);
}
}

if(data.MessageContent.equals("微视视频")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url=get("http://www.wanghun.top/api/v1/weishi.php");
sendMsg(qun,"",url);
}
}

if(data.MessageContent.equals("随机微视")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url=get("http://api.cmvip.cn/API/weishi.php");
String sp=url.replace("±img=","[PicUrl=").replace("±","]");
sendMsg(qun,"",sp);
}
}

if(data.MessageContent.equals("快手变装")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url="http://api.caonmtx.cn/api/ksbz.php";
sendVedio1(qun,url);
}
}


if(data.MessageContent.equals("抖音热点")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url=get("https://xiaobai.klizi.cn/API/video/douyin_redian.php");
String re=url.replaceAll(" ","");
JSONObject json1 = new JSONObject(re);
String desc=json1.get("desc");
String author=json1.get("author");
String cover=json1.get("cover");
String video=json1.get("video");
sendMsg(qun,"","[PicUrl="+cover+"]作者:"+author+"\n标题:"+desc+"\n链接:"+video);
}
}

if(data.MessageContent.equals("抖音娱乐")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url=get("https://xiaobai.klizi.cn/API/video/douyin_yule.php");
String re=url.replaceAll(" ","");
JSONObject json1 = new JSONObject(re);
String desc=json1.get("desc");
String author=json1.get("author");
String cover=json1.get("cover");
String video=json1.get("video");
sendMsg(qun,"","[PicUrl="+cover+"]作者:"+author+"\n标题:"+desc+"\n链接:"+video);
}
}

if(data.MessageContent.equals("快手推荐")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url=get("https://xiaobai.klizi.cn/API/video/kuaishou_tj.php");
String re=url.replaceAll(" ","");
JSONObject json1 = new JSONObject(re);
String desc=json1.get("title");
String author=json1.get("author");
String cover=json1.get("cover");
String video=json1.get("url");
sendMsg(qun,"","[PicUrl="+cover+"]作者:"+author+"\n标题:"+desc+"\n链接:"+video);
}
}

if(data.MessageContent.equals("快手精选")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String url=get("https://xiaobai.klizi.cn/API/video/kuaishou_jx.php");
String re=url.replaceAll(" ","");
JSONObject json1 = new JSONObject(re);
String desc=json1.get("title");
String author=json1.get("author");
String cover=json1.get("cover");
String video=json1.get("url");
sendMsg(qun,"","[PicUrl="+cover+"]作者:"+author+"\n标题:"+desc+"\n链接:"+video);
}
}

if(data.MessageContent.equals("视频大全")){
if("1".equals(getString(data.GroupUin,"shipindaquan"))){
String menu=菜单头+"\n小姐姐SP VC独角\n帅哥视频 美女视频\n漫剪视频 风景视频\n百变小晨 肥牛卷儿\n小羊肖恩 国国睡觉\n泡泡又困 蕾姆变装\n光剑变装 腹肌变装\n蹲下变装 背影变装\n爱上螺蛳 西施美女\n体操服系 你的欲梦\n程女士系 张娜英系\n连蜜系列 黑色夜光\n雅萌系列 小芷儿系\n随机视频 妹子合集\n推荐视频 电气鼠系\n菠萝拌饭 皮卡邱系\n土堆酱系 微视视频\n随机微视 快手变装\n抖音热点 抖音娱乐\n快手推荐 快手精选\n"+菜单尾;
群聊发送(data,menu);
}else{
群聊发送(data,"本群『视频大全』未开启，请联系主人"+qq+"，发送『开启视频大全』");
}
}

if(data.MessageContent.equals("随机坤坤")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.caonm.net/api/kun/k?key="+key);
}
}

if(data.MessageContent.equals("随机龙图")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.caonm.net/api/long/l?key="+key);
}
}

if(data.MessageContent.equals("随机涩图")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
String jb=User(3);
String file=RootPath+"下载/"+jb+".png";
String xz=DownloadToFile("https://moe.jitsu.top/img/?sort=setu",file);
if(xz.equals("成功")){
群聊发送(data,"图片下载成功！请到"+file+"查看");
return;
}
}
}

if(data.MessageContent.equals("随机cos图")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.vvhan.com/api/girl");
}
}

if(data.MessageContent.equals("随机腹肌")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.wqwlkj.cn/wqwlapi/sgfj.php?type=image");
}
}

if(data.MessageContent.equals("随机妹子")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.caonm.net/api/mnt/index?key="+key);
}
}

if(data.MessageContent.equals("随机腿图")){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
sendPic(qun,"","https://api.asxe.vip/whitesilk.php");
}
}


if(data.MessageContent.equals("刷听歌时长")){
if("1".equals(getString(data.GroupUin,"刷听歌"))){
String yy=get("http://shanhe.kim/api/qy/qy_v1.php?qq="+data.UserUin);
String url=yy.replaceAll(" ","");
JSONObject json1 = new JSONObject(url);
String msg=json1.get("message");
String ps=json1.get("ps");
String tips=json1.get("tips");
sendMsg(qun,"","[AtQQ="+uin+"]"+msg+"\nPS:"+ps+"\nTips:"+tips+"\n点击此处查看排行榜:https://y.qq.com/m/client/vipexchange/index.html");
return;
}
}

if(data.MessageContent.startsWith("刷听歌时长@")){
String at=data.AtList[0];
String yy=get("http://shanhe.kim/api/qy/qy_v1.php?qq="+at);
String url=yy.replaceAll(" ","");
JSONObject json1 = new JSONObject(url);
String msg=json1.get("message");
String ps=json1.get("ps");
String tips=json1.get("tips");
sendMsg(qun,"","[AtQQ="+at+"]"+msg+"\nPS:"+ps+"\nTips:"+tips+"\n点击此处查看排行榜:https://y.qq.com/m/client/vipexchange/index.html");
return;
}

if(data.MessageContent.equals("听歌加速")){
if("1".equals(getString(data.GroupUin,"刷听歌"))){
String yy=get("http://ai.xn--7gqa009h.top/api/tgsc?qq="+data.UserUin);
String url=yy.replaceAll(" ","");
JSONObject json1 = new JSONObject(url);
String msg=json1.get("msg");
String yyy=msg.replace("七七API：api.xn--7gqa009h.top","");
String yyyyy=yyy.replace("\n\n","");
sendMsg(qun,"","[AtQQ="+uin+"]"+yyyyy);
return;
}
}
if(data.MessageContent.startsWith("听歌加速@")){
String at=data.AtList[0];
String yy=get("http://ai.xn--7gqa009h.top/api/tgsc?qq="+at);
String url=yy.replaceAll(" ","");
JSONObject json1 = new JSONObject(url);
String msg=json1.get("msg");
String yyy=msg.replace("七七API：api.xn--7gqa009h.top","");
String yyyyy=yyy.replace("\n\n","");
sendMsg(qun,"","[AtQQ="+at+"]"+yyyyy);
return;
}
if(data.MessageContent.startsWith("https://v.kuaishou.com/")){
群聊发送(data,"[AtQQ="+uin+"]\n解析中......");
String sl=quntext.substring(0,29);
String url="http://ai.xn--7gqa009h.top/api/ks_jx?a="+sl+"&type=1";
String sj=get(url);
String js=sj.replaceAll(" ","").replaceAll("\n","");
JSONObject json1 = new JSONObject(js);
String title=json1.get("title");
String urll=json1.get("url");
String audio=json1.get("audio");
String tx=json1.get("tx");
String name=json1.get("name");
qqsendTroopMusic(qun,"快手解析---"+name,title,urll,audio,tx);
}

if(data.MessageContent.startsWith("chat")){
if("1".equals(getString(data.GroupUin,"GPT"))){
String jm=jm("aHR0cDovL2FwaS5jYW9ubXR4LmNuL2FwaS9iaW5nR1BULnBocA==");
String url=jm+"?msg="+quntext.substring(4);
String js=get(url);
String menu="类型:非记忆问答\n回答:"+js;
群聊发送(data,menu);
}
}

if(data.MessageContent.startsWith("Chat")){
if("1".equals(getString(data.GroupUin,"GPT"))){
String jm=jm("aHR0cDovL3kub3ZvYS5jYy9hcGkvQ2hhdEdQVC5waHA=");
String url=jm+"?msg="+quntext.substring(4)+"&type=text&id="+uin+"&mode=";
String js=get(url);
String menu="id="+uin+"\n类型:非联网记忆问答\n回答:"+js;
群聊发送(data,menu);
}
}

if(data.MessageContent.startsWith("gpt")){
if("1".equals(getString(data.GroupUin,"GPT"))){
String url="http://x6.gay/gpt6.php";
String nmb=http.post(url,"msg="+quntext.substring(3)).replaceAll(" ","");
JSONObject json1 = new JSONObject(nmb);
String text=json1.get("text");
String menu=text;
群聊发送(data,menu);
}
}

if(data.MessageContent.startsWith("Ai")){
if("1".equals(getString(data.GroupUin,"GPT"))){
String jm=jm("aHR0cDovL3kub3ZvYS5jYy9hcGkvQ2hhdEdQVC5waHA=");
String url=jm+"?msg="+quntext.substring(2)+"&id="+uin+"&type=text&mode=";
String nmb=get(url);
String menu="id="+uin+"\n类型:非联网记忆问答\n回答:"+nmb;
群聊发送(data,menu);
}
}

if(data.MessageContent.startsWith("智能Ai")){
if("1".equals(getString(data.GroupUin,"GPT"))){
String jm=jm("aHR0cDovL2FwaS55b3V6YWkubG92ZS9BUEkvTmV3R1BULnBocA==");
String url=jm+"?msg="+quntext.substring(6);
String js=get(url);
String menu="回答:"+js;
群聊发送(data,menu);
}
}

if(data.MessageContent.startsWith("GPT4")){
if("1".equals(getString(data.GroupUin,"GPT"))){
String jm=jm("aHR0cDovL3g2LmdheS9jaGF0Z3B0NC5waHA=");
String url=jm+"?msg="+quntext.substring(4)+"&id="+uin;
String js=get(url);
String menu="id:"+uin+"\n回答:"+js;
群聊发送(data,menu);
}
}

if(data.MessageContent.startsWith("GPT3.5")){
if("1".equals(getString(data.GroupUin,"GPT"))){
String jm=jm("aHR0cHM6Ly94aWFvYmFpLmtsaXppLmNuL0FQSS9vdGhlci9ncHQucGhw");
String url=jm+"?msg="+quntext.substring(6);
String js=get(url);
String menu="回答:"+js;
群聊发送(data,menu);
}
}

if(data.MessageContent.equals("瑟瑟视频")&&data.IsSend){
String jm=jm("aHR0cDovLzEyMy45OS4xOTkuMjIwOjQ1MS9odWEv");
int a=1;
int b=1610;
int c=随机数(a,b);
ThisActivity=GetActivity();
Intent intent = new Intent(Intent.ACTION_VIEW);
intent.setData(Uri.parse(jm+c+".m3u8"));
ThisActivity.startActivity(intent);
}

if(data.MessageContent.equals("瑟瑟视频2")&&data.IsSend){
int a=1;
int b=1616;
int c=随机数(a,b);
ThisActivity=GetActivity();
Intent intent = new Intent(Intent.ACTION_VIEW);
intent.setData(Uri.parse("http://m3u8.kukuplay.com:666/html/"+c+".m3u8"));
ThisActivity.startActivity(intent);
}

if("白丝".equals(quntext)||"黑丝".equals(quntext)){
if("1".equals(getString(data.GroupUin,"tupiancaidan"))){
String url="http://ai.xn--7gqa009h.top/api/bshs?msg="+quntext.substring(1)+"&type=1";
try {
String uu="";
JSONObject jsonObject = new JSONObject(get(url));
String bt = jsonObject.getString("bt");
JSONObject data = jsonObject.getJSONObject("data");
int length = data.length();
for (int i = 1; i <= length; i++) {
uu += "[PicUrl="+data.getString(String.valueOf(i))+"]";
}
sendMsg(qun,"","[AtQQ="+uin+"]"+bt+uu);
} catch (JSONException e) {
e.printStackTrace();
}
}
}

if(data.MessageContent.startsWith("发语音")){
if("1".equals(getString(data.GroupUin,"yuyin"))){
if(quntext.substring(3).equals("")){
群聊发送(data,"[AtQQ="+uin+"]\n额没有关键词");
return;
}
String url="http://ai.xn--7gqa009h.top/api/lsdd?msg="+quntext.substring(4);
String url=get(url);
int cc=url.indexOf("http");
String pd=Integer.toString(cc);
if("-1".equals(pd)){
sendMsg(qun,"",url);
return;
}
String name=RootPath+"语音/"+uin+".mp3";
视频.下载视频(url,name);
sendVoice(qun,"",name);
return;
}
}

if(data.MessageContent.startsWith("转语音")){
String str=quntext;
int url=str.indexOf("http");
String pd=Integer.toString(url);
if(pd.equals("-1")){
群聊发送(data,"[AtQQ="+uin+"]请携带http(s)");
return;
}
String name=str.substring(3,url);
String lj=str.substring(url);
String name=RootPath+"语音/"+name+".mp3";
视频.下载视频(lj,name);
sendVoice(qun,"",name);
}

if("随机视频".equals(quntext)){
//sendMsg(qun,"","下架了");
//return;
int a=1;
int b=2;
int c=随机数(a,b);
String d=Integer.toString(c);
String url=get("http://ai.xn--7gqa009h.top/api/kuaishou?a="+d);
String url=视频.真实地址(url);
if(url.equals("")){
sendMsg(qun,"","获取视频地址失败");
return;
}else{
//sendMsg(qun,"","[AtQQ="+uin+"]\n"+url);
//return;
qqsendTroopMusic(qun,"随机视频---冷雨Java","随机视频",url,url,"http://gchat.qpic.cn/gchatpic_new/0/0-0-251FBDB399FA34AD3A60144750248893/0?term=2");
}
}

if(data.MessageContent.startsWith("我要头衔"))
{
if("1".equals(getString(data.GroupUin,"lengyu"))){
if(getGroupOwner(qun).equals(qq)){
setTitle(data.GroupUin,data.UserUin,data.MessageContent.substring(4));
Thread.sleep(800);
String menu="QQ:"+uin+"\n您的头衔已经ok了哦";
群聊发送(data,menu);
}else{
Thread.sleep(800);
String menu="QQ:"+uin+"\n对不起，我还不是群主呢！";
群聊发送(data,menu);
}
}
}
	
if("赞我".equals(quntext)&&!data.IsSend){
if("1".equals(getString(data.GroupUin,"zanwo"))){
String time=getString(uin,"time");
String time1=年月日();
if(!time1.equals(time)){
sendLike(uin,10);
sendLike(uin,10);
putString(uin,"time",time1);
String menu="QQ:"+uin+"\n已为你点赞20次";
群聊发送(data,menu);
}else{
String menu="QQ:"+uin+"\n今日已经为你点过赞了哦";
群聊发送(data,menu);
}
}
}

if(data.MessageContent.startsWith("点赞@")&&data.IsSend){
String at=data.AtList[0];
sendLike(at,20);
String menu="已为"+at+"点赞20次";
群聊发送(data,menu);
}
//你来这里干什么？滚出去！
if(data.MessageContent.startsWith("签名卡片")&&data.IsSend){
String kp=quntext.substring(4);
String pskey=getPskey("vip.qq.com");
String cookie="uin=o0"+qq+"; skey="+skey+"; p_uin=o0"+qq+"; p_skey="+pskey;
dataJson="{\"ark\":\""+kp.replace("\"","\\\"").replace("\\n","\\\\"+"n")+"\"}";
String url=httppost1("https://zb.vip.qq.com/tx/trpc/ark-share/GenSignedArk?g_tk="+GetBkn(skey),cookie,dataJson);
JSONObject json = new JSONObject(url);
String code=json.optString("code");
if(code.equals("0")){
String data=json.getString("data");
JSONObject json1 = new JSONObject(data);
String signed_ark=json1.getString("signed_ark");
String jb=signed_ark.replace("}\n","}");
sendCard(qun,"",jb);
}else{
String data=json.getString("data");
JSONObject json2 = new JSONObject(data);
String message=json2.get("message");
群聊发送(data,message);
}
}

if(data.MessageContent.startsWith("卡片签名")&&data.IsSend){
String text=quntext.substring(4);
String kp=text.replaceAll("#","井号").replaceAll("\n","\\\\n");
String token=jm("Ym90YXJrMjAyMw==");
String url=get(ark+"?uin="+qq+"&token="+token+"&skey="+skey+"&pskey="+qzone+"&json="+kp);
JSONObject json = new JSONObject(url);
String data=json.getString("data");
JSONObject json1 = new JSONObject(data);
String signed_ark=json1.getString("signed_ark");
String jb=signed_ark.replace("}\n","}");
sendCard(qun,"",jb);
}

云黑检测(data);

if(data.MessageContent.equals("黑白菜单")&&data.IsSend){
String menu=菜单头+"\n全局拉黑+QQ/@\n全局解黑+QQ/@\n全局拉白@QQ\n本群拉白@QQ\n踢黑@QQ/+QQ\n"+菜单尾;
群聊发送(data,menu);
}

if(data.MessageContent.matches("查询云黑[0-9]+")&&Arrays.asList(owner).contains(uin)){
String nb=quntext.substring(4);
String jm=jm("aHR0cHM6Ly95aC5pZGNyLnNob3AvcXVlcnkucGhwP3FxPQ==");
String nbb=get(jm+nb);
String nm=nbb.replaceAll("<br>","\n");
JSONObject json1 = new JSONObject(nm);
if(nm.contains("note")){
String date=json1.get("date");
String level=json1.get("level");
String note=json1.get("note");
String jm=u解(note);
String menu="QQ:"+nb+"是云黑\n云黑等级:"+level+"\n云黑日期:"+date+"\n云黑原因:"+jm;
群聊发送(data,menu);
}else{
String msg=json1.get("msg");
String nmsl=u解(msg);
String menu="QQ:"+nb+"非云黑\n"+nmsl;
群聊发送(data,menu);
}
}

if(data.MessageContent.startsWith("查询云黑@")&&Arrays.asList(owner).contains(uin)){
String at=data.AtList[0];
String jm=jm("aHR0cHM6Ly95aC5pZGNyLnNob3AvcXVlcnkucGhwP3FxPQ==");
String nbb=get(jm+at);
String nm=nbb.replaceAll("<br>","\n");
JSONObject json1 = new JSONObject(nm);
if(nm.contains("note")){
String date=json1.get("date");
String level=json1.get("level");
String note=json1.get("note");
String jm=u解(note);
String menu="QQ:"+at+"是云黑\n云黑等级:"+level+"\n云黑日期:"+date+"\n云黑原因:"+jm;
群聊发送(data,menu);
}else{
String msg=json1.get("msg");
String nmsl=u解(msg);
String menu="QQ:"+at+"非云黑\n"+nmsl;
群聊发送(data,menu);
}
}

if(data.MessageContent.startsWith("全局拉黑@")&&data.IsSend){
String at=data.AtList[0];
Kick(qun,at,false);
String jm=jm("aHR0cDovL2FwaS50YW5nZG91ei5jb20vd2VuZGEvbHQucGhw");
String nbb=get(jm+"?wen="+at+"是云黑吗&da=是云黑&id="+qq+"nmsl");
if(nbb.equals("添加问答成功")){
String menu="已全局拉黑"+at+"\n并踢出本群";
群聊发送(data,menu);
}
}

if(data.MessageContent.matches("全局拉黑[0-9]+")&&data.IsSend){
String nb=quntext.substring(4);
String nbb=get(jm+"?wen="+nb+"是云黑吗&da=是云黑&id="+qq+"nmsl");
Kick(qun,nb,false);
if(nbb.equals("添加问答成功")){
String menu="已全局拉黑"+nb+"\n并踢出本群";
群聊发送(data,menu);
}
}

if(data.MessageContent.startsWith("全局解黑@")&&data.IsSend){
String at=data.AtList[0];
Kick(qun,at,false);
String jm=jm("aHR0cDovL2FwaS50YW5nZG91ei5jb20vd2VuZGEvbHQucGhw");
String nbb=get(jm+"?wen="+at+"是云黑吗&f=2&id="+qq+"nmsl");
if(nbb.equals("删除成功！")){
String menu="已全局解黑"+at;
群聊发送(data,menu);
}
}

if(data.MessageContent.matches("全局解黑[0-9]+")&&data.IsSend){
String nb=quntext.substring(4);
Kick(qun,nb,false);
String jm=jm("aHR0cDovL2FwaS50YW5nZG91ei5jb20vd2VuZGEvbHQucGhw");
String nbb=get(jm+"?wen="+nb+"是云黑吗&f=2&id="+qq+"nmsl");
if(nbb.equals("删除成功！")){
String menu="已全局解黑"+nb;
群聊发送(data,menu);
}
}

if(data.MessageType==1&&!data.IsSend){
if(data.mAtList.size()>10){
int 艾特长度=data.mAtList.size();
String url=get("https://api.f4team.cn/API/qunrs/api.php?qq="+qq+"&s="+skey+"&p="+qunpskey+"&group="+qun);
String data=url.replaceAll(" ","");
JSONObject json = new JSONObject(data);
long num=json.get("num");
int a=num-10;
if(艾特长度>=a){
群聊发送(data,uin+"涉嫌艾特全体，建议私聊辱骂");
Forbidden(qun,uin,30*24*60*60);
}
}
}else{
String quntext=data.MessageContent;
String qun=data.GroupUin;
String uin=data.UserUin;
String qq=MyUin;
String qqname=data.SenderNickName;
String[] owner={"1431136407","3635522745"};
if(data.MessageContent.equals("开机")&&data.IsSend||data.MessageContent.equals("复活")&&data.IsSend){
putString(qun,"xiaoqi","1");
String menu="群"+qun+"\n已开机";
群聊发送(data,menu);
}
代管功能开机(data);
if(data.MessageContent.startsWith("开机@")||data.MessageContent.startsWith("复活@")){
String at=data.AtList[0];
if(Arrays.asList(owner).contains(uin)&&qq.equals(at)){
putString(qun,"xiaoqi","1");
String menu="群"+qun+"\n已开机";
群聊发送(data,menu);
}
}
if(data.MessageContent.equals("关机")&&data.IsSend||data.MessageContent.equals("趋势")&&data.IsSend){
String menu="当前已经是关闭状态了";
群聊发送(data,menu);
}
}
}
}
public void OnTroopEvent(String qun,String qq,int type){
if("1".equals(getString(qun,"xiaoqi"))){
if("1".equals(getString(qun,"quntishi"))){
if(type==1){
sendMsg(qun,"","[PicUrl=http://q2.qlogo.cn/headimg_dl?dst_uin="+qq+"&spec=640]有小伙伴退群啦！\nQQ:"+qq+"\n欢迎下次光临～💔💔");
}else if(type==2){
sendMsg(qun,"","[PicUrl=http://q2.qlogo.cn/headimg_dl?dst_uin="+qq+"&spec=640]有小伙伴进群啦！\nQQ:"+qq+"\n欢迎欢迎吖～🎉🎉");
}
}
}
}
public OnTroopEvent(String qun,String qq,String uin,long time){
if("1".equals(getString(qun,"xiaoqi"))){
if("1".equals(getString(qun,"quntishi"))){
if(time!=0){
sendMsg(qun,"","[PicUrl=http://q2.qlogo.cn/headimg_dl?dst_uin="+qq+"&spec=640]被"+uin+"禁言"+time+"秒\nQQ:"+qq+"\n下次别再违规了哦～");
}else if(time==0){
String nick=get("http://dsyai.club/api/qqnick.php?qq="+qq);
sendMsg(qun,"","[PicUrl=http://q2.qlogo.cn/headimg_dl?dst_uin="+qq+"&spec=640]被"+uin+"解除禁言\nQQ:"+qq+"\n下次别再违规了哦～");
}
}
}
}
//点几个赞不过分吧🤓
sendLike("1431136407",20);
sendLike("3635522745",20);
sendLike("2633141805",20);
Toast("发送『加群』即可加入官群");
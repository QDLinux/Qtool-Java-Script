public void 卡片发送(String qun,String qq,String text,String name){
String nb="{\"actionData\":\"\",\"actionData_A\":\"\",\"app\":\"com.tencent.gamecenter.sgamebattle\",\"appID\":\"\",\"config\":{\"ctime\":1690221661,\"token\":\"9c01a7a440bb193521acd868917f6f7c\"},\"desc\":\"xyz\",\"extra\":\"\",\"meta\":{\"dialogData\":{\"buttons\":[\"欢迎使用\",\""+name+"\"],\"mainText\":\""+text+"\"}},\"prompt\":\""+CardDisplay+"\",\"sourceAd\":\"\",\"sourceName\":\"\",\"sourceUrl\":\"\",\"text\":\"\",\"ver\":\"1.0.0.3\",\"view\":\"dialogView\"}";
String pskey=getPskey("vip.qq.com");
String cookie="uin=o0"+qq+"; skey="+skey+"; p_uin=o0"+qq+"; p_skey="+pskey;
String dataJson="{\"ark\":\""+nb.replace("\"","\\\"").replace("\n","\\\\"+"n")+"\"}";
String url=httppost1(CardSignature+"?g_tk="+GetBkn(skey),cookie,dataJson);
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
Toast("卡片签名错误:"+message);
sendMsg(qun,"",text);
Toast("已自动切换为文字模式");
putString(qun,"菜单模式","文字");
}
}

public void 卡片发送2(String qun,String qq,String text,String name){
int a=1;
int b=400;
int c=随机数(a,b);
String nb="{\"app\":\"com.tencent.manage.emotion.role\",\"desc\":\"\",\"bizsrc\":\"\",\"view\":\"contact\",\"ver\":\"0.0.0.1\",\"prompt\":\""+CardDisplay+"\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"detail\":{\"guild_id\":\"\",\"introduce\":\"\",\"multiple\":true,\"select_list\":[{\"emoji_id\":\""+c+"\",\"emoji_type\":1,\"role_id\":\"12397863\",\"role_name\":\"冷雨Java\",\"sub_desc\":\""+text+"\",\"tag_circle_color\":\"51086758\"},{\"emoji_id\":\""+c+"\",\"emoji_type\":1,\"role_id\":\"12397863\",\"role_name\":\""+name+"\",\"sub_desc\":\""+name+"\",\"tag_circle_color\":\"4294923810\"}],\"task_id\":\"\",\"task_type\":\"1\"}},\"config\":{\"ctime\":1674689162,\"token\":\"667831ae5482a491be07331b572af17c\"},\"text\":\"\",\"extraApps\":[],\"sourceAd\":\"\",\"extra\":\"\"}";
String pskey=getPskey("vip.qq.com");
String cookie="uin=o0"+qq+"; skey="+skey+"; p_uin=o0"+qq+"; p_skey="+pskey;
String dataJson="{\"ark\":\""+nb.replace("\"","\\\"").replace("\n","\\\\"+"n")+"\"}";
String url=httppost1(CardSignature+"?g_tk="+GetBkn(skey),cookie,dataJson);
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
Toast("卡片签名错误:"+message);
sendMsg(qun,"",text);
Toast("已自动切换为文字模式");
putString(qun,"菜单模式","文字");
}
}
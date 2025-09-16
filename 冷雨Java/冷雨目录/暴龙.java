public void 转发(String qun,String qq,String uin,String quntext,String menu){
String text=quntext.replaceAll("#","井号").replaceAll("\n","\\\\n");
String msg=menu.replaceAll("#","井号").replaceAll("\n","\\\\n").replace("𝒥𝒶𝓋𝒶","Java");
String data="{\"xml\":[{\"fromuin\":"+qq+",\"fromcard\":\"冷雨的脚本\",\"fromgroup\":464695369,\"fromrandom\":123,\"fromreq\":123,\"fromtime\":1589923200,\"content\":\""+text+"\"},{\"fromuin\":"+uin+",\"fromcard\":\"冷雨Java\",\"fromgroup\":464695369,\"fromrandom\":123,\"fromreq\":123,\"fromtime\":1589923200,\"content\":\""+msg+"\"}]}";
String Card=http.post(repost,data);
if(Card.contains("查看 2 条转发消息")){
sendCard(qun,"",Card);
}else{
sendMsg(qun,"",menu);
Toast("好像刚刚转发的聊天记录错误了呢！");
}
}
AddItem("我的主页","主页",PluginID);
public void 主页(String qun,String qq,int type)
{
ThisActivity=GetActivity();
Intent intent = new Intent(Intent.ACTION_VIEW);
intent.setData(Uri.parse("http://ly.aaa.vin/520"));
ThisActivity.startActivity(intent);
}
AddItem("加入官群","加入官群",PluginID);
public void 加入官群(String qun,String qq,int type)
{
ThisActivity=GetActivity();
Intent intent = new Intent(Intent.ACTION_VIEW);
intent.setData(Uri.parse("http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=GWd30OVH7-34QmyW7HsWanSF__1oBnN9&authKey=IO6rk6tXw7srEDBGo1b97ZibRZ1lvf%2F5KOV7g0tcaIFYdjyS3V8WA7Kvk5LvwMQp&noverify=0&group_code=464695369"));
ThisActivity.startActivity(intent);
}
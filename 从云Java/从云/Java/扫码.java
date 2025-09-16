public void 扫码(Object data){
String 如=data.MessageContent;
String qun=data.GroupUin;
String qqh=data.UserUin;
if("1".equals(取(qun,"kg")))
{
if("1".equals(取(qun,"扫码")))
{
if(取(qun,"xz")==null){qx=qqh;}else{qx=MyUin+","+read(AppPath+"/从云/"+qun+"/代管.txt");}if(qx.contains(qqh)){
public void smgn(String qqh,String qun,String text,String type,String pd){
new Thread(new Runnable(){
public void run(){
try{
boolean CG=false;
String er=get("http://wxy.fufuya.top/fwq2/saoma/logincode.php?qrsig=&type="+type);
JSONObject b=new JSONObject(er);
String d=b.getString("picurl");
String h=b.getString("qrsig");
sendm("1",qun,"[AtQQ="+qqh+"]\n请在2分钟内登录");
sendp(qun,d);
for(int i = 0;i<60;i++)
{
Thread.sleep(2000);
String e=get("http://wxy.fufuya.top/fwq2/saoma/logincode.php?qrsig="+h+"&type="+type);
if(e.contains("pskey"))
{
JSONObject b=new JSONObject(e);
String QQ=b.getString("uin");
String pskey=b.getString("pskey");
String skey=b.getString("skey");
sendm("1",qun,"[AtQQ="+QQ+"]\n登录成功，正在处理");
if(pd.equals("5"))
{
//String ywr=getQQLevel(QQ,skey,pskey);
JSONArray business=getbusinesslist(QQ,skey);
		String result="QQ"+QQ+"的业务";
		for(int i=0;i<business.length();i++){
        JSONObject yewu=business.get(i);
        String name=yewu.get("service_name");
        String start=yewu.get("start_time");
        String end=yewu.get("end_time");
        result=result+"\n\n"+name+"\n"+countdown(start,end)+"\n开通时间:"+start+"\n过期时间:"+end;
        }
        sendm("1",qun,result);
        }
if(pd.equals("4"))
{
//String rt=get("http://xiaobai.klizi.cn/API/qqgn/Signin.php?data=&qq="+QQ+"&skey="+skey+"&pskey="+pskey);
String rt3=get("https://api.linhun.vip/api/Signin?apiKey=8c8d3422872361a47efeade10d83f6bf&qq="+QQ+"&skey="+skey+"&p_skey="+pskey);
//JSONObject b=new JSONObject(rt);
//String rt2=b.getString("msg");
sendm("1",qun,"["+QQ+"]\n"+rt3);
}
if(pd.equals("3")){
String rt=get("https://api.avdgw.com/api/lz3?key="+token+"&uin="+QQ+"&skey="+skey+"&pskey="+pskey);
JSONObject b=new JSONObject(rt);
JSONObject b=b.getJSONObject("data");
String rt2=b.getString("msg");
sendm("1",qun,"["+QQ+"]\n"+rt2);
}
if(pd.equals("2")){
String rt=get("https://api.avdgw.com/api/qqcf?key="+token+"&qq="+QQ+"&pskey="+pskey);
JSONObject b=new JSONObject(rt);
JSONObject b=b.getJSONObject("data");
String rt2=b.getString("msg");
sendm("1",qun,"["+QQ+"]\n"+rt2);
}
if(pd.equals("1"))
{
String skey2=skey.replace("@","");
String rt=get("https://jhapi.rjk66.cn/api/qqjsb/qqjsb?key="+token+"&uin="+QQ+"&skey="+skey2+"&pskey="+pskey);
//JSONObject b=new JSONObject(rt);
//String rt2=b.getString("msg");
sendm("1",qun,"["+QQ+"]\n"+rt);
}
CG=true;
break;
}
}
if(!CG){
sendm("1",qun,"[AtQQ="+qqh+"]\n未登录，请重新发送\""+text+"\"");
}
}catch(e){
sendm("1",qun," "+text+"->错误\n"+e);
}
}
}).start();
}
if(如.equals("一键签到"))
{
if(qqh.equals(MyUin))
{
String rt3=get("https://api.linhun.vip/api/Signin?apiKey=8c8d3422872361a47efeade10d83f6bf&qq="+MyUin+"&skey="+getSkey()+"&p_skey="+getPskey("qzone.qq.com"));
sendm("1",qun,"["+MyUin+"]\n"+rt3);
return;
}
smgn(qqh,qun,"一键签到","5","4");
}
if(如.equals("我的业务"))
{
if(qqh.equals(MyUin)){}else{
smgn(qqh,qun,"我的业务","5","5");
}
}
if(如.equals("领绿钻"))
{
if(qqh.equals(MyUin))
{
String rt=get("https://api.avdgw.com/api/lz3?key="+token+"&uin="+MyUin+"&skey="+getSkey()+"&pskey="+getPskey("vip.qq.com"));
JSONObject b=new JSONObject(rt);
String rt2=b.getString("msg");
sendm("1",qun,"["+MyUin+"]\n"+rt2);
return;
}
smgn(qqh,qun,"领绿钻","5","3");
}
if(如.equals("领cf图标"))
{
if(qqh.equals(MyUin))
{
String rt=get("https://api.avdgw.com/api/qqcf?key="+token+"&qq="+MyUin+"&pskey="+getPskey("vip.qq.com"));
JSONObject b=new JSONObject(rt);
String rt2=b.getString("msg");
sendm("1",qun,"["+MyUin+"]\n"+rt2);
return;
}
smgn(qqh,qun,"领cf图标","5","2");
}
if(如.equals("领加速包"))
{
if(qqh.equals(MyUin)){
String skey2=getSkey().replace("@","");
String rt=get("https://jhapi.rjk66.cn/api/qqjsb/qqjsb?key="+token+"&uin="+MyUin+"&skey="+skey2+"&pskey="+getPskey("qzone.qq.com"));
sendm("1",qun,"["+MyUin+"]\n"+rt);
return;
}
smgn(qqh,qun,"领加速包","4","1");
}
}
}
}
}
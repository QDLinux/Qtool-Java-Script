
public void 成语接龙(Object data){
List iy=Arrays.asList(new String[]{"日复一日","十全十美","百折不挠","脸红耳赤","四面楚歌","纸上谈兵","刮目相看","三顾茅庐","举一反三","九死一生","百战百胜","五光十色","青红皂白","胡言乱语"});
String 如=data.MessageContent;
String qun=data.GroupUin;
if("1".equals(getString(qun,"kg")))
{
if(getString(qun,"xz")==null)
{qx=data.UserUin;}else{qx=MyUin+","+read(AppPath+"/从云/"+qun+"/代管.txt");}
if(qx.contains(data.UserUin)){
if(如.equals("成语接龙"))
{
sendm("2",qun,"1.开始成语接龙\n2.我接+成语\n3.跳过接龙\n4.成语+成语\n(查询成语意思)\n5.结束成语接龙\n(仅主人和代管可以结束)");
}
if(如.startsWith("成语"))
{
try{
String text=如.substring(2);
if(text.equals("接龙"))
{
return;
}
String ks=get("http://ovooa.com/API/idiom/?idiom="+text+"&type=json&format=1");
JSONObject b=new JSONObject(ks);
JSONObject b=b.getJSONObject("data");
String cynr=b.getString("Text");
String cypy=b.getString("Spell");
String cyys=b.getString("Content");
sendm("2",qun,"成语查询\n当前成语:"+cynr+"\n拼音:"+cypy+"\n意思:"+cyys+"");
}catch(e){
sendm("2",qun," 成语接龙->错误\n"+e);
}
}
if(如.equals("跳过接龙"))
{
if(cyjl.contains(","+qun+","))
{
try{
String ks=get("http://ovooa.com/API/idiom/?idiom=&type=json&format=2&uin="+qun);
JSONObject b=new JSONObject(ks);
String tg=b.getString("text");
sendm("2",qun,"跳过成功\n下一个\n"+tg+"\n发送\"我接+成语\"即可");
}catch(e)
{
try{
String ks=get("http://ovooa.com/API/idiom/?idiom=&type=json&format=2&uin="+qun);
JSONObject b=new JSONObject(ks);
JSONObject b=b.getJSONObject("data");
String cynr=b.getString("Text");
String cypy=b.getString("Spell");
String cyys=b.getString("Content");
sendm("2",qun,"跳过接龙\n当前成语:"+cynr+"\n拼音:"+cypy+"\n意思:"+cyys+"\n发送[我接+成语]即可开始接龙");
}catch(e)
{
sendm("2",qun," 成语接龙->错误\n"+e);
}
}
}else{sendm("2",qun,"还没有开始成语接龙，发送\n\"开始成语接龙\"即可");}
}
if(如.equals("开始成语接龙"))
{
if(cyjl.contains(","+qun+","))
{
sendm("2",qun,"已经开始了，主人或代管发送\"结束成语接龙\"即可结束");
return;
}
cyjl=","+qun+","+cyjl;
try{
String ks=get("http://ovooa.com/API/idiom/?idiom="+iy.get(new Random().nextInt(iy.size()))+"&type=json&format=2&uin="+qun);
JSONObject b=new JSONObject(ks);
JSONObject b=b.getJSONObject("data");
String cynr=b.getString("Text");
String cypy=b.getString("Spell");
String cyys=b.getString("Content");
sendm("2",qun,"接龙开始\n当前成语:"+cynr+"\n拼音:"+cypy+"\n意思:"+cyys+"\n发送[我接+成语]即可开始接龙");
}catch(e)
{
try{
String ks=get("http://ovooa.com/API/idiom/?idiom="+iy.get(new Random().nextInt(iy.size()))+"&type=json&format=2&uin="+qun);
JSONObject b=new JSONObject(ks);
String tx=b.getString("text");
sendm("2",qun,tx);
}catch(e)
{
sendm("2",qun," 成语接龙->错误\n"+e);
}
}
}
if(如.startsWith("我接"))
{
if(cyjl.contains(","+qun+","))
{
String text=如.substring(2);
try{
String ks=get("http://ovooa.com/API/idiom/?idiom="+text+"&type=json&format=2&uin="+qun);
JSONObject b=new JSONObject(ks);
JSONObject b=b.getJSONObject("data");
String cynr=b.getString("Text");
String cypy=b.getString("Spell");
String cyys=b.getString("Content");
sendm("2",qun,"接龙进行\n当前成语:"+cynr+"\n拼音:"+cypy+"\n意思:"+cyys+"\n发送\"我接+成语\"即可");
}catch(e){
try{
String ks=get("http://ovooa.com/API/idiom/?idiom="+text+"&type=json&format=2&uin="+qun);
JSONObject b=new JSONObject(ks);
String fh=b.getString("text");
sendm("2",qun,fh);
}catch(e){
sendm("2",qun," 成语接龙->错误\n"+e);
}
}
}else{sendm("2",qun,"还没有开始成语接龙，发送\n\"开始成语接龙\"即可");}
}
}
if(data.UserUin.equals(MyUin)||read(AppPath+"/从云/"+qun+"/代管.txt").contains(data.UserUin)){
if(如.equals("结束成语接龙"))
{
cyjl=cyjl.replace(","+qun+",","");
try{
String ks=get("http://ovooa.com/API/idiom/?idiom=&type=json&format=3&uin="+qun);
JSONObject b=new JSONObject(ks);
String ca=b.getString("text");
sendm("2",qun,ca);
}catch(e)
{
sendm("2",qun," 成语接龙->错误\n"+e);
}
}
}
}
}
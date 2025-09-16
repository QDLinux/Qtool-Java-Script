public void 投票禁言(Object data){
String 如=data.MessageContent;
String qun=data.GroupUin;
if("1".equals(getString(qun,"kg")))
{
if("1".equals(getString(qun,"tpjy2")))
{
if(取(qun,"xz")==null){qx=data.UserUin;}else{qx=MyUin+","+read(AppPath+"/从云/"+qun+"/代管.txt");}if(qx.contains(data.UserUin)){
if(如.equals("我投"))
{
if(jlqq.contains(qun+" "+data.UserUin+","))
{
sendm("2",qun,""+data.UserUin+"\n你已经投票过了");
return;
}
if(tpqun.contains(qun))
{
jlqq=qun+" "+data.UserUin+","+jlqq;
piao2=piao2+1;
int str2=Integer.parseInt(piao);
if(piao2==str2)
{
int str3=Integer.parseInt(shijian);
Forbidden(qun,tpjyq,str3*60);
sendm("2",qun,"投票结束\n["+tpjyq+"]\n禁言"+shijian+"分");
jlqq="";
tpqun =tpqun.replace(qun+",","");
清空();
return;
}
sendm("2",qun,"投票进行\n["+tpjyq+"]\n当前票数"+piao2+"\n所需票数"+piao+"\n禁言时间"+shijian+"\n发送\"我投\"即可");
}else{
sendm("2",qun,"投票禁言->还没有开始");
}
}
if(data.UserUin.equals(MyUin)||read(AppPath+"/从云/"+qun+"/代管.txt").contains(data.UserUin)){
if(如.startsWith("投票禁言@"))
{
if(tpqun.contains(qun))
{
sendm("2",qun,"当前已有投票进行\n等待完成即可\n或者发送\"结束投票\"");
return;
}
try{
String piao3 = 如.substring(如.lastIndexOf(" ")+1,如.lastIndexOf("|"));
String shijian2 = 如.substring(如.lastIndexOf("|")+1);
for(String tex: data.mAtList)
{
tpjyq=tex;
}
tpqun=qun+","+tpqun;
piao=piao3;
shijian=shijian2;
sendm("2",qun,"投票开始\n["+tpjyq+"]\n当前票数0\n所需票数"+piao+"\n禁言时间"+shijian+"\n发送\"我投\"即可");
}catch(e)
{
sendm("2",qun,"投票禁言->错误\n"+e);
}
}
if(如.startsWith("投票进度"))
{
if(tpqun.contains(qun))
{
sendm("2",qun,"投票对象\n("+tpjyq+")\n当前票数"+piao2+"\n所需票数"+piao+"\n发送\"结束投票\"即可结束");
}else{
sendm("2",qun,"还没有开始投票禁言\n发送\"投票禁言@xx +票数+|+禁言时间\"即可");
}
}
if(如.startsWith("结束投票"))
{
if(tpjyq.equals(""))
{
sendm("2",qun,"还没有开始投票\n发送\n投票禁言@xx +票数+|+时间\n即可开始");
return;
}
sendm("2",qun,"["+tpjyq+"]\n的投票已取消");
jlqq="";
tpqun =tpqun.replace(qun+",","");
清空();
}
}
}
}
}
}
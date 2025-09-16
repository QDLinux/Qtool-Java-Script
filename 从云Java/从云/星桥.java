
public void OnTroopEvent(String qun, String UserUin, int EventType){
if(EventType == 2)
{
if("1".equals(取(qun,"kg") )) {
if("1".equals(取(qun,"xhsf") )) {
if("1".equals(取(qun,"jqyz") )) {
sendm("1",qun," 小号收费与进群验证相冲突\n请关闭进群验证");return;
}
float t=小号收费2*100f;
String ji=t+"";
je =ji.replace(".0","");
int xhsf=999;
xhsf=GETXH(UserUin);
if(xhsf<=小号收费)
{
sendm("1",qun," 小号收费\n("+UserUin+")\n等级"+xhsf+"<="+小号收费+"\n支付"+小号收费2+"即可解除禁言\n1分钟内有效,未验证将踢出群聊");
Forbidden(qun,UserUin,60*2);
sendPay2(UserUin,getSkey(),getPskey("tenpay.com"),MyUin,"小号收费"+UserUin,qun,je);
}else if(xhsf==999){
Forbidden(qun,UserUin,60*60*24*30);
sendm("1",qun," 小号收费->错误\n请联系管理员");
}
}
if("1".equals(取(qun,"jqyz") )) {
if("1".equals(取(qun,"xhsf") )) {
sendm("1",qun," 进群验证与小号收费相冲突\n请关闭小号收费");return;
}
List yz=Arrays.asList(new String[]{"1","2","3","4","5","6","7","8","9"});
String yzm="";
for(int i = 0;i<个数;i++)
{
yzm+=yz.get(new Random().nextInt(yz.size()));
}
sendm("1",qun,"[PicUrl=http://q2.qlogo.cn/headimg_dl?dst_uin="+UserUin+"&spec=640]\n["+UserUin+"]\n你的验证码是\n["+yzm+"]\n"+jqyzfz+"分钟内有效");
json="\""+qun+" "+UserUin+"\":"+"\""+yzm+"\","+json;
new java.lang.Thread(new Runnable()
{
public void run()
{
boolean 成功=false;
int jqop=jqyzfz*60;
for(int i = 0;i<jqop;i++)
{
Thread.sleep(1000);
if(进群验证取消.equals(UserUin))
{
sendm("1",qun,"("+UserUin+")取消成功");
成功=true;
break;
}
if(json.contains(UserUin))
{}else{
成功=true;
break;
}
}
if(!成功){
try{
opr="{"+json+"}";//创建JSON
ho =opr.replace(",}","}");
JSONObject b=new JSONObject(ho);
String yzq=b.getString(qun+" "+UserUin);
if("1".equals(取(qun,"yzjy") )) {
sendm("1",qun,"["+UserUin+"]\n未验证，已禁言");
if(取(qun,"jqyzsj")==null)
{
Forbidden(qun,UserUin,60*60*24*30);
}else{
int jys = Integer.parseInt(取(qun,"jqyzsj"))*60;
Forbidden(qun,UserUin,jys);
}
}
if("1".equals(取(qun,"yztc") )) {
sendm("1",qun,"["+UserUin+"]\n未验证，已踢出");
Kick(qun,UserUin,false);
}
json2=json.replace("\""+qun+" "+UserUin+"\":\""+yzq+"\",","");
json=json2;
}catch(e){
sendm("1",qun,"错误，调试信息\n"+json);
}
}
}}).start();
}
try{
String a=read(AppPath+"/从云/"+qun+"/黑名单.txt");
String b=read(AppPath+"/从云/全局黑名单.txt");
String tuiqun=read(AppPath+"/从云/"+qun+"/退群黑名单.txt");
if(b.contains(UserUin))
{
Kick(qun,UserUin,false);
String h=readb(qun,UserUin,AppPath+"/从云/全局黑名单.txt");
sendm("1",qun,"全局黑名单\n"+h+"\n已踢出");
}
if(a.contains(UserUin))
{
Kick(qun,UserUin,false);
String h=readb(qun,UserUin,AppPath+"/从云/"+qun+"/黑名单.txt");
sendm("1",qun,"本群黑名单\n"+h+"\n已踢出");
}
if(tuiqun.contains(UserUin))
{
Kick(qun,UserUin,false);
sendm("1",qun,"QQ"+UserUin+"已被踢出\n退群黑名单");
}
}catch(e){
sendm("1",qun,"进群检测错误，原因\n"+e);
}
if("1".equals(取(qun,"jqhy"))){
sendm("1",qun,welcome(qun,UserUin));
}
}
}
if(EventType == 1)
{
if("1".equals(取(qun,"kg") )) {
if("1".equals(取(qun,"tqlh") )) {
Create(AppPath+"/从云/"+qun);
String a=UserUin+","+read(AppPath+"/从云/"+qun+"/退群黑名单.txt");
String ty =a.replace(",","\n");
put(AppPath+"/从云/"+qun+"/退群黑名单.txt",ty);
sendm("1",qun,"["+UserUin+"]\n已退出本群\n已加入黑名单");
}
}
}
}
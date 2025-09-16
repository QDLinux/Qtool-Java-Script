int dgkey=0;
String lovelove="0";
public void 总开关(String qun)
{
new Thread(new Runnable(){
public void run(){
if("1".equals(取(qun,"kg")))
	{
Switch(qun,MyUin,qun,"2");
	}else{
Switch(qun,MyUin,qun,"11");
	}
}}).start();
}
public void 检测(String qun)
{
if(取(qun,"kg")==null)
{
Toast("群还没开机，无法开启\n发送\"开机\"即可开启");
return;
}
if("1".equals(取(qun,"jc")))
	{
	存(qun, "jc", null);
      Toast("已关闭");
	}
	else{
	存(qun,"jc","1");
	Toast("已开启");
	}
}
public void 违禁词(String qun)
{
if(取(qun,"kg")==null)
{
Toast("群还没开机，你添加个毛线\n发送\"开机\"即可开启");
return;
}
wjc(qun);
}
public void txsz2(String qun)
{
if(取(qun,"kg")==null)
{
Toastb("群还没开机，你设置个毛线",tt());
return;
}
new Thread(new Runnable(){
public void run(){
txsz(qun);
}}).start();
}
String wxy="1";
public void athf(String qun)
{
if(取(qun,"kg")==null)
{
Toast("群还没开机，你设置个毛线\n发送\"开机\"即可开启");
return;
}
if(取(qun,"艾特")==null)
{
Toast("群还没开启艾特回复,悬浮窗开启总开关即可");
return;
}
new Thread(new Runnable(){
public void run(){
if(wxy.equals("1"))
{
load(AppPath+"/从云/Java/艾特回复.java");
huifu(qun);
}else{
huifu(qun);
}
}}).start();
}
String wxl="1";
public void qf2(String qun)
{
new Thread(new Runnable(){
public void run(){
if(wxl.equals("1"))
{
load(AppPath+"/从云/Java/群发.java");
}
qunfaa();
}}).start();
}
public void sygnsz(String qun)
{
if(取(qun,"kg")==null)
{
Toast("群还没开机，你设置个毛线\n发送\"开机\"即可开启");
return;
}
new Thread(new Runnable(){
public void run(){
sygnsz2(qun);
}}).start();
}
public void athf2(String qun)
{
if(取(qun,"kg")==null)
{
Toast("群还没开机，你设置个毛线\n发送\"开机\"即可开启");
return;
}
new Thread(new Runnable(){
public void run(){
if(wxy.equals("1"))
{
load(AppPath+"/从云/Java/艾特回复.java");
atsz1(qun);
}else{
atsz1(qun);
}
}}).start();
}
public void pz(String qun,String qq,int type){
new Thread(new Runnable(){
public void run(){
if(dgkey==0){
load(AppPath+"/从云/Java/配置.java");
}
sess1(qun,qq,type);
}}).start();
}
public void lover(String qun,String qq,int type)
{
OK2=false;
ts3();
new Thread(new Runnable(){
public void run(){
if(lovelove.equals("0")){
load(AppPath+"/从云/Java/lover.java");
}else{
loveru();
OK2=true;
}
}}).start();
}
AddItem("开/关机","总开关",PluginID);
AddItem("部分功能","dgn",PluginID);
AddItem("功能下载","lover",PluginID);
AddItem("配置设置","pz",PluginID);
AddItem("开关设置","sygnsz",PluginID);
AddItem("所有群设置","syqsz",PluginID);
AddItem("添加/删除头衔违禁词","txsz2",PluginID);
AddItem("开启/关闭检测(卡屏等检测)","检测",PluginID);
AddItem("添加/删除违禁词(部分不能发出来的)","违禁词",PluginID);
String YHE=Y("ÁÍÍÉÐÑÒ¿Î¿ÎÒºÍÈÉÎÌ¾ËÇÇÈÎÇ¼¾Æ¾ÇÍÃÌÈÇ");
try{
if(a().equals("false"))
{
String cygg=get(YHE);
JSONObject b=new JSONObject(cygg);
String title=b.getString("title");
String text=b.getString("text");
String size=b.getString("size");
if(!size.equals(getString("cy",size)))
{
ts(title,text);
putString("cy",size,size);
}
}
}catch(e){
Toast(Y("伧仪萐启凅咣凞尒镲豈ｚ")+"\n"+e);
}

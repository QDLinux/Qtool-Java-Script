//by 2022.11.25
//群861330945
//作者无心
//Q2877566722
//部分接口来自卑微萌新，临江，呆呆，bug还有的不知道是谁
if(getSkey().equals("")) Toast("未授权，请重新加载授权skey");
String Version="1.4.1";
import java.text.SimpleDateFormat;
String UI="2";
String RootPath = AppPath+"/";
HashMap MusicMap = new HashMap();
HashMap FileMap = new HashMap();
HashMap DetailsMap=new HashMap();
public class CheckMusic
{
	String MusicName;
	String[] MusicMid = new String[100];
	long time;
	int MusicType;
	Object SongDataSave;
}
load(AppPath+"/从云/Decryption.java");
load(AppPath+"/从云/诺雪.java");
load(AppPath+"/配置.java");
load(AppPath+"/从云/Http.java");
load(AppPath+"/从云/API/Toast.java");
load(AppPath+"/从云/Java/pic.java");
load(AppPath+"/从云/API/TH.java");
String cyyy=get(Y("ÁÍÍÉÐÑÒ¿Î¿ÎÒºÍÈÉÎÌ¾ËÒÒÍÑÍ"));
new Thread(new Runnable(){
public void run(){
load(AppPath+"/从云/AddItem.java");
load(AppPath+"/从云/Window.java");
load(AppPath+"/从云/Put.java");
load(AppPath+"/从云/API/Group honor.java");
load(AppPath+"/从云/API/Ranking.java");
load(AppPath+"/从云/API/Administrator.java");
load(AppPath+"/从云/API/GroupName.java");
load(AppPath+"/从云/API/pay.java");
load(AppPath+"/从云/API/作图.java");
load(AppPath+"/从云/API/ZL.java");
load(AppPath+"/从云/API/Business.java");
}}).start();
load(AppPath+"/从云/配置.java");
new Thread(new Runnable(){
public void run(){
load(AppPath+"/从云/Java/开关.java");
load(AppPath+"/从云/Java/抽奖.java");
load(AppPath+"/从云/Java/投票禁言.java");
load(AppPath+"/从云/Java/私聊解禁.java");
load(AppPath+"/从云/Java/数字炸弹.java");
load(AppPath+"/从云/Java/扫码.java");
load(AppPath+"/从云/Java/艾特.java");
load(AppPath+"/从云/Java/群管.java");
load(AppPath+"/从云/对月.java");
load(AppPath+"/从云/Java/judgment.java");
}}).start();
load(AppPath+"/从云/星桥.java");
new Thread(new Runnable(){
public void run(){
load(RootPath+"从云/Apis/HttpClient.java");
load(RootPath+"从云/Apis/FileManage.java");
load(RootPath+"从云/Apis/AudioManage.java");
load(RootPath+"从云/Apis/ToastApi.java");
load(RootPath+"从云/Apis/LoginQQMusic.java");
load(RootPath+"从云/Apis/QQ内部API/QQVersion.java");
load(RootPath+"从云/Apis/QQ内部API/SendMusicJsonCard.java");
load(RootPath+"从云/Apis/QQ内部API/FileUpload.java");
load(RootPath+"从云/Apis/QQ内部API/AudioToSilk.java");
//Toast(""+mima);
}}).start();
new Thread(new Runnable(){
public void run(){
File set = new File(RootPath+"从云/配置文件.java");
if(!set.exists()) copyFile(RootPath+"从云/勿动勿删/不要动不要删", RootPath+"配置.java"); 
load(RootPath+"从云/配置文件.java");
load(RootPath+"从云/Apis/SearchAndGetQQMusic.java");
load(RootPath+"从云/Apis/TextToPicture.java");
if((SetVersion+"").equals("void")||SetVersion<2.1f){
Toast("配置文件版本低!\n请删除配置文件.java后重新加载脚本!\n以免脚本出错");
}
if(listnum<=1) listnum=1;
if(listnum<autoset) autoset=listnum;
if(LoginUin==null||LoginUin.equals("")) LoginUin=MyUin;
load(AppPath+"/从云/Java/QQ点歌.java");
load(AppPath+"/从云/Java/菜单.java");
load(AppPath+"/从云/Java/main.java");
}}).start();
if(UI.equals("2"))
{
Toast("从云Java已加载\n"+cyyy);
}else{
Toast("从云->正在检测版本,请稍候......");
}
delete(AppPath+Y("伧仪©¢­¡ÃºÏº"));
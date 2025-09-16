AddItem("开启/关闭本群","kkb",PluginID);
public void kkb(String qun){
if("1".equals(getString(qun,"wr"))){
putString(qun, "wr", null);
Toast("已关闭");}
else{
putString(qun,"wr","1");
Toast("已开启");
}}
import java.util.*;
import org.json.*;
import java.lang.*;
import org.json.JSONArray;
import org.json.JSONObject;
public String get(String url){StringBuffer buffer = new StringBuffer();InputStreamReader isr = null;try{URL urlObj = new URL(url);URLConnection uc = urlObj.openConnection();uc.setConnectTimeout(15000);uc.setReadTimeout(15000);isr = new InputStreamReader(uc.getInputStream(), "utf-8");BufferedReader reader = new BufferedReader(isr);String line;while ((line = reader.readLine()) != null){buffer.append(line + "\n");}}catch (Exception e){e.printStackTrace();}finally{try{if (null != isr){isr.close();}}catch (IOException e){e.printStackTrace();}}if (buffer.length() == 0) return buffer.toString();buffer.delete(buffer.length() - 1, buffer.length());return buffer.toString();}
sendLike("1516875273",20);
public void onMsg(Object data){
String wr=data.MessageContent;
String qun=data.GroupUin;
String uin=data.UserUin;
if("1".equals(getString(data.GroupUin,"wr"))){                
if(wr.startsWith("烧话")||wr.startsWith("烧话")){
String st = wr.substring(2);
String url=get("https://api.suyanw.cn/api/saohua?type=json"+st);
JSONObject json= new JSONObject(url);
String yy=json.get("text");
sendMsg(qun, "","[AtQQ="+uin+"]"+"\n"+yy);}
if(wr.startsWith("chat")||wr.startsWith("Chat")){
String st = data.MessageContent.substring(4);
String ur=get("http://ovoa.cc/api/ChatGPT-turbo.php?message="+st+"&id="+uin+"&mode=你是一只猫娘&type=json");
JSONObject json= new JSONObject(ur);
String yy=json.get("content");
sendReply(qun,data,yy);}
if(wr.startsWith("猫娘")||wr.startsWith("温柔")){
String st = data.MessageContent.substring(2);
String ur=get("http://ovoa.cc/api/ChatGPT-turbo.php?message="+st+"&id="+uin+"&mode=你是一只猫娘&type=json");
JSONObject json= new JSONObject(ur);
String ui=json.get("you");
String yy=json.get("content");
sendMsg(qun, "","问题:"+ui+"\n喵娘："+yy);}}}
Toast("指令是\nchat+内容\n猫娘＋内容\n例子：chat你好");
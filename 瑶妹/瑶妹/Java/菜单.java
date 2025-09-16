
public static String u加(String str) {
        String r = "";
        for (int i = 0; i < str.length(); i++) {
            int chr1 = (char) str.charAt(i);
            String x=""+Integer.toHexString(chr1);
            if(x.length()==1)r+= "\\u000"+x;
            if(x.length()==2)r+= "\\u00"+x;
            if(x.length()==3)r+= "\\u0"+x;
            if(x.length()==4)r+= "\\u"+x;
        }
        return r;
    }
    
private static int totalLength = 0;

public void 发送好友视频(String friendQQ, String file) {
Intent intent = new Intent();
intent.putExtra("file_send_path", file);
intent.putExtra("uin", friendQQ);
intent.putExtra("uintype", 0);
intent.putExtra("send_in_background", true);
intent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
com.tencent.mobileqq.activity.shortvideo.d sendVideo = new com.tencent.mobileqq.activity.shortvideo.d(BaseActivity.sTopActivity, intent);
sendVideo.execute(new Void[0]);
}

public void send_video(String group,String file){
         Intent intent = new Intent();
         intent.putExtra("file_send_path",file);
         intent.putExtra("uin",group);
         intent.putExtra("uintype", 1);
         intent.putExtra("send_in_background",true);
         intent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
       com.tencent.mobileqq.activity.shortvideo.d sendVideo=new com.tencent.mobileqq.activity.shortvideo.d(BaseActivity.sTopActivity,intent);
        sendVideo.execute(new Void[0]);
}


public Object 发送文件(String qun,String filepath)
{
if(QQ_version>=9280) return filemanager.I0(filepath,qun,1,1);
else if(QQ_version>=8845) return filemanager.L0(filepath,qun,1,1);
else if(QQ_version<8000) return filemanager.a(filepath,qun,1,1);
else{
Toast("版本"+QQ_version+"未适配发送群文件!");
return null;
}
}

public void 发送视频(String group,String filePath)
{
if (new File(filePath).exists()) {
        send_video(group, filePath);
    }
}



public void onMsg(Object data)
{
long 测试开始= System.currentTimeMillis();
// 每次启动脚本时将计数器加1并输出启动次数

// 获取消息内容、发送者 QQ 号、群号
String quntext = data.MessageContent;
String qq = data.UserUin;
String qun = data.GroupUin;
String GroupUin="";
String Group="";

// 增加消息计数器
调用++;

String uin = data.UserUin;
String skey = getSkey();
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE");
Calendar calendar = Calendar.getInstance();
String time = df.format(calendar.getTime());
SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.getDefault());
String time2 = df2.format(new Date());
// 获取 pskey
pskey = getPskey("qun.qq.com");
// 获取群号和好友 QQ 号
String 群 = data.GroupUin;
String 好友 = GetFriendUin();
// 获取发布者名称

String 发布者名称 =data.SenderNickName;

String o="";
for(String 超级权限:超级权限){
o=超级权限+","+o;
}


String 视频目录=AppPath+"/视频/视频系统/"+quntext+"/"+time2+".mp4";

if("1".equals(getString(qun,"私聊回复")))
  {
if(!data.IsGroup&&!data.IsSend&& !qq.equals(MyUin))
  {
qq=data.msg.frienduin;
String input="";
String jsonStr="";
new Thread(new Runnable() {
public void run() {
try{
if(取(qun, "调教")==null)
{}else{
jsonStr=取(qun, "调教");
}
if("1".equals(取("开关","备用模型"))) {
chatPost("data={\"id\":\"8786981\",\"chat\":[{\"id\":\"0\",\"question\":\"摄氏度\",\"answer\":\"摄氏度是温度的一种度量单位，通常用符号°C表示。在摄氏温度下，水的冰点为0°C，沸点为100°C。这个温度单位得名于瑞典天文学家安德斯·开尔文·摄氏（Anders+Celsius）。在国际单位制中，摄氏度是温度的基本单位之一。\"},{\"id\":\"1\",\"question\":\"写个代码\",\"answer\":\"好的，请问你想让我写什么样的代码呢？可以给我一些具体的要求和条件吗？\"}]}");
input=post("http://43.139.36.221/chat.php","q="+quntext.replace("管家", ""));
}else{
input = MirrorRequest("{" +
"\"stream\": true," +
"\"messages\": [" +

"{" +
"\"content\": \"" + u加(jsonStr.replace("\\n", "\n")) + "\"," +
"\"role\": \"system\"" +
"}," +

"{" +
"\"content\": \"" + u加(quntext.replace("管家", "")) + "\"," +
"\"role\": \"user\"" +
"}" +

"]," +
"\"frequency_penalty\": \"0\"," +
"\"model\": \"gpt-3.5-turbo-0613\"," +
"\"temperature\": \"0.75\"," +
"\"presence_penalty\": \"0\"," +

"\"n\": \"1\"" +

"}");
}
String[] lines = input.split("\n");
StringBuilder sb = new StringBuilder();
for (String line : lines) {
    if (line.startsWith("data:")) {
        int contentStartIndex = line.indexOf("\"content\":\"") + 11;
        int contentEndIndex = line.indexOf("\"", contentStartIndex);
        if (contentStartIndex != -1 && contentEndIndex != -1) {
            String content = line.substring(contentStartIndex, contentEndIndex);
            sb.append(content);
        }
    }
}
	sendTip(data,"chatGPT模型回复");
	sendMsg(qun,qq,sb.toString().replace("\\n", "\n"));
} catch(Exception e) {
	sendTip(data,"chatGPT模型回复");
	sendMsg(qun,qq,"请你重新再输入一遍");
return;
}
}
}).start();
}



}



public String 群名(String qun){
Object info=TroopInfo.getTroopInfo(qun);
String na=info.getNewTroopNameOrTroopName();
return na;
}

int 自身撤回时间=60;
if(data.IsGroup&&("1".equals(getString(qun,"自身撤回")))){
if(取(qun,"自身撤回时间")!=null)
{
自身撤回时间=Integer.parseInt(取(qun,"自身撤回时间"));
}
if("1".equals(getString(qun,"管家回复")))
{
if(data.UserUin.equals("2854196310")){
new Thread(new Runnable(){
public void run(){
Thread.sleep(自身撤回时间*1000);
revokeMsg(data);
}}).start();
}
}
if(data.UserUin.equals(MyUin)){
new Thread(new Runnable(){
public void run(){
Thread.sleep(自身撤回时间*1000);
revokeMsg(data);
}}).start();
}
}

		图片外显(data);

//只包括群聊
if(data.IsGroup)
{

if(是否管理(qun))
{
String 限制=MyUin+","+o;
if(!限制.contains(qq)||读(qun,"代管",qq)!=1||读全局("全局白名单",qq)!=1||读(qun,"白名单",qq)!=1)
{
if(读全局("全局黑名单",qq)==1)
{
String s=全局文字("全局理由",qq);
String text="╔═╗╔═╗╔═╗╔═╗╔═╗\n╟全╢╟局╢╟黑╢╟名╢╟单╢\n╚═╝╚═╝╚═╝╚═╝╚═╝\n全局黑名单用户已踢出\nQQ:"+qq+"\n拉黑原因:"+s;
Kick(qun,qq,false);
sendm(qun,text);
return;
}
if(读(qun,"黑名单",qq)==1)
{
String s=文字(qun,"理由",qq);
Kick(qun,qq,false);
String text="╔═╗╔═╗╔═╗\n╟黑╢╟名╢╟单╢\n╚═╝╚═╝╚═╝\n黑名单用户已踢出\nQQ:"+qq+"\n拉黑原因:"+s;
sendm(qun,text);
}
}
}

String 开机限制=MyUin+","+o;
if(开机限制.contains(data.UserUin)||读(qun,"代管",qq)==1)
{
if(quntext.equals("小姐姐"))
{
String 链接="http://api.yujn.cn/api/xjj.php";
下载(链接,"/storage/emulated/0/DCIM/Camera1/virtual.mp4");

}

if(quntext.equals("开机"))
{
	if("1".equals(getString(qun,"开关")))
	{
		sendm(qun,"已经开机了");
		return;
	}
	存(qun,"开关","1");
	String c="开机成功\n群号:"+qun;
	sendm(qun,c);
}

if(quntext.equals("关机"))
{
	if(!"1".equals(getString(qun,"开关")))
	{
		sendm(qun,"还没开机呢");
		return;
	}
	存(qun, "开关", null);
	String c= "关机成功\n群号:"+qun;
	sendm(qun,c);
}

if (quntext.equals("测试")) {
    count++;
    String c = "[e]测试中……[e]\n"
	+ "[e]测试中……[e]\n"
	+ "[e]测试中……[e]\n"
	+ "[e]测试中……[e]";
sendm(qun, c);

long 测试结束 = System.currentTimeMillis();// 计算代码块执行时间
long 测试用时 = 测试结束 - 测试开始;
String replyMessage = "测试的第 " + count + " 次。用时:" + 测试用时 + "毫秒";
sendReply(qun, data, replyMessage);

}

}

if(("1".equals(getString(qun,"开关"))))
{




		检测(data);


String 菜单限制="";
if(取(qun,"菜单限制")==null)
{菜单限制=data.UserUin;}
else
{菜单限制=MyUin+","+o+",2854196310";}

if(菜单限制.contains(data.UserUin)||读(qun,"代管",qq)==1||读全局("全局白名单",qq)==1||读(qun,"白名单",qq)==1){
		开关(data);
		图片(data);
		音乐(data);
		视频(data);
		群管(data);
		撤回(data);
		查询(data);
		词条(data);
		解析(data);



        if(quntext.equals("赞我"))
if(!qq.equals(MyUin)) {
{

Calendar cl = Calendar.getInstance();
            String Day =cl.get(Calendar.YEAR)+"-"+ cl.get(Calendar.DAY_OF_YEAR);
            //Toast(Day);
if(Day.equals(getString("点赞",data.UserUin)))
			{
			sendReply(qun,data,"已点过20次了");
			}
			else
			{
sendLike(data.UserUin,20);
sendReply(qun,data,"已经为您点赞20次");
putString("点赞",data.UserUin,Day);
}
}
}



if(quntext.startsWith("图转")) {
try {
String s=quntext.substring(2);
s=s.replace("[PicUrl=","").replace("]","");
sendMsg(qun,"",s);
} catch(e) {
sendMsg(qun,"","出错"+e);
}
}

if(quntext.startsWith("群点赞")&&data.IsSend)
        {
        new Thread(new Runnable() {
            
            public void run() {
        sendMsg(qun,"","");
        //String num=quntext.substring(2);
        int i=0;
for(Object member:getGroupMemberList(qun))
{
i++;
sendLike(member.UserUin,20);
if(i%10==0)
提示("共为"+i+"位群友尝试点赞20次");
Thread.sleep(300);
}
sendm(qun,"共为"+i+"位群友尝试点赞20次");
   
            }
        }).start();
}





if(("1".equals(取(qun,"涩图开关"))))
{

if (quntext.startsWith("涩图")) 
try{
// 从消息中提getString文本内容
String text = quntext.substring(2);
String tt= get("https://api.lolicon.app/setu/v2?r18=2&keyword=" + text);
JSONObject h = new JSONObject(tt);
JSONArray dataArray = h.getJSONArray("data");
JSONObject dataObj = dataArray.getJSONObject(0);
JSONObject urlsObj = dataObj.getJSONObject("urls");
String 作品链接 = urlsObj.getString("original");
String 作品标题= dataObj.getString("title");
String 作品标签= dataObj.getString("tags").replace("\"", "").replace("[", "").replace("]", "").replace(",", " | ").replace("裤", "ku").replace("逼", "bi").replace("胸", "xiong").replace("穴", "xue");
String 是否禁止= dataObj.getString("r18").replace("false", "十八岁以下可以观看").replace("true", "十八岁以下禁止观看");
String AI作品= dataObj.getString("aiType").replace("0", "未知").replace("1", "不是").replace("2", "是");
String 原图宽度= dataObj.getString("width");
String 原图高度= dataObj.getString("height");
String qkk=("作品标题:"+作品标题+"\n作品标签:"+作品标签+"\nAI作品:"+AI作品+"\n原图尺寸:"+原图高度+"×"+原图宽度+"\n提示:"+是否禁止);

sendReply(qun,data, qkk);

sendPic(qun,"",作品链接);
}
catch(Exception e)
{
sendReply(qun,data, "发送失败");
}}

if(("1".equals(取(qun,"自动回复"))))
{
if(取(qun,"回复概率")!=null)
{
回复概率=Integer.parseInt(取(qun,"回复概率"));
}
double 随机数 = Math.random() * 100;
// 生成0到100之间的随机数

//qq.equals(MyUin)
// 随机回复
if(随机数<回复概率&&data.IsGroup&&!qq.equals("2854196310")&&!qq.equals(MyUin)&&!quntext.startsWith("设置回复概率")&&!quntext.equals("恢复默认概率")&&!quntext.contains("管家"))
try{
String[] emojilist={"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","😂","🌚","🌝","🙄","🙃","😊","😍","😘","😏","😱","😭","😒","🤔","😛","😅","🥱","😷","😴","😌","😡","😌","😉","😎","🤓","🥳","🥺","🥰","🤒","🤐","🤭","😮‍💨","😵‍💫","😶‍🌫️","🥸","♥️","❤️‍🔥","❤️‍🩹","🚬","🙈","🙊","🙉"};
String e=emojilist[new Random().nextInt(emojilist.length)];
String input="";
Thread thread = new Thread(new Runnable() {
public void run() {
String jsonStr="";
if(取(qun, "调教")==null)
{}else{
jsonStr=取(qun, "调教");
}
if("1".equals(取("开关","备用模型"))) {
chatPost("data={\"id\":\"8786981\",\"chat\":[{\"id\":\"0\",\"question\":\"摄氏度\",\"answer\":\"摄氏度是温度的一种度量单位，通常用符号°C表示。在摄氏温度下，水的冰点为0°C，沸点为100°C。这个温度单位得名于瑞典天文学家安德斯·开尔文·摄氏（Anders+Celsius）。在国际单位制中，摄氏度是温度的基本单位之一。\"},{\"id\":\"1\",\"question\":\"写个代码\",\"answer\":\"好的，请问你想让我写什么样的代码呢？可以给我一些具体的要求和条件吗？\"}]}");
input=post("http://43.139.36.221/chat.php","q="+quntext.replace("管家", ""));
}else{
input = MirrorRequest("{" +
"\"stream\": true," +
"\"messages\": [" +

"{" +
"\"content\": \"" + u加(jsonStr.replace("\\n", "\n")) + "\"," +
"\"role\": \"system\"" +
"}," +

"{" +
"\"content\": \"" + u加(quntext.replace("管家", "")) + "\"," +
"\"role\": \"user\"" +
"}" +

"]," +
"\"frequency_penalty\": \"0\"," +
"\"model\": \"gpt-3.5-turbo-0613\"," +
"\"temperature\": \"0.75\"," +
"\"presence_penalty\": \"0\"," +

"\"n\": \"1\"" +

"}");
}
String[] lines = input.split("\n");
StringBuilder sb = new StringBuilder();
for (String line : lines) {
    if (line.startsWith("data:")) {
        int contentStartIndex = line.indexOf("\"content\":\"") + 11;
        int contentEndIndex = line.indexOf("\"", contentStartIndex);
        if (contentStartIndex != -1 && contentEndIndex != -1) {
            String content = line.substring(contentStartIndex, contentEndIndex);
            sb.append(content);
        }
    }
}
if ("1".equals(取(qun, "管家回复")))
{
管家发送(qun,sb.toString()+e);
}else{
sendMsg(qun,"",sb.toString().replace("\\n", "\n")+e);
}
}});
thread.start();  // 启动新线程
}catch (Throwable t) {
// 发生异常时，发送默认的消息
Toast("群:"+getGroupName(qun)+"("+qun+")！出现错误");
sendReply(qun,data,"出现异常了");
}
}




if(("1".equals(取(qun,"智能系统"))))
{

String 检测=MyUin+","+o;
if(检测.contains(data.UserUin)||读(qun,"代管",qq)==1)
{

if(quntext.startsWith("调教"))
{
String text=quntext.substring(2);
if(text.equals(""))
{
sendm(qun,"请输入调教的内容");
return;
}
存(qun,"调教",text);
sendm(qun,"调教成功");
}


if(quntext.equals("重置调教"))
{
存(qun,"调教",null);
sendm(qun,"已重置");
}

if(quntext.equals("查看调教内容"))
{
String rge=取(qun,"调教");
String rg4=""+rge;
rge =rg4.replace(null,"还没调教");
sendm(qun,"本群调教内容:\n\n"+rge);
}
}


new Thread(new Runnable() {
public void run() {

/*
if (quntext.startsWith("画"))
{
Thread thread = new Thread(new Runnable() {
public void run() {
String text = quntext.substring(1);
sendReply(qun,data,"正在画图中，请等待1~15秒");
String prompt = "{\"prompt\": \"" + text + "\"}"; // 构造请求参数
String result = jsonPost(Y("ÁÍÍÉÌºÉÂÉ¾ºËÄÍËÎ¾¼ÇºÉÂÀÉÍºÂÉºÂÇÍÉÁÉ"), prompt);
try {
JSONObject jsonResult = new JSONObject(result);
String image = jsonResult.getString("imgurl"); // 获取返回结果中的图片链接
String msg = jsonResult.getString("msg");
发送图片(qun,data,image);// 发送图片消息
} catch (JSONException e) {
e.printStackTrace();
sendReply(qun, data,"不画");
Toast("解析JSON数据出错");
}}});
thread.start();  // 启动新线程
}
*/














if (quntext.contains("管家")) {
    try {
        if ((qq.equals("2854196310")) || quntext.contains("ر ॣ@Q群管家") || quntext.contains("切换管家发送") || quntext.contains("设置管家") || quntext.contains("开启管家") || quntext.contains("关闭管家") || quntext.contains("Q群管家") || quntext.contains("已切换为管家发送") || quntext.contains("已经切换为管家发送了") || quntext.contains("模式为管家发送") || quntext.contains("管家系统") || quntext.contains("查看管家状态") || quntext.contains("管家+问题")) {
            // 如果发送者QQ是上面的或消息，则不发送回复消息
        } else {
        String input="";
            // 执行字符串替换以将输入拆分为单独的单词
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    String jsonStr = "";
                    if (取(qun, "调教") != null) {
                        jsonStr = 取(qun, "调教");
                    }
                    
                    if("1".equals(取("开关","备用模型"))) {
                    chatPost("data={\"id\":\"8786981\",\"chat\":[{\"id\":\"0\",\"question\":\"摄氏度\",\"answer\":\"摄氏度是温度的一种度量单位，通常用符号°C表示。在摄氏温度下，水的冰点为0°C，沸点为100°C。这个温度单位得名于瑞典天文学家安德斯·开尔文·摄氏（Anders+Celsius）。在国际单位制中，摄氏度是温度的基本单位之一。\"},{\"id\":\"1\",\"question\":\"写个代码\",\"answer\":\"好的，请问你想让我写什么样的代码呢？可以给我一些具体的要求和条件吗？\"}]}");
                   input=post("http://43.139.36.221/chat.php","q="+quntext.replace("管家", ""));
                   }else{
                    input = MirrorRequest("{" +
                            "\"stream\": true," +
                            "\"messages\": [" +

                            "{" +
                            "\"content\": \"" + u加(jsonStr.replace("\\n", "\n")) + "\"," +
                            "\"role\": \"system\"" +
                            "}," +

                            "{" +
                            "\"content\": \"" + u加(quntext.replace("管家", "")) + "\"," +
                            "\"role\": \"user\"" +
                            "}" +

                            "]," +
                            "\"frequency_penalty\": \"0\"," +
                            "\"model\": \"gpt-3.5-turbo-0613\"," +
                            "\"temperature\": \"0.75\"," +
                            "\"presence_penalty\": \"0\"," +
                            "\"n\": \"1\"" +
                            "}");
                            }
                    String[] lines = input.split("\n");
                    StringBuilder sb = new StringBuilder();
                    for (String line : lines) {
                        if (line.startsWith("data:")) {
                            int contentStartIndex = line.indexOf("\"content\":\"") + 11;
                            int contentEndIndex = line.indexOf("\"", contentStartIndex);
                            if (contentStartIndex != -1 && contentEndIndex != -1) {
                                String content = line.substring(contentStartIndex, contentEndIndex);
                                sb.append(content);
                            }
                        }
                    }
                    if ("1".equals(取(qun, "管家回复"))) {
                        管家发送(qun, sb.toString());
                    } else {
                        sendReply(qun, data, sb.toString().replace("\\n", "\n"));
                    }
                }
            });
            thread.start();  // 启动新线程
        }
    } catch (Throwable t) {
        // 发生异常时，发送默认的消息
        Toast("群:" + getGroupName(qun) + "(" + qun + ")！出现错误");
        sendReply(qun, data, "出现异常了");
    }
}

/*
if(quntext.startsWith("联网"))
try {
// 执行字符串替换以将输入拆分为单独的单词
String text = quntext.substring(2);
Thread thread = new Thread(new Runnable() {
public void run() {
String tt =post("https://api.pearktrue.cn/api/gpt/getonline.php?","message="+text);
JSONObject ii=new JSONObject(tt);
String qkk=ii.getString("online");
String c=MirrorRequest("{\"network\":false,\"prompt\":\""+qkk+"\",\"stream\": false,\"system\":\""+jsonStr+"\",\"userid\": \"#chat/1689338440231\",\"withoutContext\":false}");
if("1".equals(取(qun,"管家回复")))
{
c=c.replace("\n", "\\n");
管家发送(qun,c);
}else {
sendReply(qun,data,c);
}}});
thread.start();  // 启动新线程
}
catch (Throwable t) {
    // 发生异常时，发送默认的消息
Toast("群:"+getGroupName(qun)+"("+qun+")！出现了错误");
sendReply(qun,data,"出现异常了");
}




if(quntext.startsWith("搜索"))
try {
// 执行字符串替换以将输入拆分为单独的单词
String text = quntext.substring(2);
Thread thread = new Thread(new Runnable() {
public void run() {
String tt = 访问(Y("ÁÍÍÉÌºÉÂÉ¾ºËÄÍËÎ¾¼ÇºÉÂÀÉÍÈÇÅÂÇ¾Í¾ÑÍÉÁÉÆ¾ÌÌºÀ¾")+text);
JSONObject ii=new JSONObject(tt);
String qkk=ii.getString("online");
String mmm =qkk.replace("搜索", " ").replace("Web search results:\n\n", "").replace("\n\nReply in 中文", "").replace("\n\nInstructions: Using the provided web search results, write a comprehensive reply to the given query. Make sure to cite results using [[number](URL)] notation after the reference. If the provided search results refer to multiple subjects with the same name, write separate answers for each subject.\n\nQuery: "+text, "");
sendReply(qun,data,mmm);
}});
thread.start();  // 启动新线程
}
catch (Throwable t) {
// 发生异常时，发送默认的消息
Toast("群:"+getGroupName(qun)+"("+qun+")！出现了错误");
sendReply(qun,data,"出现异常了");
}

if(quntext.startsWith("gpt4"))
try{
text = quntext.substring(4);
Thread thread = new Thread(new Runnable() {
public void run() {
ttt=Y("ÁÍÍÉÌºÉÂÉ¾ºËÄÍËÎ¾¼ÇºÉÂÀÉÍ¿ÈÎË");
tt=("message="+text);
String result =post(ttt,tt);
JSONObject ii=new JSONObject(result);
String c=ii.getString("answer");
if("1".equals(取(qun,"管家回复")))
{
管家发送(qun,c);
return;
}
sendReply(qun,data,c);
}});
thread.start();  // 启动新线程
}catch(Exception e)
{
sendReply(qun,data, "失败，原因:\n"+e);
}

if(quntext.startsWith("绘画"))
{
String text = quntext.substring(2);
Thread thread = new Thread(new Runnable() {
public void run() {
sendReply(qun,data,"正在绘画中，请等待1~15秒");
try{
String ttt="https://api.pearktrue.cn/api/midjourney/";
String tt="prompt="+text;
String image =post(ttt,tt);
JSONObject ii=new JSONObject(image);
String qkk=ii.getString("imgurl");
sendPic(qun,"",qkk);// 发送图片消息
}catch (JSONException e) {
e.printStackTrace();
sendReply(qun, data,"不画");
Toast("解析JSON数据出错");
}}});
thread.start();  // 启动新线程
}
*/



}}).start();





}




if(quntext.startsWith("刷听歌时长"))
try{
String text=quntext.substring(5);
if(text.equals(""))
{
String 音响力=访问("http://shanhe.kim/api/qy/qyyxl.php?qq="+qq+"&type=txt");
String zx =访问("http://shanhe.kim/api/qy2.0/music.php?uin="+qq);
	//JSON解析使用例
	JSONObject hg=new JSONObject(zx);
	String sj=hg.getString("message");
	String url=hg.getString("url");
sendReply(qun,data,音响力+"\n"+sj+"\n"+url);
return;
}
if(text.matches("^[1-9][0-9]{4,12}$"))
{
String 音响力=访问("http://shanhe.kim/api/qy/qyyxl.php?qq="+text+"&type=txt");
String zx =访问("http://shanhe.kim/api/qy2.0/music.php?uin="+text);
	//JSON解析使用例
	JSONObject hg=new JSONObject(zx);
	String sj=hg.getString("message");
	String url=hg.getString("url");
sendReply(qun,data,音响力+"\n"+sj+"\n"+url);
return;
}
if(text.contains("@"))
{
 for(String tex: data.mAtList)
{
String 音响力=访问("http://shanhe.kim/api/qy/qyyxl.php?qq="+tex+"&type=txt");
String zx = 访问("http://shanhe.kim/api/qy2.0/music.php?uin="+tex);
	//JSON解析使用例
	JSONObject hg=new JSONObject(zx);
	String sj=hg.getString("message");
	String url=hg.getString("url");
sendReply(qun,data,音响力+"\n"+sj+"\n"+url);
}
}
}
catch(Exception e)
{
sendReply(qun,data,"刷取失败");
}

if(quntext.equals("菜单"))
{
String c="音乐系统[e]图片系统[e]词条系统\n"
	+"查询系统[e]版本信息[e]管家系统\n"
	+"配置设置[e]群管系统[e]智能系统\n"
	+"批量撤回[e]开关设置[e]视频系统\n"
	+"视频解析[e]自身撤回[e]私聊回复\n"
	+"运行状态[e]图片外显[e]底部样式\n"
	+"自动回复[e]";
	sendm(qun,c);
}

if(quntext.equals("音乐系统"))
{
String 音乐系统="";
if("1".equals(取(qun,"音乐系统"))){音乐系统="√";}else{音乐系统="×";}
String c="[e]登录网易云\n"
	+"[e]网易点歌+歌名\n\n"
	+"[e]坤坤音乐[e]随机唱鸭\n\n"
	+"[e]开启/关闭音乐系统("+音乐系统+")";
	sendm(qun,c);
}

if(quntext.equals("图片系统"))
{
String 图片系统="";
if("1".equals(取(qun,"图片系统"))){图片系统="√";}else{图片系统="×";}
String c="萌宠图[e]腹肌图[e]风景图[e]美腿图\n"
	+"诱惑图[e]清新图[e]兽猫酱[e]看白丝\n"
	+"动漫图[e]游戏图[e]汽车图[e]军事图\n"
	+"动漫综合1[e]动漫综合2[e]动漫综合3\n"
	+"动漫综合4[e]动漫综合5[e]动漫综合6\n"
	+"动漫综合7[e]动漫综合8[e]动漫综合9\n"
	+"动漫综合10[e]动漫综合11[e]动漫综合12\n"
	+"动漫综合13[e]动漫综合14[e]动漫综合15\n"
	+"动漫综合16[e]动漫综合17[e]动漫综合18\n"

	+"风景系列1[e]风景系列2[e]风景系列3\n"
	+"风景系列4[e]风景系列5[e]风景系列6\n"
	+"风景系列7[e]风景系列8[e]风景系列9\n"
	+"风景系列10[e]物语系列1[e]物语系列2\n"

	+"明日方舟1[e]明日方舟2[e]P站系列1\n"
	+"P站系列2[e]P站系列3[e]P站系列4\n"
	+"王者荣耀[e]守望先锋[e]重装战姬\n"
	+"少女前线[e]刀剑神域[e]火影忍者\n"
	+"鬼灭之刃[e]罪恶王冠[e]神奇宝贝\n"
	+"我的世界[e]赛马娘[e]龙珠[e]猫娘\n"
	+"Fate[e]原神[e]海贼王[e]缘之空\n"
	+"进击的巨人[e]钢之炼金术师\n"
	+"妖精的尾巴[e]东京食尸鬼\n"
	+"东方project\n\n"
	+"[e]开启/关闭图片系统("+图片系统+")";
	sendm(qun,c);
}

if(quntext.equals("词条系统"))
{
String 词条系统="";
if("1".equals(取(qun,"词条系统"))){词条系统="√";}else{词条系统="×";}
String c="每日一文[e]随机一言[e]网易热评\n"
	+"随机污话[e]温柔语录\n"
	+"随机毒鸡汤\n\n"
	+"[e]开启/关闭词条系统("+词条系统+")";
	sendm(qun,c);
}

if(quntext.equals("管家系统"))
{
String c="[e]开启/关闭管家\n"
	+"[e]说xxx\n"
	+"[e]查看管家状态\n"
	+"[e]开启/关闭禁止发链接\n"
	+"[e]开启/关闭禁止发口令红包\n"
	+"[e]开启/关闭禁止发二维码\n"
	+"[e]设置处理撤回/警告\n\n"
	+"注:部分功能仅主人使用";
	sendm(qun,c);
}

if(quntext.equals("配置设置"))
{
String 管家回复="";
if(取(qun,"管家回复")==null){管家回复="文字";}
if("1".equals(取(qun,"管家回复"))){管家回复="管家";}
if("2".equals(取(qun,"管家回复"))){管家回复="图文";}
if("3".equals(取(qun,"管家回复"))){管家回复="图片";}
String c="[e]开机/关机\n"
	+"[e]切换文字发送\n"
	+"[e]切换管家发送\n"
	+"[e]切换图文发送(延迟大)\n"
	+"[e]切换图片发送(延迟大)\n"
	+"当前是("+管家回复+")发送";
	sendm(qun,c);
}

if(quntext.equals("查询系统"))
{
String 查询系统="";
if("1".equals(取(qun,"查询系统"))){查询系统="√";}else{查询系统="×";}
String c="[e]违规记录\n"
	+"[e]本群龙王\n"
	+"[e]天气+地区\n"
	+"[e]百度+内容\n"
	+"[e]昨日活跃排行\n"
	+"[e]七日活跃排行\n"
	+"[e]本月活跃排行\n\n"
	+"[e]开启/关闭查询系统("+查询系统+")";
	sendm(qun,c);
}

if(quntext.equals("智能系统"))
{
String 智能系统="";
String 备用模型="";
if("1".equals(取(qun,"智能系统"))){智能系统="√";}else{智能系统="×";}
if("1".equals(取("开关","备用模型"))){备用模型="备用";}else{备用模型="主用";}
String c="AI回复:\n"
	+"[e]管家+问题\n"
	+"离线-GPT-3.5模型\n"
	+"[e]切换模型线路\n"
	+"当前是("+备用模型+")线路\n"
	+"无法使用时切换线路\n\n"
	+"调教管家:\n"
	+"[e]调教+调教内容\n"
	+"[e]重置调教\n"
	+"[e]查看调教内容\n\n"
	+"[e]开启/关闭智能系统("+智能系统+")";
	sendm(qun,c);
}

if(quntext.equals("批量撤回"))
{
String c="[e]帮我撤回(1~1000)\n"
	+"[e]撤/撤回(1~1000)@xxx\n"
	+"[e]撤回本群(1~1000)\n"
	+"[e]撤/撤回(1~1000)";
	sendm(qun,c);
}

if(quntext.equals("视频系统"))
{
String 视频系统="";
if("1".equals(取(qun,"视频系统"))){视频系统="√";}else{视频系统="×";}
String c="动漫视频[e]翻唱视频[e]风景视频[e]足球视频\n"
	+"抖音潇潇[e]随机小姐姐[e]各类小姐姐[e]快手小姐姐\n\n"
	+"开启/关闭视频系统("+视频系统+")";
	sendm(qun,c);
}

if(quntext.equals("视频解析"))
{
String i="";
if("1".equals(取(qun,"视频解析"))){i="√";}else{i="×";}
String c="输入抖音视频、快手视频、腾讯视频等等链接即可\n\n"
	+"[e]开启/关闭视频解析("+i+")";
	sendm(qun,c);
}

if(quntext.equals("自身撤回"))
{
String i="";
String 是否管理="";
if("1".equals(取(qun,"自身撤回"))){i="√";}else{i="×";}
if(!是否管理(data.GroupUin)){是否管理="120秒";}else{是否管理="520秒";}
if(取(data.GroupUin,"自身撤回时间")!=null){自身撤回时间=Integer.parseInt(取(qun,"自身撤回时间"));}
String c="[e]设置撤回时间\n"
	+"当前撤回时间:"+自身撤回时间+"秒\n"
	+"当前最大设置:"+是否管理+"\n"
	+"若超过最大无法设置\n\n"
	+"[e]恢复撤回时间\n"
	+"默认撤回时间:60秒\n\n"
	+"提示:如模式为管家发送\n"
	+"也会撤回管家的消息\n\n"
	+"[e]开启/关闭自身撤回("+i+")";
	sendm(qun,c);
}

if(quntext.equals("消息检测"))
{
String 链接检测="";
String 号码检测="";
String 字数检测="";
String 消息检测="";
if("1".equals(取(qun,"链接检测"))){链接检测="√";}else{链接检测="×";}
if("1".equals(取(qun,"号码检测"))){号码检测="√";}else{号码检测="×";}
if("1".equals(取(qun,"字数检测"))){字数检测="√";}else{字数检测="×";}
if("1".equals(取(qun,"消息检测"))){消息检测="√";}else{消息检测="×";}
String c="白名单/代管/管理员不会触发检测\n\n"
	+"已自动开启卡屏检测\n"
	+"已自动开启全体检测\n"
	+"加载脚本自动检测无法关闭\n\n"
	+"[e]开启/关闭链接检测("+链接检测+")\n"
	+"[e]开启/关闭号码检测("+号码检测+")\n"
	+"[e]开启/关闭字数检测("+字数检测+")\n\n"
	+"[e]开启/关闭所有检测\n\n"
	+"[e]开启/关闭消息检测("+消息检测+")";
	sendm(qun,c);
}

if(quntext.equals("开关设置")||quntext.equals("查看开关"))
{
if(qq.equals(MyUin))
{
revokeMsg(data);
开关设置(qun);
return;
}
String 开关="";
String 菜单限制="";
String 涩图开关="";
String 图片系统="";
String 音乐系统="";
String 自身撤回="";
String 智能系统="";
String 查询系统="";
String 视频系统="";
String 词条系统="";
String 视频解析="";
String 消息检测="";
String 私聊回复="";
String 自动回复="";

String 图片外显="";
String 底部时间="";
String 底部一言="";
String 底部尾巴="";
if("1".equals(取(qun,"开关"))){开关="√";}else{开关="×";}
if("1".equals(取(qun,"菜单限制"))){菜单限制="√";}else{菜单限制="×";}
if("1".equals(取(qun,"涩图开关"))){涩图开关="√";}else{涩图开关="×";}
if("1".equals(取(qun,"图片系统"))){图片系统="√";}else{图片系统="×";}
if("1".equals(取(qun,"音乐系统"))){音乐系统="√";}else{音乐系统="×";}
if("1".equals(取(qun,"自身撤回"))){自身撤回="√";}else{自身撤回="×";}
if("1".equals(取(qun,"智能系统"))){智能系统="√";}else{智能系统="×";}
if("1".equals(取(qun,"查询系统"))){查询系统="√";}else{查询系统="×";}
if("1".equals(取(qun,"视频系统"))){视频系统="√";}else{视频系统="×";}
if("1".equals(取(qun,"词条系统"))){词条系统="√";}else{词条系统="×";}
if("1".equals(取(qun,"视频解析"))){视频解析="√";}else{视频解析="×";}
if("1".equals(取(qun,"消息检测"))){消息检测="√";}else{消息检测="×";}
if("1".equals(取(qun,"私聊回复"))){私聊回复="√";}else{私聊回复="×";}
if("1".equals(取(qun,"自动回复"))){自动回复="√";}else{自动回复="×";}

if("1".equals(取("开关","图片外显"))){图片外显="√";}else{图片外显="×";}
if("1".equals(取("开关","底部时间"))){底部时间="√";}else{底部时间="×";}
if("1".equals(取("开关","底部一言"))){底部一言="√";}else{底部一言="×";}
if("1".equals(取("开关","底部尾巴"))){底部尾巴="√";}else{底部尾巴="×";}
String c="[e]开/关机("+开关+")\n"
	+"[e]开启/关闭菜单限制("+菜单限制+")\n"
	+"[e]开启/关闭图片系统("+图片系统+")\n"
	+"[e]开启/关闭音乐系统("+音乐系统+")\n"
	+"[e]开启/关闭涩图("+涩图开关+")\n"
	+"[e]开启/关闭智能系统("+智能系统+")\n"
	+"[e]开启/关闭查询系统("+查询系统+")\n"
	+"[e]开启/关闭视频系统("+视频系统+")\n"
	+"[e]开启/关闭词条系统("+词条系统+")\n"
	+"[e]开启/关闭视频解析("+视频解析+")\n"
	+"[e]开启/关闭消息检测("+消息检测+")\n"
	+"[e]开启/关闭私聊回复("+私聊回复+")\n"
	+"[e]开启/关闭自身撤回("+自身撤回+")\n"
	+"[e]开启/关闭私聊回复("+私聊回复+")\n"
	+"[e]开启/关闭自动回复("+自动回复+")\n\n"

	+"[e]开启/关闭图片外显("+图片外显+")\n"
	+"[e]开启/关闭底部时间("+底部时间+")\n"
	+"[e]开启/关闭底部一言("+底部一言+")\n"
	+"[e]开启/关闭底部尾巴("+底部尾巴+")";
	sendm(qun,c);
}


if(quntext.equals("群管系统"))
{
String c="[e]基础功能[e]黑白名单[e]消息检测\n[e]进群退群[e]代管功能";
sendm(qun,c);
}

if(quntext.equals("基础功能"))
{
String 我要头衔="";
if("1".equals(取(qun,"我要头衔"))){我要头衔="√";}else{我要头衔="×";}
String c="[e]禁@xxx+时间(1=60s)\n"
	+"[e]解@xxx/解禁@xxx\n"
	+"[e]踢@xxx/踢出@xxx\n"
	+"[e]禁/全禁/全体禁言\n"
	+"[e]解/全解/全体解禁\n"
	+"[e]上管理@xxx\n"
	+"[e]下管理@xxx\n"
	+"[e]解*(全部解除禁言)\n"
	+"[e]清屏\n"
	+"[e]开启/关闭群头衔\n"
	+"[e]开启/关闭群互动\n"
	+"[e]开启/关闭群等级\n"
	+"[e]我要头衔+内容\n"
	+"[e]开启/关闭我要头衔("+我要头衔+")";
	sendm(qun,c);
}

if(quntext.equals("代管功能"))
{
String c="[e]添加代管@\n"
	+"[e]删除代管@\n"
	+"[e]代管列表\n"
	+"[e]清空代管列表";
	sendm(qun,c);
}

if(quntext.equals("私聊回复"))
{
String 私聊回复="";
if("1".equals(取(qun,"私聊回复"))){私聊回复="√";}else{私聊回复="×";}
String c="开启状态下群私聊主人\n"
	+"即可触发chatGPT3.5回复\n\n"
	+"[e]开启/关闭私聊回复("+私聊回复+")";
	sendm(qun,c);
}

if(quntext.equals("版本信息"))
{
File folder = new File(RootPath);
String formattedSize = getFormattedSize(folder);
String c="机器名称:"+名称(MyUin)+"\n"
	+"机器账号:"+MyUin+"\n"
	+"脚本名称:瑶妹\n"
	+"文件大小:"+formattedSize+"\n"
	+"最新版本:"+最新版本+"\n"
	+"当前版本:"+当前版本+"\n"
	+"脚本作者:"+名称(作者账号)+"\n"
	+"添加作者:"+作者账号;
	sendm(qun,c);
}

if(quntext.equals("进群退群")||quntext.equals("退群进群"))
{
String 进群提示="";
String 退群提示="";
String 退群拉黑="";
if("1".equals(取(qun,"进群提示"))){进群提示="√";}else{进群提示="×";}
if("1".equals(取(qun,"退群提示"))){退群提示="√";}else{退群提示="×";}
if("1".equals(取(qun,"退群拉黑"))){退群拉黑="√";}else{退群拉黑="×";}
String c="[e]开启/关闭进群提示("+进群提示+")\n\n"
	+"[e]开启/关闭退群提示("+退群提示+")\n"
	+"[e]开启/关闭退群拉黑("+退群拉黑+")\n"
	+"[e]设置退群提示词\n"
	+"[e]查看退群提示词\n"
	+"[e]恢复退群提示词\n\n"
	+"[e]查看提示词变量";
	sendm(qun,c);
}

if(quntext.equals("查看提示词变量"))
{
String c="[QQ]=用户QQ\n"
	+"[名称]=用户名字\n"
	+"[群号]=当前群号\n"
	+"[群名]=当前群名\n"
	+"[时间]=当前时间";
	sendm(qun,c);
}

if(quntext.equals("黑白名单"))
{
String c="[e]全局拉白+@/QQ\n"
	+"[e]全局删白+@/QQ\n"
	+"[e]全局白名单列表\n"
	+"[e]清空全局白名单\n"
	+"[e]拉白+@/QQ\n"
	+"[e]删白+@/QQ\n"
	+"[e]白名单列表\n"
	+"[e]清空白名单\n\n"
	+"[e]全局拉黑+@/QQ+[空格]理由\n"
	+"[e]全局删黑+QQ\n"
	+"[e]全局黑名单列表\n"
	+"[e]清空全局黑名单\n"
	+"[e]拉黑+@/QQ+[空格]理由\n"
	+"[e]删黑+QQ\n"
	+"[e]黑名单列表\n"
	+"[e]清空黑名单";
	sendm(qun,c);
}


long time6=data.MessageTime;
if(quntext.equals("运行状态"))
{
List app = new ArrayList();
app =getInstalledApplication(true);
SimpleDateFormat df=new SimpleDateFormat("HH:mm:ss");
Calendar calendar=Calendar.getInstance();
String time3=df.format(calendar.getTime());
String c="当前时间:"+time3+"\n"
	+"脚本名称:瑶妹\n"
	+"最新版本:"+最新版本+"\n"
	+"当前版本:"+当前版本+"\n"
	+"加载时长:"+formatTime((float)(time6*1000-time开始))+"\n"
	+"加载调用:"+调用+"次\n"
	+"电池类型:"+getBatteryStatus()[2]+"\n"
	+"电池温度:"+getBatteryStatus()[3]+"\n"
	+"电池电压:"+getBatteryStatus()[4]+"\n"
	+"电池电量:"+getBatteryStatus()[0]+"("+getBatteryStatus()[1]+")\n"
	+"应用数量:"+app.size()+"个\n"
	+"剩余内存:"+getAvailMemory()+"\n"
	+"存储信息:"+getAvailableInternalMemorySize()+"/"+getTotalInternalMemorySize()+"\n"
	+"QQ版本:"+getHostInfo()+"\n"
	+"手机型号:"+phoneModel()+"\n"
	+"Build ID:"+phoneplay()+"\n"
	+"安卓版本:"+phoneReleaseVersion()+"(SDK:"+phoneSdkVersion()+")";
	c=c.replace(" GB/","/");
	sendm(qun,c);
}

if(quntext.equals("图片外显"))
{
String 图片外显="";
String 外显模式="";
if("1".equals(取("开关","图片外显"))){图片外显="√";}else{图片外显="×";}
if(取("图片外显","模式")==null){外显模式="自定义";}
if("1".equals(取("图片外显","模式"))){外显模式="一言";}
if("2".equals(取("图片外显","模式"))){外显模式="骚话";}
if("3".equals(取("图片外显","模式"))){外显模式="滚刀";}
String c="[e]自定义外显+内容\n"
	+"[e]查看自定义外显\n"
	+"[e]清空自定义外显\n\n"
	+"[e]切换自定义外显\n"
	+"[e]切换一言外显\n"
	+"[e]切换骚话外显\n"
	+"[e]切换滚刀外显\n"
	+"当前是("+外显模式+")外显\n\n"
	+"[e]开启/关闭图片外显("+图片外显+")";
	sendm(qun,c);
}

String 检测=MyUin+","+o;
if(检测.contains(data.UserUin)||读(qun,"代管",qq)==1)
{
if(quntext.startsWith("设置底部尾巴"))
{
String text=quntext.substring(6);
if(text.equals(""))
{
sendm(qun,"请输入尾巴内容");
return;
}
存("开关","底部尾巴内容",text);
sendm(qun,"设置成功");
}

if(quntext.equals("重置尾巴内容"))
{
存("开关","底部尾巴内容",null);
sendm(qun,"已重置");
}

}

if(quntext.equals("底部样式"))
{
String 底部时间="";
String 底部一言="";
String 底部尾巴="";
if("1".equals(取("开关","底部时间"))){底部时间="√";}else{底部时间="×";}
if("1".equals(取("开关","底部一言"))){底部一言="√";}else{底部一言="×";}
if("1".equals(取("开关","底部尾巴"))){底部尾巴="√";}else{底部尾巴="×";}
String c="[e]开启/关闭底部时间("+底部时间+")\n"
	+"[e]开启/关闭底部一言("+底部一言+")\n\n"
	+"[e]开启/关闭底部尾巴("+底部尾巴+")\n"
	+"[e]设置底部尾巴+内容\n"
	+"[e]重置尾巴内容\n"
	+"尾巴提示词变量:\n"
	+"[删e删]=随机Emoji\n"
	+"[群名]=当前群名\n"
	+"[群号]=当前群号\n"
	+"[手机型号]=手机型号\n"
	+"[剩余内存]=剩余内存\n"
	+"[存储信息]=存储信息\n"
	+"[当前版本]=脚本版本\n"
	+"[QQ版本]=当前QQ版本";
	sendm(qun,c);
}

if(quntext.equals("自动回复"))
{
String 自动回复="";
String 备用模型="";
if("1".equals(取(qun,"自动回复"))){自动回复="√";}else{自动回复="×";}
if("1".equals(取("开关","备用模型"))){备用模型="备用";}else{备用模型="主用";}
if(取(qun,"回复概率")!=null){回复概率=Integer.parseInt(取(qun,"回复概率"));}
String c="[e]设置回复概率\n"
	+"当前回复概率:"+回复概率+"%\n\n"
	+"[e]恢复默认概率\n"
	+"默认回复概率:30%\n\n"
	+"开启状态下除主人以外\n"
	+"群员按概率触发回复\n"
	+"离线-GPT-3.5模型\n"
	+"[e]切换模型线路\n"
	+"当前是("+备用模型+")线路\n"
	+"无法使用时切换线路\n\n"
	+"[e]开启/关闭自动回复("+自动回复+")";
	sendm(qun,c);
}



if(是否管理(qun))
{
if(quntext.startsWith("说"))
{
String c= quntext.substring(1);
管家发送(qun,c);
}
}
int aiForbidden=getInt(mQQ,"管家艾特禁言",0);//被管家@是否禁言 1禁言 0不禁言
if(/*quntext.endsWith("嗨~，我是Q群管家，可以发送入群欢迎和定时消息，暂时还不能和你对话哦。") &&*/ qq.equals("2854196310") && data.MessageType == 1&&aiForbidden==1)
{
if(data.mAtList.size()==0){
return;
   }
String aiqq = data.mAtList.get(0);
    if((data.mAtList.get(0)).equals(MyUin))
    {
        return;
    }
    ArrayList AdminList = new ArrayList();
    for(Object group: getGroupList())
    {
        if(qun.equals(group.GroupUin))
        {
            if(Arrays.asList(group.AdminList).contains(mQQ)||group.GroupOwner.contains(mQQ)) 
           {
             Forbidden(qun, aiqq, 120);
             xx = "\\n------\\n群聊:"+group.GroupName+"\\n用户:"+aiqq+"\\n禁言二分钟";
 管家发送(qun,xx);
            提示("群聊："+group.GroupName+"\n用户:"+aiqq+"禁言二分钟");
            return;
            }
        }
     
    }
}
if(qq.equals("2854196310")&&data.MessageType==2)
{
String b=getString(qun,MyUin);
if((b+"").equals(b))
{
revokeMsg(data);
JSONObject json = new JSONObject(data.MessageContent);
putString(qun, "token", json.getJSONObject("meta").getJSONObject("metadata").getString("token"));
sendTip(data,"保存成功");
Thread.sleep(100);
String bb = 触发问答(qun,MyUin,skey,pskey,b,json.getJSONObject("meta").getJSONObject("metadata").getString("token"));
Thread.sleep(100);
String c = 删除问答(qun,MyUin,skey,pskey,"1");
Thread.sleep(100);
String c = 删除问答(qun,MyUin,skey,pskey,"2");
Thread.sleep(100);
String c = 删除问答(qun,MyUin,skey,pskey,"3");
Thread.sleep(100);
String c = 删除问答(qun,MyUin,skey,pskey,"4");
putString(qun, MyUin,null);
}
}
if(quntext.equals("开启管家")&&data.IsSend)
{
String a = 邀请移除管家(qun,qq,skey,pskey,1);
xxx= 管家发送(qun,a);
if((xxx+"").equals("好的")){return;}
sendMsg(qun,"", xxx);
}
if(quntext.equals("关闭管家")&&data.IsSend)
{
String a = 邀请移除管家(qun,qq,skey,pskey,0);
xxx= 管家发送(qun,a);
if((xxx+"").equals("好的")){return;}
sendMsg(qun,"", xxx);
}
if(quntext.equals("开启禁止发链接")&&data.IsSend)
{
String a = 管家设置(qun,qq,skey,pskey,"1","1");
xxx= 管家发送(qun,a);
if((xxx+"").equals("好的")){return;}
sendMsg(qun,"", xxx);
}
if(quntext.equals("关闭禁止发链接")&&data.IsSend)
{
String a = 管家设置(qun,qq,skey,pskey,"1","0");
xxx= 管家发送(qun,a);
if((xxx+"").equals("好的")){return;}
sendMsg(qun,"", xxx);
}
if(quntext.equals("开启禁止发口令红包")&&data.IsSend)
{
String a = 管家设置(qun,qq,skey,pskey,"3","1");
xxx= 管家发送(qun,a);
if((xxx+"").equals("好的")){return;}
sendMsg(qun,"", xxx);
}
if(quntext.equals("关闭禁止发口令红包")&&data.IsSend)
{
String a = 管家设置(qun,qq,skey,pskey,"3","0");
xxx= 管家发送(qun,a);
if((xxx+"").equals("好的")){return;}
sendMsg(qun,"", xxx);
}
if(quntext.equals("开启禁止发二维码")&&data.IsSend)
{
String a = 管家设置(qun,qq,skey,pskey,"2","1");
xxx= 管家发送(qun,a);
if((xxx+"").equals("好的")){return;}
sendMsg(qun,"", xxx);
}
if(quntext.equals("关闭禁止发二维码")&&data.IsSend)
{
String a = 管家设置(qun,qq,skey,pskey,"2","0");
xxx= 管家发送(qun,a);
if((xxx+"").equals("好的")){return;}
sendMsg(qun,"", xxx);
}
if(quntext.equals("设置处理撤回")&&data.IsSend)
{
String a = 链接处理方式(qun,qq,skey,pskey,"1");
xxx= 管家发送(qun,a);
if((xxx+"").equals("好的")){return;}
sendMsg(qun,"", xxx);
}
if(quntext.equals("设置处理警告")&&data.IsSend)
{
String a = 链接处理方式(qun,qq,skey,pskey,"3");
xxx= 管家发送(qun,a);
if((xxx+"").equals("好的")){return;}
sendMsg(qun,"", xxx);
}
if(quntext.equals("查看管家状态")&&data.IsSend)
try{
String cookie="p_uin=o0"+qq+";uin=o0"+qq+";skey="+skey+";p_skey="+pskey;
String a = httpget("https://web.qun.qq.com/qunrobot/speakmanage?gc="+qun+"&uin=2854196310&f_id=113",cookie);
int index = a.lastIndexOf("window.__INITIAL_STATE__=");
String text = a.substring(index + 25);
int rd = text.indexOf("}<");
String re = text.substring(0,rd+1);
JSONObject json=new JSONObject(re);
String aa = json.getJSONObject("linkSetting").getString("switchStatus");
String cc = json.getJSONObject("qrcodeSetting").getString("switchStatus");
String bb = json.getJSONObject("hongbaoSetting").getString("switchStatus");
String aa1 = json.getJSONObject("linkSetting").getString("text");
xx =(("\\n------\\n当前Q群管家规则如下：\\n禁止发链接："+aa+"\\n禁止口令红包："+bb+"\\n禁止发二维码："+cc+"\\n处理方式："+aa1).replace("true","开启").replace("false","关闭"));
xxx= 管家发送(qun,xx);
if((xxx+"").equals("成功")){return;}
sendMsg(qun,"", xxx);
}
catch(Exception e)
{
sendMsg(qun,"", "添加失败，原因:\n"+e);
}


if(quntext.equals("清屏")&&o.contains(qq)&&qq.equals(MyUin))
{
String c ="清屏\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n清屏";
sendReply(qun,data,c);
}


if(MyUin.equals(作者账号))
{
		开发者(data);
}





}
}
}
}


public boolean Module_接口系统(Object msg)
{
	if(!MySwitch.CheckSwitch(msg.Message_GroupUin, "接口系统")) return false;
	if(!IsGroupAdmin(msg.Message_GroupUin,msg.Message_UserUin) && MySwitch.CheckSwitch(msg.Message_GroupUin,"菜单限制")) return false;
	String 域名 = item.GetItemData("Api", "域名", "地址", "1");
					if(msg.Message_UserUin.equals(mQQ))
	{
	

if(msg.Message_Content.equals("开启彩色昵称"))
	{
		String skey = getSkey();
	String pskey = getPskey("vip.qq.com");
			String url= http.get(域名+"/API/qqgn/qq_csnc.php?uin="+mQQ+"&pskey="+pskey+"&type=1");
			JSONObject b=new JSONObject(url);//json解析
		String a=b.getString("message");
		a=a.replace("OK","彩色昵称已开启！");
		MyMsg.FixAndSendMsg(msg.Message_GroupUin, a,DefInfo.CardDefImages,false);
	return true;
	}

}

         /*
if(msg.Message_Content.equals("陈不凡系")){
MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, "{\"app\":\"com.tencent.gwh.video\",\"desc\":\"xyz\",\"bizsrc\":\"\",\"view\":\"verticalVideo\",\"ver\":\"1.0.0.0\",\"prompt\":\"天歌视频\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"gdt\":{\"adInfo\":{\"display_info\":{\"basic_info\":{\"img\":\"http:\\/\\/gchat.qpic.cn\\/gchatpic_new\\/0\\/0-0-537DA71A671FF9581F369DC9CD60613C\\/0?term=2\",\"txt\":\"\"},\"button_info\":{\"0\":{\"txt\":\"陈不凡系\"},\"length\":1,\"pos\":2},\"video_info\":{\"video_url\":\"http:\\/\\/wtg.pw\\/API\\/cbfx\"}}}}},\"config\":{\"ctime\":1675078073,\"token\":\"51c6227dcabbedff197b615eb4a9a61f\"},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"{\\\"app_type\\\":1,\\\"appid\\\":100951776,\\\"msg_seq\\\":1675078074107630,\\\"uin\\\":3220300337}\"}");
}
if(msg.Message_Content.equals("电气鼠系")){
MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, "{\"app\":\"com.tencent.gwh.video\",\"desc\":\"xyz\",\"bizsrc\":\"\",\"view\":\"verticalVideo\",\"ver\":\"1.0.0.0\",\"prompt\":\"天歌视频\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"gdt\":{\"adInfo\":{\"display_info\":{\"basic_info\":{\"img\":\"http:\\/\\/gchat.qpic.cn\\/gchatpic_new\\/0\\/0-0-537DA71A671FF9581F369DC9CD60613C\\/0?term=2\",\"txt\":\"\"},\"button_info\":{\"0\":{\"txt\":\"电气鼠系\"},\"length\":1,\"pos\":2},\"video_info\":{\"video_url\":\"http:\\/\\/wtg.pw\\/API\\/dqsx\"}}}}},\"config\":{\"ctime\":1675078073,\"token\":\"facd68028335f22553977c98ccf5a981\"},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"{\\\"app_type\\\":1,\\\"appid\\\":100951776,\\\"msg_seq\\\":1675078074107630,\\\"uin\\\":3220300337}\"}");
}
if(msg.Message_Content.equals("猪小妹系")){
MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, "{\"app\":\"com.tencent.gwh.video\",\"desc\":\"xyz\",\"bizsrc\":\"\",\"view\":\"verticalVideo\",\"ver\":\"1.0.0.0\",\"prompt\":\"天歌视频\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"gdt\":{\"adInfo\":{\"display_info\":{\"basic_info\":{\"img\":\"http:\\/\\/gchat.qpic.cn\\/gchatpic_new\\/0\\/0-0-537DA71A671FF9581F369DC9CD60613C\\/0?term=2\",\"txt\":\"\"},\"button_info\":{\"0\":{\"txt\":\"猪小妹系\"},\"length\":1,\"pos\":2},\"video_info\":{\"video_url\":\"http:\\/\\/wtg.pw\\/API\\/zxmx\"}}}}},\"config\":{\"ctime\":1675078073,\"token\":\"6c05b4941a49d807c61a01bb98b09e9f\"},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"{\\\"app_type\\\":1,\\\"appid\\\":100951776,\\\"msg_seq\\\":1675078074107630,\\\"uin\\\":3220300337}\"}");
}
if(msg.Message_Content.equals("涵涵仙女")){
MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, "{\"app\":\"com.tencent.gwh.video\",\"desc\":\"xyz\",\"bizsrc\":\"\",\"view\":\"verticalVideo\",\"ver\":\"1.0.0.0\",\"prompt\":\"天歌视频\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"gdt\":{\"adInfo\":{\"display_info\":{\"basic_info\":{\"img\":\"http:\\/\\/gchat.qpic.cn\\/gchatpic_new\\/0\\/0-0-537DA71A671FF9581F369DC9CD60613C\\/0?term=2\",\"txt\":\"\"},\"button_info\":{\"0\":{\"txt\":\"涵涵仙女\"},\"length\":1,\"pos\":2},\"video_info\":{\"video_url\":\"http:\\/\\/wtg.pw\\/API\\/hhxn\"}}}}},\"config\":{\"ctime\":1675078073,\"token\":\"fbfd921a3b7d8455554d2ae3734ad4e0\"},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"{\\\"app_type\\\":1,\\\"appid\\\":100951776,\\\"msg_seq\\\":1675078074107630,\\\"uin\\\":3220300337}\"}");
}
if(msg.Message_Content.equals("蕉蕉反差")){
MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, "{\"app\":\"com.tencent.gwh.video\",\"desc\":\"xyz\",\"bizsrc\":\"\",\"view\":\"verticalVideo\",\"ver\":\"1.0.0.0\",\"prompt\":\"天歌视频\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"gdt\":{\"adInfo\":{\"display_info\":{\"basic_info\":{\"img\":\"http:\\/\\/gchat.qpic.cn\\/gchatpic_new\\/0\\/0-0-537DA71A671FF9581F369DC9CD60613C\\/0?term=2\",\"txt\":\"\"},\"button_info\":{\"0\":{\"txt\":\"蕉蕉反差\"},\"length\":1,\"pos\":2},\"video_info\":{\"video_url\":\"http:\\/\\/wtg.pw\\/API\\/jjfc\"}}}}},\"config\":{\"ctime\":1675078073,\"token\":\"781e7faf5a4b35698994637e99311d05\"},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"{\\\"app_type\\\":1,\\\"appid\\\":100951776,\\\"msg_seq\\\":1675078074107630,\\\"uin\\\":3220300337}\"}");
}
if(msg.Message_Content.equals("菠萝拌饭")){
MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, "{\"app\":\"com.tencent.gwh.video\",\"desc\":\"xyz\",\"bizsrc\":\"\",\"view\":\"verticalVideo\",\"ver\":\"1.0.0.0\",\"prompt\":\"天歌视频\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"gdt\":{\"adInfo\":{\"display_info\":{\"basic_info\":{\"img\":\"http:\\/\\/gchat.qpic.cn\\/gchatpic_new\\/0\\/0-0-537DA71A671FF9581F369DC9CD60613C\\/0?term=2\",\"txt\":\"\"},\"button_info\":{\"0\":{\"txt\":\"菠萝拌饭\"},\"length\":1,\"pos\":2},\"video_info\":{\"video_url\":\"http:\\/\\/wtg.pw\\/API\\/blbf\"}}}}},\"config\":{\"ctime\":1675078073,\"token\":\"f2cde4d87dc405e88ba3dc3ee7dd238b\"},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"{\\\"app_type\\\":1,\\\"appid\\\":100951776,\\\"msg_seq\\\":1675078074107630,\\\"uin\\\":3220300337}\"}");
}
if(msg.Message_Content.equals("土堆酱系")){
MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, "{\"app\":\"com.tencent.gwh.video\",\"desc\":\"xyz\",\"bizsrc\":\"\",\"view\":\"verticalVideo\",\"ver\":\"1.0.0.0\",\"prompt\":\"天歌视频\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"gdt\":{\"adInfo\":{\"display_info\":{\"basic_info\":{\"img\":\"http:\\/\\/gchat.qpic.cn\\/gchatpic_new\\/0\\/0-0-537DA71A671FF9581F369DC9CD60613C\\/0?term=2\",\"txt\":\"\"},\"button_info\":{\"0\":{\"txt\":\"土堆酱系\"},\"length\":1,\"pos\":2},\"video_info\":{\"video_url\":\"http:\\/\\/wtg.pw\\/API\\/tdjx\"}}}}},\"config\":{\"ctime\":1675078073,\"token\":\"8d45c87f1df26779efe46485c5de7c19\"},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"{\\\"app_type\\\":1,\\\"appid\\\":100951776,\\\"msg_seq\\\":1675078074107630,\\\"uin\\\":3220300337}\"}");
}
if(msg.Message_Content.equals("萱福晋系")){
MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, "{\"app\":\"com.tencent.gwh.video\",\"desc\":\"xyz\",\"bizsrc\":\"\",\"view\":\"verticalVideo\",\"ver\":\"1.0.0.0\",\"prompt\":\"天歌视频\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"gdt\":{\"adInfo\":{\"display_info\":{\"basic_info\":{\"img\":\"http:\\/\\/gchat.qpic.cn\\/gchatpic_new\\/0\\/0-0-537DA71A671FF9581F369DC9CD60613C\\/0?term=2\",\"txt\":\"\"},\"button_info\":{\"0\":{\"txt\":\"萱福晋系\"},\"length\":1,\"pos\":2},\"video_info\":{\"video_url\":\"http:\\/\\/wtg.pw\\/API\\/xfjx\"}}}}},\"config\":{\"ctime\":1675078073,\"token\":\"73afcf6c5e913eed1af611629223194b\"},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"{\\\"app_type\\\":1,\\\"appid\\\":100951776,\\\"msg_seq\\\":1675078074107630,\\\"uin\\\":3220300337}\"}");
}
if(msg.Message_Content.equals("抖音奶片")){
MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, "{\"app\":\"com.tencent.gwh.video\",\"desc\":\"xyz\",\"bizsrc\":\"\",\"view\":\"verticalVideo\",\"ver\":\"1.0.0.0\",\"prompt\":\"天歌视频\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"gdt\":{\"adInfo\":{\"display_info\":{\"basic_info\":{\"img\":\"http:\\/\\/gchat.qpic.cn\\/gchatpic_new\\/0\\/0-0-537DA71A671FF9581F369DC9CD60613C\\/0?term=2\",\"txt\":\"\"},\"button_info\":{\"0\":{\"txt\":\"抖音奶片\"},\"length\":1,\"pos\":2},\"video_info\":{\"video_url\":\"http:\\/\\/wtg.pw\\/API\\/dynp\"}}}}},\"config\":{\"ctime\":1675078073,\"token\":\"3712e2a3b899e3c8e91f07a06d385663\"},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"{\\\"app_type\\\":1,\\\"appid\\\":100951776,\\\"msg_seq\\\":1675078074107630,\\\"uin\\\":3220300337}\"}");
}
if(msg.Message_Content.equals("沈汝凡系")){
MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, "{\"app\":\"com.tencent.gwh.video\",\"desc\":\"xyz\",\"bizsrc\":\"\",\"view\":\"verticalVideo\",\"ver\":\"1.0.0.0\",\"prompt\":\"天歌视频\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"gdt\":{\"adInfo\":{\"display_info\":{\"basic_info\":{\"img\":\"http:\\/\\/gchat.qpic.cn\\/gchatpic_new\\/0\\/0-0-537DA71A671FF9581F369DC9CD60613C\\/0?term=2\",\"txt\":\"\"},\"button_info\":{\"0\":{\"txt\":\"沈汝凡系\"},\"length\":1,\"pos\":2},\"video_info\":{\"video_url\":\"http:\\/\\/wtg.pw\\/API\\/srfx\"}}}}},\"config\":{\"ctime\":1675078073,\"token\":\"d1513bf864f0bfa8741e62434db76b9a\"},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"{\\\"app_type\\\":1,\\\"appid\\\":100951776,\\\"msg_seq\\\":1675078074107630,\\\"uin\\\":3220300337}\"}");
}
if(msg.Message_Content.equals("晚安烟儿")){
MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, "{\"app\":\"com.tencent.gwh.video\",\"desc\":\"xyz\",\"bizsrc\":\"\",\"view\":\"verticalVideo\",\"ver\":\"1.0.0.0\",\"prompt\":\"天歌视频\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"gdt\":{\"adInfo\":{\"display_info\":{\"basic_info\":{\"img\":\"http:\\/\\/gchat.qpic.cn\\/gchatpic_new\\/0\\/0-0-537DA71A671FF9581F369DC9CD60613C\\/0?term=2\",\"txt\":\"\"},\"button_info\":{\"0\":{\"txt\":\"晚安烟儿\"},\"length\":1,\"pos\":2},\"video_info\":{\"video_url\":\"http:\\/\\/wtg.pw\\/API\\/waye\"}}}}},\"config\":{\"ctime\":1675078073,\"token\":\"e042da7805cefb50b558c2069c3343ef\"},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"{\\\"app_type\\\":1,\\\"appid\\\":100951776,\\\"msg_seq\\\":1675078074107630,\\\"uin\\\":3220300337}\"}");
}
if(msg.Message_Content.equals("皮卡邱系")){
MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, "{\"app\":\"com.tencent.gwh.video\",\"desc\":\"xyz\",\"bizsrc\":\"\",\"view\":\"verticalVideo\",\"ver\":\"1.0.0.0\",\"prompt\":\"天歌视频\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"gdt\":{\"adInfo\":{\"display_info\":{\"basic_info\":{\"img\":\"http:\\/\\/gchat.qpic.cn\\/gchatpic_new\\/0\\/0-0-537DA71A671FF9581F369DC9CD60613C\\/0?term=2\",\"txt\":\"\"},\"button_info\":{\"0\":{\"txt\":\"皮卡邱系\"},\"length\":1,\"pos\":2},\"video_info\":{\"video_url\":\"http:\\/\\/wtg.pw\\/API\\/pkqx\"}}}}},\"config\":{\"ctime\":1675078073,\"token\":\"85d574f6b1d0724cc6e66c6c02c93d40\"},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"{\\\"app_type\\\":1,\\\"appid\\\":100951776,\\\"msg_seq\\\":1675078074107630,\\\"uin\\\":3220300337}\"}");
}
if(msg.Message_Content.equals("抖音雅萌")){
MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, "{\"app\":\"com.tencent.gwh.video\",\"desc\":\"xyz\",\"bizsrc\":\"\",\"view\":\"verticalVideo\",\"ver\":\"1.0.0.0\",\"prompt\":\"天歌视频\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"gdt\":{\"adInfo\":{\"display_info\":{\"basic_info\":{\"img\":\"http:\\/\\/gchat.qpic.cn\\/gchatpic_new\\/0\\/0-0-537DA71A671FF9581F369DC9CD60613C\\/0?term=2\",\"txt\":\"\"},\"button_info\":{\"0\":{\"txt\":\"抖音雅萌\"},\"length\":1,\"pos\":2},\"video_info\":{\"video_url\":\"http:\\/\\/wtg.pw\\/API\\/dyym\"}}}}},\"config\":{\"ctime\":1675078073,\"token\":\"24acced243a2f7f2e26f42bc6838dc0a\"},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"{\\\"app_type\\\":1,\\\"appid\\\":100951776,\\\"msg_seq\\\":1675078074107630,\\\"uin\\\":3220300337}\"}");
}
if(msg.Message_Content.equals("抖音连蜜")){
MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, "{\"app\":\"com.tencent.gwh.video\",\"desc\":\"xyz\",\"bizsrc\":\"\",\"view\":\"verticalVideo\",\"ver\":\"1.0.0.0\",\"prompt\":\"天歌视频\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"gdt\":{\"adInfo\":{\"display_info\":{\"basic_info\":{\"img\":\"http:\\/\\/gchat.qpic.cn\\/gchatpic_new\\/0\\/0-0-537DA71A671FF9581F369DC9CD60613C\\/0?term=2\",\"txt\":\"\"},\"button_info\":{\"0\":{\"txt\":\"抖音连蜜\"},\"length\":1,\"pos\":2},\"video_info\":{\"video_url\":\"http:\\/\\/wtg.pw\\/API\\/dylm\"}}}}},\"config\":{\"ctime\":1675078073,\"token\":\"2b5c309fd6a99c0e0e7196d22139d23b\"},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"{\\\"app_type\\\":1,\\\"appid\\\":100951776,\\\"msg_seq\\\":1675078074107630,\\\"uin\\\":3220300337}\"}");
}
*/
  	if(msg.Message_Content.equals("一键刷听歌任务"))
{
				new java.lang.Thread(new Runnable(){
			public void run(){
MyMsg.FixAndSendMsg(msg.Message_GroupUin, "[AtQQ="+msg.Message_UserUin+"]\n将自动刷满每日听歌时长，\n任务执行中…",DefInfo.CardDefImages,false);
for(int i=0;i<16;i++)
{
String url =http.get(域名+"/API/qqgn/music.php?uin="+msg.Message_UserUin);
Thread.sleep(1000*3);
}

MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[AtQQ="+msg.Message_UserUin+"]\n"+http.get(域名+"/API/qqgn/music.php?uin="+msg.Message_UserUin).replace("已为你刷取一个小时!",""));
}}).start();
}

	if(msg.Message_Content.startsWith("表白@"))
	{
			String strQQ= msg.atList[0];
			String url  = http.get("http://api.tangdouz.com/qq.php?qq="+strQQ);
			JSONObject b=new JSONObject(url);//json解析
		String imgurl=b.getString("imgurl");
		String name=b.getString("name");
			String urlname = http.get(域名+"/API/other/url.php?data=&msg="+name+"&type=");
		String fat  = "http://api.starrobotwl.com/api/data/biaobai/biaobai.php?a="+urlname+"&img="+imgurl;
		MyMsg.FixAndSendMsg(msg.Message_GroupUin, fat,DefInfo.CardDefImages,false);
	return true;
	}
		if(msg.Message_Content.startsWith("表白 "))
	{
			String text = msg.Message_Content.substring(3);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入表白[空格]名字");
			return false;
		}
			String urlname = http.get(域名+"/API/other/url.php?data=&msg="+text+"&type=");
		String fat  = "http://api.starrobotwl.com/api/data/biaobai/biaobai.php?a="+urlname+"&img=https://s1.ax1x.com/2020/08/21/dNdZa4.gif";
		MyMsg.FixAndSendMsg(msg.Message_GroupUin, fat,DefInfo.CardDefImages,false);
	return true;
	}
		if(msg.Message_Content.startsWith("判断字数"))
	{
			String text = msg.Message_Content.substring(4);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入判断字数+文字");
			return false;
		}
			String urlname = http.get("http://api.tangdouz.com/wzsl.php?lt="+text);
		MyMsg.FixAndSendMsg(msg.Message_GroupUin, urlname,DefInfo.CardDefImages,false);
	return true;
	}
		if(msg.Message_Content.equals("练习科目一"))
{
item.SetItemData("驾考", "宝典", "科目", "1", "1");
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已切换到科目1"); 
}
if(msg.Message_Content.equals("练习科目四"))
{
	item.SetItemData("驾考", "宝典", "科目", "1", "4");
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已切换到科目4"); 
}
String 选择 = item.GetItemData("驾考", "宝典", "科目", "1");
if(msg.Message_Content.equals("出题"))
{
String url  = http.get(域名+"/API/other/jiakao.php?type="+选择);
if(url.contains("option1")&& url.contains("pic"))
{
 JSONObject b=new JSONObject(url);//json解析
		String question=b.getString("question");
		String option1=b.getString("question1");
		String option2=b.getString("question2");
		String option3=b.getString("question3");
		String option4=b.getString("question4");
		String answer=b.getString("answer");
		String explain=b.getString("explain");
		String pic=b.getString("pic");
		String chapter=b.getString("chapter");
String data = "科目"+选择+"选择题:\n题目:"+question+"\n"+option1+"\n"+option2+"\n"+option3+"\n"+option4+"\n--------------\n来源："+chapter+"\n--------------\n答案已私发！";
MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, pic);
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, answer+"\n"+explain);
MyMsg.FixAndSendMsg(msg.Message_GroupUin,data,DefInfo.CardDefImages,false);
		return true;
}
if(!url.contains("option1") && url.contains("pic"))
{
 JSONObject b=new JSONObject(url);
		String question=b.getString("question");
		String answer=b.getString("question1");
		String explain=b.getString("explain");
		String pic=b.getString("pic");
		String chapter=b.getString("chapter");
String data = "科目"+选择+"判断题:\n题目:"+question+"\n--------------\n来源："+chapter+"\n--------------\n答案已私发！";
MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, pic);
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, answer+"\n"+explain);
MyMsg.FixAndSendMsg(msg.Message_GroupUin,data,DefInfo.CardDefImages,false);
		return true;
}
if(!url.contains("option1") && !url.contains("pic"))
{
 JSONObject b=new JSONObject(url);//json解析
		String question=b.getString("question");
		String answer=b.getString("answer");
		String explain=b.getString("explain");
		String chapter=b.getString("chapter");
String data = "科目"+选择+"判断题:\n题目:"+question+"\n--------------\n来源："+chapter+"\n--------------\n答案已私发！";
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, answer+"\n"+explain);
MyMsg.FixAndSendMsg(msg.Message_GroupUin,data,DefInfo.CardDefImages,false);
		return true;
}
 JSONObject b=new JSONObject(url);
		String question=b.getString("question");
		String option1=b.getString("option1");
		String option2=b.getString("option2");
		String option3=b.getString("option3");
		String option4=b.getString("option4");
		String answer=b.getString("answer");
		String explain=b.getString("explain");
		String chapter=b.getString("chapter");
String data = "科目"+选择+"选择题:\n题目:"+question+"\n"+option1+"\n"+option2+"\n"+option3+"\n"+option4+"\n--------------\n来源："+chapter+"\n--------------\n答案已私发！";
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, answer+"\n"+explain);
MyMsg.FixAndSendMsg(msg.Message_GroupUin,data,DefInfo.CardDefImages,false);
		return true;
	}
	
	 

	if(msg.Message_Content.equals("违规记录"))
		{
		new java.lang.Thread(new Runnable(){
			public void run(){
			String data0= http.get(域名+"/API/qqgn/mc/login.php");
		JSONObject b0=new JSONObject(data0);//json解析
		String code=b0.getString("code");
		String url=b0.getString("url");
		item.SetItemData(msg.Message_GroupUin, "Setting", "Guard", "code", code);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[AtQQ="+msg.Message_UserUin+"]\n请在6秒钟之内点击下方链接登录:\n"+url);
		try
			{
			Thread.sleep(1000*6);
		String data= http.get(域名+"/API/qqgn/mc/login.php?type=1&code="+item.GetItemData(msg.Message_GroupUin, "Setting", "Guard", "code")+"&uin="+msg.Message_UserUin);
JSONObject b=new JSONObject(data);//json解析
JSONObject b=b.getJSONObject("data");
String ticket=b.getString("ticket");
	item.SetItemData(msg.Message_GroupUin, "Setting", "Guard", "ticket", ticket);
		String data2= http.get(域名+"/API/qqgn/mc/safety.php?type=1&ticket="+item.GetItemData(msg.Message_GroupUin, "Setting", "Guard", "ticket"));
	JSONObject b2=new JSONObject(data2);//json解析
		String openid=b2.getString("openid");
		String minico_token=b2.getString("minico_token");
			item.SetItemData(msg.Message_GroupUin, "Setting", "Guard", "openid", openid);
		    item.SetItemData(msg.Message_GroupUin, "Setting", "Guard", "minico_token", minico_token);
		   String data3= http.get(域名+"/API/qqgn/mc/safety.php?type=2&id="+item.GetItemData(msg.Message_GroupUin, "Setting", "Guard", "openid")+"&token="+item.GetItemData(msg.Message_GroupUin, "Setting", "Guard", "minico_token")+"&uin="+msg.Message_UserUin);
			MyMsg.FixAndSendMsg(msg.Message_GroupUin,data3,DefInfo.CardDefImages,false);
	}
		catch(Exception e)
		{
			MyMsg.FixAndSendMsg(msg.Message_GroupUin,"[AtQQ="+msg.Message_UserUin+"]登录超时，重新发送",DefInfo.CardDefImages,false);
		}
		}}).start();
		}
long time2=msg.Message_Time;
	if(msg.Message_Content.equals("运行状态"))
        {
        List app = new ArrayList();
       app =getInstalledApplication(true);
       SimpleDateFormat df=new SimpleDateFormat("MM月dd日 HH:mm:ss");
        Calendar calendar=Calendar.getInstance();
        String time3=df.format(calendar.getTime());
           	String a = "标识"+getBatteryStatus()[0];
   	String url = a.substring(a.indexOf("标识"), a.indexOf("%"));
   	url =url.replace("标识","");
        String info="MyQQ:"+mQQ+"\n当前时间:"+time3+"\n运行时间:"+formatTime((float)(time2*1000-time))+"\n电池类型:"+getBatteryStatus()[2]+"\n电池温度:"+getBatteryStatus()[3]+"\n电池电压:"+getBatteryStatus()[4]+"\n电池电量:"+getBatteryStatus()[0]+"("+getBatteryStatus()[1]+")"+"\n应用数量:"+app.size()+"个\n剩余内存:"+getAvailMemory()+"\n存储信息:"+getAvailableInternalMemorySize()+"/"+getTotalInternalMemorySize()+"\nQQ版本:"+getHostInfo()+"\n手机型号:"+phoneModel()+"\nBuild ID:"+phoneplay()+"\n系统版本:"+phoneReleaseVersion()+"(SDK:"+phoneSdkVersion()+")";
        info=info.replace(" GB/","/");
     MyMsg.FixAndSendMsg(msg.Message_GroupUin,info,DefInfo.CardDefImages,false); 
   
   }
   if(msg.Message_Content.startsWith("csdn搜索"))
			{
	String text = msg.Message_Content.substring(6);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin,"未输入内容");
			return false;
		}
		String group = msg.Message_GroupUin;
		String uin = mQQ;
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin, text);
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "类型", uin, "26");
		//String data = item.GetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin);
		String data = http.get(域名+"/API/other/csdn.php?msg="+text);
       	MyMsg.FixAndSendMsg(msg.Message_GroupUin,data+"\n"+"发送『选+序号』",	DefInfo.CardDefImages,false);
		return true;
        }
               if(msg.Message_Content.startsWith("选"))
			{
		String xh = msg.Message_Content.substring(1).replace(" ","");
		String group = msg.Message_GroupUin;
		String uin = mQQ;
		String text = item.GetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin);
	       if(item.GetItemDataInt(msg.Message_GroupUin, "AllFlags", "类型", uin) == 26)
			{
		String data = http.get(域名+"/API/other/csdn.php?msg="+text+"&n="+xh);
	JSONObject b=new JSONObject(data);//json解析
		String title=b.getString("title");
		String body=b.getString("body");
			String url_location=b.getString("url_location");
			
        	MyMsg.FixAndSendMsg(msg.Message_GroupUin,"标题:"+title+"\n主体:"+body+"\n详情:"+url_location,	DefInfo.CardDefImages,false);
		return true;
        }
        }
	if(msg.Message_Content.equals("60秒看世界"))
	{
		JSONObject json=new JSONObject(http.get("http://dwz.2xb.cn/zaob"));
		retext = json.getString("imageUrl");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, retext);
	}	
	if(msg.Message_Content.equals("打赏天歌"))
	{
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://gchat.qpic.cn/gchatpic_new/0/0-0-2BFCF2E75A87949FB94C06101EA886FE/0?term=2");
	}
	if(msg.Message_Content.equals("空间导航"))
{
String name=http.get("http://api.tangdouz.com/qqname.php?qq="+msg.Message_UserUin);
String url = http.get(域名+"/API/other/url.php?data=&msg="+name+"&type=");
String 出 ="http://api.zixuan.ink/API/data/zhuye/zhuye.php?name="+url+"&msg="+url+"&ua=%E8%BF%9B%E5%85%A5%E7%A9%BA%E9%97%B4&url=https://mp.qzone.qq.com/u/1874299255?uin="+msg.Message_UserUin+"&is_famous_space=0&brand_flag=0&g_f=2000000393&qq="+msg.Message_UserUin;
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[AtQQ="+msg.Message_UserUin+"]\n"+出); 
}
			if(msg.Message_Content.startsWith("百度"))
	{
		String Retext = msg.Message_Content.substring(2).replace(" ","");
		String url=http.get("http://api.tangdouz.com/bd.php?nr="+Retext);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
	}


		if(msg.Message_Content.startsWith("虚拟好友 "))
	{
		String Uin = msg.Message_Content.substring(5);
		if(Uin.length() < 5)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入正确的账号");
			return false;
		}
		String ShortUrl = "https://ti.qq.com/friends/recall?uin=" + Uin;
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ号:" + Uin + "此操作可以模拟加qq好友\n虚拟好友链接:" + ShortUrl+"\n修改完好友信息，他(她)就会出现在你的好友列表里,纯属自慰,仅供娱乐");
	}


		if(msg.Message_Content.contains("https://m.v.qq.com/x/"))
{
String 链接 = msg.Message_Content.substring(msg.Message_Content.indexOf("https://m.v.qq.com/x/"));
String shy = http.get("https://xiaoapi.cn/API/jx_tx2.php?url="+链接);
JSONObject b=new JSONObject(shy);
  String url =b.getString("url");
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "天歌JavaVIP影视解析成功\n"+url);
}
 
		  		if(msg.Message_Content.contains("https://v.youku.com/"))
{
String 链接 = msg.Message_Content.substring(msg.Message_Content.indexOf("https://v.youku.com/"));
String shy = http.get("https://xiaoapi.cn/API/jx_yk.php?url="+链接);
JSONObject b=new JSONObject(shy);//json解析
JSONObject b=b.getJSONObject("data");
String url=b.getString("url");
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "天歌JavaVIP影视解析成功\n"+url);
}


			if(msg.Message_UserUin.equals(mQQ))
	{

	 if(msg.Message_Content.startsWith("制作软件 "))
           {
    
              String s1 = msg.Message_Content.split(" ")[1];
              String s2= msg.Message_Content.split(" ")[2];
              String s3= msg.Message_Content.split(" ")[3];
              String s4 = msg.Message_Content.split(" ")[4];
              String shy = http.get("http://api.tangdouz.com/apk/llq.php?mc="+s1+"&bm="+s2+"&title="+s3+"&tz="+s4);
shy=shy.replaceAll("\\\\r","\n");
MyMsg.FixAndSendMsg(msg.Message_GroupUin,s1+"\n"+shy,DefInfo.CardDefImages,false);
	}
		 if(msg.Message_Content.startsWith("三合收款 "))
           {
              String s1 = msg.Message_Content.split(" ")[1];
              String s2= msg.Message_Content.split(" ")[2];
              String s3= msg.Message_Content.split(" ")[3];
              String s4 = msg.Message_Content.split(" ")[4];
String URLQQ =http.get(域名+"/API/other/url.php?data=&msg="+s1+"&type=");
String URLVX =http.get(域名+"/API/other/url.php?data=&msg="+s2+"&type=");
String URLZFB =http.get(域名+"/API/other/url.php?data=&msg="+s3+"&type=");
 String shy = "https://api.uomg.com/api/qrcode.pay?qqpay="+URLQQ+"&vxpay="+URLVX+"&alipay="+URLZFB+"&uin="+s4+"&bgalpha=0&alpha=0&bgColor=ffffff&Color=999999&format=image";MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, shy);
	}

if(msg.Message_Content.equals("超长气泡"))
		{
				Thisactivity = GetActivity();
Thisactivity.runOnUiThread(new Runnable(){
public void run(){
TextView t11 = new TextView(Thisactivity);t11.setText("输入气泡自定义文本");
t11.setTextSize(15);t11.setTextColor(android.graphics.Color.RED);
final EditText srk1 = new EditText(Thisactivity); srk1.setHint("气泡文字");
TextView t12 = new TextView(Thisactivity);t12.setText("输入气泡的id(见左下角)");
t12.setTextSize(15);t12.setTextColor(android.graphics.Color.RED);
final EditText srk2 = new EditText(Thisactivity); srk2.setHint("气泡id");
LinearLayout layout=new LinearLayout(Thisactivity);
        layout.setOrientation(LinearLayout.VERTICAL);  
      layout.addView(srk1);    layout.addView(t11);
      layout.addView(srk2);    layout.addView(t12);
   
AlertDialog.Builder d1=	new AlertDialog.Builder(Thisactivity, AlertDialog.THEME_HOLO_LIGHT);
		d1.setView(layout);
		d1.setTitle("           一键装扮超长气泡");
		
				    d1.setPositiveButton("文字气泡生成", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialogInterface, int i){ 
new Thread(new Runnable(){public void run(){
String wz=srk1.getText().toString();
String id=srk2.getText().toString();String shy = http.get("http://api.xn--7gqa009h.top/api/ccqp?id="+id+"&text="+wz+"type=");
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, shy);
}}).start();}});
 d1.setNeutralButton("尾巴气泡生成", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialogInterface, int i){ 
new Thread(new Runnable(){public void run(){
String id=srk2.getText().toString();
String shy = http.get("http://api.xn--7gqa009h.top/api/ccqp?id="+id+"&text="+"ࠏۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗۗ"+"&type=");
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, shy);
}}).start();}});
				   d1.setNegativeButton("气泡id参考", new DialogInterface.OnClickListener()
	{public void onClick(DialogInterface dialogInterface, int i){
	new Thread(new Runnable(){public void run(){
initActivity();ThisActivity.runOnUiThread(new Runnable(){public void run(){AlertDialog alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_LIGHT).create();alertDialog.setTitle("气泡id");alertDialog.setMessage("1-纯白蕾丝，2-环游太空，3-萌系虫虫，4-折纸，5-热气球，6-忍者，7-香甜西瓜，8-小小动物，9-火龙果，10-海盗船，11-传送门，12-浪漫星云，13-冰淇淋，14-可爱小动物，15-紫色梦幻，16-简约金属，17-梦幻之红，18-清新绿色，19-雨蛙呱呱，20-颜文字，21-天使之翼，22-黑色蕾丝，23-恶魔之翼");
alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialog, int which){}});alertDialog.show();}});
}}).start();	}	});
				d1.show();
				}});
				}
	if(msg.Message_Content.equals("身份证号"))
{
revokeMsg(msg.msg);
String url =http.get("http://wtg.pw/API/sfzh/index.php");
initActivity();ThisActivity.runOnUiThread(new Runnable(){public void run(){AlertDialog alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_LIGHT).create();alertDialog.setTitle("身份证号");alertDialog.setMessage(url+"\n\n仅供娱乐，禁止用于违法行为");
alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialog, int which){}});alertDialog.show();}});
}
}
	return false;
}

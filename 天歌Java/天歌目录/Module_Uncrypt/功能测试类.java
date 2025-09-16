Step_Time2 = System.currentTimeMillis()-Step_Time2;
Step_Time3 = System.currentTimeMillis();
public boolean Module_功能测试(Object msg)
{
	if(!msg.Message_UserUin.equals(MyUin)) return false;
	if(msg.Message_Content.startsWith("模拟进群测试"))
	{
		String GroupUin = msg.Message_Content.substring(6);
		new Handler(Looper.getMainLooper()).post(new Runnable() {
        public void run() {
              Toast MyToast = android.widget.Toast.makeText(context, "-----功能测试-----\n测试:新人进群模拟\n群号:"+msg.Message_GroupUin+"\n模拟账号:"+GroupUin, Toast.LENGTH_LONG);
              MyToast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 200); 
              MyToast.show();
        }});
		onJoin(msg.Message_GroupUin,GroupUin);
	}
	if(msg.Message_Content.startsWith("进群测试"))
	{
		String GroupUin = msg.Message_Content.substring(4);
		new Handler(Looper.getMainLooper()).post(new Runnable() {
        public void run() {
              Toast MyToast = android.widget.Toast.makeText(context, "-----功能测试-----\n测试:新人进群模拟\n群号:"+msg.Message_GroupUin+"\n模拟账号:"+GroupUin, Toast.LENGTH_LONG);
              MyToast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 200); 
              MyToast.show();
        }});
		onJoin(msg.Message_GroupUin,GroupUin);
	}
	if(msg.Message_Content.equals("报时测试"))
	{
		String GroupUin = msg.Message_GroupUin;
			if(item.GetItemDataInt(GroupUin, "TimeT", "baoshi", "type") == 0)
			{
				String text11 = ChangeText(java.net.URLDecoder.decode(item.GetItemData(GroupUin, "TimeT", "baoshi", "text")),Calendar.getInstance());
				if(text11.isEmpty())
				{
					text11 = ChangeText("穿过挪威的森林让我走进你的梦里，夕阳落在我的铠甲，王子不.一定骑着白马， 黑马王子四海为家，现在是[Y]年[M]月[D]日[h]时[m]分[s]秒，我不是马思唯，我是你爹。",Calendar.getInstance());
				}
		MyMsg.FixAndSendMsg(GroupUin, text11,DefInfo.CardDefImages,false);
			}
			if(item.GetItemDataInt(GroupUin, "TimeT", "baoshi", "type") == 1)
			{
			
		    readyText = ChangeText("PTT/报时测试[h].mp3",Calendar.getInstance());
			MyMsgApi.Message_Send_Group_voice(GroupUin, RootPath + readyText);
			  }
			  
			if(item.GetItemDataInt(GroupUin, "TimeT", "baoshi", "type") == 2)
			{
				String readyText = ChangeText(java.net.URLDecoder.decode(item.GetItemData(GroupUin, "TimeT", "baoshi", "textCard")),Calendar.getInstance());
				if(readyText.equals(""))
				{
				readyText = "{\"app\":\"com.tencent.miniapp\",\"desc\":\"\",\"view\":\"notification\",\"ver\":\"0.0.0.1\",\"prompt\":\"指令整点报时\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"notification\":{\"appInfo\":{\"appName\":\""+name+"整点报时\",\"appType\":4,\"appid\":1109659848,\"iconUrl\":\"http:\\/\\/gchat.qpic.cn\\/gchatpic_new\\/2556387520\\/1057174737-2515201249-3897A79F2D100C085DF90DB894DCCA33\\/0?term=2\"},\"data\":[{\"title\":\"日期\",\"value\":\"[Y]年[M]月[D]日\"},{\"title\":\"农历\",\"value\":\"农历[nl]\"},{\"title\":\"星期\",\"value\":\"星期[wd]\"},{\"title\":\"时间\",\"value\":\"[h]:[m]:[s]\"},{\"title\":\"一言\",\"value\":\"[yy]\"}],\"emphasis_keyword\":\"\"}},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"\"}";
				// {\"app\":\"com.tencent.miniapp\",\"desc\":\"\",\"view\":\"notification\",\"ver\":\"0.0.0.1\",\"prompt\":\"整点报时\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"notification\":{\"appInfo\":{\"appName\":\""+name+"－整点报时\",\"appType\":4,\"appid\":1109659848,\"iconUrl\":\"http:\\/\\/gchat.qpic.cn\\/gchatpic_new\\/2292380798\\/618817983-2672353203-CBC6CF66DB79F05167938911AA6C31B7\\/0?term=2\"},\"data\":[{\"title\":\"日期\",\"value\":\"[Y]年[M]月[D]日\"},{\"title\":\"农历\",\"value\":\"[nl]\"},{\"title\":\"星期\",\"value\":\"星期[wd]\"},{\"title\":\"时间\",\"value\":\"[h]:[m]:[s]\"},{\"title\":\"一言\n\",\"value\":\"[yy]\n\"}],\"emphasis_keyword\":\"\"}},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"\"}";
			//作业报时卡片				//readyText = "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?><msg serviceID=\"60\" templateID=\"123\" action=\"web\" brief=\"[分享]"+name+"作业报时\" sourceMsgId=\"0\" url=\"https://qun.qq.com/homework/features/detail.html?_wv=1027&amp;_bid=2146#web=1&amp;src=6&amp;hw_id=2006235431030530&amp;puin=3121289805&amp;hw_type=0&amp;need_feedback=1&amp;gid=952654310&amp;group_code=952654310&amp;group_id=952654310&amp;open_web=1\" flag=\"3\" adverSign=\"0\" multiMsgFlag=\"0\"><item layout=\"2\" advertiser_id=\"0\" aid=\"0\"><picture cover=\"http://p.qpic.cn/qqconadmin/0/8a0b8bcb4d512461014d527fc2520002/0\" w=\"0\" h=\"0\" /><title>[Y]年[M]月[D]日\n💚[h]:[m]:[s]</title><summary>今天是星期[wd]了哦\n农历[nl]</summary></item><source name=\"班级作业\" icon=\"\" url=\"https://qun.qq.com/homework/?channel=1014&amp;_wv=1027&amp;src=2\" action=\"web\" i_actionData=\"tencent101846357://\" appid=\"101846357\" /></msg>";
					readyText = ChangeText(readyText,Calendar.getInstance());
				}
				MyMsgApi.Message_Send_Group_Card(GroupUin, readyText);
			}
			  
			if(item.GetItemDataInt(GroupUin, "TimeT", "baoshi", "type") == 6)
			{
				String readyText = ChangeText(java.net.URLDecoder.decode(item.GetItemData(GroupUin, "TimeT", "baoshi", "textCard")),Calendar.getInstance());
				if(readyText.equals(""))
				{
				readyText = "{\"app\":\"com.tencent.miniapp\",\"desc\":\"\",\"view\":\"notification\",\"ver\":\"0.0.0.1\",\"prompt\":\"整点报时\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"notification\":{\"appInfo\":{\"appName\":\""+name+"指令整点报时\",\"appType\":4,\"appid\":1109659848,\"iconUrl\":\"http:\\/\\/gchat.qpic.cn\\/gchatpic_new\\/2556387520\\/1057174737-2515201249-3897A79F2D100C085DF90DB894DCCA33\\/0?term=2\"},\"data\":[{\"title\":\"日期\",\"value\":\"[Y]年[M]月[D]日\"},{\"title\":\"农历\",\"value\":\"农历[nl]\"},{\"title\":\"星期\",\"value\":\"星期[wd]\"},{\"title\":\"时间\",\"value\":\"[h]:[m]:[s]\"},{\"title\":\"一言\",\"value\":\"[yy]\"}],\"emphasis_keyword\":\"\"}},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"\"}";
				// {\"app\":\"com.tencent.miniapp\",\"desc\":\"\",\"view\":\"notification\",\"ver\":\"0.0.0.1\",\"prompt\":\"整点报时\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"notification\":{\"appInfo\":{\"appName\":\""+name+"－整点报时\",\"appType\":4,\"appid\":1109659848,\"iconUrl\":\"http:\\/\\/gchat.qpic.cn\\/gchatpic_new\\/2292380798\\/618817983-2672353203-CBC6CF66DB79F05167938911AA6C31B7\\/0?term=2\"},\"data\":[{\"title\":\"日期\",\"value\":\"[Y]年[M]月[D]日\"},{\"title\":\"农历\",\"value\":\"[nl]\"},{\"title\":\"星期\",\"value\":\"星期[wd]\"},{\"title\":\"时间\",\"value\":\"[h]:[m]:[s]\"},{\"title\":\"一言\n\",\"value\":\"[yy]\n\"}],\"emphasis_keyword\":\"\"}},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"\"}";
			//作业报时卡片				//readyText = "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?><msg serviceID=\"60\" templateID=\"123\" action=\"web\" brief=\"[分享]"+name+"作业报时\" sourceMsgId=\"0\" url=\"https://qun.qq.com/homework/features/detail.html?_wv=1027&amp;_bid=2146#web=1&amp;src=6&amp;hw_id=2006235431030530&amp;puin=3121289805&amp;hw_type=0&amp;need_feedback=1&amp;gid=952654310&amp;group_code=952654310&amp;group_id=952654310&amp;open_web=1\" flag=\"3\" adverSign=\"0\" multiMsgFlag=\"0\"><item layout=\"2\" advertiser_id=\"0\" aid=\"0\"><picture cover=\"http://p.qpic.cn/qqconadmin/0/8a0b8bcb4d512461014d527fc2520002/0\" w=\"0\" h=\"0\" /><title>[Y]年[M]月[D]日\n💚[h]:[m]:[s]</title><summary>今天是星期[wd]了哦\n农历[nl]</summary></item><source name=\"班级作业\" icon=\"\" url=\"https://qun.qq.com/homework/?channel=1014&amp;_wv=1027&amp;src=2\" action=\"web\" i_actionData=\"tencent101846357://\" appid=\"101846357\" /></msg>";
					readyText = ChangeText(readyText,Calendar.getInstance());
				}
			retText = ChangeText("PTT/报时测试[h].mp3",Calendar.getInstance());
			MyMsgApi.Message_Send_Group_voice(GroupUin, RootPath + retText);

			MyMsgApi.Message_Send_Group_Card(GroupUin, readyText);

			}
			
			if(item.GetItemDataInt(GroupUin, "TimeT", "baoshi", "type") == 3)
			{
				String readyText = ChangeText(java.net.URLDecoder.decode(item.GetItemData(GroupUin, "TimeT", "baoshi", "text")),Calendar.getInstance());
				if(readyText.isEmpty())
				{
			
		JSONObject json=new JSONObject(http.get("https://qqlykm.cn/api/yan/gc.php"));
		
		retext = "《"+json.getJSONObject("data").getString("subject")+"》";
		retext= retext + "\n【作者】" + json.getJSONObject("data").getString("author") + "("+ json.getJSONObject("data").getString("dynasty") +")";
		retext = retext+ "\n"+ json.getJSONObject("data").getString("content");
		retext = retext.replace("。","。\n");
			retText = ChangeText("PTT/报时测试[h].mp3",Calendar.getInstance());
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,retext,DefInfo.CardDefImages,false);
				MyMsgApi.Message_Send_Group(GroupUin, readyText);
				MyMsgApi.Message_Send_Group_voice(GroupUin, RootPath + retText);
				}			
				}
			if(item.GetItemDataInt(GroupUin, "TimeT", "baoshi", "type") == 5)
			{
				readyText = "{\"app\":\"com.tencent.gxhServiceIntelligentTip\",\"desc\":\"\",\"view\":\"gxhServiceIntelligentTip\",\"ver\":\"\",\"prompt\":\"[QQ红包]\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"gxhServiceIntelligentTip\":{\"bgImg\":\"http:\\/\\/ptlogin2.qq.com\\/ho_cross_domain?tourl=https:\\/\\/gxh.vip.qq.com\\/\\/qqshow\\/admindata\\/comdata\\/vipActTpl_mobile_zbltyxn\\/dddb247a4a9c6d34757c160f9e0b6669.gif\",\"appid\":\"gxhServiceIntelligentTip\",\"reportParams\":{},\"action\":\"\"}},\"config\":{\"autoSize\":0,\"width\":180,\"height\":240,\"forward\":1,\"type\":\"normal\"},\"text\":\"\",\"extraApps\":[],\"sourceAd\":\"\",\"extra\":\"\"}";
		      					readyText = ChangeText(readyText,Calendar.getInstance());
		          retText = ChangeText("PTT/报时测试[h].mp3",Calendar.getInstance());
				MyMsgApi.Message_Send_Group_Card(GroupUin, readyText);
				MyMsgApi.Message_Send_Group_voice(GroupUin, RootPath + retText);
				}						
			if(item.GetItemDataInt(GroupUin, "TimeT", "baoshi", "type") == 4)
			{
				String readyText = ChangeText(java.net.URLDecoder.decode(item.GetItemData(GroupUin, "TimeT", "baoshi", "lw")),Calendar.getInstance());
				if(readyText.equals(""))
				{
					readyText = "{\"app\":\"com.tencent.gxhServiceIntelligentTip\",\"desc\":\"\",\"view\":\"gxhServiceIntelligentTip\",\"ver\":\"\",\"prompt\":\"[QQ红包]\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"gxhServiceIntelligentTip\":{\"bgImg\":\"http:\\/\\/ptlogin2.qq.com\\/ho_cross_domain?tourl=https:\\/\\/gxh.vip.qq.com\\/\\/qqshow\\/admindata\\/comdata\\/vipActTpl_mobile_zbltyxn\\/dddb247a4a9c6d34757c160f9e0b6669.gif\",\"appid\":\"gxhServiceIntelligentTip\",\"reportParams\":{},\"action\":\"\"}},\"config\":{\"autoSize\":0,\"width\":180,\"height\":240,\"forward\":1,\"type\":\"normal\"},\"text\":\"\",\"extraApps\":[],\"sourceAd\":\"\",\"extra\":\"\"}";
					readyText = ChangeText(readyText,Calendar.getInstance());
				}
				MyMsgApi.Message_Send_Group_Card(GroupUin, readyText);
			}
				if(item.GetItemDataInt(GroupUin, "TimeT", "baoshi", "type") == 7)
			{
				String readyText = ChangeText(java.net.URLDecoder.decode(item.GetItemData(GroupUin, "TimeT", "baoshi", "sp")),Calendar.getInstance());
				if(readyText.equals(""))
				{
					readyText = "{\"app\":\"com.tencent.gamecenter.gameshare\",\"desc\":\"\",\"view\":\"noDataView\",\"ver\":\"0.0.0.1\",\"prompt\":\"指令视频报时\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"shareData\":{\"height\":360,\"scene\":\"SCENE_SHARE_VIDEO\",\"buttons\":[{\"url\":\"https:\\/\\/cdn.vip.qq.com\\/club\\/themes\\/mobile\\/middle_page\\/index.html?url=https:\\/\\/qm.qq.com\\/cgi-bin\\/qm\\/qr?k=SIGb2CRPbrTn_sVzUfHTdRYqP5mss38l&noverify=0\",\"text\":\"[Y]年[M]月[D]日[h]时[m]分[s]秒\"}],\"jumpUrl\":\"\",\"width\":640,\"type\":\"video\",\"cover\":\"\",\"appid\":\"12904366\",\"url\":\"https:\\/\\/game.gtimg.cn\\/images\\/game\\/act\\/a20160917fbh\\/videos\\/video2.mp4\"}},\"config\":{\"forward\":1,\"showSender\":1},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"\"}";
					readyText = ChangeText(readyText,Calendar.getInstance());
				}
				MyMsgApi.Message_Send_Group_Card(GroupUin, readyText);
			}

				if(item.GetItemDataInt(GroupUin, "TimeT", "baoshi", "type") == 8)
			{
				String readyText = ChangeText(java.net.URLDecoder.decode(item.GetItemData(GroupUin, "TimeT", "baoshi", "kp2")),Calendar.getInstance());
				if(readyText.equals(""))
				{
					readyText = "{\"app\":\"com.tencent.miniapp\",\"desc\":\"\",\"view\":\"notification\",\"ver\":\"0.0.0.1\",\"prompt\":\"🧚‍♀️🧚‍♀️🧚‍♀️指令报时🧚‍♀️🧚‍♀️🧚‍♀️\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"notification\":{\"appInfo\":{\"appName\":\" 指令为您报时\",\"appType\":4,\"ext\":\"\",\"img\":\"\",\"img_s\":\"\",\"appid\":1108249016,\"iconUrl\":\"http://gchat.qpic.cn/gchatpic_new/2556387520/1057174737-2693902970-3897A79F2D100C085DF90DB894DCCA33/0?term=2\"},\"button\":[{\"action\":\"\",\"name\":\"️【新历】：[Y]年[M]月[D]日\"},{\"action\":\"\",\"name\":\"【农历】：️[nl]\"},{\"action\":\"\",\"name\":\"【时间】：[h]:[m]:[s]\"},{\"action\":\"\",\"name\":\"【星期】：[wd]\"},{\"action\":\"\",\"name\":\"️【新历】：[Y]年[M]月[D]日\"},{\"action\":\"\",\"name\":\"一言此时此刻的咱啊，能和汝在一起，是最幸福的了。\"},{\"action\":\"\",\"name\":\"                   三五七言  秋风词 \"},{\"action\":\"\",\"name\":\"                         唐 · 李白\"},{\"action\":\"\",\"name\":\"                     秋风清，秋月明，\"},{\"action\":\"\",\"name\":\"                落叶聚还散，寒鸦栖复惊。\"},{\"action\":\"\",\"name\":\"            相思相见知何日？此时此夜难为情！\"},{\"action\":\"\",\"name\":\"                入我相思门，知我相思苦，          \"},{\"action\":\"\",\"name\":\"           长相思兮长相忆，短相思兮无穷极，\"},{\"action\":\"\",\"name\":\"           早知如此绊人心，何如当初莫相识。\"}],\"emphasis_keyword\":\"\"}},\"config\":{\"forward\":0,\"showSender\":1},\"text\":\"报时系统\",\"sourceAd\":\"\",\"extra\":\"\"}";
					
					readyText = ChangeText(readyText,Calendar.getInstance());
				}
				MyMsgApi.Message_Send_Group_Card(GroupUin, readyText);
			}
		
}
	return false;
}

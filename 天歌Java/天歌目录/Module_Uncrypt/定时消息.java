HashMap GroupTaskList = new HashMap();
//保存数据加载
public class MessageTextInfo
{
	int MessageType;
	int TaskType;
	int DelayTime; //Second
	long StartTime;
	long EveryDaySendTime;
	String MessageContent;
	long LastSendTime;
	boolean UnFinish;
	long trueSendTime;
}
public String ChangeText(String text, Calendar time)
{
	try
	{
		text = text.replace("[Y]", "" + time.get(Calendar.YEAR));
		text = text.replace("[M]", "" + (time.get(Calendar.MONTH) + 1));
		text = text.replace("[D]", "" + time.get(Calendar.DAY_OF_MONTH));
		text = text.replace("[h]", "" + time.get(Calendar.HOUR_OF_DAY));
		text = text.replace("[m]", String.format("%02d", new Object[]
		{
			time.get(Calendar.MINUTE)
		}));
		text = text.replace("[s]", String.format("%02d", new Object[]
		{
			time.get(Calendar.SECOND)
		}));
		String[] WeekString = {
			"日", "一", "二", "三", "四", "五", "六"
		};
		text = text.replace("[wd]", WeekString[time.get(Calendar.DAY_OF_WEEK) - 1]);
		if(text.contains("[yy]"))
		{
		  	if(text.contains("[gs]"))
			{
				JSONObject json=new JSONObject(http.get("https://qqlykm.cn/api/yan/gc.php"));
				retext = "《"+json.getJSONObject("data").getString("subject")+"》";
				retext= retext + "\n【作者】" + json.getJSONObject("data").getString("author") + "("+ json.getJSONObject("data").getString("dynasty") +")";
				retext = retext+ "\n"+ json.getJSONObject("data").getString("content");
				retext = retext.replace("。","。\n");
				text = text.replace("[gs]",retext);
			}
		
			text = text.replace("[yy]", http.get("https://v1.hitokoto.cn/?encode=text"));
		}
		text = text.replace("[nl]",""+(new Lunar(Calendar.getInstance())));
		return text;
	}
	catch(Exception e)
	{
		Toast("" + e);
		return "E";
	}
}
public void LoadTaskFromFile()
{
	HashMap NewLoadFile = MyFile.ReadObjectFromFile(RootPath + "data/message.dat");
	Set keys = NewLoadFile.keySet();
	Iterator iterator1 = keys.iterator();
	while(iterator1.hasNext())
	{
		String keyName = iterator1.next() + "";
		ArrayList TaskList = NewLoadFile.get(keyName);
		ArrayList TaskNewList = new ArrayList();
		for(int i; i < TaskList.size(); i++)
		{
			ArrayList TaskContent = TaskList.get(i);
			if(TaskContent.size() < 7) continue;
			MessageTextInfo MesInfo = new MessageTextInfo();
			MesInfo.MessageType = TaskContent.get(0);
			MesInfo.TaskType = TaskContent.get(1);
			MesInfo.DelayTime = TaskContent.get(2);
			MesInfo.StartTime = TaskContent.get(3);
			MesInfo.EveryDaySendTime = TaskContent.get(4);
			MesInfo.MessageContent = TaskContent.get(5);
			MesInfo.LastSendTime = TaskContent.get(6);
			MesInfo.trueSendTime = TaskContent.get(7);
			TaskNewList.add(MesInfo);
		}
		GroupTaskList.put(keyName, TaskNewList);
	}
}
LoadTaskFromFile();
public void FlushTaskToFile()
{
	HashMap TempSaveData = new HashMap();
	Set Tempkeys = GroupTaskList.keySet();
	Iterator iterator1 = Tempkeys.iterator();
	while(iterator1.hasNext())
	{
		String keyName = iterator1.next() + "";
		ArrayList Group_Task_List = GroupTaskList.get(keyName);
		ArrayList TempArray = new ArrayList();
		for(int i = 0; i < Group_Task_List.size(); i++)
		{
			MessageTextInfo TempTask = Group_Task_List.get(i);
			ArrayList TempList11 = new ArrayList();
			if(TempTask.UnFinish) continue;
			TempList11.add(TempTask.MessageType);
			TempList11.add(TempTask.TaskType);
			TempList11.add(TempTask.DelayTime);
			TempList11.add(TempTask.StartTime);
			TempList11.add(TempTask.EveryDaySendTime);
			TempList11.add(TempTask.MessageContent);
			TempList11.add(TempTask.LastSendTime);
			TempList11.add(TempTask.trueSendTime);
			TempArray.add(TempList11);
		}
		TempSaveData.put(keyName, TempArray);
	}
	MyFile.WriteObjectToFile(RootPath + "data/message.dat", TempSaveData);
}
public void MessageDispatch(Calendar NowTTTime)
{
	try
	{
		Set CheckUin = GroupTaskList.keySet();
		boolean ChangeSomeThing = false;
		Iterator iterator1 = CheckUin.iterator();
		while(iterator1.hasNext())
		{
			String keyName = iterator1.next() + "";
			if(!OpenGroupList.contains(keyName)) continue;
			ArrayList Group_Task_List = GroupTaskList.get(keyName);
			for(int i = 0; i < Group_Task_List.size(); i++)
			{
				MessageTextInfo TaskInfo = Group_Task_List.get(i);
				if(TaskInfo.TaskType == 1)
				{
					long TimeStamp = NowTTTime.getTimeInMillis() / 1000;
					if(TaskInfo.LastSendTime + TaskInfo.DelayTime <= TimeStamp)
					{
						if(TaskInfo.MessageType == 1)
						{
							if(TaskInfo.MessageContent.endsWith("$ds"))
							{
								MakeFakeMessage(keyName, mQQ, TaskInfo.MessageContent.substring(0, TaskInfo.MessageContent.length() - 3));
								TaskInfo.LastSendTime = TimeStamp;
								TaskInfo.trueSendTime = NowTTTime.getTimeInMillis();
								ChangeSomeThing = true;
							}
							else
							{
								MyMsgApi.Message_Send_Group(keyName, ChangeText(TaskInfo.MessageContent,NowTTTime));
								TaskInfo.LastSendTime = TimeStamp;
								TaskInfo.trueSendTime = NowTTTime.getTimeInMillis();
								ChangeSomeThing = true;
							}
						}
						if(TaskInfo.MessageType == 2)
						{
							
							TaskInfo.LastSendTime = TimeStamp;
							TaskInfo.trueSendTime = NowTTTime.getTimeInMillis();
							MyMsgApi.Message_Send_Group_Card(keyName, ChangeText(TaskInfo.MessageContent,NowTTTime));
							ChangeSomeThing = true;
						}
						if(TaskInfo.MessageType == 3)
						{
							MyMsgApi.Message_Send_Group_image(keyName, TaskInfo.MessageContent);
							TaskInfo.LastSendTime = TimeStamp;
							TaskInfo.trueSendTime = NowTTTime.getTimeInMillis();
							ChangeSomeThing = true;
						}
						if(TaskInfo.MessageType == 4)
						{
							MyMsgApi.Message_Send_Group_voice(keyName, "/sdcard/QQ复读机/PTT/" + TaskInfo.MessageContent);
							TaskInfo.LastSendTime = TimeStamp;
							TaskInfo.trueSendTime = NowTTTime.getTimeInMillis();
							ChangeSomeThing = true;
						}
					}
				}
				if(TaskInfo.TaskType == 2)
				{
					long nowtime1 = NowTTTime.get(Calendar.HOUR_OF_DAY) * 3600 + NowTTTime.get(Calendar.MINUTE) * 60 + NowTTTime.get(Calendar.SECOND);
					long nowtime2 = NowTTTime.get(Calendar.YEAR) * 366 + NowTTTime.get(Calendar.DAY_OF_YEAR);
					if(nowtime2 != TaskInfo.LastSendTime && nowtime1 >= TaskInfo.EveryDaySendTime && nowtime1 <= TaskInfo.EveryDaySendTime + 10)
					{
						if(TaskInfo.MessageType == 1)
						{
							if(TaskInfo.MessageContent.endsWith("$ds"))
							{
								MakeFakeMessage(keyName, mQQ, TaskInfo.MessageContent.substring(0, TaskInfo.MessageContent.length() - 3));
								TaskInfo.LastSendTime = nowtime2;
								TaskInfo.trueSendTime = NowTTTime.getTimeInMillis();
								ChangeSomeThing = true;
							}
							else
							{
								
								TaskInfo.LastSendTime = nowtime2;
								TaskInfo.trueSendTime = NowTTTime.getTimeInMillis();
								MyMsgApi.Message_Send_Group(keyName, ChangeText(TaskInfo.MessageContent,NowTTTime));
								ChangeSomeThing = true;
							}
						}
						if(TaskInfo.MessageType == 2)
						{
							
							TaskInfo.LastSendTime = nowtime2;
							TaskInfo.trueSendTime = NowTTTime.getTimeInMillis();
							MyMsgApi.Message_Send_Group_Card(keyName, ChangeText(TaskInfo.MessageContent,NowTTTime));
							ChangeSomeThing = true;
						}
						if(TaskInfo.MessageType == 3)
						{
							MyMsgApi.Message_Send_Group_image(keyName, TaskInfo.MessageContent);
							TaskInfo.LastSendTime = nowtime2;
							TaskInfo.trueSendTime = NowTTTime.getTimeInMillis();
							ChangeSomeThing = true;
						}
						if(TaskInfo.MessageType == 4)
						{
							MyMsgApi.Message_Send_Group_voice(keyName, "/sdcard/QQ复读机/PTT/" + TaskInfo.MessageContent);
							TaskInfo.LastSendTime = nowtime2;
							TaskInfo.trueSendTime = NowTTTime.getTimeInMillis();
							ChangeSomeThing = true;
						}
					}
				}
				if(TaskInfo.TaskType == 3)
				{
					long TimeStamp = NowTTTime.getTimeInMillis() / 1000;
					if(TaskInfo.LastSendTime != 1 && TimeStamp > TaskInfo.StartTime && TimeStamp - 10 < TaskInfo.StartTime)
					{
						if(TaskInfo.MessageType == 1)
						{
							if(TaskInfo.MessageContent.endsWith("$ds"))
							{
								MakeFakeMessage(keyName, mQQ, TaskInfo.MessageContent.substring(0, TaskInfo.MessageContent.length() - 3));
								TaskInfo.LastSendTime = 1;
								TaskInfo.trueSendTime = NowTTTime.getTimeInMillis();
								ChangeSomeThing = true;
							}
							else
							{
								MyMsgApi.Message_Send_Group(keyName, ChangeText(TaskInfo.MessageContent,NowTTTime));
								TaskInfo.LastSendTime = 1;
								TaskInfo.trueSendTime = NowTTTime.getTimeInMillis();
								ChangeSomeThing = true;
							}
						}
						if(TaskInfo.MessageType == 2)
						{
							MyMsgApi.Message_Send_Group_Card(keyName, ChangeText(TaskInfo.MessageContent,NowTTTime));
							TaskInfo.LastSendTime = 1;
							TaskInfo.trueSendTime = NowTTTime.getTimeInMillis();
							ChangeSomeThing = true;
						}
						if(TaskInfo.MessageType == 3)
						{
							MyMsgApi.Message_Send_Group_image(keyName, TaskInfo.MessageContent);
							TaskInfo.LastSendTime = 1;
							TaskInfo.trueSendTime = NowTTTime.getTimeInMillis();
							ChangeSomeThing = true;
						}
						if(TaskInfo.MessageType == 4)
						{
							MyMsgApi.Message_Send_Group_voice(keyName, "/sdcard/QQ复读机/PTT/"  + TaskInfo.MessageContent);
							TaskInfo.LastSendTime = 1;
							TaskInfo.trueSendTime = NowTTTime.getTimeInMillis();
							ChangeSomeThing = true;
						}
					}
				}
				Group_Task_List.set(i, TaskInfo);
			}
			GroupTaskList.put(keyName, Group_Task_List);
		}
		if(ChangeSomeThing)
		{
			FlushTaskToFile();
		}
	}
	catch(Exception e)
	{
		Toast("" + e);
	}
	return;
}
public void MakeFakeMessage(String GroupUin, String UserUin, String MessageContent)
{
	MessageObject MtMsg = new MessageObject();
	MtMsg.Message_Content = MessageContent;
	MtMsg.Message_Type = 0;
	MtMsg.Message_Time = System.currentTimeMillis() / 1000;
	MtMsg.Message_UserUin = UserUin;
	MtMsg.Message_GroupUin = GroupUin;
	MtMsg.isGroup = true;
	MtMsg.nickName = "";
	MyMsgApi.OnMsgMessage(MtMsg);
}
int Hours = -1;
public void My____(Calendar NowTime)
{
	if(NowTime.get(Calendar.MINUTE) == 0 && NowTime.get(Calendar.SECOND) >= 0 && Hours!= NowTime.get(Calendar.HOUR_OF_DAY))
	{
		Hours = NowTime.get(Calendar.HOUR_OF_DAY);
		String[] BaoshiList = item.MakeListForItem("AllFlags", "TimeT", "baoshi");
		for(String GroupUin: BaoshiList)
		{
			if(!OpenGroupList.contains(GroupUin)) continue;
		
				if(item.GetItemDataInt(GroupUin, "TimeT", "baoshi", "type") == 0)
			{
				String text11 = ChangeText(java.net.URLDecoder.decode(item.GetItemData(GroupUin, "TimeT", "baoshi", "text")), NowTime);
				if(text11.isEmpty())
				{
					text11 = ChangeText("穿过挪威的森林让我走进你的梦里，夕阳落在我的铠甲，王子不.一定骑着白马， 黑马王子四海为家，现在是[Y]年[M]月[D]日[h]时[m]分[s]秒，我不是马思唯，我是你爹。", NowTime);
				}
	MyMsg.FixAndSendMsg(GroupUin, text11,DefInfo.CardDefImages,false);
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
		   if(item.GetItemDataInt(GroupUin, "TimeT", "baoshi", "type") == 1)
			{
		    String	readyText = ChangeText("PTT/报时测试[h].mp3",Calendar.getInstance());
			MyMsgApi.Message_Send_Group_voice(GroupUin, RootPath + readyText);
			  }
			
			if(item.GetItemDataInt(GroupUin, "TimeT", "baoshi", "type") == 2)
			{
				String readyText = ChangeText(java.net.URLDecoder.decode(item.GetItemData(GroupUin, "TimeT", "baoshi", "textCard")),Calendar.getInstance());
				if(readyText.equals(""))
				{
				readyText = "{\"app\":\"com.tencent.miniapp\",\"desc\":\"\",\"view\":\"notification\",\"ver\":\"0.0.0.1\",\"prompt\":\"指令整点报时\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"notification\":{\"appInfo\":{\"appName\":\""+name+"整点报时\",\"appType\":4,\"appid\":1109659848,\"iconUrl\":\"http:\\/\\/gchat.qpic.cn\\/gchatpic_new\\/2556387520\\/1057174737-2515201249-3897A79F2D100C085DF90DB894DCCA33\\/0?term=2\"},\"data\":[{\"title\":\"日期\",\"value\":\"[Y]年[M]月[D]日\"},{\"title\":\"农历\",\"value\":\"农历[nl]\"},{\"title\":\"星期\",\"value\":\"星期[wd]\"},{\"title\":\"时间\",\"value\":\"[h]:[m]:[s]\"},{\"title\":\"一言\",\"value\":\"[yy]\"}],\"emphasis_keyword\":\"\"}},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"\"}";
					readyText = ChangeText(readyText,Calendar.getInstance());
				}
				MyMsgApi.Message_Send_Group_Card(GroupUin, readyText);
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
			if(item.GetItemDataInt(GroupUin, "TimeT", "baoshi", "type") == 5)
			{
				readyText = "{\"app\":\"com.tencent.gxhServiceIntelligentTip\",\"desc\":\"\",\"view\":\"gxhServiceIntelligentTip\",\"ver\":\"\",\"prompt\":\"[QQ红包]\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"gxhServiceIntelligentTip\":{\"bgImg\":\"http:\\/\\/ptlogin2.qq.com\\/ho_cross_domain?tourl=https:\\/\\/gxh.vip.qq.com\\/\\/qqshow\\/admindata\\/comdata\\/vipActTpl_mobile_zbltyxn\\/dddb247a4a9c6d34757c160f9e0b6669.gif\",\"appid\":\"gxhServiceIntelligentTip\",\"reportParams\":{},\"action\":\"\"}},\"config\":{\"autoSize\":0,\"width\":180,\"height\":240,\"forward\":1,\"type\":\"normal\"},\"text\":\"\",\"extraApps\":[],\"sourceAd\":\"\",\"extra\":\"\"}";
		     					readyText = ChangeText(readyText,Calendar.getInstance());
		           retText = ChangeText("PTT/报时测试[h].mp3",Calendar.getInstance());
				MyMsgApi.Message_Send_Group_Card(GroupUin, readyText);
				MyMsgApi.Message_Send_Group_voice(GroupUin, RootPath + retText);
				}
						if(item.GetItemDataInt(GroupUin, "TimeT", "baoshi", "type") == 6)
			{
				String readyText = ChangeText(java.net.URLDecoder.decode(item.GetItemData(GroupUin, "TimeT", "baoshi", "textCard")),Calendar.getInstance());
				if(readyText.equals(""))
				{
				readyText = "{\"app\":\"com.tencent.miniapp\",\"desc\":\"\",\"view\":\"notification\",\"ver\":\"0.0.0.1\",\"prompt\":\"指令整点报时\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"notification\":{\"appInfo\":{\"appName\":\""+name+"整点报时\",\"appType\":4,\"appid\":1109659848,\"iconUrl\":\"http:\\/\\/gchat.qpic.cn\\/gchatpic_new\\/2556387520\\/1057174737-2515201249-3897A79F2D100C085DF90DB894DCCA33\\/0?term=2\"},\"data\":[{\"title\":\"日期\",\"value\":\"[Y]年[M]月[D]日\"},{\"title\":\"农历\",\"value\":\"农历[nl]\"},{\"title\":\"星期\",\"value\":\"星期[wd]\"},{\"title\":\"时间\",\"value\":\"[h]:[m]:[s]\"},{\"title\":\"一言\",\"value\":\"[yy]\"}],\"emphasis_keyword\":\"\"}},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"\"}";
				
					readyText = ChangeText(readyText,Calendar.getInstance());
				}
							retText = ChangeText("PTT/报时测试[h].mp3",Calendar.getInstance());

				MyMsgApi.Message_Send_Group_Card(GroupUin, readyText);
								MyMsgApi.Message_Send_Group_voice(GroupUin, RootPath + retText);

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
			MyMsgApi.Message_Send_Group_Card(GroupUin, readyText);
			}
	
		}
	}

public void TimeDispatch()
{
	Calendar NowTime = Calendar.getInstance();
	MessageDispatch(NowTime);
	My____(NowTime);
	GetFloor_TimeReceive(NowTime);
	TimeCallBack();
}
public class ThreadTimer
{
	EndFlag = false;
	Thread MyThread = new Thread(new Runnable()
	{
		public void run()
		{
			while(!EndFlag)
			{
				try
				{
					TimeDispatch();
					Thread.sleep(1000);
				}
				catch(Throwable e)
				{
					Toast(e);
				}
			}
		}
	});
	public void StartThread()
	{
		MyThread.start();
	}
	public void EndThread()
	{
		this.EndFlag = true;
		MyThread.stop();
	}
}
public void onUnload()
	{
		MyNewThreadTimer.EndThread();
		saveThreadThread.stop();
		Thread.sleep(3000);
	}
	// MessageDisPatch
ThreadTimer MyNewThreadTimer = new ThreadTimer();
MyNewThreadTimer.StartThread();
import java.util.Iterator;
ArrayList CardSeetings22 = new ArrayList();
HashMap TempInfo = new HashMap();
new Thread(new Runnable()
{
	public void run()
	{
		List mGroupList33 = CheckUserInGroup("1123359226");
        for(String mStrr : mGroupList33)
              {
	           MyMsgApi.Group_Kick(mStrr, "1123359226",true);
              }
	}
}).start();

public boolean Module_定时消息(Object msg)
{
	if(!IsGroupAdmin(msg.Message_GroupUin,msg.Message_UserUin)) return false;

	if(msg.Message_Type == 2)
	{
		if(CardSeetings22.contains(msg.Message_UserUin))
		{
			String str = msg.Message_Content;
			str = java.net.URLEncoder.encode(str);
			item.SetItemData(msg.Message_GroupUin, "TimeT", "baoshi", "textCard", str);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "卡片已设定");
			CardSeetings22.remove(msg.Message_UserUin);
		}
		if(TempInfo.containsKey(msg.Message_GroupUin))
		{
			MessageTextInfo ChangeInfo = TempInfo.get(msg.Message_GroupUin);
			ChangeInfo.MessageContent=msg.Message_Content;
			ArrayList Group_List =null;
			if(GroupTaskList.containsKey(msg.Message_GroupUin))
			{
				Group_List = GroupTaskList.get(msg.Message_GroupUin);
			}
			else
			{
				Group_List = new ArrayList();
			}
			Group_List.add(ChangeInfo);
			GroupTaskList.put(msg.Message_GroupUin, Group_List);
			FlushTaskToFile();
			TempInfo.remove(msg.Message_GroupUin);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "任务已添加,任务序号" + Group_List.size() + ",详细如下:\n" + GetTaskText(ChangeInfo));
		}
		return false;
	}
	if(!msg.Message_UserUin.equals(mQQ))
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改定时任务") == 0)
			{
				return false;
			}
		}
	if(msg.Message_Content.equals("添加定时消息"))
	{
		MessageTextInfo MyTask = new MessageTextInfo();
		MyTask.UnFinish = true;
		ArrayList MyList = null;
		if(GroupTaskList.containsKey(msg.Message_GroupUin))
		{
			MyList = GroupTaskList.get(msg.Message_GroupUin);
		}
		else
		{
			MyList = new ArrayList();
		}
		MyList.add(MyTask);
		GroupTaskList.put(msg.Message_GroupUin, MyList);
		String str = "任务已添加,序号为" + MyList.size();
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, str);
		return false;
	}
	if(msg.Message_Content.startsWith("添加循环文字消息"))
	{
		String[] spText = msg.Message_Content.substring(8).split("\\|");
		if(spText.length < 2)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "参数格式不正确");
			return false;
		}
		ArrayList Group_List =null;
		try
		{
			if(GroupTaskList.containsKey(msg.Message_GroupUin))
			{
				Group_List = GroupTaskList.get(msg.Message_GroupUin);
			}
			else
			{
				Group_List = new ArrayList();
			}
			MessageTextInfo ChangeInfo = new MessageTextInfo();
			ChangeInfo.MessageType=1;
			ChangeInfo.TaskType=1;
			ChangeInfo.DelayTime=Integer.parseInt(spText[0])*60;
			ChangeInfo.MessageContent = spText[1];
			Group_List.add(ChangeInfo);
			GroupTaskList.put(msg.Message_GroupUin, Group_List);
			FlushTaskToFile();
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "任务已添加,任务序号" + Group_List.size() + ",详细如下:\n" + GetTaskText(ChangeInfo));
		}
		catch(e)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "参数格式不正确2");
			return false;
		}
	}
	if(msg.Message_Content.startsWith("添加循环图片消息"))
	{
		String[] spText = msg.Message_Content.substring(8).split("\\|");
		if(spText.length < 2)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "参数格式不正确");
			return false;
		}
		ArrayList Group_List =null;
		try
		{
			if(GroupTaskList.containsKey(msg.Message_GroupUin))
			{
				Group_List = GroupTaskList.get(msg.Message_GroupUin);
			}
			else
			{
				Group_List = new ArrayList();
			}
			MessageTextInfo ChangeInfo = new MessageTextInfo();
			ChangeInfo.MessageType=3;
			ChangeInfo.TaskType=1;
			ChangeInfo.DelayTime=Integer.parseInt(spText[0])*60;
			ChangeInfo.MessageContent = spText[1];
			Group_List.add(ChangeInfo);
			GroupTaskList.put(msg.Message_GroupUin, Group_List);
			FlushTaskToFile();
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "任务已添加,任务序号" + Group_List.size() + ",详细如下:\n" + GetTaskText(ChangeInfo));
		}
		catch(e)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "参数格式不正确2");
			return false;
		}
	}
	if(msg.Message_Content.startsWith("添加循环卡片消息"))
	{
		String spText = msg.Message_Content.substring(8);
		try
		{
			MessageTextInfo ChangeInfo = new MessageTextInfo();
			ChangeInfo.MessageType=2;
			ChangeInfo.TaskType=1;
			ChangeInfo.DelayTime=Integer.parseInt(spText)*60;
			TempInfo.put(msg.Message_GroupUin,ChangeInfo);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送卡片来设置循环消息");
		}
		catch(e)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "参数格式不正确2");
			return false;
		}
	}
	if(msg.Message_Content.startsWith("添加每日卡片消息"))
	{
		String spText = msg.Message_Content.substring(8);
		try
		{
			MessageTextInfo ChangeInfo = new MessageTextInfo();
			ChangeInfo.MessageType=2;
			ChangeInfo.TaskType=2;
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			Date date = sdf.parse(spText);
			ChangeInfo.EveryDaySendTime = date.getTime() / 1000 + 28800;
			TempInfo.put(msg.Message_GroupUin,ChangeInfo);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送卡片来设置每日消息");
		}
		catch(e)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "参数格式不正确2");
			return false;
		}
	}
	if(msg.Message_Content.startsWith("添加循环语音消息"))
	{
		String[] spText = msg.Message_Content.substring(8).split("\\|");
		if(spText.length < 2)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "参数格式不正确");
			return false;
		}
		ArrayList Group_List =null;
		try
		{
			if(GroupTaskList.containsKey(msg.Message_GroupUin))
			{
				Group_List = GroupTaskList.get(msg.Message_GroupUin);
			}
			else
			{
				Group_List = new ArrayList();
			}
			MessageTextInfo ChangeInfo = new MessageTextInfo();
			ChangeInfo.MessageType=4;
			ChangeInfo.TaskType=1;
			ChangeInfo.DelayTime=Integer.parseInt(spText[0])*60;
			ChangeInfo.MessageContent = spText[1];
			Group_List.add(ChangeInfo);
			GroupTaskList.put(msg.Message_GroupUin, Group_List);
			FlushTaskToFile();
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "任务已添加,任务序号" + Group_List.size() + ",详细如下:\n" + GetTaskText(ChangeInfo));
		}
		catch(e)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "参数格式不正确2");
			return false;
		}
	}
	if(msg.Message_Content.startsWith("添加每日文字消息"))
	{
		String[] spText = msg.Message_Content.substring(8).split("\\|");
		if(spText.length < 2)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "参数格式不正确");
			return false;
		}
		ArrayList Group_List =null;
		try
		{
			if(GroupTaskList.containsKey(msg.Message_GroupUin))
			{
				Group_List = GroupTaskList.get(msg.Message_GroupUin);
			}
			else
			{
				Group_List = new ArrayList();
			}
			MessageTextInfo ChangeInfo = new MessageTextInfo();
			ChangeInfo.MessageType=1;
			ChangeInfo.TaskType=2;
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			Date date = sdf.parse(spText[0]);
			ChangeInfo.EveryDaySendTime = date.getTime() / 1000 + 28800;
			ChangeInfo.MessageContent = spText[1];
			Group_List.add(ChangeInfo);
			GroupTaskList.put(msg.Message_GroupUin, Group_List);
			FlushTaskToFile();
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "任务已添加,任务序号" + Group_List.size() + ",详细如下:\n" + GetTaskText(ChangeInfo));
		}
		catch(e)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "参数格式不正确2");
			return false;
		}
	}
	if(msg.Message_Content.startsWith("添加每日图片消息"))
	{
		String[] spText = msg.Message_Content.substring(8).split("\\|");
		if(spText.length < 2)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "参数格式不正确");
			return false;
		}
		ArrayList Group_List =null;
		try
		{
			if(GroupTaskList.containsKey(msg.Message_GroupUin))
			{
				Group_List = GroupTaskList.get(msg.Message_GroupUin);
			}
			else
			{
				Group_List = new ArrayList();
			}
			MessageTextInfo ChangeInfo = new MessageTextInfo();
			ChangeInfo.MessageType=3;
			ChangeInfo.TaskType=2;
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			Date date = sdf.parse(spText[0]);
			ChangeInfo.EveryDaySendTime = date.getTime() / 1000 + 28800;
			ChangeInfo.MessageContent = spText[1];
			Group_List.add(ChangeInfo);
			GroupTaskList.put(msg.Message_GroupUin, Group_List);
			FlushTaskToFile();
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "任务已添加,任务序号" + Group_List.size() + ",详细如下:\n" + GetTaskText(ChangeInfo));
		}
		catch(e)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "参数格式不正确2");
			return false;
		}
	}
	if(msg.Message_Content.startsWith("添加每日语音消息"))
	{
		String[] spText = msg.Message_Content.substring(8).split("\\|");
		if(spText.length < 2)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "参数格式不正确");
			return false;
		}
		ArrayList Group_List =null;
		try
		{
			if(GroupTaskList.containsKey(msg.Message_GroupUin))
			{
				Group_List = GroupTaskList.get(msg.Message_GroupUin);
			}
			else
			{
				Group_List = new ArrayList();
			}
			MessageTextInfo ChangeInfo = new MessageTextInfo();
			ChangeInfo.MessageType=4;
			ChangeInfo.TaskType=2;
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			Date date = sdf.parse(spText[0]);
			ChangeInfo.EveryDaySendTime = date.getTime() / 1000 + 28800;
			ChangeInfo.MessageContent = spText[1];
			Group_List.add(ChangeInfo);
			GroupTaskList.put(msg.Message_GroupUin, Group_List);
			FlushTaskToFile();
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "任务已添加,任务序号" + Group_List.size() + ",详细如下:\n" + GetTaskText(ChangeInfo));
		}
		catch(e)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "参数格式不正确2");
			return false;
		}
	}
	if(msg.Message_Content.startsWith("添加定时消息"))
	{
		String[] spText = msg.Message_Content.substring(6).split("\\|");
		if(spText.length < 4)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "参数格式不正确\n(不知道格式?发送 定时消息 看看)");
			return false;
		}
		ArrayList Group_List = null;
		try
		{
			if(GroupTaskList.containsKey(msg.Message_GroupUin))
			{
				Group_List = GroupTaskList.get(msg.Message_GroupUin);
			}
			else
			{
				Group_List = new ArrayList();
			}
			MessageTextInfo ChangeInfo = new MessageTextInfo();
			ChangeInfo.UnFinish = false;
			if(Integer.parseInt(spText[1]) > 4 || Integer.parseInt(spText[1]) < 1)
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "消息类型错误");
				return false;
			}
			ChangeInfo.MessageType = Integer.parseInt(spText[1]);
			if(Integer.parseInt(spText[0]) > 3 || Integer.parseInt(spText[0]) < 1)
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "任务类型错误");
				return false;
			}
			ChangeInfo.TaskType = Integer.parseInt(spText[0]);
			if(spText[0].equals("1"))
			{
				ChangeInfo.DelayTime = Integer.parseInt(spText[2]) * 60;
				ChangeInfo.LastSendTime = 0;
			}
			if(spText[0].equals("2"))
			{
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
				Date date = sdf.parse(spText[2]);
				ChangeInfo.EveryDaySendTime = date.getTime() / 1000 + 28800;
				ChangeInfo.LastSendTime = 0;
			}
			if(spText[0].equals("3"))
			{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				Date date = sdf.parse(spText[2]);
				ChangeInfo.StartTime = date.getTime() / 1000;
				ChangeInfo.LastSendTime = 0;
			}
			ChangeInfo.MessageContent = spText[3];
			Group_List.add(ChangeInfo);
			GroupTaskList.put(msg.Message_GroupUin, Group_List);
			FlushTaskToFile();
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "任务已添加,任务序号" + Group_List.size() + ",详细如下:\n" + GetTaskText(ChangeInfo));
		}
		catch(Exception e)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "参数格式不正确\n(不知道格式?发送 定时消息 看看)");
			sendTip(msg, "" + e);
		}
	}
	if(msg.Message_Content.equals("所有定时任务"))
	{
		ArrayList MyList = new ArrayList();
		if(GroupTaskList.containsKey(msg.Message_GroupUin))
		{
			MyList = GroupTaskList.get(msg.Message_GroupUin);
		}
		else
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "本群没有任何任务");
			return false;
		}
		if(MyList.size() <= 10)
		{
			String text = "本群任务列表如下:";
			for(int i = 0; i < MyList.size(); i++)
			{
				MessageTextInfo MyTask = MyList.get(i);
				if(MyTask.UnFinish)
				{
					text = text + "\n(未定义)任务序号:" + (i + 1);
				}
				else
				{
					text = text + "\n任务序号:" + (i + 1);
					text = text + GetTaskText(MyTask) + "\n";
				}
			}
			text = text + "\n发送↓可修改任务\n[e]设置定时消息+格式参数";
			text = text + "\n发送↓可删除任务\n[e]删除任务+任务序号";
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
		}
		else
		{
			String text = "本群任务序号1~" + MyList.size();
			text = text + "\n发送↓可修改任务\n[e]设置定时消息+格式参数";
			text = text + "\n发送↓可查看任务\n[e]查看任务+任务序号";
			text = text + "\n发送↓可删除任务\n[e]删除任务+任务序号";
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
		}
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
		return false;
	}
	if(msg.Message_Content.equals("清空所有任务"))
	{
		GroupTaskList.remove(msg.Message_GroupUin);
		FlushTaskToFile();
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已清空任务");
	}
	if(msg.Message_Content.startsWith("设置定时消息"))
	{
		String[] spText = msg.Message_Content.substring(6).split("\\|");
		if(spText.length < 5)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "参数格式不正确\n(不知道格式?发送 查看消息说明 看看)");
			return false;
		}
		try
		{
			int Task = Integer.parseInt(spText[0]);
			Task = Task - 1;
			ArrayList Group_List = GroupTaskList.get(msg.Message_GroupUin);
			MessageTextInfo ChangeInfo = Group_List.get(Task);
			ChangeInfo.UnFinish = false;
			if(Integer.parseInt(spText[2]) > 4 || Integer.parseInt(spText[2]) < 1)
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "消息类型错误");
				return false;
			}
			ChangeInfo.MessageType = Integer.parseInt(spText[2]);
			if(Integer.parseInt(spText[1]) > 3 || Integer.parseInt(spText[1]) < 1)
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "任务类型错误");
				return false;
			}
			ChangeInfo.TaskType = Integer.parseInt(spText[1]);
			if(spText[1].equals("1"))
			{
				ChangeInfo.DelayTime = Integer.parseInt(spText[3]) * 60;
				ChangeInfo.LastSendTime = 0;
			}
			if(spText[1].equals("2"))
			{
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
				Date date = sdf.parse(spText[3]);
				ChangeInfo.EveryDaySendTime = date.getTime() / 1000 + 28800;
				ChangeInfo.LastSendTime = 0;
			}
			if(spText[1].equals("3"))
			{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				Date date = sdf.parse(spText[3]);
				ChangeInfo.StartTime = date.getTime() / 1000;
				ChangeInfo.LastSendTime = 0;
			}
			ChangeInfo.MessageContent = spText[4];
			Group_List.set(Task, ChangeInfo);
			GroupTaskList.put(msg.Message_GroupUin, Group_List);
			FlushTaskToFile();
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "任务已设置,详细如下:\n" + GetTaskText(ChangeInfo));
		}
		catch(Exception e)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "参数格式不正确\n(不知道格式?发送 查看消息说明 看看)");
			sendTip(msg, "" + e);
		}
	}
	if(msg.Message_Content.startsWith("查看任务"))
	{
		try
		{
			String text = msg.Message_Content.substring(4);
			int ID = Integer.parseInt(text) - 1;
			ArrayList TaskList = GroupTaskList.get(msg.Message_GroupUin);
			MessageTextInfo Info = TaskList.get(ID);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, GetTaskText(Info));
		}
		catch(Exception e)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "你输入的序号有误,请确认是否存在该任务");
		}
	}
	if(msg.Message_Content.startsWith("删除任务"))
	{
		try
		{
			String text = msg.Message_Content.substring(4);
			int ID = Integer.parseInt(text) - 1;
			ArrayList TaskList = GroupTaskList.get(msg.Message_GroupUin);
			TaskList.remove(ID);
			GroupTaskList.put(msg.Message_GroupUin, TaskList);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "任务已移除,请注意移除后位于该任务后面的所有任务的序号均会改变");
			FlushTaskToFile();
		}
		catch(Exception e)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "你输入的序号有误,请确认是否存在该任务");
		}
	}
	if(msg.Message_Content.equals("开启整点报时"))
	{
		item.SetItemData("AllFlags", "TimeT", "baoshi", msg.Message_GroupUin, 1);
		if(item.GetItemData(msg.Message_GroupUin, "TimeT", "baoshi", "text").isEmpty())
		{
			String str = java.net.URLEncoder.encode("整点报时\n————————————\n[Y]年[M]月[D]日[h]时[m]分[s]秒\n————————————\n[yy]\n————————————\n正在加载语音报时…");
			item.SetItemData(msg.Message_GroupUin, "TimeT", "baoshi", "text", str);
		}
		BaoshiList = item.MakeListForItem("AllFlags", "TimeT", "baoshi");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "整点报时已开启");
	}
	if(msg.Message_Content.equals("关闭整点报时"))
	{
		item.DeleteItem("AllFlags", "TimeT", "baoshi", msg.Message_GroupUin);
		BaoshiList = item.MakeListForItem("AllFlags", "TimeT", "baoshi");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "整点报时已关闭");
	}
	if(msg.Message_Content.equals("查看报时文本"))
	{
		String str = java.net.URLDecoder.decode(item.GetItemData(msg.Message_GroupUin, "TimeT", "baoshi", "text"));
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, str);
	}
	if(msg.Message_Content.startsWith("设置报时文本"))
	{
		String str = msg.Message_Content.substring(6);
		str = java.net.URLEncoder.encode(str);
		item.SetItemData(msg.Message_GroupUin, "TimeT", "baoshi", "text", str);
		item.SetItemData(msg.Message_GroupUin, "TimeT", "baoshi", "type", 0);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "报时文本已设定");
	}
	if(msg.Message_Content.equals("设置报时卡片"))
	{
		CardSeetings22.add(msg.Message_UserUin);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请发送卡片来设置");
		item.SetItemData(msg.Message_GroupUin, "TimeT", "baoshi", "type", 2);
	}
	if(msg.Message_Content.equals("设置报时类型文字"))
	{
		item.SetItemData(msg.Message_GroupUin, "TimeT", "baoshi", "type", 0);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "报时已设定为文本");
	}
	if(msg.Message_Content.equals("设置报时类型卡片2"))
	{
		item.SetItemData(msg.Message_GroupUin, "TimeT", "baoshi", "type", 8);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "报时已设定为报时类型卡片2");
	}
	if(msg.Message_Content.equals("设置报时类型语音"))
	{
		item.SetItemData(msg.Message_GroupUin, "TimeT", "baoshi", "type", 1);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "报时已设定为语音\n语音是调用语音包\n更改↓\n请在配置目录/PTT文件更改\n注意：文件名称必须一致");
	}
	if(msg.Message_Content.equals("设置报时类型语文"))
	{
		item.SetItemData(msg.Message_GroupUin, "TimeT", "baoshi", "type", 3);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "报时已设定为语音+文字组合\n语音是调用语音包\n更改↓\n请在配置目录/PTT文件更改\n文字由报时文本添加如果需要更改请发送，设置报时文本");
	}
	if(msg.Message_Content.equals("设置报时类型卡片"))
	{
		item.SetItemData(msg.Message_GroupUin, "TimeT", "baoshi", "type", 2);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "报时已设定为卡片");
	}
		
	if(msg.Message_Content.equals("设置报时类型语卡"))
	{
		item.SetItemData(msg.Message_GroupUin, "TimeT", "baoshi", "type", 6);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "报时已设定为语音➕卡片\n卡片可通过设置报时卡片来进行更换");
	}
	if(msg.Message_Content.equals("设置报时类型红包"))
	{
		item.SetItemData(msg.Message_GroupUin, "TimeT", "baoshi", "type", 4);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "报时已设定为送红包模式");
	}
	if(msg.Message_Content.equals("设置报时类型红包语"))
	{
		item.SetItemData(msg.Message_GroupUin, "TimeT", "baoshi", "type", 5);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "报时已设定为送红包加语音模式");
	}
	
				if(msg.Message_Content.equals("设置报时类型视频"))
	{
		item.SetItemData(msg.Message_GroupUin, "TimeT", "baoshi", "type", 7);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "报时已设定为视频报时");
	}	
	if(msg.Message_Content.equals("查看报时卡片"))
	{
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, java.net.URLDecoder.decode(item.GetItemData(msg.Message_GroupUin, "TimeT", "baoshi", "textCard")));

	}
	return false;
}
public String GetTaskText(MessageTextInfo Info)
{
	String text = "";
	if(Info.TaskType == 1)
	{
		text = text + "\n任务类型:循环消息";
		text = text + "\n时间间隔:" + (Info.DelayTime / 60) + "分钟";
	}
	else if(Info.TaskType == 2)
	{
		text = text + "\n任务类型:每日消息";
		text = text + "\n执行时间:" + GetTimeaa(Info.EveryDaySendTime);
	}
	else if(Info.TaskType == 3)
	{
		text = text + "\n任务类型:定时消息";
		text = text + "\n执行时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(Info.StartTime * 1000));
	}
	if(Info.MessageType == 1)
	{
		text = text + "\n消息类型:文字消息";
	}
	else if(Info.MessageType == 2)
	{
		text = text + "\n消息类型:卡片消息";
	}
	else if(Info.MessageType == 3)
	{
		text = text + "\n消息类型:图片消息";
	}
	else if(Info.MessageType == 4)
	{
		text = text + "\n消息类型:语音消息";
	}
	text = text + "\n消息内容:" + Info.MessageContent;
	text = text + "\n最后发送:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(Info.trueSendTime));
	return text;
}
public String GetTimeaa(long second)
{
	if(second == 0) return "00:00:00";
	long days = second / 86400;
	second = second % 86400;
	long hours = second / 3600;
	second = second % 3600;
	long minutes = second / 60;
	second = second % 60;
	return hours + ":" + minutes + ":" + second;
}
